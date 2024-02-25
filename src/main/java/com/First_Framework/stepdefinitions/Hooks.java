package com.First_Framework.stepdefinitions;

import java.io.FileNotFoundException;

import org.testng.annotations.AfterMethod;

import com.First_Framework.Keywords.Keyword;
import com.First_Framework.base.Config;

import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {

	@Before
	public void setUp() throws FileNotFoundException {
		Keyword keyword = new Keyword();

		keyword.openBrowser(Config.getBrowserName());
		keyword.maximizeBrowser();
		keyword.openUrl(Config.getAppUrl());
	}
	
	@After
	public void tearDown(){
		Keyword keyword = new Keyword();
		keyword.quitAllWindows();
	}
}
