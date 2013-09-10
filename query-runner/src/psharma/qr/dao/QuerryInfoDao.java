package psharma.qr.dao;

import java.util.List;

import psharma.qr.bean.QueryInfo;


public interface QuerryInfoDao {

	List<QueryInfo> getQueryInfo();

	QueryInfo getQueryInfo(int id);

	void addQueryInfo(QueryInfo qi);

	void saveQueryInfo(QueryInfo qi);
}
