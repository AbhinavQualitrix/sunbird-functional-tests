/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/17/2018

* Purpose: Create course as Mentor and try to create  invite only batch for it,invited member should consume it,if it is ongoing else not.

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
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class ConsumeCourseByInvitedMember extends BaseTest
{
	@Test(groups={"mentor","regression1","sanity"})
	public void consumeCourseByInvitedMember() throws Exception
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
		
		//Step13:Logout as Mentor
		userLogin.userLogout();	
		
		//Step14:Login as Invited Member
		userLogin.userLogin(REVIEWER);
		
		//Step15:Consume  the course if ongoing else not
		createMentorPageObj.navigateToCourseAndSearch(courseName);
		
		//Step16: Logout as mentor
		userLogin.userLogout();	
		
		//Step17: Login as Creator
		userLogin.userLogin(MENTOR);

		//Step18: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step19: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step20: Logout as Creator
		userLogin.userLogout();
		
		
		
		
	}
	
	
}
