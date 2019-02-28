package org.page;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class WorkspacePage 
{
	//WebDriver driver;

	//Properties properties =new Properties();

	/*
	public WorkspacePage(WebDriver driver){
		this.driver = driver;
	}



	public Properties getNewFeatureObjRepo() throws Exception
	{
		InputStream input= new FileInputStream(new File(System.getProperty("user.dir")+"newFeatureObjRepo.properties"));
		properties.load(input);

		//return properties;


		String prope = properties.getProperty("termsAndConditionsPageLabel");
		@FindBy(xpath="prope")
		public WebElement 
	}

	 */

	@FindBy(xpath="//div/img[contains(@src,'logo.png')]/following::div[contains(.,'Terms and Conditions')]")
	public WebElement termsAndCoditionLabel;

	
	@FindBy(xpath="//span[contains(.,'I agree to the terms and conditions of use')]")
	public WebElement termsAndConditionsText;
	
	@FindBy(xpath="//span[contains(.,'I agree to the terms and conditions of use')]/preceding-sibling::input")
	public WebElement termsAndConditionsCheckBox;
	
	//@FindBy()
	
	@FindBy(xpath="//button[contains(.,'Continue')]")
	public WebElement continueButton;
	

	@FindBy(xpath="//label[contains(text(),'OWNER')]/..//div[@class='item active selected']")
	public WebElement selectedCreatedForType;
	
	@FindBy(xpath="//div[@class='cardImageText center aligned ']/span[contains(.,'ownershipType')]")
	public WebElement ownershipContentInAppUploads;
			
	
	@FindBy(xpath="//label[contains(.,'OWNER')]/..//div[contains(@class,'item')][2]")
	public WebElement selectcreatedByType;
	
	
	@FindBy(xpath="//label[contains(text(),'OWNER')]/..//div[@class='item active']")
	public WebElement createdByType;
	
	/*@FindBy(xpath="//label[contains(.,'OWNER')]/..//div[@class='text']")
	public WebElement selectedCreatedForType;*/
	
	@FindBy(xpath="//label[contains(.,'OWNER')]/..//input")
	public WebElement clikcOwnerTypeToEdit;
	
	@FindBy(xpath="//a[contains(@class,'black right ribbon')]")
	public List<WebElement> getContentNameFromRS;
	
	@FindBy(xpath="//a[text()='Next']")
	public WebElement NextButton;
	
	@FindBy(xpath="//a[text()='10']")
	public WebElement Page10InReviewSubmission;
	
	
	@FindBy(xpath="//div[contains(@class,'content-detail') and contains(text(),'Ownership')]")
	public WebElement verifyOwnershipInContent;
	
	@FindBy(xpath="//div[@class='ui image']")
	public WebElement contentCardInDraft;
	
	@FindBy(xpath="//label[.='OWNER']/following::div[@class='text']")
	public WebElement selectedOwnershipTypeValue;
	
	@FindBy(xpath="//label[contains(.,'OWNER')]/..//input/following::div")
	public WebElement DefaultValueOfOwnershipTypeDdl;
		
	@FindBy(xpath="//label[contains(.,'OWNER')]/..//div[contains(@class,'item')][1]")
	public WebElement selectcreatedForType;
	
	@FindBy(xpath="//div[@class='header']//i[@class='close link icon']")
	public WebElement closeIconInEditDetails;
	
	@FindBy(xpath="//tr/following::h5")
	public WebElement contentInAllMyContent;
			
	@FindBy(xpath="//div//span[contains(.,'Content Information')]/following::a[contains(.,'View Credits')]")
	public WebElement viewCreditsLink;
	
	@FindBy(xpath="//div/div[contains(.,'Creators')]/following::div")
	public WebElement creators;
	
	@FindBy(xpath="//div/div[contains(.,'Contributors')]/following::div")
	public WebElement contributors;
	
	@FindBy(xpath="//td/b[contains(.,'Owner')]/following::td[2]")
	public WebElement verifyOwnershipValueInCourse;	
	
	@FindBy(xpath="//span[.='View Details']/following::i[1]")
	public WebElement closeIconViewDetails;
}
