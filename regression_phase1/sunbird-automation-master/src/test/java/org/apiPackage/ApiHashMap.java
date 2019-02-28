package org.apiPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.generic.GenericFunctions;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.startup.BaseTest;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ApiHashMap extends BaseTest{
	
	static String TopicSelectorImg ="//a[@class='tree item active']//following::input[1]//following::a[1]//preceding::i[3]";
	static String TopicSelectorContent ="//a[@class='tree item active']//following::input[1]//following::a[1]//following::a[1]";
	static String TopicSelectorDone ="(//a[.='Done'])[2]";

	static HashMap<String,String>  XpathInfo=new HashMap<String,String>();
	
	static HashMap<String,String> XpathInfo3=new HashMap<String,String>();
	
	static HashMap<String,String> InputType=new HashMap<String,String>();
	static HashMap<String,String> InputType2=new HashMap<String,String>();
	
	ArrayList<String> Datatype=new ArrayList<String>();
	ArrayList<String> Datatype2=new ArrayList<String>();
	
	//ApiHashMap mp=new ApiHashMap();

	ArrayList<String> PathInfo=new ArrayList<String>();
	ArrayList<String> PathInfo2=new ArrayList<String>();
	
	ArrayList<String> DropdownVal=new ArrayList<String>();
	ArrayList<String> DropdownValue=new ArrayList<String>();
	
	
	
	//static WebDriver driver;
	
	
	
	public void dynamicFormHandling(String api_key,String rootorg_id,String framework_name,String action,String subtype ) 
	{
		
		{
			try {
				
				String apikey =api_key;

				RequestSpecification request = RestAssured.given();
				request.header("Content-Type", "application/json").header("Authorization",
						"Bearer " + apikey);

				
			    
				JSONObject json = new JSONObject();
						
				json.put("type", "content");
				json.put("framework", framework_name);
				json.put("action", action);
				json.put("subType", subtype);
				json.put("rootOrgId", rootorg_id);
				
				
				
				JSONObject json2 = new JSONObject();
				json2.put("request", json);

				request.body(json2.toJSONString());


				Response resp = request
						.post(APP_URL+"/api/data/v1/form/read");
				
			
				
				System.out.println(resp.body().asString());
				String fileAsString = resp.body().toString();
				Object value = resp.getBody().asString();
				System.out.println(value);
				JSONParser parser = new JSONParser();
				fileAsString = value.toString();
				JSONObject JsonObject = (JSONObject) parser.parse(fileAsString);

				for (Object key : JsonObject.keySet()) { 
					System.out.println(key + "=" + JsonObject.get(key));
				}

				org.json.JSONObject json3 = new org.json.JSONObject(fileAsString);
				Object result = json3.get("result");
				System.out.println(result.toString());
				
				org.json.JSONObject json4 = new org.json.JSONObject(result.toString());
				Object result4 = json4.get("form");
				
				System.out.println(result4.toString());
				org.json.JSONObject json5 = new org.json.JSONObject(result4.toString());
				Object result5 = json5.get("data");
				System.out.println(result5.toString());
			
					
				org.json.JSONObject json44 = new org.json.JSONObject(result5.toString());
				org.json.JSONArray result44 = json44.getJSONArray("fields");
				System.out.println(result44.toString());
				
				
				System.out.println(result44.length());

				List<JsonAttributes> originalvalue = new ArrayList<>();
				FetchApiResponse converter = new FetchApiResponse();
				for (int i = 0; i < result44.length(); i++) {
					try {
						org.json.JSONObject jsonvalue = result44.getJSONObject(i);
						ObjectMapper mapper = new ObjectMapper();
						System.out.println(jsonvalue.toString());
						JsonAttributes myPojo = new JsonAttributes();
						
						
						try
						{
							
							
							//Nov 22 
							String lower=jsonvalue.getString("lable");
							String convertUpper=lower.toUpperCase();
							
					//myPojo.setlable(jsonvalue.getString("lable"));
					
							myPojo.setlable(convertUpper);
					
					
					
						}
						catch(Exception ee)
						{
							//Nov 22
							String lower=jsonvalue.getString("label");
							String convertUpper=lower.toUpperCase();
							
							
							//myPojo.setlable(jsonvalue.getString("label"));
							myPojo.setlable(convertUpper);
							
						}
				
					
						myPojo.setVisible(jsonvalue.getBoolean("visible"));
						myPojo.setInputType(jsonvalue.getString("inputType"));
						myPojo.setRequired(jsonvalue.getBoolean("required"));
						
						//Nov 27
				//myPojo.setRequired(jsonvalue.getBoolean("required"));
						originalvalue.add(myPojo);
					} catch (Exception e) {
						System.out.println("Exception is" +e);
					}
				}
				
				
				
				   
				   
				List<JsonAttributes> filteredvalue = new ArrayList<>();

							
				//int J=0;
				for (JsonAttributes jsonAttributes : originalvalue) 
				
						{
					// if (jsonAttributes.getVisible()) 
					if (jsonAttributes.getRequired()) 
					 {
						filteredvalue.add(jsonAttributes);
						
						System.out.println("Label  " +jsonAttributes.getlable());
						String Type=jsonAttributes.getInputType();
						
						
						//Nov 26
				//System.out.println("Mandatory  " +jsonAttributes.getRequired());
						
						InputType.put(jsonAttributes.getInputType(),Type);

						
						System.out.println("InputType  " +jsonAttributes.getInputType());
						
						Datatype.add(jsonAttributes.getInputType());
						System.out.println("DataType  " +jsonAttributes.getInputType());
						
						
						
			
						
						//Code Changes
						String xpath="//label[contains(text(),'";
						String xpath2="')]/..//input";
						String FetchLabel=jsonAttributes.getlable();
						//String xpath3="')]/following-sibling::div";
						String xpath3="')]/following-sibling::*";
						String DropDownValue="')]/following::sui-select-option[1]";
						
						String DropValueFi="')]/following-sibling::*/..//*[contains(@class,'item')]";
						//String DropValueFirst="//label[contains(text(),'CLASS')]/following-sibling::*/..//div[contains(@class,'item')]";
						
						String DropValueFirst1=xpath+FetchLabel+DropValueFi;
						
						String MultiSltXpath="')]/following::i[1]";
						String ClkMultiSlt=xpath+FetchLabel+MultiSltXpath;



						//Nov 22 2018
						String ImgUpld="')]/following::div[2]";
						String DropDownSlt="')]/following::div[4]";


						//Nov 23 2018
						String topicSlt="//label[contains(.,'";
						String topicSlt2="Topics')]/..//topic-selector/..//input";
						String DropdownTopicValue="//a[@class='tree item active']//following::input[1]//following::a[1]";

						if(jsonAttributes.getInputType().equalsIgnoreCase("text"))
						{
							String Finalxpath=xpath+FetchLabel+xpath2;
							System.out.println("Xpath is  " +Finalxpath);
							XpathInfo.put(jsonAttributes.getlable(),Finalxpath);
							PathInfo.add(Finalxpath);
							DropdownVal.add(DropValueFirst1);
							
						}
						if(jsonAttributes.getInputType().equalsIgnoreCase("select"))
						{
							String Finalxpath=xpath+FetchLabel+xpath3;
							System.out.println("Xpath is  " +Finalxpath);
							//Nov 22
							String DropdownValues=xpath+FetchLabel+DropDownSlt;
							System.out.println("DropdownValues is  " +DropdownValues);
							
							XpathInfo.put(jsonAttributes.getlable(),Finalxpath);
							PathInfo.add(Finalxpath);
							DropdownVal.add(DropValueFirst1);
							
						}
						
						if(jsonAttributes.getInputType().equalsIgnoreCase("multiSelect"))
						{
							String Finalxpath=xpath+FetchLabel+xpath3;
							System.out.println("Xpath is  " +Finalxpath);


							//Nov 22
							String DropdownValues=xpath+FetchLabel+DropDownSlt;
							System.out.println("DropdownValues is  " +DropdownValues);
							
							XpathInfo.put(jsonAttributes.getlable(),Finalxpath);
							PathInfo.add(Finalxpath);
							DropdownVal.add(DropValueFirst1);
							
						}
						
						
						
						
						
						
						
						//Nov 22 2018
						
						if(jsonAttributes.getInputType().equalsIgnoreCase("file"))
						{
							String Finalxpath=xpath+FetchLabel+ImgUpld;
						
							System.out.println("Xpath is  " +Finalxpath);
							
							String DropdownValues=xpath+FetchLabel+DropDownValue;
							System.out.println("DropdownValues is  " +DropdownValues);
							
							XpathInfo.put(jsonAttributes.getlable(),Finalxpath);
							PathInfo.add(Finalxpath);
							DropdownVal.add(DropValueFirst1);
							
						}
						if(jsonAttributes.getInputType().equalsIgnoreCase("textarea"))
						{
							String Finalxpath=xpath+FetchLabel+xpath3;
						
							System.out.println("Xpath is  " +Finalxpath);
							
							String DropdownValues=xpath+FetchLabel+DropDownValue;
							System.out.println("DropdownValues is  " +DropdownValues);
							
							XpathInfo.put(jsonAttributes.getlable(),Finalxpath);
							PathInfo.add(Finalxpath);
							DropdownVal.add(DropValueFirst1);
							
							
						}
						
						if(jsonAttributes.getInputType().equalsIgnoreCase("keywordsuggestion"))
						{
							String Finalxpath=xpath+FetchLabel+xpath2;
							System.out.println("Xpath is  " +Finalxpath);
							XpathInfo.put(jsonAttributes.getlable(),Finalxpath);
							PathInfo.add(Finalxpath);
							DropdownVal.add(DropValueFirst1);
						
						}
						
						

						if(jsonAttributes.getInputType().equalsIgnoreCase("topicselector"))
						{
							String Finalxpath=topicSlt+topicSlt2;
						
							System.out.println("Xpath is  " +Finalxpath);
							
							
							//Nov 22
							String DropdownValues=DropdownTopicValue;
							
							System.out.println("DropdownValues is  " +DropdownValues);
							
						
							XpathInfo.put(jsonAttributes.getlable(),Finalxpath);
							PathInfo.add(Finalxpath);
							DropdownVal.add(DropValueFirst1);
			 
						}
						
					 }
								}



				//mp.re();
				//mp.re2();
				AddIntoArraylist();
				AddXpathIntoArraylist();
				AddDropdownIntoArraylist();
			}			

			catch (Exception e) {
				System.out.println(e);
			}
		}
		printhash();
		printhash2();
		listAllArrayList();
		listXpathAllArrayList();
		listDropDownInrrayList();
		FeedDataToUI();
		//finalvalu();
	}

	public ArrayList<String> AddIntoArraylist()
	{
		Datatype2.addAll(Datatype);
		return Datatype2;
	}
	public ArrayList<String> AddDropdownIntoArraylist()
	{
		DropdownValue.addAll(DropdownVal);
		return DropdownValue;
	}                       
	public ArrayList<String> AddXpathIntoArraylist()
	{
		PathInfo2.addAll(PathInfo);
		return PathInfo2;
	}
	public HashMap<String, String> re()
	{
		XpathInfo3.putAll(XpathInfo);
		System.out.println("Values in Xpaths: "+XpathInfo3);	
		return XpathInfo3;
	}

	public  HashMap<String, String> re2()
	{
		InputType2.putAll(InputType);
		System.out.println("Values of Type: "+InputType2);	
		return InputType2;
	}

	public void finalvalu()
	{
		String[] d=AutoId();

		for(int i=0;i<d.length;i++)
		{
			System.out.println("LastValue" +d[i]);
		}
	}

	public String[] AutoId()
	{
		List<String> list = new ArrayList<String>(InputType.values());
		String[] stockArr = new String[list.size()];
		stockArr = list.toArray(stockArr);
		return stockArr;

	}
	public  void listAllArrayList()
	{

		String[] stockArr = new String[Datatype2.size()];
		stockArr = Datatype2.toArray(stockArr);
		for(int i=0;i<Datatype2.size();i++)
		{
			System.out.println("DataType    " +stockArr[i]);
		}
	}
	public  void listXpathAllArrayList()
	{

		String[] stockArr = new String[PathInfo2.size()];
		stockArr = PathInfo2.toArray(stockArr);
		for(int i=0;i<PathInfo2.size();i++)
		{
			System.out.println("Xpath" +stockArr[i]);
		}
	}

	public  void listDropDownInrrayList()
	{

		String[] stockArr = new String[DropdownValue.size()];
		stockArr = DropdownValue.toArray(stockArr);
		for(int i=0;i<DropdownValue.size();i++)
		{
			System.out.println("Dropdown Xpath" +stockArr[i]);
		}
	}
	public static String[] printhash()
	{
		System.out.println("Value Stored in Hashmap" +XpathInfo3);
		List<String> list = new ArrayList<String>(XpathInfo.values());
		String[] stockArr = new String[list.size()];
		stockArr = list.toArray(stockArr);
		for(int i=0;i<list.size();i++)
		{
			System.out.println(stockArr[i]);
		}

		return stockArr;
	}



	public static String[] printhash2()
	{
		System.out.println("Value Stored in Hashmap" +InputType2);
		List<String> list = new ArrayList<String>(InputType.values());
		String[] stockArr = new String[list.size()];
		stockArr = list.toArray(stockArr);

		for(int i=0;i<list.size();i++)
		{
			System.out.println(stockArr[i]);
		
		}

		return stockArr;


	}


	public void FeedDataToUI()
	{


		try
		{	
			System.out.println("=======================================");
			String[] ConvertedArrayPath = new String[PathInfo2.size()];
			ConvertedArrayPath = PathInfo2.toArray(ConvertedArrayPath);

			String[] ConvertedArrayDatatype2= new String[Datatype2.size()];
			ConvertedArrayDatatype2 = Datatype2.toArray(ConvertedArrayDatatype2);
						
			String[] ConvertedArrayDropdown= new String[DropdownValue.size()];
			ConvertedArrayDropdown = DropdownValue.toArray(ConvertedArrayDropdown);


			for(int i=0;i<ConvertedArrayPath.length;i++)
			{
				
				String DataTypeValue=ConvertedArrayDatatype2[i];
			

				if(DataTypeValue.equalsIgnoreCase("text"))
				{
					String PathValue=ConvertedArrayPath[i];
					System.out.println("Xpath Value=== " +DataTypeValue  +  PathValue);
					//driver.findElement(By.xpath(PathValue)).sendKeys("Description");
				}
				else if(DataTypeValue.equalsIgnoreCase("textarea"))
				{
					String PathValue=ConvertedArrayPath[i];
					System.out.println("Xpath Value=== " +DataTypeValue  +  PathValue);
					/*driver.findElement(By.xpath(PathValue)).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath(PathValue)).clear();
					Thread.sleep(1000);*/
					//driver.findElement(By.xpath(PathValue)).sendKeys("Description");
					//driver.findElement(By.xpath(PathValue)).sendKeys("TestingDesc");
				}
				else if(DataTypeValue.equalsIgnoreCase("select"))
				{
					String PathValue=ConvertedArrayPath[i];
					String DropDownValue=ConvertedArrayDropdown[i];
					System.out.println("Xpath Value=== " +DataTypeValue  +  PathValue);
					System.out.println("Xpath Value=== " + DropDownValue);
					GenericFunctions.scrollToElement(driver.findElement(By.xpath(PathValue)));
					driver.findElement(By.xpath(PathValue)).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath(DropDownValue)).click();

				}
				else if(DataTypeValue.equalsIgnoreCase("multiselect"))
				{
					String PathValue=ConvertedArrayPath[i];
					String DropDownValue=ConvertedArrayDropdown[i];
					System.out.println("Xpath Value=== " +DataTypeValue  +  PathValue);
					System.out.println("Xpath Value=== " + DropDownValue);
					GenericFunctions.scrollToElement(driver.findElement(By.xpath(PathValue)));
					driver.findElement(By.xpath(PathValue)).click();
					Thread.sleep(1000);
					driver.findElement(By.xpath(DropDownValue)).click();

				}
				else if(DataTypeValue.equalsIgnoreCase("file"))
				{
					String PathValue=ConvertedArrayPath[i];
					System.out.println("Xpath Value=== " +DataTypeValue  +  PathValue);
				}
				else if(DataTypeValue.equalsIgnoreCase("keywordsuggestion"))
				{
					String PathValue=ConvertedArrayPath[i];
					System.out.println("Xpath Value=== " +DataTypeValue  +  PathValue);
				}
				else if(DataTypeValue.equalsIgnoreCase("topicselector"))
				{
					String PathValue=ConvertedArrayPath[i];
					 driver.findElement(By.xpath(PathValue)).click();
				        Thread.sleep(2000);
				        driver.findElement(By.xpath(TopicSelectorImg)).click();
				        Thread.sleep(2000);
				        driver.findElement(By.xpath(TopicSelectorContent)).click();
				        Thread.sleep(2000);
				        driver.findElement(By.xpath(TopicSelectorDone)).click();
				        Thread.sleep(2000);
					System.out.println("Xpath Value=== " +DataTypeValue     +PathValue);
				}
				System.out.println("======================================="); 

			}


		}

		catch(Exception e)
		{
			System.out.println("Exception Handled");
		}
	}
}

