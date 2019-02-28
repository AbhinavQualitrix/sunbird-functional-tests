
package org.testscript.reviewer;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.ContentCreateUploadPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class RejectTheUploadedContent extends BaseTest
{
	//Files from Richa yet to update
	//TC141
	@Test(groups= {"reviewer","regression1"})	
	public void rejectTheUploadedContent() throws Exception
{
	SignUpPageObj signUpPageObj = new SignUpPageObj();
	CreatorUserPageObj createUserPageObj = new CreatorUserPageObj();
	ContentCreateUploadPageObj contentCreateUploadPageObj = new ContentCreateUploadPageObj(); 

	//Step no.1 :Login as reviewer
	signUpPageObj.userLogin(REVIEWER);
	
	//Step no.2:Navigate to workspace and request the changes
	contentCreateUploadPageObj.requestChanges();
	
	//Step no. :Logout as reviewer
	signUpPageObj.userLogout();
	
	//Step np.:Login as creator	
	signUpPageObj.userLogin(CREATOR);
	
	//Step no.:Navigate to workspace then navigate to all uploads 
	contentCreateUploadPageObj.alluploads();
	
	
	
	
	
}
}