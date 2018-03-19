package org.title21.Documents_POM;
//import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.title21.dao.AdminData;
import org.title21.validation.entities.ErrorMessages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.title21.dao.AdminData;

public class CreateDocument_POM 

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
	
	@FindBy(xpath=".//*[@id='New']/a")
	WebElement newdoc;
	
	@FindBy(xpath=".//*[@id='Layer_1']")
	WebElement document;
	
	@FindBy(xpath=".//*[@id='Location']")
	WebElement location;
	
	@FindBy(xpath=".//*[@id='lock']/a[1]")
	WebElement EditModeOff;
	
	
	@FindBy(xpath=".//*[@id='Cabinet']")
	WebElement Cabinet;
	
	@FindBy(css="#CabinetSection")
	WebElement Section;
	

	@FindBy(css=".form-control.t21-placeholder.valid")
	WebElement search;
	
	@FindBy(css=".t21-inline-block")
	WebElement documentcreationverify;
	
	
	@FindBy(css="#DocCheckOutTo")
	WebElement AutoCheck;
	
	@FindBy(css="#DocumentTitle")
	WebElement DocumentTitle;
	
	@FindBy(xpath="//span[contains(@class,'field-validation-error') and contains(@data-valmsg-for,'DocumentTitle')]")
    WebElement DocumentTitlemsg;
	
	@FindBy(xpath="//span[contains(@class,'field-validation-error') and contains(@data-valmsg-for,'DocAppendix')]")
    WebElement appedixvalmsg;
	
	
	@FindBy(xpath="//span[contains(@class,'field-validation-error') and contains(@data-valmsg-for,'DocChangeSummary')]")
	 WebElement Documentsummarymsg;
	

	@FindBy(xpath="//span[contains(@class,'field-validation-error') and contains(@data-valmsg-for,'AttachmentFile')]")
	 WebElement UploadSizemsg;
	
	@FindBy(css="#DocChangeSummary")
	WebElement DocChangeSummary;
	
	@FindBy(css=".btn.t21-btn-primary.t21-ajax-submit-button.process-btn-click")
	WebElement ConfirmButtonm;
	
	@FindBy(xpath=".//*[@id='documentId']")
	WebElement documentnumber;
	
	@FindBy(css=".btn.btn-default.fa.fa-pencil.t21-ajax-link")
	WebElement editdocumentNO;
	
	
	@FindBy(xpath=".//*[@id='NavMyDocs']/a")
	WebElement MyDoc;
	
	@FindBy(css="#DocCounter")
	WebElement Number;

	@FindBy(css=".btn.btn-default.t21-ajax-link")
	WebElement EditModeON;
	
	@FindBy(css="#DocAppendix")
	WebElement Appendix;

	
	@FindBy(css=".btn.btn-default.fa.fa-plus-circle.t21-ajax-link")
	WebElement PlusButtonuploadfile;
	
	@FindBy(xpath=".//*[@id='AttachmentFile']")
	WebElement Brouse;
	
	@FindBy(xpath="//button[contains(@class,'btn t21-btn-primary t21-ajax-submit-button')]")
	WebElement AddButtonupload;
	
	@FindBy(css=".btn.t21-btn-default.pull-left")
	WebElement Cancel;
	
	@FindBy(xpath=".//*[@id='lock']")
	WebElement editmodedisable;
	
	@FindBy(linkText="PDF")
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
	
	@FindBy(xpath=".//*[@id='displaySel']/div[1]/div[3]/div/a/span[2]")//.//*[@id='displaySel']/div[1]/div[3]/div/a/span[2]
	WebElement contextmenu;	
	
	@FindBy(css=".btn.t21-btn-primary.t21-ajax-submit-button")
	WebElement checkinbuttonwindow;	
	
	@FindBy(css=".fa.fa-level-down.grid-button-icon")
	WebElement checkoutbutton;	
	
	@FindBy(css="#OpenOnCheckOut")
	WebElement checkbox;
	
	@FindBy(xpath=".//*[@id='t21-workarea']/div/div/div[1]/div[1]/div[2]/div[3]/table/tbody/tr[1]/td[1]/a")
	WebElement createddoc;
	
	@FindBy(xpath=".//*[@id='default-modal']/div/form/div/div[2]/div/div/div[2]/div[2]/div[2]/div/div/span[1]/button")
	WebElement goButton;
	
	@FindBy(css=".btn.t21-btn-primary.t21-ajax-submit-button.process-btn-click")
	WebElement checkoutconfirm;
	
	@FindBy(css=".col-lg-12.col-md-12.col-sm-12.col-xs-12.t21-padding-top")
	WebElement clickaftercheckin;
	
	@FindBy(xpath=".//*[@id='dialog-form']/div/div/div[1]/button")
	WebElement checkincancelSucesswindow;
	
	@FindBy(css=".t21-no-bold")
	WebElement checkoutversion;
	
	@FindBy(xpath=".//*[@id='default-modal']/div/form/div/div[2]/div/div/div[2]/div[3]/div/div/div/table/tbody/tr/td[1]/a")
	WebElement selectType;
	
	@FindBy(xpath=".//*[@id='DocumentTitle']")
	WebElement docTitle;
	
	@FindBy(xpath=".//*[@id='displaySel']/div/p")
	WebElement permissionMessage;
	
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
	
	public WebElement getMyDocs()
	{
		
		return MyDoc;			
	}
	public WebElement getDocChangeSummary()
	{		
		return DocChangeSummary;			
	}
	
	public WebElement getEditModeOff()
	{		
		return EditModeOff;			
	}
	
	public WebElement GeteditdocumentNo()
	{
		return editdocumentNO;			
	}
	
	public WebElement getnewdoc()
	{
		return newdoc;			
	}
	
	public WebElement getGoButton()
	{
		return goButton;			
	}
	
	public WebElement getDocumentTitlemsg()
	{		
		return DocumentTitlemsg;			
	}
	
	public WebElement getDocumentsummarymsg()
	{
		return Documentsummarymsg;			
	}
	
	public WebElement getappedixvalmsg()
	{
		return appedixvalmsg;			
	}
	
	public WebElement getUploadsizemsg()
	{
		return UploadSizemsg;			
	}
	
	public WebElement getSearchText()
	{		
		return search;			
	}

	public WebElement selectType()
	{

		return selectType;			
	}
	
	public WebElement getDocTitle()
	{

		return docTitle;			
	}
	
	
	
public boolean DocumentTitlemsgvalidation(){
		
		element=getDocumentTitlemsg();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;		
		
		if(errorMessage.contains(ErrorMessages.DocumentTitleValidationMessage))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Validation message for documet  title is not valid.");
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

public boolean UploadFileSizeValidation(){
	
	element=UploadSizemsg;
	String errorMessage = element.getText();
	boolean isValidationMessagePresent=false;		
	
	if(errorMessage.contains(ErrorMessages.FileSizeuploadValidationMessage))
	{
		isValidationMessagePresent=true;
	}else{
		log.error("Validation message for file size is not valid");
	}	
	return isValidationMessagePresent;
}
	

public WebElement getdocument()
{
	
	return document;			
}
	
	public WebElement getPlusButtonuploadfile()
	{
		
		return PlusButtonuploadfile;			
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
	

	public WebElement getPermissionMessage()
	{		
		return permissionMessage;			
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
	
	}