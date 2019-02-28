/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/21/2018
* Purpose: To verify Course search - with filter
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
import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.PublicUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;


public class SearchCourseUsingFilter extends BaseTest
{
	@Test(groups= {"publicuser","sanity1","regression1"})
	public void searchCourseUsingFilter() throws Exception 
	{	

		SignUpPageObj userLogin = new SignUpPageObj();
		PublicUserPageObj publicUser = new PublicUserPageObj();
		
		//Step 1:Login as Public user
		userLogin.userLogin(PUBLICUSER1);
		
		//Step 2 :Course search with filter
		publicUser.courseSearchFilter();
		
		//Step 3:Logout as Public user
		userLogin.userLogout();
	}
	

}
