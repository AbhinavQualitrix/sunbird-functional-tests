package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyMyActivityLinkInProfileDropdown extends BaseTest
{
	//Maintenance Done - 09th Nov
	@Test(groups={"creator","regression2"})
	public void verifyMyactivityLinkInProfileDropdown() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		ContentCreationResourcePageObj contentReourcePageObj= new ContentCreationResourcePageObj();
		
		//Login as Content creator
		userLogin.userLogin(CREATOR);
		
		//Click on profile icon and verify My activity Dashboard
		contentReourcePageObj.verifyMyActivity_OnProfile();
		
		//Navigate to library and search for any collection
		contentReourcePageObj.navigateToLibraryAndSearchContent(COLLECTION);
		
		//3.Copy the content and validate it in drafts
		contentReourcePageObj.copyContentAndValidate(COLLECTION);
		
		//Logout as Content creator
		userLogin.userLogout();
		
	}

}
