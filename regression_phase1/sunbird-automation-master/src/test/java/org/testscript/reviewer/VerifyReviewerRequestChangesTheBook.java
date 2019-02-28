package org.testscript.reviewer;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.ContentCreationLessonPlanPageObj;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class VerifyReviewerRequestChangesTheBook  extends BaseTest
{
	//Files yet to update from Richa
	@Test(groups= {"reviewer","regression1"})
	public void verifyReviewerRequestChangesTheBook() throws Exception
	{
		
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		SignUpPageObj creatorLogin = new SignUpPageObj();
		ContentCreationLessonPlanPageObj contentLessonPlanObj= new ContentCreationLessonPlanPageObj();

		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(BOOK);
		
		//Step3: Create new book
		creatorUserPageObj.createBook(objListOFTestDataForSunbird);
		
		//Step4: Save and send resource for review
		creatorUserPageObj.saveAndSendBookForReview(objListOFTestDataForSunbird);
		GenericFunctions.refreshWebPage();
		creatorLogin.userLogout();
		
		//1.Login as  reviewer
		creatorLogin.userLogin(REVIEWER);
		
		//2.Navigate to workspace-
		contentLessonPlanObj.navigateToUpForReview();
		
		//3.Go to up for Review
		contentLessonPlanObj.rejectTheContent();
		
	
		//4.User is again redirected back to up for review section
		//contentLessonPlanObj.verifyReviewerIsRedirectedPage();
	}
}
