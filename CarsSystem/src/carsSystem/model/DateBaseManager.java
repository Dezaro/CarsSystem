package carsSystem.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DateBaseManager {

	private static Connection conn;

	public void Insert(String query) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		conn = ConnectionManager.getInstance().getConnection();

		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionManager.getInstance().close();
	}

	public ResultSet Select(String query) throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		conn = ConnectionManager.getInstance().getConnection();
		Statement statement = conn.createStatement();
		ResultSet result = statement.executeQuery(query);
		return result;
	}

	public void Update(String query) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionManager.getInstance().close();
	}

	public void Delete(String query) {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		conn = ConnectionManager.getInstance().getConnection();
		PreparedStatement statement;
		try {
			statement = conn.prepareStatement(query);
			statement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		ConnectionManager.getInstance().close();
	}

}
