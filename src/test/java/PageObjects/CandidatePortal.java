package PageObjects;

//import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import EOFactory.BaseClass;
import junit.framework.Assert;



public class CandidatePortal extends BasePage{

	Properties p;  //new
	
	//constructor
	public CandidatePortal(WebDriver driver)
	{
		super(driver);
	}
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
	
	//Elements
	@FindBy(xpath="//input[@id='UserName']") WebElement UserName;
	@FindBy(xpath="//input[@id='Password']") WebElement Password;
	@FindBy(xpath="//re-captcha[@id='ngrecaptcha-0'][1]") WebElement Checkbox;  
	@FindBy(xpath="//button[@id='btnLogin']") WebElement SignMeIn;
	@FindBy(xpath="//img[@alt='Large EO Logo']") WebElement EOLogo;
	@FindBy(xpath="//strong[normalize-space()='IBT exam']") WebElement IBTExam;
	@FindBy(xpath="//span[normalize-space()='Reattempt exam']") WebElement ReattemptExam;
	
    @FindBy(css="div[class='p-3'] div:nth-child(1) div:nth-child(1) div:nth-child(4) a:nth-child(1)") WebElement StartButtonforIBTExam;
    @FindBy(css="div[class='row'] div:nth-child(2) div:nth-child(1) div:nth-child(4) a:nth-child(1)") WebElement StartButtonforReattemptExam;
                 
    @FindBy(xpath="//a[normalize-space()='Resume']")WebElement ResumeButton;
    @FindBy(xpath="//button[normalize-space()='Proceed']") WebElement PrivacyPolicy;
	@FindBy(xpath="//div[@id='examInstructionText']") WebElement ExaminationInstruction;
	@FindBy(xpath="//span[@class='spn_can_name']") WebElement CandidateName;
	@FindBy(xpath="//span[@id='eid']") WebElement ExamID; 
	@FindBy(xpath="//label[contains(text(),'I have read and understood the instructions of exa')]") WebElement CheckInstru; 
	@FindBy(xpath="//span[@id='eid']") WebElement CUniqueID; 
	@FindBy(xpath="//a[@id='btnLaunchExam']") WebElement BeginExamination;
	@FindBy(xpath="//div[@class='col col-12 text-ellipsis'][1]") WebElement ExamName;	
	@FindBy(xpath="//span[@id='spnRemTime']") WebElement RemainingTime;
	@FindBy(xpath="//p[@class='col col-3 small text-muted font-weight-bold mb-0 p-0 align-self-center text-nowrap d-flex justify-content-end']") WebElement marksForQuestion;
	@FindBy(xpath="//p[@class='small text-muted font-weight-bold mb-0 col-8 p-0 align-self-center text-nowrap']") WebElement QuestionNo;
//	@FindBy(xpath="//p[@id='divQuestionText']") WebElement questiontext; 
	@FindBy(xpath="//p[@id='divQuestionText']") WebElement QuestionText; 
	@FindBy(xpath="//button[@id='btnPreviousQue']") WebElement previousButton; 
	@FindBy(xpath="//button[@id='btnNextQue']") WebElement nextButton; 
	@FindBy(xpath="//button[@id='btnResetAns']") WebElement clearResponse; 
	@FindBy(xpath= "//button[normalize-space()='Mark For Review']") WebElement markforReview; 
	@FindBy(xpath= "//button[normalize-space()='Submit Exam']")WebElement SubmitButton; 
	@FindBy(xpath="//i[@id='instructionicon']") WebElement instructionsIcon; 
	@FindBy (xpath="//i[@id='Notes']") WebElement roughNotes; 
	@FindBy(xpath="//img[@id='calculator']")WebElement calculator ; 
	@FindBy (xpath="//div[@class='col col-9']") WebElement AttemptSummaryDrp; 
	@FindBy(xpath="//div[@class='legend-sm answered spnAnsQues']")WebElement answeredCount; 
	@FindBy(xpath="//div[@class='legend-sm mark-review spnMarkRevQues']") WebElement markForReview; 
	@FindBy(xpath="//div[@class='legend-sm not-answered spnUnansQues']") WebElement noAnswered; 
	@FindBy(xpath="//button[@class='btn btn-blue m-1 fs-13 w-100 overflow-ellipsis']") WebElement sectionName; 
	@FindBy(xpath="//div[contains(text(),'1')]")WebElement Quest1legend; 
	@FindBy(xpath="//div[contains(text(),'2')]")WebElement Quest2legend ; 
	@FindBy(xpath="//img[@class='img-fluid can-profile-pic ng-star-inserted']") WebElement candidateImageInScreen; 
	@FindBy(xpath="//span[@id='examineeid']") WebElement UniqIdOnExamScreen;
	@FindBy(xpath="//b[contains(text(),'Privacy Policy for Remote Proctored Exam Applicati')]") WebElement privacyContent;
	@FindBy(xpath="//button[normalize-space()='Submit Exam']") WebElement Submit;
	@FindBy(xpath="//h5[normalize-space()='Are you sure you want to submit the test?']") WebElement ExamSummary;
	@FindBy(css="#btnCancelEndTest") WebElement GoBack;
	@FindBy(css="#btnFinalEndTest") WebElement SubmitFinal;
	@FindBy(css="#btnSubmit") WebElement closeWindow;
	
	
	//For MCSA Question: 
	//options 
	@FindBy(xpath="//input[@id='Opt25438']")WebElement Option1MCSA;  
	@FindBy(xpath="//input[@id='Opt25439']")WebElement Option2MCSA;  
	@FindBy(xpath="//input[@id='Opt25440']")WebElement Option3MCSA;  
	@FindBy(xpath="//input[@id='Opt25441']")WebElement Option4MCSA;  
	@FindBy(xpath="//input[@id='Opt25442']")WebElement Option5MCSA;  
	//option text 
	@FindBy(css="label[for='Opt25438']")WebElement Opt1MCSA;  
	@FindBy(css="label[for='Opt25439']")WebElement Opt2MCSA;  
	@FindBy(css="label[for='Opt25440'] p")WebElement Opt3MCSA;
	@FindBy(css="label[for='Opt25441'] p")WebElement Opt4MCSA;  
	@FindBy(css="label[for='Opt25442'] p")WebElement Opt5MCSA;  
	
