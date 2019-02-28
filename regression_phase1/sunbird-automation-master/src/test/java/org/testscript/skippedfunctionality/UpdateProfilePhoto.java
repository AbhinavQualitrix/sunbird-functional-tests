/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/22/2018
* Purpose: To verify Profile - photo upload
*/

package org.testscript.skippedfunctionality;

import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class UpdateProfilePhoto extends BaseTest
{
	@Test(groups= {"skippedfunctionality"})
	public void updateProfilePhoto() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUser = new PublicUserPageObj();
		
		//Step 1 : Login in as Public user
		userLogin.userLogin(PUBLICUSER1);
		
		//Step 2 : Click on upload profile image icon
		publicUser.updateProfileImage();
		
		//Logout as Public user
		userLogin.userLogout();
		
	}
}
