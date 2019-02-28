/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Ajith Manjunath
 * Date: 06/26/2018
 * Purpose: Published content shows in "Published" bucket
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

public class VerifyPublishedBucket extends BaseTest
{
	//MT done
	@Test( groups={"creator","sanity2","regression2"})//priority=16,
	public void verifyPublishedBucket() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForDiksha= null ;
		objListOFTestDataForDiksha = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		GenericFunctions genereicFunctions = new GenericFunctions();
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();

		//Step 1:Login as Creator
		signupObj.userLogin(CREATOR);

		//Step 2:Navigate to workspace to Create a course
		creatorUserPageObj.navigateToWorkspace(COURSE);

		//Step 3:Create a Course
		creatorUserPageObj.createCourse(objListOFTestDataForDiksha);

		//Step 4:Save and submit the coursed for Review
		creatorUserPageObj.saveAndSendnewCourseForReview(objListOFTestDataForDiksha);

		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.refreshWebPage();

		//Logout as creator
		signupObj.userLogout();

		//Step 5:Login as Reviewer
		signupObj.userLogin(REVIEWER);

		//wait for 2 sec
		GenericFunctions.waitWebDriver(2000);

		//Step 6:Search the course in Up for review		
		creatorUserPageObj.searchInUpForReview(COURSE,objListOFTestDataForDiksha);

		//Step 7:Publish the course 
		creatorUserPageObj.publishAndSearch(COURSE,objListOFTestDataForDiksha);

		//Logout as Reviewer
		signupObj.userLogout();

		//Step 8:Login as Creator
		signupObj.userLogin(CREATOR);

		//Step 8a:Checked the publishes course in Published Bucket
		creatorUserPageObj.checkInPublished(COURSE,objListOFTestDataForDiksha);

		//Logout as Creator
		signupObj.userLogout();

		/*//Step9: Login as Creator
		signupObj.userLogin(CREATOR);

		//Step10: Navigate to WorkSpace-All my content
		genereicFunctions.navigateToWorkspaceFeatures(ALL_MY_CONTENT);

		//Step11: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step12: Logout as Creator
		signupObj.userLogout();*/

	}

}