	//For MCMA Question:  //label[@for='Opt25445']
	//options
		@FindBy(xpath="//input[@id='Opt25443']")WebElement Option1MCMA;
		@FindBy(xpath="//input[@id='Opt25444']")WebElement Option2MCMA;
		@FindBy(xpath="//input[@id='Opt25445']")WebElement Option3MCMA;
		@FindBy(xpath="//input[@id='Opt25446']")WebElement Option4MCMA;
		@FindBy(xpath="//input[@id='Opt25447']")WebElement Option5MCMA;
		//option text
		@FindBy(css="label[for='Opt25443']")WebElement Opt1MCMA;
		@FindBy(css="label[for='Opt25444']")WebElement Opt2MCMA;
		@FindBy(css="label[for='Opt25445'] p")WebElement Opt3MCMA;
		@FindBy(css="label[for='Opt25446'] p")WebElement Opt4MCMA;
		@FindBy(css="label[for='Opt25447'] p")WebElement Opt5MCMA;
		
		// Restricted response validation
		@FindBy(xpath="//div[@class='note-container ng-star-inserted']") WebElement RestrictRespoValidatn;
	
	//For TF questions:
	@FindBy(xpath="//label[normalize-space()='True']")WebElement OptTrue;
	@FindBy(xpath="//label[normalize-space()='False']")WebElement OptFalse;
	
