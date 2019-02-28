/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Richa Prakash
* Date: 17/09/2018
* Purpose:  Verify that the upload content is displaying while clicking on the upload content for the 2nd time
*/



package org.testscript.creator;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.ContentCreateUploadPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifySaveContentInAllUploads extends BaseTest 
{
	@Test(groups={"creator","regression2"})
	public void verifySaveContentInAllUploads() throws Exception
	{
		SignUpPageObj signupobj = new SignUpPageObj();
		 CreatorUserPageObj createuserpageobj = new CreatorUserPageObj();
		 ContentCreateUploadPageObj contentcreateuploadpageobj = new ContentCreateUploadPageObj(); 
		 
		// Step no.1:Login as a content creator
		 signupobj.userLogin(CREATOR);
		 
	     //Step no.2:Click on Workspace
		 createuserpageobj.navigateToWorkspace(UPLOADCONTENT);
		 
		 //Step no.3 click on edit details popuop
		 contentcreateuploadpageobj.verifyThatEditDetailsPageIsDisplayed();
		 
		 //Steps no.4 Check the content is in all uploads
		 contentcreateuploadpageobj.allUploadsContent();
		 
		/*//Step no.5 :Logout as reviewer
		signupobj.userLogout();*/
		 
		 
		 
	}

}
