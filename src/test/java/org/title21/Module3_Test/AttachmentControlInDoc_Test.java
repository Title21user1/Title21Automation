package org.title21.Module3_Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.Documents_POM.CreateDocument_POM;
import org.title21.Documents_POM.RecentlyViewdAndFavorites_POM;
import org.title21.Module3_POM.AttachmentControlInDoc_POM;

import org.title21.utility.BaseClass;
import org.title21.utility.DownloadUtils;
import org.title21.utility.FileUpload;
import org.title21.utility.FunctionUtils;

import com.relevantcodes.extentreports.LogStatus;;

public class AttachmentControlInDoc_Test extends BaseClass {
	AttachmentControlInDoc_POM attachment;
	String className = "";
	LoginPage_POM login;
	String AppendixNumber = "21";
	String doc = "abcdefg";
	String Appendix = doc + FunctionUtils.generateRandomNumber();
	CreateDocument_POM Credoc;
	FileUpload FileUplod;
	LogoutPage_POM logout;
	String fileUploadPath = "";
	String Document_number = "";
	static Logger log = Logger.getLogger(AttachmentControlInDoc_Test.class);
	RecentlyViewdAndFavorites_POM RecentlyViewdAndFavorites;
	String testcaseName="TestCase-WIA-Attachment control in document.docx";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;

	@BeforeClass
	public void openURL() {
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		login = new LoginPage_POM(driver);
		logout = new LogoutPage_POM(driver);
		login.loginUser("aparnak", "aparna2450");
	}

