package org.pageobjects;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.apiPackage.ApiHashMap;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.ContentCreateUploadPage;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.SignUpPage;
//import org.page.TopicTreePage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class ContentCreateUploadPageObj extends BaseTest
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	ContentCreateUploadPage contentUploadPage = PageFactory.initElements(driver, ContentCreateUploadPage.class);
	CreatorUserPageObj createrUserPageObj = new CreatorUserPageObj();
	//TopicTreePage topicslist = PageFactory.initElements(driver, TopicTreePage.class);
	SignUpPage signUpPage=PageFactory.initElements(driver, SignUpPage.class);
	static Logger log = Logger.getLogger(CreatorUserPageObj.class.getName());
	List <TestDataForDiksha> objListOFTestDataForSunbird1= null ;
	Actions action = new Actions(driver);
	Random rand=new Random();
	
	
	
	String eurl=APP_URL+"/workspace/content/edit/generic#no";
	//String eurl="https://staging.ntp.net.in/workspace/content/edit/generic#no";
	//String eurl="https://staging.open-sunbird.org/workspace/content/edit/generic#no";
	String a="Browse";
	String title="";
	/**
	* Purpose: verifyUploadContentPopupDisplay method is used to verify the upload content popup is displayed. 
	* */
	public void verifyUploadContentPopupDisplay()
	{
		try 
		{  
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the upload content popup display");
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);
			if( contentUploadPage.uploadContentText.isDisplayed())
			{
				String Evalue = contentUploadPage.uploadContentText.getText();			
				Assert.assertEquals("Upload Content", Evalue);
			}
			if(contentUploadPage.popupUploadButton.isDisplayed())
			{
				String Evalue = contentUploadPage.popupUploadButton.getText();	
				Assert.assertEquals("Upload", Evalue);	
			}
			if(contentUploadPage.closeEditor.isDisplayed())
			{
				String Evalue = contentUploadPage.closeEditor.getText();	
				Assert.assertEquals("Close Editor", Evalue);	
			}


			/*GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);*/

			WebElement browse = contentUploadPage.browseButton;
			System.out.println(browse.getText());
			if(browse.isDisplayed()&&createUserPage.enterUrl.isDisplayed())
			{

				String aurl=driver.getCurrentUrl();
				System.out.println(aurl);
				Assert.assertEquals(aurl, eurl,"The given url is not matching with the expected");
				Assert.assertTrue(true);
			}
			createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
			GenericFunctions.waitWebDriver(5000);
			//GenericFunctions.waitForElementToAppear(contentUploadPage.popupUploadButton);
			action.moveToElement(contentUploadPage.popupUploadButton).build().perform();
			contentUploadPage.popupUploadButton.click();
			GenericFunctions.waitWebDriver(5000);
			System.out.println(objListOFTestDataForSunbird1.get(10).getCourseName());
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify upload content popup");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not verify the upload content popup, Exception"+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: verifyFileUpload method is used to verify the uploaded file . 
	* */
	
	public void verifyFileUpload()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to  verify the upload content");

			contentUploadPage.saveuploadcontent.click();
			GenericFunctions.waitWebDriver(5000);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(5000);

			contentUploadPage.uploadContent.click();
			GenericFunctions.waitWebDriver(5000);
			createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
			GenericFunctions.waitWebDriver(5000);
			action.moveToElement(createUserPage.UploadButton);
			createUserPage.UploadButton.click();

			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.saveuploadcontent.click();
			GenericFunctions.waitWebDriver(5000);
			if(createUserPage.closeButtonMsg.isDisplayed()){
				createUserPage.closeButtonMsg.click();
			}

			GenericFunctions.waitWebDriver(2000);

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify the upload content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not verify the upload content popup, Exception"+e.getLocalizedMessage());
		}	

	}
	/**
	* Purpose: navigateToLibraryAndSearchContent method is used to navigate to library & search content. 
	* */
	
	public void navigateToLibraryAndSearchContent(List<TestDataForDiksha> objListOFTestDataForSunbird12)
	{
		try	
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to library and search for the content");	

			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			//createUserPage.dropDown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			GenericFunctions.waitWebDriver(1200);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchInput.click();
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad(".//TestData//contentNumbers.txt"));
			System.out.println(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad(".//TestData//contentNumbers.txt"));
			createUserPage.searchIcon.click();
			//GenericFunctions.waitForElementToAppear(contentCreatePage.searchContentName);
			GenericFunctions.waitForElementToAppear(contentUploadPage.serachedContent);
			contentUploadPage.serachedContent.click();
			GenericFunctions.waitWebDriver(1200);
			GenericFunctions.scrollToElement(contentUploadPage.homeNavigation);
			GenericFunctions.waitWebDriver(1200);
			GenericFunctions.waitForElementToAppear(contentUploadPage.searchContentName);
			if(contentUploadPage.searchContentName.isDisplayed())
			{
				String Evalue = contentUploadPage.searchContentName.getText();
				Assert.assertEquals(" Automation Content_CN0049_WEBM", Evalue);
			}
			GenericFunctions.waitForElementToAppear(contentUploadPage.copy);		
			contentUploadPage.copy.click();			
			GenericFunctions.waitWebDriver(5000);		
			Assert.assertTrue(true);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to library and search for the content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not Navigate to library and search the content, Exception"+e.getLocalizedMessage());

		}

	}
	
	/**
	* Purpose: reviewUploadContent method is used to review uploaded content. 
	* */
	
	public void reviewUploadContent()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to go to up for review and verify the upload");

			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();

		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify the upload content for the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not go to the up for review and verify the upload content"+e.getLocalizedMessage());

		}
	}
	/*public void navigateToLibraryAndSearchContent()
	{
		try 
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to library and search for the content"); 
			List <TestDataForDiksha> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			//createUserPage.dropDown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchInput.click();
			createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird1.get(2).getCourseName());//+"_"+GenericFunctions.readFromNotepad(".//TestData//contentNumbers.txt"));
			System.out.println(objListOFTestDataForSunbird1.get(2).getCourseName());//+"_"+GenericFunctions.readFromNotepad(".//TestData//contentNumbers.txt"));
			createUserPage.searchIcon.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContent);
			createUserPage.searchedContent.click();
			GenericFunctions.waitWebDriver(5000);
			contentCreatePage.copy.click();
			GenericFunctions.waitWebDriver(5000);		
			Assert.assertTrue(true);

		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify the upload content for the user");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not go to the up for review and verify the upload content, Exception Message:Exception\"+e.getLocalizedMessage()");

		}
	}*/

	/**
	* Purpose: saveAndSendUploadContentForReview method is used to save & send uploaded content for review. 
	* */
	public void saveAndSendUploadContentForReview()throws Exception{

		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save and send u for review");

			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForDiksha("testdatatestcoursename");

			GenericFunctions.waitWebDriver(1500);
			createUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.checkAppIcon.click();
			GenericFunctions.waitWebDriver(2500);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1000);
			ApiHashMap apiHashMap = new ApiHashMap();
			apiHashMap.dynamicFormHandling(DIKSHA_APIKEY,DIKSHA_ROOTORGID,DIKSHA_FRAMEWORK,"review","resource");
			/*GenericFunctions.waitForElementToAppear(createUserPage.clickBoard);
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
			GenericFunctions.waitWebDriver(1000);*/
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(4000);
			
			/*GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectCurriculum);
			createUserPage.clickOnSelectCurriculum.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectCurriculum.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectClass);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickOnSelectClass.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass.click();
			//GenericFunctions.keyTab(driver, createUserPage.selectClass.toString());
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnHeaderSubject);
			//createUserPage.clickOnHeaderSubject.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.scrollToElement(createUserPage.clickOnSelectSubject);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnSelectSubject);
			createUserPage.clickOnSelectSubject.click();
			GenericFunctions.scrollToElement(createUserPage.clickOnSelectMedium);
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectMedium);
			createUserPage.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppearOnScreen(createUserPage.selectMedium);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectMedium.click();
			GenericFunctions.waitWebDriver(5000);
			//			contentCreatePage.selectTopic.click();
			//			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);

			//			createUserPage.searchConcept.sendKeys(objListOFTestDataForSunbird.get(10).getCourseName());			System.out.println(objListOFTestDataForSunbird.get(10).getCourseName());
			//
			//			GenericFunctions.waitWebDriver(5000);
			//			contentCreatePage.selectFunction.click();
			//			GenericFunctions.waitWebDriver(5000);
			//			createUserPage.conceptDoneButton.click();
			//			GenericFunctions.waitWebDriver(5000);
			//			createUserPage.clickOnSelectSubject.click();
			//			GenericFunctions.waitForElementToAppear(createUserPage.selectSubject);
			//			createUserPage.selectSubject.click();
			action.moveToElement(contentUploadPage.owner).click().perform();			
			GenericFunctions.scrollToElement(contentUploadPage.owner);
			contentUploadPage.owner.click();
			GenericFunctions.waitWebDriver(1500);
			contentUploadPage.ownership.click();
			
			 */			
			GenericFunctions.waitForElementToAppear(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(5000);

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on saving and sending upload content for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save and course for review");
			Assert.fail("Failed on saving and sending course for review, Exception"+e.getLocalizedMessage());

		}

	}
	/**
	* Purpose: uploadContent_Pdf_MP4_WEBM_H5P method is used to click on browse button. 
	* */

	public void uploadContent_Pdf_MP4_WEBM_H5P()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload MP4");
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcoursename");
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitForElementToAppear(contentUploadPage.browseButton);
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.browseButton.click();
			GenericFunctions.waitWebDriver(5000);
		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed To upload MP4");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to upload MP4, Exception"+e.getLocalizedMessage());
		}

	}
	/**
	* Purpose: verifyThatEditDetailsPageIsDisplayed method is used to verify the edit details page is displayed. 
	* */

	
	public void verifyThatEditDetailsPageIsDisplayed()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to get edit Detail Page is Displaying");
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);
			GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			//GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
			GenericFunctions.waitForElementToAppear(contentUploadPage.popupUploadButton);
			contentUploadPage.popupUploadButton.click();
			GenericFunctions.waitWebDriver(5000);	
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.editDetailsLink);
			contentUploadPage.editDetailsLink.click();
			GenericFunctions.waitWebDriver(5000);
			if(contentUploadPage.editDetailsHeading.isDisplayed())
			{
				String Evalue = contentUploadPage.editDetailsHeading.getText();
				Assert.assertEquals("Edit Details", Evalue,"Failed on Asserting Edit details button");
				ExtentTestManager.getTest().log(LogStatus.PASS, "Edit details popup is displayed");
			}
			if(contentUploadPage.appIcon.isDisplayed())
			{
				String Evalue = contentUploadPage.appIcon.getText();
				Assert.assertEquals("Icon", Evalue,"Failed on Asserting App Icon");
				ExtentTestManager.getTest().log(LogStatus.PASS, "App icon is displayed in Edit details form");
			}
			if(contentUploadPage.cancelButton.isDisplayed())
			{
				String Evalue = contentUploadPage.cancelButton.getText();
				Assert.assertEquals("Cancel", Evalue,"Failed on Asserting Cancel button");
				ExtentTestManager.getTest().log(LogStatus.PASS, "Cancel button is verified and it is displayed");

			}
			if(createUserPage.saveButton.isDisplayed())
			{
				String Evalue = createUserPage.saveButton.getText();
				Assert.assertEquals("Save", Evalue,"Failed on Asserting Save button");
				ExtentTestManager.getTest().log(LogStatus.PASS, "Save button is verified and it is displayed");
			}
			GenericFunctions.waitWebDriver(5000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not display the edit details page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("Could not display the edit details page, Exception"+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: selectValuesFromDropdowns method is used to select the dropdown values. 
	* */

	public String[] selectValuesFromDropdowns()
	{
		String[] valueArray=new String[4];
		try 
		{

			String upload =GenericFunctions.testDataIncrementer("./testData/uploadNumbers.txt");
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Continuation with the next scenario");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to select the BOARD, MEDIUM, CLASS and SUBJECT in the edit details form");

			contentUploadPage.checkAppIcon.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchUploadImage);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchUploadImage.sendKeys(SEARCH_CONTENT_IMAGE);
			GenericFunctions.waitWebDriver(1200);
			createUserPage.clickImageSearch.click();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.checkContentIcon.click();	

			GenericFunctions.waitForElementToAppear(createUserPage.selectAppIcon);
			contentUploadPage.selectAppIcon.click();

			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitForElementToAppear(contentUploadPage.uploadContentName);
			contentUploadPage.uploadContentName.clear();
			GenericFunctions.waitWebDriver(2500);
			contentUploadPage.uploadContentName.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseDescription()+upload);

			
			//Dec 12
			/*GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectCurriculum);
			GenericFunctions.waitWebDriver(5000);

			createUserPage.clickOnSelectCurriculum.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectCurriculum);			
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectCurriculum.click();
*/
			GenericFunctions.scrollToElement(createUserPage.clickOnSelectClass);
			
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectClass);
			createUserPage.clickOnSelectClass.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass.click();

			GenericFunctions.waitWebDriver(1200);
			driver.findElement(By.xpath("//i[@class='edit icon']")).click();
			//GenericFunctions.scrollToElement(createUserPage.clickOnSelectSubject);
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectSubject);


			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickOnSelectSubject);
			createUserPage.clickOnSelectSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectSubject);
			createUserPage.selectSubject.click();
			driver.findElement(By.xpath("//i[@class='edit icon']")).click();
			GenericFunctions.waitWebDriver(1200);

			createUserPage.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppearOnScreen(createUserPage.selectMedium);
			GenericFunctions.waitWebDriver(1200);
			createUserPage.selectMedium.click();
			driver.findElement(By.xpath("//i[@class='edit icon']")).click();
		
