/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/25/2018
* Purpose: Content Limited Sharing
*/

package org.testscript.creator;

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

public class LimitedSharingTheContent extends BaseTest
{
	@Test(groups={"creator","regression2","sanity2"})//priority=14, 
	public void limitedSharingTheContent() throws Exception
	{
		//MT done
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step 1:Login as Content creator
		signupObj.userLogin(CREATOR);
			
		//Step 2:Navigate to workspace and create all the content types
		creatorUserPageObj.navigateToWorkspace(BOOK);
		
		//Step 3a:Create content type -BOOK
		creatorUserPageObj.createBook(objListOFTestDataForSunbird);
		
		//Step 3a:Send BOOK for Limited Sharing
		creatorUserPageObj.limitedSharing("Book");
		
		//Step 3a:Logout as book creator
		signupObj.userLogout();
		
		//Step 3b:Login as content creator
		signupObj.userLogin(CREATOR);
		
		//Step 3b:Navigate to workspace to Create a course 
		creatorUserPageObj.navigateToWorkspace(COURSE);
		
		//Step 3b:create content type-COURSE
		creatorUserPageObj.createCourse(objListOFTestDataForSunbird);
		
		//Step 3b:Send COURSE for Limited Sharing
		creatorUserPageObj.limitedSharing("course");
		
					
		//Step 3c:Navigate to workspace to Create a LESSON PLAN
		creatorUserPageObj.navigateToWorkspace(LESSONPLAN);
		
		//Step 3c:Create content type-Lesson plan
		creatorUserPageObj.createLessonPlan();
		
		//Step 3c:Send the LESSON PLAN for Limited sharing
		creatorUserPageObj.limitedSharing("lesson plan");
		
		
		//Step 3d:Navigate to workspace to create a Resource
		creatorUserPageObj.navigateToWorkspace(RESOURCE);
		
		//Step 3d:Create content type-Resource
		//creatorUserPageObj.createResource(objListOFTestDataForSunbird);
		creatorUserPageObj.resourceName();
		
		/*//Step 3e: Add Audio for the resource.
		creatorUserPageObj.addAudio();*/
		
		//creatorUserPageObj.saveAndSendResouceForReview();
		//creatorUserPageObj.sendResourceForReview();
		
		//Step 3f:Send the RESOURCE for Limited sharing
		creatorUserPageObj.limitedSharing("resource");
		
		
		//Step 3g:Navigate to workspace to Upload Content-
		creatorUserPageObj.navigateToWorkspace(UPLOADCONTENT);
		
		//Step 3g:Create content type-EPUB
		creatorUserPageObj.uploadContentLimitedSharing(EPUB);
		
		//Step 3g:Send the EPUB content for Limited sharing
		creatorUserPageObj.limitedSharing("upload");
		
		//Creator Logout
		signupObj.userLogout();
		
	}

}
