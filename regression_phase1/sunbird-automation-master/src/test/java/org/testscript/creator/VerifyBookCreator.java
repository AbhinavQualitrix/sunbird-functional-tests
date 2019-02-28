/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/27/2018
* Purpose: Book creator does not get content creation access
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

public class VerifyBookCreator extends BaseTest
{
	//MT Done
	@Test(groups={"sanity2","creator","regression2"})//priority=19, 
	public void verifyBookCreator() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step 1:Login as Book creator
		signupObj.userLogin(BOOKCREATOR);
		
		//Step 2,3 and 4:Navigate to workspace and verify only book option is present 
		creatorUserPageObj.verifyOnlyBookOption();
		
		//Logout as Creator
		signupObj.userLogout();
	}

}
