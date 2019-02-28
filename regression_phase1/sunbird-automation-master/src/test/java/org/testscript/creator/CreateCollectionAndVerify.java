package org.testscript.creator;


import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreateMentorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class CreateCollectionAndVerify  extends BaseTest {

	@Test(groups= {"sanity", "regression","smoke","creator"})
	public void createCollectionAndVerify() throws Exception
	{
		
		CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
		
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		GenericFunctions genericFunctions = new GenericFunctions();
		
		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);

		//Step2: Navigate to WorkSpace,create new Collection,save and send for review.
		creatorUserPageObj.createCollection();
		GenericFunctions.refreshWebPage();

		//Step6: Logout as Creator
		creatorLogin.userLogout();
		
		//Step7: Login as Reviewer
		creatorLogin.userLogin(REVIEWER);

		//Step8: Search the course which was submitted for review
		creatorUserPageObj.goToWorkspace("collection");
		
		//Step 10: Logout as Reviewer
		creatorLogin.userLogout();		

		//Step11: Login as Public User
		creatorLogin.userLogin(PUBLICUSER1);

		//Step12: Search the course with Name
		createMentorPageObj.navigateToLibraryAndSearchForCollection();

		//Step 13: Logout as Reviewer
		creatorLogin.userLogout();	
		
		//Step 14: Login as Creator
		creatorLogin.userLogin(CREATOR);

		//Step 15:Navigate to Workspace-All my content
		genericFunctions.navigateToWorkspaceFeatures(ALL_MY_CONTENT);
		
		//Step 16: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step 17: Logout as Creator
		creatorLogin.userLogout();

	}

}


