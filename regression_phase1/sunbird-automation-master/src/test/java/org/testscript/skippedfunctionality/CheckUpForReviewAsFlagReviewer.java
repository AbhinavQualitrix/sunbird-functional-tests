package org.testscript.skippedfunctionality;

import org.pageobjects.FlagReviewerPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class CheckUpForReviewAsFlagReviewer extends BaseTest 
{
	@Test(groups= {"skippedfunctionality"})
	public void checkUpForReviewAsFlagReviewer() throws Exception
	{
		//Step1: Login as creator
		SignUpPageObj creatorObj = new SignUpPageObj();	
		creatorObj.userLogin(FLAGREVIEWER);
		
		//Step2: Search for a course and content flag them
		FlagReviewerPageObj flagReviewer = new FlagReviewerPageObj();
		flagReviewer.flagged_UpforReview();
	}

}
