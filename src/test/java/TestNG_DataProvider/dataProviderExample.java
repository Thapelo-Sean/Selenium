package TestNG_DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviderExample {
	
	@Test(dataProvider = "getData")
	public void setData(String username, String gender, String laptop) 
	{
		System.out.println("Your username is: " + username);
		System.out.println("Your gender is: " + gender);
		System.out.println("Your laptop  is: " + laptop);
		System.out.println("");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] data = new Object[3][3];
		
		//Row1
		data[0][0] = "Thapelo";  //[] row [] column
		data[0][1] = "Male";
		data[0][2] = "Lenovo";
		
		
		//Row2
		data[1][0] = "Paul";
		data[1][1] = "Male";
		data[1][2] = "Apple";
		
		//row3
		data[2][0] = "Mary";
		data[2][1] = "Female";
		data[2][2] = "Asus";
		
		
		return data;
	}
}