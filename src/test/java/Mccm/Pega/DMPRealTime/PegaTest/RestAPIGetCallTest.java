/**
 * 
 */
package Mccm.Pega.DMPRealTime.PegaTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.CookiePolicy;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mongodb.util.JSON;

import static io.restassured.RestAssured.*;

import io.restassured.http.ContentType;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;




/**
 * @author p.rout 
 *
 */
public class RestAPIGetCallTest {
	
  	@Test(priority=1)
	
	public void VerifyRESTAPIGETRequestResponseStatusCodeChkSuccessfully() {
		
	  Response response =  get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction");
	 
 	// Response response   = get("https://reqres.in/api/users?page=2\"");
	
//	System.out.println(response.asString());
	System.out.println(response.getBody().asString());
	System.out.println(response.getStatusCode());
	System.out.println(response.getStatusLine());
	System.out.println(response.getHeader("content-type"));
	System.out.println(response.getTime());
	
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
 //	request.put("name" ,"MCC_3102;4G_SWAP");
 //	request.put("first_name","Michael");
	System.out.println(request);
 

	// Response response   = get("https://reqres.in/api/users?page=2\"");
	 
 	
         Response response =  get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction");
 	
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
	

  	 given().header("Content-Type", "application/json").
	    contentType(ContentType.JSON).
	      accept(ContentType.JSON).
	      body(request).
	     when().
	  //  get("https://reqres.in/api/users?page=2\"").
	     get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction").
	      then().statusCode(200).
	      log().all();
	   }
    
	
	}
 


 
 