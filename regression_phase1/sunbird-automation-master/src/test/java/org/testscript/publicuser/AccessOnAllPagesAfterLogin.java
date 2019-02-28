package org.testscript.publicuser;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.AnnouncementCreationsPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class AccessOnAllPagesAfterLogin extends BaseTest
{
	//Maintenance Done- 09th nov
	@Test(groups= {"regression1","publicuser"})
	public void verify_PageAccessOnLogin() throws Exception
	{	
		//Login as Content creator
		SignUpPageObj userLogin = new SignUpPageObj();
		AnnouncementCreationsPageObj announcementCreationPageObj = new AnnouncementCreationsPageObj();
		userLogin.userLogin(CREATOR);

		//Navigate to Course page
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		announcementCreationPageObj.navigateToCoursePage();
		
		//Navigate to Library page
		announcementCreationPageObj.navigateToLibraryPage();
		
		//Navigate to Profile page
		announcementCreationPageObj.navigateToProfilePage();
		
		//User sign out
		userLogin.userLogout();
	}

}







