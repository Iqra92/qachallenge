package base.core.pages;

import base.core.pages.common.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/usernameEt\")")
    private WebElement emailField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/passwordEt\")")
    private WebElement passwordField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/btnLogin\")")
    private WebElement loginButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/logoutBtn\")")
    private WebElement userLoginIn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge://*[contains(@text,'Invalid email')]\")")
    private WebElement errorMessageEmail;

  //  @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:passwordEt.error/Invalid email\")")
 //   private WebElement errorMessagePassword;

    public boolean isLoginPageDisplayed() {

        return reusableUIMethods.isElementDisplayed(loginButton);
    }

    public void performLogin(String email, String password) {
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void enterEmail(String email) {
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }

    public boolean isUserLoggedIn() {
        return reusableUIMethods.isElementDisplayed(userLoginIn);
    }

    public String getErrorMessage() {
        return errorMessageEmail.getText();
    }

}
