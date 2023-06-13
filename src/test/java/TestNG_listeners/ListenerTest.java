package TestNG_listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerTest implements ITestListener {

	public void onTestStart(ITestResult Result)
	{
		System.out.println("TestCase: " + Result.getName() + " Started executing.");
	}
	
	public void onFinish(ITestContext Result)
	{
		System.out.println("TestCase: " + Result.getClass() +  " executed successfully");
	}
	
	public void onTestSuccess(ITestResult Result)
	{
		System.out.println("Testcase :" + Result.getName() + " passed");
	}
}
