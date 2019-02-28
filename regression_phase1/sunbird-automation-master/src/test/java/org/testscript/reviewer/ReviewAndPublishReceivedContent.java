package org.testscript.reviewer;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class ReviewAndPublishReceivedContent extends BaseTest
{
	//Files yet to update from Richa
	//TC146
	@Test(groups= {"reviewer","regression1"})
	public void reviewAndPublishReceivedContent() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		ContentCreationResourcePageObj contentReourcePageObj= new ContentCreationResourcePageObj();
		
		//1.Login as content creator
		userLogin.userLogin(REVIEWER);
		
		//Go to workspace and click on Up for Review
		//contentReourcePageObj.goToWorkspaceAndClick("Up for review");
		
		GenericFunctions.waitWebDriver(2000);
		creatorUserPageObj.searchInUpForReview(COURSE,objListOFTestDataForSunbird);
		
		//Publish the Course
		creatorUserPageObj.publishAndSearch(COURSE,objListOFTestDataForSunbird);
		
		//Logout as Reviewer
		userLogin.userLogout();
	}
}
