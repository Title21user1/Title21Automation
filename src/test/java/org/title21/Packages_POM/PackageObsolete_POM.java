package org.title21.Packages_POM;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.title21.AdminModule_POM.LoginPage_POM;
import org.title21.AdminModule_POM.LogoutPage_POM;
import org.title21.DBConnection.DBConnection;
import org.title21.DBConnection.DBQueries;
import org.title21.Documents_POM.DocumentCollaboration_POM;
import org.title21.Documents_POM.DocumentRoutes_POM;
import org.title21.Documents_POM.RecentlyViewdAndFavorites_POM;
import org.title21.PeriodicReviewers_POM.PeriodicOwnedDocuments_POM;
import org.title21.utility.BaseClass;
import org.title21.utility.DateTimeUtils;

public class PackageObsolete_POM {
	public WebDriver driver;
	public String documetNo = "";
	public WebElement element;
	public String doc_name = "";
	public String fileUploadPath = "";
	public String documet_no_checkout = "";
	public String DocumetNoDelete="";
	
	static Logger log = Logger.getLogger(DocumentCollaboration_POM.class);
	RecentlyViewdAndFavorites_POM RecentlyViewdAndFavorites;

	///test data

	public PackageObsolete_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(css = ".btn.t21-btn-default") // 4 close
	List<WebElement> checkinclose;

	@FindBy(css = ".fa.fa-file-o")
	WebElement Newtab;

	@FindBy(xpath = "//*[@id='displaySel']//a[@title='Context Menu']")
	WebElement contextmenu;

	@FindBy(xpath = ".//*[@id='DocTargetReleaseDateString']")
	WebElement datepicker;

	@FindBy(css = ".panel-body.text-center.t21-new-item-image")
	List<WebElement> packageicon;

	@FindBy(css = "#Cabinet")
	WebElement CabinetDropdown;
	
	//*[@id='']//a[@title='Context Menu']
	
	@FindBy(css = ".form-control.t21-placeholder")
	List<WebElement>  secrhboxFromsearchpackage;
	
	@FindBy(css = ".form-control.t21-no-maxwidth.t21-js-clear-string-validation")
	WebElement textboxsearch;

	@FindBy(css = "#CabinetSection")
	WebElement Section_Dropdown;

	@FindBy(css = ".t21-no-bold")
	List<WebElement> packagecreatedname;
	
	@FindBy(css = "#TravelerName")
	 WebElement Packagename;

	@FindBy(css = ".t21-ajax-link")
	List<WebElement> doconapproved;

	@FindBy(css = ".btn.t21-btn-primary.t21-ajax-submit-button.process-btn-click")
	WebElement Create_Button;

	
	@FindBy(xpath = "//*[@placeholder='Filter results']")
	WebElement placeholderonapproved;

	@FindBy(css = ".fa.fa-level-up.grid-button-icon")
	WebElement checkin;

	@FindBy(css = ".day.today")
	WebElement date;
	
	@FindBy(css = ".t21-js-row-link.event-id>a")
	WebElement Serch_document;

	@FindBy(css = ".t21-ajax-link.t21-add-new-link")
	List<WebElement> Add_remove_link;

	@FindBy(css = ".form-control.t21-placeholder")
	List<WebElement> Search_textbox;

	@FindBy(xpath = "//*[contains(text(),'Go')]")
	WebElement GoButton_Search;

	@FindBy(css = ".btn.t21-btn-primary.t21-ajax-submit-button")
	List<WebElement> OkButton_AttachedDoc;

	@FindBy(css = ".min-column.no-wrap")
	List<WebElement> Attached_Document;

	@FindBy(css = ".fa.fa-trash-o.action-items")
	WebElement Delete;

	@FindBy(css = ".btn.t21-btn-primary.t21-ajax-submit-button.process-btn-click")
     WebElement YesButtonOfDeletePopup;

	@FindBy(css = ".t21-ajax-submit-button.form-control.form-inline.btn.t21-btn-default")
	List<WebElement> go;

	@FindBy(css = ".btn.t21-btn-default") // 6//3 obs_date3
	List<WebElement> CloseButton;

	@FindBy(css = ".fa.fa-caret-down") // 3,4,
	List<WebElement> ContextMenu;

	@FindBy(css = ".btn.t21-btn-primary.t21-ajax-submit-button.process-btn-click")
	List<WebElement> confirm;
	
	@FindBy(css = ".t21-js-row-link.text-nowrap>a")
	List<WebElement> document;
	
	@FindBy(css = ".grid-button-text")
	List<WebElement> obsolet_on;

