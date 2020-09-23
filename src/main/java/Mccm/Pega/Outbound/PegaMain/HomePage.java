package Mccm.Pega.Outbound.PegaMain;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//import Mccm.Pega.Outbound.PegaSubClass.HomePageDetails;
import Mccm.Pega.Outbound.PegaMain.HomePageDetails;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;

public class HomePage extends TestBase {
	//page factory - OR:
	
	@FindBy(xpath="//a[@id='appview-nav-toggle-one']")
	WebElement Homepage;
	@FindBy(xpath="(//i[@class='pi pi-caret-down'])[2]")
	WebElement Pegalunch;

	 public HomePage( ) {
    	PageFactory.initElements(driver, this);
    }
	 
	 public DataLoadDetails DataLoadValidation() throws InterruptedException {
   	  Thread.sleep(8000);
   	  Homepage.click();
   	  Thread.sleep(8000);
   	  return new DataLoadDetails();
   } 
    
    public HomePageDetails ClickHomepage() throws InterruptedException {
    	  Thread.sleep(8000);
    	  Homepage.click();
    	  Thread.sleep(8000);
    	  return new HomePageDetails();
    } 	
   public PegaMarketPage Pegamrklunch()throws InterruptedException {
	
	     Actions  action = new Actions(driver);
	     action.moveToElement(Pegalunch).click().build().perform();
	     return new PegaMarketPage();
   }

   public DBConfigValdtn DBConfigValidation() throws InterruptedException {
	   	  Thread.sleep(8000);
	   	  Homepage.click();
	   	  Thread.sleep(8000);
	   	  return new DBConfigValdtn();
	   } 
   public ExtractChannelFile ExtractChannelFile() throws InterruptedException {
	   	  Thread.sleep(8000);
	   	  Homepage.click();
	   	  Thread.sleep(8000);
	   	  return new ExtractChannelFile();
	   } 
   public NBAOutboundValdtn NBAOutboundValdtn() throws InterruptedException {
	   	  Thread.sleep(8000);
	   	  Homepage.click();
	   	  Thread.sleep(8000);
	   	  return new NBAOutboundValdtn();
	   } 
         
 
}
