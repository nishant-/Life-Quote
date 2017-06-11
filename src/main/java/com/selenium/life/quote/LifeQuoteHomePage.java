package com.selenium.life.quote;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.selenium.life.util.Locators;

public class LifeQuoteHomePage {

	WebDriver driver;
	public LifeQuoteHomePage(WebDriver driver) {
		this.driver=driver;
		// TODO Auto-generated constructor stub
	}
	By lifeQuoteButton = By.id(Locators.LIFE_QUOTE_BUTTON);
	
	public WebElement lifeQuoteButton() {
		return driver.findElement(lifeQuoteButton);
	}
}
