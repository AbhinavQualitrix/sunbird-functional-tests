package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyPropertySectionAndPreviewSlides extends BaseTest
{
	@Test(groups={"creator","regression2"})
	public void verifyPropertySectionAndPreviewSlides() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		ContentCreationResourcePageObj contentReourcePageObj= new ContentCreationResourcePageObj();
		
		//Login as Content creator
		userLogin.userLogin(CREATOR);

		//Navigate to workspace to create Resource
		creatorUserPageObj.navigateToWorkspace(RESOURCE);
		
		//Enter a unique resource name
		contentReourcePageObj.resourceName();
		
		//Add text or images
		contentReourcePageObj.addSlides_Image_Text(2,119);
		
		//Add 10 slides and preview all from the beginning
		contentReourcePageObj.previewSlides_AndFromBegining();
	
		//ContentCreationResourcePage.clickAUdio("Telugu");
		
		//Logout as Content Creator
		userLogin.userLogout();
	}
}
