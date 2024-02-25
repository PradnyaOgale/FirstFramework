package com.First_Framework.stepdefinitions;

import com.First_Framework.Keywords.Keyword;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SendOtpSteps {
	
	@Given("क्रोम ब्राउज़र खोले और एप्प यूआरएल ओपन करे")
	public void openBrowserAndLaunchUrl(){
		Keyword keyword = new Keyword();
		keyword.openBrowser("Chrome");
		keyword.openUrl("https://www.myntra.com/");
	}
	
	@When("User enters invalid phone number")
	public void user_enters_invalid_phone_number() {
	   
	}

	@Then("User should get error message")
	public void user_should_get_error_message() {
	    
	}
	
}
