package lms_testng;


import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Lms_Tc14_Actions_Entirecoursecomplete {
	WebDriver driver;
	Actions actions;
	
	@BeforeMethod
	public void setup() {
		  System.setProperty("webdriver.gecko.driver","C:\\Windows\\System32\\geckodriver.exe");
		  driver = new FirefoxDriver();
		     driver.get("https://alchemy.hguy.co/lms/");
		   //Resize current window to the set dimension
		     driver.manage().window().maximize();
		     driver.manage().timeouts().implicitlyWait(20000, TimeUnit.MILLISECONDS);
	 	}	
	@Test
	public void Openpage() throws InterruptedException {
		driver.findElement(By.linkText("My Account")).click();
		driver.findElement(By.xpath("/html/body/div[1]/div/div/div/main/article/div/section[2]/div[2]/div[2]/div[2]/div[2]/a")).click();
		driver.findElement(By.id("user_login")).sendKeys("root");
		driver.findElement(By.id("user_pass")).sendKeys("pa$$w0rd");
		driver.findElement(By.id("wp-submit")).click();
		
		//WebElement course = driver.findElement(By.xpath("/html/body/div[1]/header/div/div/div/div/div[3]/div/nav/div/ul/li[2]/a"));
		//actions.click(course).perform();
		
		
			WebElement linkt;
			linkt = driver.findElement(By.linkText("All Courses"));
			linkt.sendKeys(Keys.ENTER);
			
			List<WebElement> courses = driver.findElements(By.className("entry-title"));
			System.out.println("Number of Courses are : " + courses.size());
			
			
			System.out.println("Selecting the First course");
			WebElement seemore;
			seemore = driver.findElement(By.xpath("//a[@class='btn btn-primary']"));
			seemore.sendKeys(Keys.ENTER);
			JavascriptExecutor js = ((JavascriptExecutor) driver);
			js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			WebElement topic;
			topic=driver.findElement(By.xpath("//span[@class='ld-icon-arrow-down ld-icon']"));
			topic.click();
			
			JavascriptExecutor js1 = ((JavascriptExecutor) driver);
			js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			//driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			Thread.sleep(5000);
			
			WebElement les;
			les = driver.findElement(By.xpath("//a[@class='ld-table-list-item-preview ld-primary-color-hover ld-topic-row learndash-incomplete ']"));
			boolean sel = les.isEnabled();
			System.out.println(sel);
			les.sendKeys(Keys.ENTER);
			
			JavascriptExecutor js2 = ((JavascriptExecutor) driver);
			js2.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			Thread.sleep(5000);
					
			WebElement markc;
			markc = driver.findElement(By.xpath("//input[@type='submit']"));
			markc.click();
			
						
			js1.executeScript("window.scrollTo(0, document.body.scrollHeight)");
			
			Thread.sleep(5000);
			
			WebElement prog;
			prog = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[1]/div[3]/div/div[1]/div/div[1]"));
			System.out.println("The progress is :" +prog.getText());
			
			
			
		 //TakesScreenshot scrShot =((TakesScreenshot)driver);
	     // String timeStamp;
	      //timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());

	        //Call getScreenshotAs method to create image file

	                //File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	            //Move image file to new destination

	                //File DestFile=new File("src/test/resources/"+timeStamp+".jpg");

	                //Copy file at destination

	                //FileUtils.copyFile(SrcFile, DestFile);	
			
			
		    				
		}
		
		
		
	}
	
	


