package com.itexico.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import com.itexico.testing.bases.BasePage;

public class BasicSelectDropdownPage extends BasePage {
	
	private By dayCombo, dayP;

	public BasicSelectDropdownPage(WebDriver driver) {
		super(driver);
		
		this.dayCombo = By.xpath("//select[@id='select-demo']");
		this.dayP = By.xpath("//p[@class='selected-value']");
	}
	
	public void selectByText(String text) {
		new Select(this.driver.findElement(this.dayCombo)).selectByVisibleText(text);
	}
	
	public void selectByIndex(int index) {
		new Select(this.driver.findElement(this.dayCombo)).selectByIndex(index);;
	}
	
	public String getDayPText() {
		return this.driver.findElement(this.dayP).getText();
	}
}
