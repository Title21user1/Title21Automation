package org.title21.Documents_POM;



import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.title21.Documents_POM.RecentlyViewdAndFavorites_POM;
import org.title21.utility.BaseClass;
import org.title21.utility.FileUpload;
import org.title21.utility.FunctionUtils;

public class RecentlyViewdAndFavorites_POM {
	public WebDriver driver;
	public WebElement element;
	static Logger log = Logger.getLogger(RecentlyViewdAndFavorites_POM.class);
	CreateDocument_POM Credoc;
	BaseClass baseclass; 
	FileUpload FileUplo;
	String fileUploadPath="";
	DocumentRoutes_POM documentRoutes;
	public String Document_number;
	String uploadFileName="FileToUpload.txt";
	String AppendixNumber = "21";
	String doc="pqrstvw";
	String Appendix =doc+FunctionUtils.generateRandomNumber();
	
	public RecentlyViewdAndFavorites_POM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#NavOrganizers>a")
	WebElement eBinders;
	
	
	
	@FindBy(xpath=".//*[@for= 'org-34']//*[text() = 'Lab']")////span[text()='You have committed successfully to this resolution']
	WebElement Lab ;
	
	@FindBy(xpath=" //a[text() = 'SOP']")
	WebElement SOP ;
	
	@FindBy(xpath=".//*[@id='DocTargetReleaseDateString']")
	WebElement datepicker ;
	
	@FindBy(css=".btn.t21-btn-primary.t21-ajax-submit-button.t21-btn-margin-left.pull-right.process-btn-click")
	WebElement SearchGobutton ;
	
	@FindBy(css=".fa.fa-star.fav-star")
	WebElement FavoritesStar ;
	
	@FindBy(css=".fa.fa-star-o.fav-star-open")
	WebElement Favoritesopen ;
	
	
	@FindBy(xpath=".//*[@id='displaySel']/div[1]/div[2]/span")
	WebElement Document_no_after_checkout ;


	@FindBy(xpath=".//*[@id='GeneralTab']/div[1]/div[2]/div[2]/div[2]/label")
	WebElement doc_name ;
	
	@FindBy(css=".day.today")
	WebElement date ;
	
	@FindBy(css=".t21-js-dashboard-row-link.t21-desc-ellipsis-info")
	WebElement Dashboard_Column_List ;
	
	@FindBy(linkText="SOP.01: 6.0")
	WebElement dashboarddocuments ;
	
	
	@FindBy(css=".t21-no-results-message>h4")
	WebElement recordnotfound ;
	
	@FindBy(css="#NavReports>a")
	WebElement Reports ;
	

	@FindBy(css=".fa.fa-trash-o")
	WebElement Remove ;
	
	@FindBy(css=".t21-js-row-link.t21-desc-ellipsis-info")
	WebElement Favorites_Result ;
	
	@FindBy(css="#Dashboard>a")
	WebElement Dashboard ;
	
	
	@FindBy(xpath="//*[contains(text(),'Document Approvals')]")
	WebElement DocumentApprovals ;
	

	@FindBy(css=".dashboard-subheading")
	WebElement Recently_Viewed;
	
	@FindBy(css=".form-control.t21-placeholder")
	WebElement placeholder ;
	

	@FindBy(css=".t21-js-row-link.event-id>a")
	WebElement document_Eventid ;
	
	@FindBy(xpath=".//*[@id='NavFavorites']/a")
	WebElement Favorite_tab ;
	
	@FindBy(css=".grid-see-all")
	WebElement Seeall ;
	
	
	@FindBy(css=".t21-ajax-submit-button.form-control.form-inline.btn.t21-btn-default")
	WebElement GO ;
	
	@FindBy(xpath="//span[@class='t21-no-bold']")
	WebElement getcreateddocumentnumber;
	
	@FindBy(css="#NavSearches>a>span")
	WebElement Searches;
	
	@FindBy(css=".t21-js-dashboard-row-link.t21-desc-ellipsis-info>a")
	WebElement dashboarddata;
	
	@FindBy(xpath=".//*[@id='editCell']")
	WebElement Searchbynumber;
	
	@FindBy(xpath="//*[contains(text(),'Approve')]")
	WebElement approved;
	
	
	@FindBy(xpath=".//*[@id='Pin']")
	WebElement pin;
	
	@FindBy(xpath=".//*[@id='Comments']")
	WebElement comments;
	
	@FindBy(css="#param-0")
	WebElement EnterDocNo;
	
	@FindBy(xpath=".//*[@id='set-4']/div[1]/a")
	WebElement approval;
	
	@FindBy(xpath=".//*[@id='NavMyDocs']/a")
	WebElement MyDoc;
	
	public WebElement getapproved()
	{

		return approved;			
	}
	
