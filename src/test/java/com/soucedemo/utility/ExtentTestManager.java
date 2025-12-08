package com.soucedemo.utility;

import com.aventstack.extentreports.ExtentTest;

public class ExtentTestManager {

	 private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

	    public static synchronized ExtentTest getTest() {
	        return extentTest.get();
	    }

	    public static synchronized ExtentTest startTest(String testName) {
	        ExtentTest test = ExtentManager.getExtent().createTest(testName);
	        extentTest.set(test);
	        return test;
	    }
}
