/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Ajith Manjunath
 * Date: 06/22/2018
 * Purpose: Edit and save a Reject content and send for review
 */

package org.testscript.creator;

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

public class EditContentAndSendForReview extends BaseTest
{
	//MT done
	@Test(groups= {"creator","sanity1","regression2"})//priority=13,
	public void editContentAndSendForReview() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();

		//Step 1:Login as content creator
		signupObj.userLogin(CREATOR);

		//Step 2:Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(COURSE);

		//Step 3:Create new Course
		creatorUserPageObj.createCourse(objListOFTestDataForSunbird);

		GenericFunctions.waitWebDriver(2000);

		//Step 4:Save and Send for Review
		creatorUserPageObj.saveAndSendnewCourseForReview(objListOFTestDataForSunbird);

		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.refreshWebPage();

		//Step 4a:Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(COURSE,objListOFTestDataForSunbird);

		GenericFunctions.waitWebDriver(3000);

		//Logout as Creator
		signupObj.userLogout();


		//Step 5:Login as Reviewer
		signupObj.userLogin(REVIEWER);

		//Step 6 and 7:Login as reviewer and Reject the Content -Course 	
		creatorUserPageObj.rejectTheContent(COURSE);

		GenericFunctions.waitWebDriver(2000);

		//Logout as Reviewer again 
		signupObj.userLogout();

		//Step 8:Login As Creator
		signupObj.userLogin(CREATOR);

		//Step 9,10 and 11:Go to Drafts, Edit and Re submit the content for review
		creatorUserPageObj.editAndSubmitContent();

		//wait for 2 sec
		GenericFunctions.waitWebDriver(2000);

		//Logout as Creator after Resubmitting the content for Review
		signupObj.userLogout();

		//Step 12:Login as Reviewer , 
		signupObj.userLogin(REVIEWER);

		//Step 13:Navigation to Up for review and then publish the content
		creatorUserPageObj.searchInUpForReview(COURSE, objListOFTestDataForSunbird);

		GenericFunctions.waitWebDriver(2000);

		//Step 14:Go to up for review and publish the content
		creatorUserPageObj.publishAndSearch(COURSE,objListOFTestDataForSunbird);

		//wait for 2 sec
		GenericFunctions.waitWebDriver(2000);

		//Logout as Reviewer
		signupObj.userLogout();

		/*//Step15: Login as Creator
		signupObj.userLogin(CREATOR);

		//Step16: Navigate to WorkSpace-All my content
		genereicFunctions.navigateToWorkspaceFeatures(ALL_MY_CONTENT);

		//Step17: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step18: Logout as Creator
		signupObj.userLogout();*/
	}

}
