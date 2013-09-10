package psharma.qr.dao;

import java.util.List;

import psharma.qr.bean.ConnectionInfo;


public interface ConInfoDao {

	List<ConnectionInfo> getConInfo();

	ConnectionInfo getConInfo(int id);

	void addConnectionInfo(ConnectionInfo ci);

	void saveConnectionInfo(ConnectionInfo ci);
}
