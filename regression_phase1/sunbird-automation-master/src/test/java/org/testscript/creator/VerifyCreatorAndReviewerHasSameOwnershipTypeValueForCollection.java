package org.testscript.creator;

import org.generic.GenericFunctions;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyCreatorAndReviewerHasSameOwnershipTypeValueForCollection extends BaseTest 
{
	//TC_632
	@Test(groups= {"newfeature","regression1"})
	public void verifyCreatorAndReviewerHasSameOwnershipTypeForCollection() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		GenericFunctions genericMethods = new GenericFunctions();

		//Step 1 : Login As Content creator
		signupObj.userLogin(CREATOR);

		//Step 2 : navigate to workspace to create COLLECTION
		String contentNameAndValue =creatorUserPageObj.createCollection();
		String result[] =contentNameAndValue.split("/");
		GenericFunctions.refreshWebPage();

		//Logout as Creator
		signupObj.userLogout();

		//Step 3 : Login as Reviewer
		signupObj.userLogin(REVIEWER);	

		//Step 4 : Navigate to Up For Review
		genericMethods.navigateToWorkspaceFeatures(UP_FOR_REVIEW);

		//Step 5 : Click on the created content from Up For Review section
		workspacePageObj.openTheCreatedContentFromUpForReview(result[0]);

		//Step 6 :  Check the OWNERSHIP field value
		workspacePageObj.verifyownershipTypeValueOfTheContent(null,result[1]);

		//Step 7 :Logout as Reviewer
		signupObj.userLogout();
	}

}
