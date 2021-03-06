package org.title21.Documents_Test;

import java.io.File;
import java.io.IOException;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.Documents_POM.CreateDocument_POM;
import org.title21.dao.AdminData;
import org.title21.utility.BaseClass;
import org.title21.utility.DownloadUtils;
import org.title21.utility.FileUpload;
import org.title21.utility.FunctionUtils;

import com.relevantcodes.extentreports.LogStatus;

public class CreateDocument_Test extends BaseClass {
	LoginPage_POM login;
	LoginPage_POM login1;
	LogoutPage_POM logout;
	CreateDocument_POM Credoc;
	String className = "";

	FileUpload Upload;
	String doc="abc";
	String AppendixNumber = "21";
	String Appendix =doc+FunctionUtils.generateRandomNumber();
	String fileUploadPath = "";
	String fileUploadPath1 = "";

	String uploadFileName = "DocDocument.docx";
	String uploadFileNameSize = "Sizeval.doc";
	static Logger log = Logger.getLogger(CreateDocument_Test.class);
	AdminData adminData = new AdminData();
	String testcaseName="TestCase-WIA-Creation of new document.doc";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;

	@BeforeClass(alwaysRun=true)
	public void openURL() {
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		login = new LoginPage_POM(driver);
		logout = new LogoutPage_POM(driver);
		login.loginUser("Title21User1", "test123456");
	}

