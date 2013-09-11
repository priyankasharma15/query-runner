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

import psharma.qr.bean.QueryInfo;
import psharma.qr.util.DatabaseConnectionManager;

public class QueryInfoDaoImp implements QuerryInfoDao {
	QueryInfo qi = null;
	List<QueryInfo> list = new ArrayList<QueryInfo>();

	public List<QueryInfo> getQueryInfo() {
		Connection con = DatabaseConnectionManager.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = con.prepareStatement("Select ID,QUERY_NAME,QUERY_DESCRIPTION,SQL_QUERY,NUM_PARAMS,PARAMS,STATUS from QUERY_INFO");
			rs = st.executeQuery();

			while (rs.next()) {

				int id = rs.getInt("id");
				String queryName = rs.getString("QUERY_NAME");
				String queryDescription = rs.getString("QUERY_DESCRIPTION");
				String sqlQuery = rs.getString("SQL_QUERY");
				int numParam = rs.getInt("NUM_PARAMS");
				String params = rs.getString("PARAMS");
				String status = rs.getString("status");

				qi = new QueryInfo();
				qi.setId(id);
				qi.setQueryName(queryName);
				qi.setQueryDescription(queryDescription);
				qi.setSqlQuery(sqlQuery);
				qi.setStatus(status);
				qi.setNumParam(numParam);
				qi.setParams(params);

				list.add(qi);

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
	public QueryInfo getQueryInfo(int idm) {
		Connection con = DatabaseConnectionManager.getConnection();
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			st = con.prepareStatement("Select ID,QUERY_NAME,QUERY_DESCRIPTION,SQL_QUERY,NUM_PARAMS,PARAMS,STATUS from QUERY_INFO where id = ?");
			st.setInt(1, idm);
			rs = st.executeQuery();
			if (rs.next()) {

				int id = rs.getInt("id");
				String queryName = rs.getString("QUERY_NAME");
				String queryDescription = rs.getString("QUERY_DESCRIPTION");
				String sqlQuery = rs.getString("SQL_QUERY");
				int numParam = rs.getInt("NUM_PARAMS");
				String params = rs.getString("PARAMS");
				String status = rs.getString("status");

				qi = new QueryInfo();
				qi.setId(id);
				qi.setQueryName(queryName);
				qi.setQueryDescription(queryDescription);
				qi.setSqlQuery(sqlQuery);
				qi.setStatus(status);
				qi.setParams(params);
				qi.setNumParam(numParam);

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
		return qi;

	}

	@Override
	public void addQueryInfo(QueryInfo qi) {
		Connection con = DatabaseConnectionManager.getConnection();
		PreparedStatement st = null;
		try {
			String insertQuery = "insert into QUERY_INFO values((SELECT MAX(ID)+1 from query_info),?,?,?,?,?,?)";
			st = con.prepareStatement(insertQuery);
			st.setString(1, qi.getQueryName());
			st.setString(2, qi.getQueryDescription());
			st.setString(3, qi.getSqlQuery());
			st.setInt(4, qi.getNumParam());
			st.setString(5, qi.getParams());
			st.setString(6, qi.getStatus());
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
	public void saveQueryInfo(QueryInfo qi) {
		Connection con = DatabaseConnectionManager.getConnection();
		PreparedStatement st = null;
		try {
			String insertQuery = "update QUERY_INFO set QUERY_NAME=? , QUERY_DESCRIPTION=?, SQL_QUERY=?, NUM_PARAMS=?, PARAMS=?, STATUS=?"
					+ "where ID = ?";
			st = con.prepareStatement(insertQuery);
			st.setInt(7, qi.getId());
			st.setString(1, qi.getQueryName());
			st.setString(2, qi.getQueryDescription());
			st.setString(3, qi.getSqlQuery());
			st.setInt(4, qi.getNumParam());
			st.setString(5, qi.getParams());
			st.setString(6, qi.getStatus());
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
