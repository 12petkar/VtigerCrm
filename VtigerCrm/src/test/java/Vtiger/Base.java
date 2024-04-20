package Vtiger;

import java.io.File;
import java.io.IOException;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Base {

@Test


public void text() throws InterruptedException, IOException {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.flipkart.com/");
	WebElement searchtf = driver.findElement(By.name("q"));
	
	searchtf.sendKeys("Bag");
	Thread.sleep(2000);
     searchtf.sendKeys(Keys.ENTER);
     
     driver.findElement(By.xpath("(//img[@class='_53J4C-'])[2]")).click();
     
     
     Set<String> ids = driver.getWindowHandles();
     
     for(String a : ids) {
    	 
    	 String childurl = driver.switchTo().window(a).getCurrentUrl();
    	 
    	 String ActualChildUrl = "https://www.flipkart.com/amicoleben-smart-bag-spacy-comfortable-4th-10th-class-casual-waterproof-school-30-l-trolley-backpack/p/itm832600b826015?pid=BKPGTKKEFGRX6HGS&lid=LSTBKPGTKKEFGRX6HGSBD49C7&marketplace=FLIPKART&q=bag&store=reh%2F4d7&srno=s_1_2&otracker=search&otracker1=search&fm=Search&iid=en_jfIpS3If99419PaPCu4KXFzNzKabW0UiFoS2QUQywK8YU7lm6b42I2ySV65k0wpRABagkNo33o7iJPQLowjW6w%3D%3D&ppt=sp&ppn=sp&ssid=b6b0k1zd0w0000001713605624959&qH=4a82715423d654d6";
     
       if(childurl.contains(ActualChildUrl)) {
    	   
    	   break;
       }
     
     }

  TakesScreenshot ts =(TakesScreenshot) driver;
  
  File tempfile = ts.getScreenshotAs(OutputType.FILE);
  
  File destinationfile = new File("./NewOneShot/Bag.png");
  
  FileUtils.copyFile(tempfile, destinationfile);


}

}
