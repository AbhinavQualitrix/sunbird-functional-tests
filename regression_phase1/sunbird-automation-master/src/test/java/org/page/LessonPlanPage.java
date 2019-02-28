package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LessonPlanPage 
{
	WebDriver driver;

	public  LessonPlanPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}
	//@author sachin
	// Web element mainSearch
	@FindBy(xpath = "(//a[contains(.,'Library')])[2]")
	public WebElement headerLibrary;
	
	//@author sachin
	// Web element mainSearch
	@FindBy(xpath="(//input[@placeholder='Search'])[2]")
	public WebElement mainSearch;
	
	//@author sachin
	// Web element mainSearchIcon
	@FindBy(xpath="(//i[@class='circular search link icon'])[2]")
	public WebElement mainSearchIcon;
	
	//@author sachin
	// Web element lessonPlan
	@FindBy(xpath = "(//h4[contains(@class,'title')])[1]")
	public WebElement lessonPlan;
	
	//@author sachin
	// Web element copyLessonPlan
	@FindBy(xpath="//i[@class='ui large blue clone outline icon ']")
	public WebElement copyLessonPlan;
	
	//@author sachin
	// Web element LessonPlan
	@FindBy(xpath="//div[@class='textcontent'][contains(.,'Lesson Plan')]")
	public WebElement LessonPlan;
	
	//@author sachin
	// Web element LessonPlanNamePlaceHolder
	@FindBy(xpath="//input[contains(@placeholder,'Name')]")
	public WebElement LessonPlanNamePlaceHolder;
	
	//@author sachin
	// Web element startCreatingButton
	@FindBy(xpath="//button[contains(.,'START CREATING')]")
	public WebElement startCreatingButton;
	
	//@author sachin
	// Web element newChildButton
	@FindBy(xpath = "(//a[@class='blueColor'])[4]")
	public WebElement newChildButton;
	
	//@author sachin
	// Web element childUnitTitle
	@FindBy(xpath="//input[contains(@placeholder,'Enter title for unit')]")
	public WebElement childUnitTitle;
	
	//@author sachin
	// Web element descriptionPlaceHolder
	@FindBy(xpath = "(//textarea[@name='description'])[4]")
	public WebElement descriptionPlaceHolder;
	
	//@author sachin
	// Web element addNotesPlaceHolder
	@FindBy(xpath="//input[@placeholder='Add Notes']")
	public WebElement addNotesPlaceHolder;
	
	//@author sachin
	// Web element addResource
	@FindBy(xpath="//button[@ng-click='addResource()']")
	public WebElement addResource;
	
	//@author sachin
	// Web element latestResourceCheckbox
	@FindBy(xpath="(//input[contains(@class,'checkBox')])[1]")
	public WebElement latestResourceCheckbox;
	
	//@author sachin
	// Web element proceedButton
	@FindBy(xpath="//button[contains(.,'PROCEED')]")
	public WebElement proceedButton;
	
	//@author sachin
	// Web element workSpace
	@FindBy(xpath="(//a[contains(.,'Workspace')])")
	public WebElement workSpace;
	
	//@author sachin
	// Web element secondResourceCheckbox
	@FindBy(xpath="(//input[@class='checkBox'])[2]")
	public WebElement secondResourceCheckbox;
	
	//@author sachin
	// Web element thirdResourceCheckbox
	@FindBy(xpath="(//input[@class='checkBox'])[3]")
	public WebElement thirdResourceCheckbox;
	
	//@author sachin
	// Web element firstResourcePreview
	@FindBy(xpath="(//i[@data-content='Preview'])[1]")
	public WebElement firstResourcePreview;
	
	//@author sachin
	// Web element lessonPlanTitle
	@FindBy(xpath="//*[@id='collection-tree']/ul/li/ul/li/span")
	public WebElement lessonPlanTitle;
	
	//@author sachin
	// Web element secondResourceDelete
	@FindBy(xpath="(//i[@data-content='Delete'])[2]")
	public WebElement secondResourceDelete;
	
	//@author sachin
	// Web element confirmDelete
	@FindBy(xpath="//button[contains(.,'YES, DELETE')]")
	public WebElement confirmDelete;
	
	//@author sachin
	// Web element closeDialog
	@FindBy(xpath="//i[contains(@ng-click,'closeThisDialog()')]")
	public WebElement closeDialog;
	
	//@author sachin
	// Web element editDetails
	@FindBy(xpath="//span[@ng-if='showEditMeta'][contains(.,'Edit Details')]")
	public WebElement editDetails;
	
	//@author sachin
	// Web element editDetailsTitle
	@FindBy(xpath="//input[contains(@id,'name')]")
	public WebElement editDetailsTitle;
	
	//@author sachin
	// Web element editDetailsDescription
	@FindBy(xpath="//textarea[contains(@id,'description')]")
	public WebElement editDetailsDescription;
	
	//@author sachin
	// Web element editDetailsKeyword
	@FindBy(xpath="//input[contains(@placeholder,'Add a tag')]")
	public WebElement editDetailsKeyword;
	
	//@author sachin
	// Web element editDetailsCurriculum
	@FindBy(xpath = "(//input[contains(@class,'search')])[1]")
	public WebElement editDetailsCurriculum;
	
	//@author sachin
	// Web element editDetailsRajasthan
	@FindBy(xpath = "//div[contains(.,'State (Rajasthan)')]")
	public WebElement editDetailsRajasthan;
	
	//@author sachin
	// Web element editDetailsClass
	@FindBy(xpath="//*[@class='ui fluid search dropdown ng-pristine ng-untouched ng-valid ng-empty ng-valid-required selection multiple']")
	public WebElement editDetailsClass;
	
	//@author sachin
	// Web element editDetailsClass10
	@FindBy(xpath="//div[@class='item'][contains(.,'Class 10')]")
	public WebElement editDetailsClass10;
	
	//@author sachin
	// Web element editDetailsSubject
	@FindBy(xpath="//div[contains(.,'Select Subject')]")
	public WebElement editDetailsSubject;
	
	//@author sachin
	// Web element editDetailsMathematics
	@FindBy(xpath="//div[@class='item active selected'][contains(.,'Mathematics')]")
	public WebElement editDetailsMathematics;
	
	//@author sachin
	// Web element editDetailsMedium
	@FindBy(xpath="(//input[contains(@class,'search')])[4]")
	public WebElement editDetailsMedium;
	
	//@author sachin
	// Web element editDetailsHindi
	@FindBy(xpath="//div[@class='item selected'][contains(.,'Hindi')]")
	public WebElement editDetailsHindi;
	
	//@author sachin
	// Web element editDetailsAudience
	@FindBy(xpath="(//input[contains(@class,'search')])[5]")
	public WebElement editDetailsAudience;
	
	//@author sachin
	// Web element editDetailsInstructor
	@FindBy(xpath="(//div[contains(.,'Instructor')])[14]")
	public WebElement editDetailsInstructor;
	
	//@author sachin
	// Web element editDetailsOwner
	@FindBy(xpath = "(//i[contains(@class,'dropdown icon')])[8]")
	public WebElement editDetailsOwner;
	
	//@author sachin
	// Web element editDetailsTestAutoOrg
	@FindBy(xpath="(//div[contains(.,'content creator')])[14]")
	public WebElement editDetailsTestAutoOrg;
	
	//@author sachin
	// Web element editDetailsSave
	@FindBy(xpath="//button[@class='ui blue button '][contains(.,'Save')]")
	public WebElement editDetailsSave;
	
	// @author Sachin
	// Web Element saveClose 
	@FindBy(xpath = "//button[contains(.,'Close')]")
	public WebElement saveClose;
	
	//@author Sachin
	// Web element save
	@FindBy(xpath="//i[@class='icon-save']")
	public WebElement save;
	
	// @author Sachin
	// Web Element limitedShareDropdown 
	@FindBy(xpath = "(//div[contains(.,'Limited sharing')])[13]")
	public WebElement limitedShareDropdown;
	
	//@author sachin
	// Web element limitedSharing
	@FindBy(xpath="//div[@class='item'][contains(.,'Limited sharing')]")
	public WebElement limitedSharing;
	
	// @author Sachin
	// Web Element limitedPublishingSection 
	@FindBy(xpath = "(//a[@class='item'])[23]")
	public WebElement limitedPublishingSection;
	
	// @author Sachin
	// Web Element shareIcon 
	@FindBy(xpath = "(//i[contains(@class,'linkify large icon float-ContentLeft limitedPublishingLinkIcon')])[1]")
	public WebElement shareIcon;
	
	// @author Sachin
	// Web Element copyLink 
	@FindBy(xpath = "//button[contains(.,'COPY LINK')]")
	public WebElement copyLink;
	
	// @author Sachin
	// Web Element shareIcon 
	@FindBy(xpath = "//i[@class='ui remove icon']")
	public WebElement closeSharePopup;
	
	// @author Sachin
	// Web Element shareIcon 
	@FindBy(xpath = "(//i[@class='trash large icon'])[1]")
	public WebElement lessonPlanTrash;
	
	// @author Sachin
	// Web Element shareIcon 
	@FindBy(xpath = "(//span[contains(@class,'sliderCardHeading text-cencapitalize')])[1]")
	public WebElement nameOfLessonPlan;
	
	// @author Sachin
	// Web Element shareIcon 
	@FindBy(xpath = "//button[@class='ui primary button'][contains(.,'Yes')]")
	public WebElement deleteConfirmYes;
	
	
	// @author Sachin
	// Web Element shareIcon 
	@FindBy(xpath = "(//a[contains(@class,'item')])[22]")
	public WebElement allMyContent;
	
	// @author Sachin
	// Web Element shareIcon 
	@FindBy(xpath = "(//input[contains(@name,'filter_search')])[3]")
	public WebElement searchContent;
	
	//@author sachin
	// Web element sendForReview
	@FindBy(xpath="//i[contains(@class,'send icon')]")
	public WebElement sendForReview;
	
	//@author sachin
	// Web element sendaddImage
	@FindBy(xpath="//div[@class='addImageText'][contains(.,'Add an image')]")
	public WebElement sendaddImage;
	
	//@author sachin
	// Web element sendThumbnail1
	@FindBy(xpath="(//img[contains(@class,'asset_thumbnail')])[1]")
	public WebElement sendThumbnail1;
	
	//@author sachin
	// Web element sendSelect
	@FindBy(xpath="//button[@ng-switch-when='select'][contains(.,'Select')]")
	public WebElement sendSelect;
	
	//@author sachin
	// Web element sendEditDetailsTitle
	@FindBy(xpath="//input[contains(@id,'name')]")
	public WebElement sendEditDetailsTitle;
	
	//@author sachin
	// Web element sendEditDetailsDescription
	@FindBy(xpath="//textarea[contains(@id,'description')]")
	public WebElement sendEditDetailsDescription;
	
	//@author sachin
	// Web element sendKeywords
	@FindBy(xpath="//input[contains(@placeholder,'Add a tag')]")
	public WebElement sendKeywords;
	
	//@author sachin
		// Web element sendCurriculum
		@FindBy(xpath="//label[contains(.,'BOARD')]/..//div[contains(.,'Select Board')]")
		public WebElement clickBoard;
		
		//@author sachin
		// Web element sendRajasthan
		@FindBy(xpath="//div[@class='item'][contains(.,'State (Rajasthan)')]")
		public WebElement sendRajasthan;
		
		//@author sachin
		// Web element sendClass
		@FindBy(xpath="//div[@class='default text'][contains(.,'Select Class')]")
		public WebElement sendClass;
		
		//@author sachin
		// Web element sendClass10
		@FindBy(xpath="//div[@class='item'][contains(.,'Class 10')]")
		public WebElement sendClass10;
		
		//@author sachin
		// Web element sendSubject
		@FindBy(xpath="//label[contains(.,'SUBJECT')]/..//div[contains(.,'Select Subject')]")
		public WebElement sendSubject;
		
		//@author sachin
		// Web element sendScience
		@FindBy(xpath="//div[@class='item'][contains(.,'Science')]")
		public WebElement sendScience;
		
		//@author sachin
		// Web element sendMedium
		@FindBy(xpath="//div[@class='default text'][contains(.,'Select Medium')]")
		public WebElement sendMedium;
		
		//@author sachin
		// Web element sendEnglish
		@FindBy(xpath="//div[@class='item'][contains(.,'English')]")
		public WebElement sendEnglish;
	
	//@author sachin
	// Web element sendAudience
	@FindBy(xpath="(//input[contains(@class,'search')])[5]")
	public WebElement sendAudience;
	
	//@author sachin
	// Web element sendInstructor
	@FindBy(xpath="//div[@class='item'][contains(.,'Instructor')]")
	public WebElement sendInstructor;
	
	//@author sachin
	// Web element sendOwner
	@FindBy(xpath="(//input[contains(@class,'search')])[6]")
	public WebElement sendOwner;
	
	//@author sachin
	// Web element sendTestContentcreator
	@FindBy(xpath="//div[@class='item'][contains(.,'Test ContentCreator')]")
	public WebElement sendTestContentcreator;
	
	//@author sachin
	// Web element sendSave
	@FindBy(xpath="//button[@class='ui blue button '][contains(.,'Save')]")
	public WebElement sendSave;
	
	//@author sachin
	// Web element sendSave
	@FindBy(xpath="(//span[contains(@class,'sliderCardHeading text-cencapitalize')])[1]")
	public WebElement publishedContentTitle;	
			
	//@author sachin
	// Web element sendSave
	@FindBy(xpath="//div[@class='ui label list-leftheader'][contains(.,'CONTENT PREVIEW')]")
	public WebElement contentPreview;	
			
	//@author sachin
	// Web element sendSave
	@FindBy(xpath="(//span[contains(@class,'sliderCardHeading text-cencapitalize')])[1]")
	public WebElement FirstContentInReviewSubmissions;		
	
	@FindBy(xpath = "//i[contains(@class,'close icon')]")
	public WebElement closePopUp;
			
	
}