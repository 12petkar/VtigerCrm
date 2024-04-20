package Vtiger;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtils.ExelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;
public class Opportunities {

WebDriverUtil wutil = new WebDriverUtil();
JavaUtil jutil = new JavaUtil();
ExelUtil eutil = new ExelUtil();
PropertyFileUtil putil = new PropertyFileUtil();

@Test

public void Opportunities () throws IOException, InterruptedException {
	
WebDriver driver = new ChromeDriver(); //lauch empty browsser

wutil.maximize(driver); //maximize the screen

//Read The Data Property File
String URL = putil.getDataPropertyFile("Url");
String UserName = putil.getDataPropertyFile("Username");
String Password = putil.getDataPropertyFile("Password");
wutil.implicitwait(driver); //appply the wait


driver.get(URL); //lauch the application

driver.findElement(By.name("user_name")).sendKeys(UserName); //enter the user name

driver.findElement(By.name("user_password")).sendKeys(Password); //eneter the password

driver.findElement(By.id("submitButton")).click(); //click on login btn

driver.findElement(By.partialLinkText("Opportunities")).click(); //click on opertunies

driver.findElement(By.xpath("//img[@alt='Create Opportunity...']")).click(); //click on pulush (+)btn

//To Read data Exel File

String OperName = eutil.getDataFromExcel("Sheet1", 0, 1);
String ReletedTo = eutil.getDataFromExcel("Sheet1", 1, 1);
String Drop = eutil.getDataFromExcel("Sheet1", 2, 1);
String salesDrop = eutil.getDataFromExcel("Sheet1", 3, 1);

driver.findElement(By.name("potentialname")).sendKeys(OperName); //Enter the name
Thread.sleep(2000);
driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click(); //click on (+) btn

Set<String> ids = driver.getWindowHandles();

System.out.println(ids);

for(String a : ids) {
	
	String ChildWindow = driver.switchTo().window(a).getCurrentUrl();
  
	String ChildUrl = "http://localhost:8888/index.php?module=Accounts&action=Popup&html=Popup_picker&form=vtlibPopupView&forfield=related_to&srcmodule=Potentials&forrecord=";

	if(ChildWindow.contains(ChildUrl)) {
		
		break;
		
		
	}
}


driver.findElement(By.id("search_txt")).sendKeys(ReletedTo);

driver.findElement(By.name("search")).click();

driver.findElement(By.xpath("(//a[contains(text(),'AtosSyntel')])[2]")).click();
Thread.sleep(2000);

for(String b : ids) {
	
	String ParentWindow = driver.switchTo().window(b).getCurrentUrl();

String ParentUrl = "http://localhost:8888/index.php?module=Potentials&action=EditView&return_action=DetailView&parenttab=Sales";

if(ParentWindow.contains(ParentUrl)) {
	break;
}

}


TakesScreenshot ts = (TakesScreenshot) driver;
Thread.sleep(2000);
File tempfile = ts.getScreenshotAs(OutputType.FILE);

//File destinationfile =new File("./Vip/Screenshot.png");
File Filedestination = new File("./Skillary/Homepage.png");
FileUtils.copyFile(tempfile, Filedestination);


 driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
 
 WebElement dropdown = driver.findElement(By.name("assigned_group_id"));

wutil.handledropdown(dropdown, Drop);



WebElement dropdowns = driver.findElement(By.name("sales_stage"));

wutil.handledropdown(dropdowns, salesDrop);







}
}
