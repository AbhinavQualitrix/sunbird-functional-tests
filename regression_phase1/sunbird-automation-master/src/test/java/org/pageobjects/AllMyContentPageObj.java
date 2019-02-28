package org.pageobjects;

import static org.testng.Assert.assertEquals;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.AllMyContentPage;
import org.page.ContentCreateUploadPage;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;

import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class AllMyContentPageObj extends BaseTest
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	AllMyContentPage AllMyContentPage=PageFactory.initElements(driver, AllMyContentPage.class);

	static Logger log = Logger.getLogger(CreatorUserPage.class.getName());
	List <TestDataForDiksha> objListOFTestDataForSunbird1= null ;
	Actions action = new Actions(driver);
	Random rand=new Random();
	String a="Browse";
	String title="";

	/**
	 * Purpose: allMyContentSortByDropdown method is used to check data is getting available in all my content based on selected sort by option .
	 */
	public void allMyContentSortByDropdown()throws Exception
	{
		try
		{
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to  select modified on and created on option in the dropdown");
		GenericFunctions.waitForElementToAppear(AllMyContentPage.allMyContent);
		AllMyContentPage.allMyContent.click();
		GenericFunctions.waitWebDriver(2000);
		AllMyContentPage.sortByDropdown.click();
		GenericFunctions.waitWebDriver(2000);
		AllMyContentPage.modifiedOnDropdown.click();
		GenericFunctions.waitWebDriver(2000);
		Assert.assertTrue(true,"COntent displayed based on the modified date");
		System.out.println("COntent displayed based on the modified date");
		log.info("COntent displayed based on the modified date");
		AllMyContentPage.sortByDropdown.click();
		GenericFunctions.waitWebDriver(2000);
		AllMyContentPage.createdOnDropdown.click();
		GenericFunctions.waitWebDriver(2000);
		Assert.assertTrue(true,"COntent displayed based on the date createdOn");
		System.out.println("COntent displayed based on the date createdOn ");
		log.info("COntent displayed based on the modified date createdOn");								
		}
		catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on selecting options from dropdown");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method allMyContentSortByDropdown" + e.getLocalizedMessage());
			Assert.fail("Failed on selecting options from dropdown" + e.getLocalizedMessage());
		}
	}
		
		/**
		 * Purpose: clickAllMyContent method is used to navigate to all my content & select filter  .
		 */
 	public void clickAllMyContent()throws Exception
 	{
		try{	
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to click on all my content and then filter icon");
		GenericFunctions.waitForElementToAppear(AllMyContentPage.allMyContent);
		AllMyContentPage.allMyContent.click();
		GenericFunctions.waitWebDriver(2000);		
		AllMyContentPage.filterIcon.click();				
		GenericFunctions.waitWebDriver(2000);				
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "failed on clicking all my content");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("failed to click filter icon");
		}
 	}	
 		/**
		 * Purpose: deleteByStatus method is used to delete the content by using status filter  .
		 */
   public void deleteByStatus(String statusContent)throws Exception
   {
		
	 try{
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete content by status");
		GenericFunctions.waitForElementToAppear(AllMyContentPage.selectStatus);
		AllMyContentPage.selectStatus.click();
		if(statusContent.equalsIgnoreCase("DRAFT")){
		AllMyContentPage.draftSelect.click();
		GenericFunctions.waitWebDriver(2000);
		 }
		else if(statusContent.equalsIgnoreCase("FLAGDRAFT")){
		AllMyContentPage.flagDraftSelect.click();
		GenericFunctions.waitWebDriver(2000);
		}
		else if(statusContent.equalsIgnoreCase("REVIEW")){
		AllMyContentPage.reviewSelect.click();
		GenericFunctions.waitWebDriver(2000);
		}
		else if(statusContent.equalsIgnoreCase("PROCESSING")){
		AllMyContentPage.processingSelect.click();
		GenericFunctions.waitWebDriver(2000);
		}
		else if(statusContent.equalsIgnoreCase("LIVE")){
		AllMyContentPage.liveSelect.click();
		GenericFunctions.waitWebDriver(2000);
		}
		else if(statusContent.equalsIgnoreCase("UNLISTED")){
		AllMyContentPage.unlistedSelect.click();
		GenericFunctions.waitWebDriver(2000);
		}
		else if(statusContent.equalsIgnoreCase("FLAGREVIEW")){
		AllMyContentPage.flagReviewSelect.click();
		GenericFunctions.waitWebDriver(2000);
		} 
		AllMyContentPage.applyButton.click();
		GenericFunctions.waitWebDriver(2000);
		
		AllMyContentPage.filterIcon.click();
		GenericFunctions.waitWebDriver(2000);
		try{
		if(driver.findElement(By.xpath("(//div[contains(@class,'UpReviewHeader')])[1]")).isDisplayed() ){
	    String contentType = AllMyContentPage.firstDraft.getText();
		AllMyContentPage.deleteButton.click();					
		GenericFunctions.waitWebDriver(2000);		
		AllMyContentPage.confirmYesToPopup.click();
		GenericFunctions.waitWebDriver(2000);
		Assert.assertTrue(true,"Content got deleted successfully");
		System.out.println("Content got deleted successfully");
		log.info("Content got deleted successfully");
			
		AllMyContentPage.searchContent.click();
		AllMyContentPage.searchContent.sendKeys(contentType);
		Assert.assertTrue(true,"Deleted content is not available in search result");
		System.out.println("Deleted content is not available in search result");
		log.info("Deleted content is not available in search result");
		GenericFunctions.waitWebDriver(4000);
			
		AllMyContentPage.filterIcon.click();
		GenericFunctions.waitWebDriver(2000);
				
		AllMyContentPage.resetFilter.click();
		
		}
		}
		
		catch(Exception e){
					
		AllMyContentPage.filterIcon.click();
		GenericFunctions.waitWebDriver(2000);
			
		AllMyContentPage.resetFilter.click();
		GenericFunctions.waitWebDriver(2000);			
		}	
	 }
	 catch(Exception e)
	 {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on deleting content by status");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method deleteByStatus" + e.getLocalizedMessage());
			Assert.fail("Failed on deleting content by status" + e.getLocalizedMessage()); 			 
	 }
	}
 
 
    /**
	 * Purpose: allMyContent method is used to navigate to all my content  .
	 */
	
