/**
 * 
 */
package DemoEtEFlow.InOutbound;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.CookiePolicy;
import java.util.HashMap;
import java.util.Map;

import javax.xml.crypto.dsig.XMLObject;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.apache.xmlbeans.impl.values.XmlObjectBase;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.XML;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mongodb.util.JSON;

import static io.restassured.RestAssured.*;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.testng.Assert.assertTrue;



/**
 * @author p.rout 
 *
 */
public class RestAPIGetCall {
	
  

	@Test(priority=1)
	
	public void VerifyRESTAPIGETRequestResponseStatusCodeChkSuccessfully() {
		
       Response response =  get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction");
	 
       // Response response   = get("https://reqres.in/api/users?page=2\"");
  	   
	//	 Response response   = post("https://ukwtsvulx386.elabs.svcs.entsvcs.net:18576"); 
      //  Response response   = get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processOffersResult");
	
//	System.out.println(response.asString());
	System.out.println(response.getBody().asString());
	System.out.println(response.getStatusCode());
	System.out.println(response.getStatusLine());
	System.out.println(response.getHeader("content-type"));
	System.out.println(response.getTime());
//	System.out.println(response.contentType());
//	System.out.println(response.getContentType());
//	System.out.println(response.xmlPath());
//	System.out.println(response.andReturn());
//	System.out.println(response.toString());
//	System.out.println(response.header(DEFAULT_BODY_ROOT_PATH));
//	System.out.println(response.asInputStream());
	
	System.out.println(response.getBody().print());

	
  	int StatusCode = (response. getStatusCode());
 	 	 	
 	Assert.assertEquals(StatusCode, 200, "Status code is not 200");
	
		}
	
	@Test(priority=2)

	public void VerifyRESTAPIGETRequestResponseMessageSuccessfully() {

//	Map<String, Object> map = new HashMap<String, Object>();
//	
//	map.put("name" ,"MCC_3102;4G_SWAP");
//	System.out.println(map);
	
//	JSONObject  request = new JSONObject(map);
		
	  JSONObject  request = new JSONObject();
	   
  // request.put("name" ,"MCC_3102;4G_SWAP");
 //	request.put("first_name","Michael");
	 System.out.println(request.toString());
 

         // Response response   = get("https://reqres.in/api/users?page=2\"");
	 
 	
       //  Response response =  get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction");
 	
// 	    Headers  headersArray = response.getHeaders();
// 	   
// 	   HashMap<String,String> allHeaders = new  HashMap<String,String>();
// 	   
// 	   for(io.restassured.http.Header header : headersArray ) {
//    
// 	   allHeaders.put(header.getName(), header.getValue());
// 	    
// 	 
//   	System.out.println("Headers Arry----> +allHeaders");
	

   //given().header("Content-Type", "application/json").
      given().header("Content-Type", "application/xml").
	    contentType(ContentType.JSON).
	      accept(ContentType.JSON).
	      body(request).
	     when().
 //   get("https://reqres.in/api/users?page=2\"").
    
  //  get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processOffersResult").
        
    post("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction").
	         
	      then().statusCode(200).
	      log().all();
	   }
	
	 
		
		
 
 
//		
//		private String token_resource = "C:\\Users\\prout21\\git\\Automation_Framework\\MCCM\\MCCM\\Response\\css1identity.jks";
//	    private String endpoint_rest="http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction";
//	    private String acessToken;
//
//	   // @When("^user gets access token using userId \"(.+)\" and password \"(.+)\"$")
//	public void getAccessToken(String userName, String password){
//	    RequestSpecification requestSpec = RestAssured.with();
//	    requestSpec.given().contentType("application/json");
//	    requestSpec.headers("Authorization", "Basic  your-string-here");
//	    Response response = requestSpec.post(endpoint_rest + token_resource + password + "&password=" + password + "&client_id=yourApp&grant_type=password");
//	    String responseMsg = response.asString();
//	    System.out.println(">> responseMsg=" + responseMsg);
//	 //   assertTrue("Missing access token",responseMsg.contains("access_token"));
//	    System.out.println(">> Get Access token RESPONSE: " + responseMsg);
//
////	    DocumentContext doc = JsonPath.parse(responseMsg);
//	 //   acessToken= doc.read("access_token");
//
//	    System.out.println(" >> doc.read access_token= " + acessToken);  
	 
	} 
 
 


 
 