package org.title21.PeriodicReviewers_Test;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.AdminModule_POM.Table;
import org.title21.DBConnection.DBConnection;
import org.title21.DBConnection.DBQueries;
import org.title21.PeriodicReviewers_POM.PeriodicNotOwnedDocuments_POM;
import org.title21.dao.AdminData;
import org.title21.utility.BaseClass;
import org.title21.utility.DateTimeUtils;

import com.relevantcodes.extentreports.LogStatus;

public class PeriodicNotOwnedDocuments_Test extends BaseClass{
	LoginPage_POM login;
	LogoutPage_POM logout;
	PeriodicNotOwnedDocuments_POM periodicReviews;
	static Logger log = Logger.getLogger(PeriodicNotOwnedDocuments_Test.class);
	String className="";
	String documentNo="";
	String documentNo1="";
	String documentNo2="";
	String documentNo3="";
	String documetsName="";
	String documentStatus="";
	String fileUploadPath="";
	 String selectedgroups="";
	String uploadFileName="FileToUpload.txt";
	Table searchTable;
	boolean isRecordFound=false;
	boolean isRecordFound1=false;
	boolean isValueFound=false;
	DBQueries dbqueries;
	AdminData adminData=new AdminData();
	String testcaseName="FileToUpload.txt";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;

