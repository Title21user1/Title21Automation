package org.title21.AdminModule_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EmployeePOM {

  public WebDriver driver;
  //public //WebElement element;
  
  public EmployeePOM(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  @FindBy(xpath=".dropdown-toggle.t21-nav-bar-dropdown")
  WebElement administrator;//=cssSelector(".dropdown-toggle.t21-nav-bar-dropdown");

  @FindBy(xpath="//*[@id='Administration']/a")
  WebElement administration;//=xpath("//*[@id='Administration']/a");

  @FindBy(xpath=".selected.t21-padding-5.set-item")
  WebElement employees;//=cssSelector(".selected.t21-padding-5.set-item");

  @FindBy(xpath=".fa.fa-plus-circle.t21-padding-right-5")
  WebElement addNew;//=cssSelector(".fa.fa-plus-circle.t21-padding-right-5");

  @FindBy(xpath=".dropdown-toggle.t21-nav-bar-dropdown")
  WebElement locationTab;//=cssSelector(".dropdown-toggle.t21-nav-bar-dropdown");

  @FindBy(xpath=".form-control.t21-placeholder")
  WebElement searchBox;//=cssSelector(".form-control.t21-placeholder");
  
  @FindBy(xpath="//button[contains(@type,'submit') and contains(@tabindex,'1')]")
  WebElement  goButton;//=xpath("//button[contains(@type,'submit') and contains(@tabindex,'1')]");
  
  @FindBy(xpath="//button[contains(@name,'clear')]")
  WebElement  crossButton;//=xpath("//button[contains(@name,'clear')]");
    
  @FindBy(xpath="//a[contains(@href,'#tab1')]")
  WebElement  generalTab;//=xpath("//a[contains(@href,'#tab1')]");
    
  @FindBy(xpath="//select[contains(@name,'Employee.Location')]")
  WebElement  locationEmployee;//=xpath("//select[contains(@name,'Employee.Location')]");
    
  @FindBy(xpath=".form-control#Employee_FullName")
  WebElement  employeeFullName;//=cssSelector(".form-control#Employee_FullName");
    
  @FindBy(xpath=".form-control#Employee_EmployeeID")
  WebElement  employeeID;//=cssSelector(".form-control#Employee_EmployeeID");
    
  @FindBy(xpath="//select[contains(@name,'Employee.SupervisorID')]")
  WebElement  supervisorDropdown;//=xpath("//select[contains(@name,'Employee.SupervisorID')]");
    
  @FindBy(xpath="//select[contains(@name,'Employee.DefaultFirm')]")
  WebElement  businessUnit;//=xpath("//select[contains(@name,'Employee.DefaultFirm')]");
    
  @FindBy(xpath="//select[contains(@name,'Employee.Department')]")
  WebElement  department;//=xpath("//select[contains(@name,'Employee.Department')]");
    
  @FindBy(css=".form-control#Employee_Address")
  WebElement  address;//=cssSelector(".form-control#Employee_Address");
    
  @FindBy(css=".form-control#Employee_City")
  WebElement  city;//=cssSelector(".form-control#Employee_City");
    
  @FindBy(css=".form-control#Employee_State")
  WebElement  state;//=cssSelector(".form-control#Employee_State");
    
  @FindBy(css=".form-control#Employee_Postal_Code")
  WebElement  postal_Code;//=cssSelector(".form-control#Employee_Postal_Code");
    
  @FindBy(css=".dropdown-toggle.t21-nav-bar-dropdown")
  WebElement  country;//=cssSelector(".form-control#Employee_Country");
    
  @FindBy(css=".form-control#Employee_Phone")
  WebElement  phone;//=cssSelector(".form-control#Employee_Phone");
    
  @FindBy(css=".form-control#Employee_Email")
  WebElement  email;//=cssSelector(".form-control#Employee_Email");
    
  @FindBy(xpath="//button[contains(@class,'btn t21-btn-default pull-left')]")
  WebElement  cancelButton;//=xpath("//button[contains(@class,'btn t21-btn-default pull-left')]");
    
  @FindBy(xpath="//button[contains(@class,'btn t21-btn-primary t21-ajax-submit-button')]")
  WebElement  addButton;//=xpath("//button[contains(@class,'btn t21-btn-primary t21-ajax-submit-button')]");
    
  @FindBy(xpath="//a[contains(@href,'#tab2')]")
  WebElement  jobCodesTab;//=xpath("//a[contains(@href,'#tab2')]");
    
  @FindBy(xpath="//a[contains(text(),'Human Resources Clerk')]")
  WebElement  jobCodesDropdown;//=xpath("//a[contains(text(),'Human Resources Clerk')]");
    
  @FindBy(xpath="//a[contains(@href,'#tab3')]")
  WebElement  otherTab;//=xpath("//a[contains(@href,'#tab3')]");
    
  @FindBy(xpath="//*[@class='collapsible-icon t21-padding-right-5']")
  WebElement  trainingLink;//=xpath("//*[@class='collapsible-icon t21-padding-right-5']");
    
  @FindBy(xpath="//*[@id='IsTraining']")
  WebElement  uponSaveCheckbox;//=xpath("//*[@id='IsTraining']");
    
    
  @FindBy(xpath="//*[@id='collapse-1']/div/div[2]/div/label")
  WebElement  employeeSupervisorradioBtn;//=xpath("//*[@id='collapse-1']/div/div[2]/div/label");
    
  @FindBy(xpath="//*[@id='collapse-1']/div/div[3]/div[1]/label")
  WebElement  otherSpecificSupervisorradioBtn;//=xpath("//*[@id='collapse-1']/div/div[3]/div[1]/label");
    
    
  @FindBy(xpath="//*[@name='Supervisor']")
  WebElement  supervisorOtherTab;//=xpath("//*[@name='Supervisor']");
    
  @FindBy(xpath="//*[@id='IsEmailNotificationTobeSend']")
  WebElement  sendEmailNotification;//=xpath("//*[@id='IsEmailNotificationTobeSend']");
    
  @FindBy(xpath="//*[@id='Employee_HireDate']")
  WebElement  hireDate;//=xpath("//*[@id='Employee_HireDate']");
    
  @FindBy(xpath="//*[@name='Employee.EmploymentType']")
  WebElement  employeeType;//=xpath("//*[@name='Employee.EmploymentType']");
    
  @FindBy(xpath="//*[@name='Employee.ForwardItemsTo']")
  WebElement  employeeForwardItemsTo;//=xpath("//*[@name='Employee.ForwardItemsTo']");
    
  @FindBy(xpath="//*[@name='Employee.Status']")
  WebElement  employeeStatus;//=xpath("//*[@name='Employee.Status']");
    
  @FindBy(xpath="//*[@name='Employee.AltEmployeeID']")
  WebElement  altEmployeeID;//=xpath("//*[@name='Employee.AltEmployeeID']");
    
  @FindBy(xpath="//*[@id='CreateUserId']")
  WebElement  createUserID;//=xpath("//*[@id='CreateUserId']");  
    
  
  @FindBy(xpath="//a[contains(@href,'/Update?EmployeeID=akarshb')]")
  WebElement  editButton;// = xpath("//a[contains(@href,'/Update?EmployeeID=akarshb')]");
    
    
    public WebElement administrator_dropdown()
    {
      //WebElement element=driver.findElement(administrator);
      return administrator;
    }
    public WebElement administration_menue()
    {
      //WebElement element=driver.findElement(administration);
      return administration;
    }
    public WebElement employees_menue()
    {
      //WebElement element=driver.findElement(employees);
      return employees;
    }
    public WebElement addNew_Employee()
    {
      //WebElement element=driver.findElement(addNew);
      return addNew;
    }
    public WebElement general_Tab()
    {
      //WebElement element=driver.findElement(generalTab);
      return generalTab;
    }
    public WebElement location_Field()
    {
      //WebElement element=driver.findElement(locationTab);
      return locationTab;
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
    public WebElement cross_Button()
    {
      //WebElement element=driver.findElement(crossButton);
      return crossButton;
    }
    public WebElement employee_Dropdown_LocTab()
    {
      //WebElement element=driver.findElement(locationEmployee);
      return locationEmployee;
    }
    public WebElement employee_FullName()
    {
      //WebElement element=driver.findElement(locationEmployee);
      return locationEmployee;
    }
    public WebElement supervisorDropdown_Field()
    {
      //WebElement element=driver.findElement(supervisorDropdown);
      return supervisorDropdown;
    }
    public WebElement businessUnit_Dropdown()
    {
      //WebElement element=driver.findElement(businessUnit);
      return businessUnit;
    }
    public WebElement department_Dropdown()
    {
      //WebElement element=driver.findElement(department);
      return department;
    }
    public WebElement address_textbox()
    {
      //WebElement element=driver.findElement(address);
      return address;
    }
    public WebElement employee_City()
    {
      //WebElement element=driver.findElement(city);
      return city;
    }
    public WebElement employee_State()
    {
      //WebElement element=driver.findElement(state);
      return state;
    }
    public WebElement employee_PostalCode()
    {
      //WebElement element=driver.findElement(postal_Code);
      return postal_Code;
    }
    public WebElement employee_Country()
    {
      //WebElement element=driver.findElement(country);
      return country;
    }
    public WebElement employee_Phone()
    {
      //WebElement element=driver.findElement(phone);
      return phone;
    }
    public WebElement employee_email()
    {
      //WebElement element=driver.findElement(email);
      return email;
    }
    public WebElement cancel_Btn()
    {
      //WebElement element=driver.findElement(cancelButton);
      return cancelButton;
    }
    public WebElement add_Btn()
    {
      //WebElement element=driver.findElement(addButton);
      return addButton;
    }
    public WebElement job_Codes()
    {
      //WebElement element=driver.findElement(jobCodesTab);
      return jobCodesTab;
    }
    public WebElement jobCode_Dropdown1()
    {
      //WebElement element=driver.findElement(jobCodesDropdown);
      return jobCodesDropdown;
    }
    public WebElement other_Tab()
    {
      //WebElement element=driver.findElement(otherTab);
      return otherTab;
    }
    public WebElement trainingLink_Tab()
    {
      //WebElement element=driver.findElement(trainingLink);
      return trainingLink;
    }
    public WebElement uponSave_Checkbox()
    {
      //WebElement element=driver.findElement(uponSaveCheckbox);
      return uponSaveCheckbox;
    }
    public WebElement employeeSupervisor_RadioBtn()
    {
      //WebElement element=driver.findElement(employeeSupervisorradioBtn);
      return employeeSupervisorradioBtn;
    }
    public WebElement otherSpecificSupervisor_RadioBtn()
    {
      //WebElement element=driver.findElement(otherSpecificSupervisorradioBtn);
      return otherSpecificSupervisorradioBtn;
    }
    public WebElement sendEmail_Notification()
    {
      //WebElement element=driver.findElement(createUserID);
      return createUserID;
    }
    
    public WebElement hire_Date()
    {
      //WebElement element=driver.findElement(hireDate);
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
      //WebElement element=driver.findElement(altEmployeeID);
      return altEmployeeID;
    }
    public WebElement create_UserID()
    {
      //WebElement element=driver.findElement(createUserID);
      return createUserID;
    }
    public WebElement edit_BTN()
  {
    //WebElement element=driver.findElement(editButton);
    return editButton;
  }
    
   }
