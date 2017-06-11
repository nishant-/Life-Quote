package com.selenium.life.test;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.selenium.life.quote.GeneratedQuotePage;
import com.selenium.life.quote.LifeQuoteHomePage;
import com.selenium.life.quote.Person;
import com.selenium.life.quote.PersonalDetailsExcel;
import com.selenium.life.quote.PersonlDetailsPage;
import com.selenium.life.util.DriverFactory;
import com.selenium.life.util.Env;

public class GenerateLifeInsuranceQuoteTest {

	WebDriver driver;
	List<Person> pList;

	@BeforeTest
	public void setup() {
		try{
			pList=PersonalDetailsExcel.getPersonalDetailsAsList(Env.WORKBOOK_PATH, Env.SHEET_NAME);
			driver = DriverFactory.getDriver();
			Assert.assertTrue(driver.getTitle()!=null);
		}
		catch (Exception e){
			System.out.println(e);
			
		}
	
	}
	
	@Test
	public void openBrowser() {
		driver.get(Env.APP_URL);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}
	
	@Test(dependsOnMethods = ("openBrowser"))
	public void getLifeQuoteIsClicked() {
		LifeQuoteHomePage lqhp = new LifeQuoteHomePage(driver);
		lqhp.lifeQuoteButton().click();
	}
	
	@Test(dependsOnMethods = ("getLifeQuoteIsClicked"))
	public void generateQuote() {
		PersonlDetailsPage pdp = new PersonlDetailsPage(driver);
		Person p = pList.get(0);
		pdp.age().sendKeys(p.getAge()+"");
		pdp.email().sendKeys(p.getEmail());
		pdp.male().click();
		pdp.occupation().selectByVisibleText(p.getOccupationCategory());
		pdp.state().selectByVisibleText(p.getState());
		WebDriverWait driverWait = new WebDriverWait(driver, 5);
		driverWait.until(ExpectedConditions.elementToBeClickable(pdp.quoteButton()));
		pdp.quoteButton().click();
	}
	
	@Test(dependsOnMethods= ("generateQuote"))
	public void quoteAmountIsDisplayed() {
		GeneratedQuotePage gqp = new GeneratedQuotePage(driver);
		Assert.assertTrue(gqp.amount().toString()!=null);
	}
	
	@AfterTest
	public void end() {
		driver.close();
	}

}
