/*
 * IN THIS CLASS WE CREATE A PAGE OBJECT CLASS BY USING PAGE FACTORY METHOD
 * WE ALREADY CREATE A BASSE CLASS BECAUSE OF RE-USEABLITY .
 * SO, IN BASE CLASS CONSTRUCTOR AND CHILD CLASS CONSTRUCTOR CAN BE ACCED THROUGH SUPER KEYWORD
 * i.e,PARENT CLASS -->VARIABLES,METHODS,CONSTRUCTORS ARE ACCESED THROUGH SUPER KEYWORD.
 * THEN FIRST WE EXTEND THAT PARENT CLASS TO CHILD CLASS.
 * 
 */

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage  extends Basepage{

	//Homepage constructor:-
	public Homepage(WebDriver driver) 
	{
		
		super(driver);
		
	}

	//LOCATORS:-
	@FindBy(xpath ="//span[normalize-space()='My Account']")
	WebElement linMyAccout;
	
	@FindBy(xpath ="//a[normalize-space()='Register']")
	WebElement linRegistration;
	
	//LOGIN BUTTON WEBELEMENT
	@FindBy(xpath ="//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']")
	WebElement linkLogin;
	
	
	
	//ACTION-METHODS:-
	public void ClicklinMyAccount()
	{
		linMyAccout.click();
	}
	
	public void ClicklinRegistration()
	{
		linRegistration.click();
	}
	public void ClicklinkLogin()
	{
		linkLogin.click();
	}
	
}
