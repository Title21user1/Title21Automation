package org.title21.PeriodicReviewers_POM;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ActionsRequiredByDocOwner_POM extends PeriodicNotOwnedDocuments_POM{
	public WebDriver driver;
	public WebElement element;
	
	static Logger log = Logger.getLogger(ActionsRequiredByDocOwner_POM.class);
	
	public ActionsRequiredByDocOwner_POM(WebDriver driver)
	{
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css=".dropdown-toggle.t21-nav-bar-dropdown")
	 WebElement administratordropdown;

	@FindBy(xpath="//a[contains(@href, 'Administration')]")
	 WebElement administrationlink;

	@FindBy(css=".t21-grid-header-style")
	WebElement administrationtext;
	 
	@FindBy(xpath=".//a[contains(@href,'Administration/GetDocumentTypeList')]")
	WebElement DocumentTypes;
	
	@FindBy(xpath=".//select[contains(@name,'EventType')]")
	WebElement EventType;
	
	@FindBy(css=".form-control.t21-ajax-submit-select#GridLocation")
	WebElement EventLocation;
	
	@FindBy(css=".//select[contains(@name,'EventType')]")
	List<WebElement> EventType1 ;
	
	
	
	@FindBy(xpath=".//input[contains(@name,'FilterValue')]")
	WebElement FilterResults;
	
	@FindBy(xpath=".//button[contains(@type,'submit') and contains(@tabindex,'1')]")
	WebElement GoButton;
	
	@FindBy(css=".t21-ajax-submit-button.form-control.form-inline.btn.t21-btn-default")
	WebElement GoBtn;

	
	@FindBy(xpath=".//button[contains(@name,'clear')]")
	WebElement ClearButton;
	
	@FindBy(css="#t21-workarea :nth-child(2).col-lg-9.col-md-12.col-sm-12.col-xs-12 table tbody tr:nth-child(1) td.pull-right a:nth-child(3) span")
	WebElement ANTFORMEditButton;
	
	@FindBy(xpath=".//a[contains(@href,'/DocumentType/Update?prefix=ANT-SOP&eventType') ]")
	WebElement ANTSOPEditButton;
	
	@FindBy(css="#Location.form-control")
	WebElement Location;
	
	@FindBy(css="#Description.form-control")
	WebElement Description;
	
	@FindBy(css="#default-modal div form div.modal-body div:nth-child(5) div.panel-heading.clickable-panel h5")
	WebElement DocumentType;
	
	@FindBy(css=".col-md-4.t21-padding-right-30")
	WebElement DocNo;
	
	@FindBy(css=".form-control#DefaultTemplate")
	WebElement Template;
	
	@FindBy(css="#default-modal div form div.modal-body div:nth-child(7) div.panel-heading.clickable-panel h5")
	WebElement PeriodicReviews;
	
	@FindBy(css="#PeriodicRvwNotReqdByDocAuthOnNoChange")
	WebElement PeriodicReviewsCheckBox1;
	
	@FindBy(css="#PeriodicRvwNotReqdByDocAuthOnChange")
	WebElement PeriodicReviewsCheckBox2;

	@FindBy(css=".btn.t21-btn-primary.t21-ajax-submit-button")
	WebElement ConfirmButton;
	
	@FindBy(css=".btn.t21-btn-default.pull-left")
	WebElement CancelButton;
	
	@FindBy(xpath=".//a[contains(@href,'DocumentType/Add')]")
	WebElement AddNewDocument;
	
	@FindBy(css="#Prefix.form-control")
	WebElement PreFix;
	
	@FindBy(css="#default-modal form .modal-header button")
	WebElement CloseWindow;
	
	@FindBy(css=".fa.fa-file-o")
	WebElement CreateDocument;
	
	@FindBy(css="#Layer_1")
	WebElement Document;
     
	@FindBy(xpath=".//input[contains(@name,'ValueOfBasicFilter')]")
	WebElement search;
	
	@FindBy(xpath=".//*[@id='Cabinet']")
	WebElement Cabinet;

	@FindBy(css="#CabinetSection")
	WebElement Section;
	
	@FindBy(css=".form-control.valid#DocCheckOutTo")
	WebElement AutoCheckOutTo;
	
	@FindBy(css="#DocumentTitle")
	WebElement DocumentTitle;
	
	@FindBy(css="#DocChangeSummary")
	WebElement DocumentSummary;
	
	@FindBy(css="#Approval > a")
	WebElement Approval;
	
	@FindBy(css="#Dashboard > a > span")
	WebElement dashboard;
	
	@FindBy(css="#t21-workarea .row .col-md-3.col-sm-12.col-xs-12 :nth-child(2) :nth-child(3) table tbody tr:nth-child(1) > td.t21-js-dashboard-row-link.t21-desc-ellipsis-info > a")
	WebElement EffectiveDoc;
	
	@FindBy(css=".t21-ajax-link.t21-btn-primary.btn")
	WebElement viewdocument;
	
	@FindBy(css=".btn-group a.btn.btn-danger.t21-ajax-link")
	WebElement changeBTN;
	
	@FindBy(css="#tab-strip .btn-group a.btn.btn-success.t21-ajax-link")
	WebElement dontchangeBTN;
	
	@FindBy(css="#Review > a")
	WebElement reviewTab;
	
	@FindBy(xpath="//*[@id='Comments']")
	WebElement approveCommentTextBox;
	
	@FindBy(css=".day.today")
	WebElement pickCurrentDate;
	
	public WebElement pickCurrent_Date()
	{
		return pickCurrentDate;
	}
	
	public WebElement approveComment_TextBox()
	{
		return approveCommentTextBox;
	}
	
	 public WebElement administratorDropDown()
	 {
		 return administratordropdown;
		
	 }
	 public WebElement administrationLink()
	 {
		 return administrationlink;
		 
	 }
	 public WebElement administrationText()
	 {
		 return administrationtext; 
		
	 }
	 public WebElement getDashboard()
	 {
		 return dashboard; 
		
	 }
	 public WebElement getEffectiveDOC()
	 {
		 return EffectiveDoc; 
		
	 }
	 
    public WebElement DocumentTypes()
   {

	return DocumentTypes;			
  }
    public Select getEventType()
	{		
		Select selectObj=new Select(EventType);
		return selectObj;		
	}
    public Select getEventLocation()
	{		
		Select selectObj=new Select(EventLocation);
		return selectObj;		
	}
   
    public WebElement getFilterResults()
    {

 	return FilterResults;			
   }
    public WebElement getGoButton()
    {
 	return GoButton;			
   }
    
    public WebElement getClearButton()
    {
    return ClearButton;			
   }
    public WebElement getANTFORMEditButton()
    {

 	return ANTFORMEditButton;			
   }
    public WebElement getANTSOPEditButton()
    {

 	return ANTSOPEditButton;			
   }
    public WebElement getLocation()
    {
    return Location;			
   }
    
    public WebElement getDescription()
    {
    return Description;			
   }
    
    public WebElement getDocumentType()
    {
    return DocumentType;			
   }
   
    
    public WebElement getDocNo()
    {
    return DocNo;			
   }
    public WebElement getTemplate()
    {
    return Template;			
   }
    
    public WebElement getPeriodicReviews()
    {
    return PeriodicReviews;			
   }
    public WebElement getPeriodicReviewsCheckBox1()
    {
    return PeriodicReviewsCheckBox1;			
   }
    public void verifyPeriodicReviewsCheckBox1(Boolean check)
	{
		if (!check && getPeriodicReviewsCheckBox1().isSelected()) {
			getPeriodicReviewsCheckBox1().click();
		}
		else if (check && !getPeriodicReviewsCheckBox1().isSelected()) {
			getPeriodicReviewsCheckBox1().click();
		}
	}
    public WebElement getPeriodicReviewsCheckBox2()
    {
    return PeriodicReviewsCheckBox2;			
   }
   
	public void verifyPeriodicReviewsCheckBox2(Boolean check)
   	{
   		if (!check && getPeriodicReviewsCheckBox2().isSelected()) {
   			getPeriodicReviewsCheckBox2().click();
   		}
   		else if (check && !getPeriodicReviewsCheckBox2().isSelected()) {
   			getPeriodicReviewsCheckBox2().click();
   		}
   	}
    public WebElement getConfirmButton()
    {
 	return ConfirmButton;			
   }
    
    public WebElement getCancelButton()
    {
 	return CancelButton;			
   }
    public WebElement getAddNewDocument()
    {
 	return AddNewDocument;			
   }
    public WebElement getPreFix()
    {
 	return PreFix;			
   }
    public WebElement getCloseWindow()
    {
 	return CloseWindow;			
   }

    public WebElement getCreateDocument()
    {
 	return CreateDocument;			
   }
    public WebElement getDocument()
    {
 	return Document;			
   }
    public WebElement getSearch()
    {
 	return search;			
   }
    public WebElement getGoBtn()
    {
 	return GoBtn;			
   }
    
    public Select getCabinet()
   	{		
   		Select selectObj=new Select(Cabinet);
   		return selectObj;		
   	}
    public Select getSection()
   	{		
   		Select selectObj=new Select(Section);
   		return selectObj;		
   	}
    public Select getAutoCheckOutTo()
   	{		
   		Select selectObj=new Select(AutoCheckOutTo);
   		return selectObj;		
   	}
    public WebElement getDocumenttitle()
    {
 	return DocumentTitle;			
   }
    public WebElement getDocumentsummary()
    {
 	return DocumentSummary;			
   }
    public WebElement getApproval()
    {
 	return Approval;			
   }
    public WebElement getViewDocument()
    {
 	return viewdocument;			
   }
    
    public WebElement getchangeBTN()
    {
 	return changeBTN;			
   }
    public WebElement getdontchangeBTN()
    {
 	return dontchangeBTN;			
   }
    public WebElement getreviewTab()
    {
 	return reviewTab;			
   }
   
   }