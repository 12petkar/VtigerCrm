package Basic2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchToBrowser {


public static void main(String[] args) throws InterruptedException {
	//String givendata="https://demowebshop.tricentis.com/";	
WebDriver driver = new ChromeDriver();

driver.manage().window().maximize();

driver.navigate().to("https://demowebshop.tricentis.com/");

WebElement dwsIcon = driver.findElement(By.cssSelector("img[alt='Tricentis Demo Web Shop']"));

//String cureentdata = driver.getCurrentUrl();


if(dwsIcon.isDisplayed()) {
	
	
System.out.println("You Are In DempWorkshop...");

Thread.sleep(2000);


driver.navigate().back();
Thread.sleep(2000);
driver.navigate().forward();
Thread.sleep(2000);
driver.navigate().refresh();
Thread.sleep(2000);
driver.close();



}
else {
	System.out.println("You Are Not DempWorkshop Page Check the URL .....");
}
}
}
