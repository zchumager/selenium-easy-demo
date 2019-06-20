package com.itexico.testing.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.itexico.testing.bases.BasePage;

public class JavascriptAlertBoxPage extends BasePage {
	
	private List<By> buttons;
	private By confirmP, promptP;

	public JavascriptAlertBoxPage(WebDriver driver) {
		super(driver);
		
		this.buttons = new ArrayList<By>();
		for(int i=2; i<=4; i++) {
			this.buttons.add(By.xpath("(//div[@class='panel-body'])["+i+"]//button"));
		}
		
		this.confirmP = By.id("confirm-demo");
		this.promptP = By.id("prompt-demo");
	}
	
	public void clickButtonByIndex(int index) {
		this.driver.findElement(this.buttons.get(index)).click();
	}
	
	public String getconfirmP_Text() {
		return this.driver.findElement(this.confirmP).getText();
	}
	
	public String getPromptP_Text() {
		return this.driver.findElement(this.promptP).getText();
	}

}
