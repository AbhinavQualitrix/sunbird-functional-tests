package org.testscript.creator;

import org.testng.annotations.Test;
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

public class VerifyTheBookAvailableForReview extends BaseTest
{
	@Test(groups={"creator","sanity1","regression2"})
	public void verifyTheBookAvailableForReview() throws Exception
	{	
		/*Creator_TC02 creatorTestcase2 = new Creator_TC02();
		creatorTestcase2.testCase02();	*/	
		List <TestDataForDiksha> objListOFTestDataForDiksha= null ;
		objListOFTestDataForDiksha = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Login as Creator	
		signupObj.userLogin(BOOKCREATOR);

		//Go to workspace , create a book,submit for reviewer
		creatorUserPageObj.navigateToWorkspace(BOOK);

		//Navigate to workspace and Create new Book
		creatorUserPageObj.createBook(objListOFTestDataForDiksha);

		//Save and Send for Review
		creatorUserPageObj.saveAndSendBookForReview(objListOFTestDataForDiksha);
		
		//Logout as content Creator
		signupObj.userLogout();
		
		//Login as Book reviewer
		signupObj.userLogin(BOOKREVIEWER);
		
		//Verify only books are there for reviewing
		creatorUserPageObj.verifyOnlyBooksPresent();
		
		//Logout as Book reviewer
		signupObj.userLogout();
		
		//Step 8: Login as Creator
		signupObj.userLogin(BOOKCREATOR);

		//Step 9: Navigate to WorkSpace
		creatorUserPageObj.navigateToWorkspace(PUBLISHED);

		//Step 10: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step 11: Logout as Creator
		signupObj.userLogout();
	}

}
