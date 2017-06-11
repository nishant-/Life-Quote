package com.selenium.life.quote;

public class Person {

	int age;
	String gender;
	String occupationCategory;
	String state;
	String email;
	String premiumAmount;
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getOccupationCategory() {
		return occupationCategory;
	}
	public void setOccupationCategory(String occupationCategory) {
		this.occupationCategory = occupationCategory;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPremiumAmount() {
		return premiumAmount;
	}
	public void setPremiumAmount(String premiumAmount) {
		this.premiumAmount = premiumAmount;
	}
	
	@Override
	public String toString() {
		
		return "Person = "+ age + gender + occupationCategory + state + email + premiumAmount;
	}
	
}
