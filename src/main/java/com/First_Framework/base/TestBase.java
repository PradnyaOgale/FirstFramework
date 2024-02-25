package com.First_Framework.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.First_Framework.Keywords.Keyword;

public class TestBase {

	Keyword keyword = new Keyword();
	@BeforeMethod
	public void setpUp() throws Exception {
		
		
	
		keyword.openBrowser(Config.getBrowserName());
		keyword.maximizeBrowser();
		keyword.openUrl(Config.getAppUrl());
	}
	
	@AfterMethod
	public void tearDown(){
		
		keyword.quitAllWindows();
	}
}
