package database;

import model.Parking;

public interface ParkingDBIF {

	boolean saveParking(Parking parking);

	boolean saveParking();

	int findBayByID(String lot, String row, String bay) throws DataAccessException;
}
