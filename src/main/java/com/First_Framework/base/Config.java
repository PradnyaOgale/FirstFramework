package com.First_Framework.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * This class has methods to read all the properties available in application.properties file
 */
public class Config {

	public static String getBrowserName() throws FileNotFoundException{
		
		String base = System.getProperty("user.dir");
		String filePath = base+"/src/main/resources/application.properties";
		
		FileInputStream fis = new FileInputStream(filePath);
		
		Properties prop = new Properties();
		String value = null;
		 try {
			prop.load(fis);
			value = prop.getProperty("browser_name");
		} catch (IOException e) {
			e.printStackTrace();
		}
		 
		 return value;
	}
	
	public static String getAppUrl() throws FileNotFoundException{
		
		String base = System.getProperty("user.dir");
		String filePath = base+"/src/main/resources/application.properties";
		
		FileInputStream fis = new FileInputStream(filePath);
		
		Properties prop = new Properties();
		String value_url = null;
		try {
			prop.load(fis);
			value_url = prop.getProperty("app.url");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return value_url;
	}
}
