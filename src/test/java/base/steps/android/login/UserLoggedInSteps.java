package base.steps.android.login;
import base.core.library.TestContext;
import base.core.pages.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import base.core.pages.UserLoggedInPage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class UserLoggedInSteps {

    private final UserLoggedInPage userLoggedInPage;
    private final LoginPage loginPage;
    private final TestContext context;

    public UserLoggedInSteps(UserLoggedInPage userLoggedInSteps, LoginPage loginPage,TestContext context) {
        this.userLoggedInPage = userLoggedInSteps;
        this.loginPage = loginPage;
        this.context = context;
    }

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        if (!userLoggedInPage.isUserLoggedIn()) {
            loginPage.performLogin(context.getRegisteredEmail(), "Secure@123");
            assertTrue("User is not logged in!", userLoggedInPage.isUserLoggedIn());
        }
    }

    @Then("the user profile should display correct first name, last name and email")
    public void verifyUserProfile() {
        assertEquals("First name mismatch",
                "First name: John",
                userLoggedInPage.getFirstName());

        assertEquals("Last name mismatch",
                "Last name: Doe",
                userLoggedInPage.getLastName());

        String fullDisplayedEmail = userLoggedInPage.getEmail();
        String displayedEmailValue = fullDisplayedEmail.replace("Email: ", "").trim();

        assertEquals("Email mismatch",
                context.getRegisteredEmail(),
                displayedEmailValue);
    }


    @When("the user clicks on the logout button")
    public void the_user_clicks_on_the_logout_button() {
        userLoggedInPage.clickLogoutButton();
    }

    @Then("the user should be redirected to the login screen")
    public void the_user_should_be_redirected_to_the_login_screen() {
        assertTrue(userLoggedInPage.isLoginScreenDisplayed());
    }
}
