package org.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContentCreationLessonPlanPage 
{
	WebDriver driver;

	public  ContentCreationLessonPlanPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}
	
	//TC_166 Click on copy
	@FindBy(xpath="//i[@class='ui large blue clone outline icon blue-text-color-sunbird ']")
	public  WebElement copyIcon;
	
	//167
	@FindBy(xpath="//span[1][@class='ng-binding']")
	public  WebElement textOnEditPage;
	
	//tc222
	@FindBy(xpath="//button[2][@class='ui basic button text-transform-none']")
	public  WebElement newChild;
	
	@FindBy(xpath="//Span[@class='label-icon-box-text save-button-text']")
	public  WebElement saveButton;
	
	//tc233
	//USer profile
	@FindBy(xpath="(//*[@id='dropdown-menu-list-header'])[2]")
	public  WebElement profileIcon;
	
	@FindBy(xpath="//html/body/app-root/app-workspace/div/div[2]/app-workspacesidebar/div/a[7]")
	public  WebElement upForReviewButton;
	
	
	@FindBy(xpath="/html/body/app-root/app-workspace/div/div[3]/app-up-for-review/table/tbody/tr[1]/td[1]")
	public  WebElement latestContent;
	
	//tc_238

	//Dec 04
	//@FindBy(xpath="//button[contains(text(),' REQUEST CHANGES ')]")
	@FindBy(xpath="//span[contains(text(),'Request Changes')]")
	public  WebElement requestChanges;
	
	@FindBy(xpath="//label[@class='content-title popup-item ng-binding ng-scope']")
	public WebElement copiedContentName;	
	
	//tc 238
	@FindBy(xpath="/html/body/sui-modal/sui-dimmer/div/div/div/div[2]/div[2]/div/div/textarea")
	public WebElement commentTextArea;
		
	
	//tc 240
	@FindBy(xpath="https://staging.open-sunbird.org/workspace/content/upForReview/")
	public WebElement pageURL;
	
	//tc 237

	
	
}
