package com.First_Framework.base;

/**
 * This interface stores all locators of the project but this interface is no longer in use since we are using Page Object Model
 * @author pradnyaogale
 */
@Deprecated
public interface Locator {

	//We created interface for locators as variables in interface are by default public, static , final
	
	String searchComponent = "css##div.desktop-query>input[placeholder*=\"Search for\"]";
	String PRODUCTtITLE = "css##h3.product-brand";
}
