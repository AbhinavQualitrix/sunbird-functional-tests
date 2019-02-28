package org.testscript.regression_removed;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.BatchUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_301 extends BaseTest{
	@Test(groups="regressionP2")
	public void TC_301_rootOrg() throws Exception 
	{//Doubt
		
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
