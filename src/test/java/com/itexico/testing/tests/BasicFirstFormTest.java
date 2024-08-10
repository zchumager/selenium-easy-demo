package com.itexico.testing.tests;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.itexico.testing.bases.BaseTest;
import com.itexico.testing.listeners.EvtListener;
import com.itexico.testing.steps.BasicFirstFormSteps;

public class BasicFirstFormTest extends BaseTest<BasicFirstFormSteps>{
	
	private EventFiringWebDriver eventDriver;
	private List<String> l = new ArrayList<String>(Collections.singletonList("Java"));
	
	@BeforeTest
	public void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();

		this.eventDriver = new EventFiringWebDriver(this.driver);

		EvtListener listener = new EvtListener();
		listener.setList(l);
		this.eventDriver.register(listener);

		this.driver.manage().window().maximize();
		this.driver.get("https://www.seleniumeasy.com/test/basic-first-form-demo.html");
		
		this.steps = new BasicFirstFormSteps(this.eventDriver);
	}
	
	@Test
	public void testShowMessageForm() {
		String message = "Hello World";
		this.steps.enterMessage(message);
		this.steps.clickShowMessageButton();
		
		Assert.assertEquals(this.steps.getDisplaySpanText(), message);
	}
	
	@Test
	public void testTwoInputFields() {
		String a = "2";
		String b = "3";
		
		
		this.steps.enterA(a);
		this.steps.enterB(b);
		this.steps.clickGetTotalButton();
		
		String actual = ((BasicFirstFormSteps) this.steps).getDisplayValueText();
		String expected = String.valueOf((Integer.parseInt(a) + Integer.parseInt(b)));
		
		Assert.assertEquals(actual, expected);
		
		this.l.stream().forEach(System.out::println);
	}
}
