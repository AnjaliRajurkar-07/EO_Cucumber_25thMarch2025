package StepsDefinations;

import java.io.IOException;
import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import EOFactory.BaseClass;
import PageObjects.AdminLogin;
import PageObjects.AttendanceReport;
import PageObjects.CandidatePortal;
import io.cucumber.java.en.*;




public class IBTExam {
	 WebDriver driver;
	 AdminLogin add;
	 Properties p;
	 AttendanceReport AttdReport;
	 CandidatePortal Caddport;
	 

	@Given("the Admin logs in to the admin portal")
	public void the_admin_logs_in_to_the_admin_portal() throws InterruptedException {
	    add=new AdminLogin(BaseClass.getDriver());
	    add.EnterUsername("Autotest@examonline.in");
	    add.EnterPass("Dbs@1235");
	    //add.CheckboxRobot();
		//Thread.sleep(3000);
	    //driver.wait(3000);
	    add.clickSignIn();
	    
	}
    
	@Given("the candidate taking credentials from the attendance sheet for {string}")
	public void the_candidate_taking_credentials_from_the_attendance_sheet(String examName) throws InterruptedException {
		AttdReport=new AttendanceReport(BaseClass.getDriver());  //Initialize web elements
		AttdReport.gotoReport();
       
		AttdReport.gotoAttendReport();
		AttdReport.clickExamName();
	    AttdReport.selectExamName(examName);
	    Thread.sleep(3000);
		AttdReport.clickReportBy();
		Thread.sleep(3000);
		AttdReport.selectReportBy(); //"Exam" parameter
		Thread.sleep(3000);
		AttdReport.ClickViewReport();
		AttdReport.goToAbsent();
		AttdReport.takeCerd();
		
	}

	@Given("the candidate navigates to the candidate login page and logged in")
	public void the_candidate_navigates_to_the_candidate_login_page_and_logged_in() throws IOException, InterruptedException
	{
		Caddport=new CandidatePortal(BaseClass.getDriver());
		AttdReport=new AttendanceReport(BaseClass.getDriver());
		String[] Credentials=AttdReport.takeCerd();
		System.out.println(Credentials); 
		Caddport.openCandidatePortal(); 
		Caddport.CandidateLoginPage(Credentials[1], Credentials[2]); 
		//Thread.sleep(3000);
        
	}

	

	@Then("verify the candidate is able to see the dashboard") //---->breaking
	public void verify_the_candidate_is_able_to_see_the_dashboard()
	{
		Caddport=new CandidatePortal(BaseClass.getDriver());
		Caddport.verifyDashboard();
		
		/*if(Caddport.verifyDashboard(EName)==true)
		{
			System.out.println("Exam name is "+ EName);
		}
		else {System.out.println("Exam Name is Mismatched ");}  
	*/
	}
	
		@When("the candidate clicks the start button for the IBT exam")
	public void the_candidate_clicks_the_start_button_for_the_ibt_exam() throws InterruptedException 
	{
		Caddport=new CandidatePortal(BaseClass.getDriver());
		boolean exs=Caddport.verifyExamStatusforIBTExam();
		Assert.assertEquals(exs, true);
	    System.out.println("Exam status is Start");
	  
	}

		
	
			@Then("verify if the candidate should see the instruction page and other details")
	public void verify_if_the_candidate_should_see_the_instruction_page_and_other_details() throws InterruptedException
			{
				
	      System.out.println("Candidate clicking start button");
	      Caddport=new CandidatePortal(BaseClass.getDriver());
	      AttdReport=new AttendanceReport(BaseClass.getDriver());
	      
	      Caddport.verifyInstructionsPage();
	     // Thread.sleep(3000);
	      
	    }

	@Then("verify if the candidate see Remaining Exam Time and exam name")
	public void verify_if_the_candidate_see_remaining_exam_time_and_exam_name() throws InterruptedException
	{
          Caddport=new CandidatePortal(BaseClass.getDriver());
		  Caddport.VerifyExamName();
	
	}


	@Then("verify MCSA Question and select option")
	public void verify_MCSA_Question_and_select_option() {
	    
		Caddport=new CandidatePortal(BaseClass.getDriver());
		Caddport.VerifyMarksForMCSA();
		Caddport.verifyQuestionNoForMCSA();
		Caddport.verifyQuestionTextForMCSA();
		Caddport.verifyOptionsMCSA();
		Caddport.selectMCSAAnswer(); 
		
	}
     
	@Then("verify MCMA Question and select option")
       public void verify_MCMA_Question_and_select_option() throws InterruptedException {

		Caddport=new CandidatePortal(BaseClass.getDriver());
		Caddport.VerifyMarksForMCMA();
	    Caddport.verifyQuestionNoForMCMA();
		Caddport.verifyQuestionTextForMCMA();
		Caddport.verifyOptionsMCMA();
	//	Thread.sleep(3000);
		Caddport.selectMCMAAnswer();
		
	}

