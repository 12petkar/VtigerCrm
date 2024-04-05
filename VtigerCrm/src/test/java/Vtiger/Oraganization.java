package Vtiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtils.ExelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class Oraganization {

PropertyFileUtil putil = new PropertyFileUtil();

JavaUtil jutil = new JavaUtil();

WebDriverUtil wutil = new WebDriverUtil();

ExelUtil eutil = new ExelUtil();

@Test

public void OraganizationTest() throws IOException, InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	
	wutil.maximize(driver);   // maximize the screen
	wutil.implicitwait(driver);  // To apply Wait
	
	// To read the data from property file
	String URL = putil.getDataPropertyFile("Url"); // To read the data from property file
    String UserName = putil.getDataPropertyFile("Username");
    String PASSWORD = putil.getDataPropertyFile("Password");
	
    //Login To ApplicTION
    
    driver.get(URL);
    
    driver.findElement(By.name("user_name")).sendKeys(UserName); // Enter The user Name of Tf
    Thread.sleep(2000);
   driver.findElement(By.name("user_password")).sendKeys(PASSWORD); // Enter The Password of Tf
   
   driver.findElement(By.id("submitButton")).click(); // Click on Login btn
   
   driver.findElement(By.partialLinkText("Organizations")).click(); //click on Organizations
   
   driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click(); //Click on plush..btn(+)
   
   //To  Reading the Data From Exel file
   
   String ORG = eutil.getDataFromExcel("Organization", 0, 1);
    String GROUP = eutil.getDataFromExcel("Organization", 1, 1);

driver.findElement(By.name("accountname")).sendKeys(ORG+jutil.getRandomNumber()); //Enter the Org name

driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click(); //click on group radio btn
Thread.sleep(2000);
WebElement Dropdown = driver.findElement(By.name("assigned_group_id")); // click on Support Group

wutil.handledropdown(Dropdown, GROUP);


wutil.screenshot(driver, GROUP); //click on screenshot

driver.findElement(By.xpath("(//input[@name='button'])[1]")).click(); // click on save btn
Thread.sleep(2000);
WebElement img = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")); //mouse hover on sign img
Thread.sleep(2000);
wutil.mousehover(driver, img);

driver.findElement(By.xpath("//a[text()='Sign Out']")).click(); //click on signout btn



 




}
}
