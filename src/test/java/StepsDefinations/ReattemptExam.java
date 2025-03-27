package StepsDefinations;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import EOFactory.BaseClass;
import PageObjects.AdminLogin;
import PageObjects.AttendanceReport;
import PageObjects.CandidatePortal;
import io.cucumber.java.en.*;


public class ReattemptExam {
	
	WebDriver driver;
	 AdminLogin add;
	 Properties p;
	 AttendanceReport AttdReport;
	 CandidatePortal Caddport;
	 
	 
	 @Then("verify the candidate is able to see the dashboard for reattempt exam")
	 public void verify_the_candidate_is_able_to_see_the_dashboard_for_reattempt_exam ()
	 {
		 Caddport=new CandidatePortal(BaseClass.getDriver());
		 Caddport.verifyExamForReattempt();
		
	 }
	 
	 
	 
	 
		@When("the candidate clicks the start button for the Reattempt exam")
		public void the_candidate_clicks_the_start_button_for_the_ibt_exam() throws InterruptedException 
		{
			Caddport=new CandidatePortal(BaseClass.getDriver());
			System.out.println("redirected to reattempt steps defination file");
			boolean exs=Caddport.verifyExamStatusforReattemptExam();
			Assert.assertEquals(exs, true);
		    System.out.println("Exam status is Start");
		  
		}
	
	

}
