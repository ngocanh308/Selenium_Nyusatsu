package com.testcase;

import org.testng.ITestListener;
import org.testng.ITestResult;

import com.common.ultilities.Log;

public class ListenerClass extends TestHelper implements ITestListener {

	public void onTestFailure(ITestResult result) {
		Log.info("Testcase failed___________log");
		try {
			captureScreenShot(result.getName());
		} catch (Exception e) {
			e.getMessage();// TODO : handle exception
		}
	}

	public void onTestSkipped(ITestResult result) {
		Log.info("Testcase Skipped___________log");
		try {
			captureScreenShot(result.getName());
		} catch (Exception e) {
			e.getMessage();// TODO : handle exception
		}
	}
}
