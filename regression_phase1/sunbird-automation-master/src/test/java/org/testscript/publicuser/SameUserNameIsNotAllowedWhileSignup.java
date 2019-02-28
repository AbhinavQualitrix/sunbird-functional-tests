package org.testscript.publicuser;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class SameUserNameIsNotAllowedWhileSignup extends BaseTest
{
	//Maintenance Done - 09th Nov
	@Test(groups= {"publicuser","regression1"})
	public void verify_SignUpFailure() throws Exception
	{		
		SignUpPageObj signUpPageObj = new SignUpPageObj();
		
		//Signup user failure		
		signUpPageObj.singleSignUpUser();
		
		//Check for data exists
		signUpPageObj.checkUserDataExists();
		
	}

}
