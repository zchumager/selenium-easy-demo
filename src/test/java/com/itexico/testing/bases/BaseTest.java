package com.itexico.testing.bases;

import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;

public abstract class BaseTest<S> {
	protected String userDir;
	protected String driverPath;
	protected WebDriver driver;
	protected Logger logger;
	
	protected S steps;
	
	public BaseTest() {
		this.userDir = System.getProperty("user.dir");
		this.driverPath = this.userDir + "/src/test/resources/chromedriver";
		System.setProperty("webdriver.chrome.driver", this.driverPath);
		
		this.logger = Logger.getLogger("logger");
	}
	
	@AfterSuite
	public void tearDown() throws InterruptedException {
		Thread.sleep(2000);
		this.driver.quit();
	}
}

