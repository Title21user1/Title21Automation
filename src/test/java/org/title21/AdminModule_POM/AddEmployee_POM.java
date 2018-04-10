package org.title21.AdminModule_POM;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.title21.AdminModule_Test.AddEmployee_Test;
import org.title21.validation.entities.ErrorMessages;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class AddEmployee_POM {
	
	public WebDriver driver;
	public WebElement element;
	static Logger log = Logger.getLogger(AddEmployee_POM.class);
	
	public AddEmployee_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(css=".dropdown-toggle.t21-nav-bar-dropdown")
	WebElement	administrator;
	
	@FindBy(xpath="//*[@id='Administration']/a")
	WebElement administration;

	@FindBy(css=".selected.t21-padding-5.set-item")
	WebElement employees;

	@FindBy(css=".fa.fa-plus-circle.t21-padding-right-5")
	WebElement addNew;
	
	@FindBy(xpath="//select[contains(@name,'Employee.Location')]")
	WebElement locationDropdown;

	@FindBy(css=".form-control.t21-placeholder")
	WebElement searchBox;

	/*@FindBy(xpath="//button[contains(@type,'submit') and contains(@tabindex,'1')]")
	WebElement goButton;*/

	@FindBy(xpath="//button[contains(@name,'clear')]")
	WebElement crossButton;

	@FindBy(xpath="//a[contains(@href,'#tab1')]")
	WebElement generalTab;

	@FindBy(xpath="//select[contains(@name,'Employee.Location')]")
	WebElement locationEmployee;

	@FindBy(css=".form-control#Employee_FullName")
	WebElement employeeFullName;

	@FindBy(css=".form-control#Employee_EmployeeID")
	WebElement employeeID;

	@FindBy(xpath="//select[contains(@name,'Employee.SupervisorID')]")
	WebElement supervisorDropdown;

	@FindBy(xpath="//select[contains(@name,'Employee.DefaultFirm')]")
	WebElement businessUnit;

	@FindBy(xpath="//select[contains(@name,'Employee.Department')]")
	WebElement department;//=By.xpath("//select[contains(@name,'Employee.Department')]");

	@FindBy(css=".form-control#Employee_Address")
	WebElement address;//=By.cssSelector(".form-control#Employee_Address");

	@FindBy(css=".form-control#Employee_City")
	WebElement city;//=By.cssSelector(".form-control#Employee_City");

	@FindBy(css=".form-control#Employee_State")
	WebElement state;//=By.cssSelector(".form-control#Employee_State");

	@FindBy(css=".form-control#Employee_Postal_Code")
	WebElement postal_Code;//=By.cssSelector(".form-control#Employee_Postal_Code");

	@FindBy(css=".form-control#Employee_Country")
	WebElement country;//=By.cssSelector(".form-control#Employee_Country");

	@FindBy(css=".form-control#Employee_Phone")
	WebElement phone;//=By.cssSelector(".form-control#Employee_Phone");

	@FindBy(css=".form-control#Employee_Email")
	WebElement email;//=By.cssSelector(".form-control#Employee_Email");

	@FindBy(xpath="//button[contains(@class,'btn t21-btn-default pull-left')]")
	WebElement cancelButton;//=By.xpath("//button[contains(@class,'btn t21-btn-default pull-left')]");

	@FindBy(xpath="//button[contains(@class,'btn t21-btn-primary t21-ajax-submit-button')]")
	WebElement addButton;

	@FindBy(xpath="//a[contains(text(),'Job Codes')]")
	WebElement jobCodesTab;
	
	@FindAll({@FindBy(xpath="//td[contains(@class,'t21-js-row-link')]/a")})
	List<WebElement> jobCodesList;

	//@FindBy(xpath="//a[contains(text(),'Human Resources Clerk')]")
	@FindBy(xpath="//a[contains(text(),'Senior Technologist')]")
	WebElement jobCodesDropdown;
		
	@FindBy(xpath="//a[contains(text(),'VP, Human Resources')]")
	WebElement jobCodeVPHumanResources;
	
	@FindBy(xpath="//a[contains(@href,'#tab3')]")
	WebElement otherTab;//=By.xpath("//a[contains(@href,'#tab3')]");

	@FindBy(xpath="//*[@class='collapsible-icon t21-padding-right-5']")
	WebElement trainingLink;//=By.xpath("//*[@class='collapsible-icon t21-padding-right-5']");

	@FindBy(xpath="//*[@id='IsTraining']")
	WebElement uponSaveCheckbox;    

	@FindBy(xpath="//*[@id='collapse-1']/div/div[2]/div/label")
	WebElement employeeSupervisorradioBtn;

	@FindBy(xpath="//*[@id='collapse-1']/div/div[3]/div[1]/label")
	WebElement otherSpecificSupervisorradioBtn;//=By.xpath("//*[@id='collapse-1']/div/div[3]/div[1]/label");
    
	@FindBy(xpath="//*[@name='Supervisor']")
	WebElement supervisorOtherTab;//=By.xpath("//*[@name='Supervisor']");

	@FindBy(xpath="//*[@id='IsEmailNotificationTobeSend']")
	WebElement sendEmailNotification;//=By.xpath("//*[@id='IsEmailNotificationTobeSend']");
	
	@FindBy(xpath="//*[@id='Employee_HireDate']")
	WebElement hireDate;//=By.xpath("//*[@id='Employee_HireDate']");

	@FindBy(xpath="//*[@name='Employee.EmploymentType']")
	WebElement employeeType;//=By.xpath("//*[@name='Employee.EmploymentType']");

	@FindBy(xpath="//*[@name='Employee.ForwardItemsTo']")
	WebElement employeeForwardItemsTo;//=By.xpath("//*[@name='Employee.ForwardItemsTo']");

	@FindBy(xpath="//*[@name='Employee.Status']")
	WebElement employeeStatus;//=By.xpath("//*[@name='Employee.Status']");

	@FindBy(xpath="//*[@name='Employee.AltEmployeeID']")
	WebElement altEmployeeID;//=By.xpath("//*[@name='Employee.AltEmployeeID']");

	@FindBy(xpath="//*[@id='CreateUserId']")
	WebElement createUserID;    
    
	@FindBy(css=".t21-js-user-message-text")
	WebElement successMessageText;	
		
	@FindBy(css=".min-column")
	WebElement selectedJobCode;
	
	@FindBy(xpath="//button[contains(text(),'Close')]")
	WebElement closeButtonOnSuccessMessage;
		
	@FindBy(xpath="//span[contains(@class,'field-validation-error') and contains(@data-valmsg-for,'Employee.Location')]")
	WebElement locationFieldValidationMessage;	
	
	@FindBy(xpath="//span[contains(@class,'field-validation-error') and contains(@data-valmsg-for,'Employee.FullName')]")
	WebElement fullNameValidationMessage;	
	
	@FindBy(xpath="//span[contains(@class,'field-validation-error') and contains(@data-valmsg-for,'Employee.EmployeeID')]")
	WebElement employeeIDValidationMessage;
	
	@FindBy(xpath="//span[contains(@class,'field-validation-error') and contains(@data-valmsg-for,'Employee.DefaultFirm')]")
	WebElement businessUnitValidationMessage;
	
	@FindBy(xpath="//span[contains(@class,'field-validation-error') and contains(@data-valmsg-for,'Employee.Department')]")
	WebElement departmentValidationMessage;
	
	@FindBy(css=".t21-placeholder")
	WebElement filterTextBox;
	
	@FindBy(xpath="//button[@type='submit'][@tabindex='1']")
	WebElement goButton;
	
	public WebElement administrator_dropdown()
	{
		//WebElement element=driver.findElement(administrator);
		return administrator;
	}
	public WebElement administration_menu()
	{
		//WebElement element=driver.findElement(administration);
		return administration;
	}
	public WebElement employees_link()
	{
		//WebElement element=driver.findElement(employees);
		return employees;
	}
	
	public WebElement addNewLink()
	{
		//WebElement element=driver.findElement(addNew);
		return addNew;
	}
	
	public Select getLocationDropdown()
	{
		Select selectObj=new Select(locationDropdown);
		return selectObj;
	}
	
	public WebElement searchText_Box()
	{
		//WebElement element=driver.findElement(searchBox);
		return searchBox;
	}
	public WebElement go_Button()
	{
		//WebElement element=driver.findElement(goButton);
		return goButton;
	}
	public WebElement employee_DropdownTab()
	{
		//WebElement element=driver.findElement(locationEmployee);
		return locationEmployee;
	}
	public WebElement getEmployeeFullName()
	{
		return employeeFullName;
	}
	
	public WebElement getEmployeeID()
	{
		return employeeID;
	}
	
	public Select getsupervisorDropdown()
	{		
		Select selectObj=new Select(supervisorDropdown);
		return selectObj;		
	}
	
	public Select getbusinessUnitDropdown()
	{
		Select selectObj=new Select(businessUnit);
		return selectObj;		
	}
	
	public Select getDepartmentDropdown()
	{
		Select selectObj=new Select(department);
		return selectObj;			
	}
	
	public WebElement getAddressField()
	{
		return address;
	}
	public WebElement getEmployeeCity()
	{
		return city;
	}
	public WebElement getEmployeeState()
	{
		return state;
	}
	public WebElement getEmployeePostalCode()
	{
		return postal_Code;
	}
	public WebElement getEmployeeCountry()
	{
		return country;
	}
	public WebElement getEmployeePhone()
	{
		return phone;
	}
	public WebElement getEmployeeemail()
	{
		return email;
	}
	public WebElement cancel_Btn()
	{
		return cancelButton;
	}
	public WebElement getAddBtn()
	{
		return addButton;
	}
	public WebElement job_Codes()
	{
		return jobCodesTab;
	}
	public WebElement getjobCodeSeniorTechnologist()
	{
		return jobCodesDropdown;
	}
	
	public List<WebElement> getAllJobCodesList(){
		
		return jobCodesList;
	}
	
	public WebElement other_Tab()
	{		
		return otherTab;
	}
	public WebElement trainingLink_Tab()
	{
		return trainingLink;
	}
	public WebElement uponSave_Checkbox()
	{
		return uponSaveCheckbox;
	}
	public WebElement employeeSupervisor_RadioBtn()
	{		
		return employeeSupervisorradioBtn;
	}
	public WebElement otherSpecificSupervisor_RadioBtn()
	{
		return otherSpecificSupervisorradioBtn;
	}
		
	public WebElement hire_Date()
	{
		return hireDate;
	}
	public WebElement employee_type()
	{
		//WebElement element=driver.findElement(employeeType);
		return employeeType;
	}
	public WebElement employee_ForwardItemsTo()
	{
		//WebElement element=driver.findElement(employeeForwardItemsTo);
		return employeeForwardItemsTo;
	}
	public WebElement employee_Status()
	{
		//WebElement element=driver.findElement(employeeStatus);
		return employeeStatus;
	}
	public WebElement alt_Employee()
	{
		////WebElement element=driver.findElement(altEmployeeID);
		return altEmployeeID;
	}
	public WebElement create_UserID()
	{
		//WebElement element=driver.findElement(createUserID);
		return createUserID;
	}
	public WebElement sendEmail_Notification()
	{
		//WebElement element=driver.findElement(createUserID);
		return sendEmailNotification;
	}
	
	public WebElement getSelectedJobCode() {
		
		return selectedJobCode;
	}
		
	public WebElement getSuccessMessage(){
		
		return successMessageText;
	}
			
	public WebElement getCloseButtononSuccessMessage(){
		
		return closeButtonOnSuccessMessage;
	}	
	
	public WebElement getlocationValidationMessage(){
		
		return locationFieldValidationMessage;
	}
	
	public WebElement getfullNameValidationMessage(){
		
		return fullNameValidationMessage;
	}
	
	public WebElement getEmployeeIDValidationMessage(){
		
		return employeeIDValidationMessage;
	}
		
	public WebElement getBusinessUnitValidationMessage(){
		
		return businessUnitValidationMessage;
	}
	
	public WebElement getdepartmentValidationMessage(){
		
		return departmentValidationMessage;
	}
	
	public WebElement getJobCodesTab() {
		
		return jobCodesTab;
	}
		
	public WebElement getFilterTextBox(){
				
		return filterTextBox;
	}
	
	public WebElement getGoButton(){
		
		return goButton;		
	}
	
	public WebElement getJobCodeVPHumanResource(){
		
		return jobCodeVPHumanResources;		
	}
	
	public boolean verifyLocationValidationMessage(){
		
		element=getlocationValidationMessage();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;		
		
		if(errorMessage.contains(ErrorMessages.locationValidationMessage))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Validation message for Location dropdown is not valid.");
		}	
		return isValidationMessagePresent;
	}
	
	public boolean verifyFullNameValidationMessage(){
		
		element=getfullNameValidationMessage();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;		
		
		if(errorMessage.contains(ErrorMessages.fullNameValidationMessage))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Validation message for Full Name field is not valid.");
		}	
		return isValidationMessagePresent;
		
	}
	
	public boolean verifyEmployeeIDValidationMessage(){
		
		element=getEmployeeIDValidationMessage();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;		
		
		if(errorMessage.contains(ErrorMessages.employeeIDValidationMessage))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Validation message for EmployeeID field is not valid.");
		}	
		return isValidationMessagePresent;
	}
	
	public boolean verifyBusinessUnitValidationMessage(){		
		element=getBusinessUnitValidationMessage();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;		
		
		if(errorMessage.contains(ErrorMessages.businessUnitValidationMessage))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Validation message for BusinessUnit field is not valid.");
		}	
		
		return isValidationMessagePresent;
	}	
	
	public boolean verifyDepartmentValidationMessage(){	
		
		element=getdepartmentValidationMessage();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;		
		
		if(errorMessage.contains(ErrorMessages.departmentValidationMessage))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Validation message for Department field is not valid.");
		}	
		
		return isValidationMessagePresent;
	}	
		
	
	public boolean verifySuccessMessage() {
		
		element=getSuccessMessage();
		String errorMessage = element.getText();
		boolean isSuccessMessagePresent=false;		
		
		if(errorMessage.contains(ErrorMessages.createEmployeeSuccessMessage))
		{
			isSuccessMessagePresent=true;			
		}
		return isSuccessMessagePresent;		
	}
	
	public boolean verifyUniqueEmployeeFullName() {
		
		element=getfullNameValidationMessage();
		String errorMessage = element.getText();
		boolean isSuccessMessagePresent=false;		
		
		if(errorMessage.contains(ErrorMessages.employeeNameExistsValidationMessage))
		{
			isSuccessMessagePresent=true;			
		}
		return isSuccessMessagePresent;		
		
	}
		
	public boolean verifyUniqueEmployeeID() {
		
		element=getEmployeeIDValidationMessage();
		String errorMessage = element.getText();
		boolean isSuccessMessagePresent=false;		
		
		if(errorMessage.contains(ErrorMessages.employeeIDExistsValidationMessage))
		{
			isSuccessMessagePresent=true;			
		}
		return isSuccessMessagePresent;		
	}
		
	public void clickOnJobCode(String jobcode){
		
		
	}
	
}
