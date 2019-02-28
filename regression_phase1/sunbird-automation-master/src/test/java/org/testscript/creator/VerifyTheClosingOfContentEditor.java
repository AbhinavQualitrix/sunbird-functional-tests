package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyTheClosingOfContentEditor extends BaseTest
{
	@Test(groups={"creator","regression2"})
	public void contentCreator_CloseEditor() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		ContentCreationResourcePageObj contentReourcePageObj= new ContentCreationResourcePageObj();

		//Login as Content creator
		userLogin.userLogin(CREATOR);

		//Navigate to workspace to create Resource
		creatorUserPageObj.navigateToWorkspace(RESOURCE);

		//Enter a unique resource name
		contentReourcePageObj.resourceName();

		//Add text or image through Slides
		contentReourcePageObj.addSlides(1);

		//To verify that user is able to close the content editor.
		contentReourcePageObj.verifyCloseContentEditor();
		

		//Logout as Content Creator
		userLogin.userLogout();
	}


}
