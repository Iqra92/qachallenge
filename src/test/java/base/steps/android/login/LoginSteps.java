package base.steps.android.login;

import base.core.library.ReusableUIMethods;
import base.core.library.TestContext;
import base.core.pages.LoginPage;
import base.core.pages.CreateAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private final LoginPage loginPage;
    private final CreateAccountPage createAccountPage;
    private static String registeredEmail;
    private final TestContext context;

    public LoginSteps(TestContext context) {
        loginPage = new LoginPage();
        createAccountPage = new CreateAccountPage();
        this.context = context;
    }

    @When("the user is navigate to login page")
    public void the_user_is_navigate_to_login_page() {
        loginPage.clickLoginButton();
        assertTrue(loginPage.isLoginPageDisplayed());
    }

    @Given("the user has a registered account")
    public void the_user_has_a_registered_account() {
        if (registeredEmail == null) {
            registeredEmail = ReusableUIMethods.generateUniqueEmail();
            createAccountPage.createAccount("John", "Doe", registeredEmail, "Secure@123");
            assertTrue("Account creation failed!", createAccountPage.isRegistrationSuccessful());
        }
    }

    @When("the user enters the registered email")
    public void the_user_enters_the_registered_email() {
        loginPage.enterEmail(context.getRegisteredEmail());
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
        assertTrue("Login failed!", loginPage.isUserLoggedIn());
    }

    @When("the user clicks the login button without entering credentials")
    public void the_user_clicks_login_button_without_entering_credentials() {
        loginPage.clickLoginButton();
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

    @When("the user enters {string} as email")
    public void the_user_enters_email(String email) {
        loginPage.enterEmail(email);
    }

    @When("the user enters {string} as password")
    public void the_user_enters_password(String password) {
        loginPage.enterPassword(password);
    }

    @When("the user leaves the password field empty")
    public void the_user_leaves_the_password_field_empty() {
        loginPage.enterPassword("");
    }

    @When("the user leaves the email field empty")
    public void the_user_leaves_the_email_field_empty() {
        loginPage.enterEmail("");
    }
}
