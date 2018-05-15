package org.title21.Documents_POM;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.title21.PeriodicReviewers_POM.PeriodicOwnedDocuments_POM;
import org.title21.utility.BaseClass;
import org.title21.validation.entities.ErrorMessages;

public class DocumentCollaboration_POM {
	public WebDriver driver;
	public String documetNo = "";
	public WebElement element;
	BaseClass BaseClass = new BaseClass();
	static Logger log = Logger.getLogger(DocumentCollaboration_POM.class);
	RecentlyViewdAndFavorites_POM RecentlyViewdAndFavorites;

	public DocumentCollaboration_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[text() = 'Collaboration']")
	WebElement CollaborationTab;
	@FindBy(xpath = ".//*[@id='Description']")
	WebElement DescriptionOnAddCollaborator;

	@FindBy(css = "#Location")
	WebElement Location;

	@FindBy(css = ".t21-js-row-link.event-id>a")
	WebElement DocumentonCollaboration;

	@FindBy(xpath = "//*[text() = 'Collaboration']")
	List<WebElement> CollaborationTabonsearch;

	@FindBy(css = ".t21-table-hover-row>td")
	List<WebElement> CollaborationTasklist;

	@FindBy(css = ".t21-js-row-link.text-nowrap>a")
	List<WebElement> document;

	@FindBy(css = ".t21-margin-bottom")
	List<WebElement> NoResultErrorMessageForSearch;

	@FindBy(xpath = ".//*[@id='Category']")
	WebElement CategoryOnAddCollaborator;

	@FindBy(xpath = ".//*[@id='AssignToPerson']")
	WebElement AssignToPersonOnAddCollaborator;

	@FindBy(xpath = ".//*[@id='DueDate']")
	WebElement DueDateOnAddCollaborator;

	@FindBy(xpath = ".//*[@id='NotifyMeWhenTaskComplete']")
	WebElement NotifyMeWhenTaskComplete;

	@FindBy(xpath = ".//*[@id='RequiresESig']")
	WebElement electonicsignatuire;

	@FindBy(xpath = ".//*[@id='EnableTask']")
	WebElement EnableTaskcheckbox;

	@FindBy(xpath = ".//*[@id='Notes']")
	WebElement NotesOnAddCollaborator;

	@FindBy(xpath = ".active>a")
	WebElement collaboationonSerach;

	@FindBy(css = ".btn.t21-btn-primary.t21-ajax-submit-button.process-btn-click")//
	WebElement AddButton;

	@FindBy(xpath = ".//*[@id='NavTasks']/a")
	WebElement MyTaskTab;

	@FindBy(xpath = ".//*[@id='EmailOnAddNew']")
	WebElement EmailOnaddNew;

	@FindBy(xpath = ".//*[@id='NavMyDocs']/a")
	WebElement MyDocument;

	@FindBy(xpath = ".//*[@id='AllowDocumentEditing']")
	WebElement AllowDocumentEditing;

	@FindBy(xpath = "//*[@class='fa fa-plus-circle t21-padding-right-5']") // 3
	List<WebElement> AddColaboratorlink;

	@FindBy(css = ".selected.t21-table-hover-row>td>a")
	List<WebElement> verifyaftercollaboration;

	@FindBy(css = ".t21-ajax-submit-button.form-control.form-inline.btn.t21-btn-default")
	List<WebElement> GoButtonOnSearch;

	@FindBy(css = ".set-item-link")
	List<WebElement> AssignByMe;
	
@FindBy(css = ".col-lg-8.col-md-8.col-sm-8.t21-no-bold")
	List<WebElement> Taskstatusverify;

	@FindBy(css = ".btn.t21-btn-primary.t21-ajax-link.t21-bold")
	WebElement MarkTaskCompleteButton;

	@FindBy(css = ".btn.t21-btn-primary.t21-ajax-submit-button")
	WebElement ConfirmButton;

	@FindBy(css = ".t21-js-user-message-text")
	WebElement Recordlockedmessage;
	
	@FindBy(css = "#Pin")
	WebElement Pin;
	
	@FindBy(css = ".btn.t21-btn-default")
	WebElement CloseButton;
    
	@FindBy(css = ".fa.fa-caret-down")
	List<WebElement> Contextmenu;
	
	@FindBy(css = ".grid-button-text")
	WebElement AuditlogButton;

	@FindBy(css = "#Type")
	WebElement Typedropdown;