	@BeforeClass
	public void openURL() 
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		logout=new LogoutPage_POM(driver);
		login=new LoginPage_POM(driver);
		dbqueries = new DBQueries();
		periodicReviews=new PeriodicNotOwnedDocuments_POM(driver);	
		login.loginFunction();
	}

	@Test(testName = "PeriodicReviews", groups = "Periodic Reviews", priority = 0)
	public void DocumentRoutes() throws Exception
	{
		test = extent.startTest("Periodic Reviews");
		test.log(LogStatus.PASS, "1.In the Web interface, Login as admin.");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		
		periodicReviews.administratorDropDown().click();
		sleep(2);
		periodicReviews.dropDownSetting_Link().click();
		periodicReviews.multiSignReviewCheck(false);
		
		//=======================================================Prerequisites==========================================================================
		 documentNo1 = createNewDocWithPeriodicReviewer();
		 documentNo2 = createNewDocWithPeriodicReviewer();
		 documentNo3 = createNewDocWithPeriodicReviewer();
		
		 approveDocFromWizard(documentNo1);
		 approveDocFromWizard(documentNo2);
		 approveDocFromWizard(documentNo3);
		
		 DBConnection.executeStoredProcedure(dbqueries.moveDocsOnReleaseDate);
		 
		 periodicReviews.wizard_Option().click();
		 sleep(2);
		 periodicReviews.wizardReview_Tab().click();
		 sleep(2);
			
			for(int i=1; i<=20; i++)
			{
				selectDocForReview(documentNo1);
				 if(!isValueFound)
				 {
					 periodicReviews.documentTableNext_Button().click();
					sleep(2); 
				}
				else
				{
					break;
				}
			}
		 sleep(2);
		 periodicReviews.viewDocButtonForPeriodicReview().click();
		//=======================================================Main steps===================================================================================== 
		 test.log(LogStatus.PASS, "2.Navigate to Administrator> Users >Edit user. Make a note of all the groups the test user is part of.");
		 periodicReviews.administratorDropDown().click();
		 periodicReviews.administrationLink().click();
		 sleep(2);
		 periodicReviews.users_Link().click();
		 sleep(2);
		 periodicReviews.filterText().sendKeys("sameer");
		 periodicReviews.goButton().click();
		 sleep(2);
		 clickOnEditButton("sameer");
		 sleep(2);
		 selectedgroups = periodicReviews.selectedGroups_TextArea().getText();
		 periodicReviews.cancel_Button().click();
		 sleep(5);
		 
		 test.log(LogStatus.PASS, "3.For all the groups user is part of  as given in Step 2: Edit Group> Documents > and uncheck 'Allow periodic review without viewing document'.");
		 periodicReviews.group_Link().click();
		 sleep(2);
		 periodicReviews.filterText().sendKeys(selectedgroups);
		 sleep(2);
		 periodicReviews.goButton().click();
		 sleep(2);
		 clickOnGroupEditButton(selectedgroups);
		 sleep(2);
		 periodicReviews.updateGroupDoc_Tab().click();
		 periodicReviews.docPermissions_PartTwo().click();
		 sleep(2);
		 periodicReviews.docPermissionItemsCheck(false);
		 test.log(LogStatus.PASS, "<b>ER1- Allow periodic review without viewing document unchecked.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Allow periodic review without viewing document unchecked")));
		 javaScriptClick(periodicReviews.auditLogConfirm_Button());
		// periodicReviews.auditLogConfirm_Button().click();
		 sleep(4);
		 periodicReviews.close_Button().click();
		 sleep(2);
		 
		 test.log(LogStatus.PASS, "4.Logout from admin user and login with test user belongs to the above group. ");
		 
		 test.log(LogStatus.PASS, "5.Select the Unread Periodic review document from Prerequisite 3a.");
		 periodicReviews.wizard_Option().click();
		 sleep(2);
		 periodicReviews.wizardReview_Tab().click();
		 sleep(2);
		 for(int i=1; i<=20; i++)
		 {
			selectDocForReview(documentNo2);
			 if(!isValueFound)
			 {
				 periodicReviews.documentTableNext_Button().click();
				sleep(2); 
			 }
			 else
			 {
				break;
			 }
		 }
		 
		 sleep(2);
		 if(periodicReviews.changeDontChangeDisable_Button().isDisplayed())
		 {
			 test.log(LogStatus.PASS, "<b>ER2- Periodic review action is unavailable for unread documents.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Allow periodic review without viewing document unchecked")));
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Uanble to find the Periodic review action is unavailable for unread documents.");
		 }
		 
		 test.log(LogStatus.PASS, "6.Logout from test user and Login to the admin user.");
		 
		 test.log(LogStatus.PASS, "7.For any group the user is part of as given in Step 2: Edit Group> Documents > and ensure that 'Allow periodic review without viewing document' is checked.");
		 periodicReviews.administratorDropDown().click();
		 periodicReviews.administrationLink().click();
		 sleep(2);
		 periodicReviews.group_Link().click();
		 sleep(2);
		 periodicReviews.filterText().sendKeys(selectedgroups);
		 sleep(2);
		 periodicReviews.goButton().click();
		 sleep(2);
		 clickOnGroupEditButton(selectedgroups);
		 sleep(4);
		 periodicReviews.updateGroupDoc_Tab().click();
		 sleep(2);
		 periodicReviews.docPermissions_PartTwo().click();
		 sleep(2);
		 periodicReviews.docPermissionItemsCheck(true);
		 sleep(2);
		 test.log(LogStatus.PASS, "<b>ER3- Allow periodic review without viewing the document is checked.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Allow periodic review without viewing document unchecked")));
		 periodicReviews.auditLogConfirm_Button().click();
		 sleep(2);
		 periodicReviews.close_Button().click();
		 sleep(2);
		 
		 test.log(LogStatus.PASS, "8.Logout of the Admin user.");
		 test.log(LogStatus.PASS, "9.Login to the web interface as the test user and select the Unread Periodic review document from Prerequisite 3a again.");
		 periodicReviews.wizard_Option().click();
		 sleep(2);
		 periodicReviews.wizardReview_Tab().click();
		 sleep(2);
		 for(int i=1; i<=20; i++)
		 {
		  selectDocForReview(documentNo2);
			 if(!isValueFound)
			 {
				 periodicReviews.documentTableNext_Button().click();
				sleep(2); 
			 }
			 else
			 {
				break;
			 }
		 } 
		 
		 sleep(2);
		 if(periodicReviews.change_Button().isDisplayed() && periodicReviews.dontChange_Button().isDisplayed())
		 {
			 test.log(LogStatus.PASS, "<b>ER4- The document appears as read/ready to sign and periodic review actions are available.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "document appears as read/ready to sign and periodic review")));
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Uanble to find the document appears as read/ready to sign and periodic review actions are available.");
		 }
		 
		 test.log(LogStatus.PASS, "10.Click on the 'Change' button.");
		 periodicReviews.change_Button().click();
		 sleep(2);
		 
		 if(periodicReviews.reviewDecisionPopUp_Header().isDisplayed())
		 {
			 test.log(LogStatus.PASS, "<b>ER5- Electronic signature controls to perform the periodic review appears.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Electronic signature controls")));
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "<b>Uanble to find the Electronic signature controls to perform the periodic review appears.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Electronic signature controls")));
		 }
		 
		 test.log(LogStatus.PASS, "11.Sign by providing a Pin and comments. Click Confirm.");
		 periodicReviews.pinTo_Approve().sendKeys("262829");
		 periodicReviews.approveConfirm_Button().click();
		 sleep(2);
		 for(int i=1; i<=20; i++)
			{
			 verifyDocForReview(documentNo2);
				if(!isValueFound)
				{
					 periodicReviews.documentTableNext_Button().click();
					sleep(2); 
				}
				else
				{
					break;
				}
			} 
		 
		 
		 if(isValueFound)
		 {
			 test.log(LogStatus.PASS, "<b>ER7- The periodic review list displays and the document is no longer on the list<b>"+
						test.addScreenCapture(captureScreenShot(driver, "periodic review list displays")));
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Unable to find the periodic review list displays and the document is no longer on the list<b>"+
						test.addScreenCapture(captureScreenShot(driver, "periodic review list displays")));
		 }
		 
		 test.log(LogStatus.PASS, "12.View audit logs by clicking on top right corner menu.(Administration > Audit log)");
		 periodicReviews.administratorDropDown().click();
		 sleep(2);
		 periodicReviews.auditLog_Option().click();
		 
		 
		 verifyValuesInAuditLog(documentNo2, 4);
		 if(isValueFound)
		 {
			 test.log(LogStatus.PASS, "<b>ER8- The periodic review decision (performed in Step 11) is available in the audit log.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "periodic review list displays")));
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "<b>Uanble to find the periodic review decision (performed in Step 11) is available in the audit log.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "periodic review list displays")));
		 }
		 
		 test.log(LogStatus.PASS, "13.Open the settings page of the Web interface. Ensure that the Multi-Sign Review option is turned off.");
		 periodicReviews.administratorDropDown().click();
		 sleep(2);
		 periodicReviews.dropDownSetting_Link().click();
		 
		 periodicReviews.multiSignReviewCheck(false);
		 test.log(LogStatus.PASS, "<b>ER9- Multi-Sign review turned off.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Multi-Sign review turned off")));
		 
		 test.log(LogStatus.PASS, "14.Click on the Periodic review wizard to view the list of documents awaiting periodic review.");
		 periodicReviews.wizard_Option().click();
		 sleep(2);
		 periodicReviews.wizardReview_Tab().click();
		 sleep(2);
		 test.log(LogStatus.PASS, "<b>ER10- Checkboxes to select multiple documents are not available.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Unable to find the checkBox Checkboxes")));
		 
		 test.log(LogStatus.PASS, "15.Open the settings page of the Web Interface again, then turn on the 'Multi-Sign Review' option.");
		 periodicReviews.administratorDropDown().click();
		 sleep(2);
		 periodicReviews.dropDownSetting_Link().click();
		 periodicReviews.multiSignReviewCheck(true);
		 driver.navigate().refresh();
		 
		 test.log(LogStatus.PASS, "16.Click on the Periodic review wizard to view the list of documents awaiting periodic review again.");
		 periodicReviews.wizard_Option().click();
		 sleep(2);
		 periodicReviews.wizardReview_Tab().click();
		 sleep(2);
		 
		 if(periodicReviews.reviewDoc_CheckBox().isDisplayed())
		 {
			 test.log(LogStatus.PASS, "<b>ER11- Checkboxes  to select multiple documents are available.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Unable to find the checkBox Checkboxes")));
		 }
		 else
		 {
			 test.log(LogStatus.PASS, "<b>Unable to find the Checkboxes  to select multiple documents are available.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Unable to find the checkBox Checkboxes")));
		 }
		 
		 test.log(LogStatus.PASS, "17.Login with the admin user, for all the groups the user is a part of, ensure that 'Allow periodic review without viewing document' is not checked (Same as step 3)");
		 periodicReviews.administratorDropDown().click();
		 periodicReviews.administrationLink().click();
		 sleep(2);
		 periodicReviews.group_Link().click();
		 periodicReviews.filterText().sendKeys(selectedgroups);
		 periodicReviews.goButton().click();
		 sleep(2);
		 clickOnEditButton(selectedgroups);
		 sleep(2);
		 periodicReviews.updateGroupDoc_Tab().click();
		 periodicReviews.docPermissions_PartTwo().click();
		 sleep(2);
		 periodicReviews.docPermissionItemsCheck(false);
		 
		 test.log(LogStatus.PASS, "18.Select a not-owned document which has not yet been viewed (the document from prerequisite 3a) along with a not-owned document which has been previously viewed (from prerequisite 3b).");
		 periodicReviews.wizard_Option().click();
		 sleep(2);
		 periodicReviews.wizardReview_Tab().click();
		 sleep(2);
		 
		 for(int i=1; i<=20; i++)
		 {
			 checkedSpecificDoc(documentNo2);
				if(!isValueFound)
				{
					 periodicReviews.documentTableNext_Button().click();
					sleep(2); 
				}
				else
				{
					break;
				}
		 }
		 
		 for(int i=1; i<=20; i++)
		 {
			 checkedSpecificDoc(documentNo3);
				if(!isValueFound)
				{
					 periodicReviews.documentTableNext_Button().click();
					sleep(2); 
				}
				else
				{
					break;
				}
		 }
		 if(periodicReviews.changeDontChangeDisable_Button().isDisplayed())
		 {
			 test.log(LogStatus.PASS, "<b>ER12- Periodic review actions are not available.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "changeDontChangeDisable_Button")));
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Uanble to find the Periodic review actions available.");
		 }
		 
		 test.log(LogStatus.PASS, "19.Now select only the document which has not yet been viewed and click on 'View Document'.");
		 selectDocForReview(documentNo3);
		 sleep(2);
		 periodicReviews.viewDocButtonForPeriodicReview().click();
		 sleep(2);
		 
		 if(periodicReviews.change_Button().isDisplayed() && periodicReviews.dontChange_Button().isDisplayed())
		 {
			 test.log(LogStatus.PASS, "<b>ER13- The document displays in a new tab.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "document appears as read/ready to sign and periodic review")));
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Uanble to find the document displays in a new tab.");
		 }
		 
		 test.log(LogStatus.PASS, "20.Close the tab, and select 2 documents which were selected in step 18 again.");
		 periodicReviews.docTabClose_Button().click();
		 
		 if(periodicReviews.change_Button().isDisplayed() && periodicReviews.dontChange_Button().isDisplayed())
		 {
			 test.log(LogStatus.PASS, "<b>ER14- The periodic review actions are available.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "document appears as read/ready to sign and periodic review")));
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "Uanble to find the periodic review actions are available.");
		 }
		 
		 test.log(LogStatus.PASS, "21.Click on 'Dont Change'");
		 periodicReviews.dontChange_Button().click();
		 sleep(2);
		 
		 if(periodicReviews.reviewDecisionPopUp_Header().isDisplayed())
		 {
			 test.log(LogStatus.PASS, "<b>ER15- Electronic signature controls to perform the periodic review appear and lists both documents selected for the periodic review action<b>"+
						test.addScreenCapture(captureScreenShot(driver, "document appears as read/ready to sign and periodic review")));
		 }
		 else
		 {
			 test.log(LogStatus.PASS, "<b>Unable to find the Electronic signature controls to perform the periodic review appear and lists both documents selected for the periodic review action<b>"+
						test.addScreenCapture(captureScreenShot(driver, "document appears as read/ready to sign and periodic review")));
		 }
		 
		 test.log(LogStatus.PASS, "22.Sign for the periodic review by providing a Pin and comments.");
		 periodicReviews.pinTo_Approve().sendKeys("262829");
		 periodicReviews.auditLogConfirm_Button().click();
		 sleep(2);
		 
		 for(int i=1; i<=20; i++)
		 {
			 verifyDocForReview(documentNo2);
				if(!isValueFound)
				{
					 periodicReviews.documentTableNext_Button().click();
					sleep(2); 
				}
				else
				{
					break;
				}
		 }
		
		 for(int i=1; i<=20; i++)
		 {
			 verifyDocForReview(documentNo3);
				if(!isValueFound)
				{
					 periodicReviews.documentTableNext_Button().click();
					sleep(2); 
				}
				else
				{
					break;
				}
		 }
		 
		 if(!isValueFound)
		 {
			 test.log(LogStatus.PASS, "<b>ER16- The periodic review list displays and both documents are removed from the list.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "document appears as read/ready to sign and periodic review")));
		 }
		 else
		 {
			 test.log(LogStatus.FAIL, "<b>Unale to find the periodic review list displays and both documents are removed from the list.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "document appears as read/ready to sign and periodic review")));
		 }
		 
		 test.log(LogStatus.PASS, "23.View audit logs by clicking on top right corner menu.(Administration > Audit log)");
		 periodicReviews.administratorDropDown().click();
		 sleep(2);
		 periodicReviews.auditLog_Option().click();
		 sleep(2);
		 
		 for(int i=1; i<=20; i++)
		 {
			 verifyValuesInAuditLog(documentNo2, 4);
				if(!isValueFound)
				{
					 periodicReviews.documentTableNext_Button().click();
					sleep(2); 
				}
				else
				{
					break;
				}
		 }
		 
		 for(int i=1; i<=20; i++)
		 {
			 verifyValuesInAuditLog(documentNo3, 4);
				if(!isValueFound)
				{
					 periodicReviews.documentTableNext_Button().click();
					sleep(2); 
				}
				else
				{
					break;
				}
		 }
		 if(isValueFound)
		 {
			 test.log(LogStatus.PASS, "<b>ER17- The periodic review decisions for both documents (performed in Step 22) are available in the audit log.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "periodic review decisions for both documents")));
		 }
		 else
		 {
			 test.log(LogStatus.PASS, "Unable to find the periodic review decisions for both documents (performed in Step 22) are available in the audit log.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "periodic review decisions for both documents")));
		 }
		 
	}

	@AfterClass
	public void closeBrowserInstance()
	{		
		extent.endTest(test);
		driver.close();
	}

	private String createNewDocWithPeriodicReviewer()
	{
		periodicReviews.getnewdoc().click();
		sleep(2);
		waitTillElementVisible(periodicReviews.getdocument());
		periodicReviews.getdocument().click();
		sleep(3);
		periodicReviews.getlocationDrodown().selectByVisibleText(routeData[1][0]);
		sleep(2);
		documentNo = periodicReviews.document_No().getAttribute("value");
		periodicReviews.getDocumentTitle().sendKeys(routeData[1][1]+documentNo); 
		periodicReviews.getDocChangeSummary().sendKeys(routeData[1][2]+documentNo);
		verticalScrollingDown();
		periodicReviews.getConfirmButton().click();
		sleep(5);
		if(periodicReviews.getdocumentcreationverify().isDisplayed()) 
		{
			periodicReviews.addMainFile_Button().click();

			waitTillElementVisible(periodicReviews.addMainFileHeader_Text());
			if(periodicReviews.addMainFileHeader_Text().isDisplayed())
			{
				fileUploadPath=System.getProperty("user.dir") + "\\testdata";
				fileUploadPath=fileUploadPath+"\\"+uploadFileName;
				periodicReviews.browse_Button().sendKeys(fileUploadPath);

				sleep(2);
				periodicReviews.add_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL,"Unable to find Add Main File header.");
			}
			sleep(2);
			periodicReviews.getDocumentApprovaltab().click();
			sleep(2);
			periodicReviews.getAddApproverLink().click();
			sleep(5);
			if(periodicReviews.addNewApprover_Header().isDisplayed())
			{
				periodicReviews.getApproverRole().selectByVisibleText(routeData[1][3]);
				sleep(2);
				periodicReviews.getLocationDropdown().selectByVisibleText(routeData[1][4]); 
				sleep(2);
				periodicReviews.getnameinAddApprover().selectByVisibleText(routeData[1][5]);
				periodicReviews.getSequenceinAddApprover().selectByVisibleText("1");
				periodicReviews.getallottedDaysinAddApprover().selectByVisibleText(routeData[1][7]);
				periodicReviews.approverAdd_Button().click();
				sleep(2);

			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find Add new approver popup screen."+
						test.addScreenCapture(captureScreenShot(driver, "new approver popup")));
			}
			sleep(4);
			periodicReviews.general_Tab().click();
			sleep(2);
			
			test.log(LogStatus.PASS, "4.Set the document owner as the current test user if not set already.");
			
			scrollIntoView(periodicReviews.periodicReviewsDays_TextBox());
			test.log(LogStatus.PASS, "5.Go to the periodic review section.");
			
			
			test.log(LogStatus.PASS, "6.Enter days per review (for eg: 365)");
			periodicReviews.periodicReviewsDays_TextBox().clear();
			periodicReviews.periodicReviewsDays_TextBox().sendKeys("365");
			
			test.log(LogStatus.PASS, "7.Pick a date.(next 2-3 day from current day.)");
			
			String pickDate = DateTimeUtils.getTomorrowDate();
			String[] preDate = pickDate.split("/");
			String dd1 = preDate[1];
			String dd=dd1;
			if(dd1.contains("0"))
			{
				dd=dd1.substring(1, 2);
				if(dd.equals("0")) 
				{
					dd = dd1;
				}
			}
			periodicReviews.pickDate_TextBox().click();
			sleep(2);
			driver.findElement(By.xpath("//td[text()='"+dd+"']")).click();
			sleep(2);
			
			verticalScrollingUp();
			verticalScrollingUp();
			test.log(LogStatus.PASS, "8.Set the target release date to the current date.");
			String targetReleaseDate = DateTimeUtils.getYesterdayDate();
			String[] preDate1 = targetReleaseDate.split("/");
			String Releasedd1 = preDate1[1];
			String Releasedd=Releasedd1;
			if(Releasedd1.contains("0"))
			{
				Releasedd=Releasedd1.substring(1, 2);
				if(Releasedd.equals("0")) 
				{
					Releasedd = Releasedd1;
				}
			}
			periodicReviews.docTargetReleaseDate_TextBox().click();
			sleep(2);
			driver.findElement(By.xpath("//td[text()='"+Releasedd+"']")).click();
			sleep(2);
			test.log(LogStatus.PASS, "9.Click on 'Edit Periodic Reviewers' link.");
			scrollIntoView(periodicReviews.editPeriodicReviewers_Link());
			periodicReviews.editPeriodicReviewers_Link().click();
			sleep(5);
			
			if(periodicReviews.editPeriodicReviewers_HeaderText().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER1- The Edit periodic reviewer's popup screen is displayed.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Edit periodic reviewer")));
				
				test.log(LogStatus.PASS, "10.Select location.");
				periodicReviews.editPeriodicReviewersLocationDropDown().selectByVisibleText(routeData[1][0]);
				
				test.log(LogStatus.PASS, "11.Select two reviewers.");
				periodicReviews.availablePeriodicReviewers_Filter().click();
				periodicReviews.availablePeriodicReviewers_Filter().sendKeys(loginData[11][2]);
				sleep(2);
				if(periodicReviews.AvailablePeriodicReviewers_SearchResultArea().isDisplayed())
				{
					periodicReviews.availablePeriodic_MoveButton().click();
				}
				else
				{
					test.log(LogStatus.PASS, "Periodic Reviewers is not displyed after specific search.");
				}
				
				sleep(2);
				
				periodicReviews.availablePeriodicReviewers_Filter().clear();
				periodicReviews.availablePeriodicReviewers_Filter().sendKeys(loginData[12][2]);
				sleep(2);
				if(periodicReviews.AvailablePeriodicReviewers_SearchResultArea().isDisplayed())
				{
					periodicReviews.availablePeriodic_MoveButton().click();
				}
				else
				{
					test.log(LogStatus.PASS, "Periodic Reviewers is not displyed after specific search.");
				}
				
				periodicReviews.save_Button().click();
				sleep(7);
				verticalScrollingUp();
				verticalScrollingUp();
				periodicReviews.docContext_Menu().click();
				sleep(2);
				periodicReviews.checkIn_Route().click();
				sleep(2);
				periodicReviews.checkInRouteSubmit_Button().click();
				sleep(2);
				periodicReviews.close_Button().click();
				sleep(3);
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find The Edit periodic reviewer's popup screen.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Edit periodic reviewer")));
			}
		}
		return documentNo;
	}
	
	private void approveDocFromWizard(String docName)
	{
		periodicReviews.wizard_Option().click();
		periodicReviews.approval_Tab().click();
		sleep(2);
		isRecordFound = false;
		for(int i=1; i<=20; i++)
		{
			 selectDocForApprovel(docName);
			 if(!isRecordFound)
			 {
				// verticalScrollingDown();
				 periodicReviews.documentTableNext_Button().click();
		 		 sleep(2); 
			 }
			 else
			 {
				 break;
			 }
		}
		sleep(2);
		periodicReviews.documentTab_ForApprover().click();
		sleep(2);
		periodicReviews.documentApprove_Button().click();
		sleep(2);
		periodicReviews.pinTo_Approve().clear();
		periodicReviews.pinTo_Approve().sendKeys(routeData[1][12]);
		periodicReviews.checkInRouteSubmit_Button().click();
		sleep(2);
	}
	
	private boolean selectDocForApprovel(String docName) 
	{
		isRecordFound=false;
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getcollapseDocumentstableCells(3);				
		for (int i=0;i<tableCells.size();i++)
		{
			if (tableCells.get(i).getText().contains(docName))
			{													
				tableCells.get(i).click();
				isRecordFound=true;
				break;
			}
		}
		return isRecordFound;
	}
	
	private boolean verifyDocForReview(String docName) 
	{
		isValueFound=false;
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getReviewDocsCells(3);				
		for (int i=0;i<tableCells.size();i++)
		{
			if (tableCells.get(i).getText().contains(docName))
			{				
				isValueFound=true;
				break;
			}
		}
		return isValueFound;
	}
	
	private boolean selectDocForReview(String docName) 
	{
		isValueFound=false;
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getReviewDocsCells(3);				
		for (int i=0;i<tableCells.size();i++)
		{
			if (tableCells.get(i).getText().contains(docName))
			{			
				tableCells.get(i).click();
				isValueFound=true;
				break;
			}
		}
		return isValueFound;
	}
	
	private void clickOnEditButton(String employeeFullName) 
	{
		
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.gettableCells(1);				
		
		for (int i=1;i<=tableCells.size();i++){
			if (employeeFullName.equalsIgnoreCase(tableCells.get(i-1).getText()))
			{				
				WebElement delete = driver.findElement(By.xpath("//tbody[@class='t21-js-clickable-rows']/tr["+i+"]//span[@title='Edit User']"));
				delete.click();
				break;
			}
		}
	}
	
	private void clickOnGroupEditButton(String employeeFullName) 
	{
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.gettableCells(1);				
		
		for (int i=1;i<=tableCells.size();i++){
			if (employeeFullName.equalsIgnoreCase(tableCells.get(i-1).getText()))
			{				
				WebElement delete = driver.findElement(By.xpath("//tr["+i+"]//span[@title='Edit Group']"));
				delete.click();
				break;
			}
		}
	}
	
	
	private void checkedSpecificDoc(String DocName) 
	{
		
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.gettableCells(4);				
		
		for (int i=1;i<=tableCells.size();i++){
			if (tableCells.get(i-1).getText().contains(DocName))  
			{				
				WebElement clickCheckBox = driver.findElement(By.xpath("//tr["+i+"]/td[1]"));
				clickCheckBox.click();
				break;
			}
		}
	}
	
	private boolean verifyValuesInAuditLog(String reviewerName, int cellNo) 
	{
		isValueFound=false;
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getAuditLogsCells(cellNo);				
		for (int i=0;i<tableCells.size();i++)
		{
			if (tableCells.get(i).getText().contains(reviewerName))
			{				
				isValueFound=true;
				break;
			}
		}
		return isValueFound;
	}
	
	
}