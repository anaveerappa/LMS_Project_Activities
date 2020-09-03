package lms_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Lms_Tc02_Websiteheading {
  
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
	
//Checking the web site heading of web page	
	     @Test
	     public void WebsiteHeadingtitle() {
	    		
	    		//((JavascriptExecutor)driver).executeScript("scroll(0,400)");
	    		
	    		//Print heading of the web page
	    	    WebElement element = driver.findElement(By.cssSelector("h1.uagb-ifb-title"));
	    	    String heading = element.getText();
	    	    
	    	    System.out.println("heading of the webpage: " + heading);
	    	    
	    	    Assert.assertEquals("Learn from Industry Experts",heading);
	 }
	     
	     @AfterMethod
	 	public void CloseBrowser() {
	 		
	 		//Close browser
	         driver.close();
}
}
