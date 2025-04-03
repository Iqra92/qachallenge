package base.core.pages;

import base.core.pages.common.BasePage;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class UserLoggedInPage extends BasePage {

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/userLoggedInMessage\")")
    private WebElement userLoggedInMessage;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/firstNameTv\")")
    private WebElement userFirstName;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/lastNameTv\")")
    private WebElement userLastName;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/emailTv\")")
    private WebElement userEmail;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/logoutBtn\")")
    private WebElement logoutButton;

    @AndroidFindBy(uiAutomator = "new UiSelector().resourceId(\"com.hostelworld.qacodechallenge:id/btnLogin\")")
    private WebElement userLoginIn;


    public boolean isUserLoggedIn() {
        return reusableUIMethods.isElementDisplayed(logoutButton);
    }

    public String getFirstName() {
        return userFirstName.getText();
    }

    public String getLastName() {
        return userLastName.getText();
    }

    public String getEmail() {
        return userEmail.getText();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public boolean isLoginScreenDisplayed() {
        return reusableUIMethods.isElementDisplayed(userLoginIn);
    }
}
