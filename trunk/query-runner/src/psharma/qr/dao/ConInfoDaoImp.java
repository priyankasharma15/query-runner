package psharma.qr.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import psharma.qr.bean.ConnectionInfo;
import psharma.qr.util.DatabaseConnectionManager;


public class ConInfoDaoImp implements ConInfoDao {
	ConnectionInfo ci = null;
	List<ConnectionInfo> list = new ArrayList<ConnectionInfo>();

	@Override
	public List<ConnectionInfo> getConInfo() {
		Connection con = DatabaseConnectionManager.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			st = con.prepareStatement("Select ID,GROUP_NAME,CONNECTION_NAME,CONNECTION_DESCRIPTION,URL,USERNAME,PASSWORD,STATUS from CONNECTION_INFO");
			rs = st.executeQuery();
			while (rs.next()) {

				int id = rs.getInt("id");
				String groupName = rs.getString("GROUP_NAME");
				String connectionName = rs.getString("CONNECTION_NAME");
				String connectionDescription = rs
						.getString("CONNECTION_DESCRIPTION");
				String url = rs.getString("URL");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String status = rs.getString("status");

				ci = new ConnectionInfo();
				ci.setId(id);
				ci.setGroupName(groupName);
				ci.setConnectionName(connectionName);
				ci.setConnectionDescription(connectionDescription);
				ci.setUrl(url);
				ci.setUsername(username);
				ci.setPassword(password);
				ci.setStatus(status);

				list.add(ci);

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
		return list;

	}

	@Override
	public ConnectionInfo getConInfo(int idm) {
		Connection con = DatabaseConnectionManager.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = con.prepareStatement("Select ID,GROUP_NAME,CONNECTION_NAME,CONNECTION_DESCRIPTION,URL,USERNAME,PASSWORD,STATUS from CONNECTION_INFO where ID = ?");
			st.setInt(1, idm);
			rs = st.executeQuery();
			if (rs.next()) {

				int id = rs.getInt("id");
				String groupName = rs.getString("GROUP_NAME");
				String connectionName = rs.getString("CONNECTION_NAME");
				String connectionDescription = rs
						.getString("CONNECTION_DESCRIPTION");
				String url = rs.getString("URL");
				String username = rs.getString("USERNAME");
				String password = rs.getString("PASSWORD");
				String status = rs.getString("status");

				ci = new ConnectionInfo();
				ci.setId(id);
				ci.setGroupName(groupName);
				ci.setConnectionName(connectionName);
				ci.setConnectionDescription(connectionDescription);
				ci.setUrl(url);
				ci.setUsername(username);
				ci.setPassword(password);
				ci.setStatus(status);

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
		return ci;
	}

	@Override
	public void addConnectionInfo(ConnectionInfo ci) {
		Connection con = DatabaseConnectionManager.getConnection();
		PreparedStatement st = null;
		try {
			String insertQuery = "insert into CONNECTION_INFO values((SELECT MAX(ID)+1 from connection_info),?,?,?,?,?,?,?)";
			st = con.prepareStatement(insertQuery);
			st.setString(1, ci.getGroupName());
			st.setString(2, ci.getConnectionName());
			st.setString(3, ci.getConnectionDescription());
			st.setString(4, ci.getUrl());
			st.setString(5, ci.getUsername());
			st.setString(6, ci.getPassword());
			st.setString(7, ci.getStatus());
			st.executeUpdate();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				DatabaseConnectionManager.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}

		}

	}

	@Override
	public void saveConnectionInfo(ConnectionInfo ci) {
		Connection con = DatabaseConnectionManager.getConnection();
		PreparedStatement st = null;
		try {
			String insertQuery = "update CONNECTION_INFO  set GROUP_NAME = ?, CONNECTION_NAME = ?, CONNECTION_DESCRIPTION = ? , URL = ? ,USERNAME = ? ,PASSWORD = ? , STATUS = ?"
					+ "where ID = ?";

			st = con.prepareStatement(insertQuery);
			st.setInt(8, ci.getId());

			st.setString(1, ci.getGroupName());
			st.setString(2, ci.getConnectionName());
			st.setString(3, ci.getConnectionDescription());
			st.setString(4, ci.getUrl());
			st.setString(5, ci.getUsername());
			st.setString(6, ci.getPassword());
			st.setString(7, ci.getStatus());
			st.executeUpdate();
		}

		catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				DatabaseConnectionManager.closeConnection(con);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				// e.printStackTrace();
			}

		}
	}

}
