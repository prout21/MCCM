package DemoEtEFlow.InOutbound;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.testng.annotations.Test;

public class Apitest1 {

    /**
     * @param args
     */
	
	@Test
	
    public static void main(String[] args) {
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet("https://www.google.com/?q=java");
        try {
            HttpResponse response = client.execute(request);
            System.out.println(response.getStatusLine());

        } catch (Exception e) {
            e.printStackTrace();

        }

    }
}