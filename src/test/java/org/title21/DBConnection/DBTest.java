package org.title21.DBConnection;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.utility.BaseClass;

public class DBTest extends BaseClass
{
	CleanDBQueries cleandbqueries;
	DBConnection dbconnection;
	
	static Logger log = Logger.getLogger(DBTest.class);
	
	@BeforeClass
	public void beforeClass()
	{
		cleandbqueries = new CleanDBQueries();
		dbconnection = new DBConnection();
	}
	
	@Test
	public void getSessionTimeOut() throws Exception
	{
		dbconnection.getQueryExecuted(cleandbqueries.creategroup1);
		sleep(1);
		log.info("Admin Group Created: AdminGroup");
		dbconnection.getQueryExecuted(cleandbqueries.updategroup1);
		sleep(1);
		log.info("Admin Group Updated");
	}
		
}
