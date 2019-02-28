package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContentCreationResourcePage 
{

	WebDriver driver;

	public  ContentCreationResourcePage(WebDriver driver)
	{ 
		this.driver=driver; 
	}

	//Updated on 06 Nov
	//@FindBy(xpath="//a[text()='Announcement dashboard']")
	@FindBy(xpath="(//a[text()='Announcement dashboard'])[2]")	
	public WebElement profileIconAnnouncementDashboard;

	@FindBy(xpath="//a[text()='Workspace']")
	public WebElement profileIconWorkspace;

	//Updated on 06 Nov
	@FindBy(xpath="(//a[text()='Logout'])[2]")
	//@FindBy(xpath="//a[text()='Logout']")
	public WebElement profileIconLogout;

	//Updated on 06 Nov
	@FindBy(xpath="(//a[text()='My Activity'])[2]")
	//@FindBy(xpath="//a[text()='My Activity']")
	public WebElement profileIconActivity;

	//Updated on 06 Nov
	@FindBy(xpath="(//a[text()='Profile'])[2]")
	//@FindBy(xpath="//div[@id='dropdown-menu-list-header']//a[text()='Profile']")
	public WebElement profileIconProfile;

	
	//Added For Test case TC_073


	@FindBy(xpath="//a[contains(text(),' All My Content ')]")
	public WebElement allMyActivity;

	@FindBy(xpath="//a[contains(text(),'Review Submissions')]")
	public WebElement reviewSubmissions;

	@FindBy(xpath="//a[contains(text(),' Drafts')]")
	public WebElement drafts;

	@FindBy(xpath="//a[contains(text(),'Published')]")
	public WebElement published;

	@FindBy(xpath="//a[contains(text(),'All Uploads')]")
	public WebElement allUploads;

	@FindBy(xpath="//a[contains(text(),'Up For Review')]")
	public WebElement upForReview;

	@FindBy(xpath="//a[contains(text(),'Flag Review')]")
	public WebElement flagReview;

	@FindBy(xpath="//a[contains(text(),'Limited Publishing')]")
	public WebElement limitedPublishing;

	@FindBy(xpath="//span[contains(text(),' Show Filters ')]")
	public WebElement showFilters;


	//FOR 'APPLY' BUTTON LOCATOR IS ALREADY PRESENT IN createUserPage
	@FindBy(xpath="//a[.='APPLY']")
	public WebElement filterApplyButton;

	@FindBy(xpath="//a[.='RESET']")
	public WebElement filterResetButton;

	@FindBy(xpath="//sui-select[@labelfield='name']")
	public WebElement sortByIcon;

	//TC_74 Click on copy
	@FindBy(xpath="//i[@class='ui large blue clone outline icon']")
	public  WebElement courseCopyIcon;

	@FindBy(xpath="(//div[@class='player-badge-alignment']//i)[7]")
	public WebElement libraryContentCopyIcon;

	@FindBy(xpath="//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement copiedContentName;

	@FindBy(xpath="//span[1][@class='ng-binding']")
	public  WebElement textOnEditPage;

	@FindBy(xpath="//span[@class='ui HomeAccordianHeading left floated header']")
	public WebElement searchedClickedCourseResource;



	@FindBy(xpath=".//div[@class='sbCard mt-20 mr-30']/..//h4")
	public WebElement draftsCopiedContentName;

	//TC_76 

	@FindBy(xpath="//a[@data-content='Add Slide']")
	public WebElement addSlide;

	@FindBy(xpath="//a[@data-content='Add Text']")
	public WebElement addText;

	@FindBy(xpath="//textarea[@placeholder='Add text here']")
	public WebElement addTextTextArea;

	@FindBy(xpath="//button[.='Done']")
	public WebElement addTextDoneButton;

	//Updated on 05 Sep
	//@FindBy(xpath="//a[@data-content='Add Shapes']")

	@FindBy(xpath="//div[@data-content='Add Shapes']")
	public WebElement addShapes;

	@FindBy(xpath="//span[.='Triangle']")
	public WebElement addTriangleShape;

	@FindBy(xpath="//a[@data-content='Add Image']")
	public WebElement addImage;

	@FindBy(xpath="//img[@class='asset_thumbnail']")
	public WebElement resourceImage;

	@FindBy(xpath="//a[@data-content='Add Audio']")
	public WebElement addAudio;

	@FindBy(xpath="//div[@class='audioitem infopopover']")
	public static WebElement selectMyAudio;



	@FindBy(xpath="(//audio[@id='audio-5'])[2]")
	public WebElement selectAudio_AllAudio;

	@FindBy(xpath="//a[@data-content='Add Hotspot']")
	public WebElement addHotspot;

	@FindBy(xpath="//a[@data-content='Add Scribblepad']")
	public WebElement addScribblepad;

	@FindBy(xpath="//a[@data-content='Add Video']")
	public WebElement addVideo;

	// ADD QUESTION SET
	@FindBy(xpath="//a[@data-content='Add Question Set']")
	public WebElement addQuestionSet;

	@FindBy(xpath="//button[contains(text(),'Create question')]")
	public WebElement createQuestion;

	@FindBy(xpath="//div[@class='card card-hover-effect ng-scope']//div[contains(text(),'Select')]")
	public WebElement questionTemplateSelect;

	//Updated on 05 Sep
	//@FindBy(xpath="//textarea[@placeholder='Enter the question']")


	@FindBy(xpath="//body[@class='cke_editable cke_editable_themed cke_contents_ltr cke_show_borders']")
	//@FindBy(xpath="//div[@class='form-group segment textBoxDiv questionTextBox']//textarea")
	public WebElement enterTheQuestion;

	//Nov 30
	//@FindBy(xpath="//div[@id='options_0']//p")
	//@FindBy(xpath="//div//input[@name='options_0']")
	//@FindBy(xpath="//div[@class='form-group segment textBoxDiv']//input")


	
	@FindBy(xpath="//button[@id='next-button']")
	public WebElement createQueNext;

	@FindBy(xpath="(//label[contains(text(),'Mark as right answer')])[1]")
	public WebElement markAsRight;

	@FindBy(xpath="//label[.='LEVEL']/..//div[.='Select Level']")
	public WebElement clickLevel;



	@FindBy(xpath="//label[.='GRADE LEVEL']/..//div[.='Select Grade']")
	public WebElement clickGrade;

	@FindBy(xpath="//div[.='Select Grade']/..//div[@class='item selected']")
	public WebElement selectGrade;

	@FindBy(xpath="//label[.='SUBJECT']/..//div[.='Select Subject']")
	public WebElement clickSubject;

	

	@FindBy(xpath="//label[.='BOARD']/..//div[.='Select Board']")
	public WebElement clickBoard;

	

	@FindBy(xpath="//label[.='MAX SCORE']/..//input[@id='max_score']")
	public WebElement questionMaxScore;

	@FindBy(xpath="//label[.='CONCEPTS']/..//input[@name='concepts']")
	public WebElement clickConcepts;

	@FindBy(xpath="//div[@id='conceptSelector_questionMetaDataTemplate-concept']//input[@placeholder='Search']")
	public WebElement searchConcepts;

	@FindBy(xpath="//div[@id='conceptSelector_questionMetaDataTemplate-concept']//a[contains(text(),'Choose All')]")
	public WebElement conceptChooseAll;

	@FindBy(xpath="//div[@id='conceptSelector_questionMetaDataTemplate-concept']//a[.='Done']")
	public WebElement conceptDoneButton;

	@FindBy(xpath="//button[contains(text(),'Submit')]")
	public WebElement QueSubmitButton;

	@FindBy(xpath="//div[@class='header ng-binding']")
	public WebElement pickQuestion;

	@FindBy(xpath="//div[@class='seven wide column qb-question-container']//input")
	public WebElement pickQuestionCheckBox;

	@FindBy(xpath="//button[contains(text(),'Next')]")
	public WebElement pickQueNextButton;

	@FindBy(xpath="//input[@placeholder='Question Set Title']")
	public WebElement questionSetTitle;

	@FindBy(xpath="(//button[contains(text(),'Add')])[3]")
	public WebElement questionSetAddButton;

	//
	@FindBy(xpath="//a[@data-content='Add Math text']")
	public WebElement addMathText;

	@FindBy(xpath="//div[@class='math-lib-header ng-binding']")
	public WebElement selectMathText;

	@FindBy(xpath="//button[@class='ui basic primary button math-add-button']")
	public WebElement selectedMathTextAdd;

	@FindBy(xpath="//img[@class='asset_thumbnail']")
	public WebElement checkAppIcon;

	//SelectAppIcon is in CreatorUP



	//Added for Test case 79

	//Updated ON 08  Nov 
	@FindBy(xpath="//input[@placeholder='Paste video URL here']")
	//@FindBy(xpath="//input[@placeholder='Paste video URL...']")
	public WebElement pasteVideoUrl;

	@FindBy(xpath="//div[@class='ui blue button']")
	public WebElement goButton;

	@FindBy(id="addToLesson")
	public WebElement addToLessonBtn;

	@FindBy(xpath="//div[@data-content='Preview']//i")
	public WebElement previewIcon;

	@FindBy(xpath="//div[@class='child preview-bgimage']")
	public WebElement previewPopup;

	@FindBy(xpath="//div[@id='gameArea']//video")
	public WebElement confirmContent;

	//@FindBy(xpath="//div[@class='preview-modal-content']")
	@FindBy(xpath="//div[@class='iziModal-content']")
	public WebElement randomClickElement;

	//@FindBy(xpath="//*[@id='activitybrowser']")
	//@FindBy(xpath="//div[@class='ui icon menu']/..//a[@data-content='Add Activity']")
	@FindBy(xpath="//a[@data-content='Add Activity']")
	public WebElement addActivity;

	@FindBy(xpath="//button[contains(.,'Search')]")
	//@FindBy(xpath="//input[@placeholder='Search activity']")
	public WebElement searchActivity;

	@FindBy(xpath="//div//label[contains(text(),'Category')]/..//i")
	public WebElement clickCategory;

	@FindBy(xpath="//div[@data-value='string:math']")
	public WebElement selectCategory;

	@FindBy(xpath="//div[@class='content activity-meta']")
	public WebElement selectActivity;

	@FindBy(xpath="//div[@class='content activity-meta']/..//button[.='Add']")
	public WebElement addActivityBtn;

	@FindBy(xpath="(//a[@data-variation='tiny inverted'])[11]")
	public WebElement clickAddedActivity;

	@FindBy(xpath="//button[.='ADD']")
	public WebElement addActivityPopupBtn;

	//Added for test case 81
	@FindBy(xpath="//input[@placeholder='Search by question title']")
	public WebElement questionSetSearchBar;

	@FindBy(xpath="//div[.='Select Language']")
	public WebElement afClickLanguage;

	@FindBy(xpath="//div[.='Select Language']/..//div[.='English']")
	public WebElement afSelectLanguage;

	@FindBy(xpath="//div[.='Select Level']")
	public WebElement afClickDifficulty;

	//Select Difficulty is already located

	@FindBy(xpath="//div[.='Question Type']")
	public WebElement afClickQuestionType;

	@FindBy(xpath="//div[.='Question Type']/..//div[@class='item selected']")
	public WebElement afSelectQuestionType;

	@FindBy(xpath="//div[.='Select Class']")
	public WebElement afClickGradeLevel;

	@FindBy(xpath="//div[.='Select Class']/..//div[@class='item selected']")
	public WebElement afSelectGradeLevel;

	@FindBy(xpath="//div[@class='advanceFilterDiv']")
	public WebElement advancedFilter;

	@FindBy(xpath="//i[@id='qb-search-button']")
	public WebElement searchIcon;

	@FindBy(xpath="//iframe[@frameborder='0']")
	public WebElement enterQuestionIframe;

	@FindBy(xpath="//iframe[@class='iziModal-iframe']")
	public WebElement createQuestionFrame1;


	//Added for test case 83 --14 Sep 2018 
	@FindBy(xpath="(//div[@class='card card-hover-effect ng-scope']//div[contains(text(),'Select')])[3]")
	public WebElement fibQuestionTemplate;

	@FindBy(xpath="//select[@ng-model='keyboardType']")
	public WebElement selectKeyboard;

	//Keyboard Type

	@FindBy(xpath="//select[@ng-model='keyboardType']//option[2]")
	public WebElement keyboardTypeEnglish;

	@FindBy(xpath="//select[@ng-model='keyboardType']//option[1]")
	public WebElement keyboardTypeDevice;

	@FindBy(xpath="//select[@ng-model='keyboardType']//option[3]")
	public WebElement keyboardTypeCustom;

	@FindBy(xpath="//i[@class='icon undo ui right-floated replayIcon']")
	public WebElement previewRefreshIcon;

	@FindBy(xpath="//input[@id='ans-field1']")
	//@FindBy(xpath="//input[@class='ans-field highlightInput']")
	public WebElement previewAnsFiled1;

	@FindBy(xpath="//div[@class='parentDivMainKeyboard qc-keyboard-bottom']")
	public WebElement previewKeyboard;

	@FindBy(xpath="(//div[@id='firstRowAlpha']//span)[1]")
	public WebElement keyboardLetterA;

	@FindBy(xpath="//iframe[@id='iframeArea']")
	public WebElement previewFrameArea;

	@FindBy(xpath="*//div[@ng-show='customTag']/..//input")
	public WebElement addKeysTB;

	@FindBy(xpath="//div[.='Select Medium']")
	public WebElement clickMedium;

	@FindBy(xpath="//div[.='Select Medium']/..//div[.='English']")
	public WebElement selectMedium;

	//Added for Test case 83 - 17 Sep 2018

	@FindBy(xpath="//div[@class='key_barakhadi']//span")
	public List<WebElement>previewKBCharCount;

	/* @FindBy(xpath="//div[@class='key_barakhadi']//span")
	 public WebElement previewKBCharCount;*/


	//Adding for Test case 88

	@FindBy(xpath="//div[@id='previewVideo']/..//div[@class='ui text loader']")
	public WebElement videoLoaderText;

	// @FindBy(xpath="//div[@class='ui pointing dropdown icon button']")
	@FindBy(xpath="//div[@data-content='Send for review']/..//div[@class='ui pointing dropdown icon button']")
	public WebElement limitedSharingIcon;

	@FindBy(xpath="//div[contains(text(),'Limited sharing')]")
	public WebElement clickLimitedSharing;

	@FindBy(xpath="//div[@class='left floated']//i")
	public WebElement contentShareIcon;



	@FindBy(css="body > sui-popup > div > div.content")
	public WebElement copiedMessage;

	@FindBy(xpath="//input[@id='copyLinkData']")
	public WebElement linkDataField;

	@FindBy(xpath="//div[@id='player-auto-scroll']//span")
	public WebElement resourceNameNewWindow;

	@FindBy(xpath="//div[@id='commonHeader']//a[@class='btn at-btn at-btn-ok']")
	public WebElement editorEditDetails;

	@FindBy(xpath="//input[@id='defaultTemplate-topic']")
	public WebElement clickTopics;

	//@FindBy(xpath="//div[@class='topic-tree-tab']/..//div[@class='node']")
	@FindBy(xpath="//div[@data-id='rj_k-12_1_topic_mathematics_l1con_1']//a[@class='name']")
	public WebElement selectTopic;

	//@FindBy(xpath="(//a[.='Cancel']/following::a[@class='ui blue button accept'])[1]")
	//@FindBy(xpath="(//div[@id='topicSelector_defaultTemplate-topic']/..//a[.='Done'])[1]")
	@FindBy(xpath="//div[@id='topicSelector_defaultTemplate-topic']/..//a[.='Done']")
	public WebElement topicsDoneBtn;


	//Added for Test case 93 
	@FindBy(xpath="//div[@class='content']//div[2]")
	public WebElement latestContentTimeUFR;


	//Added for Test case 94
	//@FindBy(className="no-result-text")
	@FindBy(xpath="//div[contains(@class,'no-result-search-text')]")
	public WebElement noResultText;

	//Added for Test 96
	@FindBy(xpath="//sui-multi-select[@id='board']/..//sui-select-option[@class='item selected']")
	public WebElement selectFilterBoard;

	@FindBy(xpath="//sui-multi-select[@id='gradeLevel']//sui-select-option[@class='item selected']")
	public WebElement selectFilterGrade;

	//Dec 06 
	@FindBy(xpath="//sui-multi-select[@id='gradeLevel']//sui-select-option")
	public WebElement selectFilterGrade1;
	
	//Dec 06
	@FindBy(xpath="//sui-multi-select[@id='subject']/.//sui-select-option[@class='item selected']")
	public WebElement selectFilterSubject;

	@FindBy(xpath="//sui-multi-select[@id='contentType']//span[.='Resource']")
	public WebElement selectCotentType;

	@FindBy(xpath="(//sui-multi-select[@id='medium']//sui-select-option[@class='item selected']//span)[2]")
	public WebElement selectFilterMedium;

	//Dec 06
	@FindBy(xpath="//div[@class='content content-detail' and contains(.,'Medium')]/following::div[@class='content']")
	//@FindBy(xpath="(//div[@class='nine wide column']//div)[3]")
	public WebElement verifyFilterMedium;

	@FindBy(xpath="//i[@class='ui remove icon']")
	public WebElement contentCloseIcon;

	//Added for Test case 119 and 120
	@FindBy(xpath="//div[@class='ui fluid image']")
	public WebElement clickNextSlide;

	@FindBy(xpath="//div[@class='ui image']//img[@class='asset_thumbnail']")
	public WebElement checkContentIcon;

	@FindBy(xpath="//a[@title='Properties']")
	public WebElement propertiesSection;

	@FindBy(xpath="(//a[@class='nav-icon nav-next'])[2]")
	public WebElement previewNextBtn;

	@FindBy(xpath="(//a[@class='nav-icon nav-previous'])[2]")
	public WebElement previewPreviousBtn;

	@FindBy(xpath="//iframe[@id='previewContentIframe']")
	public WebElement previewPopupFrame;

	@FindBy(xpath="//h2[@class='ps-heading']")
	public WebElement contentPreiviewCompleteScreen;

	@FindBy(xpath="//a[@class='ps-btn ps-btn--orange endpage-icons']")
	public WebElement previewPopupReplayBtn;

	@FindBy(xpath="*//i[@class='trash large icon']")
	public static WebElement deleteIconLP;

	@FindBy(xpath="//button[.='Yes']")
	public static WebElement deletePopupYesBtn;

	//Added for Test case 
	@FindBy(xpath="//div[@id='board']//div[@class='text']")
	public static WebElement curriculumDivText;


	//Added for Test case 163 - 01/10/2018
	@FindBy(xpath="(//input[@placeholder='Enter title for Book'])[2]")
	public WebElement untitledCollection;

	@FindBy(xpath="//textarea[@placeholder='Brief description about the content']")
	public WebElement untitledCollectionDesc;

	@FindBy(xpath="//label[.='TITLE']/..//input[@name='name']")
	public WebElement editDetailsCollectionTitle;

	@FindBy(xpath="//i[@class='close link icon']")
	public WebElement editDetailsClose;

	//Added for Test case 164 
	@FindBy(xpath="//div[@class='no-result-text']")
	public static WebElement noResultFound;

	//Added for Test case 173
	/* @FindBy(xpath="(//li[@class='fancytree-lastsib']/..//span)[4]")
	 public WebElement rootNodeElement;*/

	@FindBy(xpath="(//li[@class='fancytree-lastsib']/..//span)[4]")
	public static WebElement rootNodeElement;

	@FindBy(xpath="//i//p[@class='slideIn']")
	public WebElement deleteMsg;

	@FindBy(xpath="//div[@class='iziToast-wrapper iziToast-wrapper-topCenter']//div[@class='iziToast-capsule']//div")
	//@FindBy(xpath="/(//div[@class='iziToast-wrapper iziToast-wrapper-topCenter']/..//div//p)[8]")
	public WebElement deleteToaster;

	@FindBy(xpath="//div[@class='iziToast iziToast-theme-light iziToast-color-red iziToast-animateInside iziToast-paused']/..//p")
	public WebElement getToasterMsg;

	//ADDED BY RAJU

	@FindBy(xpath="//div[contains(@class,'ui text menu m-0 ')]/following::a[contains(text(),'Library')]")
	public WebElement ClickOnLibrary;


	@FindBy(xpath="//span[@class='ShowFilterSubTitle']")
	public WebElement VerifySortBy;

	@FindBy(xpath="//span[@class='ShowFilterSubTitle']/following::i[@class='dropdown icon']")
	public WebElement ClickSortByDropDown;



	@FindBy(xpath="//span[@class='ShowFilterSubTitle']/following::i[@class='dropdown icon']/following::span[contains(text(),'Modified On')]")
	public WebElement VerifySortByOptionList;


	//created
	@FindBy(xpath="//span[@class='ShowFilterSubTitle']/following::i[@class='dropdown icon']/following::span[contains(text(),'Created On')]")
	public WebElement VerifySortByOptionList1;


	@FindBy(xpath="//th[@class='six wide UpReviewTableHeader']/following::div[3]")
	public WebElement VerifySearchedContent;

	//Merge-Nov 27
	@FindBy(xpath="//div[@class='ui label tiny right']")
	public static WebElement libraryContentLabel;

	//Merge-Nov 27
	@FindBy(xpath="//span[contains(@class,'ui HomeAccordianHeading')]")
	//@FindBy(xpath="//span[@class='ui HomeAccordianHeading m-responsive-cp left floated header']")
	public WebElement searchedClickedContent;

	//Nov 26
	@FindBy(xpath="//strong[@class='iziToast-title slideIn']")
	public static  WebElement copyErrorToast;
	
	//Merge Nov 27
	@FindBy(xpath="//div[@id='closeButton']/a/i")
	public WebElement xWindowCloseButton;
	
	//Nov 28
	@FindBy(linkText="All audio")
	public static WebElement clickAllAudio;
	
	//Nov 28
	@FindBy(xpath="//label[contains(text(),'Yes, make it available to everyone')]")
	public WebElement yesRadioButton;
	
	//Nov 28
	@FindBy(xpath="//i[@class='huge upload icon']")
	public WebElement audioUploadIcon;
	
	/*@FindBy(xpath="//label[contains(text(),'Yes, make it available to everyone')]")
	public WebElement rightBtnAvailable;*/
	
	//Added for Test case 78
	@FindBy(xpath="//button[contains(text(),'Upload/ Record')]")
	public WebElement btnUploadRecord; 

	//Nov 30
	//@FindBy(id="assetfile")
	@FindBy(xpath="//label[contains(.,'drag and drop')]/..//input")
	public WebElement btnChooseFile;

	@FindBy(xpath="//button[contains(text(),'Upload and Use')]")
	public WebElement btnUploadAndUse;

	@FindBy(xpath="//p[@class='slideIn']")
	public WebElement alertMessage;

	
	
	
	
	
	
	
	
	//Dec 12
	
		//@FindBy(xpath="//div//input[contains(@name,'0')]")
		//div[@class='one column row qHeader ng-scope']/following::p[1]
		
		@FindBy(xpath="//div[@name='mcqoptions_0']")
		public WebElement setAnswer0;
		
		
			
			//@FindBy(xpath="//div//input[@name='options_1']")
		@FindBy(xpath="//div[@name='mcqoptions_1']")
			public WebElement setAnswer1;
		
		@FindBy(xpath="//label[.='LEVEL']/..//div[.='Select Level']/following::div[2]")
		public WebElement selectLevel;
		

		@FindBy(xpath="//label[.='SUBJECT']/..//div[.='Select Subject']/following::div[2]")
		public WebElement selectSubject;
		
		@FindBy(xpath="//label[.='BOARD']/..//div[.='Select Board']/following::div[2]")
		public WebElement selectBoard;
		
		
		

		@FindBy(xpath="//label[contains(text(),'CLASS')]/following::div[1]")
		public WebElement Clickclass;
		
		@FindBy(xpath="//label[contains(text(),'CLASS')]/following::div[4]")
		public WebElement selectclass;
		
		
		
		@FindBy(xpath="//label[contains(text(),'MEDIUM')]")
		public WebElement ClickMediumlabel;
		
		
		@FindBy(xpath="//span[@class='playAudio ng-binding']")
		public static WebElement verifyAudioName;
		
		

		//Dec 15
		
		@FindBy(xpath="//button[contains(text(),' COPY LINK ')]")
			public WebElement copyLinkBtn;
		
	
	
	
	
}

