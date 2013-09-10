package psharma.qr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import psharma.qr.bean.UserInfo;
import psharma.qr.util.DatabaseConnectionManager;


public class UserLogInDaoImp implements UserLogInDao {

	/**
	 * will take username return userInfo
	 * 
	 */
	public UserInfo getLogIn(String username) {
		Connection con = DatabaseConnectionManager.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		UserInfo us = null;
		try {
			st = con.prepareStatement("Select username , password , status from LOG_IN_DB where username = ?");
			st.setString(1, username);
			rs = st.executeQuery();
			if (rs.next()) {

				String password = rs.getString("password");
				String status = rs.getString("status");
				us = new UserInfo();
				us.setPassword(password);
				us.setStatus(status);
				us.setUsername(username);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				rs.close();
				DatabaseConnectionManager.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}

		}
		System.out.println(us);
		return us;

	}

}
