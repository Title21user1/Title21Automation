package org.title21.Santiy_Test;

import org.testng.annotations.Test;
import org.title21.AdminModule_POM.DashBord_POM;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.AdminModule_POM.WizardPage_POM;
import org.title21.Documents_POM.CreateDocument_POM;
import org.title21.Documents_POM.MyDocs_POM;
import org.title21.Documents_POM.RecentlyViewdAndFavorites_POM;
import org.title21.Module3_POM.Reports_POM;
import org.title21.Module3_POM.eBinders_POM;
import org.title21.utility.BaseClass;
import org.title21.utility.FunctionUtils;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;

public class Sanity_Test extends BaseClass
{
	LoginPage_POM login; 
	LogoutPage_POM logout;
	CreateDocument_POM createdoc;
	MyDocs_POM mydocs;
	eBinders_POM ebinder;
	Reports_POM reports;
	DashBord_POM dashboard;
	RecentlyViewdAndFavorites_POM favorites;
	WizardPage_POM wizpage;
	String className="";
	String docID="";
	String docTitle="Sanity Test "+FunctionUtils.generateRandomNumber();


	@BeforeClass
	public void beforeClass()
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		login=new LoginPage_POM(driver);
		logout=new LogoutPage_POM(driver);
		createdoc=new CreateDocument_POM(driver);
		mydocs=new MyDocs_POM(driver);
		ebinder=new eBinders_POM(driver);
		reports=new Reports_POM(driver);
		dashboard=new DashBord_POM(driver);
		favorites=new RecentlyViewdAndFavorites_POM(driver);
		wizpage=new WizardPage_POM(driver);
		
