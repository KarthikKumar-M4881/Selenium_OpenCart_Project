/*
 * THIS IS THE PAGE OBJECT CLASS OF ACCOUNT REGISTARTION OF THE USER
 * WHICH CONTAINS THE BASIC USER DETAILS LIKE FIRST_NAME,LAST_NAME...ETC;
 * FOR THOSE WE CAN CREATES:-
 * 1)CONSTRUCTOR
 * 2)LOCATORS
 * 3)ACTION-METHODS
 */
package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistartionpage extends Basepage {
	
	//CONSTRUCTOR:-
    public AccountRegistartionpage(WebDriver driver) 
    {
		super(driver);
		
	}
	
	//LOCATORS:-
    
    //FirstName Locator:-
    @FindBy(css="#input-firstname")
    WebElement txt_FirstName_Loc;
	
	//SecondName Locator:-
    @FindBy(css="#input-lastname")
	WebElement txt_LastName_Loc;
	
	//Email Locators:-
    @FindBy(css="#input-email")
    WebElement txt_Email_Loc;
    
    
    //TELEPHONE LOCATORS:-
    @FindBy(css="#input-telephone")
    WebElement txt_TelePhone_Loc;
    
    //Password Locators:-
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_password_Loc;
	
	//CONFIRM PASSWORD:-
	@FindBy( xpath ="//input[@id='input-confirm']")
	WebElement txt_ConfirmPassword_Loc;
	
	//SLIDING BOX
	@FindBy(xpath="//input[@name='agree']")
	WebElement Chk_privacy_Loc;
	
	//Continue Button
	@FindBy(xpath="//input[@value='Continue']")
	WebElement btn_continue_Loc;
	
	
	//VERIFICATION MESSAGE 
	@FindBy(xpath="//h1[text()='Your Account Has Been Created!']")
	WebElement Confirm_Message;
	
	
	//ACTION-METHODS:-
	public void setFirstName(String FirstName)
	{
		txt_FirstName_Loc.sendKeys(FirstName);
	}
	
	
	public void setLastName(String LastName)
	{
		txt_LastName_Loc.sendKeys(LastName);
	}
	
	public void setEmail(String Email)
	
	{
		txt_Email_Loc.sendKeys(Email);
	}
	
	public void setTelephone(String telephone)
	{
		txt_TelePhone_Loc.sendKeys(telephone);
	}
	public void setPassword(String password)
	{
		txt_password_Loc.sendKeys(password);
	}
	
	public void setConfirmPassword(String confirmPassword)
	{
		txt_ConfirmPassword_Loc.sendKeys(confirmPassword);
	}
	public void ClickChickBox()
	{
		Chk_privacy_Loc.click();
	}
	
	public void ClickContinue()
	{
		btn_continue_Loc.click();
	}
	
	


	public String getConfirm_Message() {
		
		return Confirm_Message.getText();
	}
	
	
	
	
	
}
