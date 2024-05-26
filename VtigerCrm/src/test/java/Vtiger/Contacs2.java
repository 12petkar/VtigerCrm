package Vtiger;

import java.io.IOException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import CommonUtils.ExelUtil;
import CommonUtils.JavaUtil;
import CommonUtils.PropertyFileUtil;
import CommonUtils.WebDriverUtil;

public class Contacs2 {



JavaUtil jutil= new JavaUtil();
WebDriverUtil wutil = new WebDriverUtil();
ExelUtil eutil= new ExelUtil();
PropertyFileUtil putil = new PropertyFileUtil();

@Test

public void contc() throws IOException, InterruptedException {

	
	

	WebDriver driver = new ChromeDriver();
	 wutil.maximize(driver);
	 
	 String URL = putil.getDataPropertyFile("Url");
	 
	String Username = putil.getDataPropertyFile("Username");
     
	String Password = putil.getDataPropertyFile("Password");
	
	driver.get(URL);
	wutil.implicitwait(driver);

	driver.findElement(By.name("user_name")).sendKeys(Username);
	driver.findElement(By.name("user_password")).sendKeys(Password);
	driver.findElement(By.id("submitButton")).click();
	
	driver.findElement(By.partialLinkText("Contacts")).click();
	driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click();
	
	//Read the Dtata from property file
	String FullName = eutil.getDataFromExcel("Radhe", 0, 1);
	
	driver.findElement(By.name("firstname")).sendKeys(FullName);
			
	String LastName = eutil.getDataFromExcel("Radhe", 1, 1);
	
	  String OrgName = eutil.getDataFromExcel("Radhe", 2, 1);
	
	  String title = eutil.getDataFromExcel("Radhe", 3, 1);
	  
	  String deparment = eutil.getDataFromExcel("Radhe", 4, 1);
	  
	  String email = eutil.getDataFromExcel("Radhe", 5, 1);       
	  
	 String mobnum = eutil.getDataFromExcel("Radhe", 6, 1);
	
	 
	 String drop = eutil.getDataFromExcel("Radhe", 7, 1);
	 
	 driver.findElement(By.name("lastname")).sendKeys(LastName);
	
	driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click();
	
	Set<String> ids = driver.getWindowHandles();
	
	for(String a : ids) {
		
		String UrlC = driver.switchTo().window(a).getCurrentUrl();
		
		String child="http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=";
	
		if(UrlC.contains(child)) {
			break;
		}
	
	
	}
	
	

	
	driver.findElement(By.id("search_txt")).sendKeys(OrgName);

	driver.findElement(By.name("search")).click();
	
	driver.findElement(By.xpath("(//a[contains(text(),'AtosSyntel')])[2]")).click();


   for(String b : ids) {
	   
	   String Parenturl = driver.switchTo().window(b).getCurrentUrl();
	   
	   String Parenturll = "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";
   
   if(Parenturl.contains(Parenturll)) {
	   
	   break;
   }
   
   }

   driver.findElement(By.id("title")).sendKeys(title);
  Thread.sleep(2000);
   driver.findElement(By.id("department")).sendKeys(deparment);
   Thread.sleep(2000);
  driver.findElement(By.id("email")).sendKeys(email);
  Thread.sleep(200);
  driver.findElement(By.id("mobile")).sendKeys(mobnum);
  Thread.sleep(2000);
  driver.findElement(By.xpath("(//input[@name='assigntype'])[2]")).click();
  Thread.sleep(2000);
  WebElement dropdown = driver.findElement(By.name("assigned_group_id"));
  
  wutil.handledropdown(dropdown, drop);
  
  
   


}




}
