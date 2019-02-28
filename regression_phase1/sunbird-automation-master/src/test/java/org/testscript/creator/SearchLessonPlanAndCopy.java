package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.LessonPlanPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class SearchLessonPlanAndCopy extends BaseTest {

	@Test(groups= {"regression2","creator"})
	public void searchLessonPlanAndCopy() throws Exception {

		
		// Step 1: Login with valid creator creden0tial
		SignUpPageObj UserLogin = new SignUpPageObj();
		UserLogin.userLogin(CREATOR);

		// Step 2: 
		LessonPlanPageObj LessonPlanPageObj = new LessonPlanPageObj();
		LessonPlanPageObj.searchInLibrary();
		

	}
}
