package com.First_Framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.First_Framework.Keywords.Keyword;

public class GiftCardPage {

	public GiftCardPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}
	
	@FindBy(css = "div.occasionspicker-occasionsContainer>div:nth-child(6)")
	public WebElement diwaliComponent;
	
	public void clickOnDiwali() {
		diwaliComponent.click();
	
	}
	
	@FindBy(css = "div.occasionspicker-occasionDivSelected ")
	public WebElement resultDiwaliComponent;
	public void verifyDiwaliCard(){
		String text = resultDiwaliComponent.getText();
		System.out.println(text);
		Assert.assertTrue(text.contains("Diwali"));
	}
}
