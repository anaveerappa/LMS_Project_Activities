package lms_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Lms_Tc04_Secpopularcourse {
  
	 WebDriver driver;
	 @BeforeMethod             
	  public void setup() {
	 	 
	 	 System.setProperty("webdriver.gecko.driver","C:\\Windows\\System32\\geckodriver.exe");
	 	 driver = new FirefoxDriver();
	 		
	 		//Open browser
	      driver.get("https://alchemy.hguy.co/lms");
	      
	      //Resize current window to the set dimension
	      driver.manage().window().maximize();
	 	  
	  }

	 @Test
	 public void Openpage() {
	 	
	 	((JavascriptExecutor)driver).executeScript("scroll(0,900)");
	 	
	 	//Print title of the second of the web page
	 	WebElement element = driver.findElement(By.cssSelector("#post-71 > div:nth-child(3) > h3:nth-child(1)"));
	    String heading = element.getText();
	    
	    System.out.println("title of the second of the web page: " + heading);
	    
	    Assert.assertEquals("Email Marketing Strategies",heading);
	 	
	 }
	 
	 @AfterMethod
		public void teardown() {
			
			//Close browser
	        driver.close();
}
}
