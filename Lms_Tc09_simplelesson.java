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

public class Lms_Tc09_simplelesson {
  
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
        
        WebElement courselink = driver.findElement(By.xpath("/html/body/div/div/div/div/main/article/div/section[2]/div[2]/div/div/div/div[1]/article/a/img"));
        courselink.click();
        
        ((JavascriptExecutor)driver).executeScript("scroll(0,400)");
        
        WebElement Loginbtn = driver.findElement(By.className("ld-button"));
        Loginbtn.click();
        
        //Login details to navigate courses
        
        WebElement username = driver.findElement(By.id("user_login"));
        username.sendKeys("root");
        
        WebElement password = driver.findElement(By.id("user_pass"));
        password.sendKeys("pa$$w0rd");
        
        WebElement Login = driver.findElement(By.id("wp-submit"));
        Login.click();
        
        ((JavascriptExecutor)driver).executeScript("scroll(0,900)");
        
        WebElement content = driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/div/div/div/div[3]/div[2]/div[1]/div[1]/a/div[2]"));
        content.click();
        
        WebElement coursetitle = driver.findElement(By.cssSelector("#ld-focus-mode-course-heading"));
        String coursename =coursetitle.getText();
        
        //Print the course title of the page
        System.out.println("course title is: " + coursename);
       
        
        
}
	
	@AfterMethod
	public void teardown() {
		
		//Close browser
        driver.close();
}
	
}