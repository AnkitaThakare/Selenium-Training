package Demo_TestNG_Script;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterTest;

public class NewTest 
{
	//Global Declaration
     ChromeDriver driver;
	  //EdgeDriver driver;
	
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
			driver.get("https://opensource-demo.orangehrmlive.com/index.php/dashboard");
	  }
	
  @Test
  public void Login() 
  {
	  
	    driver.findElement(By.name("txtUsername")).sendKeys("Admin");
	    driver.findElement(By.name("txtPassword")).sendKeys("admin123");
	    driver.findElement(By.id("btnLogin")).click();
	    driver.findElement(By.linkText("Dashboard")).isDisplayed();
  }
  
  @Test
  public void Logout() throws InterruptedException
		  
  {
	    driver.findElement(By.id("welcome")).click();
	    Thread.sleep(5000);
	    driver.findElement(By.linkText("Logout")).click();
	    driver.findElement(By.id("divLogo")).isDisplayed();
  }
  
  

  @AfterTest
  public void afterTest() 
  {
	//Close browser
	  driver.quit();
  }

}
