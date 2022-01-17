package com.amazon;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
	
	protected Logger log;
	protected WebDriver driver;

	@BeforeMethod
	protected void setUp() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		log = LogManager.getLogger();

		driver = new ChromeDriver();
		log.info("Create driver is started." );
	}
	
	@AfterMethod
	protected void tearDown() {
		log.info("Create driver quit." );
		driver.quit();

	}
}