	@FindBy(css = ".fa.fa-newspaper-o.grid-button-icon")
	WebElement Form;
	
	@FindBy(xpath = "//*[@placeholder='Filter results']")
	List<WebElement> getplaceholder;

	@FindBy(css = ".t21-js-row-link.event-id>a")
	WebElement documentoncollaboration;

	@FindBy(css = ".btn.btn-default.t21-ajax-link")
	List<WebElement> edit_mode_enable;
	
	@FindBy(css = ".caret")
	WebElement dropdowforauditmenu;

	@FindBy(css = ".t21-js-row-link.event-id>a")
	WebElement doconsearch;

	@FindBy(css = "#NotifyMeWhenTaskComplete")
	WebElement NotifyMeWhenTaskCompleteCheckbox;

	public List<WebElement> getTaskstatusverify()// 2
	{

		return Taskstatusverify;
	}
	public List<WebElement> edit_mode_enable()
	{

		return edit_mode_enable;
	}
	public List<WebElement> getGoButtonOnSearch()// 2
	{

		return GoButtonOnSearch;
	}
	
	public List<WebElement> getContextmenu()// 2
	{

		return Contextmenu;
	}

	public List<WebElement> getCollaborationTabonsearch()// 2
	{

		return CollaborationTabonsearch;
	}

	public List<WebElement> getplaceholder() {

		return getplaceholder;
	}
	public WebElement getCloseButton() {

		return CloseButton;
	}
	
	public WebElement getRecordlockedmessage() {

		return Recordlockedmessage;
	}

	public WebElement getNotifyMeWhenTaskCompleteCheckbox() {

		return NotifyMeWhenTaskCompleteCheckbox;
	}

	public WebElement getForm() {

		return Form;
	}
	public WebElement getAuditlogButton() {

		return AuditlogButton;
	}
	public Select getTypedropdown() {
		Select selectObj = new Select(Typedropdown);
		return selectObj;
	}

	public List<WebElement> getCollaborationTasklist()// 2
	{

		return CollaborationTasklist;
	}

	public List<WebElement> getverifyaftercollaboration()// 2
	{

		return verifyaftercollaboration;
	}

	public WebElement getdropdowforauditmenu() {

		return dropdowforauditmenu;
	}

	public List<WebElement> getAssignByMe()// 2
	{

		return AssignByMe;
	}

	public WebElement getcollaboationonSerach() {

		return collaboationonSerach;
	}

	public WebElement getDocumentonCollaboration() {

		return DocumentonCollaboration;
	}

	public WebElement getConfirmButton() {

		return ConfirmButton;
	}

	public WebElement getPin() {

		return Pin;
	}

	public WebElement getMarkTaskCompleteButton() {

		return MarkTaskCompleteButton;
	}

	public List<WebElement> getcollaborationOnMyDocument()// 5
	{

		return AssignByMe;
	}

	public WebElement getCollaborationTab() {

		return CollaborationTab;
	}

	public WebElement getMyDocumentTab() {

		return MyDocument;
	}

	public WebElement getMyTaskTab() {

		return MyTaskTab;
	}

	public Select getLocation() {
		Select selectObj = new Select(Location);
		return selectObj;
	}

	public WebElement getAddButton() {

		return AddButton;
	}

	public List<WebElement> getNoResultErrorMessageForSearch() {

		return NoResultErrorMessageForSearch;
	}

	public WebElement getNotifyMeWhenTaskComplete() {

		return NotifyMeWhenTaskComplete;
	}

	public WebElement getDescription_On_AddCollaborator() {

		return DescriptionOnAddCollaborator;
	}

	public WebElement getEnableTaskcheckbox() {

		return EnableTaskcheckbox;
	}

	public WebElement getAllowDocumentEditingcheckbox() {

		return AllowDocumentEditing;
	}

	public WebElement getEmailOnaddNewcheckbox() {

		return EmailOnaddNew;
	}

	public WebElement getdoconsearch() {

		return doconsearch;
	}

	public WebElement getelectonisognaturecheckbox() {

		return electonicsignatuire;
	}

	public Select getCategoryOnAddCollaborator() {
		Select selectObj = new Select(CategoryOnAddCollaborator);
		return selectObj;
	}

	public WebElement getAssignToPerson_On_AddCollaborator() {

		return AssignToPersonOnAddCollaborator;
	}

	public WebElement getDueDate_On_AddCollaborator() {

		return DueDateOnAddCollaborator;
	}

