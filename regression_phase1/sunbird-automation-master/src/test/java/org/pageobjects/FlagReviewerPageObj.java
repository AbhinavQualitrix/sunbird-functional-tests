package org.pageobjects;

import java.util.List;
import java.util.Random;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorUserPage;
import org.page.FlagReviewerPage;
import org.page.PublicUserPage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
/**
* Created by Qualitrix Technologies Pvt Ltd.
* Purpose: Class file to segregate complete functional methods related to flag reviewer role and its feature
*/
public class FlagReviewerPageObj extends BaseTest
{
	FlagReviewerPage flagReviewerPage = PageFactory.initElements(driver, FlagReviewerPage.class);
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	CreatorUserPage creatorPage = PageFactory.initElements(driver, CreatorUserPage.class);
	List <TestDataForDiksha> objListOFTestDataForSunbird1= null ;
	Random rand = new Random();
	Actions action = new Actions(driver);
	JavascriptExecutor js = (JavascriptExecutor)driver;

	/**
	* Purpose: flaggedUpForReview() method is used to search the course and flag up for review
	*/
	public void flaggedUpForReview()
	{	

		//Click a random course from My courses section
		publicUserPage.headerProfile.click();
		publicUserPage.searchBar.sendKeys(SEARCH_COURSES);
		publicUserPage.clickSearch.click();
		GenericFunctions.waitWebDriver(3000);
		int randomCourse=rand.nextInt(flagReviewerPage.coursesSearched.size());
		flagReviewerPage.coursesSearched.get(randomCourse).click();
		String getCourseName=flagReviewerPage.clikedCourseContentName.getText();
		GenericFunctions.waitWebDriver(3000);

		//GenericFunctions.waitForElementToAppear(flagReviewerPage.flagIcon);
		flagReviewerPage.flagIcon.click();
		GenericFunctions.waitWebDriver(2000);
		randomReasonForFlag();
		GenericFunctions.waitWebDriver(3000);
		//Search and click on a random Content from Popular Books section
	}
	
	/**
	* Purpose: genericContentSearch() method is used to search the content
	*/
	public String genericContentSearch()
	{
		GenericFunctions.waitForElementToAppear(creatorPage.headerLibrary);
		publicUserPage.headerLibrary.click();
		publicUserPage.searchBar.sendKeys(SEARCH_LIBRARIES);
		GenericFunctions.waitForElementToAppear(flagReviewerPage.popularBooksHeader);
		String contentName=flagReviewerPage.contentsSearched.getText();
		flagReviewerPage.contentsSearched.click();

		System.out.println(contentName);
		//flagReviewerPage.contentsSearched.get(randomContent).click();
		//String getContentName=flagReviewerPage.clikedCourseContentName.getText();
		GenericFunctions.waitForElementToAppear(flagReviewerPage.flagIcon);
		flagReviewerPage.flagIcon.click();
		GenericFunctions.waitWebDriver(2000);
		randomReasonForFlag();
		return contentName;

	}
	
	/**
	* Purpose: randomReasonForFlag() method is used to flag the content with random reason
	*/
	public void randomReasonForFlag()
	{
		//Select a random reject reason for a flag
		int randomreason=rand.nextInt(flagReviewerPage.flagReason.size());
		GenericFunctions.waitWebDriver(3000);
		//GenericFunctions.waitForElements(flagReviewerPage.flagReason);
		flagReviewerPage.flagReason.get(randomreason).click();
		//Give a random comment for the comment box
		String randcourse = (flagReviewerPage.randomComments[rand.nextInt(flagReviewerPage.randomComments.length)]);
		flagReviewerPage.addComment.sendKeys(randcourse);
		GenericFunctions.waitWebDriver(2000);
		flagReviewerPage.submitButton.click();
	}

