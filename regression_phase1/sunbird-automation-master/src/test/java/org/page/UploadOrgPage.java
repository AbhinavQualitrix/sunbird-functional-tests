package org.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class UploadOrgPage {

	WebDriver driver;

	public UploadOrgPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}

	
	//Updated on 10 Oct
	@FindBy(id="signInImg")
	//@FindBy(xpath="//span[.='LOGIN']")
	//@FindBy(xpath="(//a[contains(text(),'LOGIN')])[2]")
	public WebElement loginButton;

	@FindBy(id="username")
	public WebElement username;

	@FindBy(id="password")
	public WebElement password;

	//@FindBy(xpath="//button[.='Login']")
	@FindBy(id="kc-login")
	public WebElement clickLogin;
	
	//@FindBy(name="login")
	@FindBy(xpath="//p/preceding::button[contains(.,'Sign In')]")
	public WebElement clickLogin1;

	//DEC 25
	//@FindBy(xpath="(//div[contains(@class,'dropdown right top pointing')])[2]")
	//@FindBy(xpath="(//*[@id='dropdown-menu-list-header'])[2]")
	//@FindBy(id="dropdown-menu-list-header")
	@FindBy(xpath="//div[contains(@class,'dropdown right top pointing')]")
	public WebElement dropdown;

	//Updated on 23/08/2018
	//@FindBy(xpath="//a[contains(text(),'Profile')]")
	@FindBy(xpath="//div[contains(@class,'dropdown right top pointing')]/..//a[contains(.,'Profile')]")
	public WebElement clickProfileIcon;

	@FindBy(xpath="//a[contains(text(),'Check Upload Status')]")
	public WebElement uploadStatus;

	@FindBy(xpath="//sui-select-option//span[contains(text(),'Upload Organizations')]")
	//@FindBy(xpath="//a[contains(text(),'Upload Organizations')]")
	public WebElement organizationUpload;

	@FindBy(xpath="//button[contains(text(),'UPLOAD ORGANIZATIONS CSV')]")
	public WebElement uploadCSV;

	@FindBy(xpath="//strong[.='Invalid column name.']")
	public WebElement invalidUpload;

	//@FindBy(className="iziToast-close")//
	//@FindBy(xpath="//div[@class='iziToast-texts']/strong[contains(text(),'Invalid column:')]")
	@FindBy(xpath="//div[@class='iziToast-texts']/strong[@class='iziToast-title slideIn']")
	public WebElement uploadErrorToast;

	//@FindBy(xpath="//div[.='Upload Organizations']/../div[@class='one wide column actions']")
	@FindBy(xpath="(//i[@class='close icon'])[2]")
	public WebElement closePopup;

	@FindBy(xpath="//div[4]//a[.='Course']")
	public WebElement elementpresent; 

	@FindBy(xpath="//div[@class='WorkSpaceTextContent']")
	public WebElement elementWorkspace; 

	@FindBy(xpath="//p[contains(text(),'Process ID:')]")
	public WebElement processID;
	
	//Updated on 16 NOv 2018
	//@FindBy(xpath="//a[.='Upload Users']")
	//@FindBy(xpath="//a[contains(text(),'Upload Users')]")
	@FindBy(xpath="//sui-select-option//span[contains(text(),'Upload Users')]")
	public WebElement uploadUsers;
	
	@FindBy(xpath="//input[@placeholder='OrgId']")
	public WebElement clickOrgId;
 
	//Updated on 30 May 2018
	//@FindBy(xpath="//button[.='UPLOAD USERS CSV']")
	@FindBy(xpath="//button[contains(text(),'UPLOAD USERS CSV')]")
	public WebElement uploadUsersCsv;
	 
	//@FindBy(xpath="//a[.='Check Upload Status']")
	
	//Updated on 16 Nov 2018
	@FindBy(xpath="//sui-select-option//span[contains(text(),'Check Upload Status')]")
	//@FindBy(xpath="//a[contains(text(),'Check Upload Status')]")
	public WebElement checkUploadStatus;
	
	@FindBy(xpath="//input[@placeholder='Process ID']")
	public WebElement cProcessId;
	
	//@FindBy(xpath="//thead[@class='ng-scope']/..//td[@class='ng-binding'][1]")
	//Updated on 30 May 2018
	@FindBy(xpath="//table//tbody//td[1]")
	public WebElement getOrgId;
	
	@FindBy(xpath="//h5[contains(.,'Uploaded File: ')]")
	public WebElement uploadedRUser;
	
	//Updated on Nov 19th
	@FindBy(xpath="//input[@placeholder='Process ID']/following::button['CHECK STATUS']")
	//@FindBy(xpath="//button['CHECK STATUS']")
	public WebElement checkStatusButton;
	
	//Updated on 30 May 2018
	//@FindBy(xpath="//div[@id='statusBulkUpload']//i")
	@FindBy(xpath="//i[@class='close icon']")
	public WebElement closeWindow;
	
	@FindBy(xpath="//div[@id='userBulkUpload']/..//i[@class='ui remove icon']")
	public WebElement closeWindow1;
	
	//Updated both xpaths of externalId and provider
	//@FindBy(xpath="//thead[@class='ng-scope']/..//td[@class='ng-binding'][5]")
	@FindBy(xpath="//table//tbody//td[5]")
	public WebElement externalId;
	
	//@FindBy(xpath="//thead[@class='ng-scope']/..//td[@class='ng-binding'][6]")
	@FindBy(xpath="//table//tbody//td[6]")
	public WebElement provider;
	
	//Updated on 31 may
	//@FindBy(xpath="//input[@placeholder='External Id']")
	@FindBy(xpath="//input[@placeholder='OrgExternalId']")
	public WebElement uploadUserExternal_Id;
	
	
	//@FindBy(xpath="//input[@placeholder='Provider']")
	@FindBy(xpath="//input[@placeholder='OrgProvider']")
	public WebElement uploadUserProvider;
	
	
	//OCT 10 - v1.11.0
	@FindBy(xpath="//div[contains(@class,'dropdown right top pointing')]/..//a[contains(.,'Admin dashboard')]")
	//@FindBy(xpath="//div[@class='menu transition hidden']//a[.='Admin dashboard']")
	//@FindBy(xpath="(//*[@id='dropdown-menu-list-header'])[2]//following::a[.='Admin dashboard']")
	public WebElement clickAdminDashboardIcon;
	
	//@FindBy(xpath="//div[.='Select Organization']")
	@FindBy(xpath="//div[@class='ui dropdown']//div[.='Select Organization']")
	public WebElement selectOrganizationDropdown;
	
	@FindBy(xpath="//div[contains(text(),'ORG25')]")
	public WebElement selectOrg;
	
	@FindBy(xpath="//span[1]//i[@class='dropdown icon']")
	public WebElement rightDropdownList;
	
	@FindBy(xpath="//div[contains(text(),'Creation')]")
	public WebElement clickCreation;
	
	@FindBy(xpath="//div[.='Consumption']")
	public WebElement clickConsumption;
	
	@FindBy(xpath="//div[@class='meta dashBoardCardText ng-binding']")
	public String dashboardCards;
	
	@FindBy(xpath="//div[.='Number of contents created']")
	public WebElement contentsCreated;
	
	@FindBy(xpath="//div[.='Number of authors']")
	public WebElement authors;
	
	@FindBy(xpath="//div[.='Number of reviewers']")
	public WebElement reviewers	;
	
	//@FindBy(xpath="//a[.='CSV']")
	@FindBy(xpath="//a[contains(text(),'CSV')]")
	public WebElement csvLink;
	

	
	@FindBy(xpath="//div//span[contains(text(),'LAST 14 DAYS')]")
	public WebElement last14Days;
	
	@FindBy(xpath="//div//span[contains(text(),'LAST 5 WEEKS')]")
	public WebElement last5Weeks;
	
	@FindBy(xpath="//span[contains(text(),'LAST 7 DAYS')]")
	public WebElement last7Days;
	
	@FindBy(xpath="//div[.='Number of visits by users']")
	public WebElement visits;
	
	@FindBy(xpath="//div[.='Content consumption time']")
	public WebElement consumptionTime;
	
	@FindBy(xpath="//div[.='Average time spent by user per visit']")
	public WebElement avgTime;
	

	@FindBy(xpath="//div[@class='content']//p")
	public WebElement thankYouMessage;
	
	//Nov 19th
	@FindBy(xpath="//strong[@class='iziToast-title slideIn']")
	public static WebElement errorToast;

	//Added on Nov 16th
	@FindBy(xpath="//sui-select//div[@class='default text'][.='Admin Actions']/following::i[@class='dropdown icon']")
	public static WebElement adminActionsButton;
	
	
	//Nov 25
	//@FindBy(xpath="(//i[@class='close icon'])")
	@FindBy(xpath="(//i[@class='close icon'])[1]")
	public WebElement closeThanks;
	
	@FindBy(css="#radial-mood-response-rate > svg > g > g.labels.q2")
	public WebElement radial1;
	
		//-------------------------------------------------------------
	@FindBy(xpath="//*[@id='radial-mood-response-rate']/svg")
	public WebElement radial;
	
	//Dec 25
	@FindBy(xpath="//div[contains(@class,'dropdown right top pointing')]/..//a[contains(.,'Logout')]")
	//@FindBy(xpath="(//div[@class='item headerDropdownProfile'])[2]/following::a[contains(.,'Logout')]")
	//@FindBy(xpath="(//div[@id='dropdown-menu-list-header'])[2]//a[.='Logout']")
	//@FindBy(xpath="//a[.='Logout']")
	//@FindBy(xpath="//div[@id='dropdown-menu-list-header']//a[.='Logout']")
	public WebElement logout;
	
	
	
	//Updated on 13 Dec
		@FindBy(xpath="//img[@alt='Diksha App logo'][1]/preceding::button[1]")
		public WebElement loginButton3;

		
		//Dec 28
        @FindBy(xpath="(//a[contains(text(),'Sign In')])[2]")
        //@FindBy(xpath="(//a[contains(text(),'LOGIN')])[2]")
        public WebElement loginInExplorePage;
		
	
}




