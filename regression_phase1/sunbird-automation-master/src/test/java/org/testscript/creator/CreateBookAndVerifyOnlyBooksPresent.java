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

public class CreateBookAndVerifyOnlyBooksPresent extends BaseTest
{
	@Test(groups= {"sanity1", "regression1","creator"})
	public void createBookAndVerifyOnlyBooksPresent() throws Exception
	{	
		//MT Done
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		
		//Login as Creator	
		signupObj.userLogin(BOOKCREATOR);

		//Go to workspace , create a book,submit for reviewer
		creatorUserPageObj.navigateToWorkspace(BOOK);

		//Navigate to workspace and Create new Book
		creatorUserPageObj.createBook(objListOFTestDataForSunbird);

		//Save and Send for Review
		creatorUserPageObj.saveAndSendBookForReview(objListOFTestDataForSunbird);
		
		//Logout as content Creator
		signupObj.userLogout();
		
		//Login as Book reviewer
		signupObj.userLogin(BOOKREVIEWER);
		
		//Verify only books are there for reviewing
		creatorUserPageObj.verifyOnlyBooksPresent();
		
		signupObj.userLogout();}

}
