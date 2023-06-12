package Screenshots;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class listenersClass extends baseClass implements ITestListener{
	
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Failed Test");
		failed();
		System.out.println("Screenshot for failure taken.");
	}
	
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Test Success");
		success();
		System.out.println("Screenshot for success taken.");
	}
}