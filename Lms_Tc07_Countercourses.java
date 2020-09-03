package lms_testng;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Lms_Tc07_Countercourses {
  
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
		
		driver.navigate().to("https://alchemy.hguy.co/lms/all-courses/");
		
		//Check the My account title of the page
        String title = driver.getTitle();
	
        //Print the title of the page
        System.out.println("My account title of the page: " + title);
        
        Assert.assertEquals("All Courses – Alchemy LMS",title);
        
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        
       
        List<WebElement> links = driver.findElements(By.className("entry-title"));    //Identify the number of Link on webpage and assign into Webelement List 
        
        int linkCount = links.size();     // Count the total Link list on Web Page
        
        System.out.println("Total Number of courses on webpage = "  + linkCount);
        
        for (WebElement obkCurrentLink : links) {
        	
        	String strLinkText = obkCurrentLink.getText();
        	
        	System.out.println(strLinkText);
        }
	}
        @AfterMethod
    	public void teardown() {
    		
    		//Close browser
            driver.close();
	}
}
