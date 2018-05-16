package org.title21.Module3_Test;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.DBConnection.DBConnection;
import org.title21.DBConnection.DBQueries;
import org.title21.Documents_POM.CreateDocument_POM;
import org.title21.Documents_POM.DocumentRoutes_POM;
import org.title21.Documents_POM.RecentlyViewdAndFavorites_POM;
import org.title21.Documents_Test.RecentlyViewedAndFavorites_Test;

import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.AdminModule_POM.Table;
import org.title21.utility.BaseClass;
import org.title21.utility.FileUpload;
import org.title21.utility.FunctionUtils;

import com.relevantcodes.extentreports.LogStatus;

import org.title21.Module3_POM.AttachmentControlInDoc_POM;
import org.title21.Module3_POM.LinkControlOfDocument_POM;
import org.title21.Module3_Test.AttachmentControlInDoc_Test;

public class LinkControlOfDocument_Test extends BaseClass {

	AttachmentControlInDoc_Test Attachmenttest;
	String className = "";
	LoginPage_POM login;
	String AppendixNumber = "21";
	String doc = "testautomation";
	String Appendix = doc + FunctionUtils.generateRandomNumber();
	FileUpload FileUplod;
	LogoutPage_POM logout;
	String fileUploadPath = "";
	String Document_number = "";
	String doc_name = "";
	String linkdoc = "";
	Table searchTable;
	DBQueries dbqueries;
	DocumentRoutes_POM documentRoutes;
	String effective_doc = "";
	String ref_documents = "";
	CreateDocument_POM Credoc;
	String documet_no_checkout1 = "";
	boolean isRecordFound = false;
	RecentlyViewedAndFavorites_Test RecentlyViewd;
	RecentlyViewdAndFavorites_POM RecentlyViewdAndFavorites;
	LinkControlOfDocument_POM LinkControlofDocument;
	AttachmentControlInDoc_POM attachment;
	String documet_no_checkout = "";
	public String Document_For_link="";
	static Logger log = Logger.getLogger(LinkControlOfDocument_Test.class);
	@BeforeClass(alwaysRun = true)
	public void openURL() {
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		login = new LoginPage_POM(driver);
		attachment = new AttachmentControlInDoc_POM(driver);
		RecentlyViewdAndFavorites = new RecentlyViewdAndFavorites_POM(driver);
		logout = new LogoutPage_POM(driver);
		LinkControlofDocument = new LinkControlOfDocument_POM(driver);
		Credoc = new CreateDocument_POM(driver);
 
		login.loginUser("aparnak", "aparna2450");
		dbqueries = new DBQueries();

	}

