package org.generic;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.comparison.ImageDiff;
import ru.yandex.qatools.ashot.comparison.ImageDiffer;

import org.testng.AssertJUnit;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.page.CreatorAnnouncementPage;
import org.page.CreatorUserPage;
import org.pageobjects.CreatorAnnouncementPageObj;
import org.pageobjects.CreatorUserPageObj;
import org.startup.BaseTest;
import org.startup.IAutoConst;
import org.generic.ExtentTestManager;
import org.generic.GenericFunctions;
import org.testng.Assert;

/**
 * Created by Qualitrix Technologies Pvt Ltd.
 * Purpose: To have all set of generic methods which are used across the project
 */

public class GenericFunctions extends BaseTest//implements IAutoConst//
{

	public Select select;
	public Action action;

	CreatorUserPage createUserPage=PageFactory.initElements(driver, CreatorUserPage.class);
	static CreatorUserPageObj createUserPageObj = new CreatorUserPageObj();
	static Logger log = Logger.getLogger(GenericFunctions.class.getName());
	CreatorAnnouncementPageObj creatorAnnouncementPageObj = new CreatorAnnouncementPageObj();
	CreatorAnnouncementPage creatorAnnouncementPage=PageFactory.initElements(driver, CreatorAnnouncementPage.class);

	/**
	 * Purpose: selectValueFromDropdown method selects the value from the dropdown list
	 */
	public static void selectValueFromDropdown(WebDriver driver,String locator, String text)
	{	

		WebElement lang = driver.findElement(By.xpath(locator));
		List<WebElement> list = lang.findElements(By.xpath(locator));
		for (WebElement opt : list)
		{
			String value = opt.getText();
			if(value.equalsIgnoreCase(text)){
				System.out.println("Value clicked ="+value);
				opt.click();
			}
		}		
	}

	/**
	 * Purpose: setClipboardData method is used to select and set data to clipboard
	 */
	public static void setClipboardData(String string) 
	{
		//StringSelection is a class that can be used for copy and paste operations.
		StringSelection stringSelection = new StringSelection(string);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}

	/**
	 * Purpose: uploadFile method is used to upload file from the system to the application
	 */
	public static void uploadFile(String fileLocation) 
	{
		try {
			//Setting clipboard with file location
			setClipboardData(fileLocation);
			//native key strokes for CTRL, V and ENTER keys
			Robot robot = new Robot();
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
		} catch (Exception exp) {
			System.out.println("Failed uploading document");
			exp.printStackTrace();
		}
	}

