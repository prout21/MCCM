/**
 * 
 */
package Mccm.Pega.DMP.RealTime;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;




/**
 * @author prout21
 *
 */
public class Restfulrequest {
	

           
      String endpoint = "http://mccm-191102761.eu-central-1.elb.amazonaws.com:8171/prweb/PRRestService/CSM/customerMarketingProductAPI/processNextBestAction" ;
	  

	  
	

 
	@Test
	
	public void Getresoponce() throws ClientProtocolException, IOException {
		
		//HttpClient client =  HttpClientBuilder.create().build(); 
		HttpClient client = new DefaultHttpClient();
		HttpGet request = new HttpGet(endpoint);
		HttpResponse response = client.execute(request);
		BufferedReader br = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
		String line="";
		StringBuffer  sb = new StringBuffer();
		while((line=br.readLine())!=null)
		{
		sb.append(line);
		}
		System.out.println(response.getStatusLine());
		 System.out.println(sb);
		}
	 
	}

 
