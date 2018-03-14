package org.title21.POM;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	@FindBy(xpath=".//*[@id='set-1']/div/a")
	WebElement	checkoutbyme;
	
	@FindBy(xpath=".//*[@id='t21-workarea']/div/div/div/div[2]/div/div[3]/div/table/tbody/tr[1]/td[2]/a")
	WebElement	firstDocument;
	
	@FindBy(xpath=".//*[@id='dialog-form']/div/div/div[3]/button")
	List<WebElement> recentViewedDocs;
	
	
	public WebElement getMyDocs()
	{
		return mydocs;
	}
	
	public WebElement getCheckOutByMe()
	{
		return checkoutbyme;
	}
	
	public WebElement getFirstDocumentName()
	{
		return firstDocument;
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
	
	public WebElement clickCreatedDoc()
	{
		
		return null;
		
	}
}
