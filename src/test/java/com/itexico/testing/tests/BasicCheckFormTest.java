package com.itexico.testing.tests;

import java.util.Map;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.itexico.testing.bases.BaseTest;
import com.itexico.testing.steps.BasicCheckFormSteps;

public class BasicCheckFormTest extends BaseTest<BasicCheckFormSteps> {
	public BasicCheckFormTest() {
		this.driver = new ChromeDriver();
	}
	
	@BeforeTest
	public void setup() {
		this.driver.manage().window().maximize();
		this.driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
		this.steps = new BasicCheckFormSteps(this.driver);
	}
	
	@Test
	public void testSingleCheckBox() {
		this.steps.checkAgeSelectedChk();
		boolean condition = (this.steps.getTxtAgeDivStyle().equals("")|| this.steps.getTxtAgeDivStyle().equals("display:block"));
		Assert.assertTrue(condition);
	}
	
	@Test
	public void testMultipleCheckboxDemo() {
		this.steps.checkMultipleCheckboxes();
		Map<String, String> values = this.steps.getButtonAndHiddenValues();
		
		boolean condition = (values.get("buttonValue").equals("Uncheck All") && values.get("hiddenValue").equals("true"));
		Assert.assertTrue(condition);
	}
}
