package psharma.qr.service;

import java.util.List;

import psharma.qr.bean.ConnectionInfo;
import psharma.qr.bean.QueryInfo;
import psharma.qr.bean.QueryResult;
import psharma.qr.dao.QueryResultDao;


public class QueryManager {

	public static void main(String[] args) {
		QueryManager qm = new QueryManager();
		QueryResult qr;
		QueryInfoManager qim = new QueryInfoManager();
		QueryInfo qi;
		qi = qim.getQueryInfo(2);
		ConInfoManager cim = new ConInfoManager();
		ConnectionInfo ci = new ConnectionInfo();
		ci = cim.getConnectionInfo(1);
		String param = "2";
		qr = qm.getQuery(qi, ci, param);
		// System.out.println(qr);

		for (String str : qr.getColumnName()) {

			System.out.println(str);
		}
		for (List<String> valueList : qr.getRows()) {
			for (String str : valueList) {
				System.out.println(str);

			}

		}

	}

	public QueryResult getQuery(QueryInfo qi, ConnectionInfo ci, String params) {
		QueryResultDao qrd = new QueryResultDao();
		QueryResult qr;
		qr = qrd.getQuery(qi, ci, params);
		return qr;

	}

}
