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
