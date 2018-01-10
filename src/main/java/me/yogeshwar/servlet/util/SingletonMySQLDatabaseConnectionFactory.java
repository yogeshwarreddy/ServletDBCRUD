package me.yogeshwar.servlet.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SingletonMySQLDatabaseConnectionFactory implements SingletonConnectionFactory {
	static Connection connection;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection createConnection() throws SQLException {
		if (connection == null || connection.isClosed()) {
			synchronized (SingletonMySQLDatabaseConnectionFactory.class) {
				if (connection == null || connection.isClosed()) {
					try {
						connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc", "root", "root");
						return connection;
					} catch (SQLException e) {
						e.printStackTrace();
						return null;
					}
				}
			}
		}
		return connection;
	}

	public Statement createStatement() throws SQLException {
		return createConnection().createStatement();
	}

	public void closeConnection() {
		try {
			if (connection != null && !connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
