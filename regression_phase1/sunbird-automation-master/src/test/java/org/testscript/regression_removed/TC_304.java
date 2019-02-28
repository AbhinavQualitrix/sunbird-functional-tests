package org.testscript.regression_removed;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.BatchUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_304 extends BaseTest{
	@Test(groups="regressionP2")
	public void TC_304_rootOrg() throws Exception
	{//DOUBT SAME AS 301, 302, 303
		
		  // Login as Mentor
	      SignUpPageObj mentorLogin = new SignUpPageObj();
	      mentorLogin.userLogin(MENTOR);
		
	      // Create Invite Only Batch
	      BatchUserPageObj BatchUserPageObj = new BatchUserPageObj();
	      BatchUserPageObj.navigateToWorkspaceAndSelectBatches("Upcoming Batches");
		
		  // Update Upcoming Batch		
	      BatchUserPageObj.navigateToCourseSearchAndUpdate();
		  
	}
}
