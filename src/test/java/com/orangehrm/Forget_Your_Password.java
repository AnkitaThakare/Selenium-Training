package com.orangehrm;

//import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Forget_Your_Password 
{

	@Test
	public void forgetyourpassword()  
	{
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
		driver.findElement(By.linkText("Forgot your password?"));
		driver.findElement(By.name("securityAuthentication[userName]")).sendKeys("admin123");
		driver.findElement(By.name("button")).click();
		
		
	}

}
