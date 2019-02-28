package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;


/**
 * @author TEJAS46
 *
 */
public class CreatorUserPage {
	WebDriver driver;

	public  CreatorUserPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}




	@FindBy(xpath="//i[@class='close icon']")
	public WebElement closeIcon;


	//10 OCT
	//	@FindBy(xpath="//div//a[5][contains(text(),'Profile')]")
	//	@FindBy(xpath="//a[.='Profile']")
	//@FindBy(xpath="//div[@class='ui secondary pointing menu']//a[contains(text(),'Profile')]")
	@FindBy(xpath="(//a[@class='item mt-15 computer only' and contains(text(),'Profile')])[2]")
	public WebElement headerProfile;

	//Dec 25

	//@FindBy(xpath="//a[.='Workspace']")
	//@FindBy(xpath="//a[contains(text(),'Workspace')]")
	//@FindBy(xpath="//div[@class='menu transition hidden']//a[contains(text(),'Workspace')]")
	//@FindBy(xpath="//span[.='View your workspace']")
	//@FindBy(xpath="(//a[contains(.,'Workspace')])[2]")
	@FindBy(xpath="(//a[contains(.,'Workspace')])")
	public WebElement workSpace;





	@FindBy(xpath="//button[contains(text(),'START CREATING')]")
	public WebElement startCreating;

	@FindBy(tagName="iframe")
	public WebElement iFrame;

	//@FindBy(xpath="(//button//a//i)[2]")
	@FindBy(xpath="//button[@class='ui basic button text-transform-none'][2]//a[2]")
	public WebElement newChild;

	//	@FindBy(xpath="//input[@class='ng-pristine ng-valid-maxlength ng-not-empty ng-valid ng-valid-required ng-touched']")
	//	@FindBy(xpath="//input[@class='ng-valid-maxlength ng-dirty ng-touched ng-not-empty ng-valid ng-valid-required']")
	//	@FindBy(xpath="//form[@name='contentMetaForm']//input[@placeholder='Enter title for Book']")
	@FindBy(xpath="//label[.='Title']/following-sibling::div//following-sibling::input")
	//@FindBy(xpath="//input[@id='name']")
	public WebElement titleName;
	
	@FindBy(xpath="//textarea[@placeholder='Brief description about the course unit']")
	//@FindBy(xpath="//textarea[@id='description']")
	public WebElement titleDescription;

	@FindBy(xpath="//button[.='ADD RESOURCE']")
	public WebElement addResource;

	@FindBy(xpath="(//div[@class='facetList ng-scope'][1]//div/div[1])[3]")
	public WebElement selectResource;

	//Updated on 17th Aug 2018
	//@FindBy(xpath="//strong[contains(text(),'Find & Select Activities')]")
	@FindBy(xpath="//strong[contains(text(),'Find & Select Resources')]")
	public WebElement findSelectActivities;	

	//@FindBy(xpath="//button[@class='ui right floated primary tiny button btnAttribute']")
	//@FindBy(xpath="//button[@class='ui right floated primary tiny button proceed-btn']")
	@FindBy(xpath="//div[@class=' ui clearing segment']/..//button[contains(text(),'PROCEED')]")
	public WebElement proceedButton;

	@FindBy(xpath="//div[@class='ui appIconSelector']")
	public WebElement clickAppIcon;

	//	@FindBy(xpath="//img[@class='asset_thumbnail']")
	@FindBy(xpath="//div[@class='ui image']//img")
	public WebElement checkAppIcon;

	@FindBy(xpath="//div[@class='ui image']//img[@data_id='do_2125450286821949441339']")
	public WebElement checkAppIcon1;


	@FindBy(xpath="//button[.='Select']")
	public WebElement selectAppIcon;

	@FindBy(xpath="//button[.='Save']")
	public WebElement saveButton;	

	//	@FindBy(xpath="//div[@class='ui search dropdown placeholder-padding ng-pristine ng-untouched ng-empty ng-invalid ng-invalid-required selection active visible']")
	@FindBy(xpath="//div[.='Select Curriculum']")
	public WebElement clickOnSelectCurriculum;

	@FindBy(xpath="//div[@class='item selected']")
	public WebElement selectCurriculum;

	@FindBy(xpath="//div[.='Select Class']")
	public WebElement clickOnSelectClass;

	@FindBy(xpath="//label[contains(.,'CLASS')]/..//div[contains(@class,'item')]")
	//@FindBy(xpath="//div[@class='menu transition visible']//following-sibling::div")
	public WebElement selectClass;

	@FindBy(xpath="//label[contains(text(),'SUBJECT')]")
	public WebElement clickOnHeaderSubject;

	@FindBy(xpath="//div[.='Select Subject']")
	public WebElement clickOnSelectSubject;

	//OCT 12 v1.11.0
	//@FindBy(xpath="//div[@data-value='Mathematics']")
	@FindBy(xpath="//div[.='Select Subject']/following::div[@class='item']")
	public WebElement selectSubject;
	/*
	@FindBy(xpath="//div[.='Select Medium']")
	public WebElement clickOnSelectMedium;*/



	@FindBy(xpath="//div[@class='text']//span[.='All']")
	public WebElement headerDropdown;

	@FindBy(xpath="//div[@id='headerSearch']//span[.='Courses']")
	public WebElement headerCourseClick;

	//OCT 10
	@FindBy(xpath="(//input[@id='keyword'])[1]")
	//@FindBy(xpath="//input[@id='keyword']")
	public WebElement searchInput;


	//Dec 25
	@FindBy(xpath="(//input[@id='keyword'])/following::i")
	//@FindBy(xpath="//i[@class='circular search link icon']")
	public WebElement searchIcon;

	//OCT 10 - v1.11.0
	@FindBy(xpath="//input[@placeholder='Search content']/following::i")
	public WebElement searchIconUpForReview;

	//Feb-27'19
	//@FindBy(xpath="//a[contains(text(),'Review Submissions')]")
	@FindBy(xpath="//a[@href='/workspace/content/review/1']")
	public WebElement reviewSubmission;


	//Dec 18
	@FindBy(xpath="//div[contains(@class,'sbCard')]/div[@class='sub-header']/h4")
	public List<WebElement> reviewSubmittedCourse;

	//updated on June 13
	//@FindBy(xpath="(//div[@class='content']/..//span)[2]")
	@FindBy(xpath="//span[.='Course']")
	public WebElement createCourse;

	//@FindBy(xpath="(//div[@class='content']/..//span)[1]")
	//Updated on June 15
	@FindBy(xpath="//div[@class='content']/..//span[.='Book']")
	public WebElement createBook;

	//@FindBy(xpath="(//div[@class='content']/..//span)[3]")
	//Updated on June 15
	@FindBy(xpath="//div[@class='content']/..//span[.='Resource']")
	public WebElement createResource;


	//@FindBy(xpath="(//div[@class='content']/..//span)[4]")
	//Updated on 15 June
	@FindBy(xpath="//div[@class='content']/..//span[.='Collection']")
	public WebElement createCollection;


	//@FindBy(xpath="(//div[@class='content']/..//span)[5]")
	//Updated on 15 June
	@FindBy(xpath="//div[@class='content']/..//span[.='Lesson Plan']")
	public WebElement createLesson;

	//@FindBy(xpath="(//div[@class='content']/..//span)[6]")
	//Updated on 15 June
	@FindBy(xpath="//div[@class='content']/..//span[.='Upload Content']")
	public WebElement createUploadContent;


	@FindBy(xpath="//sui-select[@id='board']")
	public WebElement clickBookBoard;

	// OCT 10 v 1.11.0
	//@FindBy(xpath="(//sui-select[@id='board']/..//sui-select-option[@class='item'])[1]")
	//@FindBy(xpath="//sui-select-option[@class='item']//span[.='CBSE']")
	@FindBy(xpath="//sui-select[@id='board']/..//sui-select-option[@class='item']")
	public WebElement selectBookBoard;

	@FindBy(xpath="//sui-multi-select[@id='gradeLevel']")
	public List<WebElement> clickBookGrade;




	@FindBy(xpath="//sui-select[@id='subject']")
	public WebElement clickBookSubject;

	//OCT 10-v1.11.0
	@FindBy(xpath="//sui-select[@id='subject']/..//sui-select-option")
	public WebElement selectBookSubject;

	@FindBy(xpath="//sui-select[@id='medium']")
	public WebElement clickBookMedium;

	//OCT 11 -V1.11.0
	@FindBy(xpath="//sui-select[@id='medium']/..//sui-select-option")
	public WebElement selectBookMedium;

	@FindBy(xpath="//sui-select[@id='year']")
	public WebElement clickBookYear;

	@FindBy(xpath="//sui-select[@id='year']//span[contains(text(),'2010')]")
	public WebElement selectBookYear;

	@FindBy(xpath="//input[@placeholder='Publisher']")
	public WebElement bookPublisher;

	@FindBy(xpath="//p[.='TABLE OF CONTENTS']")
	public WebElement tableOfContents;

	//@FindBy(xpath="(//textarea[@placeholder='Brief description about the unit']")
	//@FindBy(xpath="//*[@id="contents-data-form"]/div/div/div[2]/div/textarea")
	//label[.='Description']/../div/textarea[@placeholder='Brief description about the unit']
	@FindBy(xpath="//label[.='Description']/../div/textarea[@placeholder='Brief description about the unit']")
	public WebElement bookDescription;

	//@FindBy(xpath="(//form[@id='contents-data-form'])[4]")
	@FindBy(xpath="(//label[.='Name'])[2]")
	public WebElement clickBookForm;

	//@FindBy(xpath="(//input[@placeholder='Enter title for Book'])[3]")
	@FindBy(xpath="//label[.='Name']/../div[@class='ui input']/..//input[@placeholder='Enter title for Book']")
	public WebElement bookTitle;

	@FindBy(xpath="//label[.='Keywords']/..//div[@class='tags']//input[@placeholder='Enter Keywords']")
	public WebElement bookKeywords;

	@FindBy(xpath="//input[@placeholder='Enter code here']")
	public WebElement bookDialcode;

	@FindBy(xpath="(//div[@class='ui image']//img[@data_id='do_2124646169195151361273'])[1]")
	public WebElement clickBookIcon;

	@FindBy(xpath="(//div[@class='ui image']//img[@data_id='do_212450905413713920137'])[1]")
	public WebElement selectBookIcon;

	@FindBy(xpath="(//img[@class='resourceMetaImage '])[2]")
	public WebElement selectBookResource;

	//@FindBy(xpath="//i[@class='large blue check circle icon']")
	@FindBy(xpath="//i[@class='large check circle icon']")
	public WebElement acceptDialcode;

	@FindBy(xpath="//a[contains(text(),'Up For Review')]")
	public WebElement upForReview;

	//--------------------------------------------------------------
	//Elements for Create A Lesson plan

	@FindBy(xpath="//input[@placeholder='Enter title for unit']")
	public WebElement lessonTitle;

	@FindBy(xpath="(//div//textarea[@placeholder='Brief description about the unit'])[2]")
	public WebElement lessonDescription;

	@FindBy(xpath="//input[@placeholder='Add Notes']")
	public WebElement lessonNotes;

	@FindBy(xpath="(//img[@class='resourceMetaImage '])[3]")
	public WebElement lessonResource;

	@FindBy(xpath="//div[@class='ui image']//img[@data_id='do_2124646193555292161285']")
	public WebElement selectLessonIcon;

	@FindBy(xpath="//input[@placeholder='Search content']")
	public WebElement searchForReview;

	@FindBy(xpath="//img[@class='ui tiny image UpReviewTinyImage']/..//div[@class='UpReviewHeader']")
	public WebElement searchedContentForPublish;

	@FindBy(xpath="//span[.='Publish']")
	public WebElement clickPublishIcon;

	@FindBy(xpath="//span[.='Request Changes']")
	public WebElement clickRequestChangesIcon;

	@FindBy(xpath="//input[@class='listItem']")
	public List<WebElement> selectAllCB; 

	//Nov 21
	//@FindBy(xpath="//button[@class='ui blue button ng-binding']")
	//@FindBy(xpath="//button[contains(text(),'PUBLISH')]")
	//@FindBy(xpath="//div[@class='row margin-top-10']//button[contains(text(),'PUBLISH')]")
	@FindBy(xpath="//body//button[contains(text(),'PUBLISH')]")
	public WebElement publishButton;


	@FindBy(xpath="//button[contains(text(),'Publish')]")
	public WebElement popupPublishButton;

	@FindBy(xpath="(//div[@class='UpReviewHeader'])[1]")
	public WebElement contentForReject;

	//@FindBy(xpath="//button[contains(text(),'REQUEST CHANGES')]")
	@FindBy(xpath="//body//button[contains(text(),'REQUEST CHANGES')]")
	public WebElement clickRequestChanges;

	@FindBy(xpath="//h5[.='Appropriateness']/..//input[@class='listItem']")
	public WebElement rejectReason1;

	@FindBy(xpath="//h5[.='Content details']/..//input[@class='listItem']")
	public WebElement rejectReason2;

	@FindBy(xpath="//h5[.='Usability']/..//input[@class='listItem']")
	public WebElement rejectReason3;

	//@FindBy(xpath="(//div[@id='checklistModal']/..//button[contains(.,'Request changes')])[2]")
	@FindBy(xpath="//button[contains(text(),'Request Changes')]")
	public WebElement requestChangesButton;

	@FindBy(xpath="(//div[@id='review-footer']/..//button[.='Request changes'])[2]")
	public WebElement requestChangesButton1;


	//Added locator for fetching list of courses up for review
	@FindBy(xpath="//div[@class='UpReviewHeader']")
	public List<WebElement> searchCoursesUpForReview;

	@FindBy(xpath="//span[contains(text(),'Publish')]")
	public WebElement publishCourseButton;

	@FindBy(xpath="//input[@class='listItem']")
	public List<WebElement> checkbox;

	//Dec 05
	@FindBy(xpath="//div[contains(@class,'sbCard')]/div[@class='sub-header']/h4")
	//@FindBy(xpath="//div[@class='sbCard mt-20 mr-30']/div[@class='sub-header']/h4")
	//@FindBy(xpath="//span[@class='sliderCardHeading text-cencapitalize']")
	//@FindBy(xpath="//span[@class='sliderCardHeading text-cencapitalize']")
	public List<WebElement> searchPublishedCourses;



	//Elements for upload documents -

	@FindBy(xpath="//input[@type='file']")
	public WebElement browseButton;

	@FindBy(xpath="//div[@class='qq-uploader-selector qq-uploader custom-qq-uploader']")
	public WebElement clickUploadSection;

	@FindBy(xpath="//label[.='URL']/following-sibling::div//following-sibling::input")
	public WebElement enterUrl;




	//Dec 03
	@FindBy(xpath="//label[contains(.,'Upload Content')]/following::button[contains(.,'Upload')]")
	//@FindBy(xpath="//button[.='Upload']")

	public WebElement UploadButton;

	@FindBy(xpath="//input[@id='name']")
	public WebElement contentMp4Title;

	@FindBy(xpath="//textarea[@id='description']")
	public WebElement contentMp4Desc;

	@FindBy(xpath="//input[@placeholder='Add a tag']")
	public WebElement contentKeywords;

	@FindBy(xpath="//input[@id='searchMyImageAssets']")
	public WebElement searchUploadImage;

	@FindBy(xpath="//input[@id='searchMyImageAssets']/..//i[@class='circular search link icon inverted']")
	public WebElement clickImageSearch;

	//Updated on 06/09/2018
	@FindBy(xpath="//div[@class='ui image']//img[@class='asset_thumbnail']")
	public WebElement checkContentIcon;

	@FindBy(xpath="//input[@name='concepts']")
	public WebElement clickConcepts;

	@FindBy(xpath="//a[.='Artificial_Intelligence']")
	public WebElement selectConcept1;

	@FindBy(xpath="//a[.='Deep_Learning']")
	public WebElement selectConcept2;

	@FindBy(xpath="//a[.='Perceptron']")
	public WebElement selectSubConcept1;

	@FindBy(xpath="//a[.='RELU']")
	public WebElement selectSubConcept2;

	@FindBy(xpath="//a[.='Softmax']")
	public WebElement selectSubConcept3;


	//div[@id='topicSelector_defaultTemplate-topic']/..//a[contains(.,'Done')]
	@FindBy(xpath="//div[.='no-results']")
	public WebElement noResults;

	//---------------------------------------------------------------
	//Elements for creating a Collection

	@FindBy(xpath="(//label[.='Name']/following-sibling::div//following-sibling::input)[2]")
	public WebElement collectionTitle;


	@FindBy(id="dropdown-menu-list-header")
	public WebElement menuListHeader;

	@FindBy(xpath="//a[.='Workspace']")
	public WebElement listHeaderProfile;

	@FindBy(xpath="//label[.='Keywords']/..//div[@class='tags']//input[@placeholder='Enter Keywords']")
	public WebElement collectionKeywords;

	//Updated on 23/08/2018
	//@FindBy(xpath="//div[contains(text(),'Latest Resource')]/..//span[.='View All']")
	@FindBy(xpath="(//span[.='View All'])[1]")
	public WebElement viewAllButton;

	@FindBy(xpath="//div[@id='lessonBrowser_lessonType']")
	public WebElement filterCategory;

	@FindBy(xpath="//div[@data-value='Collection']")
	public WebElement collectionFilter;

	@FindBy(xpath="//div[@data-value='Resource']")
	public WebElement resourceFilter;

	@FindBy(id="apply-lesson-filter-button")
	public WebElement applyFilter;

	@FindBy(xpath="(//img[@class='resourceMetaImage '])[4]")
	public WebElement selectCollection;

	//Updated on 06/09/2018
	@FindBy(xpath="//div[@class='ui image']//img[@class='asset_thumbnail']")
	public WebElement checkCollectionIcon;

	@FindBy(xpath="//textarea")
	public List<WebElement> reviewComment;


	//Updated on 06/09/2018
	@FindBy(xpath="//h5[.='Comments']/..//textarea")
	public WebElement reviewComments;


	//Dec 05
	@FindBy(xpath="//div[contains(@class,'sbCard')]/div[@class='sub-header']/h4")
	//@FindBy(xpath="//div[@class='sbCard mt-20 mr-30']/div[@class='sub-header']/h4")
	//@FindBy(xpath="//span[@class='sliderCardHeading text-cencapitalize']")
	public WebElement getCourseName;

	@FindBy(xpath="//img[@class='resourceMetaImage ']")
	public WebElement selectExtraResource;

	//Dec 04
	//@FindBy(xpath="//div[@data-content='Send for review']/..//div[@class='ui pointing dropdown icon button']")
	@FindBy(xpath="//div[@data-content='Send for review']/..//div[contains(@class,'ui pointing dropdown')]")
	public WebElement limitedSharingArrow;

	@FindBy(xpath="//div[.=' Limited sharing']")
	public WebElement clickLimitedSharing;
	//---------------------------------------------

	//Updated on 06/09/2018
	//@FindBy(xpath="//input[@id='treePicker']")
	@FindBy(xpath="//input[@name='concepts']")
	public WebElement selectConcept;


	//Updated on 26/07/2018
	//@FindBy(xpath="//div[@id='conceptSelector_treePicker']//input[@placeholder='Search']")
	@FindBy(xpath="//div[@id='conceptSelector_questionMetaDataTemplate-concept']//input[@placeholder='Search']")
	public WebElement searchConcept;

	//Updated on 26/07/2018
	//@FindBy(xpath="//a[contains(text(),'Choose All')]")
	@FindBy(xpath="//div[@id='conceptSelector_questionMetaDataTemplate-concept']//a[contains(text(),'Choose All')]")
	public WebElement conceptChooseAll;

	//Updated on 26/07/2018
	//@FindBy(xpath="//a[contains(text(),'Done')]")
	@FindBy(xpath="//div[@id='conceptSelector_questionMetaDataTemplate-concept']//a[contains(text(),'Done')]")
	public WebElement conceptDoneButton;

	@FindBy(xpath="//sui-select[@id='resourceType']")
	public WebElement clickResourceType;

	@FindBy(xpath="//sui-select-option[@class='item']//span[.='Study material']")
	public WebElement selectResouceType;

	@FindBy(xpath="//div[@class='content-title-container row custom-row-1']/label")
	public WebElement untitledCollection;

	@FindBy(xpath="//i[@class='fa fa-picture-o custom-menu-icon']")
	//@FindBy(xpath="//i[@class='fa fa-camera']")
	public WebElement addImageIcon;

	//Element added on 02/07/2018
	@FindBy(xpath="//div[.='Uploading..']")
	public WebElement waitForUpload;

	/*@FindBy(xpath="//button[contains(text(),'Close')]")
	public WebElement closeButton;*/

	@FindBy(xpath="//button[contains(text(),'PUBLISH')]")
	public WebElement publishResource;

	@FindBy(xpath="//div[contains(@class,'dropdown right top pointing')]/..//a[contains(.,'My Activity')]")
	public WebElement myActivity;

	@FindBy(xpath="//div[contains(text(),'Select Course To See Dashboard')]")
	public WebElement searchCourseInActivity;

	//Elements for Test case 14

	@FindBy(xpath="//button[.='Close']")
	public WebElement closeContentPopup;

	//Adding elements for Test case 16



	//Adding elements for Test case 18
	@FindBy(xpath="//a[.='Edit']")
	public WebElement editDialCode;

	//Adding element for Reviewer test case 16

	@FindBy(xpath="//i[@class='remove icon custom-cursor']")
	public WebElement editorCloseIcon;



	//Adding elements for test case 14
	@FindBy(xpath="//span[@class='browse item cursor-pointer']")
	public WebElement filterIcon;

	@FindBy(xpath="//sui-multi-select[@id='subject']")
	public WebElement clickFilterSubject;

	@FindBy(xpath="//sui-multi-select[@id='subject']//span[.='English']")
	public WebElement selectFilterSubject;

	@FindBy(xpath="//sui-multi-select[@id='medium']")
	public WebElement clickFilterMedium;

	@FindBy(xpath="//sui-multi-select[@id='medium']//span[.='English']")
	public WebElement selectFilterMedium;

	@FindBy(xpath="//sui-multi-select[@id='contentType']")
	public WebElement clickContentType;

	@FindBy(xpath="//sui-multi-select[@id='contentType']//span[.='LessonPlan']")
	public WebElement selectContentType;

	@FindBy(xpath="//a[.='APPLY']")
	public WebElement applyButton;

	@FindBy(xpath="//div[@class='ui image']//img[@class='asset_thumbnail']")
	public WebElement contentResourceIcon;

	//Adding for Maintainance of Test case 2
	@FindBy(xpath="//button[contains(text(),'Upload and use')]")
	public WebElement uploadAndUseButton;


	@FindBy(xpath="//input[@id='assetfile']")
	public WebElement chooseFileButton;

	@FindBy(xpath="//button[@class='ui blue button submit button']")
	public WebElement uploadAndUseButtonRight;

	@FindBy(xpath="//div[contains(text(),'Select Course')]")
	public WebElement clickDashboardCourse;

	@FindBy(xpath="//div[contains(text(),'Select Course')]/..//sui-select-option")
	public WebElement selectDashboardCourse;


	// Added for send course for review popup, OCT 10



	//Added on 11 OCT - v1.11.0

	@FindBy(xpath="//a[@data-content='Add Audio']")
	public WebElement addAudio;

	@FindBy(linkText="All audio")
	public WebElement clickAllAudio;

	@FindBy(xpath="(//audio[@id='audio-5'])[2]")
	public WebElement selectAudio_AllAudio;



	@FindBy(xpath="//i[@class='trash large icon']")
	public List<WebElement> deleteButtonAll ;

	@FindBy(xpath="//button[.=' YES ']")
	public WebElement yesButtonPopup ;

	@FindBy(xpath="(//i[@class='trash large icon'])[1]")
	public WebElement deleteButton ;


	//Added on OCT 23 2018
	//@FindBy(xpath="(//*[@id='dropdown-menu-list-header'])[2]//following::a[@href='/profile']")
	@FindBy(xpath="//div[contains(@class,'dropdown right top pointing')]/..//a[contains(.,'Profile')]")
	public WebElement profileIconProfile;

	@FindBy(xpath="//a[@href='/workspace/content/uploaded/1']")
	public WebElement allUploads;

	@FindBy(xpath="//a[@href='/workspace/content/limited-publish/1']")
	public WebElement limitedPublishing;

	//Nov 22
	@FindBy(xpath="//div[@class='cardImageText center aligned ']/span")
	public WebElement getContentInDrafts;

	//Nov 22
	@FindBy(xpath="//span[contains(text(),'View Details')]")
	public WebElement viewDetails;



	@FindBy(xpath="(//sui-select-option[@value='Organisations'])[2]")
	public WebElement organisationsInSearch;

	@FindBy(xpath="(//i[@class='dropdown icon'])[2]")
	public WebElement searchDropdown;

	@FindBy(xpath="(//input[@class='checkBox'])[1]")
	public WebElement selectResourceN;

	@FindBy(xpath="(//div[@class='UpReviewHeader'])[1]")
	public WebElement searchCoursesUpForReviewE;

	@FindBy(xpath="//div[@class='ui button text-part popup-item']")
	//@FindBy(xpath="//div[@data-content='Send for review']")
	public WebElement sendForReviewA;

	@FindBy(xpath="//span[@class='ng-scope']")
	public WebElement editOrViewDetailslink;

	@FindBy(xpath="//button[contains(text(),'Close')]")
	public WebElement closeButtonMsg ;


	//Nov 23rd
	@FindBy(xpath="//label[contains(.,'Topics')]/..//topic-selector/..//input")
	public WebElement clickTopic;

	//Nov 23rd
	@FindBy(xpath="//div[@id='topicSelector_defaultTemplate-topic']//input[@placeholder='Search']")
	public WebElement searchTopic;

	//Nov 23rd
	@FindBy(xpath="//div[@class='ui tree-picker tree']/..//i[@class='add circle icon']/..//a")
	public WebElement selectTopic;



	//Nov 24
	@FindBy(xpath="(//sui-multi-select[@id='board'])[1]")
	//@FindBy(xpath="//sui-multi-select[@id='board']")
	public WebElement clickFilterBoard;


	//Nov 24
	@FindBy(xpath="//div[contains(text(),'TextBook')]")
	public List<WebElement> contentType;

	@FindBy(xpath="(//div[@class='content'])[1]")
	public WebElement searchedContent;

	//Nov 26 - v1.11.0
	//@FindBy(xpath="(//sui-multi-select[@id='gradeLevel']/..//sui-select-option[@class='item selected'])[2]")
	//@FindBy(xpath="//sui-multi-select[@id='gradeLevel']/..//sui-select-option[@class='item selected']")
	@FindBy(xpath="(//sui-multi-select[@id='gradeLevel'])[1]/..//sui-select-option")
	public List<WebElement> selectBookGrade;

	//Nov 27-Added
	@FindBy(xpath="//label[contains(.,'Name')]/following::input[@type='text' or @placeholder='Name']")
	public WebElement resourceName;


	//span[contains(.,'Create')]/following::input[@type='text']
	//span[contains(.,'Create')]/following::input[@type='text' or @placeholder='Name']
	//label[contains(.,'Name')]/following::input[@type='text' or @placeholder='Name']
	//label[contains(.,'Name')]/following::input[@type='text' or @placeholder='Name']



	//Dec 25
	@FindBy(xpath="(//div[contains(@class,'ui text menu m-0 ')])/a[contains(.,'Courses')]")
	//@FindBy(xpath="(//div[@class='ui text menu m-0 flex-jc-center d-flex']/a[2])[2]")
	//@FindBy(xpath="//div[@class='ui text menu m-0 jc-center flex']/following::a[contains(text(),'Courses')]")
	//@FindBy(xpath="//a[contains(text(),'Course')]")
	public WebElement headerCourse;
	/*
	//Nov 28th
	@FindBy(xpath="//div[contains(@class,'ui text menu m-0 ')]/following::a[contains(text(),'Library')]")
	//@FindBy(xpath="//div[@class='ui text menu m-0 jc-center flex']/following::a[contains(text(),'Library')]")
	//@FindBy(xpath="//a[contains(text(),'Library')]")
	public WebElement headerLibrary;
	 */
	//Nov 28th
	@FindBy(xpath="//div[@id='saveButton']//i")
	//@FindBy(xpath="//span[.='Save']")
	public WebElement saveCourse;

	//Nov 28
	@FindBy(xpath="//div[@class='no-result-text']")
	public WebElement noContentInUpForReview;

	//Nov 28
	@FindBy(xpath="//a[contains(text(),'Published')]")
	public WebElement published;

	//Nov 28
	@FindBy(xpath="//a[contains(text(),'Drafts')]")
	public WebElement drafts;

	//Nov 28
	//@FindBy(xpath="//a[.=' All My Content ']")
	@FindBy(xpath="//a[@href='/workspace/content/allcontent/1']")
	public WebElement allMyContent;

	//Nov 28
	//@FindBy(xpath="//a[.='Done']")
	//@FindBy(xpath="*//a[.='Done']")
	@FindBy(xpath="//div[contains(@id,'Selector_defaultTemplate')]//a[(.='Done')]")
	public WebElement doneButton;



	//Nov 28
	@FindBy(xpath="//div[@class='ui button text-part popup-item']//i[@class='send icon']")
	//@FindBy(xpath="//div[@class='ui button text-part popup-item']")
	public WebElement sendForReview;

	/*//Dec 03
	@FindBy(xpath="//label[contains(.,'MEDIUM')]/..//div[contains(@class,'item')]")
	//@FindBy(xpath="//div[@class='default text']/following::div[@class='item selected']")
	public WebElement selectMedium;
	 */

	//Nov 29
	@FindBy(xpath="//label[contains(.,'Name')]/..//input")
	//@FindBy(xpath="//label[contains(text(),'Title')]//following::input[@placeholder='Enter title for Book']")
	public WebElement bookName;




	//Nov 30
	@FindBy(xpath="//label[contains(.,'Name')]/..//input")
	public WebElement lessonPlanName;


	//--------------------------------------------------

	// @Author Sachin

	@FindBy(xpath = "//sui-select-option[@class='item selected']//span[.='State (Rajasthan)']")
	public WebElement selectRajasthanBoard;

	// @Author Sachin
	@FindBy(xpath = "//sui-multi-select[@id='gradeLevel']")
	public WebElement clickFilterClass;

	// @Author Sachin
	// @FindBy(xpath="(//sui-select[@id='board']/..//sui-select-option[@class='item'])[1]")
	@FindBy(xpath = "//sui-select-option[@class='item selected']//span[.='Class 9']")
	public WebElement selectClass9;

	// @author Sachin
	// Web Element firstContent
	@FindBy(xpath = "(//td[contains(.,'Untitled Course Course')])[1]")
	public WebElement firstContent;

	// @author Sachin
	// Web Element mainSearchBar
	@FindBy(xpath = "//*[@id='search-input-container']/div[2]/div")
	public WebElement mainSearchBar;

	// @author Sachin
	// Web Element firstLessonPlan
	@FindBy(xpath = "(//td[contains(.,'Untitled Collection LessonPlan')])[1]")
	public WebElement firstLessonPlan;

	// @author Sachin
	// Web Element resource1
	@FindBy(xpath = "//*[@id='ngdialog1']/div[2]/div/div[2]/div/div/div/div/div/div[1]/div[2]/div[1]/div[2]")
	public WebElement resource1;

	// @author Sachin
	// Web Element resource2
	@FindBy(xpath = "//*[@id='ngdialog1']/div[2]/div/div[2]/div/div/div/div/div/div[1]/div[2]/div[2]/div[2]/div[2]")
	public WebElement resource2;

	// @author Sachin
	// Web Element resource3
	@FindBy(xpath = "//*[@id='ngdialog1']/div[2]/div/div[2]/div/div/div/div/div/div[1]/div[2]/div[3]/div[2]/div[2]")
	public WebElement resource3;

	// @author Sachin
	// Web Element deleteIcon
	@FindBy(xpath = "//*[@id='content-list']/div/div[1]/div/div/div[2]/div[4]/i[2]")
	public WebElement deleteIcon;

	// @author Sachin
	// Web Element yesConfirmation
	@FindBy(xpath = "//*[@id='deletePopup']/div/button")
	public WebElement yesConfirmation;

	// @author Sachin
	// Web Element cancelButton
	@FindBy(xpath = "//*[@id='deletePopup']/div/div/div[2]/i")
	public WebElement cancelButton;

	// @author Sachin
	// Web Element confirmPublish
	@FindBy(xpath = "//*[@id='review-footer']/div/button[2]")
	public WebElement confirmPublish;

	// @author Sachin
	// Web Element creatorProfileIcon
	@FindBy(xpath = "//*[@id=\"dropdown-menu-list-header\"]/img")
	public WebElement creatorProfileIcon;

	// @author Sachin
	// Web Element creatorWorkspace
	@FindBy(xpath = "//*[@id=\"dropdown-menu-list-header\"]/div/a[3]")
	public WebElement creatorWorkspace;



	// @author Sachin
	// Web Element requestChange
	@FindBy(xpath = "//*[@id=\"commonHeader\"]/div/div[4]/div/div/div[2]/div[7]/span")
	public WebElement requestChange;

	// @author Sachin
	// Web Element clickPreview
	@FindBy(xpath = "//*[@id=\"content-list\"]/div/div/div/div/div[2]/div[4]/i[1]")
	public WebElement clickPreview;

	//		// @author sachin
	//		@FindBy(xpath = "/html/body/app-root/div/app-workspace/div/div[3]/app-up-for-review/table/tbody/tr[1]/td[1]")
	//		public WebElement recentContent;

	// @author Sachin
	// Web Element ProfileImage
	@FindBy(xpath = "//*[@id=\"dropdown-menu-list-header\"]/img")
	public WebElement profileIcon;

	// @author Sachin
	// Web Element sortByDropdown
	@FindBy(xpath = "//*[@id=\"sortByDropDown\"]/sui-select/i")
	public WebElement sortByDropdown;

	// @author Sachin
	// Web Element modifiedOn
	@FindBy(xpath = "//*[@id=\"sortByDropDown\"]/sui-select/div[3]/sui-select-option[1]/span[2]")
	public WebElement modifiedOn;

	// @author Sachin
	// Web Element createdOn
	@FindBy(xpath = "//*[@id=\"sortByDropDown\"]/sui-select/div[2]/sui-select-option[2]/span[2]")
	public WebElement createdOn;

	// @author Sachin
	// Web Element dropDown2
	@FindBy(xpath = "//*[@id=\"sortByDropDown\"]/sui-select/i")
	public WebElement dropDown2;

	// @author Sachin
	// Web Element selectStatus
	@FindBy(xpath = "//sui-multi-select[contains(@id,'status')]")
	public WebElement selectStatus;

	// @author Sachin
	// Web Element draftSelect
	@FindBy(xpath = "//sui-select-option[@class='item selected'][contains(.,'Draft')]")
	public WebElement draftSelect;

	// @author Sachin
	// Web Element confirmYesToPopup
	@FindBy(xpath = "//button[@class='ui primary button'][contains(.,'Yes')]")
	public WebElement confirmYesToPopup;

	// @author Sachin
	// Web Element searchContentClick
	@FindBy(xpath = "//i[@class='circular search link icon']")
	public WebElement searchContentClick;

	// @author Sachin
	// Web Element selectLive
	@FindBy(xpath = "//*[@id=\"status\"]/div[2]/sui-select-option[5]/span[2]")
	public WebElement selectLive;

	// @author Sachin
	// Web Element searchContentPlaceHolder
	@FindBy(xpath = "//input[@placeholder='Search content']")
	public WebElement searchContentPlaceHolder;

	// @author Sachin
	// Web Element addQuestionSet
	@FindBy(xpath = "//*[contains(@class, 'icon-questions icon custom-menu-icon')]")
	public WebElement addQuestionSet;

	// @author Sachin
	// Web Element createQuestion


	// @author Sachin
	// Web Element MCQ
	@FindBy(xpath = "//*[@id='templatsCards']/div/div[1]/div[3]/div/div")
	public WebElement MCQ;

	// @author Sachin
	// Web Element MTF
	@FindBy(xpath = "//*[@id='templatsCards']/div/div[2]/div[3]/div/div")
	public WebElement MTF;

	// @author Sachin
	// Web Element FIB
	@FindBy(xpath = "//*[@id='templatsCards']/div/div[3]/div[3]/div/div")
	public WebElement FTB;

	// @author Sachin
	// Web Element Back
	@FindBy(xpath = "//button[contains(@id,'back-button')]")
	public WebElement Back;

	// @author Sachin
	// Web Element SortByDropdown
	@FindBy(xpath = "(//i[contains(@class,'dropdown icon')])[4]")
	public WebElement SortByDropdown;	

	// @author Sachin
	// Web Element modifiedOnDropdown
	@FindBy(xpath = "//span[contains(.,'Modified On')]")
	public WebElement modifiedOnDropdown;

	// @author Sachin
	// Web Element createdOnDropdown
	@FindBy(xpath = "//span[contains(.,'Created On')]")
	public WebElement createdOnDropdown;

	// @author Sachin
	// Web Element flagDraftSelect
	@FindBy(xpath = "//sui-select-option[@class='item'][contains(.,'FlagDraft')]")
	public WebElement flagDraftSelect;

	// @author Sachin
	// Web Element reviewSelect
	@FindBy(xpath = "(//sui-select-option[@class='item'][contains(.,'Review')])[1]")
	public WebElement reviewSelect;

	// @author Sachin
	// Web Element processingSelect
	@FindBy(xpath = "//sui-select-option[contains(.,'Processing')]")
	public WebElement processingSelect;

	// @author Sachin
	// Web Element liveSelect
	@FindBy(xpath = "//sui-select-option[@class='item'][contains(.,'Live')]")
	public WebElement liveSelect;

	// @author Sachin
	// Web Element unlistedSelect
	@FindBy(xpath = "//sui-select-option[@class='item'][contains(.,'Unlisted')]")
	public WebElement unlistedSelect;

	// @author Sachin
	// Web Element flagReviewSelect
	@FindBy(xpath = "//sui-select-option[@class='item'][contains(.,'FlagReview')]")
	public WebElement flagReviewSelect;

	// @author Sachin
	// Web Element resetFilter
	@FindBy(xpath = "//a[contains(.,'RESET')]")
	public WebElement resetFilter;

	// @author Sachin
	// Web Element firstDraft
	@FindBy(xpath = "(//div[contains(@class,'UpReviewHeader')])[1]")
	public WebElement firstDraft;

	// @author Sachin
	// Web Element searchContent
	@FindBy(xpath = "//input[@placeholder='Search content']")
	public WebElement searchContent;

	// @author Sachin
	// Web Element No Content 
	@FindBy(xpath = "//div[contains(@class,'no-result-text')]")
	public WebElement noContent;

	// @author Sachin
	// Web Element No Content 
	@FindBy(xpath = "(//div[contains(@class,'sub-header')])[1]")
	public WebElement course;

	// @author Sachin
	// Web Element No Content 
	@FindBy(xpath = "//i[contains(@class,'close icon')]")
	public WebElement closePopUp;


	@FindBy(xpath="//input[@placeholder='Enter title for Book']")
	public WebElement untitledNameB;



	@FindBy(xpath="//label[contains(.,'MEDIUM')]/following::div")
	public WebElement clickMedium;

	@FindBy(xpath="//label[contains(.,'MEDIUM')]/following::div//div[@class='item selected']")
	public WebElement selectMediumN;

	@FindBy(xpath="//label[contains(.,'CLASS')]/following::div")
	public WebElement clickClassN;

	@FindBy(xpath="//label[contains(.,'CLASS')]/following::div//div[@class='item']")
	public WebElement selectClassN;

	@FindBy(xpath="//label[contains(.,'SUBJECT')]/following::div")
	public WebElement clickSubject;

	@FindBy(xpath="//label[contains(.,'SUBJECT')]/following::div//div[@class='item selected']")
	public WebElement selectSubjectN;

	@FindBy(xpath="//select[@id='_selectyear']")
	//@FindBy(xpath="//div[.='Year']")
	public WebElement selectyear;

	//@FindBy(xpath="//div[.='2018']")
	@FindBy(xpath="//option[.='2018']")
	public WebElement select2018;

	@FindBy(xpath="//div[.='2005']")
	public WebElement select2005;

	@FindBy(xpath="//div[@class='iziToast-body']")
	public WebElement successToastMessage;





	@FindBy(xpath="//input[@id='name'][1]")
	public WebElement reviewCourseName;



	//Dec 13
	@FindBy(xpath="//label[contains(text(),'MEDIUM')]/following::div[1]")
	public WebElement clickOnSelectMedium;


	//Dec 03
	@FindBy(xpath="//label[contains(.,'MEDIUM')]/..//div[contains(@class,'item')][1]")
	//@FindBy(xpath="//div[@class='default text']/following::div[@class='item selected']")
	public WebElement selectMedium;

	//@FindBy(xpath="//button[contains(text(),'PUBLISH')]")
	@FindBy(xpath="//span[contains(text(),'Publish')]")
	public WebElement publishCourse;

	@FindBy(xpath="(//input[@placeholder='Enter title for Book'])[2]")
	public WebElement untitledName;

	@FindBy(xpath="//input[@placeholder='Enter title for unit']")
	public WebElement untitledUnitName;

	//added on 16 Sep
	@FindBy(xpath="//button[contains(text(),'Create question')]")
	public WebElement createQuestion;

	@FindBy(xpath="//a[contains(text(),'Multiple Choice Question')]/following::div[3]")
	public WebElement selectMCQTemplate;

	@FindBy(xpath="//a[contains(text(),'Match The Following')]/following::div[3]")
	public WebElement selectMTFTemplate;

	@FindBy(xpath="//a[contains(text(),'Fill in the Blanks')]/following::div[3]")
	public WebElement selectFITBTemplate;

	@FindBy(xpath="//iframe[@frameborder='0']")
	public WebElement writeQuestion ;

	//@FindBy(xpath="(//input[@placeholder='Enter answer'])[1]")
	@FindBy(id="mcqoptions_0")
	public WebElement inputAnswer1 ;

	@FindBy(id="mcqoptions_1")
	public WebElement inputAnswer2 ;

	@FindBy(xpath="//button[.='Add answer']")
	public WebElement addAnswer ;

	//@FindBy(xpath="(//label[contains(text(),'Mark as right answer')])[1]")
	@FindBy(xpath="//input[@id='0']")
	public WebElement markAsRightAnswer ;

	@FindBy(xpath="//button[.='Refresh']")
	public WebElement previewRefreshIcon ;

	@FindBy(xpath="//div[@class='ps-body']")
	public WebElement nextArrowPreview  ;

	@FindBy(xpath="(//img[@class='ui centered tiny image select-template'])[1]")
	public WebElement selectLayout   ;

	@FindBy(xpath="(//div[.='Select Medium'])[2]")
	public WebElement mediumInQuestion ;



	@FindBy(xpath="(//div[.='Select Level'])[2]")
	public WebElement levelInQuestion ;

	@FindBy(xpath="(//div[.='EASY'])[2]")
	public WebElement selectEasy ;

	@FindBy(xpath="(//div[.='Select Grade'])")
	public WebElement gradeLevelInQuestion ;

	@FindBy(xpath="(//div[.='Class 4'])[2]")
	public WebElement selectClass4 ;

	@FindBy(xpath="(//div[.='Select Subject'])[2]")
	public WebElement subjectInQuestion ;

	@FindBy(xpath="(//div[.='Mathematics'])[2]")
	public WebElement selectMathematics ;

	//@FindBy(xpath="(//div[.='Select Board/Syllabus'])[2]")
	@FindBy(xpath="(//div[.='Select Board'])[2]")
	public WebElement boardInQuestion ;

	@FindBy(xpath="//input[@placeholder='Enter the Max Score']")
	public WebElement maxScore  ;

	@FindBy(xpath="//input[@id='questionMetaDataTemplate-concept']")
	public WebElement Concepts ;

	@FindBy(xpath="(//button[@id='save-question-button'])[2]")
	public WebElement submitButtonInQuestion  ;

	@FindBy(xpath="//button[@id='add-more-ques-button']")
	public WebElement addMoreQuestion   ;

	@FindBy(xpath="(//input[@id='mtf-optionLHS'])[1]")
	public WebElement enterAnswer1 ;

	@FindBy(xpath="(//input[@id='mtf-optionRHS-input'])[1]")
	public WebElement enterAnswer2 ;

	@FindBy(xpath="(//input[@id='mtf-optionLHS'])[2]")
	public WebElement enterAnswer3 ;

	@FindBy(xpath="(//input[@id='mtf-optionRHS-input'])[2]")
	public WebElement enterAnswer4 ;

	@FindBy(xpath="(//input[@id='mtf-optionLHS'])[3]")
	public WebElement enterAnswer5 ;

	@FindBy(xpath="(//input[@id='mtf-optionRHS-input'])[3]")
	public WebElement enterAnswer6 ;

	@FindBy(xpath="//input[@id='ans-field1']")
	public WebElement answerFITB ;

	@FindBy(xpath="//li[@class='ps-action-list__item']")
	public WebElement nextInPreview ;

	@FindBy(xpath="(//div[@class='option-text-container '])[1]")
	public WebElement answerMCQ  ;

	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	//@FindBy(xpath="//div[@class='form-group segment textBoxDiv questionTextBox']//textarea")
	public WebElement enterTheQuestion;

	@FindBy(xpath="//button[@id='next-button']")
	public WebElement createQueNext;

	@FindBy(xpath="(//div[.='English'])[3]")
	public WebElement selectEnglishQues;

	@FindBy(xpath="(//div[.='CBSE'])[2]")
	public WebElement selectCBSEQue;

	@FindBy(xpath="//input[@placeholder='Enter the Title']")
	public WebElement enterTheTitleQues;



	@FindBy(xpath="(//i[@class='dropdown icon'])[3]")
	public WebElement showFilter;



	@FindBy(xpath="(//div[.='Select Medium'])[2]/following::div/div[2]")
	public WebElement selectEnglishFITB;

	@FindBy(xpath="(//button[contains(text(),'Add')])[2]")
	public WebElement addAnotherQuestion  ;

	@FindBy(xpath="//iframe[@id='iframeArea']")
	public WebElement previewFrame ;

	@FindBy(xpath="//img[@id='org-ekstep-contentrenderer-questionunit-questionComponent-downArwImg']")
	public WebElement downButtonPreview ;

	@FindBy(xpath="//div[@class='expand-container ']//p[contains(text(),'days?')]")
	public WebElement previewContainer;

	@FindBy(xpath="(//input[@name='filter_search'])[2]")
	public WebElement searchInActivity;

	@FindBy(xpath="//i[@data-content='Delete']")
	public WebElement deleteResource;

	@FindBy(xpath="//button[.='YES, DELETE']")
	public WebElement yesDeleteResource;

	@FindBy(xpath="//i[@class='upload icon custom-icon']")
	public WebElement uploadNewfile;

	@FindBy(xpath="//i[@ng-click='fireEvent(stage.ondelete)']")
	public WebElement deleteSlide;

	@FindBy(xpath="//button[.='Delete']")
	public WebElement deleteConfirmationPopup;

	@FindBy(xpath="//img[@ng-click='fireEvent(stage.getOnClick())']")
	public List<WebElement> existingSlide;

	@FindBy(xpath="(//div[.='Urdu'])[4]")
	public WebElement selectUrdu4 ;

	@FindBy(xpath="(//div[.='Urdu'])[2]")
	public WebElement selectUrdu2 ;

	@FindBy(xpath="(//input[@type='checkbox'])[6]")
	public WebElement questionCheckbox  ;

	@FindBy(xpath="//button[contains(text(),'Next')]")
	public WebElement nextButton  ;

	@FindBy(xpath="//input[@placeholder='Question Set Title']")
	public WebElement questionSetTitle  ;

	@FindBy(xpath="(//button[contains(text(),'Add')])[3]")
	public WebElement addbutton  ;

	@FindBy(xpath="//i[@class='icon-save']")
	public WebElement saveIcon;	

	//@FindBy(xpath="//i[@class='remove icon custom-cursor']")
	@FindBy(xpath="//i[@class='remove icon custom-cursor']")
	public WebElement closePage  ;

	@FindBy(xpath="(//span[@class='sliderCardHeading text-cencapitalize'])[1]")
	public WebElement createdResorce  ;

	@FindBy(xpath="//sui-multi-select[@id='status']")
	public WebElement clickFilterStatus;

	@FindBy(xpath="//sui-multi-select[@id='status']//span[.='Live']")
	public WebElement selectFilterStatusLive;

	@FindBy(xpath="//i[@id='stage']")
	public WebElement addSlide ;

	@FindBy(xpath="//i[@id='shape']")
	public WebElement addShape  ;

	@FindBy(xpath="//div[@class='menu transition visible']/a[1]")
	public WebElement addTriangle  ;

	@FindBy(xpath="//i[@id='image']")
	public WebElement addImage  ;



	@FindBy(xpath="//a[@data-content='Add Hotspot']")
	public WebElement addHotspot  ;

	@FindBy(xpath="//i[@id='scribblepad']")
	public WebElement addScribblepad  ;

	@FindBy(xpath="//i[@id='activitybrowser']")
	public WebElement addActivity  ;

	@FindBy(xpath="//input[@placeholder='Search activity']")
	public WebElement searchActivity  ;

	@FindBy(xpath="(//i[@class='dropdown icon'])[6]")
	public WebElement categoryType  ;

	@FindBy(xpath="//div[text()='core']")
	public WebElement typeCore  ;

	@FindBy(xpath="//div[contains(text(),'Triangles- Introduction')]")
	public WebElement triangleIntroduction  ;

	@FindBy(xpath="(//img[@class='activity-appicon'])[1]")
	public WebElement mathText  ;

	@FindBy(xpath="(//button[text()='Add'])[2]")
	public WebElement addButtonInActivity   ;

	@FindBy(xpath="//i[@id='videoPlugin']")
	public WebElement addVideo  ;

	@FindBy(xpath="//input[@placeholder='Paste video URL here']")
	public WebElement pasteVideoUrl  ;

	@FindBy(xpath="//div[text()='Go']")
	public WebElement goButton  ;

	@FindBy(xpath="//button[text()='Add To Lesson']")
	public WebElement addToLesson  ;

	@FindBy(xpath="//div[@class='ui image']")
	public WebElement img1;


	@FindBy(xpath="//span[contains(text(),'Lesson Plan')]")
	public WebElement clickLessonplan ;



	//Dec 15
	//@FindBy(xpath="//div[@id='board']")
	@FindBy(xpath="//label[contains(text(),'BOARD')]/following::div[1]/..//i")
	public WebElement clickBoard;

	@FindBy(xpath="//div[@id='board']/..//div[contains(@class,'item')][1]")
	//@FindBy(xpath="//label[contains(.,'BOARD')]/..//div[contains(@class,'item')][1]")
	public WebElement selectBoard;


	//Dec 15
	@FindBy(xpath="//label[contains(text(),'OWNER')]/following::div[1]/div[.='Owner']")
	//@FindBy(xpath="//label[contains(text(),'OWNER')]/following::div[1]")
	public WebElement clickOwner;


	@FindBy(xpath="//label[contains(.,'OWNER')]/..//div[contains(@class,'item')][1]")
	public WebElement selectOwner;
	
	@FindBy(xpath="//label[contains(.,'OWNER')]/..//div[contains(@class,'item')][2]")
	public WebElement selectOwner2;

	//Dec 15

	@FindBy(xpath="//span[@class='sliderCardHeading text-cencapitalize'][1]")
	public WebElement getContentFromDraft;

	//Dec 15
	@FindBy(xpath="//i[@class='linkify large icon float-ContentLeft limitedPublishingLinkIcon'][1]")
	public WebElement clickGobuton;




	
	@FindBy(xpath="//input[@placeholder='Name']")
	//@FindBy(xpath="//label[contains(text(),'Name')]/following::input[@name='name'][@placeholder='Enter title for Book'][2]")
	//	@FindBy(xpath="//div[@class='ui modal ng-scope transition visible active']//input[@placeholder='Name']")
	//	@FindBy(xpath="//div[@class='ui modal scroll transition active visible normal']/..//input[@placeholder='Name']")
	//	@FindBy(xpath="//label[contains(text(),'Name')]/following-sibling::div/input")
	//	@FindBy(xpath="//form[@class='ui form ng-untouched ng-pristine ng-valid']//input")
	public WebElement courseName;

	@FindBy(xpath="//label[contains(text(),'Name')]/following::input[@name='name'][@placeholder='Enter title for Book'][2]")
	public WebElement collectionName;


	@FindBy(xpath="//textarea[@placeholder='Brief description about the content']")
	public WebElement courseDescription;


	@FindBy(xpath="//button[contains(text(),'Select')]")
	public WebElement selectImage;

	// Web element editDetails
	@FindBy(xpath="//span[@ng-if='showEditMeta'][contains(.,'Edit Details')]")
	public WebElement editDetails;

	//@author sachin
	// Web element editDetailsTitle
	@FindBy(xpath="//input[contains(@id,'name')]")
	public WebElement editDetailsTitle;

	@FindBy(xpath="//i[contains(@class,'red remove circle')]")
	public WebElement removeBookDialcode;

	@FindBy(xpath="//div[@class='header p-15 pb-0']")
	public WebElement searchedContentForUpload;

	@FindBy(xpath="(//button[text()='Add'])[2]")
	public WebElement add ;

	@FindBy(xpath="//input[@id='contributors']")
	public WebElement listOfContributors ;

	@FindBy(xpath="//div[.='Select Language']")
	public WebElement selectLanguage;

	@FindBy(xpath="//div[.='Select Language']/following::div/div[1]")
	public WebElement selectedLanguage ;

	//dec 27
	@FindBy(xpath="//a[@href='/resources']")

	public WebElement headerLibrary;

	//Dec 27
	@FindBy(xpath="//button[contains(text(),'Use Editor')]")
	public WebElement clickUseEditor;

	//Dec 28    
	@FindBy(xpath="(//*[@id='dropdown-menu-list-header'])")
	public WebElement profileIconDropdown;




	//Dec 28

	@FindBy(xpath="//div[@class='sub-header']//h4")
	public WebElement headerCourseTitles;

	@FindBy(xpath="//img[@class='ui tiny centered image']")
	public WebElement logoInMetadataPage;
	
	
	//Feb 5
	
	@FindBy(xpath="//input[@id='name']")
	public WebElement titleNameForCourse;
	
	@FindBy(xpath="//textarea[@id='description']")
	public WebElement titleDescriptionForCourse;
	
	@FindBy(xpath="//input[@placeholder='Add a tag']")
	public WebElement titleKeywordForCourse;
	
	@FindBy(xpath="(//textarea[@id='description'])[2]")
	public WebElement enterDescriptionForCourse;
	
	@FindBy(xpath="//input[@id='defaultTemplate-topic']")
	public WebElement topicForCourse;
	
	@FindBy(xpath="(//a[@class='name'])[1]")
	public WebElement topicSelectedForCourse;
	
	//Feb 13
	
	@FindBy(xpath="//input[@value='Yes']")
	public WebElement QRcodeRequiredYes;
	
	@FindBy(xpath="//input[@placeholder='Enter code here']")
	public WebElement dialcodeEnter;
	
	@FindBy(xpath="//i[@class='large check circle icon']")
	public WebElement validatedialcodeEnterYes;
	
	@FindBy(xpath="//span[.='Invalid DIAL code']")
	public WebElement invalidDialCode;
	
	@FindBy(xpath="//i[@class='small green check icon']")
	public WebElement validDialCodeSymbol;
	
	@FindBy(xpath="//label[contains(.,'CREDIT TO')]/..//input")
	public WebElement creditTo;
	
	@FindBy(xpath="//select[@id='_selectownedBy']/../div[1]")
	public WebElement selectedOwnerType;
	
	@FindBy(xpath="//a[@href='/workspace/content/collaborating-on/1']")
	public WebElement collaborations;

	
}


