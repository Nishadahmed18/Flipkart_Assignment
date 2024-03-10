package com.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class PlaceOrder extends BaseClass {

	public PlaceOrder() {
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//input[@type='text']")
	private WebElement mobilePlaceOrder	;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submitPlaceOrder;
	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement otp	;
	@FindBy(xpath = "//button[@type='submit']")
	private WebElement 	clickButtonPlaceOrder;

	@FindBy(xpath = "//div[text()='Remove']")
	private WebElement 	removebtOne;

	@FindBy(xpath = "(//div[text()='Remove'])[1]")
	private WebElement 	removebtTwo;

	public WebElement getRemovebtOne() {
		return removebtOne;
	}

	public WebElement getRemovebtTwo() {
		return removebtTwo;
	}
	public WebElement getMobilePlaceOrder() {
		return mobilePlaceOrder;
	}
	public WebElement getSubmitPlaceOrder() {
		return submitPlaceOrder;
	}
	public WebElement getOtp() {
		return otp;
	}
	public WebElement getClickButtonPlaceOrder() {
		return clickButtonPlaceOrder;
	}


}
