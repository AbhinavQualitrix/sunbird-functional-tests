package org.testscript.reviewer;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.UpForReviewPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyFiltersCanBeAppliedInUpForReview extends BaseTest{
  @Test(groups= {"reviewer","regression1"})
  public void verifyFiltersCanBeAppliedInUpForReview() throws Exception{
	  	  
	  
	  SignUpPageObj reviewerLogin = new SignUpPageObj();
	  UpForReviewPageObj UpForReviewPageObj = new UpForReviewPageObj();
	  
	  //  Login as Reviewer
	  reviewerLogin.userLogin(REVIEWER);
	  
	  // Go to Workspace and click on upForReview
	  UpForReviewPageObj.reviewerUpForReview();
	  
	  
	  // Fill the filter options and click on apply button
	  UpForReviewPageObj.showFilters();
	  

  }
}