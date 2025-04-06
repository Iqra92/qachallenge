package base.steps.android.login;

import base.core.library.ReusableUIMethods;
import base.core.pages.LoginPage;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static base.core.library.TestContext.getRegisteredEmail;
import static org.junit.Assert.*;

public class LoginSteps {

    private final LoginPage loginPage;

    public LoginSteps() {
        loginPage = new LoginPage();
    }

    @When("the user is navigate to login page")
    public void the_user_is_navigate_to_login_page() {
        loginPage.clickLoginButton();
        assertTrue(loginPage.isLoginPageDisplayed());
        System.out.println("User is on the Login Page");
    }

    @When("the user enters the registered email")
    public void the_user_enters_the_registered_email() {
        System.out.println("Check Registered Email =>: "+getRegisteredEmail());
        loginPage.enterEmail(getRegisteredEmail());
    }

    @When("the user enters the valid password {string}")
    public void the_user_enters_the_valid_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user clicks on the login button")
    public void the_user_clicks_on_the_login_button() {
        loginPage.clickLoginButton();
    }

    @Then("the user should be successfully logged in")
    public void the_user_should_be_successfully_logged_in() {
        assertTrue("Login Successfully!", loginPage.isUserLoggedIn());
        System.out.println("User is Successfully loggedIn");
    }

    @When("the user attempts to login with empty fields")
    public void the_user_attempts_to_login_with_empty_fields() {
        loginPage.clickLoginButton();
        loginPage.clickUserName();
        boolean isEmailErrorDisplayed = loginPage.isInvalidEmailMessageDisplayed();
        assertTrue("Expected error message for empty email address.", isEmailErrorDisplayed);
        loginPage.enterEmail(getRegisteredEmail());
        loginPage.clickLoginButton();
        boolean isPasswordErrorDisplayed = loginPage.isInvalidPasswordMessageDisplayed();
        assertTrue("Expected error message for empty password.", isPasswordErrorDisplayed);
    }

    @When("the user attempts to login with invalid credentials")
    public void the_user_attempts_to_login_with_Invalid_fields() {
        loginPage.clickLoginButton();
        loginPage.clickUserName();
        loginPage.enterEmail("Invalid@gmail.com");
        boolean isEmailErrorDisplayed = loginPage.isInvalidEmailMessageDisplayed();
        assertTrue("Expected error message for email is not registered.", isEmailErrorDisplayed);
        loginPage.enterEmail(getRegisteredEmail());
        loginPage.clickLoginButton();
        loginPage.clickPassword();
        boolean isPasswordErrorDisplayed = loginPage.isInvalidPasswordMessageDisplayed();
        assertTrue("Expected error message for password is not registered.", isPasswordErrorDisplayed);
    }

    @Then("an error message {string} should be displayed")
    public void an_error_message_should_be_displayed(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        assertEquals("Error message mismatch!", expectedErrorMessage, actualErrorMessage);
    }

    @When("the user enters {string} as email and clicks login")
    public void the_user_enters_email_and_clicks_login(String email) {
        loginPage.enterEmail(email);
        loginPage.clickLoginButton();
    }

    @Then("an error message {string} should be displayed for login")
    public void an_error_message_should_be_displayed_for_login(String expectedErrorMessage) {
        String actualErrorMessage = loginPage.getErrorMessage();
        assertEquals("Error message mismatch!", expectedErrorMessage, actualErrorMessage);
    }

    @When("the user enters registered email")
    public void the_user_enters_registered_email() {
        loginPage.enterEmail(getRegisteredEmail());
        loginPage.clickLoginButton();
        boolean isPasswordErrorDisplayed = loginPage.isInvalidPasswordMessageDisplayed();
        assertTrue("Expected error message for password is not registered.", isPasswordErrorDisplayed);

    }

    @When("the user enters valid password")
    public void the_user_enters_valid_password() {
        loginPage.clickUserName();
        loginPage.clearEmailFieldText();
        loginPage.enterPassword("Secure@123");
        loginPage.clickLoginButton();
        boolean isEmailErrorDisplayed = loginPage.isInvalidEmailMessageDisplayed();
        assertTrue("Expected error message for email is not registered.", isEmailErrorDisplayed);

    }

    @When("the user enters incorrect password")
    public void the_user_enters_Incorrect_password() {
        loginPage.clickPassword();
        loginPage.clearPasswordFieldText();
        loginPage.enterEmail(getRegisteredEmail());
        loginPage.clickLoginButton();
        loginPage.enterPassword("IncorrectPassword");
        loginPage.clickLoginButton();
        boolean isPasswordErrorDisplayed = loginPage.isInvalidPasswordMessageDisplayed();
        assertTrue("Expected error message for password is not registered.", isPasswordErrorDisplayed);

    }

    @When("the user enters Invalid email format")
    public void the_user_enters_Invalid_email_format() {
        loginPage.enterEmail("invalid.com");
        loginPage.clickLoginButton();
        boolean isEmailErrorDisplayed = loginPage.isInvalidEmailMessageDisplayed();
        assertTrue("Expected error message for email is not valid.", isEmailErrorDisplayed);

    }

    @When("the user leaves the password field empty")
    public void the_user_leaves_the_password_field_empty() {
        loginPage.enterPassword("");
    }

    @When("the user leaves the email field empty")
    public void the_user_leaves_the_email_field_empty() {
        loginPage.enterEmail("");
    }

    @When("the user presses the Android back button")
    public void the_user_presses_back_button() {
        ReusableUIMethods.pressAndroidBackButton();
    }

}
