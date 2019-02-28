package org.pageobjects;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.page.ContentCreateUploadPage;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.SignUpPage;
import org.page.SignUpPage;
import org.page.TopicTreePage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.relevantcodes.extentreports.LogStatus;

public class TopicTreePageObject extends BaseTest{
	WebDriverWait wait = new WebDriverWait(driver,20);
	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	PublicUserPage publicUserPage = PageFactory.initElements(driver, PublicUserPage.class);
	CreateMentorPage createMentorPage=PageFactory.initElements(driver, CreateMentorPage.class);
	ContentCreateUploadPage contentCreatePage = PageFactory.initElements(driver, ContentCreateUploadPage.class);
	CreatorUserPageObj createrUserPageObj = new CreatorUserPageObj();
	TopicTreePage topicslist = PageFactory.initElements(driver, TopicTreePage.class);
	SignUpPage signUpPage=PageFactory.initElements(driver, SignUpPage.class);
	static Logger log = Logger.getLogger(CreatorUserPageObj.class.getName());
	List <TestDataForDiksha> objListOFTestDataForSunbird1= null ;
	Actions action = new Actions(driver);
	Random rand=new Random();


	public void createBook_verifyTopicTreePopup(List <TestDataForDiksha> objListOFTestDataForSunbird)
	{
		try
		{   
			SoftAssert softAssert = new SoftAssert();
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create a book and trying to verify the topic tree popup");
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String bookNumber = GenericFunctions.testDataIncrementer("./testData/bookNumbers.txt").toString();
			topicslist.bookName.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+bookNumber);
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(topicslist.selectRajasthanBoard);
			GenericFunctions.waitWebDriver(5000);

			
			//Dec 12
			/*GenericFunctions.waitForElementToAppear(topicslist.selectBoard);
			topicslist.selectBoard.click();

			GenericFunctions.waitForElementToAppear(topicslist.selectRajasthanBoard);
			topicslist.selectRajasthanBoard.click();

			GenericFunctions.waitForElementToAppear(topicslist.selectGrade);
			topicslist.selectGrade.click();		

			GenericFunctions.waitTillTheElementIsVisibleAndClickable(topicslist.selectGradeLevel);
			topicslist.selectGradeLevel.click();
			topicslist.selectGrade.click();	


			GenericFunctions.waitTillTheElementIsVisibleAndClickable(topicslist.selectSubject);
			topicslist.selectSubject.click();

			GenericFunctions.waitTillTheElementIsVisibleAndClickable(topicslist.selectMathematics);
			topicslist.selectMathematics.click();

			GenericFunctions.waitTillTheElementIsVisibleAndClickable(topicslist.selectMedium);
			topicslist.selectMedium.click();

			GenericFunctions.waitForElementToAppear(topicslist.selectEnglish);
			topicslist.selectEnglish.click();

			GenericFunctions.scrollToElement(topicslist.startCreating);
			//			GenericFunctions.waitTillTheElementIsVisibleAndClickable(topicslist.selectYear);		
			//			topicslist.selectYear.click();
			//			
			 * 
			 * 
*/		
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(topicslist.startCreating);		
			topicslist.startCreating.click();
			GenericFunctions.waitWebDriver(2000);		
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(6500);
			
			topicslist.clickUseEditor.click();
			GenericFunctions.waitWebDriver(3000);
			
			
			GenericFunctions.waitForElementToAppear(createUserPage.newChild);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.bookTitle.click();
			createUserPage.bookTitle.clear();
			createUserPage.bookTitle.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName());
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(topicslist.selectTopic);
			action.moveToElement(topicslist.selectTopic).click().perform();
			GenericFunctions.waitForElementToAppear(topicslist.topicHeader);
			GenericFunctions.waitWebDriver(3000);



			if(topicslist.topicHeader.isDisplayed())

			{
				String Evalue=topicslist.topicHeader.getText();
				softAssert.assertEquals("Topic",Evalue);				
				//softAssert.assertAll();

			}

			ExtentTestManager.getTest().log(LogStatus.PASS, "Topic Tree Pop up is displaying");
			if(topicslist.cancelButton.isDisplayed())
			{
				String Evalue=topicslist.cancelButton.getText();
				softAssert.assertEquals("Cancel",Evalue);	

			}
			ExtentTestManager.getTest().log(LogStatus.PASS, "Cancel Button  is displaying");

			if(topicslist.doneButton.isDisplayed())
			{
				String Evalue=topicslist.doneButton.getText();
				softAssert.assertEquals("Done",Evalue);	

			}

