package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Maibritt Bjørn Jacobsen
 * @version 2021-05-28
 */

public class DatabaseConnection {
	
	private Connection connection = null;
	private static DatabaseConnection dbConnection;
	
	private static final String driverClass = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static final String dbName = "dmaa0920_1011454";
	private static final String serverAddress = "hildur.ucn.dk";
	private static final int    serverPort = 1433;
	private static final String userName = "dmaa0920_1011454";
	private static final String password = "Password1!";
	
	/*
	 * Constructor (Singleton)
	 */
	private DatabaseConnection() {
		String connectionString = String.format("jdbc:sqlserver://%s:%d;databaseName=%s;user=%s;password=%s", 
				serverAddress, serverPort, dbName, userName, password);
		try {
			Class.forName(driverClass);
			connection = DriverManager.getConnection(connectionString);
		} catch (ClassNotFoundException e) {
			System.err.println("Could not load JDBC driver");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Could not connect to database " + dbName + "@" + serverAddress + ":" + serverPort + " as user " + userName + " using password ******");
			System.out.println("Connection string was: " + connectionString.substring(0, connectionString.length() - password.length()) + "....");
			e.printStackTrace();
		}
	}
	
	/*
	 * Returns instance if one is created. Else create one
	 */
	public static DatabaseConnection getInstance() {
		if(dbConnection == null) {
			dbConnection = new DatabaseConnection();
		}
		return dbConnection;
	}
	
	/*
	 * Starting transaction
	 */
	public void startTransaction() throws SQLException {
		connection.setAutoCommit(false);
	}
	
	/*
	 * Committing transaction 
	 */
	public void commitTransaction() throws SQLException {
		connection.commit();
		connection.setAutoCommit(true);
	}
	
	/*
	 * If transaction fails - erase all data attempted to be modified
	 */
	public void rollbackTransaction() throws SQLException {
		connection.rollback();
		connection.setAutoCommit(true);
	}
	
//	public int executeUpdate(String sql) throws SQLException {
//		System.out.println("DBConnection, Updating: " + sql);
//		int res = -1;
//		try (Statement s = connection.createStatement()){
//			res = s.executeUpdate(sql);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			throw e;
//		}
//		return res;
//	}
	
	
	public Connection getConnection() {
		return connection;
	}
	
	public void disconnect() {
		try {
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

