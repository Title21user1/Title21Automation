package org.title21.DBConnection;

public class DatabaseCheck
{
	DBQueries dbquries = new DBQueries();
	DBConnection dbconnection = new DBConnection();
	CreateUsers createusers = new CreateUsers();
	CreateGroup creategroups = new CreateGroup();
	String columnUserName="UserName";
	String columnGroupName="Groups";
	
	public void runDatabaseCheck()
	{
		boolean verifyUser1 = DBConnection.verifyString("Title21User1", dbquries.verifyTitle21User1, columnUserName);
		boolean verifyUser2 = DBConnection.verifyString("Title21User2", dbquries.verifyTitle21User2, columnUserName);
		boolean verifyUser3 = DBConnection.verifyString("Title21User3", dbquries.verifyTitle21User3, columnUserName);
		boolean verifyUser4 = DBConnection.verifyString("Title21User4", dbquries.verifyTitle21User4, columnUserName);
		boolean verifyUser5 = DBConnection.verifyString("Title21User5", dbquries.verifyTitle21User5, columnUserName);
		boolean verifyGroup = DBConnection.verifyString("Title21Group", dbquries.verifyTitle21Group, columnGroupName);
		
		dbconnection.getQueryExecuted(dbquries.setAdminPassword);
		dbconnection.getQueryExecuted(dbquries.uncheckWizardPopUp);
		
		if(verifyGroup==false)
		{
			dbconnection.getQueryExecuted(creategroups.Title21Group_1);
			dbconnection.getQueryExecuted(creategroups.Title21Group_2);
			dbconnection.getQueryExecuted(creategroups.Title21Group_3);
		}
		
		if(verifyUser1==false)
		{
			dbconnection.getQueryExecuted(createusers.Title21User1_1);
			dbconnection.getQueryExecuted(createusers.Title21User1_2);
			dbconnection.getQueryExecuted(createusers.Title21User1_3);
			dbconnection.getQueryExecuted(createusers.Title21User1_4);
			dbconnection.getQueryExecuted(createusers.Title21User1_5);
			dbconnection.getQueryExecuted(createusers.Title21User1_6);
			dbconnection.getQueryExecuted(createusers.Title21User1_7);
			dbconnection.getQueryExecuted(createusers.Title21User1_8);
			dbconnection.getQueryExecuted(createusers.Title21User1_9);
			dbconnection.getQueryExecuted(createusers.Title21User1_10);
		}
		
		if(verifyUser2==false)
		{
			dbconnection.getQueryExecuted(createusers.Title21User2_1);
			dbconnection.getQueryExecuted(createusers.Title21User2_2);
			dbconnection.getQueryExecuted(createusers.Title21User2_3);
			dbconnection.getQueryExecuted(createusers.Title21User2_4);
			dbconnection.getQueryExecuted(createusers.Title21User2_5);
			dbconnection.getQueryExecuted(createusers.Title21User2_6);
			dbconnection.getQueryExecuted(createusers.Title21User2_7);
			dbconnection.getQueryExecuted(createusers.Title21User2_8);
			dbconnection.getQueryExecuted(createusers.Title21User2_9);
			dbconnection.getQueryExecuted(createusers.Title21User2_10);
		}
		
		if(verifyUser3==false)
		{
			dbconnection.getQueryExecuted(createusers.Title21User3_1);
			dbconnection.getQueryExecuted(createusers.Title21User3_2);
			dbconnection.getQueryExecuted(createusers.Title21User3_3);
			dbconnection.getQueryExecuted(createusers.Title21User3_4);
			dbconnection.getQueryExecuted(createusers.Title21User3_5);
			dbconnection.getQueryExecuted(createusers.Title21User3_6);
			dbconnection.getQueryExecuted(createusers.Title21User3_7);
			dbconnection.getQueryExecuted(createusers.Title21User3_8);
			dbconnection.getQueryExecuted(createusers.Title21User3_9);
			dbconnection.getQueryExecuted(createusers.Title21User3_10);
		}
		
		if(verifyUser4==false)
		{
			dbconnection.getQueryExecuted(createusers.Title21User4_1);
			dbconnection.getQueryExecuted(createusers.Title21User4_2);
			dbconnection.getQueryExecuted(createusers.Title21User4_3);
			dbconnection.getQueryExecuted(createusers.Title21User4_4);
			dbconnection.getQueryExecuted(createusers.Title21User4_5);
			dbconnection.getQueryExecuted(createusers.Title21User4_6);
			dbconnection.getQueryExecuted(createusers.Title21User4_7);
			dbconnection.getQueryExecuted(createusers.Title21User4_8);
			dbconnection.getQueryExecuted(createusers.Title21User4_9);
		}
		
		if(verifyUser5==false)
		{
			dbconnection.getQueryExecuted(createusers.Title21User5_1);
			dbconnection.getQueryExecuted(createusers.Title21User5_2);
			dbconnection.getQueryExecuted(createusers.Title21User5_3);
			dbconnection.getQueryExecuted(createusers.Title21User5_4);
			dbconnection.getQueryExecuted(createusers.Title21User5_5);
			dbconnection.getQueryExecuted(createusers.Title21User5_6);
			dbconnection.getQueryExecuted(createusers.Title21User5_7);
			dbconnection.getQueryExecuted(createusers.Title21User5_8);
			dbconnection.getQueryExecuted(createusers.Title21User5_9);
		}
	}
}
