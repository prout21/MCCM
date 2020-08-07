package DemoEtEFlow.InOutbound;

 
	import java.io.IOException;
	import java.util.concurrent.TimeUnit;
	import junit.framework.Assert;
	import org.apache.http.client.ClientProtocolException;
	import org.junit.After;
	import org.junit.Before;
	import org.junit.Test;
	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.firefox.FirefoxDriver;

	@SuppressWarnings("deprecation")
	public class ApiTest {
		private WebDriver driver;
		private String baseUrl;
		

		@Test
		public void test() throws ClientProtocolException, IOException {
			driver.get(baseUrl);
			driver.navigate().to("https://ukwtsvulx386.elabs.svcs.entsvcs.net:18576");	
		 WebElement webElement=driver.findElement(By.tagName("pre"));
		 DMPApiResponse weatherApiResponse=new DMPApiResponse();
		 String ExpectedString=weatherApiResponse.GetResponse();
		 Assert.assertTrue(webElement.getText().equals(ExpectedString));
		}

	}


