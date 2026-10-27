/*
 * THIS IS THE ACTUAL PAGE OBJECT TEST ,HERE WE CAN EXCUTE THE TEST CASES
 * FOR THE ACCOUNT_REGISTRATION CLASS.
 */

package testCases;


import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.AccountRegistartionpage;
import pageObjects.Homepage;
import testBase.BaseClass;

public class TC001_AccountRegistrationpageTest extends BaseClass
{

	
	
    @Test(groups= {"Regression","Master"})
	void Test_VerifyAccountRegistrationpage()
	{
    	logger.info("*********Starting TC001_AccountRegistrationpageTest**********");
    	//IN A HOMEPAGE WE HAVE ACCOUNT LINK INSIDE IT ANOTHER REGISTRATION LINK IS THERE.
    	
    	try
    	{
    	Homepage hp = new Homepage(driver);
    	logger.info("Clicked on MyAccount Link....");
    	hp.ClicklinMyAccount();
    	logger.info("Clicked on Register Link.....");
    	hp.ClicklinRegistration();
    	
    	AccountRegistartionpage regpage = new AccountRegistartionpage(driver);
    	
    	logger.info("Providing Customer details.....");
    	regpage.setFirstName(randomString().toUpperCase());
    	regpage.setLastName(randomString().toUpperCase());
    	regpage.setEmail(randomString()+"@gmail.com");
    	regpage.setTelephone(randomNumber());
    	
    	String password=randomAlfaNumerics();
    	
    	
    	regpage.setPassword(password);
    	regpage.setConfirmPassword(password);
    	regpage.ClickChickBox();
    	regpage.ClickContinue();
    	
    	logger.info("Validating expected message... ");
    	// Get actual confirmation message
    	String actualMessage = regpage.getConfirm_Message();
         //Get expected confirmation message
    	String expectedMessage = "Your Account Has Been Created!";
        //validating the confirmation message
    	Assert.assertEquals(actualMessage, expectedMessage);
    	}
    	catch(Exception e)
    	{
    		logger.error("Test Failed..");
    		logger.debug("Debug logs...");
    		Assert.fail();
    		
    	
    	}
    	finally 
    	{
      	        logger.info("********Finished TC001_AccountRegistrationpageTest********");
        }

    	}
	}
    	
