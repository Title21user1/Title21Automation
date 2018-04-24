package org.title21.AdminModule_Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.title21.AdminModule_POM.DashBord_POM;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.utility.BaseClass;

import com.relevantcodes.extentreports.LogStatus;

public class LoginPage_Test extends BaseClass {
	LoginPage_POM login; 
	DashBord_POM dashboardObj;
	SoftAssert softAssertion=new SoftAssert();
	String className="";
	
	String testcaseName="TestCase-WIA-Login Authentication.doc";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;	
	
	@BeforeClass
	public void openURL() 
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		
	}
	@Test(testName = "Login Functionality", groups = "AdminModule", priority = 0)
	public void LoginToApp() throws Exception 
	{
		test = extent.startTest("Login Authentication");
		
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		test.log(LogStatus.PASS, "1. Enter the URL in the browser to bring up the web interface login page.");
		login= new LoginPage_POM(driver);
		login.getLogin_button().click();
		sleep(2);
		
		if (login.verifyUserIDValidationMessage()){
			test.log(LogStatus.PASS, "2. Click on Log in button without a user name."+"<br/>"
		     +"<b>ER1: User is informed of missing User Name <b>"+
			test.addScreenCapture(captureScreenShot(driver, "withBlankUsername")));
		}
		
		//login.sendKeys(loginData[0][0]);
		login.getUsername().sendKeys(loginData[0][0]);
		test.log(LogStatus.PASS, "2a Username Entered");
		login.getLogin_button().click();
		test.log(LogStatus.PASS, "3. Enter a valid user name for a user within in the system, click on Log in button");
		test.addScreenCapture(captureScreenShot(driver, "AfterEnteringProperUsername"));
		login.getLogin_button().click();
		sleep(2);
		
		if (login.verifyPasswordValidationMessage()){
			test.log(LogStatus.PASS, "4. Click on Log in button without password"+"<br/>"+
					"<b>ER2: User is informed of missing Password.<b>"+		
			test.addScreenCapture(captureScreenShot(driver, "MessageWithblankPassword")));
		}
		
		login.getpassword().sendKeys(loginData[0][1]);		
		login.getLogin_button().click();
		test.log(LogStatus.PASS, "4a. Clicked on Login Button.");
		
		if (login.verifyPasswordErrorMessage()){			
			test.log(LogStatus.PASS, "5. Enter an incorrect password, and click on Log in button."+"<br/>"
			+"<b>ER3: Password entered is cleared and user is informed of invalid credentials<b>"+		
			test.addScreenCapture(captureScreenShot(driver, "PasswordErrorMessageSuccess")));
		}else{			
			throw new Exception("Password message not matched.");			
		};
		
		login.getUsername().clear();
		login.getUsername().sendKeys(loginData[1][0]);
		login.getpassword().sendKeys(loginData[1][1]);
		test.log(LogStatus.PASS, "6. Enter the correct user name and password.");
		login.getLogin_button().click();
		test.log(LogStatus.PASS, "6a) Clicked on Login button."+
		test.addScreenCapture(captureScreenShot(driver, "View after Loggedin.")));
		
		login.getLogin_button().click();
		waitForPageToLoad(driver,4);		
		test.log(LogStatus.PASS, "6b) Verifying DashBord after user loggedin.");
		dashboardObj = new DashBord_POM(driver); 
		
		if (dashboardObj.verifyDashboardPrescence()){
			test.log(LogStatus.PASS, "6c) DashBord is displayed After Login."
		+"<br/>"+"<b>ER4: User is successfully logged in and the home screen or dashboard is displayed.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "displayingDashboard")));
		};
		     	
	}	
	
	
	@AfterClass
	public void closeBrowserInstance() 
	{
		extent.endTest(test);
		driver.close();
	}

	
	
}
