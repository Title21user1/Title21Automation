package org.title21.Documents_Test;
import java.util.List;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.AdminModule_POM.Table;
import org.title21.DBConnection.DBConnection;
import org.title21.DBConnection.DBQueries;
import org.title21.Documents_POM.ReadAndSignTraining_POM;
import org.title21.dao.AdminData;
import org.title21.utility.BaseClass;
import org.title21.utility.DateTimeUtils;

import com.relevantcodes.extentreports.LogStatus;

public class ReadAndSignTraining_Test extends BaseClass{
	LoginPage_POM login;
	LogoutPage_POM logout;
	ReadAndSignTraining_POM readSign;
	DateTimeUtils dateTimeUtils;
	static Logger log = Logger.getLogger(DocumentRoutes_Test.class);
	String className="";
	String documetNo="";
	String documetsName="";
	String fileUploadPath="";
	String uploadFileName="FileToUpload.txt";
	String documentStatus="";
	String addedEntities="";
	String trainigDueDate="";
	Table searchTable;
	DBQueries dbqueries;
	boolean isRecordFound=false;
	AdminData adminData=new AdminData();
		
	@BeforeClass(alwaysRun=true)
	public void openURL() 
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		logout=new LogoutPage_POM(driver);
		login=new LoginPage_POM(driver);
		dbqueries = new DBQueries();
	}
