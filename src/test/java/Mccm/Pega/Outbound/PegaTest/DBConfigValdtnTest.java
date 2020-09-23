package Mccm.Pega.Outbound.PegaTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.LoginPage;
import Mccm.Pega.Outbound.PegaMain.DBConfigValdtn;
import Mccm.Pega.Outbound.PegaMain.DBConfigValdtn;
//import Mccm.Pega.Outbound.PegaSubClass.DBConfigValdtn;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;

public class DBConfigValdtnTest extends TestBase {

	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  homepage;
	DBConfigValdtn DBConfigValdtn1;
	TestUtil testutil;
	
	public DBConfigValdtnTest()
	{
		super();
	}
 @BeforeMethod
 
    public void setup() throws InterruptedException {
	    initialization();
	    loginpage = new LoginPage();
	    testutil = new TestUtil();
	    DBConfigValdtn1 =new DBConfigValdtn();
	    homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
	    DBConfigValdtn1=homepage.DBConfigValidation();
 }
 @Test (priority=1)
 public void VerifyDBConfigurationSuccessfully() throws InterruptedException { 
	 DBConfigValdtn1.Recordclk();
	 DBConfigValdtn1.SysAdmin();
	 DBConfigValdtn1.javaexictor4();
	 DBConfigValdtn1.DynamicSystemSettins();
	 DBConfigValdtn1.MCCMLCOutbound();
	 DBConfigValdtn1.SerchClick();
	 DBConfigValdtn1.ClickMCCMLCOutbound();
	 testutil.SwitcTodefaultContent();
	 testutil.SwitchToFrame("PegaGadget1Ifr");
	 DBConfigValdtn1.ActionClkMCCMLCOutbound();
	 DBConfigValdtn1.RunActionClk();
	 DBConfigValdtn1.RunClick();
	 DBConfigValdtn1.CampRunidValidation();
 
 }
 
 
 @AfterMethod
 
      public void teardown() {
	
      driver.quit();
	 
      
 	 System.out.println("DB Config Runid Check Done");  
 }
    
}
