/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/05/2018

* Purpose:Navigate to my Activity .

*/
package org.testscript.mentor;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.generic.GenericFunctions;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;


public class NavigateToMyActivityInDropdown extends BaseTest {
	
	@Test(groups={"mentor","sanity2","regression1"})
	public void navigateToMyActivityInDropdown() throws Exception
	{
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreateMentorPageObj createMentorPageObj =new CreateMentorPageObj();
		
		//Step1: Login as Creator
		creatorLogin.userLogin(MENTOR);

		//Step2: Navigate to My activity in Dropdown		
		createMentorPageObj.navigateToMyActivityInDropDownMenu();
		
		//Step3: Logout as mentor
		creatorLogin.userLogout();
		
	}
	

}
