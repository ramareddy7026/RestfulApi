package com.qa.restclient;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.qa.testbase.Testbase;

public class Restclient {
	public CloseableHttpResponse get(String url,HashMap<String, String> headermap) throws ClientProtocolException, IOException
	{
		CloseableHttpClient httpclients = HttpClients.createDefault();
		HttpGet httpget=new HttpGet(url);
		for(Map.Entry<String, String > entry:headermap.entrySet())
		{
			httpget.addHeader(entry.getKey(), entry.getValue());
		}
		
		
		CloseableHttpResponse  closeablehttpresponse= httpclients.execute(httpget);
		return closeablehttpresponse;
	}
	
	
	

}
