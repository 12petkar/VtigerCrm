package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage {

public WebElement getOrganization() {
		return Organization;
	}


	public WebElement getContacts() {
		return Contacts;
	}


	public WebElement getImg() {
		return img;
	}


	public WebElement getSignout() {
		return signout;
	}


@FindBy(xpath = "(//a[text()='Organizations'])[1]") //Indentify organization

private WebElement Organization;

@FindBy(xpath = "//a[text()='Contacts']") //Indentify img

private WebElement Contacts;

@FindBy(xpath = "//img[@alt='Create Organization...']") //Indentify img

private WebElement img;





@FindBy(xpath = "//a[text()='Sign Out']")

private WebElement signout;



public WebElement getImgss() {
	return imgss;
}


@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")

private WebElement imgss;



}
