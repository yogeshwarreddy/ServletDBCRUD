package me.yogeshwar.servlet.util;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public interface SingletonConnectionFactory {
	public Connection createConnection() throws SQLException;
	public Statement createStatement() throws SQLException;
}
