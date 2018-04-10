package org.title21.Documents_test;

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
import org.title21.Documents_POM.PeriodicOwnedDocuments_POM;
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
		sleep(2);
		waitTillElementVisible(periodicReviews.getdocument());
		periodicReviews.getdocument().click();
		sleep(3);
		periodicReviews.getlocationDrodown().selectByVisibleText(routeData[1][0]);
		sleep(2);
		documetNo = periodicReviews.document_No().getAttribute("value");
		periodicReviews.getDocumentTitle().sendKeys(routeData[1][1]+documetNo); 
		periodicReviews.getDocChangeSummary().sendKeys(routeData[1][2]+documetNo);
		verticalScrollingDown();
		periodicReviews.getConfirmButton().click();
		sleep(5);
		if(periodicReviews.getdocumentcreationverify().isDisplayed()) 
		{
			test.log(LogStatus.PASS,"3.Add a main file, approvers and other required fields.");
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
			sleep(2);
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
			String dd = preDate[1];
			if(dd.contains("0"))
			{
				dd=dd.substring(1, 2);
			}
			periodicReviews.pickDate_TextBox().click();
			driver.findElement(By.xpath("//td[text()='"+dd+"']")).click();
			
			scrollIntoView(periodicReviews.docTargetReleaseDate_TextBox());
			test.log(LogStatus.PASS, "8.Set the target release date to the current date.");
			String targetReleaseDate = DateTimeUtils.getYesterdayDate();
			String[] preDate1 = targetReleaseDate.split("/");
			String Releasedd = preDate1[1];
			if(Releasedd.contains("0"))
			{
				Releasedd=Releasedd.substring(1, 2);
			}
			periodicReviews.pickDate_TextBox().click();
			driver.findElement(By.xpath("//td[text()='"+Releasedd+"']")).click();
			
			test.log(LogStatus.PASS, "9.Click on 'Edit Periodic Reviewers' link.");
			scrollIntoView(periodicReviews.editPeriodicReviewers_Link());
			periodicReviews.editPeriodicReviewers_Link().click();
			sleep(2);
			
			if(periodicReviews.editPeriodicReviewers_HeaderText().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER1- The Edit periodic reviewer's popup screen is displayed.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Edit periodic reviewer")));
				
				test.log(LogStatus.PASS, "10.Select location.");
				periodicReviews.editPeriodicReviewersLocationDropDown().selectByVisibleText("routeData[1][0]");
				
				test.log(LogStatus.PASS, "11.Select two reviewers.");
				periodicReviews.availablePeriodicReviewers_Filter().clear();
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
			periodicReviews.docContext_Menu().click();
			sleep(2);
			periodicReviews.checkIn_Route().click();

			sleep(2);
			periodicReviews.checkInRouteSubmit_Button().click();
			sleep(2);
			if(periodicReviews.messagePopUp_Header().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER 3- The document is checked in and route for approval.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Route is added")));

				periodicReviews.verifyDocumentCheckedIn(driver);
				periodicReviews.close_Button().click();
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find check in route pop up.");
			}
			
			test.log(LogStatus.PASS, "14.Login with approver's login and approve the document.");
			logout.logoutFunction();
			login.loginUser(loginData[1][0], loginData[1][1]); 
			approveDocFromWizard(documetNo);
			test.log(LogStatus.PASS, "<b>ER 4- The document is approved successfully and displays the successful message.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "document is approved successfully")));
			
			test.log(LogStatus.PASS, "15.Login with Test user1");
			login.loginUser(loginData[7][0], loginData[7][1]);
			
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
			periodicReviews.wizardReview_Tab().click();
			
			for(int i=1; i<=20; i++)
			{
				verifyDocForApprovel(documetNo);
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
			selectDocForApprovel(documetNo);
			
			/*if()
			{
				//verify buttons are not enable 
				test.log(LogStatus.PASS, "<b>ER 7- The document is not ready to sign (as it is waiting for others to review) and the Change/Don’t Change buttons are not available.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "document is not ready to sign")));
			}
			else
			{
				test.log(LogStatus.PASS, "<b>Unable to find the- The document is not ready to sign (as it is waiting for others to review) and the Change/Don’t Change buttons are not available.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "document is not ready to sign")));
			}*/
			
			test.log(LogStatus.PASS, "19.Click on the context menu for one of the periodic reviewers.");
			
			
			test.log(LogStatus.PASS, "20.Click on 'Bypass' to bypass the test user 2. (1st periodic reviewer added in step(10)).");
			
			
			
			
			
			
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
		List<WebElement> tableCells=searchTable.getcollapseDocumentstableCells(2);				
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

	private boolean selectDocForApprovel(String docName) 
	{
		isRecordFound=false;
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getcollapseDocumentstableCells(2);				
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