	@FindBy(css = "#OpenOnCheckOut")
	WebElement checkbox;
	
	@FindBy(css = ".fa.fa-file-text-o")
	WebElement Mydocument;
	
	@FindBy(xpath = "//*[@id='Approval']")
	WebElement approval;
	
	@FindBy(css = ".t21-select-row.t21-js-unlink-item")
	WebElement checkboxonDocumentlist;
	
	@FindBy(css = "#SelectedLocation")
	WebElement locationdropdown ;

	@FindBy(css = ".btn.t21-btn-primary.t21-ajax-submit-button")
	WebElement confirm_button_checkin;

	@FindBy(css = ".fa.fa-file.fa-stack-2x")
	List<WebElement> PackageName;

	@FindBy(css = "#TravObsoleteDateString")
	WebElement Obsolete_Date;
	
	@FindBy(xpath = "//button[text()='Close']")
	WebElement Close_button_Checkin ;

	

	@FindBy(css = ".fa.fa-level-down.grid-button-icon")
	WebElement checkoutbutton;

	@FindBy(xpath = "//button[contains(@class,'btn t21-btn-primary t21-ajax-submit-button')]")
	WebElement AddButtonupload;

	@FindBy(xpath = ".//*[@id='AttachmentFile']")
	WebElement Brouse;

	@FindBy(css = ".btn.t21-btn-primary.t21-ajax-submit-button.process-btn-click")
	WebElement YesButtonObsoluteDatePopup;// raoutes

	@FindBy(xpath = "//*[text()='Approvals']")
	WebElement ApprovalsTab;

	@FindBy(css = ".fa.fa-share.grid-button-icon")
	WebElement RoutesForApprovar;

	@FindBy(css = ".fa.fa-thumbs-o-up.t21-padding-right-5")
	WebElement approve_button;

	
	@FindBy(css = ".btn.btn-default.fa.fa-plus-circle.t21-ajax-link")
	WebElement AddFileButton;

	@FindBy(xpath = ".//*[@id='dialog-form']/div/div/div[1]/button")
	WebElement checkincancelSucesswindow;
	

	@FindBy(xpath="//*[@id='Pin']")
	WebElement pinToApprove;
	
	
	@FindBy(xpath=".//*[@href='/MyDocs/Approval']")
	WebElement ApprovaltabonMydocument;
	
	
	
	@FindBy(xpath=".//*[@id='documentId']")
	WebElement documentnumber;
	
	
	
	public List<WebElement> getdoconapproved() {

		return doconapproved;
	}
	
	public WebElement Close_Button_Checkin() {

		return Close_button_Checkin;
	}

	public WebElement gettextboxsearch()
	{
		return textboxsearch;			
	}
	public WebElement Routeforapproval()
	{
		return RoutesForApprovar;			
	}
	
	public WebElement yesbuttonroutes()
	{
		return YesButtonObsoluteDatePopup;			
	}
	public WebElement getdocumentnumber()
	{
		return documentnumber;			
	}

	public WebElement getpinToApprove() {
		return pinToApprove;

	}
	public WebElement getapprovallinkonmydocument() {
		return ApprovaltabonMydocument;

	}
	public WebElement getcheckoutbutton() {
		return checkoutbutton;

	}
	public WebElement gapprovelink() {
		return approve_button;

	}

	public WebElement getAddFileButton() {
		return AddFileButton;

	}
	public WebElement getSerch_document() {
		return Serch_document;

	}
	public WebElement getMydocument() {
		return Mydocument;

	}

	public WebElement getconfirm_button_checkin() {
		return confirm_button_checkin;

	}

	public Select getlocationdropdown() {
		Select selectObj=new Select(locationdropdown);
		return selectObj;
	}
	public List<WebElement> getpackagecreatedname() {

		return packagecreatedname;
	}
	
	public WebElement getapproval() {

		return ApprovalsTab;
	}

	public WebElement getcheckin() {

		return checkin;
	}

	public WebElement getcheckboxonDocumentlist() {

		return checkboxonDocumentlist;
	}
	public WebElement getNewTab() {

		return Newtab;
	}

	public List<WebElement> getPackageIcon() {

		return packageicon;
	}

	public Select getCabinetDropdown() {
		Select selectObj=new Select(CabinetDropdown);
		return selectObj;
		
	}

	public Select getSection_Dropdown() {
		Select selectObj=new Select(Section_Dropdown);
		return selectObj;
		
	}

	public WebElement getcontextmenu() {

		return contextmenu;
	}

	public WebElement getPackagename() {

		return Packagename;
	}

