package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.LessonPlanPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class CreateLessonPlanWith3Resources extends BaseTest {
	
	@Test(groups= {"regression1","creator"})
	public void createLessonPlanWith3Resources() throws Exception {

		// Login as creator
		SignUpPageObj UserLogin = new SignUpPageObj();
		UserLogin.userLogin(CREATOR);

		// Click on workspace
		LessonPlanPageObj LessonPlanPageObj = new LessonPlanPageObj();
		LessonPlanPageObj.clickWorkspace();
		
		// Fill details and click start creating
		LessonPlanPageObj.createLessonPlanpopUp();
		
		// Create lesson Plan with three resources
		LessonPlanPageObj.lessonPlanWithThreeResources();
	}
}