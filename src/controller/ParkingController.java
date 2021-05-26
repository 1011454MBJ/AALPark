package controller;

import model.*;

import java.sql.SQLException;
import java.time.LocalDate;

import database.*;

/**
 * @author Maibritt Bjørn Jacobsen
 * @version 2021-05-28
 */

public class ParkingController implements ParkingDBIF {

	private ParkingDBIF parkDB;
	private ClientController clientController;
	private CarController carController;
	private Parking parking;
	private Car car;
	private Client client;

	/*
	 * Constructor
	 */
	public ParkingController() throws SQLException {
		parkDB = new ParkingDB();
		clientController = new ClientController();
		carController = new CarController();
	}

	/*
	 * Creating the instance of parking to which other information can be added
	 */
	public Parking createParking() {
		parking = new Parking();
		return parking;
	}

	/*
	 * Adding a car to Parking
	 */
	public void addCar(String regNo) throws DataAccessException {
		car = carController.findCarByRegistrationNo(regNo);
		parking.addCarInformation(car);
	}
	
	//Overloaded - same method - different input parameters
	public void addCar(String regNo, String make, String model, String fuelType) {
		car = carController.createCar(regNo, make, model, fuelType);
		parking.addCarInformation(car);
	}

	/*
	 * Adding Client to Parking
	 */
	public void addClientInformation(String firstName, String lastName, String phoneNo, 
									String mail, String lot, String row, String bay, 
									String departureDate) throws DataAccessException {

		client = clientController.createClient(firstName, lastName, phoneNo, mail);
		parking.addClientInformation(client);
		int location = findBayByID(lot, row, bay);
		
		parking.setLocation(location);
		LocalDate departDate = LocalDate.parse(departureDate);
		parking.setDepartureDate(departDate);
	}

	/*
	 * Adding a return date to Parking
	 */
	public void addDates(String returnDate) {
		LocalDate dueBackDate = LocalDate.parse(returnDate);
		parking.setReturnDate(dueBackDate);
	}

	/*
	 * Saving Parking to database
	 */
	public int saveParking() throws DataAccessException, SQLException {
		
		return saveParking(parking);
	
	}

	/*
	 * Getting carMake
	 */
	public String getMake() {
		
		return car.getMake();
	}

	/*
	 * Getting carModel
	 */
	public String getModel() {
		
		return car.getModel();
	}

	/*
	 * Getting carFuelType
	 */
	public String getFuelType() {
		
		return car.getFuelType();
	}
	
	/*
	 * Get the object car
	 */
	public Car getCar() {
		
		return car;
	}

	/*
	 * Set carMake
	 */
	public void setMake(String make) {
		
		car.setMake(make);
		parking.addCarInformation(car);
	}

	/*
	 * Set carModel
	 */
	public void setModel(String model) {
		
		car.setModel(model);
		parking.addCarInformation(car);
	}

	/*
	 * Set carFuelType
	 */
	public void setFuelType(String fuelType) {
		
		car.setFuelType(fuelType);
		parking.addCarInformation(car);
	}

	/*
	 * Find bay ID from lot, row and bay number
	 */
	@Override
	public int findBayByID(String lot, String row, String bay) throws DataAccessException {
		
		return parkDB.findBayByID(lot, row, bay);
	}

	/*
	 * Save Parking
	 */
	@Override
	public int saveParking(Parking parking) throws DataAccessException, SQLException {
		
		return parkDB.saveParking(parking);
	}

	/*
	 * Getting a ParkingID from a carRegNo
	 */
	@Override
	public int getParkingID(String regNo) throws SQLException {

		return parkDB.getParkingID(regNo);
	}

	/*
	 * Adding a service to Parking
	 */
	public void addSelectedService(String carMake) {
		parking.setService(carMake);
	}

	/*
	 * Removing a service from Parking 
	 */
	public void removeSelectedService() {
		parking.setService();
	}

}
