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

public class ExtractChannelFile extends TestBase {

	public static String ExcelFilePath;

	@FindBy(xpath="(//h3[@class='layout-group-item-title'])[5]")
	WebElement Recordclk;

	@FindBy(xpath="(//div[@id='iconExpandCollapse'])[15]")
	WebElement SysAdmin;

	@FindBy(xpath="//a[text()='Dynamic System Settings']")
	WebElement webelement4;

	@FindBy(xpath="//input[@type='text'][@name='$PpyDisplayHarness$ppySearchText']")
	WebElement GetDataExtractDetails;

	@FindBy(xpath="//*[@class='pi pi-search-2']")
	WebElement SerchClick;

	@FindBy(xpath="//a[text()='Report definition']")
	WebElement ClickReportdeftion;

	@FindBy(xpath="//a[text()='GetDataExtractDetails']")
	WebElement ClickGetDataExtractDetails;


	@FindBy(xpath="//*[@class='pi pi-caret-down margin-l-1x']")
	WebElement ActionClkGetDataExtractDetails;

	@FindBy(xpath="(//text()[.='Run']/ancestor::a[1])[2]")
	WebElement RunActionClk;

	@FindBy(xpath="(//a[@id=\"pui_colmenu\"])[1]")
	WebElement FileNameClk;

	@FindBy(xpath="(//span[@class=\"menu-item-title\"])[1]")
	WebElement FilterClk;


	@FindBy(xpath="//input[@type='text'][@name='$PpyFilterCriteria_pyReportContentPage_pxResults_pzRRListBody_1$ppyColumnFilterCriteria$gFileName1$ppySearchText']")
	WebElement FileNameSerach;

	@FindBy(xpath="//button[text()='Apply']")
	WebElement FilterApplayClk;

	@FindBy(xpath="(//span[contains(.,'Y')])[7]")
	WebElement EXTFLAGChk;



	Excel_Reader obj= new Excel_Reader(ExcelFilePath+"/src/main/java/Mccm/Pega/TestData/PegaTestData.xlsx");

	String ChanelFileNameIN = obj.getCellValue("PegaTestData", 1, 16);

	String GetDataExtractDetailsIN = obj.getCellValue("PegaTestData", 1, 15);

	public ExtractChannelFile( ) {
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

	public void GetDataExtractDetails() throws InterruptedException
	{
		Thread.sleep(6000);
		GetDataExtractDetails.sendKeys(GetDataExtractDetailsIN);
		Thread.sleep(6000);
	}

	public void SerchClick() throws InterruptedException
	{
		Thread.sleep(6000);
		SerchClick.click( );
		Thread.sleep(6000);
	}
	public void ClickGetDataExtractDetails() throws InterruptedException
	{
		Thread.sleep(6000);
		ClickReportdeftion.click();
		Thread.sleep(6000);
		ClickGetDataExtractDetails.click( );
		Thread.sleep(6000);
	}
	public void ActionClkGetDataExtractDetails() throws InterruptedException
	{
		Thread.sleep(6000);
		ActionClkGetDataExtractDetails.click( );
		Thread.sleep(6000);
	}

	public void RunActionClk() throws InterruptedException
	{
		TestUtil obj=new TestUtil();
		obj.ActionMouseMov(RunActionClk);
	}	

	public void FileNameClk() throws InterruptedException
	{
		String mainWindow=driver.getWindowHandle();
		Set<String> set =driver.getWindowHandles();
		// Using Iterator to iterate with in windows
		Iterator<String> itr= set.iterator();
		while(itr.hasNext())
		{
			String childWindow=itr.next();
			// Compare whether the main windows is not equal to child window. If not equal, we will close.
			if(!mainWindow.equals(childWindow)){
				driver.switchTo().window(childWindow);
				driver.manage().window().maximize();

				Thread.sleep(6000); 
				FileNameClk.click( );
				Thread.sleep(6000);
				FilterClk.click( );
				Thread.sleep(6000);
			}
		}
	}
	public void FileNameSerach() throws InterruptedException
	{
		Thread.sleep(6000);
		FileNameSerach.sendKeys(ChanelFileNameIN);
		Thread.sleep(6000);
		FilterApplayClk.click( );
	}


	// display validation of the Flag id data

	public void EXTFLAGCheck() throws InterruptedException
	{
		Thread.sleep(6000);
		WebElement w4= EXTFLAGChk;
		Thread.sleep(6000);
		String EXTFLAG = w4.getText();

		System.out.println(w4.getText());

		Assert.assertEquals(EXTFLAG, "Y"); 
	}

}