	/**
	* Purpose: flagged_UpforReview() method is used to flag the content in up for review bucket
	*/
	public void flagged_UpforReview()
	{
		publicUserPage.headerProfile.click();
		GenericFunctions.waitForElementToAppear(creatorPage.workSpace);
		creatorPage.workSpace.click();
		GenericFunctions.waitWebDriver(2000);
		flagReviewerPage.flaggedContent.click();	
		System.out.println(driver.getCurrentUrl()+"Reviwer has FLAGGED bucket access");
		GenericFunctions.waitWebDriver(1000);
		flagReviewerPage.upForReview.click();
		GenericFunctions.waitWebDriver(2000);
		System.out.println(driver.getCurrentUrl()+"Reviewer has UP FOR REVIEW bucket access");
	}

	/**
	* Purpose: courseSearchAndFlagIt() method is used to searching a course and flag it
	*/
	public String courseSearchAndFlagIt()
	{
		GenericFunctions.waitForElementToAppear(publicUserPage.headerCourses);
		publicUserPage.headerCourses.click();
		GenericFunctions.waitForElementToAppear(flagReviewerPage.latestCourses);
		int courseSize = flagReviewerPage.courseMy.size();
		int i=0;
		String elementArray[]=new String[courseSize];
		for(WebElement ele:flagReviewerPage.courseMy)
		{
			GenericFunctions.waitWebDriver(2000);
			if(ele.isDisplayed())
			{
				String eleText=ele.getText();
				System.out.println(eleText);
				elementArray[i]=eleText;
				i++;
				GenericFunctions.waitWebDriver(2000);
			}
			else
			{
				GenericFunctions.waitWebDriver(2000);
				flagReviewerPage.myCourseNextuBtton.click();
				GenericFunctions.waitWebDriver(2000);
				elementArray[i]=flagReviewerPage.courseMyFifth.getText();
			}
		}

		for(String data:elementArray)
		{
			System.out.println(data+" ");
		}


		String randomCourseSearch = (elementArray[new Random().nextInt(elementArray.length)]);
		System.out.println("----------------------------");
		System.out.println(randomCourseSearch);
		System.out.println("----------------------------");
		//To click on a any random course from the course

		try
		{
			publicUserPage.searchBar.clear();
			publicUserPage.searchBar.sendKeys(randomCourseSearch);
			publicUserPage.clickSearch.click();
			GenericFunctions.waitWebDriver(3000);
			if(randomCourseSearch.equalsIgnoreCase(publicUserPage.courseToBeClicked.getText()))
			{
				publicUserPage.courseToBeClicked.click();
				GenericFunctions.waitWebDriver(2000);
				if(flagReviewerPage.flagIcon.isDisplayed())
				{
					GenericFunctions.waitWebDriver(2000);
					flagReviewerPage.flagIcon.click();
					randomReasonForFlag();
					System.out.println("Flagged the Course");
				}
				else
				{
					driver.navigate().back();
					publicUserPage.searchBar.clear();
					GenericFunctions.waitWebDriver(2000);
					String randomCourseSearch1 = (elementArray[new Random().nextInt(elementArray.length)]);
					publicUserPage.searchBar.sendKeys(randomCourseSearch1);
					publicUserPage.courseToBeClicked.click();
					GenericFunctions.waitForElementToAppear(flagReviewerPage.flagIcon);
					flagReviewerPage.flagIcon.click();
					randomReasonForFlag();
					System.out.println("Flagged the Course");

				}
			}

		}
		catch(Exception e)
		{
			System.out.println( "exception occured on searching the course- " + e);
		}


		GenericFunctions.refreshWebPage();
		GenericFunctions.waitWebDriver(2000);
		try
		{
			System.out.println(flagReviewerPage.courseFlaggedMessage.getText());
		}
		catch(Exception e)
		{
			System.out.println("Exception occured while capturing message"+e);
		}
		return randomCourseSearch;
	}	

