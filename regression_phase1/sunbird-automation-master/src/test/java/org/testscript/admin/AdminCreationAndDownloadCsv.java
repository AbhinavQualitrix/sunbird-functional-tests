/**
* Created by Qualitrix Technologies Pvt Ltd.
* @author: Ajith Manjunath
* Date: 05/15/2018
* Purpose: Admin dashboard - creation and CSV download
*/

package org.testscript.admin;

import org.testng.annotations.Test;

import org.pageobjects.SignUpPageObj;
import org.pageobjects.UploadOrgObj;

import org.startup.BaseTest;


@Test(groups={"sanity1","regression1","admin"})//priority=7, 
public class AdminCreationAndDownloadCsv extends BaseTest
{
	 //, invocationCount=1  , "regression","Admin group"
	public void adminCreationAndDownloadCsv() throws Exception
	{	
		
		UploadOrgObj adminUpload= new UploadOrgObj();
		SignUpPageObj adminLogin = new SignUpPageObj();
		
		//Step1: Login as Admin
		adminLogin.userLogin(ADMIN);
		

		//Step 2,3,4 and 5: Click on admin dashboard.
		//Apply filter, check stats 
		//Download the CSV
		//adminUpload.adminCreationConsumption(FILTER_CREATION);
		adminUpload.adminCreationConsumption(FILTER_CREATION);
		
		//Logout as Admin
		adminLogin.userLogout();
	}
	


}
