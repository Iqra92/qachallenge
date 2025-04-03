package base.steps.android.login;

import base.core.library.ReusableUIMethods;
import base.core.library.TestContext;
import base.core.pages.CreateAccountPage;
import base.core.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static base.core.library.ReusableUIMethods.generateUniqueEmail;
import static org.junit.Assert.*;

public class CreateAccountSteps {

    private final LoginPage loginPage;
    private final CreateAccountPage createAccount;
    private static String registeredEmail;
    private final TestContext context;

    public CreateAccountSteps(LoginPage loginPage, CreateAccountPage createAccount,TestContext context) {
        this.loginPage = loginPage;
        this.createAccount = createAccount;
        this.context = context;
    }

    @When("the user is navigate to create account page")
    public void the_user_is_navigate_to_create_account_page() {
        createAccount.clickCreateAccount();
        assertTrue(createAccount.isCreateAccountPageDisplayed());
    }

    @When("the user enters valid email")
    public void the_user_enters_valid_email() {
        String uniqueEmail = ReusableUIMethods.generateUniqueEmail();
        context.setRegisteredEmail(uniqueEmail);
        createAccount.enterEmail(uniqueEmail);
    }

    @When("the user enters valid {string} as first name")
    public void the_user_enters_valid_first_name(String firstName) {
        createAccount.enterFirstName(firstName);
    }

    @When("the user enters valid {string} as last name")
    public void the_user_enters_valid_last_name(String lastName) {
        createAccount.enterLastName(lastName);
    }

    @When("the user enters valid {string} as password")
    public void the_user_enters_valid_password(String password) {
        createAccount.enterPassword(password);
    }

    @When("the user clicks on the create account button")
    public void the_user_clicks_on_create_account_button() {
        createAccount.clickCreateAccount();
    }

    @Then("the user should be successfully registered")
    public void the_user_should_be_successfully_registered() {
        if (!createAccount.isRedirectedToLoginScreen()) {
            fail("Registration failed: User was NOT redirected to the login screen.");
        }
        if (createAccount.isErrorMessageDisplayed()) {
            fail("Registration failed: An error message was displayed.");
        }
    }

    @When("the user attempts to create an account with empty fields")
    public void the_user_attempts_to_create_an_account_with_empty_fields() {
        createAccount.clickCreateAccountButton();
        createAccount.clickFirstName();

        String firstNameError = String.valueOf(createAccount.getFirstNameErrorText());
        if (firstNameError != null) {
            System.out.println("First Name Error: " + firstNameError);
            assertEquals("Invalid First name", firstNameError);
            createAccount.enterFirstName("John");
            createAccount.clickCreateAccountButton();
        }

        String lastNameError = createAccount.getLastNameErrorText();
        if (lastNameError != null) {
            System.out.println("Last Name Error: " + lastNameError);
            assertEquals("Invalid Last name", lastNameError);
            createAccount.enterLastName("Doe");
            createAccount.clickCreateAccountButton();
        }

        String emailError = createAccount.getEmailErrorText();
        if (emailError != null) {
            System.out.println("Email Error: " + emailError);
            assertEquals("Invalid email", emailError);
            createAccount.enterEmail("john.doe@example.com");
            createAccount.clickCreateAccountButton();
        }

        String passwordError = createAccount.getPasswordErrorText();
        if (passwordError != null) {
            System.out.println("Password Error: " + passwordError);
            assertEquals("Invalid password", passwordError);
            createAccount.enterPassword("SecurePass123!");
            createAccount.clickCreateAccountButton();
        }
    }

    @When("the user enters invalid {string} as email")
    public void the_user_enters_invalid_email(String invalidEmail) {
        createAccount.enterEmail(invalidEmail);
    }

    @Then("an error message {string} should be displayed for invalid email")
    public void verifyInvalidEmailError(String expectedErrorMessage) {
        String actualErrorMessage = createAccount.getEmailErrorMessage();
        assertEquals("Email validation failed!", expectedErrorMessage, actualErrorMessage);
    }

    @Given("the user has already created an account")
    public void the_user_has_already_created_an_account() {
        if (registeredEmail == null) {
            registeredEmail = generateUniqueEmail();
            createAccount.enterFirstName("John");
            createAccount.enterLastName("Doe");
            createAccount.enterEmail(registeredEmail);
            createAccount.enterPassword("Secure@123");
            createAccount.clickCreateAccountButton();

            assertTrue("Account creation failed!", createAccount.isRegistrationSuccessful());
        }
    }

    @When("the user enters the same email used previously")
    public void the_user_enters_the_same_email_used_previously() {
        createAccount.enterEmail(context.getRegisteredEmail());
    }

    @Then("an error message {string} should be displayed for email")
    public void verifyEmailAlreadyExistsError(String expectedErrorMessage) {
        String actualErrorMessage = createAccount.getEmailErrorMessage();
        assertEquals("Duplicate email validation failed!", expectedErrorMessage, actualErrorMessage);
    }

}











