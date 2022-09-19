package datadriven;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderExample {

	@DataProvider(name = "dp1")
	public Object[][] dataProvider() {

		return new Object[][] {
			{"Value One"},
			{"Value Two"},
			{"Value Three"}
		};
	}
	
	@Test(dataProvider = "dp1")
	public void useDataProviderTest(String input) {
		System.out.println("The value is " + input);
	}
	
	@DataProvider(name = "dp2")
	public Object[][] dataProvider2() {

		return new Object[][] {
			{1,2,3},
			{2,3,4},
			{6,7,13}
		};
	}
	
	@Test (dataProvider = "dp2")
	public void useDataProvideIntTest(int num1, int num2, int num3) {
		int sum = num1 + num2;
		Assert.assertEquals(sum, num3);
	}
	
}
