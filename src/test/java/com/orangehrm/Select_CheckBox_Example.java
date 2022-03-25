package com.orangehrm;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Select_CheckBox_Example 
{
  
	WebDriver driver;
	  @Test(priority=1,description="Login to OrangeHRM with valid credentials")
	  public void Login() throws InterruptedException 
	  {
		  driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
			driver.findElement(By.name("txtUsername")).sendKeys("Admin");
			driver.findElement(By.name("txtPassword")).sendKeys("admin123");
			//driver.findElement(By.name("txtPassword")).sendKeys("admin123");
			driver.findElement(By.id("btnLogin")).click();
			// Verify that Dashboard page displayed
			String ActElement = driver.findElement(By.linkText("Dashboard")).getText();
			String ExpElement = "Dashboard";
			Assert.assertEquals(ActElement, ExpElement);
			System.out.println(ActElement);
	  }
	  @Test(priority=2)
	  public void Leave() throws InterruptedException
	  {
		  driver.findElement(By.linkText("Leave")).click();
		  driver.findElement(By.cssSelector(".toggle.tiptip")).isDisplayed();
		  driver.findElement(By.id("leaveList_cmbWithTerminated")).click();
		  Thread.sleep(5000);
	  }
	 
	 
	  @Test(priority=3,description="Logout from OrangeHRM")
	  public void Logout() throws InterruptedException 
	  {
		 
			driver.findElement(By.xpath("//a[contains(text(),'Welcome')]")).click();
			Thread.sleep(3000);
			driver.findElement(By.linkText("Logout")).click();
			driver.findElement(By.id("logInPanelHeading")).isDisplayed();
	  }
	 
	  @BeforeTest
	  public void LaunchBrowser() 
	  {
		  	WebDriverManager.chromedriver().setup();
			// WebDriverManager.firefoxdriver().setup();
			//WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();
			//driver = new EdgeDriver();
			driver.manage().window().maximize();
	  }
	  @AfterTest
	  public void CloseBrowser()
	  {
			// driver.close();//Close will close only current chrome browser
			driver.quit();
	  }
	
}
