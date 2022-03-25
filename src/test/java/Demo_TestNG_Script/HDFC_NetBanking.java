package Demo_TestNG_Script;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class HDFC_NetBanking 
{
	// Global Declaration

		 ChromeDriver driver;
		 
	//  Local Variable
		 
		 
		 
  @Test
  public void Login_Page() throws InterruptedException 
  {
	  
	 
	  //driver.findElement(By.id(" Welcome to HDFC Bank NetBanking "));
	  driver.switchTo().frame("login_page");
	  //driver.findElement(By.className("Customer ID/ User ID")); 
	  driver.findElement(By.name("fldLoginUserId")).sendKeys("1000");
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[text()=\"CONTINUE\"]")).click();
	 //driver.findElement(By.linkText("Login to NetBanking"));
	  Thread.sleep(2000);
	 // String AlertText = driver.switchTo().alert().getText();
	  //String ExpAlertMsg = "Customer ID  cannot be left blank.";
//	  driver.switchTo().frame(0);
//	  String getText = driver.findElement(By.xpath("//div[text()=\"Login to NetBanking\"]")).getText();
//	  Thread.sleep(2000);
//	  String ExpAlertMsg = "Login to NetBanking";
//	  Assert.assertEquals(getText, ExpAlertMsg);
	  //driver.switchTo().alert().accept();
  }
  @BeforeTest
  public void beforeTest() 
  {
	  //Download chromeDriver at run time
      WebDriverManager.chromedriver().setup();
	  //Download edgeDriver at run time
      //WebDriverManager.edgedriver().setup();
      //EdgeDriver driver = new EdgeDriver();
	   driver = new ChromeDriver();
		//driver = new EdgeDriver();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
  }

  @AfterTest
  public void afterTest() 
  {
	//Close browser
	  driver.quit();
  }

}
