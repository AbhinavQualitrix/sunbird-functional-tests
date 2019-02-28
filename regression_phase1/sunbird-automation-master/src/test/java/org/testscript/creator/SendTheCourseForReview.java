package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class SendTheCourseForReview extends BaseTest
{
	//MT done
	@Test(groups={"creator","sanity2","regression2"})
	public void sendTheCourseForReview() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		 
		//Step 1 :Login as content creator
		signupObj.userLogin(CREATOR);
		
		
		//Navigate 
		creatorUserPageObj.navigateToWorkspace(COURSE);
		
		//Doubt here
		//Step 2 :create a Course
		creatorUserPageObj.createCourse(objListOFTestDataForSunbird);
		
		//Step 3:Submit the course for review 
		creatorUserPageObj.saveAndSendnewCourseForReview(objListOFTestDataForSunbird);
		
		//Step 4 :Logout as Content Creator
		signupObj.userLogout();
	}

}
