package Vtiger;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtils.ExelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class FromInformation {

	
	JavaUtil jutil = new JavaUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	PropertyFileUtil putil = new PropertyFileUtil();
	ExelUtil eutil = new ExelUtil();

@Test

public void from() throws EncryptedDocumentException, IOException {
	
	WebDriver driver = new ChromeDriver();
  
	wutil.maximize(driver);
	wutil.implicitwait(driver);
	driver.get("https://demoqa.com/automation-practice-form");
    String FName = eutil.getDataFromExcel("Sheet1", 0, 1);
    String email = eutil.getDataFromExcel("Sheet1", 1, 1);
   String mobilenumber = eutil.getDataFromExcel("Sheet1", 2, 1);


   
   driver.findElement(By.id("firstName")).sendKeys(FName);



}



}
