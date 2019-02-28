/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/09/2018
* Purpose: Upload sub org
*/


package org.testscript.skippedfunctionality;

import org.generic.GenericFunctions;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.UploadOrgObj;
import org.startup.BaseTest;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;


public class UploadSubOrg extends BaseTest  
{	

	@Test(groups= {"skippedfunctionality"})//(priority=3, groups={"Admin group"})
	public void uploadSubOrg() throws InterruptedException, Exception 
	{		
		//Step1: Admin Login
		SignUpPageObj adminLogin = new SignUpPageObj();
		UploadOrgObj adminUpload= new UploadOrgObj();
		adminLogin.userLogin(ADMIN);		
		
		//Step2 and 3: Upload Sub Org		
		boolean actualValue=adminUpload.uploadRootAndSubOrg(UPLOAD_SUB_ORG);
		AssertJUnit.assertEquals(true,actualValue);
		
		GenericFunctions.waitWebDriver(2000);
		//Logout as Admin
		adminLogin.userLogout();
	}

}
