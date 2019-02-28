/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 06/20/2018
* Purpose: Create a New Collection and validate it
*/

package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.generic.GenericFunctions;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class CollectionCreation extends BaseTest
{
	@Test(groups={"creator","sanity", "regression1"})
	public void collectionCreation() throws Exception
	{
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		GenericFunctions genereicFunctions = new GenericFunctions();
		
		//Step1:Login as content creator
		signupObj.userLogin(CREATOR);
		
		//Step2:Navigate to workspace and create a Collection 
		//And send the Collection for review
		creatorUserPageObj.createCollection();
		//creatorUserPageObj.createCollection();
		
		//Step3:Logout as Creator 
		signupObj.userLogout();
		
		//Step4:Login as Reviewer
		signupObj.userLogin(REVIEWER);
		
		//Step5:Go to workspace and publish the content-h5p
		creatorUserPageObj.goToWorkspace("collection");
		
		//Step6:Reject the Collection
		creatorUserPageObj.rejectTheContent(COLLECTION);
		
		//StepLogout as Reviewer
		signupObj.userLogout();
		
		//Step7: Login as Creator
		signupObj.userLogin(CREATOR);
		
		//Step8: Navigate to WorkSpace-All my content
		genereicFunctions.navigateToWorkspaceFeatures(ALL_MY_CONTENT);

		//Step9: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step10: Logout as Creator
		signupObj.userLogout();
	}

}
