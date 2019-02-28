package org.testscript.mentor;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.BatchUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class ToVerifyUpdatingOfOngoingBatchForSearchedCourse extends BaseTest{
	@Test(groups= {"regression1","mentor"})
	public void toVerifyUpdatingOfOngoingBatchForSearchedCourse() throws Exception {
		
		  // Login as Mentor
	      SignUpPageObj mentorLogin = new SignUpPageObj();
	      mentorLogin.userLogin(MENTOR);
		
	      // Create Invite Only Batch
	      BatchUserPageObj BatchUserPageObj = new BatchUserPageObj();
	      BatchUserPageObj.navigateToWorkspaceAndSelectBatches("Ongoing Batches");
		
		  // Update ongoing Batch		
	      BatchUserPageObj.navigateToCourseSearchAndUpdate();
		  
	}
}
