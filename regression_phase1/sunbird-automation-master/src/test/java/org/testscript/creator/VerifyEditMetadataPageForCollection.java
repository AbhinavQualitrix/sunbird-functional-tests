package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.pageobjects.ContentCreationResourcePageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyEditMetadataPageForCollection extends BaseTest
{
	//Files yet to update from Richa
	//TC163
	@Test(groups= {"regression2","creator"})
	public void workspaceCollection_verifyEditDetailsPage() throws Exception
	{
	SignUpPageObj creatorLogin = new SignUpPageObj();
	CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
	ContentCreationResourcePageObj contentReourcePageObj= new ContentCreationResourcePageObj();
	
	
	//Step1: Login as Creator
	creatorLogin.userLogin(CREATOR);
	
	//Step2: Navigate to WorkSpace
	creatorUserPageObj.navigateToWorkspace(COLLECTION);
	
	//Step3: Create new Collection
	 List<String> metapageDetails = contentReourcePageObj.createNewCollection();
	 
	}

}
