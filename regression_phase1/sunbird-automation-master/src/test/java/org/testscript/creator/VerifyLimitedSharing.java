/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Richa Prakash
 * Date: 17/09/2018
 * Purpose:  Verify that the upload content is displaying in limited sharing bucket share pop up is displayed to the user with shareable link 
  User can access the content via share link with valid user credentials
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

public class VerifyLimitedSharing extends BaseTest {

	@Test(groups={"creator","sanity","regression2"})

	public void verifyLimitedSharing() throws Exception{
		SignUpPageObj signupobj = new SignUpPageObj();
		CreatorUserPageObj createuserpageobj = new CreatorUserPageObj();
		ContentCreateUploadPageObj contentcreateuploadpageobj = new ContentCreateUploadPageObj(); 

		// Step no.1:Login as a content creator
		signupobj.userLogin(CREATOR);

		//Step no.2:Click on Workspace
		createuserpageobj.navigateToWorkspace(UPLOADCONTENT);
		
		//Steps no.3:Verify edit details form 
		contentcreateuploadpageobj.verifyThatEditDetailsPageIsDisplayed();
		
		//Step no.4:select dropdowns in edit details form
		String[] valueArray = contentcreateuploadpageobj.selectValuesFromDropdowns();
		
		//Step no.5:verify the selected values in the dropdowns
		contentcreateuploadpageobj.verifyValuesOfDropdowns(valueArray);
		
		//Step no.6:to verify topics selection in topic tree
		contentcreateuploadpageobj.selectTopicFromTopicTree();
		
		//Step no.7:Verify limited sharing the content
		contentcreateuploadpageobj.verifyLimitedSharingContent();
		
		//Step no.4 :Logout as reviewer
		signupobj.userLogout();
	

	}





}
