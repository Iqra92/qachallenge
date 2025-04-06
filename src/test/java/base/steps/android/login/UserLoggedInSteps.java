package base.steps.android.login;
import base.core.pages.LoginPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import base.core.pages.UserLoggedInPage;

import static base.core.library.TestContext.getRegisteredEmail;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


public class UserLoggedInSteps {

    private final UserLoggedInPage userLoggedInPage;
    private final LoginPage loginPage;

    public UserLoggedInSteps(UserLoggedInPage userLoggedInSteps, LoginPage loginPage) {
        this.userLoggedInPage = userLoggedInSteps;
        this.loginPage = loginPage;
    }

    @Then("the user profile should display correct first name, last name and email")
    public void verifyUserProfile() {
        assertEquals("First name mismatch",
                "First name: John",
                userLoggedInPage.getFirstName());
        System.out.println("First Name Match and displayed in user logged In page");

        assertEquals("Last name mismatch",
                "Last name: Doe",
                userLoggedInPage.getLastName());
        System.out.println("Last Name Match and displayed in user logged In page");

        String fullDisplayedEmail = userLoggedInPage.getEmail();
        String displayedEmailValue = fullDisplayedEmail.replace("Email: ", "").trim();

        assertEquals("Email mismatch",
                getRegisteredEmail(),
                displayedEmailValue);
        System.out.println("Email Match and displayed in user logged In page");
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
