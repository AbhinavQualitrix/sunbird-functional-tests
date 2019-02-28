/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Richa Prakash
* Date: 28/08/2018
* Purpose:  Verify that the uploaded content pop up is displaying 
* when clicking on the upload content 
*/

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

public class VerifyAppliedFilter extends BaseTest{
	
	@Test(groups={"reviewer","regression1"})
	public void verifyAppliedFilter() throws Exception{
	SignUpPageObj signupobj = new SignUpPageObj();
	CreatorUserPageObj createuserpageobj = new CreatorUserPageObj();
	ContentCreateUploadPageObj contentcreateuploadpageobj = new ContentCreateUploadPageObj(); 

	//Step no.1 :Login as reviewer
	signupobj.userLogin(REVIEWER);
	
	//Step no.2 :Navigate to workspace and show filter
	contentcreateuploadpageobj.showFilter();

	//Step no.3 :Logout as reviewer
	signupobj.userLogout();
	

	
	
	
	}	
}
