package org.title21.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.testng.Assert;
import org.title21.utility.BaseClass;

public class DBConnection extends BaseClass {

	public static Connection getConnection() throws Exception {
		System.out.println(connection);
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
				sleep(2);			
				
			} catch (SQLException ex) {
  				ex.printStackTrace();
			}
		}
		return connection;
	}

	/*
	 * @param dbquery - query statement
	 * @param columnName - columnName in which query will fetch the value.
	 * 
	 */
	
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
			System.out.println("Failed Database Connection");
		}
		finally{
			closeConnection();
		}
		return dbvalue;
	}
	
	/*
	 * 
	 * This will execute storedProcedure. 
	 * It will return true if there is any resultset false otherwise. 
	 * 
	 */
		
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




