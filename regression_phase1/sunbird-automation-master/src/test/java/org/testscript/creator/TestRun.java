package org.testscript.creator;

import org.testng.internal.Utils;

public class TestRun {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub
		/*String bucketName= "https://staging.ntp.net.in/workspace/content/drafts/1";
		System.out.println(bucketName);
	
		String bucket= bucketName.substring(bucketName.lastIndexOf("/"));
		
		//boolean rets = bucketName.endsWith("content/");
		
		String bucket2= bucketName.substring(bucketName.indexOf("content/"));
		
		//boolean bucket3= bucketName.startsWith("content/");
	
		String result[] = bucketName.split("/");
		
		System.out.println("FINAL  "+result[result.length-2]);
		
		//System.out.println("BUCK1"+bucket);
		//System.out.println("BUCK3 " +bucket3);
		 */	
		
		
		String contentName = "Automation Collection"+"/"+"Diksha_ntp_org";
		System.out.println(contentName);
		String[] result = contentName.split("/");
		for(String a :result)
		{
			System.out.println("results "+a);
		}
		
		System.out.println("result 1 -"+result[0]);
		System.out.println("result 1 -"+result[1]);
		
		//System.out.println("result 2 -"+result[]);
	}

}
