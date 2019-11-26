package com.qa.testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Testbase {
	public Properties prop;
	
	public Testbase()
	{
		try
		{
			prop=new Properties();
			FileInputStream fis=new FileInputStream(System.getProperty("D:\\eclipse\\apirest\\ram_API1\\src\\main\\java\\com\\qa\\config\\config.properties"));
			prop.load(fis);
		}
		catch(FileNotFoundException f)
		{
		 f.printStackTrace();
		}
		catch(IOException i)
		{
			i.printStackTrace();
		}
	}

}
