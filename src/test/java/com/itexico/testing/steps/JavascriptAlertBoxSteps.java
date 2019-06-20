package com.itexico.testing.steps;

import org.openqa.selenium.WebDriver;

import com.itexico.testing.bases.BaseSteps;
import com.itexico.testing.pages.JavascriptAlertBoxPage;

public class JavascriptAlertBoxSteps extends BaseSteps<JavascriptAlertBoxPage> {

	public JavascriptAlertBoxSteps(WebDriver driver) {
		super(driver);
		this.page = new JavascriptAlertBoxPage(driver);
	}
	
	public void clickButtonByIndex(int index) {
		this.page.clickButtonByIndex(index);
	}
	
	public String getconfirmP_Text() {
		return this.page.getconfirmP_Text();
	}
	
	public String getPromptP_Text() {
		return this.page.getPromptP_Text();
	}
}
