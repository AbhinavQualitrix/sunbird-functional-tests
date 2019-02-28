package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AnnouncementPage 
{
	WebDriver driver;

	public  AnnouncementPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}
	
	// @author Sachin
	// Web Element No Content 
	@FindBy(xpath = "//i[contains(@class,'close icon')]")
	public WebElement closePopUp;
	
	
	@FindBy(xpath="//div[contains(@class,'dropdown right top pointing')]")
	public WebElement profileIconDropdown;
	
	@FindBy(xpath="//div[contains(@class,'dropdown right top pointing')]/..//a[contains(.,'Announcement dashboard')]")
	public WebElement announcement_Dashboard;
	
	@FindBy(xpath="(//input[contains(@class,'ng-untouched ng-pristine ng-invalid')])[1]")
	public WebElement enterTitle;
	
	@FindBy(xpath="//input[@placeholder='Please enter organisation/department that has sent the announcement']")
	public WebElement enterOrg;
	
	@FindBy(xpath="//div[text()='Select announcement type']")
	public WebElement announcementType;
	
	@FindBy(xpath="//sui-select-option[@class='item']/span[text()='Circular']")
	public WebElement announcementTypeCircular;
	
	@FindBy(xpath="//input[@formcontrolname='description']")
	public WebElement enterDescription;
	
	@FindBy(xpath="//span[@class='cursor-pointer blue-text-color-sunbird']")
	public WebElement addUrl;
	
	@FindBy(xpath="//input[@placeholder='Enter web url (starting with http or https)']")
	public WebElement enterUrl;
	
	@FindBy(xpath="(//td[contains(.,'Resend')])[1]")
	public WebElement resendAnnouncementButton;
	
	@FindBy(xpath="//input[contains(@formcontrolname,'title')]")
	public WebElement resendTitle;
	
	@FindBy(xpath="(//button[@type='button'])[11]")
	public WebElement editRecipients;
	
	@FindBy(xpath="//input[@placeholder='Search for location']")
	public WebElement searchForLocation;
	
	@FindBy(xpath="//div[text()='CONFIRM RECIPIENTS']")
	public WebElement confirmRecipients;
	
	@FindBy(xpath="//div[text()='PREVIEW ANNOUNCEMENT']")
	public WebElement previewAnnouncement;
	
	@FindBy(xpath="//button[contains(text(),'SEND ANNOUNCEMENT')]")
	public WebElement sendAnnouncement;
	
	@FindBy(xpath="//button[@class='ui primary basic button announcement-button btn-width-34 approve']")
	public WebElement announcementcreatedConfirmation;
	
	@FindBy(xpath="(//td[contains(@tabindex,'0')])[1]")
	public WebElement editedAnnouncement;
	
	@FindBy(xpath="//span[text()='BACK']")
	public WebElement back;
	
	@FindBy(xpath="(//button[contains(@type,'button')])[11]")
	public WebElement selectRecipients;
	
	@FindBy(xpath="//label[contains(.,'Nellore')]")
	public WebElement checkLocation;
	
	@FindBy(xpath="//span[contains(.,'CREATE ANNOUNCEMENT')]")
	public WebElement create_Announcement;
	
	//OCT 12 v1.11.0
	@FindBy(xpath="//div[text()='Select announcement type']/..//sui-select-option")
	//@FindBy(xpath="//sui-select-option[@class='item']/span[text()='Order']")
	public WebElement announcementTypeOrder;
	
}