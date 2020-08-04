package DemoEtEFlow.InOutbound;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import Mccm.Pega.Outbound.PegaMain.HomePage;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;

public class PageMrktEtoEFlowDmpRealTime extends TestBase  {
 
 

@Test  
     public void VerifyDMPrealtimerunSuccessfull() throws InterruptedException, AWTException {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\prout21\\Downloads\\chromedriver_win32\\chromedriver.exe");  
	 WebDriver driver = new ChromeDriver();
	 driver.get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8573/prweb");
	 driver.findElement(By.xpath("//input[@id='txtUserID']")).sendKeys("prafulla" );
	 driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("rules" );
	 driver.findElement(By.xpath("//span[@class='loginButtonText']")).click( );
	 Thread.sleep(8000);
	 
	 String xpath = "(//i[@class='pi pi-caret-down'])[2]";
	 WebElement element =  driver.findElement(By.xpath(xpath));
     Actions  action = new Actions(driver);
     action.moveToElement(element).click().build().perform();
     Thread.sleep(6000);
     String  s1 = "(//span[@class='menu-item-title'])[5]";
      driver.findElement(By.xpath(s1)).click( );
      Thread.sleep(8000);
      String mainWindow=driver.getWindowHandle();
      System.out.println(mainWindow);
      // It returns no. of windows opened by WebDriver and will return Set of Strings
      Set<String> set =driver.getWindowHandles();
      // Using Iterator to iterate with in windows
      Iterator<String> itr= set.iterator();
      while(itr.hasNext())
      {
      String childWindow=itr.next();
      // Compare whether the main windows is not equal to child window. If not equal, we will close.
      if(!mainWindow.equals(childWindow)){
      driver.switchTo().window(childWindow);
     
      Thread.sleep(8000);
 	 driver.findElement(By.xpath("//a[@id='appview-nav-toggle-one']")).click( );
 	 Thread.sleep(8000);
 	 driver.findElement(By.xpath("//span[text()='Campaigns']")).click( );
 	 Thread.sleep(8000);
 	 int size = driver.findElements(By.tagName("iframe")).size();
	 System.out.println(size);
  
     driver.switchTo().frame(1);
     
     Actions actions = new Actions(driver);

     Robot robot = new Robot();

     robot.mouseMove(50,50);

     actions.click().build().perform();

     robot.mouseMove(200,70);

     actions.click().build().perform();

      Thread.sleep(8000);
 	  driver.findElement(By.xpath("//*[@class='pi pi-caret-down']")).click( );
 	  Thread.sleep(8000);
 	  driver.findElement(By.xpath("//span[text()='Multi-Channel Campaign']")).click( );
	  Thread.sleep(8000);
	  
	  driver.switchTo().defaultContent();
	  System.out.println("I am in outer frame.......................");
	  int size1 = driver.findElements(By.tagName("iframe")).size();
	  System.out.println(size1);
	  driver.switchTo().frame(2);
	  System.out.println("i am ineer frame no ");
	  Thread.sleep(8000);
	  
	  driver.findElement(By.xpath("//input[@type='text'][@name='$PpyWorkPage$ppyLabel']")).sendKeys("DMPREALTIME2");
	  Thread.sleep(8000);
      driver.findElement(By.xpath("//span[text()='Build']")).click( );
      Thread.sleep(8000);
      
       driver.findElement(By.cssSelector("button[name='ContainerWithHeader_pyWorkPage.ProgramConfiguration.StrategyContainer_7']")).click( );
      
 

        Thread.sleep(6000);
    	  driver.findElement(By.xpath("//input[contains(@name,'pFilterCriteriaDisplay$ppyValue')]")).sendKeys("Test Channel");  
    	  Thread.sleep(6000);       
    	  driver.findElement(By.xpath("//*[contains(@class,'pi-search')]")).click( );
          
    	  Thread.sleep(6000);
   	  driver.findElement(By.xpath("(//div[contains(@data-repeat-source,'MultiSelectCardSelector')]//button[text()='Add'])[1]")).click();  
   	  Thread.sleep(6000); 
    
 
		 driver.findElement(By.xpath("//button[text()='Apply']")).click( );
 
		 Thread.sleep(6000);
		 
		 JavascriptExecutor js2 = (JavascriptExecutor) driver;
		 WebElement element3 = driver.findElement(By.xpath("//div[text()='Engagement']"));
		 js2.executeScript("arguments[0].scrollIntoView();", element3);	
		 
		 
		 driver.findElement(By.cssSelector("button[name='EngagementContainer_pyWorkPage_7']")).click( );
		 
		               
		 Thread.sleep(6000);
		 WebElement checkbox =  driver.findElement(By.xpath("//input[@type='checkbox'][@name='$PpyWorkPage$pEnableContainers']"));
		 checkbox.click( );
		 Thread.sleep(6000);
		 WebElement radio1 =  driver.findElement(By.xpath("//img[@name='CalendarImg-8e50e8cd']"));
		 radio1.click( );
		 Thread.sleep(6000);
 
		 driver.findElement(By.xpath("//a[text()='Today']")).click( );
			 
	   	 Thread.sleep(6000);
		  WebElement checkbox1 =  driver.findElement(By.xpath("//text()[.='Configure containers']/ancestor::button[1]"));
		  checkbox1.click( );		
	       Thread.sleep(6000);
	       
	   
	    	  driver.findElement(By.xpath("//input[@type='text'][@name='$PRealtimeContainerMultiPg$pFilterCriteriaDisplay$ppyValue']")).sendKeys("CSM");  
	    	  Thread.sleep(6000);       
	    	  driver.findElement(By.xpath("//*[@name='WideDetailsSelectorPanel_RealtimeContainerMultiPg_53']")).click( );
	          //Get THE XPATH SYTLE BASE _REF ='RealtimeContainerMultiPg'
	    	  Thread.sleep(6000);
	   	  driver.findElement(By.xpath("(//div[contains(@data-repeat-source,'RealtimeContainerMultiPg')]//button[text()='Add'])[1]")).click();  
	   	  Thread.sleep(6000); 
	 	    
	     boolean searchIconPresence = driver.findElement(By.xpath("//button[text()='Add containers']")).isDisplayed();
	     boolean searchIconEnabled = driver.findElement(By.xpath("//button[text()='Add containers']")).isEnabled();

	     if (searchIconPresence==true && searchIconEnabled==true)

	     {
	     // click on the search button
	    	 System.out.println("i am in if----------------------");
	    	 Thread.sleep(6000);
	    	 WebElement element9 = driver.findElement(By.xpath("//button[text()='Add containers']"));
	    	 JavascriptExecutor executor3 = (JavascriptExecutor)driver;
	    	 executor3.executeScript("arguments[0].click();", element9);
	     Thread.sleep(6000);
	     System.out.println("i am in if---search-------------------");
         
	     }
	     	     
	     Thread.sleep(6000);
		 
         driver.findElement(By.xpath("//button[text()='Apply']")).click( );
		 Thread.sleep(6000);
		 driver.findElement(By.xpath("//button[text()='Save']")).click( );
		 Thread.sleep(6000);
	 
		 driver.findElement(By.xpath("//button[text()='Run']")).click( );
		 Thread.sleep(6000);
		 driver.findElement(By.xpath("//button[text()='Confirm']")).click( );
	
      }
      }
}
}
	 
		
		 
	
	    
		    
	 

    	
   
    
   
