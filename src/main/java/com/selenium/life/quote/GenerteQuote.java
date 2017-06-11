package com.selenium.life.quote;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.life.util.DriverFactory;
import com.selenium.life.util.Env;

public class GenerteQuote {

	public static void main(String[] args) throws Exception {

		List<Person> pList = PersonalDetailsExcel.getPersonalDetailsAsList(Env.WORKBOOK_PATH, Env.SHEET_NAME);
		for (Person p : pList) {
			WebDriver driver = DriverFactory.getDriver();
			driver.get(Env.APP_URL);
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
			LifeQuoteHomePage lqhp = new LifeQuoteHomePage(driver);
			lqhp.lifeQuoteButton().click();
			generateQuote(p, driver);
			setAmountFromQuote(p, driver);
			driver.close();

		}
		PersonalDetailsExcel.createExcelWithQuote(pList);

	}

	private static void setAmountFromQuote(Person p, WebDriver driver) {
		GeneratedQuotePage gqp = new GeneratedQuotePage(driver);
		String amount = gqp.amount().getText();
		p.setPremiumAmount(amount);
	}

	private static void generateQuote(Person p, WebDriver driver) {
		PersonlDetailsPage pdp = new PersonlDetailsPage(driver);
		pdp.age().sendKeys("" + p.getAge());
		if (p.getGender().equals("M")) {
			pdp.male().click();
		} else {
			pdp.female().click();
		}
		pdp.occupation().selectByVisibleText(p.getOccupationCategory());
		pdp.state().selectByVisibleText(p.getState());
		pdp.email().sendKeys(p.getEmail());
		WebDriverWait webDriverWait = new WebDriverWait(driver, 5);
		webDriverWait.until(ExpectedConditions.elementToBeClickable(pdp.quoteButton()));
		pdp.quoteButton().click();
	}
}
