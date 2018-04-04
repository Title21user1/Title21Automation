package org.title21.POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.title21.utility.BaseClass;

public class DashBord_POM

{
	BaseClass b=new BaseClass();
	protected WebDriver driver;
	
	@FindBy(css="#Dashboard>a>span")
	WebElement dashboard;
	
	@FindBy(css=".t21-grid-header-style" )
	WebElement headerstyle;
			
	public DashBord_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement toDashboard()
	{
		return dashboard;
	}
	
	/*
	 * 
	 * This method verify text on dashboard - (Dashboard). 
	 * @param WebDriver obj
	 */
	
	public boolean verifyDashboardPrescence(){
		
		String dashboredtext = dashboard.getText();
		System.out.println(dashboredtext);
		
		if(dashboredtext.equals("Dashboard"))
		{
			return true;
		}
		else
		{
			return false;
		}
		
	}
	
	/*
	 * 
	 * 
	 */
	
	public boolean verifyHeaderStyle(){
		
		String headstyletext = headerstyle.getText();
		System.out.println(headstyletext);
		if(headstyletext.equals("Administrator's Dashboard"))
		{
			return true;
		}
		else
		{
			return false;
		}
				
	}
}