	@Test(testName = "Link Control Of Document", groups = "Module3", priority = 0)
	public void LinkControlOfDocument_POM() throws Exception {
        
		test = extent.startTest("Link Control Of Document");
		log.info("Link Control Of Document");
		attachment.CreateDocument();
		sleep(2);
		Document_For_link = LinkControlofDocument.getdocname().getText();
		sleep(5);
		System.out.println(Document_For_link);
		Credoc.getPlusButtonuploadfile().click();
		sleep(3);
		scrolldown(2);
		fileupload("DocDocument.docx");
		sleep(3);
		scrollup(2);
		sleep(3);
		attachment.CreateDocument();
		sleep(5);
		String Document_name = LinkControlofDocument.getdocname().getText();
		sleep(3);
		Credoc.getPlusButtonuploadfile().click();
		sleep(3);
		scrolldown(2);
		fileupload("DocDocument.docx");
		sleep(5);
		scrolldown(2);
		attachment.getAddnew().get(0).click();
		sleep(3);
		fileupload("DocDocument2.docx");
		sleep(5);
		Linkattached("Open", "2/22/2018", 24);
		sleep(5);
		linkdoc = LinkControlofDocument.getlinkdocuments().get(0).getText();
		sleep(5);
		System.out.println(linkdoc);
		if (linkdoc.equals(doc_name)) {
			test.log(LogStatus.PASS,
					"5.Check the checkbox of any document from the list." + "<br/>" + "6.Click on OK button." + "<br/>"
							+ "<b>ER3:Ensure the linked document is in the Links frame. <b>"
							+ test.addScreenCapture(captureScreenShot(driver, "verifylink_document")));

		}
		sleep(5);
		Search(Document_name);
		sleep(3);
		attachment.getshowattachment().click();
		sleep(4);
		test.log(LogStatus.PASS,
				"7.Go to searches" + "<br/>" + "8 Search for document created in step1" + "<br/>"
						+ "9.Expand the document. " + "<br/>" + "<br/>"
						+ "<b>ER4:The linked draft document is not available in the grid.  <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "showattachment")));

		// show attachment
		LinkControlofDocument.getdoconsearch().click();
		scrolldown(3);
		
		// * verticalScrollingDown(); verticalScrollingDown(); verticalScrollingDown();
		 
		Linkattached("Archived", "1/1/2018", 25);
		sleep(8);
		Linkattached("Both", "2/28/2018", 25);
		sleep(5);
		verticalScrollingDown();
		attachment.getremove().get(1).click();
		sleep(4);
		if (LinkControlofDocument.getyesbutton().isDisplayed()) {
			test.log(LogStatus.PASS,
					"16. Click on OK button" + "<br/>" + "17.Click on Remove Link" + "<br/>"
							+ "<b>ER8: The Remove Linked Document screen appears. <b>"
							+ test.addScreenCapture(captureScreenShot(driver, "delete_document_popup")));
		}
		LinkControlofDocument.getyesbutton().click();
		test.log(LogStatus.PASS,
				"" + "18.Click on Yes." + "<br/>" + "<br/>" + "<b>ER9: The Linked document is deleted successfully. <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "delete_document")));
		sleep(3);
		LinkControlofDocument.getadd_new_link().get(1).click();
		sleep(8);
		ref_documents = LinkControlofDocument.getselected_doc_from_link().get(2).getText();
		sleep(3);
		System.out.println("data is" + ref_documents);
		sleep(5);
		searchlinkonlinkwindow(Document_For_link, 8);
		sleep(4);
		test.log(LogStatus.PASS, "" + "19.Again click on add new links" + "<br/>"
				+ "20.Link one document and note down the number of linked document(for eg: doc no. 001.406: 0.0)"
				+ "<br/>" + test.addScreenCapture(captureScreenShot(driver, "delete_document")));
		Search(Document_For_link);
		LinkControlofDocument.getdoconsearch().click();
		sleep(3);
		//LinkControlofDocument.getedit().click();
		sleep(3);
		scrolldown(3);
		
		 //verticalScrollingDown(); verticalScrollingDown(); verticalScrollingDown();
		 
		sleep(6);
		for (WebElement option : LinkControlofDocument.getsearchlinklist()) {
			if (String.valueOf(option.getText()).equals(Document_name)) {

				test.log(LogStatus.PASS, "" + "21.click on ok." + "<br/>" + "22.Go to searches"
						+ "23.	Click on Search on Document Number." + "<br/>"
						+ "24.	Enter the document number which is noted in step (20)." + "<br/>"
						+ "25.	Click on go button" + "<br/>"
						+ "27.Verify the document created in step (1) is present in the link control of document links in step (20)."
						+ "<br/>" + "<b>ER10:The document is available in the link control. <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "document_available_linkcontrol")));

			}
		}
		sleep(4);
		// Search(Document_name);
		LinkControlofDocument.getadd_new_link().get(1).click();
		sleep(5);
		// searchlinkonlinkwindow("1.0", 8);
		LinkControlofDocument.getlinksearchonsearch().sendKeys("effective");
		LinkControlofDocument.getGoButton().get(8).click();
		sleep(3);
		test.log(LogStatus.PASS,
				"28.Link one effective document." + "<br/>"
						+ "29.Note the effective version of the document (for eg:2.0)" + "<br/>"
						+ "<b>ER 11 : The Effective document is linked and available in the link control. <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "effecetive_document_in_link")));
		sleep(3);
		effective_doc = LinkControlofDocument.getselected_doc_from_link().get(1).getText();
		sleep(5);
		System.out.println(effective_doc);
		searchlinkonlinkwindow(effective_doc, 8);
		sleep(5);
		verticalScrollingUp();
		Search(effective_doc);//effective_doc
		LinkControlofDocument.getdoconsearch().click();
		RecentlyViewd = new RecentlyViewedAndFavorites_Test();
		sleep(7);
		Credoc = new CreateDocument_POM(driver);
		sleep(5);
		GenerateEffectiveFile("1.0");
		approved();
		sleep(5);
		LinkControlofDocument.getdashboardocumentslist().get(0).click();
		sleep(5);
		test.log(LogStatus.PASS,
				"" + "30Search the effective document linked in step (28) through searches." + "<br/>"
						+ "31. Checkout the document." + "<br/>" + "32. Add approvers to the document " + "<br/>"
						+ "33.Checked In and route it for approval" + "34.Approve  the document" + "<br/>"
						+ "35.Move the document to effective document" + "<br/>"
						+ "<b>ER12: The document is moved to effective cabinet and major revision is updated. <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "delete_document")));
		sleep(4);
		Search(Document_For_link);
		LinkControlofDocument.getdoconsearch().click();
		sleep(3);
		scrolldown(3);
		sleep(4);
		test.log(LogStatus.PASS,
				"" + "36.Open the document used in step (20)." + "<br/>" + "37.Go to link control." + "<br/>"
						+ "<b>ER 13: The major revision document is available in the link control.<b>" + "<br/>"
						+ test.addScreenCapture(captureScreenShot(driver, "delete_document")));

		scrollup(3);
		sleep(2);
		attachment.getshowattachment().click();
		sleep(2);
		test.log(LogStatus.PASS,
				"" + "38.Go to searches" + "<br/>" + "39.Search for document used in step (20)."
						+ "40.Expand the document grid" + "<br/>"
						+ "<b>ER 14: The linked effective document is available in the grid.<b>" + "<br/>"
						+ test.addScreenCapture(captureScreenShot(driver, "delete_document")));
	}

	public void searchlinkonlinkwindow(String searchlink, int go) {
		sleep(3);
		LinkControlofDocument = new LinkControlOfDocument_POM(driver);
		if (searchlink.equalsIgnoreCase(doc_name)) {

			LinkControlofDocument.getsearch().get(2).sendKeys(searchlink);

		} else

		{
			LinkControlofDocument.getlinksearchonsearch().clear();
			LinkControlofDocument.getlinksearchonsearch().sendKeys(searchlink);
		}
		LinkControlofDocument.getGoButton().get(go).click();
		LinkControlofDocument = new LinkControlOfDocument_POM(driver);
		sleep(5);

		// LinkControlofDocument.getdocument_checkbox().click();
		LinkControlofDocument.trainingItemsCheck(true);

		sleep(5);
		if (searchlink.equalsIgnoreCase(doc_name)) {
			LinkControlofDocument.getOkButton().click();
		} else {
			LinkControlofDocument.getokbuttononsearch().get(1).click();
		}
	}

	public void Linkattached(String status, String Todate, int Location) {
		LinkControlofDocument.getadd_new_link().get(1).click();
		sleep(3);
		if (status.equalsIgnoreCase("Open")) {
			test.log(LogStatus.PASS, "1 Create a new document and add a main file to it." + "<br/>"
					+ "2.Open the document in edit mode and navigate to the link control frame." + "<br/>"
					+ "3 Click on add new " + "<br/>" + "<b>ER1:Dialog to add linked documents/forms appears.<b>"
					+ test.addScreenCapture(captureScreenShot(driver, "new_link_popup")));

		}
		if ((status.equalsIgnoreCase("Archived")) || (status.equalsIgnoreCase("Both"))) {
			LinkControlofDocument.getStatusDropdown().selectByVisibleText(status);
		}

		sleep(2);
		LinkControlofDocument.getTypebuttonandLocationbutton().get(1).click();// location
		LinkControlofDocument.getheckbox().get(Location).click();
		sleep(4);
		if (status.equalsIgnoreCase("Open")) {
			LinkControlofDocument.getcalender().get(3).clear();// to date
			LinkControlofDocument.getcalender().get(3).sendKeys(Todate);
			sleep(3);
			LinkControlofDocument.getGoButton().get(2).click();
		}
		sleep(5);
		if (status.equalsIgnoreCase("open")) {
			test.log(LogStatus.PASS,
					"4.Select Status: Open, created between (Select dates for eg: 2/22/2018 and 3/28/2018), and Type: Document."
							+ "<br/>" + "<b>ER2:The Open documents list appears. <b>"
							+ test.addScreenCapture(captureScreenShot(driver, "open_status_linklist")));
		} else if (status.equalsIgnoreCase("Archived")) {

			test.log(LogStatus.PASS, "10.In the link control, click on Add Newlink." + "<br/>"
					+ "11.Select Status: Archived, Created between (Select dates for eg: 1/1/2018 and 3/28/2018) and Type: Document"
					+ "<br/>" + "<br/>" + "<b>ER5: The Archived documents list appears. <b>"
					+ test.addScreenCapture(captureScreenShot(driver, "Archived_list")));

		}

		else if (status.equals("Both")) {
			test.log(LogStatus.PASS, "10.clck on ok " + "<br/>" + "13.In the link control, click on Add New link."
					+ "<br/>"
					+ "14.	Select Status: Both, Created between (Select dates for eg: 2/28/2018 and 3/28/2018) and Type: Document.+"
					+ "<br/>" + "<b>ER6: The both documents list appears. <b>"
					+ test.addScreenCapture(captureScreenShot(driver, "both_list")));
			test.log(LogStatus.PASS,
					"10.clck on ok " + "<br/>" + "13.In the link control, click on Add New link." + "<br/>"
							+ "15.Select location from location dropdown (for eg-Antioch)" + "<br/>"
							+ "<b>ER7.The Open and Archived documents list as per the selected location appears. <b>"
							+ test.addScreenCapture(captureScreenShot(driver, "both_listforlocation")));

		}
		LinkControlofDocument = new LinkControlOfDocument_POM(driver);
		sleep(2);
		doc_name = LinkControlofDocument.getselected_doc_from_link().get(0).getText();
		sleep(4);
		System.out.println(doc_name);
		LinkControlofDocument = new LinkControlOfDocument_POM(driver);
		sleep(4);
		if (status.equalsIgnoreCase("open")) {
			searchlinkonlinkwindow(doc_name, 2);

		}
		
		else {
			sleep(3); 
			LinkControlofDocument.getclose().click();
		}

	}

	public void GenerateEffectiveFile(String version)

	{
		Credoc = new CreateDocument_POM(driver);
		documentRoutes = new DocumentRoutes_POM(driver);
		sleep(5);
		/*Credoc.getcontextmenu().click();
		sleep(5);
		LinkControlofDocument.getcheckin().click();
		sleep(4);
		LinkControlofDocument.getconfirm_button_checkin().click();
		sleep(4);
		LinkControlofDocument.Close_Button_Checkin().click();*/
		sleep(4);
	    Credoc.getcontextmenu().click();
		sleep(3);
		Credoc.getcheckoutbutton().click();
		sleep(3);
		LinkControlofDocument.checkoutcheckbox(true);
		sleep(2);
		LinkControlofDocument.getconfirm_button_checkin().click();
        sleep(2);
		RecentlyViewdAndFavorites.datepicker().click();
		sleep(2);
		RecentlyViewdAndFavorites.gettodaysdate().click();
		sleep(3);
		documet_no_checkout1 = RecentlyViewdAndFavorites.getDocument_no_after_checkout().getText();

		doc_name = RecentlyViewdAndFavorites.getdocname().getText();

		documet_no_checkout = doc_name + version;
		System.out.println(documet_no_checkout + "doc numbet after checkout first");
		documentRoutes.getDocumentApprovaltab().click();
		sleep(3);
		documentRoutes.getAddApproverLink().click();
		sleep(2);
		documentRoutes.getApproverRole().selectByVisibleText("Approver");
		sleep(5);
		LinkControlofDocument.getlocationdropdown().selectByVisibleText("All");
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
		LinkControlofDocument.getconfirm_button_checkin().click();
		sleep(5);
		LinkControlofDocument.Close_Button_Checkin().click();
		sleep(3);
		logout.logoutFunction();
		sleep(4);
	}

	@SuppressWarnings("unused")
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

	public void approved() throws Exception {
		login = new LoginPage_POM(driver);
		login.loginUser("sameer", "joshi12345");
		documentRoutes = new DocumentRoutes_POM(driver);
		documentRoutes.wizard_Option().click();
		documentRoutes.approval_Tab().click();
		sleep(2);
		LinkControlofDocument.getplaceholderonapproved().sendKeys(doc_name);
		LinkControlofDocument.getGoButton().get(0).click();
		LinkControlofDocument.getclickonapproveddoc().click();
		sleep(5);
		LinkControlofDocument.docapprovetab().click();
		sleep(3);
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

	public void scrolldown(int size) {
		int i;
		for (i = 1; i <= size; i++) {
			verticalScrollingDown();
		}
	}

	public void scrollup(int size) {
		int i;
		for (i = 1; i <= size; i++) {
			verticalScrollingUp();
		}
	}
	
	private void Search(String Searchdata) {
		scrollup(2);
		RecentlyViewdAndFavorites = new RecentlyViewdAndFavorites_POM(driver);
		RecentlyViewdAndFavorites.getSearches().click();
		RecentlyViewdAndFavorites.getplaceholder().sendKeys("Search on Document Number");
		RecentlyViewdAndFavorites.getGOButton().click();
		sleep(5);
		RecentlyViewdAndFavorites.SearchByDocNumber().click();
		RecentlyViewdAndFavorites.getEnterDocNo().sendKeys(Searchdata);
		RecentlyViewdAndFavorites.SearchGobutton().click();
	}

	public void fileupload(String uploadFileName) {

		fileUploadPath = System.getProperty("user.dir") + "\\testdata";
		fileUploadPath = fileUploadPath + "\\" + uploadFileName;
		Credoc.getBrouse().sendKeys(fileUploadPath);
		sleep(2);
		Credoc.getAddButtonupload().click();

	}

	@AfterMethod
	public void afterClass() throws IOException {
		cleanDownloadDirectory();
		sleep(2);
		logout = new LogoutPage_POM(driver);
		logout.logoutFunction();
		sleep(2);
	}

	@AfterClass(alwaysRun = true)
	public void closeBrowserInstance() {

		extent.endTest(test);
		driver.quit();
	}
}