package Vtiger;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import org.yaml.snakeyaml.events.Event.ID;

import CommonUtils.ExelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class Org {


	ExelUtil eutil = new ExelUtil();
	JavaUtil jutil = new JavaUtil();
	PropertyFileUtil putil= new PropertyFileUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	
@Test

public void org() throws IOException, InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	
	wutil.maximize(driver);
	
	//Read the data property file
	String URL = putil.getDataPropertyFile("Url");
	
    String username = putil.getDataPropertyFile("Username");
        
	String password = putil.getDataPropertyFile("Password");
	
	driver.get(URL);
	
	
	driver.findElement(By.name("user_name")).sendKeys(username);

	
	driver.findElement(By.name("user_password")).sendKeys(password);
	
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.partialLinkText("Organizations")).click();
	
	driver.findElement(By.cssSelector("img[alt='Create Organization...']")).click();
	wutil.implicitwait(driver);
	
	String org = eutil.getDataFromExcel("Sheet1", 0, 1);
	
	String Drop = eutil.getDataFromExcel("Sheet1", 1, 1);
	
	driver.findElement(By.name("accountname")).sendKeys(org+jutil.getRandomNumber());
	
	driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
	
	WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
	
	wutil.handledropdown(dropdown, Drop);
	
	
	driver.findElement(By.xpath("(//input[@name='button'])[1]")).click();
	
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	
	File tempfile = ts.getScreenshotAs(OutputType.FILE);
	
	File fileDestination = new File("./Radhe/Screenshot.png");
	
	FileUtils.copyFile(tempfile, fileDestination);
	
	Thread.sleep(2000);
	WebElement mousehover = driver.findElement(By.cssSelector("img[src='themes/softed/images/user.PNG']"));
	Thread.sleep(2000);
	wutil.mousehover(driver, mousehover);
	
	driver.findElement(By.partialLinkText("Sign Out")).click();
	
	
	
	
	
	
	
	
	
	
}


}
