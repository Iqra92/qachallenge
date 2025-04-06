Feature: Login Functionality

  Scenario: User log in with valid credentials
    Given the user is on the main screen
    When the user is navigate to create account page
    When the user enters valid "John" as first name
    When the user enters valid "Doe" as last name
    When the user enters valid email
    When the user enters valid "Secure@123" as password
    And the user clicks on the create account button
    And the user clicks on the login button
    When the user enters the registered email
    And the user enters the valid password "Secure@123"
    And the user clicks on the login button
    Then the user should be successfully logged in
    When the user clicks on the logout button

  Scenario: Login with empty fields
    And the user clicks on the login button
    When the user attempts to login with empty fields

  Scenario: Login with only email (No password)
    When the user enters registered email

  Scenario: Login with invalid credentials
    When the user attempts to login with invalid credentials

  Scenario: Login with only password (No email)
    When the user enters valid password

  Scenario: Login with incorrect password
    When the user enters incorrect password

  Scenario: Login with an invalid email format
    When the user enters Invalid email format

