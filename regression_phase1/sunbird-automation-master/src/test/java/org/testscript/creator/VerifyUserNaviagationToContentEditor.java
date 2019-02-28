package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.pageobjects.ContentCreationLessonPlanPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class VerifyUserNaviagationToContentEditor extends BaseTest
{
	//Maintenance - taken up
	//TC219 - Nov 13th
	@Test(groups={"creator","regression2"})
	public void verifyUserNavigateToContentEditorPage() throws Exception
	{
		List<TestDataForDiksha> objListOFTestDataForSunbird = null;
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj createUserPageObj = new CreatorUserPageObj();
		ContentCreationLessonPlanPageObj lessonPlanObj = new ContentCreationLessonPlanPageObj();
		
		
		//1.Login as a Content Creator
		userLogin.userLogin(CREATOR);
		
		//2.Click on profile 
		//3.Click on workspace and click on Create Book option
		//4.Click on cancel icon create Book page.
		
		//2.Navigate to workspace and click on Create Book
		createUserPageObj.navigateToWorkspace(BOOK);
		
		//Create Book by filling Valid Name and Verify Content Editor
		lessonPlanObj.verifyCreateBookPopup();
		
		
		
		//Logout as Content Creator
		userLogin.userLogout();
		
	}

}
