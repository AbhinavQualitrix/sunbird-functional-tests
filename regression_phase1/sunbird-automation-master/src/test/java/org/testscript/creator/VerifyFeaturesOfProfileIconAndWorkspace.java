/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Tejas Kumar K

* Date: 08/28/2018

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

public class VerifyFeaturesOfProfileIconAndWorkspace extends BaseTest
{
	//Maintenance Done - 07 Nov
	@Test(groups= {"regression2","creator"})
	public void verifyProfileIcon4Features_workspaceFeatures() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		ContentCreationResourcePageObj contentReourcePageObj= new ContentCreationResourcePageObj();
		
		//1.Login as content creator
		
		//Test case 72 :Click on Profile Icon and verify Elements
		contentReourcePageObj.verifyProfileIconAndWorkspace();
		
		//Test case 73 :To verify that the user is able to see all the features after clicking on the workspace
		contentReourcePageObj.verifyWorkspaceAndFeatures();
		
		//Logout as Content creator
		userLogin.userLogout();
	}

}
