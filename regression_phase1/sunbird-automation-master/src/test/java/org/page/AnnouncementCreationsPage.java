package org.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnnouncementCreationsPage 
{
	WebDriver driver;

	public  AnnouncementCreationsPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}
	
	//Nov 13th
	@FindBy(xpath="//div[contains(@class,'dropdown right top pointing')]")
	//@FindBy(xpath="//img[@class='ui circular image logged-in-user']")
	public WebElement profileIcon;
	
	//Nov 13th
	@FindBy(xpath="//div[contains(@class,'dropdown right top pointing')]/..//a[contains(.,'Announcement dashboard')]")
	//@FindBy(xpath="//a[@class='item'][contains(text(),'Announcement dashboard')]")
	public WebElement announcementDashboardMenu;
	
	@FindBy(xpath="//span[@class='announcement-button-text']")
	public WebElement verifyMyAnnouncementPageIsDisplayed;

	
	@FindBy(xpath="//div[@class='header']")
	public WebElement verifyNoAnnouncementMessage;
	
	
	
	@FindBy(xpath="//tr[@class='ann-table-heading']")
	public WebElement fetchAnnouncementHeader;
	
	
		
	@FindBy(xpath="//tr[@class='table-list-name-ann'][1]")
	public WebElement checkAnnouncementData;
	
	
	
	@FindBy(xpath="//span[@class='announcement-button-text']")
	public WebElement clickCreateAnnoucement;
	
	
	@FindBy(xpath="//label[contains(text(),'TITLE')]")
	public WebElement announcementTitle;
	
	
	@FindBy(xpath="//label[contains(text(),'FROM')]")
	public WebElement announcementFrom;
	
	
	
	@FindBy(xpath="//label[contains(text(),'ANNOUNCEMENT TYPE')]")
	public WebElement announcementType;
	
	
	
	@FindBy(xpath="//label[contains(text(),'DESCRIPTION')]")
	public WebElement announcementDescription;
	
	@FindBy(xpath="//label[contains(text(),'URL / WEBLINK')]")
	public WebElement announcementURL;

	

	@FindBy(xpath="//label[contains(text(),'UPLOAD ATTACHMENT')]")
	public WebElement announcementUploadAttachment;
	
	
	@FindBy(xpath="//h4[contains(text(),'Popular')]")
	public WebElement headerLibraryTitles;

	@FindBy(xpath="//h4[contains(text(),'Course')]")
	public WebElement headerCourseTitles;
	
	@FindBy(xpath="//i[@class='close icon']")
	public WebElement popupCloseIcon;
	
	@FindBy(xpath="//div[@class='ui primary basic button announcement-button btn-width-34']")
	public WebElement popupCloseIconYes;
}

