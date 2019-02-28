package org.apiPackage;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.generic.ExtentTestManager;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.relevantcodes.extentreports.LogStatus;

public class FetchApiResponse {
	static HashMap<String,String>  XpathInfo=new HashMap<String,String>();
	
	static HashMap<String,String> XpathInfo3=new HashMap<String,String>();
	
	static HashMap<String,String> InputType=new HashMap<String,String>();
	static FetchApiResponse mp=new FetchApiResponse();


	
	
	
	
	public static void main(String[] args) 
	{
		
		{
			try {
				String apikey = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiI2NTU0NDQ5ZWI0MGQ0YTI4ODQ3YzAzYWZlNmJjMmEyOCJ9.YhnTaDw_xv"
						+ "f8Q5S66QiO71-5WeqLaTPv-vvNZSwBqLk";

				RequestSpecification request = RestAssured.given();
				request.header("Content-Type", "application/json").header("Authorization",
						"Bearer " + apikey);

				
			    
				JSONObject json = new JSONObject();
				
				
/*//For Rajastan
				//Oct 29 2018
				json.put("type", "content");

				json.put("action", "save");
				json.put("subType", "course");
				json.put("rootOrgId", "01258411770173030498");
*/
			
				
	/*//For JDFL
				
				json.put("type", "content");

				json.put("action", "create");
				json.put("subType", "textbook");
				json.put("rootOrgId", "01257763721283174416");
				json.put("framework", "jdf1");

				*/
				json.put("type", "type");
						
				json.put("type", "content");

				json.put("action", "review");
				json.put("subType", "resource");
				json.put("rootOrgId", "012315809814749184151");
				
				
				
				JSONObject json2 = new JSONObject();
				json2.put("request", json);

				request.body(json2.toJSONString());

				//Creation of Book
				Response resp = request
						.post("https://staging.open-sunbird.org/api/data/v1/form/read");

				
				
				
				/*//Review Resource
				Response resp = request
						.post("https://staging.open-sunbird.org/api/data/v1/form/read");
				*/
				
				
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
						
						//Nov 27
				//myPojo.setRequired(jsonvalue.getBoolean("required"));
						originalvalue.add(myPojo);
					} catch (Exception e) {
System.out.println("Exception is" +e);
					}
				}
				
				
				 String path = System.getProperty("user.dir")+"/TestData/TestDataSheet.xls";
					//   FileOutputStream fos = new FileOutputStream("Q:\\TestWorkSpace\\ReSearch\\TestData\\TestDataSheet.xls");
					 
					   
					   
			//	File src=new File("Q:\\TestWorkSpace\\ReSearch\\TestData\\TestDataSheet.xls");
				File src=new File(path);
				FileInputStream fis=new FileInputStream(src);
				 
				   // load the workbook
				 
				HSSFWorkbook  wb=new HSSFWorkbook (fis);
				 
				  // get the sheet which you want to modify or create
				
				//Nov 22
				HSSFSheet  sh1= wb.getSheet("SendForReview");
				
			//	HSSFSheet  sh1= wb.getSheet("ContentFramework");
				
				
				// Row row = sh1.createRow(1);
				//  
				 /*  Cell cell = row.createCell(1);
				   cell.setCellType(cell.CELL_TYPE_STRING);
				  				   FnonileOutputStream fos = new FileOutputStream("Q:\\TestWorkSpace\\ReSearch\\TestData\\TestDataSheet.xls");
				   wb.write(fos);
				   fos.close();
				*/
				
				   
				   
				   
				List<JsonAttributes> filteredvalue = new ArrayList<>();

							
				int J=0;
				for (JsonAttributes jsonAttributes : originalvalue) 
				
								{
				
					Row row = sh1.createRow(J);
					 J++;
					 System.out.println("Value is" +J);
					 
					 //Nov 27
					 
					 
					 
					 
					//if (jsonAttributes.getVisible()&&jsonAttributes.getRequired()) {
					 
					 
					 if (jsonAttributes.getVisible()) {
						filteredvalue.add(jsonAttributes);
						
						System.out.println("Label  " +jsonAttributes.getlable());
						String Type=jsonAttributes.getInputType();
						
						
						//Nov 26
				//System.out.println("Mandatory  " +jsonAttributes.getRequired());
						
						
						
						System.out.println("InputType  " +jsonAttributes.getInputType());
						
						
						/*HashMap<String,String> XpathInfo=new HashMap<String,String>();
						
						HashMap<String,String> XpathInfo3=new HashMap<String,String>();*/
						
						
						//Code Changes
						String xpath="//label[contains(text(),'";
						String xpath2="')]/..//input";
						String FetchLabel=jsonAttributes.getlable();
						String xpath3="')]/following-sibling::div";
						String DropDownValue="')]/following::sui-select-option[1]";
						
						
						
						
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

							String TypeValue=jsonAttributes.getInputType();
							
							InputType.put(jsonAttributes.getInputType(),TypeValue);

							
							Cell cell = row.createCell(0);
							   cell.setCellType(cell.CELL_TYPE_STRING);
							   cell.setCellValue(Finalxpath);

							  
							   Cell cell2 = row.createCell(1);
							   cell2.setCellType(cell.CELL_TYPE_STRING);
							   cell2.setCellValue(FetchLabel);
							   
							   Cell cell3 = row.createCell(2);
							   cell3.setCellType(cell.CELL_TYPE_STRING);
							   cell3.setCellValue(jsonAttributes.getInputType());
							   
							   
							   Cell cell4 = row.createCell(3);
							   cell4.setCellType(cell.CELL_TYPE_STRING);
							   cell4.setCellValue(ClkMultiSlt);
							   String path1 = System.getProperty("user.dir")+"/TestData/TestDataSheet.xls";
								//   FileOutputStream fos = new FileOutputStream("Q:\\TestWorkSpace\\ReSearch\\TestData\\TestDataSheet.xls");
								   FileOutputStream fos = new FileOutputStream(path1);
							   
							 //  FileOutputStream fos = new FileOutputStream("Q:\\TestWorkSpace\\ReSearch\\TestData\\TestDataSheet.xls");
							   wb.write(fos);
							   fos.close();
							   
 							   
							   
						}
						if(jsonAttributes.getInputType().equalsIgnoreCase("select"))
						{
							String Finalxpath=xpath+FetchLabel+xpath3;
						
							System.out.println("Xpath is  " +Finalxpath);
							
							
							//Nov 22
							String DropdownValues=xpath+FetchLabel+DropDownSlt;
							//String DropdownValues=xpath+FetchLabel+DropDownValue;
							
							
							System.out.println("DropdownValues is  " +DropdownValues);
							
							XpathInfo.put(jsonAttributes.getlable(),Finalxpath);
							InputType.put(jsonAttributes.getInputType(),jsonAttributes.getName());

							
							Cell cell = row.createCell(0);
							   cell.setCellType(cell.CELL_TYPE_STRING);
							   cell.setCellValue(Finalxpath);
							   
							   Cell cell2 = row.createCell(1);
							   cell2.setCellType(cell.CELL_TYPE_STRING);
							   cell2.setCellValue(DropdownValues);
							   
							   
							   Cell cell3 = row.createCell(2);
							   cell3.setCellType(cell.CELL_TYPE_STRING);
							   cell3.setCellValue(jsonAttributes.getInputType());
							   
							   Cell cell4 = row.createCell(3);
							   cell4.setCellType(cell.CELL_TYPE_STRING);
							   cell4.setCellValue(ClkMultiSlt);
							   
							   String path1 = System.getProperty("user.dir")+"/TestData/TestDataSheet.xls";
								//   FileOutputStream fos = new FileOutputStream("Q:\\TestWorkSpace\\ReSearch\\TestData\\TestDataSheet.xls");
								   FileOutputStream fos = new FileOutputStream(path1);
							   
							 //  FileOutputStream fos = new FileOutputStream("Q:\\TestWorkSpace\\ReSearch\\TestData\\TestDataSheet.xls");
							   wb.write(fos);
							  fos.close();
							
						}
						
						if(jsonAttributes.getInputType().equalsIgnoreCase("multiSelect"))
						{
							String Finalxpath=xpath+FetchLabel+xpath3;
							System.out.println("Xpath is  " +Finalxpath);
							
							
							//Nov 22
							//String DropdownValues=xpath+FetchLabel+DropDownValue;
							String DropdownValues=xpath+FetchLabel+DropDownSlt;
							System.out.println("DropdownValues is  " +DropdownValues);
							
							XpathInfo.put(jsonAttributes.getlable(),Finalxpath);
							InputType.put(jsonAttributes.getInputType(),jsonAttributes.getName());

							Cell cell = row.createCell(0);
							   cell.setCellType(cell.CELL_TYPE_STRING);
							   cell.setCellValue(Finalxpath);
							   
							   Cell cell2 = row.createCell(1);
							   cell2.setCellType(cell.CELL_TYPE_STRING);
							   cell2.setCellValue(DropdownValues);
							   
							   Cell cell3 = row.createCell(2);
							   cell3.setCellType(cell.CELL_TYPE_STRING);
							   cell3.setCellValue(jsonAttributes.getInputType());
							   
							   
							   Cell cell4 = row.createCell(3);
							   cell4.setCellType(cell.CELL_TYPE_STRING);
							   cell4.setCellValue(ClkMultiSlt);
							   
							   
							   String path1 = System.getProperty("user.dir")+"/TestData/TestDataSheet.xls";
							//   FileOutputStream fos = new FileOutputStream("Q:\\TestWorkSpace\\ReSearch\\TestData\\TestDataSheet.xls");
							   FileOutputStream fos = new FileOutputStream(path1);
							   wb.write(fos);
							  fos.close();
						}
						
						
						
						
						
						
						
						//Nov 22 2018
						
						if(jsonAttributes.getInputType().equalsIgnoreCase("file"))
						{
							String Finalxpath=xpath+FetchLabel+ImgUpld;
						
							System.out.println("Xpath is  " +Finalxpath);
							
							String DropdownValues=xpath+FetchLabel+DropDownValue;
							System.out.println("DropdownValues is  " +DropdownValues);
							
							XpathInfo.put(jsonAttributes.getlable(),Finalxpath);
							InputType.put(jsonAttributes.getInputType(),jsonAttributes.getName());

							
							Cell cell = row.createCell(0);
							   cell.setCellType(cell.CELL_TYPE_STRING);
							   cell.setCellValue(Finalxpath);
							   
							   Cell cell2 = row.createCell(1);
							   cell2.setCellType(cell.CELL_TYPE_STRING);
							   cell2.setCellValue(DropdownValues);
							   
							   Cell cell3 = row.createCell(2);
							   cell3.setCellType(cell.CELL_TYPE_STRING);
							   cell3.setCellValue(jsonAttributes.getInputType());
							   
							   Cell cell4 = row.createCell(3);
							   cell4.setCellType(cell.CELL_TYPE_STRING);
							   cell4.setCellValue(ClkMultiSlt);
							   
							   String path1 = System.getProperty("user.dir")+"/TestData/TestDataSheet.xls";
								//   FileOutputStream fos = new FileOutputStream("Q:\\TestWorkSpace\\ReSearch\\TestData\\TestDataSheet.xls");
								   FileOutputStream fos = new FileOutputStream(path1);
							   
							 //  FileOutputStream fos = new FileOutputStream("Q:\\TestWorkSpace\\ReSearch\\TestData\\TestDataSheet.xls");
							   wb.write(fos);
							  fos.close();
							
						}
						if(jsonAttributes.getInputType().equalsIgnoreCase("textarea"))
						{
							String Finalxpath=xpath+FetchLabel+xpath3;
						
							System.out.println("Xpath is  " +Finalxpath);
							
							String DropdownValues=xpath+FetchLabel+DropDownValue;
							System.out.println("DropdownValues is  " +DropdownValues);
							
							XpathInfo.put(jsonAttributes.getlable(),Finalxpath);
							InputType.put(jsonAttributes.getInputType(),jsonAttributes.getName());

							
							Cell cell = row.createCell(0);
							   cell.setCellType(cell.CELL_TYPE_STRING);
							   cell.setCellValue(Finalxpath);
							   
							   Cell cell2 = row.createCell(1);
							   cell2.setCellType(cell.CELL_TYPE_STRING);
							   cell2.setCellValue(DropdownValues);
							   
							   Cell cell3 = row.createCell(2);
							   cell3.setCellType(cell.CELL_TYPE_STRING);
							   cell3.setCellValue(jsonAttributes.getInputType());
							   
							   Cell cell4 = row.createCell(3);
							   cell4.setCellType(cell.CELL_TYPE_STRING);
							   cell4.setCellValue(ClkMultiSlt);
							   
							   String path1 = System.getProperty("user.dir")+"/TestData/TestDataSheet.xls";
								//   FileOutputStream fos = new FileOutputStream("Q:\\TestWorkSpace\\ReSearch\\TestData\\TestDataSheet.xls");
								   FileOutputStream fos = new FileOutputStream(path1);
							   
							 //  FileOutputStream fos = new FileOutputStream("Q:\\TestWorkSpace\\ReSearch\\TestData\\TestDataSheet.xls");
							   wb.write(fos);
							  fos.close();
							
						}
						
						if(jsonAttributes.getInputType().equalsIgnoreCase("keywordsuggestion"))
						{
							String Finalxpath=xpath+FetchLabel+xpath2;
							System.out.println("Xpath is  " +Finalxpath);
							XpathInfo.put(jsonAttributes.getlable(),Finalxpath);
							InputType.put(jsonAttributes.getInputType(),jsonAttributes.getName());

							
							Cell cell = row.createCell(0);
							   cell.setCellType(cell.CELL_TYPE_STRING);
							   cell.setCellValue(Finalxpath);
							   
							   Cell cell2 = row.createCell(1);
							   cell2.setCellType(cell.CELL_TYPE_STRING);
							   cell2.setCellValue(FetchLabel);
							   
							   Cell cell3 = row.createCell(2);
							   cell3.setCellType(cell.CELL_TYPE_STRING);
							   cell3.setCellValue(jsonAttributes.getInputType());
							   
							   
							   Cell cell4 = row.createCell(3);
							   cell4.setCellType(cell.CELL_TYPE_STRING);
							   cell4.setCellValue(ClkMultiSlt);
							   String path1 = System.getProperty("user.dir")+"/TestData/TestDataSheet.xls";
								//   FileOutputStream fos = new FileOutputStream("Q:\\TestWorkSpace\\ReSearch\\TestData\\TestDataSheet.xls");
								   FileOutputStream fos = new FileOutputStream(path1);
							   
							 //  FileOutputStream fos = new FileOutputStream("Q:\\TestWorkSpace\\ReSearch\\TestData\\TestDataSheet.xls");
							   wb.write(fos);
							   fos.close();
							   
						}
						
						

						if(jsonAttributes.getInputType().equalsIgnoreCase("topicselector"))
						{
							String Finalxpath=topicSlt+topicSlt2;
						
							System.out.println("Xpath is  " +Finalxpath);
							
							
							//Nov 22
							String DropdownValues=DropdownTopicValue;
							//String DropdownValues=xpath+FetchLabel+DropDownValue;
							
							
							System.out.println("DropdownValues is  " +DropdownValues);
							
						
							XpathInfo.put(jsonAttributes.getlable(),Finalxpath);
							InputType.put(jsonAttributes.getInputType(),jsonAttributes.getName());

							Cell cell = row.createCell(0);
							   cell.setCellType(cell.CELL_TYPE_STRING);
							   cell.setCellValue(Finalxpath);
							   
							   Cell cell2 = row.createCell(1);
							   cell2.setCellType(cell.CELL_TYPE_STRING);
							   cell2.setCellValue(DropdownValues);
							   
							   
							   Cell cell3 = row.createCell(2);
							   cell3.setCellType(cell.CELL_TYPE_STRING);
							   cell3.setCellValue(jsonAttributes.getInputType());
							   
							   Cell cell4 = row.createCell(3);
							   cell4.setCellType(cell.CELL_TYPE_STRING);
							   cell4.setCellValue(ClkMultiSlt);
							   
							   String path1 = System.getProperty("user.dir")+"/TestData/TestDataSheet.xls";
								//   FileOutputStream fos = new FileOutputStream("Q:\\TestWorkSpace\\ReSearch\\TestData\\TestDataSheet.xls");
								   FileOutputStream fos = new FileOutputStream(path1);
							   
							 //  FileOutputStream fos = new FileOutputStream("Q:\\TestWorkSpace\\ReSearch\\TestData\\TestDataSheet.xls");
							   wb.write(fos);
							  fos.close();
							
						}
						
						
						
						
						
						
						
						
						
						
						
						
						
						
						
					/*	XpathInfo3.putAll(XpathInfo);
						System.out.println("Values in newmap2: "+ XpathInfo3);*/
						/*for(Map.Entry m:XpathInfo.entrySet())
						{  
							   System.out.println(m.getKey()+" "+m.getValue());  
						}
						
						String v=XpathInfo.get(jsonAttributes.getlable());
						System.out.println("HaspMapTESt" +v);
						
						*/
				/*		
				 * 
						//Made
						String BeforeXpath="//label[contains(text(),'";
						//e3)]/following-sibling::";
						String Nextxpath=jsonAttributes.getlable();
						String Lastpath="')]/following-sibling::";
						
						String tg="')]/following-sibling::*";
						
						String Afterxpath=BeforeXpath+Nextxpath+Lastpath;
						System.out.println(Afterxpath);
						System.out.println("---------");
						*/
						
					}
				}
				
								  
			
