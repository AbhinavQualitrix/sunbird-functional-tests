/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Richa Prakash
* Date: 28/08/2018
* Purpose:  Verify that the uploaded content pop up is displaying 
* when clicking on the upload content 
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

public class VerifyTheUploadedContent extends BaseTest

{
	@Test(groups={"creator","regression2"})
	public void verifyTheUploadedContent() throws Exception
	{
	 SignUpPageObj signupobj = new SignUpPageObj();
	 CreatorUserPageObj createuserpageobj = new CreatorUserPageObj();
	 ContentCreateUploadPageObj contentcreateuploadpageobj = new ContentCreateUploadPageObj(); 
	 
	 // Step no.1:Login as a content creator
	 signupobj.userLogin(CREATOR);
	 
	 createuserpageobj.navigateToWorkspace(UPLOADCONTENT);
	 //Step no.2:Click on workspace
	 
	 //Step no.3:Enter URL
	 contentcreateuploadpageobj.verifyUploadContentPopupDisplay();
	
	 //Step no.4:Upload the youtube url	 
	 contentcreateuploadpageobj.verifyFileUpload();
	 
	 //Step no.5 :Logout as reviewer
	 signupobj.userLogout();
	 
	}
}
