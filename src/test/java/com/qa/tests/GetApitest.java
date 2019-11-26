package com.qa.tests;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import com.qa.restclient.Restclient;
import com.qa.testbase.Testbase;

public class GetApitest extends Testbase{
	Testbase testBase;
	String serviceUrl;
	String apiUrl;
	String url;
	Restclient restclient;
	CloseableHttpResponse closebaleHttpResponse;
	
	
	@BeforeMethod
	public void setUp() throws ClientProtocolException, IOException{
		testBase = new Testbase();
		serviceUrl = prop.getProperty("URL");
		apiUrl = prop.getProperty("serviceURL");
		//https://reqres.in/api/users
		
		url = serviceUrl + apiUrl;
		
	}
	@Test(priority=1)
	public void getApitestwithheaders() throws ClientProtocolException, IOException
	{
		restclient=new Restclient();
		HashMap<String,String> headermap=new HashMap<String, String>();
		headermap.put("Content-Type", "application/json");
		//headermap.put("", "");
		//headermap.put("","");
		CloseableHttpResponse closeablehttprespnse = restclient.get(url, headermap);
		int statuscode = closeablehttprespnse.getStatusLine().getStatusCode();
		System.out.println(statuscode);
		//Assert.assertEquals(actual, expected, message);
		String responsestring = EntityUtils.toString(closeablehttprespnse.getEntity(),"UTF-8");
		JSONObject jsonresponse=new JSONObject(responsestring);
		
	}
	

}
