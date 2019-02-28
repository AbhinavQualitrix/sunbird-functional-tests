package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GetPage {

	WebDriver driver;

	public  GetPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}

	//Added for TC008

	@FindBy(xpath="//input[@name='search']")
	public WebElement getPageSearch;

	@FindBy(xpath="//div[@class='ui tiny image']")
	public WebElement getPageGooglePlayIcon;


	//Added for TC015

	//Nov 9th 
	//@FindBy(xpath = "//button[contains(text(),'Explore sunbird')]")
	//@FindBy(xpath = "(//button[contains(text(),'Explore sunbird')])[2]")
	@FindBy(xpath = "//span[contains(.,'GET STARTED')]")
	public WebElement getStartedExplore;




	@FindBy(xpath="//button[@class='ui basic button left-float']")
	public WebElement xEnterDialCode_Hindi;

	//On Nov 9th
	@FindBy(xpath = "(//sui-select[@labelfield='name'])[2]")
	//@FindBy(xpath = "//sui-select[@labelfield='name']")
	public WebElement xLanguageChange;

	@FindBy(id = "board")
	public WebElement iBoard;

	//Dec 18
	//@FindBy(id = "medium")
	@FindBy(xpath="//sui-multi-select[@id='medium']")
	public WebElement iMedium;

	@FindBy(id = "subject")
	public WebElement iSubject;

	@FindBy(id = "gradeLevel")
	public WebElement iClass;

	@FindBy(xpath = "//a[contains(text(),'SUBMIT')]")
	public WebElement xBtnSubmit;

	@FindBy(xpath = "//a[contains(text(),'RESET')]")
	public WebElement xBtnReset;

	@FindBy(xpath = "//div[@role='listbox']")
	public List<WebElement> xListOfContents;

	//Nov 9th
	@FindBy(xpath="(//sui-select-option[@class='item']//span[contains(text(),'Hindi')])[2]")
	//@FindBy(xpath="//sui-select-option[@class='item']//span[contains(text(),'Hindi')]")
	public WebElement xSelectHindiLanguage;

	@FindBy(xpath="//div[contains(text(),'SUBMIT')]")
	public WebElement xDivBtnSubmit;



	//Nov 13th - reverted to old again
	//@FindBy(xpath=".//div[@class='sbCard mt-20 mr-30']//h4")
	@FindBy(xpath="//div[@class='title']")
	public List<WebElement> xDialContentTitles;

	//Nov 13th
	@FindBy(xpath = "(//div[contains(text(),' Select Board')]/..//sui-select-option/div/div/div[contains(text(),'State (Rajasth')])")
	//@FindBy(xpath = "//sui-select-option[@class='multi-select-dropdown multi-select-padding item selected']/div/div/div[contains(text(),'Andhra')]")
	public WebElement xSelectBoard;

	//Nov 13th
	@FindBy(xpath = "//div[contains(text(),'Select Medium')]/..//sui-select-option/div/div/div[contains(text(),'English')]")
	//@FindBy(xpath = "//sui-select-option[@class='multi-select-dropdown multi-select-padding item selected']/div/div/div[contains(text(),'Telugu')]")
	public WebElement xSelectMedium;

	//Nov 13th
	@FindBy(xpath = "//div[contains(text(),'Select Subject')]/..//sui-select-option/div/div/div[contains(text(),'English')]")
	//@FindBy(xpath = "//sui-select-option[@class='multi-select-dropdown multi-select-padding item selected']/div/div/div[contains(text(),'Science')]")
	public WebElement xSelectSubject;

	//Nov 13th
	@FindBy(xpath = "//sui-select-option[contains(@class,'multi-select-')]/div[contains(.,'Class 2')]/div")
	//@FindBy(xpath = "//sui-select-option[@class='multi-select-dropdown multi-select-padding item selected']/div/div/div[contains(text(),'Class 6')]")
	public WebElement xSelectClass;


	//Added on 13th Nov
	@FindBy(xpath="(//sui-select-option[@class='item']//span[contains(text(),'English')])[2]")
	public WebElement xSelectEnglishLanguage;

	//Nov 30
	@FindBy(xpath="//div[contains(@class,'sbCard mt')]/div[@class='sub-header']/h4")
	public WebElement exploreDikshaContentCard;

	//Dec 18
	//@FindBy(xpath = "//button[contains(text(),'Explore sunbird')]")
	//@FindBy(xpath = "(//button[contains(text(),'Explore sunbird')])[2]")
	//@FindBy(xpath = "//span[contains(.,'GET STARTED')]")
	@FindBy(xpath = "//div//ul//li//a[normalize-space()='Explore Content']")
	public WebElement exploreContent;


    //Dec 25
    @FindBy(xpath = "//input[@id='keyword']")
    //@FindBy(css = "#keyword")
    public WebElement idSearchBar;

    //Dec 25
    @FindBy(xpath = "(//span[contains(text(),'Enter QR code')])")
    //@FindBy(xpath = "(//button[contains(text(),'Enter DIAL code')])[2]")    
    //@FindBy(xpath = "//button[contains(text(),'Enter DIAL code')]")
    public WebElement xEnterDialCode;


    //Dec 25
    @FindBy(xpath="//div[contains(@class,'ui tiny header')")
    //@FindBy(xpath="//div[@class='ui tiny header']")
    public WebElement getPageDialCode;

    //DEc 25
    @FindBy(xpath=".//div[contains(@class,'sbCard mt-20 mr-30')]")
    //@FindBy(xpath="//div[@class='cardImageText center aligned ']/span")
    public List<WebElement> reviewDialCodeRelatedContent;



}
