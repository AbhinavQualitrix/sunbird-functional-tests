package org.testscript.reviewer;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.generic.GenericFunctions;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.UpForReviewPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyLatestContentOnTopForReviewer extends BaseTest 
{
 @Test(groups= {"reviewer","regression1"})
  		public void verifyLatestContentOnTopForReviewer() throws Exception{
	  		  
	 		  // Step 1 : Login as reviewer
			  SignUpPageObj reviewerLogin = new SignUpPageObj();			  			 
			  reviewerLogin.userLogin(REVIEWER);
			  
			  GenericFunctions.waitWebDriver(2000);
			  
			  // Step 2 : Go to workspace and click on upForReview
			  UpForReviewPageObj UpForReviewPageObj = new UpForReviewPageObj();
			  UpForReviewPageObj.reviewerUpForReview();
	  	  
    }
}
