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
	
	public WebElement toQueries()
	{
		return queries;
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