	public List<WebElement> docType() {
		return document;
	}

	public List<WebElement> getAddColaboratorlink() {

		return AddColaboratorlink;

	}

	public void CreateDocument() {

		PeriodicOwnedDocuments_POM periodicReviews = new PeriodicOwnedDocuments_POM(driver);
		periodicReviews.getnewdoc().click();
		org.title21.utility.BaseClass.sleep(4);
		BaseClass.waitTillElementVisible(periodicReviews.getdocument());
		periodicReviews.getdocument().click();
		org.title21.utility.BaseClass.sleep(9);
		docType().get(4).click();
		org.title21.utility.BaseClass.sleep(4);
		documetNo = periodicReviews.document_No().getAttribute("value");
		org.title21.utility.BaseClass.sleep(5);
		periodicReviews.getDocumentTitle().sendKeys("testautomation" + documetNo);
		periodicReviews.getDocChangeSummary().sendKeys("test summary" + documetNo);
		BaseClass.verticalScrollingDown();
		periodicReviews.getConfirmButton().click();
		org.title21.utility.BaseClass.sleep(5);
	}

	public void getAllowDocumentEditingcheckbox(Boolean check) {
		if (!check && getAllowDocumentEditingcheckbox().isSelected()) {
			getAllowDocumentEditingcheckbox().click();
		} else if (check && !getAllowDocumentEditingcheckbox().isSelected()) {
			getAllowDocumentEditingcheckbox().click();
		}
	}

	public void getEnableTaskcheckbox(Boolean check) {
		if (!check && getEnableTaskcheckbox().isSelected()) {
			getEnableTaskcheckbox().click();
		} else if (check && !getEnableTaskcheckbox().isSelected()) {
			getEnableTaskcheckbox().click();
		}
	}

	public void getelectonisognaturecheckbox(Boolean check) {
		if (!check && getelectonisognaturecheckbox().isSelected()) {
			getelectonisognaturecheckbox().click();
		} else if (check && !getelectonisognaturecheckbox().isSelected()) {
			getelectonisognaturecheckbox().click();
		}
	}

	public void getNotifyMeWhenTaskCompleteCheckbox(Boolean check) {
		if (!check && getNotifyMeWhenTaskCompleteCheckbox().isSelected()) {
			getNotifyMeWhenTaskCompleteCheckbox().click();
		} else if (check && !getNotifyMeWhenTaskCompleteCheckbox().isSelected()) {
			getNotifyMeWhenTaskCompleteCheckbox().click();
		}
	}

	public void getEmailOnaddNewcheckbox(Boolean check) {
		if (!check && getEmailOnaddNewcheckbox().isSelected()) {
			getEmailOnaddNewcheckbox().click();
		} else if (check && !getEmailOnaddNewcheckbox().isSelected()) {
			getEmailOnaddNewcheckbox().click();
		}
	}

	public boolean NoResultvalidationMessage() {

		element = getNoResultErrorMessageForSearch().get(1);
		String errorMessage = element.getText();
		boolean isValidationMessagePresent = false;

		if (errorMessage.contains(ErrorMessages.NoResultFoundOnReviewValidation)) {
			isValidationMessagePresent = true;
		} else {
			log.error("Validation message for No result found  not display ");
		}
		return isValidationMessagePresent;
	}
	public boolean RecordLockvalidatiom(){

		element=getRecordlockedmessage();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;		

		if(errorMessage.contains(ErrorMessages.recordLockeditmodevalidation))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Validation message for record lock after for edit mode not display ");
		}	
		return isValidationMessagePresent;
	}
	public void Search(String doc) {
		getplaceholder().get(0).sendKeys(doc);
		getGoButtonOnSearch().get(0).click();
	}

	public void SearchTab(String Searchdata) {
		RecentlyViewdAndFavorites = new RecentlyViewdAndFavorites_POM(driver);
		RecentlyViewdAndFavorites.getSearches().click();
		RecentlyViewdAndFavorites.getplaceholder().sendKeys("Search on Document Number");
		RecentlyViewdAndFavorites.getGOButton().click();
		org.title21.utility.BaseClass.sleep(5);
		RecentlyViewdAndFavorites.SearchByDocNumber().click();
		RecentlyViewdAndFavorites.getEnterDocNo().sendKeys(Searchdata);
		RecentlyViewdAndFavorites.SearchGobutton().click();
	}
}