package Mccm.Pega.Outbound.PegaMain;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;
import Mccm.Pega.excel.utility.Excel_Reader;

public class NBAOutboundValdtn extends TestBase {
	
	public static String ExcelFilePath;
	
	@FindBy(xpath="(//h3[@class='layout-group-item-title'])[5]")
	WebElement Recordclk;
	
	@FindBy(xpath="(//div[@id='iconExpandCollapse'])[15]")
	WebElement SysAdmin;
	
	@FindBy(xpath="//a[text()='Dynamic System Settings']")
	WebElement webelement4;
		
	@FindBy(xpath="//input[@type='text'][@name='$PpyDisplayHarness$ppySearchText']")
	WebElement D_LatestNBACampaignFlag;
	
	@FindBy(xpath="//*[@class='pi pi-search-2']")
	WebElement SerchClick;
	
	@FindBy(xpath="//a[text()='Data Page']")
	WebElement ClickDataPage;
	
	@FindBy(xpath="//a[text()='D_LatestNBACampaignFlag']")
	WebElement ClickD_LatestNBACampaignFlag;


	@FindBy(xpath="//*[@class='pi pi-caret-down margin-l-1x']")
	WebElement ActionClkD_LatestNBACampaignFlag;
	 
	@FindBy(xpath="(//text()[.='Run']/ancestor::a[1])[2]")
	WebElement RunActionClk;
	 
	@FindBy(xpath="//input[@type='checkbox'][@name='$PD_pzRunRecord$ppxRunWindow$gTABTHREAD1$ppxRunParameters$ppyFlushAll']")
	WebElement FlushClk;
	
	@FindBy(xpath="(//div[@class='pzbtn-mid'])[3]")
	WebElement RunFlushClk;
	
	@FindBy(xpath="(//span[contains(.,'PR-')])[3]")
	WebElement CampRUNid;
	
	@FindBy(xpath="(//a[@href='#'])[3]//following::span[28]")
	WebElement ActiveOfferCountCmpltd;
	
	@FindBy(xpath="(//a[@href='#'])[5]//following::span[30]")
	WebElement CmpgnDailyCycleCmpltd;
	
	@FindBy(xpath="(//a[@href='#'])[25]//following::span[50]")
	WebElement DataExpCmpltdDMP;
	
	@FindBy(xpath="(//a[@href='#'])[27]//following::span[52]")
	WebElement DataExpCmpltdEDWH;
	
	@FindBy(xpath="(//a[@href='#'])[29]//following::span[54]")
	WebElement DataExpCmpltdKIASEPOS;
	
	@FindBy(xpath="(//a[@href='#'])[31]//following::span[56]")
	WebElement DataExpCmpltdMAMODB;
	
	@FindBy(xpath="(//a[@href='#'])[33]//following::span[58]")
	WebElement DataExpCmpltdOS;
	
	@FindBy(xpath="(//a[@href='#'])[37]//following::span[62]")
	WebElement IsCmpgnSuccess;
	
	@FindBy(xpath="(//a[@href='#'])[41]//following::span[66]")
	WebElement SaveLCSSCmpltd;
	
	 	
	Excel_Reader obj= new Excel_Reader(ExcelFilePath+"/src/main/java/Mccm/Pega/TestData/PegaTestData.xlsx");
			
	String DLatestNBACampaignFlagIN = obj.getCellValue("PegaTestData", 1, 17);
	
	Excel_Reader obj1= new Excel_Reader(ExcelFilePath+"/src/main/java/Mccm/Pega/TestData/PegaOutputData.xlsx");

	String CampaigRUNid = obj1.getCellValue("PegaOutputData", 1, 0);
	
	
	public NBAOutboundValdtn( ) {
    	PageFactory.initElements(driver, this);
    }
	
	public void Recordclk() throws InterruptedException
	{
		Thread.sleep(6000);
		Recordclk.click( );
        Thread.sleep(6000);
	}
	public void SysAdmin() throws InterruptedException
	{
		 Thread.sleep(6000);
		 SysAdmin.click( );
		 Thread.sleep(6000);
	}
	public void javaexictor4() throws InterruptedException
	{
		TestUtil obj=new TestUtil();
		obj.JavascriptExecutor(webelement4);
	}	
	public void DynamicSystemSettins() throws InterruptedException
	{
		Thread.sleep(6000);
		webelement4.click( );
		Thread.sleep(6000);
	}
		
	public void D_LatestNBACampaignFlag() throws InterruptedException
	{
		Thread.sleep(6000);
		D_LatestNBACampaignFlag.sendKeys(DLatestNBACampaignFlagIN);
        Thread.sleep(6000);
	}
	
	public void SerchClick() throws InterruptedException
	{
		Thread.sleep(6000);
		SerchClick.click( );
        Thread.sleep(6000);
	}
	public void ClickD_LatestNBACampaignFlag() throws InterruptedException
	{
		Thread.sleep(6000);
		ClickDataPage.click();
		Thread.sleep(6000);
		ClickD_LatestNBACampaignFlag.click( );
        Thread.sleep(6000);
	}
	public void ActionClkD_LatestNBACampaignFlag() throws InterruptedException
	{
		Thread.sleep(6000);
		ActionClkD_LatestNBACampaignFlag.click( );
        Thread.sleep(6000);
	}
	
