package Mccm.Pega.Outbound.PegaTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.LoginPage;
import Mccm.Pega.Outbound.PegaMain.DataLoadDetails;
//import Mccm.Pega.Outbound.PegaSubClass.DataLoadDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;

public class DataLoadDetailsTest extends TestBase {

	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  homepage;
	DataLoadDetails DataLoadDetails1;
	TestUtil testutil;
	
	public DataLoadDetailsTest()
	{
		super();
	}
 @BeforeMethod
 
    public void setup() throws InterruptedException {
	    initialization();
	    loginpage = new LoginPage();
	    testutil = new TestUtil();
	    DataLoadDetails1 =new DataLoadDetails();
	    homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
	    DataLoadDetails1=homepage.DataLoadValidation();
 }
 @Test (priority=1)
 public void VerifyOracleCansadraDataLoadedSuccessfully() throws InterruptedException { 
	 DataLoadDetails1.Recordclk();
	 DataLoadDetails1.SysAdmin();
	 DataLoadDetails1.javaexictor4();
	 DataLoadDetails1.DynamicSystemSettins();
	 DataLoadDetails1.d_latestdataloadFlag();
	 DataLoadDetails1.SerchClick();
	 DataLoadDetails1.Clickd_latestdataloadFlag();
	 testutil.SwitcTodefaultContent();
	 testutil.SwitchToFrame("PegaGadget1Ifr");
	 DataLoadDetails1.ActionClkd_latestdataloadFlag();
	 DataLoadDetails1.RunActionClk();
	 DataLoadDetails1.FulshRunClick();
	 DataLoadDetails1.DataLoadCmpltdOracle();
	 DataLoadDetails1.DataLoadCmpltdCsndra();
	
 }
 
 
 @AfterMethod
 
      public void teardown() {
	
      driver.quit();
	 
      
 	 System.out.println("DSS seting Started");  
 }
    
}
