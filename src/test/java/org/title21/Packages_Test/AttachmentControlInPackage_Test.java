package org.title21.Packages_Test;

import java.io.File;

import org.apache.log4j.Logger;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.Documents_POM.CreateDocument_POM;
import org.title21.Documents_POM.DocumentCollaboration_POM;
import org.title21.Packages_POM.AttachmentControlInPackage_POM;
import org.title21.utility.BaseClass;
import org.title21.utility.DownloadUtils;

import com.relevantcodes.extentreports.LogStatus;

public class AttachmentControlInPackage_Test extends BaseClass {

	LogoutPage_POM logout;
	LoginPage_POM login;
	public String className = "";
	AttachmentControlInPackage_POM attachmentpackage;
	DocumentCollaboration_POM Documentcoll_POM;
	static Logger log = Logger.getLogger(CreateDocument_POM.class);
	@BeforeClass
	public void openURL() {

		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		logout = new LogoutPage_POM(driver);
		login = new LoginPage_POM(driver);
		Documentcoll_POM = new DocumentCollaboration_POM(driver);
		attachmentpackage = new AttachmentControlInPackage_POM(driver);
		//
		login.loginUser("saurabhp", "Title123456*");
	}

	@Test(testName = " AttachemntContrilInPackage", groups = "AttachemntContrilInPackage", priority = 0)
	public void AttachemntContrilInPackage() throws Exception {

		test = extent.startTest(" DocumentCollaboration_Test");
		test.log(LogStatus.INFO, "Link to Test case document",
				"<a href='file://" + filePath + "'>TestCaseDocument</a>");
		log.info("AttachemntContrilInPackage");
		attachmentpackage.Create_Package();
		sleep(4);
		String package_name = attachmentpackage.getpackagecreatedname().get(0).getText();
		sleep(4);
		String home_page = driver.getWindowHandle();
		sleep(2);
		attachmentpackage.getAttachmentsTab().click();
		sleep(3);
		attachmentpackage.getAddLink().get(3).click();
		sleep(5);
		test.log(LogStatus.PASS,
				"1 Create a new package." + "<br/>" + "2.Navigate to Attachment/Task tab" + "<br/>"
						+ "3.Click on Add New link." + "<br/>" + "<b>ER 1 : Add a file/document dialog appears. <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "addnewlink")));
		attachmentpackage.fileupload("upload.PNG");//
		sleep(7);
		test.log(LogStatus.PASS, "4.	Click on Choose File button.." + "<br/>"
				+ "5.	Try to attach a file type which is not a MS Word document or an executable (e.g. Jpeg, PNG, TXT etc.)."
				+ "<br/>" + "<b> ER 2 :File is successfully attached <b>"
				+ test.addScreenCapture(captureScreenShot(driver, "addpngdoc")));
		attachmentpackage.getAddLink().get(3).click();
		sleep(7);
		attachmentpackage.fileupload("DocDocument.docx");
		sleep(7);
		test.log(LogStatus.PASS,
				"6.	Click on the Add New link again, and try to attach a MS Word (.doc or .docx) document. \n"
						+ " Note: Ensure the word document is not empty and has some text.\n" + "" + "<br/>"
						+ "<b> ER 3 : The word document is also attached successfully.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "addmsworddocument")));
		sleep(3);
		attachmentpackage.getnativedownloadoption().get(1).click();
		sleep(5);
		File downloadedFile = DownloadUtils.waitForDownloadToComplete("upload.PNG");
		if (downloadedFile.exists()) {
			test.log(LogStatus.PASS,
					"7.	Click on the Native link under the Open column for 1st file attached." + "<br/>"
							+ "<b> ER 4 : File/attachment is downloaded in the native format. .<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "wordfiledownload")));
		}
		sleep(3);
		attachmentpackage.getpdf().get(0).click();
		sleep(5);
		test.log(LogStatus.PASS,
				"8.	Click on the PDF link under the “Open” column for the attached MS Word document." + "<br/>"
						+ "<b> ER 5:The MS Word file attachment successfully opens in PDF format<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "pdfdownload")));
		sleep(3);
		driver.switchTo().window(home_page);
		sleep(3);
		attachmentpackage.getedit().get(1).click();
		sleep(3);
		test.log(LogStatus.PASS,
				"9.	Close the PDF." +"<br/>"+ "10.Click on the edit icon to edit the attachment." + "<br/>"
						+ "<b>ER 6 :The Editing Attachment screen appears. <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "editfile")));
		attachmentpackage.geDescription().sendKeys("Test File");
		sleep(3);
		attachmentpackage.getupdate().click();
		sleep(5);
		test.log(LogStatus.PASS,
				"11.Add a description and edit the file name."+"<br/>" + "12.Click on Update." + "<br/>"
						+ "<b> ER 7 :The description is added and the file name is changed. <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "editdocumentandadddescription")));
		sleep(3);
		attachmentpackage.getremove().get(0).click();
		sleep(5);
		test.log(LogStatus.PASS,
				"13 Click on delete attachment." + "<br/>" + "<b> ER 8 :The Remove Attachment screen appears.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "pdfdownload")));
		sleep(3);
		attachmentpackage.getyes().click();
		sleep(3);
		test.log(LogStatus.PASS, "14 Click on Yes." + "<br/>" + "<b> ER 9 : The Attachment is deleted successfully.<b>"
				+ test.addScreenCapture(captureScreenShot(driver, "pdfdownload")));
		attachmentpackage.SearchTab(package_name);
		sleep(5);
		if (attachmentpackage.getclieckonserchdoc().getText().contains(package_name)) {
			sleep(5);
			attachmentpackage.getclieckonserchdoc().click();
			sleep(5);

			test.log(LogStatus.PASS,
					"15.Go to searches." +"<br/>"+ "16.Click on Search Packages link and click on go button" + "<br/>"
							+ "17.Enter Package number created in step(1) in filter result field" + "<br/>"
							+ "18.Click on go button." + "<br/>"
							+ "<b> ER 10 :The Package is displayed as per search result.<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "clickonsearchdocument")));
		}
		sleep(5);
		attachmentpackage.getAttachmentsTab().click();
		sleep(4);
		test.log(LogStatus.PASS,
				"19.Click on show linked document and attachment arrow." + "<br/>"
						+ "20.Expand the attachment section by clicking on attachment." + "<br/>"
						+ "21.Verify the attachment added in step (6)." + "<br/>"
						+ "<b> 11.Verify the attachment added in step (6).<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "verifylinkdocument")));

	}

	@AfterClass
	public void closeBrowserInstance() {
		extent.endTest(test);
		driver.close();
	}
}