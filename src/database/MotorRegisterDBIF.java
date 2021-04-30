package database;

import model.*;

public interface MotorRegisterDBIF {

	public Car findCarByRegistrationNo(String regNo) throws DataAccessException;
}
