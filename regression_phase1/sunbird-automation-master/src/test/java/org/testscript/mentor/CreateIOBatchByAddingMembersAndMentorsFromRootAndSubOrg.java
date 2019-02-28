package org.testscript.mentor;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.BatchUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class CreateIOBatchByAddingMembersAndMentorsFromRootAndSubOrg extends BaseTest{
	@Test(groups={"mentor","regression1"})
	public void createIOBatchByAddingMembersAndMentorsFromRootAndSubOrg() throws Exception {
		
		  // Login as Mentor
	      SignUpPageObj mentorLogin = new SignUpPageObj();
	      mentorLogin.userLogin(MENTOR);
		
	      // Create Invite Only Batch
		// CreateMentorPageObj CreateMentorPageObj = new CreateMentorPageObj();
	      BatchUserPageObj BatchUserPageObj = new BatchUserPageObj();
	      BatchUserPageObj.createInviteBatch();
		
		
	}
}
