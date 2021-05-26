package controller;

import model.*;

import java.sql.SQLException;

import database.*;

/**
 * @author Maibritt Bjørn Jacobsen
 * @version 2021-05-28
 */

public class CarController implements MotorRegisterDBIF {

	private MotorRegisterDBIF motorDB;

	/*
	 * Constructor
	 */
	public CarController() throws SQLException {
		this.motorDB = new MockMotorDB();
	}

	/*
	 * Finding a car from a carRegNo
	 */
	@Override
	public Car findCarByRegistrationNo(String regNo) throws DataAccessException {
		return motorDB.findCarByRegistrationNo(regNo);
	}

	/*
	 * Creating an instance of Car
	 */
	public Car createCar(String regNo, String make, String model, String fuelType) {
		Car car = new Car(regNo, make, model, fuelType);
		return car;
		
	}
}