	/**
	* Purpose: acceptDiscardFlag() method is used to accept the flagged content
	*/
	public void acceptDiscardFlag(String acceptDiscard)
	{
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
		publicUserPage.headerProfile.click();
		GenericFunctions.waitForElementToAppear(creatorPage.workSpace);
		creatorPage.workSpace.click();
		GenericFunctions.waitForElementToAppear(flagReviewerPage.flagged);
		flagReviewerPage.flagged.click();
		try
		{
			GenericFunctions.waitWebDriver(2000);
			System.out.println(creatorPage.getCourseName.getText());
			creatorPage.getCourseName.click();
			GenericFunctions.waitWebDriver(1500);		
			GenericFunctions.WaitForFrameAndSwitchToIt(creatorPage.iFrame);
			GenericFunctions.waitWebDriver(3500);


			if(acceptDiscard.equalsIgnoreCase("accept"))
			{
				GenericFunctions.waitWebDriver(2000);
				flagReviewerPage.acceptGreyButton.click();
			}
			else if(acceptDiscard.equalsIgnoreCase("discard"))
			{
				GenericFunctions.waitWebDriver(2000);
				flagReviewerPage.discardGreyButton.click();
				GenericFunctions.waitWebDriver(2000);
			}


		}
		catch(Exception e)
		{
			System.out.println("Exception in Accpeting/Rejecting the flag "+e);
		}
	}

	/**
	* Purpose: acceptDiscardBlue() method is used to discard the flagged content
	*/
	public void acceptDiscardBlue(String acceptDiscard)
	{
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
		publicUserPage.headerProfile.click();
		GenericFunctions.waitForElementToAppear(creatorPage.workSpace);
		creatorPage.workSpace.click();
		GenericFunctions.waitForElementToAppear(flagReviewerPage.flagged);
		flagReviewerPage.flagged.click();
		try
		{
			GenericFunctions.waitWebDriver(2000);
			System.out.println(creatorPage.getCourseName.getText());
			creatorPage.getCourseName.click();
			/*GenericFunctions.waitWebDriver(1500);		
			GenericFunctions.WaitForFrameAndSwitchToIt(creatorPage.iFrame);
			GenericFunctions.waitWebDriver(3500);
			 */
			GenericFunctions.waitWebDriver(3500);
			if(acceptDiscard.equalsIgnoreCase("accept"))
			{
				GenericFunctions.waitForElementToAppearOnScreen(flagReviewerPage.acceptBlueButton);
				GenericFunctions.scrollToElement(flagReviewerPage.acceptBlueButton);
				flagReviewerPage.acceptBlueButton.click();
				GenericFunctions.waitWebDriver(1500);
				System.out.println("Accepted the flag");
				//flagReviewerPage.acceptGreyButton.isDisplayed();
			}
			else if(acceptDiscard.equalsIgnoreCase("discard"))
			{
				GenericFunctions.waitForElementToAppearOnScreen(flagReviewerPage.discardBlueButton);
				GenericFunctions.scrollToElement(flagReviewerPage.discardBlueButton);
				flagReviewerPage.discardBlueButton.click();
				System.out.println("Rejected the flag");
				//flagReviewerPage.acceptGreyButton.isDisplayed();
			}
		}
		catch(Exception e)
		{
			System.out.println("Exception in accepting / Rejecting flag in Blue button ");
		}
	}

	/**
	* Purpose: flagCourseContent() method is used to flag the course content
	*/
	public String flagCourseContent()
	{
		objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		GenericFunctions.waitTillTheElementIsVisibleAndClickable(creatorPage.headerCourse);
		creatorPage.headerCourse.click();
		GenericFunctions.waitWebDriver(2000);
		/*publicUserPage.searchBar.clear();
		publicUserPage.searchBar.sendKeys(objListOFTestDataForSunbird1.get(0).getCourseName()+"C");
		publicUserPage.clickSearch.click();*/
		GenericFunctions.waitForElementToAppear(flagReviewerPage.myCourses);
		GenericFunctions.waitWebDriver(3000);
		String courseName=flagReviewerPage.courseMyCourses2.getText();
		flagReviewerPage.courseMyCourses2.click();
		GenericFunctions.waitForElementToAppear(flagReviewerPage.flagIcon);
		//if(flagReviewerPage.flagIcon.isDisplayed())

		GenericFunctions.waitWebDriver(2000);
		flagReviewerPage.flagIcon.click();
		randomReasonForFlag();
		System.out.println("Flagged the Course");
		return courseName;
	}

