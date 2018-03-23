package org.title21.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.title21.POM.DashBord_POM;
import org.title21.POM.Delete_Employee_POM;
import org.title21.POM.LoginPage_POM;
import org.title21.POM.LogoutPage_POM;
import org.title21.dao.AdminData;
import org.title21.utility.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class DeleteEmployee_Test extends BaseClass {
	LoginPage_POM login;
	LogoutPage_POM logout;
	Delete_Employee_POM emp;
	DashBord_POM dashboardObj;
	AdminData adminData;
	SoftAssert softAssertion = new SoftAssert();
	String className = "";
	String employeeID = "";
	boolean EmployeePresenceAfterSearch = false;
	static Logger log = Logger.getLogger(DeleteEmployee_Test.class);
	
	String testcaseName="TestCase-WIA-Delete Employee record.doc";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;

	@BeforeClass
	public void openURL() {
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		login = new LoginPage_POM(driver);
		login.loginFunction();
	}

	@Test(testName = "delete_employee", groups = "Employee")
	public void Delete_Employee() throws Exception {
		
		test = extent.startTest("Delete Employee");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		test.log(LogStatus.PASS, "1 Login to the web interface.");
		getAdministrationPage(test);
		emp = new Delete_Employee_POM(driver);
		adminData = new AdminData();
		test.log(LogStatus.PASS, " 3. Click on employee link." + "<br/>" + "<b>ER1: Employee records are listed. <b>"
				+ test.addScreenCapture(captureScreenShot(driver, "employeelist")));
		emp.EmployeeFilterResult().sendKeys(adminData.getEmployeeName());
		sleep(2);
		emp.EmployeeFilterResutGoButton().click();
		sleep(2);
		
		if (clickonDelete()){
			waitTillElementVisible(emp.noemployeebutton());
			test.log(LogStatus.PASS,
					" 4. Click on Delete Employee icon." + "<br/>"
							+ "<b>ER2: Delete Employee popup is displayed. <b>"
							+ test.addScreenCapture(captureScreenShot(driver, "delete_popup")));
			
		}
				
		emp.noemployeebutton().click();
		test.log(LogStatus.PASS, "5. Click on No Button. ");
		sleep(2);
		emp.EmployeeFilterClearButton().click();
		sleep(2);
		emp.EmployeeFilterResult().sendKeys(adminData.getEmployeeName());
		sleep(2);
		emp.EmployeeFilterResutGoButton().click();
		sleep(2);
		
		test.log(LogStatus.PASS, " 6. Search for employee " + "<br/>" + "<b>ER 3: The employee is not deleted.<b>"
				+ test.addScreenCapture(captureScreenShot(driver, "Employee Still Exist")));
		
		waitTillElementVisible(emp.EmployeeFilterResult());
		sleep(4);		
		test.log(LogStatus.PASS, "7. Click on the delete icon against the employee in the previous step.");
		if (clickonDelete()){
			test.log(LogStatus.PASS, "8. Click on Yes Button when the confirmation dialog is displayed.");
			waitTillElementVisible(emp.deleteEmployeePopUpYesButton());
			emp.deleteEmployeePopUpYesButton().click();
			sleep(2);
			test.log(LogStatus.PASS,
							"<b>ER4: Employee should get deleted and show a confirmation message.<b>"
							+ test.addScreenCapture(captureScreenShot(driver, "yes_button_delete_confirm")));
			waitTillElementVisible(emp.ConfirmPopUpCloseButton());
			emp.ConfirmPopUpCloseButton().click();			
		}
		
		waitTillElementVisible(emp.EmployeeFilterResult());
		sleep(2);
		emp.EmployeeFilterClearButton().click();
		sleep(2);
		emp.EmployeeFilterResult().sendKeys(adminData.getEmployeeName());
		sleep(2);
		emp.EmployeeFilterResutGoButton().click();
		sleep(2);
		
		test.log(LogStatus.PASS, "9. Search for the employee which was deleted in the previous step.");
		
		if (emp.verifyNoEmployeeFoundText()){
			test.log(LogStatus.PASS,"<b>ER5: Employee is no longer available in the list.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "employeenoLongerAvailable")));			
		}else{
			test.log(LogStatus.FAIL,"Employee is still available in the list.");
		}
		
		sleep(3);
		
		log.info("Now calling logout function.");

		logout = new LogoutPage_POM(driver);

		logout.logoutFunction();

		log.info("logout successfully.");
		
		extent.endTest(test);
	}
		
	@AfterClass
	public void closeBrowserInstance() {

		driver.close();	
		
	}
	
	public boolean clickonDelete(){
		
		adminData = new AdminData();
		boolean isRecordFound=false;
		for (int i = 1; i <= 10; i++) {

			WebElement employee = driver
					.findElement(By.xpath("//tbody[@class='t21-js-clickable-rows']/tr[" + i + "]/td[1]"));
			String empName = employee.getText();

			if (empName.equalsIgnoreCase(adminData.getEmployeeName())) {
				
				WebElement delete = driver.findElement(By.xpath(
						"//tbody[@class='t21-js-clickable-rows']/tr[" + i + "]//span[@title='Remove Employee']"));
				delete.click();
				
				isRecordFound=true;
				break;
			}
		}
		return isRecordFound;
	}
}