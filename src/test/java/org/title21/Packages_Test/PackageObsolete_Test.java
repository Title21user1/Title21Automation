package org.title21.Packages_Test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.Documents_POM.DocumentCollaboration_POM;
import org.title21.Documents_POM.DocumentRoutes_POM;
import org.title21.Packages_POM.PackageObsolete_POM;
import org.title21.utility.BaseClass;
import org.title21.utility.DateTimeUtils;

import com.relevantcodes.extentreports.LogStatus;

public class PackageObsolete_Test extends BaseClass {

	LogoutPage_POM logout;
	LoginPage_POM login;
	public String className = "";
	PackageObsolete_POM PackageObsoletePOM;
	DocumentCollaboration_POM DocumentCollaborationPOM;
	DocumentRoutes_POM documentRoutes;
	DocumentCollaboration_POM Documentcoll_POM;

	@BeforeClass
	public void openURL() {

		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		logout = new LogoutPage_POM(driver);
		login = new LoginPage_POM(driver);
		PackageObsoletePOM = new PackageObsolete_POM(driver);
		DocumentCollaborationPOM = new DocumentCollaboration_POM(driver);
		Documentcoll_POM = new DocumentCollaboration_POM(driver);
		documentRoutes = new DocumentRoutes_POM(driver);
		login.loginUser("saurabhp", "Title123456*");
	}

