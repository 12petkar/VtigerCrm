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

public class Product {

WebDriverUtil wutil = new WebDriverUtil();
JavaUtil jutil = new JavaUtil();

PropertyFileUtil putil = new PropertyFileUtil();
ExelUtil eutil = new ExelUtil();


@Test
	
	public void probuts() throws IOException, InterruptedException {
		
     WebDriver driver = new ChromeDriver(); //empty browser
     
     wutil.maximize(driver); // maximize screen
     
     wutil.implicitwait(driver); //apply wait
     
     
     //To Read the Data form property file
     
     String URL = putil.getDataPropertyFile("Url");
     String UserName = putil.getDataPropertyFile("Username");    
      String Password = putil.getDataPropertyFile("Password");
      
      driver.get(URL);//Lauch Application
    
      driver.findElement(By.name("user_name")).sendKeys(UserName); //Enter the User name
      Thread.sleep(2000);
      driver.findElement(By.name("user_password")).sendKeys(Password); //Enter password 
      Thread.sleep(2000);
      driver.findElement(By.id("submitButton")).click(); //click on login btn
      
     
      driver.findElement(By.partialLinkText("Products")).click(); //click on Products
      
      Thread.sleep(2000);
      driver.findElement(By.cssSelector("img[src='themes/softed/images/btnL3Add.gif']")).click(); //click on Img (+) Btn
      
      
      //To Read the Data from exel file 
      
      String productName = eutil.getDataFromExcel("Product", 0, 1);
      String ProductCategory = eutil.getDataFromExcel("Product", 1, 1);
      String VendorName = eutil.getDataFromExcel("Product", 2, 1);
      String VendorPartNo = eutil.getDataFromExcel("Product", 3, 1);
                             
               
      driver.findElement(By.name("productname")).sendKeys(productName); //Enter thw product name
      Thread.sleep(2000);
      WebElement drop = driver.findElement(By.name("productcategory")); //hamdle dropdown
      Thread.sleep(2000);
      wutil.handledropdown(drop, ProductCategory);

    /* driver.findElement(By.cssSelector("img[src='themes/softed/images/select.gif']")).click(); //click on img (+) btn
    
    //To Transper window to parent to child
     
    Set<String> ids = driver.getWindowHandles();
    
    for(String a : ids) {
    	
    	String actualurl = driver.switchTo().window(a).getCurrentUrl();
   
            System.out.println(actualurl);
     
            String childurl = "http://localhost:8888/index.php?module=Vendors&action=Popup&html=Popup_picker&popuptype=specific&form=EditView&fromlink=";
             if(actualurl.contains(childurl)) {
            	 
            	 break;
             }
            
            
    }
     
   
    driver.findElement(By.id("search_txt")).sendKeys(VendorName);//enetrt name
    driver.findElement(By.name("search")).click(); //click in search btn*/


   driver.findElement(By.id("vendor_part_no")).sendKeys(VendorPartNo);
      
      
      
      
}






}
