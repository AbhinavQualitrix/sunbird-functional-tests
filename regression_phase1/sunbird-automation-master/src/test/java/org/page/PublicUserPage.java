package org.page;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;


public class PublicUserPage 
{
	WebDriver driver;

	public  PublicUserPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}

	@FindBy(xpath="//input[@id='password-new']")
	public WebElement newPassword;

	@FindBy(xpath="//span[@class='kc-feedback-text']")
	public WebElement passwordMessage;

	@FindBy(xpath="//input[@id='password-confirm']")
	public WebElement confirmPassword;

	@FindBy(xpath="//input[@name='username']")
	public WebElement enterUsername;

	@FindBy(xpath="//a[contains(.,'Forgot')]")
	public WebElement forgotPasswordLink;

	@FindBy(xpath="//button[contains(text(),'Submit')]")
	public WebElement forgotSubmit;

	@FindBy(xpath="//form[@id='kc-totp-login-form']/..//lable")
	public WebElement getMailConfirmation;

	@FindBy(xpath="//a[@id='backToApplication']")
	public WebElement backToApplicationLink;

	@FindBy(xpath="//span[.='user_not_found']")
	public WebElement userNotFound;




	@FindBy(xpath="//a[contains(text(),'Courses')]")
	public WebElement headerCourses;

	@FindBy(xpath="//a[contains(text(),'Library')]")
	public WebElement headerLibrary;

	@FindBy(xpath="//a[contains(text(),'Groups')]")
	public WebElement headerGroups;

	//Added on 18/07/2018
	//Adding Test case 4





	@FindBy(xpath="//p[@class='serch-allresult']")
	public WebElement showResults;


	//Updated the xpath of Header Profile on 10 OCt 2018
	//@FindBy(xpath="//div//a[5][contains(text(),'Profile')]")
	//@FindBy(xpath="//div[@class='ui secondary pointing menu']//a[contains(text(),'Profile')]")
	@FindBy(xpath="(//a[@class='item mt-15 computer only' and contains(text(),'Profile')])[2]")
	public WebElement headerProfile;

	@FindBy(xpath="//div[.='Announcements']")
	public WebElement announcements;

	@FindBy(xpath="//input[@placeholder='Search' or @id='keyword']")
	public WebElement searchBar;

	@FindBy(xpath="//i[@class='circular search link icon']")
	public WebElement clickSearch;

	@FindBy(xpath="//p//span[contains(text(),'for ')]")
	public WebElement searchedInputResult;

	@FindBy(xpath="//a[@class='ui black right ribbon label']")
	public WebElement searchedResults;

	@FindBy(xpath="//i[@class='icon filter']")
	public WebElement filterIcon;

	//i[@class='icon filter']
	@FindBy(xpath="//sui-multi-select[@id='board']//i[@class='dropdown icon']")
	public WebElement clickFilterBoard;




	@FindBy(xpath="//sui-multi-select[@id='contentType']")
	public WebElement clickContentTypes;

	@FindBy(xpath="//sui-multi-select[@id='contentType']/..//sui-select-option")
	public WebElement selectContentType;

	@FindBy(xpath="//input[contains(text(),'Concepts ')]")
	public WebElement clickConcepts;

	@FindBy(xpath="//div[@class='ui search form']//input[@type='text'][@placeholder='Search']")
	public WebElement clickSearchConcepts;

	@FindBy(xpath="//a[.='Done']")
	public WebElement clickDone;

	@FindBy(xpath="//a[.='APPLY']")
	public WebElement clickApply;

	@FindBy(xpath="//a[.=' SUBMIT ']")
	public WebElement clickSubmit;

	@FindBy(xpath="(//a[@class='ui label margin-top--5'])[5]")
	public WebElement contentType;

	@FindBy(xpath="//sui-multi-select[@id='gradeLevel']//i[@class='dropdown icon']")
	public WebElement clickGradeFilter;

	//OCT 12 - v1.11.0
	//@FindBy(xpath="//sui-multi-select[@id='gradeLevel']/..//sui-select-option")
	@FindBy(xpath="//sui-multi-select[@id='gradeLevel']/..//sui-select-option")
	public WebElement selectFilterGrade;


	@FindBy(xpath="//span[.='No results found']")
	public WebElement noResults;

	@FindBy(xpath="//i[@class='delete icon']")
	public List<WebElement> clearAllFilters;

	@FindBy(xpath="//i[@class='edit icon']")
	public WebElement imageEditIcon;

	@FindBy(xpath="//span[.='Contributions']")
	public WebElement profileContributions;

	@FindBy(xpath="//span[.=' Summary ']/../a[.='EDIT']")
	public WebElement summaryEditButton;

	@FindBy(tagName="textarea")
	public WebElement summaryText;

	@FindBy(tagName="button")
	public WebElement summarySave;//button[.='SAVE ']

	@FindBy(xpath="//span[.=' Experience ']/../a[.='ADD']")
	public WebElement experienceAddButton;

	@FindBy(name="jobName")
	public WebElement experienceOccupationField;

	@FindBy(xpath="//input[@formcontrolname='role']")
	public WebElement experienceDesignationField;

	@FindBy(xpath="//input[@formcontrolname='orgName']")
	public WebElement experienceOrganizationField;

	@FindBy(xpath="//sui-multi-select[@formcontrolname='subject']")
	public WebElement experienceClickSubjectDropdown;

	@FindBy(xpath="//sui-select-option//span[.='Assamese']")
	public WebElement experienceSelectSubjectDropdown;


	//@FindBy(xpath="//input[@formcontrolname='isCurrentJob']/../label[.='Yes']")
	@FindBy(xpath="(//input[@formcontrolname='isCurrentJob'])[1]")
	public WebElement experienceSelectYesRadioButton;

	//@FindBy(xpath="html/body/sui-popup/div/sui-datepicker/sui-calendar-date-view/table/tbody/tr[4]/td[1]")
	@FindBy(linkText="18")
	public WebElement experienceSelectJoinDate;

	@FindBy(xpath="//input[@formcontrolname='joiningDate']")
	public WebElement experienceClickJoinDate;

	@FindBy(xpath="//p[.='permanent']/../div[@class='description']")
	public WebElement checkAddressStatus;

	@FindBy(xpath="//span[.='Address ']/../a[.='EDIT']")
	public WebElement addressEditButton;

	@FindBy(xpath="//input[@id='addTypeCurrent']")
	public WebElement selectCurrentRadioButton;

	@FindBy(xpath="//input[@name='addressLine1']")
	public WebElement addressLine1;

	@FindBy(xpath="//input[@name='addressLine2']")
	public WebElement addressLine2;

	@FindBy(xpath="//input[@name='city']")
	public WebElement addressCity;

	@FindBy(xpath="//input[@name='state']")
	public WebElement addressState;

	@FindBy(xpath="//input[@name='country']")
	public WebElement addressCountry;

	@FindBy(xpath="//input[@name='zipcode']")
	public WebElement addressZipcode;

	@FindBy(xpath="//span[.='Education ']/../a[.='ADD']")
	public WebElement educationEditButton;

	@FindBy(xpath="//input[@name='degree']")
	public WebElement educationDegree;

	@FindBy(xpath="//input[@name='percentage']")
	public WebElement educationPercentage;

	@FindBy(xpath="//input[@name='grade']")
	public WebElement educationGrade;

	@FindBy(xpath="//input[@name='name']")
	public WebElement educationInstitution;

	@FindBy(xpath="//input[@name='boardOrUniversity']")
	public WebElement educationBoard;

	@FindBy(xpath="//input[@name='yearOfPassing']")
	public WebElement educationYearOFPassing;

	@FindBy(xpath="//span[.='Skill Tags ']/../a[.='ADD']")
	public WebElement skillAddButton;

	@FindBy(xpath="//span[.='Add Skills']")
	public WebElement addSkillsHeader;

	//Updated on 16 OCT 2018
	@FindBy(xpath="//div[@id='addSkill']//input[@class='search']")
	//@FindBy(xpath="//div[@id='addSkill']")
	public WebElement addSkills;

	@FindBy(xpath="//sui-multi-select[@name='skills']")
	public WebElement selectSkills;

	@FindBy(xpath="//button[contains(text(),'FINISH')]")
	public WebElement finishButton;

	@FindBy(xpath="//span[.=' Additional Information']/../a[.='EDIT']")
	public WebElement additionalInfoEdit;

	@FindBy(xpath="//input[@name='firstName']")
	public WebElement additionalFirstName;

	@FindBy(xpath="//input[@name='lastName']")
	public WebElement additionalLastName;

	@FindBy(xpath="//input[@name='location']")
	public WebElement additionalLocation;

	@FindBy(xpath="//span[.='Skill Tags ']/..//div//i[@class='lock icon']")
	public WebElement skillLockIcon;

	@FindBy(xpath="//div[@class='text']//span[.='All']")
	public WebElement headerDropdown;

	@FindBy(xpath="//sui-select-option//span[.='Users']")
	public WebElement headerDropdownUsers;

	/*@FindBy(xpath="//a[.='TestFlagReviewer  N']")
	public WebElement searchedEndorseUser;
	 */

	@FindBy(xpath="//span[.='Skill Tags ']/..//div//i[@class='unlock alternate icon']")
	public WebElement SkillUnlockIcon;

	@FindBy(xpath="//a[contains(text(),'+1')]")
	public WebElement endorsementIcon;

	@FindBy(xpath="//span[contains(text(),'Skill Tags')]")
	public WebElement skillTag;

	@FindBy(xpath="//div[@class='detail']//span[2]")
	public List<WebElement> eachSkillTagSize;

	@FindBy(xpath="//div[@class='cardImageText center aligned ']//span[contains(text(),'Course')]")
	public 	List<WebElement> searchedCourses;


	@FindBy(xpath="//div[@class='sub-header'][1]")
	public WebElement courseToBeClicked;

	//Added for Test case 8 -18/07/2018
	@FindBy(xpath="//div[@class='no-result-text']")
	public WebElement noResultsFound;

	//Added for Test case 13 - 20/07/2018
	@FindBy(xpath="//a[.='Last']")
	public WebElement lastButton;

	//Added for test case 14 - 20/07/2018
	@FindBy(xpath="//div[@class='sectionHeading header']")
	public WebElement getUsername;

	@FindBy(xpath="//a[@class='header ']")
	public WebElement getResultsUsername;

	@FindBy(xpath="//span[@class='cursor-pointer']")
	public WebElement viewMoreSkills;

	@FindBy(xpath="//div[@class='detail']//span[2]")
	public WebElement endorsementCount;

	@FindBy(xpath="//div[@class='addition item selected']")
	public WebElement addSkill;

	//Added for Test case 7-20/07/2018

	@FindBy(xpath="//span[.='Resume']")
	public WebElement courseResumeButton;

	//Added on Maintenance 07/09/2018

	@FindBy(xpath="//div[@id='conceptSelector_treePicker']//input[@placeholder='Search']")
	public WebElement searchConcepts;

	@FindBy(xpath="//div[@id='conceptSelector_treePicker']//a[contains(text(),'Choose All')]")
	public WebElement conceptChooseAll;

	@FindBy(xpath="//div[@id='conceptSelector_treePicker']//a[contains(text(),'Done')]")
	public WebElement conceptDoneButton;

	@FindBy(xpath="(//input[@formcontrolname='isCurrentJob'])[2]")
	public WebElement experienceSelectNoRadioButton;

	@FindBy(xpath="//span[.='Skill Tags ']/../a[.='EDIT']")
	public WebElement skillEditButton;

	@FindBy(xpath="//i[@class='delete icon']")
	public List<WebElement> deleteSkills;

	@FindBy(xpath="//i[@class='delete icon']")
	public WebElement deleteSkill;

	@FindBy(xpath="//div[@class='addition item selected']")
	public WebElement addSkillItem;

	//OCT 16 - v1.11.0
	@FindBy(xpath="//span[.='Skill Tags ']/..//div//i")
	//@FindBy(xpath=".//div[@id='addSkill']//i[@class='dropdown icon']")
	public WebElement addSkillLockUnlockIcon;

	@FindBy(xpath="//sui-multi-select[@formcontrolname='language']")
	public WebElement knownLanguages;

	@FindBy(xpath="//sui-multi-select[@formcontrolname='language']/..//sui-select-option")
	public WebElement selectLanguage;

	@FindBy(xpath="//div[@class='profileitems ui relaxed divided items ']//i[@class='trash outline icon trashIcon-fontSize m-responsive-p-icon-ml']")
	public WebElement experienceDelete;

	@FindBy(xpath="//div[@id='education']/..//i[@class='trash outline icon trashIcon-fontSize m-responsive-p-icon-ml']")
	public WebElement educationDelete;

	@FindBy(xpath="//a[@class='header ']")
	public List<WebElement> searchedResults1;

	@FindBy(xpath="//a[@class='header ']")
	public WebElement searchedResult;

	//Nov 24
	//@FindBy(xpath="//sui-multi-select[@id='gradeLevel']//i[@class='dropdown icon']")
	@FindBy(xpath="(//sui-multi-select[@id='gradeLevel']//i[@class='dropdown icon'])[1]")
	public WebElement clickFilterClass;

	//Nov 24
	//@FindBy(xpath="//div//span[.='CBSE']")
	//@FindBy(xpath="//sui-multi-select[@id='board']/..//sui-select-option")
	@FindBy(xpath="(//sui-multi-select[@id='board']/..//sui-select-option)[1]")
	public WebElement selectFilterBoard;

	//Nov 24
	@FindBy(xpath="((//sui-multi-select[@id='gradeLevel'])/..//sui-select-option)")
	//@FindBy(xpath="//sui-multi-select[@id='gradeLevel']/..//sui-select-option")
	public List<WebElement> selectFilterClass;

	//Nov 24
	@FindBy(xpath="(//sui-multi-select[@id='subject']//i[@class='dropdown icon'])[1]")
	//@FindBy(xpath="//sui-multi-select[@id='subject']//i[@class='dropdown icon']")
	public WebElement clickFilterSubject;

	//Nov 24
	@FindBy(xpath="(//sui-multi-select[@id='subject'])/..//sui-select-option")
	//@FindBy(xpath="//sui-multi-select[@id='subject']/..//sui-select-option")
	public List<WebElement> selectFilterSubject;

	//Nov 24
	@FindBy(xpath="(//sui-multi-select[@id='medium']//i[@class='dropdown icon'])[1]")
	//@FindBy(xpath="//sui-multi-select[@id='medium']//i[@class='dropdown icon']")
	public WebElement clickFilterMedium;


	//Nov 24
	//@FindBy(xpath="//sui-multi-select[@id='medium']/..//sui-select-option")
	@FindBy(xpath="(//sui-multi-select[@id='medium'])/..//sui-select-option")
	public List<WebElement> selectFilterMedium;


	//Nov 24
	@FindBy(xpath="(//sui-multi-select[@id='contentType']//i[@class='dropdown icon'])[1]")
	//@FindBy(xpath="//sui-multi-select[@id='medium']//i[@class='dropdown icon']")
	public WebElement clickFilterContentType;


	//Nov 24
	//@FindBy(xpath="//sui-multi-select[@id='medium']/..//sui-select-option")
	@FindBy(xpath="(//sui-multi-select[@id='contentType'])/..//sui-select-option")
	public WebElement selectFilterContentType;

	//Nov 25	
	@FindBy(xpath="(//div[@id='headerSearch'])[2]/..//span[2]")
	public WebElement headerDropDown;

	//Nov 25
	@FindBy(xpath="//div[@class='sub-header']")
	//@FindBy(xpath="//span[@class='sliderCardHeading text-cencapitalize']")
	public WebElement searchedCourses1;



	//Nov 25
	@FindBy(xpath="(//button[contains(text(),'Edit')])[1]")
	public static WebElement editButton;

	//Nov 25
	@FindBy(xpath="(//label[.='Board']/..//i)[1]")
	public static WebElement clickProfileBoard;

	//Nov 25
	@FindBy(xpath="(//label[.='Board'])[1]/..//sui-select-option")
	public static WebElement selectProfileBoard;

	//Nov 25
	@FindBy(xpath="(//label[.='Medium']/..//i)[1]")
	public static WebElement clickProfileMedium;

	//Nov 25
	@FindBy(xpath="(//label[.='Medium'])/..//sui-select-option")
	public static WebElement selectProfileMedium;


	//Nov 25
	@FindBy(xpath="(//label[.='Class']/..//i)[1]")
	public static WebElement clickProfileClass;

	//Nov 25
	@FindBy(xpath="(//label[.='Class'])/..//sui-select-option")
	public static WebElement selectProfileClass;


	@FindBy(xpath="(//label[.='Subject']/..//i)[1]")
	public static WebElement clickProfilesubject;

	//Nov 25
	@FindBy(xpath="(//label[.='Subject'])/..//sui-select-option")
	public static WebElement selectProfileSubject;

	//Nov 25
	@FindBy(xpath="(//button[contains(.,'SUBMIT')])")
	public static WebElement submitButton;











	//Nov 28
	@FindBy(xpath="//label[contains(text(),'Subject')]/..//div[1]")
	public static WebElement clickProfileSubject;


	@FindBy(xpath="//label[contains(text(),'Board')]/following::i[1]/following::i[@class='delete icon'][1]")
	public static WebElement ProfileSlted;


	@FindBy(xpath="//span[@class='ui header']")
	public static WebElement ProfileHeaderTxt;


	//Nov 18
	@FindBy(xpath="//a[@href='/home']/following::a[contains(text(),'Home')]")
	//@FindBy(xpath="//a[contains(text(),'Home')]")
	public WebElement headerHome;


	//Dec 05
	@FindBy(xpath="//span[contains(@class,'todo-heading')]")
	//@FindBy(xpath="//span[@class='ui header accordian-heading mt-0']")
	public WebElement toDo;

	//Dec 05
	@FindBy(xpath="//span[contains(@class,'label')]")
	//@FindBy(xpath="//span[contains(@class,'todolabel')]")
	public WebElement toDoCount;


	//Nov 28
	//@FindBy(xpath="//div[contains(@class,'sbCard mt-20 mr-30')][1]")
	@FindBy(xpath="//div[contains(@class,'sbCard mt-20')][1]")
	public WebElement resultCourseCard;

	@FindBy(xpath="//p[@class='instruction']")
	public WebElement errorOnInstruction;

	//Dec 28
	@FindBy(xpath="(//label[.='Medium']/..//i)")
	public static WebElement profileMediumDropdown;

	//DEc 28
	@FindBy(xpath="(//label[.='Class']/..//i)")
	public static WebElement profileClassDropdown;

	//DEc 28
	@FindBy(xpath="(//label[.='Subject']/..//i)")
	public static WebElement profileSubjectDropdown;

	@FindBy(xpath="//div[@class='signInHead mt-27']")
	public WebElement forgotPasswordLabel;

	@FindBy(xpath="//button[contains(text(),'Reset')]")
	public WebElement ResetSubmit;
	
}	



