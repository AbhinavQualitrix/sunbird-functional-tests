
/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/16/2018

* Purpose: Check for Authentic and Unauthentic users.

*/

package org.testscript.mentor;

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
import org.openqa.selenium.support.PageFactory;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class CheckForAuthenticUserInMentor extends BaseTest {
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	String courseName;
	String startDate;
	String endDate;
	
	
	@Test(groups={"mentor","regression1","sanity2"})
	public void checkForAuthenticUserInMentor() throws Exception
	{    
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj cretorUserPageObj =new CreatorUserPageObj();
		List <TestDataForDiksha> objListOFTestDataForSunbird1=null;
		objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
		
		//Step1: Login as Creator
		creatorLogin.userLogin(ADMIN);

		
		//Step2: Navigate to profile and search for authentic user
		cretorUserPageObj.navigateToProfileAndSearch(objListOFTestDataForSunbird1.get(9).getCourseDescription());
		createMentorPageObj.checkForAuthenticUserAndEdit();
		

		//Step3: Navigate to profile and search for Unauthentic user
		GenericFunctions.refreshWebPage();
		String actualPersonName= objListOFTestDataForSunbird1.get(9).getTitle();          
		cretorUserPageObj.navigateToProfileAndSearch(objListOFTestDataForSunbird1.get(9).getTitle());
		createMentorPageObj.checkForUnauthenticUserAndEdit(actualPersonName);

		
		//Step4: Logout as mentor
		creatorLogin.userLogout();
		
		

	}

}