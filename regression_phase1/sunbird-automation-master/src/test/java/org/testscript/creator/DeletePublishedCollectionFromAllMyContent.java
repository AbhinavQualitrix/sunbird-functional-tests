package org.testscript.creator;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.pageobjects.AllMyContentPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testng.annotations.Test;


public class DeletePublishedCollectionFromAllMyContent extends BaseTest {
	@Test(groups= {"regression2","creator"})
	public void deletePublishedCollectionFromAllMyContent() throws Exception {

		SignUpPageObj creator = new SignUpPageObj();
		creator.userLogin(CREATOR);
		
		// Click on workspace
		//CreatorUserPageObj CreatorUserPageObj = new CreatorUserPageObj();
		AllMyContentPageObj AllMyContentPageObj = new AllMyContentPageObj();
		AllMyContentPageObj.clickWorkspace();
		
		// Click filter icon
		AllMyContentPageObj.allMyContent();
				
		// Delete published COLLECTION
		AllMyContentPageObj.deleteContent("COLLECTION");
		
		// Test case done

	}
}