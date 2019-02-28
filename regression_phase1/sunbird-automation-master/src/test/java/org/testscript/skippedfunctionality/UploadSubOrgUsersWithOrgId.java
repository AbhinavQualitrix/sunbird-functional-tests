/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/11/2018
* Purpose: Upload users for sub orgs with org id
*/

package org.testscript.skippedfunctionality;

import org.pageobjects.SignUpPageObj;
import org.pageobjects.UploadOrgObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class UploadSubOrgUsersWithOrgId extends BaseTest
{
	//MT done
	@Test(groups= {"skippedfunctionality"})//(priority=4, groups={"Admin group"})
	public void uploadSubOrgUsers() throws Exception
	{
		//Step1: Admin Login
		SignUpPageObj adminLogin = new SignUpPageObj();
		UploadOrgObj adminUpload= new UploadOrgObj();
		adminLogin.userLogin(ADMIN);

		//Step2,3,4 and 5:Go to profile and 
		//Upload Users for Sub Org with sub Org Id
		
		adminUpload.uploadRootAndSubOrgUserWithOrgId(UPLOAD_USERS_SUB_ORG);
		
		
		//Logout as Admin
		adminLogin.userLogout();
		
	}
}
