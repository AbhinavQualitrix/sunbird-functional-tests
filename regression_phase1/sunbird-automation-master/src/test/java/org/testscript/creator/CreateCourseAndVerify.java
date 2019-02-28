/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Ajith Manjunath
 * Date: 06/11/2018
 * Purpose: Create a New Course and validate it
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
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class CreateCourseAndVerify extends BaseTest
{
	//MT done
	@Test(priority=1, groups={"creator","sanity","regression","smoke"})
	public void createCourseAndVerify() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		GenericFunctions genereicFunctions= new GenericFunctions();
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreateMentorPageObj createMentorPageObj= new CreateMentorPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();

		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(COURSE);

		//Step3: Create new Course
		creatorUserPageObj.createCourseForOpenBatch(objListOFTestDataForSunbird);

		//Step4: Save and Send for Review
		creatorUserPageObj.saveAndSendnewCourseForReview(objListOFTestDataForSunbird);

		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(COURSE,objListOFTestDataForSunbird);

		//Step6: Logout as Creator
		creatorLogin.userLogout();
		 
		
		//Step7: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);
		
		//Step8: Search the course which was submitted for review
		creatorUserPageObj.searchInUpForReviewForOpenbatch(COURSE,objListOFTestDataForSunbird);

		//Step9:Publish the Course
		creatorUserPageObj.publishAndSearchForOpenBatch(COURSE,objListOFTestDataForSunbird);

		// Logout as Reviewer
		creatorLogin.userLogout();
		
		//Step10: Login as Public User
		creatorLogin.userLogin(PUBLICUSER1);

		//Step11: Search the course with Name
		GenericFunctions.waitWebDriver(2000);
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch();

		//Step 12: Logout as Reviewer
		creatorLogin.userLogout();	
		
		//Step 13: Login as Creator
		creatorLogin.userLogin(CREATOR);

		//Step14: Navigate to WorkSpace-All my content
		creatorUserPageObj.navigateToWorkspace(ALL_MY_CONTENT);
		
		//Step 15: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step 16: Logout as Creator
		creatorLogin.userLogout();
		 
	




	
		
			
		
	}

}