package com.soucedemo.listeners;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.soucedemo.base.Base;
import com.soucedemo.pages.LoginPage;
import com.soucedemo.utility.ExtentManager;
import com.soucedemo.utility.ExtentTestManager;
import com.soucedemo.utility.MyUtils;

public class MyListener implements ITestListener {
	
	private static final Logger log = LogManager.getLogger(MyListener.class);

	private static String testName(ITestResult result) {
		String testDescription = result.getMethod().getDescription();
		if (testDescription == null || testDescription.isEmpty()) {
			testDescription = result.getMethod().getMethodName();
		}
		return testDescription;
	}
	
	
	@Override
	public void onTestStart(ITestResult result) {
		
		log.info("Test Started "+testName(result));
		ExtentTestManager.startTest(testName(result));
	}

	@Override
	public void onTestSuccess(ITestResult result) {
	
		log.info("Test Pass: "+testName(result));
		ExtentTestManager.getTest().log(Status.PASS, "Test Passed: "+ testName(result));
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("screenshot taken ------");
		log.info("Test Fail: "+testName(result));
		String path = MyUtils.takeScreenshot(Base.getDriver(), result.getName());
	
		ExtentTestManager.getTest().addScreenCaptureFromPath(path);
		ExtentTestManager.getTest().log(Status.FAIL, "Test Faied: " + result.getThrowable());
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		log.info("Test Skipped: "+testName(result));
		ExtentTestManager.getTest().log(Status.SKIP, "Test Skiped: "+ testName(result));
	}

	@Override
	public void onStart(ITestContext context) {
		log.info("Test started for : "+context.getName());
	
	}

	@Override
	public void onFinish(ITestContext context) {
	log.info("Test finished for : "+context.getName());
	
	ExtentManager.getExtent().flush();
	
	}

}
