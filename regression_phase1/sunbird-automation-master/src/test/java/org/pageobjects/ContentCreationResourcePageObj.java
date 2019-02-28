package org.pageobjects;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


import org.apache.log4j.Logger;
import org.apiPackage.ApiHashMap;
import org.generic.AllUploadingPaths;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.ContentCreationResourcePage;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.SignUpPage;
import org.page.UploadOrgPage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class ContentCreationResourcePageObj extends BaseTest
{
	WebDriverWait wait = new WebDriverWait(driver,20);
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	UploadOrgPage orgUploadPage=PageFactory.initElements(driver, UploadOrgPage.class);
	SignUpPage signUpPage=PageFactory.initElements(driver, SignUpPage.class);
	ContentCreationResourcePage contentCreationResourcePage =PageFactory.initElements(driver,ContentCreationResourcePage.class);
	static Logger log = Logger.getLogger(CreatorUserPageObj.class.getName());
	List <TestDataForDiksha> objListOFTestDataForSunbird1= null ;
	Actions action = new Actions(driver);
	Random rand=new Random();
	CreatorUserPageObj createUserPageObj= new CreatorUserPageObj();
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	SoftAssert softAssert = new SoftAssert();
	String eUrl=APP_URL+"/myActivity";
	


	/**
	* Purpose: SearchContentAndValidate method is used to search the content & validate.
	* */
	public void SearchContentAndValidate(String Contentname)
	{

		try
		{

			GenericFunctions.waitForElementToAppear(createUserPage.searchForReview);
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is Searching for the content in search field");
			GenericFunctions.waitForElementToAppear(createUserPage.searchForReview);
			createUserPage.searchForReview.sendKeys(Contentname);
			GenericFunctions.waitWebDriver(1000);
			SoftAssert softAssert = new SoftAssert();

			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.VerifySearchedContent);
			String ContentType=contentCreationResourcePage.VerifySearchedContent.getText();
			System.out.println(ContentType);

			System.out.println(Contentname);
			switch (Contentname) {
			case "CourseA":

				softAssert.assertEquals(ContentType,"Course");
				ExtentTestManager.getTest().log(LogStatus.PASS, "Search Content "+Contentname+" is displayed Succesfully");
				log.info("Search Content is displayed Succesfully");
				break;


			case "BookA":

				softAssert.assertEquals(ContentType,"TextBook");
				ExtentTestManager.getTest().log(LogStatus.PASS, "Search Content "+Contentname+" is displayed Succesfully");
				log.info("Search Content is displayed Succesfully");
				break;



			case "LessonA":
				softAssert.assertEquals(ContentType,"LessonPlan");
				ExtentTestManager.getTest().log(LogStatus.PASS, "Search Content "+Contentname+" is displayed Succesfully");
				log.info("Search Content is displayed Succesfully");
				break;

			case "Automation Content":
				softAssert.assertEquals(ContentType,"Resource");
				ExtentTestManager.getTest().log(LogStatus.PASS, "Search Content "+Contentname+" is displayed Succesfully");
				log.info("Search Content is displayed Succesfully");
				break;

			case "Automation Collection":
				softAssert.assertEquals(ContentType,"Collection");
				ExtentTestManager.getTest().log(LogStatus.PASS, "Search Content "+Contentname+" is displayed Succesfully");
				break;


			default:
				System.out.println(Contentname);
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Search Content is Not displayed Succesfully");
				log.error("Search Content is Not displayed Succesfully");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on validating Searched Content in All my content Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on validating Searched Content in All my content Page");
			Assert.fail("Failed on validating Searched Content in All my content Page");

		}

	}
	/**
	* Purpose: VerifySortByIsExists method is used to sort the content & validate.
	* */
	public void VerifySortByIsExists()
	{
		try
		{
			SoftAssert softAssert = new SoftAssert();
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Click on Library Page");
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.ClickOnLibrary);
			contentCreationResourcePage.ClickOnLibrary.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Click on Library Page");
			//softAssert.assertTrue(true);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Validate the SortBy Text & SortyBy Option in Library Page");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.searchInput);
			createUserPage.searchInput.click();
			createUserPage.searchInput.sendKeys("courseA");
			GenericFunctions.waitWebDriver(2000);
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.VerifySortBy);
			if(contentCreationResourcePage.VerifySortBy.isDisplayed())
			{
				String ActualValue=contentCreationResourcePage.VerifySortBy.getText();
				softAssert.assertEquals(ActualValue,"Sort by:");

				//ExtentTestManager.getTest().log(LogStatus.INFO, "Click on SortBy Dropdown in Library Page");
				GenericFunctions.waitForElementToAppear(contentCreationResourcePage.ClickSortByDropDown);
				contentCreationResourcePage.ClickSortByDropDown.click();

				//ExtentTestManager.getTest().log(LogStatus.INFO, "Validate Modified option in Dropdown in Library Page");
				String OptionValue1=contentCreationResourcePage.VerifySortByOptionList.getText();
				softAssert.assertEquals(OptionValue1,"Modified On");

				//ExtentTestManager.getTest().log(LogStatus.INFO, "Validate CreatedOn option in Dropdown in Library Page");
				String OptionValue2=contentCreationResourcePage.VerifySortByOptionList1.getText();
				softAssert.assertEquals(OptionValue2,"Created On");

				softAssert.assertAll();

				ExtentTestManager.getTest().log(LogStatus.PASS,"SortBy Option has been verified in Library Page");
			}
			else
			{
				System.out.println("Could not verify elements");
				log.info("Could not verify elements");
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on validating SoryBy Options in Library Page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on validating SoryBy Options in Library Page");
			Assert.fail("Failed on validating SoryBy Options in Library Page");
		}
	}
	/**
	* Purpose: verifyProfileIconAndWorkspace method is used to validate the features under Profile Icon.
	* */
	public void verifyProfileIconAndWorkspace()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to validate the features under Profile Icon");
			GenericFunctions.waitForElementToAppear(createUserPage.profileIconDropdown);
			createUserPage.profileIconDropdown.click();
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.profileIconProfile);
			if(contentCreationResourcePage.profileIconAnnouncementDashboard.isDisplayed()&&contentCreationResourcePage.profileIconActivity.isDisplayed()
					&&contentCreationResourcePage.profileIconLogout.isDisplayed()&&contentCreationResourcePage.profileIconProfile.isDisplayed())
			{
				Assert.assertTrue(true);
				System.out.println(contentCreationResourcePage.profileIconProfile);
				System.out.println(contentCreationResourcePage.profileIconAnnouncementDashboard);
				System.out.println(contentCreationResourcePage.profileIconActivity);
				System.out.println(contentCreationResourcePage.profileIconLogout);

				ExtentTestManager.getTest().log(LogStatus.PASS, "Features :"+contentCreationResourcePage.profileIconProfile+", "+contentCreationResourcePage.profileIconAnnouncementDashboard+"," +contentCreationResourcePage.profileIconActivity+" and"+ contentCreationResourcePage.profileIconLogout +" are verified on clicking Profile Icon");
			}
			else
			{
				System.out.println("Could not verify elements");
				log.info("Could not verify elements");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on validating the features under Profile Icon");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on validating the features under Profile Icon");
			Assert.fail("Failed on validating the features under Profile Icon");
		}	
	}
	/**
	* Purpose: verifyWorkspaceAndFeatures method is used to validate all the features/Options under Workspace");
	* */
	public void verifyWorkspaceAndFeatures()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to validate all the features/Options under Workspace");
			System.out.println("Continuation of Test case 73");
			GenericFunctions.waitWebDriver(2000);
			contentCreationResourcePage.profileIconProfile.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitForElementToAppear(createUserPage.createBook);
			String EUrl="https://staging.ntp.net.in/workspace/content/create";
			String aUrl=driver.getCurrentUrl();
			System.out.println(aUrl);
			if(createUserPage.createBook.isDisplayed()&&createUserPage.createCourse.isDisplayed()&&createUserPage.createResource.isDisplayed()
					&&createUserPage.createLesson.isDisplayed()&&createUserPage.createCollection.isDisplayed()&&createUserPage.createUploadContent.isDisplayed())
			{ 
				Assert.assertEquals(aUrl, EUrl, "Failed on validating Url");
				Assert.assertTrue(true);
				System.out.println("Book"+"\n"+"Course"+"\n"+"Resource"+"\n"+"Collection"+"\n"+"Lesson plan"+"\n"+"Upload Content"+"\n"+" Elements are present under CREATE Bucket in Workspace");
				ExtentTestManager.getTest().log(LogStatus.PASS,"Book, Course, Resource, Collection, Lesson plan, Upload Content Elements are verified and are present under CREATE Bucket in Workspace");
				GenericFunctions.waitWebDriver(2000);
				contentCreationResourcePage.allMyActivity.click();
				GenericFunctions.waitForElementToAppear(contentCreationResourcePage.showFilters);
				if(contentCreationResourcePage.showFilters.isDisplayed())
				{
					GenericFunctions.waitWebDriver(2000);


					contentCreationResourcePage.showFilters.click();
					GenericFunctions.waitForElementToAppear(contentCreationResourcePage.filterApplyButton);
					if(contentCreationResourcePage.filterApplyButton.isDisplayed()&&contentCreationResourcePage.filterResetButton.isDisplayed())
					{
						contentCreationResourcePage.sortByIcon.click();
						GenericFunctions.waitWebDriver(1000);
						Assert.assertTrue(true);
						System.out.println("Filters"+"\n"+"APPLY BUTTON"+"\n"+"RESET BUTTON"+"\n"+"Sort By"+"\n"+"Features and buttons are displayed successfully under All My Content Bucket");

					}

				}
				else
				{
					System.out.println(contentCreationResourcePage.showFilters+" element is not displayed under All My Content bucket");
				}

			}
			else
			{
				System.out.println("Elements under Workspace are not displaying and failed to verify elements");
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating to Workspace and verifying elements");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on navigating to Workspace and verifying elements");
			Assert.fail("Failed on navigating to Workspace and verifying elements");
		}
	}
	/**
	* Purpose: navigateToLibraryAndSearchContent method is used to navigate to library & search content.
	* */
	public String navigateToLibraryAndSearchContent(String inputToSearch)
	{
		try 
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to Library and search "+inputToSearch); 
			//List <TestDataForDiksha> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitForElementToAppear(createUserPage.headerLibrary);
			createUserPage.headerLibrary.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.searchInput);
			createUserPage.searchInput.click();

			if(inputToSearch.contains("resource"))
			{
				GenericFunctions.waitWebDriver(2000);
				//createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird1.get(6).getCourseName());
				createUserPage.searchInput.sendKeys("Automation "+inputToSearch);
			}
			else if(inputToSearch.contains("book"))
			{
				
				//createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird1.get(2).getCourseName());
				createUserPage.searchInput.sendKeys(inputToSearch);
			}
			else if(inputToSearch.contains("collection"))
			{
				GenericFunctions.waitWebDriver(2000);
				//createUserPage.searchInput.sendKeys(objListOFTestDataForSunbird1.get(5).getCourseName());
				createUserPage.searchInput.sendKeys("Automation Collection");
			}

			//+"_"+GenericFunctions.readFromNotepad("./TestData//contentNumbers.txt"));
			//+"_"+GenericFunctions.readFromNotepad("./testData/contentNumbers.txt"));
			//System.out.println("Input to search-"+search);
			GenericFunctions.waitWebDriver(1500);
			createUserPage.searchIcon.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitForElementToAppear(createUserPage.getCourseName);

			if(createUserPage.getCourseName.isDisplayed())
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, createUserPage.getCourseName.getText()+"Contents are sucessfully displayed in Library");
				String resultContentLabel = ContentCreationResourcePage.libraryContentLabel.getText();
				System.out.println("Content Label"+resultContentLabel);
				createUserPage.getCourseName.click();
				//Wait for 3 sec
				GenericFunctions.waitWebDriver(3000);		
				if(resultContentLabel.equalsIgnoreCase("resource"))
				{
					softAssert.assertTrue(true,"Labels of the results did not match");			
				}
				else if(resultContentLabel.equalsIgnoreCase("textbook"))
				{
					softAssert.assertTrue(true,"Labels of the results did not match");
				}
				else if(resultContentLabel.equalsIgnoreCase("collection"))
				{
					softAssert.assertTrue(true,"Labels of the results did not match");
				}

				softAssert.assertAll();
				
			
			
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to Library and search content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			softAssert.fail("Could not Navigate to library and search the content, Exception"+e.getLocalizedMessage());

		}
		return inputToSearch;	}
	/**
	* Purpose: copyContentAndValidate method is used to search content in Library and copy it.
	* */
	public void copyContentAndValidate(String contentType)
	{
		String searchedBookName="", copiedContentInDrafts="";
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search content in Library and copy it");
			if(contentType.equalsIgnoreCase("course"))
			{
				GenericFunctions.waitForElementToAppear(contentCreationResourcePage.searchedClickedCourseResource);
				searchedBookName=contentCreationResourcePage.searchedClickedCourseResource.getText();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(contentCreationResourcePage.courseCopyIcon);
				contentCreationResourcePage.courseCopyIcon.click();
			}
			else if(contentType.equalsIgnoreCase("resource"))
			{
				GenericFunctions.waitForElementToAppear(contentCreationResourcePage.searchedClickedContent);
				searchedBookName=contentCreationResourcePage.searchedClickedContent.getText();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(contentCreationResourcePage.libraryContentCopyIcon);
				contentCreationResourcePage.libraryContentCopyIcon.click();
			}
			
			else if(contentType.equalsIgnoreCase("collection"))
			{
				GenericFunctions.waitForElementToAppear(contentCreationResourcePage.searchedClickedContent);
				searchedBookName=contentCreationResourcePage.searchedClickedContent.getText();
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(contentCreationResourcePage.libraryContentCopyIcon);
				contentCreationResourcePage.libraryContentCopyIcon.click();
			}
			System.out.println("Searched and clicked content-"+searchedBookName);
			try
			{
				GenericFunctions.waitForElementToAppear(ContentCreationResourcePage.copyErrorToast);
				action.moveToElement(ContentCreationResourcePage.copyErrorToast).build().perform();
				boolean state = ContentCreationResourcePage.copyErrorToast.isDisplayed();
				if(state==true)
				{
					
					ExtentTestManager.getTest().log(LogStatus.INFO, "Error on copying Content from Library-"+ContentCreationResourcePage.copyErrorToast.getText());
					//Assert.fail("Error "+ContentCreationResourcePage.copyErrorToast.getText());
					/*GenericFunctions.refreshWebPage();										
					if(contentType.equalsIgnoreCase("course"))
					{
						GenericFunctions.waitWebDriver(2000);
						GenericFunctions.waitForElementToAppear(contentCreationResourcePage.courseCopyIcon);
						contentCreationResourcePage.courseCopyIcon.click();
					}
					else if(contentType.equalsIgnoreCase("resource"))
					{
						GenericFunctions.waitWebDriver(2000);
						GenericFunctions.waitForElementToAppear(contentCreationResourcePage.libraryContentCopyIcon);
						contentCreationResourcePage.libraryContentCopyIcon.click();
					}*/
				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "No Error while copying the content");

			}


			//GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(6000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(6500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentCreationResourcePage.copiedContentName);
			String copiedContentName=contentCreationResourcePage.copiedContentName.getText();
			System.out.println(copiedContentName);
			String currentEditorUrl=driver.getCurrentUrl();
			System.out.println("Editor Url "+currentEditorUrl);
			if(copiedContentName.contains(searchedBookName)&&currentEditorUrl.contains("draft"))
			{	
				ExtentTestManager.getTest().log(LogStatus.PASS, "Content is copied sucessfully");
				System.out.println(copiedContentName+" Content copied succesfully");
				GenericFunctions.waitWebDriver(2000);
				Assert.assertTrue(true);
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Could not copy Content");
				System.out.println("Could not copy Content");
			}
			GenericFunctions.waitWebDriver(2000);
			createUserPage.editorCloseIcon.click();
			try
			{			
				GenericFunctions.waitForElementToAppear(contentCreationResourcePage.draftsCopiedContentName);
				copiedContentInDrafts=contentCreationResourcePage.draftsCopiedContentName.getText();
				System.out.println(copiedContentInDrafts);
				//String trimmedContentName = copiedContentInDrafts.substring(0, 40);
				if(copiedContentName.contains(copiedContentInDrafts))
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, copiedContentInDrafts+"is the Copied Content found in Drafts");
					System.out.println(copiedContentInDrafts+" is the copied content present in the drafts");
					GenericFunctions.waitWebDriver(2001);
					Assert.assertTrue(true);
				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, copiedContentInDrafts+" Content is not found in Draft");
				System.out.println(copiedContentInDrafts+" Content is not found in Draft");
			}
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to copy content and validate it");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to copy content and validate it"+e.getLocalizedMessage());

		}
	}
	/**
	* Purpose: valdiateContentEditor method is used to validate the content editor by creating a resource.
	* */
	public void valdiateContentEditor()

	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create new resource");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./testData/resourceNumbers.txt").toString();
			createUserPage.bookName.sendKeys(objListOFTestDataForSunbird1.get(6).getCourseName()+resourceNumber);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(7000);			
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4500);
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.addSlide);
			if(createUserPage.saveCourse.isDisplayed()&&createUserPage.sendForReview.isDisplayed())
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "User is sucessfully navigated to Content editor and validated");
				System.out.println("User is sucessfully navigated to Content editor and validated");
				GenericFunctions.waitWebDriver(2500);
				/*createUserPage.editorCloseIcon.click();
				driver.switchTo().alert().accept();*/
				Assert.assertTrue(true);
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.ERROR, "User failed to navigate to Content editor");
				System.out.println("User failed to navigate to Content editor");
			}
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create resource and validate content editor");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to create resource and  validate content editor"+e.getLocalizedMessage());

		}
	}
	/**
	* Purpose: verifyResourcePluginsAndContents method is used to validate the contents & plugins by creating  resource with all.
	* */
	public void verifyResourcePluginsAndContents()
	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the contents and plugins for creating resource");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Continuation with Test case 76");
			GenericFunctions.waitWebDriver(1000);
			//Adding the contents and plugins present on Top bar

			//Adding Slide
			addSlides(1);

			//Add Text
			addText();

			//Adding shapes


			//Adding Image
			addImage();


			//Adding hotspot
			contentCreationResourcePage.addHotspot.click();
			GenericFunctions.waitWebDriver(1000);

			//Adding scribblepad
			contentCreationResourcePage.addScribblepad.click();
			GenericFunctions.waitWebDriver(1000);

			//Adding Question Set
			createQuestion();
			GenericFunctions.waitWebDriver(1000);

			//Adding Math Plugin
			addMathPlugin();

			//Adding multiple Slides
			contentCreationResourcePage.addSlide.click();
			GenericFunctions.waitWebDriver(1000);
			contentCreationResourcePage.addSlide.click();

			//Click on save button for saving the resource
			createUserPage.saveCourse.click();

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to validate contents and plugins for creating resources");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to validate contents and plugins for creating resources "+e.getLocalizedMessage());
			Assert.fail("Failed to validate contents and plugins for creating resources"+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: addShapes method is used to add shapes.
	* */
	public void addShapes()
	{
		GenericFunctions.waitForElementToAppear(contentCreationResourcePage.addShapes);
		contentCreationResourcePage.addShapes.click();
		GenericFunctions.waitWebDriver(1000);
		contentCreationResourcePage.addTriangleShape.click();
		GenericFunctions.waitWebDriver(3000);
	}
	/**
	* Purpose: addText method is used to add text.
	* */
	public void addText()
	{
		//Adding text
		GenericFunctions.waitForElementToAppear(contentCreationResourcePage.addText);
		contentCreationResourcePage.addText.click();
		contentCreationResourcePage.addTextTextArea.sendKeys(objListOFTestDataForSunbird1.get(10).getCourseName());
		GenericFunctions.waitWebDriver(1000);
		contentCreationResourcePage.addTextDoneButton.click();
		GenericFunctions.waitWebDriver(1000);
	}
	/**
	* Purpose: addImage method is used to add image.
	* */
	public void addImage()
	{
		//Adding Image
		GenericFunctions.waitForElementToAppear(contentCreationResourcePage.addImage);
		contentCreationResourcePage.addImage.click();
		GenericFunctions.waitForElementToAppear(createUserPage.searchUploadImage);
		createUserPage.searchUploadImage.sendKeys(SEARCH_RESOURCE_IMAGE);
		createUserPage.clickImageSearch.click();
		GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentCreationResourcePage.checkContentIcon);
		contentCreationResourcePage.checkContentIcon.click();
		GenericFunctions.waitWebDriver(2000);
		createUserPage.selectAppIcon.click();
		GenericFunctions.waitWebDriver(1000);
	}
	/**
	* Purpose: addSlides_Image_Text method is used to add slides & images & text.
	* */
	public void addSlides_Image_Text(int noOfSlides,int testCaseName)
	{
		try
		{
			//objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to add slides to the Resource");
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.addSlide);
			for(int i=1;i<=noOfSlides;i++)
			{
				contentCreationResourcePage.addSlide.click();
				if(i<=1)
				{
					addText();
				}
				else if(i==2 && i<=noOfSlides)
				{
					addImage();
				} 
				else if(i==3 && i<=noOfSlides)
				{
					addAudio();
				}
				else if(i==4 && i<=noOfSlides)
				{
					addVideo();
				}
				else if(i>4)
				{
					addShapes();
				}
			}	
			GenericFunctions.waitWebDriver(1000);
			contentCreationResourcePage.propertiesSection.click();
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.PASS, "User is able to view property section-completed Test case "+"testCaseName");
			contentCreationResourcePage.clickNextSlide.click();

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to add slides to resource");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to add slides to resource "+e.getLocalizedMessage());
			Assert.fail("Failed to add slides to resource "+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: addSlides method is used to add slides.
	* */
	public void addSlides(int slidesToAdd)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to add "+slidesToAdd+ " slides to the Resource");
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.addSlide);
			for(int i=1;i<=slidesToAdd;i++)
			{
				contentCreationResourcePage.addSlide.click();
				if(i<=1)
				{
					addText();
				}
				else if(i==2 && i<=slidesToAdd)
				{
					addImage();
				} 
				else if(i==3 && i<=slidesToAdd)
				{
					addAudio();
				}
				else if(i==4 && i<=slidesToAdd)
				{
					addVideo();
				}
				else if(i>4)
				{
					addShapes();
				}
				GenericFunctions.waitWebDriver(1000);
			}	
			contentCreationResourcePage.clickNextSlide.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to add slides to resource");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to add slides to resource "+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: previewSlides_AndFromBegining method is used to preview  slides added to the content.
	* */
	public void previewSlides_AndFromBegining()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to preview the slides added to the content");
			int slidesToAdd=10;
			addSlides(slidesToAdd);
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.previewIcon);
			contentCreationResourcePage.previewIcon.click();
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.previewPopup);
			if(contentCreationResourcePage.previewPopup.isDisplayed())
			{
				GenericFunctions.WaitForFrameAndSwitchToIt(contentCreationResourcePage.previewPopupFrame);
				GenericFunctions.waitForElementToAppear(contentCreationResourcePage.previewNextBtn);
				for(int i=1;i<=slidesToAdd+3;i++)
				{
					contentCreationResourcePage.previewNextBtn.click();
					GenericFunctions.waitWebDriver(1000);
				}
				GenericFunctions.waitWebDriver(1500);
				if(contentCreationResourcePage.contentPreiviewCompleteScreen.isDisplayed()&&contentCreationResourcePage.previewPopupReplayBtn.isDisplayed())
				{
					//contentResourcePage.contentPreiviewCompleteScreen.getText();
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS, "User completed previewing of all the slides(10) from Beginning - Completed Test case 120 and 121");

					GenericFunctions.captureScreenshotOnValidation();
				}

			}
			GenericFunctions.waitWebDriver(2000);
			//driver.get("https://staging.open-sunbird.org/workspace");
			//String currentUrl= driver.getCurrentUrl();
			driver.navigate().to(APP_URL+"/workspace");
			//driver.switchTo().defaultContent();
			//GenericFunctions.refreshWebPage();

			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.editorCloseIcon);
			createUserPage.editorCloseIcon.click();*/
			GenericFunctions.waitWebDriver(4000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to preview the slides of the content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to preview the slides of the content "+e.getLocalizedMessage());
			Assert.fail("Failed to preview the slides of the content "+e.getLocalizedMessage());
		}
		//GenericFunctions.WaitForFrameAndSwitchToIt(contentResourcePage.previewPopupFrame);

	}
	/**
	* Purpose: addMathPlugin method is used to add math plugins.
	* */
	public void addMathPlugin()
	{
		
		try
		{
		//Adding Math plugin
		GenericFunctions.waitForElementToAppear(contentCreationResourcePage.addMathText);
		contentCreationResourcePage.addMathText.click();
		GenericFunctions.waitForElementToAppearOnScreen(contentCreationResourcePage.selectMathText);
		contentCreationResourcePage.selectMathText.click();
		GenericFunctions.waitWebDriver(4000);
		contentCreationResourcePage.selectedMathTextAdd.click();
		GenericFunctions.waitWebDriver(1000);
		//GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
		/*createUserPage.saveCourse.click();
		createUserPage.closeContentPopup.click();*/
		}
		catch(Exception e4){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to adding math plugin");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e4.getLocalizedMessage());
		
			Assert.fail("Failed to adding math plugin"+e4.getLocalizedMessage());
		}
	}
	/**
	* Purpose: addAudio method is used to add audio plugins.
	* */
	public void addAudio()
	{
		
		try
		{
		//Adding Audio
		GenericFunctions.waitForElementToAppear(contentCreationResourcePage.addAudio);
		contentCreationResourcePage.addAudio.click();
		GenericFunctions.waitWebDriver(3000);
		/*
		GenericFunctions.waitForElementToAppearOnScreen(contentResourcePage.selectMyAudio);
		contentResourcePage.selectMyAudio.click();
		 */
		GenericFunctions.waitForElementToAppearOnScreen(contentCreationResourcePage.clickAllAudio);
		GenericFunctions.waitWebDriver(3000);
		GenericFunctions.waitWebDriver(1000);
		contentCreationResourcePage.clickAllAudio.click();
		GenericFunctions.waitForElementToAppear(contentCreationResourcePage.selectAudio_AllAudio);
		GenericFunctions.waitWebDriver(1000);
		GenericFunctions.waitWebDriver(3000);
		contentCreationResourcePage.selectAudio_AllAudio.click();
		GenericFunctions.waitWebDriver(3000);
		GenericFunctions.waitWebDriver(1000);
		createUserPage.selectAppIcon.click();
		GenericFunctions.waitWebDriver(1000);
	}
catch(Exception e)
		{
	ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to adding Audio");
	ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());

	Assert.fail("Failed to adding Audio"+e.getLocalizedMessage());
}
		}
	/**
	* Purpose: addVideo method is used to add video plugins.
	* */
	public void addVideo()
	{
		try
		{
		GenericFunctions.waitForElementToAppear(contentCreationResourcePage.addVideo);
		contentCreationResourcePage.addVideo.click();
		GenericFunctions.waitForElementToAppear(contentCreationResourcePage.pasteVideoUrl);
		contentCreationResourcePage.pasteVideoUrl.sendKeys(VIDEO_UPLOAD);
		GenericFunctions.waitWebDriver(2500);
		GenericFunctions.waitForElementToAppear(contentCreationResourcePage.goButton);
		contentCreationResourcePage.goButton.click();
		GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentCreationResourcePage.addToLessonBtn);
		GenericFunctions.waitWebDriver(3500);
		contentCreationResourcePage.addToLessonBtn.click();
		GenericFunctions.waitWebDriver(1500);
		}
		catch(Exception e5)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to adding video");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e5.getLocalizedMessage());

			Assert.fail("Failed to adding video"+e5.getLocalizedMessage());
		}
	}
	/**
	* Purpose: addQuestionsPluginAudioVideo method is used to add questions,audio,video plugins.
	* */
	public void addQuestionsPluginAudioVideo()
	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to add Question set, Audio, Video and plugins to the resource");
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.addQuestionSet);

			//Add Question set from existing list
			contentCreationResourcePage.addQuestionSet.click();
			GenericFunctions.waitWebDriver(2000);	
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.pickQuestion);
			GenericFunctions.waitWebDriver(2000);
			contentCreationResourcePage.pickQuestionCheckBox.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentCreationResourcePage.pickQueNextButton);
			contentCreationResourcePage.pickQueNextButton.click();
			GenericFunctions.waitWebDriver(2500);
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentCreationResourcePage.questionSetTitle);
			action.moveToElement(contentCreationResourcePage.questionSetTitle).build().perform();
			action.click(contentCreationResourcePage.questionSetTitle).build().perform();
			action.sendKeys(contentCreationResourcePage.questionSetTitle,objListOFTestDataForSunbird1.get(11).getCourseDescription()).build().perform();
			//contentCreationResourcePage.questionSetTitle.sendKeys(objListOFTestDataForSunbird1.get(11).getCourseDescription());
			GenericFunctions.waitWebDriver(2000);
			contentCreationResourcePage.questionSetAddButton.click();
			GenericFunctions.waitWebDriver(1500);

			//Add plugins
			addMathPlugin();

			//Add Audio
			addAudio();

			//Add Video
			addVideo();

			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitForElementToAppear(createUserPage.closeContentPopup);
			createUserPage.closeContentPopup.click();
			GenericFunctions.waitWebDriver(2000);
		}

		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to add Question set, Audio, Video and plugins to the resource");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to add Question set, Audio, Video and plugins to the resource "+e.getLocalizedMessage());
			Assert.fail("Failed to add Question set, Audio, Video and plugins to the resource "+e.getLocalizedMessage());
		}

	}
	/**
	* Purpose: verifyLimitedSharing method is used to verify the Limited sharing and share the content via the Share Icon.
	* */
	public void verifyLimitedSharing() throws Exception
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is verify the Limited sharing and share the content via the Share Icon");	
			Robot r = new Robot();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.limitedSharingIcon);
			if(contentCreationResourcePage.limitedSharingIcon.isDisplayed())//&&contentResourcePage.deleteIconLP.isDisplayed())
			{
				contentCreationResourcePage.limitedSharingIcon.click();
				GenericFunctions.waitWebDriver(1000);
				contentCreationResourcePage.clickLimitedSharing.click();
				GenericFunctions.waitWebDriver(3000);
				//GenericFunctions.waitForElementToAppear(createUserPage.getContentFromDraft);
				contentCreationResourcePage.limitedPublishing.click();
				GenericFunctions.waitForElementToAppear(createUserPage.getContentFromDraft);
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(contentCreationResourcePage.contentShareIcon);
				GenericFunctions.waitForElementToAppear(contentCreationResourcePage.deleteIconLP);
				if(contentCreationResourcePage.contentShareIcon.isDisplayed()&&contentCreationResourcePage.deleteIconLP.isDisplayed())
					//contentResourcePage.contentShareIcon.click();
					GenericFunctions.waitWebDriver(1000);
				//contentResourcePage.contentShareIcon.click();
				GenericFunctions.waitWebDriver(1000);
				
				createUserPage.clickGobuton.click();
				GenericFunctions.waitWebDriver(3000);
				
				contentCreationResourcePage.copyLinkBtn.click();
				GenericFunctions.waitWebDriver(3000);
				if(contentCreationResourcePage.copiedMessage.isDisplayed())
				{
					action.moveToElement(contentCreationResourcePage.linkDataField).build().perform();
					action.contextClick(contentCreationResourcePage.linkDataField).build().perform();
					GenericFunctions.waitWebDriver(1100);
					r.keyPress(KeyEvent.VK_DOWN);
					GenericFunctions.waitWebDriver(1000);
					r.keyPress(KeyEvent.VK_DOWN);
					GenericFunctions.waitWebDriver(1000);
					r.keyPress(KeyEvent.VK_ENTER);

					r.keyRelease(KeyEvent.VK_DOWN);
					r.keyRelease(KeyEvent.VK_DOWN);
					r.keyRelease(KeyEvent.VK_ENTER);

					GenericFunctions.waitWebDriver(2500);
					ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
					driver.switchTo().window(tabs2.get(1));//.get("https://staging.open-sunbird.org/resources/play/content/do_21259328104976384013190/Unlisted");


					GenericFunctions.waitForElementToAppear(contentCreationResourcePage.resourceNameNewWindow);
					while(contentCreationResourcePage.resourceNameNewWindow.isDisplayed())
					{
						ExtentTestManager.getTest().log(LogStatus.INFO, "The copied link is accessible to the user");
						Assert.assertTrue(true);
						break;
					}
				}
				else
				{
					System.out.println("Could not copy the link");
				}
				//ExtentTestManager.getTest().log(LogStatus.PASS,"Capture the Share popup"+log.addScreenCaptureFromPath());
			}
			else 
			{
				System.out.println("Could not find Share and Delete icon");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify Limited Share and Share resource via Share icon feature");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to verify Limited Share and Share resource via Share icon feature "+e.getLocalizedMessage());
			Assert.fail("Failed to verify Limited Share and Share resource via Share icon feature "+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: deleteFromLimitedPublishing method is used to delete the content from Limited publishing bucket.
	* */

	public void deleteFromLimitedPublishing()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to delete the content from Limited publishing bucket");	
			GenericFunctions.waitForElementToAppear(ContentCreationResourcePage.deleteIconLP);
			ContentCreationResourcePage.deleteIconLP.click();
			GenericFunctions.waitForElementToAppear(ContentCreationResourcePage.deletePopupYesBtn);
			ContentCreationResourcePage.deletePopupYesBtn.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.captureScreenshotOnValidation();
			Assert.assertTrue(true);
			ExtentTestManager.getTest().log(LogStatus.INFO, "content deleted succesfully from the limited publishing bucket");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to delete the content from Limited publishing bucket");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to delete the content from Limited publishing bucket "+e.getLocalizedMessage());
			Assert.fail("Failed to delete the content from Limited publishing bucket "+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: editResourceDetails method is used to edit details of Resource to verify Edit Details.
	* */

	public void editResourceDetails()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to edit details of Resource to verify Edit Details");	
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			System.out.println(contentCreationResourcePage.editorEditDetails.getText());
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.editorEditDetails);
			contentCreationResourcePage.editorEditDetails.click();
			
			/*GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectCurriculum);
			createUserPage.clickOnSelectCurriculum.click();*/
			
			
			//Dec 15
			/*GenericFunctions.waitForElementToAppear(createUserPage.selectCurriculum);
			createUserPage.selectCurriculum.click();
			GenericFunctions.waitWebDriver(1000);
			*/
			GenericFunctions.waitWebDriver(1000);
			ApiHashMap apiHashMap = new ApiHashMap();
			apiHashMap.dynamicFormHandling(DIKSHA_APIKEY,DIKSHA_ROOTORGID,DIKSHA_FRAMEWORK,"review","resource");

		/*GenericFunctions.waitWebDriver(3000);
		createUserPage.clickBoard.click();
		GenericFunctions.waitForElementToAppear(contentCreationResourcePage.selectBoard);
		GenericFunctions.waitWebDriver(2000);
		contentCreationResourcePage.selectBoard.click();
			
			GenericFunctions.waitWebDriver(2000);
			createUserPage.clickOnSelectMedium.click();
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.selectMedium);
			GenericFunctions.waitWebDriver(2000);
			contentCreationResourcePage.selectMedium.click();

			GenericFunctions.waitWebDriver(3000);
			
			GenericFunctions.scrollToElement(createUserPage.clickOnSelectClass);
			GenericFunctions.waitForElementToAppear(createUserPage.clickOnSelectClass);
			createUserPage.clickOnSelectClass.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectClass.click();
			GenericFunctions.waitWebDriver(1000);
			driver.findElement(By.xpath("//label[contains(text(),'SUBJECT')]")).click();
			GenericFunctions.waitWebDriver(3000);
			
			
		//	GenericFunctions.scrollToElement(createUserPage.clickOnSelectSubject);
			createUserPage.clickOnSelectSubject.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.selectSubject);
			contentCreationResourcePage.selectSubject.click();
			
			GenericFunctions.waitWebDriver(2000);*/
			
			//Dec 15
			/*GenericFunctions.waitForElementToAppear(contentCreationResourcePage.clickTopics);
			contentCreationResourcePage.clickTopics.click();
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(2700);
			
			
			
			try
			{
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.selectTopic);
			GenericFunctions.waitWebDriver(1000);
			contentCreationResourcePage.selectTopic.click();
			GenericFunctions.waitWebDriver(1000);
			}
			catch(Exception e4)
			{
				System.out.println("Exception Handled");
			}
			GenericFunctions.clickOnElementUsingJavascript(contentCreationResourcePage.topicsDoneBtn);*/
			/*GenericFunctions.waitForElementToAppear(contentCreationResourcePage.topicsDoneBtn);
			contentCreationResourcePage.topicsDoneBtn.click();*/
			
			
			
	
			
			
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			GenericFunctions.waitForElementToAppear(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectOwner.click();
			
			
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitForElementToAppear(createUserPage.closeContentPopup);
			createUserPage.closeContentPopup.click();

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to edit details of the Resource in the Edit Details popup");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to edit details of the Resource in the Edit Details popup "+e.getLocalizedMessage());
			Assert.fail("Failed to edit details of the Resource in the Edit Details popup "+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: createQuestion method is used to create Question  FITB.
	* */
	public void createQuestion()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create Question");
			GenericFunctions.waitWebDriver(2500);
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
			/*createUserPage.Concepts.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);
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
			/*createUserPage.closePage.click();
			GenericFunctions.waitWebDriver(2000);
			//GenericFunctions.handleAlert();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.createdResorce.click();
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.sendForReviewA);
			createUserPage.sendForReviewA.click();
			GenericFunctions.waitWebDriver(2000);*/
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
	* Purpose: validateUpForReivew method is used to verify and search contents in the Up for Review Bucket.
	* */
	public void validateUpForReivew()
	{
		try
		{
			//objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify and search contents in the Up for Review Bucket");

			//Test case 92
			GenericFunctions.waitForElementToAppear(createUserPage.closeIcon);
			createUserPage.closeIcon.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.upForReview);
			contentCreationResourcePage.upForReview.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			String latestContent=createUserPage.searchedContentForPublish.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO, latestContent+" is the Latest content is displayed in the top of List");
			ExtentTestManager.getTest().log(LogStatus.PASS, "Latest content is displayed in the top of List");
			//Test case 93 
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.upForReview);
			createUserPage.upForReview.click();
			createUserPage.searchForReview.sendKeys(latestContent);
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			GenericFunctions.waitWebDriver(3000);
			if(createUserPage.searchedContentForPublish.isDisplayed())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "User is getting the results upon searching for the content");

			}

			//Test Case 94
			GenericFunctions.waitWebDriver(2900);
			createUserPage.searchForReview.click();
			createUserPage.searchForReview.clear();
			//createUserPage.searchForReview.sendKeys(latestContent);
			String [] otherChannelContent={"CODE1","Checking Bugs","CODE2","CODE3","CODE4"};
			createUserPage.searchForReview.sendKeys(otherChannelContent[rand.nextInt(otherChannelContent.length)]);
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.noResultText);
			if(contentCreationResourcePage.noResultText.isDisplayed())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "User is not getting the results for searching the contents from different Orgs");
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify and search contents in the Up for Review Bucket");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to verify and search contents in the Up for Review Bucket "+e.getLocalizedMessage());
			Assert.fail("Failed to verify and search contents in the Up for Review Bucket "+e.getLocalizedMessage());
		}

	}

	/**
	* Purpose: contentFilterApply_Reset method is used to apply filters and validate contents.
	* */
	public void contentFilterApply_Reset()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to apply filters and validate contents");
			contentCreationResourcePage.upForReview.click();
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.showFilters);
			contentCreationResourcePage.showFilters.click();

			//Board
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.clickFilterBoard);
			createUserPage.clickFilterBoard.click();
			GenericFunctions.waitWebDriver(2000);
			contentCreationResourcePage.selectFilterBoard.click();
			//GenericFunctions.waitWebDriver(1000);
			//Grade(class)
			GenericFunctions.waitForElements(createUserPage.clickBookGrade);
			createUserPage.clickBookGrade.get(0).click();
			GenericFunctions.waitWebDriver(2000);
			contentCreationResourcePage.selectFilterGrade.click();
			contentCreationResourcePage.selectFilterGrade1.click();
			//Subject
			GenericFunctions.waitForElementToAppear(createUserPage.clickFilterSubject);
			createUserPage.clickFilterSubject.click();
			GenericFunctions.waitWebDriver(1000);
			contentCreationResourcePage.selectFilterSubject.click();
			//Medium
			GenericFunctions.waitForElementToAppear(createUserPage.clickFilterMedium);
			createUserPage.clickFilterMedium.click();
			GenericFunctions.waitWebDriver(1000);
			String MediumText=contentCreationResourcePage.selectFilterMedium.getText();
			System.out.println(MediumText);
			contentCreationResourcePage.selectFilterMedium.click();
			//Content type
			GenericFunctions.waitForElementToAppear(createUserPage.clickContentType);
			createUserPage.clickContentType.click();
			GenericFunctions.waitWebDriver(1000);
			contentCreationResourcePage.selectCotentType.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.clickOnElementUsingJavascript(contentCreationResourcePage.filterApplyButton);
			//contentCreationResourcePage.filterApplyButton.click();
			contentCreationResourcePage.showFilters.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.verifyFilterMedium);
			GenericFunctions.scrollToElement(contentCreationResourcePage.verifyFilterMedium);
			String compMediumText=contentCreationResourcePage.verifyFilterMedium.getText().trim();
			System.out.println(compMediumText);
			GenericFunctions.waitWebDriver(1000);
			if(MediumText.equalsIgnoreCase(compMediumText))
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.INFO, "Results are satisfying the given search filter criteria, and filters are same in the content");
			}
			//GenericFunctions.scrollToElement(createUserPage.headerLibrary);
			driver.navigate().back();
			GenericFunctions.waitWebDriver(4000);
			/*	GenericFunctions.waitForElementToAppear(contentCreationResourcePage.contentCloseIcon);
			//GenericFunctions.scrollToElement(contentCreationResourcePage.contentCloseIcon);
			contentCreationResourcePage.contentCloseIcon.click();			
			contentCreationResourcePage.contentCloseIcon.click();	*/		

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create new question set for resource");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create new question set for resource "+e.getLocalizedMessage());
			Assert.fail("Failed to create new question set for resource "+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: resetAppliedFilters method is used to Reset the applied filters.
	* */
	public void resetAppliedFilters()
	{
		try
		{
			//Test case 96-b
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Reset the applied filters");			
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.showFilters);
			GenericFunctions.scrollToElement(contentCreationResourcePage.showFilters);
			GenericFunctions.waitWebDriver(1000);
			contentCreationResourcePage.showFilters.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentCreationResourcePage.filterResetButton);;
			contentCreationResourcePage.filterResetButton.click();
			GenericFunctions.waitWebDriver(2000);
			contentCreationResourcePage.showFilters.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			String loadedTopContent=createUserPage.searchedContentForPublish.getText();
			Assert.assertTrue(true);
			GenericFunctions.waitWebDriver(3000);
			ExtentTestManager.getTest().log(LogStatus.PASS, "On Resetting all the filters contents are loaded sucessfully, "+loadedTopContent+" is the latest content at the Top of the list");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Completed Test cases 92, 93, 94, 96 a & b");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to reset the applied filters");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to reset the applied filters "+e.getLocalizedMessage());
			Assert.fail("Failed to reset the applied filters "+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: sendResourceForReview method is used to send resource for review.
	* */
	public void sendResourceForReview()
	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to send resource for review");
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.sendForReview.click();
			GenericFunctions.waitForElementToAppear(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(3000);
			//createUserPage.searchUploadImage.sendKeys(SEARCH_RESOURCE_IMAGE);
			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.clickImageSearch);
			createUserPage.clickImageSearch.click();*/
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.contentResourceIcon);
			createUserPage.contentResourceIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(1000);
			/*createUserPage.clickOnSelectCurriculum.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectCurriculum);
			createUserPage.selectCurriculum.click();*/
			
			/*
			GenericFunctions.scrollToElement(createUserPage.clickBoard);
			GenericFunctions.waitForElementToAppear(createUserPage.clickBoard);
			createUserPage.clickBoard.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectBoard.click();
			
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickOnSelectClass.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectClass);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClass.click();
			
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOnSelectSubject);
			createUserPage.clickOnSelectSubject.click();
			//GenericFunctions.waitForElementToAppear(createUserPage.selectSubject);
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectSubject.click();	
			createUserPage.clickOnSelectMedium.click();
			GenericFunctions.waitWebDriver(2000);

			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.selectMedium);
			//executor.executeScript("arguments[0].click();", createUserPage.selectMedium);
			action.moveToElement(createUserPage.selectMedium).build().perform();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectMedium.click();

			GenericFunctions.scrollToElement(createUserPage.selectConcept);
			createUserPage.selectConcept.click();
			GenericFunctions.waitForElementToAppear(createUserPage.searchConcept);
			createUserPage.searchConcept.sendKeys(objListOFTestDataForSunbird1.get(6).getTitle());
			GenericFunctions.waitWebDriver(1000);
			createUserPage.conceptChooseAll.click();
			createUserPage.conceptDoneButton.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitWebDriver(1000);
			 */

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
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectClassN.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickSubject);
			createUserPage.clickSubject.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectSubjectN.click();
			GenericFunctions.waitWebDriver(1000);
