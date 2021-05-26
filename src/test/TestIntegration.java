package test;

import org.junit.*;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.awt.AWTException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import gui.*;
import controller.*;
import model.*;
import database.*;

/**
 * @author Maibritt Bjørn Jacobsen
 * @version 2021-05-28
 */

public class TestIntegration {

	private AddParking addPark;
	private ParkingController pCon;
	private Client test;
	private Client hansi;
	private Car dieselCarDK;
	private Car elektriskCarDK;
	private Car carDE;
	private String departureDate;
	private String returnDate;
	private String lot;
	private String row;
	private String bay;

	/**
	 * Setting up the test rig
	 * 
	 * @throws SQLException
	 */

	@Before
	public void setUp() throws SQLException {
		addPark = new AddParking();
		pCon = new ParkingController();
		test = new Client("Test", "Testesen", "+4512345678", "test@testesen.dk");
		hansi = new Client("Hansi", "Hinterseer", "+4504143329590", "hansi@hinterseer.de");
		dieselCarDK = new Car("DI12345", "Volvo", "S40", "Diesel");
		elektriskCarDK = new Car("EL32106", "Toyota", "Yaris", "Elektrisk");
		carDE = new Car("WOBZK295", "Audi", "Q7", "Benzin");
		departureDate = new String("2021-05-17");
		returnDate = new String("2021-06-25");
		lot = new String("P1");
		row = new String("A");
		bay = new String("1");

	}

	//T3 - Test if foreign car can be found in database and saves parking to database. Should Pass!
	@Test
	public void testGermanCarNotFoundInDataBase() throws DataAccessException, SQLException {
		pCon.createParking();
		pCon.addCar(carDE.getRegNo());
		
		assertTrue(addPark.isFocusableWindow());
		assertFalse(addPark.getCarMake().equals(carDE.getMake()));
		
		pCon.addCar(carDE.getRegNo(), carDE.getMake(), carDE.getModel(), carDE.getFuelType());
		pCon.addClientInformation("Hansi", "Hinterseer", "+4504143329590", "hansi@hinterseer.de", lot, row, bay, departureDate);
		pCon.addDates( returnDate);
		
		int pID = pCon.saveParking();

		assertEquals(pID, pCon.getParkingID(carDE.getRegNo()), 0);
	}
	
	//T4 - Test if textfields update if wrong plates are typed in first. Should Pass!
	@Test
	public void testIfDisplayUpdatesWhenDKPlatesAreRetyped() throws DataAccessException {
		pCon.createParking();
		pCon.addCar(dieselCarDK.getRegNo());
		
		assertEquals(pCon.getMake(), "Volvo");
		assertEquals(pCon.getModel(), "S40");
		assertEquals(pCon.getFuelType(), "Diesel");
		
		pCon.addCar("BE12345");
		
		assertEquals(pCon.getMake(), "Chevolet");
		assertEquals(pCon.getModel(), "Corvette");
		assertEquals(pCon.getFuelType(), "Benzin");
		
	}
	
	//T5 - Test if a diesel plate car can book service addon if information is changed. Should Pass even if it is a cheat!
	@Test
	public void testIfDieselCarCanBookCharger() throws DataAccessException, SQLException {
		pCon.createParking();
		pCon.addCar(dieselCarDK.getRegNo());
		
		pCon.addCar(dieselCarDK.getRegNo(), "Renault", "Zoe", "Elektrisk");
		
		pCon.addClientInformation("Test", "Testesen", "+4512345678", "test@testesen.dk", lot, row, bay, departureDate);
		pCon.addDates(returnDate);
		
		pCon.addSelectedService(dieselCarDK.getMake());
		int pID = pCon.saveParking();
		
		PreparedStatement findServiceInDatabase = DatabaseConnection.getInstance().getConnection()
				.prepareStatement("select ServiceType from Service\r\n"
						+ "where Parking_ID_FK = (select top 1 Parking.ParkingID from Parking \r\n"
						+ "where car_FK = (select top 1 ID from Car where RegistrationNo = ? order by ID desc) \r\n"
						+ "order by ParkingID desc) \r\n"
						+ "order by ServiceID_FK desc;");
		findServiceInDatabase.setString(1, dieselCarDK.getRegNo());
		findServiceInDatabase.executeQuery();

		ResultSet rs = findServiceInDatabase.getResultSet();
		rs.next();
		String a = rs.getString(1);

		assertEquals(a, "CHARGER");
		
	}
	
