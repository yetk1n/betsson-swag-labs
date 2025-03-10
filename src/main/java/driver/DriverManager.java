package driver;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import utils.ConfigReader;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class DriverManager {
    private static RemoteWebDriver driver;

    public static RemoteWebDriver getDriver() {
        if (driver == null) {
            try {
                driver = new AndroidDriver(
                        new URL(ConfigReader.getProperty("appiumURL")),
                        Capabilities.getAndroidCapabilities()
                );
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            } catch (MalformedURLException e) {
                throw new RuntimeException("Appium URL is invalid", e);
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}