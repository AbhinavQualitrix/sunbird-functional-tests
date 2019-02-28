/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 07/02/2018
* Purpose: Go to My activity from Profile and validate it
*/

package org.testscript.admin;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class NavigateToMyActivity extends BaseTest{
	
	@Test(groups={"sanity1", "regression1","admin"})//priority=12, 
	public void navigateToMyActivity() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForDiksha= null ;
		objListOFTestDataForDiksha = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();

		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to My Activity		
		creatorUserPageObj.navigateToMyActivity();
		GenericFunctions.waitWebDriver(15000);
		
		//Step 3: Logout as Creator
		creatorLogin.userLogout();
		
	}

}