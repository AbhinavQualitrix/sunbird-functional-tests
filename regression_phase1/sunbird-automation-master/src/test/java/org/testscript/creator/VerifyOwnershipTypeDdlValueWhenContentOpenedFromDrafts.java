package org.testscript.creator;

import org.generic.GenericFunctions;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyOwnershipTypeDdlValueWhenContentOpenedFromDrafts extends BaseTest
{
	//TC_638
	@Test(groups= {"newfeature","regression2"})
	public void verifyOwnershipTypeDropdownContentWhenOpenedFromDrafts() throws Exception	
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		GenericFunctions genericMethods = new GenericFunctions();

		//Login As Content creator
		signupObj.userLogin(CREATOR);

		//Navigate to Drafts section
		genericMethods.navigateToWorkspaceFeatures(DRAFTS);

		//Click Drafts , select Collection and verify ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromWorkspace(CONTENT_TO_FIND[0]);

		//Navigate to Drafts section
		genericMethods.navigateToWorkspaceFeatures(DRAFTS);

		//Click Drafts , select Textbook and verify ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromWorkspace(CONTENT_TO_FIND[1]);

		//Navigate to Drafts section
		genericMethods.navigateToWorkspaceFeatures(DRAFTS);

		//Click Drafts , select LessonPlan and verify ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromWorkspace(CONTENT_TO_FIND[2]);
		
		//Navigate to Drafts section
		genericMethods.navigateToWorkspaceFeatures(DRAFTS);

		//Click Drafts , select Course and verify ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromWorkspace(CONTENT_TO_FIND[3]);
		
		//Navigate to Drafts section
		genericMethods.navigateToWorkspaceFeatures(DRAFTS);

		//Click Drafts , select Resource and verify ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromWorkspace(CONTENT_TO_FIND[4]);
		
		//Logout as Creator
		signupObj.userLogout();


	}

}//////////////////////////////// 598 TAKE UP NEXT 