//=====================================================================Part=>01================================================================================
	@Test(testName = "Read And Sign Training", groups = "DocumentModule", priority = 0)
	public void ReadAndSignTraining_Part1() throws Exception
	{		
		login.loginUser("Title21User2", "test123456");  //loginData[7][0], loginData[7][1]
		test = extent.startTest("Read And Sign Training Part");
		test.log(LogStatus.PASS, "1.Login to the web interface as 'Test User'.");
		test.log(LogStatus.INFO, "Link to Test case document", "<a href='file:///E:/sameer/Sameer Joshi/Title health solutions/Test case by neosoft/TestCase-WIA-document_routes.doc'>TestCaseDocument</a>");
		readSign=new ReadAndSignTraining_POM(driver);	
		dateTimeUtils=new DateTimeUtils();
		
		readSign.getnewdoc().click();
		sleep(3);
		readSign.getdocument().click();
		sleep(3);

		readSign.getlocationDrodown().selectByVisibleText(routeData[1][0]);

		readSign.getlocationDrodown().selectByVisibleText("antioch");  //Dallas

		sleep(2);
		documetNo = readSign.document_No().getAttribute("value");
		
		readSign.getDocumentTitle().sendKeys(routeData[1][1]+documetNo); 
		readSign.getDocChangeSummary().sendKeys(routeData[1][2]+documetNo);
		verticalScrollingDown();
		readSign.getConfirmButton().click();
		sleep(5);
		if(readSign.getdocumentcreationverify().isDisplayed()) 
		{
			test.log(LogStatus.PASS,"2.	Create a new document");
			
			readSign.addMainFile_Button().click();
			
			sleep(3);
			
			test.log(LogStatus.PASS,"3.Add a main file, approvers and other required fields.");
			
			//main file- 
			if(readSign.addMainFileHeader_Text().isDisplayed())
			{
				fileUploadPath=System.getProperty("user.dir") + "\\testdata";
				fileUploadPath=fileUploadPath+"\\"+uploadFileName;
				readSign.browse_Button().sendKeys(fileUploadPath);
				
				sleep(2);
				readSign.add_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL,"Unable to find Add Main File header.");
			}
			//approver-
			readSign.getDocumentApprovaltab().click();
			test.log(LogStatus.PASS,"4.	Click on the add approver link.");
			sleep(2);
			readSign.getAddApproverLink().click();
			sleep(2);
			if(readSign.addNewApprover_Header().isDisplayed())
			{
				readSign.getApproverRole().selectByVisibleText(routeData[1][3]);
				sleep(2);
				readSign.getLocationDropdown().selectByVisibleText(routeData[1][4]); 
				sleep(2);

				readSign.getnameinAddApprover().selectByVisibleText("Title21User1"); //sameer

				readSign.getSequenceinAddApprover().selectByVisibleText("1");
				readSign.getallottedDaysinAddApprover().selectByVisibleText(routeData[1][7]);
				readSign.approverAdd_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find Add new approver popup screen."+
						test.addScreenCapture(captureScreenShot(driver, "new approver popup")));
			}
			//
			
			test.log(LogStatus.PASS,"4.Click on the 'Training' tab.");
			readSign.training_Tab().click();
			sleep(2);
			
			readSign.ChangeTrainingType_Link().click();
			sleep(2);
			test.log(LogStatus.PASS,"5.Change the training type to 'Read and Sign'."+
					test.addScreenCapture(captureScreenShot(driver, "Read and Sign")));
			
			if(readSign.changeTrainingType_Header().isDisplayed())
			{
				readSign.readAndSignRadio_Button().click();
				test.log(LogStatus.PASS, "6.Click on save button.");
				readSign.changeTrainingTypePopUpSave_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find Change Training Type Pop Up.");
			}
			
			test.log(LogStatus.PASS, "7.Set 'Schedule training: On promotion to the following cabinet' to 'Approved'.");
			readSign.scheduleTraining_DropDown().selectByVisibleText("Approved");
			
			test.log(LogStatus.PASS, "8.For 'Training due,' select the radio button 'before promotion to next cabinet'.");
			readSign.BeforePromotionRadio_Button().click();
			
			verticalScrollingDown();
			test.log(LogStatus.PASS, "9.For 'Select entities subject to training,' select the radio button 'Read/Write from cabinet'.");
			readSign.readWriteFromCabinetRadio_Button().click();
			
			verticalScrollingUp();
			test.log(LogStatus.PASS, "<b>ER1- The Read and Sign Training is scheduled.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Read and Sign Training is scheduled")));
			
			test.log(LogStatus.PASS, "10.Check in the document and route the document for approval.");
			readSign.docContext_Menu().click();
			sleep(1);
			readSign.checkIn_Route().click();
			sleep(2);
			
			if(readSign.checkInRoutePopUp_Header().isDisplayed())
			{
				readSign.checkInRouteSubmit_Button().click();
				sleep(2);
				readSign.verifyDocumentCheckedIn(driver);
				test.log(LogStatus.PASS, "<b>ER2- The document is checked in and route for approval.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "document is checked in and route for approval")));
				readSign.close_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.PASS, "Unable to find Check In Route PopUp_Header.");
			}
			
			logout.logoutFunction();
			login.loginUser("Title21User1", "test123456");  //loginData[1][0], loginData[1][1]
			
			test.log(LogStatus.PASS, "11.Login with approver's login and approve the document.");
			approveDocFromWizard(documetNo);
			test.log(LogStatus.PASS, "<b>ER3- The document is approved successfully and displays the successful message.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "document is approved successfully")));
			
			test.log(LogStatus.PASS, "12.Go to: Wizard > Training.");
			readSign.wizard_Option().click();
			sleep(2);
			readSign.wizardTraining_Tab().click();
			sleep(2);
			
			if(readSign.verifyNoItemsFoundText())
			{
				test.log(LogStatus.FAIL, "<b>Unable to find the Filter TextBox.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Filter TextBox")));
			}
			else
			{
				readSign.approvalFilter_TextBox().sendKeys(documetNo);
				sleep(2);
				readSign.approvalFilterGo_Button().click();
				sleep(2);
			}
			
			/*for(int i=1; i<=20; i++)
			{
				selectDocForTraining(documetNo);
				 if(!isRecordFound)
				 {
					// verticalScrollingDown();
					 readSign.documentTableNext_Button().click();
			 			sleep(2); 
				 }
				 else
				 {
					 break;
				 }
			}*/
			
			if(selectDocForTraining(documetNo))
			{
				test.log(LogStatus.PASS, "<b>ER4- The Read and Sign training created is available.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "The Read and Sign training created is available.")));
				test.log(LogStatus.PASS, "13.Select training");
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find the validation message- The Read and Sign training created is available.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "The Read and Sign training created is available.")));
			}
			
			verticalScrollingUp();
			test.log(LogStatus.PASS, "14.click on begin training.");
			readSign.beginTraining_Button().click();
			sleep(2);
			test.log(LogStatus.PASS, "<b>ER5- Details about the training document are visible.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "The Read and Sign training created is available.")));
			test.log(LogStatus.PASS, "15.Click on Document");
			readSign.document_Button().click();
			sleep(4);
			
			if(readSign.sign_Button().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER6- The document should be available in a new tab with options to Sign.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "document should be available")));
				test.log(LogStatus.PASS, "16.Click on 'Sign'.");
				readSign.sign_Button().click();
			}
			else
			{
				test.log(LogStatus.FAIL, "unable to find the validation message- The document should be available in a new tab with options to Sign."+
						test.addScreenCapture(captureScreenShot(driver, "document should be available")));
			}
			sleep(2);
			if(readSign.pin_TextBox().isDisplayed())
			{
				test.log(LogStatus.PASS, "<b>ER7- The electronic signature dialog is presented.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "electronic signature dialog")));
				test.log(LogStatus.PASS, "17.Enter the pin and click on confirm button.");
				readSign.pin_TextBox().sendKeys(routeData[1][12]);
				readSign.changeTrainingTypePopUpSave_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find the validation message- The electronic signature dialog is presented."+
						test.addScreenCapture(captureScreenShot(driver, "electronic signature dialog")));
			}
			
			getTrainingCompletedItem(documetNo);
			if(isRecordFound)
			{
				test.log(LogStatus.PASS, "<b>ER8- User is informed that the training item is completed, and the training item details are visible with the 'Signed On' date updated.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "training item is completed")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find the validation message- User is informed that the training item is completed, and the training item details are visible with the Signed On date updated.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "training item is completed")));
			}
			
			logout.logoutFunction();
			
			test.log(LogStatus.PASS, "18.Login as admin and navigate to audit log section.");

			login.loginUser(loginData[7][0], loginData[7][1]);
			

			readSign.administratorDropDown().click();
			readSign.auditLog_Option().click();
			sleep(2);
			
			test.log(LogStatus.PASS, "19.Search the audit log for the signature entry by the test user.");
			
			if(readSign.audtitLogSearch_Field().isDisplayed())
			{
				readSign.audtitLogSearch_Field().clear();
				readSign.audtitLogSearch_Field().sendKeys(documetNo);
				readSign.audtitLogSearchFieldGo_button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.PASS, "unable to find the Audtit Log Search_Field.");
			}
			
			for(int i=1; i<=50; i++)
			{
				WebElement text = driver.findElement(By.xpath("//*[@id='dynamic-grid-table']/tbody/tr["+i+"]/td[5]"));
				String itemName= text.getText();
				
				if(itemName.equalsIgnoreCase("Completed Training Item"))
				{
					WebElement documentName = driver.findElement(By.xpath("//*[@id='dynamic-grid-table']/tbody/tr["+i+"]/td[8]"));
					String documentText= documentName.getText();
					if(documentText.contains(documetNo))
					{
						test.log(LogStatus.PASS, "<b>ER9- The audit log entry for the read and sign training performed through the web interface is recorded.<b>"+
								test.addScreenCapture(captureScreenShot(driver, "audit log entry for the read and sign training performed")));
					}
					break;
				}
			}
		}
		else
		{
			test.log(LogStatus.FAIL,"Unable to Create a new document form.");
		}
		
		logout.logoutFunction();
	}
