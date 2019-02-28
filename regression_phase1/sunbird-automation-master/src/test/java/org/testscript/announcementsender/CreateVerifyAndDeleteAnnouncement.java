/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 06/26/2018

* Purpose: Create Announcement as Creator ,verify as Receiver,delete the announcement as creator and verify at receiver end also.

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

import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorAnnouncementPage;
import org.pageobjects.CreatorAnnouncementPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateVerifyAndDeleteAnnouncement extends BaseTest {
	String announcementnameReview;
	String announcementName;
	String announcementnameReview1;
	String announcementName1;
	List <TestDataForDiksha> objListOFTestDataForSunbird= null;
	boolean checkForDeleteButton=true;
	
	@Test( groups={"sanity2", "regression1","announcementsender"})
	public void createVerifyAndDeleteAnnouncement() throws Exception
	{
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorAnnouncementPageObj creatorAnnouncementPageObj =new CreatorAnnouncementPageObj();
		
		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to Announcement Dashboard in Dropdown
		creatorAnnouncementPageObj.navigateToAnnouncementInDropDownMenu();
		
		//Step3:Create Announcement using description
		creatorAnnouncementPageObj.CreateAnnouncement();
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		String announcementNumber = GenericFunctions.readFromNotepad("./testData/announcementNumbers.txt").toString().toUpperCase();
		announcementName = objListOFTestDataForSunbird.get(7).getCourseName() + announcementNumber;
		
		// Step4: Logout as Creator
		GenericFunctions.refreshWebPage();
		creatorLogin.userLogout();
		
		

		/*// Step5: Login as Reciever				
		creatorLogin.userLogin(REVIEWER);
		
		
		System.out.println("Testing here -"+announcementName);
		//Step6:check for the announcement
		creatorAnnouncementPageObj.checkForAnnouncement(announcementName);
		
		// Step7: Logout as Reciever
		creatorLogin.userLogout();
		
		//Step8: Login as Creator
		creatorLogin.userLogin(CREATOR);
		
		//Step9: Navigate to Announcement Dashboard in Dropdown
		creatorAnnouncementPageObj.navigateToAnnouncementInDropDownMenu();
	
		//Step10: click on Delete on particular Announcement	
		creatorAnnouncementPageObj.deleteAnnouncement();
		
		// Step11: Logout as Creator
		creatorLogin.userLogout();
		
		// Step12: Login as Reciever
		creatorLogin.userLogin(REVIEWER);

		// step13: check that the same announcement deleted from their account also
		creatorAnnouncementPageObj.checkDeletedAnnouncement(announcementName1);
		
		// Step14: Logout as Creator
		creatorLogin.userLogout();*/
	}

}