	/**
	* Purpose: checkCourseInCourses() method is used to search courses 
	*/
	public String checkCourseInCourses(String courseToSearch)
	{
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.refreshWebPage();
		GenericFunctions.waitForElementToAppear(creatorPage.headerCourse);
		creatorPage.headerCourse.click();
		publicUserPage.searchBar.click();
		publicUserPage.searchBar.sendKeys(courseToSearch);
		publicUserPage.clickSearch.click();
		//GenericFunctions.waitForElementToAppear(flagReviewerPage.searchedCourse);
		GenericFunctions.waitWebDriver(3000);
		String courseName=flagReviewerPage.searchedCourse.getText();
		System.out.println(courseName);
		return courseName;

	}

	/**
	* Purpose: checkContentInLib() method is used to search content in Library 
	*/
	public String checkContentInLib()
	{
		GenericFunctions.waitForElementToAppear(creatorPage.headerLibrary);
		publicUserPage.headerLibrary.click();
		GenericFunctions.waitForElementToAppear(flagReviewerPage.popularBooksHeader);

		/*publicUserPage.searchBar.sendKeys(SEARCH_LIBRARIES);
		publicUserPage.clickSearch.click();
		 */
		String contentName=flagReviewerPage.contentsSearched.getText();
		GenericFunctions.waitWebDriver(2000);
		System.out.println(contentName);
		return contentName;
	}

	/**
	* Purpose: searchAndFlagResource() method is used to search and flag a resource 
	*/
	public void searchAndFlagResource(String resourceToSearch) 
	{
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.waitTillTheElementIsVisibleAndClickable(creatorPage.searchInput);
		creatorPage.searchInput.sendKeys(resourceToSearch);
		creatorPage.searchIcon.click();
		GenericFunctions.waitWebDriver(2000);
		creatorPage.getCourseName.click();
		GenericFunctions.waitForElementToAppear(flagReviewerPage.flagIcon);
		flagReviewerPage.flagIcon.click();
		GenericFunctions.waitWebDriver(2000);
		randomReasonForFlag();
		System.out.println("Flagged Resource is "+resourceToSearch);
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.refreshWebPage();
	}

