/**

 * Created by Qualitrix Technologies Pvt Ltd.

 * @author: Abhinav kumar singh

 * Date: 06/28/2018

 * Purpose: Open an Announcement,details should open up.

 */
package org.testscript.announcementsender;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.generic.GenericFunctions;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorAnnouncementPage;
import org.pageobjects.CreatorAnnouncementPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenAnnouncement extends BaseTest {
	String announcementName;
	String verifyannouncementName;

	@Test( groups={"sanity2", "regression1","announcementsender"})
	public void openAnnouncement() throws Exception
	{
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorAnnouncementPageObj creatorAnnouncementPageObj = new CreatorAnnouncementPageObj();

		// Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);

		// Step2: Navigate to Announcement Dashboard in Dropdown
		creatorAnnouncementPageObj.navigateToAnnouncementInDropDownMenu();

		//Step3:  Click on particular Announcement.
		creatorAnnouncementPageObj.openAnnouncement();

		//Step4: Logout as Creator.
		creatorLogin.userLogout();




	}


}
