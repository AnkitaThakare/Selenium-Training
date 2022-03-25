package Demo_TestNG_Script;

import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.testng.annotations.BeforeTest;
import static org.testng.Assert.assertEquals;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class Verify_Navigation_Command 
{
	// Global Declaration
	ChromeDriver driver;
	
	@Test
	public void ClickForJSAlert() throws InterruptedException 
	{
		// driver.switchTo().frame(0);
		// driver.findElement(By.xpath("//div[@class=\"netwrapper\"]/div[2]/div[1]/div[2]/input[@name=\"fldLoginUserId\"]")).sendKeys("1000");
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=\"Click for JS Alert\"]")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		String actAlertText = driver.findElement(By.xpath("//p[text()=\"You successfully clicked an alert\"]")).getText();
		System.out.println(actAlertText);
		String expAlertRslt = "You successfully clicked an alert";
		assertEquals(actAlertText, expAlertRslt);
	}
	
	@Test
	public void ClickForJSConfirm() throws InterruptedException 
	{
		// driver.switchTo().frame(0);
		// driver.findElement(By.xpath("//div[@class=\"netwrapper\"]/div[2]/div[1]/div[2]/input[@name=\"fldLoginUserId\"]")).sendKeys("1000");
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=\"Click for JS Confirm\"]")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().dismiss();
		String actAlertText = driver.findElement(By.xpath("//p[text()=\"You clicked: Cancel\"]")).getText();
		System.out.println(actAlertText);
		String expAlertRslt = "You clicked: Cancel";
		assertEquals(actAlertText, expAlertRslt);
		// driver.switchTo().alert().accept();
	}
	
	@Test
	public void ClickForJSPrompt() throws InterruptedException 
	{
		// driver.switchTo().frame(0);
		// driver.findElement(By.xpath("//div[@class=\"netwrapper\"]/div[2]/div[1]/div[2]/input[@name=\"fldLoginUserId\"]")).sendKeys("1000");
		// Thread.sleep(2000);
		driver.findElement(By.xpath("//button[text()=\"Click for JS Prompt\"]")).click();
		Thread.sleep(3000);
		driver.switchTo().alert().sendKeys("Selenium");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		String actAlertText = driver.findElement(By.xpath("//p[text()=\"You entered: Selenium\"]")).getText();
		System.out.println(actAlertText);
		String expAlertRslt = "You entered: Selenium";
		assertEquals(actAlertText, expAlertRslt);
		// driver.switchTo().alert().accept();
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
			driver.get("https://the-internet.herokuapp.com/javascript_alerts");
	  }

	  @AfterTest
	  public void afterTest() 
	  {
		//Close browser
		  driver.quit();
	  }
}
