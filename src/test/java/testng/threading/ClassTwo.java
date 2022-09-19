package testng.threading;

import org.testng.annotations.Test;

public class ClassTwo {
	
	@Test(priority = 1)
	public void firstTest() {
		long threadID = Thread.currentThread().getId();
		System.out.println(" This is first test of ClassTwo running in thread " +threadID);
	}
	
	@Test(priority = 2)
	public void secondTest() {
		long threadID = Thread.currentThread().getId();
		System.out.println(" This is secondTest of ClassTworunning in thread " +threadID);
	}
	
	@Test(priority = 3)
	public void thirdTest() {
		long threadID = Thread.currentThread().getId();
		System.out.println(" This is thirdTest of ClassTwo running in thread " +threadID);
	}
	
	@Test(priority = 4)
	public void fourthTest() {
		long threadID = Thread.currentThread().getId();
		System.out.println(" This is fourthTest of ClassTwo running in thread " +threadID);
	}

}
