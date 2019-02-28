package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


public class BatchUserPage {
	WebDriver driver;

	public  BatchUserPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}
	
	@FindBy(xpath="//input[@placeholder='Name']")
	public WebElement courseName;
	
	@FindBy(xpath="//input[@placeholder='Description']")
	public WebElement courseDescription;
	
	@FindBy(xpath="//button[contains(text(),'START CREATING')]")
	public WebElement startCreating;
	
	@FindBy(tagName="iframe")
	public WebElement iFrame;
	
	@FindBy(xpath="//button[@class='ui basic button text-transform-none'][2]//a[2]")
	public WebElement newChild;
	
	@FindBy(xpath="//label[.='Title']/following-sibling::div//following-sibling::input")
	public WebElement titleName;
	
	@FindBy(xpath="//textarea[@placeholder='Brief description about the course unit']")
	public WebElement titleDescription;
	
	@FindBy(xpath="//button[contains(.,'ADD RESOURCE')]")
	public WebElement addResource;
	
	@FindBy(xpath="(//img[contains(@class,'resourceMetaImage ')])[1]")
	public WebElement selectResource;
	
	@FindBy(xpath="//div[@class=' ui clearing segment']/..//button[contains(text(),'PROCEED')]")
	public WebElement proceedButton;
	
	@FindBy(xpath="//span[.='Save']")
	public WebElement saveCourse;
	
	@FindBy(xpath="//div[@class='ui button text-part popup-item']")
	public WebElement sendForReview;
	
	@FindBy(xpath="//div[@class='ui appIconSelector']")
	public WebElement clickAppIcon;
	
	@FindBy(xpath="//div[@class='ui image']//img[@class='asset_thumbnail']")
	public WebElement checkContentIcon;
	
	@FindBy(xpath="//button[.='Select']")
	public WebElement selectAppIcon;
	
	@FindBy(xpath="(//input[contains(@class,'search')])[1]")
	public WebElement clickOnSelectCurriculum;
	
	@FindBy(xpath="//div[@class='item selected']")
	public WebElement selectCurriculum;
	
	@FindBy(xpath="//*[@id='gradeLevel']/div[1]")         // 
	public WebElement clickOnSelectClass;
	
	@FindBy(xpath="//*[@id='gradeLevel']/div[1]/div[2]/div[2]")
	public WebElement selectClass;
	
	@FindBy(xpath="//div[.='Select Medium']")
	public WebElement clickOnSelectMedium;
	
	@FindBy(xpath="//div[.='Select Medium']/following::div[@class='item selected']")
	public WebElement selectMedium;
	
	@FindBy(xpath="(//input[contains(@class,'search')])[6]")
	public WebElement clickOwner;
	
	@FindBy(xpath="(//div[contains(@class,'item')])[24]")
	public WebElement selectOwner;
	
	@FindBy(xpath="//button[.='Save']")
	public WebElement saveButton;
	
	@FindBy(xpath = "//i[contains(@class,'close icon')]")
	public WebElement closePopUp;
	
	@FindBy(xpath="(//div[contains(@class,'ui text menu m-0 flex-jc-center d-flex')])/a[contains(.,'Courses')]")
	//@FindBy(xpath="(//a[contains(.,'Courses')])[2]")
	public WebElement headerCourse;
	
	@FindBy(xpath="(//div[contains(@class,'meta course')])[2]")
	public WebElement latestCourse;
	
	@FindBy(xpath="//i[@class='add icon']")
	public WebElement addIcon;
	
	@FindBy(xpath="//input[contains(@formcontrolname,'name')]")
	public WebElement nameOfBatch;
	
	@FindBy(xpath="//input[@formcontrolname='description']")
	public WebElement aboutBatch;
	
	@FindBy(xpath="//input[@formcontrolname='startDate']")
	public WebElement startDate;
	
	@FindBy(xpath="//input[@formcontrolname='startDate']/../../../../../../../../../../../../sui-popup/div/sui-datepicker/sui-calendar-date-view/table/tbody/tr/td[@class='link']")
	public WebElement startDateCalendar;
	
	@FindBy(xpath="//input[@formcontrolname='endDate']")
	public WebElement endDate;
	
	@FindBy(xpath="(//i[contains(@class,'dropdown icon')])[4]")
	public WebElement mentorsInBatch;
	
	@FindBy(xpath="(//div[contains(@class,'item')])[6]")
	public WebElement suborgMentor2InBatch;
	
	@FindBy(xpath="(//i[@class='dropdown icon'])[6]")
	public WebElement mentorDropdown;
	
	@FindBy(xpath="(//div[contains(@class,'item')])[12]")
	public WebElement membersInBatch;
	
	@FindBy(xpath="//div[@class='actions']//button[@class='ui primary button']")
	public WebElement buttonCreate;
	
	@FindBy(xpath="(//a[@class='item'][contains(.,'Workspace')])")
	public WebElement workSpace;
	
	@FindBy(xpath="//a[contains(text(),'Course Batches')]")
	public WebElement courseBatches;
	
	@FindBy(xpath="(//i[contains(@class,'dropdown icon')])")
	public WebElement batchesDropDown;
	
	@FindBy(xpath = "(//span[contains(.,'Ongoing Batches')])[2]")
	public WebElement ongoingBatches;
	
	@FindBy(xpath="//span[contains(.,'Upcoming Batches')]")
	public WebElement upcomingBatches;
	
	@FindBy(xpath="//span[contains(text(),'Previous Batches')]")
	public WebElement previousBatches;
	
	@FindBy(xpath="(//img[@src='assets/images/default.png'])[1]")
	public WebElement courseImg1;
	
	@FindBy(xpath="//label[contains(text(),'NAME OF BATCH')]")
	public WebElement batchForm;
	
	@FindBy(xpath="//button[text()='Update']")
	public WebElement updateBatch;
	
	@FindBy(xpath="(//div[contains(@class,'item')])[4]")
	public WebElement updateMentorInBatch;
	
	@FindBy(xpath="(//i[contains(@class,'dropdown icon')])[5]")
	public WebElement updateMembersInBatch;
	
	@FindBy(xpath="(//div[@class='content batch-content-meta'])[1]")
	public WebElement batchContent;
	
	@FindBy(xpath="(//input[contains(@id,'keyword')])[2]")
	public WebElement courseSearch;
	
	@FindBy(xpath="//button[contains(.,'VIEW COURSE STATS')]")
	public WebElement viewCourseStatsButton;
	
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[2]/app-workspacesidebar/div/a[7]")		
	public WebElement upForReview;
	
	@FindBy(xpath="//*[@class='UpForReviewListHover cursor-pointer']")
	public WebElement firtContent;
	
	@FindBy(xpath = "//span[contains(.,'Publish')]")
	public WebElement headerPublish;
	
	@FindBy(xpath="//*[@id='main-nav']/div[2]/app-main-menu/div/a[4]")
	public WebElement Workspace;
	
	@FindBy(xpath="//*[@class='ui right floated primary button mouse-pointer']")
	public WebElement Publish;
	
	@FindBy(xpath="//*[@id='review-footer']/div/button[2]")
	public WebElement publishConfirm;
	
	@FindBy(xpath="(//input[@name='filter_search'])[2]")
	public WebElement filterSearch;
	
	@FindBy(xpath = "(//i[@class='circular search link icon'])[2]")
	public WebElement searchIconUpForReview;
	
	@FindBy(xpath = "(//div[contains(@class,'meta')])[1]")
	public WebElement searchedCourse;
	
	@FindBy(xpath="//a[text() = 'Create Batch']")
	public WebElement createBatch;
	
	@FindBy(xpath="//div[@class='item'][contains(.,'Test BookReviewer (te***************@qualitrix.com)')]")
	public WebElement testBookReviewerInBatch;
	
	@FindBy(xpath="(//input[@id='mentorSelList']/following::div/div[contains(.,'creator')])")
	public WebElement selectMentorsInBatch;
	
	@FindBy(xpath="(//input[@id='mentorSelList']/following::div/div/div[contains(.,'content reviewer')])[2]")
	public WebElement selectMembersInBatch;
	
	// Added on 8 sep 2018
	@FindBy(xpath="//input[@formcontrolname='startDate']/../../../../../../../../../../../../sui-popup/div/sui-datepicker/sui-calendar-date-view/table/tbody/tr/td[@class='link']")
	public WebElement endDateCalendar;
	
	@FindBy(xpath="(//div[@class='ui black right ribbon label'])")
	public WebElement courseBatchImg1;
}