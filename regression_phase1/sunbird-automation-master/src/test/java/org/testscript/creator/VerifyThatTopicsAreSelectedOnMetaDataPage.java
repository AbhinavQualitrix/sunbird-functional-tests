/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Richa Prakash
* Date: 27/09/2018
* Purpose:  verify user is able to select the subtopic from the listed topic.
*/

package org.testscript.creator;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.TopicTreePageObject;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class VerifyThatTopicsAreSelectedOnMetaDataPage extends BaseTest {
	
	@Test(groups={"creator","regression2"})	
	public void verifyThatTopicsAreSelectedOnMetaDataPage() throws Exception{
	{
		
		    SignUpPageObj signupobj = new SignUpPageObj();
			CreatorUserPageObj createuserpageobj = new CreatorUserPageObj();
			TopicTreePageObject topicslist =new TopicTreePageObject();
			List <TestDataForDiksha> objListOFTestDataForSunbird=null;
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			
			
			//Steps no.:Login as a creator
			signupobj.userLogin(CREATOR);
			
			//Steps no 2.: Navigate to worksapce
			createuserpageobj.navigateToWorkspace(BOOK);
			
			//Step no 3:Navigate to book and click on the topic
			topicslist.createBook(objListOFTestDataForSunbird);
			
			//Step no.Select topic list
			topicslist.selectTopic(objListOFTestDataForSunbird);;
					
			//Step no.4:Search For topic
			topicslist.searchForTopic(objListOFTestDataForSunbird);
			
			//Step no.5:Search the topic and click on done
			topicslist.searchForTopicClickOnDoneButton(objListOFTestDataForSunbird);
			
			/*//Steps no.6:Logout as a creator
			signupobj.userLogout();*/
			







	}
	}
}
