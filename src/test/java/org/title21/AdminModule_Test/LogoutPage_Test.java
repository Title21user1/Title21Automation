package org.title21.AdminModule_Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.utility.BaseClass;

import com.relevantcodes.extentreports.LogStatus;

public class LogoutPage_Test extends BaseClass {

	LoginPage_POM login; 
	LogoutPage_POM logout;
	SoftAssert softAssertion=new SoftAssert();
	String className="";

	String testcaseName="TestCase-WIA-Logout.doc";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;		

	@BeforeClass
	public void openURL() {

		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
	}

	@Test(testName = "Logout", groups = "Logout", priority = 0)
	public void Logout() throws Exception {

		test = extent.startTest("Logout");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		test.log(LogStatus.PASS, "1. Login to the web interface.");
		login= new LoginPage_POM(driver);
		login.getUsername().sendKeys(loginData[1][0]);
		test.log(LogStatus.PASS, "1b) Username Entered");
		login.getLogin_button().click();
		test.log(LogStatus.PASS, "1c) Clicked on Login button after entering Username.");
		login.getpassword().sendKeys(loginData[1][1]);
		test.log(LogStatus.PASS, "1d) Password Entered");
		login.getLogin_button().click();
		logout=new LogoutPage_POM(driver);
		logout.getAdmindropdown().click();
		test.log(LogStatus.PASS, "2. Click on Username Dropdown at the top.");
		logout.getlogoutLink().click();

		test.log(LogStatus.PASS, "3. Click on Log out link."+				
				test.addScreenCapture(captureScreenShot(driver, "clickonLogoutlink")));	

		sleep(2);	

		if (logout.verifyMessageonModalDialog(driver)){
			test.log(LogStatus.PASS, "<br><b>ER1: User should be able to navigate Confirm Log out pop up Screen.</b><br>"+
					test.addScreenCapture(captureScreenShot(driver, "Logout Alert")));
		};

		waitTillElementVisible(logout.getCancelButton());
		logout.getCancelButton().click();
		sleep(2);

		if (logout.getAdmindropdown().isDisplayed()){
			test.log(LogStatus.PASS, "4. Click on Cancel button in Confirmation Log out screen."+
					"<br/>"+"<b>ER2: User should not Log out.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Usernotloggedout.")));
		}

		logout.getAdmindropdown().click();
		logout.getlogoutLink().click();
		sleep(2);
		logout.getLogoutButton().click();
		sleep(4);

		if (login.getUsername().isDisplayed()){
			test.log(LogStatus.PASS, "5. Click on Log out button in Confirmation Log out screen"+
					"<br/> <b> ER3: User should Log out and navigate to the Login Page.<b>" + 
					test.addScreenCapture(captureScreenShot(driver, "ClickOnLogoutButton")));		
		}

		test.log(LogStatus.PASS, "6. When logged out, navigate directly "
				+ "to any of the pages directly by entering the URL into the browser address bar (E.G: https://qa21.title21health.com/Training).");

		driver.navigate().to(baseUrl+"/Training");
		sleep(2);

		if (login.getUsername().isDisplayed()){
			test.log(LogStatus.PASS, 
					"<b> ER4:  User remains logged out and cannot navigate to the page (E.G: Training)" + 
							test.addScreenCapture(captureScreenShot(driver, "CannotnavigatetoTrainingPage")));		
		}

	}

	@AfterClass
	public void closeBrowserInstance() 
	{
		extent.endTest(test);
		driver.close();
	}

}
