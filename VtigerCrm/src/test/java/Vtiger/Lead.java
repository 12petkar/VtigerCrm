package Vtiger;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import CommonUtils.ExelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;
import POM.HomePage;
import POM.OrganizationInformationPage;

public class Lead {

	PropertyFileUtil putil = new PropertyFileUtil();
	ExelUtil eutil = new ExelUtil();
	JavaUtil jutil = new JavaUtil();
	WebDriverUtil wutil = new WebDriverUtil();
	
@Test







public void Leads() throws IOException, InterruptedException {
	
	
	WebDriver driver = new ChromeDriver();
	wutil.maximize(driver);
	
	
	String URL = putil.getDataPropertyFile("Url");
	
	String UserName = putil.getDataPropertyFile("Username");
	
	String Password = putil.getDataPropertyFile("Password");

	driver.get(URL);
	
driver.findElement(By.name("user_name")).sendKeys(UserName);	
driver.findElement(By.name("user_password")).sendKeys(Password);

driver.findElement(By.id("submitButton")).click();

driver.findElement(By.partialLinkText("Leads")).click();

driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();


//Read the data form exel

String FName = eutil.getDataFromExcel(" Lead", 0, 1);
  String Lname = eutil.getDataFromExcel(" Lead", 1, 1);
  String drop = eutil.getDataFromExcel(" Lead", 4, 1);
 String CompanyNamae = eutil.getDataFromExcel(" Lead", 2, 1);

String Email = eutil.getDataFromExcel(" Lead", 5, 1);
String Title = eutil.getDataFromExcel(" Lead", 3, 1);



driver.findElement(By.name("firstname")).sendKeys(FName);
Thread.sleep(2000);

driver.findElement(By.name("lastname")).sendKeys(Lname);
Thread.sleep(2000);
driver.findElement(By.name("company")).sendKeys(CompanyNamae);
Thread.sleep(2000);
driver.findElement(By.id("secondaryemail")).sendKeys(Email);
Thread.sleep(2000);
driver.findElement(By.id("designation")).sendKeys(Title);
Thread.sleep(2000);
driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
Thread.sleep(2000);
WebElement dropdown = driver.findElement(By.name("assigned_group_id"));

wutil.handledropdown(dropdown, drop);


OrganizationInformationPage org = new OrganizationInformationPage();
PageFactory.initElements(driver, org);
org.getSavebtn().click();



HomePage hp = new HomePage();
PageFactory.initElements(driver, hp);
Thread.sleep(2000);
wutil.mousehover(driver, hp.getImgss());
Thread.sleep(2000);
hp.getSignout().click();

}
}
