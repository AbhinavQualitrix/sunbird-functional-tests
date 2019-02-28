package org.testscript.creator;

import java.util.List;

import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.BookEditorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;


public class VerifyOwnershipTypeCreatedForInBook extends BaseTest{
	
	@Test(groups= {"regression1"})
	public void verifyOwnershipTypeCreatedForInBook() throws Exception{
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		BookEditorPageObj bookEditorPageObj = new BookEditorPageObj();
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		
		
		//Step 1:Login as Creator
		signupObj.userLogin(CREATOR);

		//Step 2:Navigate to workspace to Create a book
		creatorUserPageObj.navigateToWorkspace(BOOK);
		
		//Step 3:create new book
		creatorUserPageObj.createNewBook(objListOFTestDataForSunbird);
		
		//Step 4:add credit and ownershiptype in editform 
		bookEditorPageObj.editAndSaveBookForCreatedFor();
		
		//Step 4:add credit and ownershiptype in editform 
		bookEditorPageObj.verifyOwnerInEditSection();
		
		//Step 5:Logout as Creator
		signupObj.userLogout();
		
		
		
	}

}
