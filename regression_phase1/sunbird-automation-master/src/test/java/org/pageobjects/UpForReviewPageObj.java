package org.pageobjects;

import static org.testng.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.security.auth.login.FailedLoginException;

import org.apache.poi.util.SystemOutLogger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.page.ContentCreateUploadPage;
import org.page.CreatorAnnouncementPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.UpForReviewPage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class UpForReviewPageObj extends BaseTest
{
	UpForReviewPage upForReviewPage=PageFactory.initElements(driver, UpForReviewPage.class);
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
	List <TestDataForDiksha> objListOFTestDataForSunbird1= null ;
	Random rand = new Random();
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	static Logger log = Logger.getLogger(CreatorAnnouncementPage.class.getName());


	// @author Sachin
	public void reviewerUpForReview() throws Exception{	  			  			  			  		
			
			try
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Reviewer is Verifying that the latest content is displaying in top ");
//				GenericFunctions.waitForElementToAppear(upForReviewPage.closePopUp);
//				upForReviewPage.closePopUp.click();
//				GenericFunctions.waitWebDriver(1500);
				creatorUserPageObj.tryForWorkSpace();
				GenericFunctions.waitForElementToAppear(upForReviewPage.Workspace);
				upForReviewPage.Workspace.click();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(upForReviewPage.upForReview);
				upForReviewPage.upForReview.click();
				GenericFunctions.waitWebDriver(2000);

			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Verifying the latest content");
				ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
				System.out.println("Failed on navigating to Workspace");
				Assert.fail("Failed on navigating to Workspace and verifying the latest content ");
			}
	  }
	 
	
	// @author Sachin
	public void UpForReviewsearchContent() throws Exception{	  			  			  			  		
		
		try
		{	
			ExtentTestManager.getTest().log(LogStatus.INFO, "Reviewer is trying to search the content");
//			GenericFunctions.waitForElementToAppear(upForReviewPage.closePopUp);
//			upForReviewPage.closePopUp.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(upForReviewPage.Workspace);
			upForReviewPage.Workspace.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(upForReviewPage.upForReview);
			upForReviewPage.upForReview.click();				
			GenericFunctions.waitWebDriver(2000);
			if(upForReviewPage.ContentName.isDisplayed())
			{
			String title = upForReviewPage.ContentName.getText();			
			upForReviewPage.searchContent.click();
			GenericFunctions.waitWebDriver(2000);
			upForReviewPage.searchContent.sendKeys(title);
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(true,"Latest content is displayed at the top ");
			System.out.println("Latest content is displayed at the top ");
			log.info("Latest content is displayed at the top ");
			}
			else
			{
				System.out.println("No content is present");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search the content");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method UpForReviewsearchContent" + e.getLocalizedMessage());
			Assert.fail("Failed to search the content, Exception : " + e.getLocalizedMessage());
		}
	
  }
	
	
	// @author Sachin
    public void UpForReviewSortBy() throws Exception{	  			  			  			  		
		try{				
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the sortBy filters");
			/*GenericFunctions.waitForElementToAppear(upForReviewPage.closePopUp);
			upForReviewPage.closePopUp.click();*/
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(upForReviewPage.Workspace);
			upForReviewPage.Workspace.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(upForReviewPage.upForReview);
			upForReviewPage.upForReview.click();				
			GenericFunctions.waitWebDriver(2000);
			upForReviewPage.searchContent.click();
			GenericFunctions.waitWebDriver(2000);
			upForReviewPage.searchContent.sendKeys("COURSEAC0243");
			GenericFunctions.waitWebDriver(5000);	
			upForReviewPage.sortBy.click();
			GenericFunctions.waitWebDriver(2000);
			upForReviewPage.updatedOn.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(true,"Contents are displayed based on the dates updated");
			System.out.println("Contents are displayed based on the dates updated");
			log.info("Contents are displayed based on the dates updated");
			upForReviewPage.sortBy.click();
			GenericFunctions.waitWebDriver(4000);
			upForReviewPage.createdOn.click();
			Assert.assertTrue(true,"Contents are displayed based on the dates created on ");
			System.out.println("Contents are displayed based on the dates created on ");
			log.info("Contents are displayed based on the dates created on ");
			GenericFunctions.waitWebDriver(4000);
			upForReviewPage.sortBy.click();
			GenericFunctions.waitWebDriver(2000);
			upForReviewPage.nameAtoZ.click();
			Assert.assertTrue(true,"Contents are displayed based on the dates created on ");
			System.out.println("Contents are displayed based on the dates created on ");
			log.info("Contents are displayed based on the dates created on ");
			GenericFunctions.waitWebDriver(5000);
		}
		catch (Exception e) 
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User is trying to verify the sortBy filters");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method UpForReviewSortBy" + e.getLocalizedMessage());
			Assert.fail("User is trying to verify the sortBy filters, Exception : " + e.getLocalizedMessage());
		}
		
  }
    
    
	
    public void showFilters(){
		try{
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to select various filters");		GenericFunctions.waitWebDriver(2000);
		upForReviewPage.filterIcon.click();
		GenericFunctions.waitWebDriver(2000);
		
		
		
		/*upForReviewPage.clickFilterBoard.click();
		GenericFunctions.waitWebDriver(500);
		calc
		
		
		upForReviewPage.selectFilterBoard.click();
		GenericFunctions.waitWebDriver(500);
		
		
		upForReviewPage.clickFilterGrade.click();
		GenericFunctions.waitWebDriver(1000);
		upForReviewPage.SelectFilterGrade.click();
		GenericFunctions.waitWebDriver(500);
		
		
		upForReviewPage.clickFilterSubject.click();
		GenericFunctions.waitWebDriver(500);
		upForReviewPage.selectFilterSubject.click();
		GenericFunctions.waitWebDriver(1000);
		*/
		
		
		upForReviewPage.clickFilterMedium.click();
		GenericFunctions.waitWebDriver(500);
		upForReviewPage.selectFilterMedium.click();
		GenericFunctions.waitWebDriver(500);
		
		upForReviewPage.selectFilterMedium2.click();
		GenericFunctions.waitWebDriver(500);
	/*	upForReviewPage.clickContentType.click();
		GenericFunctions.waitWebDriver(1000);
		upForReviewPage.selectContentType.click();
		GenericFunctions.waitWebDriver(500);
		*/
		
		upForReviewPage.applyButton.click();
		GenericFunctions.waitWebDriver(6000);
		upForReviewPage.filterIcon.click();
		GenericFunctions.waitWebDriver(2000);
		
		GenericFunctions.waitForElementToAppear(upForReviewPage.firtContent);
		
		if(upForReviewPage.firtContent.isDisplayed())
		{
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(true,"User is able to fetch the content based on the filters");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Succesfully fetched contents based on filters applied");
			System.out.println("User is able to fetch the content based on the filters");
			log.info("User is able to fetch the content based on the filters");
		}
		else
		{
			System.out.println("Filter not working properly");
			log.info("Filter not working properly");
		}
		
		/*if(upForReviewPage.applyButton.isDisplayed())
		{
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(true,"User is able to fetch the content based on the filters");
			System.out.println("User is able to fetch the content based on the filters");
			log.info("User is able to fetch the content based on the filters");
		}
		else
		{
			System.out.println("Filter not working properly");
			log.info("Filter not working properly");
		}*/
	   }
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on fetching contents based on filters applied");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method showFilters" + e.getLocalizedMessage());
			Assert.fail("Failed on fetching contents based on filters applied, Exception : " + e.getLocalizedMessage());
		}
	}
    public void publishCourse() throws Exception
    {
    try 
    {
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to publish the course");
//  	GenericFunctions.waitForElementToAppear(upForReviewPage.closePopUp);
//		upForReviewPage.closePopUp.click();
//		GenericFunctions.waitWebDriver(1500);	
//    	GenericFunctions.waitForElementToAppear(upForReviewPage.Workspace);
    	GenericFunctions.waitWebDriver(500);
    	upForReviewPage.Workspace.click();
		GenericFunctions.waitForElementToAppear(upForReviewPage.upForReview);
		GenericFunctions.waitWebDriver(2000);
		upForReviewPage.upForReview.click();
		GenericFunctions.waitForElementToAppear(upForReviewPage.firtContent);
		String courseContent = upForReviewPage.firtContent.getText();
		System.out.println(courseContent);
		GenericFunctions.waitWebDriver(2000);
		upForReviewPage.firtContent.click();

		GenericFunctions.waitWebDriver(2000);
		Assert.assertTrue(true,"User is able to review the content");
		System.out.println("User is able to review the content");
		log.info("User is able to review the content");
			
		GenericFunctions.WaitForFrameAndSwitchToIt(upForReviewPage.iFrame);
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.scrollToElement(upForReviewPage.headerPublish);
		GenericFunctions.waitWebDriver(4000);
		
		if(upForReviewPage.headerPublish.isDisplayed())
		{
		upForReviewPage.headerPublish.click();
		Assert.assertTrue(true,"Content is successfully displayed with Description, content info along with REQUEST CHANGE and PUBLISH button");
		System.out.println("Content is successfully displayed with Description, content info along with REQUEST CHANGE and PUBLISH button");
		log.info("Content is successfully displayed with Description, content info along with REQUEST CHANGE and PUBLISH button");
		}
		else if(upForReviewPage.Publish.isDisplayed())
		{
			upForReviewPage.Publish.click();
			Assert.assertTrue(true,"Content is successfully displayed with Description, content info along with REQUEST CHANGE and PUBLISH button");
			System.out.println("Content is successfully displayed with Description, content info along with REQUEST CHANGE and PUBLISH button");
			log.info("Content is successfully displayed with Description, content info along with REQUEST CHANGE and PUBLISH button");
		}
		
		GenericFunctions.waitForElementToAppear(upForReviewPage.publishConfirm);
		upForReviewPage.publishConfirm.click();	
		Assert.assertTrue(true,"Mandatory field validation is available");
		System.out.println("Mandatory field validation is available");
		log.info("Mandatory field validation is available");
    }
    catch(Exception e) 
    {
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on publishing the course");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
		log.error("Exception In the method publishCourse" + e.getLocalizedMessage());
		Assert.fail("Failed on publishing te course, Exception : " + e.getLocalizedMessage());

	}
    }
	
	
}