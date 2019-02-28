/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 06/29/2018

* Purpose: create Announcement with attachment and verify it as reviewer.

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
import org.testng.Assert;
import org.testng.annotations.Test;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorAnnouncementPage;
import org.pageobjects.CreatorAnnouncementPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;

public class CreateAnnouncementWithAttachment extends BaseTest {
	String announcementnameReview;
	String announcementName;
	List <TestDataForDiksha> objListOFTestDataForSunbird= null;
	
	@Test( groups={"sanity2", "regression1","announcementsender"})
	public void createAnnouncementWithAttachment() throws Exception
	{
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorAnnouncementPageObj creatorAnnouncementPageObj =new CreatorAnnouncementPageObj();
		CreatorAnnouncementPage createAnnouncementPage = PageFactory.initElements(driver,CreatorAnnouncementPage.class);
		
		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to Announcement Dashboard in Dropdown
		creatorAnnouncementPageObj.navigateToAnnouncementInDropDownMenu();
		
		//Step3:Create Announcement using description & Url and upload attachment
		creatorAnnouncementPageObj.CreateAnnouncementUsingAttachment();
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		String announcementNumber = GenericFunctions.readFromNotepad("./testData/announcementNumbers.txt").toString().toUpperCase();
		announcementName = objListOFTestDataForSunbird.get(7).getCourseName() + announcementNumber;
		
		// Step4: Logout as Creator
		GenericFunctions.refreshWebPage();
		creatorLogin.userLogout();

		/*// Step5: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);
		
		//Step6:check for the announcement with attachment.
		System.out.println("Found announcement-"+announcementName);
		creatorAnnouncementPageObj.checkForAnnouncementWithAttachment(announcementName);
		
		//Step7: view the content
		//createAnnouncementPage.view.click();
		System.out.println("Created Announcement is available with the attachment");
		
		//Step8: logout as Creator
		creatorLogin.userLogout();*/
	}

}
