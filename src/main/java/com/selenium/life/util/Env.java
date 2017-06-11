package com.selenium.life.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Env {

	static Properties prop = new Properties();

	static {

		try (FileInputStream fis = new FileInputStream("Env.properties")) {
			prop.load(fis);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}
	public static final String APP_URL = getProperty("app.url");
	public static final String FIREFOX_DRIVER_PATH = getProperty("firefox.driver.path");
	public static final String CHROME_DRIVER_PATH = getProperty("chrome.driver.path");
	public static final String IE_DRIVER_PATH = getProperty("ie.driver.path");
	public static final String BROWSER_CHROME = getProperty("browser.chrome");
	public static final String BROWSER_FIREFOX = getProperty("browser.firefox");
	public static final String BROWSER_IE = getProperty("browser.ie");
	public static final String DRIVER_FIREFOX = getProperty("driver.firefox");
	public static final String DRIVER_CHROME = getProperty("driver.chrome");
	public static final String DRIVER_IE = getProperty("driver.ie");
	public static final String BROWSER = getProperty("browser");
	public static final String WORKBOOK_PATH = getProperty("workbook.path");
	public static final String SHEET_NAME = getProperty("workbook.sheet.name");
}
