/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * @author: Ajith Manjunath
 * Date: 05/16/2018
 * Purpose: Admin dashboard - consumption and CSV download
 */

package org.testscript.skippedfunctionality;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.SignUpPageObj;
import org.pageobjects.UploadOrgObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class AdminConsumptionAndDownloadCsv extends BaseTest 
{
	@Test(groups={"skippedfunctionality"})
	public void adminConsumptionAndDownloadCsv() throws Exception
	{
		SignUpPageObj adminLogin = new SignUpPageObj();
		UploadOrgObj adminUpload= new UploadOrgObj();

		//Step1: Login as Admin
		adminLogin.userLogin(ADMIN);

		//Step 2,3,4 and 5: Click on admin dashboard.
		//Apply filter, check stats 
		//Download the CSV
		adminUpload.adminCreationConsumption(FILTER_CONSUMPTION);

		//Logout as Admin
		adminLogin.userLogout();
	}


}
