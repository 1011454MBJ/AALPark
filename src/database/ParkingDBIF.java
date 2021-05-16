package database;

import model.Parking;

public interface ParkingDBIF {

	boolean saveParking(Parking parking);

	boolean saveParking();
}
