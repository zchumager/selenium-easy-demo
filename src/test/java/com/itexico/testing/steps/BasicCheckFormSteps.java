package com.itexico.testing.steps;

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.itexico.testing.bases.BaseSteps;
import com.itexico.testing.pages.BasicCheckFormPage;

public class BasicCheckFormSteps extends BaseSteps<BasicCheckFormPage>{
	
	public BasicCheckFormSteps(WebDriver driver) {
		super(driver);
		this.page = new BasicCheckFormPage(this.driver);
	}
	
	public void checkAgeSelectedChk() {
		this.page.checkAgeSelectedChk();
	}
	
	public String getTxtAgeDivStyle() {
		return this.page.getTxtAgeDivStyle();
	}
	
	public void checkMultipleCheckboxes() {
		this.page.checkMultipleCheckboxes();
	}
	
	public Map<String, String> getButtonAndHiddenValues() {
		Map<String, String> buttonAndHidden = new HashMap<String, String>();
		buttonAndHidden.put("buttonValue", this.page.getCheck1BtnValue());
		buttonAndHidden.put("hiddenValue", this.page.getIschkdValue());
		
		return buttonAndHidden;
	}
}
