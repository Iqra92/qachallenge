package base.core.drivers;


import base.core.library.Constants;
import base.core.library.ReusableMethods;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import base.core.library.PropertyLoader;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;


public class DriverProvider {
    private static DriverProvider instance;
    private static AppiumDriver driver;
    PropertyLoader props = ReusableMethods.getProperties();


    public DriverProvider() {}

    public static DriverProvider getInstance() {
        if (instance == null) {
            instance = new DriverProvider();
        }
        return instance;
    }

    public AppiumDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        if (driver == null) {
            throw new IllegalStateException("Driver is not initialized properly!");
        }
        return driver;
    }


    private void initializeDriver() {
        try {
            if (props.getPlatform().equalsIgnoreCase(Constants.Platforms.ANDROID)) {
                initializeAndroidDriver();
            } else {
                initializeIosDriver();
            }

            if (driver == null) {
                throw new RuntimeException("Driver initialization failed. Driver is null.");
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
            throw new RuntimeException("MalformedURLException: " + e.getMessage());
        }

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }


    private void initializeAndroidDriver() throws MalformedURLException {
        UiAutomator2Options options = new UiAutomator2Options();
        options.setPlatformName("Android");
        options.setAutomationName("UiAutomator2");
        options.setApp(props.getAppPath());
        options.setAppActivity("*");
        options.setAutoGrantPermissions(true);
        options.setDeviceName("R58N61NX8PT");
        options.setAppWaitDuration(Duration.ofSeconds(60));
        options.setAutoGrantPermissions(true);
        options.setAppActivity("com.hostelworld.qacodechallenge.MainActivity");
        options.setAppPackage("com.hostelworld.qacodechallenge");

        options.setAppWaitDuration(Duration.ofSeconds(60));


        URL url = new URL("http://127.0.0.1:4723/");
        driver = new AndroidDriver(url, options);
    }

    private void initializeIosDriver() throws MalformedURLException {
        // TODO: Initialize iOS Driver
    }
}
