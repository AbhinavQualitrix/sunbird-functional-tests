
package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UpForReviewPage 
{
	WebDriver driver;

	public  UpForReviewPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}
	// @author sachin
	// Web Element upForReview
	@FindBy(xpath="//a[contains(text(),'Up For Review')]")
	public WebElement upForReview;

	// @author sachin
	// Web Element searchContent
	@FindBy(xpath="//input[@placeholder='Search content']")
	public WebElement searchContent;
	
	// @author Sachin
	// Web Element  closePopUp 
	@FindBy(xpath = "//i[contains(@class,'close icon')]")
	public WebElement closePopUp;
	
	// @author sachin
	// Web Element sortBy
	@FindBy(xpath = "//*[@id='sortByDropDown']/sui-select/i")
	public WebElement sortBy;
	
	// @author sachin
	// Web Element updatedOn
	@FindBy(xpath = "//*[@id='sortByDropDown']/sui-select/div[3]/sui-select-option[1]")
	public WebElement updatedOn;
	
	// @author sachin
	// Web Element createdOn
	@FindBy(xpath = "//*[@id='sortByDropDown']/sui-select/div[2]/sui-select-option[2]/span[2]")
	public WebElement createdOn;
	
	// @author sachin
	// Web Element nameAtoZ
	@FindBy(xpath = "//*[@id='sortByDropDown']/sui-select/div[2]/sui-select-option[3]/span[2]")
	public WebElement nameAtoZ;
	
	// @author sachin
	//Adding elements for test case 14
	// Web Element filterIcon
	@FindBy(xpath="//span[@class='browse item cursor-pointer']")
	public WebElement filterIcon;
	
	
	
	
	//Dec 27
		// @author Raju 
		// Web Element clickFilterBoard
		@FindBy(xpath="//div[contains(text(),' Select Board')]")
		public WebElement clickFilterBoard;
		
		// @Author Raju
		//Dec 27
		@FindBy(xpath ="//div[contains(text(),' Select Board')]/following::sui-select-option[1]")
		public WebElement selectFilterBoard;
		
		
		
		//Dec 27 By Raju
		@FindBy(xpath="//div[contains(text(),' Select Grade')]")
		public WebElement clickFilterGrade;
		
		@FindBy(xpath="//div[contains(text(),' Select Grade')]/following::sui-select-option[1]")
		public WebElement SelectFilterGrade;
		

		
		 
		
		// @Author Raju Dec 27
		 @FindBy(xpath="//div[contains(text(),' Select Subject')]")
			public WebElement clickFilterSubject;
			
			//@author sachin
				@FindBy(xpath="//div[contains(text(),' Select Subject')]/following::sui-select-option[1]")
			public WebElement selectFilterSubject;
		
		

				//Dec 27
				//@author Raju 
						@FindBy(xpath="//div[contains(text(),' Select Medium')]")
				public WebElement clickFilterMedium;
				
										
				//@author sachin
							@FindBy(xpath="//div[contains(text(),' Select Medium')]/following::sui-select-option[1]")
				public WebElement selectFilterMedium;
				
							
							
							@FindBy(xpath="//*[contains(text(),' 1 Medium')]/following::span[4]")
							public WebElement selectFilterMedium2;
							
		
		//Dec 27 by Raju S
		@FindBy(xpath="//div[contains(text(),' Select Content Types')]")
		public WebElement clickContentType;
		
		
		@FindBy(xpath="//div[contains(text(),' Select Content Types')]/following::sui-select-option[1]")
		public WebElement selectContentType;

		
	//@author sachin
	// Web Element applyButton
	@FindBy(xpath="//a[.='APPLY']")
	public WebElement applyButton;
	
	//@author sachin
	// Web Element firtContent
//	@FindBy(xpath="//*[@class='UpForReviewListHover cursor-pointer']")
	
	@FindBy(xpath="//*[starts-with(text(),'Content ')]/following::td[1]")
	public WebElement firtContent;
	
	
	
	//@author sachin
	// Web Element headerPublish
	@FindBy(xpath = "//span[contains(.,'Publish')]")
	public WebElement headerPublish;
	
	//@author sachin
	// Web Element Publish
	@FindBy(xpath="//*[@class='ui right floated primary button mouse-pointer']")
	public WebElement Publish;
	
	//@author sachin
	// Web Element publishConfirm
	@FindBy(xpath="//*[@id='review-footer']/div/button[2]")
	public WebElement publishConfirm;
		
/*	@FindBy(xpath="//*[@id='main-nav']/div[2]/app-main-menu/div/a[4]")
	public WebElement Workspace;*/
	
	@FindBy(tagName="iframe")
	public WebElement iFrame;
	

	
	@FindBy(tagName="//td[@class='UpForReviewStatusOrange'][contains(.,'Review')]")
	public WebElement Review;
	
	@FindBy(xpath = "(//a[contains(.,'Library')])[2]")
	public WebElement headerLibrary;
	
	
	
	//Dec 27
		@FindBy(xpath="//a[contains(text(),'Workspace')]")
		public WebElement Workspace;
		
	
		 @FindBy(xpath="//*[starts-with(text(),'Content ')]/following::div[2]")
			public WebElement ContentName;
	

}
