package org.title21.Documents_Test;

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
import org.title21.Documents_POM.CreateDocument_POM;
import org.title21.Documents_POM.DocumentRoutes_POM;
import org.title21.Documents_POM.RecentlyViewdAndFavorites_POM;
import org.title21.utility.BaseClass;

import com.relevantcodes.extentreports.LogStatus;

public class RecentlyViewedAndFavorites_Test extends BaseClass {
	String className = "";
	LoginPage_POM login;
	RecentlyViewdAndFavorites_POM RecentlyViewdAndFavorites;
	DocumentRoutes_POM documentRoutes;
	CreateDocument_POM Credoc;
	String fileUploadPath = "";
	Table searchTable;
	DBQueries dbqueries;
	boolean isRecordFound = false;
	String uploadFileName = "test.doc";
	String documetNo = "";
	String documet_no_checkout = "";
	String documet_no_checkout1 = "";
	String doc_name = "";
	static Logger log = Logger.getLogger(RecentlyViewedAndFavorites_Test.class);
	LogoutPage_POM logout;
	String Docname = "";
	boolean DocumentPresentAfterSearch = false;

	@BeforeClass
	public void openURL() {
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);

		login = new LoginPage_POM(driver);
		documentRoutes = new DocumentRoutes_POM(driver);
		RecentlyViewdAndFavorites = new RecentlyViewdAndFavorites_POM(driver);
		Credoc = new CreateDocument_POM(driver);
		documentRoutes = new DocumentRoutes_POM(driver);
		dbqueries = new DBQueries();
		
