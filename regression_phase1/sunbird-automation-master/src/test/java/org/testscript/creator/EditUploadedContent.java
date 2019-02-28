/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/27/2018

* Purpose: As a Creator edit uploaded PDF,as a Reviewer Publish it and as a User Consume it.

*/
package org.testscript.creator;

import org.testng.annotations.Test;
import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class EditUploadedContent extends BaseTest
{
	@Test(groups={"creator","regression2"})
	public void editUploadedContent() throws Exception
	{
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		
		//Step1:Login as content creator
		
		creatorLogin.userLogin(CREATOR);
		
		//Step2:Navigate to workspace and Search
		
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);
		creatorUserPageObj.navigateToAllMyContentAndSearch(objListOFTestDataForSunbird,UPLOADCONTENT);
		
		//Step3:Upload content
		
		creatorUserPageObj.uploadNewContent(PDF);
		
		//Step3:Logout as creator
		
		creatorLogin.userLogout();
		
		//Step4:Login as Reviewer
		
		creatorLogin.userLogin(REVIEWER);
		
		//Step5:Go to workspace and publish content Mp4
		
		creatorUserPageObj.goToWorkspaceAndPublishEdittedContent("content");
		
		//Step6:Logout as reviewer
		
		creatorLogin.userLogout();
		
		//Step7:Login as Public user
		
		creatorLogin.userLogin(PUBLICUSER1);	
				
		//Step8:Go to workspace and publish content Mp4
				
		creatorUserPageObj.navigateToLibraryAndSearchEdittedContent("content");
		
		//Step9:Logout as Public user
		
		creatorLogin.userLogout();
		
		
		
	}
}

