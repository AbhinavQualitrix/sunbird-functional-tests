/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Ajith Manjunath
 * Date: 06/18/2018
 * Purpose:  Upload the Content type - Pdf and validate it
 */

package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.generic.GenericFunctions;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadContentTypePdfAndVerify extends BaseTest
{
	@Test(groups={"creator","sanity2","smoke2","regression2"})//priority=4, 
	public void uploadContentTypePdfAndVerify() throws Exception
	{
		
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		GenericFunctions genereicFunctions = new GenericFunctions();

		//Step 1:Login as content creator
		signupObj.userLogin(CREATOR);

		//Step 2,3 and 4:Navigate to workspace and upload content-Pdf and send the content for review
		creatorUserPageObj.uploadContentMp4(PDF);

		creatorUserPageObj.uploadContentMp4(PDF);

		//Logout as creator
		signupObj.userLogout();

		//Step 5:Login as Reviewer
		signupObj.userLogin(REVIEWER);

		//Step 6, 7:Go to workspace and publish content Pdf
		creatorUserPageObj.goToWorkspace("pdf");
		
		//Step 8 :Reject the upload type-Pdf which is already existing in the list
		creatorUserPageObj.rejectTheUploads("pdf");

		//Step 9 :Logout as Reviewer
		signupObj.userLogout();

		//Step10: Login as Creator
		signupObj.userLogin(CREATOR);

		//Step11: Navigate to WorkSpace-All my content
		creatorUserPageObj.navigateToWorkspace(ALL_MY_CONTENT);

		//Step12: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step13: Logout as Creator
		signupObj.userLogout();
	}
}
