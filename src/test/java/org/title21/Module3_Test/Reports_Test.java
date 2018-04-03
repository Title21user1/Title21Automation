package org.title21.Module3_Test;

import org.testng.annotations.Test;
import org.title21.Module3_POM.Reports_POM;
import org.title21.POM.AdministrationPage_POM;
import org.title21.POM.LoginPage_POM;
import org.title21.POM.LogoutPage_POM;
import org.title21.utility.BaseClass;
import org.title21.utility.FileUpload;
import org.title21.utility.FunctionUtils;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

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
	String uploadFileName = "CrystalReport.rpt";
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
		reports = new Reports_POM(driver);
		adminpage=new AdministrationPage_POM(driver);
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test
	public void Reports()
	{
		test = extent.startTest("Reports");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		login.loginUser(loginData[13][0],loginData[13][1]);
		reports.reports().click();												sleep(2);
		logout.getAdmindropdown().click();										sleep(2);
		adminpage.administrationLink().click();									sleep(2);
		verticalScrollingDown();												sleep(1);
		reports.adminReports().click();											sleep(2);
		verticalScrollingUp();													sleep(1);
		reports.addReports().click();											sleep(3);
		reports.addButton().click();											sleep(5);
		
		if (reports.verifyReportNameValidationMessage()==true) 
		{
			
		}
		else
		{

		}
		
		if (reports.verifySelectFileValidationMessage()==true) 
		{
			
		}
		else 
		{

		}
		
		if (reports.verifyCategoryReportValidationMessage()==true) 
		{
			
		}
		else 
		{

		}
		
		reports.reportName().sendKeys(reportName);								sleep(1);
		reports.browse().click();												sleep(2);
		
		fileUploadPath = System.getProperty("user.dir") + "\\testdata";
		fileUploadPath = fileUploadPath + "\\" + uploadFileName;
		FileUpload.uploadFile(fileUploadPath);									sleep(3);
		
		reports.category().selectByVisibleText("Feedback");						sleep(2);
		reports.addButton().click();											sleep(7);
		
		if (reports.verifyDesignPermissionValidationMessage()==true) 
		{
			
		}
		else 
		{

		}
		
		reports.permissionTab().click();										sleep(2);
		reports.checkUseDesignForGroup("Sp Tester");							sleep(2);
		reports.checkUseForGroup("Quality Control");							sleep(2);
		reports.addButton().click();											sleep(7);
		reports.closeButton().click();											sleep(2);
		sleep(10);
	}
	
	@AfterClass
	public void afterClass()
	{
		extent.endTest(test);
		driver.close();
	}

}
