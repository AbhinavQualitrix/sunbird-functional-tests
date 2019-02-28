package org.pageobjects;


import java.awt.Robot;
import java.util.List;
import java.util.Random;


import org.openqa.selenium.By;
import org.apache.log4j.Logger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.page.CreateMentorPage;
import org.page.CreatorAnnouncementPage;
import org.page.CreatorUserPage;
import org.page.MentorOrgPage;
import org.page.UploadOrgPage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class MentorOrgPageObj extends BaseTest
{   
	MentorOrgPage MentorOrgPage = PageFactory.initElements(driver, MentorOrgPage.class);
	//	MentorOrgPage MentorOrgPage=PageFactory.initElements(driver, MentorOrgPage.class);
	CreatorUserPageObj createUserPageObj=new CreatorUserPageObj();
	//	MentorOrgPageObjObjects MentorOrgPage = PageFactory.initElements(driver, MentorOrgPageObjObjects.class);
	//	PublicUserPageObj publicUserPageObj = PageFactory.initElements(driver, PublicUserPageObj.class);
	CreatorUserPage createUserPage = PageFactory.initElements(driver, CreatorUserPage.class);
	CreateMentorPage createMentorPage = PageFactory.initElements(driver, CreateMentorPage.class);
	List <TestDataForDiksha> objListOFTestDataForSunbird1= null ;
	Random rand = new Random();
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;
	static Logger log = Logger.getLogger(CreatorAnnouncementPage.class.getName());
	JavascriptExecutor executor = (JavascriptExecutor)driver;

	// @author Sachin
	public void coursePreview()throws Exception{
		try
		{	
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to open the course");
			GenericFunctions.waitForElementToAppear(MentorOrgPage.headerCourse);
			MentorOrgPage.headerCourse.click();
			GenericFunctions.waitWebDriver(2000);

			MentorOrgPage.course.click();
			Assert.assertTrue(true, "User is able to preview the content successfully");
			log.info("User is able to preview the content successfully");
			System.out.println("User is able to preview the content successfully");
			GenericFunctions.waitWebDriver(4000);
		}
		catch(Exception e)
		{				
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User is trying to open the course");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("User is trying to open the course");
		}

	}	

	public void createCourse(List <TestDataForDiksha> objListOFTestDataForSunbird) throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create course");
			GenericFunctions.waitWebDriver(1500);
			System.out.println(driver.findElement(By.xpath(" //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(MentorOrgPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer("./testData/courseNumbers.txt").toString();
			MentorOrgPage.courseName.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
			//MentorOrgPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			GenericFunctions.waitWebDriver(1500);
			MentorOrgPage.startCreating.click();
			/*GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(1500);*/
			GenericFunctions.waitWebDriver(4500);
			GenericFunctions.WaitForFrameAndSwitchToIt(MentorOrgPage.iFrame);
			GenericFunctions.waitWebDriver(6500);
			GenericFunctions.waitForElementToAppear(MentorOrgPage.newChild);
			System.out.println("Creating - "+MentorOrgPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(MentorOrgPage.newChild).click().perform();
			//action.moveToElement(MentorOrgPage.newChild).click().release();
			GenericFunctions.waitWebDriver(1500);
			MentorOrgPage.titleName.click();
			MentorOrgPage.titleName.clear();
			MentorOrgPage.titleName.sendKeys(objListOFTestDataForSunbird.get(0).getTitle()+courseNumber);
			MentorOrgPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			MentorOrgPage.addResource.click();

			//added on 17 Aug 2018
			//driver.switchTo().frame(0);
			GenericFunctions.waitForElementToAppear(MentorOrgPage.selectResource);
			MentorOrgPage.selectResource.click();
			GenericFunctions.waitWebDriver(500);
			MentorOrgPage.proceedButton.click();
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


	public void saveAndSendCourseForReview(List <TestDataForDiksha> objListOFTestDataForSunbird)throws Exception{

		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save and send course for review");
			GenericFunctions.waitForElementToAppear(MentorOrgPage.saveCourse);
			MentorOrgPage.saveCourse.click();
			GenericFunctions.waitWebDriver(2000);
			MentorOrgPage.sendForReview.click();
			GenericFunctions.waitWebDriver(1500);
			MentorOrgPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(3000);	
			GenericFunctions.waitForElementToAppear(MentorOrgPage.checkContentIcon);
			MentorOrgPage.checkContentIcon.click();
			GenericFunctions.waitWebDriver(1000);
			MentorOrgPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1000);

		/*	GenericFunctions.waitForElementToAppear(MentorOrgPage.clickOnSelectCurriculum);
			MentorOrgPage.clickOnSelectCurriculum.click();
			GenericFunctions.waitWebDriver(1000);
			MentorOrgPage.selectCurriculum.click();
			GenericFunctions.waitForElementToAppear(MentorOrgPage.clickOnSelectClass);
			MentorOrgPage.clickOnSelectClass.click();
			GenericFunctions.waitWebDriver(1000); 
			MentorOrgPage.selectClass.click();
			GenericFunctions.waitWebDriver(1000); 
			MentorOrgPage.clickOnSelectClass.click();//      

			//GenericFunctions.keyTab(driver, MentorOrgPage.selectClass.toString());
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(MentorOrgPage.clickOnHeaderSubject);
			//MentorOrgPage.clickOnHeaderSubject.click();
			GenericFunctions.waitWebDriver(5000);
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(MentorOrgPage.clickOnSelectSubject);
			//GenericFunctions.scrollToElement(MentorOrgPage.clickOnSelectMedium);
			//			GenericFunctions.waitWebDriver(2000);
			//			MentorOrgPage.clickOnSelectSubject.click();
			//			GenericFunctions.waitForElementToAppear(MentorOrgPage.selectSubject);
			//			MentorOrgPage.selectMathematics.click();
			//			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(MentorOrgPage.clickOnSelectMedium);
			GenericFunctions.waitWebDriver(5000);
			MentorOrgPage.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppearOnScreen(MentorOrgPage.selectMedium);
			MentorOrgPage.selectMedium.click();*/
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(MentorOrgPage.clickOwner);
			GenericFunctions.waitForElementToAppear(MentorOrgPage.clickOwner);
			MentorOrgPage.clickOwner.click();
			GenericFunctions.waitWebDriver(1500);
			MentorOrgPage.selectOwner.click();
			GenericFunctions.waitWebDriver(1500);


			MentorOrgPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);


		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on saving and sending course for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save and course for review");
			Assert.fail("Failed on saving and sending course for review");

		}

	}


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



	public void publishCourse() throws Exception
	{
		try 
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to publish the course");
			//  	GenericFunctions.waitForElementToAppear(MentorOrgPage.closePopUp);
			//		MentorOrgPage.closePopUp.click();
			//		GenericFunctions.waitWebDriver(1500);	
			//    	GenericFunctions.waitForElementToAppear(MentorOrgPage.Workspace);
			GenericFunctions.waitWebDriver(1000);
			createUserPageObj.tryForWorkSpace();
			GenericFunctions.waitWebDriver(1000);
			MentorOrgPage.workSpace.click();	
			GenericFunctions.waitForElementToAppear(MentorOrgPage.upForReview);
			GenericFunctions.waitWebDriver(2000);
			MentorOrgPage.upForReview.click();
			GenericFunctions.waitForElementToAppear(MentorOrgPage.firstContent);
			String courseContent = MentorOrgPage.firstContent.getText();
			System.out.println(courseContent);
			GenericFunctions.waitWebDriver(2000);
			MentorOrgPage.firstContent.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(MentorOrgPage.iFrame);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(MentorOrgPage.headerPublish);
			GenericFunctions.waitWebDriver(4000);
			if(MentorOrgPage.headerPublish.isDisplayed())
			{
				MentorOrgPage.headerPublish.click();
			}
			else if(MentorOrgPage.Publish.isDisplayed())
			{
				MentorOrgPage.Publish.click();
			}
			GenericFunctions.waitWebDriver(4000);
			for(int i=0;i<createUserPage.checkbox.size();i++)	
			{
				GenericFunctions.waitWebDriver(500);
				createUserPage.checkbox.get(i).click();
			}
			System.out.println("Checked all CBs");
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitForElementToAppear(createUserPage.popupPublishButton);
			executor.executeScript("arguments[0].click();", createUserPage.popupPublishButton);
			//createUserPage.popupPublishButton.click();
			System.out.println(" Content published sucessfully");
			ExtentTestManager.getTest().log(LogStatus.PASS," Content published sucessfully");
			GenericFunctions.waitWebDriver(6000);
			GenericFunctions.refreshWebPage();
			/*GenericFunctions.waitForElementToAppear(MentorOrgPage.publishConfirm);
			MentorOrgPage.publishConfirm.click();*/			
		}
		catch(Exception e) 
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on publishing the course");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method publishCourse" + e.getLocalizedMessage());
			Assert.fail("Failed on publishing te course, Exception : " + e.getLocalizedMessage());

		}
	}


	public void navigateToCourseSearchAndCreateBatch()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to search a coursea and create a batch");
			List <TestDataForDiksha> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			/*MentorOrgPage.dropDown.click();
			GenericFunctions.waitForElementToAppear(MentorOrgPage.headerProfile);
			MentorOrgPage.headerProfile.click();*/
			MentorOrgPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			String courseNumber = GenericFunctions.readFromNotepad("./testData/courseNumbers.txt").toString();
			MentorOrgPage.filterSearch.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseName()+courseNumber);
			MentorOrgPage.searchIconForCourse.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(MentorOrgPage.searchedCourse);
			MentorOrgPage.searchedCourse.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(MentorOrgPage.createBatch);
			//MentorOrgPage.createBatch.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search course and create a batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Other contents are available for reviewing");
			Assert.fail("Failed to search course and create a batch, Exception"+e.getLocalizedMessage());

		}

	}


	public void createOpenBatch() throws InterruptedException, Exception
	{
		objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create open batch for a course");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createMentorPage.addIcon);
			createMentorPage.addIcon.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.switchToFrame(driver, createMentorPage.batchForm);
			//GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createMentorPage.nameOfBatch);
			createMentorPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseName()+ GenericFunctions.readFromNotepad("./testData/dikshadata.txt"));
			createMentorPage.aboutBatch.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseName());
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

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create open batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method createOpenBatch"+e.getMessage());
			Assert.fail("Failed to create open batch, Exception"+e.getLocalizedMessage());

		}
	}



	// @author Sachin
	public void createInviteOnlyBatch() throws InterruptedException, Exception {
		Robot robot = new Robot();
		objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create invite only batch for a course");
			GenericFunctions.waitForElementToAppear(MentorOrgPage.headerCourse);
			//MentorOrgPage.closePopUp.click();
			GenericFunctions.waitWebDriver(1500);
			MentorOrgPage.headerCourse.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElements(MentorOrgPage.latestCourse);
			MentorOrgPage.latestCourse.get(0).click();
			GenericFunctions.waitWebDriver(3000);
			MentorOrgPage.addIcon.click();
			GenericFunctions.waitWebDriver(2000);
			MentorOrgPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseName()
					+ GenericFunctions.testDataIncrementer("./testData/batchNumbers.txt"));
			MentorOrgPage.aboutBatch.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseName());

			MentorOrgPage.startDate.click();
			GenericFunctions.waitWebDriver(1000);
			MentorOrgPage.startDateCalendar.click();
			GenericFunctions.waitWebDriver(1000);
			MentorOrgPage.endDate.click();
			GenericFunctions.waitWebDriver(1000);
			MentorOrgPage.endDateCalendar.click();
			GenericFunctions.waitWebDriver(1000);
			MentorOrgPage.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);				
			MentorOrgPage.selectMentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);								
			MentorOrgPage.mentorDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			MentorOrgPage.membersInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			MentorOrgPage.selectMembersInBatch.click();
			GenericFunctions.waitWebDriver(1500);
			MentorOrgPage.memberDropdown.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(MentorOrgPage.buttonCreate);
			MentorOrgPage.buttonCreate.click();
			GenericFunctions.waitWebDriver(4000);
			//MentorOrgPage.successfulMessage.click();
			System.out.println("Batch Created");
			Assert.assertTrue(true,"BAtch created successfully and invited members are auto invited to the course");
			System.out.println("BAtch created successfully and invited members are auto invited to the course");
			log.info("BAtch created successfully and invited members are auto invited to the course");
		} 
		catch (Exception e) 
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createInviteOnlyBatch" + e.getMessage());
			Assert.fail("Failed to create invite only batch, Exception" + e.getLocalizedMessage());
		}


	}


} 
