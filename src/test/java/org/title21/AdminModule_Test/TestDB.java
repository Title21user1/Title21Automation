package org.title21.AdminModule_Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.DBConnection.DBConnection;
import org.title21.DBConnection.DBQueries;
import org.title21.utility.BaseClass;

import com.relevantcodes.extentreports.LogStatus;

public class TestDB extends BaseClass
{
	DBQueries dbqueries;
	
	@BeforeClass
	public void beforeClass()
	{
		dbqueries = new DBQueries();
	}
	
	@Test
	public void getSessionTimeOut() throws Exception
	{
		test = extent.startTest("Session Timeout");
		
		//test.log(LogStatus.PASS,"DataBase Value "+DBConnection.getIntDBValue(dbqueries.sessessiontimeoutinminutes, 
		//"sessiontimeoutinminutes"));
		
		if (DBConnection.executeStoredProcedure(dbqueries.moveDocsOnReleaseDate)){
			test.log(LogStatus.PASS,"Success while moving docs between cabinets.");
		}else{
			test.log(LogStatus.FAIL,"Failed to Move Docs Between Cabinets");
		}
		
		sleep(4);
		
		if (DBConnection.executeStoredProcedure(dbqueries.moveDocsOnReleaseDate)){
			test.log(LogStatus.PASS,"Success while moving docs between cabinets.");
		}else{
			test.log(LogStatus.FAIL,"Failed to Move Docs Between Cabinets");
		}
		
		//test.log(LogStatus.PASS,"MoveDocsBetweenCabinets"+DBConnection.executeStoredProcedure(dbqueries.moveDocsOnReleaseDate));				
	}
		
	@AfterClass
	public void afterClass()
	{
		extent.endTest(test);
	}
}
