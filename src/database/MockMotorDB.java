package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.*;

public class MockMotorDB implements MotorRegisterDBIF {

	private static final String findByRegNoQ = "select RegNo, Make, Model, FuelType "
			+ "from MockMotorregistret where RegNo = ?";
	private PreparedStatement findByRegNo;
	
	public MockMotorDB() throws SQLException {
		init();
	}
	
	private void init() throws SQLException {
		findByRegNo = DatabaseConnection.getInstance()
				.getConnection().prepareStatement(findByRegNoQ);
	}
	
	@Override
	public Car findCarByRegistrationNo(String regNo) throws DataAccessException {
		try {
			findByRegNo.setString(1, regNo);
			ResultSet set;
			set = findByRegNo.executeQuery();
			Car car = null;
			if (set.next()) {
				car = buildCar(set);
			}
			return car;
		} catch (SQLException e) {
			throw new DataAccessException(e, "The car: " + regNo + " was not found");
		}
	}

	private Car buildCar(ResultSet set) throws SQLException {
		Car car = new Car(set.getString("RegNo"), set.getString("Make"), 
				set.getString("Model"), set.getString("FuelType"));
		
		return car;
	}

}
