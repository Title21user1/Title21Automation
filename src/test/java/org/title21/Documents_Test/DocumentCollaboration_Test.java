package org.title21.Documents_Test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.Documents_POM.DocumentCollaboration_POM;
import org.title21.Module3_POM.AttachmentControlInDoc_POM;
import org.title21.utility.BaseClass;
import org.title21.utility.DateTimeUtils;

import com.relevantcodes.extentreports.LogStatus;

public class DocumentCollaboration_Test extends BaseClass {

	LogoutPage_POM logout;
	LoginPage_POM login;
	public String className = "";
	DocumentCollaboration_POM DocumentCollaboration;
	static Logger log = Logger.getLogger(AttachmentControlInDoc_POM.class);

	@BeforeClass(alwaysRun=true)
	public void openURL() {

		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		logout = new LogoutPage_POM(driver);
		login = new LoginPage_POM(driver);
		DocumentCollaboration = new DocumentCollaboration_POM(driver);

	}

	@Test(testName = "Document Collaboration", groups = "DocumentModule", priority = 0, alwaysRun=true)
	public void Document_Collaboration_Test() {

		test = extent.startTest("Document Collaboration");
		test.log(LogStatus.INFO, "Link to Test case document",
				"<a href='file://" + filePath + "'>TestCaseDocument</a>");
		log.info("Document Collaboration");
		login.loginUser("Title21User1", "test123456");
		addcollaborator("1");
		sleep(5);
		DocumentCollaboration.getMyTaskTab().click();
		DocumentCollaboration.getAssignByMe().get(1).click();
		sleep(3);
		test.log(LogStatus.PASS,
				"7.	Navigate to my task  Assigned by me." + "<br/>"
						+ "<b>ER 4 : The created task is available in the Test user 1s assigned by me list.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "AssignByMeTask")));
		sleep(2);
		auditlog();
		test.log(LogStatus.PASS,
				"8.	Navigate to the audit log" + "<br/>" + "9.Select type as add task item.	" + "<br/>"
						+ "<b>ER 5: An email is sent to the second test user is available in the audit log.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "Email_available_in_auditlog")));
		logout.logoutFunction();
		sleep(4);
		getDocumentFromUser2Collaborationlist();
		sleep(3);
		String verifyCollaboration = DocumentCollaboration.getDocumentonCollaboration().getText();
		if (verifyCollaboration.contains(DocumentCollaboration.documetNo)) {
			test.log(LogStatus.PASS,
					"10.Logout from Test user 1" + "<br/>"
							+ "11.Login to the Test user 2 (test user used in step 5(a)). " + "<br/>"
							+ "12.Navigate to My Documents > Collaboration." + "<br/>"
							+ "<b>ER 6 : The collaboration task is available in the list<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "collaboration_task_second_user")));
		}
		sleep(4);
		DocumentCollaboration.getContextmenu().click();
		sleep(3);
		DocumentCollaboration.getForm().click();
		sleep(3);
		DocumentCollaboration.edit_mode_enable().get(1).click();
		sleep(3);
		test.log(LogStatus.PASS,
				"13.Open the document form from the context menu. " + "<br/>" + "14.Enable edit mode." + "<br/>"
						+ "<b>ER 7 : Form fields are editable.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "Form_Field_Editable")));
		DocumentCollaboration.getDocumentonCollaboration().click();
		sleep(3);
		DocumentCollaboration.getMarkTaskCompleteButton().click();
		sleep(4);
		test.log(LogStatus.PASS,
				"15. Mark the collaboration task as complete. " + "<br/>"
						+ "<b>ER 8 : The Checkoff document collaboration popup is displayed.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "Checkoff_collaboration_popup")));
        sleep(5);
		DocumentCollaboration.getPin().sendKeys("212223");
		sleep(5);
		DocumentCollaboration.getConfirmButton().click();
		sleep(6);
       test.log(LogStatus.PASS,
				" 16.Enter pin and click on confirm." + "<br/>"
						+ "<b>ER 9 : The task is completed and it is no longer available in the collaboration list.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "task_not_available")));

		sleep(4);
		logout.logoutFunction();
		sleep(4);
		login.loginUser("Title21User1", "test123456");
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
		String VerifyStatus = DocumentCollaboration.getTaskstatusverify().get(1).getText();
		sleep(4);
		if (VerifyStatus.equalsIgnoreCase("Completed")) {
			test.log(LogStatus.PASS,
					" 17.Log out of test user 2" + "<br/>" + "18.Login Test user 1. " + "<br/>"
							+ "19.Open the document created in step(2)" + "<br/>" + "20.Navigate to Collaboration tab."
							+ "<br/>" + "<b>ER 10 : The task is completed and date time of completion is updated.<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "Task_completed_Status")));
		}
		sleep(3);
		logout.logoutFunction();
	    login.loginUser("Title21User1", "test123456");
		addcollaborator("2");
		sleep(4);
		auditlog();
		sleep(4);
		test.log(LogStatus.PASS, " 24.Go to audit log " + "<br/>"
				+ "<b>ER 13 :An email is not sent to the second test user as checkbox is unchecked in step 22(e).<b>"
				+ test.addScreenCapture(captureScreenShot(driver, "MarkTaskcompleted_popup")));

		logout.logoutFunction();
		sleep(4);
		getDocumentFromUser2Collaborationlist();
		sleep(4);
		DocumentCollaboration.getContextmenu().click();
		sleep(3);
		DocumentCollaboration.getForm().click();
		/*sleep(3);
		DocumentCollaboration.edit_mode_enable().get(1).click();*/
		sleep(3);
		if (DocumentCollaboration.RecordLockvalidatiom()) {
			test.log(LogStatus.PASS, " 25.Logout from Test user 1" + "<br/>" + "26.Login to the Test user 2" + "<br/>"
					+ "27.Navigate to My Documents > Collaboration." + "<br/>"
					+ "28.Open the document form from the context menu. " + "<br/>" + "29.Try to enable edit mode. "
					+ "<br/>" + "<b>ER 14 :This record is locked for editing message is displayed <b>"
					+ test.addScreenCapture(captureScreenShot(driver, "Record_lock_editing")));
		}
		/*DocumentCollaboration.getCloseButton().click();*/
		sleep(5);
		DocumentCollaboration.getdoconsearch().click();
		DocumentCollaboration.getMarkTaskCompleteButton().click();
		sleep(2);
		test.log(LogStatus.PASS,
				" 30.Click on task and click on mark task complete." + "<br/>"
						+ "<b>ER 15:Mark task completed confirmation popup is displayed.<b>"
						+ test.addScreenCapture(captureScreenShot(driver, "MarkTaskcompleted_popup")));

		DocumentCollaboration.getAddButton().click();
		sleep(3);
		logout.logoutFunction();
		sleep(3);
		login.loginUser("Title21User1", "test123456");
		sleep(3);
		auditlog();
		test.log(LogStatus.PASS, " 31.Click on yes" + "<br/>" + "32.Logout from Test user 2 " + "<br/>"
				+ " 33.Login to the Test user 1" + "<br/>" + "34.Navigate to audit log. " + "<br/>"
				+ "<b>ER 16:An email is not sent to the second test user as checkbox is unchecked in step 22(g).<b>"
				+ test.addScreenCapture(captureScreenShot(driver, "email_not_send")));
		sleep(4);
		logout.logoutFunction();
		login.loginUser("Title21User1", "test123456");
		addcollaborator("3");
		sleep(4);
		logout.logoutFunction();
		getDocumentFromUser2Collaborationlist();
		sleep(4);
		DocumentCollaboration.getdoconsearch().click();

		test.log(LogStatus.PASS, " 36.Click on add button." + "<br/>" + "37.Logout from Test user 1" + "<br/>"
				+ "38.	Login to the Test user 2" + "<br/>" + "39.Navigate to My Documents > Collaboration." + "<br/>"
				+ "40.Expand the task." + "<br/>" + "<b>ER 18  Mark task completed button is disabled.<b>"
				+ test.addScreenCapture(captureScreenShot(driver, "mark_Task_disable")));

		logout.logoutFunction();
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

	public void getDocumentFromUser2Collaborationlist() {
		login.loginUser("Title21User2", "test123456");
		DocumentCollaboration.getMyDocumentTab().click();
		DocumentCollaboration.getcollaborationOnMyDocument().get(4).click();
		sleep(3);
		DocumentCollaboration.Search(DocumentCollaboration.documetNo);//DocumentCollaboration.documetNo
		sleep(3);
	}

	public void addcollaborator(String ScenarioNo) {
		
		DocumentCollaboration.CreateDocument();
		sleep(4);
		DocumentCollaboration.getCollaborationTab().click();
		sleep(4);
		DocumentCollaboration.getAddColaboratorlink().get(2).click();
		if (ScenarioNo.equalsIgnoreCase("1")) {
			test.log(LogStatus.PASS,
					"1.	Login as Test user 1." + "<br/>" + "2.Create a new document." + "<br/>"
							+ "3.Navigate to Collaboration tab." + "<br/>" + "4.Click on Add Collaborator link."
							+ "<br/>" + "<b>ER 1: Add Collaborator popup is displayed. <b>"
							+ test.addScreenCapture(captureScreenShot(driver, "Collaboration_window")));
		}
		sleep(7);
		DocumentCollaboration.getDescription_On_AddCollaborator().clear();
		sleep(2);
		DocumentCollaboration.getDescription_On_AddCollaborator().sendKeys("Automation Testing");
		sleep(2);
		DocumentCollaboration.getCategoryOnAddCollaborator().selectByVisibleText("Collaboration");
		sleep(2);
		DocumentCollaboration.getLocation().selectByVisibleText("All");
		sleep(4);
		DocumentCollaboration.getAssignToPerson().sendKeys("Title21User2");
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
		sleep(2);
		driver.findElement(By.xpath("//td[text()='" + dd + "']")).click();
		sleep(5);
		
		if (ScenarioNo.equalsIgnoreCase("2")) {
			DocumentCollaboration.getelectonisognaturecheckbox(false);
			sleep(1);
			DocumentCollaboration.getAllowDocumentEditingcheckbox(false);
			sleep(1);
			DocumentCollaboration.getEmailOnaddNewcheckbox(false);
			sleep(1);
			DocumentCollaboration.getEnableTaskcheckbox(true);
			DocumentCollaboration.getNotifyMeWhenTaskCompleteCheckbox(false);
			sleep(5);
			test.log(LogStatus.PASS,
					"21.Create new document." + "<br/>"
							+ "22.	Click on add collaborator link and In Add collaborator task dialog ensure that"
							+ "<br/>" + "a.Assign to: A second test user" + "<br/>" + "b.Due Date: Any future date"
							+ "<br/>" + "c.Required Electronic Signature to check-off is unchecked." + "<br/>"
							+ "d.Enable task is checked" + "<br/>" + "e.Email task to the assignee is unchecked"
							+ "<br/>" + "f.Allow collaborator to edit document information is unchecked." + "<br/>"
							+ "g.Notify me when task is complete is unchecked" + "<br/>"
							+ "<b>ER 11 : Task is configured as specified in step 21<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "add_collaboration2")));

			sleep(3);
			verticalScrollingUp();
			DocumentCollaboration.getAddButton().click();
			sleep(3);
			test.log(LogStatus.PASS,
					"23.Click on add." + "<br/>"
							+ "<b>ER12: Task is created and assigned to the second test user.<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "addedCollaborator")));

		} else if (ScenarioNo.equalsIgnoreCase("3")) {
			sleep(2);
			DocumentCollaboration.getAllowDocumentEditingcheckbox(true);
			sleep(1);
			DocumentCollaboration.getEmailOnaddNewcheckbox(true);
			sleep(1);
			DocumentCollaboration.getEnableTaskcheckbox(false);
			sleep(1);
			DocumentCollaboration.getelectonisognaturecheckbox(true);
			sleep(1);
			DocumentCollaboration.getNotifyMeWhenTaskCompleteCheckbox(true);
			sleep(1);
			test.log(LogStatus.PASS,
					"35.Again add one collaborator " + "<br/>" + "a.Assign to: A second test user" + "<br/>"
							+ "b.Due Date: Any future date" + "<br/>"
							+ "c.Required Electronic Signature to check-off is checked." + "<br/>"
							+ "d.Enable task is unchecked" + "<br/>" + "e.Email task to the assignee is checked"
							+ "<br/>" + "f.Allow collaborator to edit document information is checked." + "<br/>"
							+ "g.Notify me when task is complete is checked" + "<br/>"
							+ "<b>ER 17 :Task is configured as specified in step 35<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "add_collaboration3")));
			sleep(3);
			verticalScrollingUp();
			DocumentCollaboration.getAddButton().click();
			sleep(3);
		}

		else {
			sleep(2);
			DocumentCollaboration.getAllowDocumentEditingcheckbox(true);
			sleep(1);
			DocumentCollaboration.getEmailOnaddNewcheckbox(true);
			sleep(1);
			DocumentCollaboration.getEnableTaskcheckbox(true);
			sleep(1);
			DocumentCollaboration.getelectonisognaturecheckbox(true);
			sleep(1);
			DocumentCollaboration.getNotifyMeWhenTaskCompleteCheckbox(false);
			sleep(1);
			test.log(LogStatus.PASS,
					"5.In the Add collaborator task dialog ensure that:" + "<br/>" + "a.Assign to: A second test user"
							+ "<br/>" + "b.Due Date: Any future date" + "<br/>"
							+ "c.Required Electronic Signature to check-off is checked." + "<br/>"
							+ "d.Enable task is checked" + "<br/>" + "e.	Email task to the assignee" + "<br/>"
							+ "f.	Allow collaborator to edit document information is checked" + "<br/>"
							+ "<b>ER 2 : Task is configured as specified in step 5 <b>"
							+ test.addScreenCapture(captureScreenShot(driver, "add_collaboration1")));

			sleep(3);
			//verticalScrollingDown();
			DocumentCollaboration.getAddButton().click();
			sleep(3);
			test.log(LogStatus.PASS,
					"6.	Click on add." + "<br/>" + "<b>ER3: Task is created and assigned to the second test user.<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "added_colaborator1")));
			sleep(3);
		}
		sleep(3);
	}

	@AfterClass(alwaysRun=true)
	public void closeBrowserInstance() {
		extent.endTest(test);
		driver.quit();
	}
}
