package POM;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OrganizationInformationPage {

@FindBy(name = "accountname") //Indentify organization name tf

private WebElement  Oraganizationnametf;


public WebElement getOraganizationnametf() {
	return Oraganizationnametf;
}




public WebElement getGroupbtn() {
	return Groupbtn;
}




public WebElement getSavebtn() {
	return savebtn;
}




public WebElement getSerchchtf() {
	return serchchtf;
}




@FindBy(xpath =  "(//input[@name='assigntype'])[2]") //Indentify radio btn

private WebElement Groupbtn;



@FindBy(xpath = "(//input[@name='button'])[1]") //Indentify Save btn

private WebElement savebtn;




@FindBy(id = "search_txt")

private WebElement  serchchtf;



}
