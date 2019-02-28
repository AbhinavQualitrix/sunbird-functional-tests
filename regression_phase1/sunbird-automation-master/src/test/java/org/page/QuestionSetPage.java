
package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class QuestionSetPage {
	WebDriver driver;
	CreatorUserPage QuestionSetPage=PageFactory.initElements(driver, CreatorUserPage.class);

	public  QuestionSetPage(WebDriver driver)
	{ 
		this.driver=driver; 
	}
	
	// @author Sachin
	// Web Element startCreating
	@FindBy(xpath="//button[contains(text(),'START CREATING')]")
	public WebElement startCreating;

	// @author Sachin
	// Web Element addQuestionSet
	@FindBy(xpath = "//*[contains(@class, 'icon-questions icon custom-menu-icon')]")
	public WebElement addQuestionSet;
	
	// @author Sachin
	// Web Element createQuestion
	@FindBy(xpath = "//button[contains(text(),'Create question')]")
	public WebElement createQuestion;
	
	// @author Sachin
	// Web Element MTF
	@FindBy(xpath="//a[contains(text(),'Match The Following')]/following::div[3]")
	//@FindBy(xpath = "//*[@id='templatsCards']/div/div[2]/div[3]/div/div")
	public WebElement MTF;
	
	// @author Sachin
	// Web Element Back
	@FindBy(xpath = "//button[contains(@id,'back-button')]")
	public WebElement Back;
	
	// @author Sachin
	// Web Element MCQ
	@FindBy(xpath="//a[contains(text(),'Multiple Choice Question')]/following::div[3]")
	//@FindBy(xpath = "//*[@id='templatsCards']/div/div[1]/div[3]/div/div")
	public WebElement MCQ;
	
	// @author Sachin
	// Web Element FIB
	@FindBy(xpath="//a[contains(text(),'Fill in the Blanks')]/following::div[3]")
	//@FindBy(xpath = "//*[@id='templatsCards']/div/div[3]/div[3]/div/div")
	public WebElement FIB;
	
	@FindBy(xpath="//input[@placeholder='Name']")
	public WebElement bookName;
	
	@FindBy(xpath="//a[contains(text(),'Fill in the Blanks')]/following::div[3]")
	//@FindBy(xpath = "//*[@id='templatsCards']/div/div[3]/div[3]/div/div")
	public WebElement FTB;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}