//=====================================================================Part=>02================================================================================
	@Test(testName = "Read And Sign Training", groups = "DocumentModule", priority = 1)
	public void ReadAndSignTraining_Part2() throws Exception
	{		
		login.loginUser("Title21User2", "test123456");  //loginData[7][0], loginData[7][1]
		readSign=new ReadAndSignTraining_POM(driver);	
		dateTimeUtils=new DateTimeUtils();
		
		readSign.getnewdoc().click();
		sleep(3);
		readSign.getdocument().click();
		sleep(3);
		test.log(LogStatus.PASS,"20.Create a new document");

		readSign.getlocationDrodown().selectByVisibleText(routeData[1][0]);

		sleep(2);
		documetNo = readSign.document_No().getAttribute("value");
		
		readSign.getDocumentTitle().sendKeys(routeData[1][1]+documetNo); 
		readSign.getDocChangeSummary().sendKeys(routeData[1][2]+documetNo);
		verticalScrollingDown();
		readSign.getConfirmButton().click();
		sleep(5);
		test.log(LogStatus.PASS,"21.Ensure the document is open in edit mode.");
		if(readSign.getdocumentcreationverify().isDisplayed()) 
		{
			readSign.addMainFile_Button().click();
			
			sleep(3);
			
			test.log(LogStatus.PASS, "22.Add the main file, approvers, and all the required fields.");
			//main file- 
			if(readSign.addMainFileHeader_Text().isDisplayed())
			{
				fileUploadPath=System.getProperty("user.dir") + "\\testdata";
				fileUploadPath=fileUploadPath+"\\"+uploadFileName;
				readSign.browse_Button().sendKeys(fileUploadPath);
				
				sleep(2);
				readSign.add_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL,"Unable to find Add Main File header.");
			}
			//approver-
			readSign.getDocumentApprovaltab().click();
			sleep(2);
			readSign.getAddApproverLink().click();
			sleep(2);
			if(readSign.addNewApprover_Header().isDisplayed())
			{
				readSign.getApproverRole().selectByVisibleText(routeData[1][3]);
				sleep(2);
				readSign.getLocationDropdown().selectByVisibleText(routeData[1][4]); 
				sleep(2);

				readSign.getnameinAddApprover().selectByVisibleText(routeData[1][5]);

				readSign.getSequenceinAddApprover().selectByVisibleText("1");
				readSign.getallottedDaysinAddApprover().selectByVisibleText(routeData[1][7]);
				readSign.approverAdd_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find Add new approver popup screen."+
						test.addScreenCapture(captureScreenShot(driver, "new approver popup")));
			}
			
			test.log(LogStatus.PASS, "23.Set the Target Release Date to one day after the current date.");
			readSign.general_Tab().click();
			sleep(2);
			
			String targetReleaseDate=DateTimeUtils.getCurrentPSTDate();  
			
			readSign.targetReleaseDate_TextBox().click();
			sleep(1);
			readSign.targetReleaseDate_TextBox().click();
			readSign.current_Date().click();
			
			test.log(LogStatus.PASS, "<b>ER10- Target release date is set.<b>"+
					test.addScreenCapture(captureScreenShot(driver, "Target release date is set.")));
			
			test.log(LogStatus.PASS, "24.Click on the 'Training' tab.");
			readSign.training_Tab().click();
			sleep(2);
			
			test.log(LogStatus.PASS, "25.Select or change the training type to 'Read and Sign'.");
			readSign.ChangeTrainingType_Link().click();
			sleep(3);
			if(readSign.changeTrainingType_Header().isDisplayed())
			{
				readSign.readAndSignRadio_Button().click();
				readSign.changeTrainingTypePopUpSave_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find Change Training Type Pop Up.");
			}
			
			test.log(LogStatus.PASS, "26.Set 'Schedule training: On promotion to the following cabinet' to 'Approved'.");
			readSign.scheduleTraining_DropDown().selectByVisibleText("Approved");
				
			test.log(LogStatus.PASS, "27.For 'Training due', select the radio button 'before promotion to next cabinet'");
			readSign.BeforePromotionRadio_Button().click();
			
			verticalScrollingDown();
			
			test.log(LogStatus.PASS, "28.For 'Promotion Settings', select the checkbox 'Item may be promoted to next cabinet with open training items'.");
			readSign.promotionSettingsItemsCheck(true);
			sleep(2);
			test.log(LogStatus.PASS, "29.For 'Require the following percentage of training to be completed,' select the checkbox and add '50' % in the text box.");
			readSign.trainingsPercentagCheck(true);
			sleep(2);
			readSign.trainingsPercentage_TextBox().clear();
			sleep(2);
			readSign.trainingsPercentage_TextBox().sendKeys("50");
			
			test.log(LogStatus.PASS, "30.For 'Select entities subject to training', select the 'From Selection' radio button. Click on 'Entities' link. Select two entities and click on 'Update'.");
			readSign.entitiesSubject_FromSection().click();
			readSign.addNewTrainingEntities_Link().click();
			sleep(5);
			if(readSign.selectedEntities_Header().isDisplayed())
			{
				readSign.entitiesEmp_FilterBox().clear();
				readSign.entitiesEmp_FilterBox().sendKeys("Title21User4");  //loginData[11][2]
				readSign.entitiesEmpFilterGo_Button().click();
				sleep(2);
				readSign.moveSelectedEntities_Button().click();
				sleep(2);
				
				readSign.entitiesEmp_FilterBox().clear();
				readSign.entitiesEmp_FilterBox().sendKeys("Title21User5"); //loginData[12][2]
				readSign.entitiesEmpFilterGo_Button().click();
				sleep(2);
				readSign.moveSelectedEntities_Button().click();
				sleep(2);
				addedEntities = readSign.addedFirst_Entities().getText();
				
				javaScriptClick(readSign.changeTrainingTypePopUpSave_Button());
				sleep(2);
				verticalScrollingUp();
				test.log(LogStatus.PASS, "<b>ER11- The Read and Sign Training is scheduled.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Target release date is set.")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find Selected Entities Header");
			}
			
			test.log(LogStatus.PASS, "31.Check in the document and route it for approval.");
			readSign.docContext_Menu().click();
			sleep(2);
			readSign.checkIn_Route().click();
			sleep(2);
			readSign.checkInRouteSubmit_Button().click();
			sleep(2);
			readSign.verifyDocumentCheckedIn(driver);
			readSign.close_Button().click();
			sleep(2);
			test.log(LogStatus.PASS, "32.Logout and login with an approver.");
			logout.logoutFunction();
			login.loginUser("Title21User1", "test123456");  //loginData[1][0], loginData[1][1]
			
			test.log(LogStatus.PASS, "33.Approve the document.");
			approveDocFromWizard(documetNo);
			
			test.log(LogStatus.PASS, "34.Logout and login with the same user used in step 22.");
			logout.logoutFunction();
			login.loginUser("Title21User2", "test123456"); //loginData[7][0], loginData[7][1]
			
			test.log(LogStatus.PASS,"35.Move document between cabinets through the database."+DBConnection.executeStoredProcedure(dbqueries.moveDocsOnReleaseDate));
			
			driver.findElement(By.xpath("//li[text()='"+routeData[1][1]+documetNo+"']")).click();
			
			test.log(LogStatus.PASS, "36.Go to document approved in Step 35.");
			documentStatus = readSign.document_Status().getText();
			if(documentStatus.equals("Approved"))
			{
				test.log(LogStatus.PASS, "<b>ER12- Approved document from Step 35 should not move to the effective cabinet as 50% of required training is not completed yet.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Approved document status")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find Approved document status.");
			}
			
			test.log(LogStatus.PASS, "37.Logout and login as one of the entity noted in Step 30.");
			logout.logoutFunction();
			
			if(addedEntities.equalsIgnoreCase("Title21User4"))   //loginData[11][2]
			{
				login.loginUser("Title21User4", "test123456");  //loginData[11][0], loginData[11][1]
			}
			else
			{
				login.loginUser("Title21User5", "test123456");  //loginData[12][0], loginData[12][1]
			}
			
			test.log(LogStatus.PASS, "38.Navigate to Wizard > Training.");
			readSign.wizard_Option().click();
			sleep(2);
			readSign.wizardTraining_Tab().click();
			sleep(2);
			readSign.approvalFilter_TextBox().sendKeys(documetNo);
			sleep(2);
			readSign.approvalFilterGo_Button().click();
			sleep(2);
			readSign.approvalFilter_TextBox().sendKeys(documetNo);
			sleep(2);
			readSign.approvalFilterGo_Button().click();
			sleep(2);
			
			
			
			/*for(int i=1; i<=20; i++)
			{
				selectDocForTraining(documetNo);
				 if(!isRecordFound)
				 {
					// verticalScrollingDown();
					 readSign.documentTableNext_Button().click();
			 			sleep(2); 
				 }
				 else
				 {
					 break;
				 }
			}*/
			
			if(selectDocForTraining(documetNo))
			{
				test.log(LogStatus.PASS, "<b>ER13- The Read and Sign training created in ER-11 appears.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Read and Sign training created")));
			}
			else
			{
				test.log(LogStatus.FAIL, "unable to find the Read and Sign training created in ER-11 appears.");
			}
			
			readSign.approvalFilter_TextBox().clear();
			readSign.approvalFilter_TextBox().sendKeys(documetNo);
			sleep(2);
			readSign.approvalFilterGo_Button().click();
			sleep(2);
			
			String date="";
			for(int j=1; j<=20; j++)
			{
				 date=getDueOnDateTrainingDoc(documetNo);
				 if(date.equals(""))
				 {
					 readSign.documentTableNext_Button().click();
			 		 sleep(2); 
				 }
				 else
				 {
					 break;
				 }
			}
			
			String ddmm = targetReleaseDate.substring(0, 5);
			
			System.out.println(date);
			System.out.println(ddmm);
			
			if(date.contains(ddmm))
			{
				test.log(LogStatus.PASS, "<b>ER14- Training due date is same as Target release date noted in Step 20.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Read and Sign training created")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find Training due date is same as Target release date noted in Step 20.");
			}
			
			test.log(LogStatus.PASS, "39.Begin training.");
			readSign.beginTraining_Button().click();
			
			test.log(LogStatus.PASS, "40.Sign/complete the training.");
			selectTrainingItemDoc(documetNo);
			readSign.document_Button().click();
			readSign.sign_Button().click();
			sleep(2);
			readSign.pin_TextBox().sendKeys(routeData[1][12]);
			readSign.changeTrainingTypePopUpSave_Button().click();
			sleep(2);
			
			test.log(LogStatus.PASS, "41.Log out.");
			logout.logoutFunction();
			
			test.log(LogStatus.PASS,"42.Run Jobs and Move document between cabinets through the database."+DBConnection.executeStoredProcedure(dbqueries.moveDocsOnReleaseDate));
			
			test.log(LogStatus.PASS, "43.Log in to a user used in Step 1");
			login.loginUser(loginData[7][0], loginData[7][1]); //saurabhp
			
			driver.findElement(By.xpath("//li[text()='"+routeData[1][1]+documetNo+"']")).click();
			sleep(2);	
			documentStatus = readSign.document_Status().getText();
			if(documentStatus.equals("Effective"))
			{
				test.log(LogStatus.PASS, "<b>ER15- Approved document from Step 35 should move to the effective cabinet as 50% of required training is completed.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Approved document effective")));
			}
			else
			{
				driver.navigate().refresh();
				sleep(10);
				driver.findElement(By.xpath("//li[text()='"+routeData[1][1]+documetNo+"']")).click();
				sleep(2);
				if(documentStatus.equals("Effective"))
				{
					test.log(LogStatus.PASS, "<b>ER15- Approved document from Step 35 should move to the effective cabinet as 50% of required training is completed.<b>"+
							test.addScreenCapture(captureScreenShot(driver, "Approved document effective")));
				}
				else
				{
					test.log(LogStatus.FAIL, "Unable to find ER15- Approved document from Step 35 should move to the effective cabinet as 50% of required training is completed."+
							test.addScreenCapture(captureScreenShot(driver, "Approved document effective")));
				}
			}
		}
		else
		{
			test.log(LogStatus.FAIL,"Unable to Create a new document form.");
		}
		
		logout.logoutFunction();
		sleep(2);
	}
