Feature: Main Screen Functionality

  Background: User is on the main page
    Given the user is on the main screen

  @start
  Scenario: Successful navigate to login page
    When the user is navigate to login page
    When the user presses the Android back button

  Scenario: Successful navigate to create account page
    When the user is navigate to create account page