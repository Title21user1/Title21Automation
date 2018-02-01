package org.title21.test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.title21.POM.DashBord_POM;
import org.title21.POM.LoginPage_POM;
import org.title21.POM.LogoutPage_POM;
import org.title21.utility.BaseClass;

import com.relevantcodes.extentreports.LogStatus;

public class AddEmployee_Test extends BaseClass {
	LoginPage_POM login; 
	LogoutPage_POM logout;
	DashBord_POM dashboardObj;
	SoftAssert softAssertion=new SoftAssert();
	String className="";
	
	@BeforeClass
	public void openURL() 
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		loginFunction(driver);
		
	}
	@Test(testName = "login_admin", groups = "Logins", priority = 0)
	public void LoginWithInvalidCredentials() throws Exception 
	{
		
	}	
	
	
	
	@AfterClass
	public void closeBrowserInstance() 
	{
		
		driver.close();
	}

	
	
}
