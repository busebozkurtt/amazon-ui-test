package com.amazon.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductDetailsPage extends BasePageObject {

	private By addToCartButtonLocator = By.id("add-to-cart-button");
	private By cartCountLocator = By.id("nav-cart-count");
	private By productTitleLocator = By.id("productTitle");
	private String productName;

	public ProductDetailsPage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void addToCart() {
		productName = find(productTitleLocator, 10).getText();
		click(addToCartButtonLocator, 10);
	}

	public String getProductName() {
		return productName;
	}

	public CartPage clickCartButton() {
		click(cartCountLocator, 10);
		return new CartPage(driver, log);
	}
}
