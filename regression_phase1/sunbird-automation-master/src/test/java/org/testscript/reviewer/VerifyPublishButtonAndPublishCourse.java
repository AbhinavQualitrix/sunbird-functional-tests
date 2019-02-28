package org.testscript.reviewer;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.UpForReviewPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyPublishButtonAndPublishCourse extends BaseTest{
  @Test(groups= {"reviewer","regression1"})
  public void verifyPublishButtonAndPublishCourse() throws Exception{
	  	  
	  //  Login as Reviewer
	  SignUpPageObj reviewerLogin = new SignUpPageObj();
	  reviewerLogin.userLogin(REVIEWER);
	  
	  // Go to Workspace and click on upForReview
	  
	  UpForReviewPageObj UpForReviewPageObj = new UpForReviewPageObj();
	  UpForReviewPageObj.publishCourse();
	  

  }
}