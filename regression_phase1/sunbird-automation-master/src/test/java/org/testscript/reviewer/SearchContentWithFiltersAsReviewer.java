package org.testscript.reviewer;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class SearchContentWithFiltersAsReviewer extends BaseTest
{
	@Test(groups= {"reviewer","regression1"})
	public void searchContentWithFiltersAsReviewer() throws Exception
	{
		//MT done
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		SignUpPageObj signupObj = new SignUpPageObj();
		
		
		//Step1: Login as Creator
		signupObj.userLogin(CREATOR);

		//Go to workspace , create a book,submit for review
		creatorUserPageObj.createLessonPlan();
		
		//Save and send for Review
		creatorUserPageObj.saveAndSendNewLessonPlanForReview();
		
		//Logout as Creator
		signupObj.userLogout();
		
		//Login as content reviewer
		signupObj.userLogin(REVIEWER);
		
		//Navigate to workspace and apply filter and search the content type-Lesson plan
		creatorUserPageObj.searchTheCreatedContentWithFilters();
		
		//Logout as reviewer
		signupObj.userLogout();
		
	}

}
