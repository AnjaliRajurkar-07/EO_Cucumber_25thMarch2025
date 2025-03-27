package PageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
  
public class AttendanceReport extends BasePage {
	
	//constructor
	public  AttendanceReport (WebDriver driver)
	{
		super(driver);
		
	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	
	
	//Elements
	@FindBy(xpath="//span[@class='header-trigger ng-star-inserted']") WebElement expandTab;
	@FindBy(xpath="//body//examonline-root//li[7]") WebElement Reports;
	@FindBy(xpath="//span[normalize-space()='Attendance']") WebElement AttendaceReport;
	@FindBy(xpath="//nz-select[@formcontrolname='examid']") WebElement ExamName;//click on dropdown of examname
	@FindBy(xpath="//div[@class='ant-select-item-option-content']") List<WebElement> ExamNamesvalue;
	@FindBy(xpath="//nz-select[@formcontrolname='reportby']") WebElement ReportBy; 
	@FindBy(xpath="//div//nz-option-item") List<WebElement> ReportByValue;
	@FindBy(xpath="//span[normalize-space()='Report by']") WebElement ClickOutside;
	@FindBy(xpath="//div[contains(text(),'Exam')]") WebElement Byexam;  
	@FindBy(xpath="//span[normalize-space()='View Report']") WebElement ViewReport;
	@FindBy(xpath="//tbody/tr/td[5]") WebElement Absent;
	@FindBy(xpath="//tr[1]/td[4]") WebElement EmailID;     //"xpath","selector":"//tr[1]/td[4]"
	@FindBy(xpath="//tr[1]/td[2]") WebElement CandidatePassword;
	@FindBy(xpath="//tr[1]/td[1]") WebElement UniqID;
	@FindBy(xpath="//tr[1]/td[3]") WebElement CandidateName;
	
	
	//Action methods
	public void gotoReport()
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();", Reports);
	}
	
	public void gotoAttendReport()
	{
	
		AttendaceReport.click();
	}
	
	public void clickExamName()
	{
		
	/*	Mywait.until(ExpectedConditions.visibilityOf(ExamName));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", ExamName);  */
		ExamName.click();
	    
	}
	
	public void selectExamName(String Ename)
	{
		
		
		
		for(WebElement option:ExamNamesvalue)
		{
		  
		   String Exname=option.getText();	
		    if(Exname.equals(Ename))
		    {
		    	option.click();
		    }
		}
		
	}
	
	public void clickReportBy()
	{
		ClickOutside.click();
		ReportBy.click();

	}
	
	public void selectReportBy() throws InterruptedException //String option parameter
	{ 
		wait.until(ExpectedConditions.visibilityOf(Byexam));
	//	Thread.sleep(3000);
		//	Byexam.click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", Byexam);
			
		
	}
	
	
	public void ClickViewReport()
	{   
		ViewReport.click();
	}
	
	public void goToAbsent()
	{
		Absent.click();

	}
	
	public String[] takeCerd() throws InterruptedException
	{   // Thread.sleep(3000);
	     String ExamInstruction="EI"; //Hard coded variable
	     wait.until(ExpectedConditions.visibilityOf(EmailID));
		 String Email=EmailID.getText();  
	     String CandiPass= CandidatePassword.getText();
	     String CandiUniqID=UniqID.getText();
	     String CandiName= CandidateName.getText();
	     return new String[] {ExamInstruction, Email, CandiPass, CandiUniqID, CandiName};
	}
	
	
	
}
