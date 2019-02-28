package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import java.util.List;

import org.generic.ReadTestDataFromExcel;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.QuestionSetPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

public class AllQuestionSetPlugins extends BaseTest 
{
  @Test(groups= {"creator","sanity", "regression1"})
  public void questionSetPlugin() throws Exception {
	  
	  List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
	  objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
	  
	  // Login as creator
	  SignUpPageObj creatorLogin = new SignUpPageObj();
	  creatorLogin.userLogin(CREATOR);
	  
	  // Navigate to workspace and select resource under create section
	  CreatorUserPageObj CreatorUserPageObj = new CreatorUserPageObj();
	  CreatorUserPageObj.navigateToWorkspace(RESOURCE);
	  
	  // Select different questions
	  QuestionSetPageObj questionsetpage = new QuestionSetPageObj();
	  questionsetpage.createresource(objListOFTestDataForSunbird);
	 
	  
  }
}
