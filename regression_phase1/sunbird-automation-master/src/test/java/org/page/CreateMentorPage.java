package org.page;

import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
/**
* Created by Qualitrix Technologies Pvt Ltd.
* Purpose: To capture and maintain all webelements related to CreateMentorPage
*/

public class CreateMentorPage {
	
	WebDriver driver;

	public CreateMentorPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}

	@FindBy(xpath="(//i[@class='dropdown icon'])[3]")
	public WebElement searchCourseDropdown;
	
	@FindBy(xpath="//sui-select//sui-select-option[@class='item selected']")
	public WebElement firstCourseDropdownitem;
	
	@FindBy(xpath="//i[@class='right arrow icon']")
	public WebElement rightArrowIcon;
	
	@FindBy(xpath="(//input[@formcontrolname='enrollmentType'])[2]")
	public WebElement openBatch;
	
	@FindBy(xpath="//button[contains(.,'Enroll')]")
	public WebElement enrollForOpenBatch;
	
	@FindBy(xpath="//span[text()='ENROLL TO COURSE']")
	public WebElement enrollForCourse;
	
	@FindBy(xpath="//i[@class='left arrow icon']")
	public WebElement leftArrowIcon;
	
	@FindBy(xpath="//a[contains(text(),'Course Batches')]")
	public WebElement courseBatches;
	
	@FindBy(xpath="(//i[@class='dropdown icon'])[2]")
	public WebElement batchesDropDown;
	
	@FindBy(xpath="//h5[@class='ui right floated basic icon circular button margin-auto mouse-pointer']")
	public WebElement closeBatchIcon;
	
	@FindBy(xpath="//span[contains(text(),'Ongoing Batches')]")
	public WebElement ongoingBatches;
	
	@FindBy(xpath="//span[contains(text(),'Previous Batches')]")
	public WebElement previousBatches;
	
	@FindBy(xpath="//span[contains(text(),'Upgoing Batches')]")
	public WebElement upcomingBatches;
	
	@FindBy(xpath="//label[contains(text(),'NAME OF BATCH')]")
	public WebElement batchForm;
	
	@FindBy(xpath="//input[@formcontrolname='endDate']")
	public WebElement calendarEndDate;
	
	@FindBy(xpath="//input[@formcontrolname='startDate']")
	public WebElement calendarStartDate;
	
	@FindBy(xpath="//span[@class='batch-content-description']")
	public List<WebElement> courseContent;
	
	@FindBy(xpath="//i[@class='ui remove icon']")
	public WebElement closeButton;
	
	@FindBy(xpath="//div[contains(text(),'DOWNLOAD')]")
	public WebElement downloadButton;
	
	@FindBy(xpath="(//i[@class='dropdown icon'])[2]")
	public WebElement searchDropDown;
	
	

	
	
	@FindBy(xpath="//img[@src='https://cdn.ntp.net.in/player/assets/images/default.png']")
	public WebElement searchedCourse;
	
	@FindBy(xpath="//a[text() = 'Create Batch']")
	public WebElement createBatch;
	
	@FindBy(xpath="//div[@class='content']")
	public WebElement batchDetails;
	
	@FindBy(xpath="//i[@class='edit large icon remove-outline']")
	public List<WebElement> editIconInUserProfileSearchL;
	
	@FindBy(xpath="//a[@class='header ']")
	public List<WebElement> profileNameInUserSearchL;
	
	@FindBy(xpath="(//input[@type='checkbox'])[2]")
	public List<WebElement> selectRoleCheckboxes ;
	
	@FindBy(xpath="(//i[@class='edit large icon remove-outline'])[2]")
	public WebElement editIconInUserProfileSearch;
	
	@FindBy(xpath="(//*[@class='header '])[2]")
	public WebElement profileNameInUserSearch ;
	
	@FindBy(xpath="(//i[@class='edit large icon remove-outline'])[2]")
	public WebElement editIconInUserProfileSearch2;
	
	@FindBy(xpath="(//a[@class='header '])[2]")
	public WebElement profileNameInUserSearch2 ;
	
	@FindBy(xpath="//input[@type='checkbox']")
	public WebElement selectRoleCheckbox ;
	
	@FindBy(xpath="//button[contains(text(),'UPDATE')]")
	public WebElement updateButtonInUserProfile ;
	
	@FindBy(xpath="//strong[contains(text(),'Roles updated successfully')]")
	public WebElement successfulMessage ;
	
	//Updated on Oct 23 2018
	//@FindBy(xpath="//i[@class='write icon float-ContentRight cursor-pointer']")
	@FindBy(xpath="//i[@class='icon float-ContentRight cursor-pointer write']")
	public WebElement editBatch;
	
	@FindBy(xpath="//button[text()='Update']")
	public WebElement updateBatch;
	
	@FindBy(xpath="//i[@class='add icon']")
	public WebElement addIcon;
	
	@FindBy(xpath="//input[@formcontrolname='name']")
	public WebElement nameOfBatch;
	
	@FindBy(xpath="//input[@formcontrolname='description']")
	public WebElement aboutBatch;
	
	@FindBy(xpath="//input[@formcontrolname='startDate']")
	public WebElement startDate;
	
	@FindBy(xpath="//input[@formcontrolname='endDate']")
	public WebElement endDate;
	
	//@FindBy(xpath="//div[@class='createbatchdropdown ui fluid multiple search selection dropdown active visible']")
	@FindBy(xpath="//div[@id='mentors']")
	public WebElement mentorsInBatch;
	
	
	
	@FindBy(xpath="//div[@class='item selected']")
	public WebElement suborgMentor2InBatch;
	
	//@FindBy(xpath="//label[text()='MEMBERS IN THE BATCH']/../div")
	//@FindBy(xpath="//div[@id='users']")
	@FindBy(xpath="(//div[@class='createbatchdropdown ui fluid multiple search selection dropdown'])[2]")
	public WebElement membersInBatch;
	
	@FindBy(xpath="//div[@data-value='b28661ad-385c-4c9f-970c-4763df7220f5']")
	public WebElement suborgUser6InBatch;
	
	@FindBy(xpath="(//div[@data-value='c1234edf-eadd-4a3a-8990-6b7a84ee6079'])[2]")
	public WebElement orgAdminInBatch;
	
	@FindBy(xpath="(//div[@data-value='318e141e-6c24-4f32-9962-05d8a7c450ff'])[2]")
	public WebElement mentor1User;
	
	@FindBy(xpath="//div/../input[@id='userSelList']")
	public WebElement searchBatchMember;
	
	@FindBy(xpath="(//i[@class='dropdown icon'])[5]")
	public WebElement memberDropdown;
	
	@FindBy(xpath="(//i[@class='dropdown icon'])[4]")
	public WebElement mentorDropdown;
	
	@FindBy(xpath="//div[@class='actions']//button[@class='ui primary button']")
	public WebElement buttonCreate;
	
	@FindBy(xpath="//button[contains(text(),'VIEW COURSE STATS')]")
	public WebElement viewCourseStat;
	
	@FindBy(xpath="//button[@class='fluid blue right floated  ui button courseHeaderButton margin-top-0']")
	public WebElement resumeCourse;
	
	@FindBy(xpath="(//span[text()='Organisations'])[2]")
	public WebElement searchDropDownOrg;
	
	@FindBy(xpath="//span[text()='Courses']")
	public WebElement searchDropDownCourse;
	
	@FindBy(xpath="//div[@class='batch-content']/span")
	public List<WebElement> batchText;
	
	@FindBy(xpath = "//div[@class='ui black right ribbon label']")
	public WebElement batchText1;
	
	@FindBy(xpath="//img[contains(@src,'https://cdn.ntp.net.in/player/assets/images/default.png')]")
	public List<WebElement> courseImg;
	
	
	
	@FindBy(xpath="(//i[@class='dropdown icon'])[3]")
	public WebElement courseSearchDropDown;
	
	@FindBy(xpath="//div[@class='ui three stackable cards']//div[@class='batch-content']//span[@class='batch-content-description']")
	public WebElement batchDetail;
	
	//Added on 31 july 2018
	@FindBy(xpath="//input[@formcontrolname='startDate']/../../../../../../../../../../../../sui-popup/div/sui-datepicker/sui-calendar-date-view/table/tbody/tr/td[@class='link today focus']")
	public WebElement startDateCalendar;
	
	
	
	// Added on 8 sep 2018
	@FindBy(xpath="(//div[@data-value='08a6aa7a-4673-497e-971a-aa15bef52376'])[1]")
	public WebElement contentcreatorMentorsForBatch;

	@FindBy(xpath="//div[@data-value='5bf1fdf2-dd10-44de-a2ae-04a172ef886f']")
	public WebElement publicUserMembersForBatch;
	
	// Added on 8 sep 2018
	@FindBy(xpath="//input[@formcontrolname='startDate']/../../../../../../../../../../../../sui-popup/div/sui-datepicker/sui-calendar-date-view/table/tbody/tr/td[@class='link']")
	public WebElement endDateCalendar;
	
	@FindBy(xpath="(//div[@data-value='53984144-8fa9-4a86-9e76-ae909b585f7d'])[1]")
	public WebElement flagReviewerMentorsForBatch;
	
	@FindBy(xpath="(//div[@data-value='08a6aa7a-4673-497e-971a-aa15bef52376'])[1]")
	public WebElement contentCreatorMentorsForBatch;
	
	@FindBy(xpath="(//i[@class='dropdown icon'])[3]/..//sui-select-option")
	public WebElement selectSearchedCourse;
	
	@FindBy(xpath="//span[.=' FROM BEGINING']")
	public WebElement fromBeginning;
	
	//Dec 25
	//@FindBy(xpath="//div[@class='header p-15 pb-0']")
	@FindBy(xpath="//*[@class='header p-15 pb-0' or @class='asset_thumbnail']")
	public WebElement courseImg1;
	
	@FindBy(xpath="(//input[@id='mentorSelList']/following::div/div[contains(.,'creator')])")
	public WebElement selectMentorsInBatch;
	
	@FindBy(xpath="(//input[@id='mentorSelList']/following::div/div/div[contains(.,'content reviewer')])[2]")
	public WebElement selectMembersInBatch;
	
	@FindBy(xpath="//div[@class='sub-header']/h4")
	public WebElement getCourseName;
	
	
	//-------------------------------------------
	
	

	//@author Sachin
	// ProfileImage Web Element
	@FindBy(xpath="//*[@id='dropdown-menu-list-header']/img")
	public WebElement profileImage; 
	
	//@author Sachin
	// ProfileImage Workspace
	@FindBy(xpath="(//a[@class='item'][contains(.,'Workspace')])[2]")
	public WebElement workSpace;
	
	
	//@author Sachin
	// Course Web Element
	@FindBy(xpath="/html/body/app-root/app-workspace/div/div[3]/app-create-content/div/div[1]/div/div[1]/div/div")
	public WebElement course;
	
	//@author Sachin
	//  Web Element ProfileIconClick
	@FindBy(xpath="//*[@id='dropdown-menu-list-header']/img")
	public WebElement ProfileIconClick;
	
	//@author Sachin
	//  Web Element workSpace
	@FindBy(xpath="/html/body/app-root/app-workspace/div/div[3]/app-create-content/div/div[1]/div/div[1]/div/div")
	public WebElement WorkSpace;
	
	//@author Sachin
	//  Web Element create
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[2]/app-workspacesidebar/div/a[1]")
	public WebElement create;
	
	
	//@author Sachin
	//  Web Element lessonPlan
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[3]/app-create-content/div/div[2]/div/div[1]/div/div/div/span")
	public WebElement lessonPlan;
	
	//@author Sachin
	//  Web Element lessonPlanName
	@FindBy(xpath="/html/body/sui-modal/sui-dimmer/div/div/div/div/form/div/div[1]/app-content-creation-default-template/div/div[1]/div/div/input")		
	public WebElement lessonPlanName;
	
	//@author Sachin
	//  Web Element upForReview
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[2]/app-workspacesidebar/div/a[7]")		
	public WebElement upForReview;
	
	
	//@author Sachin
	//  Web Element searchPlaceHolder
	@FindBy(xpath="//*[@id='search-input-container']/div/div/input")		
	public WebElement searchPlaceHolder;
	
	
			
	//@author Sachin
	//  Web Element firstContent
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[3]/app-up-for-review/table/tbody/tr[1]/td[1]")		
	public WebElement firstContent;
			  
	//*[@id="commonHeader"]/div/div[4]/div/div/div[2]/div[7]
	
	//@author Sachin
	//  Web Element requestChanges
	@FindBy(xpath="//*[@id='commonHeader']/div/div[4]/div/div/div[2]/div[7]")		
	public WebElement requestChanges;
	
	//@author Sachin
	// Web Element drafts
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[2]/app-workspacesidebar/div/a[3]")		
	public WebElement drafts;
	
	
	//@author Sachin
	// Web Element firstLessonPlan
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[3]/app-draft/div[1]/div/div/div[1]/app-card/div/div/div[1]/div")		
	public WebElement firstLessonPlan;
	
	//@author Sachin
	// Web Element editPopupCloseIcon
	@FindBy(xpath="//*[@id='meta-modal']/div[1]/div/div/div[2]/i")		
	public WebElement editPopupCloseIcon;
	
	//@author Sachin
	// Web Element saveButton
	@FindBy(xpath="//*[@id='saveButton']/i")		
	public WebElement saveButton;
	
	//@author Sachin
	// Web Element limitedSharingDropdown
	@FindBy(xpath="//*[@id='reviewButton']/div[2]/i")		
	public WebElement limitedSharingDropdown;
			
	//@author Sachin
	// Web Element limitedSharing
	@FindBy(xpath="//*[@id='reviewButton']/div[2]/div/div")		
	public WebElement limitedSharing;
	
	
	//@author Sachin
	// Web Element limitedPublishing
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[2]/app-workspacesidebar/div/a[8]")		
	public WebElement limitedPublishing;
	
	//@author Sachin
	// Web Element shareIcon
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[3]/app-limited-published/div[1]/div/div/div/app-card/div/div/div[3]/div[2]/a/span/i")		
	public WebElement shareIcon;
	
	//@author Sachin
	// Web Element linkToBeCopied
	@FindBy(xpath="//*[@id='copyLinkData']")		
	public WebElement linkToBeCopied;
	
	//@author Sachin
	// Web Element limitedPublishingDelete
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[3]/app-limited-published/div[1]/div/div/div/app-card/div/div/div[3]/div[1]/a/span/i")		
	public WebElement limitedPublishingDelete;
		
	//@author Sachin
	// Web Element yesPopUp
	@FindBy(xpath="/html/body/sui-modal/sui-dimmer/div/div/div/div[3]/button[2]")		
	public WebElement yesPopUp;
	
	//@author Sachin
	// Web Element allMyContent
	@FindBy(xpath="//a[@href='/workspace/content/allcontent/1']")		
	public WebElement allMyContent;	
	
	//@author Sachin
	// Web Element nameCopy
	@FindBy(xpath="/html/body/app-root/div/app-workspace/div/div[3]/app-draft/div[1]/div/div/div/app-card/div/div/div[1]/div")		
	public WebElement nameCopy;	
	
	
	//@author Sachin
	// Web Element placeHolderSearch
	@FindBy(xpath="//*[@id='search-input-container']/div/div/input//*[@id='search-input-container']/div/div/input")		
	public WebElement placeHolderSearch;	
	

	//@author Sachin
	// Web Element searchIcon
	@FindBy(xpath="//*[@id='search-input-container']/div/div/i")		
	public WebElement searchIcon;
	
	
	//@author Sachin
	// Web Element preview
	@FindBy(xpath="//*[@id='content-list']/div/div/div/div/div[2]/div[4]/i[1]")		
	public WebElement preview;
	
	//@author Sachin
	// Web Element preview
	@FindBy(id="(//div[contains(@class,'avatar-content')])[2]")
	public WebElement dropdown;
	
	@FindBy(xpath="(//a[@class='item'][contains(.,'Logout')])[3]")
	public WebElement logout;
	
	@FindBy(xpath="(//a[contains(.,'LOGIN')])[3]")
	public WebElement Login;

	//@author Sachin
	@FindBy(xpath="(//div[contains(@class,'meta course')])[1]")
	public WebElement latestCourse;
	
	
	//@author Sachin
	@FindBy(xpath="(//i[@class='dropdown icon'])[4]")
	public WebElement membersinBatchDropDown;
	
	//@author Sachin
	@FindBy(xpath="(//div[contains(@class,'item')])[4]")
	public WebElement updateMentorInBatch;
	
	//@author Sachin
	@FindBy(xpath="(//i[contains(@class,'dropdown icon')])[5]")
	public WebElement updateMembersInBatch;
	
	
	//@author Sachin
	@FindBy(xpath="(//div[@class='content batch-content-meta'])[1]")
	public WebElement batchContent;
	
	@FindBy(xpath="//div[@class='item'][contains(.,'Test BookReviewer (te***************@qualitrix.com)')]")
	public WebElement testBookReviewerInBatch;
	
	//Dec 28
	@FindBy(xpath="//input[@name='filter_search']")
	public WebElement filterSearch;

	
	
}