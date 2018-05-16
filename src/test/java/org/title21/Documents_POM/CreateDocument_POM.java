package org.title21.Documents_POM;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Random;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.title21.dao.AdminData;
import org.title21.utility.BaseClass;
import org.title21.validation.entities.ErrorMessages;

public class CreateDocument_POM 
//
{
	public WebDriver driver;
	public WebElement element;
	AdminData adminData=new AdminData();
	static Logger log = Logger.getLogger(CreateDocument_POM.class);

	public CreateDocument_POM (WebDriver driver) 
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//*[@id='New']/a")
	WebElement newdoc;

	@FindBy(xpath="//*[@id='Layer_1']")
	WebElement document;

	@FindBy(xpath=".//*[@id='Location']")
	WebElement location;

	@FindBy(xpath=".//*[@id='Cabinet']")
	WebElement Cabinet;

	@FindBy(css="#CabinetSection")
	WebElement Section;

	@FindBy(xpath="//div[@class='input-group']//input[@class='form-control t21-placeholder']")
	WebElement search;

	@FindBy(css=".t21-ajax-submit-button.form-control.form-inline.btn.t21-btn-default")
	WebElement goButton;

	@FindBy(css=".t21-inline-block")
	WebElement documentcreationverify;

	@FindBy(css="#DocCheckOutTo")
	WebElement AutoCheck;

	/*@FindBy(css="#DocumentTitle")
	WebElement DocumentTitle;
*/
	@FindBy(xpath="//*[@id='DocumentTitle']")
	WebElement DocumentTitle;
	
	@FindBy(xpath="//span[contains(@class,'field-validation-error') and contains(@data-valmsg-for,'DocumentTitle')]")
	WebElement DocumentTitlemsg;

	@FindBy(xpath="//span[contains(@class,'field-validation-error') and contains(@data-valmsg-for,'DocAppendix')]")
	WebElement appedixvalmsg;

	@FindBy(xpath="//span[contains(@class,'field-validation-error') and contains(@data-valmsg-for,'DocChangeSummary')]")
	WebElement Documentsummarymsg;

	@FindBy(css="#DocChangeSummary")
	WebElement DocChangeSummary;

	@FindBy(xpath="//input[@name='submitButton']")
	WebElement ConfirmButtonm;

	@FindBy(xpath=".//*[@id='documentId']")
	WebElement documentnumber;

	@FindBy(css=".btn.btn-default.fa.fa-pencil.t21-ajax-link")
	WebElement editdocumentNO;

	@FindBy(css="#DocCounter")
	WebElement Number;

	@FindBy(css="#DocAppendix")
	WebElement Appendix;

	@FindBy(css=".btn.t21-btn-default.pull-left")
	WebElement Cancel;

	@FindBy(css="#documentId")
	WebElement createdDocID;

	@FindBy(xpath="//input[@id='DocumentTitle']")
	WebElement docTitle;

	@FindBy(xpath="//a[contains(@href,'UpdateCabinetListDropDownNewFormModal')]")
	WebElement selectType;

	@FindBy(xpath="//p[contains(text(),'permissions to edit')]")
	WebElement permissionMessage;

	@FindBy(xpath="//span[contains(@class,'field-validation-error') and contains(@data-valmsg-for,'AttachmentFile')]")
	WebElement UploadSizemsg;

	@FindBy(xpath=".//*[@id='lock']/a[1]")
	WebElement EditModeOff;

	@FindBy(xpath=".//*[@id='NavMyDocs']/a")
	WebElement MyDoc;

	@FindBy(css=".btn.btn-default.t21-ajax-link")
	WebElement EditModeON;

	@FindBy(css=".btn.btn-default.fa.fa-plus-circle.t21-ajax-link")
	WebElement PlusButtonuploadfile;

	@FindBy(xpath=".//*[@id='AttachmentFile']")
	WebElement Brouse;

	@FindBy(xpath="//button[contains(@class,'btn t21-btn-primary t21-ajax-submit-button')]")
	WebElement AddButtonupload;


	@FindBy(xpath=".//*[@id='lock']")
	WebElement editmodedisable;

	@FindBy(xpath="//a[contains(text(),'PDF')]")
	WebElement pdf;

	@FindBy(linkText="Native")
	WebElement nativeafile;

	@FindBy(css="")
	WebElement checkinwindowclose;

	@FindBy(css=".t21-js-user-message-text")
	WebElement checkinwindowsuccessmsg;

	@FindBy(css=".modal-title")
	WebElement poupcheckin;

	@FindBy(css=".modal-title")
	WebElement uploadpopuptitle;

	@FindBy(css=".fa.fa-level-up.grid-button-icon")
	WebElement checkin;

	@FindBy(css=".//*[@id='set-1']/div/a")
	WebElement checkouttome;

	@FindBy(css=".btn.t21-btn-default")
	WebElement checkoutsuccessclose;

	@FindBy(xpath=".//*[@id='lock']/a[1]")
	WebElement EditModeoffDisable;

	//@FindBy(xpath=".//*[@id='displaySel']/div[1]/div[3]/div/a/span[2]")
	//WebElement contextmenu;

	@FindBy(xpath="//*[@id='displaySel']//a[@title='Context Menu']")
	WebElement contextmenu;

	@FindBy(css=".btn.t21-btn-primary.t21-ajax-submit-button")
	WebElement checkinbuttonwindow;

	@FindBy(css=".fa.fa-level-down.grid-button-icon")
	WebElement checkoutbutton;

	@FindBy(css="#OpenOnCheckOut")
	WebElement checkbox;

	@FindBy(xpath=".//*[@id='t21-workarea']/div/div/div[1]/div[1]/div[2]/div[3]/table/tbody/tr[1]/td[1]/a")
	WebElement createddoc;

	@FindBy(css=".btn.t21-btn-primary.t21-ajax-submit-button.process-btn-click")
	WebElement checkoutconfirm;

	@FindBy(css=".col-lg-12.col-md-12.col-sm-12.col-xs-12.t21-padding-top")
	WebElement clickaftercheckin;

	@FindBy(xpath=".//*[@id='dialog-form']/div/div/div[1]/button")
	WebElement checkincancelSucesswindow;

	@FindBy(css=".t21-no-bold")
	WebElement checkoutversion;

	@FindBy(xpath="//a[contains(@href,'AddReviewerModal')]")
	WebElement editperiodicreviewer;

	@FindBy(xpath="//input[@name='submitButton']")
	WebElement saveButton;

	@FindBy(xpath="//a[contains(@href,'AddAttachmentModal')]")
	WebElement addattachment;

	@FindBy(xpath="//*[@id='default-modal']//button[@type='submit']")
	WebElement addbutton;

	@FindBy(xpath="//a[contains(@href,'LinksModal')]")
	WebElement addnewlinks;

	@FindBy(xpath="//input[@name='formIdOfLinksToAdd']")
	WebElement linkstoadd;
	
	@FindBy(css = ".t21-js-row-link.text-nowrap>a")
	List<WebElement> documenttype;

	@FindBy(xpath="//input[@name='searchString']")
	WebElement addlinksearch;

	@FindBy(xpath=".//*[@id='default-modal']//button[@class='t21-ajax-submit-button form-control form-inline btn t21-btn-default']")
	WebElement addlinkgobutton;
	
	@FindBy(xpath="//span[@class='t21-no-bold']")
	WebElement getcreateddocumentnumber;

	public WebElement getDocTitle()
	{

		return docTitle;			
	}

	public WebElement selectType()
	{

		return selectType;			
	}

	public WebElement getDocumentTitle()
	{
		return DocumentTitle;			
	}

	public WebElement getdocumentcreationverify()
	{

		return documentcreationverify;			
	}

	public WebElement getdocumentnumber()
	{
		return documentnumber;			
	}


	public WebElement getDocChangeSummary()
	{
		return DocChangeSummary;			
	}

	public WebElement GeteditdocumentNO()
	{
		return editdocumentNO;			
	}

	public WebElement getGoButton()
	{
		return goButton;			
	}

	public WebElement getDocumentTitlemsg()
	{

		return DocumentTitlemsg;			
	}

	public WebElement getappedixvalmsg()
	{
		return appedixvalmsg;			
	}

	public WebElement getCreatedDocID()
	{		
		return createdDocID;			
	}

	public WebElement getPermissionMessage()
	{		
		return permissionMessage;			
	}

	public WebElement getSearchText()
	{		
		return search;			
	}

	public WebElement editPeriodicReviewer()
	{		
		return editperiodicreviewer;			
	}

	public WebElement saveButton()
	{		
		return saveButton;			
	}

	public WebElement addAttachment()
	{		
		return addattachment;			
	}

	public WebElement addButton()
	{		
		return addbutton;			
	}

	public WebElement addNewLinks()
	{		
		return addnewlinks;			
	}

	public WebElement selectLinkToAdd()
	{
		return linkstoadd;
	}

	public WebElement addLinkSearch()
	{
		return addlinksearch;
	}

	public WebElement addLinkGoButton()
	{
		return addlinkgobutton;
	}

	
	public WebElement getdocument()
	{

		return document;			
	}
	public Select getAutoCheck()
	{		
		Select selectObj=new Select(AutoCheck);
		return selectObj;		
	}
	public Select getSection()
	{		
		Select selectObj=new Select(Section);
		return selectObj;		
	}


	public Select getlocationDrodown()
	{		
		Select selectObj=new Select(location);
		return selectObj;		
	}


	public Select getcabinet()
	{		
		Select selectObj=new Select(Cabinet);
		return selectObj;		
	}


	public Select getnumberappedix()
	{		
		Select selectObj=new Select(Number);
		return selectObj;		
	}


	public WebElement getConfirmButton()
	{

		return ConfirmButtonm;			
	}
	public WebElement Appendix()
	{

		return Appendix;			
	}	

	public boolean permissionToEditMessage(){

		element=getPermissionMessage();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;

		if(errorMessage.contains(ErrorMessages.permissionToEdit))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Validation message for Permission is not present.");
		}	
		return isValidationMessagePresent;
	}

	public WebElement getcreateddoc()
	{

		return createddoc;			
	}

	public WebElement EditModeoffDisable()
	{

		return EditModeoffDisable;			
	}

	public WebElement checkoutsuccesswindowclose()
	{

		return checkoutsuccessclose;			
	}

	public WebElement getnewdoc()
	{
		return newdoc;			

	}
	public WebElement getpoupcheckin()
	{

		return poupcheckin;			
	}

	public WebElement  editmodedisable()
	{

		return  editmodedisable;			
	}

	public WebElement getclickaftercheckin()
	{

		return clickaftercheckin;			
	}

	public WebElement getcheckinbuttonwindow()
	{
		return checkinbuttonwindow;	

	}

	public WebElement getcheckoutconfirm()
	{

		return checkoutconfirm;			
	}

	public WebElement getDocumentsummarymsg()
	{
		return Documentsummarymsg;			
	}

	/*public WebElement getappedixvalmsg()
	{
		return appedixvalmsg;		
	}*/
	public WebElement getcheckboxcheckout()
	{

		return checkbox;			
	}

	public WebElement checkoutvesionval()
	{

		return checkoutversion;			
	}

	public WebElement getcheckouttome()
	{

		return checkouttome;			

	}


	public WebElement getcheckoutbutton()
	{
		return checkoutbutton;

	}

	public WebElement getcheckincancelsuccess()
	{

		return checkincancelSucesswindow;			
	}

	public WebElement getcheckinwindowclose()
	{

		return checkinwindowclose;			
	}
	public WebElement getcheckinwindowsuccessmsg()
	{

		return checkinwindowsuccessmsg;			
	}

	public WebElement getcheckin()
	{

		return checkin;	//.//*[@id='displaySel']/div[1]/div[3]/div/ul/li[12]/div/a/span[2]		
	}

	public WebElement getEditModeON()
	{

		return EditModeON;			
	}

	public WebElement getcontextmenu()
	{

		return contextmenu;			
	}

	public WebElement getpdf()
	{

		return pdf;			
	}

	public WebElement getnative()
	{

		return nativeafile;			
	}
	public List<WebElement> docType() {
		return documenttype;
	}

	public WebElement getCancel()
	{
		return Cancel;			
	}
	public WebElement getuploadpopuptitle()
	{

		return uploadpopuptitle;			
	}

	public WebElement getAddButtonupload()
	{

		return AddButtonupload;			
	}


	public WebElement getBrouse()
	{

		return Brouse;			
	}

	public WebElement getMyDocs()
	{

		return MyDoc;			
	}

	public WebElement getEditModeOff()
	{

		return EditModeOff;			
	}

	public WebElement GeteditdocumentNo()
	{

		return editdocumentNO;			
	}

	public WebElement getPlusButtonuploadfile()
	{

		return PlusButtonuploadfile;
	}
	
	public WebElement getCreatedDocnumber()
	{

		return getcreateddocumentnumber;			
	}
	
	public void pressEscape()
	{
		Robot robot;
		try {
			robot = new Robot();
			robot.keyPress(KeyEvent.VK_ESCAPE);
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
	
	public void Search(String search)
	{
		getSearchText().sendKeys(search);
		BaseClass.sleep(1);
		getGoButton().click();
	}
	
	public void selectDocumentType(String DocType)
	{
		WebElement element = driver.findElement(By.xpath("//a[contains(text(),'"+DocType+"')]"));
		element.click();
	}
	public boolean DocumentTitlemsgvalidation(){

		element=getDocumentTitlemsg();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;		

		if(errorMessage.contains(ErrorMessages.DocumentTitleValidationMessage))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Validation message for document title is not valid.");
		}	
		return isValidationMessagePresent;
	}

	public boolean Appedixvalidation(){

		element=getappedixvalmsg();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;		

		if(errorMessage.contains(ErrorMessages.AppendixValidationMessage))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Validation message for Appendix is not valid.");
		}	
		return isValidationMessagePresent;
	}
	public boolean Documentsummarymsgvalidation(){

		element=getDocumentsummarymsg();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;		

		if(errorMessage.contains(ErrorMessages.DocumentSummaryValidationMessage))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Validation message for Document summary is not valid  ");
		}	
		return isValidationMessagePresent;
	}


	public boolean CheckinSuccessmessage(){

		element=getcheckinwindowsuccessmsg();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;		

		if(errorMessage.contains(ErrorMessages.checkedsuccessfullyMessage))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Validation message for check in is not valid.");
		}	
		return isValidationMessagePresent;
	}

	public boolean checkoutversionvalidation(){

		element=checkoutvesionval();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;		

		if(errorMessage.contains("0.1"))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Version not chnages after Checkout.");
		}	
		return isValidationMessagePresent;
	}

	public boolean UploadFileSizeValidation(){

		element=UploadSizemsg;
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;		

		if(errorMessage.contains(ErrorMessages.FileSizeuploadValidationMessage))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Validation message for file size is not valid  ");
		}	
		return isValidationMessagePresent;
	}
	
	public void fileupload(String uploadFileName) {

		String fileUploadPath = System.getProperty("user.dir") + "\\testdata";
		fileUploadPath = fileUploadPath + "\\" + uploadFileName;
		getBrouse().sendKeys(fileUploadPath);
		BaseClass.sleep(3);
		getAddButtonupload().click();
	}

	public String ValueFromAppendix()
	{		
		//	Select selectObj=new Select(Number);
		List allOptions =  getnumberappedix().getOptions();
		Random rand = new Random();
		int randomElement = (Integer) allOptions.get(rand.nextInt(allOptions.size()));
		System.out.print(randomElement);
		return String.valueOf(randomElement);
	}

	public void selectPeriodicReviewer(String value)
	{

		WebElement element = driver.findElement(By.xpath
				(".//*[@id='bootstrap-duallistbox-nonselected-list_DocRequiredReviewerList[]']//option[@value='"+value+"']"));
		element.click();			 
	}

	public void selectEntities(String value)
	{

		WebElement element = driver.findElement(By.xpath
				("//select[@id='bootstrap-duallistbox-nonselected-list_selectedEmployee']//option[@value='"+value+"']"));
		element.click();			
	}
	
	public void trainingItemsCheck(Boolean check)
	{
		if (!check && getcheckboxcheckout().isSelected()) {
			getcheckboxcheckout().click();
		}
		else if (check && !getcheckboxcheckout().isSelected()) {
			getcheckboxcheckout().click();
		}
	}
}