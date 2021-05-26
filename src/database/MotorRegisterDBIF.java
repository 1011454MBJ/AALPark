package database;

import model.*;

/**
 * @author Maibritt Bj�rn Jacobsen
 * @version 2021-05-28
 */

public interface MotorRegisterDBIF {

	public Car findCarByRegistrationNo(String regNo) throws DataAccessException;
}
