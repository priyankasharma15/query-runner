package psharma.qr.bean;

import java.util.List;

public class QueryResult {
	private List<String> columnName;
	private List<List<String>> rows;

	public List<String> getColumnName() {
		return columnName;
	}

	public void setColumnName(List<String> columnName) {
		this.columnName = columnName;
	}

	public List<List<String>> getRows() {
		return rows;
	}

	public void setRows(List<List<String>> rows) {
		this.rows = rows;
	}

}