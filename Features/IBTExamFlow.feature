#Author: your.email@your.domain.com   --->To do
#Keywords Summary :                   --->To do
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>  --->To do
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)            --->To do
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template         


@Regression
Feature: IBT exam flow
 

  @Regression
  Scenario: Candidate logs in and start attempting an IBT exam
   Given the Admin logs in to the admin portal
   And the candidate taking credentials from the attendance sheet for "<ExamName>"
   And the candidate navigates to the candidate login page and logged in
   Then verify the candidate is able to see the dashboard
   When the candidate clicks the start button for the IBT exam
   Then verify if the candidate should see the instruction page and other details
   And verify if the candidate see Remaining Exam Time and exam name
   And verify MCSA Question and select option
   And verify MCMA Question and select option
   And verify TF Question and select option
   And verify Essay Question and give answer
   And verify SA Question and give answer
   And verify FU Question
   And verify Likert Question
   And verify Numeric Value Question
   And verify Exam submission
   
   Examples:
         | ExamName    |
         | IBT exam    |
   
  Scenario: Verify candidate relogin scenario
   Given the Admin logs in to the admin portal
   And the candidate taking credentials from the attendance sheet for "<ExamName>"
   And the candidate navigates to the candidate login page and logged in
   Then verify the candidate is able to see the dashboard
   When the candidate clicks the start button for the IBT exam
   Then verify if the candidate should see the instruction page and other details
   And verify if the candidate see Remaining Exam Time and exam name
   And verify MCSA Question and select option
   And verify MCMA Question and select option
   And candidate closing exam window
   And candidate relogin to exam
   And verify if the candidate should see the instruction page and other details
   And verify if the candidate see Remaining Exam Time and exam name
   And verify if candidate clicking next button
   And verify TF Question and select option
   And verify Essay Question and give answer
   And verify SA Question and give answer
   And verify FU Question
   And verify Likert Question
   And verify Numeric Value Question
   And verify Exam submission
   
    Examples:
           | ExamName    |
           | IBT exam    |
   
   
 
    
    