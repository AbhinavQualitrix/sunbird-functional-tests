package org.testscript.newfeature;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.startup.IAutoConst;
import org.testng.annotations.Test;

 //@Listeners(org.generic.TestListener.class)
public class VerifyTermsAndConditions extends BaseTest
{
	@Test(groups= {"regression1","newfeature"})
	public void verifyTermsAndConditionsPopup() throws Exception
	{
		
		
		
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		SignUpPageObj signupObj = new SignUpPageObj();
		
		//Step 1 : Sign Up as New user
		//Login as the new user
		signupObj.userLogin(TC_TESTUSER);
		
		//Step 2 : Verify that user will get T&C popup after login
		workspacePageObj.verifyTermsAndConditionsPopup();
	}
	

}
