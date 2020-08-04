package Mccm.Pega.DMP.RealTime;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Mccm.Pega.Outbound.PegaTestBase.TestBase;

public class LoginPageDMPRealTime extends TestBase {
	//page factory - OR:
	
	@FindBy(xpath="//input[@id='txtUserID']")
	WebElement username;
	
	@FindBy(xpath="//input[@id='txtPassword']")
	WebElement password;
	
	@FindBy(xpath="//span[@class='loginButtonText']")
	WebElement loginbtm;
  
	 
    public LoginPageDMPRealTime()
    {
    	PageFactory.initElements(driver, this);
    }
    			
   
    public PegaMarktDMPRealTime login(String uid,String pwd)
    {
    	username.sendKeys(uid);
    	password.sendKeys(pwd);
    	loginbtm.click();
    	return new PegaMarktDMPRealTime();
    }
    
}
