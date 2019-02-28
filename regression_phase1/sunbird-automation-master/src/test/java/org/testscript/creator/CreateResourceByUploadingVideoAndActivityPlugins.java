/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Tejas Kumar K

* Date: 09/10/2018

* Purpose: To verify that the content creator is able to see all the 4 features after clicking on the profile icon

*/

package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class CreateResourceByUploadingVideoAndActivityPlugins extends BaseTest
{
	//Maintenance Done-08 Nov
	@Test(groups= {"regression1","creator"})
	public void verifyUploadingVideo_AddingActivity() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		ContentCreationResourcePageObj contentReourcePageObj= new ContentCreationResourcePageObj();

		//Login as Content creator
		userLogin.userLogin(CREATOR);

		//Navigate to workspace to create Resource
		creatorUserPageObj.navigateToWorkspace(RESOURCE);

		//Enter a unique resource name
		contentReourcePageObj.resourceName();
		
		//Verify Video Uploading files
		contentReourcePageObj.uploadVideoFiles();
		
		
		
	}
	
	@Test
	public void verifyAddingActivityFunctionality() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		ContentCreationResourcePageObj contentReourcePageObj= new ContentCreationResourcePageObj();
				
				//Login as Content creator
				userLogin.userLogin(CREATOR);

				//Navigate to workspace to create Resource
				creatorUserPageObj.navigateToWorkspace(RESOURCE);

				//Enter a unique resource name
				contentReourcePageObj.resourceName();
				
				//Verify the user is able create resource by adding activity plugins
				//	contentReourcePageObj.addActivityPlugins();
				
	}

}
