package org.title21.Documents_Test;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.AdminModule_POM.WizardPage_POM;
import org.title21.Documents_POM.CreateDocument_POM;
import org.title21.Documents_POM.MyDocs_POM;
import org.title21.utility.BaseClass;
import org.title21.validation.entities.ErrorMessages;

import com.relevantcodes.extentreports.LogStatus;

public class CheckInCheckOut_Test extends BaseClass
{
	LoginPage_POM login; 
	LogoutPage_POM logout;
	CreateDocument_POM Credoc;
	MyDocs_POM mydocs;
	WizardPage_POM wizpage;
	String className="";
	String testcaseName="TestCase-WIA-Check_In & Checkout.doc";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;

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
		wizpage = new WizardPage_POM(driver);
	}

	@Test(testName = "Check In And Check Out", groups = "DocumentModule", priority = 0)
	public void checkInCheckOut()
	{
		test = extent.startTest("Check In and Check Out Document");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		login.loginUser(loginData[4][0], loginData[4][1]);
		sleep(2);
		test.log(LogStatus.PASS,"1. Login to Web Application as a Test User");
		
		Credoc.getnewdoc().click();
		sleep(2);
		Credoc.getdocument().click();
		sleep(2);

		Credoc.getlocationDrodown().selectByVisibleText("Pittsburgh");
		sleep(2);
		Credoc.getSearchText().sendKeys("SOP.CT");
		sleep(1);
		Credoc.getGoButton().click();
		sleep(2);
		Credoc.selectType().click();
		sleep(2);
		Credoc.getAutoCheck().selectByVisibleText("Check Out User");
		sleep(2);
		Credoc.getDocTitle().sendKeys("TestDocument");
		Credoc.getDocChangeSummary().sendKeys("Test Summary");
		mydocs.docID = Credoc.getdocumentnumber().getAttribute("value");
		verticalScrollingDown();
		Credoc.getConfirmButton().click();
		sleep(2);
		test.log(LogStatus.PASS,"2.	Create a new document form and set Auto Check Out to another user. Created Doc ID: "+mydocs.docID);
		if(Credoc.permissionToEditMessage()==true)
		{
			test.log(LogStatus.PASS,"<b>ER1: Document has been created successfully and a message appears: You don't have permissions to edit form DOC. <b>"+
					test.addScreenCapture(captureScreenShot(driver, "No Permission to Edit")));
		}
		else
		{
			test.log(LogStatus.FAIL,"<b>ER1: Document has been created successfully but message didnt Appeared.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "No Message")));
		}

		logout.logoutFunction();
		test.log(LogStatus.PASS,"3.	Logout with the test user ");
		login.loginUser(loginData[5][0], loginData[5][1]);
		sleep(2);
		test.log(LogStatus.PASS,"4.	Log in with the user which is set as Auto Checkout to at Step 2");
		mydocs.getMyDocs().click();
		test.log(LogStatus.PASS,"5.	Go to My doc");
		mydocs.getCheckOutByMe().click();
		test.log(LogStatus.PASS,"6.	Click on Checked out to me link ");


		if(mydocs.firstDocumentID()==true)
		{
			test.log(LogStatus.PASS,"<b>ER2: Document should get reflected in checkout to me section. <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Document visible in check out by me")));
		}
		else
		{
			test.log(LogStatus.FAIL,"<b>ER2: Failed, unable to find document in checkout by me. <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Document is not visible in check out by me")));
		}

		logout.logoutFunction();
		test.log(LogStatus.PASS,"7.	Logout");
		login.loginUser(loginData[4][0], loginData[4][1]);
		sleep(1);
		test.log(LogStatus.PASS,"8.	Login with the test user");

		mydocs.clickCreatedDocFromRecentViewed(mydocs.docID);
		sleep(2);
		mydocs.getContextMenu().click();
		sleep(2);
		mydocs.getCheckinContextMenu().click();
		sleep(2);
		mydocs.getCheckinButton().click();
		sleep(2);
		mydocs.getCheckinCloseButton().click();
		sleep(2);
		mydocs.getContextMenu().click();
		sleep(2);
		mydocs.getCheckoutContextMenu().click();
		sleep(2);
		mydocs.getCheckoutPerson().clear();
		sleep(2);
		mydocs.getCheckoutPerson().sendKeys("Person User");
		sleep(2);
		test.log(LogStatus.PASS,"9.	Try to check out a document to another user using Person field ");
		mydocs.getCheckoutConfirmButton().click();
		sleep(2);

		test.log(LogStatus.PASS,"<b>ER3: Successfully able to check out a document to someone else. <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Succsessful checkout to another user")));

		mydocs.getCheckinCloseButton().click();
		sleep(2);
		test.log(LogStatus.PASS,"10. Click on Close. ");

		logout.logoutFunction();
		sleep(1);
		login.loginUser(loginData[6][0], loginData[6][1]);
		test.log(LogStatus.PASS,"11. Log in with the user which is set as Person to Checkout in step 9 ");
		sleep(2);

		mydocs.getMyDocs().click();
		sleep(2);
		test.log(LogStatus.PASS,"12. Go to My Docs ");
		mydocs.getCheckOutByMe().click();
		sleep(2);
		test.log(LogStatus.PASS,"13. Click on Checked out to me link. ");
		mydocs.getSearch().sendKeys(mydocs.docID);
		sleep(2);
		test.log(LogStatus.PASS,"14. Search for a document which is checkout in step 2 and opens the document.");
		mydocs.getGoButton().click();
		sleep(2);
		mydocs.getFirstDocumentName().click();
		sleep(2);
		mydocs.getDocumentApproval().click();
		sleep(2);
		mydocs.getEditModeON().click();
		sleep(2);
		mydocs.getSignatureRoute().click();
		sleep(2);
		mydocs.getRouteName().selectByVisibleText("tech QA team");
		sleep(2);
		test.log(LogStatus.PASS,"15.Go to Document Approval tab and add Signature route. "+
				test.addScreenCapture(captureScreenShot(driver, "Route Name Selected")));
		mydocs.getSignatureRouteAddButton().click();
		sleep(2);
		test.log(LogStatus.PASS,"<b>ER4: Signature Route is added successfully. <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Succsessful added Signature Route")));

		mydocs.getContextMenu().click();
		sleep(2);
		mydocs.getCheckinContextMenu().click();
		sleep(2);
		test.log(LogStatus.PASS,"16. Check in the document ");
		mydocs.getCheckoutConfirmButton().click();
		sleep(3);
		test.log(LogStatus.PASS,"<b>ER5: a Successful message that the document has been checked In is displayed. <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Succsessful document checkin")));
		mydocs.getCheckinCloseButton().click();
		sleep(2);

		mydocs.getContextMenu().click();
		sleep(1);
		mydocs.getRouteApporvalContext().click();
		sleep(2);
		mydocs.getCheckinButton().click();
		sleep(3);
		test.log(LogStatus.PASS,"17. Click on a route for approval. ");
		mydocs.getCheckinCloseButton().click();
		sleep(2);

		logout.logoutFunction();
		sleep(1);
		login.loginUser(loginData[1][0], loginData[1][1]);
		test.log(LogStatus.PASS,"18. Login as users named in Sequence 1 in step 15 ");

		wizpage.getWizardButton().click();
		sleep(2);
		wizpage.getApporvalButton().click();
		sleep(2);
		test.log(LogStatus.PASS,"19. Go to the Wizard>Approval");
		wizpage.getApprovalFilterText().sendKeys(mydocs.docID);
		sleep(2);
		wizpage.getApprovalGoButton().click();
		sleep(2);

		if (wizpage.getFirstDocText().contains(mydocs.docID))
		{
			test.log(LogStatus.PASS,"<b>ER6: The document is available in the approval wizard <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Document available for Approval")));
		} else
		{
			test.log(LogStatus.FAIL,"<b>ER6: The document is unavailable in approval wizard <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Document unavailable for Approval")));
		}
		
		wizpage.getApprovalFirstDoc().click();
		sleep(2);
		test.log(LogStatus.PASS,"20. Click on the Document link");
		wizpage.getFirstDocTab().click();
		sleep(5);
		test.log(LogStatus.PASS,"21. Navigate to document opened in next tab (i.e. next to Review tab)");
		wizpage.getRejectButton().click();
		sleep(2);
		test.log(LogStatus.PASS,"22. Click on Reject button ");
		
		test.log(LogStatus.PASS,"<b>ER7: Enter your pin to reject dialogue box is displayed <b>"+
				test.addScreenCapture(captureScreenShot(driver, "PIN Dialog Box")));
		
		wizpage.getPinText().sendKeys("262829");
		sleep(1);
		wizpage.getCommentText().sendKeys("Rejecting Document");
		sleep(2);
		test.log(LogStatus.PASS,"23. Enter PIN, mention Comments and click on Confirm.");
		wizpage.rejectConfirmButton().click();
		sleep(3);
		
		if (wizpage.getRejectMessageText().contains(ErrorMessages.rejectedmessage))
		{
			test.log(LogStatus.PASS,"<b>ER8: Document rejected message is displayed. <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Rejected message displayed")));
		} else
		{
			test.log(LogStatus.FAIL,"<b>ER8: Document rejected message is not displayed. <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Rejected message is not displayed")));
		}
		
		logout.logoutFunction();
		sleep(1);
		login.loginUser(loginData[6][0], loginData[6][1]);
		test.log(LogStatus.PASS,"24. Logout and Login with the user set as Person at step 9");
		
		mydocs.getMyDocs().click();
		sleep(2);
		test.log(LogStatus.PASS,"25. Go to My Doc section");
		
		mydocs.rejectedByOthers().click();
		sleep(2);
		test.log(LogStatus.PASS,"26. Click on Rejected by others link.");
		mydocs.getSearch().sendKeys(mydocs.docID);
		sleep(2);
		mydocs.getGoButton().click();
		sleep(2);
		
		if(mydocs.firstDocumentID()==true)
		{
			test.log(LogStatus.PASS,"<b>ER9: The document is available in the reject by others section. <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Document visible in rejected by others")));
		}
		else
		{
			test.log(LogStatus.FAIL,"<b>ER9: Failed, unable to find document in rejected by others. <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Document is not visible in rejected by others")));
		}
		
		logout.logoutFunction();
	}

	@AfterClass
	public void afterClass()
	{
		extent.endTest(test);
		driver.close();
	}

}