	//Option Text
	@FindBy(xpath="//label[normalize-space()='True']")WebElement OptTextTrue;
	@FindBy(xpath="//label[normalize-space()='False']")WebElement OptTextFalse; 
	 
	
	//For Essay type question:
	@FindBy(xpath="//div[@class='wordCount d-flex justify-content-end table-header-2 ng-star-inserted']") WebElement WordCount;
	@FindBy(xpath="//div[@role='textbox']//p") WebElement AnsInputBox;
	
	//Short Answer type question
	@FindBy(xpath="//textarea[@id='responseTxtArea']") WebElement SAnsInputBox;
	
	//File upload question
	@FindBy(xpath="//input[@id='fileUpload']") WebElement ChooseFile;
	@FindBy(xpath="//button[@id='btnUpload']") WebElement UploadButton;
	@FindBy(xpath="//a[normalize-space()='Success']") WebElement succcessButton;
	
	//Likert Scale
	@FindBy(css="label[for='Opt25450']") WebElement likertScaleOption1;
	@FindBy(css="label[for='Opt25451']") WebElement likertScaleOption2;
	@FindBy(css="label[for='Opt25452']") WebElement likertScaleOption3;
	@FindBy(css="label[for='Opt25453']") WebElement likertScaleOption4;
	
	//Numeric Value Question
	@FindBy(css="input[placeholder='enter your answer in integer, decimal or e-notation']") WebElement inputForNumericValue;
	@FindBy(css="div.box") WebElement KeyPad;
	@FindBy(css="button[value='1']") WebElement Value1FromkeyPad; 
	@FindBy(css="button[value='2']") WebElement Value2FromkeyPad; 
	@FindBy(css="button[value='3']") WebElement Value3FromkeyPad; 
	@FindBy(css="button[value='4']") WebElement Value4FromkeyPad; 
	@FindBy(css="button[value='5']") WebElement Value5FromkeyPad; 
	@FindBy(css="button[value='6']") WebElement Value6FromkeyPad;
	@FindBy(css="button[value='7']") WebElement Value7FromkeyPad;
	@FindBy(css="button[value='8']") WebElement Value8FromkeyPad;
	@FindBy(css="button[value='9']") WebElement Value9FromkeyPad;
	@FindBy(css="button[value='0']") WebElement Value0FromkeyPad;
	@FindBy(css="button[value='.']") WebElement pointFromkeyPad;
	@FindBy(css="button[value='-']") WebElement negativeFromkeyPad;
	@FindBy(css=".bi.bi-backspace.f-20") WebElement BackspaceFromkeyPad;
	
	
	
	//Methods====================================================================
	public void openCandidatePortal() throws IOException, InterruptedException {
		driver.switchTo().newWindow(WindowType.TAB);
		p=BaseClass.getProperties();
        driver.get(p.getProperty("CPortal")); 
        driver.manage().window().maximize();
      //  Thread.sleep(3000);
        String CandidateWindow=driver.getWindowHandle();
      //  driver.switchTo().window(CandidateWindow);
        System.out.println("The candidate portal window ID is: "+ CandidateWindow);
        
	}
	
	public void CandidateLoginPage(String UserID, String CandiPass) throws IOException, InterruptedException
	{   
		UserName.sendKeys(UserID);
		Password.sendKeys(CandiPass);
		//Checkbox.click();
		wait.until(ExpectedConditions.visibilityOf(SignMeIn));
		SignMeIn.click(); 
		
	}
	
	public boolean verifyDashboard()     
	{   boolean verifyExam=IBTExam.isDisplayed();
	    assertEquals(verifyExam,true);
	    System.out.println("exam name displayed");
		return verifyExam;
	}
	
	public boolean verifyExamStatusforIBTExam()
	{ wait.until(ExpectedConditions.visibilityOf(StartButtonforIBTExam));
		boolean checkstatus=StartButtonforIBTExam.isDisplayed();
		StartButtonforIBTExam.click();
		return checkstatus;

	}
	
	
	public boolean verifyExamStatusforReattemptExam()
	{ wait.until(ExpectedConditions.visibilityOf(StartButtonforReattemptExam));
		boolean checkstatus=StartButtonforReattemptExam.isDisplayed();
		StartButtonforReattemptExam.click();
		return checkstatus;

	}
	
