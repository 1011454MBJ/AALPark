package database;

import java.sql.SQLException;

import model.Parking;

/**
 * @author Maibritt Bjørn Jacobsen
 * @version 2021-05-28
 */

public interface ParkingDBIF {

	int saveParking(Parking parking) throws DataAccessException, SQLException;

	int findBayByID(String lot, String row, String bay) throws DataAccessException;
	
	int getParkingID(String regNo) throws SQLException;
}