				mp.re();
				/*System.out.println("For loop started"+filteredvalue.size());
				for(int i = 0; i<=filteredvalue.size();i++){
					System.out.println(filteredvalue.get(i));
				}*/
		}			
			
		 catch (Exception e) {
				System.out.println(e);
		 }
		}
		printhash();
		finalvalu();
	}
	
	                          
	
	public static  HashMap<String, String> re()
	{
	 	XpathInfo3.putAll(XpathInfo);
		System.out.println("Values in newmap2: "+XpathInfo3);	
		
		
	//	XpathInfo3.putAll(InputType);
		
		return XpathInfo3;
	}
	
	public static void finalvalu()
	{
	
		//String[] d=printhash();
		String[] d=AutoId();

		for(int i=0;i<d.length;i++)
		{
			System.out.println("LastValue" +d[i]);
		}
		//String dd=d.toString();
		//System.out.println("LastValue" +d);
		//System.out.println("LastValue" +d[6]);
	}
	
	public static String[] AutoId()
	{
		List<String> list = new ArrayList<String>(InputType.values());
	
		 String[] stockArr = new String[list.size()];
		    stockArr = list.toArray(stockArr);

		return stockArr;
		
	}
	public static String[] printhash()
	{
		System.out.println("Value Stored in Hashmap" +XpathInfo3);

 		
		List<String> list = new ArrayList<String>(XpathInfo.values());
		/*for (String s : list) {
			
		    System.out.println("ArrayList  " +s);
		    */                                                                                                               		    

		     
		    
		    String[] stockArr = new String[list.size()];
		    stockArr = list.toArray(stockArr);

		    
		    for(int i=0;i<list.size();i++)
		    {
		    	System.out.println(stockArr[i]);
		    	//if(jsonAttributes.getInputType().equalsIgnoreCase("select"))
		    	
		    	
		    	
		    }
		    
		    return stockArr;
		   /* for(String s1 : stockArr)
		       System.out.println(s1);*/
		    
		   /* System.out.println(stockArr[0]);
		    System.out.println(stockArr[1]);*/
		  //  System.out.println(stockArr[2]);
		    
		 //   System.out.println("ArrayList  " +s[0]);
		    
		    
		    
		}
		
		
	}


