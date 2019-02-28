/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/20/2018
* Purpose: Upload content type-H5P and validate it
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

public class UploadContentTypeH5pAndVerify  extends BaseTest
{
	//MT done
	@Test(groups={"creator","sanity1","smoke2","regression2"})//priority=9, 
	public void uploadH5pContentAndVerify() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step 1:Login as content creator
		signupObj.userLogin(CREATOR);
		
		
		//Step 2,3 and 4:Navigate to workspace and upload content type-H5P
		creatorUserPageObj.uploadContentMp4(H5P);
		
		creatorUserPageObj.uploadContentMp4(H5P);
		
		//Logout as creator
		signupObj.userLogout();
		
		//Step 5:Login as Reviewer
		signupObj.userLogin(REVIEWER);
		
		//Step 6 and 7:Go to workspace and publish the content-h5p
		creatorUserPageObj.goToWorkspace("h5p");
		
		GenericFunctions.waitWebDriver(2000);
		
		//reject the upload type -H5P
		creatorUserPageObj.rejectTheUploads(H5P);
		
		//Logout as Reviewer
		signupObj.userLogout();
		//Step9: Login as Creator
		signupObj.userLogin(CREATOR);

		//Step10: Navigate to WorkSpace-All my content
		creatorUserPageObj.navigateToWorkspace(ALL_MY_CONTENT);

		//Step11: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step12: Logout as Creator
		signupObj.userLogout();
	}

}
