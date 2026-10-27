package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC002_LoginTest extends BaseClass{
     @Test(groups= {"sanity","Master"})
	public void verify_Login()
	{
		try
		{
		logger.info("**********Starting TC002_LoginTest*********");
		
		Homepage hp = new Homepage(driver);
		hp.ClicklinMyAccount();
		hp.ClicklinkLogin();
		
		LoginPage lp = new LoginPage(driver);
		lp.setEmail(p.getProperty("email"));
		lp.setPassword(p.getProperty("password"));
		lp.ClickLogin();
		
		//MY ACCOUNT
		MyAccountPage MAP = new MyAccountPage(driver);
	    boolean targetPage=	MAP.isMyAccountPageExists();
	    Assert.assertTrue(targetPage);
	    
		}
		catch(Exception e)
		{
			Assert.fail();
		}
	    logger.info("*************Finifhed TC002_LoginTest************");
	    
	}
}
