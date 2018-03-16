package org.title21.Documents_POM;

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
	static Logger log = Logger.getLogger(MyDocs_POM.class);
	
	public MyDocs_POM(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath=".//*[@id='NavMyDocs']/a/span")
	WebElement	mydocs;
	
	@FindBy(xpath=".//*[@id='set-1']/div/a")
	WebElement	checkoutbyme;
	
	@FindBy(xpath=".//*[@id='t21-workarea']/div/div/div/div[2]/div/div[2]/div/div/form/div/input")
	WebElement	search;
	
	@FindBy(xpath=".//*[@id='t21-workarea']/div/div/div/div[2]/div/div[2]/div/div/form/div/span[1]/button")
	WebElement	goButton;
	
	@FindBy(xpath=".//*[@id='t21-workarea']/div/div/div/div[2]/div/div[3]/div/table/tbody/tr[1]/td[2]/a")
	WebElement	firstDocument;
	
	@FindBy(xpath=".//*[@id='displaySel']/div[1]/div[3]/div/a/span[1]")
	WebElement	contextMenu;
	
	@FindBy(xpath=".//*[@id='displaySel']/div[1]/div[3]/div/ul/li[12]/div/a/span[2]")
	WebElement	checkinContextMenu;
	
	@FindBy(xpath=".//*[@id='displaySel']/div[1]/div[3]/div/ul/li[13]/div/a/span[2]")
	WebElement	checkoutContextMenu;
	
	@FindBy(xpath=".//*[@id='displaySel']/div[1]/div[3]/div/ul/li[12]/div/a/span[2]")
	WebElement	routeApporvalContextMenu;
	
	@FindBy(xpath=".//*[@id='default-modal']/div/form/div/div[3]/input")
	WebElement	checkinButton;
	
	@FindBy(xpath=".//*[@id='dialog-form']/div/div/div[3]/button")
	WebElement	checkinCloseButton;
	
	@FindBy(id="CheckedOutTo")
	WebElement	checkoutPerson;
	
	@FindBy(xpath=".//*[@id='default-modal']/div/form/div/div[3]/input")
	WebElement	checkoutConfirmButton;
	
	@FindBy(xpath=".//*[@id='DocumentApprovalsTab']/div/div/div[1]/div[3]/div[1]/div[2]/a")
	WebElement	signatureRoute;
	
	@FindBy(xpath=".//*[@id='displaySel']/div[2]/ul/li[3]/a[1]")
	WebElement	documentApproval;
		
	@FindBy(xpath=".//*[@id='lock']/a[2]")
	WebElement	editModeON;
	
	@FindBy(xpath=".//*[@id='default-modal']/div/form/div/div[2]/div[1]/div[2]/select")
	WebElement	routeName;
	
	@FindBy(xpath=".//*[@id='default-modal']/div/form/div/div[3]/input")
	WebElement signatureroteAddButton;
	
	@FindBy(xpath=".//*[@id='set-2']/div/a")
	WebElement rejectedByOthers;
	
	@FindBy(xpath=".//*[@id='t21-workarea']/div/div/div[1]/div[1]/div[2]/div[3]/table/tbody/tr/td[1]/a")
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