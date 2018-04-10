package org.title21.Module3_Test;

import org.testng.annotations.Test;
import org.title21.AdminModule_POM.AdministrationPage_POM;
import org.title21.AdminModule_POM.DashBord_POM;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.Module3_POM.eBinders_POM;
import org.title21.utility.BaseClass;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.annotations.BeforeClass;
import java.util.concurrent.TimeUnit;
import org.testng.annotations.AfterClass;


public class eBinders_Test extends BaseClass
{
	LoginPage_POM login; 
	LogoutPage_POM logout;
	eBinders_POM ebinder;
	AdministrationPage_POM adminpage;
	DashBord_POM dashboard;
	String ebinderName="eBinder Test";
	String ebinderRoot="Test";
	String docID = "SOP.07";
	String className="";
	String testcaseName="TestCase-WIA-eBinders.doc";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;

	@BeforeClass
	public void beforeClass()
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		login=new LoginPage_POM(driver);
		logout=new LogoutPage_POM(driver);
		adminpage=new AdministrationPage_POM(driver);
		dashboard=new DashBord_POM(driver);
		ebinder=new eBinders_POM(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}

	@Test
	public void eBinders()
	{
		test = extent.startTest("eBinders");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		login.loginUser(loginData[10][0],loginData[10][1]);
		ebinder.getEbinders().click();											sleep(2);

		test.log(LogStatus.PASS,"1. Click on the eBinders tab.");

		ebinder.expandAllEbinders();

		test.log(LogStatus.PASS,"2. Click to expand them");
		test.log(LogStatus.PASS,"<b>ER1: List of binders available are displayed and available branches are visible on expanding<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Expanded EBinders")));


		ebinder.selectEbinder("All Drafts");									sleep(3);

		test.log(LogStatus.PASS,"3. Click on one of the organizers to view a list of documents available within it");
		test.log(LogStatus.PASS,"<b>ER2: A list of the document available within the organizer is displayed<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Selected EBinders")));

		logout.logoutFunction();
		test.log(LogStatus.PASS,"4. Logout from the test user");
		login.loginUser(loginData[7][0],loginData[7][1]);						sleep(2);
		test.log(LogStatus.PASS,"5.	Login with admin user");
		logout.getAdmindropdown().click();										sleep(2);
		adminpage.administrationLink().click();									sleep(2);
		test.log(LogStatus.PASS,"6.	Go to administration page");
		verticalScrollingDown();												sleep(1);
		ebinder.adminEbinders().click();										sleep(2);

		test.log(LogStatus.PASS,"7.	Click on e-Binder");

		verticalScrollingUp();													sleep(1);

		test.log(LogStatus.PASS,"<b>ER3: A List of eBinders available are displayed<b>"+
				test.addScreenCapture(captureScreenShot(driver, "List of EBinders")));

		ebinder.addEbinders().click();											sleep(2);

		test.log(LogStatus.PASS,"8. Click on add eBinder button.");
		test.log(LogStatus.PASS,"<b>ER4: Add eBinder popup screen is displayed.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Add Ebinder Popup")));

		ebinder.ebinderNameText().sendKeys(ebinderName);
		test.log(LogStatus.PASS,"9. Enter name");

		ebinder.ebinderGroup().selectByVisibleText("Administrators");			sleep(1);
		test.log(LogStatus.PASS,"10. Enter group");

		ebinder.addButton().click();											sleep(2);

		test.log(LogStatus.PASS,"11. Click on add button");
		test.log(LogStatus.PASS,"<b>ER5: A message confirming eBinder successful added is displayed.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "eBinder added successfully")));

		ebinder.closeButton().click();											sleep(2);
		test.log(LogStatus.PASS,"12. Click on close button");

		ebinder.selectEbinder(ebinderName);										sleep(1);
		ebinder.addRootFolder().click();										sleep(2);

		test.log(LogStatus.PASS,"13. Click on the newly added binder and click on add root folder.");
		test.log(LogStatus.PASS,"<b>ER6: Add Root Folder popup screen is displayed.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Root Folder Popup")));


		ebinder.rootFolderName().sendKeys(ebinderRoot);							sleep(1);
		ebinder.addButton().click();											sleep(2);

		test.log(LogStatus.PASS,"14. Enter the name and click on add button.");
		test.log(LogStatus.PASS,"<b>ER7: A message confirming Root folder successful added is displayed<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Root Folder added successfully")));

		ebinder.closeButton().click();											sleep(2);

		test.log(LogStatus.PASS,"15. Click on close.");
		test.log(LogStatus.PASS,"<b>ER8: The created eBinder record is displayed<b>"+
				test.addScreenCapture(captureScreenShot(driver, "eBinder record created")));

		ebinder.selectEbinder(ebinderName);										sleep(2);

		test.log(LogStatus.PASS,"16. Click on ebinder");
		test.log(LogStatus.PASS,"<b>ER9: The permission page for selected ebinder is displayed<b>"+
				test.addScreenCapture(captureScreenShot(driver, "eBinder Permisson page")));

		ebinder.location().selectByVisibleText("San Francisco");				sleep(1);
		test.log(LogStatus.PASS,"17. Select location from location drop-down.");

		ebinder.checkUseForGroup("Sp Tester");									sleep(2);
		test.log(LogStatus.PASS,"18. Select the group whom you want to give permission.");
		test.log(LogStatus.PASS,"19. Check the Use checkbox"+
				test.addScreenCapture(captureScreenShot(driver, "Use Checkbox")));

		ebinder.selectEbinder(ebinderRoot);										sleep(2);
		test.log(LogStatus.PASS,"20. Click on the root folder");

		ebinder.selectQueryText().sendKeys("LabSOPs");							sleep(2);
		test.log(LogStatus.PASS,"21. Enter a query in the select query text box"+
				test.addScreenCapture(captureScreenShot(driver, "Select Query")));

		ebinder.verifyButton().click();											sleep(2);
		test.log(LogStatus.PASS,"22. Click on verify.");

		horizontalScrollingToRight();											sleep(2);

		logout.logoutFunction();
		test.log(LogStatus.PASS,"23. Logout with admin user");

		login.loginUser(loginData[10][0],loginData[10][1]);
		test.log(LogStatus.PASS,"24. Login with test user belongs to the group from step 18");

		ebinder.getEbinders().click();											sleep(2);
		test.log(LogStatus.PASS,"25. Go to eBinder");

		ebinder.expandAllEbinders();
		ebinder.expandEbinder(ebinderName);
		ebinder.selectEbinder(ebinderRoot);
		test.log(LogStatus.PASS,"<b>E10: EBinder is present in the eBinder section.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "eBinder present")));

		ebinder.setFavourites(docID);											sleep(2);
		test.log(LogStatus.PASS,"26. Click on the star icon for any of the documents/events listed within the organizer");
		test.log(LogStatus.PASS,"<b>E11: The star icon is highlighted to indicate that the event has been added to favorites<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Favorite Set")));

		dashboard.toDashboard().click();										sleep(3);

		if (ebinder.verifyDocumentPresentInFavorites(docID)==true)
		{
			test.log(LogStatus.PASS,"<b>ER12: The document/event added to Favorites from the binder is available in the Favorites list <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Document Available in Favorites")));
		}
		else if (ebinder.verifyDocumentPresentInFavorites(docID)==false)
		{
			test.log(LogStatus.FAIL,"<b>ER12: Document unavailable in favorites <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Document Unavailable in Favorites")));
		}

		ebinder.unsetFavorites();
		logout.logoutFunction();

		sleep(10);
	}

	@AfterClass
	public void afterClass()
	{
		tearDown();
		extent.endTest(test);
		driver.close();
	}

	public void tearDown()
	{
		login.loginUser(loginData[7][0],loginData[7][1]);						sleep(2);
		logout.getAdmindropdown().click();										sleep(1);
		adminpage.administrationLink().click();									sleep(1);
		verticalScrollingDown();												sleep(1);
		ebinder.adminEbinders().click();										sleep(2);
		verticalScrollingUp();													sleep(1);
		ebinder.selectEbinder(ebinderName);										sleep(2);
		ebinder.deleteButton().click();											sleep(2);
		ebinder.yesButton().click();											sleep(2);
		ebinder.closeButton().click();											sleep(2);
		logout.logoutFunction();
	}

}
