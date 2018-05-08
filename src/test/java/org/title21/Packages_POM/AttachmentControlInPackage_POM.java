package org.title21.Packages_POM;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.title21.Documents_POM.CreateDocument_POM;
import org.title21.Documents_POM.DocumentCollaboration_POM;
import org.title21.Documents_POM.RecentlyViewdAndFavorites_POM;
import org.title21.utility.BaseClass;

public class AttachmentControlInPackage_POM {
	public WebDriver driver;
	public String documetNo = "";
	public WebElement element;
	String fileUploadPath = "";
	String Document_number = "";
	String package_name="";
	BaseClass BaseClass = new BaseClass();
	static Logger log = Logger.getLogger(DocumentCollaboration_POM.class);
	RecentlyViewdAndFavorites_POM RecentlyViewdAndFavorites;

	public AttachmentControlInPackage_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath=".//*[@id='AttachmentFile']")
	WebElement Brouse;
	
	@FindBy(xpath="//a[text() = 'Native']")
	List<WebElement> nativef ;
	
	@FindBy(css = ".fa.fa-file-o")
	WebElement Newtab;
	
	@FindBy(css = ".t21-js-row-link.event-id>a")
	WebElement clieckonserchdoc;
	
	@FindBy(css = "#TravelerName")
	 WebElement Packagename;

	
	@FindBy(css = ".panel-body.text-center.t21-new-item-image")
	List<WebElement> packageicon;
	
	@FindBy(css = ".fa.fa-plus-circle.t21-padding-right-5")
	List<WebElement> Add_Link;
	

	@FindBy(css = ".form-control.t21-placeholder")
	List<WebElement> Search_Box;
	
	
	@FindBy(css = "#Cabinet")
	WebElement CabinetDropdown;
	
	@FindBy(xpath = "//*[text()='Attachments/Tasks']")
	WebElement AttachmentsTab;
	
	@FindBy(css = ".t21-no-bold")
	List<WebElement> packagecreatedname;
	
	@FindBy(css = ".btn.t21-btn-primary.t21-ajax-submit-button.process-btn-click")
	WebElement Create_Button;
	
	@FindBy(css=".btn.t21-btn-primary.t21-ajax-submit-button")
	WebElement update ;
	
	@FindBy(css = ".t21-ajax-submit-button.form-control.form-inline.btn.t21-btn-default")
	List<WebElement> GoButton;
	
	
	@FindBy(css=".fa.t21-blue.fa-chevron-circle-down")
	WebElement showattachment ;
	
	@FindBy(css="#Description")
	WebElement Description ;
	
	@FindBy(xpath="//a[text() = 'PDF']")
	List<WebElement> pdf ;

	@FindBy(css=".fa.fa-pencil.action-items")
	List<WebElement> edit ;
	
	@FindBy(css=".fa.fa-trash-o.action-items")
	List<WebElement> remove ;
	
	
	@FindBy(css=".btn.t21-btn-primary.t21-ajax-submit-button")
	WebElement yes ;
	
	@FindBy(css=".form-control.t21-no-maxwidth.t21-js-clear-string-validation")
	WebElement TextBoxofpackageSearch ;
	
	public List<WebElement> goButton()
	{

		return GoButton;
	}
	public WebElement getshowattachment()
	{

		return showattachment;			
	}
	
	public WebElement getclieckonserchdoc()
	{

		return clieckonserchdoc;			
	}
	public List<WebElement> getSearch_Box()
	{

		return Search_Box;
	}
	
	public List<WebElement> getpackagecreatedname()
	{

		return packagecreatedname;
	}
	
	public WebElement getyes()
	{

		return yes;			
	}

	public List<WebElement> getremove()
	{

		return remove;			
	}
	
	public WebElement getupdate()
	{

		return update;			
	}
	public WebElement geDescription()
	{

		return Description;			
	}
	public List<WebElement> getpdf()
	{

		return pdf;			
	}
	public List<WebElement> getedit()
	{

		return edit;			
	}

	public WebElement getBrouse()
	{

		return Brouse;			
	}
	public List<WebElement> getnativedownloadoption()
	{

		return nativef;			
	}
	public List<WebElement> getAddLink()
	{

		return Add_Link;			
	}
	public WebElement getAttachmentsTab()
	{

		return AttachmentsTab;			
	}
	public WebElement getTextBoxofpackageSearch() {

		return TextBoxofpackageSearch;
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
	
	public WebElement getPackagename() {

		return Packagename;
	}
	
	public WebElement getCreate_Button() {

		return Create_Button;
	}

	public void fileupload(String uploadFileName)
	{
		CreateDocument_POM Credoc = new CreateDocument_POM(driver);
		fileUploadPath = System.getProperty("user.dir") + "\\testdata";
		fileUploadPath = fileUploadPath + "\\" + uploadFileName;
		getBrouse().sendKeys(fileUploadPath);
		org.title21.utility.BaseClass.sleep(4);
		Credoc.getAddButtonupload().click();
		org.title21.utility.BaseClass.sleep(4);

	}
	public void Create_Package()
	{
	    getNewTab().click();
	    org.title21.utility.BaseClass.sleep(4);
		getPackageIcon().get(6).click();
		org.title21.utility.BaseClass.sleep(4);
	    getCabinetDropdown().selectByVisibleText("Open DCOs");
	    org.title21.utility.BaseClass.sleep(3);
		getPackagename().sendKeys("autopackage");
		org.title21.utility.BaseClass.sleep(3);
		getCreate_Button().click();
		org.title21.utility.BaseClass.sleep(5);
        package_name=getpackagecreatedname().get(0).getText();
		
	}
	public void SearchTab(String Searchdata) {
		RecentlyViewdAndFavorites_POM RecentlyViewdAndFavorites = new RecentlyViewdAndFavorites_POM(driver);
		RecentlyViewdAndFavorites.getSearches().click();
		RecentlyViewdAndFavorites.getplaceholder().sendKeys("Search Packages");
		RecentlyViewdAndFavorites.getGOButton().click();
		org.title21.utility.BaseClass.sleep(5);
		RecentlyViewdAndFavorites.SearchByDocNumber().click();
		org.title21.utility.BaseClass.sleep(5);
		getTextBoxofpackageSearch().clear();
		getTextBoxofpackageSearch().sendKeys(package_name);
		org.title21.utility.BaseClass.sleep(3);
		RecentlyViewdAndFavorites.SearchGobutton().click();
		org.title21.utility.BaseClass.sleep(5);
		getSearch_Box().get(2).sendKeys(package_name);
		org.title21.utility.BaseClass.sleep(5);
		goButton().get(4).click();
		org.title21.utility.BaseClass.sleep(5);
		
		
	}
}  
