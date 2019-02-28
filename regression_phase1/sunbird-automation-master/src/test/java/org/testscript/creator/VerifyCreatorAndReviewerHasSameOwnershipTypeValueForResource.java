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

public class VerifyCreatorAndReviewerHasSameOwnershipTypeValueForResource extends BaseTest
{
	//TC_631
	@Test(groups= {"newfeature","regression1"})
	public void verifyCreatorAndReviewerHasSameOwnershipTypeValueForResource() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");

		SignUpPageObj signupObj = new SignUpPageObj();
		WorkspacePageObj workspacePageObj = new WorkspacePageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		GenericFunctions genericMethods = new GenericFunctions();


		//Step 1 : Login As Content creator
		signupObj.userLogin(CREATOR);

		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(RESOURCE);

		//Step3: Create new Resource
		String contentName = creatorUserPageObj.createQuestion(objListOFTestDataForSunbird);

		//Step4: Save and send resource for review
		String seletedOwnerType=creatorUserPageObj.saveAndSendResouceForReview();

		// Logout as Creator
		signupObj.userLogout();

		//Step 5 : Login as Reviewer
		signupObj.userLogin(REVIEWER);	

		//Step 6 : Navigate to Up For Review
		genericMethods.navigateToWorkspaceFeatures(UP_FOR_REVIEW);

		//Step 7 : Click on the created content from Up For Review section
		workspacePageObj.openTheCreatedContentFromUpForReview(contentName);

		//Step 8 :  Check the OWNERSHIP field value
		workspacePageObj.verifyownershipTypeValueOfTheContent(seletedOwnerType,null);

		//Step 7 :Logout as Reviewer
		signupObj.userLogout();
	}

}