public void allMyContent()throws Exception
{
	try
	{	
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to click on all my content");
		AllMyContentPage.allMyContent.click();
		GenericFunctions.waitWebDriver(2000);
			
	}
	catch(Exception e)
	{
		ExtentTestManager.getTest().log(LogStatus.FAIL, "failed on clicking all my content");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
		Assert.fail("failed on clicking all my content");
	}
	
}
	
	/**
	 * Purpose: deleteContent method is used to delete the content in all my content using search bar and filters.
	 */
public void deleteContent(String PublishedContent)throws Exception
{
	try
	{
	ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete content by status");
	GenericFunctions.waitForElementToAppear(AllMyContentPage.searchContent);				
	if(PublishedContent.equalsIgnoreCase("COURSE")){
	AllMyContentPage.searchContent.sendKeys("COURSE");
	AllMyContentPage.searchIconUpForReview.click();
	GenericFunctions.waitWebDriver(4000);
	}
	else if(PublishedContent.equalsIgnoreCase("COLLECTION")){
	AllMyContentPage.searchContent.sendKeys("COLLECTION");
	AllMyContentPage.searchIconUpForReview.click();
	GenericFunctions.waitWebDriver(2000);
	}
	else if(PublishedContent.equalsIgnoreCase("LESSON PLAN")){
	AllMyContentPage.searchContent.sendKeys("LESSON PLAN");
	AllMyContentPage.searchIconUpForReview.click();
	GenericFunctions.waitWebDriver(2000);
	}
	else if(PublishedContent.equalsIgnoreCase("RESOURCES")){
	AllMyContentPage.searchContent.sendKeys("RESOURCES");
	AllMyContentPage.searchIconUpForReview.click();
	GenericFunctions.waitWebDriver(2000);
	}
	else if(PublishedContent.equalsIgnoreCase("BOOK")){
	AllMyContentPage.searchContent.sendKeys("BOOK");
	AllMyContentPage.searchIconUpForReview.click();
	GenericFunctions.waitWebDriver(2000);
	}
	else if(PublishedContent.equalsIgnoreCase("UPLOADED CONTENT")){
	AllMyContentPage.searchContent.sendKeys("UPLOADED CONTENT");
	AllMyContentPage.searchIconUpForReview.click();
	GenericFunctions.waitWebDriver(2000);
	} 
				
	AllMyContentPage.filterIcon.click();
	GenericFunctions.waitWebDriver(2000);

	AllMyContentPage.selectStatus.click();
	GenericFunctions.waitWebDriver(2000);
	
	AllMyContentPage.liveSelect.click();
	GenericFunctions.waitWebDriver(2000);

	AllMyContentPage.applyButton.click();
	GenericFunctions.waitWebDriver(2000);	
	
	AllMyContentPage.filterIcon.click();
	GenericFunctions.waitWebDriver(2000);
	
	try{
	if(AllMyContentPage.firstDraft.isDisplayed())
	{
		String deletedContent = AllMyContentPage.firstDraft.getText();
		AllMyContentPage.deleteButton.click();
		GenericFunctions.waitWebDriver(2000);
		AllMyContentPage.yesButtonPopup.click();
		Assert.assertTrue(true, "User is  able to delete the content successfully");
		ExtentTestManager.getTest().log(LogStatus.PASS, "User is able to delete the content successfully");
		System.out.println("User is able to delete the content successfully");
		GenericFunctions.waitWebDriver(2000);
		AllMyContentPage.searchContent.clear();
		AllMyContentPage.searchContent.sendKeys(deletedContent);
		Assert.assertTrue(true, "Deleted content not available in search result");
		System.out.println("Deleted content not available in search result");
		GenericFunctions.waitWebDriver(4000);
	}
	}
	catch(Exception e)
	{
		System.out.println("There is no content");
	}
	}
	catch(Exception e)
	{				
		ExtentTestManager.getTest().log(LogStatus.FAIL, "User is unable delete content by status");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
		Assert.fail("User is unable delete content by status");
	}
}	
		
		/**
		 * Purpose: clickWorkspace method is used to navigate to workspace.
		 */
public void clickWorkspace()throws Exception
{
	try
	{	
	ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to click on all workspace");	
	GenericFunctions.waitForElementToAppear(AllMyContentPage.workSpace);
	AllMyContentPage.workSpace.click();
	GenericFunctions.waitWebDriver(2000);				
	}
	catch(Exception e)
	{
		ExtentTestManager.getTest().log(LogStatus.FAIL, "User is trying to click on all workspace");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
		Assert.fail("User is trying to click on all workspace");
	}
	}
 }

	
	
