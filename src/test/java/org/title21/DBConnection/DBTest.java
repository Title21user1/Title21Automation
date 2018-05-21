package org.title21.DBConnection;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.utility.BaseClass;

public class DBTest extends BaseClass
{
	CreateUsers createusers;
	DBConnection dbconnection;
	
	static Logger log = Logger.getLogger(DBTest.class);
	
	@BeforeClass
	public void beforeClass()
	{
		createusers = new CreateUsers();
		dbconnection = new DBConnection();
	}
	
	@Test
	public void getSessionTimeOut() throws Exception
	{
		/*dbconnection.getQueryExecuted(createusers.Title21User3_1);
		sleep(1);
		dbconnection.getQueryExecuted(createusers.Title21User3_2);
		sleep(1);
		dbconnection.getQueryExecuted(createusers.Title21User3_3);
		sleep(1);
		dbconnection.getQueryExecuted(createusers.Title21User3_4);
		sleep(1);
		dbconnection.getQueryExecuted(createusers.Title21User3_5);
		sleep(1);
		dbconnection.getQueryExecuted(createusers.Title21User3_6);
		sleep(1);
		dbconnection.getQueryExecuted(createusers.Title21User3_7);
		sleep(1);
		dbconnection.getQueryExecuted(createusers.Title21User3_8);
		sleep(1);
		dbconnection.getQueryExecuted(createusers.Title21User3_9);
		sleep(1);
		dbconnection.getQueryExecuted(createusers.Title21User3_10);
		sleep(1);
		log.info("User 3 Created");*/
		
		DBConnection.verifyString("Title21User1", "select UserName from tblUserName where Username='Title21User1'", "UserName");
		
	}
		
}
