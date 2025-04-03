package base.steps.android.login;

import base.core.pages.CreateAccountPage;
import base.core.pages.LoginPage;
import io.cucumber.java.en.Given;
import static org.junit.Assert.assertTrue;

public class MainSteps {

    private final LoginPage loginPage;
    private final CreateAccountPage createAccount;

    public MainSteps(LoginPage loginPage, CreateAccountPage createAccount) {
        this.loginPage = loginPage;
        this.createAccount = createAccount;
    }


    @Given("the user is on the main screen")
    public void the_user_is_on_the_main_screen() {
        assertTrue(loginPage.isLoginPageDisplayed());
        assertTrue(createAccount.isCreateAccountPageDisplayed());
    }

}
