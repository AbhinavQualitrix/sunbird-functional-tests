/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/22/2018
* Purpose: To verify Library search - with filter
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

public class SearchInLibraryUsingFilter extends BaseTest
{
	@Test(groups= {"publicuser","sanity1","regression1"})
	public void searchInLibraryUsingFilter() throws Exception
	{	
		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUser = new PublicUserPageObj();
		
		//Step 1 : Login in as Public user
		userLogin.userLogin(PUBLICUSER1);
		
		//Step 2 : Click on library
		//Click on filters
		publicUser.librarysearchFilter();
		
		//Step 3 :Logout as Public user
		userLogin.userLogout();
	}

}
