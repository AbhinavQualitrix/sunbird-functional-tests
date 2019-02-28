package org.testscript.creator;


import org.testng.annotations.Test;
import org.pageobjects.ExplorePageobj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyAvailabilityOfLibraryAndCourseAsAnonymousUser extends BaseTest{
	
	@Test(groups= {"regression"})
	public void verifyAvailabilityOfLibraryAndCourseAsAnonymousUser() throws Exception {
		
		
		ExplorePageobj explorePageObj = new ExplorePageobj();
		SignUpPageObj signupObj = new SignUpPageObj();
		
		//Step 1:Login As Anonymous User
		signupObj.userLogin(PUBLICUSER2);
		
		//Step 2:Verify library and course
		explorePageObj.verifyAvailabilityOfLibraryAndCourse();
		
		//Step 3:Logout As Anonymous User
		signupObj.userLogout();

		
	}

}
