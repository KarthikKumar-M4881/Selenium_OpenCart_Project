package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends Basepage {
    
	
	//CONSTRUCTOR
	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
    
	//LOCATORS:-
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_Email_Id_LOC;
	
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_Password_LOC;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement btn_Login_LOC;
	
	
	//ACTION-METHODS:-
	public void setEmail(String email)
	{
		txt_Email_Id_LOC.sendKeys(email);
	}
	public void setPassword(String password)
	{
		txt_Password_LOC.sendKeys(password);
	}
	public void ClickLogin()
	{
		btn_Login_LOC.click();
	}
}
