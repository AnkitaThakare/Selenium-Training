package com.orangehrm;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class JavaScript_Alerts 
{
	// Global Declaration
	ChromeDriver driver;
	
	
	@Test (priority=1)
	public void JS_Alert() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[@onclick='jsAlert()']")).click();
		//a[normalize-space()='CONTINUE']
		Thread.sleep(2000);
		String AlertText = driver.switchTo().alert().getText();
		String ExpText = "I am a JS Alert";
		Assert.assertEquals(AlertText, ExpText);
		driver.switchTo().alert().accept();
		String ResultText = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String ExpResultText = "You successfully clicked an alert";
		Assert.assertEquals(ResultText, ExpResultText);
	
	}
	
	@Test(priority=2)
	public void JS_Confirm() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
		//a[normalize-space()='CONTINUE']
		Thread.sleep(2000);
		String AlertText = driver.switchTo().alert().getText();
		String ExpText = "I am a JS Confirm";
		Assert.assertEquals(AlertText, ExpText);
		driver.switchTo().alert().dismiss();
		String ResultText = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String ExpResultText = "You clicked: Cancel";
		Assert.assertEquals(ResultText, ExpResultText);
	
	}
	
	@Test(priority=3)
	public void JS_Prompt() throws InterruptedException {
		
		driver.findElement(By.xpath("//button[@onclick='jsPrompt()']")).click();
		//a[normalize-space()='CONTINUE']
		Thread.sleep(2000);
		String AlertText = driver.switchTo().alert().getText();
		String ExpText = "I am a JS prompt";
		Assert.assertEquals(AlertText, ExpText);
		driver.switchTo().alert().sendKeys("Selenium");
		Thread.sleep(2000);
		driver.switchTo().alert().accept();
		String ResultText = driver.findElement(By.xpath("//p[@id='result']")).getText();
		String ExpResultText = "You entered: Selenium";
		Assert.assertEquals(ResultText, ExpResultText);
	
	}
	
	@BeforeTest
	public void LaunchBrowser() {
		// Download ChromeDriver at run time
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	}
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
}
