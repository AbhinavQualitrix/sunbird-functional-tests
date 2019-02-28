package org.testscript.creator;

import org.pageobjects.MentorOrgPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;


public class VerifyCourseCanBePreviewed extends BaseTest
{
	@Test(groups={"regression2","creator"})
	public void verifyCourseCanBePreviewed() throws Exception{
		
	// Login as mentor
	SignUpPageObj creator = new SignUpPageObj();
	creator.userLogin(CREATOR);
	
	// Preview any course
	
	//CreatorUserPageObj creatorUserPage = new CreatorUserPageObj();
	MentorOrgPageObj MentorOrgPageObj = new MentorOrgPageObj();
	
	MentorOrgPageObj.coursePreview();
	
	}

}
