package com.First_Framework.stepdefinitions;

import com.First_Framework.pages.HomePage;
import com.First_Framework.pages.SearchResultPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProductSearchSteps {

	@Given("Enter Levis in search component")
	public void enterProductToSearches(){
		HomePage homepage = new HomePage();
		homepage.enterProductToSearch("Levis");
	}
	
	@When("User clicks on a search magnifier")
	public void clickOnSearchMagnifier() {
		HomePage homepage = new HomePage();
		homepage.clickOnSearchMagnifier();
	}
	
	@Then("All results populated must contain word Levis in it")
	public void assertResults(){
		SearchResultPage srp = new SearchResultPage();
		srp.verifyProductTitlesContains("Levis");
	}
}
