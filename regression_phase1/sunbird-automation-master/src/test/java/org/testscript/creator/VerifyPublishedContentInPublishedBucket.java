package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.ContentCreateUploadPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyPublishedContentInPublishedBucket extends BaseTest{
	//TC140_TC_143
	@Test(groups={"creator","regression2"})
	public void verifyPublishedContentInPublishedBucket() throws Exception
	{
	SignUpPageObj signUpPageObj = new SignUpPageObj();
	ContentCreateUploadPageObj contentCreateUploadPageObj = new ContentCreateUploadPageObj(); 

	//Step no.1 :Login as reviewer
	signUpPageObj.userLogin(REVIEWER);
	
	//Step no.2 :Navigate to workspace and up for review
		String publishedContent=contentCreateUploadPageObj.navigateToUpForReviewN();
		
		//Step no.3 :Logout
		signUpPageObj.userLogout();
		
		//Step no.4 :Login as creator 
		signUpPageObj.userLogin(CREATOR);
		
		//Step no.5 :Navigate to workspace and verify the content published or not
		contentCreateUploadPageObj.publishedContent(publishedContent);
	
	//Step no.6 :Logout
	signUpPageObj.userLogout();
	

}

}