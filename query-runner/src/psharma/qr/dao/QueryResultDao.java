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
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import psharma.qr.bean.ConnectionInfo;
import psharma.qr.bean.QueryInfo;
import psharma.qr.bean.QueryResult;
import psharma.qr.util.DatabaseConnectionManager;

public class QueryResultDao {

	/*
	 * public static void main(String[] args) { QueryResultDao qm = new
	 * QueryResultDao(); QueryResult qr = new QueryResult(); QueryInfoManager
	 * qim = new QueryInfoManager(); QueryInfo qi = new QueryInfo(); qi =
	 * qim.getQueryInfo(1); ConInfoManager cim = new ConInfoManager();
	 * ConnectionInfo ci = new ConnectionInfo(); ci = cim.getConnectionInfo(1);
	 * qr = qm.getQuery(qi, ci); }
	 */

	public QueryResult getQuery(QueryInfo qi, ConnectionInfo ci, String params) {
		Connection con = DatabaseConnectionManager.getConnection(ci);
		PreparedStatement st = null;
		ResultSet rs = null;
		QueryResult qr = null;

		try {

			if (qi.getNumParam() >= 1) {
				st = con.prepareStatement(qi.getSqlQuery());
				st.setString(1, params);
			} else {
				st = con.prepareStatement(qi.getSqlQuery());
			}

			rs = st.executeQuery();

			ResultSetMetaData rsmd = rs.getMetaData();
			int numberOfColumns = rsmd.getColumnCount();
			System.out.println(numberOfColumns);

			List<String> columnName = new ArrayList<String>();

			for (int i = 1; i <= numberOfColumns; i++) {
				String column = rsmd.getColumnName(i);
				columnName.add(column);
			}
			List<List<String>> rowN = new ArrayList<List<String>>();
			while (rs.next()) {
				List<String> row1 = new ArrayList<String>();
				for (int i = 1; i <= numberOfColumns; i++) {
					String row = rs.getString(i);
					row1.add(row);
				}

				rowN.add(row1);

			}
			qr = new QueryResult();

			qr.setColumnName(columnName);
			qr.setRows(rowN);

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
		return qr;

	}
}
