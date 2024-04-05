package BasicDataDrivenTesting;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import CommonUtils.ExelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;
import POM.HomePage;
import POM.LoginPage;
import POM.OrganizationInformationPage;

public class BasePage {


public static void main(String[] args) throws IOException, InterruptedException {

	WebDriver driver = new ChromeDriver(); //Create object Webdriver (upcasting0
	
	 

	
	PropertyFileUtil putil = new PropertyFileUtil();
	
	ExelUtil eutil = new ExelUtil();
	
	JavaUtil jutil = new JavaUtil();
	
	WebDriverUtil wutil = new WebDriverUtil();
	
	
  String URL = putil.getDataPropertyFile("Url");
  
   String UserName = putil.getDataPropertyFile("Username");
   
   String Password = putil.getDataPropertyFile("Password");
   
   wutil.maximize(driver); //maximize screen
   
   wutil.implicitwait(driver); //apply wait
   
   driver.get(URL); //Lauch Url
   
 
   LoginPage lp = new LoginPage(); //create object LoginPage
	
   PageFactory.initElements(driver, lp); //Initialize
  
   lp.getUserName().sendKeys(UserName); //enter name tf
  
   lp.getPassword().sendKeys(Password); //enter password tf
  
   lp.getSubmitbtn().click(); //click on submit btn
   
   
   
   HomePage hp = new HomePage(); //create object HomePage
   PageFactory.initElements(driver, hp); //Initialize
 
   hp.getOrganization().click(); //click on Oragization
  Thread.sleep(200); 
  hp.getImg().click(); //click on plush btn..(+)
  
  //To Read data from Exel
  
 String ORgName = eutil.getDataFromExcel("Organization", 0, 1);
 String Group = eutil.getDataFromExcel("Organization", 1, 1);
 
 
 OrganizationInformationPage oip = new OrganizationInformationPage();
 
 PageFactory.initElements(driver, oip); //Initialize
                 
   oip.getOraganizationnametf().sendKeys(ORgName+jutil.getRandomNumber());
   
   oip.getGroupbtn().click(); //click group
   
   WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
   
   
   wutil.handledropdown(dropdown, Group); 
   
   oip.getSavebtn().click(); //click on save btn
  
   TakesScreenshot ts =(TakesScreenshot) driver;
   Thread.sleep(2000);
   File tempfile = ts.getScreenshotAs(OutputType.FILE);
   Thread.sleep(2000);
   File destinationfile = new File("./Element4/Vtiger.png");
   FileUtils.copyFile(tempfile, destinationfile);
   
   
  Thread.sleep(2000); 
   wutil.mousehover(driver, hp.getImgss()); //mouse hover on img
   
   hp.getSignout().click(); //click on signout
  
  
   
   
   
   
   
   
   
   
   
   
   
   
	
	
	
	
}

}
