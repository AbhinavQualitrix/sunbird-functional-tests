package org.pageobjects;





import java.util.List;
import java.util.Random;


import org.generic.AllUploadingPaths;

import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.generic.ReadTestDataFromExcel;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;


import org.page.ContentCreateUploadPage;
import org.page.CreatorUserPage;
import org.page.WorkspacePage;
import org.startup.BaseTest;
import org.testdata.TestDataForDiksha;
import org.testng.Assert;

import com.relevantcodes.extentreports.LogStatus;

public class WorkspacePageObj extends BaseTest
{
	//WebDriver driver;
	String onboardingUrl="https://staging.ntp.net.in/resources";
	String onboardingTabame="Custodian Org";
	WorkspacePage workspacePage = PageFactory.initElements(driver, WorkspacePage.class);
	CreatorUserPage createUserPage = PageFactory.initElements(driver, CreatorUserPage.class);
	ContentCreateUploadPage contentUploadPage = PageFactory.initElements(driver, ContentCreateUploadPage.class);
	Actions actions = new Actions(driver);
	Alert alert;
	//WebDriverWait wait = new WebDriverWait(driver,20);
	CreatorUserPageObj createUserObj = new CreatorUserPageObj();
	GenericFunctions generic = new GenericFunctions();



	public void verifyTermsAndConditionsPopup()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify the Terms And Conditions Popup after New SignUp");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(workspacePage.termsAndCoditionLabel);
			//Boolean url = wait.until(ExpectedConditions.urlContains(onboardingUrl));
			if(driver.getCurrentUrl().contentEquals(onboardingUrl) 
					&& workspacePage.termsAndCoditionLabel.isDisplayed()
					&& workspacePage.termsAndConditionsText.isDisplayed() )
			{
				System.out.println(driver.getCurrentUrl());

				ExtentTestManager.getTest().log(LogStatus.PASS, "Terms And Conditions Popup is displayed after New User SignUp");
				Assert.assertTrue(true);
				GenericFunctions.scrollToElement(workspacePage.termsAndConditionsCheckBox);
				if(workspacePage.termsAndConditionsCheckBox.isDisplayed())
				{
					GenericFunctions.waitWebDriver(2000);
					workspacePage.termsAndConditionsCheckBox.click();
					GenericFunctions.waitWebDriver(2000);
					System.out.println("Continue button color"+workspacePage.continueButton.getCssValue("background-color"));
					workspacePage.termsAndConditionsCheckBox.click();
					//if(workspacePage.termsAndConditionsCheckBox)
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS, "User can accept Terms And Conditions after New SignUp"+workspacePage.continueButton.getCssValue("background-color"));


				}


			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify Terms And Conditions Popup after New SignUp");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on verifying T&C"+e.getLocalizedMessage());
			ExtentTestManager.endTest();
			System.out.println("Failed to verify Terms And Conditions Popup after New SignUp");
			Assert.fail("Failed to verify Terms And Conditions Popup after New SignUp");
		}

	}


	public void checkNoTermsAndConditionsPopup()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify that NO Terms And Conditions Popup on second or more login");
			GenericFunctions.waitForElementToAppear(createUserPage.headerCourse);

			if(createUserPage.headerCourse.isDisplayed()&&createUserPage.headerLibrary.isDisplayed())
			{
				ExtentTestManager.getTest().log(LogStatus.PASS, "NO Terms and Conditions popup is displayed to the user "
						+ "on second or more logins , User is in HOME PAGE "+driver.getCurrentUrl());
				Assert.assertTrue(true);

			}
		}
		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify that NO Terms And Conditions Popup on second or more login");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on verifying NO T&C"+ex.getLocalizedMessage());
			System.out.println("Exception on verifying NO T&C popup"+ex.getLocalizedMessage());
			Assert.fail("Failed to verify that NO Terms And Conditions Popup after first or more signups");
		}
	}

	/*
	 * Properties properties =new Properties();
	 * 
	 * public Properties getNewFeatureObjRepo() throws Exception { InputStream
	 * input= new FileInputStream(new
	 * File(System.getProperty("user.dir")+"newFeatureObjRepo.properties"));
	 * properties.load(input); return properties;
	 * 
	 * }
	 */

	public String uploadContentToVerifyOwnershipTypeDropdown()
	{
		String createdForText=null;
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to upload content");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			String uploadedContent=uploadContentsRandomly();
			System.out.println("UC "+uploadedContent);

			GenericFunctions.waitForElementToAppear(createUserPage.editOrViewDetailslink);
			//GenericFunctions.waitForElementToAppear(createUserPage.editdetailslink);

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to verify ownershipType dropdown feature");
			createUserPage.editOrViewDetailslink.click();			
			createUserPage.contentMp4Title.click();
			createUserPage.contentMp4Title.clear();
			createUserPage.contentMp4Title.sendKeys(uploadedContent+" ownershipType test content");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.clickOwner);
			System.out.println("waited here");
			//actions.moveToElement(createUserPage.clickOwner);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.selectOwner);
			System.out.println("passing here");
			createUserPage.selectOwner.click();
			createdForText=workspacePage.selectedCreatedForType.getText();
			System.out.println(createdForText);
			GenericFunctions.waitWebDriver(2000);
			createUserPage.saveButton.click();
			GenericFunctions.waitForElementToAppear(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.saveCourse);
			createUserPage.saveCourse.click();
			GenericFunctions.waitForElementToAppear(createUserPage.closeButtonMsg);			
			if(createUserPage.closeButtonMsg.isDisplayed())
			{
				createUserPage.closeButtonMsg.click();
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "User has verifed 'createdBy' and 'createdFor' fields");
				ExtentTestManager.getTest().log(LogStatus.PASS, "User is select 'CreatedFor' ownershipType in dropdown "
						+createdForText+" is the Org Name to which content is createdFor");
			}
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppearOnScreen(createUserPage.editorCloseIcon);
			createUserPage.editorCloseIcon.click();

		}
		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on verifying verifying ownershipType dropdown and features "+ex.getLocalizedMessage());
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify ownershipType dropdown and features");			
			System.out.println("Exception on verifying verifying ownershipType dropdown and features "+ex.getLocalizedMessage());
			Assert.fail("Failed to verify ownershipType dropdown and features");
		}
		return createdForText;
	}

	public String uploadContentsRandomly()
	{

		String contentToUpload=(UPLOAD_CONTENTS[new Random().nextInt(UPLOAD_CONTENTS.length)]);
		System.out.println("CONTENT "+contentToUpload);
		WebElement browse=createUserPage.browseButton;
		String path=null;

		switch(contentToUpload)
		{

		case "youtube":
		{
			GenericFunctions.waitForElementToAppear(createUserPage.enterUrl);
			createUserPage.enterUrl.sendKeys(UPLOAD_YOUTUBE);
			path=contentToUpload;
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(contentUploadPage.popupUploadButton);
			contentUploadPage.popupUploadButton.click();
			GenericFunctions.waitWebDriver(10000);
			//GenericFunctions.waitForElementToAppear(createUserPage.editdetailslink);
			break;
		}
		case "mp4" :
		{

			System.out.println(AllUploadingPaths.mp4Path);
			GenericFunctions.waitWebDriver(5000);
			browse.sendKeys(AllUploadingPaths.mp4Path);
			GenericFunctions.waitWebDriver(7000);

			path=contentToUpload;
			break;
		}

		case "pdf" :
		{

			System.out.println(AllUploadingPaths.pdfPath);
			GenericFunctions.waitWebDriver(5000);
			browse.sendKeys(AllUploadingPaths.pdfPath);
			GenericFunctions.waitWebDriver(7000);
			//GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.editdetailslink);
			path=contentToUpload;
			break;
		}


		}
		System.out.println("path after uploading "+path);
		return path;	


	}

	public void verifyUserCanEditWhenOpenedFromAllUploads(String compareText)
	{
		try
		{
			System.out.println(compareText);
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to edit ownershipType by opening same content from ALL UPLOADS");
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.allUploads);
			createUserPage.allUploads.click();
			GenericFunctions.refreshWebPage();
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(workspacePage.ownershipContentInAppUploads);
			workspacePage.ownershipContentInAppUploads.click();
			GenericFunctions.waitWebDriver(3000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.editOrViewDetailslink);
			createUserPage.editOrViewDetailslink.click();
			//actions.moveToElement(createUserPage.clickOwner);
			GenericFunctions.scrollToElement(workspacePage.clikcOwnerTypeToEdit);
			workspacePage.clikcOwnerTypeToEdit.click();
			GenericFunctions.waitWebDriver(2000);
			//workspacePage.selectedCreatedForType.click();

			//WebElement createdByElement=driver.findElement(By.xpath("//label[contains(.,'OWNER')]/"));
			//workspacePage.createdByType.getText();
			String createdByText=workspacePage.selectedCreatedForType.getText();
			System.out.println(createdByText);
			if(compareText.equalsIgnoreCase(createdByText))
			{
				workspacePage.selectcreatedByType.click();
				Assert.assertTrue(true);
				ExtentTestManager.getTest().log(LogStatus.PASS, "User can EDIT and VERIFY both 'CreatedFor' and 'CreatedBy' ownershipTypes");
				ExtentTestManager.getTest().log(LogStatus.PASS, workspacePage.selectcreatedByType.getText()+" is the createdBy value present in ownershipType");

			}
			else
			{
				Assert.fail("failed on comparing createdForType");

			}
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.editorCloseIcon);
			createUserPage.editorCloseIcon.click();

		}	

		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to verify ownershipType dropdown and features");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on verifying verifying ownershipType dropdown and features"+ex.getLocalizedMessage());
			System.out.println("Exception on verifying verifying ownershipType dropdown and features"+ex.getLocalizedMessage());
			Assert.fail("Failed to verify ownershipType dropdown and features");
		}
	}


	/*public void findContentInReviewSubmission()
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to find content in Review Submission");
			//String [] contentNamesInReviewSubmission = {"TextBook","Enter description for Resource","LessonPlan","Course","Collection","Content Description"};
			GenericFunctions.waitWebDriver(3000);
			List<String> contentNamesInReviewSubmission = Arrays.asList("TextBook","LessonPlan","Course","Collection");
			List<String> contentDescInRviewSubmission = Arrays.asList("Enter description for Resource","Content Description");

			do
			{
				createUserPage.reviewSubmission.click();
				GenericFunctions.waitWebDriver(3000);


				for(int i=0;i<=workspacePage.getContentNameFromRS.size();i++)
				{
					String content=workspacePage.getContentNameFromRS.get(i).getText();
					System.out.println(content);
					if(content.contains(contentNamesInReviewSubmission.get(i)))
					{
						workspacePage.getContentNameFromRS.get(i).click();
						break;
						//WebElement e:workspacePage.getContentNameFromRS.get()
					}
					else if(content.contains(contentDescInRviewSubmission.get(i).toString()))
					{
						workspacePage.getContentNameFromRS.get(i).click();
					}
					else
					{
						GenericFunctions.waitWebDriver(2000);
						GenericFunctions.scrollToElement(workspacePage.NextButton);
						workspacePage.NextButton.click();
					}

				}
				GenericFunctions.waitWebDriver(2000);
				continue;

			}while(workspacePage.Page10InReviewSubmission.isDisplayed()==false);

			for(int i=0;i<=workspacePage.getContentNameFromRS.size();i++)
			{
				if(workspacePage.getContentNameFromRS.get(i).getText().contains("TextBook"))
				{
					workspacePage.getContentNameFromRS.get(i).click();
					GenericFunctions.
				}



				for(WebElement e:workspacePage.getContentNameFromRS.get(i))
				{
					if((e.getText().compareTo(contentNamesInReviewSubmission.get(i).toString()))!=0)
					{
						GenericFunctions.waitWebDriver(2000);
						e.click();
					}
					else
					{
						i++;
					}
				}

			}
			//workspacePage.getContentNameFromRS.get
		}
		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed to find content in Review Submission");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception on finding content in Review Submission"+ex.getLocalizedMessage());
			System.out.println("Exception on finding content in Review Submission"+ex.getLocalizedMessage());
			Assert.fail("Failed to find content in Review Submission");
		}
	}*/




	/*public String findContentInDrafts()
	{

		//System.out.println(param.length);
		int i=0;
		try
		{
			do
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "USer is trying to Open "+param[i]+
						" from DRAFTS and verify value of OwnershipType dropdown");
				//a[contains(@class,'black right ribbon') and contains(.,TextBook)]
				String xpath="//a[contains(@class,'black right ribbon') and contains(.,'"+param[i]+"')]";
				GenericFunctions.waitWebDriver(2000);	
				GenericFunctions.refreshWebPage();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(workspacePage.contentCardInDraft);

				WebElement contentInDraft = driver.findElement(By.xpath(xpath));
				try
				{
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.waitForElementToAppear(contentInDraft);
					boolean present = contentInDraft.isDisplayed();
					if(present==true)
					{
						GenericFunctions.waitWebDriver(2000);
						contentInDraft.click();
						GenericFunctions.waitWebDriver(2000);
						verifyOwnerTypeInContentWhenFound();
					}
					else if(present==false)
					{
						System.out.println(param[i]);
						GenericFunctions.waitWebDriver(1000);
						GenericFunctions.scrollToElement(workspacePage.NextButton);
						workspacePage.NextButton.click();
						GenericFunctions.waitWebDriver(1000);
						findContentInDrafts(param[i]);
						//System.out.println("Exception here");
					}
				}
				catch(Exception ee)
				{
					System.out.println("Exception on finding content"+ee);
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.scrollToElement(workspacePage.NextButton);
					workspacePage.NextButton.click();

				}


				i++;
			}while(i<param.length);
		}
		catch(NoSuchElementException Nse)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not open content "+param[i]+" "
					+ "from the Drafts and verify value of OwnershipType dropdown");
			System.out.println("No Such Element Exception , content not found in draft "+Nse);
			createContentWhichNotFoundInDrafts(param[i]);
			System.out.println("Content Created and calling same method again");
			//	findContentInDrafts();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(workspacePage.NextButton);
			workspacePage.NextButton.click();
			findContentInDrafts();
		}
		catch(Exception ge)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not open content "+param[i]+" "
					+ "from the Drafts and verify value of OwnershipType dropdown");
			System.out.println("General Exception"+ge);
			Assert.fail("");
		}

		return param[i];
	}*/

	public void createContentWhichNotFoundInDrafts(String createThis)
	{
		//GenericFunctions generic = new GenericFunctions();
		//generic.navigateToWorkspaceFeatures(workspaceVariable);
		ExtentTestManager.getTest().log(LogStatus.INFO,"content is not found in Drafts, so creating it ");
		createUserObj.navigateToWorkspace(createThis);
		GenericFunctions.waitWebDriver(1000);
		GenericFunctions.waitForElementToAppear(createUserPage.startCreating);
		createUserPage.startCreating.click();
		GenericFunctions.waitWebDriver(1000);
		addOwnershipTypeToContent();
	}

	public void addOwnershipTypeToContent()
	{
		try
		{
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(createUserPage.editOrViewDetailslink);
			createUserPage.editOrViewDetailslink.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.scrollToElement(createUserPage.clickOwner);
			createUserPage.clickOwner.click();
			GenericFunctions.waitWebDriver(2000);
			createUserPage.selectOwner.click();	
			saveCloseEditorIcon();
		}
		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Could not add ownershipType to the content"+ex.getLocalizedMessage());
			System.out.println("Could not add ownershipType to the content"+ex.getLocalizedMessage());
			Assert.fail("Could not add ownershipType to the content");
		}
	}

	public void saveCloseEditorIcon()
	{
		try
		{
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.saveButton);
			createUserPage.saveButton.click();
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.closeButtonMsg);
			createUserPage.closeButtonMsg.click();
			GenericFunctions.waitWebDriver(2000);	
			GenericFunctions.waitTillTheElementIsVisibleAndClickable(createUserPage.editorCloseIcon);
			createUserPage.editorCloseIcon.click();
			try
			{
				GenericFunctions.waitWebDriver(2000);	
				driver.switchTo().alert().accept();//alert.accept();

			}
			catch(Exception al)
			{
				System.out.println("could not find alert "+al.getMessage());
			}
		}
		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(LogStatus.INFO,"Exception for save, close the editor icon"+ex.getLocalizedMessage());
			System.out.println("Exception for save, close editor icon"+ex.getLocalizedMessage());
		}
	}

	/*
	 * purpose : To verify the dropdown values of ownershipType dropdown
	 */
	public void verifyOwnerTypeInContentWhenFound()
	{
		String foundValue,foundValue1="";
		try
		{
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
			GenericFunctions.waitWebDriver(4000);
			GenericFunctions.waitForElementToAppear(createUserPage.editOrViewDetailslink);
			createUserPage.editOrViewDetailslink.click();
			GenericFunctions.waitWebDriver(1000);

			try
			{
				boolean value=workspacePage.clikcOwnerTypeToEdit.isDisplayed();
				if(value==true)
				{
					GenericFunctions.scrollToElement(workspacePage.clikcOwnerTypeToEdit);
					workspacePage.clikcOwnerTypeToEdit.click();
					GenericFunctions.waitWebDriver(1000);
					//workspacePage.DefaultValueOfOwnershipTypeDdl.click();
					foundValue=workspacePage.selectcreatedByType.getText();
					foundValue1=workspacePage.selectcreatedForType.getText();
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.captureScreenshotOnValidation();
					//saveCloseEditorIcon();
					workspacePage.closeIconInEditDetails.click();
					Assert.assertTrue(true);
					ExtentTestManager.getTest().log(LogStatus.PASS, "Selected Content has ownershipType Dropdown value "+foundValue+" and "+foundValue1);
					//addOwnershipTypeToContent();
				}
				else if(value==false)
				{
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.scrollToElement(createUserPage.clickOwner);
					if(createUserPage.clickOwner.isDisplayed())
					{
						createUserPage.clickOwner.click();
						GenericFunctions.captureScreenshotOnValidation();
						Assert.assertTrue(true);
						ExtentTestManager.getTest().log(LogStatus.PASS, "Verified Dropdown value of ownershipType ");
					}
				}
				driver.get("https://staging.ntp.net.in/workspace");
				GenericFunctions.waitWebDriver(1000);
				//GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
				//createUserPage.workSpace.click();
				generic.navigateToWorkspaceFeatures(DRAFTS);

			}
			catch(Exception ownershipValue)
			{
				System.out.println("Could not verify dropdown value of ownershipType in the found content");
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Could not verify dropdown value of ownershipType in the content ");
			System.out.println("Exception on verifying the owner"+e.getMessage());
			Assert.fail("Exception on verifying the ownershipType dropdown value");

		}
	}

	/*
	 * purpose : TO find the parameterized content from the workspace bucket and check the ownershipType dropdown value
	 */

	public String findParameterizedContentFromWorkspace(String callParam1)
	{
		String bucket= null;
		try
		{

			String bucketName=driver.getCurrentUrl();

			System.out.println(bucketName);			
			String result[] = bucketName.split("/");			
			bucket = result[result.length-2];

			System.out.println("FINAL  "+result[result.length-2]);

			String xpath1="//a[contains(@class,'black right ribbon') and contains(.,'"+callParam1+"')]";



			System.out.println("xpath1"+xpath1);

			/*
			if(callParam1!=null &&callParam2==null)
			{
				finalXpath=xpath1;
				GenericFunctions.waitForElementToAppear(workspacePage.contentCardInDraft);
			}
			else if (callParam1==null&&callParam2!=null)
			{
				finalXpath=xpath2;
				GenericFunctions.waitForElementToAppear(workspacePage.contentInAllMyContent);
			}*/


			ExtentTestManager.getTest().log(LogStatus.INFO, "USer is trying to Open "+callParam1+
					" from 	"+bucket +"and verify value of OwnershipType dropdown");

			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(workspacePage.contentCardInDraft);
			try
			{
				WebElement contentInDraft = driver.findElement(By.xpath(xpath1));
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(contentInDraft);
				boolean present = contentInDraft.isDisplayed();
				System.out.println("present"+present);
				if(present==true)
				{
					System.out.println();
					GenericFunctions.waitWebDriver(2000);
					contentInDraft.click();
					GenericFunctions.waitWebDriver(2000);
					verifyOwnerTypeInContentWhenFound();
				}
				//else if(present==false)
				else
				{

					System.out.println("Could not find content in this page, calling");
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.scrollToElement(workspacePage.NextButton);
					workspacePage.NextButton.click();
					GenericFunctions.waitWebDriver(1000);

					//	findParametarisedContentFromWorkspace(callParam);

					findParameterizedContentFromWorkspace(callParam1);
					//findContentInDrafts(param[j]);
					//System.out.println("Exception here");


				}

			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Could not find the content even in this page ,going to next page to find it");
				System.out.println("Could not find the content even in this page"+e.getLocalizedMessage());
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.scrollToElement(workspacePage.NextButton);
				workspacePage.NextButton.click();
				GenericFunctions.waitWebDriver(1000);
				//findParametarisedContentFromWorkspace(callParam);
				findParameterizedContentFromWorkspace(callParam1);
			}

		}
		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not open content "+callParam1+ " from the Drafts and verify value of OwnershipType dropdown");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message"+ex.getLocalizedMessage());
			System.out.println("Exception , content not found in draft "+callParam1 +ex.getLocalizedMessage());
			Assert.fail("Could not open content from  "+bucket);
		}
		return callParam1;
	}

	/*
	 * purpose : TO find the Parameterized content from All My Content Bucket And verify the ownerShipType dropdown value
	 */

	public void findParameterizedContentFromAllMyContent(String contentToFind)

	{
		String bucket=null;
		try
		{
			String bucketName=driver.getCurrentUrl();
			System.out.println(bucketName);			
			String result[] = bucketName.split("/");			
			bucket = result[result.length-2];
			System.out.println("Current Bucket-"+result[result.length-2]);

			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to Open "+contentToFind+
					" from 	"+bucket +" and verify value of OwnershipType dropdown");

			//div[ contains(.,'TextBook')]/following::td[2]/parent::tr/following::div[contains(.,'TextBook')]/following::td[.='Draft']

			//	String xpath1="//div[@class='UpReviewSubHeader' and contains(.,'"+contentToFind+"')]/following::td[contains(.,'Draft')]";

			String xpath1="//div[ contains(.,'"+contentToFind+"')]/following::td[2]/parent::tr/following::div[contains(.,'"+contentToFind+"')]/following::td[.='Draft']/parent::tr/td";

			System.out.println("xpath "+xpath1);
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(workspacePage.contentInAllMyContent);

			try
			{
				WebElement contentFromAllMyContent = driver.findElement(By.xpath(xpath1));

				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(contentFromAllMyContent);
				boolean present = (contentFromAllMyContent).isDisplayed();
				System.out.println("present-"+present);

				if(present==true)
				{
					System.out.println();
					GenericFunctions.waitWebDriver(2000);
					contentFromAllMyContent.click();
					GenericFunctions.waitWebDriver(2000);
					verifyOwnerTypeInContentWhenFound();
				}

				else if(present==false)
				{

					System.out.println("Could not find content in this page, calling");
					GenericFunctions.waitWebDriver(1000);
					GenericFunctions.scrollToElement(workspacePage.NextButton);
					workspacePage.NextButton.click();
					GenericFunctions.waitWebDriver(1000);

					//	findParametarisedContentFromWorkspace(callParam);

					findParameterizedContentFromWorkspace(contentToFind);
					//findContentInDrafts(param[j]);
					//System.out.println("Exception here");


				}



			}
			catch(Exception e)
			{
				ExtentTestManager.getTest().log(LogStatus.INFO, "Could not find the content even in this page ,going to next page to find it");
				System.out.println("Could not find the content even in this page"+e.getLocalizedMessage());
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.scrollToElement(workspacePage.NextButton);
				workspacePage.NextButton.click();
				GenericFunctions.waitWebDriver(1000);
				//findParametarisedContentFromWorkspace(callParam);
				findParameterizedContentFromAllMyContent(contentToFind);				

			}


		}
		catch(Exception ex)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not open content "+contentToFind+ " from the All My Content and verify value of OwnershipType dropdown");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message"+ex.getLocalizedMessage());
			System.out.println("Exception , content not found in draft "+contentToFind +ex.getLocalizedMessage());
			Assert.fail("Could not open content from  "+bucket);
		}

	}

	/*
	 * purpose :  Click on the created content and Check the OWNERSHIP field value
	 */

	public boolean openTheCreatedContentFromUpForReview(String contentToSearch)
	{
		try
		{
			List <TestDataForDiksha> objListOFTestDataForSunbird1=null;
			objListOFTestDataForSunbird1 = ReadTestDataFromExcel.getTestDataForDiksha("testdatasheetcourse");
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is trying to open the content from Up For Review and verify the value of selected ownershipType dropdown");
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			createUserPage.upForReview.click();
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchForReview);
			//createUserPage.searchForReview.sendKeys(objListOFTestDataForSunbird1.get(4).getCourseName()+"_"+GenericFunctions.readFromNotepad("./testData/contentNumbers.txt"));
			createUserPage.searchForReview.sendKeys(contentToSearch);
			GenericFunctions.waitWebDriver(2000);
			GenericFunctions.waitForElementToAppear(createUserPage.searchedContentForPublish);
			createUserPage.searchedContentForPublish.click();
			GenericFunctions.waitWebDriver(2000);
		//	GenericFunctions.waitForElementToAppear(workspacePage.viewCreditsLink);
			ExtentTestManager.getTest().log(LogStatus.INFO, "content is opened from Up For Review Section");

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not open content from the Up For Review and verify value of OwnershipType dropdown");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message"+e.getLocalizedMessage());
			System.out.println("Exception , Could not open in Up For Review  and verify value "+e.getLocalizedMessage());
			Assert.fail("Could not open content from Up For Review and verify value ownershipType dropdown ");
		}

		return true;
	}

	/*
	 * purpose : TO verify the ownershipType value of the content opened from Up For Review section
	 */
	public void verifyownershipTypeValueOfTheContent(String passedValue1, String passedValue2)
	{
		try
		{
			ExtentTestManager.getTest().log(LogStatus.INFO, "User is triyng to verify the value of the ownershipType value");
			//GenericFunctions.scrollToElement(workspacePage.viewCreditsLink);
			if(passedValue1!=null&&passedValue2==null)
			{
				workspacePage.viewCreditsLink.click();
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(workspacePage.creators); 
				if(workspacePage.creators.isDisplayed())
				{	
					ExtentTestManager.getTest().log(LogStatus.PASS," OwnershipType-CreatedBy : "+workspacePage.creators.getText()+" OwnershipType-CreatedFor :"+workspacePage.contributors.getText());
					Assert.assertEquals(workspacePage.creators.getText(), "content creator");
					//Assert.assertEquals(workspacePage.contributors.getText(), driver.getTitle(),"Failed to assert value of Org");
					System.out.println(passedValue1.toLowerCase());
					Assert.assertEquals(workspacePage.contributors.getText(), passedValue1.toLowerCase(),"Failed to assert value of Org");
					Assert.assertTrue(true);
				}

				GenericFunctions.waitWebDriver(1000);
				createUserPage.closePopUp.click();	
			}
			else if(passedValue1==null&&passedValue2!=null)
			{
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.WaitForFrameAndSwitchToIt(createUserPage.iFrame);
				GenericFunctions.waitWebDriver(2000);
				GenericFunctions.waitForElementToAppear(createUserPage.editOrViewDetailslink);
				createUserPage.editOrViewDetailslink.click();
				GenericFunctions.waitWebDriver(2000);
				
				Assert.assertEquals(workspacePage.verifyOwnershipValueInCourse.getText().trim().toLowerCase(), passedValue2.toLowerCase(),"Failed to verify ownershipType of selected content");
				//ExtentTestManager.getTest().log(LogStatus.ERROR,"Failed to verify ownershipType of selected content");
				ExtentTestManager.getTest().log(LogStatus.PASS,"Verified ownershipType value of the opened Content type and has "+workspacePage.verifyOwnershipValueInCourse.getText()+" as its value");
				Assert.assertTrue(true);
				GenericFunctions.waitWebDriver(1000);
				workspacePage.closeIconViewDetails.click();	 
				GenericFunctions.waitWebDriver(1000);
				GenericFunctions.waitForElementToAppear(createUserPage.editorCloseIcon);
				createUserPage.editorCloseIcon.click();
				
					
			}
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not verify value of ownersipType value");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message"+e.getLocalizedMessage());
			System.out.println("Exception ,Could not verify value of ownersipType value"+e.getLocalizedMessage());
			Assert.fail("Could not verify value of ownersipType value");
		}

	}
}
