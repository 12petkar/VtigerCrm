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

public class Contacts {



PropertyFileUtil putil = new PropertyFileUtil();

ExelUtil eutil = new ExelUtil();

JavaUtil jutil = new JavaUtil();

WebDriverUtil wutil = new WebDriverUtil();

@Test

public void ContactsTest() throws IOException, InterruptedException {
	
	WebDriver driver = new ChromeDriver();
	
	wutil.maximize(driver); //maximize the Screen
	
	wutil.implicitwait(driver); //apply Wait
	
	
	//Reading the Data form Property File
	
	String URL = putil.getDataPropertyFile("Url");
	
	String UserName = putil.getDataPropertyFile("Username");
	
	  String PASSWORD = putil.getDataPropertyFile("Password");
 	
	  driver.get(URL); //Lauch The Application
	
	  
	  driver.findElement(By.name("user_name")).sendKeys(UserName);  //Enter user name Tf
	  Thread.sleep(2000);
	  
	  driver.findElement(By.name("user_password")).sendKeys(PASSWORD); //Enter Password tf
	  Thread.sleep(2000);
	  
	  driver.findElement(By.id("submitButton")).click(); //Click on Login btn
	  
	  driver.findElement(By.partialLinkText("Contacts")).click();  //click on Contact
	  
	  driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click(); //click on plush btn...(+)
	  
	  //To Read Data From Exel File
	  
	  String FirstName = eutil.getDataFromExcel("Contacts", 0, 1);
	  String LastName = eutil.getDataFromExcel("Contacts", 1, 1);
	  String ORGName = eutil.getDataFromExcel("Contacts", 3, 1);        
	  
	  driver.findElement(By.name("firstname")).sendKeys(FirstName); //Enter the tf name
	  Thread.sleep(2000);
	  driver.findElement(By.name("lastname")).sendKeys(LastName);  //enter the password tf
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("(//img[@src='themes/softed/images/select.gif'])[1]")).click(); //click on Organization Name plush btn(+)
	  Thread.sleep(2000);
	  
	  Set<String> ids = driver.getWindowHandles();
	  
	  System.out.println(ids);
	  
	  for(String a : ids) {
		  
		  String ChildUrl = driver.switchTo().window(a).getCurrentUrl();
		  System.out.println(ChildUrl);
		  
		 String CHILDURL = "http://localhost:8888/index.php?module=Accounts&action=Popup&popuptype=specific_contact_account_address&form=TasksEditView&form_submit=false&fromlink=&recordid=";
	    if(ChildUrl.contains(CHILDURL)) {
	    	break;
	    	
	    	
	    	
	    }
	  
	  }
	  
	  
	  driver.findElement(By.id("search_txt")).sendKeys(ORGName); //Enter The OrgName tf
	  
	  driver.findElement(By.name("search")).click(); //Search on company name
	  
	  driver.findElement(By.xpath("(//a[contains(text(),'AtosSyntel')])[2]")).click(); //click on company name
	  
	// ids= driver.getWindowHandles();
	  
	  for(String b : ids) {
		  
		  String ParentUrl = driver.switchTo().window(b).getCurrentUrl();
		  
		  System.out.println(ParentUrl);
		String PARENTURL = "http://localhost:8888/index.php?module=Contacts&action=EditView&return_action=DetailView&parenttab=Marketing";  
	    if(ParentUrl.contains(PARENTURL)) {
	    	
	    	break;
	    	
	    }
	  
	  }
	
	  driver.findElement(By.xpath("(//input[@name='button'])[1]")).click(); //click on save btn
	  Thread.sleep(2000);
	  wutil.screenshot(driver, LastName);
	  Thread.sleep(2000);
	  WebElement img = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")); //mouse hover on img
	  Thread.sleep(2000);
	  wutil.mousehover(driver, img);
	  Thread.sleep(2000);
	  driver.findElement(By.xpath("//a[text()='Sign Out']")).click(); //click on sign btn
	   
	


}
}
