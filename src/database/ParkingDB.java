package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Parking;

public class ParkingDB implements ParkingDBIF {

	private static final String findBayByIDQ = "select Bay.ID\r\n" + "  from Bay\r\n" 
			+ "  join Row\r\n" + "    on Row.ID = Bay.Row_FK\r\n" 
			+ "  join ParkingLot\r\n" + "    on ParkingLot.ID = Row.Lot_FK\r\n"
			+ "  where ParkingLot.Name = ?\r\n" + "     and Row.Row = ?\r\n" 
			+ "	 and Bay.Number = ?";
	private PreparedStatement findBayByID;
	private static final String findCarQ = "select top 1 id from Car " 
			+ "where RegistrationNo = ? order by id desc";
	private PreparedStatement findCar;
	private static final String findClientQ = "select top 1 id from Client " 
			+ "where mail = ? order by id desc";
	private PreparedStatement findClient;
	private static final String insertCarQ = "insert into Car (RegistrationNo, "
			+ "Make, Model, FuelType) values(?, ?, ?, ?); \r\n";
	private PreparedStatement insertCar;
	private static final String insertClientQ = "insert into Client " 
			+ "(Mail, FirstName, LastName, PhoneNo, PaymentTerms, "
			+ "ClientCar_FK) values (?, ?, ?, ?, ?, ?)";
	private PreparedStatement insertClient;
	private static final String insertParkingQ = "insert into Parking " 
			+ "(Location_FK, DepartureDate, ReturnDate, Car_FK) "
			+ "values (?, ?, ?, ?); \r\n";
	private PreparedStatement insertParking;
	private static final String retrieveParkingIDQ = "select top 1 Parking.ParkingID " 
			+ "from Parking where car_FK = (select top 1 id from Car " 
			+ "where RegistrationNo = ? order by id desc) order by ParkingID desc;";
	private PreparedStatement retrivalParkingID;
	private static final String insertServiceQ = "insert into Service (ServiceType, ServiceDate, "
			+ "DeliveryStatus_FK, Parking_ID_FK) values (?, ?, ?, ?)";
	private PreparedStatement insertService;
	
	public ParkingDB() throws SQLException {
		init();
	}

	private void init() throws SQLException {
		findBayByID = DatabaseConnection.getInstance().getConnection()
				.prepareStatement(findBayByIDQ);
		findCar = DatabaseConnection.getInstance().getConnection()
				.prepareStatement(findCarQ);
		findClient = DatabaseConnection.getInstance().getConnection()
				.prepareStatement(findClientQ);
		insertCar = DatabaseConnection.getInstance().getConnection()
				.prepareStatement(insertCarQ, Statement.RETURN_GENERATED_KEYS);
		insertParking = DatabaseConnection.getInstance().getConnection()
				.prepareStatement(insertParkingQ, Statement.RETURN_GENERATED_KEYS);
		insertClient = DatabaseConnection.getInstance().getConnection()
				.prepareStatement(insertClientQ, Statement.RETURN_GENERATED_KEYS);
		retrivalParkingID = DatabaseConnection.getInstance().getConnection()
				.prepareStatement(retrieveParkingIDQ);
		insertService = DatabaseConnection.getInstance().getConnection()
				.prepareStatement(insertServiceQ, Statement.RETURN_GENERATED_KEYS);

	}

	@Override
	public int findBayByID(String lot, String row, String bay) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			findBayByID.setString(1, lot);
			findBayByID.setString(2, row);
			findBayByID.setString(3, bay);

			ResultSet set = findBayByID.executeQuery();

			int location = -1;

