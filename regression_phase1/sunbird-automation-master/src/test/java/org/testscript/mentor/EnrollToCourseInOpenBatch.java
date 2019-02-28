/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/24/2018

* Purpose: Create course as Mentor and try to create open batch for it,public user should consume it,mentor can check the stats.

*/

package org.testscript.mentor;

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
import org.page.CreatorUserPage;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class EnrollToCourseInOpenBatch extends BaseTest
{
	@Test(groups={"mentor","regression1","sanity1"})
	public void enrollToCourseInOpenBatch() throws Exception
	{
		
		
		List <TestDataForDiksha> 	objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		CreateMentorPageObj createMentorPageObj=new CreateMentorPageObj();
		
	
		
		//Step1: Login as Mentor
		userLogin.userLogin(MENTOR);
		
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(COURSE);
		
		
		//Step3: Create new Course
		creatorUserPageObj.createCourseForOpenBatch(objListOFTestDataForSunbird);
		
		
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
		creatorUserPageObj.searchInUpForReviewForOpenbatch(COURSE,objListOFTestDataForSunbird);
		
		
		//Step9:Publish the Course
		creatorUserPageObj.publishAndSearchForOpenBatch(COURSE,objListOFTestDataForSunbird);
		
		
		//Step10: Logout as Reviewer		
		userLogin.userLogout();	
		
		
		//Step11:Login as Mentor
		userLogin.userLogin(MENTOR);
		
		
		//Step12:Search the course created by same user
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch();
		
		
		//Sttep13:create open  batch
		createMentorPageObj.createOpenBatch();
		
		//Step14:Logout as Mentor
		userLogin.userLogout();	
		
		
		//Step15:Login as Public user
		userLogin.userLogin(PUBLICUSER1);
		
		
		//Step16:Search for the course
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch();
		
		//Step17:Enroll for the open batch
		createMentorPageObj.enrollForOpenBatch();
		
		//Step18:Logout as public user
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
