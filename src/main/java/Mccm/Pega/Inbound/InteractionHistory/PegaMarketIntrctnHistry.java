package Mccm.Pega.Inbound.InteractionHistory;

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

public class PegaMarketIntrctnHistry extends TestBase  {


	@FindBy(xpath="//a[@id='appview-nav-toggle-one']")
	WebElement Homepage;
	
	@FindBy(xpath="(//i[@class='pi pi-caret-down'])[2]")
	WebElement Pegalunch;
	
	@FindBy(xpath="(//span[@class='menu-item-title'])[5]")
	WebElement pegamrkting1;
	@FindBy(xpath="//a[@id='appview-nav-toggle-one']")
	WebElement ExpandPegMrkPage;
	
	@FindBy(xpath="//i[@class='icons pi pi-clipboard-check pi-white']")
	WebElement ClkReport;
	
	@FindBy(xpath="//span[text()='Interaction History']")
	WebElement ClkIntractionHstry;
	
	@FindBy(xpath="//span[text()='Recent interactions']")
	WebElement ClkRecentIntrctnHstry;
	

	
		
	public PegaMarketIntrctnHistry( ) {
    	PageFactory.initElements(driver, this);
    }
	
	public PegaMarketIntrctnHistry Pegamrklunch()throws InterruptedException {
		
	     Actions  action = new Actions(driver);
	     action.moveToElement(Pegalunch).click().build().perform();
	     return new PegaMarketIntrctnHistry();
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
	public void ExpandReport() throws InterruptedException
	{
		Thread.sleep(6000);
		ClkReport.click( );
        Thread.sleep(6000);
	}
	public void ClkIntractionHstry() throws InterruptedException
	{
		Thread.sleep(6000);
		ClkIntractionHstry.click( );
        Thread.sleep(6000);
	}
	public void ClkRecentIntrctnHstry() throws InterruptedException
	{
		Thread.sleep(6000);
		ClkRecentIntrctnHstry.click( );
        Thread.sleep(6000);
	}
	
}	 