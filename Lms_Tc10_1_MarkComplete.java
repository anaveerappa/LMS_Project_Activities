package lms_testng;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Lms_Tc10_1_MarkComplete {
	
		WebDriver driver;//Navigate to page
			@BeforeTest
			public void beforeMethod() {
				System.setProperty("webdriver.gecko.driver","C:\\Windows\\System32\\geckodriver.exe");
			driver = new FirefoxDriver();
			//System.setProperty("webdriver.gecko.driver","C:\\Windows\\System32\\geckodriver.exe");
		     driver.get("https://alchemy.hguy.co/lms/");
			}	
		//My Account Login
			  @Test
			    public void testcase() {
			driver.findElement(By.linkText("My Account")).click();
		    driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div[2]/div[2]/div[2]/a")).click();
		    driver.findElement(By.id("user_login")).sendKeys("root");
			driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
			driver.findElement(By.id("wp-submit")).click();
			
			
		 //Go to course page
			    //driver.findElement(By.linkText("All Courses")).click();
			driver.navigate().to("https://alchemy.hguy.co/lms/all-courses/");
			   
			//Select course
			    driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div/div/div/div[2]/article/div[2]/p[2]/a")).click();
			 
			//click lesson
			    driver.findElement(By.className("ld-item-title")).click();
			 
			//page title
			    System.out.println("course title:  " + driver.getTitle());
			    Assert.assertEquals(driver.getTitle(), "Deliverability Of Your Emails – Alchemy LMS");
			   
			//open topic and mark complete
			    driver.findElement(By.className("ld-lesson-title")).click();
			    //driver.findElement(By.className("learndash_mark_complete_button")).click();
			   
			  }	     
			 
		//close the browser
			  @AfterTest
				public void afterMethod() {
				driver.close();
				
		}
		
  }

