package com.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ConfigReader {

	static Properties properties;
	
	private static Properties getPropertyData() {

		File file = new File(".\\src\\main\\java\\com\\utility\\config.properties");
		FileInputStream fileinput;
		try {
			fileinput = new FileInputStream(file);
			 properties = new Properties();
			properties.load(fileinput);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties;
		
	}
	
	public String getUrl() {
		String url = getPropertyData().getProperty("url");
		return url;
	}
	public String getBrowser() {
		String browser = getPropertyData().getProperty("browser");
		return browser;
	}
	public String getSearchData() {
		String data = getPropertyData().getProperty("searchtestData");
		return data;
	}
	
	public String getExpectedData() {
		String expected = getPropertyData().getProperty("expected");
		return expected;
	}
	public String getMobileNo() {
		String mob = getPropertyData().getProperty("mobileNo");
		return mob;
	}
	
	public String getName() {
		String name = getPropertyData().getProperty("name");
		return name;
	}
	public String getPhone() {
		String phone = getPropertyData().getProperty("PhoneNo");
		return phone;
	}
	
	public String getPincode() {
		String pin = getPropertyData().getProperty("pincode");
		return pin;
	}
	
	public String getAddress() {
		String address = getPropertyData().getProperty("address");
		return address;
	}
	public String getLocality() {
		String locality = getPropertyData().getProperty("locality");
		return locality;
	}
	public String getValidateHome() {
		String home = getPropertyData().getProperty("ValidateHome");
		return home;
	}
	
}
