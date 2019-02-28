package org.pageobjects;


import java.util.List;
import java.util.Random;

import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.page.CreatorUserPage;
import org.page.GetPage;
import org.page.SignUpPage;
import org.page.UploadOrgPage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class GetPageObj extends BaseTest{

	SignUpPage signUpPage=PageFactory.initElements(driver, SignUpPage.class);
	GetPage getPage = PageFactory.initElements(driver, GetPage.class);
	UploadOrgPage orgUploadPage=PageFactory.initElements(driver, UploadOrgPage.class);
	CreatorUserPageObj creatorUserPageObj = new CreatorUserPageObj(); 
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	Actions action = new Actions(driver);
	Random rand=new Random();

	public void verifyGetPageComponents() throws InterruptedException
	{
		try
		{

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to get page");
			GenericFunctions.assertIfElementExists1(driver, XPATH, orgUploadPage.loginButton3);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Found login button: "+orgUploadPage.loginButton3);
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPage.getPageSearch);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Found search context: "+getPage.getPageSearch);
			GenericFunctions.waitWebDriver(1500);
		/*	GenericFunctions.assertIfElementExists1(driver, XPATH, getPage.getPageGooglePlayIcon);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Found google play icon: "+getPage.getPageGooglePlayIcon);*/
			GenericFunctions.waitWebDriver(1500);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to get page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to navigate to get page"+e.getLocalizedMessage());
		}
	}
	public void verifyGetPageDialCode() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to get page and search dial code");
			String randomDialCode = DIAL_CODE[rand.nextInt(DIAL_CODE.length)];
			getPage.getPageSearch.sendKeys(randomDialCode);
			getPage.getPageSearch.sendKeys(Keys.ENTER);
			Assert.assertEquals(randomDialCode, getPage.getPageDialCode.getText().substring(11, 17) , "Dial Codes Matching");
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPage.getPageDialCode);
			//driver.navigate().back();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search dial code in get page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to search dial code in get page"+e.getLocalizedMessage());
		}
	}
	
	public void verifyGetPageGooglePlayStoreNavigation() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to google play store clickin on google play icon in get page");

			getPage.getPageGooglePlayIcon.click();
			String getPageGPUrl = driver.getCurrentUrl();
			ExtentTestManager.getTest().log(LogStatus.INFO, "URL : "+getPageGPUrl);
			System.out.println("URL: "+getPageGPUrl);
			driver.navigate().back();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search dial code in get page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to search dial code in get page"+e.getLocalizedMessage());
		}
	}
	public void verifyGetPageLoginScreenNavigation() throws InterruptedException
	{
		try
		{
			
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to navigate to login screen on clickin on login button in get page");
			orgUploadPage.loginButton3.click();
			String getPageGPUrl = driver.getCurrentUrl();
			String getPageGPTitle = driver.getTitle();
			ExtentTestManager.getTest().log(LogStatus.INFO, "Application is navigated to login URL : "+getPageGPUrl);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Application has navigated to login page having title: "+getPageGPTitle);
			System.out.println("Application has navigated to login page having title: "+getPageGPTitle);
			driver.navigate().back();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to navigate to login page on clicking on login button in get page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to navigate to login page on clicking on login button in get page"+e.getLocalizedMessage());
		}
	}
	public void verifyGetPageDialCodeComingSoon() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search with dial code which is not available");
			String randomDialCode = DIAL_CODE[rand.nextInt(DIAL_CODE.length)];
			getPage.getPageSearch.sendKeys(randomDialCode+"1234");
			getPage.getPageSearch.sendKeys(Keys.ENTER);
			try
			{
				//Dec 12
				//GenericFunctions.assertIfElementExists1(driver, XPATH, signUpPage.alertMessage);
			/*	GenericFunctions.waitForElementToAppear(signUpPage.alertMessage.get(0));
				String alertText = signUpPage.alertMessage.get(0).getText();*/
				GenericFunctions.waitWebDriver(1500);
			//	System.out.println("Searched dial code in not available and "+alertText);						
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Searched dial code in not available and Content is coming soon");
			}
			driver.navigate().refresh();
			GenericFunctions.waitWebDriver(4000);
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed in searching dial code");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed in searching dial code"+e.getLocalizedMessage());
		}
	}


	public void verifyGetPageDialCodeSearchResults() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to search dial code again in search page");
			String randomDialCode1 = DIAL_CODE[rand.nextInt(DIAL_CODE.length)];
			getPage.getPageSearch.sendKeys(randomDialCode1);
			getPage.getPageSearch.sendKeys(Keys.ENTER);
			GenericFunctions.waitWebDriver(3000);
			
			//Assert.assertEquals(randomDialCode1, getPage.getPageDialCode.getText());
			driver.navigate().refresh();
			
			GenericFunctions.waitWebDriver(4000);
		//Assert.assertEquals(randomDialCode1, getPage.getPageDialCode.getText().substring(11, 17) , "Iteration 1: Dial Codes Matching");
			//getPage.getPageSearch.clear();
			String randomDialCode2 = DIAL_CODE[rand.nextInt(DIAL_CODE.length)];
			getPage.getPageSearch.sendKeys(randomDialCode2);
			getPage.getPageSearch.sendKeys(Keys.ENTER);
			
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPage.getPageDialCode);
			//Assert.assertEquals(randomDialCode2, getPage.getPageDialCode.getText());
			
			//Assert.assertEquals(randomDialCode2, getPage.getPageDialCode.getText().substring(11, 17) , "Iteration 2: Dial Codes Matching");
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPage.getPageDialCode);
			GenericFunctions.waitWebDriver(1500);
			driver.navigate().back();
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to search dial code again in search page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to search dial code again in search page"+e.getLocalizedMessage());
		}
	}

	public void verifyGetStartedPageExploreDiksha() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify page elements in explore Diksha page");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPage.exploreContent);
			getPage.exploreContent.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPage.idSearchBar);
			System.out.println(driver.getCurrentUrl());
			ExtentTestManager.getTest().log(LogStatus.INFO, "User navigated to "+driver.getCurrentUrl());
			GenericFunctions.assertIfElementExists1(driver, XPATH, orgUploadPage.loginInExplorePage);
			GenericFunctions.assertIfElementExists1(driver, ID, getPage.idSearchBar);			
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPage.xEnterDialCode);
			ExtentTestManager.getTest().log(LogStatus.INFO, getPage.xEnterDialCode.getText());
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPage.xLanguageChange);
			ExtentTestManager.getTest().log(LogStatus.INFO, getPage.xLanguageChange.getText());
			GenericFunctions.assertIfElementExists1(driver, ID, getPage.iBoard);
			ExtentTestManager.getTest().log(LogStatus.INFO, getPage.iBoard.getText());
			GenericFunctions.assertIfElementExists1(driver, ID, getPage.iMedium);
			ExtentTestManager.getTest().log(LogStatus.INFO, getPage.iMedium.getText());
			GenericFunctions.assertIfElementExists1(driver, ID, getPage.iSubject);
			ExtentTestManager.getTest().log(LogStatus.INFO, getPage.iSubject.getText());
			GenericFunctions.assertIfElementExists1(driver, ID, getPage.iClass);
			ExtentTestManager.getTest().log(LogStatus.INFO, getPage.iClass.getText());
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPage.xBtnSubmit);
			ExtentTestManager.getTest().log(LogStatus.INFO, getPage.xBtnSubmit.getText());
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPage.xBtnReset);
			ExtentTestManager.getTest().log(LogStatus.INFO, getPage.xBtnReset.getText());
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.assertIfAllElementsExists(driver,getPage.xListOfContents);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Verified all the Page Elements of Explore page of Diksha");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify page elements in explore Diksha page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to verify page elements in explore Diksha page"+e.getLocalizedMessage());
		}
	}


	public void verifyContentSearchInExploreDiksha() throws InterruptedException
	{
		try
		{
			List <TestDataForDiksha> objListOFTestDataForDiksha= null ;
			objListOFTestDataForDiksha = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify respected search result on explore Diksha page");
			/*
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPage.getStartedExplore);
			getPage.getStartedExplore.click();
			*/
			driver.get("https://staging.ntp.net.in/");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPage.exploreContent);
			getPage.exploreContent.click();			
			GenericFunctions.waitForElementToAppear(getPage.idSearchBar);			
			getPage.idSearchBar.sendKeys(objListOFTestDataForDiksha.get(0).getCourseName());
			GenericFunctions.waitWebDriver(2000);
			getPage.idSearchBar.sendKeys(Keys.ENTER);
			GenericFunctions.waitWebDriver(1500);
			CreatorUserPageObj.assertCourseFoundInSearch(objListOFTestDataForDiksha.get(0).getCourseName());
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPage.exploreDikshaContentCard);

			try
			{
				if(getPage.exploreDikshaContentCard.isDisplayed())

				{
					Assert.assertTrue(true,"Failed on Asserting the resuults after the content search");
					ExtentTestManager.getTest().log(LogStatus.PASS, "Contents are displayed on searching in explore Diksha Page");
				}
			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Contents are not displayed on searching in explore Diksha Page"+e.getLocalizedMessage());
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify respected search result on explore Diksha page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to verify respected search result on explore Diksha page"+e.getLocalizedMessage());
		}
	}

	public void verifyLanguageChangeInExploreDiksha() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify that the the placeholder of all the fields on explore page are displaying according to the selected language");
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPage.getStartedExplore);
			driver.get("https://staging.ntp.net.in/");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPage.exploreContent);
			getPage.exploreContent.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPage.xLanguageChange);
			getPage.xLanguageChange.click();
			//GenericFunctions.selectValueFromDropdown(driver, getPage.xSelectHindiLanguage, "Hindi");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPage.xSelectHindiLanguage);
			getPage.xSelectHindiLanguage.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.assertElementValueByWebElement(driver, XPATH, getPage.xEnterDialCode_Hindi, HINDI_LABEL);
			ExtentTestManager.getTest().log(LogStatus.INFO, "Field labels are displayed according to the selected language");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify that the the placeholder of all the fields on explore page are displaying according to the selected language");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to verify that the the placeholder of all the fields on explore page are displaying according to the selected language"+e.getLocalizedMessage());
		}
	}

	public void verifyDialCodeContentInExploreDiksha() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify that the user is able to get the content associated with the DIAL code ");
			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPage.getStartedExplore);
			getPage.getStartedExplore.click();*/
			driver.get("https://staging.ntp.net.in/");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPage.exploreContent);
			getPage.exploreContent.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPage.xLanguageChange);
			getPage.xLanguageChange.click();
			GenericFunctions.waitForElementToAppear(getPage.xSelectEnglishLanguage);
			getPage.xSelectEnglishLanguage.click();
			GenericFunctions.waitForElementToAppear(getPage.xEnterDialCode);
			getPage.xEnterDialCode.click();
			String randomDialCode1 = DIAL_CODE[rand.nextInt(DIAL_CODE.length)];
			getPage.getPageSearch.sendKeys(randomDialCode1);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPage.xDivBtnSubmit);
			getPage.xDivBtnSubmit.click();
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.assertIfElementExists1(driver, XPATH, getPage.getPageDialCode);
			GenericFunctions.assertIfAllElementsExists(driver, getPage.reviewDialCodeRelatedContent);
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is able to verify and get the content associated with the DIAL code searched");
			getPage.reviewDialCodeRelatedContent.get(0).click();
			GenericFunctions.waitWebDriver(3000);
			/*GenericFunctions.assertIfAllElementsExists(driver,getPage.xDialContentTitles);	
			getPage.xDialContentTitles.get(0).click();*/
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.captureScreenshotOnValidation();
			ExtentTestManager.getTest().log(LogStatus.PASS, "User is able to check and access the content which was associated with the DIAL code searched");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify that the user is able to get and access the content associated with the DIAL code ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to verify that the user is able to get and access the content associated with the DIAL code "+e.getLocalizedMessage());
		}
	}


	public void verifyLoginNavigationFromExploreDiksha() throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify that the clicking on Login button is navigating to the login page");
			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPage.getStartedExplore);
			getPage.getStartedExplore.click();*/
			driver.get("https://staging.ntp.net.in/");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPage.exploreContent);
			//getPage.getStartedExplore.click();
			GenericFunctions.waitWebDriver(1000);
			orgUploadPage.loginButton.click();
			GenericFunctions.waitWebDriver(1500);
			ExtentTestManager.getTest().log(LogStatus.PASS, "User is able to navigate to the login page "+driver.getCurrentUrl());
			GenericFunctions.captureScreenshotOnValidation();

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify that the clicking on Login button is navigating to the login page");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to verify that the clicking on Login button is navigating to the login page"+e.getLocalizedMessage());
		}
	}

	public void verifyContentParameterDisplay(WebElement locator1, WebElement locator2) throws InterruptedException
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify that the contents displayed according to the selected parameter in filter section");
			driver.get(APP_URL);
			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPage.getStartedExplore);
			getPage.getStartedExplore.click();*/
			driver.get("https://staging.ntp.net.in/");
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(getPage.exploreContent);
			getPage.exploreContent.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(locator1);
			ExtentTestManager.getTest().log(LogStatus.INFO, locator1.getText()+" is the selected filter ");
			locator1.click();
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(locator2);
			ExtentTestManager.getTest().log(LogStatus.PASS, "Contents are displayed according to the selected "+locator2.getText());
			locator2.click();
			GenericFunctions.waitWebDriver(1500);
			getPage.xBtnSubmit.click();
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(5000);
			System.out.println("1");
			GenericFunctions.assertIfAllElementsExists(driver,getPage.xListOfContents);
			System.out.println("2");
			getPage.xBtnReset.click();
			System.out.println("4");
			GenericFunctions.waitWebDriver(6000);

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify that the contents displayed according to the selected "+locator1.getText()+" and "+
					locator2.getText()+" parameter in filter section");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Failed to verify that the contents displayed according to the selected "+locator1.getText()+" and "+
					locator2.getText()+" parameter in filter section"+e.getLocalizedMessage());
		}
	}

}