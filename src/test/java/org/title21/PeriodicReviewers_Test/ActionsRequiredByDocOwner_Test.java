package org.title21.PeriodicReviewers_Test;


import java.io.IOException;
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
import org.title21.PeriodicReviewers_POM.ActionsRequiredByDocOwner_POM;
import org.title21.PeriodicReviewers_POM.PeriodicOwnedDocuments_POM;
import org.title21.dao.AdminData;
import org.title21.utility.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class ActionsRequiredByDocOwner_Test extends BaseClass{
	
	LoginPage_POM login; 
	LogoutPage_POM logout;
	static Logger log = Logger.getLogger(ActionsRequiredByDocOwner_Test.class);
	String className="";
	String eventType="IndxCard";
	String documetNo="";
	String documetsName="";
	String documentStatus="";
	String fileUploadPath="";
	boolean isRecordFound=false;
	boolean isRecordFound1=false;
	boolean isValueFound=false;
	DBQueries dbqueries;
	String uploadFileName="FileToUpload.txt";
	Table searchTable;
	ActionsRequiredByDocOwner_POM action;
	PeriodicOwnedDocuments_POM periodicReviews;
	PeriodicOwnedDocuments_Test periodicTest;
	String testcaseName="FileToUpload.txt";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;
	
	@BeforeClass
	public void openURL() 
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		login = new LoginPage_POM(driver);
		action= new ActionsRequiredByDocOwner_POM(driver);
		logout=new LogoutPage_POM(driver);
		dbqueries = new DBQueries();
		periodicReviews=new PeriodicOwnedDocuments_POM(driver);	
		periodicTest = new PeriodicOwnedDocuments_Test();
		login.loginUser(loginData[7][0], loginData[7][1]);
		
	}
	@Test(testName = "ActionsRequiredByDocOwner", groups = "Periodic Review", priority = 0)
	public void ActionsRequiredByDocOwner_Prerequisites() throws Exception 
	{
		//DBConnection.executeStoredProcedure(dbqueries.moveDocsOnReleaseDate);
		test = extent.startTest("ActionsRequiredByDocOwner_Test");	
		test.log(LogStatus.PASS, "1.Login as Test user 1(Owner) " + "<br/>"	);
		//================================================================Prerequisites=================================================================================
		/*action.administratorDropDown().click();
		action.administrationLink().click();
		sleep(2);
		action.DocumentTypes().click();
		sleep(2);
		action.getEventType().selectByVisibleText(eventType);
		sleep(2);
		
		action.getEventLocation().selectByVisibleText(routeData[1][4]);
		sleep(2);
		
		action.getFilterResults().sendKeys("ANT-FORM");
		sleep(2);
		action.getGoButton().click();
		sleep(2);
		action.getANTFORMEditButton().click();
		sleep(2);
	    verticalScrollingDown();
	    sleep(2);
	    action.verifyPeriodicReviewsCheckBox2(true);
	    sleep(2);
	    action.getCloseWindow().click();
		sleep(2);
		action.administratorDropDown().click();
		action.administrationLink().click();
		sleep(2);
		action.DocumentTypes().click();
		sleep(2);
		action.getEventType().selectByVisibleText(eventType);
		sleep(2);
		action.getEventLocation().selectByVisibleText(routeData[1][4]);
		sleep(2);
		action.getFilterResults().sendKeys("ANT-SOP");
		sleep(2);
		action.getGoButton().click();
		sleep(2);
		action.getANTSOPEditButton().click();
		sleep(2);
		action.verifyPeriodicReviewsCheckBox1(true);
		sleep(2);
		action.getCloseWindow().click();
		sleep(3);*/
		
		test.log(LogStatus.PASS,"2.	Create a new document with the document type used in prerequisite 3");
		periodicReviews.getnewdoc().click();
		sleep(3);
		periodicReviews.getdocument().click();
		sleep(3);
		periodicReviews.getlocationDrodown().selectByVisibleText("All");
		sleep(2);
		action.getSearch().clear();
		sleep(1);
	    action.getSearch().sendKeys("ANT-FORM");
		sleep(2);
		
        action.getGoBtn().click();
		sleep(2);

		documetNo = periodicReviews.document_No().getAttribute("value");
		periodicReviews.getDocumentTitle().sendKeys("Actions required by doc Owner"); 
		sleep(2);
		periodicReviews.getDocChangeSummary().sendKeys("Actions required by doc Owner");
		verticalScrollingDown();
		periodicReviews.getConfirmButton().click();
		sleep(5);
		if(periodicReviews.getdocumentcreationverify().isDisplayed()) 
		{
			test.log(LogStatus.PASS,"3.	Add a main file, approvers and other required fields.");
			periodicReviews.addMainFile_Button().click();

			sleep(2);
			if(periodicReviews.addMainFileHeader_Text().isDisplayed())
			{
				fileUploadPath=System.getProperty("user.dir") + "\\testdata";
				fileUploadPath=fileUploadPath+"\\"+uploadFileName;
				periodicReviews.browse_Button().sendKeys(fileUploadPath);

				sleep(3);
				periodicReviews.add_Button().click();
				sleep(3);
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
				sleep(2);
				periodicReviews.getSequenceinAddApprover().selectByVisibleText("1");
				periodicReviews.getallottedDaysinAddApprover().selectByVisibleText(routeData[1][7]);
				sleep(3);
				periodicReviews.approverAdd_Button().click();
				sleep(5);

			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find Add new approver popup screen."+
						test.addScreenCapture(captureScreenShot(driver, "new approver popup")));
			
			}
			periodicReviews.general_Tab().click();
			sleep(2);
			
			scrollIntoView(periodicReviews.periodicReviewsDays_TextBox());
			test.log(LogStatus.PASS, "4.Go to the periodic review section.");
			sleep(2);
			
			test.log(LogStatus.PASS, "5.Enter days per review (for eg: 7)");
			periodicReviews.periodicReviewsDays_TextBox().clear();
			periodicReviews.periodicReviewsDays_TextBox().sendKeys("7");
			sleep(2);
			
			sleep(2);
			test.log(LogStatus.PASS, "6.Add one periodic reviewer by clicking on Edit Periodic Reviewers link.");
			scrollIntoView(periodicReviews.editPeriodicReviewers_Link());
			periodicReviews.editPeriodicReviewers_Link().click();
			sleep(5);
			
			periodicReviews.getlocationDrodown().selectByVisibleText("All");
			sleep(2);
		
			sleep(2);
			periodicReviews.availablePeriodicReviewers_Filter().click();
			periodicReviews.availablePeriodicReviewers_Filter().sendKeys("Check in User");
			sleep(4);
			if(periodicReviews.AvailablePeriodicReviewers_SearchResultArea().isDisplayed())
			{
				periodicReviews.availablePeriodic_MoveButton().click();
				
			}
			else
			{
				test.log(LogStatus.PASS, "Periodic Reviewers is not displyed after specific search.");
			}
		
			periodicReviews.save_Button().click();
			sleep(5);
			
			verticalScrollingUp();
			verticalScrollingUp();
			sleep(2);
			periodicReviews.docContext_Menu().click();
			sleep(2);
			periodicReviews.checkIn_Route().click();

			test.log(LogStatus.PASS, "7.CheckIn the document and rout in for approval.");
			sleep(2);
			periodicReviews.checkInRouteSubmit_Button().click();
			sleep(2);
			periodicReviews.close_Button().click();
			sleep(2);
		}
		
		logout.logoutFunction();
		login.loginFunction();
		
		approveDocFromWizard(documetNo);
		sleep(5);
		
		test.log(LogStatus.PASS,"8.Approve the document and make it effective.");
		DBConnection.executeStoredProcedure(dbqueries.moveDocsOnReleaseDate);
		
		action.getDashboard().click();
		sleep(2);
		
		action.getEffectiveDOC().click();
		sleep(5);
		
		test.log(LogStatus.PASS, "<b><b>"+
				test.addScreenCapture(captureScreenShot(driver, "Approved document effective")));
		sleep(2);

        logout.logoutFunction();
        test.log(LogStatus.PASS,"9.Logout as Test user 1");
         sleep(2);
         
         test.log(LogStatus.PASS,"10.Login as Test user 2(periodic reviewer added in step");
         login.loginUser("checkin", "test123456");
         sleep(2);
         
         
            test.log(LogStatus.PASS, "11.Open the periodic review wizard to view a list of documents awaiting the user's review. ");
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
				test.log(LogStatus.PASS, "<b>ER 1- Periodic review of the document is available in Test User 2’s wizard</b>"+
						test.addScreenCapture(captureScreenShot(driver, "review wizard")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find The document for which periodic review has been set is available."+
						test.addScreenCapture(captureScreenShot(driver, "review wizard")));
			}
			
			test.log(LogStatus.PASS, "12.Click to view the document and perform the periodic review with a review decision as 'Change'/'Changes Required'");
			periodicReviews.wizard_Option().click();
			sleep(2);
			selectDocForReviewFromTable(documetNo);
			action.getchangeBTN().click();
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		}

		@AfterClass
		public void closeBrowserInstance() throws IOException 
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
		private void selectDocForReviewFromTable(String docName)
		{
		    periodicReviews.wizard_Option().click();
		    action.getreviewTab().click();
		    sleep(2);
		    isRecordFound = false;
		    for(int i=1; i<=20; i++)
		    {
		   	 selectDocForReview(docName);
		      if(!isValueFound)
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
		    action.viewDocButtonForPeriodicReview().click();
		    sleep(3);
		  }
		
}