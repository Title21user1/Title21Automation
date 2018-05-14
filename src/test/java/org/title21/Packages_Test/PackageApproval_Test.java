package org.title21.Packages_Test;


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
import org.title21.Packages_POM.PackageApproval_POM;
import org.title21.dao.AdminData;
import org.title21.utility.BaseClass;

import com.relevantcodes.extentreports.LogStatus;

public class PackageApproval_Test extends BaseClass{
	LoginPage_POM login;
	LogoutPage_POM logout;
	PackageApproval_POM packageApproval;
	static Logger log = Logger.getLogger(PackageApproval_Test.class);
	String className="";
	String packageNo="";
	String fileUploadPath="";
	String currentStepsStatus="";
	boolean isRecordFound1=false;
	String uploadFileName="FileToUpload.txt";
	Table searchTable;
	DBQueries dbqueries;
	AdminData adminData=new AdminData();
	String testcaseName="TestCase-WIA-Package_approval.docx";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;

	@BeforeClass(alwaysRun=true)
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

	@Test(testName = "PackageApproval", groups = "Packages", priority = 0)
	public void DocumentRoutes() throws Exception
	{		
		test = extent.startTest("Package Approval");
		log.info("Codes");
		test.log(LogStatus.PASS, "1.Login to the web interface.");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		packageApproval=new PackageApproval_POM(driver);	
	
		DBConnection.executeStoredProcedure(dbqueries.doNotForwardAttachedIndexCards);
		
		test.log(LogStatus.PASS, "2.Click on the new and select package.");
		packageApproval.getnewdoc().click();
		sleep(2);
		packageApproval.package_Link().click();
		sleep(3);
		
		if(packageApproval.verifyCreateNewPackagePopUpText())
		{
			test.log(LogStatus.PASS, "<b>ER1- Create new Package screen will appear.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Create new Package screen")));
		}
		else
		{
			test.log(LogStatus.FAIL, "<b>Uable to find the create new Package screen will appear.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Create new Package screen")));
		}
		
		test.log(LogStatus.PASS, "3.Select Cabinet and Section from the dropdown list.");
		packageApproval.cabinet_DropDown().selectByVisibleText("Open DCOs");
		sleep(2);
		packageApproval.cabinetSection_DropDown().selectByVisibleText("DCO in Progress");
		
		sleep(2);
		test.log(LogStatus.PASS, "6.Add Package Name.");
		packageApproval.packageName_TextBox().sendKeys("NeoTest");
		
		test.log(LogStatus.PASS, "7.Click on 'Create'.");
		packageApproval.create_Button().click();
		sleep(3);
		
		if(packageApproval.verifyPackageScreen())
		{
			test.log(LogStatus.PASS, "<b>ER2- Package screen will appear.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Package screen")));
			
		}
		else
		{
			test.log(LogStatus.FAIL, "<b>Unable to find the Package screen.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Package screen")));
		}
		
		packageNo = packageApproval.package_No().getText();
		
		test.log(LogStatus.PASS, "6.Ensure the Package is open in edit mode.");
		test.log(LogStatus.PASS, "7.Click on 'Add/Remove' link available in documents frame.");
		packageApproval.addRemove_LinkText().click();			
		sleep(3);
		
		if(packageApproval.verifyAttachDocScreen())
		{
			test.log(LogStatus.PASS, "<b>ER3- Attach documents screen will appear.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Attach documents screen")));
		}
		else
		{
			test.log(LogStatus.FAIL, "<b>Unable to find the attach documents screen.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Attach documents screen")));
		}
		
		test.log(LogStatus.PASS, "8.Select Status: Open, Created between (e.g. a month before current date and current date), Type: Document and Location: ALL");
		packageApproval.selectStatus_DoropDown().selectByVisibleText("Open");
		sleep(2);
		packageApproval.andDate_Box().click();
		sleep(2);
		packageApproval.current_Date().click();
		sleep(2);
		packageApproval.type_DropDown().selectByVisibleText("Document");
		sleep(2);
		packageApproval.location_DropDown().click();
		sleep(2);
		packageApproval.selectAll_Locacation().click();
		sleep(2);
		
		test.log(LogStatus.PASS, "9.Enter effective in the search field and click on go button");
		packageApproval.attachedDocFilterResult_TextBox().sendKeys("Effective");
		packageApproval.attachedDocFilterResultGo_Button().click();
		sleep(2);
		
		test.log(LogStatus.PASS, "10.Select Effective documents.");
		packageApproval.onlyshowavailableDoc_CheckBox().click();
		sleep(4);
		packageApproval.filteredPackage_Result().click();
		
		test.log(LogStatus.PASS, "11.Click on 'OK'.");
		packageApproval.ok_Button().click();
		sleep(4);
		
		if(packageApproval.docAddedIn_DocSection().isDisplayed())
		{
			test.log(LogStatus.PASS, "<b>ER4- Added documents appear in the document frame.<b>"+
					test.addScreenCapture(captureScreenShot(driver, " Added documents")));
		}
		else
		{
			test.log(LogStatus.FAIL, "<b>Unable to find the Added documents in the document frame.<b>"+
					test.addScreenCapture(captureScreenShot(driver, " Added documents")));
		}
		
		verticalScrollingUp();
		test.log(LogStatus.PASS, "12.Mark the document to be obsolete from the context menu.");
		packageApproval.firstDoc_ContextMenu().click();
		sleep(2);
		packageApproval.obsolete_Option().click();
		sleep(2);
		
		if(packageApproval.messagePopUp_Header().isDisplayed())
		{
			test.log(LogStatus.PASS, "<b>ER5- Document is marked Obsolete Message is displayed.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Document is marked Obsolete")));
			packageApproval.close_Button().click();
			sleep(4);
		}
		else
		{
			test.log(LogStatus.PASS, "<b>Uanble to find the added documents in the document frame.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Document is marked Obsolete")));
		}
		
		verticalScrollingUp();
		sleep(2);
		test.log(LogStatus.PASS, "13.Navigate to attachment tab.");
		packageApproval.attachmentsTasks_Tab().click();
		sleep(2);
		
		test.log(LogStatus.PASS, "14.Click on add new attachment button.");
		packageApproval.attachmentsAddNewLink().click();
		sleep(2);
		
		test.log(LogStatus.PASS, "15.Add file and click on add button");
		packageApproval.fileupload(uploadFileName);
		sleep(4);
		
		if(packageApproval.attachments_Attached().isDisplayed())
		{
			test.log(LogStatus.PASS, "<b>ER6- Attachment is added for package in the attachment section.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Document is marked Obsolete")));
		}
		else
		{
			test.log(LogStatus.FAIL, "<b>Unable to find the Attachment added for package in the attachment section.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Document is marked Obsolete")));
		}
		
		test.log(LogStatus.PASS, "16.Navigate to the approval tab.");
		packageApproval.approvals_Tab().click();
		sleep(4);
		
		test.log(LogStatus.PASS, "17.Click on the add approver link.");
		packageApproval.approver_Link().click();
		
		sleep(4);
		test.log(LogStatus.PASS, "18.Select Role (for eg: Approver)");
		test.log(LogStatus.PASS, "Note: Only role: Approver for individual approver should be chosen here");
		packageApproval.getApproverRole().selectByVisibleText(routeData[1][3]);
		
		test.log(LogStatus.PASS, "19.Select location, approver name.");
		packageApproval.getLocationDropdown().selectByVisibleText(routeData[1][4]); 
		sleep(2);
		
		test.log(LogStatus.PASS, "20.Select sequence as 1 and select allotted days from the dropdown.");
		packageApproval.getnameinAddApprover().selectByVisibleText(routeData[1][5]);
		packageApproval.getSequenceinAddApprover().selectByVisibleText("1");
		packageApproval.getallottedDaysinAddApprover().selectByVisibleText(routeData[1][7]);

		test.log(LogStatus.PASS,"21.Click on add button.");
		packageApproval.approverAdd_Button().click();
		sleep(4);
		
		if(verifyDocNameInTable(routeData[1][5]))
		{
			test.log(LogStatus.PASS, "<b>ER8- Individual approver is added<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Individual approver is added")));
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find Individual approver."+
					test.addScreenCapture(captureScreenShot(driver, "Individual approver is added")));
		}
		
		test.log(LogStatus.PASS, "22.Click on the add approver link and add a Group approver (E.g. sp tester) as Sequence 1");
		packageApproval.getAddApproverLink().click();
		sleep(2);
		packageApproval.getApproverRole().selectByVisibleText(routeData[1][8]);
		packageApproval.getLocationDropdown().selectByVisibleText(routeData[1][4]);
		sleep(2);
		packageApproval.getnameinAddApprover().selectByVisibleText(routeData[1][9]);
		packageApproval.getSequenceinAddApprover().selectByVisibleText("1"); 
		packageApproval.getallottedDaysinAddApprover().selectByVisibleText(routeData[1][7]);
		packageApproval.approverAdd_Button().click();
		sleep(2);
		if(verifyDocNameInTable(routeData[1][9]))
		{
			test.log(LogStatus.PASS, "<b>ER9- Group approver is added.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Group approver is added")));
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find Group approver is added."+
					test.addScreenCapture(captureScreenShot(driver, "Group approver is added")));
		}
		
		test.log(LogStatus.PASS, "23.Click on add a signature route link");
		packageApproval.signatureRoute_Link().click();
		sleep(4);
		
		if(packageApproval.addNewSignatureRoute_Header().isDisplayed())
		{
			test.log(LogStatus.PASS, "<b>ER10- Signature route dialog appears.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Signature route dialog appears.")));
			
		}
		else
		{
			test.log(LogStatus.PASS, "<b>Unable to find the signature route dialog.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Signature route dialog appears.")));
		}
		
		test.log(LogStatus.PASS, "24.Select the route (for e.g. 'routeneotest') and click on add button.(added as sequence 2) "
				+ "Note: Ensure that individual approvers in the route do not belong to the group added previously. Remove them from the group if necessary.");
		
		packageApproval.routeName_DropDown().selectByVisibleText(routeData[1][11]);
		packageApproval.approverAdd_Button().click();
		sleep(4);
		if(verifyDocNameInTable(routeData[1][11]))
		{
			test.log(LogStatus.PASS, "<b>ER11- Route is added.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Route is added")));
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find Route is added."+
					test.addScreenCapture(captureScreenShot(driver, "Route is added")));
		}
		
		test.log(LogStatus.PASS, "25.Click on package option context menu.");
		packageApproval.docContext_Menu().click();
		sleep(2);
		              
		packageApproval.packageRouteApproval().click();
		test.log(LogStatus.PASS, "26.Click on route for approval.");
		sleep(2);
		
		
		test.log(LogStatus.PASS, "<b>ER12- Confirmation message for approval is displayed.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Route is added")));
		packageApproval.checkInRouteSubmit_Button().click();
		test.log(LogStatus.PASS, "27.Click on yes button.");
		
		sleep(4);
		if(packageApproval.messagePopUp_Header().isDisplayed())
		{
			test.log(LogStatus.PASS, "<b>ER13- A message confirming package is routed for approval is displayed.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Route is added")));
			packageApproval.close_Button().click();
			sleep(2);
			test.log(LogStatus.PASS, "28.Click on close button.");
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to find check in route pop up.");
		}
		
		test.log(LogStatus.PASS, "29.Login as one of the users named in Sequence 1.");
		sleep(2);
		logout.logoutFunction();
		sleep(2);
		login.loginUser(loginData[1][0], loginData[1][1]);
		
		test.log(LogStatus.PASS, "30.Go to the approval wizard.");
		packageApproval.wizard_Option().click();
		sleep(2);
		packageApproval.approval_Tab().click();
		sleep(2); 
		packageApproval.wizardApprovalFilterTextBox().sendKeys(packageNo);
		sleep(2);
		packageApproval.wizardApprovalFilterGoButton().click();
		sleep(2);
		
		packageApproval.filtered_Package().click();
		sleep(2);
		test.log(LogStatus.PASS, "<b>ER14- The Package is available in the approval wizard<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Route is added")));
		
		test.log(LogStatus.PASS, "31.Logout and login as the individual approver in Sequence 2");
		logout.logoutFunction();
		login.loginUser("Mart707", "title21neo");
		
		
		test.log(LogStatus.PASS, "32.Navigate to the approval wizard");
		packageApproval.wizard_Option().click();
		packageApproval.approval_Tab().click();
		
		sleep(2);
		test.log(LogStatus.PASS, "<b>ER15- The document is not available in the approval wizard.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Route is added")));
		
		logout.logoutFunction();
		
		test.log(LogStatus.PASS, "34.Login as each individual approver listed in Sequence 1, and approve the document through the Web interface.");
		login.loginUser(loginData[1][0], loginData[1][1]);
		packageApproval.myDocs_Tab().click();
		sleep(2);
		packageApproval.docApproval_Link().click();
		sleep(2);
		packageApproval.approvalFilterResult_TextBox().sendKeys(packageNo);
		sleep(2);
		packageApproval.approvalFilterResultGo_Button().click();
		sleep(2);
		packageApproval.searched_Doc().click();
		sleep(2);
		packageApproval.packageApprovalsTab().click();
		sleep(2);
		packageApproval.approveLink().click();
		sleep(4);
		packageApproval.pinTo_Approve().clear();					
		packageApproval.pinTo_Approve().sendKeys(routeData[1][12]);
		packageApproval.checkInRouteSubmit_Button().click();
		sleep(2);
		
		logout.logoutFunction();
		login.loginUser(loginData[8][0], loginData[8][1]);
		packageApproval.myDocs_Tab().click();
		sleep(2);
		packageApproval.docApproval_Link().click();
		sleep(2);
		packageApproval.approvalFilterResult_TextBox().sendKeys(packageNo);
		sleep(2);
		packageApproval.approvalFilterResultGo_Button().click();
		sleep(2);
		packageApproval.searched_Doc().click();
		sleep(2);
		packageApproval.packageApprovalsTab().click();
		sleep(2);
		packageApproval.approveLink().click();
		sleep(4);
		packageApproval.pinTo_Approve().clear();					
		packageApproval.pinTo_Approve().sendKeys(routeData[1][12]);
		packageApproval.checkInRouteSubmit_Button().click();
		sleep(2);
		
		
		test.log(LogStatus.PASS, "35.Login as a member of the group named in Sequence 2 again and navigate to the approval wizard.");
		logout.logoutFunction();
		login.loginUser("Mart707", "title21neo");

		packageApproval.myDocs_Tab().click();
		sleep(2);
		packageApproval.docApproval_Link().click();
		sleep(2);
		packageApproval.approvalFilterResult_TextBox().sendKeys(packageNo);
		sleep(2);
		packageApproval.approvalFilterResultGo_Button().click();
		sleep(2);
		packageApproval.searched_Doc().click();
		sleep(2);
		packageApproval.packageApprovalsTab().click();
		sleep(2);
		
		test.log(LogStatus.PASS, "<b>ER16- The document is available in the approval wizard, and the status for both of the Sequence 1 individual approvals are updated.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Route is added")));
		
		test.log(LogStatus.PASS, "36.Reject the package by member of the group named in Sequence 2");
		verticalScrollingDown();
		sleep(2);
		sleep(2);
		packageApproval.docRejectLink().click();
		sleep(4);
		packageApproval.pinTo_Approve().clear();					
		packageApproval.pinTo_Approve().sendKeys(routeData[1][12]);
		packageApproval.comments_TextBox().sendKeys("Rejected");
		packageApproval.checkInRouteSubmit_Button().click();
		sleep(2);
		verticalScrollingDown();
		sleep(2);
		
		if(packageApproval.verifyPackageRejectedMsg())
		{
			test.log(LogStatus.PASS, "<b>ER17- The package is rejected.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Route is added")));
		}
		else
		{
			test.log(LogStatus.PASS, "<b>Unable to find the rejected package.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Route is added")));
		}
		
		test.log(LogStatus.PASS, "37.Login as a user used in step (1).");
		logout.logoutFunction();
		login.loginUser(loginData[7][0], loginData[7][1]);
		
		test.log(LogStatus.PASS, "38.Go to package created in step (5).");
		
		sleep(2);
		packageApproval.searches_Tab().click();
		sleep(2);
		packageApproval.searchesFilterResult_TextBox().sendKeys("Search Packages");
		sleep(2);
		packageApproval.searchesFilterResultGo_Button().click();
		sleep(2);
		packageApproval.searchPackagesLinkText().click();
		sleep(2);
		packageApproval.searchGo_Button().click();
		sleep(2);
		verticalScrollingUp();
		sleep(2);
		packageApproval.searchesFilterTextBox().sendKeys(packageNo);
		sleep(2);
		packageApproval.searchesFilterGoButton().click();
		sleep(2);
		packageApproval.filteredPackage_Result().click();
		sleep(4);

		test.log(LogStatus.PASS, "39.Navigate to approver tab and route the package for approval again.");
		packageApproval.approvals_Tab().click();
		sleep(2);
		packageApproval.searchesPackageContextMenu().click();
		sleep(2);
		packageApproval.packageRouteApproval().click();
		sleep(2);
		packageApproval.checkInRouteSubmit_Button().click();
		sleep(2);
		packageApproval.close_Button().click();
		sleep(2);
		
		test.log(LogStatus.PASS, "40.Login as each individual approver listed in Sequence 1, and approve the document through the Web interface.");
		logout.logoutFunction();
		sleep(2);
		login.loginUser(loginData[1][0], loginData[1][1]);
		packageApproval.myDocs_Tab().click();
		sleep(2);
		packageApproval.docApproval_Link().click();
		sleep(2);
		packageApproval.approvalFilterResult_TextBox().sendKeys(packageNo);
		sleep(2);
		packageApproval.approvalFilterResultGo_Button().click();
		sleep(2);
		packageApproval.searched_Doc().click();
		sleep(4);
		packageApproval.packageApprovalsTab().click();
		sleep(2);
		packageApproval.approveLink().click();
		sleep(4);
		packageApproval.pinTo_Approve().clear();					
		packageApproval.pinTo_Approve().sendKeys(routeData[1][12]);
		packageApproval.checkInRouteSubmit_Button().click();
		sleep(2);
		
		logout.logoutFunction();
		login.loginUser(loginData[8][0], loginData[8][1]);
		packageApproval.myDocs_Tab().click();
		sleep(2);
		packageApproval.docApproval_Link().click();
		sleep(2);
		packageApproval.approvalFilterResult_TextBox().sendKeys(packageNo);
		sleep(2);
		packageApproval.approvalFilterResultGo_Button().click();
		sleep(2);
		packageApproval.searched_Doc().click();
		sleep(4);
		packageApproval.packageApprovalsTab().click();
		sleep(2);
		packageApproval.approveLink().click();
		sleep(4);
		packageApproval.pinTo_Approve().clear();					
		packageApproval.pinTo_Approve().sendKeys(routeData[1][12]);
		packageApproval.checkInRouteSubmit_Button().click();
		sleep(2);
		
		test.log(LogStatus.PASS, "41.Login as a member of the group named in Sequence 2 again and navigate to the approval wizard.");
		logout.logoutFunction();
		login.loginUser("Mart707", "title21neo");
		packageApproval.myDocs_Tab().click();
		sleep(2);
		packageApproval.docApproval_Link().click();
		sleep(2);
		packageApproval.approvalFilterResult_TextBox().sendKeys(packageNo);
		sleep(2);
		packageApproval.approvalFilterResultGo_Button().click();
		sleep(2);
		packageApproval.searched_Doc().click();
		sleep(4);
		packageApproval.packageApprovalsTab().click();
		sleep(2);
		packageApproval.approveLink().click();
		sleep(4);
		packageApproval.pinTo_Approve().clear();					
		packageApproval.pinTo_Approve().sendKeys(routeData[1][12]);
		packageApproval.checkInRouteSubmit_Button().click();
		sleep(2);
		verticalScrollingDown();
		sleep(2);
		test.log(LogStatus.PASS, "<b>ER18- The package is successfully approved by all the approvers.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "package is successfully approved")));
		
		verticalScrollingUp();
		sleep(2);
		packageApproval.general_Tab().click();
		sleep(2);
		currentStepsStatus = packageApproval.currentStapesStatus().getText();
		
		if(currentStepsStatus.equalsIgnoreCase("Approved DCOs"))
		{
			test.log(LogStatus.PASS, "<b>ER19- The package is moved to Next cabinet.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "package is successfully approved")));
		}
		else
		{
			driver.navigate().refresh();
			sleep(2);
			verticalScrollingUp();
			sleep(2);
			packageApproval.dashboard_Tab().click();
			sleep(4);
			driver.findElement(By.xpath("//a[text()='"+packageNo+"']")).click();
			sleep(4);
			currentStepsStatus = packageApproval.currentStapesStatus().getText();
			if(currentStepsStatus.equalsIgnoreCase("Approved DCOs"))
			{
				test.log(LogStatus.PASS, "<b>ER19- The package is moved to Next cabinet.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "package is successfully approved")));
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Uanble to find the package moved to Next cabinet.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "package is successfully approved")));
			}
		}
	}

	@AfterClass(alwaysRun=true)
	public void closeBrowserInstance()
	{	
		logout.logoutFunction();
		extent.endTest(test);
		driver.close();
	}

	private boolean verifyDocNameInTable(String docName) 
	{
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getPackageApprovalstableCells(3);				
		for (int i=0;i<tableCells.size();i++)
		{
			if (tableCells.get(i).getText().equalsIgnoreCase(docName))
			{				
				isRecordFound1=true;
				break;
			}
		}
		return isRecordFound1;
	}
}
