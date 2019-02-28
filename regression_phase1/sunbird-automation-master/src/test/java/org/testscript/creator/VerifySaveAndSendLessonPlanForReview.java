package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.LessonPlanPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifySaveAndSendLessonPlanForReview extends BaseTest {
	@Test(groups={"creator","regression2"})
	public void verifySaveAndSendLessonPlanForReview() throws Exception {

		// Login as Creator
		SignUpPageObj login = new SignUpPageObj();
		login.userLogin(CREATOR);

		// Click on workspace
		 LessonPlanPageObj LessonPlanPageObj = new LessonPlanPageObj();
		 LessonPlanPageObj.clickWorkspace();
		  
		// Fill details and click start creating
		 LessonPlanPageObj.createLessonPlanpopUp();
		
		// Create ChildNode and click on proceed
		 LessonPlanPageObj.createChildNode();
		
		// Save Lesson plan and send for review
		 LessonPlanPageObj.saveLessonPlanAndSendForReview();				
	}    
}