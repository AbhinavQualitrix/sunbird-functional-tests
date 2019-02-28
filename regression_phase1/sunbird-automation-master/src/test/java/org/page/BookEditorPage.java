package org.page;



import java.util.List;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;

public class BookEditorPage {

	WebDriver driver;

	public BookEditorPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}

	
	@FindBy(xpath="//*[.='Add']")
	public List<WebElement> addInExploreSuggestions;
	
	@FindBy(xpath="//*[.='Add']")
	public WebElement addInExploreSuggestion;

	@FindBy(xpath="//*[.='TOC']")
	public WebElement dropDownTOC ;

	@FindBy(xpath="//*[.='TOC']/following::div/div[contains(.,'Download ToC Metadata')]")
	public WebElement downloadTOCMetadata;

	@FindBy(xpath="//*[.='TOC']/following::div/div[contains(.,'Update ToC Metadata')]")
	public WebElement updateTOCMetadata;
	
	@FindBy(xpath="//strong[@class='slideIn']")
	public WebElement messageBox;
	
	@FindBy(xpath="(//span[@class='ui tiny header'])[2]")
	public WebElement dropdownQR_Codes ;
	
	@FindBy(xpath="//*[contains(text(),'QR codes')]/../../div[1]")
	public WebElement generateQR_Codes ;
	
	@FindBy(xpath="//*[@type='number']")
	public WebElement requestQR_Codes ;
	
	@FindBy(xpath="//*[@value='Request']")
	public WebElement requestButtonInQR_Codes ;
	
	@FindBy(xpath="//span[@class='text ng-binding']")
	public WebElement downloadQR_Codes ;
	
	@FindBy(xpath="(//*[@class='ng-binding ng-scope'])[2]")
	public WebElement ownershipTypeInContent ;
	
	@FindBy(xpath="//span[@class='ng-scope']")
	public WebElement viewDetailsLink ;
	
	@FindBy(xpath="//table[@class='ui very basic table contentDetails']/tbody/tr[14]")
	public WebElement ownerInViewDetailsPage ;
	
	
}
