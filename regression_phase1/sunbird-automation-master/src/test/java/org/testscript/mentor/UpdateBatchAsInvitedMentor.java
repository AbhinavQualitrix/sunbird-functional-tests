/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/16/2018

* Purpose: After creating invite only batch,check invited mentor can update it.

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

public class UpdateBatchAsInvitedMentor extends BaseTest 
{
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	List <TestDataForDiksha> objListOFTestDataForSunbird= null;
	
	
	@Test(groups= {"regression1","mentor","sanity2"})
	public void updateBatchAsInvitedMentor() throws Exception
	{
		
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		CreateMentorPageObj createMentorPageObj=new CreateMentorPageObj();
		
		//Step1: Login as Mentor
		userLogin.userLogin(MENTOR);

		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(COURSE);

		//Step3: Create new Course
		creatorUserPageObj.createCourse(objListOFTestDataForSunbird);

		//Step4: Save and Send for Review
		creatorUserPageObj.saveAndSendnewCourseForReview(objListOFTestDataForSunbird);
		GenericFunctions.refreshWebPage();

		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(COURSE,objListOFTestDataForSunbird);

		//Step6: Logout as Mentor
		userLogin.userLogout();

		//Step7: Login as Reviewer
		userLogin.userLogin(REVIEWER);

		//Step8: Search the course which was submitted for review
		creatorUserPageObj.searchInUpForReview(COURSE,objListOFTestDataForSunbird);

		//Step9:Publish the Course
		creatorUserPageObj.publishAndSearch(COURSE,objListOFTestDataForSunbird);

		//Step10: Logout as Reviewer		
		userLogin.userLogout();	

		//Step11:Login as Mentor
		userLogin.userLogin(MENTOR);

		//Step12:Search the course and create invite only batch
		String courseName=createMentorPageObj.createInviteOnlyBatch();
		System.out.println(courseName);
		
		//Step13: Logout as mentor
		userLogin.userLogout();
		           
		//Step14: Login as mentor
		userLogin.userLogin(MENTOR);
		
		//Step15: Search for the particular course and update the batch
		createMentorPageObj.navigateToCourseSearchAndUpdate(courseName);
		String expected = courseName;
		System.out.println(expected);
		
		//Step16: Logout as mentor
		userLogin.userLogout();
		
		//Step17: Login as invited member  
		userLogin.userLogin(REVIEWER);
					
		//Step18: Search for the particular course 		
		createMentorPageObj.navigateToCourseAndSearch(courseName);
		
		//Step19: Logout as mentor
		userLogin.userLogout();
		
		//Step20: Login as Creator
		userLogin.userLogin(MENTOR);

		//Step21: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step22: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step23: Logout as Creator
		userLogin.userLogout();

	}
}
