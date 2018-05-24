package org.title21.PeriodicReviewers_POM;

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
import org.title21.AdminModule_POM.Table;
import org.title21.DBConnection.DBConnection;
import org.title21.DBConnection.DBQueries;
import org.title21.Documents_POM.DocumentRoutes_POM;
import org.title21.Documents_POM.RecentlyViewdAndFavorites_POM;
import org.title21.Module3_POM.AttachmentControlInDoc_POM;

import org.title21.utility.BaseClass;
import org.title21.utility.DateTimeUtils;
import org.title21.validation.entities.ErrorMessages;

public class PeriodicDelegate_POM {
	String fileUploadPath = "";
	String uploadFileName = "";
	public WebDriver driver;
	public String documetNo = "";
	boolean isRecordFound = false;
	Table searchTable;
	public WebElement element;
	static Logger log = Logger.getLogger(AttachmentControlInDoc_POM.class);
	PeriodicOwnedDocuments_POM periodicReviews;
	LogoutPage_POM logout = new LogoutPage_POM(driver);
	LoginPage_POM login = new LoginPage_POM(driver);
	DBQueries dbqueries = new DBQueries();
	String EffectiveDocumentNumber = "";
	BaseClass baseclass = new BaseClass();

	public PeriodicDelegate_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		periodicReviews = new PeriodicOwnedDocuments_POM(driver);

	}

	//
	@FindBy(css = "#Pin")
	WebElement PinNoChangesScreen;

	
	@FindBy(css = "#Location")
	WebElement Location;

	@FindBy(css = ".t21-grid-header-style>h4")
	List<WebElement> clickBeforedelegate;

	@FindBy(css = ".t21-grid-header-style>h4")
	List<WebElement> SerchtextboxOnDocument;

	@FindBy(css = "#UserName")
	WebElement usernamedropdown;

	@FindBy(css = ".grid-button-text")
	WebElement AuditlogButton;

	@FindBy(css = ".t21-no-bold")
	WebElement DocumentNumber;

	@FindBy(css = ".btn.btn-danger.t21-ajax-link")
	WebElement ChangeButton;

	@FindBy(css = ".t21-table-custom>tbody>tr>td")
	List<WebElement> VerifyDelegateUser;

	@FindBy(css = ".t21-table-custom>tbody>tr>td")
	List<WebElement> VerifyUnDelegateUser;

	@FindBy(xpath = "//*[text() = 'Delegate']")
	List<WebElement> Delegateoption;

	@FindBy(xpath = "//*[text() = 'Undelegate']")
	List<WebElement> Undelegate;

	@FindBy(xpath = "//button[contains(@class,'btn t21-btn-primary t21-ajax-submit-button')]")
	WebElement AddButtonOfUpload;

	@FindBy(css = ".btn.btn-default.fa.fa-plus-circle.t21-ajax-link")
	WebElement AddMainFileLink;

	@FindBy(css = "#Type")
	WebElement Typedropdown;

	@FindBy(xpath = ".//*[@id='AttachmentFile']")
	WebElement Brouse;

	@FindBy(css = ".alert.t21-alert-info.alert-dismissible>p")
	WebElement NoResultErrorMessageForSearch;

	@FindBy(css = ".btn.t21-btn-primary.t21-ajax-submit-button.process-btn-click")
	WebElement UndelegatepopupwindowYesButton;

	@FindBy(xpath = "//*[@placeholder='Filter results']")
	List<WebElement> placeholder;

	@FindBy(css = ".t21-ajax-submit-button.form-control.form-inline.btn.t21-btn-default")
	WebElement GoButton;

	@FindBy(xpath = ".//*[@id='DelegateTo']")
	WebElement DelegateToDropdown;

	@FindBy(css = ".t21-ajax-link.t21-btn-primary.btn")
	WebElement ViewDocument;

	@FindBy(css = ".t21-js-row-link")
	WebElement ClickOnDocumentFromReviewList;

	@FindBy(css = "#Comments")
	WebElement CommentsOnChnagesScreen;

	@FindBy(css = ".caret")
	WebElement dropdowforauditmenu;

	@FindBy(css = ".fa.fa-book")
	WebElement doccumentfromapproved;

	@FindBy(css = ".t21-maintab")
	WebElement ReviewTabOnPeriodicReviewscreen;

	@FindBy(css = ".t21-js-row-link.text-nowrap")
	List<WebElement> document;

	@FindBy(css = ".dropdown-toggle.t21-no-text-decoration.fill-cell.t21-combined-icons.t21-mousehand")
	List<WebElement> DropdownOfReviewer;

	@FindBy(css = ".t21-ajax-submit-button.form-control.form-inline.btn.t21-btn-default")
	WebElement GoButtonOfSearch;

	@FindBy(css = ".flash")
	WebElement approvedoctab;

	@FindBy(css = ".btn.t21-btn-primary.t21-ajax-submit-button")
	WebElement Confirm_Button;

	public List<WebElement> getSerchtextboxOnDocument() {
		return SerchtextboxOnDocument;
	}

	public List<WebElement> docType() {
		return document;
	}

	public List<WebElement> getVerifyDelegateUser() {

		return VerifyDelegateUser;
	}

	public List<WebElement> getclickBeforedelegate() {

		return clickBeforedelegate;
	}

	public WebElement getapprovedoctab() {

		return approvedoctab;
	}

	public WebElement getGoButton() {

		return GoButton;
	}

	public WebElement getdropdowforauditmenu() {

		return dropdowforauditmenu;
	}

	public WebElement getClickOnDocumentFromReviewList() {

		return ClickOnDocumentFromReviewList;
	}

	public List<WebElement> getDelegateOption() {
		return Delegateoption;
	}

	public WebElement getNoResultErrorMessageForSearch() {

		return NoResultErrorMessageForSearch;
	}

	public WebElement getUndelegatepopupwindowYesButton() {

		return UndelegatepopupwindowYesButton;
	}

	public WebElement getPinNoChangesScreen() {

		return PinNoChangesScreen;
	}

	public WebElement getCommentsOnChangesScreen() {

		return CommentsOnChnagesScreen;
	}

	public WebElement getChangeButton() {

		return ChangeButton;
	}

	public Select  getLocation() {
		Select selectObj = new Select(Location);
		return selectObj;
	}

	
	public WebElement getConfirm_Button() {

		return Confirm_Button;
	}

	public Select getDelegateToDropdownFromaddDelegationwindow() {
		Select selectObj = new Select(DelegateToDropdown);
		return selectObj;
	}

	public Select getTypedropdown() {
		Select selectObj = new Select(Typedropdown);
		return selectObj;
	}

	public Select getusernamedropdown() {
		Select selectObj = new Select(usernamedropdown);
		return selectObj;
	}

	public List<WebElement> getDropdownOfReviewer() {

		return DropdownOfReviewer;
	}

	public List<WebElement> getVerifyUnDelegateUser() {

		return VerifyUnDelegateUser;
	}

	public WebElement getReviewTabOnPeriodicReviewscreen()

	{

		return ReviewTabOnPeriodicReviewscreen;
	}

	public WebElement get()

	{

		return ViewDocument;
	}

	public List<WebElement> getUndelegate()

	{

		return Undelegate;
	}

	public WebElement getdoccumentfromapproved()

	{

		return doccumentfromapproved;
	}

	public WebElement getViewDocumentButton()

	{

		return ViewDocument;
	}

	public WebElement getAuditlogButton() {

		return AuditlogButton;
	}

	public List<WebElement> getplaceholder() {

		return placeholder;
	}

	public WebElement getGOButton() {

		return GoButtonOfSearch;
	}

	public WebElement getDocumentNumber() {

		return DocumentNumber;
	}

	public WebElement getAddMainFileLink() {

		return AddMainFileLink;
	}

	public WebElement getAddButtonOfUpload() {

		return AddButtonOfUpload;
	}

	public WebElement getBrouseButton() {

		return Brouse;
	}

	public void fileupload(String uploadFileName) {

		getAddMainFileLink().click();
		BaseClass.sleep(3);
		fileUploadPath = System.getProperty("user.dir") + "\\testdata";
		fileUploadPath = fileUploadPath + "\\" + uploadFileName;
		getBrouseButton().sendKeys(fileUploadPath);
		BaseClass.sleep(5);
		getAddButtonOfUpload().click();
		BaseClass.sleep(3);

	}

	public void Search(String document) {
		getplaceholder().get(0).sendKeys(document);
		getGOButton().click();
	}

	public void CreateDocumentAndAddReviewers() throws Exception {

		LogoutPage_POM logout = new LogoutPage_POM(driver);
		LoginPage_POM login = new LoginPage_POM(driver);
		DBQueries dbqueries = new DBQueries();
		periodicReviews.getnewdoc().click();
		org.title21.utility.BaseClass.sleep(8);
		baseclass.waitTillElementVisible(periodicReviews.getdocument());
		periodicReviews.getdocument().click();
		org.title21.utility.BaseClass.sleep(7);
		docType().get(3).click();
		BaseClass.sleep(3);
		documetNo = periodicReviews.document_No().getAttribute("value");
		BaseClass.sleep(5);
		EffectiveDocumentNumber = documetNo + ":1.0";
		periodicReviews.getDocumentTitle().sendKeys("testautomation" + documetNo);
		periodicReviews.getDocChangeSummary().sendKeys("test summary" + documetNo);
		baseclass.verticalScrollingDown();
		periodicReviews.getConfirmButton().click();
		BaseClass.sleep(5);
		fileupload("DocDocument.docx");
		org.title21.utility.BaseClass.sleep(5);
		periodicReviews.getDocumentApprovaltab().click();
		org.title21.utility.BaseClass.sleep(5);
		periodicReviews.getAddApproverLink().click();
		org.title21.utility.BaseClass.sleep(5);
		if (periodicReviews.addNewApprover_Header().isDisplayed()) {
			periodicReviews.getApproverRole().selectByVisibleText("Approver");
			BaseClass.sleep(2);
			periodicReviews.getLocationDropdown().selectByVisibleText("All");
			BaseClass.sleep(2);
			periodicReviews.getnameinAddApprover().selectByVisibleText("Title21User2");
			periodicReviews.getSequenceinAddApprover().selectByVisibleText("1");
			periodicReviews.getallottedDaysinAddApprover().selectByVisibleText("1 day");
			periodicReviews.approverAdd_Button().click();
			org.title21.utility.BaseClass.sleep(5);

		}
		BaseClass.sleep(3);

		periodicReviews.general_Tab().click();
		BaseClass.sleep(2);
		baseclass.scrollIntoView(periodicReviews.periodicReviewsDays_TextBox());
		periodicReviews.periodicReviewsDays_TextBox().clear();
		periodicReviews.periodicReviewsDays_TextBox().sendKeys("365");
		String pickDate = DateTimeUtils.getTomorrowDate();
		String[] preDate = pickDate.split("/");
		String dd1 = preDate[1];
		String dd = dd1;
		if (dd1.contains("0")) {
			dd = dd1.substring(1, 2);
			if (dd.equals("0")) {
				dd = dd1;
			}
		}
		periodicReviews.pickDate_TextBox().click();
		BaseClass.sleep(2);
		driver.findElement(By.xpath("//td[text()='" + dd + "']")).click();
		BaseClass.sleep(2);

		baseclass.verticalScrollingUp();
		baseclass.verticalScrollingUp();

		String targetReleaseDate = DateTimeUtils.getYesterdayDate();
		String[] preDate1 = targetReleaseDate.split("/");
		String Releasedd1 = preDate1[1];
		String Releasedd = Releasedd1;
		if (Releasedd1.contains("0")) {
			Releasedd = Releasedd1.substring(1, 2);
			if (Releasedd.equals("0")) {
				Releasedd = Releasedd1;
			}
		}
		periodicReviews.docTargetReleaseDate_TextBox().click();
		BaseClass.sleep(2);
		driver.findElement(By.xpath("//td[text()='" + Releasedd + "']")).click();
		BaseClass.sleep(2);

		baseclass.scrollIntoView(periodicReviews.editPeriodicReviewers_Link());
		periodicReviews.editPeriodicReviewers_Link().click();
		BaseClass.sleep(5);

		if (periodicReviews.editPeriodicReviewers_HeaderText().isDisplayed()) {
			BaseClass.sleep(5);
			getLocation().selectByVisibleText("All");
			BaseClass.sleep(3);
			periodicReviews.availablePeriodicReviewers_Filter().click();
			periodicReviews.availablePeriodicReviewers_Filter().sendKeys("Title21User2");
			BaseClass.sleep(2);
			if (periodicReviews.AvailablePeriodicReviewers_SearchResultArea().isDisplayed()) {
				periodicReviews.availablePeriodic_MoveButton().click();
			}

			BaseClass.sleep(2);

			periodicReviews.availablePeriodicReviewers_Filter().clear();
			periodicReviews.availablePeriodicReviewers_Filter().sendKeys("Title21User4");
			BaseClass.sleep(2);
			if (periodicReviews.AvailablePeriodicReviewers_SearchResultArea().isDisplayed()) {
				periodicReviews.availablePeriodic_MoveButton().click();
			}
			periodicReviews.save_Button().click();
			BaseClass.sleep(2);
		}

		baseclass.verticalScrollingUp();
		baseclass.verticalScrollingUp();
		periodicReviews.docContext_Menu().click();
		org.title21.utility.BaseClass.sleep(5);
		periodicReviews.checkIn_Route().click();

		org.title21.utility.BaseClass.sleep(5);
		periodicReviews.checkInRouteSubmit_Button().click();
		org.title21.utility.BaseClass.sleep(5);
		periodicReviews.close_Button().click();
		org.title21.utility.BaseClass.sleep(5);
		logout.logoutFunction();
		// DBConnection.executeStoredProcedure(dbqueries.moveDocsOnReleaseDate);
		BaseClass.sleep(5);
		login.loginUser("Title21User2", "test123456");
		approveDocFromWizard(documetNo);
		logout.logoutFunction();
		DBConnection.executeStoredProcedure(dbqueries.moveDocsOnReleaseDate);
		BaseClass.sleep(5);
		login.loginUser("Title21User2", "test123456");
		BaseClass.sleep(5);
		periodicReviews.wizard_Option().click();
		org.title21.utility.BaseClass.sleep(5);
		periodicReviews.wizardReview_Tab().click();
		org.title21.utility.BaseClass.sleep(8);

	}

	private void approveDocFromWizard(String docName) {
		RecentlyViewdAndFavorites_POM RecentlyViewdAndFavorites = new RecentlyViewdAndFavorites_POM(driver);
		DocumentRoutes_POM documentRoutes = new DocumentRoutes_POM(driver);
		periodicReviews.wizard_Option().click();
		periodicReviews.approval_Tab().click();
		org.title21.utility.BaseClass.sleep(5);
		RecentlyViewdAndFavorites.getplaceholder().sendKeys(documetNo);// documet_no_checkout1
		RecentlyViewdAndFavorites.getGOButton().click();
		org.title21.utility.BaseClass.sleep(5);
		getdoccumentfromapproved().click();
		org.title21.utility.BaseClass.sleep(5);
		getapprovedoctab().click();
		org.title21.utility.BaseClass.sleep(5);
		periodicReviews.documentApprove_Button().click();
		org.title21.utility.BaseClass.sleep(5);
		periodicReviews.pinTo_Approve().clear();
		periodicReviews.pinTo_Approve().sendKeys("212223");
		periodicReviews.checkInRouteSubmit_Button().click();
		org.title21.utility.BaseClass.sleep(5);
	}

	private boolean selectDocForApprovel(String docName, int cell) {
		searchTable = new Table(driver);
		isRecordFound = false;
		List<WebElement> tableCells = searchTable.getcollapseDocumentstableCells(cell);
		for (int i = 0; i < tableCells.size(); i++) {
			if (tableCells.get(i).getText().contains(docName)) {
				tableCells.get(i).click();
				isRecordFound = true;
				break;
			}
		}
		return isRecordFound;
	}

	public boolean NoResultvalidationMessage() {

		element = getNoResultErrorMessageForSearch();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent = false;

		if (errorMessage.contains(ErrorMessages.NoResultFoundOnReviewValidation)) {
			isValidationMessagePresent = true;
		} else {
			log.error("Validation message for No result found  ");
		}
		return isValidationMessagePresent;
	}
}
