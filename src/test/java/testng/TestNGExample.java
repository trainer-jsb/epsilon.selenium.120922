package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;

public class TestNGExample {
	
  @Test (priority = 1)
  public void createEmployee() {
	  System.out.println("This is the createEmployee");
  }
  
  @Test (priority = 2)
  public void updateEmployee() {
	  System.out.println("This is the updateEmployee");
  }
  
  @Test (priority = 3)
  public void deleteEmployee() {
	  System.out.println("This is the deleteEmployee");
  }
}
