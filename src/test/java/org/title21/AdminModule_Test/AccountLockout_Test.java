package org.title21.AdminModule_Test;

import org.testng.annotations.Test;
import org.title21.AdminModule_POM.AddNewUser_POM;
import org.title21.AdminModule_POM.AdministrationPage_POM;
import org.title21.AdminModule_POM.DashBord_POM;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.AdminModule_POM.UpdateUser_POM;
import org.title21.DBConnection.DBConnection;
import org.title21.DBConnection.DBQueries;
import org.title21.utility.BaseClass;
import org.title21.validation.entities.ErrorMessages;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.AfterClass;

public class AccountLockout_Test extends BaseClass
{
	LoginPage_POM login; 
	LogoutPage_POM logout;
	AdministrationPage_POM adminpage;
	AddNewUser_POM adduser;
	UpdateUser_POM updateuser;
	DashBord_POM dashboardObj;
	DBQueries dbqueries;
	String className="";
	String testcaseName="TestCase-WIA-Lockout on repeated incorrect passwords.doc";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;

	@BeforeClass(alwaysRun=true)
	public void beforeClass()
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		login=new LoginPage_POM(driver);
		logout=new LogoutPage_POM(driver);
		adminpage = new AdministrationPage_POM(driver);
		adduser = new AddNewUser_POM(driver);
		updateuser = new UpdateUser_POM(driver);
		dbqueries = new DBQueries();
	}

	@Test(testName = "AccountLockOut", groups = "AdminModule", priority = 0)
	public void accountLockout()
	{
		test = extent.startTest("Account Lockout");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		test.log(LogStatus.PASS,"1.	Enter the URL in the browser to bring up the web interface login page.");
		login.loginUser(loginData[2][0], loginData[2][1]);

		if (login.verifyPasswordErrorMessagePresence()==true)
		{
			login.getUsername().clear();
			login.loginFunction();
			logout.getAdmindropdown().click();	
			sleep(1);
			adminpage.administrationLink().click();
			sleep(1);
			adduser.user_link().click();
			sleep(2);
			updateuser.unlockUser(loginData[2][0]);
			logout.logoutFunction();
			login.loginUser(loginData[2][0], loginData[2][1]);

			updateuser.iAgree_Button().click();
		}
		else
		{
			if (updateuser.verifyIAgreePresence()==true)
			{
				updateuser.iAgree_Button().click();
				sleep(2);
			}		
		}

		test.log(LogStatus.PASS,"2.	Enter a valid test username and password");
		test.log(LogStatus.PASS,"<b>ER1: User is able to login with the correct username and password.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "SuccessfulLogin")));
		
		logout.logoutFunction();
		test.log(LogStatus.PASS,"3.	Log out of the web interface");

		login.getUsername().sendKeys(loginData[2][0]);
		sleep(1);
		login.getLogin_button().click();
		sleep(2);
		
		int NumFailedLoginAttempts = DBConnection.getIntDBValue(dbqueries.failedloginattempts,"NumFailedLoginAttempts");
		int counter = 1;
		test.log(LogStatus.PASS,"4.	Enter the test username with an incorrect password "+NumFailedLoginAttempts+" times consecutively");
		
		login.getpassword().sendKeys(loginData[3][1]);
		sleep(2);
		login.getLogin_button().click();
		sleep(2);
		test.log(LogStatus.PASS,"Invalid Login No: "+counter);
	
		for (int i = 1; i < NumFailedLoginAttempts; i++)
		{
			{
				login.getpassword().sendKeys(loginData[3][1]);
				sleep(2);
				login.getLogin_button().click();
				sleep(1);
				login.getLogin_button().click();
				sleep(2);
				counter++;
				test.log(LogStatus.PASS,"Invalid Login No: "+counter);	
			}
		}

		test.log(LogStatus.PASS,"<b>ER2: On entering the incorrect password "+NumFailedLoginAttempts+" times the user is locked out and asked to contact the administrator.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "AccountLocked")));

		login.getpassword().sendKeys(loginData[2][1]);
		sleep(2);
		login.getLogin_button().click();
		sleep(2);
		login.getLogin_button().click();
		sleep(2);
		test.log(LogStatus.PASS,"5.	Login again, but now with the correct password.");
		
		if (login.getPasswordErrorMessage().getText().equalsIgnoreCase(ErrorMessages.passworderrormessages))
		{
			test.log(LogStatus.PASS,"<b>ER3: The user remains locked out and cannot login with the correct password.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "UnableToLogin")));	
		}
		
	}


	@AfterClass(alwaysRun=true)
	public void afterClass()
	{
		extent.endTest(test);
		driver.quit();
	}
}