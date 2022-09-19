package datadriven;

import org.testng.Assert;
import org.testng.annotations.Test;

public class InheritDataProviderLayer {
	
	@Test(dataProvider = "dp1", dataProviderClass =  DataProviderLayer.class)
	public void useDataProviderTest(String input) {
		System.out.println("The value is " + input);
	}
	
	@Test (dataProvider = "dp2", dataProviderClass = DataProviderLayer.class)
	public void useDataProvideIntTest(int num1, int num2, int num3) {
		int sum = num1 + num2;
		Assert.assertEquals(sum, num3);
	}

}
