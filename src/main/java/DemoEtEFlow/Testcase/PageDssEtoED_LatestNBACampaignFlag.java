package DemoEtEFlow.Testcase;

import java.awt.AWTException;
import java.awt.List;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.poi.xssf.usermodel.XSSFSheet;
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

import Mccm.Pega.DMP.RealTime.PegaMarktDMPRealTime;
import Mccm.Pega.Outbound.PegaTestBase.TestBase;
import Mccm.Pega.excel.utility.Excel_Reader;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import java.io.FileOutputStream;



public class PageDssEtoED_LatestNBACampaignFlag extends TestBase {

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

		Thread.sleep(6000);

		driver.findElement(By.xpath("//input[@type='text'][@name='$PpyDisplayHarness$ppySearchText']")).sendKeys("D_LatestNBACampaignFlag");  
		Thread.sleep(6000); 

		driver.findElement(By.xpath("//*[@class='pi pi-search-2']")).click( );
		Thread.sleep(6000);    

		driver.findElement(By.xpath("//a[text()='Data Page']")).click( );
		Thread.sleep(6000);

		driver.findElement(By.xpath("//a[text()='D_LatestNBACampaignFlag']")).click( );
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


				// display validation of the Camp RUN id data

				WebElement w2;
				w2=driver.findElement(By.xpath("(//span[contains(.,'PR-')])[3]"));

				String CampRunID = w2.getText();

				System.out.println(CampRunID);

				Excel_Reader obj= new Excel_Reader("C:\\Users\\prout21\\git\\Automation_Framework\\MCCM\\MCCM\\src\\main\\java\\Mccm\\Pega\\TestData\\PegaOutputData.xlsx");

				String CampaigRUNid = obj.getCellValue("PegaOutputData", 1, 0);

				System.out.println(CampaigRUNid);

				Assert.assertEquals(CampRunID, CampaigRUNid); 

				// display validation of the ActiveOfferCountCmpltd data

				WebElement w3;

				w3=driver.findElement(By.xpath("(//a[@href='#'])[3]//following::span[28]"));

				String ActiveOfferCountCmpltd = w3.getText();

				System.out.println(w3.getText());

				Assert.assertEquals(ActiveOfferCountCmpltd, "Y"); 
				// display validation of the CmpgnDailyCycleCmpltd data

				WebElement w4;

				w4=driver.findElement(By.xpath("(//a[@href='#'])[5]//following::span[30]"));

				String CmpgnDailyCycleCmpltd = w4.getText();

				System.out.println(w4.getText());

				Assert.assertEquals(CmpgnDailyCycleCmpltd, "Y"); 

				// display validation of the DataExpCmpltdDMP data

				WebElement w5;

				w5=driver.findElement(By.xpath("(//a[@href='#'])[25]//following::span[50]"));

				String DataExpCmpltdDMP = w5.getText();

				System.out.println(w5.getText());

				Assert.assertEquals(DataExpCmpltdDMP, "Y"); 

				// display validation of the DataExpCmpltdEDWH data

				WebElement w6;

				w6=driver.findElement(By.xpath("(//a[@href='#'])[27]//following::span[52]"));

				String DataExpCmpltdEDWH = w6.getText();

				System.out.println(w6.getText());

				Assert.assertEquals(DataExpCmpltdEDWH, "Y"); 

				// display validation of the DataExpCmpltdKIASEPOS data

				WebElement w7;

				w7=driver.findElement(By.xpath("(//a[@href='#'])[29]//following::span[54]"));

				String DataExpCmpltdKIASEPOS = w7.getText();

				System.out.println(w7.getText());

				Assert.assertEquals(DataExpCmpltdKIASEPOS, "Y"); 

				// display validation of the DataExpCmpltdMAMODB data

				WebElement w8;

				w8=driver.findElement(By.xpath("(//a[@href='#'])[31]//following::span[56]"));

				String DataExpCmpltdMAMODB = w8.getText();

				System.out.println(w8.getText());

				Assert.assertEquals(DataExpCmpltdMAMODB, "Y"); 

				// display validation of the DataExpCmpltdOS data

				WebElement w9;

				w9=driver.findElement(By.xpath("(//a[@href='#'])[33]//following::span[58]"));

				String DataExpCmpltdOS = w9.getText();

				System.out.println(w9.getText());

				Assert.assertEquals(DataExpCmpltdOS, "Y"); 

				// display validation of the IsCmpgnSuccess data

				WebElement w10;

				w10=driver.findElement(By.xpath("(//a[@href='#'])[37]//following::span[62]"));

				String IsCmpgnSuccess = w10.getText();

				System.out.println(w10.getText());

				Assert.assertEquals(IsCmpgnSuccess, "Y"); 

				// display validation of the SaveLCSSCmpltd data

				WebElement w11;

				w11=driver.findElement(By.xpath("(//a[@href='#'])[41]//following::span[66]"));

				String SaveLCSSCmpltd = w11.getText();

				System.out.println(w11.getText());

				Assert.assertEquals(SaveLCSSCmpltd, "Y"); 

			}
		}
	}

}














