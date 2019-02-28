package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class CreatorAnnouncementPage {
	WebDriver driver;
	
	public CreatorAnnouncementPage(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	
	//Added on 22-Oct0-2018
	@FindBy(xpath="//*[@class='close icon']")
	public WebElement CloseAnnouncementPopup;
	
	
	
	//oct 12 v1.11.0
	@FindBy(xpath="//div[contains(@class,'dropdown right top pointing')]/..//a[contains(.,'Announcement dashboard')]")
	public WebElement announcement_Dashboard;
	
	@FindBy(xpath="//span[text()='CREATE ANNOUNCEMENT']")
	public WebElement create_Announcement;
	
	@FindBy(xpath="//input[@placeholder=\"Please enter relevant title for this announcement (Max: 100 chars)\"]")
	public WebElement enterTitle;
	
	@FindBy(xpath="//input[@placeholder='Please enter organisation/department that has sent the announcement']")
	public WebElement enterOrg;
	
	@FindBy(xpath="//div[text()='Select announcement type']")
	public WebElement announcementType;
	
	//OCT 12 v1.11.0
	@FindBy(xpath="//div[text()='Select announcement type']/..//sui-select-option")
	//@FindBy(xpath="//sui-select-option[@class='item']/span[text()='Order']")
	public WebElement announcementTypeOrder;
	
	@FindBy(xpath="//sui-select-option[@class='item']/span[text()='Circular']")
	public WebElement announcementTypeCircular;
	
	//@FindBy(xpath="(//input[@placeholder='Please enter description for this announcement (Max: 1200 chars)'])[3]")
	@FindBy(xpath="//input[@formcontrolname='description']")
	public WebElement enterDescription;
	
	@FindBy(xpath="//span[@class='cursor-pointer blue-text-color-sunbird']")
	public WebElement addUrl;
	
	@FindBy(xpath="//input[@placeholder='Enter web url (starting with http or https)']")
	public WebElement enterUrl;
	
	
	//Updated on 22-Oct-2018
		@FindBy(xpath="(//label[.='UPLOAD ATTACHMENT']/..//span[.='UPLOAD ATTACHMENT'])[2]")
	//@FindBy(xpath="(//span[text()='UPLOAD ATTACHMENT'])[8]")
	public WebElement uploadDocument;
	
	@FindBy(xpath="//button[contains(text(),'SELECT RECIPIENTS')]")
	public WebElement selectRecipient;
	
	@FindBy(xpath="//input[@placeholder='Search for location']")
	public WebElement searchForLocation;
	
	//OCT 12 v1.11.0
	@FindBy(xpath="//sui-checkbox//label")
	//@FindBy(xpath="//sui-checkbox[@class='ui checkbox ng-untouched ng-pristine ng-valid']")
	public List<WebElement> checkLocation;
	
	@FindBy(xpath="//div[text()='CONFIRM RECIPIENTS']")
	public WebElement confirmRecipients;
	
	@FindBy(xpath="//span[text()='BACK']")
	public WebElement back;
	
	@FindBy(xpath="//div[text()='PREVIEW ANNOUNCEMENT']")
	public WebElement previewAnnouncement;
	
	@FindBy(xpath="//span[contains(text(),'VIEW')]")
	public WebElement view;
	
	@FindBy(xpath="//button[contains(text(),'SEND ANNOUNCEMENT')]")
	public WebElement sendAnnouncement;
	
	@FindBy(xpath="//button[@class='ui primary basic button announcement-button btn-width-34 approve']")
	public WebElement announcementcreatedConfirmation;
	
	@FindBy(xpath="//button[@class='ui basic button announcement-button btn-width-26 announcement-button-text']")
	public WebElement stopCreatingAnnouncementMessageYes;
	
	@FindBy(xpath="//button[@class='ui button primary announcement-button btn-width-26 close']")
	public WebElement stopCreatingAnnouncementMessageNo;
	
	
	@FindBy(xpath="//div[@class='item headerDropdownProfile']")
	public WebElement userNameInDropDown;
	
	@FindBy(xpath="//a[text()='Profile']")
	public WebElement profileInDropDown;
	
	@FindBy(xpath="//a[text()='Workspace']")
	public WebElement workspaceInDropDown;
	
	@FindBy(xpath="(//a[text()='My Activity'])[2]")
	public WebElement myActivityInDropdown;
	
	@FindBy(xpath="//td[@class=\"cursor-pointer red-text-color-sunbird\"]")
	public WebElement deleteAnnouncementButton;
	
	@FindBy(xpath="//td[@class=\"cursor-pointer red-text-color-sunbird\"]/../td[1]")
	public WebElement selectAnnouncementName;
	
	@FindBy(xpath="//div[@class=\"header padding-top-5 segment-heading\"]")
	public List<WebElement> reviewAnnouncement;
	
	@FindBy(xpath="//a[text()='See All']")
	public WebElement seeAllAnnouncement;
	
	@FindBy(xpath="//i[@class=\"right chevron icon\"]")
	public WebElement nextarrowOnHomePage;
	
	@FindBy(xpath="//table[@class=\"ui padded table\"]/thead/tr/th[1]")
	public WebElement announcementTableName;
	
	@FindBy(xpath="//table[@class=\"ui padded table\"]/thead/tr/th[6]")
	public WebElement announcementTableActions;
	
	@FindBy(xpath="//table[@class=\"ui padded table\"]//tr[@class=\"table-list-name-ann\"]/td")
	public WebElement announcementTableNameContent;
	
	@FindBy(xpath="//table[@class=\"ui padded table\"]//td[@class=\"cursor-pointer blue-text-color-sunbird\"]")
	public WebElement announcementTableActionsContent;
	
	@FindBy(xpath="//div[@class='pt-10 segment-heading']")
	public WebElement announcementReview;
	
	
	@FindBy(xpath="//td[@class=\"cursor-pointer blue-text-color-sunbird\"]")
	public WebElement resendAnnouncementButton;
	
	@FindBy(xpath="//td[@class=\"cursor-pointer blue-text-color-sunbird\"]/../td[1]")
	public WebElement resendAnnouncementName;
	
	
	//Dec 11
	@FindBy(xpath="//div[contains(@class,'5 segment-heading')]")
	//@FindBy(xpath="//div[@class='header padding-top-5 segment-heading']")
	public WebElement reviewAnnouncementN;
	
	@FindBy(xpath="//i[@class='close icon']")
	public WebElement popupCloseIcon;
	
	@FindBy(xpath="//button[.=' EDIT RECIPIENTS ']")
	public WebElement editRecipients;

	
	// @author Sachin
	@FindBy(xpath="//input[contains(@formcontrolname,'title')]")
	public WebElement resendTitle;
	
	// @author Sachin
	@FindBy(xpath="(//td[contains(@tabindex,'0')])[1]")
	public WebElement editedAnnouncement;
	
	// @author Sachin
	@FindBy(xpath="(//button[contains(@type,'button')])[11]")
	public WebElement selectRecipients;
}
