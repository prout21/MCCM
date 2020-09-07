package DemoEtEFlow.Testcase;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class PageDssEtoETruncate {
   
   @Test  
    public void lunchChromBrowser() throws InterruptedException, AWTException {
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\prout21\\Downloads\\chromedriver_win32\\chromedriver.exe");  
	 WebDriver driver = new ChromeDriver();
	 driver.get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8573/prweb");
	 driver.findElement(By.xpath("//input[@id='txtUserID']")).sendKeys("prafulla" );
	 driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("rules" );
	 driver.findElement(By.xpath("//span[@class='loginButtonText']")).click( );
	 Thread.sleep(8000);
	 driver.findElement(By.xpath("//a[@id='appview-nav-toggle-one']")).click( );
	 Thread.sleep(8000);
	 //driver.findElement(By.xpath("//h3[@id='headerlabel2350']")).click( );
	 //Thread.sleep(8000);
	 String xpath="(//h3[@class='layout-group-item-title'])[5]";
	 driver.findElement(By.xpath(xpath)).click( );
	 Thread.sleep(6000);
	 String xpath1="(//div[@id='iconExpandCollapse'])[15]";
	 driver.findElement(By.xpath(xpath1)).click( );
	 Thread.sleep(6000);
	 JavascriptExecutor js = (JavascriptExecutor) driver;
	 WebElement element = driver.findElement(By.xpath("//a[text()='Dynamic System Settings']"));
	 js.executeScript("arguments[0].scrollIntoView();", element);
	 driver.findElement(By.xpath("//a[text()='Dynamic System Settings']")).click( );
	 Thread.sleep(6000);
//	 driver.switchTo().frame(0);
//	 int size = driver.findElements(By.tagName("iframe")).size();
//	 System.out.println(size);
//	 Thread.sleep(6000);
	
	    
		     
			 Thread.sleep(6000);
			 
			 driver.findElement(By.xpath("//input[@type='text'][@name='$PpyDisplayHarness$ppySearchText']")).sendKeys("LegacyChannelSnapshot");  
			 Thread.sleep(6000); 
			 
			 driver.findElement(By.xpath("//*[@class='pi pi-search-2']")).click( );
			 Thread.sleep(6000);    
			 
			 driver.findElement(By.xpath("//a[text()='Data Set']")).click( );
			 Thread.sleep(6000);
			 
			 driver.findElement(By.xpath("//a[text()='LegacyChannelSnapshot']")).click( );
			 Thread.sleep(6000);
			 
			 driver.switchTo().defaultContent();
			  Thread.sleep(8000);
			  driver.switchTo().frame("PegaGadget1Ifr");
			 
			 
			 
			 driver.findElement(By.xpath("//*[@class='pi pi-caret-down margin-l-1x']")).click( );
			 Thread.sleep(6000);
			 
			
			 String xpath2 = "(//text()[.='Run']/ancestor::a[1])[2]";
			 WebElement element2 =  driver.findElement(By.xpath(xpath2));
		     Actions  action = new Actions(driver);
		     action.moveToElement(element2).click().build().perform();
		     Thread.sleep(6000);
		     
		
		     
		  //	// driver.switchTo().defaultContent();
		//	//  Thread.sleep(8000);
		//	//  driver.switchTo().frame("EXPAND-OUTERFRAME");
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

		   //  //Switching back to Parent Window  
		  //   //driver.switchTo().window(Parent_Window);  
			  
		     Thread.sleep(6000);
			 
			 driver.findElement(By.xpath("//select[@name='$PD_pzRunRecord$ppxRunWindow$gTABTHREAD1$ppxRunParameters$ppyTestInputs$ppyOperationIndex']")).sendKeys("Truncate");
			 Thread.sleep(6000);
			 
			 
//			 String xpath3 = "//text()[.='Truncate']";
//			 WebElement element3 =  driver.findElement(By.xpath(xpath3));
//		     Actions  action1 = new Actions(driver);
//		     action1.moveToElement(element3).click().build().perform();
		  
		 
			 Thread.sleep(6000);
			 driver.findElement(By.xpath("//input[@type='checkbox'][@name='$PD_pzRunRecord$ppxRunWindow$gTABTHREAD1$ppxRunParameters$ppyTestInputs$ppyOperation$ppyTracingEnabled']")).click( );
			 Thread.sleep(6000);
			 
			 Thread.sleep(6000);
			 driver.findElement(By.xpath("(//div[@class='pzbtn-mid'])[2]")).click( );
			 Thread.sleep(6000);
			 
//			 String xpath3="(//text()[.='Run'])[3]";
//			 driver.findElement(By.xpath(xpath3)).click( );
			 
	 
		 
			 
             driver.close();
		     }
		      }
		     driver.switchTo().window(mainWindow);
  
   }
		    
		      
		 




}




		      
		      
