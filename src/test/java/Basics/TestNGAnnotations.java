package Basics;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class TestNGAnnotations {
	
	/*BeforeSuite
	 * BeforeTest
	 * BeforeClasses
	 * BeforeMethod
	 * Test
	 * AfterMethod
	 * AfterClassses
	 * AfterTest
	 * AfterSuite
	 */
	
	@Test
	public void testCase1() 
	{
		System.out.println("in Test case 1");
	}
	
	@Test
	public void testCase2() 
	{
		System.out.println("in Test case 2");
	}
	
	@BeforeMethod
	public void beforeMethod() 
	{
		System.out.println("in before method");
	}
	
	@AfterMethod
	public void afterMethod() 
	{
		System.out.println("in after method");
	}
	
	@BeforeClass
	public void beforeClass() 
	{
		System.out.println("in before class");
	}
	
	@AfterClass
	public void afterClass() 
	{
		System.out.println("in after class");
	}
	
	@BeforeTest
	public void beforeTest() 
	{
		System.out.println("in before Test");
	}

	@AfterTest
	public void afterTest() 
	{
		System.out.println("in after Test");
	}
}