package org.testscript.skippedfunctionality;

import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.FlagReviewerPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class CheckTheflaggedContentINDraft extends BaseTest
{
	@Test(groups= {"skippedfunctionality"})
	public void checkTheflaggedContentINDraft() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		
		SignUpPageObj signUpPageObj = new SignUpPageObj();
		FlagReviewerPageObj flagReviewer = new FlagReviewerPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step 1: Login as content creator
		signUpPageObj.userLogin(CREATOR);
		
		//Step 2: Navigate to workspace
		creatorUserPageObj.navigateToWorkspace(RESOURCE);
		
		//Step 3: Create new Course
		creatorUserPageObj.createResource(objListOFTestDataForSunbird);
		
		//Step 4:Save and send resource for review
		creatorUserPageObj.saveAndSendResouceForReview();
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.refreshWebPage();
		
		//Step 5:Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(RESOURCE,objListOFTestDataForSunbird);
		GenericFunctions.waitWebDriver(3000);
		
		//Step 6: Logout as Creator
		signUpPageObj.userLogout();
		
		//Step 7:Login as Reviewer
		signUpPageObj.userLogin(REVIEWER);
		
		//Step 8:Search the course which was submitted for review
		GenericFunctions.waitWebDriver(2000);
		String resourceToSearch=creatorUserPageObj.searchInUpForReview(RESOURCE,objListOFTestDataForSunbird);
		
		//Step 7:publish the resource and search it
		creatorUserPageObj.resourcePublishAndSearch(objListOFTestDataForSunbird);
		
		//Step 8: logout as Reviewer
		signUpPageObj.userLogout();	
		
		
		//Step 9:	String resourceToSearch ="Automation ResourceR0024";
		//Now Login As Public user
		signUpPageObj.userLogin(PUBLICUSER1);
		
		//Step 10:Search the resource and flag it
		flagReviewer.searchAndFlagResource(resourceToSearch);
		
		//Step 11: Logout as public user
		signUpPageObj.userLogout();
		
		//Step 12:Login as Flag reviewer
		signUpPageObj.userLogin(FLAGREVIEWER);
		
		//Step 13:Open the content - Accept the flag
		flagReviewer.acceptDiscardBlue(ACCEPT);
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.refreshWebPage();
		
		//Step 14: Logout as Flag reviewer
		signUpPageObj.userLogout();
		
		//Step 15:Login as Content creator
		signUpPageObj.userLogin(CREATOR);
		
		//Go to the Drafts,open the content, 
		//Step 16:Edit the content and again submit for review 
		flagReviewer.editAndSubmitContent();
		GenericFunctions.waitWebDriver(3000);	
		
		//Step 17: Logout as Content Creator
		signUpPageObj.userLogout();
		GenericFunctions.waitWebDriver(3000);
		
		//Step 18:Login as Flag reviewer
		signUpPageObj.userLogin(FLAGREVIEWER);
		
		//Step 19 : Go to Up for review and reject the content
		String contentToCheckDrafts=flagReviewer.publishRequestChanges(REQUESTCHANGES);
		GenericFunctions.waitWebDriver(3000);
		GenericFunctions.refreshWebPage();
		
		//Step 20: Logout as FlagReviewer
		signUpPageObj.userLogout();
		
		//Step 21: Login As Content Creator to again in Drafts-STEP 16
		signUpPageObj.userLogin(CREATOR);
		
		//Step 22: Go to drafts and check for content
		flagReviewer.recheckInDrafts(contentToCheckDrafts);
		
		//Step 23:  Logout as Creator
		signUpPageObj.userLogout();
	}

}
