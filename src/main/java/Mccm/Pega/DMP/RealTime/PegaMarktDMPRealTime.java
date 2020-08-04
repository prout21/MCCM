package Mccm.Pega.DMP.RealTime;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.testng.Assert;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.QAUtil.TestUtil;
import Mccm.Pega.excel.utility.Excel_Reader;

public class PegaMarktDMPRealTime extends TestBase  {
	

	public static String ExcelFilePath;
	
	@FindBy(xpath="//a[@id='appview-nav-toggle-one']")
	WebElement Homepage;
	
	@FindBy(xpath="(//i[@class='pi pi-caret-down'])[2]")
	WebElement Pegalunch;
	
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
	
	@FindBy(xpath="//div[text()='Engagement']")
	WebElement webelement2;
	
	
	@FindBy(css="button[name='EngagementContainer_pyWorkPage_7']")
	WebElement Engagementconfig;
	
	
	@FindBy(xpath="//input[@type='checkbox'][@name='$PpyWorkPage$pEnableContainers']")
	WebElement Realtimecontainers;
	
	
	@FindBy(xpath="//img[@name='CalendarImg-8e50e8cd']")
	WebElement Calender;
	
	@FindBy(xpath="//a[text()='Today']")
	WebElement Currentdate;
	
	@FindBy(xpath="//text()[.='Configure containers']/ancestor::button[1]")
	WebElement ConfigureContainers;
	
	@FindBy(xpath="//input[@type='text'][@name='$PRealtimeContainerMultiPg$pFilterCriteriaDisplay$ppyValue']")
	WebElement SrchConfigEngagment;
	
	@FindBy(xpath="//*[@name='WideDetailsSelectorPanel_RealtimeContainerMultiPg_53']")
	WebElement ClkConfigEngagment;
	
	@FindBy(xpath="(//div[contains(@data-repeat-source,'RealtimeContainerMultiPg')]//button[text()='Add'])[1]")
	WebElement AddConfigureContainers;
	
	@FindBy(xpath="//button[text()='Add containers']")
	WebElement AddContainers;
	
	
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
	

	Excel_Reader obj= new Excel_Reader(ExcelFilePath+"/src/main/java/Mccm/Pega/TestData/PegaTestData.xlsx");
	
	String Campaigncd = obj.getCellValue("PegaTestData", 1, 0);
		
	String ConfigMrkStrtgy = obj.getCellValue("PegaTestData", 1, 8);
				
	String DMPRealtimecontainers = obj.getCellValue("PegaTestData", 1, 11);
	
	
		
	public PegaMarktDMPRealTime( ) {
    	PageFactory.initElements(driver, this);
    }
	
	public PegaMarktDMPRealTime Pegamrklunch()throws InterruptedException {
		
	     Actions  action = new Actions(driver);
	     action.moveToElement(Pegalunch).click().build().perform();
	     return new PegaMarktDMPRealTime();
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
	
	public void Realtimecontainers() throws InterruptedException
	{
		Thread.sleep(6000);
		Realtimecontainers.click( );
        Thread.sleep(6000);
	}
	
	public void Calender() throws InterruptedException
	{
		Thread.sleep(6000);
		Calender.click( );
        Thread.sleep(6000);
	}
	
	public void Currentdate() throws InterruptedException
	{
		Thread.sleep(6000);
		Currentdate.click( );
        Thread.sleep(6000);
	}
	
	public void ConfigureContainers() throws InterruptedException
	{
		Thread.sleep(6000);
		ConfigureContainers.click( );
        Thread.sleep(6000);
	}
	
	public void SrchConfigEngagment() throws InterruptedException
	{
		Thread.sleep(6000);
		SrchConfigEngagment.sendKeys(DMPRealtimecontainers);
        Thread.sleep(6000);
        ClkConfigEngagment.click();
        Thread.sleep(6000);
	}
	public void AddConfigureContainers() throws InterruptedException
	{
		Thread.sleep(6000);
		AddConfigureContainers.click( );
        Thread.sleep(6000);
	}
	
	public void Javascriptserch() throws InterruptedException
	{
		 Thread.sleep(6000);
		 boolean searchIconPresence = AddContainers.isDisplayed();
	     boolean searchIconEnabled =  AddContainers.isEnabled();

	     if (searchIconPresence==true && searchIconEnabled==true)

	     {
	      	 WebElement element9 = AddContainers;
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
	
	}
	

	
