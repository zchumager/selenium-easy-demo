package com.itexico.testing.steps;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.itexico.testing.bases.BaseSteps;
import com.itexico.testing.pages.BasicRadioButtonPage;

public class BasicRadioButtonSteps extends BaseSteps<BasicRadioButtonPage>{
	
	public BasicRadioButtonSteps(WebDriver driver) {
		super(driver);
		this.page = new BasicRadioButtonPage(this.driver);
	}
	
	public void checkMaleRadio() {
		this.page.checkMaleRadio();
	}
	
	public void checkFemaleRadio() {
		this.page.checkFemaleRadio();
	}
	
	public void clickChekedValueBtn() {
		this.page.clickChekedValueBtn();
	}
	
	public String getMessageParagraphText() {
		return this.page.getMessageParagraphText();
	}
	
	public List<WebElement> getGenderRadioGroup() {
		return this.page.getGenderRadioGroup();
	}
	
	public List<WebElement> getAgeRadioGroup() {
		return this.page.getAgeRadioGroup();
	}
	
	public void clickGetValuesBtn() {
		this.page.clickGetValuesBtn();
	}
	
	public String getMessageParagraphGroupText() {
		return this.page.getMessageParagraphGroupText();
	}
}
