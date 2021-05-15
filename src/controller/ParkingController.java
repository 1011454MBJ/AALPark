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

	public void addClientInformation(String firstName, String lastName, String phoneNo, 
									String mail, String location, LocalDate returnDate) {

		client = clientController.createClient(firstName, lastName, phoneNo, mail);
		parking.addClientInformation(client);
		parking.setLocation(location);
		parking.setReturnDate(returnDate);

	}

	@Override
	public boolean saveParking(Parking parking) {
		// TODO Auto-generated method stub
		return false;
	}

	public String getMake() {
		// TODO Auto-generated method stub
		return car.getMake();
	}

	public String getModel() {
		// TODO Auto-generated method stub
		return car.getModel();
	}

	public String getFuelType() {
		// TODO Auto-generated method stub
		return car.getFuelType();
	}

	public Car getCar() {
		// TODO Auto-generated method stub
		return car;
	}

}
