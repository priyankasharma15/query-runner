package psharma.qr.service;

import java.util.ArrayList;
import java.util.List;

import psharma.qr.bean.ConnectionInfo;
import psharma.qr.dao.ConInfoDao;
import psharma.qr.dao.ConInfoDaoImp;


public class ConInfoManager {

	public static void main(String[] args) {
		ConInfoManager ob = new ConInfoManager();
		List<ConnectionInfo> list = new ArrayList<ConnectionInfo>();
		list = ob.getConInfo();
		System.out.println(list);
		ConnectionInfo ci = new ConnectionInfo();
		ci = ob.getConnectionInfo(1);
		System.out.println(ci);
		ConnectionInfo c = new ConnectionInfo();
		c.setId(2);
		c.setGroupName("QAC");
		c.setConnectionName("Test");
		c.setConnectionDescription("new");
		c.setUrl("ab");
		c.setUsername("pinki");
		c.setPassword("pri123");
		c.setStatus("Y");
		ob.saveConnectionInfo(c);
		System.out.println(c);
	}

	public List<ConnectionInfo> getConInfo() {

		List<ConnectionInfo> list = new ArrayList<ConnectionInfo>();
		ConInfoDao ob = new ConInfoDaoImp();
		list = ob.getConInfo();

		return list;
	}

	public ConnectionInfo getConnectionInfo(int idm) {
		ConnectionInfo ci = new ConnectionInfo();
		ConInfoDao ob = new ConInfoDaoImp();
		ci = ob.getConInfo(idm);
		return ci;
	}

	public void addConnectionInfo(ConnectionInfo ci) {
		ConInfoDao ob = new ConInfoDaoImp();
		ob.addConnectionInfo(ci);
	}

	public void saveConnectionInfo(ConnectionInfo ci) {
		ConInfoDao ob = new ConInfoDaoImp();
		ob.saveConnectionInfo(ci);
	}
}
