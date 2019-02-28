/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Raju S
* Date: 04/10/2018
* Purpose:  
To verify that the user is able to view the AnnouncementDetails
.
*/
package org.testscript.announcementsender;



import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.generic.GenericFunctions;
import org.openqa.selenium.support.PageFactory;
import org.page.AnnouncementCreationsPage;
import org.pageobjects.AnnouncementCreationsPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyAnnouncementPageContent extends BaseTest
{
	//Maintenance - Done 9th Nov
	@Test(groups={"sanity", "regression1","announcementsender"})//priority=1, 
	public void verifyAnnouncementMessage() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		AnnouncementCreationsPageObj announcementCreationsPageObj=new AnnouncementCreationsPageObj();
		
		//Step1: Login as Creator
		userLogin.userLogin(CREATOR);
		
		//Step2: Navigate to Announcement dashboard and verify
		announcementCreationsPageObj.NavigateToAnnouncementDashboard();
		
		//Step 3: Verify Announcement message 
		//announcementCreationsPageObj.verifyAnnouncementMessage();			
		
		//Step 4: Logout 
		userLogin.userLogout();
	}

	@Test(priority=2, groups={"sanity", "regression"})
	public void VerifyAnnouncementDetails() throws Exception
	{

		SignUpPageObj userLogin = new SignUpPageObj();
		AnnouncementCreationsPageObj announcementCreationsPageObj=new AnnouncementCreationsPageObj();
		
		//Step 1 : Login as creator
		userLogin.userLogin(CREATOR);
		
		
		//Step 2 : Navigate to announcement dashboard
		announcementCreationsPageObj.NavigateToAnnouncementDashboard();
		
		//Step 3 : Validate view announcement section
		announcementCreationsPageObj.ValidateViewAnnouncementSection();
		
		//Step 4 : Logout as creator
		userLogin.userLogout();
		
	}
	

	@Test(priority=3, groups={"sanity", "regression"})
	public void VerifyAnnouncementCreationFields() throws Exception
	{
	
		SignUpPageObj userLogin = new SignUpPageObj();	
		AnnouncementCreationsPageObj announcementCreationsPageObj=new AnnouncementCreationsPageObj();
		AnnouncementCreationsPage announcementcreationspage=PageFactory.initElements(driver,AnnouncementCreationsPage.class);
		
		//Step 1 : Login as creator
		userLogin.userLogin(CREATOR);
		
		//Step 2 : Navigate to Announcement and verify
		announcementCreationsPageObj.NavigateToAnnouncementDashboard();
		
		//Step 3 : Click on create Announcement
		announcementcreationspage.clickCreateAnnoucement.click();
		
		
		//Step 4 : Fetch fields and assert
		GenericFunctions.FetchFieldsAndAssert(announcementcreationspage.announcementTitle,"TITLE");
		announcementcreationspage.popupCloseIcon.click();
		announcementcreationspage.popupCloseIconYes.click();
		GenericFunctions.refreshWebPage();
		
		//Step 4 : Logout as creator
		userLogin.userLogout();		
		
	}
	
	
	
}
