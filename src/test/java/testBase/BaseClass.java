package testBase;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/*
 * SRS1:-TEST CASE :-ACCOUNT REGISTRATION:-
 * 1.1 Create BasePage under "pageObjects" which includes only constructor
 * this will be invoked by every page object class constructor(RE-usebility).
 * 1.2 Create Page Object Classes for Homepage.registrationPage under pageObjects package.(THESE CLASSES EXTENDS FROM BASEPAGE)
 * 1.3 CREATE ACCOUNTREGISTRATIONTEST UNDER "TESTCASES"
 * 1.4 Create BaseClass under testBase package and copy re-usable methods.
 * 1.5 Create re-usable method to generate random number and strings in BaseClass.
 */
public class BaseClass{
	
	public static WebDriver driver;
	public Logger logger;//Log4j
	public Properties p;
	
	@BeforeClass(groups= {"Sanity","Regression","Master"})
	@Parameters({"os","browser"})
	public void SetUp(String os, String  br) throws IOException
	{
		/*SRS:-4 READ COMMON VALUES FROM CONFIG.PROPERTIES FILE
		 * =====================================================
		 * 4.1:-Add config.properties file under src/test/resources.
		 * 4.2:-Update BaseClass--->setup() method,add script to load config.properties file.
		 * 4.3:-Replace hard coded values in test Cases like Url,username,password etc.. 
		 */
		
		//LOADING CONFI,PROPERTIES FILE
		FileReader file = new FileReader("./src//test//resources//config.properties");
		p=new Properties();
		p.load(file);
		
		/*
		 * SRS2:-ADDING LOGS TO TEST CASE(LOG4J2)
		 * =======================================
		 * 2.1 Add log4j2.xml file under src/test/resourses.
		 * 2.2 Update BaseClass.
		 * 2.3 Add log Statement to AccountRegistrationTest.
		 */
		
		logger=LogManager.getLogger(this.getClass());
		
		/*SRS:-3 RUN TESTS ON DESIRED BROWSER/CROSS/BROWSER/PARALLEL
		 * ==========================================================
		 * 3.1 create testng.xml file to run test cases and parameterize
		 * browser name and os to BaseClass-->setup() method.
		 * 3.2 Update BaseClass -->setup() method,launch browser based on conditions.
		 * 3.3 Maintain separate xml to run multiple browsers parallel.. 
		 */
		switch(br.toLowerCase())
		{
		case "chrome" : driver = new ChromeDriver() ;break;
		case "edge"   :driver =  new EdgeDriver();break;
		case "firefox":driver = new FirefoxDriver();	break;	
		default :System.out.println("Invalid browser name....");
		}
		
		
		
	
    	driver.manage().deleteAllCookies();
    	//STEP2:-USE IMPLICIT WAIT
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    	
    	//STEP3:-GET THE URL
    	driver.get(p.getProperty("appURL"));//READING URL FROM PROPERTIES FILE.
    	
    	//STEP4:-MAXIMIZE THE WINDOW SIZE
    	driver.manage().window().maximize();
	}
    @AfterClass(groups= {"Sanity","Regression","Master"})
	void teardown()
	{
		driver.close();
	}
    
  //Generate the data into Alphabetics
  	public String randomString()
  	{
  		String RandomString = RandomStringUtils.randomAlphabetic(5);
  		return RandomString;
  	}
  	//Generate the data into Numbers
  	public String randomNumber()
  	{
  		String RandomNumber = RandomStringUtils.randomNumeric(10);
  		return RandomNumber;
  	}
  	
  	//Generate the data into Alfa Numerics
  	public String randomAlfaNumerics()
  	{
  		String RandomString = RandomStringUtils.randomAlphabetic(5);
  		String RandomNumber = RandomStringUtils.randomNumeric(5);
  		return (RandomString+"@"+RandomNumber);
  	}
  	
  	public String captureScreen(String tname) throws IOException {
  	    String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
  	    
  	    TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
  	    File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
  	    
  	    String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + tname + "_" + timeStamp + ".png";
  	    File targetFile = new File(targetFilePath);
  	    
  	    sourceFile.renameTo(targetFile);
  	    
  	    return targetFilePath;
  	
  	
}
}
