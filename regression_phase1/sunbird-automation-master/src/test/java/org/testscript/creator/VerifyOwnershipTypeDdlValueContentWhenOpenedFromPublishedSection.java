package org.testscript.creator;

import org.generic.GenericFunctions;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyOwnershipTypeDdlValueContentWhenOpenedFromPublishedSection extends BaseTest 
{
	//TC_636
	@Test(groups= {"newfeature","regression2"})
	public void verifyOwnershipTypeDdlValueContentWhenOpenedFromPublishedSection() throws  Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		GenericFunctions genericMethods = new GenericFunctions();

		//Step 1 : Login As Content creator
		signupObj.userLogin(CREATOR);

		//Step 2 : Navigate to Published Section
		genericMethods.navigateToWorkspaceFeatures(PUBLISHED);

		//Step 3 : Select Collection from and verify Ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromWorkspace(CONTENT_TO_FIND[0]);

		//Step 4 : Navigate to Published Section
		genericMethods.navigateToWorkspaceFeatures(PUBLISHED);

		//Step 5 : Select Book from and verify Ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromWorkspace(CONTENT_TO_FIND[1]);

		//Step 6 : Navigate to Published Section
		genericMethods.navigateToWorkspaceFeatures(PUBLISHED);

		//Step 7 : Select LessonPlan from and verify Ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromWorkspace(CONTENT_TO_FIND[2]);

		//Step 8 : Navigate to Published Section
		genericMethods.navigateToWorkspaceFeatures(PUBLISHED);

		//Step 9 : Select Course from and verify Ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromWorkspace(CONTENT_TO_FIND[3]);

		//Step 10 : Navigate to Published Section
		genericMethods.navigateToWorkspaceFeatures(PUBLISHED);

		//Step 11 : Select Course from and verify Ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromWorkspace(CONTENT_TO_FIND[4]);

	}



}
