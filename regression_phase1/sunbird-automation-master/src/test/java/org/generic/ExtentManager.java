/**

* Created by Qualitrix Technologies Pvt Ltd.

* @author: Ajith Manjunath

* Date: 09/14/2018

* Purpose: Contains all the methods which will help extent reporting. 
*/


package org.generic;

import com.relevantcodes.extentreports.ExtentReports;

//OB: ExtentReports extent instance created here. That instance can be reachable by getReporter() method.
 
public class ExtentManager {
 
    private static ExtentReports extent;
 
    public synchronized static ExtentReports getReporter(){
        if(extent == null){
            //Set HTML reporting file location
            String workingDir = System.getProperty("user.dir");
            extent = new ExtentReports(workingDir+"/extentReports/extentReportResults.html", true);
        }
        return extent;
    }
}
