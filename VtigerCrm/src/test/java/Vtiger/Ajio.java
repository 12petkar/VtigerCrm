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

public class Ajio {

	//public static void main(String[] args) throws InterruptedException, IOException {
		// TODO Auto-generated method stub

@Test

public void Ajios() throws InterruptedException, IOException{ 
	
	WebDriver driver = new ChromeDriver();
	
	driver.manage().window().maximize();
	
	driver.get("https://www.ajio.com/");
	WebElement searchtf = driver.findElement(By.name("searchVal"));
	
	searchtf.sendKeys("Sungalss");
	searchtf.sendKeys(Keys.ENTER);
	
	driver.findElement(By.xpath("//label[contains(text(),'Men')]")).click(); // click on men
	Thread.sleep(2000);
	driver.findElement(By.xpath("//span[text()='brands']")).click(); //click on brand
     Thread.sleep(2000);
	driver.findElement(By.xpath("//label[contains(text(),'AISLIN')]")).click(); //select brand
	Thread.sleep(2000);
	driver.findElement(By.cssSelector("img[alt='Product image of AISLIN 8929 UV Protected Aviators']")).click(); //click on img
	
	Set<String> ids = driver.getWindowHandles();
	
	for(String a : ids) {
		
		String ActualUrl = driver.switchTo().window(a).getCurrentUrl();
		   System.out.println(ActualUrl);
		String ChildUrl = "https://www.ajio.com/aislin-8929-uv-protected-aviators/p/464884879_green";
		
		if(ActualUrl.contains(ChildUrl)) {
			
			break;
		}
	}
	driver.findElement(By.xpath("//span[text()='ADD TO BAG']")).click();
	Thread.sleep(5000);
	driver.findElement(By.xpath("//span[text()='GO TO BAG']")).click();
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	Thread.sleep(2000);
	File tempfile = ts.getScreenshotAs(OutputType.FILE);
	
	File destinationFile = new File("./Ajio/bigsunglass.png");
	
	FileUtils.copyFile(tempfile, destinationFile);
	
	
	
	for(String b : ids) {
		
		
		String ParentUrl = driver.switchTo().window(b).getCurrentUrl();
		
		System.out.println(ParentUrl);
   
		String AcutalParentUrl = "https://www.ajio.com/search/?query=%3Arelevance%3Agenderfilter%3AMen%3Abrand%3AAISLIN&text=Sungalss&classifier=intent&gridColumns=3&segmentIds=";
	  
		if(ParentUrl.contains(AcutalParentUrl)) {
			
			break;
		}
	
	}
	
	TakesScreenshot tss = (TakesScreenshot) driver;
	Thread.sleep(2000);
	File tempfile1 = tss.getScreenshotAs(OutputType.FILE);
	
	File destinationFile1 = new File("./Ajio/bigsun.png");
	
	FileUtils.copyFile(tempfile1, destinationFile1);
	
	
	}

}
