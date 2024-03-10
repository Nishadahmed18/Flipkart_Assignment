package com.pom;

import org.openqa.selenium.support.PageFactory;

import com.base.BaseClass;
import com.utility.ConfigReader;

public class PageObjectManager extends BaseClass {

	public PageObjectManager() {
		PageFactory.initElements(driver, this);
	}
	
	HomePage hom;
	ConfigReader configReader;
	ProductPage ppm;
	PlaceOrder plom;
	
	public PlaceOrder getPlom() {
		plom=new PlaceOrder();
		return plom;
	}
	public ProductPage getPpm() {
		ppm=new ProductPage();
		return ppm;
	}
	public HomePage getHom() {
		hom=new HomePage();
		return hom;
	}
	
	public ConfigReader getConfigReader() {
		configReader = new ConfigReader();
		return configReader;
	}
}
