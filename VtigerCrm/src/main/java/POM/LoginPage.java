package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

public WebElement getUserName() {
		return UserName;
	}

	public WebElement getPassword() {
		return Password;
	}

	public WebElement getSubmitbtn() {
		return submitbtn;
	}

@FindBy(name = "user_name") //indentify username tf

private WebElement UserName;


@FindBy(name = "user_password") //identify password tf

private WebElement Password;

@FindBy(id = "submitButton") //indentify submit btn

private WebElement submitbtn;
}
