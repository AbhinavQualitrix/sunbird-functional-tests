package org.testscript.newfeature;

import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

//@Listeners(org.generic.TestListener.class)
public class NoTCForSecondTimeUserLogin extends BaseTest
{
	@Test(groups= {"regression1","newfeature"})
	public void noTermsAndConditionsForSecondTimeUserLogon() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		
		//Step 1 : Sign Up as New user
		//Login as that after accepting T&C
		signupObj.userLogin(NEWUSER_SECONDTIME);
		
		//Step 2 : Check that T&C popup is not displayed to the user on second or more login
		workspacePageObj.checkNoTermsAndConditionsPopup();
		
	}
	

}
