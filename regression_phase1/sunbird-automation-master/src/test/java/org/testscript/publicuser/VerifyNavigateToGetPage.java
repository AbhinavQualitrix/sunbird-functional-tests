package org.testscript.publicuser;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.pageobjects.GetPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifyNavigateToGetPage extends BaseTest
{
	//Maintenance Done- 09th nov
	@Test(groups= {"publicuser","regression"})
	public void verify_NavigateToGetPage() throws Exception
	{	
		//Opening the URL
		/*String getPageURL = driver.getCurrentUrl();
		driver.get(getPageURL+"/get");*/
		
		//Verify the components on GetPage
		GetPageObj getPageObj = PageFactory.initElements(driver, GetPageObj.class);
		getPageObj.verifyGetPageComponents();
		
		//Verify DIAL Code on GetPage
		getPageObj.verifyGetPageDialCode();
		
		//Verify Google Play store navigation
		getPageObj.verifyGetPageGooglePlayStoreNavigation();
		
		//Verify clicking on Login button is leading to Login screen
		getPageObj.verifyGetPageLoginScreenNavigation();
		
		//Verify on wrong dial code message
		getPageObj.verifyGetPageDialCodeComingSoon();
		
		//Verify dial code search again in get page
		getPageObj.verifyGetPageDialCodeSearchResults();
		
		
	}


}
