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

public class Lms_Tc08_ContactScreen {
  
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
		
		WebElement element = driver.findElement(By.id("menu-item-1506"));
		element.click();
		
		//Check the title of the page
	    String title = driver.getTitle();

	    //Print the title of the page
	    System.out.println("Website title is: " + title);
	    
	    Assert.assertEquals("Contact – Alchemy LMS",title);
	    
	    ((JavascriptExecutor)driver).executeScript("scroll(0,850)");
	    
	    WebElement fullname = driver.findElement(By.id("wpforms-8-field_0"));
	    fullname.sendKeys("Anaveerappa");
	    
	    WebElement email = driver.findElement(By.id("wpforms-8-field_1"));
	    email.sendKeys("anaveerappam@gmail.com");
	    
	    WebElement subject = driver.findElement(By.id("wpforms-8-field_3"));
	    subject.sendKeys("LMSAutomation");
	    
	    WebElement comment = driver.findElement(By.id("wpforms-8-field_2"));
	    comment.sendKeys("Automation LMS");
	    
	    WebElement button = driver.findElement(By.className("wpforms-submit"));
	    button.click();
	    
	    String displayedmsg = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/section[4]/div[2]/div[2]/div[2]/div[2]/p")).getText();
	    
	    System.out.println("Displayed message is : "  + displayedmsg);
	    
	    Assert.assertEquals("Thanks for contacting us! We will be in touch with you shortly.",displayedmsg);
	    
	}
	
	@AfterMethod
	public void teardown() {
		
		//Close browser
        driver.close();
}
}