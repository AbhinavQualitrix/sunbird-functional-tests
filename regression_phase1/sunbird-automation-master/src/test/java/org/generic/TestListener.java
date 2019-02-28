/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Ajith Manjunath

* Date: 05/02/2018

* Purpose: Contains all the methods which will help reporting. 
*/


package org.generic;

import org.apache.velocity.util.StringUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.startup.BaseTest;
import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;


import com.relevantcodes.extentreports.LogStatus;

public class TestListener extends BaseTest implements ITestListener {

	 
    private static String getTestMethodName(ITestResult iTestResult) {
        return iTestResult.getMethod().getConstructorOrMethod().getName();
    }
    
    private static String getTestClassName(ITestResult iTestResult)
    {
    	//return iTestResult.getTestName().toString();
    	//return iTestResult.getTestClass().toString();
    	return iTestResult.getMethod().getRealClass().getName();
    	
    }
    //Before starting all tests, below method runs.
    
	@Override
    public void onStart(ITestContext iTestContext) {
    	System.out.println("I am in onStart method " + iTestContext.getName());
        iTestContext.setAttribute("WebDriver", this.driver);
        
    }
 
    //After ending all tests, below method runs.
    @Override
    public void onFinish(ITestContext iTestContext) {
        System.out.println("I am in onFinish method " + iTestContext.getName());
        //Do tier down operations for extentreports reporting!
        ExtentTestManager.endTest();
        ExtentManager.getReporter().flush();
    }
 
    @Override
    public void onTestStart(ITestResult iTestResult) {
        System.out.println("I am in onTestStart method " +  getTestMethodName(iTestResult) + " start , I am in onTestStart class " +  getTestClassName(iTestResult) + " start");
        
        //Start operation for extentreports.
        ExtentTestManager.startTest(iTestResult.getMethod().getMethodName(),iTestResult.getTestClass().toString());
        //Get the class Name of the Test method
       // ExtentTestManager.startTest(iTestResult.getTestName(),"");
       // ExtentTestManager.startTest(iTestResult.getTestClass().toString(),"");
        System.out.println("Print on Test Start"+iTestResult.getTestClass().toString());
    }
 
    @Override
    public void onTestSuccess(ITestResult iTestResult) {
        System.out.println("I am in onTestSuccess method " +  getTestMethodName(iTestResult) + " succeed , I am in onTestSuccess class " +  getTestClassName(iTestResult) + " succeed");
       
        //Extentreports log operation for passed tests.
        
       
        
        ExtentTestManager.getTest().log(LogStatus.PASS, getTestClassName(iTestResult).toString()+" Test passed");	
    }
 
    @Override
    public void onTestFailure(ITestResult iTestResult) {
        System.out.println("I am in onTestFailure method " +  getTestMethodName(iTestResult) + " failed, I am in onTestFailure class " +  getTestClassName(iTestResult) + " failed");
        
 
        
        //Get driver from BaseTest and assign to local webdriver variable.
        Object testClass = iTestResult.getInstance();
        WebDriver webDriver = ((BaseTest) testClass).getDriver();
 
        //Take base64Screenshot screenshot.
        String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
                getScreenshotAs(OutputType.BASE64);
       //ExtentTestManager.startTest(iTestResult.getTestClass().toString(),"");
       
        //Extentreports log and screenshot operations for failed tests.
       
        
        ExtentTestManager.getTest().log(LogStatus.FAIL,getTestClassName(iTestResult)+" Test Failed",
                ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
        
        String image = ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot);
        String screenPath = "<img height='42' width='42' src='" + ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot)+"'/></img>";
        Reporter.log(screenPath);

    
    }
 
    @Override
    public void onTestSkipped(ITestResult iTestResult) {
        System.out.println("I am in onTestSkipped method "+  getTestMethodName(iTestResult) + " skipped , I am in onTestSkipped class "+  getTestClassName(iTestResult) + " skipped");
        
        //Extentreports log operation for skipped tests.
        ExtentTestManager.getTest().log(LogStatus.SKIP, getTestClassName(iTestResult)+" Test Skipped");
    }
 
    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
        System.out.println("Test failed but it is in defined success ratio " + getTestMethodName(iTestResult));
    }
    
    
    
}