		dashboard.enableCIBMTR_LMS();												
		dashboard.enableCIBMTR_LMS_ForGroup("Sp Tester");
	}

	@Test(testName = "Sanity Test - Login", groups = "Sanity", priority = 0)
	public void Login_SanityTest()
	{
		test = extent.startTest("Login");
		
		login.loginUser(loginData[14][0],loginData[14][1]);
		
		test.log(LogStatus.PASS,"<b>ER: User is successfully logged-in.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Login Successfull")));

	}

	@Test(testName = "Sanity - Create Document", groups = "Sanity", priority = 1)
	public void CreateDocument_SanityTest()
	{
		test = extent.startTest("Create Document");
		createdoc.getnewdoc().click();												sleep(3);
		createdoc.getdocument().click();											sleep(3);
		createdoc.Search("SOP.CT");													sleep(3);
		createdoc.selectDocumentType("SOP.CT");										sleep(3);
		createdoc.getDocTitle().sendKeys(docTitle);									sleep(2);
		createdoc.getDocChangeSummary().sendKeys("Sanity Test Document Summary");	sleep(2);
		docID = createdoc.getdocumentnumber().getAttribute("value");				sleep(2);
		createdoc.getConfirmButton().click();										sleep(5);

		test.log(LogStatus.PASS,"<b>ER: Document it created <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Document Created")));
	}

	@Test(testName = "Sanity Test - CheckoutToMe", groups = "Sanity", priority = 2)
	public void CheckoutToMe_SanityTest()
	{
		test = extent.startTest("Document CheckOutToMe");
		mydocs.getMyDocs().click();													sleep(3);
		mydocs.getCheckOutByMe().click();											sleep(2);

		test.log(LogStatus.PASS,"<b>ER: Document created is available in CheckoutToMe section.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Document CheckoutToME")));
	}

	@Test(testName = "Sanity Test - Open Document Form", groups = "Sanity", priority = 3)
	public void DocumentForm_SanityTest()
	{
		test = extent.startTest("Open Document Form");
		createdoc.Search(docID);													sleep(2);
		mydocs.getContextMenuInList().click();										sleep(2);
		mydocs.form().click();														sleep(2);

		test.log(LogStatus.PASS,"<b>ER: Document form opens <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Document Form")));
	}

	@Test(testName = "Sanity Test - Undo Checkout Document", groups = "Sanity", priority = 4)
	public void UndoCheckout_SanityTest()
	{
		test = extent.startTest("Undo Checkout Document");
		mydocs.getContextMenu().click();											sleep(2);
		verticalScrollingDown();													sleep(1);
		mydocs.undoCheckoutForm().click();											sleep(2);
		mydocs.undoCheckoutYesButton().click();										sleep(10);
		mydocs.getCheckinCloseButton().click();										sleep(2);
		verticalScrollingUp();														sleep(2);

		test.log(LogStatus.PASS,"<b>ER: Document is removed <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Document Deleted")));
	}

	@Test(testName = "Sanity Test - eBindersDocument", groups = "Sanity", priority = 5)
	public void EbinderDocuments_SanityTest()
	{
		test = extent.startTest("eBinders Document");
		ebinder.getEbinders().click();												sleep(2);
		ebinder.expandEbinder("Lab");
		ebinder.selectEbinder("SOP");												sleep(3);

		test.log(LogStatus.PASS,"<b>ER: Documents are listed <b>"+
				test.addScreenCapture(captureScreenShot(driver, "eBinders Docs Listed")));
	}

	@Test(testName = "Sanity Test - Main PDF File", groups = "Sanity", priority = 6)
	public void MainPDF_SanityTest()
	{
		test = extent.startTest("Open Main PDF File");
		createdoc.Search("SOP.02");													sleep(2);
		mydocs.selectDocument("SOP.02").click();									sleep(2);
		mydocs.getContextMenu().click();											sleep(2);
		mydocs.mainFilePDFContextMenu().click();									sleep(5);

		test.log(LogStatus.PASS,"<b>ER: PDF of document displays <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Mail File PDF")));
	}

	@Test(testName = "Sanity Test - Search For Document", groups = "Sanity", priority = 7)
	public void SearchForDocument_SanityTest()
	{
		test = extent.startTest("Search For Document");
		mydocs.searchesTab().click();												sleep(2);
		createdoc.Search("Search on Document Number");								sleep(2);
		mydocs.selectDocument("Search on Document Number").click();					sleep(4);

		test.log(LogStatus.PASS,"<b>ER: Documents are listed <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Searches Doc Listed")));

	}

	@Test(testName = "Sanity Test - Open Reports", groups = "Sanity", priority = 8)
	public void OpenReports_SanityTest()
	{
		test = extent.startTest("Open Reports");
		reports.reports().click();													sleep(2);
		mydocs.selectDocument("Documents Approaching Review").click();				sleep(5);

		test.log(LogStatus.PASS,"<b>ER: Report displays <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Reports Displayed")));
	}

	@Test(testName = "Sanity Test - Navigate To Charts", groups = "Sanity", priority = 9)
	public void OpenCharts_SanityTest()
	{
		test = extent.startTest("Navigate To Charts");
		dashboard.toCharts().click();												sleep(2);
		mydocs.selectDocument("Top Disbursements by Entity").click();				sleep(5);

		test.log(LogStatus.PASS,"<b>ER: Charts interface displays <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Charts displayed")));
	}

	@Test(testName = "Sanity Test - Navigate To Favorites", groups = "Sanity", priority = 10)
	public void OpenFavorites_SanityTest()
	{
		test = extent.startTest("Navigate To Favorites");
		verticalScrollingDown();													sleep(1);
		favorites.getFavorite_tab().click();										sleep(5);

		test.log(LogStatus.PASS,"<b>ER: Favorites interface displays <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Favorites displayed")));
	}

	@Test(testName = "Sanity Test - Navigate To Wizard>Approval Tab", groups = "Sanity", priority = 11)
	public void OpenApprovalTab_SanityTest()
	{
		test = extent.startTest("Navigate To Wizard>Approval Tab");

		wizpage.getWizardButton().click();											sleep(2);
		wizpage.getApporvalButton().click();										sleep(4);

		test.log(LogStatus.PASS,"<b>ER: Wizard>Approval Landing pages display <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Wizard Approval displayed")));
	}
	
	@Test(testName = "Sanity Test - Navigate To Wizard>Review Tab", groups = "Sanity", priority = 12)
	public void OpenReviewTab_SanityTest()
	{
		test = extent.startTest("Navigate To Wizard>Review Tab");
		
		wizpage.getWizardButton().click();											sleep(2);
		wizpage.getReviewButton().click();											sleep(4);
		test.log(LogStatus.PASS,"<b>ER: Wizard>Review Landing pages display <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Wizard Review displayed")));
	}
	
	@Test(testName = "Sanity Test - Navigate To Wizard>Traning Tab", groups = "Sanity", priority = 13)
	public void OpenTrainingTab_SanityTest()
	{
		test = extent.startTest("Navigate To Wizard>Traning Tab");
		
		wizpage.getWizardButton().click();											sleep(2);
		wizpage.getTrainingButton().click();										sleep(4);
		test.log(LogStatus.PASS,"<b>ER: Wizard>Traning Landing pages display <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Wizard Traning displayed")));
	}
	
	@Test(testName = "Sanity Test - Navigate To CIBMTR", groups = "Sanity", priority = 14)
	public void ToCIBMTR_SanityTest()
	{
		test = extent.startTest(" Navigate To CIBMTR");
		
		dashboard.toCIBMTR().click();												sleep(3);
		test.log(LogStatus.PASS,"<b>ER: CIBTR - Landing pages load without errors <b>"+
				test.addScreenCapture(captureScreenShot(driver, "CIBTR displayed")));
	}
	
	@Test(testName = "Sanity Test - Navigate To Queries", groups = "Sanity", priority = 15)
	public void ToQueries_SanityTest()
	{
		test = extent.startTest("Navigate To Queries");
		
		dashboard.toQueries().click();												sleep(4);

		test.log(LogStatus.PASS,"<b>ER: Queries - Landing pages load without errors <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Queries Landing")));
		
	}
	
	@Test(testName = "Sanity Test - Navigate To Reports", groups = "Sanity", priority = 16)
	public void ToSubmission_SanityTest()
	{
		test = extent.startTest("Navigate To Reports Sub Tabs");
	
		dashboard.toReports().click();												sleep(2);
		dashboard.toSubmission().click();											sleep(4);

		test.log(LogStatus.PASS,"<b>ER: Submission - Landing pages load without errors <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Submission Page")));
		
		dashboard.toReports().click();												sleep(2);
		dashboard.toRetrieval().click();											sleep(4);

		test.log(LogStatus.PASS,"<b>ER: Retrieval - Landing pages load without errors <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Retrieval Page")));
		
		dashboard.toReports().click();												sleep(2);
		dashboard.toRFI().click();													sleep(4);

		test.log(LogStatus.PASS,"<b>ER: RFI - Landing pages load without errors <b>"+
				test.addScreenCapture(captureScreenShot(driver, "RFI Page")));	
	}
	
	@Test(testName = "Sanity Test - Navigate To CIBMTR>Charts Tab", groups = "Sanity", priority = 17)
	public void ToCIBMTRCharts_SanityTest()
	{
		test = extent.startTest("Navigate To CIBMTR-Charts");
		
		dashboard.toCharts().click();												sleep(4);

		test.log(LogStatus.PASS,"<b>ER: Charts - Landing pages load without errors <b>"+
				test.addScreenCapture(captureScreenShot(driver, "CIBTR displayed")));
	}
	
	@Test(testName = "Sanity Test - Navigate To LMS Tab & Sub Tabs", groups = "Sanity", priority = 18)
	public void ToTraining_SanityTest()
	{
		test = extent.startTest("Navigate To LMS Tab & Sub Tabs");
		
		dashboard.toLMS().click();													sleep(4);

		test.log(LogStatus.PASS,"<b>ER: LMS - Landing pages load without errors <b>"+
				test.addScreenCapture(captureScreenShot(driver, "LMS displayed")));
		
		dashboard.toTraningPlans().click();											sleep(4);

		test.log(LogStatus.PASS,"<b>ER: Traning Plans - Landing pages load without errors <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Training Plans")));
		
		dashboard.toTraningCourses().click();										sleep(4);

		test.log(LogStatus.PASS,"<b>ER: Training Courses - Landing pages load without errors <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Training Courses")));
		
		dashboard.toScheduleCourse().click();										sleep(4);

		test.log(LogStatus.PASS,"<b>ER: Schedule Course - Landing pages load without errors <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Schedule Course")));
		
		dashboard.toScheduleList().click();											sleep(4);

		test.log(LogStatus.PASS,"<b>ER: Schedule List - Landing pages load without errors <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Schedule List")));
		
		dashboard.toScheduleTrainee().click();										sleep(4);

		test.log(LogStatus.PASS,"<b>ER: Schedule Trainee - Landing pages load without errors <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Schedule Trainee")));
	}
	
	@Test(testName = "Sanity Test - Logout", groups = "Sanity", priority = 19)
	public void Logout_SanityTest()
	{
		test = extent.startTest("Logout");
		
		logout.logoutFunction();
		
		test.log(LogStatus.PASS,"<b>ER: Logout Successfull<b>"+
				test.addScreenCapture(captureScreenShot(driver, "Logout Successfull")));	
	}
	
	@AfterMethod
	public void afterMethod()
	{
		extent.endTest(test);
	}
	
	@AfterClass
	public void afterClass()
	{
		driver.quit();
	}
}
