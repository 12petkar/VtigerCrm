package Vtiger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
public class Dummy {

//public static void main(String[] args) {
	
	@Test(priority = 0)
	
	public void Myntra() {
		
      WebDriver driver = new ChromeDriver();
      driver.get("https://www.myntra.com/");
	}
   
      
     @Test(priority = 3)

   public void Facebbok() {
	   
         WebDriver driver = new ChromeDriver();
         driver.get("https://www.facebook.com/");
         
     }
     
     @Test(priority = 1)
     
     public void Zomato() {
    	 
    	    WebDriver driver = new ChromeDriver();
            driver.get("https://www.zomato.com/pune");	
            
     }
     
     @Test(priority = 2)

     public void Ajio() {
    	 
    	  WebDriver driver = new ChromeDriver();
          driver.get("https://www.ajio.com/");
          
     }
     
     @Test(priority = 4)

     public void Swiggy() {
    	 
    	 
   	  WebDriver driver = new ChromeDriver();
         driver.get("https://www.swiggy.com/");
   }
	
}




