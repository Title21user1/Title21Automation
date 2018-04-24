package org.title21.Documents_Test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.Documents_POM.DocumentCollaboration_POM;
import org.title21.Documents_POM.NonCollaborationTask_POM;
import org.title21.Module3_POM.AttachmentControlInDoc_POM;
import org.title21.utility.BaseClass;
import org.title21.utility.DateTimeUtils;

import com.relevantcodes.extentreports.LogStatus;

public class NonCollaborationTask_Test extends BaseClass {
	LogoutPage_POM logout;
	LoginPage_POM login;
	public String className = "";
	NonCollaborationTask_POM NonCollaboration;
	DocumentCollaboration_POM DocumentCollaboration;
	static Logger log = Logger.getLogger(AttachmentControlInDoc_POM.class);

	@BeforeClass
	public void openURL() {

		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		logout = new LogoutPage_POM(driver);
		login = new LoginPage_POM(driver);
		DocumentCollaboration = new DocumentCollaboration_POM(driver);
		NonCollaboration = new NonCollaborationTask_POM(driver);

	}

	@Test(testName = " NonCollaborationTask", groups = "NonCollaborationTask", priority = 0)
	public void Non_Collaboration_Test() {

		test = extent.startTest("NonCollaborationTask_Test");
		test.log(LogStatus.INFO, "Link to Test case document",
				"<a href='file://" + filePath + "'>TestCaseDocument</a>");

		addcollaborator();
		sleep(5);
		DocumentCollaboration.getMyTaskTab().click();
		DocumentCollaboration.getAssignByMe().get(1).click();
		sleep(4);
		test.log(LogStatus.PASS,
				"12.Click on update." + "<br/>" + "13.Navigate to my task > Assigned by me" + "<br/>"
						+ "<b>ER 4 : The created task is available in the Test user 1s assigned by me list.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "Edit_Task ")));
		sleep(4);
		auditlog();
		sleep(4);
		test.log(LogStatus.PASS,
				"14.Navigate to the audit log." + "<br/>" + "15.	Select type as add task item." + "<br/>"
						+ "<b>ER 5 : An email is sent to the second test user is available in the audit log.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "Audit_log ")));
		logout.logoutFunction();
		sleep(4);
		getDocumentFromUser2Collaborationlist();
		sleep(3);
		DocumentCollaboration.getDocumentonCollaboration().click();
		DocumentCollaboration.getMarkTaskCompleteButton().click();
		sleep(4);
		test.log(LogStatus.PASS,
				"19.Mark the collaboration task as complete" + "<br/>"
						+ "<b>ER 7: The Checkoff task popup is displayed.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "MarkTask_popup ")));
		DocumentCollaboration.getPin().sendKeys("262829");
		sleep(2);
		DocumentCollaboration.getConfirmButton().click();
		sleep(2);
		if (DocumentCollaboration.NoResultvalidationMessage()) {
			test.log(LogStatus.PASS, "20.Enter pin and click on confirm." + "<br/>"
					+ "<b>ER 8 : The task is completed and it is no longer available in the User2 tasks list.<b>"
					+ test.addScreenCapture(captureScreenShot(driver, "Audit_log ")));
		}
		logout.logoutFunction();
		login.loginUser("saurabhp", "Title123456*");
		sleep(3);
		System.out.println(DocumentCollaboration.documetNo);
		DocumentCollaboration.SearchTab(DocumentCollaboration.documetNo);
		sleep(5);
		DocumentCollaboration.getdoconsearch().click();
		sleep(3);
		DocumentCollaboration.getCollaborationTabonsearch().get(0).click();
		sleep(3);
		DocumentCollaboration.getCollaborationTasklist().get(11).click();
		sleep(3);
		test.log(LogStatus.PASS,
				"21.Log out of test user 2" + "<br/>" + "22.	Login Test user 1. " + "<br/>"
						+ "23.Open the document created in step(2)" + "<br/>" + "24.Navigate to Collaboration tab."
						+ "<br/>" + "<b>ER 9:The task is completed and date time of completion is updated .<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "complte_task_status_verify ")));
		sleep(5);
		if (NonCollaboration.getdisable_edit_mode().isDisplayed()) {
			test.log(LogStatus.PASS,
					"25.Click on edit and delete button." + "<br/>"
							+ "<b>ER 10 :Delete and edit buttons are disabled for the completed task. <b>"
							+ test.addScreenCapture(captureScreenShot(driver, "edit_and_delete_disable ")));
		}
		logout.logoutFunction();
	}

	public void addcollaborator() {
		login.loginUser("saurabhp", "Title123456*");
		DocumentCollaboration.CreateDocument();
		sleep(4);
		DocumentCollaboration.getCollaborationTab().click();
		sleep(4);
		DocumentCollaboration.getAddColaboratorlink().get(3).click();
        sleep(3);
		test.log(LogStatus.PASS,
				"1.	Login as Test user 1." + "<br/>" + "2.Create a new document." + "<br/>"
						+ "3.Navigate to Collaboration tab. " + "<br/>" + "4.Click on Add new task link." + "<br/>"
						+ "<b>ER 1: Add New Task popup is displayed. <b>"
						+ test.addScreenCapture(captureScreenShot(driver, "Task_window ")));

		sleep(10);
		DocumentCollaboration.getDescription_On_AddCollaborator().clear();
		sleep(2);
		DocumentCollaboration.getDescription_On_AddCollaborator().sendKeys("Automation testing");
		sleep(2);
		DocumentCollaboration.getLocation().selectByVisibleText("Dallas");
		sleep(4);
		DocumentCollaboration.getAssignToPerson_On_AddCollaborator().sendKeys("sameer");
		sleep(4);
		String pickDate = DateTimeUtils.getTomorrowDate();
		String[] preDate = pickDate.split("/");
		String dd1 = preDate[1];
		String dd = dd1;
		if (dd1.contains("0")) {
			dd = dd1.substring(1, 2);
			if (dd.equals("0")) {
				dd = dd1;
			}
		}
		DocumentCollaboration.getDueDate_On_AddCollaborator().click();
		org.title21.utility.BaseClass.sleep(2);
		driver.findElement(By.xpath("//td[text()='" + dd + "']")).click();
		sleep(3);

		DocumentCollaboration.getelectonisognaturecheckbox(true);
		sleep(2);
		DocumentCollaboration.getEmailOnaddNewcheckbox(true);
		sleep(3);
		DocumentCollaboration.getEnableTaskcheckbox(true);
		DocumentCollaboration.getNotifyMeWhenTaskCompleteCheckbox(true);
		sleep(3);
		test.log(LogStatus.PASS, "5.	Add the Description and select a Category." + "<br/>"
				+ "6.Assign To: Test User 2 (A second test user)." + "<br/>"
				+ "7 .Due Date: A day after the current date." + "<br/>"
				+ "8.Ensure Required Electronic Signature to check-off, Enable Task, Email task to assignee and Notify me when task is completed checkboxes are checked"
				+ "<br/>" + "9.	Add notes." + "<br/>" + "10.Click on Add." + "<br/>"
				+ "<b>ER 2 :Task is created and assigned to the second test user.<b>"
				+ test.addScreenCapture(captureScreenShot(driver, "Task_Created_And_Assign")));

		sleep(3);
		verticalScrollingUp();
		NonCollaboration.getNotes().sendKeys("test collaboration");
		DocumentCollaboration.getAddButton().click();
		sleep(5);
		NonCollaboration.geteditbutton().click();
		sleep(5);
		test.log(LogStatus.PASS,
				"11.Again edit the task." + "<br/>" + "<b>ER 3 : Task is configured as specified in above steps.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "Edit_Task ")));
		sleep(4);
		DocumentCollaboration.getDescription_On_AddCollaborator().clear();
		DocumentCollaboration.getDescription_On_AddCollaborator().sendKeys("update test data");
		NonCollaboration.getupdate().click();
		sleep(5);

	}

	public void getDocumentFromUser2Collaborationlist() {
		login.loginUser("sameer", "joshi12345");
		DocumentCollaboration.getMyDocumentTab().click();
		DocumentCollaboration.getcollaborationOnMyDocument().get(5).click();
		sleep(3);
		DocumentCollaboration.Search(DocumentCollaboration.documetNo);
		sleep(3);
		if (DocumentCollaboration.getDocumentonCollaboration().getText().contains(DocumentCollaboration.documetNo)) {
			test.log(LogStatus.PASS, "16.Logout from Test user 1" + "<br/>"
					+ "17.Login to the Test user 2 (test user used in step 5(a)). " + "<br/>"
					+ "18.Navigate to My Documents > Task" + "<br/>" + "<b>ER 6:The task is available in the list.<b>"
					+ test.addScreenCapture(captureScreenShot(driver, "verify_document_task_on_2nduser ")));
		}
	}

	public void auditlog() {
		sleep(5);
		DocumentCollaboration.getdropdowforauditmenu().click();
		sleep(3);
		DocumentCollaboration.getAuditlogButton().click();
		DocumentCollaboration.getTypedropdown().selectByVisibleText("Add Task Item");
		DocumentCollaboration.getConfirmButton().click();
		sleep(4);

	}
	@AfterClass
	public void closeBrowserInstance() {
		extent.endTest(test);
		driver.quit();
	}
}
