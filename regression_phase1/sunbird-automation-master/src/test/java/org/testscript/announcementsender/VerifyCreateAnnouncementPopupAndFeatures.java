package org.testscript.announcementsender;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.generic.GenericFunctions;
import org.pageobjects.AnnouncementPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyCreateAnnouncementPopupAndFeatures extends BaseTest
{
	@Test(groups={"sanity", "regression1","announcementsender"})
	public void verifyCreateAnnouncementPopupAndFeatures() throws Exception{
		SignUpPageObj orgAdminLogin = new SignUpPageObj();
		AnnouncementPageObj announcementPageObj = new AnnouncementPageObj();

		// Step1: Log in as Admin
		orgAdminLogin.userLogin(CREATOR);

		// Step2: Go to announcements page and click on create announcement link.
		announcementPageObj.navigateToAnnouncementInDropDownMenu();


		/* Step3:
		 *  Click on the "announcement type" drop down.
          Select the organization that has sent the announcement.
          Give the description of the announcement.
          Try to add any web link or URL at the add web/URL field.*/
		GenericFunctions.waitWebDriver(3000);
		announcementPageObj.CreateAnnouncementPopUp();


	}
}