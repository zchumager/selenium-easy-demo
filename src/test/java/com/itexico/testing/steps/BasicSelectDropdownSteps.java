package com.itexico.testing.steps;

import org.openqa.selenium.WebDriver;

import com.itexico.testing.bases.BaseSteps;
import com.itexico.testing.pages.BasicSelectDropdownPage;

public class BasicSelectDropdownSteps extends BaseSteps<BasicSelectDropdownPage> {

	public BasicSelectDropdownSteps(WebDriver driver) {
		super(driver);
		this.page = new BasicSelectDropdownPage(this.driver);
	}
	
	public void selectByText(String text) {
		this.page.selectByText(text);
	}
	
	public void selectByIndex(int index) {
		this.page.selectByIndex(index);
	}
	
	public String getDayPText() {
		return this.page.getDayPText();
	}
}
