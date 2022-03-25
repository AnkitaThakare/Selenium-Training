package com.orangehrm;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Web_Order_E2E_Scenario 
{

	private static final String ExpName = null;
	private static final String UpdateName = null;
	ChromeDriver driver;
	@BeforeTest
	public void LaunchBrowser()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://secure.smartbearsoftware.com/samples/TestComplete11/WebOrders/Login.aspx?ReturnUrl=%2fsamples%2fTestComplete11%2fWebOrders%2fDefault.aspx");
	}
	
  @Test(priority=1)
  public void Login_WebOrder() throws InterruptedException
  {
	    driver.findElement(By.name("ctl00$MainContent$username")).sendKeys("Tester");
	    driver.findElement(By.name("ctl00$MainContent$password")).sendKeys("test");
	    driver.findElement(By.name("ctl00$MainContent$login_button")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.xpath("(//h1[normalize-space()='Web Orders'][1]")).isDisplayed();
  }
  
//  @Test(priority = 1)
//	public void Login_WebOrder() throws InterruptedException
//	{
//		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']")).sendKeys("Tester");
//		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']")).sendKeys("test");
//		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_login_button']")).click();
//	}
	@Test(priority = 2)
	public void CreateOrder_UpdateOrder_DeleteOrder() throws InterruptedException
	{
		
		// Click on Create Order Link
		driver.findElement(By.linkText("Order")).click();
		// Verify Order Page is displayed
		driver.findElement(By.xpath("//h2[normalize-space()='Order']")).isDisplayed();
		// Fill mandatory fields on Create order Page
		Select product = new Select(driver.findElement(By.id("ctl00_MainContent_fmwOrder_ddlProduct")));
		product.selectByVisibleText("MyMoney");
		driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']")).sendKeys("3");
		
		/*
		int Qty = 3;
		int Price_Per_Unit = 100;
		int Result = Qty * Price_Per_Unit;
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).click();
		String str =  driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtTotal")).getText();
		int total = 0;
		try
		{
		 total = Integer.parseInt(str);
		}
      catch (NumberFormatException ex){
          ex.printStackTrace();
      }
		Assert.assertEquals(Result,total);*/
		
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Ankita");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys("MG Road");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys("Pune");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys("Maharastra");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys("416406");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_cardList_0")).click();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys("1234567890");
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("11/20");
		driver.findElement(By.xpath("//a[text() = 'Process']")).click();
		driver.findElement(By.xpath("//strong[normalize-space()='New order has been successfully added.']")).isDisplayed();
		driver.findElement(By.xpath("//a[text() = 'View all orders']")).click();
		// Verify new created order is displayed on List of All Order Page
		driver.findElement(By.xpath("//h2[normalize-space()='List of All Orders']")).isDisplayed();
		String ExpName = "Ankita";
		Thread.sleep(2000);
		String ActName = driver.findElement(By.xpath("//td[text() = '" + ExpName + "']")).getText();
		Assert.assertEquals(ActName, ExpName);
	}
	// Update order
	@Test(priority = 3,alwaysRun = true)
	public void Update_Order() throws InterruptedException
	{
		//Select Updated order on List of All Order Page
		driver.findElement(By.xpath("//td[text() = '" + ExpName + "']//following-sibling::td/input[@alt = 'Edit']")).click();
		
		//Verify Edit order Page is displayed and clear Previous value and update new value
		driver.findElement(By.xpath("//h2[normalize-space()='Edit Order']")).isDisplayed();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).clear();
		driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys("Ankita1");
		driver.findElement(By.xpath("//a[text() = 'Update']")).click();
		driver.findElement(By.xpath("//a[text() = 'View all orders']")).click();
		String UpdateName = "Ankita1";
		Thread.sleep(5000);
		
		// Verify updated order is displayed on List of All Order Page
		String UpdActName = driver.findElement(By.xpath("//td[text() = '" + UpdateName + "']")).getText();
		Assert.assertEquals(UpdActName, UpdateName);
	}
	// Delete Order
	@Test(priority = 4)
	public void Delet_order() throws InterruptedException
	{
		driver.findElement(By.xpath("//td[text() = '" + UpdateName + "']//preceding-sibling::td/input")).click();
		driver.findElement(By.id("ctl00_MainContent_btnDelete")).click();
		Thread.sleep(5000);
		// Verify Selected Order is deleted and not displayed on List of All Order Page
		Boolean deleteduser = driver.getPageSource().contains(UpdateName);
		Assert.assertFalse(deleteduser);
	}
	@AfterTest
	public void CloseBrowser() {
		driver.quit();
	}
	
}
