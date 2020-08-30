/**
 * 
 */
package Demo.APIRestful;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.CookiePolicy;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;
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
public class RestAPIKeystoreGetPostCall {
	
	@Test(priority=1)
	
public  void VerifyKeyStoreCerificateSuccessfully() throws KeyStoreException, NoSuchAlgorithmException, CertificateException, IOException, UnrecoverableEntryException {
		
		//Connect to server use Keystore Certificate
	
	KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
		System.out.println("hi");
		char[] keyStorePassword = "password".toCharArray();  
		try(InputStream keyStoreData = new FileInputStream("C:\\Users\\prout21\\css1identity.jks"))
		{  //keystore.ks       //is the file from where we want to load the file  
			keystore.load(keyStoreData, keyStorePassword); 
			System.out.println(keyStoreData);
			System.out.println(keyStorePassword);
		}
	
	char[] keyPassword = "password".toCharArray();  
	KeyStore.ProtectionParameter entryPassword =  
	        new KeyStore.PasswordProtection(keyPassword);  
	System.out.println("hi1");
	KeyStore.Entry keyEntry = keystore.getEntry("keyAlias", entryPassword);  
	System.out.println("hi2");

	 
	
	char[] keyStorePassword1 = "password".toCharArray();  
	try (FileOutputStream keyStoreOutputStream = new FileOutputStream("C:\\Users\\prout21\\jks\\css1identity.jks")) {  
	    keystore.store(keyStoreOutputStream, keyStorePassword1);
	    }  
	}  
	

	@Test(priority=2)
	
	public void VerifyRESTAPIGETRequestStatusCodeChkSuccessfully() {
		
    Response response =  post("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction");
	 
   //   Response response   = get("https://reqres.in/api/users?page=2\"");
  	   
     //	 Response response   = post("https://ukwtsvulx386.elabs.svcs.entsvcs.net:18576"); 
      //  Response response   = get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processOffersResult");
	
//	System.out.println(response.asString());
	System.out.println(response.getBody().asString());
	System.out.println(response.getStatusCode());
	System.out.println(response.getStatusLine());
	System.out.println(response.getHeader("content-type"));
	System.out.println(response.getTime());
 
	
	System.out.println(response.getBody().print());

	
  	int StatusCode = (response. getStatusCode());
 	 	 	
 	Assert.assertEquals(StatusCode, 200, "Status code is not 200");
	
		}
	
	@Test(priority=3)

	public void VerifyRESTAPIGETRequestResponseMessageSuccessfully() throws IOException {

		Map<String, String> postContent = new HashMap<>();


		postContent.put("name","Online");
		postContent.put("type","Inbound");
		postContent.put("value","7cd536xz3000");
		postContent.put("schemeID","MobileHashed");
		postContent.put("container","CSM");
		postContent.put("characteristicName","Transaction");
		postContent.put("value","Prolongation");
		postContent.put( "type","Intent");


		//	System.out.println(map);

		//	JSONObject  request = new JSONObject(map);

		JSONObject  request = new JSONObject();

		// request.put("name" ,"MCC_3102;4G_SWAP");
		//	request.put("first_name","Michael");
		// map.put("container", "CustomerOfferOnline");

		System.out.println(request.toString());


		//  Response response1   = get("https://reqres.in/api/users?page=2\"");


		//     Response response1 =  post("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction");

                Response response1 =  post("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction");

	  	//      Response response1   = post("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processOffersResult");

		// 	    Headers  headersArray = response.getHeaders();
		// 	   
		//  	   HashMap<String,String> allHeaders = new  HashMap<String,String>();
		//  	   
		// 	   for(io.restassured.http.Header header : headersArray ) {
		//     
		//  	   allHeaders.put(header.getName(), header.getValue());
		// 	    
		//  	 
		//    	System.out.println("Headers Arry----> +allHeaders");


		given().
		header("Content-Type","application/json;charset=utf-8").
		header("X-Request-Id","GUID likead785657").
		header("X-MCCM-CorrelationID","GUID like ad64557").
		header("X-MCCM-Usecase","DMP Realtime").
		//  header("Content-Type", "application/xml").
		//  contentType(ContentType.JSON).
		with().
		body(postContent).
		//  accept(ContentType.JSON).


		when().
		//    post("https://reqres.in/api/users?page=2\"").

		//  post("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processOffersResult").

		//  post("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8576/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction").

	 	post("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction").
       
	//	post("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processOffersResult").
		
		then().
		//statusCode(200).
		log().all();
	
  	 	System.out.println(response1.getStatusCode());
  	 	
 	 	int StatusCode = (response1.getStatusCode());
	  	  	 	
	  	  	Assert.assertEquals(StatusCode, 200, "Status code is not 200");
	}
	
	@Test(priority=4)

	public void VerifyRESTAPIPostOfferSuccessfully() throws IOException {

		 

		//	System.out.println(map);

		//	JSONObject  request = new JSONObject(map);

//		JSONObject  request = new JSONObject();
//
//		// request.put("name" ,"MCC_3102;4G_SWAP");
//		//	request.put("first_name","Michael");
//		// map.put("container", "CustomerOfferOnline");
//
//		System.out.println(request.toString());


		//  Response response1   = get("https://reqres.in/api/users?page=2\"");


		//     Response response1 =  post("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction");


		//    Response response1 =  post("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction");

	  //	      Response response1   = post("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processOffersResult");

		// 	    Headers  headersArray = response.getHeaders();
		// 	   
		//  	   HashMap<String,String> allHeaders = new  HashMap<String,String>();
		//  	   
		// 	   for(io.restassured.http.Header header : headersArray ) {
		//     
		//  	   allHeaders.put(header.getName(), header.getValue());
		// 	    
		//  	 
		//    	System.out.println("Headers Arry----> +allHeaders");


		given().
		
		header("Content-Type","application/json;charset=utf-8").
		 
		when().
		 
	
    	get("http://mccm-191102761.eu-central-1.elb.amazonaws.com:8576/prweb/PRRestService/CSM/customerMarketingProductAPI/processOffersResult").
		
		then().
	 
		log().all();
	
//  	 	System.out.println(response1.getStatusCode());
//  	 	
// 	 	int StatusCode = (response1.getStatusCode());
//	  	  	 	
//	  	  	Assert.assertEquals(StatusCode, 200, "Status code is not 200");
	}
		}
 
 
 


 
 