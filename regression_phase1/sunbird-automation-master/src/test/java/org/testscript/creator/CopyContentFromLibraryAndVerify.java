package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class CopyContentFromLibraryAndVerify extends BaseTest 
{
	//TC74
	@Test(groups= {"creator","regression1"})
	public void verifyCopyContent_Library() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		ContentCreationResourcePageObj contentReourcePageObj= new ContentCreationResourcePageObj();
		
		//Step 1.Login as content creator
		userLogin.userLogin(CREATOR);
		
		//Step 2.Navigate to library and search the content
		contentReourcePageObj.navigateToLibraryAndSearchContent(COLLECTION);
		
		//Step 3.Copy the content and validate it in drafts
		contentReourcePageObj.copyContentAndValidate(COLLECTION);
		
		//Step 4.Logout as content creator
		userLogin.userLogout();
	}

}
