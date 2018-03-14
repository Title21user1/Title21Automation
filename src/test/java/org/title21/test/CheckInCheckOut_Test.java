package org.title21.test;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.POM.CreateDocument_POM;
import org.title21.POM.LoginPage_POM;
import org.title21.POM.LogoutPage_POM;
import org.title21.POM.MyDocs_POM;
import org.title21.utility.BaseClass;

import com.relevantcodes.extentreports.LogStatus;

public class CheckInCheckOut_Test extends BaseClass
{
	LoginPage_POM login; 
	LogoutPage_POM logout;
	CreateDocument_POM Credoc;
	MyDocs_POM mydocs;
	String className="";

	@BeforeClass
	public void beforeClass()
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		login=new LoginPage_POM(driver);
		logout=new LogoutPage_POM(driver);
		mydocs =new MyDocs_POM(driver);
		Credoc=new CreateDocument_POM(driver);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}


	@Test(testName = "CheckInCheckOut", groups = "Document", priority = 0)
	public void checkInCheckOut()
	{
		test = extent.startTest("Check In and Check Out Document");
		login.loginUser(loginData[4][0], loginData[4][1]);
		sleep(2);
		test.log(LogStatus.PASS,"1. Login to Web Application as a Test User");

		Credoc.getnewdoc().click();
		sleep(2);
		Credoc.getdocument().click();
		sleep(3);
		
		Credoc.getlocationDrodown().selectByVisibleText("Pittsburgh");
		sleep(2);
		Credoc.getSearchText().sendKeys("SOP.CT");
		sleep(1);
		Credoc.getGoButton().click();
		sleep(1);
		Credoc.selectType().click();
		sleep(2);
		Credoc.getAutoCheck().selectByVisibleText("Check Out User");
		sleep(2);
		Credoc.getDocTitle().sendKeys("TestDocument");
		Credoc.getDocChangeSummary().sendKeys("Test Summary");
		mydocs.docID = Credoc.getdocumentnumber().getAttribute("value");
		verticalScrollingDown();
		Credoc.getConfirmButton().click();
		sleep(2);
		test.log(LogStatus.PASS,"2.	Create a new document form and set Auto Check Out to another user. Created Doc ID: "+mydocs.docID);
		if(Credoc.permissionToEditMessage()==true)
		{
			test.log(LogStatus.PASS,"<b>ER1: Document has been created successfully and a message appears: You don't have permissions to edit form DOC. <b>"+
					test.addScreenCapture(captureScreenShot(driver, "No Permission to Edit")));
		}
		else
		{
			test.log(LogStatus.FAIL,"<b>ER1: Document has been created successfully but message didnt Appeared.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "No Message")));
		}
		
		logout.logoutFunction();
		test.log(LogStatus.PASS,"3.	Logout with the test user ");
		login.loginUser(loginData[5][0], loginData[5][1]);
		sleep(2);
		test.log(LogStatus.PASS,"4.	Log in with the user which is set as Auto Checkout to at Step 2");
		mydocs.getMyDocs().click();
		test.log(LogStatus.PASS,"5.	Go to My doc");
		mydocs.getCheckOutByMe().click();
		test.log(LogStatus.PASS,"6.	Click on Checked out to me link ");
		
		
		if(mydocs.firstDocumentID()==true)
		{
			test.log(LogStatus.PASS,"<b>ER2: Document should get reflected in checkout to me section. <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Document visible in check out by me")));
		}
		else
		{
			test.log(LogStatus.FAIL,"<b>ER2: Failed, unable to find document in checkout by me. <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Document is not visible in check out by me")));
		}
		
		logout.logoutFunction();
		test.log(LogStatus.PASS,"7.	Logout");
		login.loginUser(loginData[4][0], loginData[4][1]);
		sleep(1);
		test.log(LogStatus.PASS,"8.	Login with the test user");
		
	}

	@AfterClass
	public void afterClass()
	{
		extent.endTest(test);
		driver.close();
	}

}
