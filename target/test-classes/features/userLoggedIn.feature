Feature: Post-login Functionality

  Background: User has successfully logged in
    Given the user is logged in

  Scenario: Verify User Details after Successful Login
    TThen the user profile should display correct first name, last name and email

  Scenario: Verify Logout Functionality
    When the user clicks on the logout button
    Then the user should be redirected to the login screen

