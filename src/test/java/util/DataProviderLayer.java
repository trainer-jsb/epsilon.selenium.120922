package util;

import java.io.FileInputStream;
import java.util.Properties;

import org.testng.Assert;

public class DataProviderLayer {
	
	public static String getPropertyValue(String filePath, String key) {
		Properties prop = new Properties();
		try {
			FileInputStream fis = new FileInputStream(filePath);
			prop.load(fis);
		}catch(Exception ex) {
			Assert.fail("FAIL | Incorrect file path or key; unable to read test data");
		}
		return prop.getProperty(key);
	}

}
