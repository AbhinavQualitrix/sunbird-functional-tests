package org.testscript.creator;

import org.generic.GenericFunctions;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyCreatorAndReviewerHasSameOwnershipTypeValueForCourse extends BaseTest
{
	@Test(groups= {"newfeature","regression1"})
	public void verifyCreatorAndReviewerHasSameOwnershipTypeValueForCourse() throws Exception
	{

		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		GenericFunctions genericMethods = new GenericFunctions();

		//Step 1 : Login As Content creator
		signupObj.userLogin(REVIEWER);
		
		//
		//creatorUserPageObj.createCourse();
		genericMethods.navigateToWorkspaceFeatures(UP_FOR_REVIEW);
		
		
		//genericMethods.navigateToWorkspaceFeatures(REVIEW_SUBMISSION);
		
		genericMethods.navigateToWorkspaceFeatures(COLLABORATIONS);
	}
}


