
/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Abhinav kumar singh

* Date: 07/12/2018

* Purpose: Search the organisations and download it and verify it.

*/package org.testscript.skippedfunctionality;


import org.testng.annotations.Test;
import org.generic.GenericFunctions;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorUserPage;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;

public class SearchAndDownloadOrgFile extends BaseTest {
	
	CreatorUserPage createUserPage1=PageFactory.initElements(driver, CreatorUserPage.class);
	String courseName;
	String startDate;
	String endDate;
	String fileName = "Organisations";
	
	
	@Test(groups= {"skippedfunctionality"})
	public void searchAndDownloadOrgFile() throws Exception
	{
		
		//Step1: Login as Creator
		
		SignUpPageObj creatorLogin = new SignUpPageObj();
		creatorLogin.userLogin(ADMIN);

		//Step2: Navigate to profile and search the org and download
		
		CreatorUserPageObj cretorUserPageObj =new CreatorUserPageObj();
		cretorUserPageObj.navigateToProfileAndSearchOrg();
		GenericFunctions.waitWebDriver(1000);
		System.out.println("Download is done");
		
		//Step3: check the download
		
		String downloadPath = "/home/" + System.getProperty("user.name") + "/Downloads/";
		GenericFunctions generics = new GenericFunctions();
		generics.isFileDownloaded_Ext(downloadPath, fileName);
		System.out.println("downloaded file exist");
		
		//Step4: Logout as mentor
		
		GenericFunctions.waitWebDriver(1000);
		creatorLogin.userLogout();
		
		
	}
}
