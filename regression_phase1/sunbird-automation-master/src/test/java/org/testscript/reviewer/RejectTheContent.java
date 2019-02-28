
package org.testscript.reviewer;
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

public class RejectTheContent extends BaseTest{

	@Test(groups= {"reviewer","regression1"})	
	public void rejectTheContent() throws Exception{
	SignUpPageObj signupobj = new SignUpPageObj();
	ContentCreateUploadPageObj contentcreateuploadpageobj = new ContentCreateUploadPageObj(); 

	//Step no.1 :Login as reviewer
	signupobj.userLogin(REVIEWER);
	
	//Step no.2:Navigate to workspace and request the changes
	contentcreateuploadpageobj.requestChanges();
	
	//Step no.3 :Logout as reviewer
	signupobj.userLogout();
	
	//Step n0.4:Login as creator	
	signupobj.userLogin(CREATOR);
	
	//Step no.5:Navigate to workspace then navigate to all uploads 
	contentcreateuploadpageobj.alluploads();
	
	//Step no.6 :Logout as reviewer
	signupobj.userLogout();
	
	
	
}
}