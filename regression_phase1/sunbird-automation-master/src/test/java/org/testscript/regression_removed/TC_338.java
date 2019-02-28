package org.testscript.regression_removed;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.AnnouncementPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class TC_338 extends BaseTest{
 @Test(groups="regressionP2")
 public void TC_338_announcement_feature() throws Exception
 {//338 same as 337
      SignUpPageObj orgAdminLogin = new SignUpPageObj();
      
      
      // Step1: Log in as Admin
      orgAdminLogin.userLogin(ADMIN);
      
      // Go to announcement Page
      AnnouncementPageObj announcementPageObj = new AnnouncementPageObj();
      announcementPageObj.navigateToAnnouncementInDropDownMenu();
      
      // Step2: Edit and resend the announcement      
      announcementPageObj.editAndResendAnnouncement();    
      
      // Test Case done
    
 }
}