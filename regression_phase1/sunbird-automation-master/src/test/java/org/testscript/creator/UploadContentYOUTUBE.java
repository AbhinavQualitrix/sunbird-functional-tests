/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/27/2018

* Purpose: As a Creator Upload a YOUTUBE video,as a Reviewer Publish it and as a User Consume it.

*/
package org.testscript.creator;

import org.testng.annotations.Test;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadContentYOUTUBE extends BaseTest
{
	@Test(groups={"creator","regression2","smoke2","sanity1"})
	public void uploadContentYOUTUBE() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step1:Login as content creator
		
		signupObj.userLogin(CREATOR);
		
		//Step2:Navigate to workspace and upload content-MP4
		
		creatorUserPageObj.uploadContentMp4(YOUTUBE);
		
		//Step3:Logout as creator
		
		signupObj.userLogout();
		
		//Step4:Login as Reviewer
		
		signupObj.userLogin(REVIEWER);
		
		//Step5:Go to workspace and publish content Mp4
		
		creatorUserPageObj.goToWorkspaceAndPublish("content");
		
		//Step6:Logout as reviewer
		
		signupObj.userLogout();
		
		//Step7:Login as Public user
		
		signupObj.userLogin(PUBLICUSER1);	
				
		//Step8:Go to workspace and publish content Mp4
				
		creatorUserPageObj.navigateToLibraryAndSearchContent("content");
		
		//Step9:Logout as Public user
		
		signupObj.userLogout();
		
		//Step10: Login as Creator
		
		signupObj.userLogin(CREATOR);

		//Step11: Navigate to WorkSpace

		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step12: Delete the Created item

		creatorUserPageObj.deleteCreatedItems();

		//Step13: Logout as Creator

		signupObj.userLogout();
		
	}
}