	@Then("verify TF Question and select option")
    public void verify_TF_Question_and_select_option() {

		Caddport=new CandidatePortal(BaseClass.getDriver());
		Caddport.VerifyMarksForTF();
	    Caddport.verifyQuestionNoForTF();
		Caddport.verifyQuestionTextForTF();
		Caddport.verifyOptionsTF();
		Caddport.selectTFAnswer(); 
		
	}
	
	@Then("verify Essay Question and give answer")
	public void verify_Essay_Question_and_give_answer(){
		Caddport=new CandidatePortal(BaseClass.getDriver());
		Caddport.VerifyMarksForEssayQue();
		Caddport.verifyQuestionNoForEssay();
		Caddport.verifyQuestionTextForEssay();
		Caddport.giveanswerForEssayTypeQuestion();
	    
		
		
	}
	
	@Then ("verify SA Question and give answer")
	public void verify_SA_Question_and_give_answer() {
		Caddport=new CandidatePortal(BaseClass.getDriver());
		Caddport.VerifyMarksForShortAnsQue();
		Caddport.verifyQuestionNoForShortAns();
		Caddport.verifyQuestionNoForShortAns();
		Caddport.giveAnswerForShortAnswer();
	}
	
	@Then("verify FU Question")
	public void verify_FU_Question()
	{
		Caddport=new CandidatePortal(BaseClass.getDriver());
		Caddport.VeiryFUQues();
	}
	
	@Then ("verify Likert Question")
	public void verify_Likert_Question ()
	{
		Caddport=new CandidatePortal(BaseClass.getDriver());
		Caddport.verifyLikertQues();
	}
	
	@Then ("verify Numeric Value Question")
    public void verify_Numeric_Value_Question () 
    {
		Caddport= new CandidatePortal (BaseClass.getDriver());
		Caddport.verifyNumericValueQues();
		
    }
	
	@Then ("verify Exam submission")
	public void verify_Exam_submission ()
	{
		Caddport= new CandidatePortal (BaseClass.getDriver());
		Caddport.VerifyExamSubmissionButton();
		Caddport.VerifyExamSubmission();
	}
	
	@Then ("candidate closing exam window")
	public void candidate_closing_exam_window ()
	{
		Caddport= new CandidatePortal (BaseClass.getDriver());
		Caddport.closeExamWindow();
	}
	
	@Then ("candidate relogin to exam")
	public void candidate_relogin()
	{
		Caddport= new CandidatePortal (BaseClass.getDriver());
		Caddport.relogin();
	}
	
	@Then ("verify if candidate clicking next button")
	public void Candidate_Clicking_Next_BUtton()
	{
		Caddport= new CandidatePortal (BaseClass.getDriver());
		Caddport.ClickNextButton();
		
	}
	/*
	@Then("verify if candidate clicking next button")
	public void verify_if_candidate_clicking_next_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("verify if candidate see the question2 and select multi options and moving to next question")
	public void verify_if_candidate_see_the_question2_and_select_multi_options_and_moving_to_next_question() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("verify if candidate see the question3 and select option and moving to next question")
	public void verify_if_candidate_see_the_question3_and_select_option_and_moving_to_next_question() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("verify if candidate see the question4 and attempt eassay type question and moving to next question")
	public void verify_if_candidate_see_the_question4_and_attempt_eassay_type_question_and_moving_to_next_question() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("verify if candidate see the question5 and attempt short answer question and moving to next question")
	public void verify_if_candidate_see_the_question5_and_attempt_short_answer_question_and_moving_to_next_question() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("verify if candidate see the question6 and attempt file upload question and moving to next question")
	public void verify_if_candidate_see_the_question6_and_attempt_file_upload_question_and_moving_to_next_question() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("verify if candidate see the question7 and attempt likert scale question and moving to next question")
	public void verify_if_candidate_see_the_question7_and_attempt_likert_scale_question_and_moving_to_next_question() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("verify if candidate see the question8 and attempt calculated numeric question and moving to next question")
	public void verify_if_candidate_see_the_question8_and_attempt_calculated_numeric_question_and_moving_to_next_question() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@When("candidate submit the exam")
	public void candidate_submit_the_exam() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("verify if candidate see Exam submission pop up")
	public void verify_if_candidate_see_exam_submission_pop_up() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("verify if candidate see Thank You! page")
	public void verify_if_candidate_see_thank_you_page() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

	@Then("verify if candidate see close window button")
	public void verify_if_candidate_see_close_window_button() {
	    // Write code here that turns the phrase above into concrete actions
	    throw new io.cucumber.java.PendingException();
	}

*/
}
	
	
	
	
	



