/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Raju S
 * Date: 03/10/2018
 * Purpose:  
To verify that the user is able to view the sort option 
.
 */



package org.testscript.creator;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifySortOption extends BaseTest
{
	//MT done - 7th Nov
	@Test(groups={"creator","regression2"})//priority=1,
	public void verifySortOption() throws Exception
	{

		ContentCreationResourcePageObj contentCreatoinResourcePage=new ContentCreationResourcePageObj();
		SignUpPageObj userLogin = new SignUpPageObj();

		//Step1: Login as Creator
		userLogin.userLogin(CREATOR);

		//Step 2: Verify Sort Option			
		contentCreatoinResourcePage.VerifySortByIsExists();

		//Step 3:Logout as Creator
		userLogin.userLogout();
	}
}