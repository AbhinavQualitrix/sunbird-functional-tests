/**

 * Created by Qualitrix Technologies Pvt Ltd.

 * @author: Abhinav kumar singh

 * Date: 07/12/2018

 * Purpose: Check for sub org member can't add org member while creating a invite only batch.

 */
package org.testscript.mentor;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;
import org.apache.log4j.Logger;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.support.PageFactory;
import org.page.CreateMentorPage;
import org.page.CreatorAnnouncementPage;
import org.page.CreatorUserPage;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class CheckSuborgMentorInvitingOrgMember extends BaseTest 
{
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	List <TestDataForDiksha> objListOFTestDataForSunbird= null;
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	static Logger log = Logger.getLogger(CreatorAnnouncementPage.class.getName());

	@Test(groups={"mentor","regression1","sanity"})
	public void suborgMentorInvitingOrgMember() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		CreateMentorPageObj createMentorPageObj=new CreateMentorPageObj();
		
		//Step1: Login as Mentor
		userLogin.userLogin(MENTOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(COURSE);
		
		//Step3: Create new Course
		creatorUserPageObj.createCourse(objListOFTestDataForSunbird);
		
		//Step4: Save and Send for Review
		creatorUserPageObj.saveAndSendnewCourseForReview(objListOFTestDataForSunbird);
		GenericFunctions.refreshWebPage();
	
		//Step5: Check for course in review submissions 
		creatorUserPageObj.reviewInSubmissions(COURSE,objListOFTestDataForSunbird);

		//Step6: Logout as Mentor
		userLogin.userLogout();
		
		//Step7: Login as Reviewer
		userLogin.userLogin(REVIEWER);
		
		//Step8: Search the course which was submitted for review
		creatorUserPageObj.searchInUpForReview(COURSE,objListOFTestDataForSunbird);
		
		//Step9:Publish the Course
		creatorUserPageObj.publishAndSearch(COURSE,objListOFTestDataForSunbird);
		
		//Step10: Logout as Reviewer		
		userLogin.userLogout();	
		
		//Step11:Login as Mentor
		userLogin.userLogin(MENTOR);
		
		//Step12: Navigate to course and search the course created by other user.
		createMentorPageObj.createInviteOnlyBatchForSuborg();
		
		//Step13: Logout as mentor
		userLogin.userLogout();
		
		//Step14: Login as Creator
		userLogin.userLogin(MENTOR);

		//Step15: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step16: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step17: Logout as Creator
		userLogin.userLogout();

	}
}