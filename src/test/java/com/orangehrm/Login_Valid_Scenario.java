package com.orangehrm;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.edge.EdgeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login_Valid_Scenario 
{

	@Test
	public void loginvalidscenario() throws InterruptedException 
	{
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	    driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	    driver.findElement(By.name("txtPassword")).sendKeys("admin123");
	    driver.findElement(By.name("Submit")).click();
	    driver.findElement(By.linkText("Dashboard")).isDisplayed();
	    driver.findElement(By.id("welcome")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText("Logout")).click();
	    driver.findElement(By.id("divLogo")).isDisplayed();
	    
	    driver.quit();
	}

}
