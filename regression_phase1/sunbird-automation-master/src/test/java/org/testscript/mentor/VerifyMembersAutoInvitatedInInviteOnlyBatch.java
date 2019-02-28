package org.testscript.mentor;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.MentorOrgPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyMembersAutoInvitatedInInviteOnlyBatch extends BaseTest{
	@Test(groups= {"mentor","regression1"})
	public void verifyMembersAutoInvitatedInInviteOnlyBatch() throws Exception {
		
		  // Login as Mentor
	      SignUpPageObj mentorLogin = new SignUpPageObj();
	      mentorLogin.userLogin(MENTOR);
		
	      // Create Invite Only Batch
		//CreateMentorPageObj CreateMentorPageObj = new CreateMentorPageObj();
	      MentorOrgPageObj MentorOrgPageObj = new MentorOrgPageObj();
	      MentorOrgPageObj.createInviteOnlyBatch();
		
		
	}
}
