package org.testscript.skippedfunctionality;

import org.generic.GenericFunctions;
import org.pageobjects.FlagReviewerPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class DiscardAsFlagReviewer extends BaseTest
{
	@Test(groups= {"skippedfunctionality"})
	public void discardAsFlagReviewer() throws Exception
	{
		SignUpPageObj signUpPageObj = new SignUpPageObj();
		FlagReviewerPageObj flagReviewer = new FlagReviewerPageObj();
		
		//Step1: Login as Public user
		signUpPageObj.userLogin(PUBLICUSER1);
		
		//Step2: search a course, a content and flag them
		String courseName=flagReviewer.flagCourseContent();
		System.out.println("course flagged: "+courseName);
		GenericFunctions.waitWebDriver(2000);
		String contentName=flagReviewer.genericContentSearch();
		System.out.println("content flagged: "+contentName);
		GenericFunctions.waitWebDriver(2000);
		
		//Step3: Logout as public user
		signUpPageObj.userLogout();
		
		//Step4: Login as Flag reviewer
		signUpPageObj.userLogin(FLAGREVIEWER);
		
		//Step5: Discard the flag of course 
		flagReviewer.acceptDiscardFlag(DISCARD);
		GenericFunctions.waitWebDriver(2000);
		GenericFunctions.refreshWebPage();
		
		//Step6: Discard the flag of content
		flagReviewer.acceptDiscardFlag(DISCARD);
		
		//Step7: Check the course in Courses
		String checkedCourse=flagReviewer.checkCourseInCourses(courseName);
		
		//Step8: Check content in Library
		String checkedContent=flagReviewer.checkContentInLib();
		if(courseName.equalsIgnoreCase(checkedCourse)&&contentName.equalsIgnoreCase(checkedContent))
		{
			System.out.println("Course is correctly flagged, Discarded and checked");
			System.out.println("Content is correctly flagged, Discarded and checked");
		}
		else
		{
			System.out.println("Course/Content is not Correctly flagged,Discarded and checked");
		}
		
		//Step9: Logout as flag reviewer
		signUpPageObj.userLogout();
		
		
	}

}
