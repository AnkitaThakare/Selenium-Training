package com.orangehrm;

//import org.testng.annotations.Test;
import org.testng.annotations.DataProvider;

public class ApplicationTestData 
{
	@DataProvider(name = "Login")
	public Object[][] getDataforLogin() {
		// Multidimensional Object
		// 3X3 or 4X3 or 4X5
		return new Object[][] {

				{"Admin", "admin123" },
				{"dixit", "admin123" },
				{"sanket", "admin123" },
				{"Admin", "admin123" }
				};

	}
  
}
