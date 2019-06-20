package com.itexico.testing.tests;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.itexico.testing.bases.BaseTest;
import com.itexico.testing.steps.BasicSelectDropdownSteps;

public class BasicSelectDropdownTest extends BaseTest<BasicSelectDropdownSteps> {
	
	public BasicSelectDropdownTest() {
		this.driver = new ChromeDriver();
	}
	
	@BeforeTest
	public void setup() {
		this.driver.manage().window().maximize();
		this.driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		this.steps = new BasicSelectDropdownSteps(this.driver);
	}
	
	@Test
	public void SelectListDemoTest() {
		List<String> days = Arrays.asList(
				"Sunday", "Monday", "Tuesday", "Wednesday"
				, "Thursday", "Friday", "Saturday"
		);
		
		String msgLabel = "Day selected :- ";
		
		days.stream().forEach(day -> {
			this.steps.selectByText(day);
			Assert.assertEquals(msgLabel + day, this.steps.getDayPText());
		});
	}
}
