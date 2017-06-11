package com.selenium.life.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Locators {

	static Properties prop = new Properties();
	static FileInputStream fis = null;
	static {

		try (FileInputStream fis = new FileInputStream("Locators.properties")) {
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

	public static final String LIFE_QUOTE_BUTTON          =  getProperty("life.quote.button.id");
	public static final String AGE             =  getProperty("life.quote.age.id");
	public static final String MALE     = getProperty("life.quote.gender.male.id");
	public static final String FEMALE   =getProperty("life.quote.gender.female.id");
	public static final String OCCUPATION       =getProperty("life.quote.occupaion.id");
	public static final String STATE           =getProperty("life.quote.state.id");
	public static final String EMAIL           =getProperty("life.quote.email.id");
	public static final String GETQUOTE_BUTTON =getProperty("life.quote.getquote.button.id");
	public static final String AMOUNT          =getProperty("life.quote.amount.xpath");
	
	
	
}
