package com.selenium.life.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		
		if(Env.BROWSER.equals(Env.BROWSER_CHROME)){
			System.setProperty(Env.DRIVER_CHROME, Env.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
		}
		else if(Env.BROWSER.equals(Env.BROWSER_IE)){
			System.setProperty(Env.DRIVER_IE, Env.IE_DRIVER_PATH);
			driver = new InternetExplorerDriver();
		}
		else if(Env.BROWSER.equals(Env.BROWSER_FIREFOX)){
			System.setProperty(Env.DRIVER_FIREFOX, Env.FIREFOX_DRIVER_PATH);
			driver = new FirefoxDriver();
		}
		else {
			throw new RuntimeException("Driver not found!!");
		}
		return driver;
		
	}
}
