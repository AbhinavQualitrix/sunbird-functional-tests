/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 08/17/2018

* Purpose: Create Question Set in Resource as creator and publish as reviewer.

*/
package org.testscript.creator;

import org.testng.annotations.Test;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class CreateQuestionFITBAndVerify extends BaseTest {
	
	@Test(groups={"creator","regression","smoke1"})
	public void createQuestionFITBAndVerify() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(RESOURCE);
		
		//Step3: Create new Course
		creatorUserPageObj.createQuestionFITB(objListOFTestDataForSunbird);
		
		//Step4: Save and send resource for review
		creatorUserPageObj.saveAndSendResouceForReview();
		//GenericFunctions.refreshWebPage();
			
		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(RESOURCE,objListOFTestDataForSunbird);
		GenericFunctions.waitWebDriver(3000);

		//Step6: Logout as Creator
		creatorLogin.userLogout();
		
		//Step7: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);
		
		//Step8: Search the course which was submitted for review
		GenericFunctions.waitWebDriver(2000);
		creatorUserPageObj.searchInUpForReview(RESOURCE,objListOFTestDataForSunbird);
		
		//Step 9:publish the resource and search it
		creatorUserPageObj.resourcePublishAndSearch(objListOFTestDataForSunbird);
		
		//Step 10: Logout as Reviewer
		creatorLogin.userLogout();	
		
		//Step11: Login as Creator
		creatorLogin.userLogin(CREATOR);

		//Step12: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step13: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step14: Logout as Creator
		creatorLogin.userLogout();
		
	}

}