*/
			ApiHashMap apiHashMap = new ApiHashMap();
			apiHashMap.dynamicFormHandling(DIKSHA_APIKEY,DIKSHA_ROOTORGID,DIKSHA_FRAMEWORK,"review","resource");
			
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			createUserPage.selectOwner.click();

			//createUserPageObj.selectTopic();

			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();

			GenericFunctions.waitWebDriver(1500);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to send resource for review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to send resource for review"+e.getLocalizedMessage());
			Assert.fail("Failed to send resource for review"+e.getLocalizedMessage());
		}

	}
	/**
	* Purpose: resourceName method is used to  name resource while creating .
	* */
	public void resourceName()
	{
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying create new resource by giving an Unique Resource name");
			System.out.println("Passed here");
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(createUserPage.resourceName);
			String resourceNumber = GenericFunctions.testDataIncrementer("./testData/resourceNumbers.txt").toString();
			action.moveToElement(createUserPage.resourceName).build().perform();

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
	* Purpose: uploadVideoFiles method is used to upload video files .
	* */
	public void uploadVideoFiles()
	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload Video files");

			//Add Video files to Resource
			addVideo();
			ExtentTestManager.getTest().log(LogStatus.PASS, "Video is uploaded sucessfully");
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitForElementToAppear(createUserPage.closeContentPopup);
			createUserPage.closeContentPopup.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.previewIcon);
			contentCreationResourcePage.previewIcon.click();
			GenericFunctions.waitWebDriver(1600);
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.previewPopup);
			GenericFunctions.waitWebDriver(1600);
			Boolean confirmPopup = contentCreationResourcePage.previewPopup.isDisplayed();
			while(confirmPopup==true)
			{
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitForElementToAppear(contentCreationResourcePage.confirmContent);
				String aVideoUrl=contentCreationResourcePage.confirmContent.getAttribute("src");
				System.out.println(aVideoUrl);
				if(aVideoUrl.equalsIgnoreCase(VIDEO_UPLOAD))
				{
					ExtentTestManager.getTest().log(LogStatus.PASS, "The content creator is able to preview and save the uploaded video file");
					Assert.assertTrue(true);
				}
				else
				{
					ExtentTestManager.getTest().log(LogStatus.INFO, "Could not verify the video in the preview popup");
					System.out.println("Could not verify the video in the preview");
				}

				GenericFunctions.refreshWebPage();
				GenericFunctions.waitWebDriver(4000);
				//contentResourcePage.randomClickElement.click();
				//driver.switchTo().defaultContent();
				//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				break;
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to upload video files");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to upload video files"+e.getLocalizedMessage());
			Assert.fail("Failed to upload video files"+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: addActivityPlugins method is used to add activity plugins .
	* */
	public void addActivityPlugins()
	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "Continuation with the next test case");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Add activity Plugins");
			GenericFunctions.waitWebDriver(4000);			
			/*GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4000);*/
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.addActivity);
			System.out.println(contentCreationResourcePage.addActivity.getText());
			GenericFunctions.clickOnElementUsingJavascript(contentCreationResourcePage.addActivity);
			/*action.moveToElement(contentCreationResourcePage.addActivity).build().perform();
			
			action.click(contentCreationResourcePage.addActivity).build().perform();*/
			GenericFunctions.waitWebDriver(2000);
			
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentCreationResourcePage.searchActivity);
			contentCreationResourcePage.searchActivity.click();
			contentCreationResourcePage.searchActivity.sendKeys(objListOFTestDataForSunbird1.get(11).getTitleDescription());
			
			action.moveToElement(contentCreationResourcePage.searchActivity).build().perform();
			contentCreationResourcePage.searchActivity.click();
			
			GenericFunctions.waitWebDriver(4000);
			/*contentCreationResourcePage.clickCategory.click();
			GenericFunctions.waitWebDriver(2000);
			contentCreationResourcePage.selectCategory.click();*/
	
			GenericFunctions.waitForElementToAppearOnScreen(contentCreationResourcePage.addActivityBtn);
			contentCreationResourcePage.addActivityBtn.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentCreationResourcePage.clickAddedActivity);
			contentCreationResourcePage.clickAddedActivity.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentCreationResourcePage.addActivityPopupBtn);
			GenericFunctions.waitWebDriver(3000);
			contentCreationResourcePage.addActivityPopupBtn.click();

			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveCourse);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.closeContentPopup);
			createUserPage.closeContentPopup.click();
			//createUserPage.editorCloseIcon.click();

			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentCreationResourcePage.previewIcon);
			contentCreationResourcePage.previewIcon.click();
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.previewPopup);
			GenericFunctions.waitWebDriver(2000);
			Boolean confirmPopup = contentCreationResourcePage.previewPopup.isDisplayed();
			while(confirmPopup==true)
			{
				GenericFunctions.captureScreenshotOnValidation();
				ExtentTestManager.getTest().log(LogStatus.PASS, "User is able to preview the added activity/plugins");
				Assert.assertTrue(true);
				break;
			}

			driver.switchTo().defaultContent();
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.editorCloseIcon);
			createUserPage.editorCloseIcon.click();
			GenericFunctions.waitWebDriver(4000);

		}

		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Add Activity Plugins to the resource");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to Add Activity Plugins to the resource"+e.getLocalizedMessage());
			Assert.fail("Failed to Add Activity Plugins to the resource "+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: applyFiltersForQuestionSet method is used to aply filters for questions set .
	* */
	public void applyFiltersForQuestionSet()
	{
		try
		{
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to apply filter for Question Set");

			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.addQuestionSet);
			contentCreationResourcePage.addQuestionSet.click();
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.questionSetSearchBar);
			contentCreationResourcePage.questionSetSearchBar.click();
			contentCreationResourcePage.questionSetSearchBar.sendKeys(objListOFTestDataForSunbird1.get(11).getTitleDescription());
			GenericFunctions.waitWebDriver(1000);
			contentCreationResourcePage.advancedFilter.click();
			GenericFunctions.waitWebDriver(1500);
			contentCreationResourcePage.afClickLanguage.click();
			GenericFunctions.waitWebDriver(1000);
			contentCreationResourcePage.afSelectLanguage.click();
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.afClickDifficulty);
			contentCreationResourcePage.afClickDifficulty.click();
			GenericFunctions.waitWebDriver(1000);
			contentCreationResourcePage.selectLevel.click();
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.afClickQuestionType);
			contentCreationResourcePage.afClickQuestionType.click();
			GenericFunctions.waitWebDriver(1000);
			contentCreationResourcePage.afSelectQuestionType.click();
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.afClickGradeLevel);
			contentCreationResourcePage.afClickGradeLevel.click();
			GenericFunctions.waitWebDriver(1000);
			contentCreationResourcePage.afSelectGradeLevel.click();
			GenericFunctions.waitWebDriver(1500);
			contentCreationResourcePage.searchIcon.click();
			//GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);

			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.pickQuestion);
			GenericFunctions.waitWebDriver(3500);

			action.moveToElement(contentCreationResourcePage.pickQuestionCheckBox).click().build().perform();

			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.pickQueNextButton);
			contentCreationResourcePage.pickQueNextButton.click();
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.questionSetTitle);
			contentCreationResourcePage.questionSetTitle.sendKeys(objListOFTestDataForSunbird1.get(11).getCourseDescription());
			GenericFunctions.waitWebDriver(1000);
			contentCreationResourcePage.questionSetAddButton.click();
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.closeContentPopup.click();
			//User is able to preview the added question sets
		}

		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to apply Filters for Question Set");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to apply Filters for Question Set "+e.getLocalizedMessage());
			Assert.fail("Failed to apply Filters for Question Set "+e.getLocalizedMessage());
		}

	}
	/**
	* Purpose: fillInTheBlankQuestion method is used to create FITB questions set .
	* */
	public void fillInTheBlankQuestion()
	{
		try
		{
			//Select select = new Select(contentResourcePage.selectKeyboard);
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "To verify user is able to create - Fill in the blanks question type");
			GenericFunctions.waitWebDriver(1600);
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.addQuestionSet);
			contentCreationResourcePage.addQuestionSet.click();
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.createQuestion);
			contentCreationResourcePage.createQuestion.click();
			GenericFunctions.waitWebDriver(2600);
			contentCreationResourcePage.fibQuestionTemplate.click();
			GenericFunctions.waitWebDriver(2600);
			//GenericFunctions.waitForElementToAppear(contentResourcePage.enterTheQuestion);
			GenericFunctions.WaitForFrameAndSwitchToIt(contentCreationResourcePage.enterQuestionIframe);
			contentCreationResourcePage.enterTheQuestion.click();
			contentCreationResourcePage.enterTheQuestion.sendKeys(objListOFTestDataForSunbird1.get(10).getCourseName());
			GenericFunctions.waitWebDriver(1600);
			//GenericFunctions.WaitForFrameAndSwitchToIt(contentResourcePage.createQuestionFrame1);
			//GenericFunctions.scrollToElement(contentResourcePage.selectKeyboard);
			driver.switchTo().parentFrame();
			GenericFunctions.waitWebDriver(3600);
			action.moveToElement(contentCreationResourcePage.selectKeyboard).build().perform();
			action.click(contentCreationResourcePage.selectKeyboard).build().perform();
			//contentResourcePage.selectKeyboard.click();

			/*//To verify Keyboard Type English And Device
			keyboardType_English_Device();
			 */
			/*//To verify Keyboard type-CUSTOM
			selectCustomKBType("default");*/


		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify create-Fill in the blanks question type");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to verify create-Fill in the blanks question type "+e.getLocalizedMessage());
			Assert.fail("Failed to verify create-Fill in the blanks question type "+e.getLocalizedMessage());
		}
		ExtentTestManager.getTest().log(LogStatus.INFO,"Completion of Test case, continuation with next scenario");
	}
	/**
	* Purpose: keyboardTypeEnglishAndDevice method is used to select keyboard type English And Device.
	* */
	public void keyboardTypeEnglishAndDevice()
	{

		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "USer is trying to select keyboard type English And Device");

			//To VERIFY THE KEYBOARD TYPE - ENGLISH
			action.moveToElement(contentCreationResourcePage.keyboardTypeEnglish).build().perform();
			GenericFunctions.waitWebDriver(2000);
			contentCreationResourcePage.keyboardTypeEnglish.click();
			GenericFunctions.waitWebDriver(1200);
			contentCreationResourcePage.previewRefreshIcon.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(contentCreationResourcePage.previewFrameArea);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentCreationResourcePage.previewAnsFiled1);
			GenericFunctions.waitWebDriver(4000);				
			contentCreationResourcePage.previewAnsFiled1.click();
			GenericFunctions.waitWebDriver(2000);
			if(contentCreationResourcePage.previewKeyboard.isDisplayed()&&contentCreationResourcePage.keyboardLetterA.isDisplayed())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS,"Keyboard is displayed on previewing the question when Keyboard type is - English");
				System.out.println("Keyboard is displayed on previewing the question and Keyboard type as 'English'");
			}
			else 
			{
				System.out.println("Keyboard is not displayed on Previewing the Question");
			}

			//TO VERIFY KEYBOARD TYPE-DEVICE
			driver.switchTo().parentFrame();
			GenericFunctions.waitWebDriver(2000);
			action.moveToElement(contentCreationResourcePage.selectKeyboard).build().perform();
			action.click(contentCreationResourcePage.selectKeyboard).build().perform();
			GenericFunctions.waitWebDriver(1000);
			contentCreationResourcePage.keyboardTypeDevice.click();
			GenericFunctions.waitWebDriver(2000);
			contentCreationResourcePage.previewRefreshIcon.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(contentCreationResourcePage.previewFrameArea);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentCreationResourcePage.previewAnsFiled1);
			GenericFunctions.waitWebDriver(2000);
			contentCreationResourcePage.previewAnsFiled1.click();
			contentCreationResourcePage.previewAnsFiled1.sendKeys("Test A");
			Assert.assertTrue(true);
			ExtentTestManager.getTest().log(LogStatus.INFO,"Keyboard is not displayed while previewing the question and Keyboard type as -Device");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to select keyboard type English And Device");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to select keyboard type English And Device "+e.getLocalizedMessage());
			Assert.fail("Failed to select keyboard type English And Device "+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: selectCustomKBType method is used to select Custom type keyboard.
	* */

	public void selectCustomKBType(String addKeysType)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to select Custom type keyboard");
			int inputCharArrSize=0;
			char[] inputKeyCharArr=null;
			char[] prevKBElementsCharArr=null;
			driver.switchTo().parentFrame();
			GenericFunctions.waitWebDriver(1200);
			action.moveToElement(contentCreationResourcePage.selectKeyboard).build().perform();
			action.click(contentCreationResourcePage.selectKeyboard).build().perform();
			GenericFunctions.waitWebDriver(1000);
			contentCreationResourcePage.keyboardTypeCustom.click();

			GenericFunctions.waitWebDriver(650);
			if(addKeysType.equalsIgnoreCase("language"))
			{
				contentCreationResourcePage.addKeysTB.sendKeys(objListOFTestDataForSunbird1.get(12).getTitle());
			}
			else if(addKeysType.equalsIgnoreCase("default"))
			{
				contentCreationResourcePage.addKeysTB.clear();
				contentCreationResourcePage.addKeysTB.sendKeys(objListOFTestDataForSunbird1.get(12).getTitle());

			}
			else if(addKeysType.equalsIgnoreCase("characters"))
			{
				contentCreationResourcePage.addKeysTB.clear();
				inputKeyCharArr = objListOFTestDataForSunbird1.get(12).getTitle().toCharArray();
				inputCharArrSize = inputKeyCharArr.length-7;
				contentCreationResourcePage.addKeysTB.sendKeys(objListOFTestDataForSunbird1.get(12).getTitle());

			}
			else if(addKeysType.equalsIgnoreCase("alphabets"))
			{
				contentCreationResourcePage.addKeysTB.clear();
				contentCreationResourcePage.addKeysTB.sendKeys(objListOFTestDataForSunbird1.get(12).getCourseDescription());
			}
			else if(addKeysType.equalsIgnoreCase("special chracters"))
			{
				contentCreationResourcePage.addKeysTB.clear();
				contentCreationResourcePage.addKeysTB.sendKeys(objListOFTestDataForSunbird1.get(13).getCourseName());
			}
			GenericFunctions.waitWebDriver(2000);
			contentCreationResourcePage.previewRefreshIcon.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(contentCreationResourcePage.previewFrameArea);
			GenericFunctions.waitWebDriver(2000); 	
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.previewAnsFiled1);
			GenericFunctions.waitWebDriver(2000);
			contentCreationResourcePage.previewAnsFiled1.click();
			GenericFunctions.waitWebDriver(2000);
			if(contentCreationResourcePage.previewKeyboard.isDisplayed()&&contentCreationResourcePage.keyboardLetterA.isDisplayed())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS,"Custom Keyboard is displayed with only the entered keywords while previewing the question");
				System.out.println("Custom Keyboard is displayed with only the entered keywords while previewing the question");
			}
			/*if(addKeysType.contains("characters"))
			{	

				//contentResourcePage.previewKBCharCount.getText();
				//driver.findElement(By.xpath("//sui-multi-select[@formcontrolname='language']")).click();
				//driver.findElement(By.tagName("sui-multi-select")).click();
			}
			}*/
			if(addKeysType.contains("characters"))
			{

				System.out.println(contentCreationResourcePage.previewKBCharCount.size());
				//int prevKBCharArrSize = prevKBElementsCharArr[i];
				int prevKBCharArrSize = contentCreationResourcePage.previewKBCharCount.size();
				//	int prevKBCharArrSizeChanged= prevKBCharArrSize - 7 ;
				System.out.println((prevKBCharArrSize));
				if(prevKBCharArrSize==inputCharArrSize)
				{


					Assert.assertTrue(true, "Characters dint match to Assert");
					ExtentTestManager.getTest().log(LogStatus.PASS,"Number of characters displayed in the keyboard preview is same as the number of characters while creating the keyboard");
					ExtentTestManager.getTest().log(LogStatus.PASS,"Characters entered while creating the keyboards are same in the Custom keyboard while previewing");
					GenericFunctions.waitWebDriver(1100);

					driver.switchTo().parentFrame();
					//GenericFunctions.WaitForFrameAndSwitchToIt(contentResourcePage.createQuestionFrame1);
					action.moveToElement(contentCreationResourcePage.createQueNext).build().perform();
					action.click(contentCreationResourcePage.createQueNext).click().build().perform();						
					//contentResourcePage.createQueNext.click();	
				}
				else 
				{
					System.out.println("Characters did not match");
				}
			}	


		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Select custom type keyboard");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to Select custom type keyboard, Exception "+e.getLocalizedMessage());
			Assert.fail("Failed to Select custom type keyboard "+e.getLocalizedMessage());
		}
		//contentResourcePage.createQueNext.click();
	}
	/**
	* Purpose: fillAllMandatory method is used to fill all mandatory fields while creating questions.
	* */
	public void fillAllMandatory()
	{
		try
		{
			//Select select = new Select(contentResourcePage.selectKeyboard);
			objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to fill all the mandatory fields for submitting");
			//GenericFunctions.WaitForFrameAndSwitchToIt(contentResourcePage.createQuestionFrame1);
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
			createUserPage.maxScore.sendKeys("10");
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(contentCreationResourcePage.QueSubmitButton).build().perform();
			contentCreationResourcePage.QueSubmitButton.click();
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.pickQuestion);
			if(contentCreationResourcePage.pickQuestion.isDisplayed())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS,"Keyboard is displayed with only the entered keywords while previewing the quesiton and Keyboard type as 'Custom'");

			}


		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to fill the mandatory fields");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to fill the mandatory fields "+e.getLocalizedMessage());
			Assert.fail("Failed to fill the mandatory fields "+e.getLocalizedMessage());
		}

	}
	/**
	* Purpose: createQuestionTitle method is used to create question title while creating questions..
	* */
	public void createQuestionTitle()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is provide title for the Question Set");
			GenericFunctions.waitWebDriver(2600);
			action.moveToElement(contentCreationResourcePage.pickQueNextButton).build().perform();
			action.click(contentCreationResourcePage.pickQueNextButton).build().perform();
			//GenericFunctions.waitForElementToAppear(contentResourcePage.pickQueNextButton);
			//contentResourcePage.pickQueNextButton.click();
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.questionSetTitle);
			contentCreationResourcePage.questionSetTitle.sendKeys(objListOFTestDataForSunbird1.get(11).getCourseDescription());
			GenericFunctions.waitWebDriver(2000);
			contentCreationResourcePage.questionSetAddButton.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeContentPopup);
			createUserPage.closeContentPopup.click();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to give the title for Question Set");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to give the title for Question Set , Exception : "+e.getLocalizedMessage());
			Assert.fail("Failed to give the title for Question Set "+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: verifyCloseContentEditor method is used to verify that content editor can be closed.
	* */
	public void verifyCloseContentEditor()
	{
		String validationMsg="";
		try
		{
			//objListOFTestDataForSunbird1= ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify that content editor can be closed");
			GenericFunctions.waitForElementToAppear(createUserPage.editorCloseIcon);
			createUserPage.editorCloseIcon.click();
			GenericFunctions.waitWebDriver(2000);

			try
			{


				validationMsg=driver.switchTo().alert().getText();
				driver.switchTo().alert().dismiss();
				GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
				GenericFunctions.waitWebDriver(2000);
				createUserPage.saveCourse.click();
				GenericFunctions.waitWebDriver(3000);
				GenericFunctions.waitForElementToAppear(createUserPage.closeContentPopup);
				GenericFunctions.waitWebDriver(1000);
				createUserPage.closeContentPopup.click();
				GenericFunctions.waitWebDriver(3000);
				GenericFunctions.waitForElementToAppear(createUserPage.editorCloseIcon);
				GenericFunctions.waitWebDriver(1000);
				createUserPage.editorCloseIcon.click();
			}
			catch(Exception e)
			{
				System.out.println("Could not check for the Alert message");
			}
			GenericFunctions.waitWebDriver(3000);
			Assert.assertTrue(true);
			ExtentTestManager.getTest().log(LogStatus.PASS, "validated the message before saving the content, "+validationMsg+" is the Message");
			//Wait for 2 sec
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify and close content editor");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to verify and close content editor "+e.getLocalizedMessage());
			Assert.fail("Failed to verify and close content editor "+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: goToWorkspaceAndClick method is used to navigate to different sections in workspace.
	* */
	public void goToWorkspaceAndClick(String clickOn)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Navigate to "+clickOn +" from workspace");
			/*GenericFunctions.waitForElementToAppear(createUserPage.headerProfile);
			createUserPage.headerProfile.click();*/
			createUserPageObj.goToProfilePage();
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(1000);
			if(clickOn.equalsIgnoreCase("Up For Review"))
			{
				contentCreationResourcePage.upForReview.click();
			}	
			else if(clickOn.equalsIgnoreCase("Drafts"))
			{
				contentCreationResourcePage.drafts.click();
			}	
			else if(clickOn.equalsIgnoreCase("Published"))
			{
				contentCreationResourcePage.published.click();
			}
			else if(clickOn.equalsIgnoreCase("Limited Publishing"))
			{
				contentCreationResourcePage.limitedPublishing.click();	
			}	
			else if(clickOn.equalsIgnoreCase("Review Submissions"))
			{
				contentCreationResourcePage.reviewSubmissions.click();	

			}
			else if(clickOn.equalsIgnoreCase("All My content"))
			{
				contentCreationResourcePage.allMyActivity.click();	
			}
			else
			{
				GenericFunctions.waitWebDriver(2000);
				System.out.println("Could not navigate to "+clickOn);
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to "+clickOn +" from workspace");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to navigate to "+clickOn +" from workspace "+e.getLocalizedMessage());
			Assert.fail("Failed to navigate to "+clickOn +" from workspace"+e.getLocalizedMessage());
		}

	}
	/**
	* Purpose: verifyMyActivity_OnProfile method is used to verify my activity.
	* */
	public void verifyMyActivity_OnProfile()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify My Activity");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(orgUploadPage.dropdown);
			orgUploadPage.dropdown.click();
			GenericFunctions.waitWebDriver(2000); 
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.profileIconActivity);
			contentCreationResourcePage.profileIconActivity.click();
			String aUrl=driver.getCurrentUrl();
			GenericFunctions.waitWebDriver(2000);
			Assert.assertEquals(aUrl, eUrl, "User is not able to verify My activity dashboard");
			ExtentTestManager.getTest().log(LogStatus.PASS, "User is able to view the course dashboard on click of my activity option.");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to  from workspace");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to navigate to from workspace "+e.getLocalizedMessage());
			Assert.fail("Failed to navigate to from workspace"+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: verifyEditDetails_OfMetadataPage method is used to verify edit details in metadata page.
	* */
	public void verifyEditDetails_OfMetadataPage(List<String> metapageDetails)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify edit details in metadata page");
			//GenericFunctions.waitForElementToAppear(contentResourcePage.editorEditDetails);
			//contentResourcePage.editorEditDetails.click();
			for(int i=0;i<=metapageDetails.size();i++)
			{
				String data=metapageDetails.get(i);
				System.out.println(data);

			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to  from workspace");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to navigate to from workspace "+e.getLocalizedMessage());
			Assert.fail("Failed to navigate to from workspace"+e.getLocalizedMessage());
		}
	}
	/**
	* Purpose: createNewCollection method is used to create new collection.
	* */
	public List<String> createNewCollection()
	{
		List<String> metadataPageDetails = new ArrayList<String>();
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create new collection");
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			GenericFunctions.waitForElementToAppear(createUserPage.startCreating);
			createUserPage.startCreating.click();
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(7500);
			GenericFunctions.waitForElementToAppear(createUserPage.newChild);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(2000);
			String collectionName = objListOFTestDataForSunbird1.get(5).getCourseName()+"_"+GenericFunctions.testDataIncrementer("./testData/collectionNumbers.txt");
			
			createUserPage.collectionName.clear();
			createUserPage.collectionName.sendKeys(collectionName);
			GenericFunctions.waitWebDriver(4000);
			createUserPage.courseDescription.sendKeys(objListOFTestDataForSunbird1.get(5).getCourseDescription());
			GenericFunctions.waitForElementToAppear(createUserPage.addResource);
			createUserPage.addResource.click();
			GenericFunctions.waitForElementToAppear(createUserPage.findSelectActivities);
			GenericFunctions.waitWebDriver(1500);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create new collection");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed on creating collection");
			Assert.fail("Failed to create new collection");
		}
		return metadataPageDetails;
	}
	/**
	* Purpose: uploadAudioForEveryone method is used to upload audio accesible to all.
	* */
	public void uploadAudioForEveryone() throws InterruptedException
	{
		try
		{
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.addAudio);
			if(contentCreationResourcePage.addAudio.isEnabled())
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "User sucessfully navigated to the metadata/plugins page of resource");
			}
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload an audio for resource");
			GenericFunctions.waitWebDriver(2000);

			contentCreationResourcePage.addAudio.click();
			GenericFunctions.waitWebDriver(1000);

			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentCreationResourcePage.clickAllAudio);
			contentCreationResourcePage.clickAllAudio.click();
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.selectAudio_AllAudio);
			contentCreationResourcePage.selectAudio_AllAudio.click();*/

			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.btnUploadRecord);
			contentCreationResourcePage.btnUploadRecord.click();
			GenericFunctions.waitWebDriver(2000);
			action.click(contentCreationResourcePage.yesRadioButton).build().perform();
			//contentCreationResourcePage.yesRadioButton.click();
			GenericFunctions.waitWebDriver(2000);
			contentCreationResourcePage.audioUploadIcon.click();
			GenericFunctions.waitWebDriver(3000);
			//action.moveToElement(contentCreationResourcePage.btnChooseFile).build().perform();
			contentCreationResourcePage.btnChooseFile.click();
			String path=AllUploadingPaths.audioPath;
			
			
			GenericFunctions.uploadFile(path);

			//String secondpath = "./UploadingDocuments/Uploading audios/"+AUDIO_UPLOAD;  

			//contentCreationResourcePage.rightBtnAvailable.click();

			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentCreationResourcePage.btnUploadAndUse);
			contentCreationResourcePage.btnUploadAndUse.click();

			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentCreationResourcePage.alertMessage);
			action.moveToElement(contentCreationResourcePage.alertMessage);
			String actualAlertMessage = contentCreationResourcePage.alertMessage.getText();						
			String expectedAlertMessage = "Audio successfully uploaded";		
			
			System.out.println("expectedAlertMessage-"+expectedAlertMessage+", actualAlertMessage-"+actualAlertMessage);
			Assert.assertEquals(actualAlertMessage, expectedAlertMessage);
			Assert.assertTrue(true);
			System.out.println("Passed Assert");
			GenericFunctions.waitWebDriver(7000);
			action.moveToElement(contentCreationResourcePage.verifyAudioName).build().perform();
			String uploadedAudioName = contentCreationResourcePage.verifyAudioName.getText();
			System.out.println(uploadedAudioName);
			if(AUDIO_UPLOAD.contains(uploadedAudioName))
			{
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "Audio is uploaded sucesssfully to the resource");

			}
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(contentCreationResourcePage.xWindowCloseButton);
			contentCreationResourcePage.xWindowCloseButton.click();
			GenericFunctions.waitWebDriver(5000);

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to upload an audio");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to upload an audio"+e.getLocalizedMessage());
		}

	}
}
