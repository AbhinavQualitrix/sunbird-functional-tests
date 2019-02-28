/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 08/03/2018

* Purpose: Create Lesson plan as creator and publish as reviewer and consume as Public user.

*/
package org.testscript.creator;

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


@Test(groups={"creator","regression","smoke1"})
public class CreateLessonAndVerify extends BaseTest {	
	
	
	public void createLessonAndVerify() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		
		//Step1: Login as Creator
		SignUpPageObj creatorLogin = new SignUpPageObj();
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to WorkSpace
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		creatorUserPageObj.navigateToWorkspace(LESSONPLAN);
		
		//Step3: Create new Lesson Plan
		creatorUserPageObj.createNewLessonPlan(objListOFTestDataForSunbird);
		
		//Step4: Save and send resource for review
		
		creatorUserPageObj.saveAndSendNewLessonPlanForReview();
		GenericFunctions.refreshWebPage();
			
		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(LESSONPLAN,objListOFTestDataForSunbird);
		
		GenericFunctions.waitWebDriver(3000);

		//Step6: Logout as Creator
		creatorLogin.userLogout();
		
		//Step7: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);
		
		//Step8: Search the course which was submitted for review
		GenericFunctions.waitWebDriver(2000);
		creatorUserPageObj.searchInUpForReview(LESSONPLAN,objListOFTestDataForSunbird);
		
		
		//Step 9:publish the resource and search it
		creatorUserPageObj.LessonPlanPublishAndSearch(objListOFTestDataForSunbird);
		
		//Step 10: Logout as Reviewer
		creatorLogin.userLogout();		
		
		//Step11: Login as Public User
		creatorLogin.userLogin(PUBLICUSER1);

		//Step12: Search the course with Name
		GenericFunctions.waitWebDriver(2000);
		CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
		createMentorPageObj.navigateToLibraryAndSearchForLessonPlan();

		//Step 13: Logout as Reviewer
		creatorLogin.userLogout();
		
		//Step14: Login as Creator
		creatorLogin.userLogin(CREATOR);

		//Step15: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step16: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step17: Logout as Creator
		creatorLogin.userLogout();
		
	}

}
