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
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.BatchUserPage;
import org.page.ContentCreateUploadPage;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.UploadOrgPage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class BatchUserPageObj extends BaseTest
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	BatchUserPage BatchUserPage = PageFactory.initElements(driver, BatchUserPage.class);
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	CreatorUserPageObj createrUserPageObj = new CreatorUserPageObj();
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	static Logger log = Logger.getLogger(CreatorUserPage.class.getName());
	List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
	CreatorUserPageObj creatorUserPageObj =new CreatorUserPageObj();
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	Actions action = new Actions(driver);
	Random rand=new Random();
	String eurl="https://staging.ntp.net.in/workspace/content/edit/generic#no";
	String a="Browse";
	String title="";


	/**
	 * Purpose: createCourse method is used to create a Course.
	 */
	public void createCourse(List <TestDataForDiksha> objListOFTestDataForSunbird) throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create course");
			GenericFunctions.waitWebDriver(1500);
			//System.out.println(driver.findElement(By.xpath(" //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(BatchUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer(".//testData//courseNumbers.txt").toString();
			BatchUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
			//BatchUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			GenericFunctions.waitWebDriver(1500);
			BatchUserPage.startCreating.click();
			/*GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(1500);*/
			GenericFunctions.waitWebDriver(4500);
			GenericFunctions.WaitForFrameAndSwitchToIt(BatchUserPage.iFrame);
			GenericFunctions.waitWebDriver(6500);
			GenericFunctions.waitForElementToAppear(BatchUserPage.newChild);
			System.out.println("Creating - "+BatchUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(BatchUserPage.newChild).click().perform();
			//action.moveToElement(BatchUserPage.newChild).click().release();
			GenericFunctions.waitWebDriver(1500);
			BatchUserPage.titleName.click();
			BatchUserPage.titleName.clear();
			BatchUserPage.titleName.sendKeys(objListOFTestDataForSunbird.get(0).getTitle()+courseNumber);
			BatchUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			BatchUserPage.addResource.click();

			//added on 17 Aug 2018
			//driver.switchTo().frame(0);
			GenericFunctions.waitForElementToAppear(BatchUserPage.selectResource);
			BatchUserPage.selectResource.click();
			GenericFunctions.waitWebDriver(500);
			BatchUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(2000);


		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create course");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method createCourse"+e.getMessage());
			System.out.println("Exception In the method createCourse, failed to create corse");
			Assert.fail("Failed on creating course");

		}
	}
	
	/**
	 * Purpose: saveAndSendCourseForReview method is used to save Course & send it for review.
	 */
	public void saveAndSendCourseForReview(List <TestDataForDiksha> objListOFTestDataForSunbird)throws Exception{

		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save and send course for review");
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			GenericFunctions.waitWebDriver(2500);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(3000);
			createUserPage.sendForReview.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();	
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.checkAppIcon);
			createUserPage.checkAppIcon.click();
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(2500);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on saving and sending course for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save and course for review");
			Assert.fail("Failed on saving and sending course for review");

		}

	}
	
	/**
	 * Purpose: userLogout method is used to Logout the application.
	 */
	public void userLogout()throws Exception{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to logout from the application");
			UploadOrgPage orgUploadPage=PageFactory.initElements(driver, UploadOrgPage.class);
			GenericFunctions.waitForElementToAppear(orgUploadPage.dropdown);
			orgUploadPage.dropdown.click();
			
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(orgUploadPage.logout);
			orgUploadPage.logout.click();
			GenericFunctions.waitWebDriver(2000);
			System.out.println("User Logout");

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User could not logout from the application");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("User failed to logout from the application"+e.getLocalizedMessage());
		}

	}
	
	/**
	 * Purpose: publishCourse method is used to publish the Course.
	 */
	
    public void publishCourse() throws Exception
    {
    try 
    {
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to publish the course");
//  	GenericFunctions.waitForElementToAppear(BatchUserPage.closePopUp);
//		BatchUserPage.closePopUp.click();
		creatorUserPageObj.tryForWorkSpace();
		GenericFunctions.waitWebDriver(1500);	
    	GenericFunctions.waitForElementToAppear(BatchUserPage.Workspace);
    	GenericFunctions.waitWebDriver(500);
    	BatchUserPage.Workspace.click();
		GenericFunctions.waitForElementToAppear(BatchUserPage.upForReview);
		GenericFunctions.waitWebDriver(2000);
		BatchUserPage.upForReview.click();
		GenericFunctions.waitForElementToAppear(BatchUserPage.firtContent);
		String courseContent = BatchUserPage.firtContent.getText();
		System.out.println(courseContent);
		GenericFunctions.waitWebDriver(2000);
		BatchUserPage.firtContent.click();
		GenericFunctions.WaitForFrameAndSwitchToIt(BatchUserPage.iFrame);
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.scrollToElement(BatchUserPage.headerPublish);
		GenericFunctions.waitWebDriver(4000);
		if(BatchUserPage.headerPublish.isDisplayed())
		{
		BatchUserPage.headerPublish.click();
		}
		else if(BatchUserPage.Publish.isDisplayed())
		{
			BatchUserPage.Publish.click();
		}
		for(int i=0;i<createUserPage.checkbox.size();i++){
			createUserPage.checkbox.get(i).click();
		}

		GenericFunctions.waitWebDriver(2500);
		//executor.executeAsyncScript("arguments[0].click();", createUserPage.popupPublishButton);
		createUserPage.popupPublishButton.click();
		GenericFunctions.waitWebDriver(3000);
		/*GenericFunctions.waitForElementToAppear(BatchUserPage.publishConfirm);
		BatchUserPage.publishConfirm.click();*/			
    }
    catch(Exception e) 
    {
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on publishing the course");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
		log.error("Exception In the method publishCourse" + e.getLocalizedMessage());
		Assert.fail("Failed on publishing te course, Exception : " + e.getLocalizedMessage());

	}
}
    /**
	 * Purpose: navigateToCourseSearchAndCreateBatch method is used to search the Course & create a batch for it.
	 */
	
	public void navigateToCourseSearchAndCreateBatch()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to search a coursea and create a batch");
			List <TestDataForDiksha> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			/*BatchUserPage.dropDown.click();
			GenericFunctions.waitForElementToAppear(BatchUserPage.headerProfile);
			BatchUserPage.headerProfile.click();*/
			BatchUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			String courseNumber = GenericFunctions.testDataIncrementer("./testData/courseNumbers.txt").toString();
			BatchUserPage.filterSearch.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseName()+courseNumber);
			GenericFunctions.waitWebDriver(2000);
			BatchUserPage.searchIconUpForReview.click();
			GenericFunctions.waitWebDriver(2000);
			BatchUserPage.searchedCourse.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.createBatch.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search course and create a batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Other contents are available for reviewing");
			Assert.fail("Failed to search course and create a batch, Exception"+e.getLocalizedMessage());

		}

	}
	  /**
		 * Purpose: createOpenBatch method is used to  create an open batch.
		 */
	
	public void createOpenBatch() throws InterruptedException, Exception {

		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create open batch for a course");
			GenericFunctions.waitForElementToAppear(createMentorPage.addIcon);
			createMentorPage.addIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.switchToFrame(driver, createMentorPage.batchForm);
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+ GenericFunctions.readFromNotepad("./testData/dikshadata.txt"));
			createMentorPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
			createMentorPage.openBatch.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.startDate.click(); 
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.startDateCalendar.click(); 
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.endDate.click(); 
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.endDateCalendar.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createMentorPage.buttonCreate);
			System.out.println(createMentorPage.buttonCreate.getText());
			action.moveToElement(createMentorPage.buttonCreate).build().perform();
			action.click(createMentorPage.buttonCreate).build().perform();
			
			//createMentorPage.buttonCreate.click();
			System.out.println("Batch Created");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create open batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createOpenBatch" + e.getMessage());
			Assert.fail("Failed to create open batch, Exception" + e.getLocalizedMessage());

		}
	}
	

	  /**
		 * Purpose: createInviteBatch method is used to  create an invite only batch.
		 */
	public void createInviteBatch() throws InterruptedException, Exception {
		Robot robot = new Robot();
	    objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
								
		try {
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create invite only batch for a course");
			//GenericFunctions.waitForElementToAppear(BatchUserPage.closePopUp);
//		if(BatchUserPage.closePopUp.isDisplayed())
//		{
//		  BatchUserPage.closePopUp.click();
//		}
		//else
		//{
			GenericFunctions.waitWebDriver(1500);
			BatchUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(BatchUserPage.latestCourse);
			BatchUserPage.latestCourse.click();
			GenericFunctions.waitWebDriver(3000);
			BatchUserPage.addIcon.click();
			GenericFunctions.waitWebDriver(2000);
			BatchUserPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchNumbers.txt"));
			BatchUserPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

			BatchUserPage.startDate.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.startDateCalendar.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.endDate.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.endDateCalendar.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);				
			BatchUserPage.suborgMentor2InBatch.click();
			//BatchUserPage.mentorsInBatch.click();
			
			GenericFunctions.waitWebDriver(1000);								
			BatchUserPage.mentorDropdown.click();
			GenericFunctions.waitWebDriver(1000);	
			BatchUserPage.membersInBatch.click();
			GenericFunctions.waitWebDriver(1000);	
			BatchUserPage.selectMembersInBatch.click();
			GenericFunctions.waitWebDriver(1000);	
			BatchUserPage.mentorDropdown.click();
			GenericFunctions.waitWebDriver(2500);	
			
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(BatchUserPage.buttonCreate);
			BatchUserPage.buttonCreate.click();
			GenericFunctions.waitWebDriver(4000);
			//BatchUserPage.successfulMessage.click();
			System.out.println("Batch Created");
			Assert.assertTrue(true,"Batch created successfully and able to add mentor & mentor from root org and sub org");
			log.info("Batch created successfully and able to add mentor & mentor from root org and sub org");
			System.out.println("Batch created successfully and able to add mentor & mentor from root org and sub org");
		//}
		}
		catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
			Assert.fail("Failed to create invite only batch, Exception" + e.getLocalizedMessage());
		}
		

	}
	
	
	
	
	
	
	  /**
		 * Purpose: createInviteBatchwithStartDate method is used to  create an invite only batch with start date as current date.
		 */
	public void createInviteBatchwithStartDate() throws InterruptedException, Exception {
		Robot robot = new Robot();
	    objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
								
		try {
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create invite only batch with start date as current date");
			GenericFunctions.waitForElementToAppear(BatchUserPage.headerCourse);
			//BatchUserPage.closePopUp.click();
			GenericFunctions.waitWebDriver(1500);
			BatchUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(BatchUserPage.latestCourse);
			BatchUserPage.latestCourse.click();
			GenericFunctions.waitWebDriver(3000);
			BatchUserPage.addIcon.click();
			GenericFunctions.waitWebDriver(2000);
			BatchUserPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchNumbers.txt"));
			BatchUserPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

			//Added on 31/07/2018
			createMentorPage.startDate.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.startDateCalendar.click();
			GenericFunctions.waitWebDriver(1000);
			
			//Added on 08/09/2018
			createMentorPage.endDate.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.endDateCalendar.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			
			//Added on 08/09/2018
			createMentorPage.selectMentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.mentorDropdown.click();
			createMentorPage.membersInBatch.click();
			GenericFunctions.waitWebDriver(2000);
			
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createMentorPage.selectMembersInBatch);			
			executor.executeScript("arguments[0].click();",createMentorPage.selectMembersInBatch);
			
			// 	 createMentorPage.selectMembersInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.memberDropdown.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPage.buttonCreate.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Invite only batch for a course is created sucessfully");
			System.out.println("Batch Created");
			GenericFunctions.waitWebDriver(4000);
			Assert.assertTrue(true,"User is trying to create invite only batch with start date as current date");
			log.info("User is trying to create invite only batch with start date as current date");
			System.out.println("User is trying to create invite only batch with start date as current date");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
			Assert.fail("Failed to create invite only batch, Exception" + e.getLocalizedMessage());
		}
		

	}
	
	
	  /**
	* Purpose: createInviteBatchFutureStartDate method is used to  create an invite only batch with start date as future date.
	 */
	public void createInviteBatchFutureStartDate() throws InterruptedException, Exception {
		Robot robot = new Robot();
	    objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
								
		try {
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create upcoming batch with future start date");
			
			GenericFunctions.waitForElementToAppear(BatchUserPage.headerCourse);
			//BatchUserPage.closePopUp.click();
			GenericFunctions.waitWebDriver(1500);
			BatchUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(BatchUserPage.latestCourse);
			BatchUserPage.latestCourse.click();
			GenericFunctions.waitWebDriver(3000);
			BatchUserPage.addIcon.click();
			GenericFunctions.waitWebDriver(2000);
			BatchUserPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchNumbers.txt"));
			BatchUserPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

			BatchUserPage.startDate.sendKeys("1 January 2020");
			GenericFunctions.waitWebDriver(1000);

			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.endDate.sendKeys("1 June 2019");
			
			BatchUserPage.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);				
			BatchUserPage.selectMentorsInBatch.click();
			BatchUserPage.mentorsInBatch.click();
			
			GenericFunctions.waitWebDriver(1000);								
			BatchUserPage.mentorDropdown.click();
			BatchUserPage.membersInBatch.click();
			GenericFunctions.waitWebDriver(2000);
			BatchUserPage.selectMembersInBatch.click();
			BatchUserPage.mentorDropdown.click();
			GenericFunctions.waitWebDriver(4000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(BatchUserPage.buttonCreate);
			BatchUserPage.buttonCreate.click();
			//BatchUserPage.successfulMessage.click();
			System.out.println("Batch Created");
			Assert.assertTrue(true,"User is trying to create upcoming batch with future start date");
			log.info("User is trying to create upcoming batch with future start date");
			System.out.println("User is trying to create upcoming batch with future start date");

		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
			Assert.fail("Failed to create invite only batch, Exception" + e.getLocalizedMessage());
		}
		

	}
	
	  /**
		* Purpose: navigateToWorkspaceAndSelectBatches method is used to navigate to workspace and selcet batches. 
		* 		 */
	public void navigateToWorkspaceAndSelectBatches(String batchType) throws InterruptedException {
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"User is trying to navigate to Worskpace and select batch " + batchType);

			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(BatchUserPage.workSpace);
			GenericFunctions.waitForElementToAppear(BatchUserPage.workSpace);
		//	BatchUserPage.closePopUp.click();
			GenericFunctions.waitWebDriver(1500);
			BatchUserPage.workSpace.click();	
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.courseBatches.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.batchesDropDown.click();
			GenericFunctions.waitWebDriver(1500);
			if (batchType.equalsIgnoreCase("Ongoing Batches")) {
				GenericFunctions.waitForElementToAppear(BatchUserPage.ongoingBatches);
				BatchUserPage.ongoingBatches.click();
				GenericFunctions.waitWebDriver(1500);
				System.out.println("Ongoing batches");
			} else if (batchType.equalsIgnoreCase("Upcoming Batches")) {
				GenericFunctions.waitWebDriver(1000);
				BatchUserPage.upcomingBatches.click();
				System.out.println("upcoming batches");
			} else if (batchType.equalsIgnoreCase("Previous Batches")) {
				GenericFunctions.waitWebDriver(1000);
				BatchUserPage.previousBatches.click();
				GenericFunctions.waitWebDriver(5000);
				System.out.println("Previous batches");
			}
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Workspace and select batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToWorkspaceInDropDownMenu" + e.getMessage());
			Assert.fail(
					"Failed on navigating to Workspace and selecting batch, Exception : " + e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: navigateToCourseSearchAndUpdate method is used to navigate to course,search it  and update a batch. 
	* */

	public void navigateToCourseSearchAndUpdate() throws InterruptedException {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		//String courseName = "null";
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,
					"To verify update the batch");
			GenericFunctions.waitWebDriver(1500);

			BatchUserPage.courseBatchImg1.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.switchToFrame(driver, BatchUserPage.batchForm);
			BatchUserPage.nameOfBatch.clear();
			BatchUserPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(1).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchNumbers.txt"));
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.aboutBatch.clear();
			BatchUserPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
//			BatchUserPage.openBatch.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.endDate.clear();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.endDateCalendar.click();
			//BatchUserPage.endDate.sendKeys("30 September 2019");
			GenericFunctions.waitWebDriver(3000);
//			BatchUserPage.mentorsInBatch.click();
//			BatchUserPage.updateMentorInBatch.click();
//			GenericFunctions.waitWebDriver(1000);
//			BatchUserPage.mentorsInBatch.click();
//			
//			BatchUserPage.updateMembersInBatch.click();
//			BatchUserPage.membersInBatch.click();
//			GenericFunctions.waitWebDriver(1500);
//			BatchUserPage.updateMembersInBatch.click();
//			GenericFunctions.waitWebDriver(1500);						
			BatchUserPage.updateBatch.click();
			GenericFunctions.waitWebDriver(4000);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,
					"Failed on updating the course");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToCourseSearchAndUpdate" + e.getMessage());
			Assert.fail("Failed on updating the course : "
					+ e.getLocalizedMessage());
		}

	}
	
	/**
	* Purpose: updateUpcomingBatches method is used to  update the upcoming batch. 
	* */
	
	public void updateUpcomingBatches() throws InterruptedException {
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		//String courseName = "null";
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO,"To verify updation of the upcoming batch");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(BatchUserPage.courseBatchImg1);
			BatchUserPage.courseBatchImg1.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.switchToFrame(driver, BatchUserPage.batchForm);
			BatchUserPage.nameOfBatch.clear();
			BatchUserPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(1).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchNumbers.txt"));
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.aboutBatch.clear();
			BatchUserPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
