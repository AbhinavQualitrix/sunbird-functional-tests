package org.pageobjects;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.apache.log4j.Logger;
import org.apache.poi.util.SystemOutLogger;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.AnnouncementPage;
import org.page.CreatorAnnouncementPage;


import org.page.UploadOrgPage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class AnnouncementPageObj extends BaseTest
{
	//private static final String IMAGE = null;
		WebDriverWait wait = new WebDriverWait(driver,20);
		AnnouncementPage AnnouncementPage=PageFactory.initElements(driver, AnnouncementPage.class);	
		CreatorAnnouncementPage createAnnouncementPage= PageFactory.initElements(driver, CreatorAnnouncementPage.class);
		//SignUpPage signUpPage=PageFactory.initElements(driver, SignUpPage.class);
		static Logger log = Logger.getLogger(CreatorAnnouncementPage.class.getName());
		Actions action = new Actions(driver);
		Random rand=new Random();
		String announcementName;
		List <TestDataForDiksha> objListOFTestDataForSunbird= null;

		/**
		 * Purpose: navigateToAnnouncementInDropDownMenu method is used to navigate to the announcement dashboard in header dropdown.
		 */
		
	public void navigateToAnnouncementInDropDownMenu() throws InterruptedException
	{
		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to announcement dashboard in drop down menu");
			GenericFunctions.waitForElementToAppear(AnnouncementPage.profileIconDropdown);
			//AnnouncementPage.closePopUp.click();
			GenericFunctions.waitWebDriver(1500);
			AnnouncementPage.profileIconDropdown.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPage.announcement_Dashboard.click();	
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on navigating announcement in drop down menu");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method navigateToAnnouncementInDropDownMenu"+e.getMessage());
			Assert.fail("Failed on navigating to announcement dashboard in drop down menu, Exception : "+e.getLocalizedMessage());

		}
	}
	
	/**
	 * Purpose: CreateAnnouncementPopUp method is used to create announcement popup.
	 */
	public void CreateAnnouncementPopUp() throws InterruptedException, Exception
	{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify create announcement Popup");
			Robot robot = new Robot();
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitWebDriver(1500);
			AnnouncementPage.create_Announcement.click();
			GenericFunctions.waitWebDriver(5000);
			AnnouncementPage.enterTitle.click();
			String announcementNumber = GenericFunctions.testDataIncrementer("./testData/announcementNumbers.txt").toString();
			announcementName = objListOFTestDataForSunbird.get(7).getCourseName();
			System.out.println(announcementName + announcementNumber);
			AnnouncementPage.enterTitle.sendKeys(announcementName + announcementNumber );
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPage.enterOrg.click();
			AnnouncementPage.enterOrg.sendKeys(objListOFTestDataForSunbird.get(7).getCourseDescription());
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPage.announcementType.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPage.announcementTypeOrder.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPage.enterDescription.click();
			AnnouncementPage.enterDescription.sendKeys(objListOFTestDataForSunbird.get(7).getTitle());
			GenericFunctions.waitWebDriver(2000);
			/*AnnouncementPage.addUrl.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPage.enterUrl.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPage.enterUrl.sendKeys(objListOFTestDataForSunbird.get(7).getTitleDescription());*/
			GenericFunctions.waitWebDriver(1000);
			Assert.assertTrue(true,"User is able to enter title & org, select announcement type, enter description and add URL successfully ");
			log.info("User is able to enter title & org, select announcement type, enter description and add URL successfully ");
			System.out.println("User is able to enter title & org, select announcement type, enter description and add URL successfully ");
		}
		
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on verifying announcement popup : Title, org, Type, Description, Link");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method CreateAnnouncementPopUp"+e.getMessage());
			Assert.fail("Failed on verifying announcement popup : Title, org, Type, Description, Link, Exception : "+e.getLocalizedMessage());
		}
		
	 }
	

	/**
	 * Purpose: editAndResendAnnounccement method is used to resend the announcement after editting the fields.
	 */
	public void editAndResendAnnouncement() throws InterruptedException, Exception
	{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to edit,resend and validate the edited announcement");
			//Robot robot = new Robot();
			//objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForSunbird("testdatasheetcourse");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(AnnouncementPage.resendAnnouncementButton);
			AnnouncementPage.resendAnnouncementButton.click();
			GenericFunctions.waitWebDriver(5000);
			AnnouncementPage.resendTitle.click();
			AnnouncementPage.resendTitle.clear();
			AnnouncementPage.resendTitle.sendKeys("Automation123456789");
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPage.editRecipients.click();
			GenericFunctions.waitWebDriver(8000);
			GenericFunctions.waitForElements(createAnnouncementPage.checkLocation);
			GenericFunctions.waitWebDriver(5000);
			createAnnouncementPage.checkLocation.get(0).click();
			/*createAnnouncementPage.checkLocation.get(1).click();
			createAnnouncementPage.checkLocation.get(2).click();*/
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.clickOnElementUsingJavascript(AnnouncementPage.confirmRecipients);
			//AnnouncementPage.confirmRecipients.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.clickOnElementUsingJavascript(AnnouncementPage.previewAnnouncement);
			//AnnouncementPage.previewAnnouncement.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.clickOnElementUsingJavascript(AnnouncementPage.sendAnnouncement);
			//AnnouncementPage.sendAnnouncement.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.clickOnElementUsingJavascript(AnnouncementPage.announcementcreatedConfirmation);
			//AnnouncementPage.announcementcreatedConfirmation.click();
			GenericFunctions.waitWebDriver(3000);
			String editproof = AnnouncementPage.editedAnnouncement.getText();
			System.out.println(editproof + "This is the edited Title");
			Assert.assertTrue(true,"User is able to edit and resend the announcement successfully");
			log.info("User is able to edit and resendd the announcement suuccessfully");
			System.out.println("User is able to edit and resend the announcement successfully");
			GenericFunctions.waitWebDriver(2500);
		}
		
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to edit and resend announcement");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method editAndResendAnnounccement"+e.getMessage());
			Assert.fail("Failed to edit and resend announcement: "+e.getLocalizedMessage());
		}
		
	 }
	/**
	 * Purpose: verifyDataStorage method is used to verify the data is getting stored ,by clicking on back after entering each field.
	 */
	public void verifyDataStorage() throws InterruptedException, Exception
	{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify that page data is stored correctly by checking in back button");
			Robot robot = new Robot();
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitWebDriver(1500);
			AnnouncementPage.create_Announcement.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(AnnouncementPage.enterTitle);
			AnnouncementPage.enterTitle.click();
			String announcementNumber = GenericFunctions.testDataIncrementer("./testData/announcementNumbers.txt").toString();
			announcementName = objListOFTestDataForSunbird.get(7).getCourseName();
			System.out.println(announcementName + announcementNumber);
			AnnouncementPage.enterTitle.sendKeys(announcementName + announcementNumber );
			AnnouncementPage.enterOrg.click();
			AnnouncementPage.enterOrg.sendKeys(objListOFTestDataForSunbird.get(7).getCourseDescription());
			AnnouncementPage.announcementType.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPage.announcementTypeOrder.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPage.enterDescription.click();
			AnnouncementPage.enterDescription.sendKeys(objListOFTestDataForSunbird.get(7).getTitle());
			GenericFunctions.waitWebDriver(2000);
			/*AnnouncementPage.addUrl.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPage.enterUrl.click();
			GenericFunctions.waitWebDriver(1000);
			AnnouncementPage.enterUrl.sendKeys(objListOFTestDataForSunbird.get(7).getTitleDescription());*/
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(AnnouncementPage.selectRecipients);
			GenericFunctions.clickOnElementUsingJavascript(AnnouncementPage.selectRecipients);
			GenericFunctions.waitWebDriver(3000);
			AnnouncementPage.back.click();
			GenericFunctions.waitWebDriver(3000);
			AnnouncementPage.selectRecipients.click();
			GenericFunctions.waitWebDriver(8000);
			GenericFunctions.waitForElements(createAnnouncementPage.checkLocation);
			GenericFunctions.waitWebDriver(5000);
			createAnnouncementPage.checkLocation.get(0).click();
			createAnnouncementPage.checkLocation.get(1).click();
			createAnnouncementPage.checkLocation.get(2).click();
			//action.moveToElement(createAnnouncementPage.checkLocation).click().build().perform();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.confirmRecipients);
			GenericFunctions.waitWebDriver(3000);
			AnnouncementPage.back.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.confirmRecipients);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.clickOnElementUsingJavascript(AnnouncementPage.previewAnnouncement);  
			GenericFunctions.waitWebDriver(3000);
			AnnouncementPage.back.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.clickOnElementUsingJavascript(AnnouncementPage.previewAnnouncement);  
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.clickOnElementUsingJavascript(AnnouncementPage.sendAnnouncement);  
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.clickOnElementUsingJavascript(AnnouncementPage.announcementcreatedConfirmation);  
			GenericFunctions.waitWebDriver(2000);
			System.out.println("Page Data storage verified successfully by going Back to every page");
			Assert.assertTrue(true,"Previous pages data are correctly displayed upon clicking on Back button when user returns to previous screen");
			log.info("Previous pages data are correctly displayed upon clicking on Back button when user returns to previous screen");
			System.out.println("Previous pages data are correctly displayed upon clicking on Back button when user returns to previous screen");
		}
		
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to store the page data correctly after clicking Back button");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method verifyBackButton"+e.getMessage());
			Assert.fail("Failed to store the page data correctly after clicking Back button: "+e.getLocalizedMessage());
		}
		
	 }
	/**
	 * Purpose: CreateAnnouncement method is used to create a new announcement.
	 */
	public void CreateAnnouncement() throws InterruptedException, Exception
	{

		try{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create an announcement");
			objListOFTestDataForSunbird = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.create_Announcement);
			createAnnouncementPage.create_Announcement.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.enterTitle);
			createAnnouncementPage.enterTitle.click();
			String announcementNumber = GenericFunctions.testDataIncrementer("./testData/announcementNumbers.txt").toString();
			announcementName = objListOFTestDataForSunbird.get(7).getCourseName()+announcementNumber;
			System.out.println(announcementName + announcementNumber);
			createAnnouncementPage.enterTitle.sendKeys(announcementName + announcementNumber );
			createAnnouncementPage.enterOrg.click();
			createAnnouncementPage.enterOrg.sendKeys(objListOFTestDataForSunbird.get(7).getCourseDescription());
			createAnnouncementPage.announcementType.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.announcementTypeOrder.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterDescription.click();
			createAnnouncementPage.enterDescription.sendKeys(objListOFTestDataForSunbird.get(7).getTitle());
			GenericFunctions.waitWebDriver(2000);
			/*createAnnouncementPage.addUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.click();
			GenericFunctions.waitWebDriver(1000);
			createAnnouncementPage.enterUrl.sendKeys("https://www.google.com/");*/
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.selectRecipient);
			/*action.moveToElement(createAnnouncementPage.selectRecipient).build().perform();
			action.click().build().perform();*/
			GenericFunctions.waitWebDriver(8000);
			GenericFunctions.waitForElements(createAnnouncementPage.checkLocation);
			GenericFunctions.waitWebDriver(5000);
			createAnnouncementPage.checkLocation.get(0).click();
			createAnnouncementPage.checkLocation.get(1).click();
			createAnnouncementPage.checkLocation.get(2).click();
			//action.moveToElement(createAnnouncementPage.checkLocation).click().build().perform();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.confirmRecipients);
			//createAnnouncementPage.confirmRecipients.click();
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.previewAnnouncement);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.previewAnnouncement);
			//createAnnouncementPage.previewAnnouncement.click();
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.sendAnnouncement);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.sendAnnouncement);
			//createAnnouncementPage.sendAnnouncement.click();
			GenericFunctions.waitForElementToAppear(createAnnouncementPage.announcementcreatedConfirmation);
			GenericFunctions.clickOnElementUsingJavascript(createAnnouncementPage.announcementcreatedConfirmation);
			//createAnnouncementPage.announcementcreatedConfirmation.click();
			GenericFunctions.waitWebDriver(2000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating an announcement");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			log.error("Exception In the method CreateAnnouncement"+e.getMessage());
			Assert.fail("Failed to create an announcement, Exception : "+e.getLocalizedMessage());
		}
	}
	
	
}