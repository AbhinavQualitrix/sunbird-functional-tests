/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/18/2018
* Purpose: To verify course search
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

public class SearchCourse extends BaseTest
{
	//MT done
	@Test(groups= {"publicuser","sanity1","regression1"})
	public void searchCourse() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUser = new PublicUserPageObj();
		
		//Step 1 : Login into Application as Public user	
		userLogin.userLogin(PUBLICUSER1);

		//Step 2 and 3 : Click on courses
		//Search for course
		publicUser.courseSearch();
		
		//Logout as Public user
		userLogin.userLogout();
	
	}

}
