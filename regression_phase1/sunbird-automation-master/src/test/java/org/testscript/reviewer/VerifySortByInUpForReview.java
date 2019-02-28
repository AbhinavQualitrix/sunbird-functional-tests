package org.testscript.reviewer;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.UpForReviewPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifySortByInUpForReview extends BaseTest
{
  @Test(groups= {"reviewer","regression1"})
  public void verifySortByInUpForReview() throws Exception{
	  
	  // Login as reviewer
	  SignUpPageObj reviewerLogin = new SignUpPageObj();
	  reviewerLogin.userLogin(REVIEWER);
	  
	  // Go to Workspace < click on upForReview < Search content
	  UpForReviewPageObj UpForReviewPageObj = new UpForReviewPageObj();
	  UpForReviewPageObj.UpForReviewSortBy();
	  
	    
  }
}
