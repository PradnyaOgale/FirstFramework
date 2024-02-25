package com.First_Framework.pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.First_Framework.Keywords.Keyword;

public class ProductPage {

	public ProductPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}
	
	@FindBy(css = "h1.pdp-title+h1.pdp-name")
	public WebElement productTitle;
	public void getProductTitle(){
		String text = productTitle.getText();
		System.out.println("Product Title: "+text);
	}
	
	/*@FindBy(css = "div.pdp-description-container")
	public WebElement productInfo;
	public void getProductInfo() {
		productInfo.getText();
	}*/
	@FindBy(css = "div.pdp-productDescriptorsContainer")
	public List<WebElement> productDesc;
	public List<String> getProductDesc() {
		Keyword keyword = new Keyword();
		return keyword.getTexts(productDesc);
		
	}
	public void verifyIfProductHasTheDescription(){
		List<String> prodDesc = getProductDesc();
		
		for (String prodDescs : prodDesc) {
			System.out.println(prodDescs);
			Assert.assertNotNull(prodDescs);	
		}
		
	}
	
	@FindBy(css = "img[alt^=\"Bella Toes Women\"]")
	public WebElement productComponent;
	public void clickOnAProduct(){
		
		productComponent.click();
	}

	@FindBy(css = "div.pdp-price-info>h1.pdp-title")
	public WebElement flatTitle;
	public String getFlatTitle() {
		return flatTitle.getText();
		//System.out.println(text);
	}
	
	@FindBy(xpath = "//*[@id=\"sizeButtonsContainer\"]/div[2]/div[3]")
	public WebElement sizeBtn;
	public void selectSizeOfTheFlat(){
		
		sizeBtn.click();
	}
	
	@FindBy(css = "div.pdp-add-to-bag-with-prior")
	public WebElement addToCartBtnComponent;
	public void clickOnAddToCartBtn() {
		addToCartBtnComponent.click();
	}

	@FindBy(css = "span[data-reactid*=\"905\"]")
	public WebElement cartComponent;
	public void clickOnCartIcon() {
		cartComponent.click();
	}
	
	@FindBy(css = "div.itemContainer-base-brand")
	public WebElement cartFlatTitle;
	public void getFlatTitleFromCartAndCompare() {
		String text1 = flatTitle.getText();
		System.out.println(text1);
		String text = getFlatTitle();
		Assert.assertEquals(text1, text, "Both titles are equal");
	}
	
	@FindBy(css = "span.size-buttons-size-chart")
	public WebElement sizeChartOption;
	public void clickOnSizeChart(){
		sizeChartOption.click();
	}
	
	
	@FindBy(css = "tr.sizeChartWeb-newRow")
	public List<WebElement> sizeInfo;
	public List<String> sizeInfo(){
		Keyword keyword = new Keyword();
		return keyword.getTexts(sizeInfo);
	}
	
	public void getSizeInformation() {
		List<String> text = sizeInfo();
		
		//SoftAssert softly = new SoftAssert();
		for (String sizeTexts : text) {
			System.out.println("Size chart: "+sizeTexts);
			//softly.assertTrue(sizeTexts.contains("s"));
		}
		//softly.assertAll();
	}
	/**
	 * BreadCrumb navigation
	 */
	@FindBy(css = "div.breadcrumbs-container>a[href=\"/women-footwear\"]")
	public WebElement bCrumbShirtLink;
	public void clickOnBreadCrumbWomenFootwearLink(){
		System.out.println("Currently you're on *Product Page*");
		bCrumbShirtLink.click();
		System.out.println("You've navigated to *Women Footwear* link");
	}
}
