/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 08/02/2018

* Purpose: Edit Book as creator and publish as reviewer and consume as Public user.

*/
package org.testscript.creator;

import org.testng.annotations.Test;
import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class EditBookAndVerify extends BaseTest {
	
	@Test(groups={"creator","regression2","sanity2"})
	public void editBookAndVerify() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);
		
		//Step3: Navigate to All my activity and Search
		creatorUserPageObj.navigateToAllMyContentAndSearch(objListOFTestDataForSunbird,BOOK);
		
		//Step4: Create new Course
		creatorUserPageObj.editBook(objListOFTestDataForSunbird);
		
		//Step5: Save and send resource for review
		creatorUserPageObj.saveAndSendEdittedBookForReview();
		
		//Step6: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(BOOK,objListOFTestDataForSunbird);

		//Step7: Logout as Creator
		creatorLogin.userLogout();
		
		//Step8: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);
		
		//Step9: Search the course which was submitted for review
		creatorUserPageObj.searchInUpForReviewForEdittedContents(BOOK,objListOFTestDataForSunbird);
		
		//Step10:publish the resource and search it
		creatorUserPageObj.BookPublishAndSearch(objListOFTestDataForSunbird);
		
		//Step11: Logout as Reviewer
		creatorLogin.userLogout();		
		
		//Step12: Login as Public User
		creatorLogin.userLogin(PUBLICUSER1);

		//Step13: Search the course with Name
		createMentorPageObj.navigateToLibraryAndSearchForEdittedBook();

		//Step14: Logout as Reviewer
		creatorLogin.userLogout();
		
		
		
	}

}
