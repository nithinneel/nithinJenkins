package com.crm.genericUtilities;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalysisImplement implements IRetryAnalyzer{
	
	int count=0;
	int retryLimit=3;
	
	public boolean retry(ITestResult result) {
		if (count<retryLimit) {
			count++;
			return true;
		}
		return false;
	}
	
}
