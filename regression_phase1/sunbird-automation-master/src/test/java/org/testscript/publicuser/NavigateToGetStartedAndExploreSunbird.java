package org.testscript.publicuser;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.page.GetPage;
import org.pageobjects.GetPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class NavigateToGetStartedAndExploreSunbird extends BaseTest 
{
	//Maintenance Done - 9th Nov
	@Test(groups= {"publicuser","regression1"})
	public void verify_NavigateToGetStarted_ExploreSunbirdPage() throws Exception
	{			
		//Verify that the user is able to navigate to the explore page
		GetPageObj getPageObj = new GetPageObj(); 
		getPageObj.verifyGetStartedPageExploreDiksha();

		//Verify that the user should able to get the respected search result
		getPageObj.verifyContentSearchInExploreDiksha();

		//Verify that the the placeholder of all the fields on explore page are displaying according to the selected language
		getPageObj.verifyLanguageChangeInExploreDiksha();

		//Verify that the user is able to get the content associated with the DIAL code 
		//Verify that the user is able to play the content in explore page
		getPageObj.verifyDialCodeContentInExploreDiksha();

		//Verify that the user is able to navigate to the login page
		getPageObj.verifyLoginNavigationFromExploreDiksha();

		//Verify that No filters are selected when user navigate to the explore page
		//Verify that the contents displayed according to the selected parameter in filter section - Board/Apply/Reset 
		GetPage getPage = PageFactory.initElements(driver, GetPage.class);
		
		getPageObj.verifyContentParameterDisplay(getPage.iBoard,getPage.xSelectBoard);

		//Verify that the contents displayed according to the selected parameter in filter section - Medium/Apply/Reset 		
		getPageObj.verifyContentParameterDisplay(getPage.iMedium, getPage.xSelectMedium);

		//Verify that the contents displayed according to the selected parameter in filter section - Subject/Apply/Reset 
		getPageObj.verifyContentParameterDisplay(getPage.iSubject, getPage.xSelectSubject);
		
		//Verify that the contents displayed according to the selected parameter in filter section - Class/Apply/Reset 		
		getPageObj.verifyContentParameterDisplay(getPage.iClass, getPage.xSelectClass);


	}
}