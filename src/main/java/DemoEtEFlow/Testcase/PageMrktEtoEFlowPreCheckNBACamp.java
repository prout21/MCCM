package DemoEtEFlow.Testcase;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
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

public class PageMrktEtoEFlowPreCheckNBACamp   {
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
	 driver.switchTo().frame(0);
	 int size = driver.findElements(By.tagName("iframe")).size();
	 System.out.println(size);
	 Thread.sleep(6000);
	 driver.findElement(By.xpath("(/html[1]/body[1]/div[2]/form[1]/div[3]/div[1]/table[1]/tbody[1]/tr[1]/td[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]/table[1]/tbody[1]/tr[1]/td[2]/div[1]/table[1]/tbody[1]/tr[1]/th[2]/div[1]/span[1]/a[1])")).click( );
	                               		   
	 Thread.sleep(6000);
	 driver.findElement(By.xpath("//input[@type='text'][@name='$PpyFilterCriteria_pgRepPgSubSectionpzViewInstancesB_pxResults_pzViewInstances_1$ppyColumnFilterCriteria$gpyPurpose2$ppySearchText']")).sendKeys("NBACampaignName");  
	 Thread.sleep(6000);
	 driver.findElement(By.xpath("//text()[.='Apply']/ancestor::button[1]")).click( );
	 Thread.sleep(6000);
	 driver.findElement(By.xpath("//div[contains(text(),'MCCM')]")).click( );
	 Thread.sleep(8000);
	  driver.switchTo().defaultContent();
	  Thread.sleep(8000);
	  driver.switchTo().frame("PegaGadget1Ifr");
	  Thread.sleep(8000);
 

		WebElement w3=driver.findElement(By.xpath("//input[@type='text'][@name='$PRH_1$ppySetting']"));
	 
		String NBACampaignNamevalue = w3.getAttribute("value");

		System.out.println(NBACampaignNamevalue);
		File file = new File("C:\\Users\\prout21\\git\\Automation_Framework\\MCCM\\MCCM\\src\\main\\java\\Mccm\\Pega\\TestData\\PegaOutputData1.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook();

		XSSFSheet sh = wb.createSheet("PegaOutputData");

		sh.createRow(1).createCell(0).setCellValue(NBACampaignNamevalue);

				sh.createRow(0).createCell(0).setCellValue("NBACampaignNamevalue");

				try {
					FileOutputStream fos = new FileOutputStream(file);
					wb.write(fos);
				}catch (Exception e) {

				}
		 
	 
	}
}

 
