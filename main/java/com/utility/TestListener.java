package com.utility;


import org.testng.ITestListener;
import org.testng.ITestResult;

import com.base.BaseClass;

public class TestListener extends BaseClass implements ITestListener {


	public void onTestSuccess(ITestResult result) {
		screenShot(result.getMethod().getMethodName());
			
	}

	public void onTestFailure(ITestResult result) {
		screenShot(result.getMethod().getMethodName()+"failedTest");

	}
}
