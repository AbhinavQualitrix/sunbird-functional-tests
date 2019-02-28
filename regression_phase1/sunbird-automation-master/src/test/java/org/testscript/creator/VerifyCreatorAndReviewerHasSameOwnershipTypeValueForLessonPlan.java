package org.testscript.creator;

import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.WorkspacePageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class VerifyCreatorAndReviewerHasSameOwnershipTypeValueForLessonPlan  extends BaseTest 
{
	//TC_633
	@Test(groups= {"newfeature","regression1"})
	public void verifyCreatorAndReviewerHasSameOwnershipTypeForLessonPlan() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		GenericFunctions genericMethods = new GenericFunctions();

		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

		//Step 1 : Login As Content creator
		signupObj.userLogin(CREATOR);

		//Step 2 : navigate to workspace 
		creatorUserPageObj.navigateToWorkspace(LESSONPLAN);

		//Create new Lesson plan
		String contentName=creatorUserPageObj.createNewLessonPlan(objListOFTestDataForSunbird);

		//Step 4 : save and send lesson plan for review
		String selectedOwnershipType=creatorUserPageObj.saveAndSendNewLessonPlanForReview();

		//Logout as Creator
		signupObj.userLogout();

		//Step 5 : Login as Reviewer
		signupObj.userLogin(REVIEWER);

		//Step 6 : Navigate to Up For Review
		genericMethods.navigateToWorkspaceFeatures(UP_FOR_REVIEW);

		//Step 7 : Click on the created content from Up For Review section
		workspacePageObj.openTheCreatedContentFromUpForReview(contentName);

		//Step 8 :  Check the OWNERSHIP field value
		workspacePageObj.verifyownershipTypeValueOfTheContent(null,selectedOwnershipType);

		//Step 9 :Logout as Reviewer
		signupObj.userLogout();		
	}

}
