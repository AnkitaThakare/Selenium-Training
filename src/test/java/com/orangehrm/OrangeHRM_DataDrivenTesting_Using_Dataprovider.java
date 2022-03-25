package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHRM_DataDrivenTesting_Using_Dataprovider extends ApplicationTestData
{
	// Global Declaration
		ChromeDriver driver;

		@Test (dataProvider = "Login")
		public void Login_Valid_Scenario() throws InterruptedException {

			driver.findElement(By.name("txtUsername")).sendKeys();
			driver.findElement(By.name("txtPassword")).sendKeys();
			driver.findElement(By.id("btnLogin")).click();
			driver.findElement(By.linkText("Dashboard")).isDisplayed();
			driver.findElement(By.partialLinkText("Welcome")).click();
			Thread.sleep(2000);
			driver.findElement(By.linkText("Logout")).click();
			driver.findElement(By.id("btnLogin")).isDisplayed();
		}

		@BeforeTest
		public void LaunchBrowser() {
			// Download ChromeDriver at run time
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		}

		@AfterTest
		public void CloseBrowser() {
			driver.quit();
		}
}
