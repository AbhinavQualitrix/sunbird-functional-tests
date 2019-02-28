package org.pageobjects;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.CreateMentorPage;
import org.page.CreatorAnnouncementPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.SignUpPage;
import org.page.UploadOrgPage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

/**
* Created by Qualitrix Technologies Pvt Ltd.
* Purpose: Class file to segregate complete functional methods related to mentor role and course creation feature
*/

public class CreateMentorPageObj extends BaseTest{

	WebDriverWait wait = new WebDriverWait(driver,20);
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	CreatorAnnouncementPage createAnnouncementPage=PageFactory.initElements(driver, CreatorAnnouncementPage.class);
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	SignUpPage signUpPage=PageFactory.initElements(driver, SignUpPage.class);
	static Logger log = Logger.getLogger(CreatorAnnouncementPage.class.getName());
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	CreatorUserPageObj creatorUserPageObj =new CreatorUserPageObj();
	UploadOrgPage uploadOrgPage = PageFactory.initElements(driver, UploadOrgPage.class);
	Actions action = new Actions(driver);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	Random rand=new Random();
	List <TestDataForDiksha> objListOFTestDataForSunbird= null;
	
	String batchStatus="Previous Batches";
	String courseName;
	String startDate;
	String endDate;

	/**
	* Purpose: navigateToMyActivityInDropDownMenu() method is used for navigating to my activity from drop down menu
	*/
	public void navigateToMyActivityInDropDownMenu() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to My activity");
			GenericFunctions.waitForElementToAppear(createUserPage.profileIconDropdown);
			createUserPage.profileIconDropdown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.myActivity);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.myActivity.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickDashboardCourse);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickDashboardCourse.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectDashboardCourse.click();
			if(uploadOrgPage.last7Days.isDisplayed()&&uploadOrgPage.last7Days.isDisplayed()&&uploadOrgPage.last5Weeks.isDisplayed())
			{
				Assert.assertTrue(true);
				WebDriver webDriver = this.getDriver();
				String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)webDriver).
						getScreenshotAs(OutputType.BASE64);
				ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot);
			}
			else 
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Failed to Validate Course Dashboard");
				System.out.println("Failed to Validate Course Dashboard");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to my activity");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error(e.getMessage()+"Error in navigateToMyActivity");
			Assert.fail("Error in navigating to my activity");
		}
	}
	
	/**
	* Purpose: navigateToCourseAndSearch() method is used for navigating to course menu and search for particular course
	*/
	public void navigateToCourseAndSearch(String courseName) throws InterruptedException
	{
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigate to Course section and search course");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchInput);
			createUserPage.searchInput.sendKeys(courseName);
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createMentorPage.courseImg1);
			createMentorPage.courseImg1.click();
			GenericFunctions.waitWebDriver(3000);
		
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Course section and search course");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToCourseAndSearch"+e.getLocalizedMessage());
			Assert.fail("Failed on navigating to Course section and search course, Exception : "+e.getLocalizedMessage());

		}
	}
	
	/**
	* Purpose: navigateToCourseAndSearchForOpenBatch() method is used for navigating to course menu and search for open batch information using search parameter
	*/
	public void navigateToCourseAndSearchForOpenBatch(String courseName) throws InterruptedException
	{
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigate to Course section, search course and create open batch");
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchInput.sendKeys(courseName);
			
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(4000);
			
			GenericFunctions.waitForElementToAppear(createMentorPage.courseImg1);
			createMentorPage.courseImg1.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Course section, search course and create batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToCourseAndSearchForOpenBatch"+e.getLocalizedMessage());
			Assert.fail("Failed on navigating to Course section, search course and create open batch, Exception : "+e.getLocalizedMessage());
		}
	}


	/**
	* Purpose: navigateToCourseAndSearchForOpenBatch() method is used for navigating to course menu and search for open batch information
	*/
	public void navigateToCourseAndSearchForOpenBatch() throws InterruptedException
	{
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try{

			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigate to Course section, search course ");
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName() + GenericFunctions.readFromNotepad("./testData/dikshadata.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(createMentorPage.courseImg1);
			createMentorPage.courseImg1.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Course section, search course ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToCourseAndSearchForOpenBatch"+e.getLocalizedMessage());
			Assert.fail("Failed on navigating to Course section, search course and create open batch, Exception : "+e.getLocalizedMessage());
		}
	}
	
	
	/**
	* Purpose: navigateToCourseSearchAndUpdate() method is used for navigating to course menu, search for course and update the course
	*/
	
	public void navigateToCourseSearchAndUpdate(String courseName1) throws InterruptedException
	{
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigate to Course section, search course and update the batch");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchInput.sendKeys(courseName1);
			System.out.println(courseName1);
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPage.courseImg1.click();
			GenericFunctions.waitForElementToAppear(createMentorPage.editBatch);
			createMentorPage.editBatch.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.switchToFrame(driver, createMentorPage.batchForm);
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.nameOfBatch.clear();
			createMentorPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(1).getCourseName()+ GenericFunctions.testDataIncrementer("./testData/batchName.txt")+"Edited");
			GenericFunctions.waitWebDriver(2000);
			createMentorPage.updateBatch.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, "The course "+courseName1+" is searched sucessfully and updated it");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Course section, search course and update the course");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToCourseSearchAndUpdate"+e.getMessage());
			Assert.fail("Failed on navigating to Course section, search course and update the course, Exception : "+e.getLocalizedMessage());
		}

	}
	
	/**
	* Purpose: navigateToWorkspaceAndSelectBatches() method is used for navigating to workspace and select batches
	*/
	
	public void navigateToWorkspaceAndSelectBatches(String batchType) throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to Worskpace and select batch "+batchType);
			GenericFunctions.waitForElementToAppear(createUserPage.profileIconDropdown);
			createUserPage.profileIconDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.workspaceInDropDown.click();	
			GenericFunctions.waitWebDriver(1500);
			createMentorPage.courseBatches.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.batchesDropDown.click();
			if(batchStatus.equalsIgnoreCase("Ongoing Batches")) {
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.ongoingBatches.click();
				System.out.println("Ongoing batches");
			}else if(batchStatus.equalsIgnoreCase("Upcoming Batches"))
			{
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.upcomingBatches.click();
				System.out.println("upcoming batches");
			}else if(batchStatus.equalsIgnoreCase("Previous Batches"))
			{
				GenericFunctions.waitWebDriver(1000);
				createMentorPage.previousBatches.click();
				System.out.println("Previous batches");
			}					
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Workspace and select batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToWorkspaceInDropDownMenu"+e.getMessage());
			Assert.fail("Failed on navigating to Workspace and selecting batch, Exception : "+e.getLocalizedMessage());
		}
	}

	

	/**
	 * Purpose: checkForAuthenticUserAndEdit() method is used for authentic users  
	 */
	public void checkForAuthenticUserAndEdit() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search authentic user and edit");
			GenericFunctions generic = new GenericFunctions();
			GenericFunctions.waitWebDriver(4000);
			String personName = createMentorPage.profileNameInUserSearch.getText();
			System.out.println(personName);
			GenericFunctions.waitForElementToAppear(createMentorPage.editIconInUserProfileSearch);
			boolean elementStatus = generic.isElementPresent(createMentorPage.editIconInUserProfileSearch);	
			if(elementStatus == true)
			{
				System.out.println("authenticPerson");
				createMentorPage.editIconInUserProfileSearch.click();
				GenericFunctions.waitWebDriver(3000);		
				createMentorPage.selectRoleCheckbox.click();
				GenericFunctions.waitWebDriver(2000);	
				createMentorPage.updateButtonInUserProfile.click();
				try {
					GenericFunctions.waitForElementToAppear(createMentorPage.successfulMessage);
					String msg = createMentorPage.successfulMessage.getText();
					System.out.println(msg);
				}catch(Exception e)
				{
					ExtentTestManager.getTest().log(LogStatus.INFO,"Could not capture successful message ");
				}
			}	

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching authentic user and edit");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method checkForAuthenticUserAndEdit"+e.getMessage());
			Assert.fail("Failed on searching authentic user and edit"+e.getLocalizedMessage());
		}
	}

	/**
	* Purpose: checkForAuthenticUserAndEdit() method is used for authentic users  
	*/
	public void checkForUnauthenticUserAndEdit(String Anotherstring ) throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search Unauthentic user and edit");
			GenericFunctions generic = new GenericFunctions();
			CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
			String personName = createMentorPage.profileNameInUserSearch.getText();
			System.out.println(personName);	
			if(personName.equalsIgnoreCase(Anotherstring))
			{
				System.out.println("authenticPerson" +"edit button is available");
			}else {
				System.out.println("UnauthenticPerson" +"edit button is unavailable");
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching authentic user and edit");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method checkForUnauthenticUserAndEdit"+e.getMessage());
			Assert.fail("Failed on searching unauthentic user and edit"+e.getLocalizedMessage());
		}
	}

	/**
	* Purpose: enrollForOpenBatch() method is used enrolling to a batch  
	*/
	public void enrollForOpenBatch() throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to enroll for an open batch");
			GenericFunctions.waitWebDriver(6000);
			createMentorPage.enrollForOpenBatch.click();
			GenericFunctions.waitWebDriver(4000);
			createMentorPage.enrollForCourse.click();
			GenericFunctions.waitWebDriver(3000);
			/*if(createMentorPage.resumeCourse.isDisplayed()==true)
			{
				System.out.println("User is already enrolled to the course");
			}
			else
			{
				createMentorPage.enrollForOpenBatch.click();
				GenericFunctions.waitWebDriver(2000);
				createMentorPage.enrollForCourse.click();
			}*/
			//creatorUserPageObj.handlePopupOnLogin();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to enroll for an open batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method enrollForOpenBatch"+e.getMessage());
			Assert.fail("Failed to enroll for an open batch, Exception"+e.getLocalizedMessage());
		}
	}
	

	/**
	* Purpose: createInviteOnlyBatch() method  is used for creating invite for the batches
	*/
	public String createInviteOnlyBatch() throws InterruptedException, Exception
	{
		String savedCourseName = null;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create invite only batch for a course");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName() + GenericFunctions.readFromNotepad("./testData/dikshadata.txt").toUpperCase());
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createMentorPage.getCourseName);
			savedCourseName=createMentorPage.getCourseName.getText();
			System.out.println(savedCourseName);
			GenericFunctions.waitWebDriver(2000);
			createMentorPage.getCourseName.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(createMentorPage.addIcon);
			createMentorPage.addIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.switchToFrame(driver, createMentorPage.batchForm);
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+ GenericFunctions.testDataIncrementer("./testData/batchName.txt"));
			createMentorPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());

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

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method createInviteOnlyBatch"+e.getMessage());
			Assert.fail("Failed to create invite only batch, Exception"+e.getLocalizedMessage());
		}
		return savedCourseName;

	}
	
	/**
	* Purpose: createOpenBatch() method  is used for creating open batches
	*/
	public void createOpenBatch() throws InterruptedException, Exception
	{
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try{
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

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create open batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method createOpenBatch"+e.getMessage());
			Assert.fail("Failed to create open batch, Exception"+e.getLocalizedMessage());

		}
	}
	
	/**
	* Purpose: createInviteOnlyBatchForSuborg() method  is used for creating invite for batches under sub org
	*/
	public void createInviteOnlyBatchForSuborg() throws InterruptedException, Exception
	{

		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create invite only batch for Sub Organization");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./testData/dikshadata.txt").toUpperCase());
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPage.courseImg1.click();
			GenericFunctions.waitWebDriver(3000);
			createMentorPage.addIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.switchToFrame(driver, createMentorPage.batchForm);
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.nameOfBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+ GenericFunctions.testDataIncrementer("./TestData/batchName.txt"));
			createMentorPage.aboutBatch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
			createMentorPage.startDate.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.startDateCalendar.click();
			GenericFunctions.waitWebDriver(500);
			createMentorPage.endDate.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.endDateCalendar.click();
			GenericFunctions.waitWebDriver(500);
			createMentorPage.mentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.selectMentorsInBatch.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.mentorDropdown.click();
			GenericFunctions.waitWebDriver(500);
			createMentorPage.membersInBatch.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions generic = new GenericFunctions();
			boolean elementPresent = generic.isElementPresent(createMentorPage.orgAdminInBatch);
			if(elementPresent==false)
			{
				System.out.println("Batch cann't be Created");
			}
			else
			{
				System.out.println("Batch can be created");
			}
			
			createUserPage.closeIcon.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create invite only batch for Sub Organization");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method createInviteOnlyBatchForSuborg"+e.getMessage());
			Assert.fail("Failed to create invite only batch for Sub Organization, Exception"+e.getLocalizedMessage());

		}
	}

	/**
	* Purpose: viewCourseStats() method is used for checking the course status
	*/
	/*public void viewCourseStats()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to view the course stats");
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitForElementToAppear(createMentorPage.viewCourseStat);
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.viewCourseStat.click();
			GenericFunctions.waitWebDriver(3000);
			
			try
			{
			GenericFunctions.waitForElementToAppear(createMentorPage.courseSearchDropDown);
			createMentorPage.courseSearchDropDown.click();
			//createMentorPage.courseSearchDropDown.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+ GenericFunctions.readFromNotepad("./TestData/openBatchData.txt"));
			GenericFunctions.waitForElementToAppear(createMentorPage.selectSearchedCourse);
			createMentorPage.selectSearchedCourse.click();
			}
			catch(Exception e3)
			{
				System.out.println(e3);
			}
			GenericFunctions.waitForElementToAppear(createMentorPage.fromBeginning);
			createMentorPage.fromBeginning.click();
			GenericFunctions.waitWebDriver(2000);
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to view the course stats");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method viewCourseStats"+e.getMessage());
			Assert.fail("Failed to view the course stat, Exception"+e.getLocalizedMessage());

		}
	}*/
	
	/**
	* Purpose: createCourseForOpenBatch() method is used for creating coursed for open batches
	*/
	public void createCourseForOpenBatch(List <TestDataForDiksha> objListOFTestDataForSunbird) throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create course");
			GenericFunctions.waitWebDriver(1500);
			System.out.println(driver.findElement(By.xpath(" //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer("./TestData/openBatchData.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
			createUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			GenericFunctions.waitWebDriver(1500);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(4500);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(6500);
			GenericFunctions.waitForElementToAppear(createUserPage.newChild);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.titleName.click();
			createUserPage.titleName.clear();
			createUserPage.titleName.sendKeys(objListOFTestDataForSunbird.get(0).getTitle()+courseNumber);
			createUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.selectResource);
			createUserPage.selectResource.click();
			GenericFunctions.waitWebDriver(500);
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(500);


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
	* Purpose: enrollForOpenBatchN() method is used for users to enroll for open batches
	*/
	public void enrollForOpenBatchN() throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to enroll for an open batch");
			GenericFunctions.waitWebDriver(2000);
			createMentorPage.enrollForOpenBatch.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPage.enrollForCourse.click();
			GenericFunctions.waitWebDriver(3000);
			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to enroll for an open batch");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method enrollForOpenBatch"+e.getMessage());
			Assert.fail("Failed to enroll for an open batch, Exception"+e.getLocalizedMessage());
		}
	}
	public void navigateToCourseAndSearchForCourse() throws InterruptedException
	{
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Course And Search For Course");
			GenericFunctions.waitWebDriver(3500);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPage.filterSearch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./testData/dikshadata.txt"));
			GenericFunctions.waitWebDriver(2000);
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(createMentorPage.courseImg1);
			createMentorPage.courseImg1.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Course And Search For Course");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToCourseAndSearchForCourse"+e.getMessage());
			Assert.fail("Failed to navigate To Course And Search For Course, Exception"+e.getLocalizedMessage());
		}
	}
	public void navigateToLibraryAndSearchForCollection() throws InterruptedException
	{
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Library And Search For Collection");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.filterSearch.sendKeys(objListOFTestDataForSunbird.get(5).getCourseName()+GenericFunctions.readFromNotepad("./testData/collectionNumbers.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createMentorPage.courseImg1);
			createMentorPage.courseImg1.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Library And Search For Collection");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToLibraryAndSearchForCollection"+e.getMessage());
			Assert.fail("Failed to navigate To Library And Search For Collection, Exception"+e.getLocalizedMessage());
		}
	}
	
	public void navigateToLibraryAndSearchForBook() throws InterruptedException
	{
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Library And Search For Book");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.filterSearch.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+GenericFunctions.readFromNotepad("./testData/bookNumbers.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createMentorPage.courseImg1);
			createMentorPage.courseImg1.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Library And Search For Book");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToLibraryAndSearchForBook"+e.getMessage());
			Assert.fail("Failed to navigate To Library And Search For Book, Exception"+e.getLocalizedMessage());
		}
	}
	public void navigateToLibraryAndSearchForLessonPlan() throws InterruptedException
	{
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Library And Search For LessonPlan");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(3000);
			createMentorPage.filterSearch.sendKeys(objListOFTestDataForSunbird.get(3).getCourseName()+GenericFunctions.readFromNotepad("./testData/lessonPlan.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createMentorPage.courseImg1);
			createMentorPage.courseImg1.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Library And Search For LessonPlan");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToLibraryAndSearchForLessonPlan"+e.getMessage());
			Assert.fail("Failed to navigate To Library And Search For LessonPlan, Exception"+e.getLocalizedMessage());
		}
	}
	
	public void viewCourseStats()
	{
		try
		{
		ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to view the course stats");
		GenericFunctions.waitWebDriver(3000);
		GenericFunctions.refreshWebPage();
		GenericFunctions.waitWebDriver(3000);
		createMentorPage.viewCourseStat.click();
		GenericFunctions.waitWebDriver(3000);
		createMentorPage.fromBeginning.click();
		GenericFunctions.waitWebDriver(3000);	
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to view the course stats");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method viewCourseStats"+e.getMessage());
			Assert.fail("Failed to view the course stat, Exception"+e.getLocalizedMessage());

		}
	}

	public void navigateToLibraryAndSearchForEdittedBook() throws InterruptedException
	{
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Library And Search For Book");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.filterSearch.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName());//+GenericFunctions.readFromNotepad("./testData/bookNumbers.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForUpload);
			createUserPage.searchedContentForUpload.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Library And Search For Book");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToLibraryAndSearchForBook"+e.getMessage());
			Assert.fail("Failed to navigate To Library And Search For Book, Exception"+e.getLocalizedMessage());
		}
	}
	public void navigateToCourseAndSearch() throws InterruptedException
	{
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigate to Course section and search course");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.headerCourse.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.filterSearch.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./testData/dikshadata.txt").toUpperCase());
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createMentorPage.courseImg1);
			createMentorPage.courseImg1.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Course section and search course");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToCourseAndSearch"+e.getLocalizedMessage());
			Assert.fail("Failed on navigating to Course section and search course, Exception : "+e.getLocalizedMessage());
		}
	}


}



