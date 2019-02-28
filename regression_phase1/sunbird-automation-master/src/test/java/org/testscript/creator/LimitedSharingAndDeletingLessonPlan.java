package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.LessonPlanPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class LimitedSharingAndDeletingLessonPlan extends BaseTest {
	@Test(groups= {"regression2","creator"})
	public void limitedSharingAndDeletingLessonPlan() throws Exception {

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
		
		// Send for Limited Publishing and delete
		  LessonPlanPageObj.limitedPublishing();
	
	}    
}