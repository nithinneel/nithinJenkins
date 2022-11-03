package com.crm.genericUtilities;

import java.io.File;
import java.time.LocalDate;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListnerImplemplementation implements ITestListener{
	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.PASS, result.getMethod().getMethodName());
		test.log(Status.PASS, result.getThrowable());
	}

	public void onTestFailure(ITestResult result) {
		String testName = result.getMethod().getMethodName();
		
		test.log(Status.FAIL, result.getMethod().getMethodName());
		test.log(Status.FAIL, result.getThrowable());
		
		TakesScreenshot screenshot = (TakesScreenshot)BaseClass.sdriver;
		File src = screenshot.getScreenshotAs(OutputType.FILE);
		LocalDate datetime = LocalDate.now();
		File dest = new File("screenshots/"+"_"+testName+"_"+datetime+".PNG");
		try {
			FileUtils.copyDirectory(src, dest);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("problem in saving screenshot"+e.getMessage());
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		test.log(Status.SKIP, result.getMethod().getMethodName());
		test.log(Status.SKIP, result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ExtentSparkReporter spark = new ExtentSparkReporter("./ExtentReports/report.html");
		spark.config().setTheme(Theme.DARK);
		spark.config().setReportName("Framework Extent Repoet");
		spark.config().setDocumentTitle("Nithin Document");
		
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("createdBy","Nithin");
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		report.flush(); 
	}
	
}
