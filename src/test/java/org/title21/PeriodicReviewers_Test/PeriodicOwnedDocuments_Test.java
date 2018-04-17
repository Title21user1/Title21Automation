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
import org.title21.Documents_Test.DocumentRoutes_Test;
import org.title21.PeriodicReviewers_POM.PeriodicOwnedDocuments_POM;
import org.title21.dao.AdminData;
import org.title21.utility.BaseClass;
import org.title21.utility.DateTimeUtils;

import com.relevantcodes.extentreports.LogStatus;

public class PeriodicOwnedDocuments_Test extends BaseClass{
	LoginPage_POM login;
	LogoutPage_POM logout;
	PeriodicOwnedDocuments_POM periodicReviews;
	static Logger log = Logger.getLogger(DocumentRoutes_Test.class);
	String className="";
	String documetNo="";
	String documetsName="";
	String documentStatus="";
	String fileUploadPath="";
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
		login.loginUser(loginData[7][0], loginData[7][1]);
	}

	@Test(testName = "PeriodicReviews", groups = "Periodic Reviews", priority = 0)
	public void DocumentRoutes() throws Exception
	{		
		test = extent.startTest("Periodic Reviews");
		test.log(LogStatus.PASS, "1.Login to the web interface as the first test user 1.");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		periodicReviews=new PeriodicOwnedDocuments_POM(driver);	

		test.log(LogStatus.PASS,"2.Create a new document.");
		periodicReviews.getnewdoc().click();
		sleep(3);
		periodicReviews.getdocument().click();
		sleep(3);
		periodicReviews.getlocationDrodown().selectByVisibleText(routeData[1][0]);
		sleep(2);
		documetNo = periodicReviews.document_No().getAttribute("value");
		periodicReviews.getDocumentTitle().sendKeys(routeData[1][1]+documetNo);
		sleep(3);
		periodicReviews.getDocChangeSummary().sendKeys(routeData[1][2]+documetNo);
		sleep(3);
		periodicReviews.getConfirmButton().click();
		sleep(5);
		if(periodicReviews.getdocumentcreationverify().isDisplayed()) 
		{
			test.log(LogStatus.PASS,"3.Add a main file, approvers and other required fields.");
			periodicReviews.addMainFile_Button().click();

			sleep(2);
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
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find The Edit periodic reviewer's popup screen.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Edit periodic reviewer")));
			}

			if(periodicReviews.editPeriodicReviewers_Link().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER2- The selected periodic reviewers are listed.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "reviewers are listed")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find The selected periodic reviewers list.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "reviewers are listed")));
			}

			test.log(LogStatus.PASS, "13.Check in the document and route the document for approval.");
			verticalScrollingUp();
			verticalScrollingUp();
			periodicReviews.docContext_Menu().click();
			sleep(2);
			periodicReviews.checkIn_Route().click();

			sleep(2);
			periodicReviews.checkInRouteSubmit_Button().click();
			sleep(5);

			test.log(LogStatus.PASS, "<b>ER 3- The document is checked in and route for approval.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Route is added")));

			periodicReviews.close_Button().click();
			sleep(3);


			test.log(LogStatus.PASS, "14.Login with approver's login and approve the document.");
			logout.logoutFunction();
			sleep(5);
			login.loginUser(loginData[1][0], loginData[1][1]); 
			approveDocFromWizard(documetNo);
			test.log(LogStatus.PASS, "<b>ER 4- The document is approved successfully and displays the successful message.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "document is approved successfully")));
			logout.logoutFunction();
			test.log(LogStatus.PASS, "15.Login with Test user1");
			login.loginUser(loginData[7][0], loginData[7][1]);
			sleep(5);
			test.log(LogStatus.PASS,"16.Run jobs to move the document to the effective cabinet."+DBConnection.executeStoredProcedure(dbqueries.moveDocsOnReleaseDate));

			driver.findElement(By.xpath("//li[text()='"+routeData[1][1]+documetNo+"']")).click();
			sleep(2);	
			documentStatus = periodicReviews.document_Status().getText();
			if(documentStatus.equals("Effective"))
			{
				test.log(LogStatus.PASS, "<b>ER15- Approved document from Step 35 should move to the effective cabinet as 50% of required training is completed.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Approved document effective")));
			}
			else
			{
				driver.navigate().refresh();
				sleep(10);
				driver.findElement(By.xpath("//li[text()='"+routeData[1][1]+documetNo+"']")).click();
				sleep(2);
				if(documentStatus.equals("Effective"))
				{
					test.log(LogStatus.PASS, "<b>ER5- The document Status is changed to effective.<b>"+
							test.addScreenCapture(captureScreenShot(driver, "Approved document effective")));
				}
				else
				{
					test.log(LogStatus.FAIL, "Unable to find the The document Status is changed to effective."+
							test.addScreenCapture(captureScreenShot(driver, "Approved document effective")));
				}
			}

			test.log(LogStatus.PASS, "17.Go to: Wizard > Review.");
			periodicReviews.wizard_Option().click();
			sleep(2);
			periodicReviews.wizardReview_Tab().click();
			sleep(2);

			for(int i=1; i<=20; i++)
			{
				verifyDocForReview(documetNo);
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
				test.log(LogStatus.PASS, "<b>ER 6- The document for which periodic review has been set is available.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "review wizard")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find The document for which periodic review has been set is available."+
						test.addScreenCapture(captureScreenShot(driver, "review wizard")));
			}

			test.log(LogStatus.PASS, "18.Click on the document.");
			selectDocForReview(documetNo);
			sleep(2);

			if(periodicReviews.changeDontChangeDisable_Button().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER 7- The document is not ready to sign (as it is waiting for others to review) and the Change/Don't Change buttons are not available.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "document is not ready to sign")));
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find the- The document is not ready to sign (as it is waiting for others to review) and the Change/Don’t Change buttons are not available.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "document is not ready to sign")));
			}
			verticalScrollingDown();
			verticalScrollingDown();
			sleep(2);
			test.log(LogStatus.PASS, "19.Click on the context menu for one of the periodic reviewers.");
			periodicReviews.firstPeriodicReviewer_ContextTab().click();

			sleep(2);
			if(periodicReviews.firstPeriodicReviewerBypass_Menu().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER 8- Bypass option is available.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Bypass option")));
				test.log(LogStatus.PASS, "20.Click on 'Bypass' to bypass the test user 2. (1st periodic reviewer added in step(10)).");
				periodicReviews.firstPeriodicReviewerBypass_Menu().click();
			}
			else
			{
				test.log(LogStatus.PASS, "Unable to find the Bypass option");
			}

			sleep(2);
			if(periodicReviews.bypassReviewer_ConfirmationMsg().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER 9- The bypass confirmation popup is displayed.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "bypass confirmation popup")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find the bypass confirmation popup");
			}

			test.log(LogStatus.PASS, "21.Click on yes button.");
			periodicReviews.yes_Button().click();
			sleep(2);

			if(periodicReviews.bypassedByFirstReviewer_TextMsg().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER 10- The bypass action is updated against the second test user.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "bypass action is updated")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find the bypass action is updated against the second test user");
			}

			test.log(LogStatus.PASS, "22.Logout from Test user 1 (Owner). Login to the Test user 2 (1st periodic reviewer added in step(8)) checks the periodic reviews list of the second user.");
			logout.logoutFunction();
			sleep(2);
			login.loginUser(loginData[11][0], loginData[11][1]);

			periodicReviews.wizard_Option().click();
			sleep(2);
			periodicReviews.wizardReview_Tab().click();
			sleep(2);

			for(int i=1; i<=20; i++)
			{
				verifyDocForReview(documetNo);
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
				test.log(LogStatus.PASS, "<b>ER 11- The periodic review is removed from the second test user's list.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "review wizard")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find The periodic review is removed from the second test user's list."+
						test.addScreenCapture(captureScreenShot(driver, "review wizard")));
			}

			test.log(LogStatus.PASS, "23.Logout from the Test user 2. Login to Test user 1.");
			logout.logoutFunction();
			login.loginUser(loginData[7][0], loginData[7][1]);

			periodicReviews.wizard_Option().click();
			sleep(2);
			periodicReviews.wizardReview_Tab().click();
			sleep(2);

			for(int i=1; i<=20; i++)
			{
				verifyDocForReview(documetNo);
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
			selectDocForReview(documetNo);
			sleep(2);
			verticalScrollingDown();
			sleep(2);
			periodicReviews.firstPeriodicReviewer_ContextTab().click();
			sleep(2);
			test.log(LogStatus.PASS, "24.Click on the context menu and Click on 'Clear Bypass' for the Test user 2 who was bypassed in step 18 and confirm.");
			periodicReviews.firstPeriodicReviewer_ClearBypass().click();
			sleep(2);
			periodicReviews.yes_Button().click();
			sleep(2);

			String firstReviewer_Comments = periodicReviews.firstReviewer_Comments().getText();
			if(firstReviewer_Comments.equalsIgnoreCase("N/A"))
			{
				test.log(LogStatus.PASS, "<b>ER 12- The bypass action is cleared against the second test user.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "bypass action is updated")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find the bypass action is cleared against the second test user.");
			}

			test.log(LogStatus.PASS, "25.Logout and login as the Test user 2 and check the periodic review list.");
			logout.logoutFunction();
			sleep(2);
			login.loginUser(loginData[11][0], loginData[11][1]);
			periodicReviews.wizard_Option().click();
			sleep(2);
			periodicReviews.wizardReview_Tab().click();
			sleep(2);

			for(int i=1; i<=20; i++)
			{
				verifyDocForReview(documetNo);
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
				test.log(LogStatus.PASS, "<b>ER 13- The periodic review is available to the second test user again after the bypass is cleared.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "review wizard")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find The periodic review is available to the second test user again after the bypass is cleared."+
						test.addScreenCapture(captureScreenShot(driver, "review wizard")));
			}

			test.log(LogStatus.PASS, "26.Perform the periodic review by clicking on view document.");
			selectDocForReview(documetNo);
			sleep(2);
			periodicReviews.viewDocButtonForPeriodicReview().click();
			sleep(2);

			test.log(LogStatus.PASS, "27.Click on Either Change or Don't Change.");
			periodicReviews.dontChange_Button().click();

			sleep(2);
			if(periodicReviews.reviewDecisionPopUp_Header().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER 14- The periodic review decision popup is displayed.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "review wizard")));

				test.log(LogStatus.PASS, "28.Enter pin and comment.");
				periodicReviews.reviewPIN_TextBox().sendKeys(routeData[1][12]);

				test.log(LogStatus.PASS, "29.Click on confirm button.");
				periodicReviews.checkInRouteSubmit_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find The periodic review decision popup.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "review wizard")));
			}

			test.log(LogStatus.PASS, "30.Logout and login again as the Test user 1 and select the document in the user's periodic reviewer's list.");
			logout.logoutFunction();
			sleep(2);
			login.loginUser(loginData[7][0], loginData[7][1]);

			periodicReviews.wizard_Option().click();
			sleep(2);
			periodicReviews.wizardReview_Tab().click();
			sleep(2);

			for(int i=1; i<=20; i++)
			{
				verifyDocForReview(documetNo);
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
			selectDocForReview(documetNo);

			if(periodicReviews.noChangesRequired_FirstReviewer().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER 15- The periodic review action performed by the second test user is updated.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "periodic review action performed")));
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find the periodic review action performed by the second test user's updated.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "periodic review action performed")));
			}

			verticalScrollingDown();
			test.log(LogStatus.PASS, "31.Bypass the Third test user (Test User 3 from Prerequisite 2).");
			periodicReviews.secondPeriodicReviewer_ContextTab().click();
			sleep(2);
			periodicReviews.secondPeriodicReviewer_Bypass().click();
			sleep(2);
			periodicReviews.yes_Button().click();
			sleep(5);

			test.log(LogStatus.PASS, "32.Click on 'View Document'.");
			periodicReviews.viewDocButtonForPeriodicReview().click();
			sleep(5);
			verticalScrollingUp();
			sleep(1);
			
			if(periodicReviews.dontChange_Button().isEnabled() && periodicReviews.change_Button().isEnabled())
			{
				test.log(LogStatus.PASS, "<b>ER 16- The document is displayed in a new tab and the periodic review Change/Don't Change buttons are available.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "periodic review action performed")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find the document is displayed in a new tab and the periodic review Change/Don't Change buttons are available.");
			}

			test.log(LogStatus.PASS, "33.Click on 'Don't Change', then sign by providing a pin and comments. Click Confirm.");
			verticalScrollingUp();
			sleep(1);
			periodicReviews.dontChange_Button().click();
			sleep(2);
			periodicReviews.reviewPIN_TextBox().sendKeys(routeData[1][12]);
			periodicReviews.checkInRouteSubmit_Button().click();
			sleep(2);
			periodicReviews.wizard_Option().click();
			sleep(2);
			periodicReviews.wizardReview_Tab().click();
			sleep(2);

			test.log(LogStatus.PASS, "34.View the list of periodic reviews awaiting the first test user.");
			for(int i=1; i<=20; i++)
			{
				verifyDocForReview(documetNo);
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
				test.log(LogStatus.PASS, "<b>ER 17- The document is removed from the list.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "document is removed")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Able to find The document in the list."+
						test.addScreenCapture(captureScreenShot(driver, "document is removed")));
			}

			test.log(LogStatus.PASS, "35.Log in to the local admin user and view the audit logs (administration> Audit log)");
			logout.logoutFunction();
			sleep(2);
			login.loginUser(loginData[7][0], loginData[7][1]);
			periodicReviews.administratorDropDown().click();
			periodicReviews.auditLog_Option().click();
			sleep(2);

			test.log(LogStatus.PASS, "36.Select type Bypass required reviewer and click on confirm.");
			periodicReviews.auditLogType_DropDown().selectByVisibleText(AuditLogs[1][0]); 
			sleep(2);
			periodicReviews.auditLogConfirm_Button().click();
			sleep(2);
			verticalScrollingDown();

			if(verifyValuesInAuditLog(loginData[11][2], 8)&&verifyValuesInAuditLog(loginData[12][2], 8))
			{

				test.log(LogStatus.PASS, "<b>ER 18- The Bypass on Test user 2 and final bypass action on the Test user 3 is available in the audit log.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "periodic review action performed")));
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find the Bypass on Test user 2 and final bypass action on the Test user 3 is available in the audit log.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "periodic review action performed")));
			}

			test.log(LogStatus.PASS, "37.Select type Cleared Bypass of Required Reviewer and click on confirm.");
			verticalScrollingUp();
			periodicReviews.auditLogType_DropDown().selectByVisibleText(AuditLogs[2][0]); 
			sleep(2);
			periodicReviews.auditLogConfirm_Button().click();
			sleep(2);
			verticalScrollingDown();
			if(verifyValuesInAuditLog(loginData[11][2], 8))
			{
				test.log(LogStatus.PASS, "<b>ER 19- Clear bypass on the second test user is available in the audit log.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "periodic review action performed")));
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find the Clear bypass on the second test user is available in the audit log.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "periodic review action performed")));
			}

			test.log(LogStatus.PASS, "38.Select type Enter/Update Review and click on confirm.");
			verticalScrollingUp();
			sleep(2);
			periodicReviews.auditLogType_DropDown().selectByVisibleText(AuditLogs[3][0]); 
			sleep(2);
			verticalScrollingDown();
			sleep(2);
			if(verifyValuesInAuditLog(loginData[7][0], 2))
			{
				test.log(LogStatus.PASS, "<b>ER 20- The periodic review actions performed by the Test user 1 and Test user 3 are available in the audit logs.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "periodic review action performed")));
			}
			else
			{
				test.log(LogStatus.FAIL, "<b>Unable to find The periodic review actions performed by the Test user 1 and Test user 3 are available in the audit logs.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "periodic review action performed")));
			}

		}
		else
		{
			test.log(LogStatus.FAIL,"Unable to Create a new document form.");
		}
	}

	@AfterClass
	public void closeBrowserInstance()
	{		
		extent.endTest(test);
		driver.close();
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
		sleep(4);
	}

}
