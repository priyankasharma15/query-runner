package psharma.qr.util;

import java.io.FileReader;
import java.util.Properties;

public class PropertyReader {

	static Properties properties = new Properties();

	static {
		String properyLocation = System.getProperty("qr-properties");

		if (properyLocation != null && properyLocation.length() != 0) {
			try {
				properties.load(new FileReader(properyLocation));
			} catch (Exception e) {
			}
		}
		if (properties.size() == 0) {
			try {
				properties.load(new FileReader(
						"c:/query-runner/query-runner.properties"));
			} catch (Exception e) {
			}
		}
		if (properties.size() == 0) {
			try {
				properties.load(PropertyReader.class.getClassLoader()
						.getResourceAsStream("query-runner.properties"));

			} catch (Exception e) {
			}
		}
		System.out.println("Number of Properties Loaded:" + properties.size());
	}

	public static String getUrl() {
		String dbUrl = (String) properties.get("DB_URL");

		return dbUrl;

	}

	public static String getUsername() {
		String dbUsername = (String) properties.get("DB_USERNAME");

		return dbUsername;

	}

	public static String getPassword() {
		String dbPassword = (String) properties.get("DB_PASSWORD");

		return dbPassword;

	}

}
