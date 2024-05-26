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

public class MyntraScreenshot {

@Test

public void Myntra() throws InterruptedException, IOException {
	
	WebDriver driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://www.myntra.com/");
	WebElement serchtf = driver.findElement(By.cssSelector("input[placeholder='Search for products, brands and more']"));
	serchtf.sendKeys("Sunglass");
	Thread.sleep(2000);
	serchtf.sendKeys(Keys.ENTER);
	
	driver.findElement(By.xpath("//img[@alt='Voyage Unisex Black Lens Oval Sunglasses with UV Protected Lens 2038MG3051C']")).click();

	Set<String> ids = driver.getWindowHandles();
	
	for(String a : ids) {
		
		String childurl = driver.switchTo().window(a).getCurrentUrl();
		
		System.out.println(childurl);
		
		String CURL = "https://www.myntra.com/sunglasses/voyage/voyage-unisex-black-lens-oval-sunglasses-with-uv-protected-lens-2038mg3051c/14582818/buy";
		if(childurl.contains(CURL)) {
			
			break;
			
		}
	}
	
	
	TakesScreenshot ts = (TakesScreenshot) driver;
	
	File tempfile = ts.getScreenshotAs(OutputType.FILE);
	
	File destinationFile = new File("./Sunglass/Myntra.png");
	
	FileUtils.copyFile(tempfile, destinationFile);
	


for(String b : ids) {
	
	String ParentTile = driver.switchTo().window(b).getCurrentUrl();
	
	System.out.println(ParentTile);
	
	String URL="https://www.myntra.com/";


if(ParentTile.contains(URL)) {
	
	break;
}
	


}
}



}