	@Test(testName = "Attachment Control In Doc", groups = "Module3", priority = 0)
	public void AttachmentCotrol_Test() throws Exception {
		attachment = new AttachmentControlInDoc_POM(driver);
		test = extent.startTest("Attachment control in document");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		RecentlyViewdAndFavorites = new RecentlyViewdAndFavorites_POM(driver);
		createdoc();		
		String home_page = driver.getWindowHandle();
		attachment.addMainFile().click();
		sleep(2);
		fileupload("test.doc");
		sleep(10);
		verticalScrollingDown();
		verticalScrollingDown();
		sleep(1);
		attachment.getAddnew().get(0).click();
		sleep(5);
		test.log(LogStatus.PASS,
				"1.Create a new document and add main file to it." + "<br/>"
						+ "2.Open the document in edit mode and navigate to the attachment control." + "<br/>"
						+ "3.Click on Add New link." + "<br/>" + "<b>ER1: Add a document dialog appears. <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "dialog_add_file")));
		fileupload("DocDocument.docx");
		sleep(10);
		test.log(LogStatus.PASS, "4.Click on Choose File button." + "<br/>"
				+ "5.Try to attach a file type which is not a MS Word document or an executable (e.g. Jpeg, PNG, TXT etc.)."
				+ "<br/>" + "<b>ER2: File is successfully attached.<b>"
				+ test.addScreenCapture(captureScreenShot(driver, "fileattached")));
		sleep(3);
		attachment.getAddnew().get(0).click();
		sleep(5);
		fileupload("DocDocument2.docx");
		sleep(10);
		test.log(LogStatus.PASS,
				"6.Click on the Add New link again, and try to attach a MS Word (.doc or .docx) document	" + "<br/>"
						+ "Note: Ensure the word document is not empty and has some text." + "<br/>"
						+ "<b>ER3: The word document is also attached successfully. <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "second_attachment")));
		sleep(5);		
		attachment.getnativedownloadoption().get(1).click();		
		sleep(5);
		File downloadedFile = DownloadUtils.waitForDownloadToComplete("DocDocument.docx");
		if (downloadedFile.exists()) {
			test.log(LogStatus.PASS,
					"7.Click on the Native link under the Open column for 1st file attached." + "<br/>"
							+ "<b>ER4: File/attachmentis downloaded in the native format.<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "nativefile")));
		}
		attachment.getpdf().get(2).click();
		sleep(5);
		test.log(LogStatus.PASS,
				"8.Click on the PDF link under the Open column for the attached MS Word document. " + "<br/>"
						+ "<b>ER 5: The MS Word file attachment successfully opens in PDF format<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "pdffile")));
		sleep(4);
		driver.switchTo().window(home_page);
		List<WebElement> editattachment = attachment.getedit();
		editattachment.get(1).click();
		sleep(5);
		if (attachment.getattachmentwindowpopup().isDisplayed()) {
			test.log(LogStatus.PASS,
					"9. Close the PDF. " + "<br/>" + "10.Click on the edit icon to edit the attachment." + "<br/>"
							+ "<b>ER 6: The Editing Attachment screen appears<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "editattachment")));
		}
		attachment.geDescription().sendKeys("Test File");
		
		attachment.getupdate().click();
		sleep(5);
		test.log(LogStatus.PASS,
					"11. Add a description and edit the file name. " + "<br/>" + "12.Click on Update." + "<br/>"
							+ "<b>ER 7: The description is added and the file name is changed.<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "descriptionattachement")));
		sleep(5);
		List<WebElement> remove = attachment.getremove();
		remove.get(1).click();
		sleep(3);
		if (attachment.getyes().isDisplayed()) {
			test.log(LogStatus.PASS,
					"13.Click on delete attachment." + "<br/>" + "<b>ER8: The Remove Attachment screen appears.<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "clickondelete")));
		}
		attachment.getyes().click();
		sleep(5);
		test.log(LogStatus.PASS, "14.Click on Yes." + "<br/>" + "<b>ER9: The Attachment is deleted successfully.<b>"
				+ test.addScreenCapture(captureScreenShot(driver, "deleteattachment")));
		sleep(5);
		verticalScrollingUp();
		verticalScrollingUp();
		sleep(5);
		RecentlyViewdAndFavorites.getSearches().click();
		Search("Search on Document Number");
		sleep(5);
		RecentlyViewdAndFavorites.SearchByDocNumber().click();
		RecentlyViewdAndFavorites.getEnterDocNo().sendKeys(Document_number);
		RecentlyViewdAndFavorites.SearchGobutton().click();
		sleep(5);
		if (attachment.getverifysearch().getText().contains(Document_number))
			test.log(LogStatus.PASS,
					"15. Go to searches" + "<br/>" + "16.Click on Search on Document Number link." + "<br/>"
							+ "<b>ER10: The Document is displayed as per search result.<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "search result")));
		sleep(5);
		attachment.getshowattachment().click();
		sleep(5);
		if (attachment.verifyattachment().isDisplayed()) {
			test.log(LogStatus.PASS,
					"16	Click on show linked document and attachment arrow and verify the added attachment in step(6)."
							+ "<br/>" + "<b>E11: The linked attachment is displayed<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "viewattachment")));

		}
		
	}

	public void fileupload(String uploadFileName) {

		fileUploadPath = System.getProperty("user.dir") + "\\testdata";
		fileUploadPath = fileUploadPath + "\\" + uploadFileName;
		Credoc.getBrouse().sendKeys(fileUploadPath);
		sleep(2);
		Credoc.getAddButtonupload().click();

	}

	public void createdoc() {
		Credoc = new CreateDocument_POM(driver);
		Credoc.getnewdoc().click();
		FileUplod = new FileUpload();
		sleep(3);
		Credoc.getdocument().click();
		sleep(3);
		Credoc.GeteditdocumentNo().click();
		sleep(3);
		Credoc.getnumberappedix().selectByVisibleText(AppendixNumber);
		Credoc.Appendix().sendKeys(Appendix);
		Document_number = Credoc.getdocumentnumber().getAttribute("value");
		BaseClass.sleep(2);
		Credoc.getDocumentTitle().sendKeys("Test" + Document_number);
		Credoc.getDocChangeSummary().sendKeys("Test summary" + Document_number);
		verticalScrollingDown();
		Credoc.getConfirmButton().click();
		BaseClass.sleep(3);
	}

	private void Search(String Searchdata) {
		RecentlyViewdAndFavorites = new RecentlyViewdAndFavorites_POM(driver);
		RecentlyViewdAndFavorites.getplaceholder().sendKeys(Searchdata);
		RecentlyViewdAndFavorites.getGOButton().click();
	}

	@AfterClass
	public void closeBrowserInstance() throws IOException {

		cleanDownloadDirectory();
		sleep(2);
		logout.logoutFunction();
		log.info("logout successfully.");
		sleep(2);
		extent.endTest(test);
		driver.close();
	}
}
