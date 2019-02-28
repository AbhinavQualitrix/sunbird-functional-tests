package org.testscript.mentor;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.MentorOrgPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class MentorCreateCourseAndCreateOpenBatchForIt extends BaseTest 
{
	@Test(groups={"mentor","regression1"})
	public void mentorCreateCourseAndCreateOpenBatchForIt() throws Exception
	{

		
		SignUpPageObj mentorLogin = new SignUpPageObj();
		CreatorUserPageObj CreatorUserPageObj = new CreatorUserPageObj();
		MentorOrgPageObj MentorOrgPageObj = new MentorOrgPageObj();
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		
		// Login as Mentor
		mentorLogin.userLogin(MENTOR);

		// Click on Workspace
		CreatorUserPageObj.navigateToWorkspace(COURSE);

		// Create course
		CreatorUserPageObj.createCourse(objListOFTestDataForSunbird);

		// Save and send course for review
		CreatorUserPageObj.saveAndSendnewCourseForReview(objListOFTestDataForSunbird);

		// Logout 
		MentorOrgPageObj.userLogout();

		// Login back as Reviewer to Publish the course
		mentorLogin.userLogin(REVIEWER);

		// Publish the course
		MentorOrgPageObj.publishCourse();

		// Logout
		MentorOrgPageObj.userLogout();

		// Login as Course mentor
		mentorLogin.userLogin(MENTOR);

		// Search for course created and create batch
		MentorOrgPageObj.navigateToCourseSearchAndCreateBatch();

		// Now as course mentor search for the created course on Course page
		// 7. Click on create batch--> Select open batch

		MentorOrgPageObj.createOpenBatch();















	}
}