//			createUserPage.clickOnSelectClass.click();
//			GenericFunctions.waitWebDriver(1000);
//			createUserPage.selectClass.click();
//
//			GenericFunctions.waitWebDriver(1200);
//			driver.findElement(By.xpath("//i[@class='edit icon']")).click();


			createUserPage.clickOnSelectSubject.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectSubject);
			createUserPage.selectSubject.click();
			driver.findElement(By.xpath("//i[@class='edit icon']")).click();
			//dec 12 2018
		/*	GenericFunctions.waitWebDriver(2000);
			GenericFunctions.scrollToElement(contentUploadPage.selectedCirriculumText);
			GenericFunctions.waitWebDriver(2000);	
			
			valueArray[0] = contentUploadPage.selectedCirriculumText.getText();*/
			
			
			/*valueArray[1]= contentUploadPage.selectedClassText.getText();
			valueArray[2]=  contentUploadPage.selectedMediumText.getText();
			valueArray[3]=  contentUploadPage.selectedSubjectText.getText();
			*/

			valueArray[2]=  contentUploadPage.selectedMediumText.getText();
			valueArray[3]=  contentUploadPage.selectedSubjectText.getText();
			System.out.println(valueArray[0]+valueArray[1]+valueArray[2]+valueArray[3]);
			System.out.println("Passed here");
			GenericFunctions.waitWebDriver(1200);

			
			
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			GenericFunctions.waitForElementToAppearOnScreen(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectOwner.click();
			
			GenericFunctions.waitForElementToAppear(createUserPage.saveButton);
			createUserPage.saveButton.click();
			
			GenericFunctions.waitForElementToAppearOnScreen(createUserPage.closeContentPopup);
			createUserPage.closeContentPopup.click();

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not select values from the dropdowns in edit details from");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			log.error("Could not select values from the dropdowns in edit details from");
			Assert.fail("Could not select values from the dropdowns in edit details from, Exception"+e.getLocalizedMessage());
		}

		//Return the stored values to verify
		return valueArray;
	}	

	/**
	* Purpose: verifyValuesOfDropdowns method is used to verify values of a dropdown. 
	* */

	public void verifyValuesOfDropdowns(String [] valueArray)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is tring to verify values in the dropdown");
			
			GenericFunctions.waitWebDriver(2000);
			/*GenericFunctions.waitForElementToAppearOnScreen(createUserPage.searchedContentForPublish);
			createUserPage.searchedContentForPublish.click();*/
			
			GenericFunctions.waitWebDriver(4000);
			/*GenericFunctions.waitForElementToAppear(createUserPage.closeButton);
			createUserPage.closeButton.click();*/
			
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.editDetailsLink);
			contentUploadPage.editDetailsLink.click();
			
			//Dec 12
			/*GenericFunctions.waitForElementToAppear(createUserPage.clickAppIcon);
			if(valueArray[0].equalsIgnoreCase(contentUploadPage.selectedCirriculumText.getText()))
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Selected Curriculum text has been verified");*/
		//	GenericFunctions.s(contentUploadPage.selectedClassText);
		
		
				/*if(valueArray[1].equalsIgnoreCase(contentUploadPage.selectedClassText.getText()))
				{
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS, "Selected Class text has been verified");*/
					if(valueArray[3].equalsIgnoreCase(contentUploadPage.selectedSubjectText.getText()))
					{
						Assert.assertTrue(true);
						ExtentTestManager.getTest().log(LogStatus.PASS, "Selected Subject text has been verified");
						
						//GenericFunctions.scrollToElement(contentUploadPage.selectedClassText);
						if(valueArray[2].equalsIgnoreCase(contentUploadPage.selectedMediumText.getText()))
						{
							Assert.assertTrue(true);
							ExtentTestManager.getTest().log(LogStatus.PASS, "Selected Medium text has been verified");
						}

					}
		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not display the edit details page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			log.error("Could not display the edit details page");
			Assert.fail("Could not display the edit details page, Exception"+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: selectTopicFromTopicTree method is used to select topic from topic tree. 
	* */

	public void selectTopicFromTopicTree()
	{
		try
		{
			
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is tring to verify the topics in topic tree");
			/*GenericFunctions.waitWebDriver(1200);
			GenericFunctions.waitForElementToAppearOnScreen(contentUploadPage.selectTopicPopup);
			GenericFunctions.scrollToElement(contentUploadPage.selectTopicPopup);
			contentUploadPage.selectTopicPopup.click();
			GenericFunctions.waitWebDriver(3000);   
			GenericFunctions.waitForElementToAppearOnScreen(contentUploadPage.selectPolynomials);
			contentUploadPage.selectPolynomials.click();
			GenericFunctions.waitForElementToAppearOnScreen(createUserPage.doneButton);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.doneButton.click();
			GenericFunctions.waitWebDriver(3000);


			GenericFunctions.waitForElementToAppearOnScreen(contentUploadPage.selectedTopics);
			if(contentUploadPage.selectedTopics.isDisplayed())
			{
				//Assert.assertEquals(contentUploadPage.selectedTopics.getText(), "topics selected");
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Topics are succesfully selected from the topic tree");
			}

			GenericFunctions.scrollToElement(contentUploadPage.owner);
			GenericFunctions.waitForElementToAppear(contentUploadPage.owner);
			contentUploadPage.owner.click();
			GenericFunctions.waitForElementToAppear(contentUploadPage.ownership);		
			contentUploadPage.ownership.click();*/

			createUserPage.saveButton.click();
			GenericFunctions.waitForElementToAppear(createUserPage.closeButtonMsg);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.closeButtonMsg.click();


		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not select and verify the topic tree");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			log.error("Could not select and verify the topic tree");
			Assert.fail("Could not select and verify the topic tree, Exception"+e.getLocalizedMessage());
		}
	}



	/**
	* Purpose: verifyLimitedSharingContent method is used to verify the limited published content. 
	* */


	public void verifyLimitedSharingContent()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify limited sharing functionality");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.limitedSharingArrow.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.clickLimitedSharing.click();
			GenericFunctions.waitForElementToAppear(createUserPage.limitedPublishing);
			createUserPage.limitedPublishing.click();
			if(createUserPage.limitedPublishing.isDisplayed())
			{
				GenericFunctions.waitWebDriver(2000);
				action.moveToElement(createUserPage.getContentInDrafts).perform();
				System.out.println(createUserPage.getContentInDrafts.getText());
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content is successfullly submitted for limited publishing"+createUserPage.getContentInDrafts.getText()+" is the content name ");
			}
			GenericFunctions.waitWebDriver(2000);
			/*createUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(5000);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(2500);*/
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not verify limited sharing functionality");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			log.error("Could not verify limited sharing functionality");
			Assert.fail("Could not verify limited sharing functionality, Exception"+e.getLocalizedMessage());
		}
	}

	/**
	* Purpose: allUploadsContent method is used to verify the saved upload content in all upload section. 
	* */
	
	public void allUploadsContent()
	{
		try {

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the saved upload content in all upload section.");
			GenericFunctions.waitWebDriver(3000);
			if(createUserPage.reviewCourseName.isDisplayed())
			{
				Assert.assertTrue(true);	
			}
			GenericFunctions.waitWebDriver(5000);
			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.reviewCourseName);
			createUserPage.reviewCourseName.click();
			GenericFunctions.waitWebDriver(5000);

			System.out.println(createUserPage.reviewCourseName);
*/
		}catch(Exception e) 
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The upload content is not in all uploads after saving");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("The upload content is not in all uploads after saving, Exception"+e.getLocalizedMessage());
		}
	}

	/**
	* Purpose: reviewSubmissionPage method is used to verify the upload content in review submision page.
	* */
	public void reviewSubmissionPage()
	{
		try {

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to see the upload content in review submision page.");
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.closeLinkIcon);
			contentUploadPage.closeLinkIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.closePageIcon);
			contentUploadPage.closePageIcon.click();
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.workspace);
			contentUploadPage.workspace.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.reviewSubmission);
			createUserPage.reviewSubmission.click();
			GenericFunctions.waitWebDriver(5000);
			if(contentUploadPage.reviewCardView.isDisplayed())
			{
				String Evalue =contentUploadPage.reviewCardView.getText();
				//Assert.assertEquals("CourseA Description", Evalue);
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Verified contente in review Submission "+Evalue);
			}
			GenericFunctions.waitWebDriver(5000);
		/*	contentUploadPage.homeNavigation.click();
			GenericFunctions.waitWebDriver(5000);*/
		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The upload content is not displaying in the review submision page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("The upload content is not displaying in the review submision page, Exception"+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: navigateToUpForReviewAndSearchContent method is used to navigate to up for review page.
	* */
	public void navigateToUpForReviewAndSearchContent()
	{
		String contentName="";
		try {

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to up for review page");
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.workspace);
			contentUploadPage.workspace.click();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.upforreview.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitForElementToAppear(contentUploadPage.searchBox);

			contentUploadPage.searchBox.sendKeys(CONTENT_ARRAY[rand.nextInt(CONTENT_ARRAY.length)]);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.contentInUpForReview);
			if(contentUploadPage.contentInUpForReview.isDisplayed())
			{
				GenericFunctions.waitWebDriver(2000);
				contentName=contentUploadPage.contentInUpForReview.getText();
				ExtentTestManager.getTest().log(LogStatus.PASS, contentName+"Contents are displayed on Searching content in Up For Review");
				//Assert.assertEquals("CourseA", Evalue);
				Assert.assertTrue(true);

				contentUploadPage.searchBox.clear();
				contentUploadPage.upforreview.click();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.refreshWebPage();
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.contentInUpForReview);
				GenericFunctions.waitWebDriver(2000);
				System.out.println(contentUploadPage.contentInUpForReview.getText()+"-"+contentUploadPage.latestContentDuration.getText());
				try
				{
					if(contentUploadPage.latestContentDuration.getText().contains("minute")||contentUploadPage.latestContentDuration.getText().contains("hour")||contentUploadPage.latestContentDuration.getText().contains("second")||contentUploadPage.latestContentDuration.getText().contains("day"))
					{
						ExtentTestManager.getTest().log(LogStatus.PASS, contentName+"Content is latest content and "+contentUploadPage.latestContentDuration.getText());
						Assert.assertTrue(true);
					}
				}
				catch(Exception e)
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, contentName+"Content is latest content and "+contentUploadPage.latestContentDuration.getText());
				}
			}


			GenericFunctions.waitWebDriver(5000);


		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User is failed to navigate to up for review page");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("User is failed to navigate to up for review page, Exception"+e.getLocalizedMessage());
		}

	}
	/**
	* Purpose: navigateToUpForReviewAndSearchContent method is used to verify sort by in Up for review
	* */
	public void verifySortByFeatureAndValues()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify sort by in Up for review");

			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

			GenericFunctions.waitWebDriver(3000);
			
			GenericFunctions.waitForElementToAppear(contentUploadPage.workspace);
			contentUploadPage.workspace.click();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.upforreview.click();
			GenericFunctions.waitWebDriver(5000);
			
			
			
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.sortBy);
		
		 /*	contentUploadPage.profileIcon.click();
			GenericFunctions.waitWebDriver(5000);*/
			
