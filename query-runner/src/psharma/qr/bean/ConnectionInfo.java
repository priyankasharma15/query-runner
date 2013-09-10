package psharma.qr.bean;

public class ConnectionInfo {

	public int id;
	public String groupName;
	public String connectionName;
	public String connectionDescription;
	public String url;
	public String username;
	public String password;
	public String status;

	public String toString() {
		return "ConnectionInfo [id=" + id + ", groupName=" + groupName
				+ ", connectionName=" + connectionName
				+ ", connectionDescription=" + connectionDescription + ", url="
				+ url + ", username=" + username + ", password=" + password
				+ ", status=" + status + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getConnectionName() {
		return connectionName;
	}

	public void setConnectionName(String connectionName) {
		this.connectionName = connectionName;
	}

	public String getConnectionDescription() {
		return connectionDescription;
	}

	public void setConnectionDescription(String connectionDescription) {
		this.connectionDescription = connectionDescription;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
