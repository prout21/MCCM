	package Mccm.Pega.Outbound.PegaMain;
	
	import java.io.File;
    import java.io.FileInputStream;
	import java.io.FileNotFoundException;
    import java.io.FileOutputStream;
    import java.io.IOException;
	import java.util.Properties;
	import java.util.concurrent.TimeUnit;
	import java.util.function.Function;
    import org.apache.poi.xssf.usermodel.XSSFSheet;
    import org.apache.poi.xssf.usermodel.XSSFWorkbook;
    import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.NoSuchElementException;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.testng.Assert;
	
	import Mccm.Pega.Outbound.PegaTestBase.TestBase;
	import Mccm.Pega.QAUtil.TestUtil;
	import Mccm.Pega.excel.utility.Excel_Reader;
	
	public class PegaMarketPage extends TestBase  {
	
		public static String ExcelFilePath;
	
	
	
		@FindBy(xpath="(//span[@class='menu-item-title'])[5]")
		WebElement pegamrkting1;
		@FindBy(xpath="//a[@id='appview-nav-toggle-one']")
		WebElement ExpandPegMrkPage;
	
		@FindBy(xpath="//span[text()='Campaigns']")
		WebElement Campaigns;
	
		@FindBy(xpath="//*[@class='pi pi-caret-down']")
		WebElement Create;
	
		@FindBy(xpath="//span[text()='Multi-Channel Campaign']")
		WebElement MultiChannelCampaign;
	
		@FindBy(xpath="//input[@type='text'][@name='$PpyWorkPage$ppyLabel']")
		WebElement Campaigncode;
	
		@FindBy(xpath="//span[text()='Build']")
		WebElement Build;
	
		@FindBy(css="button[name='ContainerWithHeader_pyWorkPage.ProgramConfiguration.StrategyContainer_7']")
		WebElement MrktStrtgyConfig;
	
		@FindBy(xpath="//input[contains(@name,'pFilterCriteriaDisplay$ppyValue')]")
		WebElement SrchMrkStrtgy;
	
		@FindBy(xpath="//*[contains(@class,'pi-search')]")
		WebElement ClkSrchMrkStrtgy;
	
		@FindBy(xpath="(//div[contains(@data-repeat-source,'MultiSelectCardSelector')]//button[text()='Add'])[1]")
		WebElement AddMrkStrtgy;
	
		@FindBy(xpath="//button[text()='Apply']")
		WebElement Applay;
	
		@FindBy(css="button[name='ContainerWithHeader_pyWorkPage.AudienceContainer_7']")
		WebElement AudianceConfig;
	
		@FindBy(xpath="//input[contains(@name,'pFilterCriteriaDisplay$ppyValue')]")
		WebElement SrchConfigAudience;
	
		@FindBy(xpath="//*[contains(@class,'pi-search')]")
		WebElement ClkSrchConfigAudience;
	
		@FindBy(xpath="(//div[contains(@data-repeat-source,'MultiSelectCardSelector')]//button[text()='Add'])[1]")
		WebElement AddAdinceconfig;
	
		@FindBy(xpath="//button[text()='Apply']")
		WebElement ApplayAdience;
	
		@FindBy(xpath="//div[text()='Engagement']")
		WebElement webelement2;
	
	
		@FindBy(css="button[name='EngagementContainer_pyWorkPage_7']")
		WebElement Engagementconfig;
	
	
		@FindBy(xpath="//input[@type='checkbox'][@name='$PpyWorkPage$pEnableScheduling']")
		WebElement Campaignschdul;
	
	
		@FindBy(xpath="//label[text()='Recurring']")
		WebElement Recurring;
	
	
		@FindBy(xpath="//input[@type='checkbox'][@name='$PpyWorkPage$pProgramConfiguration$pDirectDBTemplate']")
		WebElement databasetemplate;
	
		@FindBy(xpath="//text()[.='Configure template']/ancestor::button[1]")
		WebElement configtemplate;
	
		@FindBy(xpath="//input[@type='text'][@name='$PDBTemplateMultiPg$pFilterCriteriaDisplay$ppyValue']")
		WebElement SrchConfigEngagment;
	
		@FindBy(xpath="//*[@name='WideDetailsSelectorPanel_DBTemplateMultiPg_53']")
		WebElement ClkConfigEngagment;
	
		@FindBy(xpath="(//div[contains(@data-repeat-source,'DBTemplateMultiPg')]//button[text()='Add'])[1]")
		WebElement Addmcclbound;
	
		@FindBy(xpath="//button[text()='Add template']")
		WebElement Addtemplete;
	
	
		@FindBy(xpath="//button[text()='Apply']")
		WebElement ApplayEngagement;
	
		@FindBy(xpath="//button[text()='Save']")
		WebElement SaveCampgn;
	
		@FindBy(xpath="//button[text()='Run']")
		WebElement RunCampgn;
	
		@FindBy(xpath="//button[text()='Confirm']")
		WebElement ConfirmCampgn;
	
		@FindBy(xpath="//*[@class='pi pi-refresh']")
		WebElement RefreshCampgn;
	
		@FindBy(xpath="//h2[text()='Run schedule']")
		WebElement Runschedule;
		
		@FindBy(xpath="//span[text()='Completed']")
		WebElement Completed;

		@FindBy(xpath="//span[text()='Failed']")
		WebElement Failed;

		@FindBy(xpath="//span[text()='Stopped']")
		WebElement Stopped;

		@FindBy(xpath="//*[@name='DataFlowRunDetails_pyWorkPage_3']")
		WebElement RunDetails;

		@FindBy(xpath="//span[text()='Campaign run ID']")
		WebElement CampaignrunID;
		
		@FindBy(xpath="//span[.='Campaign run ID']/..//span[contains(.,'PR-')]")
		WebElement CampaignRunID;
		
		
	
	
	
		Excel_Reader obj= new Excel_Reader(ExcelFilePath+"/src/main/java/Mccm/Pega/TestData/PegaTestData.xlsx");
	
		String Campaigncd = obj.getCellValue("PegaTestData", 1, 0);
	
		String ConfigMrkStrtgy = obj.getCellValue("PegaTestData", 1, 8);
	
		String ConfigAudience = obj.getCellValue("PegaTestData", 1, 9);
	
		String ConfigEngagment = obj.getCellValue("PegaTestData", 1, 10);
	
	
	
		public PegaMarketPage( ) {
			PageFactory.initElements(driver, this);
		}
	
		public void pegamarkting() throws InterruptedException
		{
			Thread.sleep(6000);
			pegamrkting1.click( );
			Thread.sleep(6000);
		}
	
	
		public void ExpandPegMrkPage() throws InterruptedException
		{
			Thread.sleep(6000);
			ExpandPegMrkPage.click( );
			Thread.sleep(6000);
		}
	
		public void Campaigns() throws InterruptedException
		{
			Thread.sleep(6000);
			Campaigns.click( );
			Thread.sleep(6000);
		}
		public void Create() throws InterruptedException
		{
			Thread.sleep(6000);
			Create.click( );
			Thread.sleep(6000);
		}
		public void MultiChannelCampaign() throws InterruptedException
		{
			Thread.sleep(6000);
			MultiChannelCampaign.click( );
			Thread.sleep(6000);
		}
		public void Campaigncode() throws InterruptedException
		{
			Thread.sleep(6000);
			Campaigncode.sendKeys(Campaigncd);
			Thread.sleep(6000);
		}
		public void Build() throws InterruptedException
		{
			Thread.sleep(6000);
			Build.click( );
			Thread.sleep(6000);
		}
		public void MrktStrtgyConfig() throws InterruptedException
		{
			Thread.sleep(6000);
			MrktStrtgyConfig.click( );
			Thread.sleep(6000);
		}
		public void SrchMrkStrtgy() throws InterruptedException
		{
			Thread.sleep(6000);
			SrchMrkStrtgy.sendKeys(ConfigMrkStrtgy);
			Thread.sleep(6000);
			ClkSrchMrkStrtgy.click();
			Thread.sleep(6000);
		}
	
		public void AddMrkStrtgy() throws InterruptedException
		{
			Thread.sleep(6000);
			AddMrkStrtgy.click( );
			Thread.sleep(6000);
	
		}
		public void Applay() throws InterruptedException
		{
			Thread.sleep(6000);
			Applay.click( );
			Thread.sleep(6000);
	
		}    
	
		public void AudianceConfig() throws InterruptedException
		{
			Thread.sleep(6000);
			AudianceConfig.click( );
			Thread.sleep(6000);
		}
		public void SrchConfigAudience() throws InterruptedException
		{
			Thread.sleep(6000);
			SrchConfigAudience.sendKeys(ConfigAudience);
			Thread.sleep(6000);
			ClkSrchConfigAudience.click();
			Thread.sleep(6000);
		}
		public void AddAdinceconfig() throws InterruptedException
		{
			Thread.sleep(6000);
			AddAdinceconfig.click( );
			Thread.sleep(6000);
		}
	
		public void ApplayAdience() throws InterruptedException
		{
			Thread.sleep(6000);
			ApplayAdience.click( );
			Thread.sleep(6000);
		}
	
		public void javaexictor2() throws InterruptedException
		{
			TestUtil obj=new TestUtil();
			obj.JavascriptExecutor(webelement2);
		}
	
		public void Engagementconfig() throws InterruptedException
		{
			Thread.sleep(6000);
			Engagementconfig.click( );
			Thread.sleep(6000);
		}
	
		public void Campaignschdul() throws InterruptedException
		{
			Thread.sleep(6000);
			Campaignschdul.click( );
			Thread.sleep(6000);
		}
	
		public void Recurring() throws InterruptedException
		{
			Thread.sleep(6000);
			Recurring.click( );
			Thread.sleep(6000);
		}
	
		public void databasetemplate() throws InterruptedException
		{
			Thread.sleep(6000);
			databasetemplate.click( );
			Thread.sleep(6000);
		}
	
		public void configtemplate() throws InterruptedException
		{
			Thread.sleep(6000);
			configtemplate.click( );
			Thread.sleep(6000);
		}
	
		public void SrchConfigEngagment() throws InterruptedException
		{
			Thread.sleep(6000);
			SrchConfigEngagment.sendKeys(ConfigEngagment);
			Thread.sleep(6000);
			ClkConfigEngagment.click();
			Thread.sleep(6000);
		}
		public void Addmcclbound() throws InterruptedException
		{
			Thread.sleep(6000);
			Addmcclbound.click( );
			Thread.sleep(6000);
		}
	
		public void Javascriptserch() throws InterruptedException
		{
			Thread.sleep(6000);
			boolean searchIconPresence = Addtemplete.isDisplayed();
			boolean searchIconEnabled =  Addtemplete.isEnabled();
	
			if (searchIconPresence==true && searchIconEnabled==true)
	
			{
				WebElement element9 = Addtemplete;
				JavascriptExecutor executor3 = (JavascriptExecutor)driver;
				executor3.executeScript("arguments[0].click();", element9);
				Thread.sleep(6000);
			}
		}
	
		public void ApplayEngagement() throws InterruptedException
		{
			Thread.sleep(6000);
			ApplayEngagement.click( );
			Thread.sleep(6000);
		}
	
		public void SaveCampgn() throws InterruptedException
		{
			Thread.sleep(6000);
			SaveCampgn.click( );
			Thread.sleep(6000);
		}
	
		public void RunCampgn() throws InterruptedException
		{
			Thread.sleep(6000);
			RunCampgn.click( );
			Thread.sleep(6000);
		}
	
		public void ConfirmCampgn() throws InterruptedException
		{
			Thread.sleep(6000);
			ConfirmCampgn.click( );
			Thread.sleep(6000);
		}
		public void RefreshCampgn() throws InterruptedException
		{
			Thread.sleep(6000);
			RefreshCampgn.click( );
			Thread.sleep(6000);
		}
	
	
		//***********fluent wait program *********************************//
	
		public void Runstatus() throws InterruptedException
		{
	
			for(int i=0;i<50;i++)
			{
	
				Thread.sleep(6000);
	
				try
				{
					Thread.sleep(6000);
				//	driver.findElement(By.xpath("//*[@class='pi pi-refresh']")).click( );
					RefreshCampgn.click( );
					Thread.sleep(6000);
					JavascriptExecutor js6 = (JavascriptExecutor) driver;
					WebElement element7 =Runschedule;
					//WebElement element7 = driver.findElement(By.xpath("//h2[text()='Run schedule']"));
					js6.executeScript("arguments[0].scrollIntoView();", element7);	
				}catch(Exception e){
	
				}
	
				String getTextOnPage1 = "",getTextOnPage2 = "",getTextOnPage3 = "";
	
	
				try {
	
	
					WebElement element11 = Completed;
					
				//	WebElement element11 = driver.findElement(By.xpath("//span[text()='Completed']"));
	
					getTextOnPage1 = element11.getText();
	
				}catch(Exception e){
					e.printStackTrace();
	
				}
				try {
	
	
					WebElement element12 = Failed;
				//	WebElement element12 = driver.findElement(By.xpath("//span[text()='Failed']"));
	
					getTextOnPage2 = element12.getText();
	
	
				}catch(Exception e){
					e.printStackTrace();
	
				}
	
				try {
					WebElement element13 = Stopped;
				//	WebElement element13 = driver.findElement(By.xpath("//span[text()='Stopped']"));
	
					getTextOnPage3 = element13.getText();
	
				}catch(Exception e1){
					e1.printStackTrace();{
					}
					if (getTextOnPage1.equals("COMPLETED")){
	
	
						System.out.println("Test Case Passed");
	
	
						break;
					}
					else if (getTextOnPage2.equals("FAILED")) {
	
						System.out.println("Test Case Failed");
	
						Assert.assertEquals(getTextOnPage2, "COMPLETED"); 
	
						break;
					}
	
					else if (getTextOnPage3.equals("STOPPED")) {
	
						System.out.println("Test Case Stopped");
	
						Assert.assertEquals(getTextOnPage3, "COMPLETED"); 
	
						break;
					}
	
					{
						continue;
					}
	
	
	
				}
			}
	
		}
		
		public void CampRunIDCaptured() throws InterruptedException
		{
			Thread.sleep(8000);
			Completed.click();
		//	driver.findElement(By.xpath("//span[text()='Completed']")).click( );
			Thread.sleep(8000);

			JavascriptExecutor js7 = (JavascriptExecutor) driver;
			WebElement element8 =Completed;
			//WebElement element8 = driver.findElement(By.xpath("//span[text()='Completed']"));
			js7.executeScript("arguments[0].scrollIntoView();", element8);	

			Thread.sleep(8000);
			RunDetails.click();
		//	driver.findElement(By.xpath("//*[@name='DataFlowRunDetails_pyWorkPage_3']")).click( );
			Thread.sleep(8000);

			JavascriptExecutor js8 = (JavascriptExecutor) driver;
			WebElement element9 =CampaignrunID;
			//WebElement element9 = driver.findElement(By.xpath("//span[text()='Campaign run ID']"));
			js8.executeScript("arguments[0].scrollIntoView();", element9);	

			//Search the element by using starts-with
			WebElement w = CampaignRunID ;

	//		w=driver.findElement(By.xpath("//span[.='Campaign run ID']/..//span[contains(.,'PR-')]"));

			//Print the text of the searched element

			String CampRunID = w.getText();

			System.out.println(w.getText());

			File file = new File(ExcelFilePath+"/src/main/java/Mccm/Pega/TestData/PegaOutputData.xlsx");
			//	File file = new File("C:\\Users\\prout21\\git\\Automation_Framework\\MCCM\\MCCM\\src\\main\\java\\Mccm\\Pega\\TestData\\PegaOutputData.xlsx");
			XSSFWorkbook wb = new XSSFWorkbook();

			XSSFSheet sh = wb.createSheet("PegaOutputData");

			sh.createRow(0).createCell(0).setCellValue("CampRunID");

					sh.createRow(1).createCell(0).setCellValue(CampRunID);

					try {
						FileOutputStream fos = new FileOutputStream(file);
						wb.write(fos);
					}catch (Exception e) {

					}

			
		}
	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
