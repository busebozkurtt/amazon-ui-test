package com.amazon;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.amazon.pages.HomePage;
import com.amazon.pages.ProductDetailsPage;
import com.amazon.pages.ProductPage;
import com.amazon.pages.CartPage;

public class AddToCartTest extends BaseTest {
	@Test
	public void addToCartTest() {

		// Open home page
		log.info("Starting Add to cart test.");
		HomePage homePageInstance = new HomePage(driver, log);
		homePageInstance.openPage();

		// Accept cookies.
		log.info("Accept Cookies.");
		homePageInstance.acceptCookie();

		// Enter product name to sarch.
		String product = "4k ultra tv";
		log.info("Searching product: " + product);
		ProductPage productPageInstance = homePageInstance.searchProduct(product);

		Assert.assertTrue(productPageInstance.isProductFounded(), "This product is not available");

		// Select product
		log.info("Select second product.");
		ProductDetailsPage productDetailsName = productPageInstance.selectProduct(2);

		// Add selected product to cart
		log.info("Product is adding to cart");
		productDetailsName.addToCart();

		log.info("Go to cart page");
		CartPage cartPageInstance = productDetailsName.clickCartButton();

		// Check the product in the cart
		String actualProductName = cartPageInstance.getCartProductName().toLowerCase();
		String expectedProductName = productDetailsName.getProductName().toLowerCase();
		Assert.assertTrue(actualProductName.contains(expectedProductName),
				"actualProductName does not contain expectedProductName\nexpectedProductName: " + expectedProductName
						+ "\nactualProductName: " + actualProductName);

	}
}
