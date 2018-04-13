package org.title21.Module3_POM;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LinkControlOfDocument_POM 

{
	
	public WebDriver driver;
	public WebElement element;
	
	static Logger log = Logger.getLogger(AttachmentControlInDoc_POM.class);
	public LinkControlOfDocument_POM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css=".fa.fa-plus-circle.t21-padding-right-5")
	List<WebElement> add_new_link ;//1
	
	@FindBy(css=".form-control.t21-placeholder")
	List<WebElement> search ;//1
	
	@FindBy(css=".form-control.t21-js-date-field")
	List<WebElement> calender ;//1
	
	@FindBy(css=".t21-js-dashboard-row-link.t21-desc-ellipsis-info>a")
	List<WebElement> dashboarddpcumentslist ;
	
	@FindBy(css=".t21-js-unlink-item.t21-select-row")
	List<WebElement> checkboxlist ;//1
	
	@FindBy(css=".btn.t21-btn-primary.t21-ajax-submit-button")
	WebElement OkButton;
	
	@FindBy(css=".t21-js-unlink-item.t21-select-row")
	WebElement document_checkbox;
	
	@FindBy(css=".form-control.t21-placeholder")
	WebElement placeholderonapproved;
	
	
	@FindBy(css=".t21-ajax-submit-button.form-control.form-inline.btn.t21-btn-default")
	WebElement goonapproved;
	
	
	@FindBy(css=".t21-js-row-link.event-id>a")
	WebElement doconsearch;
	
	
	@FindBy(xpath="//*[text()='Search']/following::input[@class='form-control t21-placeholder']")
	WebElement linksearchonsearch;
	
	@FindBy(css=".t21-no-bold")
	WebElement doc_name;
	
	@FindBy(css=".btn.t21-btn-primary.t21-ajax-submit-button.process-btn-click")
	List<WebElement>  confirm;
	
	@FindBy(css=".btn.t21-btn-primary.t21-ajax-submit-button")
	List<WebElement>  checkinconfirm;
	
	@FindBy(css=".close")
	WebElement close;
	
	@FindBy(xpath=".//*[@id='lock']/a[2]")
	WebElement edit;
	
	@FindBy(css=".min-column.no-wrap")
	List<WebElement> link_documents;
	
	
	@FindBy(css=".btn.t21-btn-default")
	List<WebElement> checkinclose;
	
	@FindBy(css="#SelectedStatus")
	WebElement StatusDropdown;
	
	@FindBy(css=".btn.t21-btn-primary.t21-ajax-submit-button")
	WebElement ok;
	
	@FindBy(xpath="//button[@class='btn t21-btn-primary t21-ajax-submit-button']")
	WebElement yes;
	
	@FindBy(css=".fa.fa-trash-o.action-items")
	List<WebElement> remove;
    
	@FindBy(css=".t21-ajax-link")
	List<WebElement> doconapproved ;

	@FindBy(css=".event-id")
	List<WebElement> selected_doc_from_link;
	
	
	@FindBy(css=".multiselect.dropdown-toggle.btn.t21-btn-default")
	List<WebElement> Typebutton;
	
	
	@FindBy(css=".checkbox>input")
	List<WebElement> checkbox;
	
	@FindBy(css=".min-column.no-wrap")
	List<WebElement> searchlinkdocumentslist;
	
	
	@FindBy(css=".t21-js-unlink-item.t21-select-row")
	List<WebElement> checkobox_list;

	
	@FindBy(css=".t21-ajax-submit-button.form-control.form-inline.btn.t21-btn-default")
	List<WebElement> go;
	
	@FindBy(css=".btn.t21-btn-primary.t21-ajax-submit-button")
	List<WebElement> okbuttononsearch ;
	
	public WebElement getedit()
	{

		return edit;			
	}
	public WebElement getplaceholderonapproved()
	{

		return placeholderonapproved;			
	}
	public WebElement getgoonapproved()
	{

		return goonapproved;			
	}
	public List<WebElement> getcheckinconfirm()
	{

		return checkinconfirm;			
	}
	
	public List<WebElement> getcheckinclose()
	{

		return checkinclose;			
	}
	public List<WebElement> getokbuttononsearch()
	{

		return okbuttononsearch;			
	}
	
	public List<WebElement> getcheckbox_list()
	{

		return checkboxlist;			
	}
	
	public List<WebElement> getconfirm()
	{

		return confirm;			
	}
	
	public List<WebElement>getsearchlinklist()
	{

		return searchlinkdocumentslist;			
	}
	public List<WebElement>getremove()
	{

		return remove;			
	}
	public WebElement getdocument_checkbox()
	{

		return document_checkbox;			
	}
	public List<WebElement> getdoconapproved()
	{

		return doconapproved;			
	}
	public WebElement getyesbutton()
	{

		return yes;			
	}
	public WebElement getclose()
	{

		return close;			
	}
	public WebElement getdocname()
	{

		return doc_name;			
	}
	public WebElement getlinksearchonsearch()
	{

		return linksearchonsearch;			
	}
	public WebElement getdoconsearch()
	{

		return doconsearch;			
	}
	
	public WebElement ok_button()
	{

		return ok;			
	}
	public List<WebElement> getGoButton()
	{

		return go;			
	}
	public List<WebElement> getdashboardocumentslist()
	{

		return dashboarddpcumentslist;			
	}
	
	public List<WebElement> getselected_doc_from_link()
	{

		return selected_doc_from_link;			
	}
	public List<WebElement> getlinkdocuments()
	{

		return link_documents;			
	}
	public List<WebElement> getsearch()
	{

		return search;			
	}
	//.checkbox>input
	public List<WebElement> getheckbox()
	{

		return checkbox;			
	}
	
	public List<WebElement> getgo()
	{

		return go;			
	}
	public WebElement getOkButton()
	{

		return OkButton;			
	}

	public List<WebElement> getcalender()
	{

		return calender;			
	}
	
	public List<WebElement> getTypebuttonandLocationbutton()
	{

		return Typebutton;			
	}
	
	public Select getStatusDropdown()
	{
		Select selectObj=new Select(StatusDropdown);
		return selectObj;
	}
	
	
	public List<WebElement> getadd_new_link()
	{

		return add_new_link;			
	}
	
	public void trainingItemsCheck(Boolean check)
	{
		if (!check && getdocument_checkbox().isSelected()) {
			getdocument_checkbox().click();
		}
		else if (check && !getdocument_checkbox().isSelected()) {
			getdocument_checkbox().click();
		}
	}

}