	public WebElement getdocname()
	{

		return doc_name;			
	}
	public WebElement getDocument_no_after_checkout()
	{

		return Document_no_after_checkout;			
	}
	public WebElement gettodaysdate()
	{

		return date;			
	}
	
	
	public WebElement getpin()
	{

		return pin;			
	}
	
	public WebElement getcomments()
	{

		return comments;			
	}
	public WebElement getMyDoc()
	{

		return MyDoc;			
	}
	
	public WebElement getapproval()
	{

		return approval;			
	}
	
	public WebElement getDocumentApprovals()
	{

		return DocumentApprovals;			
	}

	public WebElement getSearches()
	{

		return Searches;			
	}
	public WebElement dashboarddata()
	{

		return dashboarddata;			
	}

	public WebElement datepicker()
	{

		return datepicker;			
	}

	
	public WebElement getEnterDocNo()
	{

		return EnterDocNo;			
	}
	public WebElement SearchByDocNumber()
	{

		return Searchbynumber;			
	}
	public WebElement getrecordnotfound()
	{

		return recordnotfound;			
	}
	
	public WebElement getCreatedDocnumber()
	{

		return getcreateddocumentnumber;			
	}

	public WebElement SearchGobutton()
	{

		return SearchGobutton;			
	}
	public WebElement Recently_Viewed()
	{

		return Recently_Viewed;			
	}
	
	public WebElement getseeall()
	{

		return Seeall;			
	}
	
	public WebElement getremove()
	{

		return Remove;			
	}
	
	public WebElement getFavorite_tab()
	{

		return Favorite_tab;			
	}
	
	public WebElement getplaceholder()
	{

		return placeholder;			
	}
	

	public WebElement getGOButton()
	{

		return GO;			
	}
	public WebElement getdocument_Eventid()
	{

		return document_Eventid;			
	}
	
	
	public WebElement getDashboard()
	{

		return Dashboard;			
	}
	
	public WebElement geteBinders()
	{

		return eBinders;			
	}

	public WebElement getFavorites_Result()
	{

		return Favorites_Result;			
	}
	public WebElement getReports()
	{

		return Reports;			
	}
	
	public WebElement getLab()
	{

		return Lab;			
	}
	
	public WebElement getSOP()
	{

		return SOP;			
	}
	
	public WebElement getFavoritesStar()
	{

		return FavoritesStar;			
	}
	
	public WebElement getFavoritesopen()
	{

		return Favoritesopen;			
	}
	
	public WebElement getDashboard_Column_List()
	{

		return Dashboard_Column_List;			
	}
	
	public WebElement getdashboarddocuments()
	{
		return dashboarddocuments;			
	}
	
	public boolean verifyFavoriteOpen()
	{	
		List<WebElement> favoriteopen = driver.findElements(By.cssSelector(".fa.fa-star-o.fav-star-open"));
		int size = favoriteopen.size();
		Boolean result = false;
		if(size != 0)
		{
			result = true;
		}
		else
		{			
			result = false;
		}
		return result;
	}
	
	public void createdocandcheckin()
	{
		Credoc= new CreateDocument_POM (driver);
		Credoc.getnewdoc().click();
		FileUplo=new FileUpload();
		baseclass=new BaseClass();
		BaseClass.sleep(3);
		Credoc.getdocument().click();
		BaseClass.sleep(5);
		Credoc.GeteditdocumentNo().click();
		BaseClass.sleep(5);
		Credoc.getnumberappedix().selectByVisibleText(AppendixNumber);
		Credoc.Appendix().sendKeys(Appendix);
	    Document_number = Credoc.getdocumentnumber().getAttribute("value");
		BaseClass.sleep(2);
		Credoc.getDocumentTitle().sendKeys("Test"+Document_number);
		Credoc.getDocChangeSummary().sendKeys("Test summary"+Document_number);
		baseclass.verticalScrollingDown();
		Credoc.getConfirmButton().click();
		BaseClass.sleep(4);
	    Credoc.getCreatedDocnumber();
		Credoc.getPlusButtonuploadfile().click();
		fileUploadPath = System.getProperty("user.dir") + "\\testdata";
		fileUploadPath = fileUploadPath + "\\" + uploadFileName;
		Credoc.getBrouse().sendKeys(fileUploadPath);
		BaseClass.sleep(5);
		Credoc.getAddButtonupload().click();
		BaseClass.sleep(10);
		Credoc.getcontextmenu().click();
		BaseClass.sleep(2);
		Credoc.getcheckin().click();
		BaseClass.sleep(3);
		Credoc.getcheckinbuttonwindow().click();
		BaseClass.sleep(4);
		Credoc.getcheckincancelsuccess().click();
		BaseClass.sleep(2);
		
	}
	
}