//=====================================================================Part=>03================================================================================	
	@Test(testName = "Read And Sign Training", groups = "DocumentModule", priority = 3)
	public void ReadAndSignTraining_Part3() throws Exception
	{	
		login.loginUser(loginData[7][0], loginData[7][1]);
		readSign=new ReadAndSignTraining_POM(driver);	
		dateTimeUtils=new DateTimeUtils();
		
		readSign.getnewdoc().click();
		sleep(3);
		readSign.getdocument().click();
		sleep(3);
		test.log(LogStatus.PASS,"44.Create a new document.");
		readSign.getlocationDrodown().selectByVisibleText(routeData[1][0]);
		sleep(2);
		documetNo = readSign.document_No().getAttribute("value");
		
		readSign.getDocumentTitle().sendKeys(routeData[1][1]+documetNo); 
		readSign.getDocChangeSummary().sendKeys(routeData[1][2]+documetNo);
		verticalScrollingDown();
		readSign.getConfirmButton().click();
		sleep(5);
		test.log(LogStatus.PASS,"45.Ensure the document is open in edit mode.");
		test.log(LogStatus.PASS, "46.Note: Edit mode On/Off is generally indicated on the top of the form and form fields are editable when it is enabled.");
		if(readSign.getdocumentcreationverify().isDisplayed()) 
		{
			readSign.addMainFile_Button().click();
			
			sleep(2);
			
			test.log(LogStatus.PASS, "47.Add the main file, approvers, and all the required fields.");
			//main file- 
			if(readSign.addMainFileHeader_Text().isDisplayed())
			{
				fileUploadPath=System.getProperty("user.dir") + "\\testdata";
				fileUploadPath=fileUploadPath+"\\"+uploadFileName;
				readSign.browse_Button().sendKeys(fileUploadPath);
				
				sleep(2);
				readSign.add_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL,"Unable to find Add Main File header.");
			}
			//approver-
			readSign.getDocumentApprovaltab().click();
			sleep(2);
			readSign.getAddApproverLink().click();
			sleep(2);
			if(readSign.addNewApprover_Header().isDisplayed())
			{
				readSign.getApproverRole().selectByVisibleText(routeData[1][3]);
				sleep(2);
				readSign.getLocationDropdown().selectByVisibleText(routeData[1][4]); 
				sleep(2);
				readSign.getnameinAddApprover().selectByVisibleText(routeData[1][5]);
				readSign.getSequenceinAddApprover().selectByVisibleText("1");
				readSign.getallottedDaysinAddApprover().selectByVisibleText(routeData[1][7]);
				readSign.approverAdd_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find Add new approver popup screen."+
						test.addScreenCapture(captureScreenShot(driver, "new approver popup")));
			}
			
			test.log(LogStatus.PASS, "48.Click on the 'Training' tab.");
			readSign.training_Tab().click();
			sleep(2);
			
			test.log(LogStatus.PASS, "49.Select or change the training type to 'Read and Sign'.");
			readSign.ChangeTrainingType_Link().click();
			sleep(3);
			if(readSign.changeTrainingType_Header().isDisplayed())
			{
				readSign.readAndSignRadio_Button().click();
				readSign.changeTrainingTypePopUpSave_Button().click();
				sleep(2);
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find Change Training Type Pop Up.");
			}
			
			test.log(LogStatus.PASS, "50.Set 'Schedule training: On promotion to the following cabinet' to 'Approved'.");
			readSign.scheduleTraining_DropDown().selectByVisibleText("Approved");
				
			test.log(LogStatus.PASS, "51.For 'Training due' select radio button 'by date' and set that date.");
			readSign.trainingDue_ByDate().click();
			trainigDueDate= readSign.trainingDueDate_TextBox().getAttribute("value");
			
			verticalScrollingDown();
			
			test.log(LogStatus.PASS, "52.For 'Promotion Settings', select the checkbox 'Item may be promoted to next cabinet with open training items'.");
			readSign.promotionSettingsItemsCheck(true);
			sleep(2);
			test.log(LogStatus.PASS, "53.For 'Require the following percentage of training to be completed,' select the checkbox and add '50' % in the text box.");
			readSign.trainingsPercentagCheck(true);
			sleep(2);
			readSign.trainingsPercentage_TextBox().clear();
			sleep(2);
			readSign.trainingsPercentage_TextBox().sendKeys("50");
			
			test.log(LogStatus.PASS, "54.For 'Select entities subject to training', select the 'From Selection' radio button. Click on 'Entities' link. Select two entities and click on 'Update'.");
			readSign.entitiesSubject_FromSection().click();
			readSign.addNewTrainingEntities_Link().click();
			sleep(3);
			if(readSign.selectedEntities_Header().isDisplayed())
			{
				readSign.entitiesEmp_FilterBox().clear();
				readSign.entitiesEmp_FilterBox().sendKeys(loginData[11][2]);
				readSign.entitiesEmpFilterGo_Button().click();
				sleep(2);
				readSign.moveSelectedEntities_Button().click();
				sleep(2);
				
				readSign.entitiesEmp_FilterBox().clear();
				readSign.entitiesEmp_FilterBox().sendKeys(loginData[12][2]);
				readSign.entitiesEmpFilterGo_Button().click();
				sleep(2);
				readSign.moveSelectedEntities_Button().click();
				
				addedEntities = readSign.addedFirst_Entities().getText();
				
				javaScriptClick(readSign.changeTrainingTypePopUpSave_Button());
				sleep(2);
				verticalScrollingUp();
				test.log(LogStatus.PASS, "<b>ER16- Read and Sign Training is setup as described in previous steps.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Target release date is set.")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find Selected Entities Header");
			}
			
			test.log(LogStatus.PASS, "55.Check in the document and route the document for approval.");
			readSign.docContext_Menu().click();
			sleep(2);
			readSign.checkIn_Route().click();
			sleep(2);
			readSign.checkInRouteSubmit_Button().click();
			sleep(4);
			readSign.verifyDocumentCheckedIn(driver);
			readSign.close_Button().click();
			sleep(2);
			logout.logoutFunction();
			login.loginUser(loginData[1][0], loginData[1][1]);  //sameer
			
			test.log(LogStatus.PASS, "56.Approve the document.");
			approveDocFromWizard(documetNo);
			
			test.log(LogStatus.PASS, "57.Log out.");
			logout.logoutFunction();
			
			
			test.log(LogStatus.PASS, "58.Log in as one of the entities noted in Step 56.");
			if(addedEntities.equalsIgnoreCase(loginData[11][2]))
			{
				login.loginUser(loginData[11][0], loginData[11][1]);
			}
			else
			{
				login.loginUser(loginData[12][0], loginData[12][1]);
			}
			
			test.log(LogStatus.PASS, "59.Navigate to Wizard > Training.");
			readSign.wizard_Option().click();
			sleep(2);
			readSign.wizardTraining_Tab().click();
			sleep(5);
			
			String date="";
			for(int j=1; j<=20; j++)
			{
				 date=getDueOnDateTrainingDoc(documetNo);
				 if(date.equals(""))
				 {
					 readSign.documentTableNext_Button().click();
			 		 sleep(2); 
				 }
				 else
				 {
					 break;
				 }
			}
			
			String ddmm = trainigDueDate.substring(0, 5);
			
			System.out.println(date);
			System.out.println(ddmm);
			
			if(date.contains(ddmm))
			{
				test.log(LogStatus.PASS, "<b>ER17- The Read and Sign training created in Step 56 appears and the due date is the same as 'Training due by date' noted in step 53.<b>"+
						test.addScreenCapture(captureScreenShot(driver, "Read and Sign training created")));
			}
			else
			{
				test.log(LogStatus.FAIL, "Unable to find The Read and Sign training created in Step 56 appears and the due date is the same as 'Training due by date' noted in step 53.");
			}
		}
		else
		{
			test.log(LogStatus.FAIL,"Unable to Create a new document form.");
		}
		
		logout.logoutFunction();
	}