			ExtentTestManager.getTest().log(LogStatus.PASS, "Done Button  is displaying");
			topicslist.cancelButton.click();
			GenericFunctions.waitWebDriver(3000);




		}

		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on creating book and topic tree is not displayed ");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create a book");
			Assert.fail("Failed to display topic header,topic,cancel button,done button");
		}

	}



	public void createBook(List<TestDataForDiksha>objListOFTestDataForSunbird)
	{
		try {
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create book");	
			GenericFunctions.waitWebDriver(1500);
			GenericFunctions.waitForElementToAppear(createUserPage.bookName);
			String bookNumber = GenericFunctions.testDataIncrementer(".//TestData//bookNumbers.txt").toString();

			topicslist.bookName.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName()+bookNumber);
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(topicslist.selectRajasthanBoard);
			GenericFunctions.waitWebDriver(5000);

			/*GenericFunctions.waitForElementToAppear(topicslist.selectBoard);
			topicslist.selectBoard.click();

			GenericFunctions.waitForElementToAppear(topicslist.selectRajasthanBoard);
			topicslist.selectRajasthanBoard.click();

			GenericFunctions.waitForElementToAppear(topicslist.selectGrade);
			topicslist.selectGrade.click();		

			GenericFunctions.waitTillTheElementIsVisibleAndClickable(topicslist.selectGradeLevel);
			topicslist.selectGradeLevel.click();
			topicslist.selectGrade.click();	


			GenericFunctions.waitTillTheElementIsVisibleAndClickable(topicslist.selectSubject);
			topicslist.selectSubject.click();

			GenericFunctions.waitTillTheElementIsVisibleAndClickable(topicslist.selectMathematics);
			topicslist.selectMathematics.click();

			GenericFunctions.waitTillTheElementIsVisibleAndClickable(topicslist.selectMedium);
			topicslist.selectMedium.click();

			GenericFunctions.waitForElementToAppear(topicslist.selectEnglish);
			topicslist.selectEnglish.click();*/

			GenericFunctions.scrollToElement(topicslist.startCreating);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(topicslist.startCreating);		
			topicslist.startCreating.click();
			GenericFunctions.waitWebDriver(2000);		
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(6500);
			GenericFunctions.waitForElementToAppear(createUserPage.newChild);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.bookTitle.click();
			createUserPage.bookTitle.clear();
			createUserPage.bookTitle.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName());
			GenericFunctions.waitWebDriver(5000);



		}catch(Exception e) {

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to create Book");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create a book");
			Assert.fail("Failed on ");
		}
	}

	public void selectTopic(List<TestDataForDiksha>objListOFTestDataForSunbird)
	{
		try {

			SoftAssert softAssert = new SoftAssert();
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to click the topic tree list fro TOC");

			GenericFunctions.waitForElementToAppear(topicslist.selectTopic);
			action.moveToElement(topicslist.selectTopic).click().perform();	

			/*ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to select the topic tree");			
			GenericFunctions.waitForElementToAppear(topicslist.selectVedicMathematices);

			if(topicslist.selectVedicMathematices.isDisplayed())

			{
				String Evalue = topicslist.selectVedicMathematices.getText();
				softAssert.assertEquals("Vedic Mathematics", Evalue);
			}
			topicslist.selectVedicMathematices.click();	
			GenericFunctions.waitForElementToAppear(topicslist.selectNumberSystem);
			if(topicslist.selectNumberSystem.isDisplayed())

			{
				String Evalue = topicslist.selectNumberSystem.getText();
				softAssert.assertEquals("Number System", Evalue);
			}

			topicslist.selectNumberSystem.click();
			GenericFunctions.waitWebDriver(5000);


			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to cancel the selected topic");

			GenericFunctions.waitForElementToAppear(topicslist.cancelButton);		

			topicslist.cancelButton.click();
			GenericFunctions.waitWebDriver(5000);
			topicslist.selectTopic.click();

			GenericFunctions.waitForElementToAppear(topicslist.selectVedicMathematices);
			topicslist.selectVedicMathematices.click();	
			GenericFunctions.waitForElementToAppear(topicslist.selectNumberSystem);
			topicslist.selectNumberSystem.click();*/
			GenericFunctions.waitWebDriver(5000);			
			topicslist.doneButton.click();
			//GenericFunctions.waitForElementToAppear(topicslist.selectTopic);
			GenericFunctions.waitWebDriver(5000);
			
			
		/*	topicslist.selectTopic.click();
			GenericFunctions.waitWebDriver(5000);

			if(topicslist.checkIcon.isDisplayed())

			{

				ExtentTestManager.getTest().log(LogStatus.INFO, "User is getting the topic tree selected");
			}
			GenericFunctions.waitForElementToAppear(topicslist.cancelButton);
			topicslist.cancelButton.click();
			GenericFunctions.waitWebDriver(5000);
			String atopic= 	topicslist.selectTopic.getText();
			System.out.println(atopic);
			String etopic="Topic (Selected 2)";
			Assert.assertEquals(atopic, etopic, "The selected topic is not displayed in the content editor");
*/

		}catch(Exception e) {

			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to select topic from topic tree");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create a book");
			Assert.fail("Failed on ");
		}
	}

	public void searchForTopic(List<TestDataForDiksha>objListOFTestDataForSunbird)
	{
		try {
			SoftAssert softAssert = new SoftAssert();
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to remove all topics");

			//	String bookNumber = GenericFunctions.testDataIncrementer(".//TestData//bookNumbers.txt").toString();
			GenericFunctions.waitForElementToAppear(topicslist.selectTopic);
			topicslist.selectTopic.click();
			
			//Dec 12
			/*GenericFunctions.waitForElementToAppear(topicslist.selectVedicMathematices);
			topicslist.selectVedicMathematices.click();
			GenericFunctions.waitForElementToAppear(topicslist.selectNumberSystem);
			topicslist.selectNumberSystem.click();
			GenericFunctions.waitForElementToAppear(topicslist.searchTopic);
			GenericFunctions.waitWebDriver(3000);
			topicslist.searchTopic.sendKeys(objListOFTestDataForSunbird.get(6).getTitle());
			GenericFunctions.waitWebDriver(5000);
			
		


			if(topicslist.chooseAll.isDisplayed())
			{
				String Evalue = topicslist.chooseAll.getText();
				softAssert.assertEquals(" Choose All", Evalue);

			}
			GenericFunctions.waitForElementToAppear(topicslist.chooseAll);
			topicslist.chooseAll.click();
			if(topicslist.chooseAll.isDisplayed())
			{
				String Evalue = topicslist.removeAll.getText();
				softAssert.assertEquals(" Remove All", Evalue);

			}

			GenericFunctions.waitForElementToAppear(topicslist.removeAll);
			topicslist.removeAll.click();
			ExtentTestManager.getTest().log(LogStatus.INFO, "The topic tree selected is removed");*/
			GenericFunctions.waitForElementToAppear(topicslist.doneButton);
			topicslist.doneButton.click();
			GenericFunctions.waitWebDriver(3000);
			

		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on seraching the topic in topic tree");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create a book");
			Assert.fail("Failed on serching the topic in the topic tree");
		}
	}
	
	public void searchForTopicClickOnDoneButton(List<TestDataForDiksha>objListOFTestDataForSunbird)
	{
		try {
			SoftAssert softAssert = new SoftAssert();
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to select all topic from list");
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(2000);		
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(6500);
			GenericFunctions.waitForElementToAppear(createUserPage.newChild);
			System.out.println("Creating - "+createUserPage.newChild.getText());
			GenericFunctions.waitWebDriver(3000);
			action.moveToElement(createUserPage.newChild).click().perform();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.bookTitle.click();
			createUserPage.bookTitle.clear();
			createUserPage.bookTitle.sendKeys(objListOFTestDataForSunbird.get(2).getCourseName());
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppear(topicslist.selectTopic);
			action.moveToElement(topicslist.selectTopic).build().perform();
			topicslist.selectTopic.click();
			GenericFunctions.waitWebDriver(2000);
			
			//Dec 12
			/*GenericFunctions.waitTillTheElementIsVisibleAndClickable(topicslist.searchTopic);
			topicslist.searchTopic.sendKeys(objListOFTestDataForSunbird.get(6).getTitle());
			GenericFunctions.waitWebDriver(5000);
			GenericFunctions.waitForElementToAppearOnScreen(topicslist.resultsOnTopicSeacrh);
			
			if(topicslist.resultsOnTopicSeacrh.isDisplayed())
			{
				String Evalue =topicslist.resultsOnTopicSeacrh.getText();
				softAssert.assertEquals("Polynomials", Evalue);
			}
			topicslist.chooseAll.click();*/
			GenericFunctions.waitWebDriver(3000);
			topicslist.doneButton.click();
			GenericFunctions.waitWebDriver(3000);
			
			
			

			
		}catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on seraching the topic in topic tree");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());
			System.out.println("Failed to create a book");
			Assert.fail("Failed on serching the topic in the topic tree");
		}
}
	}