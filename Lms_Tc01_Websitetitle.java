package lms_testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


    
    public class Lms_Tc01_Websitetitle {
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
	
	//Checking the title of the LMS web site
	@Test
	public void Websitetitlepage() {
		
        //Check the title of the page
        String title = driver.getTitle();
	
        //Print the title of the page
        System.out.println("Website title is: " + title);
        
        Assert.assertEquals("Alchemy LMS – An LMS Application",title);
        
	}
	
	//Closing the browser
	@AfterMethod
	public void CloseBrowser() {
		
		//Close browser
        driver.close();
	}
	
}
