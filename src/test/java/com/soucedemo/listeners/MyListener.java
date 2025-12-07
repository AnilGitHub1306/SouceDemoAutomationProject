package com.soucedemo.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.soucedemo.base.Base;
import com.soucedemo.pages.LoginPage;
import com.soucedemo.utility.MyUtils;

public class MyListener implements ITestListener {
	
	private static final Logger log = LogManager.getLogger(LoginPage.class);

	@Override
	public void onTestStart(ITestResult result) {
		String testDescription = result.getMethod().getDescription();
		log.info("Test Started "+testDescription);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		String testDescription = result.getMethod().getDescription();
		log.info("Test Pass: "+testDescription);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("screenshot taken ------");
		String path = MyUtils.takeScreenshot(Base.getDriver(), result.getName());
		String testDescription = result.getMethod().getDescription();
		log.info("Test Fail: "+testDescription);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		String testDescription = result.getMethod().getDescription();
		log.info("Test Skipped: "+testDescription);
	}

	@Override
	public void onStart(ITestContext context) {
		log.info("Test started for : "+context.getName());
	
	}

	@Override
	public void onFinish(ITestContext context) {
	log.info("Test finished for : "+context.getName());
	}

}
