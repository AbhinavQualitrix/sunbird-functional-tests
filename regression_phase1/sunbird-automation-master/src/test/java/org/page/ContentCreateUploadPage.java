package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContentCreateUploadPage 
{
	WebDriver driver;

	public  ContentCreateUploadPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}
	@FindBy(xpath="//*[@id=\"url-upload\"]/div/input")
	public WebElement enterUrl;

	@FindBy(xpath="//button[contains(text(),'Close Editor')]")
	public WebElement closeEditor;

	@FindBy(xpath="//div[.='Browse']")
	public WebElement browseButton;

	@FindBy(xpath="//i[@class='ui large blue clone outline icon']")
	public WebElement copy;

	@FindBy(xpath="//div[@class=\"icon-box popup-item\"]")
	public WebElement uploadContent;



	@FindBy(id="defaultTemplate-concept")
	public WebElement concept;

	@FindBy(xpath="//strong[.='Functions']")

	public WebElement selectFunction;

	@FindBy(xpath="//*[@id=\"upload-content-div\"]/div")
	public   WebElement Frame;


	//Dec 04
	@FindBy(xpath="//i[@class='edit icon']/ancestor::span")
	//@FindBy(xpath="//i[@class='edit icon']")
	public WebElement editDetailsHeading;

	@FindBy(xpath="//*[@id=\"name\"]/label")
	public WebElement title;

	@FindBy(id="icon_appIcon")
	public WebElement checkAppIcon;

	@FindBy(xpath="//*[@id=\"defaultTemplate-concept\"]")
	public WebElement selectConcept;

	@FindBy(xpath="//*[@id=\"conceptSelector_defaultTemplate-concept\"]//input[@placeholder='Search']")

	public WebElement searchConcept1;

	@FindBy(xpath="//div[@class='ui image']//img[@class='asset_thumbnail']")
	public WebElement checkContentIcon;

	@FindBy(xpath="//button[.='Select']")
	public WebElement selectAppIcon;



	@FindBy(xpath="//*[@id=\"ngdialog5\"]/div[2]/div/div[3]/div/div[2]/div/button[2]")

	public WebElement selectButton;

	@FindBy(xpath="//*[@id=\"defaultTemplate-topic\"]")

	public WebElement selectTopic;

	@FindBy(xpath="//*[@id=\"topicSelector_defaultTemplate-topic\"]/div[4]/a[5]")
	public WebElement doneButton1;

	@FindBy(xpath="//input[@id=\"name\"]")
	public WebElement uploadContentName;

	@FindBy(xpath="//*[@id='closeButton']")
	public WebElement closeEditorButton;


	@FindBy(xpath="//i[@class=\"linkify large icon float-ContentLeft limitedPublishingLinkIcon\"]")
	public WebElement clickOnShare;

	@FindBy(xpath="//div[2]/app-workspacesidebar/div/a[10]")
	public WebElement clickonLimitedPublishing;

	@FindBy(xpath="//button[@class=\"ui basic primary button\"]")
	public WebElement copyLink;

	@FindBy(xpath="//i[@class=\"ui remove icon\"]")
	public WebElement closeShareLink;

	@FindBy(id="copyLinkData")
	public WebElement linkdata;


	@FindBy(xpath="//div[2]/app-workspacesidebar/div/a[4]")
	public WebElement reviewSubmission;

	@FindBy(xpath="//span[@class=\"sliderCardHeading text-cencapitalize\"]")
	public WebElement reviewCardView;



	

	@FindBy(xpath="//*[@id=\"dropdown-menu-list-header\"]/div/a[3]")
	public WebElement workspace1;



	//Dec 05
	@FindBy(xpath="(//img[@class='ui tiny image UpReviewTinyImage']/..//div[@class='UpReviewHeader'])[2]")
	//@FindBy(xpath="//div[@class='UpReviewHeader']")
	public WebElement contentupload;

	@FindBy(xpath="//input[@placeholder='Search content']")
	public WebElement searchBox;



	@FindBy(xpath="//*[@id=\"sortByDropDown\"]//span[2]")
	public WebElement updatedOn;

	@FindBy(xpath="//*[@id=\"sortByDropDown\"]//sui-select-option[2]/span[2]")
	public WebElement createdOn;

	@FindBy(xpath="//*[@id=\"sortByDropDown\"]//sui-select-option[3]/span[2]")
	public WebElement nameAZ;

	@FindBy(xpath="//div[.=\"Pending since: a day ago \"]")
	public WebElement date;

	@FindBy(xpath="//*[@id=\"showFilterButton\"]")
	public WebElement showfilter;

	@FindBy(xpath="//*[@id=\"board\"]")
	public WebElement selectBoard;

	@FindBy(xpath="//*[@id=\"board\"]//span[2]")
	public WebElement selectRajasthan;

	@FindBy(xpath="//*[@id=\"gradeLevel\"]")
	public WebElement gradeLevel;

	@FindBy(xpath="//*[@id=\"gradeLevel\"]//span[2]")
	public WebElement selectClass9;

	@FindBy(id="subject")
	public WebElement selectSubject;

	@FindBy(xpath="//*[@id=\"subject\"]//span[2]")
	public WebElement selectMathematics;

	@FindBy(id="medium")
	public WebElement selectMedium;

	@FindBy(xpath="//*[@id=\"medium\"]//span[2]")
	public WebElement selectHindi;

	@FindBy(id="contentType")
	public WebElement selectContentType;

	@FindBy(xpath="//*[@id=\"contentType\"]//span[2]")
	public WebElement selectCollection;

	@FindBy(xpath="//a[@class='searchfilterbutton ui blue tiny  button']")
	public WebElement clickOnApplyButton;

	@FindBy(xpath="//div[@class='UpReviewHeader']")
	public WebElement contentFiltered;

	@FindBy(xpath="//th[@class='two wide UpReviewTableHeader']")
	public WebElement status;

	@FindBy(xpath="//div[2]/app-upforreview-contentplayer//div/button[1]")
	public WebElement publishButton;

	@FindBy(xpath="//input[@class='listItem']")
	public List<WebElement> checkbox;


	//@FindBy(xpath="/html/body/sui-modal/sui-dimmer/div/div/div/div[3]/div")
	@FindBy(xpath="/html/body/sui-modal/sui-dimmer/div/div/div/div[3]/div/button[2]")
	public WebElement publishButton1;

	@FindBy(xpath="//div/div[2]/app-workspacesidebar/div/a[5]")
	public WebElement published;

	@FindBy(xpath="//span[@class='sliderCardHeading text-cencapitalize']")
	public WebElement contentPublished;

	@FindBy(xpath="//body//button[contains(text(),'REQUEST CHANGES')]")
	public WebElement requestChangesButton;

	@FindBy(xpath="/html/body/sui-modal/sui-dimmer/div/div/div/div[2]/div[2]/div/div/textarea")
	public WebElement requestChangesComment;

	@FindBy(xpath="/html/body/sui-modal/sui-dimmer/div/div/div/div[3]/div/button[2]")
	public WebElement requestChangesBlueButton;

	@FindBy(xpath="//div/div[2]/app-workspacesidebar/div/a[6]")
	public WebElement allUploads;

	@FindBy(xpath="//div[@data-content='Review comments']")
	public WebElement reviewerSuggestion;

	@FindBy(xpath="//span[@class='ng-binding']")
	public WebElement reviewerSuggestionTitle;

	@FindBy(xpath="//input[@type='file']")
	public WebElement browseButton1;

	@FindBy(xpath="//*[@id=\"ngdialog1\"]/div[2]/div/div[1]/div/div/div/label")
	public WebElement uploadContentText;

	//Dec 04
	@FindBy(xpath="//div[contains(@class,'actions')]/..//button[contains(.,'Upload')]")
	//@FindBy(xpath="//button[.='Upload']")
	public WebElement popupUploadButton;

	@FindBy(xpath="//div/app-library-search//app-card/div/div[1]")
	public WebElement serachedContent;

	@FindBy(xpath="//span[@class='ui HomeAccordianHeading left floated header']")
	public WebElement searchContentName;

	@FindBy(xpath="//div/app-breadcrumbs//span[1]/a")
	public WebElement homeNavigation;

	@FindBy(xpath="//*[@id='content-meta-form']//app-icon/div/label")
	public WebElement appIcon;

	//@FindBy(id="closePopUp")
	@FindBy(xpath="//button[contains(@id,'close')]")
	public WebElement cancelButton;

	@FindBy(xpath="//*[@id=\"ownedBy\"]/div[1]/div[1]")
	public WebElement owner;



	@FindBy(xpath="//div[@class=\"UpReviewHeader\"]")
	public WebElement contentName;

	@FindBy(xpath="//*[@id='dropdown-menu-list-header']/ngx-avatar/div/div")
	public WebElement profileIcon;

	@FindBy(xpath="//*[@id=\"dropdown-menu-list-header\"]/div/a[2]")
	public WebElement logoutButton;

	@FindBy(xpath="//*[@id=\"defaultTemplate-topic\"]")
	public WebElement selectTopicPopup;

	@FindBy(xpath="//*[@id=\"topicSelector_defaultTemplate-topic\"]/div[3]/div[3]/div/div[3]/div[1]/a")
	public WebElement selectPolynomials;

	@FindBy(xpath="//input[@placeholder='Search content']")
	public WebElement searchForReview;

	@FindBy(xpath="//*[@id=\"main-nav\"]/div[2]/app-main-menu/div/a[1]")
	public WebElement homePage;

	//Nov 29
	@FindBy(xpath="//div[@class='default text']/following::div[@class='item selected']")
	public WebElement ownership;

	//Dec 04
	@FindBy(xpath="//label[contains(.,'CURRICULUM')]/..//div[@class='text']")
	public WebElement selectedCirriculumText;

	@FindBy(xpath="//label[contains(.,'CLASS')]/..//div[@class='text']")
	public WebElement selectedClassText;

	@FindBy(xpath="//label[contains(.,'SUBJECT')]/..//div[@class='text']")
	public WebElement selectedSubjectText;

	@FindBy(xpath="//label[contains(.,'MEDIUM')]/..//div[@class='text']")
	public WebElement selectedMediumText;

	//Dec04

	@FindBy(xpath="//input[@name='topic']")
	public WebElement selectedTopics;

	@FindBy(xpath="//i[contains(@class,'download icon')]")
	public WebElement contentDownloadIcon;


	@FindBy(xpath="//i[@class='close link icon']")
	public WebElement closeLinkIcon;

	@FindBy(xpath="//i[@class='remove icon custom-cursor']")
	public WebElement closePageIcon;

	@FindBy(xpath="//span[contains(@class,'sliderCardHeading')]")
	public WebElement contentInPublished;

	//Dec 12
	@FindBy(xpath="//i[@class='icon-save']")
	public WebElement saveuploadcontent;

	@FindBy(xpath="//img[@class='ui tiny image UpReviewTinyImage']/..//div[@class='UpReviewHeader']")
	//@FindBy(xpath="//div[@class='UpReviewHeader']")
	public WebElement contentInUpForReview;

	//Dec 15
	@FindBy(xpath="//td[2]//h5//div[@class='UpReviewSubHeader']")
	public WebElement latestContentDuration;

	@FindBy(xpath="//div//span[contains(@class,'HomeAccordianHeading')]")
	public WebElement clickContentInUFR;

	//Dec 19
	@FindBy(xpath="//i[contains(@class,'ascending icon')]")
	public WebElement sortByAscendingIcon;

	//Dec 19
	@FindBy(xpath="//i[contains(@class,'descending icon')]")
	public WebElement sortByDescendingIcon;
	
	
	//Dec 27
	@FindBy(xpath="//a[contains(text(),'Workspace')]")
	public WebElement workspace;

	
	@FindBy(xpath="//a[@href='/workspace/content/upForReview/1']")
	public WebElement upforreview;
	
	@FindBy(xpath="//*[@id='sortByDropDown']")
	public WebElement sortBy;
	
	@FindBy(xpath="//*[contains(text(),'Edit Details')]")
	public WebElement editDetailsLink;
}
