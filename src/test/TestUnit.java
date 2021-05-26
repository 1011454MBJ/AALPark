package test;

import static org.junit.Assert.*;

import java.awt.AWTException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import controller.ParkingController;
import database.DataAccessException;
import database.DatabaseConnection;
import gui.AddParking;
import model.Car;
import model.Client;

/**
 * @author Maibritt Bjørn Jacobsen
 * @version 2021-05-28
 */

public class TestUnit {

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
	
	//T12 - Test if CancelButton works. Should Pass, but throws an assertError!
	@Test
	public void testIfCancelButtonClosesParkingWindow() throws AWTException {
		
		addPark.cancelButtonClicked();
		assertFalse(addPark.isFocusableWindow());
		
	}

	@After
	public void tearDown() {
		addPark.reset();
	}
}
