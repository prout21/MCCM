/**
 * 
 */
package DemoEtEFlow.InOutbound;

import static io.restassured.RestAssured.given;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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

import io.restassured.http.ContentType;




/**
 * @author p.rout 
 *
 */
public class RestfulrequestTest2 {
	

           
      String endpoint = "http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction";
	private String name;
	  
	@Test
	
	public void VerifyHitRESTfulGETRequestResponseSuccessfully() throws ClientProtocolException, IOException {
		
	 
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(endpoint);
		HttpResponse response = client.execute(request);
		
 		BufferedReader br = new BufferedReader(new InputStreamReader((response.getEntity().getContent()))); 
 		String response1 = br.readLine(); 
 		System.out.println("response" + response); 
		
		
 	//  	String responseString = EntityUtils.toString(response.getEntity(), "UTF-8");
//	 	
   ///      	String response11 = responseString.readLine(); 
// 	   	System.out.println("response" + response); 
		   
	 //       JSONObject responseJson = new JSONObject(br);
	       
	//       JSONArray jsonArray = new JSONArray(br);
          
 		Map<String, Object> map = new HashMap<String, Object>();
 		map.put("name" ,"MCC_3102;4G_SWAP");
 		System.out.println(map);
 		JSONObject  request1 = new JSONObject(map);
 		System.out.println(request);


 		
		   System.out.println("Response Json from API-->+ responseJson");
		   
 
	 
		   
		   Header[]  headersArray = response.getAllHeaders();
		   
		   HashMap<String,String> allHeaders = new  HashMap<String,String>();
		   
		   for(Header header : headersArray ) {
		   
		   allHeaders.put(header.getName(), header.getValue());
		    
		 
	    	System.out.println("Headers Arry----> +allHeaders");
		
 
	
	 	int StatusCode = (response.getStatusLine().getStatusCode());
	 	
	   	
     	Assert.assertEquals(StatusCode, 200, "Status code is not 200");
      	

  	   
	}
	}
}
      	
    	
 
	 
 

 
