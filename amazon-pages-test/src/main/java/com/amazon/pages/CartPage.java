package com.amazon.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends BasePageObject {

	private By productLocator = By.cssSelector("span.a-truncate-cut");

	public CartPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public String getCartProductName() {
		return find(productLocator, 10).getText();
	}
}
