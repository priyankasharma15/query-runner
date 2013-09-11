/**
-----------------------------------------------------------------------------
query-runner is available for use under the following license, commonly known
as the 3-clause (or "modified") BSD license:
-----------------------------------------------------------------------------
Copyright (c) 2013, Priyanka Sharma (sharmapriyanka334@gmail.com)
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:
1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. The name of the author may not be used to endorse or promote products
   derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY THE AUTHOR 'AS IS' AND ANY EXPRESS OR
IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
-----------------------------------------------------------------------------
 **/
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
