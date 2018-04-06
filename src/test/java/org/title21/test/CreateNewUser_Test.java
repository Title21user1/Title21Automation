package org.title21.test;

import org.openqa.selenium.By;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.POM.AddNewUser_POM;
import org.title21.POM.LoginPage_POM;
import org.title21.POM.LogoutPage_POM;
import org.title21.dao.AdminData;
import org.title21.utility.BaseClass;
import org.title21.utility.FunctionUtils;
import com.relevantcodes.extentreports.LogStatus;

public class CreateNewUser_Test extends BaseClass{
	LoginPage_POM login;
	LogoutPage_POM logout;
	AddNewUser_POM addNewUserPage;
	String className="";
	String number="";
	String location="";
	String employeeName="";
	String username="";
	String firstMsgColor = "";
	String secondLineColor = "";
	String thirdLinecolor = "";
	String userName = "";	
	boolean UserPresenceAfterSearch = false;	
	AdminData adminData=new AdminData();
	String testcaseName="TestCase-WIA-Create New User.doc";	
	String filePath = System.getProperty("user.dir") + "\\TestCases\\"+testcaseName;	
	
	@BeforeClass
	public void openURL() 
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		login=new LoginPage_POM(driver);
		login.loginFunction();
	}
	
	@Test(testName = "Create New User", groups = "New User", priority = 0)
	public void AddNewUser() throws Exception
	{
		test = extent.startTest("Create New User");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file://"+filePath+"'>TestCaseDocument</a>");
		addNewUserPage= new AddNewUser_POM(driver);
		test.log(LogStatus.PASS, "1.Login to the web interface.");
		getAdministrationPage(test);	
		number = FunctionUtils.generateRandomNumber();
		addNewUserPage.user_link().click();
		test.log(LogStatus.PASS, "3.Click on Users link ");
		
		sleep(3);
		if(addNewUserPage.userTable_Verifications() != null)
		{
			test.log(LogStatus.PASS, "<b>ER 1- User records Screen is displayed.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "User records Screen")));
			
			addNewUserPage.getUserLocation_DropDown().selectByVisibleText(userData[1][0]);
			test.log(LogStatus.PASS, "4.Click on location drop-down and select the specific location (for ex. "+userData[1][0]+").");
			
			sleep(3);
			for(int i=1; i<=5; i++ ) {
				
				String userLocation = driver.findElement(By.xpath("//tbody[@class='t21-js-clickable-rows']/tr["+i+"]/td[4]")).getText();
				sleep(1);
				if(userLocation.equalsIgnoreCase(userData[1][0])) {
					UserPresenceAfterSearch = true;
					break;
				}
			}
			
			if(UserPresenceAfterSearch) {
				test.log(LogStatus.PASS, "<b>ER 2- Only Users of selected location are displayed.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Employees of selected location")));
			}else {
				test.log(LogStatus.FAIL, "Unable to verified ER 2- Only Users of selected location are displayed."+
						test.addScreenCapture(captureScreenShot(driver, "Employees of selected location")));
			}
			
			if(addNewUserPage.groupFilterResult() != null)
			{
				test.log(LogStatus.PASS, "5.Enter the invalid data in user's field and click on GO button.");
				
				addNewUserPage.groupFilterResult().click();
				addNewUserPage.groupFilterResult().sendKeys("aaaa"+number);
				addNewUserPage.groupFilterResutGoButton().click();
				
				if(addNewUserPage.verifyNoUserFoundText(driver))
				{
					test.log(LogStatus.PASS, "<b>ER 3- It should show validation messages as 'No User Found'.<b>"+
							test.addScreenCapture(captureScreenShot(driver, "No User Found")));
				}
				else
				{
					test.log(LogStatus.FAIL, "Unable to verified ER 3– It should show validation messages as 'No User Found'."+
							test.addScreenCapture(captureScreenShot(driver, "No User Found")));
				}
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to verified User 'Filter Result' field."+
						test.addScreenCapture(captureScreenShot(driver, "Filter Result field")));
			}
		}
		else
		{
			test.log(LogStatus.FAIL, "Unable to verified User records Screen."+
					test.addScreenCapture(captureScreenShot(driver, "records Screen")));
		}
		addNewUserPage.addNew_User().click();
		test.log(LogStatus.PASS, "6.Click on 'Add New' button.");
		
		sleep(3);
		waitTillElementVisible(addNewUserPage.AddNewUserPopUpHeader());
		
		if(addNewUserPage.verifyAddNewUserPopUpHeader(driver))
		{
			test.log(LogStatus.PASS, "<b>ER 4- Add new user popup screen appears.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Add New User")));
			
			if(addNewUserPage.general_tab() != null) 
			{
				addNewUserPage.add_GeneralButton().click();
				addNewUserPage.add_GeneralButton().click();
				test.log(LogStatus.PASS, "7.Click on Add Button.");
				sleep(2);
				if(addNewUserPage.locationRequired_ErrorMsg().isDisplayed()&&addNewUserPage.fullNameRequired_ErrorMsg().isDisplayed()&&addNewUserPage.userNameRequired_ErrorMsg().isDisplayed()&&addNewUserPage.pleaseSelectOneGroup_ErrorMsg().isDisplayed())
				{
					test.log(LogStatus.PASS, "<b>ER 5- It displays validation messages as 'Location is required', 'Full Name is required', 'User Name is required', 'Please select at least one group'.<b>."+
							test.addScreenCapture(captureScreenShot(driver, "Location is required")));
				}
				else
				{
					test.log(LogStatus.FAIL, "Unable to verified validation messages 'Location is required'."+
							test.addScreenCapture(captureScreenShot(driver, "Location is required")));
				}
				
				addNewUserPage.location_Dropdown().selectByVisibleText(userData[1][0]);
				
				test.log(LogStatus.PASS, "8.Select one location.(for eg: "+userData[1][0]+").");
				
				sleep(2);
				
				if(addNewUserPage.alertEMPAssignedMsg(driver))
				{
					test.log(LogStatus.FAIL, "It displayed validation message as 'All employees have already been assigned a user ID'."+
							test.addScreenCapture(captureScreenShot(driver, "Assigned User ID")));
					
					addNewUserPage.confirmClose_Button().click();
					sleep(2);
					addNewUserPage.addNewUserClose_Button().click();
					sleep(3);
				}
				else
				{
					test.log(LogStatus.PASS, "<b>ER 6- 'list of employees' in full name field and 'groups' associated with that location should get listed.<b>"+
							test.addScreenCapture(captureScreenShot(driver, "Location Details")));
					addNewUserPage.userFullName_Dropdown().selectByVisibleText(adminData.getEmployeeName());
					
					test.log(LogStatus.PASS, "9.Select Location whose all employees have already been assigned a user ID");
					addNewUserPage.location_Dropdown().selectByVisibleText(userData[1][9]);
					sleep(2);
					if(addNewUserPage.empAssigned_Msg().isDisplayed())
					{
						test.log(LogStatus.PASS, "<b>ER 7- It displayed validation message as 'All employees have already been assigned a user ID'.<b>"+
								test.addScreenCapture(captureScreenShot(driver, "already assigned a user ID")));
						addNewUserPage.confirmClose_Button().click();
					}
					else
					{
						test.log(LogStatus.FAIL, "Unable to find validation message- It displayed validation message as 'All employees have already been assigned a user ID'."+
								test.addScreenCapture(captureScreenShot(driver, "already assigned a user ID")));
					}
					addNewUserPage.location_Dropdown().selectByVisibleText(userData[1][0]);
					sleep(2);
					addNewUserPage.userFullName_Dropdown().selectByVisibleText(adminData.getEmployeeName());
					sleep(2);
					addNewUserPage.username_textbox().sendKeys(userData[1][10]);
					test.log(LogStatus.PASS, "10.Enter already existing username in username field.");
					addNewUserPage.userName_Label().click();
					sleep(2);
					if(addNewUserPage.userNameError_Msg().isDisplayed())
					{
						test.log(LogStatus.PASS, "<b>ER 8- A validation message 'Full Name already exists' and 'EmployeeID Already Exists' are displayed..<b>"+
								test.addScreenCapture(captureScreenShot(driver, "Name already exists")));
					}
					else
					{
						test.log(LogStatus.FAIL, "Unable to find validation message- A validation message 'Full Name already exists' and 'EmployeeID Already Exists' are displayed..<b>"+
								test.addScreenCapture(captureScreenShot(driver, "Name already exists")));
					}
					
					test.log(LogStatus.PASS, "11.Select one employee.");
					userName=userData[1][2]+FunctionUtils.generateRandomNumber();
					
					addNewUserPage.username_textbox().clear();
					addNewUserPage.username_textbox().sendKeys(userName);
					test.log(LogStatus.PASS, "12.Enter username.");
					adminData.setUserName(userName);
					
					sleep(2);
					addNewUserPage.available_Filter().sendKeys(userData[1][0]);
					
					String list = addNewUserPage.available_List().getText();
					
					sleep(2);
					if(list.contains(userData[1][0]))
					{
						addNewUserPage.available_Button().click();
						test.log(LogStatus.PASS, "13.Add one group by clicking on the arrow.");
						
						String selectedList = addNewUserPage.selected_List().getText();
						
						if(selectedList.contains(userData[1][0]))
						{
							sleep(3);
							
							javaScriptClick(addNewUserPage.add_GeneralButton());
							test.log(LogStatus.PASS, "14.Click on add button.");
							
							sleep(3);
							if(addNewUserPage.password_tab() != null)
							{
								test.log(LogStatus.PASS, "<b>ER 9- It should Navigate to 'Password Tab'.<b>"+
										test.addScreenCapture(captureScreenShot(driver, "password tab")));
								sleep(3);
								
								addNewUserPage.password_AddTab().click();
								test.log(LogStatus.PASS, "15.Click on Add Button without entering a 'new password' and 'confirm password'.");
								
								if(addNewUserPage.passwordRequired_ErrorMsg().isDisplayed()&&addNewUserPage.confirmPasswordRequired_ErrorMsg().isDisplayed())
								{
									test.log(LogStatus.PASS, "<b>ER 10- It should display validation messages as 'Password is required', 'Confirm Password is required'.<b>"+
											test.addScreenCapture(captureScreenShot(driver, "password tab")));
								}else
								{
									test.log(LogStatus.FAIL, "Unable to verified validation messages 'Password is required '."+
											test.addScreenCapture(captureScreenShot(driver, "Password is required ")));
								}
								
								addNewUserPage.check_AuthenticationType().selectByVisibleText(userData[1][4]);
								test.log(LogStatus.PASS, "16.Select authentication type as Title21.");
								sleep(2);
								addNewUserPage.new_PasswordInput().sendKeys(userData[1][6]);
								test.log(LogStatus.PASS, "17.Enter password less than 10 characters.");
								
								addNewUserPage.check_StrengthButton().click();
								test.log(LogStatus.PASS, "18.Click on check strength.");
							
								sleep(3);
								if(addNewUserPage.passwordMust_PopUp().isDisplayed()) 
								{
									firstMsgColor = addNewUserPage.tenCharacters_Msg().getCssValue("color");
									
									secondLineColor = addNewUserPage.strengthLeastOne_Msg().getCssValue("color");
																	
									if(!firstMsgColor.equals(secondLineColor))
									{
										test.log(LogStatus.PASS, "<b>ER 11- It should display validation messages as 'password contain at least 10 characters'.<b>"+
												test.addScreenCapture(captureScreenShot(driver, "Pop Up")));
									}
									else
									{
										test.log(LogStatus.FAIL, "Unable to find ER 9 – It should display validation messages as “password contain at least 10 characters”."+
												test.addScreenCapture(captureScreenShot(driver, "Pop Up")));
									}
								}
								else
								{
									test.log(LogStatus.FAIL, "Unable to find 'Password must' pup-up."+
											test.addScreenCapture(captureScreenShot(driver, "Pop Up")));
								}
								
								addNewUserPage.passwordMust_Close().click();
								
								sleep(3);
								addNewUserPage.new_PasswordInput().clear();
								addNewUserPage.new_PasswordInput().sendKeys(userName+123);
								addNewUserPage.confirm_PasswordInput().sendKeys(userName+123);
								test.log(LogStatus.PASS, "19.Enter password contains user Id.");
								sleep(2);
								test.log(LogStatus.PASS, "20.Click on add button.");
								javaScriptClick(addNewUserPage.password_AddTab());
								sleep(3);
								if(addNewUserPage.passwordCannotContainUserId_ErrorMsg().isDisplayed()) 
								{
									sleep(3);
									test.log(LogStatus.PASS, "<b>ER 12- It should display validation messages as 'Password cannot contain User Id'.<b>"+
											test.addScreenCapture(captureScreenShot(driver, "Pop Up")));
								}
								else
								{
									test.log(LogStatus.FAIL, "Unable to find 'Password must' pup-up."+
											test.addScreenCapture(captureScreenShot(driver, "Pop Up")));
								}
								sleep(2);
								addNewUserPage.new_PasswordInput().clear();
								addNewUserPage.new_PasswordInput().sendKeys(userData[1][5]);
								test.log(LogStatus.PASS, "21.Enter valid password ");
								addNewUserPage.confirm_PasswordInput().clear();
								addNewUserPage.confirm_PasswordInput().sendKeys(userData[1][8]);
								test.log(LogStatus.PASS, "22.Enter invalid data in confirm password field.");
								sleep(2);
								javaScriptClick(addNewUserPage.password_AddTab());
								sleep(3);
								if(addNewUserPage.passwordDoesNotMatch_ErrorMsg().isDisplayed())
								{
									test.log(LogStatus.PASS, "<b>ER 13- It should display validation messages as 'Password does not match'.<b>"+
											test.addScreenCapture(captureScreenShot(driver, "Password does not match")));
								}
								else
								{
									test.log(LogStatus.FAIL, "Unable to verified ER 11– It should display validation messages as 'Password does not match'."+
											test.addScreenCapture(captureScreenShot(driver, "Password does not match")));
								}
								sleep(3);
								addNewUserPage.new_PasswordInput().sendKeys(userData[1][5]);
								sleep(2);
								addNewUserPage.confirm_PasswordInput().sendKeys(userData[1][5]);
								
								test.log(LogStatus.PASS, "23.Enter valid password and confirm password ");
								sleep(2);
								addNewUserPage.password_AddTab().click();
								test.log(LogStatus.PASS, "24.Click on add button");
								
								sleep(3);
								
								if(addNewUserPage.password_AddTab() != null) 
								{
									addNewUserPage.password_AddTab().click();
								}
								sleep(3);
								
								if(addNewUserPage.confirmHeader_Msg() != null)
								{
									test.log(LogStatus.PASS, "<b>ER 14- A message confirming user is successfully added is displayed.<b>"+
											test.addScreenCapture(captureScreenShot(driver, "Confirmed pop-up")));
									addNewUserPage.confirmClose_Button().click();
								}
								else
								{
									test.log(LogStatus.FAIL, "Successfully verified confirm pop-up");
								}
								
								sleep(3);
								if(addNewUserPage.groupFilterResult().isDisplayed())
								{
									test.log(LogStatus.PASS, "25.Go to user list screen .");
									
									addNewUserPage.groupFilterResult().clear();
									test.log(LogStatus.PASS, "26.Click on search filter and enter the created user's name.");
									addNewUserPage.groupFilterResult().sendKeys(userName);
									test.log(LogStatus.PASS, "27.Click on Go butto");
									addNewUserPage.groupFilterResutGoButton().click();
									
									sleep(2);
									
									for(int i=1; i<=10; i++ ) {
										
										String groups = driver.findElement(By.xpath("//tbody[@class='t21-js-clickable-rows']/tr["+i+"]/td[2]")).getText();
										sleep(1);
										if(groups.equalsIgnoreCase(userName)) {
											UserPresenceAfterSearch = true;
											break;
										}
									}
									
									if(UserPresenceAfterSearch) {
										test.log(LogStatus.PASS, "<b>ER 15- User Record as per search is displayed.<b>"+
												test.addScreenCapture(captureScreenShot(driver, "newly created user name")));
									}else {
										test.log(LogStatus.FAIL, "Unable to verify created user."+
												test.addScreenCapture(captureScreenShot(driver, "newly created user name.")));
									}
								}
								else
								{
									test.log(LogStatus.FAIL, "Unable to verify created group."+
											test.addScreenCapture(captureScreenShot(driver, "Unable to find Filter Result text field.")));
								}
								
								
							}
							else
							{
								test.log(LogStatus.FAIL, "Unable to verified 'password' tab.");
							}
							
						}
						else
						{
							test.log(LogStatus.FAIL, "Unable to select list.");
						}
					}
					else
					{
						test.log(LogStatus.FAIL, "Unable to clicked 'Available' button.");
						addNewUserPage.cancel_GeneralButton().click();
					}
				}
				
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to verified 'general' tab");
			}
			
		}else {
			test.log(LogStatus.FAIL, "Unable to verified ER 4- Add new user popup screen appears. "+
					test.addScreenCapture(captureScreenShot(driver, "Add New User")));
		}
		extent.endTest(test);
	}
	
	@Test(testName = "logout", groups = "Logout", priority = 1)
	public void Logout() throws Exception 
	{	
		sleep(3);
		logout=new LogoutPage_POM(driver);
		logout.logoutFunction();		
	}
	
	@AfterClass
	public void closeBrowserInstance()
	{		
		driver.close();
	}
}