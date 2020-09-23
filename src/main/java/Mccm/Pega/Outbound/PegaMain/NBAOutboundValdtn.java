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
	WebElement d_latestdataloadFlag;
	
	@FindBy(xpath="//*[@class='pi pi-search-2']")
	WebElement SerchClick;
	
	@FindBy(xpath="//a[text()='Data Page']")
	WebElement ClickDataPage;
	
	@FindBy(xpath="//a[text()='D_LatestDataLoadFlag']")
	WebElement Clickd_latestdataloadFlag;


	@FindBy(xpath="//*[@class='pi pi-caret-down margin-l-1x']")
	WebElement ActionClkd_latestdataloadFlag;
	 
	@FindBy(xpath="(//text()[.='Run']/ancestor::a[1])[2]")
	WebElement RunActionClk;
	 
	@FindBy(xpath="//input[@type='checkbox'][@name='$PD_pzRunRecord$ppxRunWindow$gTABTHREAD1$ppxRunParameters$ppyFlushAll']")
	WebElement FlushClk;
	
	@FindBy(xpath="(//div[@class='pzbtn-mid'])[3]")
	WebElement RunFlushClk;
	
	@FindBy(xpath="(//a[@href='#'])[11]//following::span[31]")
	WebElement DataLoadCmpltdCsndra;
	
	@FindBy(xpath="(//a[@href='#'])[13]//following::span[33]")
	WebElement DataLoadCmpltdOracle;
	
	 	
	Excel_Reader obj= new Excel_Reader(ExcelFilePath+"/src/main/java/Mccm/Pega/TestData/PegaTestData.xlsx");
			
	String dlatestdataloadFlag = obj.getCellValue("PegaTestData", 1, 12);
	
	
	
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
		
	public void d_latestdataloadFlag() throws InterruptedException
	{
		Thread.sleep(6000);
		d_latestdataloadFlag.sendKeys(dlatestdataloadFlag);
        Thread.sleep(6000);
	}
	
	public void SerchClick() throws InterruptedException
	{
		Thread.sleep(6000);
		SerchClick.click( );
        Thread.sleep(6000);
	}
	public void Clickd_latestdataloadFlag() throws InterruptedException
	{
		Thread.sleep(6000);
		ClickDataPage.click();
		Thread.sleep(6000);
		Clickd_latestdataloadFlag.click( );
        Thread.sleep(6000);
	}
	public void ActionClkd_latestdataloadFlag() throws InterruptedException
	{
		Thread.sleep(6000);
		ActionClkd_latestdataloadFlag.click( );
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
	// display validation of the DataLoadCmpltdCsndra data
	
	public void DataLoadCmpltdCsndra() throws InterruptedException
	{

	WebElement w3;

//	w3=driver.findElement(By.xpath("(//a[@href='#'])[11]//following::span[31]"));
	w3=DataLoadCmpltdCsndra;

	String DataLoadCmpltdCsndra = w3.getText();

	System.out.println(w3.getText());

	Assert.assertEquals(DataLoadCmpltdCsndra, "Y"); 
	
	}
	
	// display validation of the DataLoadCmpltdOracle data
	
	public void DataLoadCmpltdOracle() throws InterruptedException
	{

	WebElement w4;
	
	w4=DataLoadCmpltdOracle;

//	w4=driver.findElement(By.xpath("(//a[@href='#'])[13]//following::span[33]"));

	String DataLoadCmpltdOracle = w4.getText();

	System.out.println(w4.getText());

	Assert.assertEquals(DataLoadCmpltdOracle, "Y"); 
	}
}