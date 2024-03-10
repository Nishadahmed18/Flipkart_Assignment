package com.test;
import java.util.Scanner;

import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;
import com.base.BaseClass;
import com.pom.PageObjectManager;

public class Runner extends BaseClass {

	PageObjectManager pom  = new PageObjectManager();

	@Test(groups = "TS001")
	private void launchaApplication() throws InterruptedException {
		launchBrowser(pom.getConfigReader().getBrowser());
		launchUrl(pom.getConfigReader().getUrl());

	}



	@Test(dependsOnMethods = "launchaApplication",groups = "TS001")
	private void searchProduct() {
		Assert.assertEquals(gettitle(),  pom.getConfigReader().getValidateHome());
		passInput(pom.getHom().getSearch(), pom.getConfigReader().getSearchData());

		clickButton(pom.getHom().getSelectProduct());
	}

	@Test(dependsOnMethods = "searchProduct",groups = "TS001")
	private void addtoCart() {
		windowhandles();
		boolean isdisplayed = isdisplayed(pom.getHom().getAddToCart());
		Assert.assertTrue(isdisplayed);
		scroll();
		clickButton(pom.getHom().getAddToCart());
	}


	@Test(dependsOnMethods = "addtoCart",groups = "TS002")
	private void placeOrder() {
		clickButton(pom.getPpm().getPlaceOrder());
		passInput(pom.getPlom().getMobilePlaceOrder(),pom.getConfigReader().getMobileNo() );
		clickButton(pom.getPlom().getSubmitPlaceOrder());
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the OTP");
		String otp = scanner.next();
		staticWait(5000);
		passInput(pom.getPlom().getOtp(), otp);
		clickButton(pom.getPlom().getClickButtonPlaceOrder());



	}

	@Test(dependsOnMethods = "placeOrder",groups = "TS002")
	private void Login() {
		boolean isdisplayed = isdisplayed(pom.getPpm().getLogin());
		Assert.assertTrue(isdisplayed);
		clickButton(pom.getPpm().getLogin());
		passInput(pom.getPpm().getMobileNumber(), pom.getConfigReader().getMobileNo());
		System.out.println(driver.getTitle());

	}


	@Test(dependsOnMethods = "placeOrder",groups = "TS002")
	private void deliveryAddress() {
		passInput(pom.getPpm().getFirstname(), pom.getConfigReader().getName());
		passInput(pom.getPpm().getPhoneNo(), pom.getConfigReader().getMobileNo());
		passInput(pom.getPpm().getPincode(), pom.getConfigReader().getPhone());
		passInput(pom.getPpm().getAddress(), pom.getConfigReader().getAddress());
		passInput(pom.getPpm().getLocality(), pom.getConfigReader().getLocality());
		boolean isdisplayed = isdisplayed(pom.getPpm().getSave());
		Assert.assertTrue(isdisplayed);
		clickButton(pom.getPpm().getSave());
	}

	@Test(dependsOnMethods = "deliveryAddress",groups = "TS002")
	private void orderSummary() {
		boolean isdisplayed = isdisplayed(pom.getPpm().getContinueOrder());
		Assert.assertTrue(isdisplayed);
		clickButton(pom.getPpm().getContinueOrder());
	}

	@Test(dependsOnMethods = "orderSummary",groups = "TS002")
	private void payment() {
		boolean isdisplayed = isdisplayed(pom.getPpm().getPaymentOption());
		Assert.assertTrue(isdisplayed);
		clickButton(pom.getPpm().getPaymentOption());
	}

	@Test(dependsOnMethods = "addtoCart",groups = "TS001")
	private void removeCart() {
		boolean isdisplayed = isdisplayed(pom.getPlom().getRemovebtOne());
		Assert.assertTrue(isdisplayed);
		clickButton(pom.getPlom().getRemovebtOne());
		boolean isdisplayed2 = isdisplayed(pom.getPlom().getRemovebtTwo());
		Assert.assertTrue(isdisplayed2);
		clickButton(pom.getPlom().getRemovebtTwo());
	}


//	@AfterSuite()
	private void terminateExecution() {
		terminateBrowser();
	}
}
