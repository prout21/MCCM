package DemoEtEFlow.InOutbound;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.testng.annotations.Test;


 
public class DMPApiResponse {
	
  // 	private final String USER_AGENT="Mozilla/5.0";
	
	 @Test  
	public String GetResponse() throws ClientProtocolException, IOException
	{
		StringBuffer result=new StringBuffer();
		HttpClient client=new DefaultHttpClient();
		String url="https://ukwtsvulx386.elabs.svcs.entsvcs.net:18576";
		HttpGet request=new HttpGet(url);
	//	request.addHeader("User-Agent",USER_AGENT);
		HttpResponse response=client.execute(request);
		int responseCode=response.getStatusLine().getStatusCode();
		System.out.println("Response Code: " + responseCode);
		try{
		if(responseCode==200)
			
		{
			System.out.println("Get Response is Successfull");
			BufferedReader reader=new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
			String line="";
			while((line=reader.readLine())!=null)
			{
				result.append(line);
				System.out.println(result.toString());
			}
		}
		return result.toString();
		
	}
		catch(Exception ex)
	{
		result.append("Get Response Failed");
		return result.toString();
	}

}
}

 
