package org.testscript.creator;

import org.generic.GenericFunctions;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyOwnershipTypeDdlValueContentWhenOpenedFromAllMyContentSection extends BaseTest
{
	//TC_635
	@Test(groups= {"newfeature","regression2"})
	public void verifyOwnershipTypeDdlValueContentWhenOpenedFromAllMyContentSection() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		GenericFunctions genericMethods = new GenericFunctions();

		//Step 1 : Login As Content creator
		signupObj.userLogin(CREATOR);

		//Step 2 : Navigate to All My Content Section
		genericMethods.navigateToWorkspaceFeatures(ALL_MY_CONTENT);

		//Step 3 : Select Collection from and verify Ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromAllMyContent(CONTENT_TO_FIND[0]);

		//Step 4 : Navigate to All My Content Section
		genericMethods.navigateToWorkspaceFeatures(ALL_MY_CONTENT);

		//Step 5 : Select TextBook from and verify Ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromAllMyContent(CONTENT_TO_FIND[1]);


		//Step 4 : Navigate to All My Content Section
		genericMethods.navigateToWorkspaceFeatures(ALL_MY_CONTENT);

		//Step 5 : Select LessonPlan from and verify Ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromAllMyContent(CONTENT_TO_FIND[2]);

		//Step 4 : Navigate to All My Content Section
		genericMethods.navigateToWorkspaceFeatures(ALL_MY_CONTENT);

		//Step 5 : Select Course from and verify Ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromAllMyContent(CONTENT_TO_FIND[3]);

		//Step 4 : Navigate to All My Content Section
		genericMethods.navigateToWorkspaceFeatures(ALL_MY_CONTENT);

		//Step 5 : Select Resource from and verify Ddl value of ownershipType
		workspacePageObj.findParameterizedContentFromAllMyContent(CONTENT_TO_FIND[4]);

	}

}
