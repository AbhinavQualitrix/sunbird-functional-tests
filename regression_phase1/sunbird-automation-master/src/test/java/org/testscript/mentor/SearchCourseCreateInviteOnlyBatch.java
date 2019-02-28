/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/24/2018

* Purpose: Login as Mentor ,Search a course and try to create an invite only batch for it.

*/

package org.testscript.mentor;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class SearchCourseCreateInviteOnlyBatch extends BaseTest
{
	@Test(groups={"mentor","smoke2","regression1","sanity2"})
	public void searchCourseCreateInviteOnlyBatch() throws Exception
	{
		
		SignUpPageObj userLogin = new SignUpPageObj();
		CreateMentorPageObj createMentorPageObj=new CreateMentorPageObj();
		
		//Step1: Login as Mentor
		userLogin.userLogin(MENTOR);
		
		
		//Step2:Search the course and create invite only batch
		createMentorPageObj.createInviteOnlyBatch();
		
		//Step3:Logout as Mentor
		userLogin.userLogout();
		
		//Step4:Login as Invited Member
		userLogin.userLogin(PUBLICUSER1);


		//Step5:Consume  the course for which you are invited
		createMentorPageObj.navigateToCourseAndSearch("content");
		
		//Step6:Logout as Invited Member
		userLogin.userLogout();
	}
	
}
				