	public void verifyExamForReattempt()
	{
	
		
	}
	
	public void verifyInstructionsPage() throws InterruptedException 
	{  	
		Thread.sleep(4000);
		Set<String> ExamWindow=driver.getWindowHandles(); 	   
	   
	    String lastElement=null;
	    List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
	    String lastWindow = windowsList.get(windowsList.size() - 1);
	    driver.switchTo().window(lastWindow);
	    
	    
	    
	    assertEquals(privacyContent.getText(), "Privacy Policy for Remote Proctored Exam Application");
	   // Thread.sleep(3000);
	   // wait.until(ExpectedConditions.visibilityOf(PrivacyPolicy)); 
	    PrivacyPolicy.click();
	    wait.until(ExpectedConditions.visibilityOf(ExaminationInstruction));
	    
	    System.out.println("Exam instruction display: "+ ExaminationInstruction.isDisplayed());
		System.out.println("Candidate Name display: "+ CandidateName.isDisplayed());
		System.out.println("Candidate Name display: "+ CUniqueID.isDisplayed());
		 wait.until(ExpectedConditions.visibilityOf(CheckInstru)); 
	    
	    CheckInstru.click();
	    BeginExamination.click();
	   
	   
	}
	
	public void VerifyExamName() throws InterruptedException
	{
		System.out.println("Exam Name on exam screen: " + ExamName.isDisplayed());
	//	wait.until(ExpectedConditions.visibilityOf(RemainingTime)); 
		System.out.println("Exam Reaming time on exam screen: " + RemainingTime.isDisplayed());
	}
	
	///Verify MCSA Question:-----
	//Verify question marks on exam screen
	public void VerifyMarksForMCSA()
	{
		String RealMarks= "2.00 Marks";
		String QuestionMarks=marksForQuestion.getText();
		if(QuestionMarks.equals(RealMarks))
		{
			System.out.println("Marks are not matched for MCSA Question");
		}
		else {System.out.println("Marks are not matched for MCSA Question");}
	}
	
	//Verify question no on exam screen
	public void verifyQuestionNoForMCSA()
	{   String MCSAQuestionNoOnScreen= "QUESTION 1 OF 8";
		String mcsaQuestionNo=QuestionNo.getText();
		
		if(mcsaQuestionNo.equals(mcsaQuestionNo))
		{
			System.out.println("Marks No matched for MCSA Question");
		}
		else {System.out.println("Marks No not matched for MCSA Question");}
		
	}
	
	//Verify Text correctly displayed or not 
	public void verifyQuestionTextForMCSA()
	{
		System.out.println(QuestionText.isDisplayed());
	    String questTextMCSA=QuestionText.getText();
	    String MCSAQuestText="Question text1 MCSA";
       //assertEquals(questTextMCSA, MCSAQuestText, "MCSA Question text matched!!!");
        assertEquals(questTextMCSA, MCSAQuestText);
	}
	
  
	
	public void verifyOptionsMCSA()
	{
	  System.out.println("Option 1 radio button for MCSA is enabled: "+Option1MCSA.isEnabled());
	  System.out.println("Option 2 radio button for MCSA is enabled: "+Option2MCSA.isEnabled());
	  System.out.println("Option 3 radio button for MCSA is enabled: "+Option3MCSA.isEnabled());
	  System.out.println("Option 4 radio button for MCSA is enabled: "+Option4MCSA.isEnabled());
	  
	  String MCSAOption1=Opt1MCSA.getText();
	  System.out.println(MCSAOption1);
	  String MCSAOption2=Opt2MCSA.getText();
	  String MCSAOption3=Opt3MCSA.getText();
	  String MCSAOption4=Opt4MCSA.getText();
	  
	  String Act_MCSAOption1="opt1";  
	  String Act_MCSAOption2="opt2"; 
	  String Act_MCSAOption3="opt3";
	  String Act_MCSAOption4="opt4";
	  
	  assertEquals(Act_MCSAOption1, MCSAOption1,"MCSA Question option 1 text matched!!!");
	  assertEquals(Act_MCSAOption2, MCSAOption2,"MCSA Question option 2 text matched!!!");
	  assertEquals(Act_MCSAOption3, MCSAOption3,"MCSA Question option 3 text matched!!!");
	  assertEquals(Act_MCSAOption4, MCSAOption4,"MCSA Question option 4 text matched!!!");
	} 
	
