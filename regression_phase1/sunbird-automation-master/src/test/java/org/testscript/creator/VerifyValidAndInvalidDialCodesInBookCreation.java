package org.testscript.creator;

import java.util.List;

import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.pageobjects.BookEditorPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.pageobjects.SignUpPageObj;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

public class VerifyValidAndInvalidDialCodesInBookCreation extends BaseTest{
	
	@Test(groups= {"regression1"})
	public void verifyValidAndInvalidDialCodesInBookCreation() throws Exception{
		SignUpPageObj signupObj = new SignUpPageObj();
		CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj();
		BookEditorPageObj bookEditorPageObj = new BookEditorPageObj();
		List <TestDataForDiksha> objListOFTestDataForSunbird= null ;
		objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
		String currentDir =System.getProperty("user.dir");
		String [] partsOfCurrentDir = currentDir.split("/");
		String systemName = partsOfCurrentDir[2];
		String dirPath = "/home/"+systemName+"/Downloads/";
		
		//Step 1:Login as Creator
		signupObj.userLogin(CREATOR);

		//Step 2:Navigate to workspace to Create a book
		creatorUserPageObj.navigateToWorkspace(BOOK);
		
		//Step 3:Download TOC
		String ext = bookEditorPageObj.download_QRCode(objListOFTestDataForSunbird);
		
		//Step 4:Verify the file is Downloaded or not
		Boolean DownloadStatus = GenericFunctions.isFileDownloaded_Ext(dirPath, ext);
		System.out.println("FIle exist in the location:"+ DownloadStatus);
		ExtentTestManager.getTest().log(LogStatus.INFO, "FIle exist in the location:"+ DownloadStatus);
		
		//Step 5:Logout as Creator
		signupObj.userLogout();
		
	}

}
