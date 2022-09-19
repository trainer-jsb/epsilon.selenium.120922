package datadriven;

import org.testng.annotations.DataProvider;

public class DataProviderLayer {

	@DataProvider(name = "dp1")
	public Object[][] dataProvider() {

		return new Object[][] {
			{"Value One"},
			{"Value Two"},
			{"Value Three"}
		};
	}
	
	@DataProvider(name = "dp2")
	public Object[][] dataProvider2() {

		return new Object[][] {
			{1,2,3},
			{2,3,4},
			{6,7,13}
		};
	}
}