     public void selectMCSAAnswer()
	{
		Opt1MCSA.click();     
	    nextButton.click();
		System.out.println("MCSA question verified and answered successfully");
	}
	
	
	///Verify MCMA Question:-----
	
	public void VerifyMarksForMCMA()
	{
		String RealMarks= "2.00 Marks";
		String QuestionMarks=marksForQuestion.getText();
		if(QuestionMarks.equals(RealMarks))
		{
			System.out.println("Marks are not matched for MCMA Question");
		}
		else {System.out.println("Marks are not matched for MCMA Question");}
	} 
	
	public void verifyQuestionNoForMCMA()
	{   String MCMAQuestionNoOnScreen= "QUESTION 2 OF 8";
		String MCMAQuestionNo=QuestionNo.getText();
		
		if(MCMAQuestionNo.equals(MCMAQuestionNoOnScreen))
		{
			System.out.println("Marks No matched for MCMA Question");
		}
		else {System.out.println("Marks No not matched for MCMA Question");}
		
	}
	
	public void verifyQuestionTextForMCMA()
	{
		System.out.println(QuestionText.isDisplayed());
	    String questTextMCMA=QuestionText.getText();
	    String MCMAQuestText="Question text2 MCMA";
        //Assert.assertEquals(questTextMCMA, MCMAQuestText);
        if(questTextMCMA.equals(MCMAQuestText))
        {
        	System.out.println("Question Text for MCMA is verified");
        }
	}
	
	public void verifyOptionsMCMA()
	{
	  System.out.println("Option 1 radio button for MCMA is enabled: "+Option1MCMA.isEnabled());
	  System.out.println("Option 2 radio button for MCMA is enabled: "+Option2MCMA.isEnabled());
	  System.out.println("Option 3 radio button for MCMA is enabled: "+Option3MCMA.isEnabled());
	  System.out.println("Option 4 radio button for MCMA is enabled: "+Option4MCMA.isEnabled());
	  
	  String MCMAOption1=Opt1MCMA.getText();
	  String MCMAOption2=Opt2MCMA.getText();
	  String MCMAOption3=Opt3MCMA.getText();
	  String MCMAOption4=Opt4MCMA.getText();
	 
	  String Act_MCMAOption1="A1";  
	  String Act_MCMAOption2="A2"; 
	  String Act_MCMAOption3="A3";
	  String Act_MCMAOption4="A4";
	  
	  assertEquals(Act_MCMAOption1, MCMAOption1, "MCMA Question option 1 text matched!!!");
	  assertEquals(Act_MCMAOption2, MCMAOption2, "MCMA Question option 2 text matched!!!");
	  assertEquals(Act_MCMAOption3, MCMAOption3, "MCMA Question option 3 text matched!!!");
	  assertEquals(Act_MCMAOption4, MCMAOption4, "MCMA Question option 4 text matched!!!");
	}
	
	public void selectMCMAAnswer()
	{  
	    Opt2MCMA.click();
		Opt3MCMA.click();
		
        if (Opt2MCMA.isSelected() && Opt3MCMA.isSelected() )
        {   boolean option1IsSelected= Opt1MCMA.isEnabled();
        	boolean option4IsSelected=Opt4MCMA.isEnabled();
        	
        	assertFalse(option1IsSelected);
            assertFalse(option4IsSelected);
        	assertFalse(option4IsSelected);
            
        }
        assertTrue(RestrictRespoValidatn.isDisplayed());
        System.out.println("Response restricted successfully for MCMA question");
		System.out.println("MCMA question verified and answered successfully");
		nextButton.click();
	}
	
	
	//Verify True & False question
	
