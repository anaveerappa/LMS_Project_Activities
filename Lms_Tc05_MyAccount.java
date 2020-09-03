package lms_testng;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Lms_Tc05_MyAccount {
  
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
		
		driver.navigate().to("https://alchemy.hguy.co/lms/my-account/");
		
		//Check the My account title of the page
        String title = driver.getTitle();
	
        //Print the title of the page
        System.out.println("My account title of the page: " + title);
        
        Assert.assertEquals("My Account – Alchemy LMS",title);
		
	}
	
	@AfterMethod
	public void teardown() {
		
		//Close browser
        driver.close();
}
}