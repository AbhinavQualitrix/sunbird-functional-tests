/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 09/26/2018

* Purpose: Edit Resource as creator and publish as reviewer.

*/
package org.testscript.creator;

import org.testng.annotations.Test;
import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class EditResourceAndVerify extends BaseTest {
	
	@Test(groups={"creator","regression2"})
	public void editResourceAndVerify() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);
		
		//Step3: Navigate to All my activity and Search
		creatorUserPageObj.navigateToAllMyContentAndSearch(objListOFTestDataForSunbird,RESOURCE);
		
		//Step4: delete the existing slides
		creatorUserPageObj.deleteTheSlide();
		
		//Step5: Create new Resource
		creatorUserPageObj.createResourceWithoutSave(objListOFTestDataForSunbird);
		
		//Step6: Create new Question
		creatorUserPageObj.createQuestionAndSave(objListOFTestDataForSunbird);
		
		//Step7: Save and send resource for review
		creatorUserPageObj.saveAndSendEdittedResouceForReview();
		//GenericFunctions.refreshWebPage();
			
		//Step8: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(RESOURCE,objListOFTestDataForSunbird);
	

		//Step9: Logout as Creator
		creatorLogin.userLogout();
		
		//Step10: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);
		
		//Step11: Search the course which was submitted for review
		
		creatorUserPageObj.searchInUpForReviewForEdittedContents(RESOURCE,objListOFTestDataForSunbird);
		
		//Step12:publish the resource and search it
		creatorUserPageObj.resourcePublishAndSearch(objListOFTestDataForSunbird);
		
		//Step13: Logout as Reviewer
		creatorLogin.userLogout();	
		
		
		
		
		
	}

}