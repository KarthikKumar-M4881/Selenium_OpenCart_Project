/*
 * THIS CLASS IS CALLED AS A BASE CLASS--->
 * BECAUSE THIS CLASS CONTAIN THE BASIC LOGIC WHICH CONTAINS FOR ALL THE CLASS,
 * THAT WHY WE CAN CREATE THIS CLASS i.e,THIS CLASS CAN BE RE-USES SO MANY TIMES TO ANOTHER CLASS..
 */

package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class Basepage {

	WebDriver driver;
	
	//CONSTRUCTOR:-
	public Basepage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
}
