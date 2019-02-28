package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.UpForReviewPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class SearchTheContentInUpForReview extends BaseTest
{
  @Test(groups={"creator","regression2","reviewer"})
  public void searchTheContentInUpForReview() throws Exception{
	  
	  // Step 1 : Login as reviewer
	  SignUpPageObj reviewerLogin = new SignUpPageObj();
	  reviewerLogin.userLogin(REVIEWER);
	  
	  // Step 2 : Go to Workspace < click on upForReview < Search content
	  UpForReviewPageObj UpForReviewPageObj = new UpForReviewPageObj();
	  UpForReviewPageObj.UpForReviewsearchContent();

  }
}
