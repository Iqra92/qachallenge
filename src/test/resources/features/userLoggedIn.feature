Feature: Post-login Functionality

  Background: User created account successfully then logged in
    Given the user is navigate to create account page
    When the user enters valid "John" as first name
    When the user enters valid "Doe" as last name
    When the user enters valid email
    When the user enters valid "Secure@123" as password
    And the user clicks on the create account button
    Then the user should be successfully registered
    And the user clicks on the login button
    When the user enters the registered email
    And the user enters the valid password "Secure@123"
    And the user clicks on the login button


  Scenario: Verify User Details after Successful Login
    Then the user profile should display correct first name, last name and email
    When the user clicks on the logout button
    Then the user should be redirected to the login screen

