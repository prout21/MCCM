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

public class Page2ScaleDssStudio {

	@Test  
	public void NBABatchCampaignInboundSuccessfull() throws InterruptedException, AWTException {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\prout21\\Downloads\\chromedriver_win32\\chromedriver.exe");  
		WebDriver driver = new ChromeDriver();
		driver.get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8573/prweb");
		driver.findElement(By.xpath("//input[@id='txtUserID']")).sendKeys("prafulla" );
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("rules" );
		driver.findElement(By.xpath("//span[@class='loginButtonText']")).click( );
		Thread.sleep(8000);
		String xpath = "(//i[@class='pi pi-caret-down'])[1]";
		WebElement element =  driver.findElement(By.xpath(xpath));
		Actions  action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
		Thread.sleep(6000);
		String xpath3 = "//span[text()='System']";
		WebElement element3 =  driver.findElement(By.xpath(xpath3));
		Actions  action3 = new Actions(driver);
		action3.moveToElement(element3).build().perform();

		Thread.sleep(6000);

		String xpath1 = "//span[text()='Operations']";
		WebElement element1 =  driver.findElement(By.xpath(xpath1));
		Actions  action1 = new Actions(driver);
		action1.moveToElement(element1).build().perform();
		Thread.sleep(6000);
		String xpath2 = "//span[text()='Logs']";
		WebElement element2 =  driver.findElement(By.xpath(xpath2));
		Actions  action2 = new Actions(driver);
		action2.moveToElement(element2).click().build().perform();
		Thread.sleep(6000);

		driver.switchTo().frame("PegaGadget0Ifr");	
		Thread.sleep(6000);

		driver.findElement(By.xpath("//a[text()='Log files']")).click( );
		Thread.sleep(6000);


		String winHandleBefore = driver.getWindowHandle();
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}

		Thread.sleep(6000); 
		driver.findElement(By.xpath("(//a[contains(@href,'/prweb/-Y_n0g1ZkUjELaFhdaBKnhbDHrR3m1dq*/!TABTHREAD0') ])[3]")).click( );

		WebElement element6 = driver.findElement(By.xpath("//input[@type='text' and @name='filterString']"));
		Thread.sleep(6000); 
		element6.clear();


		Thread.sleep(6000);
		driver.findElement(By.xpath("//input[@type='button' and @value='Apply']")).click( );
		Thread.sleep(6000);
		String winHandleAfter = driver.getWindowHandle();
		for(String winChildHandle : driver.getWindowHandles()) {
			if(!winChildHandle.equals(winHandleBefore) 
					&& !winChildHandle.equals(winHandleAfter)) {
				driver.switchTo().window(winChildHandle);
			}
		}

	}
}