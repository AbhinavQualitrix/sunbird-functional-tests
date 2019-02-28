package org.pageobjects;

import org.apache.log4j.Logger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorUserPage;
import org.page.ExplorePage;
import org.startup.BaseTest;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class ExplorePageobj extends BaseTest{
	
	ExplorePage explorePage = PageFactory.initElements(driver, ExplorePage.class);
	static Logger log = Logger.getLogger(CreatorUserPage.class.getName());
	/**
	 * Purpose: navigateToExplorePage method is used to navigate to explore page.
	 */
	
	public void navigateToExplorePage() throws Exception{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To ExplorePage");
			GenericFunctions.waitWebDriver(2000);
			driver.get(APP_URL+"/explore");
			GenericFunctions.waitForElementToAppear(explorePage.clickOnFirstTextBook);
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigate To ExplorePage");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToExplorePage" + e.getLocalizedMessage());
			Assert.fail("Failed on navigate To ExplorePage" + e.getLocalizedMessage());
			
		}	
	}
	
	/**
	 * Purpose: navigateToTOCPage method is used to upload a navigate to TOC page.
	 */
	
	public void navigateToTOCPage() throws Exception{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To TOC Page");
			GenericFunctions.waitWebDriver(2000);
			driver.get(APP_URL+"/explore");
			explorePage.clickOnFirstTextBook.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigate To TOC Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToTOCPage" + e.getLocalizedMessage());
			Assert.fail("Failed on navigate To TOC Page" + e.getLocalizedMessage());
			
		}	
	}
	
	/**
	 * Purpose: navigateToContentDisplayPage method is used to upload a navigate to Content Display page.
	 */
	
	public void navigateToContentDisplayPage() throws Exception{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Content Display Page");
			GenericFunctions.waitWebDriver(2000);
			driver.get(APP_URL+"/explore");
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigate To Content Display Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToContentDisplayPage" + e.getLocalizedMessage());
			Assert.fail("Failed on navigate To Content Display Page" + e.getLocalizedMessage());
			
		}	
	}
	
	/**
	 * Purpose: verifyAvailabilityOfLibraryAndCourse method is used to verify availability of library and course fields.
	 */
	
	public void verifyAvailabilityOfLibraryAndCourse() throws Exception{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify Availability Of Library And Course");
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.waitForElementToAppear();
			
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on verify Availability Of Library And Course");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method verifyAvailabilityOfLibraryAndCourse" + e.getLocalizedMessage());
			Assert.fail("Failed on verify Availability Of Library And Course" + e.getLocalizedMessage());
			
		}	
	}
	
	
}
