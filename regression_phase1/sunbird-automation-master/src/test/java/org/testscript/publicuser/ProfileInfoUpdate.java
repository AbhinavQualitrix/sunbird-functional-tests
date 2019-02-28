/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/23/2018
* Purpose: To verify Profile - all information update
*/

package org.testscript.publicuser;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class ProfileInfoUpdate extends BaseTest
{
	@Test(groups= {"publicuser","regression1","sanity1"})//skippedfunctionality
	public void profileInfoUpdate() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUserPageObj = new PublicUserPageObj();
		
		
		//Step 1 : Login as any user	
		userLogin.userLogin(PUBLICUSER1);
		 
		//Step 2: Profile - all information update	
		//publicUser.profileInformationUpdate();
		publicUserPageObj.updateProfileInformation();
		
		//Logout as Public user
		userLogin.userLogout();
		
	}
	
}
