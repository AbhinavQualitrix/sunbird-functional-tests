/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/10/2018
* Purpose: Upload user for root org with org id
*/

package org.testscript.skippedfunctionality;

import org.generic.GenericFunctions;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.UploadOrgObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadRootOrgUsersWithOrgId extends BaseTest
{
	@Test(groups= {"skippedfunctionality"})
	public void uploadRootOrgUsers() throws Exception
	{
		SignUpPageObj adminLogin = new SignUpPageObj();
		UploadOrgObj adminUpload= new UploadOrgObj();
		
		//Step1: Admin Login
		adminLogin.userLogin(ADMIN);
		

		//Step2,3,4 and 5:Go to profile, and Upload users With Root Org ID
		adminUpload.uploadRootAndSubOrgUserWithOrgId(UPLOAD_USERS_ROOT_ORG);
		
		GenericFunctions.waitWebDriver(2000);
		
		//Logout as Admin
		adminLogin.userLogout();
	}
}

