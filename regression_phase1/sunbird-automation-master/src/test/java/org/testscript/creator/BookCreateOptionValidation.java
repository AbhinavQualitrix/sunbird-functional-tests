/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/27/2018
* Purpose: Content creator does not book create option
*/


package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class BookCreateOptionValidation extends BaseTest
{
	//MT done
	
	@Test(priority=19, groups={"creator","sanity2", "regression1"})
	public void bookCreateOptionValidation() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();

		//Step 1:Login with ANY user who dont have  credentials.
		signupObj.userLogin(REVIEWER);
		//signupObj.userLogin(CREATOR);
		
		//Step 2:Go to workspace
		//3. Click on create
		//4. Verify book option is not displaying.
		creatorUserPageObj.verifyNoBookOptionPresent();
		
		//Logout as Content creator
		signupObj.userLogout();
		
		
	}
}
