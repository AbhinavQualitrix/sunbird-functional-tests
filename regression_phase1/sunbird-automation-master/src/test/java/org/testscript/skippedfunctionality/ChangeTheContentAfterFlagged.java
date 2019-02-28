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

public class ChangeTheContentAfterFlagged extends BaseTest
{
	@Test(groups= {"skippedfunctionality"})
	public void changeTheContentAfterFlagged() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		SignUpPageObj signUpPageObj = new SignUpPageObj();
		FlagReviewerPageObj flagReviewer = new FlagReviewerPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step1: Login as content creator
		signUpPageObj.userLogin(CREATOR);
		
		//Step2: Navigate to workspace	
		creatorUserPageObj.navigateToWorkspace(RESOURCE);
		
		//Step3: Create new Course
		creatorUserPageObj.createResource(objListOFTestDataForSunbird);
		
		//Step4: Save and send resource for review
		creatorUserPageObj.saveAndSendResouceForReview();
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.refreshWebPage();
		
		//Step5:  Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(RESOURCE,objListOFTestDataForSunbird);
		GenericFunctions.waitWebDriver(3000);
		
		//Step6: Logout as Creator
		signUpPageObj.userLogout();
		
		
		//Step7: Login as Reviewer
		signUpPageObj.userLogin(REVIEWER);
		
		//Step8: Search the course which was submitted for review
		GenericFunctions.waitWebDriver(2000);
		String resourceToSearch=creatorUserPageObj.searchInUpForReview(RESOURCE,objListOFTestDataForSunbird);
		
		//Step9: publish the resource and search it
		creatorUserPageObj.resourcePublishAndSearch(objListOFTestDataForSunbird);
		
		//Step10: logout as Reviewer
		signUpPageObj.userLogout();	
		
		//String resourceToSearch ="Automation ResourceR0024";
		//Step11: Now Login As Public user
		signUpPageObj.userLogin(PUBLICUSER1);
		
		//Step12: Search the resource and flag it
		flagReviewer.searchAndFlagResource(resourceToSearch);
		
		//Step13: Logout as public user
		signUpPageObj.userLogout();
		
		//Step14: Login as Flag reviewer
		signUpPageObj.userLogin(FLAGREVIEWER);
		
		//Step15: Open the content - Accept the flag
		flagReviewer.acceptDiscardBlue(ACCEPT);
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.refreshWebPage();
		
		//Step16: Logout as Flag reviewer
		signUpPageObj.userLogout();
		
		//Step17: Login as Content creator
		signUpPageObj.userLogin(CREATOR);
		
		//Go to the Drafts,open the content, 
		//Step18: Edit the content and again submit for review 
		flagReviewer.editAndSubmitContent();
		GenericFunctions.waitWebDriver(3000);
		GenericFunctions.refreshWebPage();
		GenericFunctions.waitWebDriver(3000);	
		
		//Step19: Logout as Content Creator
		signUpPageObj.userLogout();
		
		//Step20: Login as Flag reviewer
		signUpPageObj.userLogin(FLAGREVIEWER);
		
		//Step21: Publish the content
		flagReviewer.publishRequestChanges(PUBLISH);
		
		//Step22: Logout as FlagReviewer
		signUpPageObj.userLogout();
		
	}
}
