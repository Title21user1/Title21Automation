package org.title21.test;

import org.testng.annotations.Test;
import org.title21.DBConnection.DBConnection;
import org.title21.dao.AdminData;
import org.title21.utility.BaseClass;
import org.title21.utility.DateTimeUtils;

public class debug extends BaseClass{
	
	/*public static void main(String args[]){
		AdminData admindataObj=new AdminData();
		admindataObj.getEmployeeName();		
	}*/
	
	@Test
	public static void test_db() throws Exception{
		
		DBConnection dbconnect=new DBConnection();
		dbconnect.getConnection();
		
		DateTimeUtils dateconnect=new DateTimeUtils();
		System.out.println(dateconnect.getYesterdayDate());		
		System.out.println(dateconnect.getTomorrowDate());		
		System.out.println(dateconnect.getCurrentPSTDate());		
		
	}	
	
}