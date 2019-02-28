/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Ajith Manjunath
 * Date: 06/27/2018
 * Purpose: Dial code unlinking to book unit
 */

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
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class UnlinkDailcode extends BaseTest
{
	//MT done
	@Test( groups={"creator","sanity2","regression2"})//priority=18,
	public void unlinkDailcode() throws Exception
	{
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		GenericFunctions genereicFunctions = new GenericFunctions();
		
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();

		//Step 1:Login as Creator
		signupObj.userLogin(BOOKCREATOR);

		//Step 2:Navigate to workspace to Create a book
		creatorUserPageObj.navigateToWorkspace(BOOK);

		//Step 3,4,5 and 6:Create a Book
		creatorUserPageObj.createBook(objListOFTestDataForSunbird);

		//Step 7,8 and 9:Save the book and the message
		creatorUserPageObj.removeDailCodeAndCheckMessage();

		//Logout as Creator
		signupObj.userLogout();

		/*//Step10: Login as Creator
		signupObj.userLogin(BOOKCREATOR);

		//Step11: Navigate to WorkSpace-All my content
		genereicFunctions.navigateToWorkspaceFeatures(ALL_MY_CONTENT);

		//Step12: Delete the Created item
		creatorUserPageObj.deleteCreatedItems();

		//Step13: Logout as Creator
		signupObj.userLogout();*/

	}

}
