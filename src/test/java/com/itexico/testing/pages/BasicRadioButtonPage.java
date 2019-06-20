package com.itexico.testing.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.itexico.testing.bases.BasePage;

public class BasicRadioButtonPage extends BasePage{
	
	private By maleRadio, femaleRadio, chekedValueBtn, messageParagraph;
	
	private By genderRadioGroup, ageRadioGroup, getValuesBtn, messageParagraphGroup;

	public BasicRadioButtonPage(WebDriver driver) {
		super(driver);
		
		this.maleRadio = By.xpath("(//input[@value='Male'])[1]");
		this.femaleRadio = By.xpath("(//input[@value='Female'])[1]");
		this.chekedValueBtn = By.id("buttoncheck");
		this.messageParagraph = By.xpath("//p[@class='radiobutton']");
		
		this.genderRadioGroup = By.name("gender");
		this.ageRadioGroup = By.name("ageGroup");
		this.getValuesBtn = By.xpath("//button[text() = 'Get values']");
		this.messageParagraphGroup = By.xpath("//p[@class='groupradiobutton']");
	}
	
	public void checkMaleRadio() {
		this.driver.findElement(this.maleRadio).click();
	}
	
	public void checkFemaleRadio() {
		this.driver.findElement(this.femaleRadio).click();;
	}
	
	public void clickChekedValueBtn() {
		this.driver.findElement(this.chekedValueBtn).click();
	}
	
	public String getMessageParagraphText() {
		return this.driver.findElement(this.messageParagraph).getText();
	}
	
	
	public List<WebElement> getGenderRadioGroup() {
		return this.driver.findElements(this.genderRadioGroup);
	}
	
	public List<WebElement> getAgeRadioGroup() {
		return this.driver.findElements(this.ageRadioGroup);
	}
	
	public void clickGetValuesBtn() {
		this.driver.findElement(this.getValuesBtn).click();
	}
	
	public String getMessageParagraphGroupText() {	
		return this.driver.findElement(this.messageParagraphGroup).getText();
	}
}
