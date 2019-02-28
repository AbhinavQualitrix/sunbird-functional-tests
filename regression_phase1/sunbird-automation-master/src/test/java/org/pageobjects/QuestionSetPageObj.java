package org.pageobjects;

import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.generic.AllUploadingPaths;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.ContentCreationResourcePage;
import org.page.CreateMentorPage;
import org.page.CreatorUserPage;
import org.page.PublicUserPage;
import org.page.QuestionSetPage;

import org.page.UploadOrgPage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;


import com.relevantcodes.extentreports.LogStatus;

public class QuestionSetPageObj extends BaseTest{
	
	WebDriverWait wait = new WebDriverWait(driver,20);
	QuestionSetPage questionSetPage=PageFactory.initElements(driver, QuestionSetPage.class);
	static Logger log = Logger.getLogger(CreatorUserPage.class.getName());
	List <TestDataForDiksha> objListOFTestDataForSunbird1= null ;
	Actions action = new Actions(driver);
	Random rand=new Random();
	AllUploadingPaths allPaths= new AllUploadingPaths();
	String lessonNumber;
	String title="";

	
		public void createresource(List <TestDataForDiksha> objListOFTestDataForSunbird) throws Exception
		
		{
			try
				{
				ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to create resource with different question sets");
				GenericFunctions.waitWebDriver(1500);
				//GenericFunctions.waitForElementToAppear(QuestionSetPageObj.bookName);
				String resourceNumber = GenericFunctions.testDataIncrementer(".//testData//resourceNumbers.txt").toString();
				questionSetPage.bookName.sendKeys(objListOFTestDataForSunbird.get(6).getCourseName()+resourceNumber);
				 				
				questionSetPage.startCreating.click();
				GenericFunctions.waitWebDriver(5000);
				
				driver.switchTo().frame(0);
				GenericFunctions.waitForElementToAppear(questionSetPage.addQuestionSet);
				questionSetPage.addQuestionSet.click(); 	
				GenericFunctions.waitWebDriver(2000);
				
				questionSetPage.createQuestion.click();
				
				
				if(questionSetPage.MTF.isDisplayed())
				{
					questionSetPage.MTF.click();
					GenericFunctions.waitWebDriver(2000);
					Assert.assertTrue(true," MTF Clicked");
					System.out.println("MTF got Clicked");
					log.info(" MTF got Selected");
				}
				else
				{
					System.out.println("MTF didn't get Clicked");
					log.info("Not able to Click MTF");
				}

				questionSetPage.Back.click();
				GenericFunctions.waitWebDriver(2000);

				
				
				if(questionSetPage.MCQ.isDisplayed())
				{
					questionSetPage.MCQ.click();
					GenericFunctions.waitWebDriver(2000);
					Assert.assertTrue(true," MCQ Selected");
					System.out.println("MCQ got Selected");
					log.info(" MCQ got Selected");
				}
				else
				{
					log.info("Not ablet to Select MCQ");
				}

				questionSetPage.Back.click();
				GenericFunctions.waitWebDriver(2000);

				
				
				if(questionSetPage.FTB.isDisplayed())
				{
					questionSetPage.FTB.click();
					GenericFunctions.waitWebDriver(2000);	
					Assert.assertTrue(true," FTB Selected");
					System.out.println("FTB got Selected");
					log.info(" FTB got Selected");
				}
				else
				{
					log.info("Not ablet to Select FTB");
				}
		  }
		
		  catch(Exception e)
		  {
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to Select MTF,MCQ,FTB ");
				ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: " + e.getLocalizedMessage());
				log.error("Exception In the method createresource" + e.getLocalizedMessage());
				Assert.fail("Failed to Select MTF,MCQ,FTB " + e.getLocalizedMessage());
		   }

	}
}
	
	
	

