package org.testscript.creator;

import org.generic.GenericFunctions;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyOwnersipTypeDdlValueContentWhenOpenedFromLimitedPublishing extends BaseTest 
{
	//TC_637
	@Test(groups= {"newfeature","regression1"})
	public void verifyOwnershipTypeDropdownContentWhenOpenedFromLP() throws Exception
	{

		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		GenericFunctions genericMethods = new GenericFunctions();

		//Step 1 & 2 : Login As Content creator
		signupObj.userLogin(CREATOR);

		//Step 3 : Navigate to Limited Publishing Section 
		genericMethods.navigateToWorkspaceFeatures(LIMITED_PUBLISHING);

		//Step 4  & 5 : Select Collection and verify ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromWorkspace(CONTENT_TO_FIND[0]);
		//workspacePageObj.createContentWhichNotFoundInDrafts(COLLECTION);


		//Step 6a : Navigate to Limited Publishing Section 
		genericMethods.navigateToWorkspaceFeatures(LIMITED_PUBLISHING);

		//Step 6b : Select Book and verify ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromWorkspace(CONTENT_TO_FIND[1]);

		//Step 7a : Navigate to Limited Publishing Section 
		genericMethods.navigateToWorkspaceFeatures(LIMITED_PUBLISHING);

		//Step 7b : Select LessonPlan and verify ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromWorkspace(CONTENT_TO_FIND[2]);

		//Step 8a : Navigate to Limited Publishing Section 
		genericMethods.navigateToWorkspaceFeatures(LIMITED_PUBLISHING);


		// Step 8b : Select Course and verify ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromWorkspace(CONTENT_TO_FIND[3]);

		//Step 9a : Navigate to Limited Publishing Section 
		genericMethods.navigateToWorkspaceFeatures(LIMITED_PUBLISHING);

		// Step 9b : Select Resource and verify ddl value of ownershipType		
		workspacePageObj.findParameterizedContentFromWorkspace(CONTENT_TO_FIND[4]);


	}


}
