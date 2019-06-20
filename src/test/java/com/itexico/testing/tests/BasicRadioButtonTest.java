package com.itexico.testing.tests;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.itexico.testing.bases.BaseTest;
import com.itexico.testing.steps.BasicRadioButtonSteps;

public class BasicRadioButtonTest extends BaseTest<BasicRadioButtonSteps>{
	
	public BasicRadioButtonTest() {
		this.driver = new ChromeDriver();
	}
	
	@BeforeTest
	public void setup() {
		this.driver.manage().window().maximize();
		this.driver.get("https://www.seleniumeasy.com/test/basic-radiobutton-demo.html");
		this.steps = new BasicRadioButtonSteps(this.driver);
	}
	
	@Test
	public void testMaleRadio() {
		this.steps.checkMaleRadio();
		this.steps.clickChekedValueBtn();
		
		Assert.assertEquals(this.steps.getMessageParagraphText(), "Radio button 'Male' is checked");
	}
	
	@Test
	public void testFemaleRadio() {
		this.steps.checkFemaleRadio();
		this.steps.clickChekedValueBtn();
		
		Assert.assertEquals(this.steps.getMessageParagraphText(), "Radio button 'Female' is checked");
	}
	
	@Test
	public void testRadioGroups() {
		
		List<String> genderOuts = Arrays.asList(
				"Sex : Male"
				, "Sex : Female");
		
		List<String> ageOuts = Arrays.asList(
				"Age group: 0 - 5"
				, "Age group: 5 - 15"
				, "Age group: 15 - 50");
		
		List<WebElement> genderGroup = this.steps.getGenderRadioGroup();
		List<WebElement> ageGroup = this.steps.getAgeRadioGroup();
		
		
		for(int i=0; i<genderGroup.size(); i++) {
			for(int j=0; j<ageGroup.size(); j++) {
				genderGroup.get(i).click();
				ageGroup.get(j).click();
				
				this.steps.clickGetValuesBtn();		
				
				Assert.assertTrue(this.steps.getMessageParagraphGroupText().equals(
						(genderOuts.get(i) + System.lineSeparator() + ageOuts.get(j))));
				
			}
		}
	}
	
}
