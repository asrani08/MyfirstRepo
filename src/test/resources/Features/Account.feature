
Feature: Testing LUMA App

Background:
Given user is on Home page
Scenario:1 Creating User 
    When user click on Create an account
    Then user enters personam Info
      | First Name | Mami   |
      | Last Name  | pqr   |
    And User enters sign-in info
      | Email             | rani12@gmail.com |
      | Password          |A@12345678 |
      | Confirm Password  | A@12345678 |

    Then user click on Create an Account Button
    And user verifies Thank you msg
    
    Scenario:2 Testing Login Functionality
    
    When user click on Sign In 
    And user enters username
      | Email | rani12@gmail.com |
    And user enters password
    | Password |A@12345678 |
    Then user click on Sign In Button
    Then User is on My Account Page 
    

  
