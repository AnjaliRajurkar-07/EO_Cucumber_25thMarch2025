
@Regression 
Feature: Reattempt exam flow 
 
  @Regression 
  Scenario: Candididate Giving 1st attempt of reattempt
   Given the Admin logs in to the admin portal
   And the candidate taking credentials from the attendance sheet for "<ExamName>"
   And the candidate navigates to the candidate login page and logged in
   Then verify the candidate is able to see the dashboard for reattempt exam
   When the candidate clicks the start button for the Reattempt exam
   
   
   Examples:
           | ExamName|
           | Reattempt exam|           
           
           
           
         