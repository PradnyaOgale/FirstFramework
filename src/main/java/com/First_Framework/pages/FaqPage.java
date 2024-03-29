package com.First_Framework.pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.asserts.SoftAssert;

import com.First_Framework.Keywords.Keyword;

public class FaqPage {

	public FaqPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}
	@FindBy(css = "div.desktop-customerPolicies>a[data-reactid*=\"62\"]")
	public WebElement faqComponent;
	public void clickOnFaqOption() {
		faqComponent.click();
	}
	
	@FindBy(css = "div#phonepeQueries div.faqSection-question")
	public List<WebElement> faqQuestions;
	public List<String> getFaqQuestions(){
		
		Keyword keyword = new Keyword();
		return keyword.getTexts(faqQuestions);
	}
	public void verifyIfQuestionsHasPhonePeWord(){
		
		List<String> faqQuest = getFaqQuestions();
		SoftAssert softly = new SoftAssert();
		for (String faqQuests : faqQuest) {
			
			softly.assertTrue(faqQuests.contains("PhonePe"));
		}
		softly.assertAll();
		System.out.println("All questions are related to PhonePe");
	}
	
	
}
