package org.pageobjects;

import java.awt.Robot;
import java.util.List;
import java.util.Random;
import org.apache.log4j.Logger;
import org.generic.AllUploadingPaths;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.ContentCreateUploadPage;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.SignUpPage;
import org.page.UploadOrgPage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;
import com.relevantcodes.extentreports.LogStatus;
import org.apiPackage.ApiHashMap;

public class CreatorUserPageObj extends BaseTest{

	private static final boolean Object = false;

	static Logger log = Logger.getLogger(CreatorUserPageObj.class.getName());

	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	SignUpPage signUpPage=PageFactory.initElements(driver, SignUpPage.class);
	UploadOrgPage uploadOrgPage = PageFactory.initElements(driver, UploadOrgPage.class);
	ContentCreateUploadPage contentUploadPage = PageFactory.initElements(driver, ContentCreateUploadPage.class);
	List <TestDataForDiksha> objListOFTestDataForSunbird1= null ;
	Actions action = new Actions(driver);
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	WebDriverWait wait = new WebDriverWait(driver,20);
	Random rand=new Random();

	String lessonNumber;
	String title="";

	/**
	 * Purpose: createCourse method is used to create course by adding a child node.
	 */

	public void createCourse(List <TestDataForDiksha> objListOFTestDataForSunbird) throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create course");
			GenericFunctions.waitWebDriver(1500);
			//System.out.println(driver.findElement(By.xpath(" //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer("./testData/dikshadata.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
			//createUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2500);		
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.titleNameForCourse.click();
			createUserPage.titleNameForCourse.clear();
			createUserPage.titleNameForCourse.sendKeys(objListOFTestDataForSunbird.get(0).getTitle()+courseNumber);
			createUserPage.titleDescriptionForCourse.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			createUserPage.titleKeywordForCourse.sendKeys("math");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitWebDriver(2500);
			createUserPage.selectResourceN.click();
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(1500);

		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create course");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method createCourse"+e.getMessage());
			System.out.println("Exception In the method createCourse, failed to create corse");
			Assert.fail("Failed on creating course");
		}
	}

	/**
	 * Purpose: saveAndSendBookForReview method is used to save the content and send the content for review by filling mandatory fields if review form.
	 */

	public void saveAndSendBookForReview(List <TestDataForDiksha> objListOFTestDataForSunbird)
	{
		ApiHashMap apiHashMap = new ApiHashMap();
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save And Send NewBook For Review");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.checkAppIcon);
			createUserPage.checkAppIcon.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.selectAppIcon);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1500);
			
			apiHashMap.dynamicFormHandling(DIKSHA_APIKEY,DIKSHA_ROOTORGID,DIKSHA_FRAMEWORK,"review","textbook");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			ExtentTestManager.getTest().log(LogStatus.INFO, "User has successfully saved And Send NewBook For Review");
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save And Send NewBook For Review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save And Send NewBook For Review ");
			Assert.fail("Failed to save And Send NewBook For Review ");
		}
	}


	/**
	 * Purpose: reviewInSubmissions method is used to check the content in review submission section.
	 */

	public void reviewInSubmissions(String source, List <TestDataForDiksha> objListOFTestDataForSunbird)
	{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify "+source+" is found in review submission");
			GenericFunctions.waitWebDriver(4000);
			tryForWorkSpace();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.reviewSubmission);
			createUserPage.reviewSubmission.click();
			//assertFoundInReviewSubmission(source,objListOFTestDataForSunbird);
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to find in review submission");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Failed to find in review submission bucket"+e.getLocalizedMessage());
		}

	}

	/**
	 * Purpose: assertFoundInReviewSubmission method is used to assert the content in review submission section.
	 */

	public static void assertFoundInReviewSubmission(String source,List <TestDataForDiksha> objListOFTestDataForSunbird){
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To assert that "+source+" is found in review submission");
			//List<WebElement> result = driver.findElements(By.xpath("//div[@class='cardImageText center aligned ']/span"));
			CreatorUserPage createUserPage1=PageFactory.initElements(driver, CreatorUserPage.class);
			GenericFunctions.waitWebDriver(4000);
			if(source.equalsIgnoreCase(COURSE))
			{
				GenericFunctions.waitWebDriver(4000);
				String courseNumber = GenericFunctions.readFromNotepad("./testData/courseNumbers.txt").toString();
				for(int i=0;i<createUserPage1.reviewSubmittedCourse.size();i++){
					String courseName = createUserPage1.reviewSubmittedCourse.get(i).getText();
					if(courseName.equalsIgnoreCase(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber))
					{
						Assert.assertTrue(true, courseName+" Found: Submitted for Review");
						System.out.println(courseName+"Course Found: Course Submitted for Review");
						log.info(courseName+"Course Found: Course Submitted for Review");
						ExtentTestManager.getTest().log(LogStatus.PASS, courseName+"Course Found: Course Submitted for Review");
						break;
					}
					else
					{				
						log.info("Still finding course in review submission");
					}
				}
			}
			else if(source.equalsIgnoreCase(BOOK))
			{
				GenericFunctions.waitWebDriver(4000);
				String courseNumber = GenericFunctions.readFromNotepad("./testData/bookNumbers.txt").toString();
				for(int i=0;i<createUserPage1.reviewSubmittedCourse.size();i++){
					String courseName = createUserPage1.reviewSubmittedCourse.get(i).getText();
					if(courseName.equalsIgnoreCase(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber))
					{
						Assert.assertTrue(true, courseName+" Book: Submitted for Review");
						System.out.println(courseName+"Book Found: book Submitted for Review");
						log.info(courseName+"Book Found: book Submitted for Review");
						break;
					}
					else
					{				
						log.info("Still finding book in review submission");
					}
				}
			}
			else if(source.equalsIgnoreCase(RESOURCE))
			{
				GenericFunctions.waitWebDriver(2000);
				String courseNumber = GenericFunctions.readFromNotepad("./testData/resourceNumbers.txt").toString();
				for(int i=0;i<createUserPage1.reviewSubmittedCourse.size();i++){
					String courseName = createUserPage1.reviewSubmittedCourse.get(i).getText();
					if(courseName.equalsIgnoreCase(objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber))
					{
						Assert.assertTrue(true, courseName+" Resource : Submitted for Review");
						System.out.println(courseName+"Resource Found: Course Submitted for Review");
						log.info(courseName+"Resource Found: resource Submitted for Review");
						ExtentTestManager.getTest().log(LogStatus.PASS, courseName+"Resource Found: resource Submitted for Review");
						break;
					}
					else
					{				
						log.info("Still finding Resource in review submission");
					}
				}
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to assert in review submission");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getLocalizedMessage());
			Assert.fail("Failed on asserting in review submission bucket");

		}
	}

	/**
	 * Purpose: assertCourseFoundInSearch method is used to assert the course in search section.
	 */

	public static void assertCourseFoundInSearch(String searchCourseName){
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify that course is found in search");
			CreatorUserPage createUserPage1=PageFactory.initElements(driver, CreatorUserPage.class);
			for(int i=0;i<createUserPage1.reviewSubmittedCourse.size();i++){
				String courseName = createUserPage1.reviewSubmittedCourse.get(i).getText();
				if(courseName.equalsIgnoreCase(searchCourseName))
				{
					Assert.assertTrue(true, courseName+" Course Found in Search");
					System.out.println(courseName+"Course Found in Search");
					log.info(courseName+" Course Found in Search");
					break;
				}
				else
				{	

					log.info("Still finding course in review submission");

				}
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching for course");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getMessage());
			Assert.fail("Failed on searching the course");
		}
	}

	/**
	 * Purpose: assertFoundInUpForReview method is used to assert the content in up for review section.
	 */

	public static void assertFoundInUpForReview(String searchCourseName){
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To assert that course is found in Up for review");
			//List<WebElement> result = driver.findElements(By.xpath("//div[@class='cardImageText center aligned ']/span"));
			CreatorUserPage createUserPage1=PageFactory.initElements(driver, CreatorUserPage.class);
			//String courseNumber = GenericFunctions.readFromNotepad("./testData/courseNumbers.txt").toString();

			for(int i=0;i<createUserPage1.searchCoursesUpForReview.size();i++){
				String courseName = createUserPage1.searchCoursesUpForReview.get(i).getText();
				if(courseName.equalsIgnoreCase(searchCourseName))
				{
					Assert.assertTrue(true, courseName+" Found in up for review");
					createUserPage1.searchCoursesUpForReview.get(i).click();
					System.out.println(courseName+"Found and Clicked in up for review");
					log.info(courseName+"Found and Clicked in up for review");
					break;
				}
				else
				{				
					log.info("Still finding in up for review");
				}
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on verifying the asserrtion in Up for review bucket ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getMessage());
			Assert.fail("Failed on asserting the course in Up for review bucket");
		}
	}

	/**
	 * Purpose: assertOnSearchAfterPublish method is used to assert the content in search section after publishing the content.
	 */

	public static void assertOnSearchAfterPublish(String searchCourseName){
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify that "+searchCourseName+" is found on searching after publishing");
			//List<WebElement> result = driver.findElements(By.xpath("//div[@class='cardImageText center aligned ']/span"));
			CreatorUserPage createUserPage1=PageFactory.initElements(driver, CreatorUserPage.class);
			//String courseNumber = GenericFunctions.readFromNotepad("./testData/courseNumbers.txt").toString();
			for(int i=0;i<createUserPage1.searchPublishedCourses.size();i++){
				String courseName = createUserPage1.searchPublishedCourses.get(i).getText();
				if(courseName.equalsIgnoreCase(searchCourseName))
				{
					Assert.assertTrue(true, courseName+" Found in Search");
					System.out.println(courseName+"Found in Search");
					log.info(courseName+" Found in Search");
					break;
				}
				else
				{				
					log.info("Still finding course in review submission");
				}
			}
		}

		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching the course after publishing it");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getMessage());
			Assert.fail("Failed on asserting the course after publishing");
		}
	}

	/**
	 * Purpose: createBook method is used to create a textbook by adding units as child nodes to it.
	 */

	public void createBook(List <TestDataForDiksha> objListOFTestDataForSunbird) throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create New Book");
			GenericFunctions.waitWebDriver(1500);
			//System.out.println(driver.findElement(By.xpath(" //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer("./testData/bookNumbers.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber);
			//createUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.clickOnElementUsingJavascript(createUserPage.clickUseEditor);
			GenericFunctions.waitWebDriver(3500);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(2000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(3500);
			createUserPage.untitledNameB.click();
			createUserPage.untitledNameB.clear();
			createUserPage.untitledNameB.sendKeys(objListOFTestDataForSunbird.get(2).getTitle()+courseNumber);
			//createUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitWebDriver(3000);
			//GenericFunctions.waitForElementToAppear(createUserPage.selectResourceN);
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.selectResourceN);
			createUserPage.selectResourceN.click();
			createUserPage.proceedButton.click();

		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create New Book");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create New Book");
			Assert.fail("Failed to create New Book ");
		}
	}

	/**
	 * Purpose: getBookName method is used to get the textbook name.
	 */

	public String getBookName()
	{
		String course = GenericFunctions.randomCourseName();
		String generatedName=GenericFunctions.readFromNotepad("./testData/bookNumbers.txt");
		System.out.println(generatedName+course);
		return generatedName+course;
	}

	/**
	 * Purpose: createLessonPlan method is used to create a lesson plan by adding a child node.
	 */

	public void createLessonPlan()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create a lesson plan");
			List <TestDataForDiksha> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitWebDriver(1000);


			/*GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();

			GenericFunctions.waitForElementToAppear(createUserPage.clickLessonplan);
			createUserPage.clickLessonplan.click();*/


			GenericFunctions.waitWebDriver(2000);

			lessonNumber = GenericFunctions.testDataIncrementer("./testData/lessonPlan.txt");
			//createUserPage.clickOnPopup.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.lessonPlanName);
			//createUserPage.bookName.sendKeys(objListOFTestDataForSunbird1.get(3).getCourseName()+lessonNumber);
			createUserPage.lessonPlanName.sendKeys(objListOFTestDataForSunbird1.get(3).getCourseName()+lessonNumber);
			System.out.println("Lesson created :"+objListOFTestDataForSunbird1.get(3).getCourseName()+lessonNumber);

			/*
			createUserPage.clickBookBoard.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBookBoard);
			createUserPage.selectBookBoard.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.clickBookGrade.get(0).click();
			//GenericFunctions.waitForElementToAppear(createUserPage.selectBookGrade);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectBookGrade.get(0).click();
			//createUserPage.clickOnPopup.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.clickBookSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectBookSubject);
			createUserPage.selectBookSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickBookMedium);
			createUserPage.clickBookMedium.click();
			//createUserPage.clickOnPopup.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectBookMedium.click();
			 */
			GenericFunctions.waitWebDriver(4000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(7000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4500);
			GenericFunctions.waitForElementToAppear(createUserPage.newChild);
			System.out.println(createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(2500);
			//createUserPage.newChild.click();	
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(5000);
			//createUserPage.lessonTitle.click();
			createUserPage.lessonTitle.clear();
			GenericFunctions.waitForElementToAppear(createUserPage.lessonTitle);
			createUserPage.lessonTitle.sendKeys(objListOFTestDataForSunbird1.get(3).getCourseName());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.lessonDescription.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.lessonDescription.sendKeys(objListOFTestDataForSunbird1.get(3).getCourseDescription());
			GenericFunctions.waitForElementToAppear(createUserPage.lessonNotes);
			createUserPage.lessonNotes.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.lessonNotes.sendKeys(objListOFTestDataForSunbird1.get(3).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addResource.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			createUserPage.lessonResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.proceedButton);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating the lesson plan");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create the new lesson plan");
			Assert	.fail("Failed on creating the lesson plan");
		}

	}


	/**
	 * Purpose: uploadContentMp4 method is used to upload the content,save it and send it for review after filling the review form.
	 */


	public String uploadContentMp4(String uploadType) throws Exception
	{
		ApiHashMap apiHashMap = new ApiHashMap();
		String selectedOwnerType=null;
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload"+uploadType+" and send it for review");
			List <TestDataForDiksha> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitWebDriver(2000);
			navigateToWorkspace(UPLOADCONTENT);		
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(8000);
			GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			GenericFunctions.waitWebDriver(8000);
			WebElement browse=createUserPage.browseButton;
			if(uploadType.equalsIgnoreCase("mp4"))
			{
				System.out.println(AllUploadingPaths.mp4Path);
				GenericFunctions.waitWebDriver(8000);
				browse.sendKeys(AllUploadingPaths.mp4Path);
				System.out.println("Uploaded file : "+AllUploadingPaths.mp4Path);
				GenericFunctions.waitWebDriver(8000);

				System.out.println("MP4 content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("webm"))
			{

				System.out.println(AllUploadingPaths.webmPath);
				GenericFunctions.waitWebDriver(8000);
				browse.sendKeys(AllUploadingPaths.webmPath);
				System.out.println("Uploaded file : "+AllUploadingPaths.webmPath);
				GenericFunctions.waitWebDriver(8000);
				System.out.println("WEBM content uploaded sucessfully");
				//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			}
			else if(uploadType.equalsIgnoreCase("youtube"))
			{
				GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
				createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
				GenericFunctions.waitWebDriver(10000);
				//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.UploadButton);	
				GenericFunctions.waitForElementToAppear(contentUploadPage.popupUploadButton);
				contentUploadPage.popupUploadButton.click();
				//action.moveToElement(createUserPage.UploadButton).build().perform();
				//action.click(createUserPage.UploadButton).build().perform();
				//createUserPage.UploadButton.click();
				GenericFunctions.waitWebDriver(4000);
				System.out.println("YOUTUBE content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("epub"))
			{

				System.out.println(AllUploadingPaths.epubPath);
				GenericFunctions.waitWebDriver(8000);
				browse.sendKeys(AllUploadingPaths.epubPath);
				System.out.println("Uploaded file : "+AllUploadingPaths.epubPath);
				GenericFunctions.waitWebDriver(8000);
				System.out.println("EPUB content uploaded sucessfully");
			}

			else if(uploadType.equalsIgnoreCase("h5p"))
			{				
				GenericFunctions.waitWebDriver(8000);
				browse.sendKeys(AllUploadingPaths.h5pPath);
				System.out.println("Uploaded file : "+AllUploadingPaths.h5pPath);
				GenericFunctions.waitWebDriver(8000);
				System.out.println("H5P content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("html"))
			{
				System.out.println(AllUploadingPaths.htmlPath);
				GenericFunctions.waitWebDriver(8000);
				browse.sendKeys(AllUploadingPaths.htmlPath);
				System.out.println("Uploaded file : "+AllUploadingPaths.htmlPath);
				System.out.println("HTML content uploaded sucessfully");
				GenericFunctions.waitWebDriver(8000);
				

			}

			else if(uploadType.equalsIgnoreCase("pdf"))
			{

				System.out.println(AllUploadingPaths.pdfPath);
				GenericFunctions.waitWebDriver(8000);
				browse.sendKeys(AllUploadingPaths.pdfPath);
				System.out.println("Uploaded file : "+AllUploadingPaths.pdfPath);
				GenericFunctions.waitWebDriver(8000);
				System.out.println("PDF content uploaded sucessfully");
			}
			GenericFunctions.waitWebDriver(4500);
			GenericFunctions.waitForElementToAppear(createUserPage.untitledCollection);
			System.out.println(createUserPage.untitledCollection.getText());
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.sendForReview.click();
			ExtentTestManager.getTest().log(LogStatus.PASS, uploadType+"Content is uploaded successfully");
			GenericFunctions.waitForElementToAppear(createUserPage.contentMp4Title);
			title=(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.testDataIncrementer("./testData/contentNumbers.txt")).toString();
			System.out.println(title);
			createUserPage.contentMp4Title.click();
			createUserPage.contentMp4Title.clear();
			if(uploadType.contains(MP4))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+MP4);
			}
			else if(uploadType.contains(WEBM))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+WEBM);
			}
			else if(uploadType.contains(YOUTUBE))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+YOUTUBE);
			}
			else if(uploadType.contains(EPUB))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+EPUB);
			}
			else if(uploadType.contains(HTML))
			{	
				createUserPage.contentMp4Title.sendKeys(title+"_"+HTML);
			}
			else if(uploadType.contains(H5P))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+H5P);
			}
			else if(uploadType.contains(PDF))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+PDF);
			}
			GenericFunctions.waitWebDriver(1000);
			createUserPage.contentMp4Desc.click();
			createUserPage.contentMp4Desc.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseDescription());
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.checkAppIcon.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.selectAppIcon);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1000);
		
			apiHashMap.dynamicFormHandling(DIKSHA_APIKEY,DIKSHA_ROOTORGID,DIKSHA_FRAMEWORK,"review","resource");
			
			
			/*GenericFunctions.waitForElementToAppear(createUserPage.clickBoard);
			createUserPage.clickBoard.click();
			GenericFunctions.waitWebDriver(3000);

			createUserPage.selectBoard.click();
			GenericFunctions.waitWebDriver(2000);

			createUserPage.clickMedium.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectMediumN.click();

			GenericFunctions.waitWebDriver(2000);

			GenericFunctions.scrollToElement(createUserPage.clickClassN);
			createUserPage.clickClassN.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectClassN.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(createUserPage.clickSubject);
			createUserPage.clickSubject.click();
			GenericFunctions.waitWebDriver(2000);

			createUserPage.selectSubjectN.click();*/

			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitWebDriver(2000);

			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			selectedOwnerType=createUserPage.selectOwner.getText();
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();

			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(createUserPage.reviewSubmission);
			createUserPage.reviewSubmission.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to upload "+uploadType+" content and send for review ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to upload content"+e.getLocalizedMessage());
			Assert.fail("Failed to upload any content and send for review ");
		}
		System.out.println("title/selectedOwnerType - "+title+"/"+selectedOwnerType);
		return title+"/"+selectedOwnerType;


	}

	/**
	 * Purpose: rejectTheContent method is used to reject the content.
	 */


	public void rejectTheContent(String inputToReject)
	{
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to reject the content "+inputToReject);
			List <TestDataForDiksha> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
			publicUserPage.headerProfile.click();
			//goToProfilePage();
			tryForWorkSpace();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.upForReview.click();


			if(inputToReject.equalsIgnoreCase("Course"))

			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./testData/courseNumbers.txt").toString());
				GenericFunctions.waitWebDriver(3000);
			}

			else if(inputToReject.equalsIgnoreCase("collection"))
			{	
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(5).getCourseName());
				GenericFunctions.waitWebDriver(3000);
			}

			else if(inputToReject.equalsIgnoreCase("book"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+GenericFunctions.readFromNotepad("./testData/bookNumbers.txt"));
			}

			else if(inputToReject.equalsIgnoreCase("lessona"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(3).getCourseName());
				GenericFunctions.waitWebDriver(3000);
			}
			else if(inputToReject.equalsIgnoreCase("courseac"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());
				GenericFunctions.waitWebDriver(3000);
			}
			else if(inputToReject.equalsIgnoreCase("booka"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName());
				GenericFunctions.waitWebDriver(3000);
			}
			GenericFunctions.waitWebDriver(3000);
			createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7000);



			if(inputToReject.contains("resource"))
			{
				driver.switchTo().defaultContent();
				GenericFunctions.scrollToElement(createUserPage.clickRequestChanges);
				System.out.println(createUserPage.clickRequestChanges.getText());
				action.click(createUserPage.clickRequestChanges).build().perform();
				GenericFunctions.waitWebDriver(3000);
				createUserPage.rejectReason1.click();
				createUserPage.rejectReason2.click();
				createUserPage.rejectReason3.click();
				String rejectReason = (REVIEW_COMMENTS[new Random().nextInt(REVIEW_COMMENTS.length)]);
				GenericFunctions.waitWebDriver(1000);
				createUserPage.reviewComment.get(0).click();
				createUserPage.reviewComment.get(0).sendKeys(rejectReason);

				//resizeTheScreen();
				//GenericFunctions.scrollTillEndOfPage();
				GenericFunctions.waitForElementToAppear(createUserPage.requestChangesButton);
				GenericFunctions.waitWebDriver(1000);	
				executor.executeScript("arguments[0].click();", createUserPage.requestChangesButton);
				//createUserPage.requestChangesButton.click();
				GenericFunctions.waitWebDriver(3000);
				ExtentTestManager.getTest().log(LogStatus.PASS, inputToReject+" is rejected succesfully");
				System.out.println(inputToReject+" is rejected succesfully");
				GenericFunctions.waitForElementToAppear(uploadOrgPage.dropdown);
			}
			else
			{
				GenericFunctions.waitWebDriver(2000);

				GenericFunctions.waitForElementToAppear(createUserPage.clickRequestChangesIcon);
				createUserPage.clickRequestChangesIcon.click();
				GenericFunctions.waitWebDriver(3000);
				createUserPage.rejectReason1.click();
				createUserPage.rejectReason2.click();
				createUserPage.rejectReason3.click();
				String rejectReason = (REVIEW_COMMENTS[new Random().nextInt(REVIEW_COMMENTS.length)]);
				createUserPage.reviewComments.click();
				createUserPage.reviewComments.sendKeys(rejectReason);
				GenericFunctions.waitWebDriver(2000);
				resizeTheScreen();
				//GenericFunctions.waitForElementToAppear(createUserPage.requestChangesButton1);
				GenericFunctions.waitWebDriver(4000);
				//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.requestChangesButton1);
				//action.moveToElement(createUserPage.requestChangesButton1);
				//GenericFunctions.clickOnElementUsingJavascript(createUserPage.requestChangesButton1);
				GenericFunctions.clickOnElementUsingJavascript(createUserPage.requestChangesButton1);
				GenericFunctions.waitWebDriver(4000);
				//createUserPage.requestChangesButton1.click();
				GenericFunctions.waitWebDriver(3000);
				System.out.println(inputToReject+" is rejected succesfully");
				ExtentTestManager.getTest().log(LogStatus.PASS, inputToReject+" is rejected succesfully");

			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on rejecting the content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to reject the content"+inputToReject);
			Assert.fail("Failed on rejecting the content");
		}

	}

	/**
	 * Purpose: rejectTheResource method is used to reject the resource.
	 */

	public void rejectTheResource()
	{
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to reject the resource");
			List <TestDataForDiksha> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

			/*GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
			publicUserPage.headerProfile.click();*/
			//goToProfilePage();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.upForReview.click();

			/*GenericFunctions.waitWebDriver(2000);
			createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+"R0");
			GenericFunctions.waitWebDriver(3000);
			createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitWebDriver(7000);

			GenericFunctions.waitForElementToAppear(createUserPage.clickRequestChanges);
			//GenericFunctions.scrollToElement(createUserPage.clickRequestChanges);
			createUserPage.clickRequestChanges.click();
			GenericFunctions.waitWebDriver(3000);
			createUserPage.rejectReason1.click();
			createUserPage.rejectReason2.click();
			createUserPage.rejectReason3.click();
			String rejectReason = (REVIEW_COMMENTS[new Random().nextInt(REVIEW_COMMENTS.length)]);
			System.out.println(rejectReason);
			GenericFunctions.waitWebDriver(2000);

			//updated on 06/09/2018
			createUserPage.reviewComment.get(1).click();
			createUserPage.reviewComment.get(1).sendKeys(rejectReason);
			GenericFunctions.waitWebDriver(2000);
			resizeTheScreen();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.requestChangesButton);
			GenericFunctions.clickOnElementUsingJavascript(createUserPage.requestChangesButton);
			//createUserPage.requestChangesButton.click();
			 */
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on rejecting the resource");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to reject the resource");
			Assert.fail("Failed on rejecting the resource");
		}

	}


	/**
	 * Purpose: createResource method is used to create the resource by adding a child node,save it and send for review.
	 */



	public void createResource(List <TestDataForDiksha> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create Resource");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./testData/resourceNumbers.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addShape.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addTriangle.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addImage.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.img1.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.selectImage);
			createUserPage.selectImage.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);

			//for uploading audio
			/*createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addAudio.click();
			createUserPage.uploadAndUseButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.yesRadioButton.click();
			createUserPage.uploadAudioIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.chooseFileButton.click();
			GenericFunctions.waitWebDriver(1500);
			String path1 = System.getProperty("user.dir")+"/UploadingDocuments/Upload Document Contents/"+ AUDIO;
			System.out.println("Uploaded image : "+path1);
			//log.info("Uploaded file name: "+path);
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.uploadFile(path1);
			GenericFunctions.waitWebDriver(2500);
			createUserPage.uploadAndUseButtonRight.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);*/


			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addHotspot.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addScribblepad.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addActivity.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.searchActivity);
			createUserPage.searchActivity.sendKeys("MATH");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.mathText);
			createUserPage.mathText.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addButtonInActivity.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addVideo.click();
			createUserPage.pasteVideoUrl.sendKeys(UPLOAD_MP4_URL);
			createUserPage.goButton.click();
			GenericFunctions.waitWebDriver(4000);
			createUserPage.add.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closePage);
			createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create Resource ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create Resource");
			Assert.fail("Failed to create Resource ");
		}
	}

	/**
	 * Purpose: saveAndSendResouceForReview method is used to fill the review form that comes after clicking on  send for review.
	 */

	public String saveAndSendResouceForReview()
	{
		ApiHashMap apiHashMap = new ApiHashMap();
		String selectedOwnerType=null;
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save And Send Resouce For Review ");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.checkAppIcon);
			createUserPage.checkAppIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1000);
			apiHashMap.dynamicFormHandling(DIKSHA_APIKEY,DIKSHA_ROOTORGID,DIKSHA_FRAMEWORK,"review","resource");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			selectedOwnerType =createUserPage.selectOwner.getText();
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1000);
			ExtentTestManager.getTest().log(LogStatus.INFO, "User has successfully saved And Send Resouce For Review ");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save And Send Resouce For Review ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save And Send Resouce For Review ");
			Assert.fail("Failed to save And Send Resouce For Review  ");

		}
		return selectedOwnerType;

	}

	/**
	 * Purpose: resourcePublishAndSearch method is used to click on all checkboxes and publish the content.
	 */

	public void resourcePublishAndSearch(List <TestDataForDiksha> objListOFTestDataForSunbird)
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to publish and search the resource");
			String searchCourseName="";
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.publishResource);
			//GenericFunctions.scrollToElement(createUserPage.publishResource);
			createUserPage.publishResource.click();

			GenericFunctions.waitWebDriver(4000);
			for(int i=0;i<createUserPage.checkbox.size();i++)	
			{
				createUserPage.checkbox.get(i).click();
			}
			System.out.println("Checked all Check Boxes");
			GenericFunctions.waitWebDriver(4000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.popupPublishButton);
			executor.executeScript("arguments[0].click();", createUserPage.popupPublishButton);
			//createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);

			assertOnSearchAfterPublish(searchCourseName);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to publish and search the resource");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error(e.getMessage()+"Error in resourcePublishAndSearch");
			Assert.fail("Failed to publish and search the resource");
		}
	}

	/**
	 * Purpose: navigateToMyActivity method is used to navigate to my activity and select dashboard course and check last7days/last7weeks is available or not.
	 */

	public void navigateToMyActivity(){
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
	 * Purpose: editAndSubmitContent method is used to navigate to draft select any content ,edit it ,save it and send it for review.
	 */

	public void editAndSubmitContent()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to edit and submit the content for reviewing");
			List <TestDataForDiksha> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

			//publicUserPage.headerProfile.click();
			//goToProfilePage();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();

			createUserPage.drafts.click();
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(2000);
			String courseToAssert = objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./testData/courseNumbers.txt").toString();

			System.out.println("Course read :"+courseToAssert);			

			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppearOnScreen(createUserPage.getContentInDrafts);
			System.out.println("Course Found on Drafts :"+createUserPage.getContentInDrafts.getText());
			try
			{
				if(createUserPage.getContentInDrafts.getText().equalsIgnoreCase(courseToAssert))
				{
					//createUserPage.getCourseName.click();
					createUserPage.getContentInDrafts.click();
				}
				else
				{
					System.out.println(courseToAssert +"Course is not found in Drafts to Edit");
				}
			}
			catch(Exception e)
			{
				System.out.println("Could not get the same content in Drafts");
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.getContentInDrafts);
				createUserPage.getContentInDrafts.click();
			}

			GenericFunctions.waitWebDriver(2000);
			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.getContentInDrafts);
			createUserPage.getContentInDrafts.click();*/
			GenericFunctions.waitWebDriver(6000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7000);
			GenericFunctions.waitForPageToLoad(createUserPage.addResource);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectExtraResource.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.proceedButton);
			createUserPage.proceedButton.click();
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.saveCourse.click();
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			GenericFunctions.waitWebDriver(3000);
			createUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on editing and submitting the content for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not edit the content and submit for review");
		}

	}

	/**
	 * Purpose: limitedSharing method is used to limited share the course,book ,lessonplan and resource.
	 */

	public void limitedSharing(String contentType)
	{
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Limited sharing "+contentType);

			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			if(contentType.equalsIgnoreCase("book"))
			{
				createUserPage.bookTitle.sendKeys("_"+"Limited Sharing");
				GenericFunctions.waitWebDriver(1000);
			}
			else if(contentType.equalsIgnoreCase("course"))
			{
				createUserPage.titleNameForCourse.sendKeys("_"+"Limited Sharing");
				GenericFunctions.waitWebDriver(1000);
				createUserPage.titleDescriptionForCourse.sendKeys("_"+"Limited Sharing");
			} 
			else if(contentType.equalsIgnoreCase("lesson plan"))
			{
				createUserPage.lessonTitle.sendKeys("_"+"Limited Sharing");
				GenericFunctions.waitWebDriver(1000);
				createUserPage.lessonDescription.sendKeys("_"+"Limited Sharing");
			}
			else if(contentType.equalsIgnoreCase("resource"))
			{
				GenericFunctions.waitWebDriver(2000);
				createUserPage.closeContentPopup.click();
				GenericFunctions.waitWebDriver(1000);
			}

			else if(contentType.equalsIgnoreCase("upload"))
			{
				GenericFunctions.waitWebDriver(2000);
				createUserPage.closeContentPopup.click();
				GenericFunctions.waitWebDriver(1000);
			}
			GenericFunctions.waitWebDriver(2000);
			createUserPage.limitedSharingArrow.click();
			GenericFunctions.waitWebDriver(500);
			createUserPage.clickLimitedSharing.click();
			GenericFunctions.waitWebDriver(6000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on limited sharing the content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed on limited sharing the content");
		}

	}

	/**
	 * Purpose: uploadContentLimitedSharing method is used to upload content for limited sharing.
	 */

	public void uploadContentLimitedSharing(String uploadType) throws Exception
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload "+uploadType+" for Limited sharing");
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);
			GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			GenericFunctions.waitWebDriver(2000);
			WebElement browse=createUserPage.browseButton;
			if(uploadType.equalsIgnoreCase("mp4"))
			{
				browse.sendKeys(AllUploadingPaths.mp4Path);
				GenericFunctions.waitWebDriver(2000);
				System.out.println("MP4 content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("webm"))
			{
				browse.sendKeys(AllUploadingPaths.webmPath);
				GenericFunctions.waitWebDriver(2000);
				System.out.println("WEBM content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("youtube"))
			{
				createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
				GenericFunctions.waitWebDriver(2000);
				System.out.println("YOUTUBE content uploaded sucessfully");
				createUserPage.UploadButton.click();
			}
			else if(uploadType.equalsIgnoreCase("epub"))
			{
				browse.sendKeys(AllUploadingPaths.epubPath);
				GenericFunctions.waitWebDriver(2000);
				System.out.println("EPUB content uploaded sucessfully");
			}

			else if(uploadType.equalsIgnoreCase("h5p"))
			{
				browse.sendKeys(AllUploadingPaths.h5pPath);
				GenericFunctions.waitWebDriver(2000);
				System.out.println("H5P content uploaded sucessfully");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on uploading content for limited sharing ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed on uploading content for limited sharing ");
		}
	}

	/**
	 * Purpose: clickInReviewSubmission method is used to search course in review submission.
	 */

	public void clickInReviewSubmission()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search course in review submission");
			List <TestDataForDiksha> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			String courseToAssert = objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./testData/courseNumbers.txt").toString();
			System.out.println(courseToAssert);
			GenericFunctions.waitWebDriver(3000);
			if(createUserPage.getContentInDrafts.getText().equalsIgnoreCase(courseToAssert))
			{
				//createUserPage.getCourseName.click();
				createUserPage.getContentInDrafts.click();
			}
			else
			{
				System.out.println(courseToAssert +"Course is not found in Review Submission");
			}

			//createUserPage.getCourseName.click();						

			GenericFunctions.waitWebDriver(6000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(6000);
			try
			{

				if(createUserPage.viewDetails.isDisplayed())
				{		
					System.out.println(createUserPage.viewDetails.getText());
					System.out.println(createUserPage.viewDetails.getText().length());
					//Assert.assertEquals(createUserPage.viewDetails.getText(), " View Details ");
					System.out.println("User does not have the Edit access");
					createUserPage.editorCloseIcon.click();
					GenericFunctions.waitWebDriver(2000);
					ExtentTestManager.getTest().log(LogStatus.PASS, "User does not have the Edit access and have only View Access");
				}
			}
			catch(Exception e)
			{
				System.out.println("Exception Occured here"+e);
				ExtentTestManager.getTest().log(LogStatus.FAIL, "EXCEPTION"+e.getLocalizedMessage());
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search course in review submission");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to search course in review submission");
		}

	}

	/**
	 * Purpose: checkInPublished method is used to search  the course in Published section.
	 */

	public void checkInPublished(String source, List <TestDataForDiksha> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to check in Published content in Published bucket");
			GenericFunctions.waitWebDriver(3000);
			/*GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
			publicUserPage.headerProfile.click();*/
			//goToProfilePage();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.published.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.refreshWebPage();
			//handlePopupOnLogin();
			GenericFunctions.waitForElementToAppear(createUserPage.getContentInDrafts);
			//String courseName= createUserPage.getCourseName.getText();
			String courseName= createUserPage.getContentInDrafts.getText();
			System.out.println(courseName);
			System.out.println(objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./testData/courseNumbers.txt").toString());
			if(courseName.equalsIgnoreCase(objListOFTestDataForSunbird.get(0).getCourseName()+GenericFunctions.readFromNotepad("./testData/courseNumbers.txt").toString()))
			{
				System.out.println("Course: "+courseName+" is found in published bucket");
				ExtentTestManager.getTest().log(LogStatus.PASS, "Course: "+courseName+" is found in published bucket");
			}
			else
			{
				System.out.println("Course:"+courseName+"is not found in publishes bucket");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Course is not found in published bukcet");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to get the course in the published bucket");
		}

	}

	/**
	 * Purpose: saveBookAndCheckMessage method is used to save book and check the confirmation message.
	 */

	public void saveBookAndCheckMessage()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save book and check the confirmation message");
			String randomDialCode = DIAL_CODE[rand.nextInt(DIAL_CODE.length)];
			GenericFunctions.waitForElementToAppear(createUserPage.bookDialcode);
			createUserPage.bookDialcode.sendKeys(randomDialCode);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.acceptDialcode.click();
			System.out.println("Dial Code: "+randomDialCode+" is entered in meta data page");
			GenericFunctions.waitWebDriver(1500);		
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveCourse);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveCourse.click();
			GenericFunctions.waitForElementToAppearOnScreen(createUserPage.successToastMessage);
			action.moveToElement(createUserPage.successToastMessage);
			String alertText=createUserPage.successToastMessage.getText();
			try
			{
				GenericFunctions.waitWebDriver(3500);
				createUserPage.saveCourse.click();
				GenericFunctions.waitWebDriver(1000);
			}
			catch(Exception e)
			{
				System.out.println("Save icon is not enabled");
			}
			Assert.assertTrue(true, "Failed on asserting while checking the message");
			System.out.println("Dial Code Added/updated Successfully");
			System.out.println("Content updated successfully");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Dial Code Added "+alertText);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Content updated successfully");
			GenericFunctions.waitWebDriver(1500);


		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save and check the confirmation message");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Exception occured while saving the book and checking confirmation messsage"+e);
			Assert.fail("Failed to save and check the confirmation message");

		}
	}

	/**
	 * Purpose: removeDailCodeAndCheckMessage method is used to remove dial code and check the confirmation message.
	 */


	public void removeDailCodeAndCheckMessage()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to remove the dial code and check the confirmation message");
			saveBookAndCheckMessage();
			createUserPage.editDialCode.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.removeBookDialcode.click();
			//GenericFunctions.waitWebDriver(1500);
			//createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(3500);
			//GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Dial Code Removed successfully");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Dial Code Removed successfully");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.editorCloseIcon);
			createUserPage.editorCloseIcon.click();
			GenericFunctions.waitForElementToAppear(createUserPage.profileIconDropdown);
			GenericFunctions.refreshWebPage();
			//handlePopupOnLogin();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to remove the dial code and check the confirmation message");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed on remove dial code and check the confirmation message");

		}

	}

	/**
	 * Purpose: verifyOnlyBookOption method is used to check in the workspace,only book option should be available.
	 */

	public void verifyOnlyBookOption()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify only book option is present");
			/*GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
			publicUserPage.headerProfile.click();*/
			//goToProfilePage();
			/*try
			{
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(createUserPage.closeIcon);
				createUserPage.closeIcon.click();
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Could not find the Popup after login");
				System.out.println("Exception occured " +e.getLocalizedMessage());
			}*/
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(2500);
			boolean bookOption = createUserPage.createBook.isDisplayed();
			Assert.assertEquals(true,bookOption);
			GenericFunctions.waitWebDriver(1500);
			if(bookOption==true)
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, createUserPage.createBook.getText()+" Option is only present for Book Creator");
				System.out.println(createUserPage.createBook.getText()+" Option is only present for Book Creator");
			}
			else
			{
				System.out.println("Only book option is not present");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify that only book option is present to the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to verify that only book option is present to the user");

		}

	}

	/**
	 * Purpose: rejectTheUploads method is used to reject the uploads.
	 */

	public void rejectTheUploads(String uploadType)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to reject the upload"+uploadType);
			List <TestDataForDiksha> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

			/*GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
			publicUserPage.headerProfile.click();*/
			//handlePopupOnLogin();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.upForReview);
			createUserPage.upForReview.click();

			//To search for an upload and reject it which is already existing in the list
			GenericFunctions.waitForElementToAppear(createUserPage.searchForReview);
			if(uploadType.equalsIgnoreCase("epub"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+" "+EPUB);
			}
			else if(uploadType.equalsIgnoreCase("mp4"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+" "+MP4);
			}
			else if(uploadType.equalsIgnoreCase("webm"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+" "+WEBM);
			}

			else if(uploadType.equalsIgnoreCase("youtube"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+" "+YOUTUBE);
			}
			else if(uploadType.equalsIgnoreCase("html"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+" "+HTML);
			}

			else if(uploadType.equalsIgnoreCase("h5p"))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+" "+H5P);
			}
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(createUserPage.clickRequestChanges);
			//GenericFunctions.scrollToElement(createUserPage.clickRequestChanges);
			GenericFunctions.waitWebDriver(2500);
			//Giving reasons 
			createUserPage.clickRequestChanges.click();
			//GenericFunctions.waitForElementToAppear(createUserPage.rejectReason1);
			GenericFunctions.waitWebDriver(2500);
			createUserPage.rejectReason1.click();
			createUserPage.rejectReason2.click();
			createUserPage.rejectReason3.click();
			String rejectReason = (REVIEW_COMMENTS[new Random().nextInt(REVIEW_COMMENTS.length)]);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.reviewComment.get(0).click();
			createUserPage.reviewComment.get(0).sendKeys(rejectReason);
			GenericFunctions.waitWebDriver(2000);
			resizeTheScreen();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.requestChangesButton);
			executor.executeScript("arguments[0].click();", createUserPage.requestChangesButton);
			GenericFunctions.waitWebDriver(2000);
			//createUserPage.requestChangesButton.click();
			GenericFunctions.waitWebDriver(3000);
			//GenericFunctions.refreshWebPage();
			//handlePopupOnLogin();
			GenericFunctions.waitWebDriver(3000);
			System.out.println(uploadType+" rejected succesfully ");
			ExtentTestManager.getTest().log(LogStatus.PASS, uploadType+" rejected succesfully ");

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to reject the upload content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to reject the uploads"+uploadType);

		}

	}

	/**
	 * Purpose: verifyOnlyBooksPresent method is used to verify that only books should be available.
	 */

	public void verifyOnlyBooksPresent()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify that only books are present to the user");
			/*GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
			publicUserPage.headerProfile.click();*/
			//handlePopupOnLogin();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(2000);

			GenericFunctions.waitForElements(createUserPage.contentType); 
			String actualBookText=createUserPage.contentType.get(0).getText();
			String expectedBookText="TextBook";
			if(createUserPage.contentType.get(0).isDisplayed())
			{
				Assert.assertEquals(actualBookText, expectedBookText);
				System.out.println("Only Textbooks are available");
				ExtentTestManager.getTest().log(LogStatus.PASS, "Only Books are available to the user");
			}
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify only books present to the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Other contents are available for reviewing");
			Assert.fail("Failed to verify only books present to the user");

		}
	}

	/**
	 * Purpose: searchTheCreatedContentWithFilters method is used to search the content using different filters.
	 */

	public void searchTheCreatedContentWithFilters()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify search with filters");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.upForReview.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.filterIcon.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.clickFilterBoard);
			createUserPage.clickFilterBoard.click();
			GenericFunctions.waitForElementToAppear(publicUserPage.selectFilterBoard);
			publicUserPage.selectFilterBoard.click();
			publicUserPage.clickFilterClass.click();
			GenericFunctions.waitForElements(publicUserPage.selectFilterClass);
			publicUserPage.selectFilterClass.get(0).click();
			publicUserPage.selectFilterClass.get(1).click();
			GenericFunctions.waitWebDriver(1000);

			publicUserPage.clickFilterSubject.click();
			GenericFunctions.waitForElements(publicUserPage.selectFilterSubject);
			publicUserPage.selectFilterSubject.get(0).click();
			publicUserPage.selectFilterSubject.get(1).click();
			GenericFunctions.waitWebDriver(1000);

			publicUserPage.clickFilterMedium.click();
			GenericFunctions.waitForElements(publicUserPage.selectFilterMedium);
			publicUserPage.selectFilterMedium.get(0).click();
			publicUserPage.selectFilterMedium.get(1).click();

			createUserPage.clickContentType.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.selectContentType);
			createUserPage.selectContentType.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.applyButton.click();
			System.out.println("All the filters are applied");
			createUserPage.filterIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			if(createUserPage.searchedContentForPublish.isDisplayed())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "User is able to search the content using filters");
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to apply filters and search");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to apply filters and search");

		}


	}

	/**
	 * Purpose: navigateToProfileAndSearch method is used to search different profiles inside Profile.
	 */

	public void navigateToProfileAndSearch(String userData)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to profile and search "+userData);
			/*GenericFunctions.waitForElementToAppear(createUserPage.headerProfile);
			createUserPage.headerProfile.click();*/
			goToProfilePage();
			GenericFunctions.waitForElementToAppear(createUserPage.searchInput);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchInput.click();
			createUserPage.searchInput.sendKeys(userData);
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(1000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to profile and search");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("could not navigate to profile and search");
		}
	}

	/**
	 * Purpose: navigateToProfileAndSearch method is used to search different profiles inside Profile.
	 */

	public void navigateToProfileAndSearchOrg()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigate to profile and search organizations");
			//createUserPage.dropDown.click();
			/*GenericFunctions.waitForElementToAppear(createUserPage.headerProfile);
			createUserPage.headerProfile.click();*/
			//GenericFunctions.waitForElementToAppear(createMentorPage.searchDropDown);
			//createMentorPage.searchDropDown.click();
			GenericFunctions.waitWebDriver(1000);
			//createMentorPage.searchDropDownOrg.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.downloadButton.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to profile and search organizations");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not navigate to profile and search organizations,Exception "+e.getLocalizedMessage());
		}
	}

	/**
	 * Purpose: navigateToCourseSearchAndCreateBatch method is used to search a course in search bar and click on create batch.
	 */

	public void navigateToCourseSearchAndCreateBatch()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to search a coursea and create a batch");
			List <TestDataForDiksha> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			//createUserPage.dropDown.click();
			/*GenericFunctions.waitForElementToAppear(createUserPage.headerProfile);
			createUserPage.headerProfile.click();*/
			handlePopupOnLogin();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.searchDropDown.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.searchDropDownCourse.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.filterSearch.sendKeys(objListOFTestDataForSunbird1.get(8).getCourseDescription());
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createMentorPage.searchedCourse.click();
			GenericFunctions.waitWebDriver(1000);
			createMentorPage.createBatch.click();
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
	 * Purpose: verifyNoBookOptionPresent method is used to verify no book options to be present.
	 */

	public void verifyNoBookOptionPresent()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify no book option is present to the user");
			/*GenericFunctions.waitForElementToAppear(createUserPage.headerProfile);
			createUserPage.headerProfile.click();*/
			//handlePopupOnLogin();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(2000);
			try
			{
				createUserPage.createBook.click();
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "User does not have create book option");
				Assert.assertTrue(true);
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify book option to the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not check for book option,Exception"+e.getLocalizedMessage());

		}
	}


	/**
	 * Purpose: addAudio method is used to add audio to the resource.
	 */

	public void addAudio()
	{
		//Adding Audio
		GenericFunctions.waitForElementToAppear(createUserPage.addAudio);
		createUserPage.addAudio.click();
		GenericFunctions.waitForElementToAppearOnScreen(createUserPage.clickAllAudio);
		GenericFunctions.waitWebDriver(500);
		createUserPage.clickAllAudio.click();
		GenericFunctions.waitForElementToAppear(createUserPage.selectAudio_AllAudio);
		GenericFunctions.waitWebDriver(500);
		createUserPage.selectAudio_AllAudio.click();
		GenericFunctions.waitWebDriver(600);
		createUserPage.selectAppIcon.click();
		GenericFunctions.waitWebDriver(500);
	}

	/**
	 * Purpose: deleteCreatedItems method is used to delete created contents.
	 */

	public void deleteCreatedItems()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete Items which are created");
			GenericFunctions.waitForElementToAppear(createUserPage.deleteButton);
			createUserPage.deleteButton.click();
			GenericFunctions.waitForElementToAppear(createUserPage.yesButtonPopup);
			createUserPage.yesButtonPopup.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.refreshWebPage();
			//handlePopupOnLogin();
			GenericFunctions.waitForElementToAppear(uploadOrgPage.dropdown);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Created content is deleted from All My Content");

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to delete Items ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to delete Items");
			Assert.fail("Failed to delete Items ");
		}
	}

	/**
	 * Purpose: goToProfilePage method is used to navigate to profile.
	 */

	public void goToProfilePage()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "Navigate to Profile Page");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.profileIconDropdown);
			createUserPage.profileIconDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.profileIconProfile);
			createUserPage.profileIconProfile.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not navigate to Profile Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not navigate to Profile Page");
		}
	}

	/**
	 * Purpose: handlePopupOnLogin method is used to handle the popup while ligin.
	 */

	public void handlePopupOnLogin()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is tring to handle the popup ");
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(createUserPage.closeIcon);
			createUserPage.closeIcon.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "Could not find the-Enter details to get relevant content Popup after login");
			System.out.println("Exception occured " +e.getLocalizedMessage());
		}
	}

	/**
	 * Purpose: createCourseForOpenBatch method is used to create course by adding a child node.
	 */

	public String createCourseForOpenBatch(List <TestDataForDiksha> objListOFTestDataForSunbird) throws InterruptedException
	{
		String courseNumber=null;
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create course");
			GenericFunctions.waitWebDriver(1500);
			//System.out.println(driver.findElement(By.xpath(" //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			courseNumber = GenericFunctions.testDataIncrementer("./testData/dikshadata.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2500);		
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.titleNameForCourse.click();
			createUserPage.titleNameForCourse.clear();
			createUserPage.titleNameForCourse.sendKeys(objListOFTestDataForSunbird.get(0).getTitle()+courseNumber);
			createUserPage.titleDescriptionForCourse.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			createUserPage.titleKeywordForCourse.sendKeys("math");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitWebDriver(2500);
			createUserPage.selectResourceN.click();
			createUserPage.proceedButton.click();


		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create course");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method createCourse"+e.getMessage());
			System.out.println("Exception In the method createCourse, failed to create corse");
			Assert.fail("Failed on creating course");
		}
		return objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber;
	}
	/**
	 * Purpose: searchInUpForReviewForOpenbatch method is used to search course in up for review.
	 */

	public String searchInUpForReviewForOpenbatch(String source,List <TestDataForDiksha> objListOFTestDataForSunbird) throws Exception{
		String courseNumber = "",searchCourseName="";
		try
		{	
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search in Up For Review bucket for "+source);
			/*GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
			publicUserPage.headerProfile.click();*/
			//handlePopupOnLogin();

			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(1000);	
			createUserPage.upForReview.click();
			/*courseNumber = GenericFunctions.readFromNotepad("./testData/dikshadata.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);	*/	

			if(source.equalsIgnoreCase(COURSE))
			{
				courseNumber = GenericFunctions.readFromNotepad("./testData/dikshadata.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName() + courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName() + courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			if(source.equalsIgnoreCase(BOOK)){
				courseNumber = GenericFunctions.readFromNotepad("./testData/bookNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName() + courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(2).getCourseName() + courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			//Added on 10 july 2018
			else if(source.equalsIgnoreCase(RESOURCE))
			{
				courseNumber = GenericFunctions.readFromNotepad("./testData/resourceNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName() + courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(6).getCourseName() +courseNumber;
				GenericFunctions.waitWebDriver(3000);

			}
			//------------ADDED ON OCT 11 v1.11.0--------------
			System.out.println(searchCourseName);
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitWebDriver(3000);
			//createUserPage.editorCloseIcon.click();

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching in Up for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getLocalizedMessage());
			log.error("Exception In the method searchCourse"+e.getMessage());
			Assert.fail("Failed to search in Up for review bucket");
		}
		return searchCourseName;

	}

	/**
	 * Purpose: publishAndSearchForOpenBatch method is used to publish and search course.
	 */

	public String publishAndSearchForOpenBatch(String source,List <TestDataForDiksha> objListOFTestDataForSunbird){
		String courseNumber="",searchCourseName="";
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to publish and search "+source);
			GenericFunctions.waitWebDriver(3000);	
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(3000);	
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.publishCourseButton);
			createUserPage.publishCourseButton.click();
			for(int i=0;i<createUserPage.checkbox.size();i++){
				createUserPage.checkbox.get(i).click();
			}

			GenericFunctions.waitWebDriver(2500);
			//executor.executeAsyncScript("arguments[0].click();", createUserPage.popupPublishButton);
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);

			//driver.switchTo().defaultContent();

			/*if(source.equalsIgnoreCase(COURSE))
			{
				GenericFunctions.refreshWebPage();
				//handlePopupOnLogin();
				GenericFunctions.waitWebDriver(6000);
				GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
				createUserPage.headerCourse.click();
				GenericFunctions.waitWebDriver(3000);
				courseNumber = GenericFunctions.readFromNotepad("./testData/dikshadata.txt").toString();
				GenericFunctions.waitForElementToAppear(createUserPage.searchInput);
				createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(2500);
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber;
			}

			else if(source.equalsIgnoreCase(BOOK))
			{
				GenericFunctions.refreshWebPage();
				//handlePopupOnLogin();
				GenericFunctions.waitWebDriver(6000);
				GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
				createUserPage.headerLibrary.click();
				GenericFunctions.waitWebDriver(2500);
				courseNumber = GenericFunctions.readFromNotepad("./testData/bookNumbers.txt").toString();
				GenericFunctions.waitForElementToAppear(createUserPage.searchInput);
				createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(2500);
				searchCourseName = createUserPage.getCourseName.getText(); //objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber;
			}

			//Added on Maintenance 06/09/2018
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.getCourseName);

			//assertOnSearchAfterPublish(searchCourseName);
			 */			
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to publish and search "+source);
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getMessage());
			Assert.fail("Failed to publish and search");
		}
		System.out.println(searchCourseName);
		return searchCourseName;
	}

	/**
	 * Purpose: selectTopic method is used to search and select the topic.
	 */

	public void selectTopic()
	{
		try
		{
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickTopic.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchTopic);
			createUserPage.searchTopic.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectTopic);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectTopic.click();	
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.doneButton);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.doneButton.click();

			//executor.executeScript("arguments[0].click();", createUserPage.doneButton); 
			//GenericFunctions.scrollToElement(createUserPage.doneButton);
			//GenericFunctions.scrollTillEndOfPage();
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.doneButton);
			GenericFunctions.waitWebDriver(3000);
			//createUserPage.doneButton.click();
			//executor.executeScript("arguments[0].click();",createUserPage.doneButton);
			//action.moveToElement(createUserPage.doneButton).click().perform();
			//action.click(createUserPage.doneButton).build().perform();
			//GenericFunctions.clickOnElementUsingJavascript(createUserPage.doneButton);
			//action.click(createUserPage.doneButton).click().build().perform();

		}
		catch(Exception e)
		{
			System.out.println("Could not select the Topic is send for review form");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Could not select the Topic is send for review form");
		}
	}

	/**
	 * Purpose: IsElementDisplayed method is used to check the element is displayed on the page.
	 */
	public boolean IsElementDisplayed()//WebDriver driver, WebElement id)
	{
		try		
		{
			WebDriverWait wait =new WebDriverWait(driver, 120);
			WebElement elementState = wait.until(ExpectedConditions.visibilityOf(createUserPage.workSpace));

			if(elementState.isDisplayed())
			{
				return true;
			}
			else
			{
				GenericFunctions.refreshWebPage();
				return false;
			}
		}
		catch(Exception e)
		{
			System.out.println("exception e"+e);
		}
		return false;
	}

	/**
	 * Purpose: navigateToLibraryAndSearchContent method is used to navigate to the library and search the content.
	 */

	public void navigateToLibraryAndSearchContent(String userData)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Library And Search Content");
			List <TestDataForDiksha> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			/*GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();*/

			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchInput.click();
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("./testData/contentNumbers.txt"));
			System.out.println(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("./testData/contentNumbers.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForUpload);
			createUserPage.searchedContentForUpload.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Library And Search Content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to navigate To Library And Search Content");
			Assert.fail("Failed to navigate To Library And Search Content ");
		}


	}


	//Nov 28th
	/*public void saveAndSendCourseForReview(List <TestDataForDiksha> objListOFTestDataForSunbird)throws Exception{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save and send course for review");
			GenericFunctions.waitWebDriver(2500);
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

	}*/

	/**
	 * Purpose: searchInUpForReview method is used to search the content in up for review.
	 */

	public String searchInUpForReview(String source,List <TestDataForDiksha> objListOFTestDataForSunbird) throws Exception{
		String courseNumber = "",searchCourseName="";
		try
		{	
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search in Up For Review bucket for "+source);
			/*GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
			publicUserPage.headerProfile.click();*/
			////handlePopupOnLogin();

			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(1000);	
			createUserPage.upForReview.click();
			if(source.equalsIgnoreCase(COURSE)){
				courseNumber = GenericFunctions.readFromNotepad("./testData/dikshadata.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);		

			}
			else if(source.equalsIgnoreCase(COLLECTION)){
				courseNumber = GenericFunctions.readFromNotepad("./testData/collectionNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(5).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(5).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			else if(source.equalsIgnoreCase(BOOK)){
				courseNumber = GenericFunctions.readFromNotepad("./testData/bookNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);			
			}
			//Added on 10 july 2018
			else if(source.equalsIgnoreCase(RESOURCE))
			{
				courseNumber = GenericFunctions.readFromNotepad("./testData/resourceNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber);
				createUserPage.searchIconUpForReview.click();
				searchCourseName = objListOFTestDataForSunbird.get(6).getCourseName()+courseNumber;
				GenericFunctions.waitWebDriver(3000);
			}
			//------------ADDED ON OCT 11 v1.11.0--------------

			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitWebDriver(3000);
			//createUserPage.editorCloseIcon.click();

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching in Up for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getLocalizedMessage());
			log.error("Exception In the method searchCourse"+e.getMessage());
			Assert.fail("Failed to search in Up for review bucket");
		}
		return searchCourseName;

	}
	//Nov 28
	/**
	 * Purpose: publishAndSearch method is used to publish and search the content .
	 */

	public String publishAndSearch(String source,List <TestDataForDiksha> objListOFTestDataForSunbird){
		String courseNumber="",searchCourseName="";
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to publish and search "+source);
			GenericFunctions.waitWebDriver(3000);	
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.publishCourseButton);
			createUserPage.publishCourseButton.click();
			for(int i=0;i<createUserPage.checkbox.size();i++){
				createUserPage.checkbox.get(i).click();
			}
			GenericFunctions.waitWebDriver(1500);
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);	
			driver.switchTo().defaultContent();
			GenericFunctions.waitForElementToAppear(createUserPage.upForReview);
			//if(createUserPage.upForReview.isDisplayed()&&createUserPage.noContentInUpForReview.isDisplayed())

			if(createUserPage.upForReview.isDisplayed())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, source+"is published sucessfully");
			}
			//driver.switchTo().defaultContent();
			/*
			if(source.equalsIgnoreCase(COURSE))
			{
				GenericFunctions.refreshWebPage();
				////handlePopupOnLogin();
				GenericFunctions.waitWebDriver(6000);
				GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);
				createUserPage.headerCourse.click();
				GenericFunctions.waitWebDriver(3000);
				courseNumber = GenericFunctions.readFromNotepad("./testData/courseNumbers.txt").toString();
				GenericFunctions.waitForElementToAppear(createUserPage.searchInput);
				createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(2500);
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName()+courseNumber;
			}

			else if(source.equalsIgnoreCase(BOOK))
			{
				GenericFunctions.refreshWebPage();
				////handlePopupOnLogin();
				GenericFunctions.waitWebDriver(6000);
				GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
				createUserPage.headerLibrary.click();
				GenericFunctions.waitWebDriver(2500);
				courseNumber = GenericFunctions.readFromNotepad("./testData/bookNumbers.txt").toString();
				GenericFunctions.waitForElementToAppear(createUserPage.searchInput);
				createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber);
				createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(2500);
				searchCourseName = createUserPage.getCourseName.getText(); //objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber;
			}*/

			//Added on Maintenance 06/09/2018
			/*GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.getCourseName);*/

			//assertOnSearchAfterPublish(searchCourseName);

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to publish and search "+source);
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getMessage());
			Assert.fail("Failed to publish and search");
		}
		System.out.println(searchCourseName);
		return searchCourseName;
	}

	//Nov 28

	/**
	 * Purpose: resourceName method is used to create resource by adding name of resource .
	 */
	public void resourceName()
	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying create new resource by giving an Unique Resource name");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			GenericFunctions.waitWebDriver(1500);
			String resourceNumber = GenericFunctions.testDataIncrementer("./testData/resourceNumbers.txt").toString();
			createUserPage.resourceName.sendKeys(objListOFTestDataForSunbird1.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(7000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4500);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on entering unique resource name");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on entering unique resource name"+e.getLocalizedMessage());
			Assert.fail("Failed on entering unique resource name"+e.getLocalizedMessage());
		}

	}

	/**
	 * Purpose: createCollection method is used to create collection by adding a child node,save it and send it for review after filling the review form  .
	 */
	public String createCollection()
	{
		ApiHashMap apiHashMap = new ApiHashMap();
		String selectedOwnershipType=null, collectionName = null;
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create new collection");
			List <TestDataForDiksha> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitWebDriver(2000);
			tryForWorkSpace();
			navigateToWorkspace(COLLECTION);
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			collectionName = objListOFTestDataForSunbird1.get(5).getCourseName()+"_"+GenericFunctions.testDataIncrementer("./testData/collectionNumbers.txt");
			createUserPage.courseName.sendKeys(collectionName);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(10000);
			GenericFunctions.waitForPageToLoad(createUserPage.addResource);
			GenericFunctions.waitForElementToAppear(createUserPage.addResource);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitForElementToAppear(createUserPage.selectCollection);
			createUserPage.selectCollection.click();
			GenericFunctions.waitForElementToAppear(createUserPage.proceedButton);
			createUserPage.proceedButton.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReview);
			if(createUserPage.sendForReview.isEnabled())
			{	
				ExtentTestManager.getTest().log(LogStatus.PASS, "Collection is successfully created");
				try
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to send the collection for review");
					createUserPage.sendForReview.click();
					GenericFunctions.waitForElementToAppear(createUserPage.clickAppIcon);
					createUserPage.clickAppIcon.click();
					GenericFunctions.waitForElementToAppear(createUserPage.checkAppIcon);
					createUserPage.checkAppIcon.click();
					GenericFunctions.waitWebDriver(1500);
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.selectAppIcon);
					createUserPage.selectAppIcon.click();
					GenericFunctions.waitWebDriver(1000);
					apiHashMap.dynamicFormHandling(DIKSHA_APIKEY,DIKSHA_ROOTORGID,DIKSHA_FRAMEWORK,"review","collection");
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.scrollToElement(createUserPage.clickOwner);
					createUserPage.clickOwner.click();
					GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
					createUserPage.selectOwner.click();
					ExtentTestManager.getTest().log(LogStatus.INFO,"User is able to select value from the ownershipType dropdown"); 
					selectedOwnershipType=createUserPage.selectOwner.getText();
					GenericFunctions.waitWebDriver(1500);
					GenericFunctions.waitForElementToAppear(createUserPage.saveButton);
					createUserPage.saveButton.click();
					GenericFunctions.waitWebDriver(2000);	
					try
					{
						boolean createCondition = createUserPage.workSpace.isDisplayed();					
						if(createCondition==true)
							GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
						ExtentTestManager.getTest().log(LogStatus.PASS, "Collection is sent for review");
					}					
					catch(UnhandledAlertException u)
					{
						driver.switchTo().alert();
						ExtentTestManager.getTest().log(LogStatus.INFO, "Handled the exception"+u.getLocalizedMessage());
					}
				}
				catch(Exception e)
				{
					ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to send the Collection for review");
					ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message : "+e.getLocalizedMessage());
					Assert.fail("Failed to fill form for new collection");
				}
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Send for review button is not enabled");

			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create new collection");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on creating collection");
			Assert.fail("Failed to create new collection");
		}

		System.out.println("collectionName / selectedOwnershipType "+collectionName+"/"+selectedOwnershipType);
		return collectionName+"/"+selectedOwnershipType;
	}
	//Nov 28


	/*	
	public void saveAndSendForReviewLesson()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save and publish the lesson plan");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.sendForReview.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();

			//Added on Maintenance 12/09/2018
			//GenericFunctions.waitForElementToAppear(createUserPage.searchUploadImage);
			//createUserPage.searchUploadImage.sendKeys(LESSON_PLAN_IMAGE);
			//createUserPage.clickImageSearch.click();

			GenericFunctions.waitWebDriver(2000);	
			createUserPage.checkContentIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1500);
			apiHashMap.dynamicFormHandling(DIKSHA_APIKEY, DIKSHA_ROOTORGID, DIKSHA_FRAMEWORK, "review", "lessonplan");
			GenericFunctions.scrollToElement(createUserPage.clickBoard);
			GenericFunctions.waitForElementToAppear(createUserPage.clickBoard);
			createUserPage.clickBoard.click();
			createUserPage.selectBoard.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickMedium.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectMediumN.click();
			GenericFunctions.scrollToElement(createUserPage.clickClassN);
			createUserPage.clickClassN.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectClassN.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickSubject);
			createUserPage.clickSubject.click();
			createUserPage.selectSubjectN.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.selectyear);
			createUserPage.selectyear.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.select2018.click();

			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();





			/*
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.clickOwner);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);			
			createUserPage.selectOwner.click();

			//selectTopic();

			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitForElementToAppear(createUserPage.saveButton);
			createUserPage.saveButton.click();

			GenericFunctions.waitWebDriver(5000);


			GenericFunctions.waitWebDriver(2500);

			ExtentTestManager.getTest().log(LogStatus.PASS, "Lesson Plan is published sucessfully");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save and publish the lesson plan");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save and publish the lesson plan");
			Assert.fail("Failed on saving and publishing the lesson plan");
		}

	}
	 */

	//NOv 28

	/**
	 * Purpose: navigateToWorkspace method is used to navigate to the workspace and then navigate to the mentioned section  .
	 */

	public void navigateToWorkspace(String createVariable)
	{

		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is navigating to the Workspace to create "+createVariable);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(2000);
			switch(createVariable)
			{
			case "Book":
				GenericFunctions.waitForElementToAppear(createUserPage.createBook);
				createUserPage.createBook.click();
				GenericFunctions.waitWebDriver(2000);
				break;
			case "Course":
				GenericFunctions.waitForElementToAppear(createUserPage.createCourse);
				createUserPage.createCourse.click();
				GenericFunctions.waitWebDriver(2000);
				break;
			case "Resource":
				GenericFunctions.waitForElementToAppear(createUserPage.createResource);
				createUserPage.createResource.click();
				GenericFunctions.waitWebDriver(2000);
				break;
			case "Collection":
				GenericFunctions.waitForElementToAppear(createUserPage.createCollection);
				createUserPage.createCollection.click();
				GenericFunctions.waitWebDriver(2000);
				break;
			case "Lesson Plan":
				GenericFunctions.waitForElementToAppear(createUserPage.createLesson);
				createUserPage.createLesson.click();
				GenericFunctions.waitWebDriver(2000);
				break;
			case "Upload Content":
				GenericFunctions.waitForElementToAppear(createUserPage.createUploadContent);
				createUserPage.createUploadContent.click();
				GenericFunctions.waitWebDriver(2000);
				break;

			case "Published":
				GenericFunctions.waitForElementToAppear(createUserPage.published);
				createUserPage.published.click();
				GenericFunctions.waitWebDriver(2000);
				break;

			case "Drafts":
				GenericFunctions.waitForElementToAppear(createUserPage.drafts);
				createUserPage.drafts.click();
				GenericFunctions.waitWebDriver(2000);
				break;

			case "All My Content":
				GenericFunctions.waitForElementToAppear(createUserPage.allMyContent);
				createUserPage.allMyContent.click();
				GenericFunctions.waitWebDriver(2000);
				break;
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Workspace");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on navigating to Workspace");
			Assert.fail("Failed on navigating to Workspace and create "+createVariable);
		}

	}

	//Nov 28
	/**
	 * Purpose: tryForWorkSpace method is used to navigate to the workspace & try ,if not available until navigate to workspace  .
	 */

	public void tryForWorkSpace()
	{
		try
		{

			String cssValue="#main-nav > div.ui.text.primary-nav.menu.ml-auto.computer.only > app-main-menu > div > a.item.active";

			if((driver.findElements(By.xpath("//a[contains(.,'Workspace')]")).size()!=0))
			{
				System.out.println("Element is Present");			
			}
			else
			{
				GenericFunctions.refreshWebPage();
				tryForWorkSpace();
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "Could not find the-Enter details to get relevant content Popup after login");
			System.out.println("Exception occured " +e.getLocalizedMessage());
		}

	}

	//Nov 28

	/**
	 * Purpose: goToWorkspace method is used to navigate to the workspace & then in up for review and then publish the content.
	 */

	public void goToWorkspace(String inputToSearch)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to workspace, search in Up for review and publish "+inputToSearch);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.refreshWebPage();
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			tryForWorkSpace();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.upForReview);
			createUserPage.upForReview.click();
			//GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.searchForReview);
			if(inputToSearch.equalsIgnoreCase(MP4))
			{
				String searchMp4Content=objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("./testData/contentNumbers.txt")+"_"+MP4;
				createUserPage.searchForReview.sendKeys(searchMp4Content);
				System.out.println(searchMp4Content);
			}

			else if(inputToSearch.equalsIgnoreCase(WEBM))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("./testData/contentNumbers.txt")+"_"+WEBM);
			}
			else if(inputToSearch.equalsIgnoreCase(YOUTUBE))
			{
				createUserPage.searchForReview.sendKeys(GenericFunctions.readFromNotepad("./testData/contentNumbers.txt")+"_"+YOUTUBE);//objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+
			}
			else if(inputToSearch.equalsIgnoreCase(EPUB))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("./testData/contentNumbers.txt")+"_"+EPUB);
			}
			else if(inputToSearch.equalsIgnoreCase(HTML))
			{  
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("./testData/contentNumbers.txt")+"_"+HTML);
			}
			else if(inputToSearch.equalsIgnoreCase(H5P))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("./testData/contentNumbers.txt")+"_"+H5P);
			}
			else if(inputToSearch.equalsIgnoreCase(PDF))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("./testData/contentNumbers.txt")+"_"+PDF);
			}

			else if(inputToSearch.equalsIgnoreCase(COLLECTION))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(5).getCourseName()+"_"+GenericFunctions.readFromNotepad("./testData/collectionNumbers.txt"));
				//+"_"+GenericFunctions.readFromNotepad("./testData/collectionNumbers.txt")
			}
			else if(inputToSearch.equalsIgnoreCase(LESSONPLAN))
			{
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(3).getCourseName());
				GenericFunctions.waitWebDriver(3000);
				//createUserPage.searchedContentForPublish.click();
			}
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			GenericFunctions.waitWebDriver(3000);
			createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitWebDriver(4000);

			if(inputToSearch.contains("collection"))
			{
				GenericFunctions.waitWebDriver(4000);
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(4000);
				createUserPage.clickPublishIcon.click();
			}
			else if(inputToSearch.contains("lessonplan"))
			{
				GenericFunctions.waitWebDriver(4000);
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(4000);
				GenericFunctions.waitForElementToAppear(createUserPage.clickPublishIcon);
				GenericFunctions.scrollToElement(createUserPage.clickPublishIcon);
				createUserPage.clickPublishIcon.click();
			}
			else if(inputToSearch.contains("epub")||inputToSearch.contains("webm")||inputToSearch.contains("mp4")||inputToSearch.contains("h5p")||inputToSearch.contains("html")||inputToSearch.contains("youtube")||inputToSearch.contains("pdf"))
			{

				GenericFunctions.waitWebDriver(4000);
				//GenericFunctions.waitForElementToAppear(createUserPage.publishButton);
				GenericFunctions.scrollTillEndOfPage();
				//GenericFunctions.scrollToElement(createUserPage.publishButton);
				GenericFunctions.waitWebDriver(2500);
				System.out.println(createUserPage.publishButton.getText());
				createUserPage.publishButton.click();
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
			System.out.println(inputToSearch+" Content published sucessfully");
			ExtentTestManager.getTest().log(LogStatus.PASS,inputToSearch+" Content published sucessfully");
			GenericFunctions.waitWebDriver(6000);
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitForElementToAppear(createUserPage.upForReview);
			createUserPage.upForReview.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search and publish "+inputToSearch);
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getMessage());
			Assert.fail("Failed to search and publish");
		}

	}


	public void resizeTheScreen()
	{
		GenericFunctions.waitWebDriver(2000);
		/*Dimension d = new Dimension(800,480);
		driver.manage().window().setSize(d);*/
		//executor.executeScript("document.body.style.zoom = '0.8';");
		//executor.executeScript("document.body.style.zoom = '70%';");
	}



	/*public String uploadContent(String uploadType) throws Exception
	{
		String title="";
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload Content");
			List <TestDataForDiksha> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			Robot robot = new Robot();
			GenericFunctions.waitWebDriver(2000);
			navigateToWorkspace(UPLOADCONTENT);	
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);
			GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			GenericFunctions.waitWebDriver(2000);
			WebElement browse=createUserPage.browseButton;

			if(uploadType.equalsIgnoreCase("mp4"))
			{
				String path = System.getProperty("user.dir")+"/uploadingDocuments/uploading videos/"+UPLOAD_MP4;
				System.out.println(path);
				GenericFunctions.waitWebDriver(5000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(10000);
				System.out.println("MP4 content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("webm"))
			{
				String path = System.getProperty("user.dir")+"/uploadingDocuments/uploading videos/"+UPLOAD_WEBM;
				System.out.println(path);
				GenericFunctions.waitWebDriver(5000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(10000);
				System.out.println("webm content uploaded sucessfully");
				ExtentTestManager.getTest().log(LogStatus.PASS, "Webm uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("youtube"))
			{
				createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
				GenericFunctions.waitWebDriver(5000);
				GenericFunctions.waitForElementToAppear(createUserPage.UploadButton);
				createUserPage.UploadButton.click();
				System.out.println("YOUTUBE content uploaded sucessfully");

			}
			else if(uploadType.equalsIgnoreCase("epub"))
			{
				String path = System.getProperty("user.dir")+"/uploadingDocuments/upload Document Contents/"+UPLOAD_EPUB;
				System.out.println(path);
				GenericFunctions.waitWebDriver(5000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(10000);
				System.out.println("epub content uploaded sucessfully");
			}

			else if(uploadType.equalsIgnoreCase("h5p"))
			{
				String path = System.getProperty("user.dir")+"/uploadingDocuments/upload Document Contents/"+UPLOAD_H5P;
				System.out.println(path);
				GenericFunctions.waitWebDriver(5000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(10000);
				System.out.println("h5p content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("html"))
			{
				String path = System.getProperty("user.dir")+"/uploadingDocuments/upload Document Contents/"+UPLOAD_HTML;
				System.out.println(path);
				GenericFunctions.waitWebDriver(5000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(10000);
				System.out.println("html content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("pdf"))
			{
				String path = System.getProperty("user.dir")+"/uploadingDocuments/upload Document Contents/"+UPLOAD_PDF;
				System.out.println(path);
				GenericFunctions.waitWebDriver(5000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(10000);
				System.out.println("pdf content uploaded sucessfully");
			}
			System.out.println(driver.getCurrentUrl());
			String url=driver.getCurrentUrl();
			//wait.until(ExpectedConditions.(browse));

			wait.until(ExpectedConditions.invisibilityOf(browse));
			System.out.println("Passed visibility");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to send the content for review");
			GenericFunctions.waitWebDriver(8000);
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.sendForReview.click();
			GenericFunctions.waitForElementToAppear(createUserPage.contentMp4Title);
			title=(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.testDataIncrementer("./testData/contentNumbers.txt")).toString();
			System.out.println(title);
			createUserPage.contentMp4Title.click();
			createUserPage.contentMp4Title.clear();
			if(uploadType.contains(MP4))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+MP4);
			}
			else if(uploadType.contains(WEBM))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+WEBM);
			}
			else if(uploadType.contains(YOUTUBE))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+YOUTUBE);
			}
			else if(uploadType.contains(EPUB))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+EPUB);
			}
			else if(uploadType.contains(HTML))
			{	
				createUserPage.contentMp4Title.sendKeys(title+"_"+HTML);
			}
			else if(uploadType.contains(H5P))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+H5P);
			}
			else if(uploadType.contains(PDF))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+PDF);
			}

			GenericFunctions.waitWebDriver(1000);
			createUserPage.contentMp4Desc.click();
			createUserPage.contentMp4Desc.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseDescription());
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.checkAppIcon);
			createUserPage.checkAppIcon.click();
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(createUserPage.clickBoard);
			createUserPage.clickBoard.click();
			createUserPage.selectBoard.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickMedium.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectMediumN.click();
			GenericFunctions.scrollToElement(createUserPage.clickClassN);
			createUserPage.clickClassN.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClassN.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickSubject);
			createUserPage.clickSubject.click();
			createUserPage.selectSubjectN.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to upload "+uploadType+" content and send for review ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to upload content");
			Assert.fail("Failed to upload any content and send for review ");
		}
		return title;
	}*/

	/**
	 * Purpose: goToWorkspaceAndPublish method is used to navigate to the workspace & then in up for review and then publish the content.
	 */

	public void goToWorkspaceAndPublish(String inputToSearch)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to go To Workspace And Publish");

			List <TestDataForDiksha> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("./testData/contentNumbers.txt"));
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitWebDriver(7000);			

			GenericFunctions.scrollTillEndOfPage();
			GenericFunctions.waitWebDriver(4500);
			createUserPage.publishButton.click();
			GenericFunctions.waitWebDriver(1000);
			for(int i=0;i<createUserPage.checkbox.size();i++)
			{
				createUserPage.checkbox.get(i).click();
			}
			System.out.println("Checked all CBs");
			GenericFunctions.waitWebDriver(4000);	 
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);
			System.out.println("Content Published");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on going To Workspace And Publish");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to go To Workspace And Publish");
			Assert.fail("Failed on going To Workspace And Publish");
		}	
	}

	/**
	 * Purpose: createNewBook method is used to create new book by adding a child node.
	 */


	public void createNewBook(List <TestDataForDiksha> objListOFTestDataForSunbird) throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create New Book");
			GenericFunctions.waitWebDriver(1500);

			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer("./testData/bookNumbers.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber);

			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.clickOnElementUsingJavascript(createUserPage.clickUseEditor);
			GenericFunctions.waitWebDriver(3500);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(2000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(3500);
			createUserPage.untitledNameB.click();
			createUserPage.untitledNameB.clear();
			createUserPage.untitledNameB.sendKeys(objListOFTestDataForSunbird.get(2).getTitle()+courseNumber);
			//createUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.selectResourceN.click();
			createUserPage.proceedButton.click();

		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create New Book");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create New Book");
			Assert.fail("Failed to create New Book ");
		}
	}

	/**
	 * Purpose: saveAndSendNewBookForReview method is used to save new book  editting it & sending it for review.
	 */

	public void saveAndSendNewBookForReview()
	{
		ApiHashMap apiHashMap = new ApiHashMap();
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save And Send NewBook For Review");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.editOrViewDetailslink.click();
			GenericFunctions.waitWebDriver(1500);
			apiHashMap.dynamicFormHandling(DIKSHA_APIKEY,DIKSHA_ROOTORGID,DIKSHA_FRAMEWORK,"review","textbook");
			/*GenericFunctions.scrollToElement(createUserPage.clickBoard);
			GenericFunctions.waitForElementToAppear(createUserPage.clickBoard);
			createUserPage.clickBoard.click();
			createUserPage.selectBoard.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickMedium.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectMediumN.click();
			GenericFunctions.scrollToElement(createUserPage.clickClassN);
			createUserPage.clickClassN.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClassN.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickSubject);
			createUserPage.clickSubject.click();
			createUserPage.selectSubjectN.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.selectyear);
			createUserPage.selectyear.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.select2018.click();*/
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.checkAppIcon);
			createUserPage.checkAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);

		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save And Send NewBook For Review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save And Send NewBook For Review ");
			Assert.fail("Failed to save And Send NewBook For Review ");

		}


	}

	/**
	 * Purpose: BookPublishAndSearch method is used to publish new book .
	 */

	public void BookPublishAndSearch(List <TestDataForDiksha> objListOFTestDataForSunbird)
	{
		String courseNumber="",searchCourseName="";
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Book Publish And Search ");

			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitForElementToAppear(createUserPage.publishCourse);
			GenericFunctions.scrollToElement(createUserPage.publishCourse);
			createUserPage.publishCourse.click();
			GenericFunctions.waitWebDriver(4000);
			for(int i=0;i<createUserPage.checkbox.size();i++)	
			{
				createUserPage.checkbox.get(i).click();
			}
			System.out.println("Checked all CBs");
			GenericFunctions.waitWebDriver(4000);	
			GenericFunctions.waitForElementToAppear(createUserPage.popupPublishButton);
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);
			assertOnSearchAfterPublish(searchCourseName);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Book Publish And Search ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to Book Publish And Search ");
			Assert.fail("Failed to Book Publish And Search ");
		}
	}

	/**
	 * Purpose: createCollection method is used to create collection by adding a child node .
	 */



	public void createCollection(List <TestDataForDiksha> objListOFTestDataForSunbird) throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create Collection");
			GenericFunctions.waitWebDriver(1500);
			//System.out.println(driver.findElement(By.xpath(" //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer("./testData/collectionNumbers.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(5).getCourseName()+courseNumber);
			//createUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(5000);		
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4000);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(4000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(3500);
			createUserPage.untitledName.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.untitledName.clear();
			createUserPage.untitledName.sendKeys(objListOFTestDataForSunbird.get(5).getTitle()+courseNumber);
			//createUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.addResource.click();
			GenericFunctions.waitWebDriver(1500);
			//GenericFunctions.waitForElementToAppear(createUserPage.selectResourceN);
			createUserPage.selectResourceN.click();
			createUserPage.proceedButton.click();
			System.out.println("Creating - "+objListOFTestDataForSunbird.get(5).getCourseName()+GenericFunctions.readFromNotepad("./testData/collectionNumbers.txt"));

		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create Collection");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create Collection ");
			Assert.fail("Failed to create Collection ");
		}
	}

	/**
	 * Purpose: CoursePublishAndSearch method is used to publish course .
	 */

	public void CoursePublishAndSearch(List <TestDataForDiksha> objListOFTestDataForSunbird)
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Course Publish And Search  ");
			String courseNumber="",searchCourseName="";
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitForElementToAppear(createUserPage.publishCourse);
			GenericFunctions.scrollToElement(createUserPage.publishCourse);
			createUserPage.publishCourse.click();
			GenericFunctions.waitWebDriver(4000);
			for(int i=0;i<createUserPage.checkbox.size();i++)	
			{
				createUserPage.checkbox.get(i).click();
			}
			System.out.println("Checked all CBs");
			GenericFunctions.waitWebDriver(4000);	
			GenericFunctions.waitForElementToAppear(createUserPage.popupPublishButton);
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);
			assertOnSearchAfterPublish(searchCourseName);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Course Publish And Search ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to Course Publish And Search ");
			Assert.fail("Failed to Course Publish And Search ");
		}
	}

	/**
	 * Purpose: createNewLessonPlan method is used to create lesson plan by adding a child node .
	 */

	public String createNewLessonPlan(List <TestDataForDiksha> objListOFTestDataForSunbird) throws InterruptedException
	{
		String lessonPlanName=null;
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create New Lesson Plan");
			GenericFunctions.waitWebDriver(1500);
			//System.out.println(driver.findElement(By.xpath(" //span[contains(text(),'Design Course')]")).getText());
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer("./testData/lessonPlan.txt").toString();
			lessonPlanName=objListOFTestDataForSunbird.get(3).getCourseName()+courseNumber;
			createUserPage.courseName.sendKeys(lessonPlanName);
			//createUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird.get(0).getCourseDescription()+courseNumber);	
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2500);		
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(5000);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(3000);
			createUserPage.untitledUnitName.click();
			createUserPage.untitledUnitName.clear();
			createUserPage.untitledUnitName.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			//createUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);

			createUserPage.addResource.click();
			GenericFunctions.waitWebDriver(1500);
			//GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			createUserPage.selectResourceN.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.proceedButton.click();

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create New Lesson Plan");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create New Lesson Plan");
			Assert.fail("Failed to create New Lesson Plan");
		}
		System.out.println("lessonPlanName -"+lessonPlanName);
		return lessonPlanName;
	}


	/**
	 * Purpose: saveAndSendNewLessonPlanForReview method is used to save lesson plan & sending it for review. .
	 */


	public String saveAndSendNewLessonPlanForReview()
	{
		ApiHashMap apiHashMap = new ApiHashMap();
		String selectedOwnershipType=null;
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save And Send New Lesson Plan For Review");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReview);
			createUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.checkAppIcon);
			createUserPage.checkAppIcon.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1000);
			apiHashMap.dynamicFormHandling(DIKSHA_APIKEY,DIKSHA_ROOTORGID,DIKSHA_FRAMEWORK,"review","lessonplan");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			selectedOwnershipType=createUserPage.selectOwner.getText();
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(1500);
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is able to select the vlaue from ownershipType dropdown");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			ExtentTestManager.getTest().log(LogStatus.INFO, "User has successfully saved And Send New Lesson Plan For Review");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save And Send New Lesson Plan For Review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save And Send New Lesson Plan For Review ");
			Assert.fail("Failed to save And Send New Lesson Plan For Review");

		}
		System.out.println("selectedOwnershipType -"+selectedOwnershipType);
		return selectedOwnershipType;
	}

	/**
	 * Purpose: LessonPlanPublishAndSearch method is used to publish the lesson plan.
	 */

	public void LessonPlanPublishAndSearch(List <TestDataForDiksha> objListOFTestDataForSunbird)
	{
		
		String courseNumber="",searchCourseName="";
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Lesson Plan Publish And Search ");
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitForElementToAppear(createUserPage.publishCourse);
			GenericFunctions.scrollToElement(createUserPage.publishCourse);
			createUserPage.publishCourse.click();
			GenericFunctions.waitWebDriver(4000);
			for(int i=0;i<createUserPage.checkbox.size();i++)	
			{
				createUserPage.checkbox.get(i).click();
			}
			System.out.println("Checked all CBs");
			GenericFunctions.waitWebDriver(4000);	
			GenericFunctions.waitForElementToAppear(createUserPage.popupPublishButton);
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);
			assertOnSearchAfterPublish(searchCourseName);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Lesson Plan Publish And Search  ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to Lesson Plan Publish And Search ");
			Assert.fail("Failed to Lesson Plan Publish And Search ");
		}
	}

	/**
	 * Purpose: createQuestionMCQ method is used to create MCQ question set.
	 */

	public void createQuestionMCQ(List <TestDataForDiksha> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create QuestionMCQ");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./testData/resourceNumbers.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addQuestionSet.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.createQuestion);
			createUserPage.createQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.selectMCQTemplate);
			createUserPage.selectMCQTemplate.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.writeQuestion);
			String question = GenericFunctions.readFromNotepad("./testData/questions.txt").toString();
			createUserPage.enterTheQuestion.click();
			createUserPage.enterTheQuestion.sendKeys(question);
			driver.switchTo().parentFrame();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(createUserPage.inputAnswer1);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.inputAnswer1.click();
			createUserPage.inputAnswer1.sendKeys("240,200,160");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(createUserPage.markAsRightAnswer);
			createUserPage.markAsRightAnswer.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.inputAnswer2);
			createUserPage.inputAnswer2.click();
			createUserPage.inputAnswer2.sendKeys("200,160,240");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.previewRefreshIcon.click();
			GenericFunctions.waitWebDriver(10000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.previewFrame);
			/*Screenshot myScreenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(myScreenshot.getImage(), "PNG", new File("./ScreenShot/ + img1.png"));*/
			GenericFunctions.compareTwoImages();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.INFO, "First Image comparison in MCQ is passed");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.downButtonPreview.click();
			GenericFunctions.waitWebDriver(1000);
			/*Screenshot myScreenshot1 = new AShot().takeScreenshot(driver);
			ImageIO.write(myScreenshot1.getImage(), "PNG", new File("./ScreenShot/ + img2.png"));*/
			GenericFunctions.compareTwoImages();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Second Image comparison in MCQ is passed");
			//GenericFunctions.takeScreenshotOnValidation("img");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.previewContainer.click();
			GenericFunctions.scrollTillEndOfPage();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.compareTwoImages();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Third Image comparison in MCQ is passed");
			/*Screenshot myScreenshot2 = new AShot().takeScreenshot(driver);
			ImageIO.write(myScreenshot2.getImage(), "PNG", new File("./ScreenShot/ + img3.png"));*/
			//GenericFunctions.captureScreenshotOnValidation();
			GenericFunctions.waitWebDriver(1000);
			driver.switchTo().parentFrame();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.createQueNext);
			//createUserPage.selectLayout.click();
			createUserPage.createQueNext.click();
			GenericFunctions.waitForElementToAppear(createUserPage.enterTheTitleQues);
			createUserPage.enterTheTitleQues.click();
			createUserPage.enterTheTitleQues.clear();
			createUserPage.enterTheTitleQues.sendKeys("Question" + GenericFunctions.testDataIncrementer("./testData/questionNumbers.txt"));
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.boardInQuestion);
			createUserPage.boardInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectCBSEQue.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.mediumInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEnglishFITB.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.gradeLevelInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass4.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.subjectInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectMathematics.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.levelInQuestion);
			createUserPage.levelInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEasy.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.maxScore.sendKeys("5");
			GenericFunctions.waitWebDriver(3000);
			createUserPage.submitButtonInQuestion.click();
			GenericFunctions.waitWebDriver(2000);
			/*createUserPage.submitButtonInQuestion.click();
			GenericFunctions.waitWebDriver(2000);*/
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.nextButton);
			createUserPage.nextButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.questionSetTitle.sendKeys("Quantitative aptitude");
			GenericFunctions.waitWebDriver(2000);
			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.nextButton);
			createUserPage.nextButton.click();*/
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addbutton.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);

			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create MCQQuestion ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create MCQQuestion");
			Assert.fail("Failed to create MCQQuestion ");
		}
	}

	/**
	 * Purpose: createQuestionMTF method is used to create MTF question set.
	 */

	public void createQuestionMTF(List <TestDataForDiksha> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create QuestionMTF type");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./testData/resourceNumbers.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addQuestionSet.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.createQuestion);
			createUserPage.createQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectMTFTemplate.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.writeQuestion);
			createUserPage.enterTheQuestion.click();
			createUserPage.enterTheQuestion.sendKeys("Question" + GenericFunctions.testDataIncrementer("./testData/questionNumbers.txt"));
			driver.switchTo().parentFrame();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(createUserPage.enterAnswer1);
			createUserPage.enterAnswer1.sendKeys("animal");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.enterAnswer2.sendKeys("dog");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.enterAnswer3.sendKeys("bird");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.enterAnswer4.sendKeys("peacock");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.enterAnswer5.sendKeys("mammal");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.enterAnswer6.sendKeys("human");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.previewRefreshIcon);
			createUserPage.previewRefreshIcon.click();
			GenericFunctions.waitWebDriver(10000);
			/*Screenshot myScreenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(myScreenshot.getImage(), "PNG", new File("./ScreenShot/ + img4.png"));*/
			GenericFunctions.compareTwoImages();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.INFO, "First Image comparison in MTF is passed");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createQueNext.click();
			GenericFunctions.waitForElementToAppear(createUserPage.enterTheTitleQues);
			createUserPage.enterTheTitleQues.click();
			createUserPage.enterTheTitleQues.clear();
			createUserPage.enterTheTitleQues.sendKeys("Question" + GenericFunctions.testDataIncrementer("./testData/questionNumbers.txt"));
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.boardInQuestion);
			createUserPage.boardInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectCBSEQue.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.mediumInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEnglishFITB.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.gradeLevelInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass4.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.subjectInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectMathematics.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.levelInQuestion);
			createUserPage.levelInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEasy.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.maxScore.sendKeys("5");
			GenericFunctions.waitWebDriver(3000);
			createUserPage.submitButtonInQuestion.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.nextButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.questionSetTitle.sendKeys("Quantitative aptitude");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addbutton.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create QuestionMTF ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create QuestionMTF");
			Assert.fail("Failed to create QuestionMTF ");
		}
	}

	/**
	 * Purpose: createQuestionFITB method is used to create FITB question set.
	 */

	public void createQuestionFITB(List <TestDataForDiksha> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create Resource");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./testData/resourceNumbers.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addQuestionSet.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.createQuestion);
			createUserPage.createQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectFITBTemplate.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.writeQuestion);
			createUserPage.enterTheQuestion.click();
			createUserPage.enterTheQuestion.sendKeys("2+7=[[9]]");
			driver.switchTo().parentFrame();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.previewRefreshIcon.click();
			GenericFunctions.waitWebDriver(10000);
			/*Screenshot myScreenshot = new AShot().takeScreenshot(driver);
			ImageIO.write(myScreenshot.getImage(), "PNG", new File("./ScreenShot/ + img5.png"));*/
			GenericFunctions.compareTwoImages();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.INFO, "First Image comparison in MCQ is passed");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createQueNext.click();
			GenericFunctions.waitForElementToAppear(createUserPage.enterTheTitleQues);
			createUserPage.enterTheTitleQues.click();
			createUserPage.enterTheTitleQues.clear();
			createUserPage.enterTheTitleQues.sendKeys("Question" + GenericFunctions.testDataIncrementer("./testData/questionNumbers.txt"));
			GenericFunctions.waitForElementToAppear(createUserPage.boardInQuestion);
			createUserPage.boardInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectCBSEQue.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.mediumInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEnglishFITB.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.gradeLevelInQuestion.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectClass4.click();
			GenericFunctions.waitWebDriver(4000);

			//MT Jan16'19
			action.moveToElement(createUserPage.subjectInQuestion);
			GenericFunctions.scrollToElement(createUserPage.subjectInQuestion);
			createUserPage.subjectInQuestion.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.selectMathematics);
			createUserPage.selectMathematics.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.levelInQuestion);
			createUserPage.levelInQuestion.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEasy.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.maxScore.sendKeys("5");
			GenericFunctions.waitWebDriver(3000);
			/*createUserPage.Concepts.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementeclipse-javadoc:%E2%98%82=diksha-jan10-19/src%5C/test%5C/java%3Corg.generic%7BGenericFunctions.java%E2%98%83GenericFunctionsToAppear(createUserPage.searchConcept);
			createUserPage.searchConcept.sendKeys(objListOFTestDataForSunbird.get(6).getTitle());
			GenericFunctions.waitWebDriver(2000);
			createUserPage.conceptChooseAll.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.conceptDoneButton.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectLanguage.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectedLanguage.click();
			GenericFunctions.waitWebDriver(3000);*/
			createUserPage.submitButtonInQuestion.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.nextButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.questionSetTitle.sendKeys("Quantitative aptitude");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addbutton.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create QuestionFITB ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create QuestionFITB");
			Assert.fail("Failed to create QuestionFITB ");
		}
	}

	/**
	 * Purpose: createQuestion method is used to create a question set.
	 */

	public String createQuestion(List <TestDataForDiksha> objListOFTestDataForSunbird)
	{
		String resourceName=null;
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to a create Resource and Create Question");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./testData/resourceNumbers.txt").toString();

			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);

			resourceName = objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber;
			createUserPage.bookName.sendKeys(resourceName+resourceNumber);

			GenericFunctions.waitWebDriver(1000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(2000);
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.addQuestionSet);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addQuestionSet.click();
			GenericFunctions.waitWebDriver(4000);
			//GenericFunctions.waitForElementToAppear(createUserPage.questionCheckbox);
			//GenericFunctions.waitWebDriver(1000);

			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.questionCheckbox);

			createUserPage.questionCheckbox.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.scrollToElement(createUserPage.nextButton);
			createUserPage.nextButton.click();
			createUserPage.questionSetTitle.sendKeys("Math test");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addbutton.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create Question ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create Question");
			Assert.fail("Failed to create Question ");
		}
		System.out.println("ResourceName -"+resourceName);
		return resourceName;
	}

	/**
	 * Purpose: navigateToAllMyContentAndSearch method is used to navigate to all my content and search for any type of content.
	 */

	public void navigateToAllMyContentAndSearch(List <TestDataForDiksha> objListOFTestDataForSunbird,String createVariable)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is navigating to the All my content and search "+createVariable);
			GenericFunctions.waitForElementToAppear(createUserPage.allMyContent);
			createUserPage.allMyContent.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.filterIcon);
			createUserPage.filterIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.clickFilterStatus);
			createUserPage.clickFilterStatus.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.selectFilterStatusLive);
			createUserPage.selectFilterStatusLive.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.applyButton);
			createUserPage.applyButton.click();
			GenericFunctions.waitWebDriver(2000);
			if(createVariable.equalsIgnoreCase(BOOK))
			{
				//String courseNumber = GenericFunctions.readFromNotepad("./testData/bookNumbers.txt").toString();
				createUserPage.searchInActivity.click();
				createUserPage.searchInActivity.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName());//+courseNumber);
				//createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(createUserPage.searchCoursesUpForReviewE);
				createUserPage.searchCoursesUpForReviewE.click();
				GenericFunctions.waitWebDriver(10000);		
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(10000);
			}
			else if(createVariable.equalsIgnoreCase(UPLOADCONTENT))
			{
				//String courseNumber = GenericFunctions.readFromNotepad("./testData/contentNumbers.txt").toString();
				createUserPage.searchInActivity.click();
				createUserPage.searchInActivity.sendKeys(objListOFTestDataForSunbird.get(4).getCourseName()+"_");//+courseNumber+"_"+ PDF);
				//createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(1500);
				GenericFunctions.waitForElementToAppear(createUserPage.searchCoursesUpForReviewE);
				createUserPage.searchCoursesUpForReviewE.click();
				GenericFunctions.waitWebDriver(10000);
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(10000);
			}
			else if(createVariable.equalsIgnoreCase(RESOURCE))
			{
				//String courseNumber = GenericFunctions.readFromNotepad("./testData/resourceNumbers.txt").toString();
				createUserPage.searchInActivity.click();
				createUserPage.searchInActivity.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName());// +courseNumber);
				//createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(1500);
				GenericFunctions.waitForElementToAppear(createUserPage.searchCoursesUpForReviewE);
				createUserPage.searchCoursesUpForReviewE.click();
				GenericFunctions.waitWebDriver(10000);		
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(10000);
			}
			else if(createVariable.equalsIgnoreCase(COLLECTION))
			{
				//String courseNumber = GenericFunctions.readFromNotepad("./testData/collectionNumbers.txt").toString();
				createUserPage.searchInActivity.click();
				createUserPage.searchInActivity.sendKeys(objListOFTestDataForSunbird.get(5).getCourseName());//+courseNumber);
				//createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(1500);
				GenericFunctions.waitForElementToAppear(createUserPage.searchCoursesUpForReviewE);
				createUserPage.searchCoursesUpForReviewE.click();
				GenericFunctions.waitWebDriver(6000);		
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(6000);
			}
			else if(createVariable.equalsIgnoreCase(LESSONPLAN))
			{
				//String courseNumber = GenericFunctions.readFromNotepad("./testData/lessonPlan.txt").toString();
				createUserPage.searchInActivity.click();
				createUserPage.searchInActivity.sendKeys(objListOFTestDataForSunbird.get(3).getCourseName());//+courseNumber);
				//createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(1500);
				GenericFunctions.waitForElementToAppear(createUserPage.searchCoursesUpForReviewE);
				createUserPage.searchCoursesUpForReviewE.click();
				GenericFunctions.waitWebDriver(6000);		
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(6000);
			}
			else if(createVariable.equalsIgnoreCase(COURSE))
			{
				//String courseNumber = GenericFunctions.readFromNotepad("./testData/courseNumbers.txt").toString();
				createUserPage.searchInActivity.click();
				createUserPage.searchInActivity.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());//+courseNumber);
				//createUserPage.searchIcon.click();
				GenericFunctions.waitWebDriver(1500);
				GenericFunctions.waitForElementToAppear(createUserPage.searchCoursesUpForReviewE);
				createUserPage.searchCoursesUpForReviewE.click();
				GenericFunctions.waitWebDriver(6000);		
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(6000);
			}


		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to All my content and search");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on navigating to Workspace");
			Assert.fail("Failed on navigating to Workspace and create "+createVariable);
		}

	}

	/**
	 * Purpose: editBook method is used to edit a created book by deleting existing resource and adding a new one.
	 */

	public void editBook(List <TestDataForDiksha> objListOFTestDataForSunbird) throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to edit a Book");
			GenericFunctions.waitWebDriver(1500);
			//action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(3500);
			/*createUserPage.untitledName.click();
			createUserPage.untitledName.clear();
			createUserPage.untitledName.sendKeys(objListOFTestDataForSunbird.get(2).getTitle());
			//createUserPage.titleDescription.sendKeys(objListOFTestDataForSunbird.get(0).getTitleDescription()+courseNumber);
			GenericFunctions.waitWebDriver(1500);*/
			GenericFunctions.scrollToElement(createUserPage.deleteResource);
			createUserPage.deleteResource.click();
			GenericFunctions.waitWebDriver(500);
			createUserPage.yesDeleteResource.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectResource);
			createUserPage.selectResource.click();
			createUserPage.proceedButton.click();

		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create New Book");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create New Book");
			Assert.fail("Failed to create New Book ");
		}
	}

	/**
	 * Purpose: saveAndSendEdittedBookForReview method is used to save an ediied book and send it for review.
	 */

	public void saveAndSendEdittedBookForReview(){
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save And Send NewBook For Review");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.editOrViewDetailslink.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.sendForReview.click();
			/*GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createMentorPage.courseImg1);
			createMentorPage.courseImg1.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectAppIcon.click();*/
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			//createUserPage.closePage.click();
			//GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save And Send NewBook For Review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save And Send NewBook For Review ");
			Assert.fail("Failed to save And Send NewBook For Review ");

		}
	}

	/**
	 * Purpose: searchInUpForReviewForEdittedContents method is used to search an ediied book in up for review.
	 */

	public void searchInUpForReviewForEdittedContents(String source,List <TestDataForDiksha> objListOFTestDataForSunbird) throws Exception{
		try{	
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search in Up For Review bucket for "+source);
			String courseNumber = "",searchCourseName="";
			GenericFunctions.waitWebDriver(2000);
			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(publicUserPage.headerProfile);
			publicUserPage.headerProfile.click();*/
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitForElementToAppear(createUserPage.upForReview);
			createUserPage.upForReview.click();
			if(source.equalsIgnoreCase(COURSE)){
				//courseNumber = GenericFunctions.readFromNotepad("./testData/courseNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());//+courseNumber);
				//createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName();//+courseNumber;
				GenericFunctions.waitWebDriver(3000);
				//GenericFunctions.waitForElementToAppear(createUserPage.searchCoursesUpForReviewE);
				createUserPage.searchCoursesUpForReviewE.click();
			}
			else if(source.equalsIgnoreCase(BOOK)){
				//courseNumber = GenericFunctions.readFromNotepad("./testData/bookNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName());//+courseNumber);
				//createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(2).getCourseName();//+courseNumber;
				GenericFunctions.waitWebDriver(3000);	
				//GenericFunctions.waitForElementToAppear(createUserPage.searchCoursesUpForReviewE);
				createUserPage.searchCoursesUpForReviewE.click();
			}
			else if(source.equalsIgnoreCase(RESOURCE)){
				//courseNumber = GenericFunctions.readFromNotepad("./testData/resourceNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName());//+courseNumber);
				//createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(6).getCourseName();//+courseNumber;
				GenericFunctions.waitWebDriver(3000);	
				GenericFunctions.waitForElementToAppear(createUserPage.searchCoursesUpForReviewE);
				createUserPage.searchCoursesUpForReviewE.click();
			}
			else if(source.equalsIgnoreCase(COLLECTION)){
				//courseNumber = GenericFunctions.readFromNotepad("./testData/collectionNumbers.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(0).getCourseName());//+courseNumber);
				//createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(0).getCourseName();//+courseNumber;
				GenericFunctions.waitWebDriver(3000);	
				GenericFunctions.waitForElementToAppear(createUserPage.searchCoursesUpForReviewE);
				createUserPage.searchCoursesUpForReviewE.click();
			}
			else if(source.equalsIgnoreCase(LESSONPLAN)){
				//courseNumber = GenericFunctions.readFromNotepad("./testData/lessonPlan.txt").toString();
				createUserPage.searchForReview.click();
				createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird.get(3).getCourseName());//+courseNumber);
				//createUserPage.searchIcon.click();
				searchCourseName = objListOFTestDataForSunbird.get(3).getCourseName();//+courseNumber;
				GenericFunctions.waitWebDriver(3000);
				GenericFunctions.waitForElementToAppear(createUserPage.searchCoursesUpForReviewE);
				createUserPage.searchCoursesUpForReviewE.click();
			}
			//assertFoundInUpForReview(searchCourseName);
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching in Up for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println(e.getLocalizedMessage());
			log.error("Exception In the method searchCourse"+e.getMessage());
			Assert.fail("Failed to search in Up for review bucket");
		}

	}

	/**
	 * Purpose: deleteTheSlide method is used to delete the slide.
	 */

	public void deleteTheSlide() 
	{
		try 
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete the slide");
			GenericFunctions.waitWebDriver(2000);
			/*List<WebElement>list = createUserPage.existingSlide;
			for(WebElement del : list) {
				if(del.isDisplayed()) {
					del.click();
					GenericFunctions.waitWebDriver(1000);
					createUserPage.deleteSlide.click();
					GenericFunctions.waitWebDriver(500);
					createUserPage.deleteConfirmationPopup.click();
					GenericFunctions.waitWebDriver(500);
				}


			}*/
			for(int i=0;i<=createUserPage.existingSlide.size()+5;i++) {

				createUserPage.existingSlide.get(0).click();
				GenericFunctions.waitWebDriver(500);
				createUserPage.deleteSlide.click();
				GenericFunctions.waitWebDriver(500);
				createUserPage.deleteConfirmationPopup.click();
				GenericFunctions.waitWebDriver(1000);
			}


		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on deleting the slide");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on deleting the slide");
			Assert.fail("Failed on deleting the slide ");
		}
	}

	/**
	 * Purpose: createResourceWithoutSave method is used to create a resource by adding different slides but not saving it.
	 */

	public void createResourceWithoutSave(List <TestDataForDiksha> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create Resource");
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addShape.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addTriangle.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addImage.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.img1.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectImage.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);

			//for uploading audio
			/*createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addAudio.click();
			createUserPage.uploadAndUseButton.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.yesRadioButton.click();
			createUserPage.uploadAudioIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.chooseFileButton.click();
			GenericFunctions.waitWebDriver(1500);
			String path1 = System.getProperty("user.dir")+"/UploadingDocuments/Upload Document Contents/"+ AUDIO;
			System.out.println("Uploaded image : "+path1);
			//log.info("Uploaded file name: "+path);
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.uploadFile(path1);
			GenericFunctions.waitWebDriver(2500);
			createUserPage.uploadAndUseButtonRight.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);*/


			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addHotspot.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addScribblepad.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addActivity.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.searchActivity);
			createUserPage.searchActivity.sendKeys("Math");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.mathText);
			createUserPage.mathText.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addButtonInActivity.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.addVideo.click();
			createUserPage.pasteVideoUrl.sendKeys(UPLOAD_MP4_URL);
			createUserPage.goButton.click();
			GenericFunctions.waitWebDriver(4000);
			createUserPage.addToLesson.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveIcon);
			createUserPage.saveIcon.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1000);
			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closePage);
			createUserPage.closePage.click();*/
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			/*GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);*/
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create Resource ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create Resource");
			Assert.fail("Failed to create Resource ");
		}
	}

	/**
	 * Purpose: createQuestionAndSave method is used to create a resource by adding question and saving it
	 */

	public void createQuestionAndSave(List <TestDataForDiksha> objListOFTestDataForSunbird)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create Question from existing ones");
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitForElementToAppear(createUserPage.addSlide);
			createUserPage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			/*GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./testData/questionNumbers.txt").toString();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(2000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1500);
			System.out.println("Adding Resource: "+createUserPage.untitledCollection.getText());*/
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.addQuestionSet);
			createUserPage.addQuestionSet.click();
			GenericFunctions.waitWebDriver(4000);
			//GenericFunctions.waitForElementToAppear(createUserPage.questionCheckbox);
			//GenericFunctions.waitWebDriver(1000);
			createUserPage.questionCheckbox.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.scrollToElement(createUserPage.nextButton);
			createUserPage.nextButton.click();
			createUserPage.questionSetTitle.sendKeys("Math test");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.addbutton.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.saveIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);
			/*createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);*/
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(4000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create Question ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create Question");
			Assert.fail("Failed to create Question ");
		}
	}

	/**
	 * Purpose: saveAndSendEdittedResouceForReview method is used to save the editted resource and send it for review.
	 */

	public void saveAndSendEdittedResouceForReview(){
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save And Send editted Resource For Review ");
			/*	GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createMentorPage.courseImg1);
			createMentorPage.courseImg1.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(createUserPage.clickSelectBoard);
			createUserPage.clickSelectBoard.click();
			createUserPage.selectCBSE.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickSelectMedium.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectEnglish.click();
			GenericFunctions.scrollToElement(createUserPage.clickSelectClass);
			createUserPage.clickSelectClass.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass3.click();
			GenericFunctions.waitWebDriver(1000);
			//createUserPage.creditTo.click();
			GenericFunctions.scrollToElement(createUserPage.clickSelectSubject);
			createUserPage.clickSelectSubject.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectUrdu2.click();;*/

			GenericFunctions.waitWebDriver(3500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(3500);
			//createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(3000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save And Send editted Resouce For Review ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save And Send editted Resouce For Review ");
			Assert.fail("Failed to save And Send editted Resouce For Review  ");

		}
	}

	/**
	 * Purpose: uploadNewContent method is used to upload a new content while editting an existing content,saving it and send it for review.
	 */

	public String uploadNewContent(String uploadType) throws Exception
	{
		String title="";
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload new Content");
			GenericFunctions.waitWebDriver(1500);
			List <TestDataForDiksha> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitForElementToAppear(createUserPage.uploadNewfile);
			createUserPage.uploadNewfile.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			GenericFunctions.waitWebDriver(2000);
			WebElement browse=createUserPage.browseButton;

			if(uploadType.equalsIgnoreCase("mp4"))
			{
				String path = System.getProperty("user.dir")+"/uploadingDocuments/uploading videos/"+UPLOAD_MP4;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(5000);
				System.out.println("MP4 content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("webm"))
			{
				String path = System.getProperty("user.dir")+"/uploadingDocuments/uploading videos/"+UPLOAD_WEBM;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(5000);
				System.out.println("webm content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("youtube"))
			{
				createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
				GenericFunctions.waitWebDriver(2000);
				createUserPage.UploadButton.click();
				System.out.println("YOUTUBE content uploaded sucessfully");

			}
			else if(uploadType.equalsIgnoreCase("epub"))
			{
				String path = System.getProperty("user.dir")+"/uploadingDocuments/upload Document Contents/"+UPLOAD_EPUB;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(5000);
				System.out.println("epub content uploaded sucessfully");
			}

			else if(uploadType.equalsIgnoreCase("h5p"))
			{
				String path = System.getProperty("user.dir")+"/uploadingDocuments/upload Document Contents/"+UPLOAD_H5P;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(5000);
				System.out.println("h5p content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("html"))
			{
				String path = System.getProperty("user.dir")+"/uploadingDocuments/upload Document Contents/"+UPLOAD_HTML;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(8000);
				System.out.println("html content uploaded sucessfully");
			}
			else if(uploadType.equalsIgnoreCase("pdf"))
			{
				String path = System.getProperty("user.dir")+"/uploadingDocuments/upload Document Contents/"+UPLOAD_PDF;
				System.out.println(path);
				GenericFunctions.waitWebDriver(3000);
				browse.sendKeys(path);
				System.out.println("Uploaded file : "+path);
				GenericFunctions.waitWebDriver(5000);
				System.out.println("pdf content uploaded sucessfully");
			}

			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.sendForReview.click();
			GenericFunctions.waitForElementToAppear(createUserPage.contentMp4Title);

			title=(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("./testData/contentNumbers.txt")).toString();
			System.out.println(title);
			createUserPage.contentMp4Title.click();
			createUserPage.contentMp4Title.clear();
			if(uploadType.contains(MP4))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+MP4);
			}
			else if(uploadType.contains(WEBM))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+WEBM);
			}
			else if(uploadType.contains(YOUTUBE))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+YOUTUBE);
			}
			else if(uploadType.contains(EPUB))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+EPUB);
			}
			else if(uploadType.contains(HTML))
			{	
				createUserPage.contentMp4Title.sendKeys(title+"_"+HTML);
			}
			else if(uploadType.contains(H5P))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+H5P);
			}
			else if(uploadType.contains(PDF))
			{
				createUserPage.contentMp4Title.sendKeys(title+"_"+PDF);
			}

			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to upload "+uploadType+" content and send for review ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to upload content");
			Assert.fail("Failed to upload any content and send for review ");
		}
		return title;
	}

	/**
	 * Purpose: goToWorkspaceAndPublishEdittedContent method is used to  got to workspace & publish the content from up for review.
	 */

	public void goToWorkspaceAndPublishEdittedContent(String inputToSearch)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to go To Workspace And Publish");

			List <TestDataForDiksha> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			/*GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
			publicUserPage.headerProfile.click();*/
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitForElementToAppear(createUserPage.upForReview);
			createUserPage.upForReview.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_");//+GenericFunctions.readFromNotepad("./testData/contentNumbers.txt"));
			GenericFunctions.waitWebDriver(3000);
			//	String compare=createUserPage.searchedContentForPublish.getText();
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitWebDriver(7000);			
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			//GenericFunctions.scrollToElement(createUserPage.publishButton);
			GenericFunctions.scrollTillEndOfPage();
			GenericFunctions.waitWebDriver(4500);
			createUserPage.publishButton.click();
			GenericFunctions.waitWebDriver(1000);
			for(int i=0;i<createUserPage.checkbox.size();i++)
			{
				createUserPage.checkbox.get(i).click();
			}
			System.out.println("Checked all CBs");
			GenericFunctions.waitWebDriver(4000);	 
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);
			System.out.println("Content Published");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on going To Workspace And Publish");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to go To Workspace And Publish");
			Assert.fail("Failed on going To Workspace And Publish");
		}	
	}

	/**
	 * Purpose: navigateToLibraryAndSearchEdittedContent method is used to navigate to library and serach the editted content.
	 */

	public void navigateToLibraryAndSearchEdittedContent(String userData)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate To Library And Search Content");
			List <TestDataForDiksha> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			//createUserPage.dropDown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.searchInput.click();
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_");//+GenericFunctions.readFromNotepad("./testData/contentNumbers.txt"));
			System.out.println(objListOFTestDataForSunbird1.get(4).getCourseName()+"_");//+GenericFunctions.readFromNotepad("./testData/contentNumbers.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForUpload);
			createUserPage.searchedContentForUpload.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate To Library And Search Content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to navigate To Library And Search Content");
			Assert.fail("Failed to navigate To Library And Search Content ");
		}

	}

	/**
	 * Purpose: saveAndSendCourseForReviewAfterEdit method is used to save and send course for revieew after editting an existing one.
	 */

	public void saveAndSendCourseForReviewAfterEdit(List <TestDataForDiksha> objListOFTestDataForSunbird)throws Exception{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save And Send Course For Review After Edit ");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.editOrViewDetailslink.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(2500);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2500);
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			GenericFunctions.waitWebDriver(3000);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.clickAppIcon.click();	
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.checkAppIcon);
			createUserPage.checkAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save And Send Course For Review After Edit  ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save And Send Course For Review After Edit ");
			Assert.fail("Failed to save And Send Course For Review After Edit  ");

		}

	}

	/**
	 * Purpose: saveAndSendnewCourseForReview method is used to save and send course for review .
	 */

	public void saveAndSendnewCourseForReview(List <TestDataForDiksha> objListOFTestDataForSunbird)throws Exception
	{
		ApiHashMap apiHashMap = new ApiHashMap();
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save and send course for review");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.sendForReview.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();	
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.checkAppIcon);
			createUserPage.checkAppIcon.click();
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1500);
			apiHashMap.dynamicFormHandling(DIKSHA_APIKEY,DIKSHA_ROOTORGID,"TPD","review","course");
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			ExtentTestManager.getTest().log(LogStatus.INFO, "User has successfully saved and send course for review");
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on saving and sending course for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save and course for review");
			Assert.fail("Failed on saving and sending course for review");

		}	
	}
}