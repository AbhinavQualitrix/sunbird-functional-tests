/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/17/2018
* Purpose: Verify Login and Change password
*/

package org.testscript.publicuser;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.page.SignUpPage;
import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;


public class LoginAndChangePassword extends BaseTest
{
		
	@Test(groups= {"regression1","sanity1","publicuser"})
	public void loginAndChangePassword() throws Exception 
	{	
		SignUpPageObj publicLogin = new SignUpPageObj();
		PublicUserPageObj publicUser = new PublicUserPageObj();
		
		//Step 1: Login into Application as Public user
		publicLogin.userLogin(PUBLICUSER2);
		
		//Step 2: Verify Login 
		//And Change Password
		publicUser.changePassword();
	}

}
