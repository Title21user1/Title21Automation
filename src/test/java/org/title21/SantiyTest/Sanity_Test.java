package org.title21.SantiyTest;

import org.testng.annotations.Test;
import org.title21.Documents_POM.CreateDocument_POM;
import org.title21.Documents_POM.MyDocs_POM;
import org.title21.POM.AdministrationPage_POM;
import org.title21.POM.LoginPage_POM;
import org.title21.POM.LogoutPage_POM;
import org.title21.POM.eBinders_POM;
import org.title21.utility.BaseClass;
import org.title21.utility.FunctionUtils;

import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.AfterClass;

public class Sanity_Test extends BaseClass
{
	LoginPage_POM login; 
	LogoutPage_POM logout;
	CreateDocument_POM createdoc;
	MyDocs_POM mydocs;
	eBinders_POM ebinder;
	AdministrationPage_POM adminpage;
	String className="";
	String docID="";
	String docTitle="Sanity Test "+FunctionUtils.generateFourRandomNumber();
	
	
	@BeforeClass
	public void beforeClass()
	{
		getBrowser();
		className = this.getClass().getName();
		createDirectory(className);
		login=new LoginPage_POM(driver);
		logout=new LogoutPage_POM(driver);
		createdoc=new CreateDocument_POM(driver);
		mydocs=new MyDocs_POM(driver);
		ebinder=new eBinders_POM(driver);
		adminpage=new AdministrationPage_POM(driver);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	@Test
	public void SanityTest()
	{
		test = extent.startTest("Sanity");
		login.loginUser(loginData[14][0],loginData[14][1]);
		createdoc.getnewdoc().click();												sleep(3);
		createdoc.getdocument().click();											sleep(3);
		createdoc.Search("SOP.CT");													sleep(3);
		createdoc.selectDocumentType("SOP.CT");										sleep(3);
		createdoc.getDocTitle().sendKeys(docTitle);									sleep(2);
		createdoc.getDocChangeSummary().sendKeys("Sanity Test Document Summary");	sleep(2);
		docID = createdoc.getdocumentnumber().getAttribute("value");				sleep(2);
		createdoc.getConfirmButton().click();										sleep(3);
		highlightElement(mydocs.createdDocument(docID));							sleep(2);
		
		test.log(LogStatus.PASS,"<b>ER: Document it created <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Document Created")));
		
		mydocs.getMyDocs().click();													sleep(3);
		mydocs.getCheckOutByMe().click();											sleep(2);
		highlightElement(mydocs.selectDocument(docID));								sleep(2);
		
		test.log(LogStatus.PASS,"<b>ER: Document created in step 2 is available <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Document CheckoutToME")));
		
		createdoc.Search(docID);													sleep(2);
		mydocs.getContextMenuInList().click();										sleep(2);
		mydocs.form().click();														sleep(2);
		highlightElement(mydocs.documentFormLayout());								sleep(3);
		
		test.log(LogStatus.PASS,"<b>ER: Document form opens <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Document Form")));
		
		mydocs.getContextMenu().click();											sleep(2);
		verticalScrollingDown();													sleep(1);
		mydocs.undoCheckoutForm().click();											sleep(2);
		mydocs.undoCheckoutYesButton().click();										sleep(3);
		mydocs.getCheckinCloseButton().click();										sleep(2);
		verticalScrollingUp();														sleep(2);
		highlightElement(mydocs.tableBodyLayout());									sleep(2);
		
		test.log(LogStatus.PASS,"<b>ER: Document is removed <b>"+
				test.addScreenCapture(captureScreenShot(driver, "Document Deleted")));
		
		ebinder.getEbinders().click();												sleep(2);
		ebinder.expandEbinder("Lab");
		ebinder.selectEbinder("SOP");												sleep(2);
		highlightElement(ebinder.tableBodyLayout());								sleep(2);
		
		test.log(LogStatus.PASS,"<b>ER: Documents are listed <b>"+
				test.addScreenCapture(captureScreenShot(driver, "eBinders Docs Listed")));
		
		createdoc.Search("");														sleep(2);
		
	}

	@AfterClass
	public void afterClass()
	{
		extent.endTest(test);
		driver.close();
	}
	
	public void preRequisites()
	{
		
	}
}
