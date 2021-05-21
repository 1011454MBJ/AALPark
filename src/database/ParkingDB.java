package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Parking;

public class ParkingDB implements ParkingDBIF {
	
	private static final String findBayByIDQ = "select Bay.ID\r\n"
			+ "  from Bay\r\n"
			+ "  join Row\r\n"
			+ "    on Row.ID = Bay.Row_FK\r\n"
			+ "  join ParkingLot\r\n"
			+ "    on ParkingLot.ID = Row.Lot_FK\r\n"
			+ "  where ParkingLot.Name = ?\r\n"
			+ "     and Row.Row = ?\r\n"
			+ "	 and Bay.Number = ?";
	private PreparedStatement findBayByID;
	private static final String insertParkingNoServiceQ = "insert into Car (RegistrationNo, "
			+ "Make, Model, FuelType) values(?, ?, ?, ?) \r\n"
			+ "insert into Parking (Location_FK, DepartureDate, ReturnDate, Car_FK) "
			+ "values (?, ?CAST(N'2018-01-15' AS Date), ?CAST(N'2018-01-23' AS Date), (SELECT ID FROM Car WHERE RegistrationNo = ?)) \r\n"
			+ "insert into Client (Mail, FirstName, LastName, PhoneNo, PaymentTerms, "
			+ "ClientCar_FK) values (?, ?, ?, ?, ?, (SELECT ID FROM Car WHERE RegistrationNo = ?))";
	private PreparedStatement insertParkingNoService;
	
	public ParkingDB() throws SQLException {
		init();
	}
	
	private void init() throws SQLException {
		findBayByID = DatabaseConnection.getInstance()
				.getConnection().prepareStatement(findBayByIDQ);
		insertParkingNoService = DatabaseConnection.getInstance()
				.getConnection().prepareStatement(insertParkingNoServiceQ);
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
				location = set.getInt(location);
			}
			return location;
		} catch (SQLException e) {
			throw new DataAccessException(e, "The bay: " + lot + " " + row + " " + bay + " was not found");
		}
	}

	@Override
	public boolean saveParking(Parking parking) throws DataAccessException, SQLException {
		// TODO Auto-generated method stub
		//int insertedRows = 0;
		boolean insert = false;
		try {
			DatabaseConnection.getInstance().startTransaction();

			insertParkingNoService.setString(1, parking.getCar().getRegNo());
			insertParkingNoService.setString(2, parking.getCar().getMake());
			insertParkingNoService.setString(3, parking.getCar().getModel());
			insertParkingNoService.setString(4, parking.getCar().getFuelType());
			
			insertParkingNoService.setInt(5,parking.getLocation());
			insertParkingNoService.setDate(6, java.sql.Date.valueOf(parking.getDepartureDate()));
			insertParkingNoService.setDate(7, java.sql.Date.valueOf(parking.getReturnDate()));
			insertParkingNoService.setString(8, parking.getCar().getRegNo());
			
			insertParkingNoService.setString(9, parking.getClient().getMail());
			insertParkingNoService.setString(10, parking.getClient().getFirstName());
			insertParkingNoService.setString(11, parking.getClient().getLastName());
			insertParkingNoService.setString(12, parking.getClient().getPhoneNo());
			//preset to credit card payment. To be reviewed when End parking is being done
			insertParkingNoService.setInt(13, 1); 
			insertParkingNoService.setString(14, parking.getCar().getRegNo());
			
			insertParkingNoService.executeUpdate();
			DatabaseConnection.getInstance().commitTransaction();
			
			ResultSet rs = insertParkingNoService.getGeneratedKeys();
			if (rs.next()) {
				insert = true;
			}
			
		} catch  (SQLException e) {
			DatabaseConnection.getInstance().rollbackTransaction();
			throw new DataAccessException(e, "Parkeringen kunne ikke gemmes");
		}
		return insert;
	}
	
}