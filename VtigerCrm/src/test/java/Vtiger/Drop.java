package Vtiger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Drop {

public static void main(String[] args) {
	
	
	WebDriver driver = new ChromeDriver();
	driver.get("https://letcode.in/test");
	driver.findElement(By.partialLinkText("Drop-Down")).click();
	
	WebElement dropdown = driver.findElement(By.id("fruits"));
	
	Select s = new Select(dropdown);
    s.selectByVisibleText("Mango");
    
    JavascriptExecutor js =(JavascriptExecutor) driver;
  
  js.executeScript("window.scrollBy(0 ,700)");
  
	//js.executeScript("window.scrollBy(0, 900)");



}


}
