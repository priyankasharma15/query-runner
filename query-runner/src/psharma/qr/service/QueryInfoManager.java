package psharma.qr.service;

import java.util.ArrayList;
import java.util.List;

import psharma.qr.bean.QueryInfo;
import psharma.qr.dao.QuerryInfoDao;
import psharma.qr.dao.QueryInfoDaoImp;


public class QueryInfoManager {

	public static void main(String[] args) {
		QueryInfoManager obj = new QueryInfoManager();
		List<QueryInfo> list = new ArrayList<QueryInfo>();
		list = obj.getQueryInfo();
		// System.out.println(list);
		System.out.println(obj.getQueryInfo());
		System.out.println(list.size());
		QueryInfo qi = new QueryInfo();
		qi.setId(5);
		qi.setQueryName("change");
		qi.setQueryDescription("newDesc");
		qi.setSqlQuery("Select * from employees");
		qi.setNumParam(0);
		qi.setParams("null");
		qi.setStatus("Y");
		obj.saveQueryInfo(qi);
		System.out.println(qi);
	}

	public List<QueryInfo> getQueryInfo() {

		List<QueryInfo> list = new ArrayList<QueryInfo>();
		QuerryInfoDao ob = new QueryInfoDaoImp();
		list = ob.getQueryInfo();

		return list;
	}

	public QueryInfo getQueryInfo(int idm) {
		QuerryInfoDao ob = new QueryInfoDaoImp();
		QueryInfo qi = new QueryInfo();
		qi = ob.getQueryInfo(idm);
		return qi;
	}

	public void addQueryInfo(QueryInfo qi) {
		QuerryInfoDao ob = new QueryInfoDaoImp();
		ob.addQueryInfo(qi);
	}

	public void saveQueryInfo(QueryInfo qi) {
		QuerryInfoDao ob = new QueryInfoDaoImp();
		ob.saveQueryInfo(qi);
	}

}
