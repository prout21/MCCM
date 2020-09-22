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
import org.testng.Assert;
import org.testng.annotations.Test;

import Mccm.Pega.excel.utility.Excel_Reader;

public class PageDssEtoEd_latestdataloadFlag {

	@Test  
	public void VerifythedataloadedSuccessfully() throws InterruptedException, AWTException {
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

		driver.findElement(By.xpath("//input[@type='text'][@name='$PpyDisplayHarness$ppySearchText']")).sendKeys("d_latestdataloadFlag");  
		Thread.sleep(6000); 

		driver.findElement(By.xpath("//*[@class='pi pi-search-2']")).click( );
		Thread.sleep(6000);    

		driver.findElement(By.xpath("//a[text()='Data Page']")).click( );
		Thread.sleep(6000);

		driver.findElement(By.xpath("//a[text()='D_LatestDataLoadFlag']")).click( );
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

				Thread.sleep(6000);
				driver.findElement(By.xpath("//input[@type='checkbox'][@name='$PD_pzRunRecord$ppxRunWindow$gTABTHREAD1$ppxRunParameters$ppyFlushAll']")).click( );
				Thread.sleep(6000);

				Thread.sleep(6000);
				driver.findElement(By.xpath("(//div[@class='pzbtn-mid'])[3]")).click( );
				Thread.sleep(8000);


				// display validation of the DataLoadCmpltdCsndra data

				WebElement w3;

				w3=driver.findElement(By.xpath("(//a[@href='#'])[11]//following::span[31]"));

				String DataLoadCmpltdCsndra = w3.getText();

				System.out.println(w3.getText());

				Assert.assertEquals(DataLoadCmpltdCsndra, "Y"); 
				
				// display validation of the DataLoadCmpltdOracle data

				WebElement w4;

				w4=driver.findElement(By.xpath("(//a[@href='#'])[13]//following::span[33]"));

				String DataLoadCmpltdOracle = w4.getText();

				System.out.println(w4.getText());

				Assert.assertEquals(DataLoadCmpltdOracle, "Y"); 
			}

		}
	}
}






