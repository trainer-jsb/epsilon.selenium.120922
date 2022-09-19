package testng.advanced;

import org.testng.annotations.Test;

public class ClassOne {
	
	@Test(priority = 1, groups = {"Smoke","Sanity"})
	public void testOne() throws InterruptedException {
		System.out.println("This is test one");
	}
	
	@Test(priority = 2, groups = {"Smoke"})
	public void testTwo() throws InterruptedException {
		System.out.println("This is test two");
	}
	
	@Test(priority = 3, groups = {"Sanity"})
	public void testThree() throws InterruptedException {
		System.out.println("This is test three");
	}

}
