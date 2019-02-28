package org.testscript.creator;


	import org.testng.annotations.Test;
	import org.testng.annotations.Test;
	import org.testng.annotations.Test;
	import org.testng.annotations.Test;
	import org.testng.annotations.Test;
	import org.testng.annotations.Test;
	import java.util.List;

	import org.generic.GenericFunctions;
	import org.generic.ReadTestDataFromExcel;
	import org.pageobjects.CreateMentorPageObj;
	import org.pageobjects.CreatorUserPageObj;
	import org.pageobjects.SignUpPageObj;
	import org.startup.BaseTest;
	import org.testdata.TestDataForDiksha;
	import org.testng.annotations.Test;

	public class CreateBookAndVerify  extends BaseTest
	{
		
		@Test(invocationCount=1,groups= {"regression","creator","smoke1"})
		public void createBookAndVerify() throws Exception
		{
			List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			CreateMentorPageObj createMentorPageObj = new CreateMentorPageObj();
			CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
			SignUpPageObj creatorLogin = new SignUpPageObj();
			GenericFunctions genericFunctions = new GenericFunctions();
			
			//Step1: Login as Creator
			
			creatorLogin.userLogin(BOOKCREATOR);
			
			//Step2: Navigate to WorkSpace
			
			creatorUserPageObj.navigateToWorkspace(BOOK);
			
			//Step3: Create new book
			creatorUserPageObj.createBook(objListOFTestDataForSunbird);
			
			//Step4: Save and send resource for review
			creatorUserPageObj.saveAndSendBookForReview(objListOFTestDataForSunbird);
			
			GenericFunctions.refreshWebPage();
				
			//Step5: Check for course in review submissions 
			creatorUserPageObj.reviewInSubmissions(BOOK,objListOFTestDataForSunbird);

			//Step6: Logout as Creator
			creatorLogin.userLogout();
			
			//Step7: Login as Reviewer
			creatorLogin.userLogin(BOOKREVIEWER);
			
			//Step8: Search the course which was submitted for review
			creatorUserPageObj.searchInUpForReview(BOOK,objListOFTestDataForSunbird);
			
			//Step 9:publish the resource and search it
			creatorUserPageObj.publishAndSearch(BOOK,objListOFTestDataForSunbird);
			
			//Step 10: Logout as Reviewer
			creatorLogin.userLogout();
			
			//Step11: Login as Public User
			creatorLogin.userLogin(PUBLICUSER1);

			//Step12: Search the course with Name
			createMentorPageObj.navigateToLibraryAndSearchForBook();

			//Step 13: Logout as Reviewer
			creatorLogin.userLogout();	
			
			//Step 14: Login as Creator
			creatorLogin.userLogin(BOOKCREATOR);

			//Step 15:Navigate to Workspace-All my content
			genericFunctions.navigateToWorkspaceFeatures(ALL_MY_CONTENT);
			
			//Step 16: Delete the Created item
			creatorUserPageObj.deleteCreatedItems();

			//Step 17: Logout as Creator
			creatorLogin.userLogout();
			
		}

	}


