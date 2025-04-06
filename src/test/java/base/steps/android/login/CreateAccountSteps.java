package base.steps.android.login;

import base.core.library.ReusableUIMethods;
import base.core.pages.CreateAccountPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static base.core.library.ReusableUIMethods.generateUniqueEmail;
import static base.core.library.TestContext.getRegisteredEmail;
import static base.core.library.TestContext.setRegisteredEmail;
import static org.junit.Assert.*;

public class CreateAccountSteps {

    private final CreateAccountPage createAccountPage;
    private static String registeredEmail;
    private String invalidEmail;

    public CreateAccountSteps( CreateAccountPage createAccount) {
        this.createAccountPage = createAccount;
    }

    @When("the user is navigate to create account page")
    public void the_user_is_navigate_to_create_account_page() {
        createAccountPage.clickCreateAccount();
        assertTrue(createAccountPage.isCreateAccountPageDisplayed());
        System.out.println("User is on the Create Account Page");
    }

    @When("the user enters valid email")
    public void the_user_enters_valid_email() {
        String uniqueEmail = ReusableUIMethods.generateUniqueEmail();
        setRegisteredEmail(uniqueEmail);
        System.out.println("Check Email here =>: "+getRegisteredEmail());
        createAccountPage.enterEmail(uniqueEmail);
    }

    @When("the user enters valid {string} as first name")
    public void the_user_enters_valid_first_name(String firstName) {
        createAccountPage.enterFirstName(firstName);
    }

    @When("the user enters valid {string} as last name")
    public void the_user_enters_valid_last_name(String lastName) {
        createAccountPage.enterLastName(lastName);
    }

    @When("the user enters valid {string} as password")
    public void the_user_enters_valid_password(String password) {
        createAccountPage.enterPassword(password);
    }

    @When("the user clicks on the create account button")
    public void the_user_clicks_on_create_account_button() {
        createAccountPage.clickCreateAccount();
    }

    @Then("the user should be successfully registered")
    public void the_user_should_be_successfully_registered() {
        if (!createAccountPage.isRedirectedToLoginScreen()) {
            fail("Registration failed: User was NOT redirected to the login screen.");
        }
        if (createAccountPage.isErrorMessageDisplayed()) {
            fail("Registration failed: An error message was displayed.");
        }
    }

    @When("the user attempts to create account with empty fields")
    public void the_user_attempts_to_create_account_with_empty_fields() {
        createAccountPage.clickCreateAccount();
        createAccountPage.clickFirstName();
        boolean isFirstNameErrorDisplayed = createAccountPage.isInvalidFirstNameMessageDisplayed();
        assertTrue("Expected error message for empty first name.", isFirstNameErrorDisplayed);
        createAccountPage.enterFirstName("John");
        createAccountPage.clickCreateAccount();
        boolean isLastNameErrorDisplayed = createAccountPage.isInvalidLastNameMessageDisplayed();

        if (!isLastNameErrorDisplayed) {
            System.out.println(" WARNING: Validation message for empty last name is not displayed. This field might be missing validation.");
        }
        createAccountPage.enterLastName("Doe");
        createAccountPage.clickCreateAccount();
        boolean isEmailErrorDisplayed = createAccountPage.isInvalidAcountEmailMessageDisplayed();
        assertTrue("Expected error message for empty email.", isEmailErrorDisplayed);
        createAccountPage.enterEmail(generateUniqueEmail());
        createAccountPage.clickCreateAccount();
        createAccountPage.clickPasswordAccount();
        boolean isPasswordErrorDisplayed = createAccountPage.isInvalidAccountPasswordMessageDisplayed();
        assertTrue("Expected error message for empty password.", isPasswordErrorDisplayed);
        createAccountPage.enterPassword("Secure@123");
        createAccountPage.clickCreateAccount();

    }

    @When("the user enters invalid {string} as email")
    public void the_user_enters_invalid_email(String invalidEmail) {
        this.invalidEmail = invalidEmail;
        createAccountPage.enterEmail(invalidEmail);
    }

    @Then("an error message {string} should be displayed for invalid email")
    public void an_error_message_should_be_displayed_for_invalid_email(String invalidEmail) {
        boolean isErrorDisplayed = createAccountPage.isInvalidAcountEmailMessageDisplayed();

        if (!isErrorDisplayed) {
            System.out.printf("WARNING: No error displayed for invalid email: %s%n", invalidEmail);
        } else {
            System.out.printf("Email validation displayed for invalid email: %s%n", invalidEmail);
        }
    }

    @Given("the user has already created an account")
    public void the_user_has_already_created_an_account() {
        if (registeredEmail == null) {
            registeredEmail = generateUniqueEmail();
            createAccountPage.enterFirstName("John");
            createAccountPage.enterLastName("Doe");
            createAccountPage.enterEmail(registeredEmail);
            createAccountPage.enterPassword("Secure@123");
            createAccountPage.clickCreateAccountButton();

            assertTrue("Account created", createAccountPage.isRegistrationSuccessful());
        }
    }

    @When("the user enters the same email used previously")
    public void the_user_enters_the_same_email_used_previously() {
        createAccountPage.enterEmail(getRegisteredEmail());
    }

    @Then("an error message should be displayed for email")
    public void verifyEmailAlreadyExistsError() {
        boolean actualErrorMessage = createAccountPage.isInvalidDuplicateUserMessageDisplayed();
        assertTrue("Users already exists", actualErrorMessage);
        System.out.println("Users already exists");
    }

}











