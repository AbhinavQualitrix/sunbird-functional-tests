package org.pageobjects;



import java.util.List;

import org.apiPackage.ApiHashMap;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.BookEditorPage;
import org.page.CreatorUserPage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class BookEditorPageObj extends BaseTest{

	
	WebDriverWait wait = new WebDriverWait(driver,20);
	
	BookEditorPage bookEditorPage = PageFactory.initElements(driver, BookEditorPage.class);
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	GenericFunctions genericFunctions = new GenericFunctions();
	Actions action = new Actions(driver);
	
	String DoId ;
	String med_class_sub;
	String fileName;
	String ownershiptype;
	
	/**
	* Purpose: download_TOC method is used to  download the TOC and capture the message and return DOId. 
	* */
	
	public String download_TOC(List <TestDataForDiksha> objListOFTestDataForSunbird) throws InterruptedException
	{
		
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to download TOC");
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer("./testData/bookNumbers.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber);	
			createUserPage.startCreating.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.clickOnElementUsingJavascript(createUserPage.clickUseEditor);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.newChild);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			action.moveToElement(createUserPage.newChild).click().perform();
			createUserPage.untitledNameB.click();
			createUserPage.untitledNameB.clear();
			createUserPage.untitledNameB.sendKeys(objListOFTestDataForSunbird.get(2).getTitle()+courseNumber);
			GenericFunctions.waitWebDriver(2000);
			bookEditorPage.addInExploreSuggestion.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitForElementToAppearOnScreen(bookEditorPage.messageBox);
			String MessageBox = bookEditorPage.messageBox.getText();
			System.out.println(MessageBox);
			ExtentTestManager.getTest().log(LogStatus.INFO, MessageBox);
			bookEditorPage.dropDownTOC.click();
			GenericFunctions.waitForElementToAppearOnScreen(bookEditorPage.downloadTOCMetadata);
			String ActualData = bookEditorPage.downloadTOCMetadata.getText();
			System.out.println(ActualData+" button is Available");
			ExtentTestManager.getTest().log(LogStatus.INFO, ActualData);
			GenericFunctions.waitWebDriver(1000);
			bookEditorPage.downloadTOCMetadata.click();
			GenericFunctions.waitWebDriver(2000);
			String CurrentURL = driver.getCurrentUrl();
			String [] arrOfUrl = CurrentURL.split("/");
			DoId = arrOfUrl[7];
			System.out.println(DoId);
			GenericFunctions.waitForElementToAppearOnScreen(bookEditorPage.messageBox);
			String MessageBox1 = bookEditorPage.messageBox.getText();
			System.out.println(MessageBox1);
			ExtentTestManager.getTest().log(LogStatus.INFO, MessageBox1);
			createUserPage.editorCloseIcon.click();
			

		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to download the toc");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to download the toc");
			Assert.fail("Failed to download the toc");
		}
		return DoId;
	}
	
	/**
	* Purpose: download_QRCode method is used to  download the QR code and capture the message and validate the downloaded file DOId. 
	* */
	
	public String download_QRCode(List <TestDataForDiksha> objListOFTestDataForSunbird) throws InterruptedException
	{
		
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to download_QRCode");
			GenericFunctions.waitForElementToAppear(createUserPage.courseName);
			String courseNumber = GenericFunctions.testDataIncrementer("./testData/bookNumbers.txt").toString();
			createUserPage.courseName.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+courseNumber);	
			createUserPage.startCreating.click();
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.clickOnElementUsingJavascript(createUserPage.clickUseEditor);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.newChild);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			action.moveToElement(createUserPage.newChild).click().perform();
			createUserPage.untitledNameB.click();
			createUserPage.untitledNameB.clear();
			createUserPage.untitledNameB.sendKeys(objListOFTestDataForSunbird.get(2).getTitle()+courseNumber);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.saveCourse.click();
			String partOfFileName = editDetailsForm();
			bookEditorPage.dropdownQR_Codes.click();
			GenericFunctions.waitWebDriver(1000);
			bookEditorPage.generateQR_Codes.click();
			GenericFunctions.waitForElementToAppearOnScreen(bookEditorPage.requestQR_Codes);
			bookEditorPage.requestQR_Codes.click();
			String QRcodeCount = GenericFunctions.testDataIncrementer("./testData/QRcodeCount.txt").toString();
			bookEditorPage.requestQR_Codes.sendKeys(QRcodeCount);
			System.out.println(QRcodeCount);
			ExtentTestManager.getTest().log(LogStatus.INFO, QRcodeCount);
			GenericFunctions.waitWebDriver(2000);
			bookEditorPage.requestButtonInQR_Codes.click();
			System.out.println("No. of QR code needed is entered");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppearOnScreen(bookEditorPage.dropdownQR_Codes);
			bookEditorPage.dropdownQR_Codes.click();
			GenericFunctions.waitForElementToAppearOnScreen(bookEditorPage.generateQR_Codes);
			String ActualData1 = bookEditorPage.generateQR_Codes.getText();
			System.out.println(ActualData1+" button is Available");
			ExtentTestManager.getTest().log(LogStatus.INFO, ActualData1);
			GenericFunctions.waitWebDriver(2000);
			int ActualData2 = Integer.valueOf(QRcodeCount)-1;
			System.out.println(ActualData2);
			String ActualData3 = Integer.toString(ActualData2);
			System.out.println(ActualData3);
			if(ActualData1.equalsIgnoreCase("Generate "+ActualData3+" + 1 QR Codes")) {
				System.out.println("Verified the n-1 + 1 template");
				ExtentTestManager.getTest().log(LogStatus.INFO, "Verified the n-1 + 1 template");
			}else {
				System.out.println("failed to verify n-1 + 1 template");
				ExtentTestManager.getTest().log(LogStatus.INFO, "failed to verify n-1 + 1 template");
			}
			GenericFunctions.waitWebDriver(2000);
			bookEditorPage.downloadQR_Codes.click();
			GenericFunctions.waitWebDriver(1000);
			String CurrentURL = driver.getCurrentUrl();
			String [] arrOfUrl = CurrentURL.split("/");
			DoId = arrOfUrl[7];
			System.out.println(DoId);
			fileName = DoId+partOfFileName;
			System.out.println(fileName);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.QRcodeRequiredYes.click();
			createUserPage.dialcodeEnter.click();
			createUserPage.dialcodeEnter.sendKeys("5FGDHU");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.validatedialcodeEnterYes.click();
			GenericFunctions.waitWebDriver(1000);
			Boolean DialCodestatus = genericFunctions.isElementPresent(createUserPage.invalidDialCode);
			if(DialCodestatus==true) {
				System.out.println("invalid dial code");
				ExtentTestManager.getTest().log(LogStatus.INFO, "invalid dial code");
				
			}else {
				System.out.println("valid dial code");
				ExtentTestManager.getTest().log(LogStatus.INFO, "valid dial code");
			}
			GenericFunctions.waitWebDriver(1000);
			createUserPage.editDialCode.click();
			createUserPage.dialcodeEnter.click();
			createUserPage.dialcodeEnter.clear();
			createUserPage.dialcodeEnter.sendKeys("HFBP7I");
			GenericFunctions.waitWebDriver(1000);
			createUserPage.validatedialcodeEnterYes.click();
			GenericFunctions.waitWebDriver(1000);
			Boolean DialCodestatus1 = genericFunctions.isElementPresent(createUserPage.validDialCodeSymbol);
			if(DialCodestatus1==true) {
				System.out.println("valid dial code");
				ExtentTestManager.getTest().log(LogStatus.INFO, "valid dial code");
				
			}else {
				System.out.println("valid dial code");
				ExtentTestManager.getTest().log(LogStatus.INFO, "invalid dial code");
			}
			createUserPage.saveCourse.click();
			createUserPage.editorCloseIcon.click();
			

		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to download QRCode");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to download QRCode");
			Assert.fail("Failed to download QRCode ");
		}
		return fileName;
	}
	
	/**
	* Purpose: editDetailsForm method is used to  validate the download QR code file by capturing the data required to validate the downloaded file . 
	* */
	
	public String editDetailsForm() throws Exception 
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save edit Details Form");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.editOrViewDetailslink.click();
			GenericFunctions.waitWebDriver(1500);
			ApiHashMap apiHashMap = new ApiHashMap();
			apiHashMap.dynamicFormHandling(DIKSHA_APIKEY,DIKSHA_ROOTORGID,DIKSHA_FRAMEWORK,"review","textbook");
			
			GenericFunctions.scrollToElement(createUserPage.clickBoard);
			GenericFunctions.waitForElementToAppear(createUserPage.clickBoard);
			createUserPage.clickBoard.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectBoard.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickMedium.click();
			GenericFunctions.waitWebDriver(1000);
			String medium = createUserPage.selectMediumN.getText();
			createUserPage.selectMediumN.click();
			GenericFunctions.scrollToElement(createUserPage.clickClassN);
			createUserPage.clickClassN.click();
			GenericFunctions.waitWebDriver(1000);
			String classN = createUserPage.selectClassN.getText();
			createUserPage.selectClassN.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickSubject);
			createUserPage.clickSubject.click();
			GenericFunctions.waitWebDriver(1000);
			String subject = createUserPage.selectSubjectN.getText();
			createUserPage.selectSubjectN.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.selectyear);
			createUserPage.selectyear.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.select2018.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.closeButtonMsg.click();
			String Med_Class_Sub = "_"+medium+"_"+classN+"_"+subject;
			med_class_sub = Med_Class_Sub.toLowerCase();
			GenericFunctions.waitWebDriver(2500);
			
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save edit Details Form");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save edit Details Form ");
			Assert.fail("Failed to save edit Details Form ");

		}
		return med_class_sub;
	}
	/**
	* Purpose: editAndSaveBookForCreatedFor method is used to  edit & save And send for review for selecting owner as created for . 
	* */
	public String editAndSaveBookForCreatedFor() throws Exception
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save And Send NewBook For Review");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.editOrViewDetailslink.click();
			GenericFunctions.waitWebDriver(1500);
			ApiHashMap apiHashMap = new ApiHashMap();
			apiHashMap.dynamicFormHandling(DIKSHA_APIKEY,DIKSHA_ROOTORGID,DIKSHA_FRAMEWORK,"review","textbook");
			/*GenericFunctions.scrollToElement(createUserPage.clickBoard);
			GenericFunctions.waitForElementToAppear(createUserPage.clickBoard);
			createUserPage.clickBoard.click();
			createUserPage.selectBoard.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickMedium.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectMediumN.click();
			GenericFunctions.scrollToElement(createUserPage.clickClassN);
			createUserPage.clickClassN.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClassN.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickSubject);
			createUserPage.clickSubject.click();
			createUserPage.selectSubjectN.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.selectyear);
			createUserPage.selectyear.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.select2018.click();*/
			
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			ownershiptype = createUserPage.selectOwner.getText();
			String secondOwner = createUserPage.selectOwner2.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Ownershiptype(created For) is available and selected:"+ownershiptype);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Ownershiptype(created By) is available:"+secondOwner);
			createUserPage.selectOwner.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.creditTo.click();
			createUserPage.creditTo.sendKeys("Automation Test");
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2500);
			
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save And Send NewBook For Review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save And Send NewBook For Review ");
			Assert.fail("Failed to save And Send NewBook For Review ");
		}
		return ownershiptype;
	}
	/**
	* Purpose: editAndSaveBookForCreatedBy method is used to  edit & save And send for review for selecting owner as created By . 
	* */
	public String editAndSaveBookForCreatedBy() throws Exception
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to save And Send NewBook For Review");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.saveCourse.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.editOrViewDetailslink.click();
			GenericFunctions.waitWebDriver(1500);
			ApiHashMap apiHashMap = new ApiHashMap();
			apiHashMap.dynamicFormHandling(DIKSHA_APIKEY,DIKSHA_ROOTORGID,DIKSHA_FRAMEWORK,"review","textbook");
			/*GenericFunctions.scrollToElement(createUserPage.clickBoard);
			GenericFunctions.waitForElementToAppear(createUserPage.clickBoard);
			createUserPage.clickBoard.click();
			createUserPage.selectBoard.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.clickMedium.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectMediumN.click();
			GenericFunctions.scrollToElement(createUserPage.clickClassN);
			createUserPage.clickClassN.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.selectClassN.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickSubject);
			createUserPage.clickSubject.click();
			createUserPage.selectSubjectN.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.selectyear);
			createUserPage.selectyear.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.select2018.click();*/
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner2);
			ownershiptype = createUserPage.selectOwner2.getText();
			String secondOwner = createUserPage.selectOwner.getText();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Ownershiptype(created For) is available and selected:"+ownershiptype);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Ownershiptype(created By) is available:"+secondOwner);
			createUserPage.selectOwner2.click();
			GenericFunctions.waitWebDriver(1000);
			createUserPage.creditTo.click();
			createUserPage.creditTo.sendKeys("Automation Test");
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2500);
			
		}
		catch(Exception e){
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to save And Send NewBook For Review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to save And Send NewBook For Review ");
			Assert.fail("Failed to save And Send NewBook For Review ");
		}
		return ownershiptype;
	}
	/**
	* Purpose: sendBookforReview method is used to send the book for review. 
	* */
	public void sendBookforReview() throws Exception
	{
		try 
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Send Book For Review");
			GenericFunctions.waitForElementToAppear(createUserPage.sendForReview);
			createUserPage.sendForReview.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.clickAppIcon);
			createUserPage.clickAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.checkAppIcon);
			createUserPage.checkAppIcon.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectAppIcon.click();
			GenericFunctions.waitWebDriver(2500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
		}
		catch(Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Send Book For Review");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to Send Book For Review");
			Assert.fail("Failed to Send Book For Review ");
		}
	}
	/**
	* Purpose: verifyOwnerInEditSection method is used to  verify Owner In Edit Section . 
	* */
	public void verifyOwnerInEditSection() throws Exception
	{
		try 
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify Owner In Edit Section");
			GenericFunctions.waitWebDriver(1500);
			createUserPage.editOrViewDetailslink.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.scrollToElement(createUserPage.selectedOwnerType);
			String selectedOwnerType = createUserPage.selectedOwnerType.getText();
			if(selectedOwnerType.equalsIgnoreCase(ownershiptype)) 
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "selected ownership type is verified");
			}
			else
			{
				ExtentTestManager.getTest().log(LogStatus.FAIL, "selected ownership type is not verified");
			}
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(1500);
			createUserPage.editorCloseIcon.click();
			
		}
		catch(Exception e) {
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify Owner In Edit Section");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to verify Owner In Edit Section");
			Assert.fail("Failed to verify Owner In Edit Section ");
		}
	}
	/**
	* Purpose: verifyOwnershipTypeInContent method is used to verify selected ownership type is present or not. 
	* */
	public void verifyOwnershipTypeInContent() throws Exception
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying  to verify OwnershipType In Content");
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(bookEditorPage.viewDetailsLink);
			bookEditorPage.viewDetailsLink.click();
			String OwnerDetails = bookEditorPage.ownerInViewDetailsPage.getText();
			System.out.println(OwnerDetails);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Ownership type in content is :"+ OwnerDetails);
			String [] createdBy_createdFor = OwnerDetails.split(":");
			
			if(ownershiptype.equalsIgnoreCase(createdBy_createdFor[1].trim()))
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "Ownership type in content is :"+ OwnerDetails);
			}
			else {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Ownership type in content is not present :"+ OwnerDetails);
			}
			//createUserPage.close
			/*GenericFunctions.waitForElementToAppear(bookEditorPage.ownershipTypeInContent);
			String createdBy_createdFor = bookEditorPage.ownershipTypeInContent.getText();
			System.out.println(createdBy_createdFor);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Ownership type in content is :"+ createdBy_createdFor);
			createUserPage.editorCloseIcon.click();*/
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify OwnershipType In Content");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to verify OwnershipType In Content");
			Assert.fail("Failed to verify OwnershipType In Content ");
		}
	}
}
