package carsSystem.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionManager {

	private static ConnectionManager instance = null;
	private final String USERNAME = "root";
	private final String PASSWORD = "";
	private final String CONNECTION_STRING = "jdbc:mysql://localhost/cars?useUnicode=yes&characterEncoding=UTF-8";
	private Connection conn = null;

	private ConnectionManager() {
	}

	public static ConnectionManager getInstance() {
		if (instance == null) {
			instance = new ConnectionManager();
		}
		return instance;
	}

	private boolean openConnection() {
		try {
			conn = DriverManager.getConnection(CONNECTION_STRING, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}

	public Connection getConnection() {
		if (conn == null) {
			if (openConnection()) {
				return conn;
			} else {
				return null;
			}
		}
		return conn;
	}

	public void close() {
		try {
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		conn = null;
	}

	public Statement createStatement() throws SQLException {
		return conn.createStatement();
	}

	public PreparedStatement preparedStatement(String sql) throws SQLException {
		return conn.prepareStatement(sql);
	}

}
