package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AllMyContentPage 
{
	WebDriver driver;

	public  AllMyContentPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}
	@FindBy(xpath="//a[@href='/workspace/content/allcontent/1']")
	public WebElement allMyContent;

	// @author Sachin
	// Web Element sortByDropdown
	@FindBy(xpath = "//*[@id=\"sortByDropDown\"]/sui-select/i")
	public WebElement sortByDropdown;
	
	// @author Sachin
	// Web Element modifiedOnDropdown
	@FindBy(xpath = "//span[contains(.,'Modified On')]")
	public WebElement modifiedOnDropdown;
	
	// @author Sachin
	// Web Element createdOnDropdown
	@FindBy(xpath = "//span[contains(.,'Created On')]")
	public WebElement createdOnDropdown;
	
	//Adding elements for test case 14
	@FindBy(xpath="//span[@class='browse item cursor-pointer'][contains(.,'Show Filters')]")
	public WebElement filterIcon;
	
	// @author Sachin
	// Web Element selectStatus
	@FindBy(xpath = "//sui-multi-select[contains(@id,'status')]")
	public WebElement selectStatus;
	
	// @author Sachin
	// Web Element draftSelect
	@FindBy(xpath = "//sui-select-option[@class='item selected'][contains(.,'Draft')]")
	public WebElement draftSelect;
	
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
	
	@FindBy(xpath="//a[.='APPLY']")
	public WebElement applyButton;
	
	@FindBy(xpath="(//i[@class='trash large icon'])[1]")
	public WebElement deleteButton ;
	
	// @author Sachin
	// Web Element firstDraft
	@FindBy(xpath = "(//div[contains(@class,'UpReviewHeader')])[1]")
	public WebElement firstDraft;
	
	// @author Sachin
	// Web Element confirmYesToPopup
	@FindBy(xpath = "//button[@class='ui primary button'][contains(.,'Yes')]")
	public WebElement confirmYesToPopup;
	
	// @author Sachin
	// Web Element searchContent
	@FindBy(xpath = "//input[@placeholder='Search content']")
	public WebElement searchContent;
	
	// @author Sachin
	// Web Element resetFilter
	@FindBy(xpath = "//a[contains(.,'RESET')]")
	public WebElement resetFilter;
	
	@FindBy(xpath="(//a[contains(.,'Workspace')])")
	public WebElement workSpace;
	
	@FindBy(xpath = "//i[@class='circular search link icon']")
	public WebElement searchIconUpForReview;
	
	@FindBy(xpath="//button[.='Yes']")
	public WebElement yesButtonPopup ;
	
	// @author Sachin
	// Web Element  closePopUp 
	@FindBy(xpath = "//i[contains(@class,'close icon')]")
	public WebElement closePopUp;
	
	@FindBy(xpath="(//a[contains(.,'Workspace')])")
	public WebElement Workspace;
	
	
	
	
	
	
	
	
	
	
	
	
	

}
