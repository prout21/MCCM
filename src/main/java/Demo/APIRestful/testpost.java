package Demo.APIRestful;

import java.util.Map;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class testpost {
	
 
	@Test
 
	
	// String name ="MCC_3102";
	
	public  static Response requestUtilitypostbody(String url,Map<String,String>map) {  
		
		String url1 = "http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction";
		
		Response resp =  RestAssured.given().relaxedHTTPSValidation().contentType(ContentType.JSON)
				
				.header("Content-Type", "application/json").
			    header(" ", " ").
			     header(" ", " ").body(map).
			
			     when().
	 	        
		post(url1);
			         
 		 return resp;      

}
}