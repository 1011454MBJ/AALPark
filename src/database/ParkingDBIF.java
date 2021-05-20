package database;

import java.sql.SQLException;

import model.Parking;

public interface ParkingDBIF {

	boolean saveParking(Parking parking) throws DataAccessException, SQLException;

	int findBayByID(String lot, String row, String bay) throws DataAccessException;
}
