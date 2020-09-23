package Mccm.Pega.Outbound.PegaTestBase;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Mccm.Pega.DMP.RealTime.PegaMarktDMPRealTime;
import Mccm.Pega.Outbound.PegaMain.DBConfigValdtn;
import Mccm.Pega.Outbound.PegaMain.DataLoadDetails;
import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.PegaMarketPage;
import Mccm.Pega.Outbound.PegaMain.HomePageDetails;
//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
import Mccm.Pega.QAUtil.TestUtil;
import Mccm.RESTful.APICall.DMPRTPNBAMobHash;


public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	
	 public static String CampRunID;

	
	public TestBase()
	{
		try {
			prop=new Properties();
			
			String projectPath = System.getProperty("user.dir");
			
							
	FileInputStream ip=new FileInputStream(projectPath+"/src/main/java/Mccm/Pega/ConfigPega/Config.properties");
	      prop.load(ip);
		   
	   PegaMarketPage.ExcelFilePath = System.getProperty("user.dir");
	   
	   HomePageDetails.ExcelFilePath = System.getProperty("user.dir");
	   
	   PegaMarktDMPRealTime.ExcelFilePath = System.getProperty("user.dir");
	   
	   DataLoadDetails.ExcelFilePath = System.getProperty("user.dir");
	   
	   DBConfigValdtn.ExcelFilePath = System.getProperty("user.dir");
	   
	   
	 
  	      
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}      
	
	}

    public static void initialization() {
    	String browserName = prop.getProperty("browser");
    	String chromedriverPath = prop.getProperty("chromedriver.dir");
    	if(browserName.equals("chrome")) {
    	System.setProperty("webdriver.chrome.driver", chromedriverPath+"/chromedriver.exe");  
    	driver = new ChromeDriver();
    	
    	}
    	
      driver.manage().window().maximize();
      driver.manage().deleteAllCookies();
      driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
      driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
      driver.get(prop.getProperty("url"));
     
    }
    
  //*******************************************************************************************
  	//*Function:	general_ReadProperty														*
  	//*Arguments:	Property Key as String													 	*
  	//*Return 		Poverty Value as String														*
  	//*Descriptions: 																			*
  	//*	This function will read the Properties file and return property value to based on key.	*
  	//*Author: 														*
  	//*******************************************************************************************
  	public static String general_ReadProperty(String propertyKey)
  	{
  		String propertyValue="";
  		File cfgfile = new File("configurationFile.properties");
  		
  		if(cfgfile.exists())
  		{
  			  Properties propties = new Properties();
  			  FileInputStream propFile;

  			  try {
  				  propFile = new FileInputStream(cfgfile);
  				  propties.load(propFile);
  				  propertyValue=propties.getProperty(propertyKey);
  				  } catch (Exception e1) {
  					  
  					  e1.printStackTrace();
  				  } 
  		 }
  		return propertyValue;
  		
  	    
  }
 }
