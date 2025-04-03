package base.hooks;

import io.appium.java_client.AppiumDriver;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import base.core.drivers.DriverManager;
import base.core.drivers.DriverProvider;
import base.core.library.Constants;
import base.core.library.PropertyLoader;

public class Hooks {

    /**
     * BeforeAll hooks run before all and one time.
     * For example if we want to download the app from server we can use this.
     */
    @BeforeAll
    public static void setup() {
        PropertyLoader.getInstance().setPlatform(Constants.Platforms.ANDROID);
        PropertyLoader.getInstance().setAppPath(Constants.Apps.ANDROID);
    }

    /**
     * Before hooks run before the first step of each scenario.
     */
    @Before
    public static void beforeTest() {
        DriverProvider driverProvider = new DriverProvider();
        AppiumDriver driver = driverProvider.getDriver();

        if (driver == null) {
            throw new RuntimeException("Driver initialization failed. Driver is null.");
        }

        DriverManager.setDriver(driver);
    }



    /**
     * After hooks run after the last step of each scenario,
     * even when the step result is failed, undefined, pending, or skipped.
     */
    @After
    public static void afterTest() {
        DriverManager.removeDriver();
    }

    @AfterAll
    public static void tearDown() {

    }
}
