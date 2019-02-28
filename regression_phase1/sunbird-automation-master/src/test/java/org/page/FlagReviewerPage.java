package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
/**
* Created by Qualitrix Technologies Pvt Ltd.
* Purpose: To capture and maintain all webelements related to FlagReviewerPage
*/
public class FlagReviewerPage 
{
	WebDriver driver;

	public  FlagReviewerPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}

	@FindAll(@FindBy(xpath="//h4[contains(text(),'Latest Courses')]/..//div[@class='cardImageText center aligned ']//span"))
	public List<WebElement> courseList;
	
	@FindBy(xpath="//h4[contains(text(),'My Courses')]/..//div[@class='cardImageText center aligned ']//span")
	public List<WebElement> courseMy;
	
	@FindBy(xpath="(//h4[contains(text(),'My Courses')]/..//div[@class='cardImageText center aligned ']//span)[5]")
	public WebElement courseMyFifth;
	
	@FindBy(xpath="//h4[contains(text(),'My Courses')]")
	public WebElement myCourses;
	
	@FindBy(xpath="//h4[contains(text(),'Latest Courses')]")
	public WebElement latestCourses;
	
	@FindBy(xpath="//h4[contains(text(),'Courses')]/..//div[@class='cardImageText center aligned ']//span")
	public List<WebElement> courseMyCourses1;
	
	@FindBy(xpath="//h4[contains(text(),'Courses')]/..//div[@class='cardImageText center aligned ']//span")
	public WebElement courseMyCourses2;
	
	@FindBy(xpath="//h4[contains(text(),'My Courses')]/..//span[@class='sliderCardHeading text-cencapitalize']")
	public WebElement courseLatestCourses;
	
	@FindBy(xpath="//h4[contains(text(),'My Courses')]/..//button[@class='slick-next slick-arrow']")
	public WebElement myCourseNextuBtton;
	
	@FindBy(xpath="//h4[contains(text(),'Latest Courses')]/..//button[@class='slick-next slick-arrow']")
	public WebElement latestCourseNextuBtton;
		
	@FindBy(xpath="//i[@class='ui large blue flag outline icon']")
	public WebElement flagIcon;
	
	@FindBy(xpath="//input[@type='radio']")
	public List<WebElement> flagReason;
	
	@FindBy(name="addYourComment")
	public WebElement addComment;
	
	public String [] randomComments = new String[]{"Not a proper course","Invalid course","no course contents","Empty course"};
	
	@FindBy(xpath="//button[contains(text(),'SUBMIT')]")
	public WebElement submitButton;
	
	//Updated on 9/07/2018
	@FindBy(xpath="//div[@class='cardImageText center aligned ']//span")
	//public List<WebElement> contentsSearched;
	public WebElement contentsSearched;
	
	@FindBy(xpath="//span[@class='ui HomeAccordianHeading left floated header']")
	public WebElement clikedCourseContentName;
	
	@FindBy(xpath="//h4[contains(text(),'Popular Books')]")
	public WebElement popularBooksHeader;
	
	@FindBy(xpath="//div[@class='cardImageText center aligned ']//span")
	public List<WebElement> coursesSearched;
	
	@FindBy(xpath="//button[contains(text(),'DISCARD')]")
	public WebElement discardButton;
	
	@FindBy(xpath="//div[@class='publicmenusection ui secondary vertical menu']//a[9]")
	public WebElement flaggedContent;
	
	@FindBy(xpath="//div[@class='publicmenusection ui secondary vertical menu']//a[7]")
	public WebElement upForReview;
	
	@FindBy(xpath="(//div[@class='ui link cards margin-right-20 margin-top-15 margin-bottom-0'])[position()=2]")
	public WebElement clickFlagContent;
	
	@FindBy(xpath="//p[.='Loading Editor...']")
	public WebElement loadingSymbol;
	
	//Adding additional elements for Test case 2
	
	@FindBy(xpath="//div//h6[@class='ui small negative message']")
	public WebElement courseFlaggedMessage;
	
	@FindBy(xpath="//a[contains(text(),'Flagged')]")
	public WebElement flagged;
	
	@FindBy(xpath="//button[contains(text(),'ACCEPT')]")
	public WebElement acceptBlueButton;
	
	@FindBy(xpath="//span[.='Accept']")
	public WebElement acceptGreyButton;
	
	@FindBy(xpath="//span[.='Discard']")
	public WebElement discardGreyButton;
	
	@FindBy(xpath="//button[contains(text(),'DISCARD')]")
	public WebElement discardBlueButton;
	
	@FindBy(xpath="//button//span[.='Resume']")
	public WebElement courseResume;
	
	@FindBy(xpath="//div[@class='cardImageText center aligned ']//span")
	public WebElement searchedCourse;
	
	//Adding elements for Test case 4
	
	@FindBy(xpath="//a[@data-content='Add Slide']")
	public WebElement addSlide;
	
	@FindBy(xpath="//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement contentTitleTopLeft;
	

	// @author sachin
	// Web Element publishCheckBox1
	@FindBy(xpath = "//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement publishCheckBox1;

	// @author sachin
	// Web Element publishCheckBox2
	@FindBy(xpath = "//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement publishCheckBox2;

	// @author sachin
	// Web Element publishCheckBox3
	@FindBy(xpath = "//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement publishCheckBox3;

	// @author sachin
	// Web Element publishCheckBox4
	@FindBy(xpath = "//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement publishCheckBox4;

	// @author sachin
	// Web Element publishCheckBox5
	@FindBy(xpath = "//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement publishCheckBox5;

	// @author sachin
	// Web Element publishCheckBox6
	@FindBy(xpath = "//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement publishCheckBox6;

	// @author sachin
	// Web Element publishCheckBox7
	@FindBy(xpath = "//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement publishCheckBox7;

	// @author sachin
	// Web Element publishCheckBox8
	@FindBy(xpath = "//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement publishCheckBox8;

	// @author sachin
	// Web Element publishCheckBox9
	@FindBy(xpath = "//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement publishCheckBox9;

	// @author sachin
	// Web Element publishCheckBox10
	@FindBy(xpath = "//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement publishCheckBox10;

	// @author sachin
	// Web Element publishCheckBox11
	@FindBy(xpath = "//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement publishCheckBox11;

	// @author sachin
	// Web Element publishCheckBox12
	@FindBy(xpath = "//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement publishCheckBox12;

	// @author sachin
	// Web Element publishCheckBox13
	@FindBy(xpath = "//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement publishCheckBox13;

	// @author sachin
	// Web Element publishPopUpButton
	@FindBy(xpath = "//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement publishPopUpButton;

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

	// @author Sachin
	// Web Element createdLessonPlan1
	@FindBy(xpath = "/html/body/app-root/app-workspace/div/div[3]/app-up-for-review/table/tbody/tr[1]")
	public WebElement createdLessonPlan1;

	// @author Sachin
	// Web Element publish
	@FindBy(xpath = "//button[contains(.,'PUBLISH')]")
	public WebElement publish;
	
	// @author sachin
	// Web Element searchContent
	@FindBy(xpath="//input[@placeholder='Search content']")
	public WebElement searchContent;
	
	//@author Sachin  
	// Web Element Workspace
	@FindBy(xpath="//*[@id='main-nav']/div[2]/app-main-menu/div/a[4]")
	public WebElement Workspace;
	
	// @author sachin
	// Web Element searchContentIcon
	@FindBy(xpath="//*[@id='search-input-container']/div/div/i")
	public WebElement searchContentIcon;
	
	// @author sachin
	//Adding elements for test case 14
	// Web Element filterIcon
	@FindBy(xpath="//span[@class='browse item cursor-pointer']")
	public WebElement filterIcon;
	
	// @author sachin
	// Web Element clickFilterBoard
	@FindBy(xpath="(//i[@class='dropdown icon'])[5]")
	public WebElement clickFilterBoard;
		
	// @Author Sachin
	// Web Element selectRajasthanBoard
	@FindBy(xpath = "//span[contains(.,'State (Rajasthan)')]")
	public WebElement selectRajasthanBoard;
	
	// @Author Sachin
	// Web Element clickFilterClass
	@FindBy(xpath = "(//i[@class='dropdown icon'])[6]")
	public WebElement clickFilterClass;
	
	// @Author Sachin
	// Web Element selectClass9
	@FindBy(xpath = "//sui-select-option[contains(.,'Class 9')]")
	public WebElement selectClass9;
	
	// @Author Sachin
	// Web Element clickFilterSubject
	@FindBy(xpath="(//sui-multi-select[contains(@zeroselectiontext,'Select')])[3]")
	public WebElement clickFilterSubject;
	
	//@author sachin
	// Web Element selectMathematics
	@FindBy(xpath="//span[contains(.,'Mathematics')]")
	public WebElement selectMathematics;
	
	//@author sachin
	// Web Element clickFilterMedium
	@FindBy(xpath="(//div[contains(.,'Select Medium')])[13]")
	public WebElement clickFilterMedium;
	
	//@author sachin
	// Web Element selectFilterMedium
	@FindBy(xpath="//span[contains(.,'English')]")
	public WebElement selectFilterMedium;
	
	//@author sachin
	// Web Element clickContentType
	@FindBy(xpath="//*[@id='contentType']/i")
	public WebElement clickContentType;
	
	//@author sachin
	// Web Element selectContentType
	@FindBy(xpath="//sui-multi-select[@id='contentType']//span[.='LessonPlan']")
	public WebElement selectContentType;
	
	//@author sachin
	// Web Element applyButton
	@FindBy(xpath="//a[.='APPLY']")
	public WebElement applyButton;
	
	//@author sachin
	// Web Element firtContent
	@FindBy(xpath="//*[@class='UpForReviewListHover cursor-pointer']")
	public WebElement firtContent;
			
	//@author sachin
	// Web Element Publish
	@FindBy(xpath="//*[@class='ui right floated primary button mouse-pointer']")
	public WebElement Publish;
	
	//@author sachin
	// Web Element noHateSpeechCheckbox
	@FindBy(xpath="(//input[contains(@class,'listItem')])[1]")
	public WebElement noHateSpeechCheckbox;
	
	//@author sachin
	// Web Element noSexualContentCheckbox
	@FindBy(xpath="(//input[contains(@class,'listItem')])[2]")
	public WebElement noSexualContentCheckbox;

	//@author sachin
	// Web Element noDiscriminationCheckbox
	@FindBy(xpath="(//input[contains(@class,'listItem')])[3]")
	public WebElement noDiscriminationCheckbox;
	
	//@author sachin
	// Web Element isSuitableForChildrenCheckbox
	@FindBy(xpath="(//input[contains(@class,'listItem')])[4]")
	public WebElement isSuitableForChildrenCheckbox;
	
	//@author sachin
	// Web Element appropriateTitleCheckbox
	@FindBy(xpath="(//input[contains(@class,'listItem')])[5]")
	public WebElement appropriateTitleCheckbox;
	
	//@author sachin
	// Web Element correctBoardCheckbox
	@FindBy(xpath="(//input[contains(@class,'listItem')])[6]")
	public WebElement correctBoardCheckbox;
	
	//@author sachin
	// Web Element appropriateTagsCheckbox
	@FindBy(xpath="(//input[contains(@class,'listItem')])[7]")
	public WebElement appropriateTagsCheckbox;
	
	//@author sachin
	// Web Element relevantKeywordsCheckbox
	@FindBy(xpath="(//input[contains(@class,'listItem')])[8]")
	public WebElement relevantKeywordsCheckbox;
	
	//@author sachin
	// Web Element contentPlaysCorrectlyCheckbox
	@FindBy(xpath="(//input[contains(@class,'listItem')])[9]")
	public WebElement contentPlaysCorrectlyCheckbox;
	
	//@author sachin
	// Web Element seeContentClearlyCheckbox
	@FindBy(xpath="(//input[contains(@class,'listItem')])[10]")
	public WebElement seeContentClearlyCheckbox;
	
	//@author sachin
	// Web Element audioCheckbox
	@FindBy(xpath="(//input[contains(@class,'listItem')])[11]")
	public WebElement audioCheckbox;
	
	//@author sachin
	// Web Element noSpellingMistakesCheckbox
	@FindBy(xpath="(//input[contains(@class,'listItem')])[12]")
	public WebElement noSpellingMistakesCheckbox;
	
	//@author sachin
	// Web Element isLanguageSimpleCheckbox
	@FindBy(xpath="(//input[contains(@class,'listItem')])[13]")
	public WebElement isLanguageSimpleCheckbox;
	
	//@author sachin
	// Web Element publishAfterCheckingboxes
	@FindBy(xpath="//*[@class='ui blue button ']")
	public WebElement publishAfterCheckingboxes;
	
	//@author sachin
	// Web Element checkPublishPopup
	@FindBy(xpath="//*[@class='ui modal transition active visible normal']")
	public WebElement checkPublishPopup;
	
	//@author sachin
	// Web Element requestChangesButton
	@FindBy(xpath="//button[contains(.,'REQUEST CHANGES')]")
	public WebElement requestChangesButton;
	
	//@author sachin
	// Web Element otherIssueCheckbox
	@FindBy(xpath="(//input[@type='checkbox'])[14]")
	public WebElement otherIssueCheckbox;
	
	//@author sachin
	// Web Element requestChangesReasonPlaceholder
	@FindBy(xpath="//textarea[contains(@rows,'3')]")
	public WebElement requestChangesReasonPlaceholder;
	
	//@author sachin
	// Web Element headerPublish
	@FindBy(xpath = "//span[contains(.,'Publish')]")
	public WebElement headerPublish;
	
	
	//@author sachin
	// Web Element headerRequestChanges
	@FindBy(xpath="//*[@id='commonHeader']/div/div[4]/div/div/div[2]/div[7]")
	public WebElement headerRequestChanges;
	
	//@author sachin
	// Web Element requestChanges
	@FindBy(xpath="(//div[contains(.,'CancelRequest Changes')])[5]")
	public WebElement requestChanges;
	
	//@author sachin
	// Web Element publishConfirm
	@FindBy(xpath="//*[@id='review-footer']/div/button[2]")
	public WebElement publishConfirm;
}
