package org.title21.Documents_Test;


import org.testng.annotations.Test;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.Documents_POM.CreateDocument_POM;
import org.title21.Documents_POM.MyDocs_POM;
import org.title21.utility.BaseClass;
import org.title21.utility.FileUpload;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.AfterClass;

public class DetailedCheckout_Test extends BaseClass
{
	LoginPage_POM login; 
	LogoutPage_POM logout;
	CreateDocument_POM Credoc;
	MyDocs_POM mydocs;
	FileUpload fileup;
	String fileUploadPath = "";
	String uploadFileName = "FileToUpload.txt";
	String className="";

	@BeforeClass
	public void beforeClass()
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		login=new LoginPage_POM(driver);
		logout=new LogoutPage_POM(driver);
		mydocs =new org.title21.Documents_POM.MyDocs_POM(driver);
		Credoc=new CreateDocument_POM(driver);
		fileup = new FileUpload();
	}

	@Test(testName = "DocumentCheckoutInDetail", groups = "DocumentModule", priority = 0)
	public void DocumentCheckoutInDetail()
	{
		preRequisites();
		test = extent.startTest("Document Checkout in Details");
		login.loginUser(loginData[5][0], loginData[5][1]);
		
		test.log(LogStatus.PASS,"1.	Login to the web interface as a test user.");
		
		mydocs.clickCreatedDocFromRecentViewed(mydocs.docID); 				sleep(2);
		mydocs.getEditModeON().click(); 									sleep(2);
		mydocs.getContextMenu().click(); 									sleep(2);
		mydocs.getCheckinContextMenu().click(); 							sleep(2);
		mydocs.getCheckinButton().click(); 									sleep(3);
		mydocs.getCheckinCloseButton().click(); 							sleep(3);
		
		test.log(LogStatus.PASS,"2. Find the effective document satisfying prerequisite.");
		
		mydocs.getContextMenu().click(); 									sleep(2);
		mydocs.getCheckoutContextMenu().click(); 							sleep(2);
		
		test.log(LogStatus.PASS,"3.	Check out the document.");
		test.log(LogStatus.PASS,"<b>ER1: Checkout dialog is displayed.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Checkout Dialog Box")));
		
		mydocs.documentApproverCheck(false);								sleep(1);
		mydocs.attachmentCheck(false);										sleep(1);
		mydocs.trainingItemsCheck(false);									sleep(2);
		
		test.log(LogStatus.PASS,"4.	Ensure that the checkboxes Document Approvers (if any),"
				+ " Attachments (if any) and Training items are not checked.");
		test.log(LogStatus.PASS,"<b>ER2: Options are unchecked.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Options Unchecked")));
		
		mydocs.getCheckoutConfirmButton().click();							sleep(5);
		
		test.log(LogStatus.PASS,"5.	Click on confirm button.");
		
		verticalScrollingDown();											sleep(2);
		verticalScrollingDown();											sleep(2);
		verticalScrollingDown();											sleep(2);
		
		test.log(LogStatus.PASS,"6.	Check the attachment control of the document checked out.");
		
		if (mydocs.verifyNoAttachmentPresent()==false)
		{
			test.log(LogStatus.PASS,"<b>ER3: There are no attached document. <b>"+
					test.addScreenCapture(captureScreenShot(driver, "No Attached Doc")));
		}
		else if (mydocs.verifyNoAttachmentPresent()==true)
		{
			test.log(LogStatus.FAIL,"<b>ER3: Document is attached <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Attachment Exist")));
		}
		
		
		verticalScrollingUp();												sleep(2);
		verticalScrollingUp();												sleep(2);
		mydocs.getDocumentApproval().click();								sleep(2);
		
		test.log(LogStatus.PASS,"7.	Check the approval tab of the document.");
		
		if (mydocs.verifyNoApproverPresent()==false)
		{
			test.log(LogStatus.PASS,"<b>ER4: There are no approvers listed.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "No Attached Doc")));
		}
		else if (mydocs.verifyNoApproverPresent()==true)
		{
			test.log(LogStatus.FAIL,"<b>ER4: Approver's are listed. <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Approver Exist")));
		}
		
		
		mydocs.trainingTab().click();										sleep(2);
		verticalScrollingDown();											sleep(2);
		
		test.log(LogStatus.PASS,"8. Check the training tab of the document.");
		
		if (mydocs.verifyNoTrainingEntitiesPresent()==false)
		{
			test.log(LogStatus.PASS,"<b>ER5: There is no read and sign training scheduled and no entities selected.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "No Traning entities present")));
		}
		else if (mydocs.verifyNoTrainingEntitiesPresent()==true)
		{
			test.log(LogStatus.FAIL,"<b>ER5: Training's entities are listed. <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Training Exist")));
		}
		
		verticalScrollingUp();												sleep(2);
		mydocs.getContextMenu().click();									sleep(2);
		verticalScrollingDown();											sleep(2);
		
		test.log(LogStatus.PASS,"9. Undo checkout (from the context menu)."+
				test.addScreenCapture(captureScreenShot(driver, "Undo Checkout")));
		
		mydocs.getUndoCheckoutContextMenu().click();						sleep(3);
		mydocs.undoCheckoutYesButton().click();								sleep(3);
		
		test.log(LogStatus.PASS,"<b>ER6: Undo checkout is complete<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Undo Checkout Success")));
		
		mydocs.getCheckinCloseButton().click();								sleep(3);
		
		mydocs.searchDocument(mydocs.docID).click();						sleep(2);
	
		mydocs.getContextMenu().click(); 									sleep(2);
		mydocs.getCheckoutContextMenu().click(); 							sleep(2);
		mydocs.selectSectionDrawer().selectByVisibleText("Regulated");		sleep(2);
		mydocs.documentApproverCheck(true);									sleep(1);
		mydocs.attachmentCheck(true);										sleep(1);
		mydocs.trainingItemsCheck(true);									sleep(2);
		
		test.log(LogStatus.PASS,"10. Try to check out the document from Prerequisite 3 but this time, ensure the checkboxes Document Approvers (if any),"
				+ "Attachments (if any) and Training items are checked");
		test.log(LogStatus.PASS,"<b>ER7: Checkboxes are checked <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Checkboxes are checked ")));
		
		mydocs.getCheckoutConfirmButton().click();							sleep(5);
		
		test.log(LogStatus.PASS,"11. Confirm checkout.");
		
		verticalScrollingDown();											sleep(2);
		verticalScrollingDown();											sleep(2);
		
		test.log(LogStatus.PASS,"12. Check the periodic review control of the document checked out "
				+ "and compare it with the effective document.");
		
		if (mydocs.beforeCheckReviewer().containsAll(mydocs.afterCheckReviewer()))
		{
			test.log(LogStatus.PASS,"<b>ER8: Periodic reviewer(s) match<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Reviewer Matches")));
		}
		else
		{
			test.log(LogStatus.FAIL,"<b>ER8: Periodic reviewer(s) does not match <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Reviewer does not match")));
		}
		
		verticalScrollingDown();											sleep(2);
		
		test.log(LogStatus.PASS,"13. Check the attachment control of the document checked out "
				+ "and compare it with the effective document.");
		
		if (mydocs.beforeCheckAttachment().containsAll(mydocs.afterCheckAttachment()))
		{
			test.log(LogStatus.PASS,"<b>ER9: Attachment(s) match <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Attachment Matches")));
		}
		else
		{
			test.log(LogStatus.FAIL,"<b>ER9: Attachment(s)does not match <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Attachment does not match")));
		}
		
		test.log(LogStatus.PASS,"14. Check the linked document control of the document checked out "
				+ "and compare it with the effective document ");
		
		if (mydocs.beforeCheckLinks().containsAll(mydocs.afterCheckLinks()))
		{
			test.log(LogStatus.PASS,"<b>ER10: Linked document(s) match <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Linked Document Matches")));
		}
		else
		{
			test.log(LogStatus.FAIL,"<b>ER10: Linked document(s) does not match <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Linked document does not match")));
		}
		
		verticalScrollingUp();												sleep(2);
		verticalScrollingUp();												sleep(2);
		
		mydocs.trainingTab().click();										sleep(2);
		
		verticalScrollingDown();											sleep(2);
		
		test.log(LogStatus.PASS,"15. Check the training control of the document checked out "
				+ "and compare it with the effective document ");
		
		if (mydocs.beforeCheckEntities().containsAll(mydocs.afterCheckEntities()))
		{
			test.log(LogStatus.PASS,"<b>ER11: Read and sign training details and entities selected match <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Entities Matches")));
		}
		else
		{
			test.log(LogStatus.FAIL,"<b>ER11: Read and sign training details and entities selected does not match <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Entities does not match")));
		}
		
		verticalScrollingUp();												sleep(2);
		mydocs.getDocumentApproval().click();								sleep(2);
		
		test.log(LogStatus.PASS,"16. Check the Approval control of the document checked out "
				+ "and compare it with the effective document.");
		
		if (mydocs.beforeCheckApprover().containsAll(mydocs.afterCheckApprover()))
		{
			test.log(LogStatus.PASS,"<b>ER12: Approver(s) match <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Aprrover Matches")));
		}
		else
		{
			test.log(LogStatus.FAIL,"<b>ER12: Approver(s) does not match <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Approver does not match")));
		}
		
		mydocs.codesTab().click();											sleep(2);
		
		test.log(LogStatus.PASS,"17. Check the Codes control of the document checked out "
				+ "and compares it with the effective document.");
		
		if (mydocs.beforeCheckCodes().containsAll(mydocs.afterCheckCodes()))
		{
			test.log(LogStatus.PASS,"<b>ER13: Codes(s) match <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Codes Matches")));
		}
		else
		{
			test.log(LogStatus.FAIL,"<b>ER13: Codes(s) does not match <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Codes does not match")));
		}
		
		sleep(3);
		logout.logoutFunction();
	}

	public void preRequisites()
	{
		login.loginUser(loginData[5][0], loginData[5][1]);
		Credoc.getnewdoc().click();											sleep(2);
		Credoc.getdocument().click();										sleep(2);
		Credoc.getlocationDrodown().selectByVisibleText("Pittsburgh");		sleep(3);
		Credoc.getSearchText().sendKeys("SOP.CT");							sleep(2);
		Credoc.getGoButton().click();										sleep(2);
		Credoc.selectType().click();										sleep(2);
		Credoc.getDocTitle().sendKeys("TestDocument");
		Credoc.getDocChangeSummary().sendKeys("Test Summary");
		mydocs.docID = Credoc.getdocumentnumber().getAttribute("value");
		verticalScrollingDown();
		Credoc.getConfirmButton().click();									sleep(2);
		Credoc.editPeriodicReviewer().click();								sleep(2);
		Credoc.getlocationDrodown().selectByVisibleText("All");				sleep(2);
		Credoc.selectPeriodicReviewer("Secret Tester");						sleep(2);
		Credoc.saveButton().click();										sleep(2);
		mydocs.beforeCheckReviewer();
		verticalScrollingDown();											sleep(1);
		Credoc.addAttachment().click();										sleep(3);
		Credoc.fileupload(uploadFileName);									sleep(9);
		mydocs.beforeCheckAttachment();
		Credoc.addNewLinks().click();										sleep(3);
		Credoc.addLinkSearch().sendKeys("SOP.CT");							sleep(2);
		Credoc.addLinkGoButton().click();									sleep(2);
		Credoc.selectLinkToAdd().click();									sleep(2);
		verticalScrollingDown();											sleep(2);
		Credoc.saveButton().click();										sleep(2);
		mydocs.beforeCheckLinks();
		verticalScrollingUp();												sleep(3);
		verticalScrollingUp();												sleep(3);

		mydocs.getDocumentApproval().click();								sleep(2);
		mydocs.getApprover().click();										sleep(2);
		mydocs.selectRole().selectByVisibleText("Approver");				sleep(3);
		mydocs.addApproverLocation().selectByVisibleText("All");			sleep(3);
		mydocs.addApproverName().selectByVisibleText("sameer");				sleep(2);
		mydocs.addApproverSequence().selectByVisibleText("1");				sleep(2);
		mydocs.addApproverAllotedDays().selectByVisibleText("3 weeks");		sleep(3);
		Credoc.saveButton().click();										sleep(2);
		mydocs.beforeCheckApprover();
		mydocs.trainingTab().click();										sleep(2);
		mydocs.changeTrainingTab().click();									sleep(2);
		mydocs.selectTrainingType(2);										sleep(2);
		Credoc.saveButton().click();										sleep(2);
		verticalScrollingDown();											sleep(2);
		mydocs.selectEntitiesSubject(1);									sleep(2);
		mydocs.editEntities().click();										sleep(2);
		Credoc.selectEntities("Person User");								sleep(2);
		Credoc.saveButton().click();										sleep(2);
		mydocs.beforeCheckEntities();
		verticalScrollingUp();												sleep(2);

		mydocs.codesTab().click();											sleep(2);
		mydocs.selectCodeClass().selectByVisibleText("Error Codes");		sleep(2);
		mydocs.codeCategory("Test");										sleep(2);
		mydocs.codeName("Incorrect");										sleep(2);
		mydocs.beforeCheckCodes();
		logout.logoutFunction();
	}

	@AfterClass
	public void afterClass()
	{
		extent.endTest(test);
		driver.quit();
	}

}
