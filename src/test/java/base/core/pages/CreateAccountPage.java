package base.core.pages;

import base.core.pages.common.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;


public class CreateAccountPage extends BasePage {


    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/firstNameEt\")")
    private WebElement firstNameField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/lastNameEt\")")
    private WebElement lastNameField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/emailEt\")")
    private WebElement emailField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/passwordEt\")")
    private WebElement passwordField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/btnCreateAccount\")")
    private WebElement createAccountButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/btnLogin\")")
    private WebElement loginButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/txtErrorMessage\")")
    private WebElement errorMessage;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/firstNameEt\")")
    private WebElement firstNameError;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/Invalid LastName\")")
    private WebElement lastNameError;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/Invalid email\")")
    private WebElement emailError;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/Invalid password\")")
    private WebElement passwordError;

    public boolean isCreateAccountPageDisplayed() {

        return reusableUIMethods.isElementDisplayed(createAccountButton);
    }

    public void clickCreateAccountButton() {
        createAccountButton.click();
    }
    public void clickFirstName() {
        firstNameField.click();
    }

    public void enterFirstName(String firstName) {
        reusableUIMethods.enterText(firstNameField, firstName);
    }

    public void enterLastName(String lastName) {
        reusableUIMethods.enterText(lastNameField, lastName);
    }

    public void enterEmail(String email) {
        reusableUIMethods.enterText(emailField, email);
    }

    public void enterPassword(String password) {
        reusableUIMethods.enterText(passwordField, password);
    }

    public void clickCreateAccount() {
        reusableUIMethods.clickElement(createAccountButton);
    }
    public void createAccount(String firstName, String lastName, String email, String password) {
        enterFirstName(firstName);
        enterLastName(lastName);
        enterEmail(email);
        enterPassword(password);
        clickCreateAccountButton();
    }

    // Verification: If we reach the login page, the registration was successful.
    public boolean isRedirectedToLoginScreen() {
        return reusableUIMethods.isElementDisplayed(loginButton);
    }

    // Verification: If an error message appears, registration failed.
    public boolean isErrorMessageDisplayed() {
        return reusableUIMethods.isElementDisplayed(errorMessage);
    }

    public String getFirstNameErrorText() { return firstNameError.getText(); }
    public String getLastNameErrorText() { return lastNameError.getText(); }
    public String getEmailErrorText() { return emailError.getText(); }
    public String getPasswordErrorText() { return passwordError.getText(); }

    public String getEmailErrorMessage() {
        return emailError.getText();
    }

    public boolean isRegistrationSuccessful() {
        return isRedirectedToLoginScreen() && !isErrorMessageDisplayed();
    }

}
