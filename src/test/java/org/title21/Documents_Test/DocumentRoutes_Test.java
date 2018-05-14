package org.title21.Documents_Test;


import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.AdminModule_POM.Table;
import org.title21.Documents_POM.DocumentRoutes_POM;
import org.title21.dao.AdminData;
import org.title21.utility.BaseClass;

import com.relevantcodes.extentreports.LogStatus;

public class DocumentRoutes_Test extends BaseClass{
	LoginPage_POM login;
	LogoutPage_POM logout;
	DocumentRoutes_POM documentRoutes;
	static Logger log = Logger.getLogger(DocumentRoutes_Test.class);
	String className="";
	String documetNo="";
	String documetsName="";
	String fileUploadPath="";
	String uploadFileName="DocDocument.docx";
	Table searchTable;
	boolean isRecordFound=false;
	boolean isRecordFound1=false;
	boolean isValueFound=false;
	AdminData adminData=new AdminData();
	String testcaseName="TestCase-WIA-Document_Routes.doc";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;

	@BeforeClass(alwaysRun=true)
	public void openURL() 
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		logout=new LogoutPage_POM(driver);
		login=new LoginPage_POM(driver);
		login.loginUser(loginData[7][0], loginData[7][1]);
	}

	@Test(testName = "Document Routes", groups = "DocumentModule", priority = 0)
	public void DocumentRoutes() throws Exception
	{		
		test = extent.startTest("Document Routes");
		//test.log(LogStatus.PASS, "1.Login as a web interface.");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		documentRoutes=new DocumentRoutes_POM(driver);		
		documentRoutes.getnewdoc().click();
		sleep(3);
		documentRoutes.getdocument().click();
		sleep(3);
		documentRoutes.getlocationDrodown().selectByVisibleText(routeData[1][0]);
		sleep(2);
		documetNo = documentRoutes.document_No().getAttribute("value");

		documentRoutes.getDocumentTitle().sendKeys(routeData[1][1]+documetNo); 
		documentRoutes.getDocChangeSummary().sendKeys(routeData[1][2]+documetNo);
		verticalScrollingDown();
		documentRoutes.getConfirmButton().click();
		sleep(5);
		if(documentRoutes.getdocumentcreationverify().isDisplayed()) 
		{
			test.log(LogStatus.PASS,"1.	Create a new document form.");

			test.log(LogStatus.PASS,"2.	Open the document form (in edit mode) and add a main file.");

			documentRoutes.addMainFile_Button().click();
			sleep(3);

			documentRoutes.fileupload(uploadFileName);
			sleep(2);
			test.log(LogStatus.PASS,"3.	Navigate to the approval tab.");
			
			documentRoutes.getDocumentApprovaltab().click();
			test.log(LogStatus.PASS,"4.	Click on the add approver link.");
			sleep(2);
			documentRoutes.getAddApproverLink().click();
			sleep(2);
			if(documentRoutes.addNewApprover_Header().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER 1- Add new approver popup screen is open.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "new approver popup")));

				documentRoutes.getApproverRole().selectByVisibleText(routeData[1][3]);
				test.log(LogStatus.PASS,"5.	Select Role (for eg: "+routeData[1][3]+")"); 
				sleep(2);
				documentRoutes.approverAdd_Button().click();
				documentRoutes.approverAdd_Button().click();
				test.log(LogStatus.PASS,"6.	Click on add button");
				sleep(2);
				if((documentRoutes.approverNameIsReuired().isDisplayed()) && (documentRoutes.approverNameIsReuired().isDisplayed()) && (documentRoutes.approverAllottedDaysRequired().isDisplayed()))
				{
					test.log(LogStatus.PASS, "<b>ER 2- Validation messages 'Name is required', 'Sequence is required', 'Allotted days are required' are displayed.<b>"+
							test.addScreenCapture(captureScreenShot(driver, "new approver popup erroe Msg")));
				}
				else
				{
					test.log(LogStatus.FAIL, "Unable to find Validation messages 'Name is required', 'Sequence is required', 'Allotted days are required' are displayed.<b>"+
							test.addScreenCapture(captureScreenShot(driver, "new approver popup erroe Msg")));
				}

				test.log(LogStatus.PASS,"7.	Enter all mandatory fields.");

				documentRoutes.getLocationDropdown().selectByVisibleText(routeData[1][4]); 
				sleep(2);
				documentRoutes.getnameinAddApprover().selectByVisibleText(routeData[1][5]);
				documentRoutes.getSequenceinAddApprover().selectByVisibleText("1");
				documentRoutes.getallottedDaysinAddApprover().selectByVisibleText(routeData[1][7]);

				test.log(LogStatus.PASS,"8.	Click on add button.");
				documentRoutes.approverAdd_Button().click();
				sleep(2);

				if(verifyDocNameInTable(routeData[1][5]))
				{
					test.log(LogStatus.PASS, "<b>ER 3- Individual approver is added.<b>"+
							test.addScreenCapture(captureScreenShot(driver, "Individual approver is added")));
				}
				else
				{
					test.log(LogStatus.FAIL, "Unable to find Individual approver is added."+
							test.addScreenCapture(captureScreenShot(driver, "Individual approver is added")));
				}

				test.log(LogStatus.PASS,"9.	Click on the add approver link and add a Group approver (E.g. sp tester) as Sequence 2.");//[1][9] Sp Tester
				documentRoutes.getAddApproverLink().click();
				sleep(2);
				documentRoutes.getApproverRole().selectByVisibleText(routeData[1][8]);
				documentRoutes.getLocationDropdown().selectByVisibleText(routeData[1][4]);
				sleep(2);
				documentRoutes.getnameinAddApprover().selectByVisibleText(routeData[1][9]);
				documentRoutes.getSequenceinAddApprover().selectByVisibleText("2"); 
				documentRoutes.getallottedDaysinAddApprover().selectByVisibleText(routeData[1][7]);
				documentRoutes.approverAdd_Button().click();
				sleep(2);
				if(verifyDocNameInTable(routeData[1][9]))
				{
					test.log(LogStatus.PASS, "<b>ER 4- Group approver is added.<b>"+
							test.addScreenCapture(captureScreenShot(driver, "Group approver is added")));
				}
				else
				{
					test.log(LogStatus.FAIL, "Unable to find Group approver is added."+
							test.addScreenCapture(captureScreenShot(driver, "Group approver is added")));
				}

				test.log(LogStatus.PASS,"10. Click on add a signature route link");
				documentRoutes.signatureRoute_Link().click();
				sleep(2);
				if(documentRoutes.addNewSignatureRoute_Header().isDisplayed())
				{
					test.log(LogStatus.PASS, "<b>ER 5- Signature route dialog appears..<b>"+
							test.addScreenCapture(captureScreenShot(driver, "Signature route dialog appears.")));

					documentRoutes.routeName_DropDown().selectByVisibleText(routeData[1][11]);
					test.log(LogStatus.PASS, "11. Select the route (for ex. "+routeData[1][11]+") and click on add button.");
					documentRoutes.approverAdd_Button().click();
					sleep(4);
					if(verifyDocNameInTable(routeData[1][11]))
					{
						test.log(LogStatus.PASS, "<b>ER 6- Route is added.<b>"+
								test.addScreenCapture(captureScreenShot(driver, "Route is added")));
					}
					else
					{
						test.log(LogStatus.FAIL, "Unable to find Route is added."+
								test.addScreenCapture(captureScreenShot(driver, "Route is added")));
					}

					test.log(LogStatus.PASS, "12. Click on doc option context menu.");
					documentRoutes.docContext_Menu().click();
					sleep(2);
					documentRoutes.checkIn_Route().click();

					test.log(LogStatus.PASS, "13. Check in the document and route it for approval.");
					sleep(2);
					documentRoutes.checkInRouteSubmit_Button().click();
					sleep(4);
					if(documentRoutes.messagePopUp_Header().isDisplayed())
					{
						test.log(LogStatus.PASS, "<b>ER 7- Successful message that the document has been checked In and routed is displayed.<b>"+
								test.addScreenCapture(captureScreenShot(driver, "Route is added")));

						documentRoutes.close_Button().click();
						test.log(LogStatus.PASS, "14. Click on close button.");
					}
					else
					{
						test.log(LogStatus.FAIL, "Unable to find check in route pop up.");
					}

					sleep(2);
					logout.logoutFunction();
					sleep(2);
					test.log(LogStatus.PASS, "15. Login as one of the users named in Sequence 1.");

					login.loginUser(loginData[1][0], loginData[1][1]); 

					test.log(LogStatus.PASS, "16. Go to the approval wizard.");
					documentRoutes.wizard_Option().click();
					documentRoutes.approval_Tab().click();
					
					
					
					
					for(int i=1; i<=20; i++)
					{
						verifyDocForApprovel(documetNo);
						 if(!isValueFound)
						 {
							documentRoutes.documentTableNext_Button().click();
							sleep(2); 
						}
						else
						{
							break;
						}
					}
					//changes-
					if(isValueFound)
					{
						test.log(LogStatus.PASS, "<b>ER 8- The document is available in the approval wizard.<b>"+
								test.addScreenCapture(captureScreenShot(driver, "approval wizard")));
					}
					else
					{
						test.log(LogStatus.FAIL, "Unable to find The document is available in the approval wizard."+
								test.addScreenCapture(captureScreenShot(driver, "approval wizard")));
					}
					logout.logoutFunction();

					test.log(LogStatus.PASS, "17. Logout and login as the individual approver in Sequence 2");

					test.log(LogStatus.PASS, "18. Navigate to the approval wizard");

					login.loginUser(loginData[8][0], loginData[8][1]); 

					documentRoutes.wizard_Option().click();
					documentRoutes.approval_Tab().click();

					driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					if(documentRoutes.verifyNoItemForApproval(driver))
					{
						test.log(LogStatus.PASS, "<b>ER 9- The document is not available in the approval wizard.<b>"+
								test.addScreenCapture(captureScreenShot(driver, "approval wizard")));
					}
					else
					{
						isValueFound=false;
						if(!verifyDocForApprovel(documetNo))
						{
							test.log(LogStatus.PASS, "<b>ER 8- The document is available in the approval wizard.<b>"+
									test.addScreenCapture(captureScreenShot(driver, "approval wizard")));
						}
						else
						{
							test.log(LogStatus.FAIL, "Document is available in the approval wizard."+
									test.addScreenCapture(captureScreenShot(driver, "approval wizard")));
						}
					}

					driver.manage().timeouts().implicitlyWait(120, TimeUnit.SECONDS);
					test.log(LogStatus.PASS, "19. Logout. ");
					logout.logoutFunction();
					test.log(LogStatus.PASS, "20. Login as each individual approvers listed in Sequence 1, and approve the document through the Web interface.");
					sleep(2);

					login.loginUser(loginData[1][0], loginData[1][1]); 

					documentRoutes.wizard_Option().click();
					documentRoutes.approval_Tab().click();
					sleep(2);
					
					for(int i=1; i<=20; i++)
					 {
						selectDocForApprovel(documetNo);
						 if(!isRecordFound)
						 {
							//verticalScrollingDown();
							documentRoutes.documentTableNext_Button().click();
							sleep(2); 
						}
						else
						{
							break;
						}
					}
					
					
					sleep(2);
					documentRoutes.documentTab_ForApprover().click();
					sleep(2);
					documentRoutes.documentApprove_Button().click();
					sleep(2);
					documentRoutes.pinTo_Approve().clear();					
					documentRoutes.pinTo_Approve().sendKeys(routeData[1][12]);
					documentRoutes.checkInRouteSubmit_Button().click();
					sleep(2);
					logout.logoutFunction();

					login.loginUser(loginData[9][0], loginData[9][1]); 

					documentRoutes.wizard_Option().click();
					documentRoutes.approval_Tab().click();
					sleep(2);

					documentRoutes.searchDoc(documetNo);

					sleep(2);
					documentRoutes.documentTab_ForApprover().click();
					sleep(2);
					documentRoutes.documentApprove_Button().click();
					sleep(2);
					documentRoutes.pinTo_Approve().clear();
					documentRoutes.pinTo_Approve().sendKeys(routeData[1][12]);
					documentRoutes.checkInRouteSubmit_Button().click();
					sleep(2);
					logout.logoutFunction();

					test.log(LogStatus.PASS, "21. Login as a member of the group named in Sequence 2 again and navigate to the approval wizard.");

					login.loginUser(loginData[8][0], loginData[8][1]); 

					documentRoutes.wizard_Option().click();
					documentRoutes.approval_Tab().click();
					sleep(2);
					
					for(int i=1; i<=20; i++)
					{
						verifyDocForApprovel(documetNo);
						if(!isValueFound)
						{
							documentRoutes.documentTableNext_Button().click();
							sleep(2); 
						}
						else
						{
							break;
						}
					}

					if(isValueFound)
					{
						test.log(LogStatus.PASS, "<b>ER 9- The document is available in the approval wizard, and the status for both of the Sequence 1 individual approvals are updated.<b>"+
								test.addScreenCapture(captureScreenShot(driver, "approval wizard")));
					}
					else
					{
						test.log(LogStatus.FAIL, "Unable to find the document is available in the approval wizard, and the status for both of the Sequence 1 individual approvals are updated.<b>"+
								test.addScreenCapture(captureScreenShot(driver, "approval wizard")));
					}
				}
				else
				{
					test.log(LogStatus.FAIL, "Unable to find Signature route dialog appears."+
							test.addScreenCapture(captureScreenShot(driver, "Signature route dialog appears.")));
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find Add new approver popup screen.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "new approver popup")));
			}
		}
		else
		{
			test.log(LogStatus.FAIL,"Unable to Create a new document form.");
		}
	}
	
	@AfterMethod
	public void afterMethod()
	{
		logout.logoutFunction();
	}
	
	@AfterClass(alwaysRun=true)
	public void closeBrowserInstance()
	{	
		extent.endTest(test);
		driver.quit();
	}

	private boolean verifyDocNameInTable(String docName) 
	{
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getDocumentApprovalstableCells(3);				
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

	private boolean verifyDocForApprovel(String docName) 
	{
		isValueFound=false;
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getcollapseDocumentstableCells(5);				
		for (int i=0;i<tableCells.size();i++)
		{
			if (tableCells.get(i).getText().equalsIgnoreCase(routeData[1][1]+docName))
			{				
				isValueFound=true;
				break;
			}
		}
		return isValueFound;
	}

	private boolean selectDocForApprovel(String docName) 
	{
		isRecordFound=false;
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getcollapseDocumentstableCells(5);				
		for (int i=0;i<tableCells.size();i++)
		{
			if (tableCells.get(i).getText().equalsIgnoreCase(routeData[1][1]+docName))
			{													
				tableCells.get(i).click();
				isRecordFound=true;
				break;
			}
		}
		return isRecordFound;
	}

}
