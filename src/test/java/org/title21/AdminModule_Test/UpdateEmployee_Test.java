package org.title21.AdminModule_Test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.AdminModule_POM.DashBord_POM;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.AdminModule_POM.UpdateEmployee_POM;
import org.title21.dao.AdminData;
import org.title21.utility.BaseClass;
import com.relevantcodes.extentreports.LogStatus;

public class UpdateEmployee_Test extends BaseClass {
	LoginPage_POM login;
	LogoutPage_POM logout;
	UpdateEmployee_POM emp;
	UpdateEmployee_POM emp2;
	DashBord_POM dashboardObj;
	String className = "";
	String employeeID = "";
	String supervisor = "";
	String EditDepartment = "";
	String EditAddressField = "";
	String EmployeeCity = "";
	String EmployeeState = "";
	String EmpStringloyeePostalCode = "";
	String EmployeeCountry = "";
	String EmployeePhone = "";
	String employeeemail = "";
	String CanceltEmployeePostalCode = "";
	String CancelEmployeeCountry = "";
	String CancelEmployeePhone = "";

	String testcaseName="TestCase-WIA-UpdateEmployee.doc";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;

	boolean EmployeePresenceAfterSearch = false;
	static Logger log = Logger.getLogger(UpdateEmployee_Test.class);	


	@BeforeClass(alwaysRun=true)
	public void openURL() {
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		login = new LoginPage_POM(driver);
		login.loginFunction();

	}

