package com.pom;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;

public class HomePage extends BaseClass {

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@name='q']")
	private WebElement search;

	@FindBy(xpath = "(//span[text()='Filters']//following::div[@class='_25b18c'])[2]")
	private WebElement selectProduct;

	
	@FindBy(xpath = "//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addToCart;

	

	
	

	

	

	
	
	public WebElement getSearch() {
		return search;
	}
	public WebElement getSelectProduct() {
		return selectProduct;
	}

	public WebElement getAddToCart() {
		return addToCart;
	}
	
	
}
