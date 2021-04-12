package pms.cucumber.props;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigProperties {

	public static String getProperty(String key) {
		String value = null;
		try (InputStream input = new FileInputStream("src/main/resources/dev.properties")) {
			Properties prop = new Properties();
			prop.load(input);
			value = prop.getProperty(key);
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return value;
	}
}
