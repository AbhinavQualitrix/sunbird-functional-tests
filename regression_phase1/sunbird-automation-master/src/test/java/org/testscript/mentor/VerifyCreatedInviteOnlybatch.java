package org.testscript.mentor;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.BatchUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyCreatedInviteOnlybatch extends BaseTest{
	@Test(groups= {"mentor","regression1"})
	public void verifyCreatedInviteOnlybatch() throws Exception
	{//308 - have a look at createInviteBatch() method
		
		  // Login as Mentor
	      SignUpPageObj mentorLogin = new SignUpPageObj();
	      mentorLogin.userLogin(MENTOR);
		
	      // Create Invite Only Batch
	      BatchUserPageObj BatchUserPageObj = new BatchUserPageObj();
	      BatchUserPageObj.createInviteBatch();
		
		// Verify the batch created
	      BatchUserPageObj.verifyCreatedBatch();
		
		
		
	}
}
