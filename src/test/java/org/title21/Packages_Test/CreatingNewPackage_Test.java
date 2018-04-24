package org.title21.Packages_Test;


import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Sleeper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.AdminModule_POM.Table;
import org.title21.DBConnection.DBConnection;
import org.title21.DBConnection.DBQueries;
import org.title21.Packages_POM.CreatingNewPackage_POM;
import org.title21.dao.AdminData;
import org.title21.utility.BaseClass;
import org.title21.utility.DateTimeUtils;

import com.gargoylesoftware.htmlunit.javascript.host.dom.Text;
import com.relevantcodes.extentreports.LogStatus;

public class CreatingNewPackage_Test extends BaseClass{
	LoginPage_POM login;
	LogoutPage_POM logout;
	CreatingNewPackage_POM creatingNewPackage;
	static Logger log = Logger.getLogger(CreatingNewPackage_Test.class);
	String className="";
	String packageNo="";
	String fileUploadPath="";
	String uploadFileName="FileToUpload.txt";
	Table searchTable;
	DBQueries dbqueries;
	AdminData adminData=new AdminData();
	String testcaseName="TestCase-WIA-Creating_new_package.docx";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;

	@BeforeClass
	public void openURL() 
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		dbqueries = new DBQueries();
		logout=new LogoutPage_POM(driver);
		login=new LoginPage_POM(driver);
		login.loginUser(loginData[7][0], loginData[7][1]);
	}

	@Test(testName = "CreatingNewPackage", groups = "Packages", priority = 0)
	public void DocumentRoutes() throws Exception
	{		
		test = extent.startTest("Creating New Package");
		test.log(LogStatus.PASS, "1.Login to the web interface.");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		creatingNewPackage=new CreatingNewPackage_POM(driver);	
		
		test.log(LogStatus.PASS, "2.Disable permission for 'Prohibit user attaching Archived Document'.");
		DBConnection.executeStoredProcedure(dbqueries.disablePermissionProhibitUserAttachingArchivedDoc);
		
		test.log(LogStatus.PASS, "3.Disable permission for “Prohibit user attaching Released Document”.");
		DBConnection.executeStoredProcedure(dbqueries.disablePermissionProhibitUserAttachingReleasedDoc);
		
		test.log(LogStatus.PASS, "4.Click on the new and select package.");
		creatingNewPackage.getnewdoc().click();
		sleep(2);
		creatingNewPackage.package_Link().click();
		sleep(3);
		
		if(creatingNewPackage.verifyCreateNewPackagePopUpText())
		{
			test.log(LogStatus.PASS, "<b>ER1- Create new Package screen will appear.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Create new Package screen")));
		}
		else
		{
			test.log(LogStatus.FAIL, "<b>Uable to find the create new Package screen will appear.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Create new Package screen")));
		}
		
		packageNo = creatingNewPackage.package_No().getAttribute("value");
		
		test.log(LogStatus.PASS, "5.Select Cabinet and Section from the dropdown list.");
		creatingNewPackage.cabinet_DropDown().selectByVisibleText("Change Control Initiation");
		creatingNewPackage.cabinetSection_DropDown().selectByVisibleText("Initiation");
		
		test.log(LogStatus.PASS, "6.Add Package Name.");
		creatingNewPackage.packageName_TextBox().sendKeys("NeoTest");
		
		test.log(LogStatus.PASS, "7.Click on 'Create'.");
		creatingNewPackage.create_Button().click();
		sleep(3);
		
		if(creatingNewPackage.verifyPackageScreen())
		{
			test.log(LogStatus.PASS, "<b>ER2- Package screen will appear.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Package screen")));
		}
		else
		{
			test.log(LogStatus.FAIL, "<b>Unable to find the Package screen.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Package screen")));
		}
		
		test.log(LogStatus.PASS, "8.Ensure the Package is open in edit mode.");
		test.log(LogStatus.PASS, "9.Add an Author and Reason for change (if not already added).");
		creatingNewPackage.ChangeReason_TextBox().sendKeys("Testing");
		sleep(2);
		
		test.log(LogStatus.PASS, "10.Navigate to My Docs > Packages.");
		creatingNewPackage.myDocs_Tab().click();
		sleep(3);
		creatingNewPackage.packages_Link().click();
		sleep(3);
		
		creatingNewPackage.packageFilter_TextBox().sendKeys(packageNo);
		creatingNewPackage.packageFilterGo_Button().click();
		sleep(2);
		
		if(creatingNewPackage.filteredPackage_Result().getText().contains(packageNo))
		{
			test.log(LogStatus.PASS, "<b>ER3- Newly created package is present.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Newly created package")));
			
			test.log(LogStatus.PASS, "11.Open Package.");
			creatingNewPackage.filteredPackage_Result().click();
			sleep(2);
			
			test.log(LogStatus.PASS, "12.Ensure the Package is open in edit mode.");
			verticalScrollingDown();
			
			test.log(LogStatus.PASS, "13.Click on 'Add/Remove' link available in documents frame.");
			creatingNewPackage.addRemove_LinkText().click();			
			
			if(creatingNewPackage.verifyAttachDocScreen())
			{
				test.log(LogStatus.PASS, "<b>ER4- Attach documents screen will appear.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Attach documents screen")));
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find the attach documents screen.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Attach documents screen")));
			}
			
			test.log(LogStatus.PASS, "14.Select Status: Open, Created between (e.g. a month before current date and current date), Type: Document and Location: ALL");
			creatingNewPackage.selectStatus_DoropDown().selectByVisibleText("Open");
			sleep(2);
			creatingNewPackage.andDate_Box().click();
			creatingNewPackage.current_Date().click();
			sleep(2);
			creatingNewPackage.type_DropDown().selectByVisibleText("Document");
			sleep(2);
			creatingNewPackage.location_DropDown().selectByVisibleText("Select all");
			sleep(2);
			
			//write dynamic logic for the selection for effective doc bcoz some doc are disabled 
			test.log(LogStatus.PASS, "15.Select one or more Draft documents.");
			creatingNewPackage.filteredPackage_Result().click();
			
			test.log(LogStatus.PASS, "16.Click on 'OK'.");
			javaScriptClick(creatingNewPackage.create_Button());
			sleep(2);
			verticalScrollingDown();
			sleep(2);
			
			if(creatingNewPackage.docAddedIn_DocSection().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER5- Selected documents appear in the document frame.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Selected documents")));
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find the selected documents appear in the document frame.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Selected documents")));
			}
			
			test.log(LogStatus.PASS, "17.On Package screen add a 'Target Release Date'.");
			verticalScrollingUp();
			sleep(2);
			
			//need clarification about Target Release Date
			
			String targetReleaseDate=DateTimeUtils.getTomorrowDate();
			String finalDate=targetReleaseDate.substring(3, 5);
			creatingNewPackage.targetReleaseDate_TextBox().click();
			driver.findElement(By.xpath("//*[text()='"+finalDate+"']")).click();
			
			if(creatingNewPackage.verifyUpdateAttachedDocPopUp())
			{
				test.log(LogStatus.PASS, "<b>ER6- Update attached document(s) (non-obsoleted only) to this Release Date? Pop up message is displayed.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Update attached document")));
				
				test.log(LogStatus.PASS, "18.Click on “Yes”.");
				creatingNewPackage.yes_Button().click();
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find the update attached document(s) (non-obsoleted only) to this Release Date? Pop up message.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Update attached document")));
			}
			
			if(creatingNewPackage.verifyMsgPopUpHeader())
			{
				test.log(LogStatus.PASS, "<b>ER7- 'No obsolete documents to update' Pop up message appears.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "No obsolete documents")));
				
				test.log(LogStatus.PASS, "19.Click on 'Close'.");
				creatingNewPackage.close_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.PASS, "<b>Unable to find the 'No obsolete documents to update' Pop up message.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "No obsolete documents")));
			}
			
			test.log(LogStatus.PASS, "20.In the web interface, click on 'Add/Remove' link available in the document's frame.");
			verticalScrollingDown();
			sleep(2);
			creatingNewPackage.addRemove_LinkText().click();
			
			test.log(LogStatus.PASS, "21.Select Status: Open, Created between (e.g. a month before current date and current date), Type: Document and Location: ALL");
			creatingNewPackage.selectStatus_DoropDown().selectByVisibleText("Open");
			sleep(2);
			creatingNewPackage.andDate_Box().click();
			creatingNewPackage.current_Date().click();
			sleep(2);
			creatingNewPackage.type_DropDown().selectByVisibleText("Document");
			sleep(2);
			creatingNewPackage.location_DropDown().selectByVisibleText("Select all");
			sleep(2);
			
			test.log(LogStatus.PASS, "22.Enter effective in the search field and click on go button");
			creatingNewPackage.attachedDocFilterResult_TextBox().sendKeys("Effective");
			creatingNewPackage.attachedDocFilterResultGo_Button().click();
			sleep(2);
			
			test.log(LogStatus.PASS, "23.Select Effective documents.");
			//write dynamic logic for the selection for effective doc bcoz some doc are disabled 
			creatingNewPackage.filteredPackage_Result().click();
			
			test.log(LogStatus.PASS, "24.Click on 'OK'.");
			javaScriptClick(creatingNewPackage.create_Button());
			sleep(2);
			
			/*if()
			{
				ER 8 –Added documents appear in the document frame.
			}
			else
			{
				
			}*/
			
			
			
		}
		else
		{
			test.log(LogStatus.FAIL, "<b>Unable to find the newly created package.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Newly created package")));
		}
		
		
		
		
		
		
		
		
		
	}

	@AfterClass
	public void closeBrowserInstance()
	{	
		logout.logoutFunction();
		extent.endTest(test);
		driver.close();
	}

}
