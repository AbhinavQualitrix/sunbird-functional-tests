/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/18/2018
* Purpose: To verify Library search- with filter
*/

package org.testscript.publicuser;

import org.testng.annotations.Test;
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

public class SearchInLibrary  extends BaseTest
{
	@Test(groups= {"publicuser","sanity1","regression1"})
	public void searchInLibrary() throws Exception 
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUser = new PublicUserPageObj();
		
		//Step 1: Login as Mentor
		userLogin.userLogin(MENTOR);
		
		//Step 2: search in library
		//Search for book, Resource, Upload content
		//Collection and lesson plan
		publicUser.librarySearch();
		
		//Step 3:Logout as Public user
		userLogin.userLogout();
				
	}	

}
