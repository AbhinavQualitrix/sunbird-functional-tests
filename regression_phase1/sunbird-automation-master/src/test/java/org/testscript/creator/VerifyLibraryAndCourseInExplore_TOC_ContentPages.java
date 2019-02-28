package org.testscript.creator;


import org.testng.annotations.Test;
import org.pageobjects.ExplorePageobj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyLibraryAndCourseInExplore_TOC_ContentPages extends BaseTest{
	

	@Test(groups= {"regression"})
	public void verifyLibraryAndCourseInExplore_TOC_ContentPages() throws Exception {

		ExplorePageobj explorePageObj = new ExplorePageobj();
		
		
		//Step 1:Open the application ,navigate to explore page
		explorePageObj.navigateToExplorePage();
		
		//Step 2:Verify Availability library and course
		explorePageObj.verifyAvailabilityOfLibraryAndCourse();
		
		//Step 3:Open the application ,navigate to TOC page
		explorePageObj.navigateToTOCPage();

		//Step 4:Verify Availability library and course
		explorePageObj.verifyAvailabilityOfLibraryAndCourse();
		
		//Step 5:Open the application ,navigate to Content display page
		explorePageObj.navigateToContentDisplayPage();

		//Step 6:Verify Availability library and course
		explorePageObj.verifyAvailabilityOfLibraryAndCourse();
	}

}
