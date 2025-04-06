package base.core.pages;

import base.core.pages.common.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static base.core.library.Constants.Errors.*;


public class LoginPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/usernameEt\")")
    private WebElement emailField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/passwordEt\")")
    private WebElement passwordField;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/btnLogin\")")
    private WebElement loginButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/greetingTv\")")
    private WebElement userLoginIn;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/usernameEt\")")
    private WebElement errorMessageEmail;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/passwordEt\")")
    private WebElement errorMessagePassword;

    public boolean isLoginPageDisplayed() {

        return reusableUIMethods.isElementDisplayed(loginButton);
    }


    public void enterEmail(String email) {
        System.out.println("Check Email =>: "+email);
        emailField.sendKeys(email);
    }

    public void enterPassword(String password) {
        passwordField.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
    public void clickUserName() {
        emailField.click();
    }
    public void clickPassword() {
        passwordField.click();
    }

    public boolean isUserLoggedIn() {
        return reusableUIMethods.isElementDisplayed(userLoginIn);
    }

    public String getErrorMessage() {
        return errorMessageEmail.getText();
    }
    public void clearEmailFieldText() {
        emailField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }
    public void clearPasswordFieldText() {
        passwordField.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
    }

    public Boolean isInvalidEmailMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(errorMessageEmail));
        String pageSource = driver.getPageSource();
        return pageSource.contains(INVALID_EMAIL);
    }

    public boolean isInvalidPasswordMessageDisplayed() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(errorMessagePassword));
        String pageSource = driver.getPageSource();
        return pageSource.contains(INVALID_PASSWORD);
    }


}
