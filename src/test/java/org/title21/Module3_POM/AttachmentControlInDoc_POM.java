package org.title21.Module3_POM;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.title21.Documents_POM.RecentlyViewdAndFavorites_POM;

public class AttachmentControlInDoc_POM 
{
	

	public WebDriver driver;
	public WebElement element;
	static Logger log = Logger.getLogger(AttachmentControlInDoc_POM.class);
	public AttachmentControlInDoc_POM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css="#Description")
	WebElement Description ;
	
	@FindBy(css=".t21-margin-bottom-10")
	WebElement bottom ;
	
	@FindBy(css=".t21-js-row-link.event-id>a")
	WebElement verifysearch ;
	
	@FindBy(css=".btn.t21-btn-primary.t21-ajax-submit-button")
	WebElement update ;
	
	@FindBy(css=".fa.t21-blue.fa-chevron-circle-down")
	WebElement showattachment ;
	
	@FindBy(xpath="//a[text() = 'Native']")
	List<WebElement> nativef ;
	/*

	@FindBy(xpath=".//*[@id='collapse-2']/div/div/div[1]/a")
	WebElement add_new ;*/
	
	@FindBy(css=".fa.fa-plus-circle.t21-padding-right-5")
	List<WebElement> add_new ;
	
	@FindBy(css=".modal-title.wrapword-breakword")
	WebElement attachmentwindowpopup ;
	
	//h4[text() = 'Editing Attachment - upload.PNG']
	@FindBy(xpath="//a[text() = 'PDF']")
	List<WebElement> pdf ;
	
	@FindBy(css=".fa.fa-pencil.action-items")
	List<WebElement> edit ;
	
	@FindBy(css=".fa.fa-trash-o.action-items")
	WebElement delete ;
	

	@FindBy(css=".btn.t21-btn-primary.t21-ajax-submit-button")
	WebElement yes ;
	
	@FindBy(css=".t21-js-open-browser-tab")
	WebElement crossverifyattachmentinreport ;
	
	@FindBy(css=".wrapword-breakword")
	WebElement verifydescription ;
	
	
	@FindBy(css=".fa.fa-trash-o.action-items")
	List<WebElement> remove ;
	
	

	public List<WebElement> getnativedownloadoption()
	{

		return nativef;			
	}
	
	public List<WebElement> getpdf()
	{

		return pdf;			
	}
	
	public List<WebElement> getremove()
	{

		return remove;			
	}
	public List<WebElement> getedit()
	{

		return edit;			
	}
	
	public WebElement getbottom()
	{

		return bottom;			
	}
	public WebElement getverifysearch()
	{

		return verifysearch;			
	}
	
	public WebElement getattachmentwindowpopup()
	{

		return attachmentwindowpopup;			
	}
	public WebElement getshowattachment()
	{

		return showattachment;			
	}
	public WebElement verifyattachment()
	{

		return crossverifyattachmentinreport;			
	}
	
	public WebElement getyes()
	{

		return yes;			
	}
	
	public WebElement getverifydescription()
	{

		return verifydescription;			
	}
	
	public List<WebElement> getAddnew()
	{

		return add_new;			
	}
	
	public WebElement geDescription()
	{

		return Description;			
	}
	
	public WebElement getupdate()
	{

		return update;			
	}
	
	public WebElement getdelete()
	{

		return delete;			
	}
	
	}

