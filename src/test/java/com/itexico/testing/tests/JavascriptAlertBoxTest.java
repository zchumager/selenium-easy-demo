package com.itexico.testing.tests;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.itexico.testing.bases.BaseTest;
import com.itexico.testing.steps.JavascriptAlertBoxSteps;

public class JavascriptAlertBoxTest extends BaseTest<JavascriptAlertBoxSteps>{
	
	private WebDriverWait wait;
	private Alert alert;
	
	public void exec(Alert a, String method)  {
		Method m;
		try {
			m = Alert.class.getMethod(method);
			m.invoke(a); //Invoca el metodo en el contexto de la instancia de Alert
		} catch (NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
	}
	
	@BeforeTest
	private void setup() {
		WebDriverManager.chromedriver().setup();
		this.driver = new ChromeDriver();

		this.driver.manage().window().maximize();
		this.driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
		this.steps = new JavascriptAlertBoxSteps(this.driver);
	}
	
	@Test
	public void testJavascriptAlertBox() {
		this.steps.clickButtonByIndex(0);
		this.wait = new WebDriverWait(this.driver, 10);
		this.alert = this.wait.until(ExpectedConditions.alertIsPresent());
		this.exec(alert, "accept");
	}
	
	@Test
	public void testConfirmP() {
		
		Map<String, String> actionMessage = new HashMap<String, String>();
		actionMessage.put("accept", "You pressed OK!");
		actionMessage.put("dismiss", "You pressed Cancel!");
		
		for(Map.Entry<String, String> e: actionMessage.entrySet()) {
			this.steps.clickButtonByIndex(1);
			this.wait = new WebDriverWait(this.driver, 10);
			this.alert = wait.until(ExpectedConditions.alertIsPresent());
			
			this.exec(alert, e.getKey());
			
			Assert.assertEquals(this.steps.getconfirmP_Text(), e.getValue());
		}
	}
	
	@Test
	public void testPromptP() {
		String name = "Pedro";
		String greetingMsg = "You have entered '" +name +"' !";
		
		this.steps.clickButtonByIndex(2);
		this.wait = new WebDriverWait(this.driver, 10);
		this.alert = wait.until(ExpectedConditions.alertIsPresent());
		
		this.alert.sendKeys(name);
		this.alert.accept();
		
		Assert.assertEquals(this.steps.getPromptP_Text(), greetingMsg);
		
	}
}
