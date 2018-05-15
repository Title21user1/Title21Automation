package org.title21.Documents_POM;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.title21.utility.BaseClass;

public class NonCollaborationTask_POM {
	public WebDriver driver;
	public String documetNo = "";
	public WebElement element;
	BaseClass BaseClass = new BaseClass();
	static Logger log = Logger.getLogger(NonCollaborationTask_POM.class);
	

	public NonCollaborationTask_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = ".fa.fa-pencil.action-items")
	WebElement edit_task;
	//tets
	@FindBy(css = ".t21-js-user-message-text.t21-user-message-text")
	WebElement delete_popup_message;
	
	@FindBy(css = ".btn.t21-btn-primary.t21-ajax-submit-button.process-btn-click")
	WebElement YesButtonOfDeletePopup;
	
	@FindBy(css = "#DueDate")
	WebElement DueDate;
	
	@FindBy(css = ".fa.fa-trash-o.action-items")
	WebElement delete_button;
	
	@FindBy(css = "#Notes")
	WebElement notes;
	
	@FindBy(css = ".fa.fa-pencil.action-items-disabled")
	WebElement disable_edit_mode;
	
	@FindBy(css = ".btn.t21-btn-primary.t21-ajax-submit-button")
	WebElement update;
	public WebElement getdelete_popup_message() 
	{

		return delete_popup_message;
	}
	
	public WebElement getDueDate() 
	{

		return DueDate;
	}
	
	public WebElement getdelete_button() 
	{

		return delete_button;
	}
	public WebElement getYesButtonOfDeletePopup() 
	{

		return YesButtonOfDeletePopup;
	}
	public WebElement geteditbutton() 
	{

		return edit_task;
	}
	public WebElement getdisable_edit_mode() 
	{

		return disable_edit_mode;
	}
	
	public WebElement getNotes() 
	{

		return notes;
	}
	
	public WebElement getupdate() 
	{

		return update;
	}
	
	
}


