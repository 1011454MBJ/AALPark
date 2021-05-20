package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Parking;

public class ParkingDB implements ParkingDBIF {
	
	private static final String findBayByIDQ = "  select Bay.ID\r\n"
			+ "  from Bay\r\n"
			+ "  join Row\r\n"
			+ "    on Row.ID = Bay.Row_FK\r\n"
			+ "  join ParkingLot\r\n"
			+ "    on ParkingLot.ID = Row.Lot_FK\r\n"
			+ "  where ParkingLot.Name = ?\r\n"
			+ "     and Row.Row = ?\r\n"
			+ "	 and Bay.Number = ?";
	private PreparedStatement findBayByID;
	
	public ParkingDB() throws SQLException {
		init();
	}
	
	private void init() throws SQLException {
		findBayByID = DatabaseConnection.getInstance()
				.getConnection().prepareStatement(findBayByIDQ);
	}

	@Override
	public boolean saveParking(Parking parking) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean saveParking() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int findBayByID(String lot, String row, String bay) throws DataAccessException {
		// TODO Auto-generated method stub
		try {
			findBayByID.setString(1, lot);
			findBayByID.setString(2, row);
			findBayByID.setString(3, bay);
			
			ResultSet set = findBayByID.executeQuery();
			
			int location = -1;
			
			if (set.next()) {
				location = set.getInt(location);
			}
			return location;
		} catch (SQLException e) {
			throw new DataAccessException(e, "The bay: " + lot + " " + row + " " + bay + " was not found");
		}
	}
	
}