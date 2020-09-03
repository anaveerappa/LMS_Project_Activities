package lms_testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Lms_Tc06_MyAccountLogin {
  
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
		
		//WebElement element = driver.findElement(ByLinkText("My Account"));
		// element.click();
		
		//Check the My account title of the page
        String title = driver.getTitle();
	
        //Print the title of the page
        System.out.println("My account title of the page: " + title);
        
        Assert.assertEquals("My Account – Alchemy LMS",title);
        
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        
        WebElement element = driver.findElement(By.linkText("Login"));
        
        element.click();
        
        //Entering username and password
        
        WebElement username = driver.findElement(By.id("user_login"));
        username.sendKeys("root");
        
        WebElement password = driver.findElement(By.id("user_pass"));
        password.sendKeys("pa$$w0rd");
        
        WebElement button = driver.findElement(By.xpath("//*[@id=\"wp-submit\"]"));
        button.click();
        
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        
	}

	@AfterMethod
	public void teardown() {
		
		//Close browser
        driver.close();
}
}