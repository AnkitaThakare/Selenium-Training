package com.orangehrm;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import java.util.Random;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Delete_AllUsers_With_SameName 
{
  
	ChromeDriver driver;
	@BeforeTest
	public void Login_HRM() {
		WebDriverManager.chromedriver().setup();
		// create Edge instance and maximize it
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.findElement(By.name("txtUsername")).sendKeys("Admin");
		driver.findElement(By.name("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		String ActElement = driver.findElement(By.linkText("Dashboard")).getText();
		String ExpElement = "Dashboard";
		Assert.assertEquals(ActElement, ExpElement);
		System.out.println(ActElement);
	}
	@AfterTest
	public void CloseBrowser()
	{
		driver.quit();
	}
	
	@Test(priority = 1)
	public void Employeelist() throws InterruptedException {
		WebElement Admin = driver.findElement(By.id("menu_admin_viewAdminModule"));
		Actions action = new Actions(driver);
		action.moveToElement(Admin).build().perform();
		WebElement user = driver.findElement(By.linkText("User Management"));
		action.moveToElement(user).build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'Users')]")).click();
	}
	@Test(priority = 2)
	public void Add_Employee() throws InterruptedException {
		driver.findElement("btnAdd").click();
		
		Select SelectPass = new Select(driver.findElements("systemUser_userType"));
		//SelectPass.selectByValue("1");
		//SelectPass.selectByIndex(0);
		SelectPass.selectByVisibleText("Admin");
		driver.findElements("systemUser_employeeName_empName").sendKeys("Fiona Grace");
		Random randomGenerator = new Random();
		int randomInt = randomGenerator.nextInt(1000);
		driver.findElement("systemUser_userName").sendKeys("Dixit" + randomInt);
		//String ExpUserName=driver.findElementById("systemUser_userName").getText();
		driver.findElement("systemUser_password").sendKeys("admin123");
		driver.findElement("systemUser_confirmPassword").sendKeys("admin123");
		Thread.sleep(5000);
		driver.findElement("btnSave").click();
		//Verify the Added User in WebTable
		Thread.sleep(2000);
		String ExpUserName = "Dixit" + randomInt;
		driver.navigate().refresh();
		Thread.sleep(2000);
		WebElement cellIneed = driver.findElement("//*[text()='"+ ExpUserName +"']");
		String ActualUserName = cellIneed.getText();
	    System.out.println("Cell value is : " + ActualUserName);
	    Assert.assertEquals(ExpUserName, ActualUserName);
	}
	@Test(priority = 3)
	public void Delete_Employees() throws InterruptedException {
		//*[@id="resultTable"]/tbody/tr[1]/td[2]
		 List<WebElement> rows=driver.findElements(By.xpath("//*[@id='resultTable']/tbody/tr"));
	        int rowsLength=rows.size();
	        System.out.println(rowsLength);
	       
	        ////*[@id='resultTable']/tbody/tr[]/td[2]
	       
	      //*[@id='resultTable']/tbody/tr[1]/td[2]
	       
		String beforXpath="//table[@id='resultTable']/tbody/tr[";
		String AfterXpath="]/td[2]";
		for(int i=1; i<=rowsLength;i++)
		{
			String name=driver.findElement(By.xpath(beforXpath + i + AfterXpath)).getText();
			System.out.println(name);
			if(name.toLowerCase().contains("dixit"))
			{
				driver.findElement(By.xpath("//*[@id='resultTable']/tbody/tr["+i+"]/td[1]/input")).click();
			}
		}
		Thread.sleep(5000);
		driver.findElement(By.id("btnDelete")).click();
		driver.findElement(By.id("dialogDeleteBtn")).click();
		String page_source = driver.getPageSource();
		//System.out.println(page_source);
		Assert.assertNotSame(page_source, "Admin");
	}
}
