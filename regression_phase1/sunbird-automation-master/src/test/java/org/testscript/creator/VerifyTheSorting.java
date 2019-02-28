/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Richa Prakash
 * Date: 20/09/2018
 * Purpose:  Verify that the uploaded content pop up is displaying 
 * when clicking on the upload content 
 */


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

public class VerifyTheSorting extends BaseTest 
{
	//Issue in sort By -Sorted results are not displayed according to the given condition
	@Test(groups={"creator","regression2"})
	public void  verifyTheSorting() throws Exception 
	{
		SignUpPageObj signupobj = new SignUpPageObj();
		ContentCreateUploadPageObj contentcreateuploadpageobj = new ContentCreateUploadPageObj(); 

		//Step no.1 :Login as reviewer
		signupobj.userLogin(REVIEWER);
		

		//Step no.2 :Navigate to workspace		
		contentcreateuploadpageobj.navigateToUpForReviewAndSearchContent();
		
		//step no.3:Click on sort By
		contentcreateuploadpageobj.verifySortByFeatureAndValues();
		
		//Step no.4 :Logout as reviewer
		signupobj.userLogout();
		

	}


}
