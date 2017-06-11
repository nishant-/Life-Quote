package com.selenium.life.quote;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.selenium.life.util.Locators;

public class PersonlDetailsPage {

	WebDriver driver;
	public PersonlDetailsPage(WebDriver driver) {
		this.driver=driver;
	}
	
	By age = By.id(Locators.AGE);
	By male = By.id(Locators.MALE);
	By female = By.id(Locators.FEMALE);
	By occupation = By.id(Locators.OCCUPATION);
	By state = By.id(Locators.STATE);
	By email = By.id(Locators.EMAIL);
	By getQuoteButton = By.id(Locators.GETQUOTE_BUTTON);
	
	public WebElement age() {
		return driver.findElement(age);
	}
	
	public Select state(){
		return new Select(driver.findElement(state));
	}
	
	public Select occupation() {
		return new Select(driver.findElement(occupation));
	}
	
	public WebElement email() {
		return driver.findElement(email);
	}
	
	public WebElement male() {
		return driver.findElement(male);
	}
	
	public WebElement female() {
		return driver.findElement(female);
	}
	
	public WebElement quoteButton() {
		return driver.findElement(getQuoteButton);
	}
}
