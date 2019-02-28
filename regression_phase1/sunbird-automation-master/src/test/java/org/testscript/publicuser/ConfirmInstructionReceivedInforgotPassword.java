/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/18/2018
* Purpose: To verify Forgot password functionality
*/

package org.testscript.publicuser;

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

public class ConfirmInstructionReceivedInforgotPassword extends BaseTest
{
	//MT done
	@Test(groups= {"publicuser","sanity1","regression1"})
	public void confirmInstructionReceivedInforgotPassword() throws Exception 
	{
		SignUpPageObj publicLogin = new SignUpPageObj();
		PublicUserPageObj publicUser = new PublicUserPageObj();
	
		GenericFunctions.waitWebDriver(3000);
		
		//Step 1,2,3 and 4: To verify Forgot Password
		//and confirm the instructions received
		publicUser.forgotPassword();
	}
}
