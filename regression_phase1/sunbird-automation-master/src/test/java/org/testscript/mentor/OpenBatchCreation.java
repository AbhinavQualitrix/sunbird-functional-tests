package org.testscript.mentor;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.BatchUserPageObj;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class OpenBatchCreation extends BaseTest {
  @Test(groups={"mentor","regression1","sanity2"})
  public void openBatchCreation() throws Exception{
	  
	  List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		GenericFunctions genereicFunctions= new GenericFunctions();
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreateMentorPageObj createMentorPageObj= new CreateMentorPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		
		//Step1: Login as Creator
		creatorLogin.userLogin(MENTOR);
		
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
		
	  // Login as Course mentor
		creatorLogin.userLogin(MENTOR);
		 
		//Step11: Search the course with Name
		GenericFunctions.waitWebDriver(2000);
		createMentorPageObj.navigateToCourseAndSearchForOpenBatch();
		 
	  // Now as course mentor search for the created course on Course page
		//Step13:create open  batch
		createMentorPageObj.createOpenBatch();
		
		//Step14:Logout as Mentor
		creatorLogin.userLogout();	
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
		 
  }
}
