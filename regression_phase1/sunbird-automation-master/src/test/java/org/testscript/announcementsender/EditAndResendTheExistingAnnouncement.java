package org.testscript.announcementsender;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.AnnouncementPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class EditAndResendTheExistingAnnouncement extends BaseTest{
 @Test(groups= {"creator","regression"})
 public void editAndResendTheExistingAnnouncement() throws Exception
 {//337
      SignUpPageObj orgAdminLogin = new SignUpPageObj();
      
      
      // Step1: Log in as Admin
      //orgAdminLogin.userLogin(ADMIN);
      orgAdminLogin.userLogin(CREATOR);
      
      // Go to announcement Page
      AnnouncementPageObj announcementPageObj = new AnnouncementPageObj();
      announcementPageObj.navigateToAnnouncementInDropDownMenu();
      
      // Step2: Edit and resend the announcement      
      announcementPageObj.editAndResendAnnouncement();
    
 }
}