	/**
	* Purpose: editAndSubmitContent() method is used for modifying and submitting the content 
	*/
	public void editAndSubmitContent()
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird=null;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
		publicUserPage.headerProfile.click();
		GenericFunctions.waitForElementToAppear(creatorPage.workSpace);
		creatorPage.workSpace.click();
		GenericFunctions.waitWebDriver(2000);
		creatorPage.drafts.click();
		String contentToAssert = objListOFTestDataForSunbird.get(6).getCourseName()+GenericFunctions.readFromNotepad("./TestData/resourceNumbers.txt").toString();
		System.out.println(creatorPage.getCourseName.getText());
		if(contentToAssert.startsWith("Automation Resource"))//)
			//if(contentToAssert.contains(creatorPage.getCourseName.getText()))
		{
			creatorPage.getCourseName.click();
			//Adding a SLide so that it gets edited
			//GenericFunctions.waitForElementToAppear(flagReviewerPage.contentTitleTopLeft);
			GenericFunctions.waitWebDriver(6500);
			GenericFunctions.WaitForFrameAndSwitchToIt(creatorPage.iFrame);
			GenericFunctions.waitWebDriver(7000);
			flagReviewerPage.addSlide.click();
			GenericFunctions.waitWebDriver(2500);
			creatorPage.saveCourse.click();
			GenericFunctions.waitWebDriver(2500);
			creatorPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(3000);
			creatorPage.sendForReview.click();
			GenericFunctions.waitWebDriver(3000);
			creatorPage.saveButton.click();
			GenericFunctions.waitWebDriver(6500);
			GenericFunctions.refreshWebPage();
		}	
		else
		{
			System.out.println(contentToAssert +"Course is not found in Drafts to Edit");
		}
	}

	/**
	* Purpose: publishRequestChanges() method is used for modifying and publishing the changes  
	*/
	public String publishRequestChanges(String publishRequest)
	{
		String contentNumber="";
		List <TestDataForDiksha> objListOFTestDataForSunbird=null;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

		GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
		publicUserPage.headerProfile.click();
		GenericFunctions.waitForElementToAppear(creatorPage.workSpace);
		creatorPage.workSpace.click();
		GenericFunctions.waitWebDriver(1500);
		creatorPage.upForReview.click();
		contentNumber = objListOFTestDataForSunbird.get(6).getCourseName()+GenericFunctions.readFromNotepad("./TestData/resourceNumbers.txt").toString();
		creatorPage.searchForReview.click();
		creatorPage.searchForReview.sendKeys(contentNumber);
		creatorPage.searchIcon.click();
		GenericFunctions.waitWebDriver(3500);
		creatorPage.searchedContentForPublish.click();
		GenericFunctions.waitWebDriver(3500);
		if(publishRequest.equalsIgnoreCase("publish"))
		{
			GenericFunctions.waitForElementToAppear(creatorPage.publishResource);
			GenericFunctions.scrollToElement(creatorPage.publishResource);
			creatorPage.publishResource.click();
			GenericFunctions.waitWebDriver(4000);
			for(int i=0;i<creatorPage.checkbox.size();i++)	
			{
				creatorPage.checkbox.get(i).click();
			}
			System.out.println("Checked all CBs");
			GenericFunctions.waitWebDriver(4000);	
			GenericFunctions.waitForElementToAppear(creatorPage.popupPublishButton);
			creatorPage.popupPublishButton.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(3000);
			System.out.println("Content published sucessfully");
		}
		else if(publishRequest.contains("request"))
		{
			GenericFunctions.waitForElementToAppear(creatorPage.clickRequestChanges);
			GenericFunctions.scrollToElement(creatorPage.clickRequestChanges);
			GenericFunctions.waitWebDriver(2500);
			//Giving reasons 
			creatorPage.clickRequestChanges.click();
			//GenericFunctions.waitForElementToAppear(creatorPage.rejectReason1);
			GenericFunctions.waitWebDriver(2500);
			creatorPage.rejectReason1.click();
			creatorPage.rejectReason2.click();
			creatorPage.rejectReason3.click();
			String rejectReason = (REVIEW_COMMENTS[new Random().nextInt(REVIEW_COMMENTS.length)]);
			creatorPage.reviewComments.click();
			creatorPage.reviewComments.sendKeys(rejectReason);
			creatorPage.requestChangesButton.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(3000);
			System.out.println("Content requested for changes sucessfully");
		}
		return contentNumber;

	}

	/**
	* Purpose: recheckInDrafts() method is used for checking the course exists in review section
	* even after publishing the changes  
	*/
	public void recheckInDrafts(String contentToCheckDrafts)
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird=null;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.waitForElementToAppear(publicUserPage.headerProfile);
		publicUserPage.headerProfile.click();
		GenericFunctions.waitForElementToAppear(creatorPage.workSpace);
		creatorPage.workSpace.click();
		GenericFunctions.waitWebDriver(2000);
		creatorPage.drafts.click();
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.waitForElementToAppearOnScreen(creatorPage.getCourseName);
		creatorPage.getCourseName.click();
		//Adding a SLide so that it gets edited
		//GenericFunctions.waitForElementToAppear(flagReviewerPage.contentTitleTopLeft);
		GenericFunctions.waitWebDriver(6500);
		GenericFunctions.WaitForFrameAndSwitchToIt(creatorPage.iFrame);
		GenericFunctions.waitWebDriver(7000);
		if(contentToCheckDrafts.equalsIgnoreCase(flagReviewerPage.contentTitleTopLeft.getText()))
		{
			System.out.println("Content is present in Drafts");
		}
		else 
		{
			System.out.println("Content is not present in Drafts");
		}
		creatorPage.editorCloseIcon.click();
		GenericFunctions.waitWebDriver(2000);
	}
}
