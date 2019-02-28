/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 06/26/2018

* Purpose: Navigate to announcement Dashboard.

*/
package org.testscript.announcementsender;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.generic.GenericFunctions;
import org.pageobjects.CreatorAnnouncementPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;


public class NavigateToAnnouncementDashboard extends BaseTest {
	
	@Test (groups={"sanity2", "regression1","announcementsender"})
	public void navigateToAnnouncementDashboard() throws Exception
	{	
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorAnnouncementPageObj creatorAnnouncementPageObj =new CreatorAnnouncementPageObj();
		
		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to Announcement Dashboard NavigateToAnnouncementDashboardin Dropdown
		creatorAnnouncementPageObj.navigateToAnnouncementInDropDownMenu();
		
		//Step3: Logout as Creator
		creatorLogin.userLogout();
	}
	

}
