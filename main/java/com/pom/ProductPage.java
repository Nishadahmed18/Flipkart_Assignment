package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class ProductPage extends BaseClass{
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//span[text()='Place Order']")
	private WebElement placeOrder;
	
	@FindBy(xpath = "//a[text()='Login']")
	private WebElement 	login;

	
	
	@FindBy(xpath = "//input[@type='text']")
	private WebElement 	mobileNumber;
	

	public WebElement getContinueOrder() {
		return continueOrder;
	}
	public WebElement getPaymentOption() {
		return paymentOption;
	}

	@FindBy(name = "name")
	private WebElement 	firstname;
	
	@FindBy(xpath = "//button[text()='CONTINUE']")
	private WebElement 	continueOrder;
	
	

	@FindBy(xpath = "//span[text()='Credit / Debit / ATM Card']")
	private WebElement 	paymentOption;
	
	@FindBy(name = "phone")
	private WebElement 	phoneNo;
	
	@FindBy(name = "pincode")
	private WebElement 	pincode;
	
	@FindBy(name = "addressLine1")
	private WebElement 	address;
	
	@FindBy(name = "addressLine2")
	private WebElement 	locality;
	
	@FindBy(xpath = "//button[text()='Save and Deliver Here']")
	private WebElement 	save;
	
	
	
	public WebElement getFirstname() {
		return firstname;
	}
	public WebElement getPlaceOrder() {
		return placeOrder;
	}
	
	public WebElement getLogin() {
		return login;
	}
	
	public WebElement getMobileNumber() {
		return mobileNumber;
	}
	
	public WebElement getPhoneNo() {
		return phoneNo;
	}
	public WebElement getPincode() {
		return pincode;
	}
	public WebElement getAddress() {
		return address;
	}
	public WebElement getLocality() {
		return locality;
	}
	public WebElement getSave() {
		return save;
	}
}