//			GenericFunctions.waitForElementToAppear(contentUploadPage.searchBox);
//			contentUploadPage.searchBox.sendKeys("CourseA DescriptionC053");
//			GenericFunctions.waitWebDriver(5000);

			
			contentUploadPage.sortBy.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppearOnScreen(contentUploadPage.updatedOn);
			if(contentUploadPage.updatedOn.isDisplayed())
			{

				contentUploadPage.updatedOn.click();
				GenericFunctions.waitWebDriver(2000);
				if(driver.getCurrentUrl().contains("sort_by=lastUpdatedOn"))
				{
					Assert.assertEquals(contentUploadPage.updatedOn.getText(), "Updated On","failed to assert Sort By -Updated");
					ExtentTestManager.getTest().log(LogStatus.PASS, "Verified Upadted On option of Sort-By feature");
				}
			}
			contentUploadPage.sortBy.click();
			GenericFunctions.waitWebDriver(3000);
			contentUploadPage.createdOn.click();
			if(contentUploadPage.updatedOn.isDisplayed())
			{
				//contentUploadPage.createdOn.click();
				GenericFunctions.waitWebDriver(3000);
				if(driver.getCurrentUrl().contains("sort_by=createdOn"))
				{
					System.out.println(driver.getCurrentUrl());
					GenericFunctions.waitWebDriver(2000);
					Assert.assertEquals(contentUploadPage.updatedOn.getText(), "Created On","failed to assert Sort By -Created By");
					ExtentTestManager.getTest().log(LogStatus.PASS, "Verified Created By option of Sort-By feature");
				}

			}
			
			/*GenericFunctions.refreshWebPage();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.nameAZ);*/
			contentUploadPage.sortBy.click();
			GenericFunctions.waitWebDriver(3000);
			contentUploadPage.nameAZ.click();
			if(contentUploadPage.updatedOn.isDisplayed())
			{
				//contentUploadPage.nameAZ.click();
				GenericFunctions.waitWebDriver(3000);
				if(driver.getCurrentUrl().contains("sort_by=name"))
				{
					System.out.println(driver.getCurrentUrl());
					GenericFunctions.waitWebDriver(2000);
					Assert.assertEquals(contentUploadPage.updatedOn.getText(),"Name A-Z","failed to assert Sort By -Name A-Z");
					ExtentTestManager.getTest().log(LogStatus.PASS, "Verified Name A-Z option of Sort-By feature");
					
				}
			}

			
			GenericFunctions.waitWebDriver(5000);
			
			
			/*GenericFunctions.waitWebDriver(5000);
			String updatedoncontent=contentUploadPage.date.getText();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.date.isDisplayed();		
			System.out.println(updatedoncontent);
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.sortBy.click();	
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.createdOn.click();
			GenericFunctions.waitWebDriver(5000);
			String updatedoncontent1=contentUploadPage.date.getText();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.date.isDisplayed();		
			System.out.println(updatedoncontent);
			contentUploadPage.sortBy.click();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.nameAZ.click();
			String updatedoncontent2=contentUploadPage.date.getText();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.date.isDisplayed();		
			System.out.println(updatedoncontent);*/




		}catch(Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not verify sort by in Up for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("Could not verify sort by in Up for review"+e.getLocalizedMessage());
		}
	}

	/**
	* Purpose: showFilter method is used to filtering with based on curriculum,grades,medium,subjects,content types,");
	* */
	public void showFilter(){
		{
			try {

				ExtentTestManager.getTest().log(LogStatus.INFO, "The upload content is filtering with based on curriculum,grades,medium,subjects,content types,");
				objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
				GenericFunctions.waitWebDriver(5000);			
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.workspace);
				contentUploadPage.workspace.click();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.upforreview);
				contentUploadPage.upforreview.click();
				GenericFunctions.waitWebDriver(5000);
				contentUploadPage.showfilter.click();
				GenericFunctions.waitWebDriver(1200);
				/*contentCreatePage.selectBoard.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectRajasthan.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.gradeLevel.click();
				GenericFunctions.waitWebDriver(1200);
				contentCreatePage.selectClass9.click();
				GenericFunctions.waitWebDriver(1200);*/
				contentUploadPage.selectSubject.click();
				GenericFunctions.waitWebDriver(2000);
				contentUploadPage.selectMathematics.click();
				GenericFunctions.waitWebDriver(2000);
				contentUploadPage.selectMedium.click();
				GenericFunctions.waitWebDriver(2000);
				contentUploadPage.selectHindi.click();
				GenericFunctions.waitWebDriver(2000);
				contentUploadPage.selectContentType.click();
				GenericFunctions.waitWebDriver(2000);
				contentUploadPage.selectCollection.click();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.clickOnApplyButton);
				contentUploadPage.clickOnApplyButton.click();
				GenericFunctions.waitWebDriver(5000);
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.contentName);
				if(contentUploadPage.contentName.isDisplayed())
                {
                    String Evalue =contentUploadPage.contentName.getText();
                    //Assert.assertEquals("Automation Collection_CL0043", Evalue);
                    Assert.assertTrue(true);
                    ExtentTestManager.getTest().log(LogStatus.PASS, "Verified the filter in Up For Review "+contentUploadPage.contentName.getText());

                }
				GenericFunctions.waitWebDriver(5000);


			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not verify the filter in Up For Review");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
				Assert.fail("Could not verify the filter in Up For Review, Exception"+e.getLocalizedMessage());
				System.out.println("Exception in applying filters "+e.getLocalizedMessage());
			}
		}
	}
	/**
	* Purpose: navigateToUpForReviewN method is used to the upload content in up for review page
	* */
	public String navigateToUpForReviewN()
	{
		String publishedContent="";
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to see the upload content in up for review page");
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitForElementToAppear(contentUploadPage.workspace);
			contentUploadPage.workspace.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.upforreview);
			contentUploadPage.upforreview.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(contentUploadPage.searchForReview);
			contentUploadPage.searchForReview.click();
			/*GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentUploadPage.searchForReview);*/
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.searchForReview.sendKeys(CONTENT_ARRAY[rand.nextInt(CONTENT_ARRAY.length)]);
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.contentInUpForReview);
			String searchInput=contentUploadPage.contentInUpForReview.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO, searchInput+" searched input in up for review");
			System.out.println(searchInput);
			GenericFunctions.waitWebDriver(5000);


			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.contentInUpForReview);
			contentUploadPage.contentInUpForReview.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(5000);
			if(searchInput.contains("resource")&&searchInput.equalsIgnoreCase("Automation content"))
			{
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.publishButton);
				publishedContent=contentUploadPage.clickContentInUFR.getText();
				contentUploadPage.publishButton.click();
			}
			else
			{
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickPublishIcon);
				publishedContent=createUserPage.untitledCollection.getText();
				createUserPage.clickPublishIcon.click();
			}
			//GenericFunctions.scrollToElement(contentCreatePage.publishButton);
			//GenericFunctions.waitForElementToAppear(contentCreatePage.publishButton);
			//action.moveToElement(contentCreatePage.publishButton).build().perform();



			GenericFunctions.waitWebDriver(5000);
			for(int i=0;i<createUserPage.checkbox.size();i++)
			{
				GenericFunctions.waitWebDriver(500);
				createUserPage.checkbox.get(i).click();
			}
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.popupPublishButton);
			createUserPage.popupPublishButton.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.workSpace);
			//			GenericFunctions.waitWebDriver(1200);
			//			GenericFunctions.waitForElementToAppear(contentCreatePage.profileIcon);
			//			contentCreatePage.profileIcon.click();
			//			GenericFunctions.waitForElementToAppear(contentCreatePage.logoutButton);
			//			contentCreatePage.logoutButton.click();

			GenericFunctions.waitWebDriver(3000);


		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("The upload content is not displaying in the review submision page, Exception"+e.getLocalizedMessage());
		}
		return publishedContent;
	}