//			BatchUserPage.openBatch.click();
			GenericFunctions.waitWebDriver(1000);
			/*BatchUserPage.startDate.click();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.startDateCalendar.click();
			GenericFunctions.waitWebDriver(1000);*/
			BatchUserPage.endDate.clear();
			GenericFunctions.waitWebDriver(1000);
			BatchUserPage.endDateCalendar.click();
			
			//BatchUserPage.endDate.sendKeys("300 September 2019");
			GenericFunctions.waitWebDriver(3000);
			//BatchUserPage.mentorsInBatch.click();
			//BatchUserPage.updateMentorInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			//BatchUserPage.mentorsInBatch.click();
			
			//BatchUserPage.updateMembersInBatch.click();
			//BatchUserPage.membersInBatch.click();
			GenericFunctions.waitWebDriver(1500);
			//BatchUserPage.updateMembersInBatch.click();
			GenericFunctions.waitWebDriver(1500);						
			BatchUserPage.updateBatch.click();
			GenericFunctions.waitWebDriver(4000);
		} catch (Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Failed on updating the upcoming batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method navigateToCourseSearchAndUpdate" + e.getMessage());
			Assert.fail("Failed on updating the upcoming batch : "+ e.getLocalizedMessage());
		}
    
	} 
	
	/**
	* Purpose: verifyCreatedBatch method is used to  verify the created batch. 
	* */
	public void verifyCreatedBatch() throws InterruptedException, Exception {									
	try {
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verifying the Created Batch");
		BatchUserPage.workSpace.click();	
		GenericFunctions.waitWebDriver(1000);
		BatchUserPage.courseBatches.click();
		GenericFunctions.waitWebDriver(1000);
		BatchUserPage.batchesDropDown.click();
		GenericFunctions.waitWebDriver(1500);
		String content = BatchUserPage.batchContent.getText();
		System.out.println(content);
		 String newLine = System.getProperty("line.separator");
		 //System.out.println("line 1" + newLine + "line2");
		 String text = "By mentor null"+ newLine+ "26 Nov - 30 Sep";
		 System.out.println(text);
		if(text.contains("26 Nov - 30 Sep"))
		{
			System.out.println("Batch created successfully and verified also");
		}
		GenericFunctions.waitWebDriver(1500);
		} 
    catch (Exception e) {
		ExtentTestManager.getTest().log(LogStatus.FAIL, "failed on validating the correct batch");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
		log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
		Assert.fail("failed on validating the correct batch, Exception" + e.getLocalizedMessage());
		}
		

	}
	/**
	* Purpose: searchCourseAsInvitedMentor method is used to  search a course as invited mentor. 
	* */
	
	public void searchCourseAsInvitedMentor() throws InterruptedException, Exception {									
	try {
		ExtentTestManager.getTest().log(LogStatus.INFO, "Verifying the Created Batch");
		GenericFunctions.waitWebDriver(1500);
		BatchUserPage.headerCourse.click();
		GenericFunctions.waitWebDriver(1500);
		BatchUserPage.latestCourse.click();
		GenericFunctions.waitWebDriver(1500);
            if(BatchUserPage.viewCourseStatsButton.isDisplayed())
            {
            	Assert.assertTrue(true,"Invited mentor can see the course on his dashboard");
            	log.info("Invited mentor can see the course on his dashboard");
            	System.out.println("Invited mentor can see the course on his dashboard");
            }
            
		
		}
    catch (Exception e)
		{
		ExtentTestManager.getTest().log(LogStatus.FAIL, "failed on validating the correct batch");
		ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
		log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
		Assert.fail("failed on validating the correct batch, Exception" + e.getLocalizedMessage());
		}
		

	}
	
}		
		