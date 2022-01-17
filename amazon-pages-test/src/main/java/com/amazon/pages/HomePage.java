package com.amazon.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePageObject {

	String pageUrl = "https://www.amazon.com.tr/";
	private By searchTextBarLocator = By.id("twotabsearchtextbox");
	private By cookiesLocator = By.id("sp-cc-accept");

	public HomePage(WebDriver driver, Logger log) {
		super(driver, log);
	}

	public void openPage() {
		log.info("Opening page: " + pageUrl);
		openUrl(pageUrl);
		log.info("Page opened!");
	}

	public ProductPage searchProduct(String product) {
		log.info("Open the Product Page. Product name:" + product);
		search(searchTextBarLocator, 10, product);
		return new ProductPage(driver, log);
	}
	
	public void acceptCookie() {
        if(isElementAvailable(cookiesLocator,10))
            click(cookiesLocator, 5);
    }
}
