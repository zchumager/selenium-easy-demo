package com.itexico.testing.steps;

import org.openqa.selenium.WebDriver;

import com.itexico.testing.bases.BaseSteps;
import com.itexico.testing.pages.BasicFirstFormPage;

public class BasicFirstFormSteps extends BaseSteps<BasicFirstFormPage> {
	
	public BasicFirstFormSteps(WebDriver driver) {
		super(driver);
		this.page = new BasicFirstFormPage(this.driver);
		
	}
	
	public void enterMessage(String message) {
		this.page.clearUserMessage();
		this.page.setUserMessage(message);
	}
	
	public void clickShowMessageButton() {
		this.page.clickShowMessageButton();
	}
	
	public String getDisplaySpanText() {
		return this.page.getDisplaySpanText();
	}
	
	public void enterA(String a) {
		this.page.clearSum1Txt();
		this.page.setSum1Txt(a);
	}
	
	public void enterB(String b) {
		this.page.clearSum2Txt();
		this.page.setSum2Txt(b);
	}
	
	public void clickGetTotalButton() {
		this.page.clickGetTotalButton();
	}
	
	public String getDisplayValueText() {
		return this.page.getDisplayValueText();
	}
}
