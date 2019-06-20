package com.itexico.testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.itexico.testing.bases.BasePage;

public class BasicFirstFormPage extends BasePage{
	private By userMessageTxt;
	private By showMessageBtn;
	private By displaySpan;
	
	private By sum1Txt;
	private By sum2Txt;
	private By getTotalBtn;
	private By displayValueSpan;
	
	public BasicFirstFormPage(WebDriver driver) {
		super(driver);
		
		this.userMessageTxt = By.id("user-message");
		this.showMessageBtn = By.xpath("//form[@id='get-input']/button");
		this.displaySpan = By.id("display");
		
		this.sum1Txt = By.id("sum1");
		this.sum2Txt = By.id("sum2");
		this.getTotalBtn = By.xpath("//form[@id='gettotal']/button");
		this.displayValueSpan = By.id("displayvalue");
		
	}
	
	public void clearUserMessage() {
		this.driver.findElement(this.userMessageTxt).clear();
	}
	
	public void setUserMessage(String message) {
		this.driver.findElement(this.userMessageTxt).sendKeys(message);
	}
	
	public void clickShowMessageButton() {
		this.driver.findElement(this.showMessageBtn).click();
	}
	
	public String getDisplaySpanText() {
		return this.driver.findElement(this.displaySpan).getText();
	}
	
	public void clearSum1Txt() {
		this.driver.findElement(this.sum1Txt).clear();
	}
	
	public void setSum1Txt(String number) {
		this.driver.findElement(this.sum1Txt).sendKeys(number);
	}
	
	public void clearSum2Txt() {
		this.driver.findElement(this.sum2Txt).clear();
	}
	
	public void setSum2Txt(String number) {
		this.driver.findElement(this.sum2Txt).sendKeys(number);
	}
	
	public void clickGetTotalButton() {
		this.driver.findElement(this.getTotalBtn).click();
	}
	
	public String getDisplayValueText() {
		return this.driver.findElement(this.displayValueSpan).getText();
	}
	
}
