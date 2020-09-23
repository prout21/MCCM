package Mccm.Pega.Outbound.PegaTest;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaMain.LoginPage;
import Mccm.Pega.Outbound.PegaMain.ExtractChannelFile;
import Mccm.Pega.Outbound.PegaMain.ExtractChannelFile;
//import Mccm.Pega.Outbound.PegaSubClass.ExtractChannelFile;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;

public class ExtractChannelFileTest extends TestBase {

	private static final String priorty = null;
	LoginPage loginpage;
	HomePage  homepage;
	ExtractChannelFile ExtractChannelFile1;
	TestUtil testutil;
	
	public ExtractChannelFileTest()
	{
		super();
	}
 @BeforeMethod
 
    public void setup() throws InterruptedException {
	    initialization();
	    loginpage = new LoginPage();
	    testutil = new TestUtil();
	    ExtractChannelFile1 =new ExtractChannelFile();
	    homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password")); 
	    ExtractChannelFile1=homepage.ExtractChannelFile();
 }
 @Test (priority=1)
 public void VerifyExtractChannelFileCheckSuccessfully() throws InterruptedException { 
	 ExtractChannelFile1.Recordclk();
	 ExtractChannelFile1.SysAdmin();
	 ExtractChannelFile1.javaexictor4();
	 ExtractChannelFile1.DynamicSystemSettins();
	 ExtractChannelFile1.GetDataExtractDetails();
	 ExtractChannelFile1.SerchClick();
	 ExtractChannelFile1.ClickGetDataExtractDetails();
	 testutil.SwitcTodefaultContent();
	 testutil.SwitchToFrame("PegaGadget1Ifr");
	 ExtractChannelFile1.ActionClkGetDataExtractDetails();
	 ExtractChannelFile1.RunActionClk();
	 ExtractChannelFile1.FileNameClk();
	 ExtractChannelFile1.FileNameSerach();
	 ExtractChannelFile1.EXTFLAGCheck();
 
 }
 
 
 @AfterMethod
 
      public void teardown() {
	
      driver.quit();
	 
      
 	 System.out.println("Extract file Check Done");  
 }
    
}
