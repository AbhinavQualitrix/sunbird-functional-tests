package org.testscript.mentor;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.BatchUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class ToVerifyUpdatingOfUpcomingBatchForSearchedCourse extends BaseTest{
	@Test(groups= {"regression1","mentor","creator"})
	public void toVerifyUpdatingOfUpcomingBatchForSearchedCourse() throws Exception {
		
		  // Login as Mentor
	      SignUpPageObj mentorLogin = new SignUpPageObj();
	      mentorLogin.userLogin(MENTOR);
		
	      // Create Invite Only Batch
	      BatchUserPageObj BatchUserPageObj = new BatchUserPageObj();
	      BatchUserPageObj.navigateToWorkspaceAndSelectBatches("Upcoming Batches");
		
		  // Update Upcoming Batch		
	      BatchUserPageObj.updateUpcomingBatches();
		  
	}
}
