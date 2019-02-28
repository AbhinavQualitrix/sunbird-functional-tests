package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorUserPage;
import org.pageobjects.AllMyContentPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;

public class VerifySortByInAllMyContentForCreator extends BaseTest {
CreatorUserPage createUserPage= PageFactory.initElements(driver, CreatorUserPage.class);
  @Test(groups={"creator","regression2"})
  public void verifyAllMyContentSortByForCreator() throws Exception {
	  
	  SignUpPageObj creator = new SignUpPageObj();
	  creator.userLogin(CREATOR);
	  
		// Click on workspace
	  AllMyContentPageObj AllMyContentPageObj = new AllMyContentPageObj();
	  AllMyContentPageObj.clickWorkspace();
			
		// Click on allMyContent and select sortBy dropdown options
	  AllMyContentPageObj.allMyContentSortByDropdown();
  
  }
}
