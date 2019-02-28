package org.testscript.creator;

import org.generic.GenericFunctions;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyCreatorAndReviewerSameOwnershipTypeValueForUploadedContent extends BaseTest 
{
	//TC_634
	@Test(groups= {"newfeature","regression1"})
	public void verifyCreatorAndReviewerHasOwnershipTypeValueOfUploadedContent() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		GenericFunctions genericMethods = new GenericFunctions();

		//Step 1 : Login As Content creator
		signupObj.userLogin(CREATOR);

		//Step 2,3 and 4 : Navigate to workspace and upload content-Epub and send the content for review
		String contentName=creatorUserPageObj.uploadContentMp4(EPUB);
		
		String result[] = contentName.split("/");
		System.out.println(result[0]+" and "+result[1]);
		//Logout as creator
		signupObj.userLogout();
		
		//Step 5 : Login as Content Reviewer
		signupObj.userLogin(REVIEWER);
		
		//Step 6 : Navigate to Up For Review
		genericMethods.navigateToWorkspaceFeatures(UP_FOR_REVIEW);
		
		//Step 7 : Click on the created content from Up For Review section
		workspacePageObj.openTheCreatedContentFromUpForReview(result[0]);
		
		//Step 8 :  Check the OWNERSHIP field value
		workspacePageObj.verifyownershipTypeValueOfTheContent(result[1],null);
		
		//Step 9 :Logout as Reviewer
		signupObj.userLogout();
		
	}

}
