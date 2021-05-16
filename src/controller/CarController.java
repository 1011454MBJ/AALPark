package controller;

import model.*;

import java.sql.SQLException;

import database.*;

public class CarController implements MotorRegisterDBIF {

	private MotorRegisterDBIF motorDB;

	public CarController() throws SQLException {
		this.motorDB = new MockMotorDB();
	}

	@Override
	public Car findCarByRegistrationNo(String regNo) throws DataAccessException {
		return motorDB.findCarByRegistrationNo(regNo);
	}

	public Car createCar(String regNo, String make, String model, String fuelType) {
		Car car = new Car(regNo, make, model, fuelType);
		return car;
		
	}
}
