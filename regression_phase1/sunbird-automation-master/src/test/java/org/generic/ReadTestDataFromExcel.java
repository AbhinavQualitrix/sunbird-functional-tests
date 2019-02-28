/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Ajith Manjunath

* Date: 09/14/2018

* Purpose: Contains all the methods which will help reading the data from excel. 
*/


package org.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import org.apache.log4j.Logger;
import org.testdata.TestDataForDiksha;

public class ReadTestDataFromExcel extends GetExcelFileData {

	static Logger log = Logger.getLogger(ReadTestDataFromExcel.class.getName());
	static Vector<String> headers = new Vector<String>();
	static Vector<String> data = new Vector<String>();
	static int noOfRecordsToBeTestedConfig =0, noOfRecordsToBeTested=0;

	public static List <TestDataForDiksha>  getTestDataForDiksha(String callingTestScript) 
	{
		List <TestDataForDiksha> objListOFTestDataForDiksha = new ArrayList<TestDataForDiksha>();
		int columnIndex = 0, sizeofHeaders = 0; 
		String columnName = "", dataValue = "";
		TestDataForDiksha objTDForDiksha = new TestDataForDiksha();
		String testDataPath = "", sheetName = "";
		try	{
			ReadTestDataFromExcel.getColumnNames();
			testDataPath = getTestDataPath(callingTestScript);
			System.out.println("Checking"+testDataPath);
			sheetName = getSheetName(callingTestScript);
			log.info("Method:getTestDataForSearch :: equipmentTestDataPath = " + testDataPath 
					+ " sheetname = " + sheetName
					+ " noOfRecordsToBeTestedConfig = " + noOfRecordsToBeTestedConfig);
			noOfRecordsToBeTestedConfig = 100;
			headers = GenericExlMethods.fetchTableHeaderColumn(testDataPath, sheetName);
			data = GenericExlMethods.fetchTableData(testDataPath, sheetName, noOfRecordsToBeTestedConfig);

			noOfRecordsToBeTested = data.size();
			sizeofHeaders = headers.size();

			log.debug("Method:getTestDataForSearch :: no of records to be tested = " + noOfRecordsToBeTested 
					+ "data.size() = " + data.size() + " headers.size() = " + headers.size()
					+ " sizeofHeaders = " + sizeofHeaders );

			if (noOfRecordsToBeTested > 0 && headers.size() > 0 && data.size() > 0 ) {
				for (int row = 0; row < noOfRecordsToBeTested ; row++)	{
					columnName = headers.get(columnIndex).toString().trim();
					dataValue = data.get(row).toString();
					if (columnName != null)		
					{

						if(columnName.equals(username.trim()))	
							objTDForDiksha.setUsername(dataValue);
						else if(columnName.equals(password.trim()))	
							objTDForDiksha.setPassword(dataValue);
						else if(columnName.equals(firstName.trim()))	
							objTDForDiksha.setFirstName(dataValue);	
						else if(columnName.equals(lastName.trim()))	
							objTDForDiksha.setLastName(dataValue);
						else if(columnName.equals(phone.trim()))	
							objTDForDiksha.setPhone(dataValue);
						else if(columnName.equals(email.trim()))	
							objTDForDiksha.setEmail(dataValue);			
						else if(columnName.equals(role.trim()))	
							objTDForDiksha.setRole(dataValue);
						else if(columnName.equals(addresslane1.trim()))
							objTDForDiksha.setAddressLane1(dataValue);
						else if(columnName.equals(addresslane2.trim()))
							objTDForDiksha.setAddressLane2(dataValue);
						else if(columnName.equals(city.trim()))
							objTDForDiksha.setCity(dataValue);
						else if(columnName.equals(state.trim()))
							objTDForDiksha.setState(dataValue);
						else if(columnName.equals(country.trim()))
							objTDForDiksha.setCountry(dataValue);
						else if(columnName.equals(pincode.trim()))
							objTDForDiksha.setPincode(dataValue);
						else if(columnName.equals(executeTest.trim()))	
							objTDForDiksha.setExecuteTest(dataValue);


						else if(columnName.equals(summary.trim()))	
							objTDForDiksha.setSummary(dataValue);
						else if(columnName.equals(occupation.trim()))	
							objTDForDiksha.setOccupation(dataValue);
						else if(columnName.equals(designation.trim()))	
							objTDForDiksha.setDesignation(dataValue);
						else if(columnName.equals(organization.trim()))	
							objTDForDiksha.setOrganization(dataValue);
						else if(columnName.equals(degree.trim()))	
							objTDForDiksha.setDegree(dataValue);
						else if(columnName.equals(percentage.trim()))	
							objTDForDiksha.setPercentage(dataValue);
						else if(columnName.equals(grade.trim()))	
							objTDForDiksha.setGrade(dataValue);
						else if(columnName.equals(institution.trim()))	
							objTDForDiksha.setInstitution(dataValue);
						else if(columnName.equals(board.trim()))	
							objTDForDiksha.setBoard(dataValue);
						else if(columnName.equals(skills.trim()))	
							objTDForDiksha.setSkills(dataValue);
						else if(columnName.equals(afirstName.trim()))	
							objTDForDiksha.setAfirstName(dataValue);
						else if(columnName.equals(alastName.trim()))	
							objTDForDiksha.setAlastName(dataValue);
						else if(columnName.equals(currentlocation.trim()))	
							objTDForDiksha.setCurrentlocation(dataValue);

						else if(columnName.equals(courseName.trim()))	
							objTDForDiksha.setCourseName(dataValue);
						else if(columnName.equals(courseDescription.trim()))	
							objTDForDiksha.setCourseDescription(dataValue);
						else if(columnName.equals(title.trim()))	
							objTDForDiksha.setTitle(dataValue);
						else if(columnName.equals(titleDescription.trim()))	
							objTDForDiksha.setTitleDescription(dataValue);
						


					}

					columnIndex = columnIndex + 1;

					if (columnIndex == sizeofHeaders)	{
						if ((objTDForDiksha.getExecuteTest().toLowerCase().contains("yes")) == true)
							objListOFTestDataForDiksha.add(objTDForDiksha);
						columnIndex = 0;
						objTDForDiksha = new TestDataForDiksha();					
					}
				} 

			} 

		}
		catch(Exception e) {
			log.error("Method:getTestDataForSearch :: exception = " + e.getMessage()  + e.getStackTrace());
			e.printStackTrace();
		}

		log.info("Method:getTestDataForSearch :: returning size of test records = " + objListOFTestDataForDiksha.size());	
		return objListOFTestDataForDiksha;
	}


}
