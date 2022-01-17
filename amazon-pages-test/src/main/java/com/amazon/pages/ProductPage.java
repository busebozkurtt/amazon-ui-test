package com.amazon.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProductPage extends BasePageObject{

	private By deliveryLocator= By.xpath("//span[@class='a-size-base a-color-base']");
	private By productNameLocator= By.xpath("//a/span[@class='a-size-base-plus a-color-base a-text-normal']");
	
	public ProductPage(WebDriver driver, Logger log) {
		super(driver, log);
	}
	
	public boolean isProductFounded () {
		return isElementAvailable(deliveryLocator, 10); 
	}
	
	public ProductDetailsPage selectProduct(int productNumber) {
		log.info("Select Product number: " + productNumber);
		List<WebElement> products = findAll(productNameLocator);
		if(products.size() >= productNumber && productNumber > 0)
		    findAll(productNameLocator).get(productNumber-1).click();
		else
			throw new IndexOutOfBoundsException("You choose product: " + productNumber + " but there are  "+ products.size()+ " products");
		return new ProductDetailsPage(driver, log);
	}

}
