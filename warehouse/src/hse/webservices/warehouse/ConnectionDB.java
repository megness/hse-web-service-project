package hse.webservices.warehouse;

import java.sql.*;

public class ConnectionDB {
	static Connection conn = null;

	public static Connection getConnection() {
		return conn;
	}

	public ConnectionDB(String userName, String password)
			throws InstantiationException, IllegalAccessException,
			ClassNotFoundException, SQLException {
		if (conn != null)
			return;
		final String url = "jdbc:mysql://localhost/manipulation_indexes?user="
				+ userName + "&password=" + password;
		Class.forName("com.mysql.jdbc.Driver").newInstance();
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("Database connection established");
	}

	void disconnectDB() {
		if (conn != null) {
			try {
				conn.close();
				System.out.println("Database connection terminated");
			} catch (Exception e) {
			}
		}
	}

	void updateDB(final String query) {
		if (conn == null)
			return;
		final Statement stat;
		try {
			stat = (Statement) conn.createStatement();
			stat.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	ResultSet queryDB(final String query) {
		if (conn == null)
			return null;
		final Statement stat;
		ResultSet result = null;
		try {
			stat = (Statement) conn.createStatement();
			result = (ResultSet) stat.executeQuery(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}