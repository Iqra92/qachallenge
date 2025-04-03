Feature: Login Functionality

  Background: Successful navigate to login page
    Given the user is navigate to login page

  Scenario: User logs in with valid credentials
    Given the user has a registered account
    When the user enters the registered email
    And the user enters the valid password "Secure@123"
    And the user clicks on the login button
    Then the user should be successfully logged in

  Scenario: Login with empty fields
    When the user clicks the login button without entering credentials
    Then an error message "Invalid email" should be displayed
    When the user enters "user@example.com" as email and clicks login
    Then an error message "Invalid password" should be displayed

  Scenario: Login with invalid credentials
    When the user enters "invalid@example.com" as email
    And the user enters "WrongPassword123" as password
    And the user clicks on the login button
    Then an error message "Invalid email" should be displayed for login

  Scenario: Login with only email (No password)
    When the user enters "user@example.com" as email
    And the user leaves the password field empty
    And the user clicks on the login button
    Then an error message "Invalid password" should be displayed

  Scenario: Login with only password (No email)
    When the user leaves the email field empty
    And the user enters "Test@123" as password
    And the user clicks on the login button
    Then an error message "Invalid email" should be displayed

  Scenario: Login with incorrect password
    When the user enters "validuser@example.com" as email
    And the user enters "WrongPass123!" as password
    And the user clicks on the login button
    Then an error message "Invalid password" should be displayed

  Scenario: Login with an invalid email format
    When the user enters "invalid-email" as email
    And the user enters "SecurePass@123" as password
    And the user clicks on the login button
    Then an error message "Invalid email" should be displayed

