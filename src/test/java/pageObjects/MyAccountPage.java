package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends Basepage {

	public MyAccountPage(WebDriver driver)
	{
		 
		super(driver);
		 
	}
	//MY ACCOUNT PAGE IS USED FOR VALIDATION PURPOSE
    @FindBy(xpath ="//h2[normalize-space()='My Account']")
    WebElement msgHeading;
    
  //Logout button webelement
  	@FindBy(xpath="//div[@class='list-group']//a[text()='Logout']")//step6
  	WebElement linkLogout;
    
    public boolean isMyAccountPageExists() {
    	try {
			return(msgHeading.isDisplayed());
		} catch (Exception e) {
			return false;
		}
	
    }
    
    public void ClickLogout()
	{
		linkLogout.click();
	}
}
