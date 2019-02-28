package org.page;


import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.startup.BaseTest;
/**
* Created by Qualitrix Technologies Pvt Ltd.
* Purpose: To capture and maintain all webelements related to SignUpPage
*/
public class SignUpPage extends BaseTest {
	WebDriver driver;
	
	//Nov 9th
	@FindBy(xpath="(//a[contains(text(),'SIGN UP')])[2]")
	public WebElement signUpLink;
	
	//Nov 9th
	//@FindBy(name="userName")
	@FindBy(xpath="//input[@formcontrolname='userName']")
	public WebElement username;
	
	//Nov 9th
	@FindBy(xpath="//input[@type='password']")
	//@FindBy(name="password")
	public WebElement password;
	
	//Nov 9th
	//@FindBy(name="firstName")
	@FindBy(xpath="//input[@formcontrolname='firstName']")
	public WebElement firstName;
	
	@FindBy(xpath="//div/input[@placeholder='Last Name']")
	public WebElement lastName;
	
	//Nov 9th
	@FindBy(xpath="//input[@formcontrolname='phone']")
	//@FindBy(name="phone")
	public WebElement phone;
	
	//Nov 9th
	@FindBy(xpath="//input[@formcontrolname='email']")
	//@FindBy(name="email")
	public WebElement email;
	
	//Nov 9th
	@FindBy(xpath="//div//button[.='SIGN UP']")
	public WebElement signUpButton; 
	
	@FindBy(xpath="//i[@class='dropdown icon']")
	public WebElement languageDropdown;
	
	//9th Nov
	@FindBy(xpath="//sui-select-option[@class='item selected']//span[2]")
	//@FindBy(xpath="//div[.='English']")
	public WebElement selectLanguage;
	

	@FindBy(xpath="//div[@class='iziToast-texts']//strong[@class='iziToast-title slideIn']")
	public List<WebElement> alertMessage;
	
	@FindBy(xpath="//div[contains(@class,'ui pointing red basic label below')]")
	public List<WebElement> alertLabel;
}

