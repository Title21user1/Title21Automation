package org.title21.POM;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class MyDocs_POM
{
	public WebDriver driver;
	public WebElement element;
	public String docID;
	static Logger log = Logger.getLogger(AddEmployee_POM.class);
	
	public MyDocs_POM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=".//*[@id='NavMyDocs']/a/span")
	WebElement	mydocs;
	
	@FindBy(xpath="//a[contains(@href,'CheckedOutDocuments')]")
	WebElement	checkoutbyme;
	
	@FindBy(css=".form-control.t21-placeholder")
	WebElement	search;
	
	@FindBy(css=".t21-ajax-submit-button.form-control.form-inline.btn.t21-btn-default")
	WebElement	goButton;
	
	@FindBy(css=".t21-js-row-link.event-id>a")
	WebElement	firstDocument;
	
	@FindBy(xpath=".//*[@id='displaySel']/div[1]/div[3]/div/a/span[2]")
	WebElement	contextMenu;
	
	@FindBy(xpath=" //span[@class='grid-button-text'][text()='Check In']")
	WebElement	checkinContextMenu;
	
	@FindBy(xpath="//span[@class='grid-button-text'][text()='Check Out']")
	WebElement	checkoutContextMenu;
	
	@FindBy(xpath="//span[@class='grid-button-text'][text()='Route For Approval']")
	WebElement	routeApporvalContextMenu;
	
	@FindBy(xpath="//input[@name='submitButton']")
	WebElement	checkinButton;
	
	@FindBy(xpath="//button[text()='Close']")
	WebElement	checkinCloseButton;
	
	@FindBy(id="CheckedOutTo")
	WebElement	checkoutPerson;
	
	@FindBy(xpath="//input[@name='submitButton']")
	WebElement	checkoutConfirmButton;
	
	@FindBy(xpath="//a[contains(@href,'AddRouteModal')]")
	WebElement	signatureRoute;
	
	@FindBy(xpath="//a[contains(@href,'DocumentApprovalsTab')]")
	WebElement	documentApproval;
		
	@FindBy(xpath=".//*[@id='lock']/a[2]")
	WebElement	editModeON;
	
	@FindBy(xpath="//*[@id='default-modal']//select[@class='form-control t21-ajax-submit-select']")
	WebElement	routeName;
	
	@FindBy(xpath=".//input[@class='btn t21-btn-primary t21-ajax-submit-button process-btn-click']")
	WebElement signatureroteAddButton;
	
	@FindBy(xpath="//a[contains(@href,'RejectedDocuments')]")
	WebElement rejectedByOthers;
	
	@FindBy(css=".t21-js-dashboard-row-link.t21-desc-ellipsis-info>a")
	List<WebElement> recentViewedDocs;
	
	
	public WebElement getMyDocs()
	{
		return mydocs;
	}
	
	public WebElement getCheckOutByMe()
	{
		return checkoutbyme;
	}
	
	public WebElement getSearch()
	{
		return search;
	}
	
	public WebElement getGoButton()
	{
		return goButton;
	}
	
	public WebElement getFirstDocumentName()
	{
		return firstDocument;
	}
	
	public WebElement getContextMenu()
	{
		return contextMenu;
	}
	
	public WebElement getCheckinContextMenu()
	{
		return checkinContextMenu;
	}
	
	public WebElement getCheckoutContextMenu()
	{
		return checkoutContextMenu;
	}
	
	public WebElement getCheckinButton()
	{
		return checkinButton;
	}
	
	public WebElement getCheckinCloseButton()
	{
		return checkinCloseButton;
	}
	
	public WebElement getCheckoutPerson()
	{
		return checkoutPerson;
	}
	
	public WebElement getCheckoutConfirmButton()
	{
		return checkoutConfirmButton;
	}
	
	public WebElement getSignatureRoute()
	{
		return signatureRoute;
	}
	
	public WebElement getDocumentApproval()
	{
		return documentApproval;
	}
	
	public WebElement getEditModeON()
	{
		return editModeON;
	}
	
	public WebElement getSignatureRouteAddButton()
	{		
		return signatureroteAddButton;			
	}
	
	public WebElement getRouteApporvalContext()
	{		
		return routeApporvalContextMenu;			
	}
	
	public WebElement rejectedByOthers()
	{		
		return rejectedByOthers;			
	}
	
	public Select getRouteName()
	{		
		Select selectObj=new Select(routeName);
		return selectObj;		
	}
	
	public List<WebElement> getAllRecentViewedDocs()
	{
		return recentViewedDocs;
	}
	
	public boolean firstDocumentID(){

		element=getFirstDocumentName();
		String errorMessage = element.getText();
		boolean isValidationMessagePresent=false;

		if(errorMessage.contains(docID))
		{
			isValidationMessagePresent=true;
		}else{
			log.error("Document is not present.");
		}	
		return isValidationMessagePresent;
	}
	
	
	public void clickCreatedDocFromRecentViewed(String docID)
	{
		List<WebElement> list = getAllRecentViewedDocs();
		int numberOfEle = list.size();
		int i;
		for(i=0; i<numberOfEle; i++)
		{
			String str = list.get(i).getText();
			if(str.contains(docID))
			{
				int j = i+1;
				WebElement element = driver.findElement(By.xpath(".//*[@id='t21-workarea']/div/div/div[1]/div[1]/div[2]/div[3]/table/tbody/tr["+j+"]/td[1]/a"));
				
				element.click();
			}
		}
	}	
}