	/**
	 * Purpose: writeNotepad method is used to write the content into file
	 */
	public static void writeNotepad(String processID,String fileName)
	{
		try 
		{
			BufferedWriter bWriter=new BufferedWriter(new FileWriter(fileName));
			bWriter.write(processID);
			System.out.println("Write ID: "+processID);
			bWriter.newLine();
			bWriter.close();
		} 
		catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

	/**
	 * Purpose: readFromNotepad method is used to read the content into file
	 */
	@SuppressWarnings("resource")
	public static String readFromNotepad(String fileName){
		String path = "";
		try {
			BufferedReader bReader=new BufferedReader(new FileReader(fileName));
			while((path=bReader.readLine())!=null){
				System.out.println("Read ID: "+path);
				String str = bReader.readLine();
				// System.out.println(str);
				return path;
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return path;
	}


	/**
	 * Purpose: waitTillTheElementIsVisibleAndClickable method is used to synchronize element appearance
	 */
	public static void waitTillTheElementIsVisibleAndClickable(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOf(element));

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	/**
	 * Purpose: waitTillTheElementInVisible method is used to synchronize single element to disappear
	 */
	public static void waitTillTheElementInVisible(WebElement element) {

		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	/**
	 * Purpose: waitForPageToLoad method is used to synchronize with whole page to load with clickable action
	 */
	public static void waitForPageToLoad(WebElement id) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(id));
	}

	/**
	 * Purpose: waitForElementState method is used to synchronize with element staleness  
	 */
	public static void waitForElementState(WebElement id) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.stalenessOf(id));

		wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.elementToBeClickable(id));
	}

	/**
	 * Purpose: waitForPageToLoad method is used to synchronize with whole page to load with visibility action 
	 */
	public static void waitForPageToLoad(List<WebElement> id) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfAllElements(id));
	}

	/**
	 * Purpose: waitForPageToLoad method is used to synchronize with whole page to load with visibility action 
	 */
	public static void waitForElementToDisAppear(List<WebElement> id) {
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.invisibilityOfAllElements(id));
	}

	/**
	 * Purpose: waitForElementToDisAppear method is used to synchronize all elements to disappear
	 */
	public static void waitForElementToDisAppear(List<WebElement> id, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOfAllElements(id));
	}


	/**
	 * Purpose: waitForElementToAppear method is used to synchronize for an element to be visible 
	 */
	public static WebElement waitForElementToAppear(WebElement id) {
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.visibilityOf(id));
		return id;
	}

	/**
	 * Purpose: waitForElementToAppear method is used to synchronize for an element to be visible with parameterised time
	 */
	public WebElement waitForElementToAppear(WebElement id, int timeout) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.visibilityOf(id));
		return id;
	}

	/**
	 * Purpose: waitForElement method is used to synchronize for an element to be visible with parameterised time
	 */
	public WebElement waitForElement(WebElement arg) {
		waitForPageToLoad(arg);
		WebElement el = arg;
		return el;
	}

	/**
	 * Purpose: WaitForFrameAndSwitchToIt method is used to synchronize and shift between the frames 
	 */
	public static void WaitForFrameAndSwitchToIt(WebElement frame){
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frame));
	}

	/**
	 * Purpose: WaitForFrameAndSwitchToIt method is used to synchronize and shift between the frames using id
	 */
	public static void WaitForFrameAndSwitchToIt(int id){
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(id));
	}

	/**
	 * Purpose: scrollToElement method is used to scroll across the application with respect to element specified
	 */
	public static void scrollToElement(WebElement element){
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * Purpose: waitForElements method is used to synchronize with page to load with elements
	 */
	public static void waitForElements(List<WebElement> arg) {
		waitForPageToLoad(arg);
	}

	/**
	 * Purpose: waitForElementToAppearOnScreen method is used to synchronize with element to appear
	 */
	public static WebElement waitForElementToAppearOnScreen(WebElement arg) {
		waitForElementToAppear(arg);
		WebElement el = arg;
		return el;
	}

	/**
	 * Purpose: clickUntilElementExists method is used to click on multiple occurence of prompt window
	 */
	public static void clickUntilElementExists(WebElement clickLocator, By by) {
		boolean elementOnScreen;
		int i = 0;
		do {
			if (i == 25) {
				break;
			}
			try {
				driver.findElement(by);
				break;
			} catch (NoSuchElementException e) {
				clickLocator.click();
				elementOnScreen = false;
				System.out.println(i);
			}
			i++;
		} while (!elementOnScreen);
	}

	/**
	 * Purpose: isElementPresent method return whether the element is present on web page or not
	 */
	public boolean isElementPresent(WebElement locator) {
		try {
			if (locator.isDisplayed())
				System.out.println("Element present on screen ***********" + locator);
			return true;
		} catch (NoSuchElementException e) {
			System.out.println("Element not present on screen **************" + locator);
			return false;
		}
	}

	/**
	 * Purpose: refreshWebPage method refreshes the web page
	 */
	public static void refreshWebPage() {
		GenericFunctions.waitWebDriver(2000);
		driver.navigate().refresh();
		GenericFunctions.waitWebDriver(2500);
		//createUserPageObj.handlePopupOnLogin();

	}

	/**
	 * Purpose: waitWebDriver method used parameterised time input for synchronization
	 */
	public static void waitWebDriver(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			System.out.println("Method: waitWebDriver :: exception =  " + e.getMessage());

		}
	}

	/**
	 * Purpose: switchToNewWindow method is used to switch the control between multiple windows
	 */
	public static void switchToNewWindow() {
		for (String winHandle : driver.getWindowHandles()) {
			driver.switchTo().window(winHandle);
		}
	}

	/**
	 * Purpose: switchToNewWindow method is used to switch the control between multiple windows
	 */
	public static void switchToFrame(WebDriver mDriver,WebElement frame){
		try 
		{
			mDriver.switchTo().frame(frame);
		} catch (Exception e) {
			log.error("Method: switchToFrame :: Exception is = " + e.getMessage() );
		}
	}

	/**
	 * Purpose: keyTab method is used to switch to next field using TAB
	 */
	public static void keyTab(WebDriver mDriver,String locator)	{

		try	{
			log.info("MethodName: keyTab :: element found = " + locator);

			mDriver.findElement(By.cssSelector(locator)).sendKeys(Keys.TAB);
		} catch(Exception e) {
			log.error("MethodName: TabKeys :: Exception occured for locator = " + locator + "exception = "+ e.getMessage());
		}
	}

	/**
	 * Purpose: getValue method is used to read values from the webelement
	 */
	public static String getValue(WebDriver mDriver, String identifyBy, String locator) {
		boolean assertElementExists = false;
		String value = "";

		try	{
			assertElementExists = assertIfElementExists(mDriver, identifyBy, locator);
			log.info("Method: getValue :: assertElementExists = " + assertElementExists + " for xpath = " + locator);
			if (assertElementExists==true) {	
				if (identifyBy.equalsIgnoreCase("xpath")) 
					value = mDriver.findElement(By.xpath(locator)).getText();
				else if (identifyBy.equalsIgnoreCase("id")) 
					value = mDriver.findElement(By.id(locator)).getText();
				else if (identifyBy.equalsIgnoreCase("name")) 
					value = mDriver.findElement(By.name(locator)).getText();
				else if (identifyBy.equalsIgnoreCase("css")) 
					value = mDriver.findElement(By.cssSelector(locator)).getText();
			}
		} catch(Exception e) {
			log.error("Method: getValue :: Exception occured for locator = " + locator + "exception = "+ e.getMessage());
		}
		log.info("Method: getValue :: value of element = " + value);
		return value.trim();
	}


	/**
	 * Purpose: assertIfElementExists method is used to whether the element exists on web page
	 */
	public static boolean assertIfElementExists(WebDriver mDriver, String identifyBy, String locator) throws Exception {
		boolean bElementFound = false;
		try	{		
			if (identifyBy.equalsIgnoreCase("xpath")){ 
				bElementFound = mDriver.findElement(By.xpath(locator)).isDisplayed();
			}else if (identifyBy.equalsIgnoreCase("id")){ 
				bElementFound = mDriver.findElement(By.id(locator)).isDisplayed();
			}else if (identifyBy.equalsIgnoreCase("name")){ 
				bElementFound = mDriver.findElement(By.name(locator)).isDisplayed();
			}else if (identifyBy.equalsIgnoreCase("css")){ 
				bElementFound = mDriver.findElement(By.cssSelector(locator)).isDisplayed();
			}else if (identifyBy.equalsIgnoreCase("linktext")){ 
				bElementFound = mDriver.findElement(By.linkText(locator)).isDisplayed();
			}else if (identifyBy.equalsIgnoreCase("partialtext")){ 
				bElementFound = mDriver.findElement(By.partialLinkText(locator)).isDisplayed();
			}else {
				log.info("None of the Element Selected Please check the Element Once: ");
			}
		} catch(Exception e){
			log.error("Method: assertIfElementExists :: Exception occured for locator = " + locator + " exception is = "+ e.getMessage());
			AssertJUnit.assertTrue(false);

		}
		log.info("Method: assertIfElementExists for locator = " + locator  + " status = " + bElementFound);	
		return bElementFound;
	}


	/**
	 * Purpose: assertElementValue method is used to verify with actual and expected webelement value
	 */
	public static boolean assertElementValue(WebDriver mDriver, String identifyBy, String locator, String expectedValue) {
		String actualElementValue = "";
		actualElementValue =  getValue(mDriver, identifyBy, locator);
		expectedValue = expectedValue.trim();

		log.info("Method: assertElementValue :: actualElementValue = " + actualElementValue 
				+ " expectedValue = " + expectedValue);

		if (expectedValue.equals(actualElementValue) == true)
			return true;
		else
			return false;
	}

	/**
	 * Purpose: randomCourseName method is used to generate random string input for course name
	 */
	public static String randomCourseName()
	{

		char[] chars = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();
		StringBuilder sb = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < 8; i++) {
			char c = chars[random.nextInt(chars.length)];
			sb.append(c);
		}
		String output = sb.toString();
		return output;
	}

	/**
	 * Purpose: testDataIncrementer method is used to increment the values
	 */
	@Test
	public static String testDataIncrementer(String filePath) {

		String courseNum = GenericFunctions.readFromNotepad(filePath);
		Pattern compile = Pattern.compile("^(.*?)([9Z]*)$");
		Matcher matcher = compile.matcher(courseNum);
		String left="";
		String right="";
		if(matcher.matches()){
			left = matcher.group(1);
			right = matcher.group(2);
		}
		courseNum = !left.isEmpty() ? Long.toString(Long.parseLong(left, 36) + 1,36):"";
		courseNum += right.replace("Z", "A").replace("9", "0");
		GenericFunctions.writeNotepad(courseNum,filePath);
		return courseNum.toUpperCase();
	}

	/**
	 * Purpose: isFileDownloaded_Ext method is used to check if file is downloaded 
	 */
	public static boolean isFileDownloaded_Ext(String dirPath, String ext)
	{
		boolean flag=false;
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			flag = false;
		}

		for (int i = 1; i < files.length; i++) {
			if(files[i].getName().contains(ext)) {
				flag=true;
			}
		}
		return flag;
		//ExtentTestManager.getTest().log(LogStatus.INFO, "file exist in the location");
	}

	/**
	 * Purpose: captureScreenshotOnValidation method is used to capture screenshot of web page
	 */
	public static void captureScreenshotOnValidation(){
		try
		{
			GenericFunctions.waitWebDriver(1500);
			String base64Screenshot = "data:image/png;base64,"+((TakesScreenshot)driver).
					getScreenshotAs(OutputType.BASE64);
			ExtentTestManager.getTest().log(LogStatus.INFO,"CONTENT VALIDATED",
					ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
		}
		catch(Exception e)
		{
			System.out.println("Method: waitWebDriver :: exception =  " + e.getMessage());
		}
	}

	/**
	 * Purpose: assertIfAllElementsExists method is check if list of all elements exist on web page
	 */
	public static boolean assertIfAllElementsExists(WebDriver mDriver, List<WebElement> locator) throws Exception {
		boolean bElementFound = false;
		try	{		

			for (WebElement opt : locator)
			{
				boolean value = opt.isDisplayed();
				if(value==true){
					AssertJUnit.assertTrue(true);
					log.info(value+" found as related to Dial Code searched");
				}
			}	

		} catch(Exception e){
			log.error("Method: assertIfElementExists :: Exception occured for locator = " + locator + " exception is = "+ e.getMessage());
			Assert.assertTrue(false,"***Method: assertIfElementExists: Exception occured for locator= " + e.getMessage());
		}
		log.info("Method: assertIfElementExists for locator = " + locator  + " status = " + bElementFound);	
		return bElementFound;
	}

	/**
	 * Purpose: assertElementValue method is used to check for element value
	 */
	public static boolean assertElementValue(WebDriver mDriver, String identifyBy, WebElement locator, String expectedValue) {
		String actualElementValue = "";
		actualElementValue =  getValue(mDriver, identifyBy, locator);
		expectedValue = expectedValue.trim();

		log.info("Method: assertElementValue :: actualElementValue = " + actualElementValue 
				+ " expectedValue = " + expectedValue);

		if (expectedValue.equals(actualElementValue) == true)
			return true;
		else
			return false;
	}

	/**
	 * Purpose: assertElementValueByWebElement method is used to check for web element value
	 */
	public static boolean assertElementValueByWebElement(WebDriver mDriver, String identifyBy, WebElement locator, String expectedValue) {
		String actualElementValue = "";
		actualElementValue =  getValueFromWebElement(mDriver, identifyBy, locator);
		expectedValue = expectedValue.trim();

		log.info("Method: assertElementValue :: actualElementValue = " + actualElementValue 
				+ " expectedValue = " + expectedValue);

		if (expectedValue.equals(actualElementValue) == true)
			return true;
		else
			return false;
	}

	/**
	 * Purpose: getValue method is used to fetch value from webelement
	 */
	public static String getValue(WebDriver mDriver, String identifyBy, WebElement locator) {
		boolean assertElementExists = false;
		String value = "";

		try	{
			//assertElementExists = assertIfElementExists(mDriver, identifyBy, locator);
			log.info("Method: getValue :: assertElementExists = " + assertElementExists + " for xpath = " + locator);
			if (assertElementExists==true) {	
				if (identifyBy.equalsIgnoreCase("xpath")) 
					value = locator.getText();
				else if (identifyBy.equalsIgnoreCase("id")) 
					value = locator.getText();
				else if (identifyBy.equalsIgnoreCase("name")) 
					value = locator.getText();
				else if (identifyBy.equalsIgnoreCase("css")) 
					value = locator.getText();
			}
		} catch(Exception e) {
			log.error("Method: getValue :: Exception occured for locator = " + locator + "exception = "+ e.getMessage());
			// e.printStackTrace();
		}
		log.info("Method: getValue :: value of element = " + value);
		//System.out.println("Method: getValue :: value of element = " + value); 
		return value.trim();
	}


	/**
	 * Purpose: getValue method is used to fetch value from webelement
	 */
	public static String getValueFromWebElement(WebDriver mDriver, String identifyBy, WebElement locator) {
		boolean assertElementExists = false;
		String value = "";

		try	{

			log.info("Method: getValue :: assertElementExists = " + assertElementExists + " for xpath = " + locator);
			if (assertElementExists==true) {	
				if (identifyBy.equalsIgnoreCase("xpath")) 
					value = locator.getText();
				else if (identifyBy.equalsIgnoreCase("id")) 
					value = locator.getText();
				else if (identifyBy.equalsIgnoreCase("name")) 
					value = locator.getText();
				else if (identifyBy.equalsIgnoreCase("css")) 
					value = locator.getText();
			}
		} catch(Exception e) {
			log.error("Method: getValue :: Exception occured for locator = " + locator + "exception = "+ e.getMessage());
			// e.printStackTrace();
		}
		log.info("Method: getValue :: value of element = " + value);

		return value.trim();
	}

	/**
	 * Purpose: navigateToWorkspaceFeatures method is used to Navigate to Workspace and Access the parameterized variable
	 */
	public void navigateToWorkspaceFeatures(String workspaceVariable)
	{
		try
		{			
			refreshWebPage();
			/*
			GenericFunctions.waitForElementToAppear(createUserPage.profileIconDropdown);
			createUserPage.profileIconDropdown.click();
			GenericFunctions.waitForElementToAppear(createUserPage.profileIconProfile);
			createUserPage.profileIconProfile.click();
			 */
			GenericFunctions.waitWebDriver(1000);
			GenericFunctions.waitForElementToAppear(createUserPage.workSpace);
			createUserPage.workSpace.click();
			GenericFunctions.waitWebDriver(1000);
			if(workspaceVariable.equalsIgnoreCase("All My Content"))
			{
				createUserPage.allMyContent.click();
			}
			else if (workspaceVariable.equalsIgnoreCase("Drafts"))
			{
				createUserPage.drafts.click();
			}
			else if(workspaceVariable.equalsIgnoreCase("Review Submissions"))
			{
				createUserPage.reviewSubmission.click();
			}
			else if(workspaceVariable.equalsIgnoreCase("Published"))
			{
				createUserPage.published.click();
			}
			else if(workspaceVariable.equalsIgnoreCase("All Uploads"))
			{
				createUserPage.allUploads.click();
			}
			else if(workspaceVariable.equalsIgnoreCase("Up For Review"))
			{
				createUserPage.upForReview.click();
			}
			else if(workspaceVariable.equalsIgnoreCase("Limited Publishing"))
			{
				createUserPage.limitedPublishing.click();
			}
			else if(workspaceVariable.equalsIgnoreCase("Collaborations"))
			{
				createUserPage.collaborations.click();
			}

		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Could not access the features of Workspace");
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Exception Message: "+e.getLocalizedMessage());
			Assert.fail("Could not access the features of Workspace");

		}
	}

	//Nov 27
	/**
	 * Purpose: assertIfElementExists1 method is used to check if the element exist on the page or not.
	 */
	public static boolean assertIfElementExists1(WebDriver mDriver, String identifyBy, WebElement locator) throws Exception {
		boolean bElementFound = false;
		try	{		
			if (identifyBy.equalsIgnoreCase("xpath")){ 
				bElementFound = locator.isDisplayed();
			}else if (identifyBy.equalsIgnoreCase("id")){ 
				bElementFound = locator.isDisplayed();
			}else if (identifyBy.equalsIgnoreCase("name")){ 
				bElementFound = locator.isDisplayed();
			}else if (identifyBy.equalsIgnoreCase("css")){ 
				bElementFound = locator.isDisplayed();
			}else if (identifyBy.equalsIgnoreCase("linktext")){ 
				bElementFound = locator.isDisplayed();
			}else if (identifyBy.equalsIgnoreCase("partialtext")){ 
				bElementFound = locator.isDisplayed();
			}else {
				log.info("None of the Element Selected Please check the Element Once: ");
			}
		} catch(Exception e){
			log.error("Method: assertIfElementExists :: Exception occured for locator = " + locator + " exception is = "+ e.getMessage());
			Assert.assertTrue(false,"***Method: assertIfElementExists: Exception occured for locator= " + e.getMessage());
		}
		log.info("Method: assertIfElementExists for locator = " + locator  + " status = " + bElementFound);	
		return bElementFound;
	}
	/**
	 * Purpose: FetchFieldsAndAssert method is used to validate the expected field is available or not. 
	 */
	public static void FetchFieldsAndAssert(WebElement ele,String ExpValue)
	{
		try
		{
			GenericFunctions.waitWebDriver(2000);
			String Actual=ele.getText();
			AssertJUnit.assertEquals(Actual,ExpValue);
		
			ExtentTestManager.getTest().log(LogStatus.PASS,ExpValue+ "Field Verified Succesfully");
		}
		catch(Exception e)
		{
			ExtentTestManager.getTest().log(LogStatus.FAIL, "Failed on Fetching & Asserting Fields");
			ExtentTestManager.getTest().log(LogStatus.FAIL,"Exception Message: "+e.getLocalizedMessage());

			Assert.fail("Failed on Fetching & Asserting Fields");

		}
	}
	/**
	 * Purpose: clickOnElementUsingJavascript method is used to click on the element using javascript.
	 */
	public static void clickOnElementUsingJavascript(WebElement element) throws Exception 
	{
		try 
		{
			if (element.isEnabled() && element.isDisplayed()) {
				System.out.println("Clicking on element with using java script click");
				//GenericFunctions.waitForElementToAppear(element);
				GenericFunctions.waitWebDriver(2000);
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
			} else {
				System.out.println("Unable to click on element");
			}
		} 
		catch (StaleElementReferenceException e) 
		{
			System.out.println("Element is not attached to the page document "+ e.getStackTrace());
		} catch (NoSuchElementException e) 
		{
			System.out.println("Element was not found in DOM "+ e.getStackTrace());
		} catch (Exception e) 
		{
			System.out.println("Unable to click on element "+ e.getStackTrace());
		}
	}

	/**
	 * Purpose: scrollTillEndOfPage method is used to navigate til the end of the page.
	 */
	
	public static void scrollTillEndOfPage()
	{
	     
   	 // ((JavascriptExecutor) driver).executeScript("window.scrollTo(0,document.body.scrollHeight )");  
   	  ((JavascriptExecutor) driver).executeScript("scroll(0, 200);");
	 
   }
	/**
	 * Purpose: compareTwoImages method is used to compare the screenshot taken on runtime with a stored expected one.  
	 */
	public static void compareTwoImages(){
		  try
		  {
		   GenericFunctions.waitWebDriver(1500);
		   BufferedImage expectedImage=ImageIO.read(new File("./screenshot/ + img1.png"));
		   Screenshot myScreenshot = new AShot().takeScreenshot(driver);	   
		   BufferedImage actualImage=myScreenshot.getImage();
		   ImageDiffer imgDiff = new ImageDiffer();
		   ImageDiff diff = imgDiff.makeDiff(expectedImage, actualImage);
		   //int status = diff.hashCode();
		   //System.out.println(status);
		   
		   Assert.assertTrue(diff.hasDiff());
		   //BufferedImage DiffImage = diff.getDiffImage();
		   
		   //String base64Screenshot = imgToBase64String(DiffImage,"png");//"data:image/png;base64,"+((TakesScreenshot)driver).getScreenshotAs(OutputType.BASE64);
		   //ExtentTestManager.getTest().log(LogStatus.INFO,"CONTENT VALIDATED",ExtentTestManager.getTest().addBase64ScreenShot(base64Screenshot));
		  
		   
		   System.out.println("Images are Same");
		    
		  }
		  catch(Exception e)
		  {
		   System.out.println("Method: waitWebDriver :: exception =  " + e.getMessage());
		  }
	
		 }

}
