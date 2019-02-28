/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 09/18/2018

* Purpose: Delete the created items from drafts and published.

*/
package org.testscript.creator;

import org.testng.annotations.Test;
import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class DeleteTheCreatedContent extends BaseTest {
	
	@Test(groups={"creator","regression"})
	public void deleteTheCreatedContent() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		SignUpPageObj creatorLogin = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Step1: Login as Creator
		creatorLogin.userLogin(CREATOR);
		
		//Step2: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);
		
		//Step3: Delete the published items.
		creatorUserPageObj.deleteCreatedItems();
		
		//Step4: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(DRAFTS);
			
		//Step5: Delete the draft items.
		creatorUserPageObj.deleteCreatedItems();
		
		//Step6: Logout as Creator
		creatorLogin.userLogout();
	}
	
}