	public void VerifyMarksForTF()
	{
		String RealMarks= "2.00 Marks";
		String QuestionMarks=marksForQuestion.getText();
		if(QuestionMarks.equals(RealMarks))
		{
			System.out.println("Marks are not matched for TF Question");
		}
		else {System.out.println("Marks are not matched for TF Question");}
	}
	
	public void verifyQuestionNoForTF()
	{   String TFQuestionNoOnScreen= "QUESTION 3 OF 8";
		String TFQuestionNo=QuestionNo.getText();
		
		if(TFQuestionNo.equals(TFQuestionNoOnScreen))
		{
			System.out.println("Marks No matched for TF Question");
		}
		else {System.out.println("Marks No not matched for TF Question");}
		
	}
	
	
	public void verifyQuestionTextForTF()
	{   
		System.out.println(QuestionText.isDisplayed());
	    String questTextTF=QuestionText.getText();
	    String TFQuestText="Question text3 true false";
        //Assert.assertEquals(questTextMCMA, MCMAQuestText);
        if(questTextTF.equals(TFQuestText))
        {
        	System.out.println("Question Text for TF is verified");
        }
	}    
	
	public void verifyOptionsTF()
	{
	  System.out.println("Option true radio button for TF is enabled: "+OptTrue.isEnabled());
	  System.out.println("Option false radio button for TF is enabled: "+OptFalse.isEnabled());
	
	  
	  String TFOption1=OptTextTrue.getText();
	  String TFOption2=OptTextFalse.getText();
		 
	  String Act_TFOption1="True";  
	  String Act_TFOption2="False"; 
	  
	  assertEquals(TFOption1, Act_TFOption1);
	  assertEquals(TFOption2, Act_TFOption2);

	}
	  
	public void selectTFAnswer()
	{   
		OptTrue.click();
		nextButton.click();
	}

    
	//Verify Essay type question
	
	public void VerifyMarksForEssayQue()
	{
		String RealMarks= "3.00 Marks";
		String QuestionMarks=marksForQuestion.getText();
		if(QuestionMarks.equals(RealMarks))
		{
			System.out.println("Marks are not matched for Essay Question");
		}
		else {System.out.println("Marks are not matched for Essay Question");}
	}
	
	
	public void verifyQuestionNoForEssay()
	{   String EssayQuestionNoOnScreen= "QUESTION 4 OF 8";
		String EssayQuestionNo=QuestionNo.getText();
		
		if(EssayQuestionNo.equals(EssayQuestionNoOnScreen))
		{
			System.out.println("Marks No matched for Essay Question");
		}
		else {System.out.println("Marks No not matched for Essay Question");}
		
	}
	
	public void verifyQuestionTextForEssay() {
		System.out.println(QuestionText.isDisplayed());
	    String questTextEssay=QuestionText.getText();
	    String EssayQuestText="Question text4 essay type";
        assertEquals(questTextEssay, EssayQuestText,"Question Text for Essay question is verified");
       
	}
	
	public void giveanswerForEssayTypeQuestion(){
		System.out.println("The word count limit for essay type question displayed: "+WordCount.isDisplayed());
		String EssayTypeResponse=UniqIdOnExamScreen.getText();
		AnsInputBox.sendKeys(EssayTypeResponse);  //giving answer same as candidate Unique ID
		nextButton.click();	
	}
	
	
	//Verify short answer type question
	
	public void VerifyMarksForShortAnsQue()
	{
		String RealMarks= "2.00 Marks";
		String QuestionMarks=marksForQuestion.getText();
		if(QuestionMarks.equals(RealMarks))
		{
			System.out.println("Marks are not matched for Short Answer Question");
		}
		else {System.out.println("Marks are not matched for Short Answer Question");}
	}
	