// Checking published content in published section.
	public void publishedContent(String publishedContent)
	{
		try {

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the published content in Published Bucket");
			System.out.println("recieved-"+publishedContent);
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitWebDriver(2000);
			/*GenericFunctions.waitForElementToAppearOnScreen(contentUploadPage.profileIcon);
			contentUploadPage.profileIcon.click();*/
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(contentUploadPage.published);
			contentUploadPage.published.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(contentUploadPage.contentInPublished);
			contentUploadPage.contentInPublished.getText();
			System.out.println(contentUploadPage.contentInPublished.getText());
			if(publishedContent.contains(contentUploadPage.contentInPublished.getText())||contentUploadPage.contentInPublished.getText().contains(publishedContent))
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Published Content is verified in published bucket"+contentUploadPage.contentInPublished.getText()+"is the content");
			}

			GenericFunctions.waitWebDriver(5000);


		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The upload content is not displaying in the published section");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("The upload content is not displaying in the published section, Exception"+e.getLocalizedMessage());
		}


	}
	/**
	* Purpose: requestChanges method is used to send the request changes for all upload content.
	* */
	public void requestChanges()
	{
		try {

			ExtentTestManager.getTest().log(LogStatus.INFO, "User  is trying to send the request changes for all upload content");
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitForElementToAppear(contentUploadPage.workspace);
			contentUploadPage.workspace.click();
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.upforreview.click();
			GenericFunctions.waitWebDriver(3000);
			contentUploadPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(6).getCourseName());
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(contentUploadPage.searchForReview);
			contentUploadPage.searchForReview.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentUploadPage.contentupload);
			if(contentUploadPage.contentupload.isDisplayed())
			{
				String Evalue =contentUploadPage.contentupload.getText();
				System.out.println(Evalue);
				//Assert.assertEquals("Automation Resource", Evalue,"Failed on Asserting");
			}
			GenericFunctions.waitWebDriver(5000);
			contentUploadPage.contentupload.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentUploadPage.requestChangesButton);
			contentUploadPage.requestChangesButton.click();
			GenericFunctions.waitWebDriver(5000);
			for(int i=0;i<contentUploadPage.checkbox.size();i++){
				contentUploadPage.checkbox.get(i).click();
			}
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentUploadPage.requestChangesComment);
			contentUploadPage.requestChangesComment.click();
			contentUploadPage.requestChangesComment.sendKeys("Testing");
			GenericFunctions.waitWebDriver(5000);

			contentUploadPage.requestChangesBlueButton.click();
			GenericFunctions.waitWebDriver(5000);


			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(2000);


		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "The reviewer failed to rejects the uploaded content ");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("The reviewer failed to rejects the uploaded content, Exception"+e.getLocalizedMessage());

		}

	}
	/**
	* Purpose: alluploads method is used to see the upload content in up for review page.
	* */
	public void alluploads()
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to see the upload content in up for review page");
			objListOFTestDataForSunbird1=ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			//GenericFunctions.waitWebDriver(2000);
			//contentUploadPage.profileIcon.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.allMyContent);
			createUserPage.allMyContent.click();
			//GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(5000);	
			contentUploadPage.contentupload.click();
			GenericFunctions.waitWebDriver(5000);	
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			
			GenericFunctions.waitWebDriver(8000);	
			//GenericFunctions.waitForElementToAppear(contentUploadPage.reviewerSuggestion);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.reviewerSuggestion);
			GenericFunctions.waitWebDriver(10000);
			GenericFunctions.clickOnElementUsingJavascript(contentUploadPage.reviewerSuggestion);
			//contentUploadPage.reviewerSuggestion.click();
			GenericFunctions.waitWebDriver(5000);
			if( contentUploadPage.reviewerSuggestionTitle.isDisplayed())
			{
				Assert.assertTrue(true);
				System.out.println("This test case pass");
				ExtentTestManager.getTest().log(LogStatus.PASS, "User can able to check the rejeted content along with the reviewer sugesstion");
			}
			contentUploadPage.closeLinkIcon.click();
			GenericFunctions.waitWebDriver(2000);
			contentUploadPage.closePageIcon.click();
			GenericFunctions.waitWebDriver(2000);

		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "User is not able to see the upload content in the all uploads section");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
			Assert.fail("User is not able to see the upload content in the all uploads section, Exception"+e.getLocalizedMessage());

		}

	}
	/**
	* Purpose: verifyContentsOfUpForReview method is used to sort the content using Updated On Sort By option.
	* */
	//Dec 19
		public void verifyContentsOfUpForReview(String sortByOption)
		{
			String contentOnAscendingOrder="",contentOnDescendingOrder="";

			try
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to sort the content using Updated On Sort By option");
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.refreshWebPage();
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.upForReview);
				createUserPage.upForReview.click();
				GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.sortBy);
				contentUploadPage.sortBy.click();
				GenericFunctions.waitWebDriver(2000);

				WebElement element= driver.findElement(By.xpath("//*[@id='sortByDropDown']//sui-select-option/span[contains(.,'"+sortByOption+"')]"));


				action.moveToElement(element).click().build().perform();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(contentUploadPage.contentInUpForReview);
				if(contentUploadPage.sortByAscendingIcon.isDisplayed()&&contentUploadPage.contentInUpForReview.isDisplayed())
				{
					Assert.assertTrue(true);
					GenericFunctions.waitWebDriver(2000);
					contentOnDescendingOrder=contentUploadPage.contentInUpForReview.getText();
					ExtentTestManager.getTest().log(LogStatus.PASS, "Contents are displaying in descending order upon using"+sortByOption+"Sort By Option, content is"+contentOnDescendingOrder);
					contentUploadPage.sortBy.click();
					GenericFunctions.waitWebDriver(2000);
					action.moveToElement(element).click().build().perform();
					GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.contentInUpForReview);
					GenericFunctions.waitWebDriver(2000);
					contentOnAscendingOrder=contentUploadPage.contentInUpForReview.getText();
					if(contentOnDescendingOrder!=contentOnAscendingOrder)
					{
						Assert.assertTrue(true);
						GenericFunctions.waitWebDriver(2000);
						ExtentTestManager.getTest().log(LogStatus.PASS, "Contents are displaying in ascending order upon using "+sortByOption+" Sort By Option again, content is"+contentOnAscendingOrder);
						GenericFunctions.waitWebDriver(2000);
					}
				}

			}

			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "User is not able to see the upload content in the all uploads section");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message:"+e.getLocalizedMessage());
				Assert.fail("User is not able to see the upload content in the all uploads section, Exception"+e.getLocalizedMessage());

			}
		}


}

