package org.testscript.creator;

import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyOwnershipTypeDropdownAndSelectValueWhenOpenedFromAllUploads extends BaseTest
{
	//TC_640
	@Test(groups= {"newfeature","regression1"})
	public void verifyOwnershipTypeDropdown() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		CreatorUserPageObj createUserpageObj = new CreatorUserPageObj();
		
		//Login As Content creator
		signupObj.userLogin(CREATOR);
		
		//Navigate to workspace
		createUserpageObj.navigateToWorkspace(UPLOADCONTENT);
		
		//Verify createdBy and CreatedFor options and select them
		String createdForText=workspacePageObj.uploadContentToVerifyOwnershipTypeDropdown();
		
		//open the uploaded content from ALL UPLOADS and verify can edit ownershipType
		workspacePageObj.verifyUserCanEditWhenOpenedFromAllUploads(createdForText);
		
		//Logout as Creator
		signupObj.userLogout();
	}
}