	public List<WebElement> getAddremovelink() {

		return Add_remove_link;
	}

	public List<WebElement> getSearch_textbox() {

		return Search_textbox;
	}

	public List<WebElement> getAdd_remove_link() {

		return Add_remove_link;
	}

	public WebElement getGoButton_Search() {

		return GoButton_Search;
	}
	public List<WebElement> docType() {
		return document;
	}
	public List<WebElement> getOkButton_AttachedDoc() {

		return OkButton_AttachedDoc;
	}

	public List<WebElement> getAttached_Document() {

		return Attached_Document;
	}

	public WebElement getDelete() {

		return Delete;
	}
	public WebElement getMyDoc() {

		return Mydocument;
	}

	public WebElement getYesButtonOfDeletePopup() {

		return YesButtonOfDeletePopup;
	}

	public WebElement getCreate_Button() {

		return Create_Button;
	}

	public List<WebElement> getCloseButton() {

		return CloseButton;
	}

	public List<WebElement> getContextMenu() {

		return ContextMenu;
	}

	public WebElement getcheckboxcheckout() {

		return checkbox;
	}

	public WebElement getplaceholderonapproved() {

		return placeholderonapproved;
	}

	public 	List<WebElement> getobsolet_on() {

		return obsolet_on;
	}

	public WebElement getObsolete_Date() {

		return Obsolete_Date;
	}

	public WebElement datepicker() {

		return datepicker;
	}

	public List<WebElement> getcheckinclose() {

		return checkinclose;
	}

	public List<WebElement> getconfirm() {

		return confirm;
	}

	public WebElement getcheckincancelsuccess() {

		return checkincancelSucesswindow;
	}

	public WebElement getBrouse() {

		return Brouse;
	}

	public List<WebElement> getGoButton() {

		return go;
	}

	public WebElement gettodaysdate() {

		return date;
	}

	public WebElement getAddButtonupload() {

		return AddButtonupload;
	}

	public void trainingItemsCheck(Boolean check) {
		if (!check && getcheckboxcheckout().isSelected()) {
			getcheckboxcheckout().click();
		} else if (check && !getcheckboxcheckout().isSelected()) {
			getcheckboxcheckout().click();
		}
	}

	
	public void Prerequsite() throws Exception
	{
		DBQueries dbqueries = new DBQueries();
		DBConnection.executeStoredProcedure(dbqueries.disablePermissionProhibitUserAttachingArchivedDoc);
		DBConnection.executeStoredProcedure(dbqueries.disablePermissionProhibitUserAttachingReleasedDoc);
		DBConnection.executeStoredProcedure(dbqueries.PromoteindexCards);
		DBConnection.executeStoredProcedure(dbqueries.AttachingApprovedDoc);
	}
	public void GenerateEffectiveFile(String scenario) throws Exception

