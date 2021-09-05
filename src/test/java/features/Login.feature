#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template

Feature: test the homepage and login page of the https://winstoncastillo.com/robot-selenium/
  Here you will find all the steps to test the login and homepage 
	
	@SmokeTest
  Scenario: User look for the login screen
    Given A user is on the homepage
    And go to the login page
    When Login Page is displayed
    Then New Customer section is displayed
    And Returning Customer is displayed
    
  Scenario: Not registered user is trying to access the system
    Given User login into the application with username "katy@gmail.com" with password "1234567"
    When Login Page is displayed
    Then Click on Login button 
    And Error Message is displayed
    