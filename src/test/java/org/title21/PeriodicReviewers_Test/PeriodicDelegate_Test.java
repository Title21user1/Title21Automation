package org.title21.PeriodicReviewers_Test;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.PeriodicReviewers_POM.PeriodicOwnedDocuments_POM;
import org.title21.PeriodicReviewers_POM.PeriodicDelegate_POM;
import org.title21.utility.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class PeriodicDelegate_Test extends BaseClass {
	String className = "";
	PeriodicDelegate_POM PeriodicReviewDelegate;
	LogoutPage_POM logout;
	LoginPage_POM login;
	PeriodicOwnedDocuments_POM periodicReviews;
	String VerifyUnDelegateuserText = "";
	String element="";

	@BeforeClass
	public void openURL() {
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		PeriodicReviewDelegate = new PeriodicDelegate_POM(driver);
		logout = new LogoutPage_POM(driver);
		login = new LoginPage_POM(driver);
		periodicReviews = new PeriodicOwnedDocuments_POM(driver);
		login.loginUser("saurabhp", "Title123456*");
	}

	@Test(testName = " Periodic Delegate", groups = "PeriodicReviewer", priority = 0)
	public void PeriodicReview_Delegate() throws Exception {

		test = extent.startTest(" PeriodicReviewDelegate_Test");
		test.log(LogStatus.INFO, "Link to Test case document",
				"<a href='file://" + filePath + "'>TestCaseDocument</a>");
		PeriodicReviewDelegate.CreateDocumentAndAddReviewers();
		sleep(4);
		PeriodicReviewDelegate.Search(PeriodicReviewDelegate.documetNo);
		sleep(4);
		test.log(LogStatus.PASS, " 1.Go to Wizard>Review " + "<br/>"
				+ "2. Click on the document to view the required periodic reviewer of the document " + "<br/>"
				+ "<b>ER 1:The list of required reviewers is available, and the logged in test user is a required reviewer on the list<b>"
				+ test.addScreenCapture(captureScreenShot(driver, "DocumentOnreviewGrid ")));
		sleep(5);
		PeriodicReviewDelegate.getClickOnDocumentFromReviewList().click();
		sleep(5);
		PeriodicReviewDelegate.getDropdownOfReviewer().get(1).click();
		sleep(5);
		test.log(LogStatus.PASS,
				" 3.Click on the reviewer context menu next to the test users name. " + "<br/>"
						+ "<b>ER 2 : The Delegate option is available  <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "DelegationOption ")));
		sleep(3);
		PeriodicReviewDelegate.getDelegateOption().get(1).click();
		sleep(5);
		test.log(LogStatus.PASS, " 4.Click on Delegate and view the list of users in the Delegate to field.  " + "<br/>"
				+ "<b>ER 3 : The Delegate To list does not contain any of the reviewers already in the Required Reviewer list of the document<b>"
				+ test.addScreenCapture(captureScreenShot(driver, "Delegationoption ")));
		PeriodicReviewDelegate.getDelegateToDropdownFromaddDelegationwindow().selectByVisibleText("aparna");
		sleep(4);
		PeriodicReviewDelegate.getConfirm_Button().click();
		sleep(4);
		test.log(LogStatus.PASS,
				" 5.Select Test User 2nd name (from Prerequisite 2)  from the list and click Confirm. " + "<br/>"
						+ "<b>ER 4 : The second test users name is updated in the Delegated To field <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "adddelegateuser ")));
		
		logout.logoutFunction();
		sleep(2);
		login.loginUser("aparnak", "aparna2450");
		Reviewscreen_Document();
		sleep(5);
		if (PeriodicReviewDelegate.getClickOnDocumentFromReviewList().isDisplayed()) {
			test.log(LogStatus.PASS,
					"6.	Logout from Test user 1 and log in with the Test user 2 (User added as delegate user in step5. View the list of documents in the second test users review wizard."
							+ "<br/>"
							+ "<b>ER 5: The delegated periodic review is available in the review wizard of the second test user  <b>"
							+ test.addScreenCapture(captureScreenShot(driver, "Seconduserperiodicreveiew ")));

		}
		sleep(3);
		logout.logoutFunction();
		sleep(5);
		login.loginUser("sameer", "joshi12345");
		sleep(2);
		Reviewscreen_Document();
		sleep(4);
		PeriodicReviewDelegate.getClickOnDocumentFromReviewList().click();
		sleep(4);
		PeriodicReviewDelegate.getViewDocumentButton().click();
		{
			test.log(LogStatus.PASS,
					"7.	Logout and login again as the original reviewer (Test User 1 from Prerequisite 2). Navigate to the review wizard. "
							+ "<br/>" + "8.Select the document which was delegated in Step 4 and click on View Document"
							+ "<br/>"
							+ "<b>ER 6:The Change and Dont Change options are not available <b>"
							+ test.addScreenCapture(captureScreenShot(driver, "changdontchangeoption ")));
		}
		sleep(8);
		PeriodicReviewDelegate.getReviewTabOnPeriodicReviewscreen().click();
		sleep(10);
		PeriodicReviewDelegate.getDropdownOfReviewer().get(1).click();
		sleep(4);
		PeriodicReviewDelegate.getUndelegate().get(1).click();
		sleep(5);
		PeriodicReviewDelegate.getUndelegatepopupwindowYesButton().click();
		sleep(7);
		VerifyUnDelegateuserText = PeriodicReviewDelegate.getVerifyUnDelegateUser().get(8).getText();
		System.out.println(VerifyUnDelegateuserText);
		sleep(7);
		if (VerifyUnDelegateuserText.equalsIgnoreCase("N/A")) {

			test.log(LogStatus.PASS, "9.Close the document." + "<br/>"
					+ "10. Navigate to the periodic review list for the document and click on Undelegate from the reviewer options. Confirm Yes"
					+ "<br/>" + "<b>ER 7 : The delegation action is removed and the Delegated To column shows N/A  <b>"
					+ test.addScreenCapture(captureScreenShot(driver, "changdontchangeoption ")));

		}
		sleep(3);
		logout.logoutFunction();
		login.loginUser("aparnak", "aparna2450");
		Reviewscreen_Document();
		sleep(4);
		if (PeriodicReviewDelegate.NoResultvalidationMessage()) {
			test.log(LogStatus.PASS,
					"11.Logout, and log in again as the second test user (Test User 2 from Prerequisite 2). " + "<br/>"
							+ "12.	Navigate to the review wizard, and look for the periodic review for which the delegation was removed."
							+ "<br/>" + "<b>ER 8:The periodic review is not available for the second test user<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "verifyundelegateduserfromseconduser ")));

		}
		sleep(3);
		logout.logoutFunction();
		login.loginUser("sameer", "joshi12345");
		sleep(2);
		periodicReviews.wizard_Option().click();
		sleep(2);
		periodicReviews.wizardReview_Tab().click();
		sleep(8);
		PeriodicReviewDelegate.Search(PeriodicReviewDelegate.documetNo);
		sleep(5);
		PeriodicReviewDelegate.getClickOnDocumentFromReviewList().click();
		sleep(4);
		PeriodicReviewDelegate.getDropdownOfReviewer().get(1).click();
		sleep(4);
		PeriodicReviewDelegate.getDelegateOption().get(1).click();
		sleep(4);
		PeriodicReviewDelegate.getDelegateToDropdownFromaddDelegationwindow().selectByVisibleText("aparna");
		sleep(4);
		PeriodicReviewDelegate.getConfirm_Button().click();
		sleep(4);
		test.log(LogStatus.PASS, "13.Logout and log in again as the first test user (Test User 1 from Prerequisite 2)."
				+ "<br/>" + "14. Delegate the document again to the second test user." + "<br/>"
				+ "15.	Logout, and log in again as the second test user (Test User 2 from Prerequisite 2)." + "<br/>"
				+ "16.Click on the periodic review which was delegated in Step 14" + "<br/>"
				+ "<b>ER 9:The periodic review is available and  Delegated To field in the reviewer list is updated with the second test users name<b>"
				+ test.addScreenCapture(captureScreenShot(driver, "verifyundelegateduserfromseconduser ")));
		sleep(4);
		logout.logoutFunction();
		login.loginUser("aparnak", "aparna2450");
		periodicReviews.wizard_Option().click();
		org.title21.utility.BaseClass.sleep(2);
		periodicReviews.wizardReview_Tab().click();
		org.title21.utility.BaseClass.sleep(8);
		PeriodicReviewDelegate.Search(PeriodicReviewDelegate.documetNo);
		sleep(4);
		PeriodicReviewDelegate.getClickOnDocumentFromReviewList().click();
		PeriodicReviewDelegate.getViewDocumentButton().click();
		sleep(3);
		System.out.println("change doc ");
		sleep(4);
		PeriodicReviewDelegate.getChangeButton().click();
		sleep(3);
		PeriodicReviewDelegate.getPinNoChangesScreen().clear();
		PeriodicReviewDelegate.getPinNoChangesScreen().sendKeys("262829");
		sleep(5);
		PeriodicReviewDelegate.getCommentsOnChangesScreen().sendKeys("test");
		sleep(4);
		PeriodicReviewDelegate.getConfirm_Button().click();
		sleep(4);
		test.log(LogStatus.PASS,
				"17.Click on View Document, and complete the periodic review by clicking on the Change or Dont Change button."
						+ "<br/>" + "18. Enter pin and comment" + "<br/>" + "19.Click on confirm" + "<br/>"
						+ "20.	Check the periodic review wizard by clicking on the Reviews link in the left navbar under wizard."
						+ "<br/>"
						+ "<b>ER 10 : The document is removed from the list after the periodic review is performed<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "changedoc ")));
		PeriodicReviewDelegate.getReviewTabOnPeriodicReviewscreen().click();
		logout.logoutFunction();
		AuditLog();

	}

	private void AuditLog() {
		login.loginUser("saurabhp", "Title123456*");
		PeriodicReviewDelegate.getdropdowforauditmenu().click();
		PeriodicReviewDelegate.getAuditlogButton().click();
		sleep(3);
		PeriodicReviewDelegate.getusernamedropdown().selectByVisibleText("aparnak");
		PeriodicReviewDelegate.getTypedropdown().selectByVisibleText("Enter/Update Review");
		sleep(2);
		String updateandenter = test.addScreenCapture(captureScreenShot(driver, "auditlogundelgation "));
		PeriodicReviewDelegate.getTypedropdown().selectByVisibleText("Delegation");//
		PeriodicReviewDelegate.getusernamedropdown().selectByVisibleText("sameer");
		PeriodicReviewDelegate.getConfirm_Button().click();
		sleep(3);
		String delegatescrc = test.addScreenCapture(captureScreenShot(driver, "auditlogundelgation "));
		PeriodicReviewDelegate.getTypedropdown().selectByVisibleText("Clear Delegation");
		PeriodicReviewDelegate.getConfirm_Button().click();
		sleep(3);
		test.log(LogStatus.PASS, "21.Logout from Test user " + "<br/>" + "22.Log in as local or system admin. "
				+ "<br/>" + "23.Navigate to Audit Log." + "<br/>"
				+ "24.Select Test user 1 from username dropdown (Test User 1 from Prerequisite 2)." + "<br/>"
				+ "<b>ER 11 : The initial delegate action, the clear delegate and another delegate action "
				+ "which were performed by the first test user is available in the audit log<b>"
				+ test.addScreenCapture(captureScreenShot(driver, "auditlogundelgation ")) + delegatescrc);
		sleep(4);
		PeriodicReviewDelegate.getConfirm_Button().click();
		test.log(LogStatus.PASS, " 25.	Select Test user 2 from username dropdown (Test User 2 from Prerequisite 2)."
				+ "<br/>" + "26. Select type as Enter/Update Review " + "<br/>"
				+ "<b>ER 12 : The periodic review action performed by the second test user is available in the audit logs <b>"
				+ updateandenter);

	}

	private void Reviewscreen_Document() {
		periodicReviews.wizard_Option().click();
		sleep(2);
		periodicReviews.wizardReview_Tab().click();
		sleep(8);
		PeriodicReviewDelegate.Search(PeriodicReviewDelegate.documetNo);//
	}
	
	@AfterClass
	public void closeBrowserInstance() throws IOException {
		sleep(2);
		logout.logoutFunction();
		sleep(2);
		extent.endTest(test);
		driver.close();
	}
}
