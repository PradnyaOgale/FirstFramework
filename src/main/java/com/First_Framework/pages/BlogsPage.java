package com.First_Framework.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.First_Framework.Keywords.Keyword;

public class BlogsPage {

	public BlogsPage() {
		PageFactory.initElements(Keyword.getDriver(), this);
	}
	public void scrollBlog() {
		Keyword.getDriver().executeScript("window.scrollBy(0,700)");
	}
	
	@FindBy(css = "div.blog-intro__main")
	public WebElement blogLink;
	public void clickOnABlogToVerifyItsAccessible() {
		blogLink.click();
		String text = Keyword.getDriver().getCurrentUrl();
		System.out.println("Blog link is accessible: "+text);
	}
}
