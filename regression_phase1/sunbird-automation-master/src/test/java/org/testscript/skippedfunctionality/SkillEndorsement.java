/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/28/2018
* Purpose: To verify skill Endorsement of user
*/

package org.testscript.skippedfunctionality;

import org.generic.GenericFunctions;
import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class SkillEndorsement extends BaseTest
{
	@Test(groups= {"skippedfunctionality"})
	public void skillEndorsement() throws Exception
	{
		
		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUser = new PublicUserPageObj();
		
		//Step 1:Login as any user
		userLogin.userLogin(PUBLICUSER1);
		
		//Step 2 : Go to profile and add a skill to public user
		String username=publicUser.addSkill();
		
		//Step 3 : Logout as Public user
		userLogin.userLogout();
		GenericFunctions.waitWebDriver(2000);
		
		//Step 4 : Login as Creator
		userLogin.userLogin(CREATOR);
		
		//Step 5:Go to profile 
		//Search any profile and generate a random skill 
		//Search for a profile and Endorse the skill 
		publicUser.skillEndorsement(username);
		
		//Step 6:Logout as Public user
		userLogin.userLogout();
	}
	
}
