package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.LessonPlanPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class AddChildNodesToLessonPlan extends BaseTest {

	@Test(groups={"regression1","creator"})
	public void addChildNodesToLessonPlan() throws Exception {

		// Login as creator
		SignUpPageObj UserLogin = new SignUpPageObj();
		UserLogin.userLogin(CREATOR);

		// Click on workspace
		LessonPlanPageObj LessonPlanPageObj = new LessonPlanPageObj();
		LessonPlanPageObj.clickWorkspace();
		
		// Fill details and click start creating
		LessonPlanPageObj.createLessonPlanpopUp();
		
		// Create three child nodes
		LessonPlanPageObj.createChildNodes();						  
	}
}