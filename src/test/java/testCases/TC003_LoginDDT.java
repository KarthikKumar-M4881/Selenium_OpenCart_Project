/*
 * THIS IS USED FOR LOGIN THE OPEN CART APPLICATION WITH DIFFERENT DATA THROUGH EXCEL FILE
 * Data is valid --login success - test pass --- logout
 *               --login failed  - test fail
 *               
 * Data is invalid --login success - test fail - logout
 *                 -- login failed - test pass
 */

package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {
    @Test(dataProvider="LoginData",dataProviderClass=DataProviders.class,groups= {"Datadriven"})//getting data provider from different class
	public void verify_loginDDT(String email,String pwd,String exp)
	{
	logger.info("*********Starting TC003_LoginDDT ************");
	try
	{
	Homepage hp = new Homepage(driver);
	hp.ClicklinMyAccount();
	hp.ClicklinkLogin();
	
	LoginPage lp = new LoginPage(driver);
	lp.setEmail(email);
	lp.setPassword(pwd);
	lp.ClickLogin();
	
	//MY ACCOUNT
	MyAccountPage MAP = new MyAccountPage(driver);
    boolean targetPage=	MAP.isMyAccountPageExists();
    /*Data is valid --login success - test pass --- logout
    *               --login failed  - test fail
    *               
    * Data is invalid --login success - test fail - logout
    *                 -- login failed - test pass
     */
	if(exp.equalsIgnoreCase("valid"))
    {
       if(targetPage == true)
       {
    	   MAP.ClickLogout();
    	   Assert.assertTrue(true);
       }
       else
       {
    	Assert.assertTrue(false);   
       }
       if(exp.equalsIgnoreCase("Invalid"))
       {
          if(targetPage == true)
          {
       	   MAP.ClickLogout();
       	   Assert.assertTrue(false);
          }
          else
          {
        	Assert.assertTrue(true);   
          }
    
	}
    }
	}
	
	catch(Exception e)
	{
		Assert.fail();
	}
	
	logger.info("*************FINISHED TC003_VERIFICATION LOGIN***********");
	
	}
}
