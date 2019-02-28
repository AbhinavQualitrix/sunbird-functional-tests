package org.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ExplorePage  {
	
	WebDriver driver;
	
	public ExplorePage(WebDriver driver) {
		this.driver=driver;
	}

	@FindBy(xpath="(//app-card[@class='pr-20 d-block'])[11]")
	public WebElement clickOnFirstTextBook;
	
	@FindBy(xpath="//div[@class='accordian-left-text']")
	public WebElement clickOnFirstTextBookTOC;
	
	@FindBy(xpath="//span[@class='fancytree-node fancytree-exp-n fancytree-ico-c']")
	public WebElement clickOnFirstTextBookTOCUnits;
	
	
}