//=============================================================================================================================================================	
	
	@AfterClass(alwaysRun=true)
	public void closeBrowserInstance()
	{	
		extent.endTest(test);
		driver.quit();
	}
	
	private boolean selectDocForApprovel(String docName) 
	{
		isRecordFound=false;
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getcollapseDocumentstableCells(5);				
		for (int i=0;i<tableCells.size();i++)
		{
			if (tableCells.get(i).getText().equalsIgnoreCase(routeData[1][1]+docName))
			{													
				tableCells.get(i).click();
				isRecordFound=true;
				break;
			}
		}
		return isRecordFound;
	}
	
	private boolean selectDocForTraining(String docName) 
	{
		isRecordFound=false;
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getTrainingItemCells(2);				
		for (int i=0;i<tableCells.size();i++)
		{
			if (tableCells.get(i).getText().contains(docName))
			{													
				tableCells.get(i).click();
				isRecordFound=true;
				break;
			}
		}
		return isRecordFound;
	}
	
	private boolean selectTrainingItemDoc(String docName) 
	{
		isRecordFound=false;
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getTrainingItemDoc(2);				
		for (int i=0;i<tableCells.size();i++)
		{
			if (tableCells.get(i).getText().contains(docName))
			{													
				tableCells.get(i).click();
				isRecordFound=true;
				break;
			}
		}
		return isRecordFound;
	}
	
	private String getDueOnDateTrainingDoc(String docName) 
	{
		String date="";
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getTrainingItemCells(2);				
		for (int i=0;i<tableCells.size();i++)
		{
			if (tableCells.get(i).getText().contains(docName))
			{	
				tableCells.get(i).click();
				int k = i+1;
				WebElement dateDetails = driver.findElement(By.xpath("//div[@data-t21-ajax-id='training-item-list']//tr["+k+"]/td[6]"));
				date=dateDetails.getText();
				break;
			}
		}
		return date;
	}
	
	
	private boolean getTrainingCompletedItem(String docName) 
	{
		isRecordFound=false;
		searchTable=new Table(driver);
		List<WebElement> tableCells=searchTable.getTrainingCompletedItemCell(2);				
		for (int i=0;i<tableCells.size();i++)
		{
			if (tableCells.get(i).getText().contains(docName))
			{													
				tableCells.get(i).click();
				isRecordFound=true;
				break;
			}
		}
		return isRecordFound;
	}
	
	private void approveDocFromWizard(String docName)
	{
		readSign.wizard_Option().click();
		readSign.approval_Tab().click();
		sleep(2);
		readSign.approvalFilter_TextBox().sendKeys(documetNo);
		sleep(2);
		readSign.approvalFilterGo_Button().click();
		sleep(2);
		
		isRecordFound = false;
		for(int i=1; i<=20; i++)
		{
			 selectDocForApprovel(docName);
			 if(!isRecordFound)
			 {
				// verticalScrollingDown();
				 readSign.documentTableNext_Button().click();
		 		 sleep(2); 
			 }
			 else
			 {
				 break;
			 }
		}
		sleep(2);
		readSign.documentTab_ForApprover().click();
		sleep(2);
		readSign.documentApprove_Button().click();
		sleep(2);
		readSign.pinTo_Approve().clear();
		readSign.pinTo_Approve().sendKeys(routeData[1][12]);
		readSign.checkInRouteSubmit_Button().click();
		sleep(4);
	}
}
