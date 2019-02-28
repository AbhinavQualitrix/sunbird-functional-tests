package org.testscript.reviewer;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class ContentValidationInUpForReviewSearchWithFilter extends BaseTest
{
	//92_93_94_96a_b
	@Test(groups= {"reviewer","regression1"})
	public void contentValidationInUpForReviewSearchWithFilter() throws Exception
	{
		SignUpPageObj userLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		ContentCreationResourcePageObj contentReourcePageObj= new ContentCreationResourcePageObj();
		
		//Login as Content creator
		userLogin.userLogin(REVIEWER);

		//Navigate to workspace to create Resource
		creatorUserPageObj.navigateToWorkspace(RESOURCE);
		
		//Click on Up for review and search and verify contents 
		contentReourcePageObj.validateUpForReivew();

		//Click on Up for review verify contents based Applied
		contentReourcePageObj.contentFilterApply_Reset();
		
		//Verify the Resetting of applied filters and the contents
		contentReourcePageObj.resetAppliedFilters();
		
		//Logout as Reviewer
		userLogin.userLogout();
	}

}
