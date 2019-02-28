package org.page;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class  TopicTreePage 
{
	WebDriver driver;

	public  TopicTreePage(WebDriver driver)
	{ 
		this.driver=driver; 
	}
	
	@FindBy(xpath="//input[@placeholder='Name']")
	public WebElement bookName;
	
	@FindBy(xpath=" //*[@id='board']")
	public WebElement selectBoard;
	
	@FindBy(xpath="//*[@id='board']/div[3]/sui-select-option/span[2]")
	public WebElement selectRajasthanBoard;
	
	@FindBy(xpath="//*[@id='gradeLevel']")
	public WebElement selectGrade;
	
	@FindBy(xpath="//*[@id=\"gradeLevel\"]/div[2]/sui-select-option[1]/span[2] ")
	public WebElement selectGradeLevel;
	
	@FindBy(xpath="//*[@id='subject']")
	public WebElement selectSubject;
	
	@FindBy(xpath="//*[@id=\"subject\"]/div[3]/sui-select-option[1]/span[2]")
	public WebElement selectMathematics;
	
	@FindBy(xpath="//*[@id='medium']")
	public WebElement selectMedium;
	
	@FindBy(xpath="//*[@id=\"medium\"]/div[3]/sui-select-option[2]/span[2]")
	public WebElement selectEnglish;
	
	@FindBy(xpath="//input[@placeholder=\"Publisher\"]")
	public WebElement publisher;
	
	@FindBy(xpath="//*[@id='year']//span[2]")
	public WebElement selectYear;
	
	@FindBy(xpath="//button[@class=\"ui primary text-align-center icon button\"]")
	public WebElement startCreating;
	
	@FindBy(xpath="//button[@class='ui basic button text-transform-none'][2]//a[2]")
	public WebElement newChild;
	
	@FindBy(xpath="//*[@id='unitTopicSelector']")
	public WebElement selectTopic;
	
	@FindBy(xpath="//i[@class='checkmark icon']")
	public WebElement selectedTopics;
	
	@FindBy(xpath="//*[@id='topicSelector_unitTopicSelector']/div[4]/a[1]")
	public WebElement chooseAll;
	
	@FindBy(xpath="//*[@id=\"topicSelector_unitTopicSelector\"]/div[4]/a[2]/i")
	public WebElement removeAll;
	
	@FindBy(xpath="//a[@class=\"ui button close cancel\"]")
	public WebElement cancelButton;

	@FindBy(xpath="//a[@class=\"ui blue button accept\"]")
	public WebElement doneButton;
	
	@FindBy(xpath="//*[@id=\"topicSelector_unitTopicSelector\"]/div[1]")
	public WebElement topicHeader;
	
	@FindBy(xpath="//a[@class='tree item active']")
	public WebElement topics;
	
	@FindBy(xpath="//*[@id='closeButton']/a/i")
	public WebElement closeButton;
	
	@FindBy(xpath="//*[@id=\"topicSelector_unitTopicSelector\"]/div[3]/div[3]/div/div[1]/div[1]/a")
	public WebElement selectVedicMathematices;
	
	@FindBy(xpath="//*[@id=\"topicSelector_unitTopicSelector\"]/div[3]/div[3]/div/div[2]/div[1]/a")
	public WebElement selectNumberSystem;
	
	@FindBy(xpath="//*[@id=\"topicSelector_unitTopicSelector\"]/div[3]/div[4]/div/div[2]/div[1]/a")
	public WebElement selectImportantPointsOf;
	
	@FindBy(xpath="//*[@id=\"topicSelector_unitTopicSelector\"]/div[3]/div[4]/div/div[3]/div[1]/a/strong")	
	public WebElement numberSystem;
	
	
	@FindBy(xpath="//i[@class='checkmark icon']")
	public WebElement checkIcon;
	
	@FindBy(xpath="//input[@placeholder='Search']")
	public WebElement searchTopic;
	
	//Nov 28
	@FindBy(xpath="//strong[@class='search-query']")
	public WebElement resultsOnTopicSeacrh;
	
	
	
	//Dec 27
		@FindBy(xpath="//button[contains(text(),'Use Editor')]")
		public WebElement clickUseEditor;
}






