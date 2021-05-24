package controller;

import model.*;

import java.sql.SQLException;
import java.time.LocalDate;

import database.*;

public class ParkingController implements ParkingDBIF {

	private ParkingDBIF parkDB;
	private ClientController clientController;
	private CarController carController;
	private Parking parking;
	private Car car;
	private Client client;

	public ParkingController() throws SQLException {
		parkDB = new ParkingDB();
		clientController = new ClientController();
		carController = new CarController();
	}

	public Parking createParking() {
		parking = new Parking();
		return parking;
	}

	public void addCar(String regNo) throws DataAccessException {
		car = carController.findCarByRegistrationNo(regNo);
		parking.addCarInformation(car);
	}
	
	//Overloaded - same method - different input parameters
	public void addCar(String regNo, String make, String model, String fuelType) {
		car = carController.createCar(regNo, make, model, fuelType);
		parking.addCarInformation(car);
	}

	public void addClientInformation(String firstName, String lastName, String phoneNo, 
									String mail, String lot, String row, String bay, 
									String departureDate, String returnDate) throws DataAccessException {

		client = clientController.createClient(firstName, lastName, phoneNo, mail);
		parking.addClientInformation(client);
		int location = findBayByID(lot, row, bay);
		
		parking.setLocation(location);
		LocalDate departDate = LocalDate.parse(departureDate);
		LocalDate dueBackDate = LocalDate.parse(returnDate);
		parking.setDepartureDate(departDate);
		parking.setReturnDate(dueBackDate);

	}

	public int saveParking() throws DataAccessException, SQLException {
		
		return saveParking(parking);
	
	}

	public String getMake() {
		
		return car.getMake();
	}

	public String getModel() {
		
		return car.getModel();
	}

	public String getFuelType() {
		
		return car.getFuelType();
	}
	
	public Car getCar() {
		
		return car;
	}

	public void setMake(String make) {
		
		car.setMake(make);
		parking.addCarInformation(car);
	}

	public void setModel(String model) {
		
		car.setModel(model);
		parking.addCarInformation(car);
	}

	public void setFuelType(String fuelType) {
		
		car.setFuelType(fuelType);
		parking.addCarInformation(car);
	}

	@Override
	public int findBayByID(String lot, String row, String bay) throws DataAccessException {
		
		return parkDB.findBayByID(lot, row, bay);
	}

	@Override
	public int saveParking(Parking parking) throws DataAccessException, SQLException {
		
		return parkDB.saveParking(parking);
	}

	@Override
	public int getParkingID(String regNo) throws SQLException {
		// TODO Auto-generated method stub
		return parkDB.getParkingID(regNo);
	}

	public void addSelectedService(String carMake) {
		// TODO Auto-generated method stub
		parking.setService(carMake);
	}

}