	public void RunActionClk() throws InterruptedException
	{
		TestUtil obj=new TestUtil();
		obj.ActionMouseMov(RunActionClk);
	}	
	
	public void FulshRunClick() throws InterruptedException
	{
	String mainWindow=driver.getWindowHandle();
    Set<String> set =driver.getWindowHandles();
    Iterator<String> itr= set.iterator();
     while(itr.hasNext())
     {
     String childWindow=itr.next();
      if(!mainWindow.equals(childWindow)){
     driver.switchTo().window(childWindow);

      Thread.sleep(6000);
      FlushClk.click();

	 Thread.sleep(6000);
	 RunFlushClk.click( );
	 Thread.sleep(6000);
      }
  
	}
	}
	
	// display validation of the Camp RUN id data
	
	public void CampRUNid() throws InterruptedException
	{
		WebElement w2=CampRUNid;
		
	//	w2=driver.findElement(By.xpath("(//span[contains(.,'PR-')])[3]"));

		String CampRunID = w2.getText();

		System.out.println(CampRunID);
  
		System.out.println(CampaigRUNid);

		Assert.assertEquals(CampRunID, CampaigRUNid); 
	}

		// display validation of the ActiveOfferCountCmpltd data
	public void ActiveOfferCountCmpltd() throws InterruptedException
	{
		WebElement w3=ActiveOfferCountCmpltd;

	//	w3=driver.findElement(By.xpath("(//a[@href='#'])[3]//following::span[28]"));

		String ActiveOfferCountCmpltd = w3.getText();

		System.out.println(w3.getText());

		Assert.assertEquals(ActiveOfferCountCmpltd, "Y"); 
	}
		// display validation of the CmpgnDailyCycleCmpltd data
	public void CmpgnDailyCycleCmpltd() throws InterruptedException
	{

		WebElement w4= CmpgnDailyCycleCmpltd;

	//	w4=driver.findElement(By.xpath("(//a[@href='#'])[5]//following::span[30]"));

		String CmpgnDailyCycleCmpltd = w4.getText();

		System.out.println(w4.getText());

		Assert.assertEquals(CmpgnDailyCycleCmpltd, "Y"); 
	}

		// display validation of the DataExpCmpltdDMP data
	public void DataExpCmpltdDMP() throws InterruptedException
	{
		WebElement w5=DataExpCmpltdDMP;

	//	w5=driver.findElement(By.xpath("(//a[@href='#'])[25]//following::span[50]"));

		String DataExpCmpltdDMP = w5.getText();

		System.out.println(w5.getText());

		Assert.assertEquals(DataExpCmpltdDMP, "Y"); 
	}

		// display validation of the DataExpCmpltdEDWH data
	public void DataExpCmpltdEDWH() throws InterruptedException
	{

		WebElement w6=DataExpCmpltdEDWH;

	//	w6=driver.findElement(By.xpath("(//a[@href='#'])[27]//following::span[52]"));

		String DataExpCmpltdEDWH = w6.getText();

		System.out.println(w6.getText());

		Assert.assertEquals(DataExpCmpltdEDWH, "Y"); 
	}

		// display validation of the DataExpCmpltdKIASEPOS data
	public void DataExpCmpltdKIASEPOS() throws InterruptedException
	{
		WebElement w7=DataExpCmpltdKIASEPOS;

//		w7=driver.findElement(By.xpath("(//a[@href='#'])[29]//following::span[54]"));

		String DataExpCmpltdKIASEPOS = w7.getText();

		System.out.println(w7.getText());

		Assert.assertEquals(DataExpCmpltdKIASEPOS, "Y"); 
	}

		// display validation of the DataExpCmpltdMAMODB data
	public void DataExpCmpltdMAMODB() throws InterruptedException
	{
		WebElement w8=DataExpCmpltdMAMODB;

	//	w8=driver.findElement(By.xpath("(//a[@href='#'])[31]//following::span[56]"));

		String DataExpCmpltdMAMODB = w8.getText();

		System.out.println(w8.getText());

		Assert.assertEquals(DataExpCmpltdMAMODB, "Y"); 
	}

		// display validation of the DataExpCmpltdOS data
	public void DataExpCmpltdOS() throws InterruptedException
	{
		WebElement w9=DataExpCmpltdOS;

		//w9=driver.findElement(By.xpath("(//a[@href='#'])[33]//following::span[58]"));

		String DataExpCmpltdOS = w9.getText();

		System.out.println(w9.getText());

		Assert.assertEquals(DataExpCmpltdOS, "Y"); 
	}

		// display validation of the IsCmpgnSuccess data
	public void IsCmpgnSuccess() throws InterruptedException
	{
		WebElement w10=IsCmpgnSuccess;

	//	w10=driver.findElement(By.xpath("(//a[@href='#'])[37]//following::span[62]"));

		String IsCmpgnSuccess = w10.getText();

		System.out.println(w10.getText());

		Assert.assertEquals(IsCmpgnSuccess, "Y"); 
	}

		// display validation of the SaveLCSSCmpltd data
	public void SaveLCSSCmpltd() throws InterruptedException
	{
		WebElement w11=SaveLCSSCmpltd;

	//	w11=driver.findElement(By.xpath("(//a[@href='#'])[41]//following::span[66]"));

		String SaveLCSSCmpltd = w11.getText();

		System.out.println(w11.getText());

		Assert.assertEquals(SaveLCSSCmpltd, "Y"); 
	}
	}