	public void verifyQuestionNoForShortAns()
	{   String ShortAnsQuestionNoOnScreen= "QUESTION 5 OF 8";
		String ShortAnsQuestionNo=QuestionNo.getText();
		
		if(ShortAnsQuestionNo.equals(ShortAnsQuestionNoOnScreen))
		{
			System.out.println("Marks No matched for Short Ans Question");
		}
		else {System.out.println("Marks No not matched for Short Ans Question");}		
	}
	
	
	public void verifyQuestionTextForShortAns() {
		System.out.println(QuestionText.isDisplayed());
	    String questTextEssay=QuestionText.getText();
	    System.out.println(questTextEssay);
	    String EssayQuestText="Question text5 short answer";
        assertEquals(questTextEssay, EssayQuestText,"Question Text for short ans question is verified");
	}
	
	public void giveAnswerForShortAnswer()
	{ SAnsInputBox.sendKeys("Automation testing");
		nextButton.click();
	}
	
	public void VeiryFUQues()
	{
		ChooseFile.sendKeys("C:\\EO\\EO data\\Data\\SAMPLE DOCUMENT TO UPLOAD\\200kb pdf file.pdf");
		UploadButton.click();
		assertEquals(succcessButton.isDisplayed(), true);
		nextButton.click();
	}
	
	public void verifyLikertQues()
	{
		System.out.println("Likert Option 1 displayed: " +likertScaleOption1.isDisplayed());
		System.out.println("Likert Option 2 displayed: " +likertScaleOption2.isDisplayed());
		System.out.println("Likert Option 3 displayed: " +likertScaleOption3.isDisplayed());
		System.out.println("Likert Option 4 displayed: " +likertScaleOption4.isDisplayed());
		
		likertScaleOption1.click();
		nextButton.click();
		
	}
	
	public void verifyNumericValueQues()
	{
		assertEquals(inputForNumericValue.isEnabled(), true);
		assertEquals(KeyPad.isDisplayed(),true);
		
		
		//Set answer 12.45
		Value1FromkeyPad.click();
		Value2FromkeyPad.click();
		pointFromkeyPad.click();
		Value4FromkeyPad.click();
		Value5FromkeyPad.click();
		assertEquals(Value1FromkeyPad.isEnabled(),false);
		nextButton.click();
	    assertEquals(QuestionNo.isDisplayed(), true);
	    
	}
	
    public void VerifyExamSubmissionButton()
    {
    	Submit.click();
    	assertEquals(ExamSummary.isDisplayed(),true);
    	GoBack.click();
    	assertEquals(RemainingTime.isDisplayed(),true);
    }
	
    public void VerifyExamSubmission()
    {
    	Submit.click();
    	assertEquals(ExamSummary.isDisplayed(),true);
    	SubmitFinal.click();
    	assertEquals(closeWindow.isDisplayed(),true);
    	closeWindow.click();
 
    }
	
	public void closeExamWindow()
	{   
	    driver.close();
		
	    List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
	    String lastWindow = windowsList.get(windowsList.size() - 1);
	    driver.switchTo().window(lastWindow);
		
		String WindowTitle=driver.getTitle();	
		System.out.println("EO Logo displayed: "+ EOLogo.isDisplayed());
		System.out.println("Resume button displayed: "+ResumeButton.isDisplayed());
		
	}
	
	public void relogin()
	{  
		ResumeButton.click();
		List<String> windowsList = new ArrayList<>(driver.getWindowHandles());
	    String lastWindow = windowsList.get(windowsList.size() - 1);
	    driver.switchTo().window(lastWindow);
	    
	}
	
	public void ClickNextButton()
	{ wait.until(ExpectedConditions.visibilityOf(nextButton));
	        nextButton.click();
	}
	
	public void CheckAttemptNo()
	{
		
	}
	
}

