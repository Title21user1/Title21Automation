package org.title21.AdminModule_POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.title21.DBConnection.DBConnection;
import org.title21.DBConnection.DBQueries;
import org.title21.utility.BaseClass;

public class DashBord_POM

{
	BaseClass b = new BaseClass();
	DBConnection dbconnection = new DBConnection();
	DBQueries dbqueries = new DBQueries();
	
	protected WebDriver driver;
	
	public DashBord_POM(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css="#Dashboard>a>span")
	WebElement dashboard;
	
	@FindBy(css=".t21-grid-header-style" )
	WebElement headerstyle;
			
	@FindBy(xpath="//a[@title='CIBMTR']")
	WebElement CIBMTR;

	@FindBy(xpath="//li[@id='NavQueries']")
	WebElement queries;
	
	@FindBy(xpath="//li[@id='NavReports']")
	WebElement reports;
	
	@FindBy(xpath="//li[@id='NavCharts']")
	WebElement charts;
	
	@FindBy(xpath="//li[@id='CIBMTRSubmission']")
	WebElement submission;
	
	@FindBy(xpath="//li[@id='CIBMTRRetrieval']")
	WebElement retrieval;
	
	@FindBy(xpath="//li[@id='RFI']")
	WebElement rfi;
	
	@FindBy(xpath="//a[@title='Training']")
	WebElement LMS;
	
	@FindBy(xpath="//li[@id='PlanDevelopment']")
	WebElement trainingplans;
	
	@FindBy(xpath="//li[@id='CourseDevelopment']")
	WebElement trainingcourses;
	
	@FindBy(xpath="//li[@id='CourseReadyToSchedule']")
	WebElement schedulecourses;
	
	@FindBy(xpath="//li[@id='ScheduledCourses']")
	WebElement schedulelist;
	
	@FindBy(xpath="//li[@id='NeedsAssesments']")
	WebElement scheduletrainee;
	
	public WebElement toDashboard()
	{
		return dashboard;
	}
	
	public WebElement toCharts()
	{
		return charts;
	}
	
	public WebElement toCIBMTR()
	{
		return CIBMTR;
	}
	
	public WebElement toLMS()
	{
		return LMS;
	}
	
	public WebElement toQueries()
	{
		return queries;
	}
	
	public WebElement toSubmission()
	{
		return submission;
	}
	
	public WebElement toRetrieval()
	{
		return retrieval;
	}
	
	public WebElement toRFI()
	{
		return rfi;
	}
	
	public WebElement toReports()
	{
		return reports;
	}
	
	public WebElement toTraningPlans()
	{
		return trainingplans;
	}
	
	public WebElement toTraningCourses()
	{
		return trainingcourses;
	}
	
	public WebElement toScheduleCourse()
	{
		return schedulecourses;
	}
	
	public WebElement toScheduleList()
	{
		return schedulelist;
	}
	
	public WebElement toScheduleTrainee()
	{
		return scheduletrainee;
	}
	
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

	@SuppressWarnings("static-access")
	public void enableCIBMTR_LMS()
	{
		int CIBMTRValue = dbconnection.getIntDBValue(dbqueries.cibmtrValue, "CibmtrEnabled");
		int LMSValue = dbconnection.getIntDBValue(dbqueries.lmsValue, "LmsEnabled");
		
		if (CIBMTRValue==0)
		{
			dbconnection.getQueryExecuted(dbqueries.cibmtrEnable);
			System.out.println("CIBMTR enabled");
		}
		
		if (LMSValue==0)
		{
			dbconnection.getQueryExecuted(dbqueries.lmsEnable);
			System.out.println("LMS enabled");
		}
	}
	
	@SuppressWarnings("static-access")
	public void enableCIBMTR_LMS_ForGroup(String groupName)
	{
		int allowCIBMTRValue = dbconnection.getIntDBValue(dbqueries.allowCibmtrAccessValue+"'"+groupName+"'", "AllowCibmtrAccess");
		int allowLMSValue = dbconnection.getIntDBValue(dbqueries.allowLMSAccessValue+"'"+groupName+"'", "AllowLmsAccess");
		
		if (allowCIBMTRValue==0)
		{
			dbconnection.getQueryExecuted(dbqueries.allowCibmtrAccessEnable+"'"+groupName+"'");
			System.out.println("CIBMTR enabled for group "+groupName);
		}
		
		if (allowLMSValue==0)
		{
			dbconnection.getQueryExecuted(dbqueries.allowLMSAccessEnable+"'"+groupName+"'");
			System.out.println("LMS enabled for group "+groupName);
		}
	}
	
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
