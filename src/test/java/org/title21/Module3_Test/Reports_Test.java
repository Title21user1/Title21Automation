package org.title21.Module3_Test;

import org.testng.annotations.Test;
import org.title21.AdminModule_POM.AdministrationPage_POM;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.Module3_POM.Reports_POM;
import org.title21.utility.BaseClass;
import org.title21.utility.FunctionUtils;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.AfterClass;

public class Reports_Test extends BaseClass
{
	LoginPage_POM login; 
	LogoutPage_POM logout;
	Reports_POM reports;
	AdministrationPage_POM adminpage;
	String reportName="Report Test "+FunctionUtils.generateRandomNumber();
	String className="";
	String fileUploadPath = "";
	String uploadFileName = "CrystalReport2.rpt";
	String testcaseName="TestCase-WIA-Reports.docx";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;

	@BeforeClass(alwaysRun=true)
	public void beforeClass()
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		login=new LoginPage_POM(driver);
		logout=new LogoutPage_POM(driver);
		reports = new Reports_POM(driver);
		adminpage=new AdministrationPage_POM(driver);
	}

	@Test(testName = "Reports", groups = "Module3", priority = 0)
	public void Reports()
	{
		test = extent.startTest("Reports");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		login.loginUser(loginData[13][0],loginData[13][1]);
		
		test.log(LogStatus.PASS,"1.	Navigate to Dashboard.");
		
		reports.reports().click();												sleep(2);
		
		test.log(LogStatus.PASS,"2.	Click on the Reports menu from the dashboard to view a list of reports available for the user.");
		test.log(LogStatus.PASS,"<b>ER1: A list of reports available is displayed.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "List of Reports")));
		
		logout.getAdmindropdown().click();										sleep(2);
		adminpage.administrationLink().click();									sleep(2);
		
		test.log(LogStatus.PASS,"3.	Go to the administration page.");
		
		verticalScrollingDown();												sleep(1);
		
		test.log(LogStatus.PASS,"4.	Click on Reports.");
		
		reports.adminReports().click();											sleep(2);
		verticalScrollingUp();													sleep(1);
		
		test.log(LogStatus.PASS,"5.	Click on add new reports.");
		
		reports.addReports().click();											sleep(3);
		
		test.log(LogStatus.PASS,"<b>ER2: Add Report dialog is displayed.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Add Reports")));
		
		test.log(LogStatus.PASS,"6.	Click on add button.");
		
		reports.addButton().click();											sleep(5);
		
		test.log(LogStatus.PASS,"<b>ER3: Report name is required, Please select report and "
				+ "Category is required validation messages are displayed<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Add Reports")));
		

		reports.reportName().sendKeys(reportName);								sleep(2);
		
		test.log(LogStatus.PASS,"7.	Enter report name.");
		
		test.log(LogStatus.PASS,"8.	Click on choose file button and Upload crystal report(.rpt extension report).");
		
		reports.fileupload(uploadFileName);										sleep(3);

		reports.category().selectByVisibleText("Feedback");						sleep(2);
		
		test.log(LogStatus.PASS,"9.	Enter Description.");
		test.log(LogStatus.PASS,"10. Select category from the drop-down.");
		test.log(LogStatus.PASS,"11. Click on add button.");
		
		reports.addButton().click();											sleep(3);
		reports.addButton().click();											sleep(15);
		reports.permissionTab().click();										sleep(2);
	
		if (reports.verifyDesignPermissionValidationMessage()==true) 
		{
			test.log(LogStatus.PASS,"<b>ER4: 'Please select at least one permission' validation message is displayed..<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Permission Validation")));
		}
		else 
		{
			test.log(LogStatus.FAIL,"<b>ER4: 'Validation message is not displayed..<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Permission Validation")));
		}
		
		test.log(LogStatus.PASS,"12. Check use and design checkboxes for one of the groups, "
				+ "(for eg. Admin) and only USE permissions for another group.");

		reports.checkUseDesignForGroup("Sp Tester");							sleep(2);
		reports.checkUseForGroup("Quality Control");							sleep(2);
		
		test.log(LogStatus.PASS,"<b>ER5: Checkboxes are checked.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Checkboxes Checked")));

		reports.generalTab().click();											sleep(2);
		reports.fileupload(uploadFileName);										sleep(3);

		test.log(LogStatus.PASS,"13. Click on add button.");
		
		reports.addButton().click();											sleep(20);
		
		test.log(LogStatus.PASS,"<b>ER6: A successful message for the newly added report is displayed..<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Report Added")));
		test.log(LogStatus.PASS,"14. Click on close button.");
		
		reports.closeButton().click();											sleep(2);
		
		logout.logoutFunction();
		login.loginUser(loginData[1][0],loginData[1][1]);
		
		test.log(LogStatus.PASS,"15. Logout and login with the user who belongs to the group with only USE in step (12).");
		test.log(LogStatus.PASS,"16. Go to dashboard.");
		
		reports.reports().click();												sleep(2);
		
		test.log(LogStatus.PASS,"17. Navigate to report page.");
		
		reports.Search(reportName);												sleep(2);
		
		test.log(LogStatus.PASS,"18. Enter the report name created in step (13) in the search filter.");
		test.log(LogStatus.PASS,"19. Click on the go button.");
		
		test.log(LogStatus.PASS,"<b>ER7: The newly created report entry is displayed.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Report Listed")));
		
		test.log(LogStatus.PASS,"20. Click on report link.");
		
		reports.clickOnReport(reportName);										sleep(7);
		
		test.log(LogStatus.PASS,"<b>ER8: The crystal report uploaded is displayed.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Report Displayed")));
		
		logout.logoutFunction();
		login.loginUser(loginData[6][0],loginData[6][1]);
		
		test.log(LogStatus.PASS,"22. Log in with the user who belongs to a group with "
				+ "USE and DESIGN permissions in step (12) and has a system or local admin rights.");
		
		logout.getAdmindropdown().click();										sleep(2);
		adminpage.administrationLink().click();									sleep(2);
		
		test.log(LogStatus.PASS,"23. Go to the administration page.");
		
		verticalScrollingDown();												sleep(1);
		reports.adminReports().click();											sleep(2);
		
		test.log(LogStatus.PASS,"24. Click on Reports.");
		
		verticalScrollingUp();													sleep(1);
		reports.Search("Documents Approaching Review by Author");				sleep(3);
		reports.editButton().click();											sleep(3);
		
		test.log(LogStatus.PASS,"25. Click on the edit button of the report other than report for "
				+ "which the use only has USE permissions (13).");
		
		if (reports.verifyEditPermissionValidationMessage()==true) 
		{
			test.log(LogStatus.PASS,"<b>ER9: Validation message "
					+ "'User must be a member of group with design permission to access this functionality' is displayed.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Design Permission Validation")));
		}
		else 
		{
			test.log(LogStatus.FAIL,"<b>ER9: Validation message is not displayed.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Design Permission Validation")));
		}
		
		test.log(LogStatus.PASS,"26. Click on close button.");
		
		reports.closeButton().click();											sleep(3);
		reports.clearButton().click();											sleep(3);
		
		reports.Search(reportName);												sleep(4);
		
		test.log(LogStatus.PASS,"27. Edit the report created in step (13).");
		
		reports.editButton().click();											sleep(15);
		
		test.log(LogStatus.PASS,"<b>ER10: Update Report popup screen is displayed.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Update Report")));
		test.log(LogStatus.PASS,"28. Click on permission tab.");
		
		reports.permissionTab().click();										sleep(2);
		
		test.log(LogStatus.PASS,"29. Uncheck the group permission checkboxes use in step (12).");
		
		reports.uncheckUseDesignForGroup("Sp Tester");							sleep(3);
		reports.checkDesignForGroup("Quality Control");							sleep(3);
		
		test.log(LogStatus.PASS,"<b>ER11: Checkboxes are unchecked.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Checboxes Unchecked")));
		
		reports.updateButton().click();											sleep(25);
		
		test.log(LogStatus.PASS,"30. Click on the update button.");
		test.log(LogStatus.PASS,"<b>ER12: A message confirming successful update of the report is displayed.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Successfully Updated")));
		
		reports.closeButton().click();											sleep(3);
		
		reports.editButton().click();											sleep(3);
		
		test.log(LogStatus.PASS,"31. Click on close button");
		test.log(LogStatus.PASS,"32. Search for a report created in step (13).");
		test.log(LogStatus.PASS,"33. Click on the edit button");
		
		if (reports.verifyEditPermissionValidationMessage()==true) 
		{
			test.log(LogStatus.PASS,"<b>ER13: User is not allowed to edit the report.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Unable To Edit")));
		}
		else 
		{
			test.log(LogStatus.FAIL,"<b>ER13: No Message is Displayed<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Unable To Edit")));
		}
		
		reports.closeButton().click();											sleep(3);
		reports.deleteReport().click();											sleep(3);
		
		test.log(LogStatus.PASS,"34. Click on delete button.");
		
		if (reports.verifyDeletePermissionValidationMessage()==true) 
		{
			test.log(LogStatus.PASS,"<b>ER14: User is not allowed to delete the report.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Unable To Delete")));
		}
		else 
		{
			test.log(LogStatus.FAIL,"<b>ER14: User is able to delete the report.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Able To Delete")));
		}
		
		reports.closeButton().click();											sleep(3);
		logout.logoutFunction();
	}

	@AfterClass(alwaysRun=true)
	public void afterClass()
	{
		extent.endTest(test);
		driver.quit();
	}

}
