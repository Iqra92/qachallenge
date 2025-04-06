package base.core.pages;

import base.core.pages.common.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import static base.core.library.Constants.Errors.*;


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

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/passwordEt\")")
    private WebElement errorMessagePassword;

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

    public void clickPasswordAccount() {
        reusableUIMethods.clickElement(passwordField);
    }


    public boolean isRedirectedToLoginScreen() {
        return reusableUIMethods.isElementDisplayed(loginButton);
    }

    public boolean isErrorMessageDisplayed() {
        return reusableUIMethods.isElementDisplayed(errorMessage);
    }

    public boolean isInvalidFirstNameMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(firstNameField));
        String pageSource = driver.getPageSource();
        return pageSource.contains(INVALID_FIRST_NAME);
    }

    public boolean isInvalidAccountPasswordMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(errorMessagePassword));
        String pageSource = driver.getPageSource();
        return pageSource.contains(INVALID_PASSWORD);
    }

    public boolean isInvalidLastNameMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(lastNameField));
        String pageSource = driver.getPageSource();
        return pageSource.contains(INVALID_LAST_NAME);
    }

    public boolean isInvalidAcountEmailMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emailField));
        String pageSource = driver.getPageSource();
        return pageSource.contains(INVALID_EMAIL);
    }


    public boolean isInvalidDuplicateUserMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(emailField));
        String pageSource = driver.getPageSource();
        return pageSource.contains(USER_ALREADY_EXISTS);
    }

    public boolean isRegistrationSuccessful() {
        return isRedirectedToLoginScreen() && !isErrorMessageDisplayed();
    }

}
