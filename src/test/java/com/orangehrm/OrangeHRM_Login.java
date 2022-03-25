package com.orangehrm;

//import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.By;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_Login 
{

	@Test
	public void Login_Valid_Scenario() throws InterruptedException 
	{
		//Download ChromeDriver at run time
		//WebDriverManager.chromedriver().setup();
		WebDriverManager.edgedriver().setup();
		EdgeDriver driver = new EdgeDriver();
		//ChromeDriver driver = new ChromeDriver();
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
