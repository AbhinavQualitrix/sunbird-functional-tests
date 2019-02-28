/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Ajith Manjunath
 * Date: 06/18/2018
 * Purpose:  Upload the Content type - HTML and validate it
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

public class UploadContentTypeHtmlAndVerify extends BaseTest
{
	@Test( groups={"creator","sanity1","smoke2","regression2"}, invocationCount=2)//priority=4,
	public void uploadContentTypeHtmlAndVerify() throws Exception
	{
		
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		GenericFunctions genereicFunctions = new GenericFunctions();

		//Step 1:Login as content creator
		signupObj.userLogin(CREATOR);

		//Step 2,3 and 4:Navigate to workspace and upload content-Html and send the content for review
		creatorUserPageObj.uploadContentMp4(HTML);

		creatorUserPageObj.uploadContentMp4(HTML);

		//Logout as creator
		signupObj.userLogout();
		
		//Step 5:Login as Reviewer
		signupObj.userLogin(REVIEWER);

		//Step 6, 7:Go to workspace and publish content Html
		creatorUserPageObj.goToWorkspace("html");
		
		//Step 8 :Reject the upload type-Html which is already existing in the list
		creatorUserPageObj.rejectTheUploads("html");

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
