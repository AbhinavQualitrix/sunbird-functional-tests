/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/18/2018
* Purpose: Upload users for sub orgs with provider and external id
*/

package org.testscript.skippedfunctionality;

import org.pageobjects.SignUpPageObj;
import org.pageobjects.UploadOrgObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadSubOrgUsersWithProviderAndExtId extends BaseTest
{
	//MT done
	@Test(groups= {"skippedfunctionality"})//(priority=5, groups={"Admin group"})
	public void subOrgUsersProviderAndExtId() throws Exception
	{
		
		SignUpPageObj adminLogin = new SignUpPageObj();
		UploadOrgObj adminUpload= new UploadOrgObj();
		
		//Step1: Admin Login
		adminLogin.userLogin(ADMIN);
		

		
		//Step 2,3,4 and 5: Go to profile
		//and Upload users for Sub org with provider and external ID
		adminUpload.rootAndSubOrgUserExternalAndProvider(UPLOAD_USERS_SUB_ORG);
		
		//Logout as Admin
		adminLogin.userLogout();
	}


}
