/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/18/2018
* Purpose: Verify Home page > To Do section
*/

package org.testscript.skippedfunctionality;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.generic.GenericFunctions;
import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyHomePage extends BaseTest
{	
	@Test(groups= {"skippedfunctionality"})//publicuser
	public void verifyHomePage() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUser = new PublicUserPageObj();

		//Step 1 : Login into Application as Public user
		userLogin.userLogin(PUBLICUSER1);

		//Step 2 : Reidrect to home page and verify TO DO
		publicUser.homePageTodo();
		
		//Wait for 2 sec
		GenericFunctions.waitWebDriver(2000);
		
		//Logout as Public user
		userLogin.userLogout();
		

	}
}
