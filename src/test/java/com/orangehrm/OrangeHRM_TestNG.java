package com.orangehrm;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class OrangeHRM_TestNG 
{
	//Global Declaration
	ChromeDriver driver;
	
  @Test
  public void Login_Valid_Scenario()
  {
	    
	    driver.findElement(By.name("txtUsername")).sendKeys("dixit");
	    driver.findElement(By.name("txtPassword")).sendKeys("admin123");
	    driver.findElement(By.id("btnLogin")).isDisplayed();
	    driver.findElement(By.linkText("Dashboard")).isDisplayed();
  }
  
  @Test
  public void Logout_Valid_Scenario() throws InterruptedException
  {
	    driver.findElement(By.id("welcome")).click();
	    Thread.sleep(2000);
	    driver.findElement(By.linkText("Logout")).click();
	    driver.findElement(By.id("divLogo")).isDisplayed();
  }
  @BeforeTest
  public void Launchbrowser()
  {
          //Download chromeDriver at run time
			WebDriverManager.chromedriver().setup();
          //WebDriverManager.edgedriver().setup();
          //EdgeDriver driver = new EdgeDriver();
			driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
  }

  @AfterTest
  public void Closebrowser() 
  {
     //Close browser
	  driver.quit();
  }

}
