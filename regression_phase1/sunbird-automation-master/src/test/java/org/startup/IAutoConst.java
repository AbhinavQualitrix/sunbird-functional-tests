package org.startup;

import org.openqa.selenium.WebDriver;

public interface IAutoConst 
{

	//public static WebDriver driver;
	
	
	//User Roles
	String PUBLICUSER="PUBLICUSER";
	String ADMIN="ADMIN";
	String CREATOR="CREATOR";
	String REVIEWER="REVIEWER";
	String FLAGREVIEWER="FLAGREVIEWER";
	String MENTOR="MENTOR";
	String XPATH="XPATH";
	String PUBLICUSER1="PUBLICUSER1";
	String PUBLICUSER2="PUBLICUSER2";
	String BOOKREVIEWER="BOOKREVIEWER";
	String AUTOCREATOR="AUTOCREATOR";
	String BOOKCREATOR="BOOKCREATOR";
	String MENTOR_S="MENTOR_S";
	String REVIEWER_S="REVIEWER_S";
	String PUBLICUSER_S="PUBLICUSER_S";
	String MENTORS_S="MENTORS_S";
	String PUBLICUSERS_S="PUBLICUSERS_S";
	String A_CONTENT_CREATOR="A_CONTENT_CREATOR";
	
	//Adding New user Roles For New Features
	String TC_TESTUSER="TCTestUser";
	String FRAMEWORK_TESTUSER="FrameworkUser";
	String NEWUSER_SECONDTIME="NewUserSecondTime";
	
	//Nov 23
	String CREATOR2="CREATOR2";

	//Driver values
	String CHROME_KEY="webdriver.chrome.driver";
	//String CHROME_VAL="./drivers/chromedriver.exe";
	//LINUX path
	String CHROME_VAL="drivers/chromedriver";
	String GECKO_KEY="webdriver.gecko.driver";
	String GECKO_VAL="./drivers/geckodriver";
	//String APP_URL="https://preprod.ntp.net.in";
	String APP_URL="https://staging.ntp.net.in";
	//String APP_URL="https://diksha.gov.in";
	String AUTO_APP_URL="http://qatestautomation.centralus.cloudapp.azure.com";


	//Upload documents name
	String UPLOAD_ROOT_ORG="Test_Data_Sample_Organizations-1.csv";
	String UPLOAD_USERS_ROOT_ORG="Test_Data_Sample_Root_Org_Users.csv";
	String UPLOAD_SUB_ORG="Test_Data_Sample_Sub_Organizations-1.csv";
	String UPLOAD_USERS_SUB_ORG="Test_Data_Sample_Sub_Org_Users.csv";
	String FILTER_CREATION="Creation";
	String FILTER_CONSUMPTION="Consumption";
	String A_HOME_URL="https://staging.ntp.net.in/home";
	String SEARCH_COURSE="courseA";
	String SEARCH_LIBRARY="Library";
	String SEARCH_COURSES="Courses";
	String SEARCH_LIBRARIES="content";	
	String[] searchInput = new String[]{"BookA","Automation content","Automation Collection","lesson plan","Automation Resource"};
	String UPLOAD_PROFILE_PIC="images1";
	String[] SEARCH_USERS=new String[]{"mentor","admin","public user","creator","reviewer"};
	String[] SEARCH_ORG=new String[]{"Org","Root Org"};
	String SUMMARY_EDIT ="Profile Summary is edited";
	String EXP_OCCUPATION="Test Occupation";
	String EXP_DESIGNATION="Test Designation";
	String EXP_ORG="Test Organization";

	String[] ADDRESS=new String[]{"Test #15","Test Vasanthnagar","Test Bangalore","Test Karnataka","Test India","Test 560035"};
	String ENDORSE_USER="TestFlagReviewer  N";
	String BOOK="Book";
	String COURSE="Course";
	String RESOURCE="Resource";
	String COLLECTION="Collection";
	String LESSONPLAN="Lesson Plan";
	String UPLOADCONTENT="Upload Content";
	String PUBLISHER="Test Automation Publisher";
	//String[] DIAL_CODE={"A9KDTL","D8QKZK","4B9YGN","7AF6MM","XCYJ4Q","REN4RS","UDTBXR","Z2T38D","31YAEC","T4HMVF"};
	String[] DIAL_CODE={"4B9YGN","A9KDTL","XCYJ4Q"};
	String LESSON_NAME="Automation Lesson Plan";	

