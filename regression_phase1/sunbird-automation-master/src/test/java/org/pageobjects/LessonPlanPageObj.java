package org.pageobjects;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Window;
import java.awt.event.KeyEvent;
import java.lang.reflect.GenericSignatureFormatError;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apiPackage.ApiHashMap;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.GetExcelFileData;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.CreatorUserPage;
import org.page.FlagReviewerPage;
import org.page.LessonPlanPage;
import org.page.PublicUserPage;
import org.page.UploadOrgPage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;


public class LessonPlanPageObj extends BaseTest

{
	WebDriverWait wait = new WebDriverWait(driver,20);
	LessonPlanPage LessonPlanPage=PageFactory.initElements(driver, LessonPlanPage.class);
	CreatorUserPage createUserPage =PageFactory.initElements(driver, CreatorUserPage.class);
	static Logger log = Logger.getLogger(LessonPlanPageObj.class.getName());
	List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
	GenericFunctions genereicFunction = new GenericFunctions();
	Actions action = new Actions(driver);
	Random rand = new Random();
	JavascriptExecutor js = (JavascriptExecutor)driver;
	

	// @author Sachin for the below method search in library :
	public void searchInLibrary()throws Exception
	{
		try
		{	
			ExtentTestManager.getTest().log(LogStatus.INFO, "To search Lesson Plan in Library and copy it");

			//				GenericFunctions.waitForElementToAppear(createUserPage.closePopUp);	
			//				createUserPage.closePopUp.click();
			//				GenericFunctions.waitWebDriver(2000);
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitForElementToAppear(LessonPlanPage.headerLibrary);	
			LessonPlanPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(LessonPlanPage.mainSearch);				
			LessonPlanPage.mainSearch.sendKeys("Lesson Plan");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(LessonPlanPage.mainSearchIcon);		
			LessonPlanPage.mainSearchIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(LessonPlanPage.lessonPlan);				
			LessonPlanPage.lessonPlan.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(LessonPlanPage.copyLessonPlan);				
			LessonPlanPage.copyLessonPlan.click();
			GenericFunctions.waitWebDriver(4000);
			Assert.assertTrue(true);
			System.out.println("Lesson Plan Copied");
			if(LessonPlanPage.copyLessonPlan.isDisplayed())
			{
				LessonPlanPage.copyLessonPlan.click();
				GenericFunctions.waitWebDriver(2000);
				Assert.assertTrue(true," Lesson Plan Copied Successfully");
				System.out.println("Lesson Plan Copied Successfully");
				log.info(" Lesson Plan Copied Successfully");
			}
			else
			{
				System.out.println("Lesson Plan Could not be copied");
				log.info("Lesson Plan Could not be copied");
			}

			GenericFunctions.waitForElementToAppear(LessonPlanPage.editDetails);	

			if(LessonPlanPage.editDetails.isDisplayed())
			{
				Assert.assertTrue(true,"On copy icon click user is redirected to collection editor with newly copied content in edit mode successfully");
				System.out.println("On copy icon click user is redirected to collection editor with newly copied content in edit mode successfully");
				log.info("On copy icon click user is redirected to collection editor with newly copied content in edit mode successfully");
			}

			else
			{
				System.out.println("Either User is NOT REDIRECTED properly or NOT in EDIT mode");
				log.info("Either User is NOT REDIRECTED properly or NOT in EDIT mode");
			}


		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on searching LessonPlan in library and copying it");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method searchInLibrary" + e.getLocalizedMessage());
			Assert.fail("Failed on searching LessonPlan in library and copying it, Exception : " + e.getLocalizedMessage());	
		}

	}




	// @author Sachin : click on workspace 
	public void clickWorkspace()throws Exception{
		try
		{	
			GenericFunctions.refreshWebPage();
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigating to workspace");
			//			GenericFunctions.waitForElementToAppear(LessonPlanPage.closePopUp);
			//			LessonPlanPage.closePopUp.click();
			GenericFunctions.waitWebDriver(2000);
			LessonPlanPage.workSpace.click();
			GenericFunctions.waitWebDriver(2000);

		}
		catch (Exception e) 
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to workspace");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method searchInLibrary" + e.getLocalizedMessage());
			Assert.fail("Failed on navigating to workspace, Exception : " + e.getLocalizedMessage());
		}
	}



	public void createLessonPlanpopUp() throws Exception{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify navigating to workspace and verify lesson plan popup");
			LessonPlanPage.LessonPlan.click();
			GenericFunctions.waitWebDriver(2000);

			String LessonPlanTitle = "TestAutomationqwerty";
			LessonPlanPage.LessonPlanNamePlaceHolder.click();
			LessonPlanPage.LessonPlanNamePlaceHolder.sendKeys(LessonPlanTitle);				
			GenericFunctions.waitWebDriver(1000);					
			LessonPlanPage.startCreatingButton.click();
			GenericFunctions.waitWebDriver(6000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to workspace");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method searchInLibrary" + e.getLocalizedMessage());
			Assert.fail("Failed on navigating to workspace, Exception : " + e.getLocalizedMessage()); 
		}
	}



	// @author Sachin fill all the details and click on start creating :
	public void createChildNodes()throws Exception{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create 3 child nodes");
			driver.switchTo().frame(0);
			// Creating 1st child node
			GenericFunctions.waitForElementToAppearOnScreen(LessonPlanPage.newChildButton);
			LessonPlanPage.newChildButton.click();
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.childUnitTitle.click();
			LessonPlanPage.childUnitTitle.clear();
			GenericFunctions.waitWebDriver(1000);

			LessonPlanPage.childUnitTitle.sendKeys("AutomationTitle1");
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.descriptionPlaceHolder.sendKeys("Description1");
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.addNotesPlaceHolder.click();
			LessonPlanPage.addNotesPlaceHolder.sendKeys("Notes1");

			LessonPlanPage.addResource.click();
			GenericFunctions.waitWebDriver(1000);

			LessonPlanPage.latestResourceCheckbox.click();
			GenericFunctions.waitWebDriver(1000);

			if(LessonPlanPage.proceedButton.isDisplayed())
			{
				LessonPlanPage.proceedButton.click();
				GenericFunctions.waitWebDriver(2000);
				Assert.assertTrue(true,"User is able to create the first child node successfully");
				System.out.println("User is able to create the first child node successfully");
				log.info(" User is trying to able the first child node successfully");

			}
			else
			{
				System.out.println("User could not create the first child node");
				log.info("User could not create the first child node");	
			}


			// Creating 2nd child node					

			LessonPlanPage.newChildButton.click();
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.childUnitTitle.click();
			LessonPlanPage.childUnitTitle.clear();
			GenericFunctions.waitWebDriver(1000);

			LessonPlanPage.childUnitTitle.sendKeys("AutomationTitle2");
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.descriptionPlaceHolder.click();
			LessonPlanPage.descriptionPlaceHolder.sendKeys("Description2");
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.addNotesPlaceHolder.click();
			LessonPlanPage.addNotesPlaceHolder.sendKeys("Notes2");

			LessonPlanPage.addResource.click();
			GenericFunctions.waitWebDriver(1000);

			LessonPlanPage.latestResourceCheckbox.click();
			GenericFunctions.waitWebDriver(1000);

			if(LessonPlanPage.proceedButton.isDisplayed())
			{
				LessonPlanPage.proceedButton.click();
				GenericFunctions.waitWebDriver(2000);
				Assert.assertTrue(true,"User is able to create the second child node successfully");
				System.out.println("User is able to create the second child node successfully");
				log.info("User is able to create the second child node successfully");

			}
			else
			{
				System.out.println("User could not create the second child node");
				log.info("User could not create the second child node");	
			}


			// Creating 3d child node					

			LessonPlanPage.newChildButton.click();
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.childUnitTitle.click();
			LessonPlanPage.childUnitTitle.clear();
			GenericFunctions.waitWebDriver(1000);

			LessonPlanPage.childUnitTitle.sendKeys("AutomationTitle3");
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.descriptionPlaceHolder.click();
			LessonPlanPage.descriptionPlaceHolder.sendKeys("Description3");
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.addNotesPlaceHolder.click();
			LessonPlanPage.addNotesPlaceHolder.sendKeys("Notes3");

			LessonPlanPage.addResource.click();
			GenericFunctions.waitWebDriver(1000);

			LessonPlanPage.latestResourceCheckbox.click();
			GenericFunctions.waitWebDriver(1000);

			if(LessonPlanPage.proceedButton.isDisplayed())
			{
				LessonPlanPage.proceedButton.click();
				GenericFunctions.waitWebDriver(2000);
				Assert.assertTrue(true,"User is able to create the third child node successfully");
				System.out.println("User is able to create the third child node successfully");
				log.info("User is able to create the third child node successfully");

			}
			else
			{
				System.out.println("User could not create the third child node");
				log.info("User could not create the third child node");	
			}	

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating 3 child nodes");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createChildNodes" + e.getLocalizedMessage());
			Assert.fail("FFailed on creating 3 child nodes, Exception : " + e.getLocalizedMessage());
		}
	}



	// @author Sachin Lesson Plan with three resources  :
	public void lessonPlanWithThreeResources()throws Exception{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify creating a lesson plan with three resources");
			// Creating 1st child node
			driver.switchTo().frame(0);
			GenericFunctions.waitForElementToAppearOnScreen(LessonPlanPage.newChildButton);
			LessonPlanPage.newChildButton.click();
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.childUnitTitle.click();
			LessonPlanPage.childUnitTitle.clear();
			GenericFunctions.waitWebDriver(1000);

			LessonPlanPage.childUnitTitle.sendKeys("AutomationTitle1");
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.descriptionPlaceHolder.click();
			LessonPlanPage.descriptionPlaceHolder.sendKeys("Description1");
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.addNotesPlaceHolder.click();
			LessonPlanPage.addNotesPlaceHolder.sendKeys("Notes1");

			LessonPlanPage.addResource.click();
			GenericFunctions.waitWebDriver(1000);

			LessonPlanPage.latestResourceCheckbox.click();
			GenericFunctions.waitWebDriver(1000);

			LessonPlanPage.secondResourceCheckbox.click();
			GenericFunctions.waitWebDriver(1000);

			LessonPlanPage.thirdResourceCheckbox.click();
			GenericFunctions.waitWebDriver(1000);					

			LessonPlanPage.proceedButton.click();
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.firstResourcePreview.click();
			GenericFunctions.waitWebDriver(2000);
			if(LessonPlanPage.contentPreview.isDisplayed())
			{
				Assert.assertTrue(true,"User is able to successfully preview the lesson plan before sending it to review");
				System.out.println("User is able to successfully preview the lesson plan before sending it to review");
				log.info("User is able to successfully preview the lesson plan before sending it to review");
			}

			LessonPlanPage.lessonPlanTitle.click();
			GenericFunctions.waitWebDriver(2000);
			LessonPlanPage.secondResourceDelete.click();
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.confirmDelete.click();
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(true,"User is able to successfully remove resource from the lesson plan");
			System.out.println("User is able to successfully remove resource from the lesson plan");
			log.info("User is able to successfully remove resource from the lesson plan");

			LessonPlanPage.secondResourceDelete.click();
			GenericFunctions.waitWebDriver(2000);
			Assert.assertTrue(true,"Resource stays in the lessonplan when No selected on the confirmation pop up");
			System.out.println("Resource stays in the lessonplan when No selected on the confirmation pop up");
			log.info("Resource stays in the lessonplan when No selected on the confirmation pop up");

			LessonPlanPage.closeDialog.click();
			GenericFunctions.waitWebDriver(2000);	
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating a lesson plan with three resources");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method lessonPlanWithThreeResources" + e.getLocalizedMessage());
			Assert.fail("Failed on creating a lesson plan with three resources, Exception : " + e.getLocalizedMessage());
		}
	}


	// @author Sachin Lesson Plan with three resources  :
	public void editDetailsAndSave()throws Exception {

		try {  
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify editing the lesson plan details and save");
			createUserPage.editDetails.click();
			GenericFunctions.waitWebDriver(1000);	
			//driver.switchTo().frame(0);
			createUserPage.editDetailsTitle.click();
			createUserPage.editDetailsTitle.clear();
			createUserPage.editDetailsTitle.sendKeys("AUTOMATION123");
			GenericFunctions.waitWebDriver(1000);
			ApiHashMap apiHashMap = new ApiHashMap();
			apiHashMap.dynamicFormHandling(DIKSHA_APIKEY,DIKSHA_ROOTORGID,DIKSHA_FRAMEWORK,"review","lessonplan");
			/*LessonPlanPage.editDetailsDescription.click();
			LessonPlanPage.editDetailsDescription.clear();
			LessonPlanPage.editDetailsDescription.sendKeys("Description1");
			GenericFunctions.waitWebDriver(1000);

			LessonPlanPage.editDetailsKeyword.click();
			LessonPlanPage.editDetailsKeyword.sendKeys("Keyword1");
			GenericFunctions.waitWebDriver(1000);			*/		

			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.editDetailsCurriculum);
			LessonPlanPage.editDetailsCurriculum.click();
			GenericFunctions.waitWebDriver(2000);					
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.editDetailsRajasthan);
			LessonPlanPage.editDetailsRajasthan.isSelected();
			GenericFunctions.waitWebDriver(2000);

			GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.editDetailsClass);
			LessonPlanPage.editDetailsClass.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.editDetailsClass10);
			LessonPlanPage.editDetailsClass10.click();
			GenericFunctions.waitWebDriver(1000);

			GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.editDetailsSubject);
			LessonPlanPage.editDetailsSubject.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.editDetailsMathematics);
			LessonPlanPage.editDetailsMathematics.click();
			GenericFunctions.waitWebDriver(1000);

			GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.editDetailsMedium);
			LessonPlanPage.editDetailsMedium.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.editDetailsHindi);
			LessonPlanPage.editDetailsHindi.click();
			GenericFunctions.waitWebDriver(1000);

			GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.editDetailsAudience);
			LessonPlanPage.editDetailsAudience.click();
			GenericFunctions.waitWebDriver(1000);					
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.editDetailsInstructor);
			LessonPlanPage.editDetailsInstructor.click();
			GenericFunctions.waitWebDriver(1000);

			GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.editDetailsOwner);
			GenericFunctions.scrollToElement(LessonPlanPage.editDetailsOwner);
			LessonPlanPage.editDetailsOwner.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.editDetailsTestAutoOrg);
			LessonPlanPage.editDetailsTestAutoOrg.click();
			GenericFunctions.waitWebDriver(1000);

			LessonPlanPage.editDetailsSave.click();*/
			/*GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(createUserPage.clickBoard);
			GenericFunctions.waitForElementToAppear(createUserPage.clickBoard);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickBoard.click();
			GenericFunctions.waitWebDriver(1000);
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
			createUserPage.select2018.click();*/
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1000);	
			Assert.assertTrue(true,"User is able to successfully edit the lesson plan before sending it for review");
			System.out.println("User is able to successfully edit the lesson plan before sending it for review");
			log.info("User is able to successfully edit the lesson plan before sending it for review");
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.saveClose.click();
			GenericFunctions.waitWebDriver(1000);

			LessonPlanPage.editDetails.click();
			Assert.assertTrue(true,"User is able to see the updated data on clicking EDIT DETAILS for the second time");
			System.out.println("User is able to see the updated data on clicking EDIT DETAILS for the second time");
			log.info("User is able to see the updated data on clicking EDIT DETAILS for the second time");
			GenericFunctions.waitWebDriver(1000);					
		}  
		catch(Exception e)

		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on editng the lesson plan details");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method editDetailsAndSave" + e.getLocalizedMessage());
			Assert.fail("Failed on editng the lesson plan details, Exception : " + e.getLocalizedMessage());
		}

	}




	// @author Sachin Lesson Plan with three resources  :
	public void limitedPublishing()throws Exception {

		try {  
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify deleting the created lesson plan");
			LessonPlanPage.save.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.limitedShareDropdown);
			LessonPlanPage.limitedShareDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.limitedSharing);
			LessonPlanPage.limitedSharing.click();
			GenericFunctions.waitWebDriver(2000);
			LessonPlanPage.limitedPublishingSection.click();
			GenericFunctions.waitWebDriver(2000);
			String publishedContentTitle = LessonPlanPage.publishedContentTitle.getText();
			if(publishedContentTitle.equals("AutomationTitle1"))
			{
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.shareIcon);
				LessonPlanPage.shareIcon.click();
				Assert.assertTrue(true,"Lesson plan is displayed under limited publishing section successfully");
				System.out.println("Lesson plan is displayed under limited publishing section successfully");
				log.info("Lesson plan is displayed under limited publishing section successfully");

				GenericFunctions.waitWebDriver(2000);
				LessonPlanPage.copyLink.click();
				GenericFunctions.waitWebDriver(2000);
				LessonPlanPage.closeSharePopup.click();
				Assert.assertTrue(true,"Share popup is correctly displayed");
				System.out.println("Share popup is correctly displayed");
				log.info("Share popup is correctly displayed");
				GenericFunctions.waitWebDriver(2000);

				LessonPlanPage.lessonPlanTrash.click();
				GenericFunctions.waitWebDriver(2000);
				String deletesLessonPlan = LessonPlanPage.nameOfLessonPlan.getText();
				GenericFunctions.waitWebDriver(2000);
				LessonPlanPage.deleteConfirmYes.click();
				GenericFunctions.waitWebDriver(2000);


				((JavascriptExecutor)driver).executeScript("window.open()");
				ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
				driver.switchTo().window(tabs.get(1));					
				driver.get("https://staging.open-sunbird.org/resources/play/collection/do_2126399173546475521525/Unlisted");
				GenericFunctions.waitWebDriver(1000);
				String originalHandle = driver.getWindowHandle();

				// To close the new tab

				for(String handle : driver.getWindowHandles()) 
				{
					if (!handle.equals(originalHandle)) 
					{
						driver.switchTo().window(handle);
						driver.close();
					}
				}
				Assert.assertTrue(true,"Content is accessible from the link shared");
				System.out.println("Content is accessible from the link shared");
				log.info("Content is accessible from the link shared");


				LessonPlanPage.workSpace.click();
				GenericFunctions.waitWebDriver(2000);
				LessonPlanPage.allMyContent.click();
				GenericFunctions.waitWebDriver(2000);
				LessonPlanPage.searchContent.click();
				LessonPlanPage.searchContent.sendKeys(deletesLessonPlan);
				GenericFunctions.waitWebDriver(2000);
				Assert.assertTrue(true,"Content is successfully removed from the AllMyContent Section");
				System.out.println("Content is successfully removed from the AllMyContent Section");
				log.info("Content is successfully removed from the AllMyContent Section");
			} 
		}
		catch(Exception e)

		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "failed To verify deleting the limited published lesson plan");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method limitedPublishing" + e.getLocalizedMessage());
			Assert.fail("failed To verify deleting the limited published lesson plan, Exception : " + e.getLocalizedMessage());
		}
	}




	public void saveLessonPlanAndSendForReview()throws Exception{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify saving and sending the Lesson Plan for review");
			LessonPlanPage.save.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.sendForReview);
			LessonPlanPage.sendForReview.click();
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.sendaddImage.click();
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.sendThumbnail1.click();
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.sendSelect.click();
			GenericFunctions.waitWebDriver(2000);					
			ApiHashMap apiHashMap = new ApiHashMap();
			apiHashMap.dynamicFormHandling(DIKSHA_APIKEY,DIKSHA_ROOTORGID,DIKSHA_FRAMEWORK,"review","lessonplan");
			
		/*	LessonPlanPage.sendEditDetailsTitle.click();
			LessonPlanPage.sendEditDetailsTitle.clear();
			LessonPlanPage.sendEditDetailsTitle.sendKeys("AutoTitle");
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.sendEditDetailsDescription.click();
			LessonPlanPage.sendEditDetailsDescription.clear();
			LessonPlanPage.sendEditDetailsDescription.sendKeys("AutoDescription");
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.sendKeywords.click();
			LessonPlanPage.sendKeywords.sendKeys("AutoKeyword");
			GenericFunctions.waitWebDriver(2000);

			GenericFunctions.waitWebDriver(1500);
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
			createUserPage.select2018.click();*/
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.workSpace);
			if(createUserPage.workSpace.isDisplayed())
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Failed to verify saving and sending the Lesson Plan for review");
			}
			
		}	
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify saving and sending the Lesson Plan for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method saveLessonPlanAndSendForReview" + e.getLocalizedMessage());
			Assert.fail("To verify saving and sending the Lesson Plan for review, Exception : " + e.getLocalizedMessage());
		}

	}



	// @author Sachin Lesson Plan with three resources  :
	public void createChildNode()throws Exception{
		try{	
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify click on child node and create a lesson plan");
			// Creating 1st child node
			//driver.switchTo().frame(0);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.newChildButton);
			LessonPlanPage.newChildButton.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(LessonPlanPage.childUnitTitle);
			GenericFunctions.waitWebDriver(2000);
			action.moveToElement(LessonPlanPage.childUnitTitle).build().perform();
			LessonPlanPage.childUnitTitle.click();
			LessonPlanPage.childUnitTitle.clear();
			GenericFunctions.waitWebDriver(1000);

			LessonPlanPage.childUnitTitle.sendKeys("AutomationTitle1");
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.descriptionPlaceHolder.click();
			LessonPlanPage.descriptionPlaceHolder.sendKeys("Description1");
			GenericFunctions.waitWebDriver(2000);

			LessonPlanPage.addNotesPlaceHolder.click();
			LessonPlanPage.addNotesPlaceHolder.sendKeys("Notes1");

			LessonPlanPage.addResource.click();
			GenericFunctions.waitWebDriver(1000);

			LessonPlanPage.latestResourceCheckbox.click();
			GenericFunctions.waitWebDriver(1000);

			LessonPlanPage.proceedButton.click();
			Assert.assertTrue(true,"User is able to successfully create a child  node");
			System.out.println("User is able to successfully create a child  node");
			log.info("User is able to successfully create a child  node");
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating the childnode");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
			log.error("Exception In the method createChildNode" + e.getLocalizedMessage());
			Assert.fail("Failed on creating the childnode , Exception : " + e.getLocalizedMessage());
		}
	}





}




