	{
		LoginPage_POM login = new LoginPage_POM(driver);
	    DBQueries dbqueries = new DBQueries();
	    DocumentRoutes_POM documentRoutes = new DocumentRoutes_POM(driver);
		LogoutPage_POM logout = new LogoutPage_POM(driver);
		BaseClass BaseClass = new BaseClass();
		PeriodicOwnedDocuments_POM periodicReviews = new PeriodicOwnedDocuments_POM(driver);
		org.title21.utility.BaseClass.sleep(7);
		periodicReviews.getnewdoc().click();
		org.title21.utility.BaseClass.sleep(4);
		BaseClass.waitTillElementVisible(periodicReviews.getdocument());
		periodicReviews.getdocument().click();
        org.title21.utility.BaseClass.sleep(9);
        docType().get(3).click();
		org.title21.utility.BaseClass.sleep(7);
		if(scenario.equalsIgnoreCase("1"))
		{
		documetNo = periodicReviews.document_No().getAttribute("value");
		}
		else
		{
			DocumetNoDelete = periodicReviews.document_No().getAttribute("value");
		}
			
		org.title21.utility.BaseClass.sleep(5);
		periodicReviews.getDocumentTitle().sendKeys("testautomation" + documetNo);
		periodicReviews.getDocChangeSummary().sendKeys("test summary" + documetNo);
		BaseClass.verticalScrollingDown();
		periodicReviews.getConfirmButton().click();
		org.title21.utility.BaseClass.sleep(5);
		org.title21.utility.BaseClass.sleep(5);
		getAddFileButton().click();
		org.title21.utility.BaseClass.sleep(5);
		fileupload("FileToUpload.txt");
		org.title21.utility.BaseClass.sleep(5);
		getcontextmenu().click();
		getcheckin().click();
		org.title21.utility.BaseClass.sleep(3);
		getconfirm_button_checkin().click();
		org.title21.utility.BaseClass.sleep(8);
		Close_Button_Checkin().click();
		org.title21.utility.BaseClass.sleep(8);
		getcontextmenu().click();
		org.title21.utility.BaseClass.sleep(4);
		getcheckoutbutton().click();
		org.title21.utility.BaseClass.sleep(4);
		trainingItemsCheck(true);
		org.title21.utility.BaseClass.sleep(4);
		getconfirm().get(0).click();
		org.title21.utility.BaseClass.sleep(5);
		if (getcheckincancelsuccess().isDisplayed()) {
			getcheckincancelsuccess();
			getcheckincancelsuccess().click();
			getcheckincancelsuccess().click();
		}
		org.title21.utility.BaseClass.sleep(5);
		datepicker().click();
		/*org.title21.utility.BaseClass.sleep(4);
		gettodaysdate().click();*/
		String pickDate = DateTimeUtils.getYesterdayDate();
		String[] preDate = pickDate.split("/");
		String dd1 = preDate[1];
		String dd = dd1;
		if (dd1.contains("0")) {
			dd = dd1.substring(1, 2);
			if (dd.equals("0")) {
				dd = dd1;
			}
		}
		org.title21.utility.BaseClass.sleep(4);
		driver.findElement(By.xpath("//td[text()='" + dd + "']")).click();
		org.title21.utility.BaseClass.sleep(3);
		documentRoutes.getDocumentApprovaltab().click();
		org.title21.utility.BaseClass.sleep(3);
		documentRoutes.getAddApproverLink().click();
		org.title21.utility.BaseClass.sleep(2);
		documentRoutes.getApproverRole().selectByVisibleText("Approver");
		org.title21.utility.BaseClass.sleep(2);
		getlocationdropdown().selectByVisibleText("All");
		org.title21.utility.BaseClass.sleep(2);
		documentRoutes.getnameinAddApprover().selectByVisibleText("Title21User2");
		documentRoutes.getSequenceinAddApprover().selectByVisibleText("1");
		documentRoutes.getallottedDaysinAddApprover().selectByVisibleText("1 day");
		documentRoutes.approverAdd_Button().click();
		org.title21.utility.BaseClass.sleep(8);
		getcontextmenu().click();
		org.title21.utility.BaseClass.sleep(7);
		BaseClass.verticalScrollingDown();
		org.title21.utility.BaseClass.sleep(5);
		documentRoutes.checkIn_Route().click();
		org.title21.utility.BaseClass.sleep(5);
		documentRoutes.checkInRouteSubmit_Button().click();
		org.title21.utility.BaseClass.sleep(9);
		Close_Button_Checkin().click();
		org.title21.utility.BaseClass.sleep(5);
		logout.logoutFunction();
		org.title21.utility.BaseClass.sleep(4);
		login.loginUser("Title21User2", "test123456");
		documentRoutes = new DocumentRoutes_POM(driver);
		documentRoutes.wizard_Option().click();
		documentRoutes.approval_Tab().click();
		org.title21.utility.BaseClass.sleep(5);
		getplaceholderonapproved().sendKeys(documetNo);
		getGoButton_Search().click();
		org.title21.utility.BaseClass.sleep(5);
		getdoconapproved().get(12).click();
		documentRoutes.documentTab_ForApprover().click();
		org.title21.utility.BaseClass.sleep(4);
		documentRoutes.documentApprove_Button().click();
		org.title21.utility.BaseClass.sleep(6);
		documentRoutes.pinTo_Approve().clear();
		documentRoutes.pinTo_Approve().sendKeys("212223");
		documentRoutes.checkInRouteSubmit_Button().click();
		org.title21.utility.BaseClass.sleep(5);
		logout.logoutFunction();
		org.title21.utility.BaseClass.sleep(5);
		DBConnection.executeStoredProcedure(dbqueries.moveDocsOnReleaseDate);
		org.title21.utility.BaseClass.sleep(5);
		login.loginUser("Title21User2", "test123456");
		org.title21.utility.BaseClass.sleep(2);
	}

	
	public void fileupload(String uploadFileName) {

		fileUploadPath = System.getProperty("user.dir") + "\\testdata";
		fileUploadPath = fileUploadPath + "\\" + uploadFileName;
		getBrouse().sendKeys(fileUploadPath);
		org.title21.utility.BaseClass.sleep(5);
		getAddButtonupload().click();

	}
////button[@type='submit'][contains(text(),'Go')]
}
