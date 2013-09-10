package psharma.qr.bean;

public class QueryInfo {

	public int id;
	public String queryName;
	public String queryDescription;
	public String sqlQuery;
	public int numParam;
	public String params;
	public String status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQueryName() {
		return queryName;
	}

	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}

	public String getQueryDescription() {
		return queryDescription;
	}

	public void setQueryDescription(String queryDescription) {
		this.queryDescription = queryDescription;
	}

	public String getSqlQuery() {
		return sqlQuery;
	}

	public void setSqlQuery(String sqlQuery) {
		this.sqlQuery = sqlQuery;
	}

	public int getNumParam() {
		return numParam;
	}

	public void setNumParam(int numParam) {
		this.numParam = numParam;
	}

	public String getParams() {
		return params;
	}

	public void setParams(String params) {
		this.params = params;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "QueryInfo [id=" + id + ", queryName=" + queryName
				+ ", queryDescription=" + queryDescription + ", sqlQuery="
				+ sqlQuery + ", numParam=" + numParam + ", params=" + params
				+ ", status=" + status + "]";
	}

}