	@Test(testName = "Create  Document", groups = "DocumentModule", priority = 0, alwaysRun=true)
	public void Create_doc() {
		test = extent.startTest("Create  Document");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		log.info("Create  Document");
		sleep(2);
		Credoc = new CreateDocument_POM(driver);
		Credoc.getnewdoc().click();
		sleep(3);
		Credoc.getdocument().click();
		sleep(7);
		test.log(LogStatus.PASS,
				"1.From the Main menu click on New and select Document " + "<br/>"
						+ "<b>ER1: New document dialog appears. <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "Doc_Dialog")));
		Credoc.getlocationDrodown().selectByVisibleText("Dallas");
		sleep(5);
		Credoc.docType().get(0).click();
		sleep(5);
		test.log(LogStatus.PASS,
				"2.Click on Search by location drop-down and select one Location Ensure the document type selected does not have a template associated with it"
						+ "<br/>" + "<b>ER2: document type of selected location is displayed.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "location_list")));
		sleep(5);
		Credoc.getConfirmButton().click();
		sleep(5);
		if (Credoc.DocumentTitlemsgvalidation() && Credoc.Documentsummarymsgvalidation()) {

			test.log(LogStatus.PASS,
					"3. Click on create a button without entering document title and Document Change Summary. "
							+ "<br/>" + "<b>ER3: It should show validation message as \"Document title is required\"& "
							+ " \" Change Summary is required\"\n" + " <b>"
							+ test.addScreenCapture(captureScreenShot(driver, "validationmessagefortitleand")));
		}

		sleep(2);
		Credoc.GeteditdocumentNo().click();
		sleep(2);
		verticalScrollingDown();
		Credoc.getConfirmButton().click();
		sleep(3);
		if (Credoc.Appedixvalidation()) {

			test.log(LogStatus.PASS, " 4.Click on \"document no\" fields edit button. " + "<br/>"
					+ "5.Click on create button." + "<br/>"
					+ "<b>ER4:  Application should display the validation message as Please enter a Document Appendix <b>"
					+ test.addScreenCapture(captureScreenShot(driver, "Doc_Dialog")));
		}
		;
		sleep(2);
		Credoc.getnumberappedix().selectByIndex(1);
		Credoc.Appendix().sendKeys(Appendix);
		sleep(2);
		String Document_number = Credoc.getdocumentnumber().getAttribute("value");
		if (Document_number.contains(Appendix)) {

			test.log(LogStatus.PASS, " 6.	Edit the \"document no\" field " + "<br/>"
					+ "7. Select number from the number drop-down field" + "<br/>"
					+ "8.Enter appendix in appendix field." + "<br/>"
					+ "<b> ER5: Document number should get changed as per number and appendix selected by the user.<b>"
					+ test.addScreenCapture(captureScreenShot(driver, "Document_number")));

		}
		Credoc.getDocumentTitle().sendKeys("Test");
		Credoc.getDocChangeSummary().sendKeys("Test Summary");
		verticalScrollingDown();
		Credoc.getConfirmButton().click();
		sleep(5);
		if (Credoc.getdocumentcreationverify().isDisplayed()) {
			test.log(LogStatus.PASS,
					"9. Enter all  mandatory field " + "<br/>" + "<b> ER6: Document should save to Draft cabinet.<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "create_document")));


		}
		sleep(3);
		logout.logoutFunction();
		sleep(3);
		login.loginUser("Title21User1", "test123456");
		sleep(4);
		Credoc.getcreateddoc().click();
		sleep(3);
		Credoc.getEditModeON().click();
		sleep(5);
		Credoc.getPlusButtonuploadfile().click();
		sleep(5);
		Credoc.fileupload(uploadFileNameSize);
		sleep(5);
		test.log(LogStatus.PASS,
				"10. Turn edit mode to ON" + "<br/>" + "11.Click on add file plus button" + "<br/>"
						+ "12. Add file with size more than 50 MB  and click on Add  button  " + "<br/>"
						+ "<b> ER7: It should show validation message as \"File size must be less than 50 MB\".<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "File_Size")));

		sleep(3);

		Credoc.getCancel().click();
		sleep(4);
		Credoc.getPlusButtonuploadfile().click();
		sleep(2);
		Credoc.fileupload(uploadFileName);
		sleep(10);
		String home_page = driver.getWindowHandle();
		verticalScrollingDown();
		Credoc.getnative().click();
		sleep(10);
		File downloadedFile = DownloadUtils.waitForDownloadToComplete("DocDocument.docx");
		if (downloadedFile.exists()) {
			test.log(LogStatus.PASS,
					"13.Attached main file to the document for eg. Any doc or pdf file " + "<br/>"
							+ "14.Click on native button under the main file" + "<br/>"
							+ "<b>ER8: It should download the main file document in its native form.<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "native_file")));
		}
		sleep(10);		
		Credoc.getpdf().click();
		sleep(10);
		test.log(LogStatus.PASS,
				"15. click on pdf button " + "<br/>"
						+ "<b>ER 9 : Document is converted to pdf form and open in new tab.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "checkinsuccessmessage")));

		String pop_page = driver.getWindowHandle();
		System.out.print(pop_page);
		sleep(2);
		driver.switchTo().window(home_page);
		sleep(3);
		verticalScrollingUp();
		sleep(2);
		Credoc.getcontextmenu().click();
		sleep(2);
		Credoc.getcheckin().click();
		sleep(2);
		test.log(LogStatus.PASS,
				"16.Click on doc option context menu." + "<br/>" + "17. Go to Action section and click on Check-In.  "
						+ "<br/>" + "<b>ER 10 : Check In popup screen is displayed.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "checkin_popup")));
		Credoc.getcheckinbuttonwindow().click();
		sleep(6);
		if (Credoc.CheckinSuccessmessage()) {
			test.log(LogStatus.PASS,
					"<b>ER 11:  A Successful message that the document has been checked In is displayed.<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "checkinsuccessmessage")));
		}

		Credoc.getcheckincancelsuccess().click();
		sleep(3);
		if (Credoc.editmodedisable().isDisplayed()) {
			test.log(LogStatus.PASS, "18.Click on close button " + "<br/>" + "<b>ER12: Doument Edit mode is disable.<b>"
					+ test.addScreenCapture(captureScreenShot(driver, "documenteditmodedisable")));
		}

		sleep(2);
		verticalScrollingUp();
		sleep(1);
		Credoc.getcontextmenu().click();
		sleep(2);
		Credoc.getcheckoutbutton().click();
		sleep(2);
		if(Credoc.getcheckboxcheckout().isDisplayed())
			test.log(LogStatus.PASS,
					"19 again click on doc option context menu  " + "<br/>" + "20.Click on checkout link." + "<br/>"
							+ "<b> ER 13 : Check Out popup screen should get open.  <b>"
							+ test.addScreenCapture(captureScreenShot(driver, "checkinsuccessmessage")));
		sleep(2);
		Credoc.getcheckboxcheckout().click();
		Credoc.getcheckoutconfirm().click();
		sleep(5);
		if (Credoc.checkoutversionvalidation()) {
			test.log(LogStatus.PASS, "21. Check the open document after checkout checkbox " + "<br/>"
					+ "22.Click on confirm button" + "<br/>"
					+ "<b>ER 14 :  Minor revision of the document incremented changed for eg, doc number is changed from 001.398:0.1 to 001.398:0.2 <b>"
					+ test.addScreenCapture(captureScreenShot(driver, "checkoutvesionvalidation")));
		}

		sleep(2);
		if(Credoc.getcheckincancelsuccess().isDisplayed())
		{
			Credoc.getcheckincancelsuccess().click();
		}
		else
		{
			log.info("prompt not display");
		}
		sleep(3);
		test.log(LogStatus.PASS, "<b>ER 15: Document edit mode enable.<b>"
				+ test.addScreenCapture(captureScreenShot(driver, "document edit   mode")));
		
		logout.logoutFunction();
		log.info("logout successfully.");
		sleep(2);
	}

	@AfterClass(alwaysRun=true)
	public void closeBrowserInstance() throws IOException
	{	
		cleanDownloadDirectory();
		sleep(2);
		extent.endTest(test);
		driver.quit();
	}
}