	@Test(testName = "Package_obsolete_Test", groups = "Package_obsolete_Test", priority = 0)
	public void Package_obsolete() throws Exception {

		test = extent.startTest("PackageObsolete_Test");
		test.log(LogStatus.INFO, "Link to Test case document",
				"<a href='file://" + filePath + "'>TestCaseDocument</a>");
		PackageObsoletePOM.GenerateEffectiveFile("1");
		sleep(5);
		PackageObsoletePOM.GenerateEffectiveFile("2");
		sleep(2);
		PackageObsoletePOM.getNewTab().click();
		sleep(5);
		PackageObsoletePOM.getPackageIcon().get(6).click();
		sleep(5);
		test.log(LogStatus.PASS,
				" 1.	Login to the web interface. " + "<br/>" + "2.Click on the new and select package." + "<br/>"
						+ "<b>ER 1 : Create new Package screen will appear<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "create_package ")));

		PackageObsoletePOM.getCabinetDropdown().selectByVisibleText("Open DCOs");
		sleep(2);
		/*
		 * PackageObsoletePOM.getSection_Dropdown().selectByIndex(1); sleep(2);
		 */
		PackageObsoletePOM.getPackagename().sendKeys("autopackage");
		sleep(3);
		PackageObsoletePOM.getCreate_Button().click();
		sleep(5);
		test.log(LogStatus.PASS,
				" 3.Select Cabinet as open DCOs and Section from the dropdown list." + "<br/>"
						+ "4.	Add Package Name." + "<br/>" + "5.Click on Create." + "<br/>"
						+ "<b> ER 2: package screen will appear.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "package_screen ")));
		sleep(4);
		String package_name = PackageObsoletePOM.getpackagecreatedname().get(0).getText();
		verticalScrollingUp();
		add_link("1", PackageObsoletePOM.DocumetNoDelete);
		sleep(3);
		PackageObsoletePOM.getContextMenu().get(3).click();
		sleep(3);
		verticalScrollingDown();
		sleep(5);
		PackageObsoletePOM.getobsolet_on().get(7).click();
		sleep(3);
		PackageObsoletePOM.getCloseButton().get(4).click();
		sleep(3);
		test.log(LogStatus.PASS,
				"12.Mark the document to be obsolete from the context menu " + "<br/>"
						+ "<b> ER 5:Document is marked Obsolete Message is displayed.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "delete_popup ")));
		verticalScrollingDown();
		sleep(5);
		PackageObsoletePOM.getDelete().click();
		sleep(5);
		test.log(LogStatus.PASS,
				"13.Click on Close." + "<br/>"
						+ "14.	Click on delete icon to remove the effective document from the Package" + "<br/>"
						+ "<b>ER 6:Remove attached document popup is displayed..<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "deletedocument ")));
		sleep(4);
		PackageObsoletePOM.getYesButtonOfDeletePopup().click();
		sleep(3);
		test.log(LogStatus.PASS,
				"15.Click on yes button.." + "<br/>"
						+ "<b>ER 7 : The document is removed from the package (No attached documents).<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "deletedocument ")));
		sleep(3);
		add_link("2", PackageObsoletePOM.documetNo);
		sleep(6);
		sleep(3);
		PackageObsoletePOM.getContextMenu().get(3).click();
		sleep(3);
		verticalScrollingDown();
		sleep(5);
		PackageObsoletePOM.getobsolet_on().get(7).click();
		sleep(3);
		PackageObsoletePOM.getCloseButton().get(4).click();
		String pickDate = DateTimeUtils.getCurrentPSTDate();
		String[] preDate = pickDate.split("/");
		String dd1 = preDate[1];
		String dd = dd1;
		if (dd1.contains("0")) {
			dd = dd1.substring(1, 2);
			if (dd.equals("0")) {
				dd = dd1;
			}
		}
		sleep(4);
		PackageObsoletePOM.getObsolete_Date().click();
		sleep(3);
		driver.findElement(By.xpath("//td[text()='" + dd + "']")).click();
		sleep(3);
		test.log(LogStatus.PASS, " 16.Add another effective document to the package " + "<br/>"
				+ "17.Mark an Effective document to Obsolete. " + "<br/>"
				+ "18.	On the Package set the Obsolete Date to current date." + "<br/>"
				+ "<b>ER 8 :Update attached Document(s) (obsoleted only) to this Obsolete Date? Popup screen is displayed.<b>"
				+ test.addScreenCapture(captureScreenShot(driver, "add_document_and_set_date ")));
		sleep(3);
		PackageObsoletePOM.getYesButtonOfDeletePopup().click();
		sleep(3);
		test.log(LogStatus.PASS,
				" 19.Click on Yes. " + "<br/>" + "<b>ER 9: Updated 1 Document message popup is displayed.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "yes_button_Delete_popup ")));
		sleep(3);
		PackageObsoletePOM.getCloseButton().get(1).click();
		sleep(4);
		driver.navigate().refresh();
		sleep(3);
		verticalScrollingUp();
		sleep(4);
		driver.findElement(By.xpath("//*[text()='Approvals']")).click();
		sleep(4);
		approvePackage();
		sleep(5);
		test.log(LogStatus.PASS,
				" 20.Click on Close. " + "<br/>" + "21.Navigate to approval tab. " + "<br/>" + "22.Add one approver."
						+ "<br/>" + "<b>ER 10: Approver is added .<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "add_approver ")));
		// sleep(3);
		verticalScrollingUp();
		PackageObsoletePOM.getContextMenu().get(2).click();
		PackageObsoletePOM.Routeforapproval().click();
		sleep(3);
		PackageObsoletePOM.getCreate_Button().click();
		sleep(5);
		test.log(LogStatus.PASS,
				"23.Route the Package for Approval by clicking on route for approval from context menu." + "<br/>"
						+ "<b>ER11: Confirmation message for approval is displayed<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "DocumentOnreviewGrid ")));
		// PackageObsoletePOM.yesbuttonroutes().click();
		sleep(5);
		test.log(LogStatus.PASS,
				"24.Click on yes button" + "<br/>"
						+ "<b>ER 12 : A message confirming package is routed for approval is displayed, <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "Messageforroute ")));
		PackageObsoletePOM.getcheckinclose().get(1).click();
		sleep(3);
		logout.logoutFunction();
		login.loginUser("sameer", "joshi12345");
		sleep(4);
		PackageObsoletePOM.getMydocument().click();
		PackageObsoletePOM.getapprovallinkonmydocument().click();
		sleep(3);
		PackageObsoletePOM.getplaceholderonapproved().sendKeys(package_name);
		sleep(3);
		PackageObsoletePOM.getGoButton().get(0).click();
		sleep(5);
		PackageObsoletePOM.getSerch_document().click();
		sleep(5);
		PackageObsoletePOM.getapproval().click();
		verticalScrollingDown();
		sleep(3);
		PackageObsoletePOM.gapprovelink().click();
		sleep(3);
		PackageObsoletePOM.getpinToApprove().sendKeys("262829");
		sleep(3);
		PackageObsoletePOM.getCreate_Button().click();
		sleep(3);
		test.log(LogStatus.PASS,
				"25.Click on close button." + "<br/>" + "26.Approve the package from approver." + "<br/>"
						+ "<b>ER 13: The package is successfully approved.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "approve_package ")));

		sleep(4);
		logout.logoutFunction();
		sleep(4);
		login.loginUser("saurabhp", "Title123456*");
		sleep(3);
		Documentcoll_POM.SearchTab(PackageObsoletePOM.documetNo + ": 1.0");
		sleep(3);
		PackageObsoletePOM.getSerch_document().click();
		sleep(4);
		test.log(LogStatus.PASS,
				"27.Take the attached Effective documents name and go to the searches." + "<br/>"
						+ "28.Search for that document." + "<br/>" + "29.Open the document." + "<br/>"
						+ "<b>ER 14 : The Obsoleted document moved automatically to the Obsolete Cabinet.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "approve_package ")));
		Documentcoll_POM.SearchTab(PackageObsoletePOM.DocumetNoDelete + ": 1.0");
		sleep(4);
		PackageObsoletePOM.getSerch_document().click();
		test.log(LogStatus.PASS,
				"30.Again go to searches " + "<br/>" + "31.Search for the document which was removed in step (15)."
						+ "<br/>" + "32.Open the document." + "<br/>"
						+ "<b>ER 15 : The document which was initially attached and removed has NOT been obsoleted.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "approve_package ")));
		sleep(4);

	}

	public void add_link(String scenario, String doc) {
		sleep(4);
		PackageObsoletePOM.getAdd_remove_link().get(0).click();
		sleep(5);
		if (scenario.equalsIgnoreCase("1")) {
			test.log(LogStatus.PASS,
					" 6.Ensure the Package is open in edit mode. " + "<br/>"
							+ "7.Click on Add/Remove link available in documents frame." + "<br/>"
							+ "<b> ER 3  Attach documents screen will appear.<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "attached_popup ")));
		}
		sleep(4);
		PackageObsoletePOM.getSearch_textbox().get(2).sendKeys(doc);
		sleep(3);
		PackageObsoletePOM.getGoButton_Search().click();
		sleep(3);
		PackageObsoletePOM.getcheckboxonDocumentlist().click();
		sleep(4);
		PackageObsoletePOM.getOkButton_AttachedDoc().get(0).click();
		sleep(3);
		if (scenario.equalsIgnoreCase("1")) {
			test.log(LogStatus.PASS,
					" 8.	Select Status: Open, Created between (e.g. a month before current date and current date), Type: Document and Location: ALL "
							+ "<br/>" + "9.	Enter effective in the search field and click on go button" + "<br/>"
							+ "10.	Select one effective document." + "<br/>" + "11:Click on OK." + "<br/>"
							+ "<b>ER 4:Added documents appear in the document frame.<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "added_document_appear ")));
		}

	}

	public void approvePackage() {
		documentRoutes.getAddApproverLink().click();
		org.title21.utility.BaseClass.sleep(2);
		documentRoutes.getApproverRole().selectByVisibleText("Approver");
		org.title21.utility.BaseClass.sleep(2);
		documentRoutes.getnameinAddApprover().selectByVisibleText("sameer");
		documentRoutes.getSequenceinAddApprover().selectByVisibleText("1");
		documentRoutes.getallottedDaysinAddApprover().selectByVisibleText("1 day");
		documentRoutes.approverAdd_Button().click();
	}

	@AfterClass
	public void closeBrowserInstance() {
		extent.endTest(test);
		driver.close();
	}
}