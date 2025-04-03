@smoke @account
Feature: Create Account Functionality

  Background: Successful navigate to create account page
    Given the user is navigate to create account page

  @positive
  Scenario: User successfully creates an account
    When the user enters valid "John" as first name
    When the user enters valid "Doe" as last name
    When the user enters valid email
    When the user enters valid "Secure@123" as password
    And the user clicks on the create account button
    Then the user should be successfully registered

  @negative
  Scenario: Create an account by resolving step-by-step validation errors
    Given the user is navigate to create account page
    When the user attempts to create an account with empty fields
    Then the user should be successfully registered

  @invalid-email
  Scenario Outline: User tries to create an account with an invalid email
    When the user enters valid "John" as first name
    And the user enters valid "Doe" as last name
    And the user enters invalid "<email>" as email
    And the user enters valid "Secure@123" as password
    And the user clicks on the create account button
    Then an error message "<errorMessage>" should be displayed for invalid email

    Examples:
      | email          | errorMessage                         |
      | johndoe.com    | Invalid email  |
      | johndoe@       | Invalid email  |
      | @example.com   | Invalid email  |
      | johndoe@com    | Invalid email  |

  @existing-user
  Scenario: User tries to create an account with an already registered email
    Given the user is navigate to create account page
    Given the user has already created an account
    When the user enters valid "John" as first name
    And the user enters valid "Doe" as last name
    And the user enters the same email used previously
    And the user enters valid "Secure@123" as password
    And the user clicks on the create account button
    Then an error message "Users already exists" should be displayed for email
