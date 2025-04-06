package base.core.library;

import base.core.drivers.DriverManager;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.UUID;

/**
 * This class is to define reusable methods that are related to UI, and they need a driver
 */
public class ReusableUIMethods {
    protected final AppiumDriver driver;

    public ReusableUIMethods(AppiumDriver driver) {
        this.driver = driver;
    }


    public void scrollToText(String text) {
        driver.findElement(AppiumBy
                .androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + text + "\"));"));
    }

    public void swipeDirection(WebElement ele, String direction) {
        ((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of("elementId",
                ((RemoteWebElement) ele).getId(), "direction", direction, "percent", 0.75));
    }

    public boolean isElementDisplayed(WebElement Element) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_TIMEOUT);
            wait.until(ExpectedConditions.visibilityOf(Element));
            return true;
        } catch (TimeoutException e) {
            return false;
        }
    }
    public static String generateUniqueEmail() {
        return "user" + UUID.randomUUID().toString().substring(0, 5) + "@example.com";
    }

    public void enterText(WebElement element, String text) {
        waitForWebElementToBeAvailable(element, 10);
        element.clear();
        element.sendKeys(text);
    }

    public void clickElement(WebElement element) {
        waitForWebElementToBeAvailable(element, 10);
        element.click();
    }


    public boolean waitForTextToBeAvailable(By selector, int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

        boolean isAvailable;
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(selector));
            isAvailable = true;
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
            isAvailable = false;
        }

        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT);
        return isAvailable;
    }

    public void disbaledSavePassword(){
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement savePasswordButton = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    By.xpath("//android.widget.Button[@resource-id=\"android:id/autofill_dialog_no\"]")));

            savePasswordButton.click();
            System.out.println("Clicked 'no thanks' button on Google Password popup");

        } catch (Exception e) {
            System.out.println("Google Password popup not found or other issue: " + e.getMessage());
        }
    }

    public static void pressAndroidBackButton() {
        AndroidDriver driver = (AndroidDriver) DriverManager.getDriver();
        driver.pressKey(new KeyEvent(AndroidKey.BACK));
    }

    public boolean waitForWebElementToBeAvailable(WebElement element, int seconds) {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(0));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));

        boolean isAvailable;
        try {
            wait.until(ExpectedConditions.visibilityOf(element));
            isAvailable = true;
        } catch (NoSuchElementException | TimeoutException | StaleElementReferenceException e) {
            isAvailable = false;
        }

        driver.manage().timeouts().implicitlyWait(Constants.DEFAULT_TIMEOUT);
        return isAvailable;
    }



}
