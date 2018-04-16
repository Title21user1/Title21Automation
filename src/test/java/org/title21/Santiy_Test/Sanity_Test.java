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

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;

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
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void SanityTest()
	{
		test = extent.startTest("Sanity");
		dashboard.enableCIBMTR_LMS();												sleep(2);
		dashboard.enableCIBMTR_LMS_ForGroup("Sp Tester");							sleep(2);
		login.loginUser(loginData[14][0],loginData[14][1]);
		createdoc.getnewdoc().click();												sleep(3);
		createdoc.getdocument().click();											sleep(3);
		createdoc.Search("SOP.CT");													sleep(3);
		createdoc.selectDocumentType("SOP.CT");										sleep(3);
		createdoc.getDocTitle().sendKeys(docTitle);									sleep(2);
		createdoc.getDocChangeSummary().sendKeys("Sanity Test Document Summary");	sleep(2);
		docID = createdoc.getdocumentnumber().getAttribute("value");				sleep(2);
		createdoc.getConfirmButton().click();										sleep(3);
		
		test.log(LogStatus.PASS,"<b>ER: Document it created <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Document Created")));
		
		mydocs.getMyDocs().click();													sleep(3);
		mydocs.getCheckOutByMe().click();											sleep(2);
		
		test.log(LogStatus.PASS,"<b>ER: Document created in step 2 is available <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Document CheckoutToME")));
		
		createdoc.Search(docID);													sleep(2);
		mydocs.getContextMenuInList().click();										sleep(2);
		mydocs.form().click();														sleep(2);
		
		test.log(LogStatus.PASS,"<b>ER: Document form opens <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Document Form")));
		
		mydocs.getContextMenu().click();											sleep(2);
		verticalScrollingDown();													sleep(1);
		mydocs.undoCheckoutForm().click();											sleep(2);
		mydocs.undoCheckoutYesButton().click();										sleep(4);
		mydocs.getCheckinCloseButton().click();										sleep(2);
		verticalScrollingUp();														sleep(2);
		
		test.log(LogStatus.PASS,"<b>ER: Document is removed <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Document Deleted")));
		
		ebinder.getEbinders().click();												sleep(2);
		ebinder.expandEbinder("Lab");
		ebinder.selectEbinder("SOP");												sleep(2);
		
		test.log(LogStatus.PASS,"<b>ER: Documents are listed <b>"+
				test.addScreenCapture(captureScreenShot(driver, "eBinders Docs Listed")));
		
		createdoc.Search("SOP.02");													sleep(2);
		mydocs.selectDocument("SOP.02").click();									sleep(2);
		mydocs.getContextMenu().click();											sleep(2);
		mydocs.mainFilePDFContextMenu().click();									sleep(5);
		
		test.log(LogStatus.PASS,"<b>ER: PDF of document displays <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Mail File PDF")));
		
		mydocs.searchesTab().click();												sleep(2);
		createdoc.Search("Search on Document Number");								sleep(2);
		mydocs.selectDocument("Search on Document Number").click();					sleep(4);
		
		test.log(LogStatus.PASS,"<b>ER: Documents are listed <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Searches Doc Listed")));
		
		reports.reports().click();													sleep(2);
		mydocs.selectDocument("Documents Approaching Review").click();				sleep(5);
		
		test.log(LogStatus.PASS,"<b>ER: Report displays <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Reports Displayed")));
		
		dashboard.toCharts().click();												sleep(2);
		mydocs.selectDocument("Top Disbursements by Entity").click();				sleep(5);
		
		test.log(LogStatus.PASS,"<b>ER: Charts interface displays <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Charts displayed")));
		
		verticalScrollingDown();													sleep(1);
		favorites.getFavorite_tab().click();										sleep(5);
		
		test.log(LogStatus.PASS,"<b>ER: Favorites interface displays <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Favorites displayed")));
		
		wizpage.getWizardButton().click();											sleep(2);
		wizpage.getApporvalButton().click();										sleep(4);
		
		test.log(LogStatus.PASS,"<b>ER: Wizard Landing pages display <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Favorites displayed")));
		
		wizpage.getReviewButton().click();											sleep(4);
		wizpage.getTrainingButton().click();										sleep(4);
		dashboard.toCIBMTR().click();												sleep(3);
		
		test.log(LogStatus.PASS,"<b>ER: CIBTR - Landing pages load without errors <b>"+
				test.addScreenCapture(captureScreenShot(driver, "CIBTR displayed")));
		
		dashboard.toQueries().click();												sleep(4);
		
		test.log(LogStatus.PASS,"<b>ER: Queries - Landing pages load without errors <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Queries Landing")));
		
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
		
		dashboard.toCharts().click();												sleep(4);
		
		test.log(LogStatus.PASS,"<b>ER: Charts - Landing pages load without errors <b>"+
				test.addScreenCapture(captureScreenShot(driver, "CIBTR displayed")));
		
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
		
		logout.logoutFunction();
	}

	@AfterClass
	public void afterClass()
	{
		extent.endTest(test);
		driver.close();
	}
	
}