	//T6 - Test if location can be empty - Should throw an exception to Pass!
	@Test (expected = DataAccessException.class)
	public void testIfParkingSavesWithNoLocation() throws DataAccessException, SQLException {
		pCon.createParking();
		pCon.addCar(dieselCarDK.getRegNo());
		
		pCon.addClientInformation("Test", "Testesen", "+4512345678", "test@testesen.dk", null, null, null, departureDate);
		pCon.addDates(returnDate);
		
		pCon.addSelectedService(dieselCarDK.getMake());
		int pID = pCon.saveParking();
		
		assertEquals(pID, pCon.getParkingID(dieselCarDK.getRegNo()), 0);
	}
	
	//T7 - Test if dates can be empty - Should throw exception to Pass!
	@Test (expected = NullPointerException.class)
	public void testIfParkingSavesWithNoDates() throws DataAccessException, SQLException {
		pCon.createParking();
		pCon.addCar(dieselCarDK.getRegNo());
		
		pCon.addClientInformation("Test", "Testesen", "+4512345678", "test@testesen.dk", lot, row, bay, null);
		pCon.addDates(null);
		
		pCon.addSelectedService(dieselCarDK.getMake());
		int pID = pCon.saveParking();
		
		assertEquals(pID, pCon.getParkingID(dieselCarDK.getRegNo()), 0);
		
	}
	
	//T8 - Test if Client can be Null. Should add a nullable Client to Parking and save it.
	// So far test fails because you can't change the first choice yet.
	@Test
	public void testIfClientCanBeNull() throws DataAccessException, SQLException {
		pCon.createParking();
		pCon.addCar(dieselCarDK.getRegNo());
		pCon.addClientInformation(null, null, null, null, lot, row, bay, departureDate);
		pCon.addDates(returnDate);
		int pID = pCon.saveParking();
		
		PreparedStatement findClient = DatabaseConnection.getInstance().getConnection()
				.prepareStatement("select top 1 "// Client.ID, 
						+ "Client.Mail from Client where ClientCar_FK = " 
						+ "(select Car.ID from Car where ParkingID = ?);");
		findClient.setInt(1, pID);//dieselCarDK.getRegNo());
		findClient.executeQuery();

		ResultSet rs = findClient.getResultSet();
		rs.next();
		//int a = rs.getInt(1);
		String b = rs.getString(2);
		
		//assertTrue(a == pID);
		assertEquals(b, "");
	}
	
	//T10 - Test for finding a mock car in the MockMotorregister database. Should Pass if using mock!
	@Test
	public void testIfDisplayFindsMockCarByRegNoInternalMockDatabase() throws DataAccessException {
		pCon.createParking();
		pCon.addCar(dieselCarDK.getRegNo());
		
		assertTrue(addPark.isFocusableWindow());
		assertEquals(pCon.getMake(), "Volvo");
		assertEquals(pCon.getModel(), "S40");
		assertEquals(pCon.getFuelType(), "Diesel");
		
	}
	
	//T11 - Test for finding a real car in the real Motorregister database. Should fail if using mock!
	//Feature should Pass if real data is inserted into mock database
	@Test
	public void testIfDisplayFindsRealLiveCarByRegNoExternalMotorregisterDatabase() throws DataAccessException {
		pCon.createParking();
		pCon.addCar("BD84861");
		
		assertTrue(addPark.isFocusableWindow());
		assertEquals(pCon.getMake(), "Ford");
		assertEquals(pCon.getModel(), "Fiesta");
		assertEquals(pCon.getFuelType(), "Benzin");
	}
	
	@After
	public void tearDown() {
		addPark.reset();
	}
}