		login.loginUser("aparnak", "aparna2450");

	}

	@Test(testName = "recentlyViewd_Favorites ", groups = "recentlyViewd_Favorites", priority = 0)
	public void Create_doc() throws Exception {
		test = extent.startTest("RecentlyViewed_And_Favorites");
		
		RecentlyViewdAndFavorites.createdocandcheckin();
		System.out.print(documetNo);
		RecentlyViewdAndFavorites.datepicker().click();
		RecentlyViewdAndFavorites.gettodaysdate().click();
		GenerateEffectiveFile();
		approved();

		RecentlyViewdAndFavorites = new RecentlyViewdAndFavorites_POM(driver);
		RecentlyViewdAndFavorites.getCreatedDocnumber();
		sleep(5);
		RecentlyViewdAndFavorites.getDashboard().click();
		waitTillElementVisible(RecentlyViewdAndFavorites.Recently_Viewed());
		if (RecentlyViewdAndFavorites.Recently_Viewed().isDisplayed()) {
			test.log(LogStatus.PASS,
					"1. Click on the Dashboard tab." + "<br/>"
							+ "<b>ER1: Existing list of recently viewed documents and Favorites are displayed. <b>"
							+ test.addScreenCapture(captureScreenShot(driver, "dashboardlist")));
		}

		RecentlyViewdAndFavorites.geteBinders().click();
		sleep(2);
		waitTillElementVisible(RecentlyViewdAndFavorites.getLab());
		RecentlyViewdAndFavorites.getLab().click();
		sleep(2);
		RecentlyViewdAndFavorites.getSOP().click();
		sleep(2);

		Search("Bio-hazardous Waste Disposal");
		sleep(2);

		if (RecentlyViewdAndFavorites.verifyFavoriteOpen()==true)
		{
			RecentlyViewdAndFavorites.getFavoritesopen().click();

		} else if(RecentlyViewdAndFavorites.verifyFavoriteOpen()==false){
			RecentlyViewdAndFavorites.getFavoritesStar().click();
			RecentlyViewdAndFavorites.getFavoritesopen().click();
		}

		test.log(LogStatus.PASS,
				"2. Click on the e-Binders tab. Open an existing eBinder which has documents. " + "<br/>"
						+ "3. Select an existing Document in the grid to view it. " + "<br/>"
						+ "4. Click on the star favorite icon to add it to Favorites. " + "<br/>"
						+ "<b>ER2: Click on the star favorite icon to add it to Favorites.  <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "Ebiderdocument")));
		sleep(3);
		RecentlyViewdAndFavorites.getDashboard().click();
		if (RecentlyViewdAndFavorites.getdashboarddocuments().isDisplayed()) {
			test.log(LogStatus.PASS,
					"5. Click on the Dashboard tab." + "<br/>"
							+ "<b>ER3: The document is available in the Recently Viewed list. <b>"
							+ test.addScreenCapture(captureScreenShot(driver, "recently viewe document")));
			test.log(LogStatus.PASS, "<b>ER4: The document is available in the Favorites list. <b>"
					+ test.addScreenCapture(captureScreenShot(driver, "recently viewe document")));

		}
		sleep(3);
		waitTillElementVisible(RecentlyViewdAndFavorites.getReports());
		RecentlyViewdAndFavorites.getReports().click();
		Search("Regulations");
		sleep(5);
		RecentlyViewdAndFavorites.getFavoritesopen().click();
		sleep(2);
		test.log(LogStatus.PASS,
				"6. Click on the Reports tab" + "<br/>"
						+ "7. Add an available report to the Favorites by clicking on the star icon" + "<br/>"
						+ "<b>ER5: The star icon is highlighted  <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "add  report in favorites")));
		
		verticalScrollingDown();
		sleep(1);
		RecentlyViewdAndFavorites.getFavorite_tab().click();
		sleep(2);
		Search("Regulations");
		sleep(2);
		
		test.log(LogStatus.PASS,
				"8.	Click on the Favorites tab" + "<br/>"
						+ "<b>ER6: The report added is available in the Favorites list <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "recently viewe document")));

		RecentlyViewdAndFavorites.getremove().click();
		sleep(2);
		RecentlyViewdAndFavorites.getplaceholder().clear();
		sleep(2);
		Search("Regulations");
		sleep(3);
		if (RecentlyViewdAndFavorites.getrecordnotfound().isDisplayed())

			test.log(LogStatus.PASS,
					"	9.	Click on the delete icon to remove the document added in Step 7 from the list of Favorites."
							+ "<br/>" + "<b>ER7: The document is removed from the Favorites list<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "removed from favorites")));


		RecentlyViewdAndFavorites.getDashboard().click();
		RecentlyViewdAndFavorites.getseeall().click();
		sleep(3);
		RecentlyViewdAndFavorites.getplaceholder().clear();
		sleep(2);
		Search("Regulations");
		sleep(2);
	
		if (RecentlyViewdAndFavorites.getrecordnotfound().isDisplayed()) {

			test.log(LogStatus.PASS, "10 Click on dashborad again" + "<br/>"
					+ "<b> ER8: The document is removed from the Favorites list in the users Dashboard <b>"
					+ test.addScreenCapture(captureScreenShot(driver, "removed from the Favorites and dashboard")));

		}

		RecentlyViewdAndFavorites.getSearches().click();
		sleep(3);
		Search("Search on Document Number");
		sleep(3);
		RecentlyViewdAndFavorites.SearchByDocNumber().click();

		RecentlyViewdAndFavorites.getEnterDocNo().sendKeys(documet_no_checkout);
		RecentlyViewdAndFavorites.SearchGobutton().click();
		RecentlyViewdAndFavorites.getFavoritesopen().click();
		Credoc.getcontextmenu().click();
		sleep(2);
		Credoc.getcheckoutbutton().click();
		sleep(3);
		Credoc.trainingItemsCheck(true);
		sleep(2);
		Credoc.getConfirmButton().click();
		sleep(3);
		
		if (Credoc.getcheckincancelsuccess().isDisplayed()) {
			waitTillElementVisible(Credoc.getcheckincancelsuccess());
			Credoc.getcheckincancelsuccess().click();
		}
		
		String document_number = RecentlyViewdAndFavorites.getCreatedDocnumber().getText();
		System.out.println(document_number + "number after checkout second");

		RecentlyViewdAndFavorites.getDashboard().click();
		sleep(5);
		test.log(LogStatus.PASS,
				"11. Click on the Searches tab. Open an existing effective document which has not been checked out."
						+ "<br/>" + "12. Click on the star favorit icon to add it to Favorites" + "<br/>"
						+ "13.Click on the Dashboard tab. " + "<br/>"
						+ "14. Verify the document from step 11 is available in the Recently Viewed list and the Favorites list"
						+ "<br/>" + "<b> ER9: The document appears in both lists. <b>" + "<br/>"
						+ test.addScreenCapture(captureScreenShot(driver, "recently viewe effective document ")));

		if (RecentlyViewdAndFavorites.dashboarddata().getText().contains(document_number)) {
			driver.findElement(By.xpath("//*[contains(text(),'" + document_number + "')]")).click();
		}

		RecentlyViewdAndFavorites.datepicker().click();
		RecentlyViewdAndFavorites.gettodaysdate().click();
		sleep(3);
		documentRoutes.getDocumentApprovaltab().click();
		sleep(3);
		documentRoutes.getAddApproverLink().click();
		sleep(2);
		documentRoutes.getApproverRole().selectByVisibleText("Approver");
		sleep(2);
		documentRoutes.getnameinAddApprover().selectByVisibleText("sameer");
		documentRoutes.getSequenceinAddApprover().selectByVisibleText("2");
		documentRoutes.getallottedDaysinAddApprover().selectByVisibleText("1 day");
		documentRoutes.approverAdd_Button().click();
		sleep(2);
		Credoc.getcontextmenu().click();
		sleep(2);
		documentRoutes.checkIn_Route().click();
		sleep(2);
		documentRoutes.checkInRouteSubmit_Button().click();
		sleep(3);
		documentRoutes.close_Button().click();
		sleep(2);
		logout = new LogoutPage_POM(driver);
		logout.logoutFunction();
		login.loginUser("sameer", "joshi12345");
		documentRoutes.wizard_Option().click();
		documentRoutes.approval_Tab().click();
		sleep(2);
		selectDocForApprovel(document_number, 3);
		sleep(2);
		documentRoutes.documentTab_ForApprover().click();
		sleep(2);
		documentRoutes.documentApprove_Button().click();
		sleep(2);
		documentRoutes.pinTo_Approve().clear();
		documentRoutes.pinTo_Approve().sendKeys("262829");
		documentRoutes.checkInRouteSubmit_Button().click();
		sleep(3);
		logout.logoutFunction();
		sleep(3);
		DBConnection.executeStoredProcedure(dbqueries.moveDocsOnReleaseDate);
		sleep(3);
		login.loginUser("aparnak", "aparna2450");
		sleep(3);
		test.log(LogStatus.PASS, "15. Check out the document from step (11)." + "<br/>"
				+ " 16.	Add the Target Release date (E.g. Either a day before or current date)" + "<br/>"
				+ "17. Click on Document Approvals and add Test User 2 as the approver" + "<br/>"
				+ "18. Check in the document and route it for approval.  " + "<br/>" + "19. Log out of Test User 1."
				+ "<br/>" + "20. Log in as Test User 2 and approve the document which was routed in the step 18. "
				+ "<br/>" + "21. Log out of Test User 2." + "<br/>" + "22.	Run Jobs from the database. " + "<br/>"
				+ "23. Login as Test User 1 and navigate to the dashboard" + "<br/>"
				+ "<b> ER10: The document which was added to favorites in the previous steps is updated to the major revision in favorites. <b>"
				+ test.addScreenCapture(captureScreenShot(driver, "checkout effective  doc ")));
		RecentlyViewdAndFavorites.geteBinders().click();
		waitTillElementVisible(RecentlyViewdAndFavorites.getLab());
		RecentlyViewdAndFavorites.getLab().click();
		sleep(3);
		RecentlyViewdAndFavorites.getSOP().click();
		Search("Bio-hazardous Waste Disposal");
		waitTillElementVisible(RecentlyViewdAndFavorites.getFavoritesStar());
		RecentlyViewdAndFavorites.getFavoritesStar().click();
		
		logout.logoutFunction();

		log.info("logout successfully.");

	}

	@AfterClass
	public void closeBrowserInstance()
	{
		extent.endTest(test);
		driver.close();

	}

	public void GenerateEffectiveFile()

	{
		Credoc = new CreateDocument_POM(driver);
		documentRoutes = new DocumentRoutes_POM(driver);
		sleep(3);
		Credoc.getcontextmenu().click();
		sleep(2);
		Credoc.getcheckoutbutton().click();
		sleep(2);
		Credoc.trainingItemsCheck(true);
		sleep(2);
		Credoc.getcheckoutconfirm().click();
		sleep(5);

		if (Credoc.getcheckincancelsuccess().isDisplayed()) {
			waitTillElementVisible(Credoc.getcheckincancelsuccess());
			Credoc.getcheckincancelsuccess();
			Credoc.getcheckincancelsuccess().click();
			Credoc.getcheckincancelsuccess().click();
		}
	
		RecentlyViewdAndFavorites.datepicker().click();
		RecentlyViewdAndFavorites.gettodaysdate().click();
		sleep(3);
		documet_no_checkout1 = RecentlyViewdAndFavorites.getDocument_no_after_checkout().getText();

		doc_name = RecentlyViewdAndFavorites.getdocname().getText();

		documet_no_checkout = doc_name + ": 1.0	";
		System.out.println(documet_no_checkout + "doc numbet after checkout first");
		documentRoutes.getDocumentApprovaltab().click();
		sleep(3);
		documentRoutes.getAddApproverLink().click();
		sleep(2);
		documentRoutes.getApproverRole().selectByVisibleText("Approver");
		sleep(2);
		documentRoutes.getnameinAddApprover().selectByVisibleText("sameer");
		documentRoutes.getSequenceinAddApprover().selectByVisibleText("2");
		documentRoutes.getallottedDaysinAddApprover().selectByVisibleText("1 day");
		documentRoutes.approverAdd_Button().click();
		sleep(3);
		Credoc.getcontextmenu().click();
		sleep(2);
		verticalScrollingDown();
		sleep(2);
		documentRoutes.checkIn_Route().click();
		sleep(2);
		documentRoutes.checkInRouteSubmit_Button().click();
		sleep(3);
		documentRoutes.close_Button().click();
		sleep(5);
		logout = new LogoutPage_POM(driver);
		logout.logoutFunction();

	}

	private void Search(String Searchdata) {
		RecentlyViewdAndFavorites.getplaceholder().sendKeys(Searchdata);
		RecentlyViewdAndFavorites.getGOButton().click();
	}

	public void approved() throws Exception
	{
		login.loginUser("sameer", "joshi12345");
		documentRoutes.wizard_Option().click();
		documentRoutes.approval_Tab().click();
		sleep(2);
		for(int i=1; i<=20; i++)
	     {
			selectDocForApprovel(documet_no_checkout1, 3);
	       if(!isRecordFound)
	       {
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
		documentRoutes.pinTo_Approve().sendKeys("262829");
		documentRoutes.checkInRouteSubmit_Button().click();
		sleep(5);
		logout.logoutFunction();
		sleep(2);
		
		DBConnection.executeStoredProcedure(dbqueries.moveDocsOnReleaseDate);
		sleep(2);
		login.loginUser("aparnak", "aparna2450");
		sleep(2);

	}

	private boolean selectDocForApprovel(String docName, int cell) {
		searchTable = new Table(driver);
		RecentlyViewdAndFavorites = new RecentlyViewdAndFavorites_POM(driver);
		List<WebElement> tableCells = searchTable.getcollapseDocumentstableCells(cell);
		for (int i = 0; i < tableCells.size(); i++) {
			if (tableCells.get(i).getText().equalsIgnoreCase(docName)) {
				tableCells.get(i).click();
				isRecordFound = true;
				break;
			}
		}
		return isRecordFound;
	}

};