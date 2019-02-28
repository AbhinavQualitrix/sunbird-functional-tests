/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Ajith Manjunath
 * Date: 05/21/2018
 * Purpose: To verify flag a content
 */

package org.testscript.skippedfunctionality;

import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class FlagTheContentAsPublicUser extends BaseTest
{
	@Test(groups= {"skippedfunctionality"})
	public void flagTheContentAsPublicUser() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUser = new PublicUserPageObj();
		
		//Step 1:Login as Public user
		userLogin.userLogin(PUBLICUSER1);
		
		//Step 2 :Flag the content
		publicUser.contentFlag();
		
		//Step 3: Logout as Public user
		userLogin.userLogout();


//Test case is not valid as the Flag Icon is removed from the application
	}

}
