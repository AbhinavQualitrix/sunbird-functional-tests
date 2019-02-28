package org.testscript.mentor;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.BatchUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class NavigateToWorkspaceAndSelectPreviousBatches extends BaseTest{
	@Test(groups={"mentor","regression1","sanity2"})
	public void navigateToWorkspaceAndSelectPreviousBatches() throws Exception 
	{//310
		
		  // Login as Mentor
	      SignUpPageObj mentorLogin = new SignUpPageObj();
	      mentorLogin.userLogin(MENTOR);
		
	      // Create Invite Only Batch
	      BatchUserPageObj BatchUserPageObj = new BatchUserPageObj();
	      
	      
	      BatchUserPageObj.navigateToWorkspaceAndSelectBatches("Previous Batches");
		  
		
	
		  
	}
}
