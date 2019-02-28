/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/15/2018
* Purpose: Verify Elements in Admin dashboard
*/

package org.testscript.admin;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.UploadOrgObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyElementsInAdminDashboard extends BaseTest
{
	//MT done 
	@Test(groups={"admin","sanity1", "regression1"})//priority=6, 
	public void verifyElementsInAdminDashboard() throws Exception
	{
		SignUpPageObj adminLogin = new SignUpPageObj();
		UploadOrgObj adminUpload= new UploadOrgObj();

		//Step 1: Login as Admin
		adminLogin.userLogin(ADMIN);

		//Step 2,3,4 and 5 : Go to Profile page
		//Verify Admin DashBoard
		adminUpload.adminDashboard();
		
		//Logout as Admin
		adminLogin.userLogout();

	}


}
