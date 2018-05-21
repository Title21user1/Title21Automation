package org.title21.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.testng.Assert;
import org.title21.utility.BaseClass;

public class DBConnection {
	
	protected static Connection connection;
	protected static Statement statement;
	protected static ResultSet rs;

	public static Connection getConnection() throws Exception {

		if (connection==null)  {
			try {
				DriverManager.registerDriver(new com.microsoft.sqlserver.jdbc.SQLServerDriver());
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				connection = DriverManager.getConnection(getDBConnectionString());
				if (connection != null) {
					System.out.println("Connected to DB");
				}
			} catch (SQLException e) {
				Assert.fail("Error Occurred while Connecting to DB : " + e.getMessage());
			}
		}
		else{
			System.out.println("previous connection not closed properly");
		}
		return connection;
	}

	private static String getDBConnectionString()
	{

		return String.format("jdbc:sqlserver://%s;databaseName=%s;user=%s;password=%s;", BaseClass.dbServer,
				BaseClass.dbName, BaseClass.dbUsername, BaseClass.dbPassword);

	}

	public static Connection closeConnection() {
		if (connection != null) {
			try {				
				connection.close();
				connection=null;
				BaseClass.sleep(2);
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return connection;
	}

	public static int getIntDBValue(String dbquery, String columnName)
	{
		int dbvalue = 0;
		try{
			getConnection();
			String query = dbquery;
			statement = connection.createStatement();
			rs = statement.executeQuery(query);

			while(rs.next()){
				dbvalue= rs.getInt(columnName);				
			}
		}
		catch(Exception e)
		{

		}
		finally{
			closeConnection();
		}
		return dbvalue;
	}

	public void getQueryExecuted(String dbquery)
	{
		try{
			getConnection();
			String query = dbquery;
			statement = connection.createStatement();
			rs = statement.executeQuery(query);				
		}
		catch(Exception e)
		{

		}
		finally{
			closeConnection();
		}
	}

	public static boolean verifyString(String value,String dbquery, String columnName)
	{
		boolean isPresent=false;
		String dbvalue = null;
		
		try{
			getConnection();
			String query = dbquery;
			statement = connection.createStatement();
			rs = statement.executeQuery(query);

			while(rs.next()){
				dbvalue= rs.getString(columnName);			
			}
		}
		catch(Exception e)
		{

		}
		finally{
			closeConnection();
		}
		
		if (dbvalue.equalsIgnoreCase(value))
		{
			isPresent=true;
			System.out.println(""+value+" is already present");
		} else 
		{
			System.out.println(""+value+" is not present");
		}
		
		return isPresent;
	}

	public static boolean executeStoredProcedure(String storedProcedure) throws Exception{
		Connection con;
		PreparedStatement ps = null;
		try{
			boolean getResults;
			con=getConnection();
			ps= con.prepareStatement(storedProcedure);

			ps.setEscapeProcessing(true);
			getResults=ps.execute();

			if (getResults){

				rs=ps.getResultSet();
				System.out.println("There is a resultset.");
				return true;

			}else{
				System.out.println("There is a no resultset returned after executing stored procedure.");
				return true;
			}

		}
		catch(Exception e){
			System.out.println(e);
			return false;
		}	
		finally{
			closeConnection();			
		}	

	}


}




