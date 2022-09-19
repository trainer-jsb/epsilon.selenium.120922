package datadriven;

import java.io.IOException;
import org.testng.annotations.Test;
import util.Utilities;

public class ReadFromPropFile {
	
	//Arrange
	private String filePath = "src/test/resources/credentials.prop";
	
	@SuppressWarnings("unused")
	@Test
	public void readFromPropFileTest() throws IOException {
		Utilities util = new Utilities();
		String username = util.getPropertyValue(filePath, "username");
		String password = util.getPropertyValue(filePath, "password");
		String browser = util.getPropertyValue(filePath, "browser");
	}
}