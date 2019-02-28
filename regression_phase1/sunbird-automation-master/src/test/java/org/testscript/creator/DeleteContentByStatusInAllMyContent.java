package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.AllMyContentPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;


public class DeleteContentByStatusInAllMyContent extends BaseTest {
	@Test(groups= {"regression2","creator"})
	public void deleteByStatusInAllMyContent() throws Exception {
		
		// Login as Creator
		SignUpPageObj creator = new SignUpPageObj();
		creator.userLogin(CREATOR);
		
		// Click on workspace
		//CreatorUserPageObj CreatorUserPageObj = new CreatorUserPageObj();
		AllMyContentPageObj AllMyContentPageObj = new AllMyContentPageObj();
		AllMyContentPageObj.clickWorkspace();
		
		// Click on AllMyContent
		AllMyContentPageObj.clickAllMyContent();
		
		// Select DRAFT, delete and search		
		AllMyContentPageObj.deleteByStatus("DRAFT");
		
		// Select FLAGDRAFT, delete and search
		AllMyContentPageObj.deleteByStatus("FLAGDRAFT");
		
		// Select REVIEW, delete and search
		AllMyContentPageObj.deleteByStatus("REVIEW");
		
		// Select PROCESSING, delete and search
		AllMyContentPageObj.deleteByStatus("PROCESSING");
		
		// Select UNLISTED, delete and search
		AllMyContentPageObj.deleteByStatus("UNLISTED");
		
		// Select FLAGREVIEW, delete and search
		AllMyContentPageObj.deleteByStatus("FLAGREVIEW");
		
		// Select FLAGREVIEW, delete and search
		AllMyContentPageObj.deleteByStatus("LIVE");
		
		
	
		
	}

}