package com.testcase;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerClass extends TestHelper implements ITestListener {

	public void onTestFailure(ITestResult result) {
		System.out.println("Test is Failed");
		try {
			captureScreenShot(result.getName());
		} catch (Exception e) {
			e.getMessage();// TODO : handle exception
		}
	}

}
