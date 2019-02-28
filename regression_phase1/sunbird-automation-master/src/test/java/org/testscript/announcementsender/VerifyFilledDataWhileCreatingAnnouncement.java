package org.testscript.announcementsender;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.AnnouncementPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyFilledDataWhileCreatingAnnouncement extends BaseTest
{
	@Test(groups= {"announcementsender","sanity", "regression1"})
	public void verifyFilledDataWhileCreatingAnnouncement() throws Exception
	{
		SignUpPageObj orgAdminLogin = new SignUpPageObj();


		// Step1: Log in as Admin
		orgAdminLogin.userLogin(CREATOR);

		// Go to announcement Page
		AnnouncementPageObj announcementPageObj = new AnnouncementPageObj();
		announcementPageObj.navigateToAnnouncementInDropDownMenu();

		// Edit and resend the announcement   
		announcementPageObj.verifyDataStorage();


	}
}