	@Test(testName = "Update Employee ", groups = "AdminModule", priority = 0, alwaysRun=true)
	public void Edit_Employee() throws Exception {

		test = extent.startTest("Update  Employee");
		log.info("Update Employee Test");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		test.log(LogStatus.PASS, "1 Login to the web interface");
		getAdministrationPage(test);
		test.log(LogStatus.PASS, "<b>ER1: Administration Screen is displayed.<b>"
				+ test.addScreenCapture(captureScreenShot(driver, " Administration_Screenis_displayed.")));
		emp = new UpdateEmployee_POM(driver);
		AdminData adminData = new AdminData();
		supervisor = "Hetal M";
		EditDepartment = "IT";
		EditAddressField = "TX 75266-09023 Winchester Cross Lane";
		EmployeeCity = "Dallas";
		EmployeeState = "Texas";
		EmpStringloyeePostalCode = "660675";
		EmployeeCountry = "US";
		EmployeePhone = "089-569-1234";
		employeeemail = "martink@testmail.com";
		System.out.print(adminData.getEmployeeName());
		test.log(LogStatus.PASS, "3. Select Employee link"+"<br/>"
				+"<b>ER2: Employee records are listed. <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Employeerecords")));
		sleep(2);
		emp.getGridLocation().selectByVisibleText("Antioch");
		sleep(2);
		test.log(LogStatus.PASS, "4. Click on location drop-down and select the specific location"+"<br/>"
				+"<b>ER3: Only Employees of selected location are displayed. <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Employeelocation")));
		sleep(2);
		emp.getGridLocation().selectByVisibleText("Dallas");
		sleep(2);
		emp.EmployeeFilterResult().sendKeys("xxxxxxxxxx");
		emp.EmployeeFilterResutGoButton().click();
		sleep(2);
		System.out.print("out" + emp.getnoemployeemsg().getText());
		if (emp.NoEmpMsg()) {
			test.log(LogStatus.PASS, "5. Enter invalid data in employee field and click on  GO button"+"<br/>"
					+"<b>ER4:It should show validation messages as No Employee Found <b>"+
					test.addScreenCapture(captureScreenShot(driver, "No_Employee_Found")));
		}
		sleep(2);
		emp.getGridLocation().selectByVisibleText("Dallas");
		emp.EmployeeFilterResult().clear();
		emp.EmployeeFilterResult().sendKeys(adminData.getEmployeeName());// Remove Employee
		sleep(2);
		emp.EmployeeFilterResutGoButton().click();
		for (int i = 1; i <= 10; i++) {
			sleep(1);
			String Employees = driver
					.findElement(By.xpath("//tbody[@class='t21-js-clickable-rows']/tr[" + i + "]/td[1]")).getText();
			sleep(1);
			if (Employees.equalsIgnoreCase(adminData.getEmployeeName())) {
				EmployeePresenceAfterSearch = true;
				test.log(LogStatus.PASS, "6. Enter the already existing employee information in in search field  and click on GO button."+"<br/>"
						+"<b>ER5: It displayed employee as per given information. <b>"+
						test.addScreenCapture(captureScreenShot(driver, "Employee_info")));
				break;
			}	

		}

		for (int i = 1; i <= 10; i++) {

			WebElement employee = driver
					.findElement(By.xpath("//tbody[@class='t21-js-clickable-rows']/tr[" + i + "]/td[1]"));
			String empName = employee.getText();

			if (empName.equalsIgnoreCase(adminData.getEmployeeName())) {

				WebElement Edit = driver.findElement(By
						.xpath("//tbody[@class='t21-js-clickable-rows']/tr[" + i + "]//span[@title='Edit Employee']"));
				Edit.click();
				sleep(3);
				test.log(LogStatus.PASS, "7. Click on Edit Employee Button"+"<br/>"
						+"<b>ER6: Update employee dialog is displayed and the general tab is presented.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "update_emp")));
				break;
			}
		}


		log.info("Update Employee Data");
		emp.getsupervisorDropdown().selectByVisibleText("Hetal M");

		emp.getbusinessUnitDropdown().selectByIndex(1);
		emp.getDepartmentDropdown().selectByVisibleText("IT");		
		emp.getAddressField().clear();

		emp.getAddressField().sendKeys("TX 75266-09023 Winchester Cross Lane");
		sleep(1);
		emp.getEmployeeCity().clear();

		emp.getEmployeeCity().sendKeys("Dallas");
		emp.getEmployeeState().clear();

		emp.getEmployeeState().sendKeys("Texas");

		emp.getEmployeePostalCode().clear();

		emp.getEmployeePostalCode().sendKeys("660675");

		emp.getEmployeeCountry().clear();

		emp.getEmployeeCountry().sendKeys("US");

		emp.getEmployeePhone().clear();

		emp.getEmployeePhone().sendKeys("089-569-1234");

		emp.getEmployeeemail().clear();

		emp.getEmployeeemail().sendKeys("martink@testmail.com");
		// emp.getAddBtn().click();
		// javaScriptClick(emp.getAddBtn());
		sleep(2);

		// addEmployeePOM.getAddBtn().click();
		javaScriptClick(emp.getAddBtn());
		sleep(3);

		if (emp.EditverifySuccessMessage()) {

			test.log(LogStatus.PASS, "8. Edit the supervisor, Business Unit, department, state and country"+"<br/>"+"9. Click on confirm button. "+"<br/>"
					+"<b>ER7: A message confirming successful update is displayed <b>"+
					test.addScreenCapture(captureScreenShot(driver, "update_emp")));
		}
		;

		sleep(3);
		emp.getCloseButtononSuccessMessage().click();
		sleep(2);
		emp.EmployeeEdit().click();
		sleep(2);
		emp = new UpdateEmployee_POM(driver);
		sleep(2);
		if (emp.Editsupervisor(supervisor)&&emp.EditbusinessUnit(driver)&&emp.EditDepartment(EditDepartment)&&emp.EditAddressField(EditAddressField)&&emp.getEmployeeCity(EmployeeCity)&&emp.getEmployeeState(EmployeeState)) 
		{
			test.log(LogStatus.PASS, "10. Again click on edit button."+"<br/>"
					+"<b>ER8: All changed fields are properly updated. <b>"+
					test.addScreenCapture(captureScreenShot(driver, "update_change")));

		}
		sleep(3);
		javaScriptClick(emp.getAddBtn());
		sleep(2);
		emp.getCloseButtononSuccessMessage().click();
		sleep(2);
		verticalScrollingUp();
		//verticalScrollingUp();
		sleep(2);
		emp.EmployeeEdit().click();
		if (emp.getEmployeeID().isEnabled() && emp.getEmployeeFullName().isEnabled()) 
		{
			test.log(LogStatus.FAIL, "11.Edit the employee again."+"<br/>"+"12.Try to edit Full Name and Employee ID field ."+"<br/>"
					+"<b>ER9: User able to edit the Full name and Employee ID field. <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Edit_name_id")));

		} else {
			sleep(2);
			test.log(LogStatus.PASS, "11.Edit the employee again."+"<br/>"+"12.Try to edit Full Name and Employee ID field ."+"<br/>"
					+"<b>ER9: User should not be able to edit the Full name and Employee ID field. <b>"+
					test.addScreenCapture(captureScreenShot(driver, "Edit_name_id")));

		}
		sleep(2);		
		javaScriptClick(emp.getAddBtn());
		sleep(3);
		emp.getCloseButtononSuccessMessage().click();
		sleep(2);
		CanceltEmployeePostalCode = "2222";
		CancelEmployeeCountry = "test";
		CancelEmployeePhone = "677888888";
		sleep(2);
		verticalScrollingUp();
		//verticalScrollingUp();
		sleep(2);
		emp.EmployeeEdit().click();
		sleep(3);

		emp.getEmployeePostalCode().clear();

		emp.getEmployeePostalCode().sendKeys(CanceltEmployeePostalCode);

		emp.getEmployeeCountry().clear();

		emp.getEmployeeCountry().sendKeys(CancelEmployeeCountry);

		emp.getEmployeePhone().clear();

		emp.getEmployeePhone().sendKeys(CancelEmployeeCountry);
		sleep(2);
		verticalScrollingDown();
		//verticalScrollingDown();
		sleep(2);
		javaScriptClick(emp.cancel_Btn());
		sleep(2);
		verticalScrollingUp();
		//verticalScrollingUp();
		emp.EmployeeEdit().click();
		sleep(3);
		String img=test.addScreenCapture(captureScreenShot(driver, "cancel_edit"));
		sleep(2);
		if (emp.getEmpStringloyeePostalCode(CanceltEmployeePostalCode) && emp.getEmployeeCountry(CancelEmployeeCountry)
				&& emp.getEmployeePhone(CancelEmployeePhone)) {

			test.log(LogStatus.FAIL, "13.Edit the employee"+"<br/>"+"14.Edit the data "+"<br/>"+"15.Click on the cancel button "+"<br/>"
					+"<b>ER10: Records are  changed. <b>"+img);

		} else {

			test.log(LogStatus.PASS, "13.Edit the employee"+"<br/>"+"14.Edit the data from some fields. "+"<br/>"+"15.Click on the cancel button. "+"<br/>"
					+"<b>ER10: Records are unchanged. <b>"+img);			
		}


		sleep(3);
		emp.getJobCodesTab().click();
		sleep(2);
		if (emp.EditJobTele().isDisplayed()) {
			test.log(LogStatus.PASS, "16. Click on Job Codes Tab in Update Employee Screen."+"<br/>"
					+"<b>ER11: User should be navigated to Job Codes Screen and job codes list should be visible. <b>"+
					test.addScreenCapture(captureScreenShot(driver, "jobcode_screen")));
		}
		log.info("verify job  code  added to  selected job codes  section.");
		sleep(3);
		sleep(2);

		emp.getjobCodeHR().click();

		sleep(3);

		log.info("Verify to click on selected job code");

		sleep(2);
		test.log(LogStatus.PASS, "17.Select one job code from \"selected job\" section."+"<br/>"
				+"<b>ER12: It should get added to selected job codes section.<b>"+
				test.addScreenCapture(captureScreenShot(driver, "select_jobcode")));
		sleep(2);
		//emp.EditJobTele().click();
		/*
		 * test.log(LogStatus.PASS, "new job code  added successfully " +
		 * test.addScreenCapture(captureScreenShot(driver,
		 * " New job code  added successfully ")));
		 */

		sleep(2);
		//String addimg = test.addScreenCapture(captureScreenShot(driver, " New_job_code _added_successfully "));
		emp.JobCodeRemovedMinus().click();
		sleep(3);
		test.log(LogStatus.PASS, "18. Click on minus button from \"selected job\"  codes section."+"<br/>"+
				"<b>ER13: Job code is removed and default job code is changed. <b>"+
				test.addScreenCapture(captureScreenShot(driver, "removed_jobcode")));
		sleep(2);
		emp.EditJobTele().click();
		//emp.getjobCodeSeniorTechnologist().click();
		sleep(2);
		WebElement oCheckBox = driver.findElement(By.cssSelector("input[value='01002']"));
		oCheckBox.click();
		sleep(2);
		javaScriptClick(emp.getAddBtn()); 
		// addEmployeePOM.getAddBtn().click();
		sleep(3);
		emp.getCloseButtononSuccessMessage().click();
		sleep(2);
		emp.EmployeeEdit().click();
		sleep(5);
		emp=new UpdateEmployee_POM(driver);
			
		emp.getJobCodesTab().click();

		//emp.getJobCodesTab().click();
		//emp.jobCodeRadio().click();
		if (emp.jobCodeRadio().isDisplayed()) {

			test.log(LogStatus.PASS,"19.Change the default job by clicking on the radio button"+"<br/>"+"20. Click on confirm."+"<br/>"+" 21. Again click on edit button"+"<br/>"
					+"<b>ER14: Default job code is changed and job code updated  <b>"+
					test.addScreenCapture(captureScreenShot(driver, "defaultjobcodeChanged")));
		}
		sleep(2);

		javaScriptClick(emp.getAddBtn());
		sleep(3);
		emp.getCloseButtononSuccessMessage().click();
		sleep(2);
		log.info("Now calling logout function.");

		logout = new LogoutPage_POM(driver);

		logout.logoutFunction();

		log.info("logout successfully."); 

	}

	@AfterClass(alwaysRun=true)
	public void closeBrowserInstance()
	{
		extent.endTest(test);
		driver.quit();
	}
}