			if (set.next()) {
				location = set.getInt(1);
			}
			return location;
		} catch (SQLException e) {
			throw new DataAccessException(e,
					"The bay: " + lot + " " + row + " " + bay + " was not found " + e.getMessage());
		}
	}

	@Override
	public int saveParking(Parking parking) throws DataAccessException, SQLException {
		// TODO Auto-generated method stub
		int parkID = -1;
		// boolean insert = false;
		try {
			DatabaseConnection.getInstance().startTransaction();
			int carID = findOrInsertCar(parking);

			findOrInsertClient(parking, carID);

			parkID = insertParking(parking, carID);
			
			if (parking.getService() != null) {
				insertService(parking, parkID);
			}
			DatabaseConnection.getInstance().commitTransaction();

		} catch (SQLException e) {
			DatabaseConnection.getInstance().rollbackTransaction();
			throw new DataAccessException(e, "Parkeringen kunne ikke gemmes" + e.getMessage());
		}
		return parkID;
	}

	private int insertService(Parking parking, int parkID) throws SQLException {
		// TODO Auto-generated method stub
//		(, , ChargerID_FK, DeliveryStatus, ) "
//		+ "values (, 3?, 4?, )";
		
		insertService.setString(1, parking.getServiceType().toString());
		insertService.setDate(2, java.sql.Date.valueOf(parking.getDepartureDate()));
		//insertService.setInt(3, 0);
		insertService.setInt(3, 1); // hardcoded to always be reserved when inserted
		insertService.setInt(4, parkID);
		insertService.executeUpdate();
		ResultSet serviceSet = insertService.getGeneratedKeys();
		if (serviceSet.next()) {
			return serviceSet.getInt(1);
		}
		return 0;
		
	}

	private int insertParking(Parking parking, int carID) throws SQLException {
		insertParking.setInt(1, parking.getLocation());
		insertParking.setDate(2, java.sql.Date.valueOf(parking.getDepartureDate()));
		insertParking.setDate(3, java.sql.Date.valueOf(parking.getReturnDate()));
		insertParking.setInt(4, carID);
		insertParking.executeUpdate();
		ResultSet parkSet = insertParking.getGeneratedKeys();
		if (parkSet.next()) {
			return parkSet.getInt(1);
		}
		return 0;
	}

	private void findOrInsertClient(Parking parking, int carID) throws SQLException {
		findClient.setString(1, parking.getClient().getMail());
		ResultSet clientSet = findClient.executeQuery();
		int clientID = -1;
		if (clientSet.next()) {
			clientID = clientSet.getInt(1);
		} else {
			insertClient.setString(1, parking.getClient().getMail());
			insertClient.setString(2, parking.getClient().getFirstName());
			insertClient.setString(3, parking.getClient().getLastName());
			insertClient.setString(4, parking.getClient().getPhoneNo());
			// preset to credit card payment. To be reviewed when End parking is being done
			insertClient.setInt(5, 1);
			insertClient.setInt(6, carID);
			insertClient.executeUpdate();
			ResultSet clientInsert = insertCar.getGeneratedKeys();
			if (clientInsert.next()) {
				clientID = clientInsert.getInt(1);
			}
		}
		//return clientID;
	}
	
	private int findOrInsertCar(Parking parking) throws SQLException {
		findCar.setString(1, parking.getCar().getRegNo());
		ResultSet carSet = findCar.executeQuery();
		int carID = -1;
		if (carSet.next()) {
			carID = carSet.getInt(1);
		} else {
			insertCar.setString(1, parking.getCar().getRegNo());
			insertCar.setString(2, parking.getCar().getMake());
			insertCar.setString(3, parking.getCar().getModel());
			insertCar.setString(4, parking.getCar().getFuelType());
			insertCar.executeUpdate();
			ResultSet carInsert = insertCar.getGeneratedKeys();
			if (carInsert.next()) {
				carID = carInsert.getInt(1);
			}
		}
		return carID;
	}
	
	@Override
	public int getParkingID(String regNo) throws SQLException {
		int parkingID = -1;
		retrivalParkingID.setString(1, regNo);
		ResultSet parkingSet = retrivalParkingID.executeQuery();
		if (parkingSet.next()) {
			parkingID = parkingSet.getInt(1);
		}
		return parkingID;
		
	}

}