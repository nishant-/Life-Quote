package com.selenium.life.quote;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.life.util.Locators;

public class GeneratedQuotePage {

	WebDriver driver;
	
	public GeneratedQuotePage(WebDriver driver) {
		this.driver=driver;
	}
	
	By amount = By.xpath(Locators.AMOUNT);
	
	
	public WebElement amount() {
		return driver.findElement(amount);
	}
}