	//Added for content upload
	String MP4_CONTENT_NAME="Automation Content Mp4";
	String SEARCH_CONTENT_IMAGE="content image";
	String SEARCH_RESOURCE_IMAGE="resource image";
	String SEARCH_COURSE_IMAGE="course image";
	String SEARCH_BOOK_IMAGE="book image";
	String LESSON_PLAN_IMAGE="lesson plan";
	String BOOK_IMAGE="book image.jpg";
	//String LESSON_PLAN_IMAGE="lesson plan.jpg";

	String MP4="MP4";
	String UPLOAD_MP4="Upload content-mp4.mp4";
	String WEBM="WEBM";
	String UPLOAD_WEBM="Upload content-webm.webm";
	String YOUTUBE="YOUTUBE";
	String UPLOAD_YOUTUBE="https://www.youtube.com/watch?v=qCs0pm_D_hM";
	String EPUB="EPUB";
	String UPLOAD_EPUB="faulkner-sound-and-the-fury.epub";
	String HTML="HTML";
	String UPLOAD_HTML="HTMLContent_test.zip";
	String H5P="H5P";
	String UPLOAD_H5P="fill-in-the-blanks-837.h5p";
	String PDF="PDF";
	String UPLOAD_PDF="samplepdf.pdf";
	String SEARCH_COLLECTION_IMAGE="Collection Image";
	String UPLOAD_MP4_URL="https://drive.google.com/file/d/16O6wbBoAum6NXdqTSXVZxh1SUAQNV1ok/view?usp=sharing";

	//Added for Send For Review Popup
	String [] REVIEW_COMMENTS={"Inappropriate course","Empty Course","Duplicate Course","Not Suitable for Children"};

	//Added for announcement
	String IMAGE="images1.jpg";
	String DESCRIPTION="DESCRIPTION";
	String ENTERURL="ENTERURL";
	String UPLOADDOCUMENT="UPLOADDOCUMENT";

	//Adding for FlagReviewer
	String ACCEPT="accept";
	String DISCARD="discard";
	String PUBLISH="publish";
	String REQUESTCHANGES="request changes";

	//Adding for Public user 
	//String TEST_MAIL_ID="testmemeight@gmail.com";
	String TEST_MAIL_ID="testforgot@YOPmail.com";
	String [] CONTENT_TYPE={"//sui-select-option/..//span[.='TextBook']","//sui-select-option/..//span[.='Collection']","//sui-select-option/..//span[.='LessonPlan']","//sui-select-option/..//span[.='Resource']"};
	String PUBLISHED="Published";

	//Added on Maintenance - OCT 23
	String ALL_MY_CONTENT="All My Content";
	String DRAFTS="Drafts";
	String REVIEW_SUBMISSION="Review Submissions";
	String ALL_UPLOADS="All Uploads";
	String LIMITED_PUBLISHING="Limited Publishing";
	String UP_FOR_REVIEW="Up for review";
	String COLLABORATIONS="Collaborations";

	//Added for Audio Upload Regression Test case 78 
	String AUDIO_UPLOAD="school chale hum.mp3";

	//Added for Audio Upload Regression Test case 79
	String VIDEO_UPLOAD="https://drive.google.com/uc?export=download&id=1RYgA8UbwKukgLSLhDVzvTGS0-wGj98cL";

	//Merged from Ajith - 25/09/2018
	String HINDI_LABEL="डायल कोड दर्ज करें ";

	//Nov 25
	String ROOT_ORG="Upload_root_org";
	String SUB_ORG="Upload_sub_org";

	//Merged from Ajith
	String ID="ID";

	//Dec 15
	String [] CONTENT_ARRAY={"CourseA","BookA","LessonA","Automation Content","Automation Collection","Automation Resource"};

	String [] UPLOAD_CONTENTS = {"youtube","mp4","pdf"};

	String[] CONTENT_TO_FIND = {"Collection","TextBook","LessonPlan","Course","Resource"};

	//Feb 18
		String SUNBIRD_APIKEY="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiI2NTU0NDQ5ZWI0MGQ0YTI4ODQ3YzAzYWZlNmJjMmEyOCJ9.YhnTaDw_xv"
				+ "f8Q5S66QiO71-5WeqLaTPv-vvNZSwBqLk";
		String DIKSHA_APIKEY="eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJjNDkyM2Y1Mjg1ZmY0NDdjYmYxMzgwNTQyM2ExZTk4YSJ9.hwQiG6OIFoIJ2O9ec6kau09ltJ-5xA5fWi6aM6NoLEU";
		String SUNBIRD_ROOTORGID="012550072256020480149";
		String DIKSHA_ROOTORGID="012550822176260096119";
		String SUNBIRD_FRAMEWORK="rj_k-12_1";
		String DIKSHA_FRAMEWORK="NCF";
}
