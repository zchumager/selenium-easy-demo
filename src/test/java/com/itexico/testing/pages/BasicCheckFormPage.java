package com.itexico.testing.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.itexico.testing.bases.BasePage;

public class BasicCheckFormPage extends BasePage{
	private By ageSelectedChk;
	private By txtAgeDiv;
	
	private By multipleCheckboxes;
	private By check1Btn;
	private By isChkd;
	
	
	public BasicCheckFormPage(WebDriver driver) {
		super(driver);
		
		this.ageSelectedChk = By.id("isAgeSelected");
		this.txtAgeDiv = By.id("txtAge");
		
		this.multipleCheckboxes = By.xpath(
				"//div[@class='panel panel-default' and position() = 2]"
				+ "//input[@type='checkbox' and @class='cb1-element']");
		this.check1Btn = By.id("check1");
		this.isChkd = By.id("isChkd");
	}
	
	public void checkAgeSelectedChk() {
		this.driver.findElement(this.ageSelectedChk).click();
	}
	
	public String getTxtAgeDivStyle() {
		return this.driver.findElement(this.txtAgeDiv).getAttribute("style");
	}
	
	public void checkMultipleCheckboxes() {
		List<WebElement> elements = this.driver.findElements(this.multipleCheckboxes);
		
		for(WebElement e: elements) {
			e.click();
		}
	}
	
	public String getCheck1BtnValue() {
		return this.driver.findElement(this.check1Btn).getAttribute("value");
	}
	
	public String getIschkdValue() {
		return this.driver.findElement(this.isChkd).getAttribute("value");
	}
}