package test;

import org.junit.*;
import static org.junit.Assert.*;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import gui.*;
import controller.*;
import model.*;
import database.*;

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
		test = new Client("Test", "Testesen", "test@testesen.dk", "+4512345678");
		hansi = new Client("Hansi", "Hinterseer", "hansi@hinterseer.de", "+4504143329590");
		dieselCarDK = new Car("DI12345", "Volvo", "S40", "Diesel");
		elektriskCarDK = new Car("EL32106", "Toyota", "Yaris", "Elektrisk");
		carDE = new Car("WOBZK295", "Audi", "Q7", "Benzin");
		departureDate = new String("2021-05-17");
		returnDate = new String("2021-06-25");
		lot = new String("P1");
		row = new String("A");
		bay = new String("1");

	}

	@Test
	public void testHappyDaysDieselNoServiceAdded() throws DataAccessException, SQLException {
		pCon.createParking();
		pCon.addCar(dieselCarDK.getRegNo());
		pCon.addClientInformation("Test", "Testesen", "+4512345678", "test@testesen.dk", lot, row, bay, departureDate);
		pCon.addDates(returnDate);
		int pID = pCon.saveParking();

		assertEquals(pID, pCon.getParkingID(dieselCarDK.getRegNo()), 0);

	}

	@Test
	public void testHappyDaysElektriskWithServiceAdded() throws DataAccessException, SQLException {
		pCon.createParking();
		pCon.addCar(elektriskCarDK.getRegNo());
		pCon.addClientInformation("Test", "Testesen", "+4512345678", "test@testesen.dk", lot, row, bay, departureDate);
		pCon.addDates( returnDate);
		pCon.addSelectedService(elektriskCarDK.getMake());
		int pID = pCon.saveParking();

		assertEquals(pID, pCon.getParkingID(elektriskCarDK.getRegNo()), 0);

		PreparedStatement findServiceInDatabase = DatabaseConnection.getInstance().getConnection()
				.prepareStatement("select ServiceType from Service\r\n"
						+ "where Parking_ID_FK = (select top 1 Parking.ParkingID from Parking \r\n"
						+ "where car_FK = (select top 1 ID from Car where RegistrationNo = ? order by ID desc) \r\n"
						+ "order by ParkingID desc) \r\n"
						+ "order by ServiceID_FK desc;");
		findServiceInDatabase.setString(1, elektriskCarDK.getRegNo());
		findServiceInDatabase.executeQuery();

		ResultSet rs = findServiceInDatabase.getResultSet();
		rs.next();
		String a = rs.getString(1);

		assertEquals(a, "CHARGER");

	}

	@After
	public void tearDown() {
		addPark.reset();
	}
}
