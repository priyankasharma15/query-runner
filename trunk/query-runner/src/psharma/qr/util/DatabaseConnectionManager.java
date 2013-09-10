package psharma.qr.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import psharma.qr.bean.ConnectionInfo;


public class DatabaseConnectionManager {
	static {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/*
	 * public static Connection getConnection() { Connection con = null; try {
	 * con = DriverManager
	 * .getConnection("jdbc:oracle:thin:@192.168.1.60:1521:XE", "pinki",
	 * "pri123"); } catch (SQLException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } return con; }
	 */
	public static Connection getConnection() {
		Connection con = null;
		String password = PropertyReader.getPassword();
		String url = PropertyReader.getUrl();
		String username = PropertyReader.getUsername();
		try {
			con = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;
	}

	public static Connection getConnection(ConnectionInfo ci) {
		Connection con = null;
		try {
			con = DriverManager.getConnection(ci.getUrl(), ci.getUsername(),
					ci.getPassword());
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return con;

	}

	public static void closeConnection(Connection con) {
		try {
			if ((con != null) && (!con.isClosed())) {
				con.close();
			}

		} catch (SQLException e) {
			// Do nothing
		}
	}
}
