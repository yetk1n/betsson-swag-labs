package driver;

import org.openqa.selenium.remote.DesiredCapabilities;
import utils.ConfigReader;

public class Capabilities {

    public static DesiredCapabilities getAndroidCapabilities() {
        DesiredCapabilities capabilities = new DesiredCapabilities();

        // Platform & Device
        capabilities.setCapability("platformName", ConfigReader.getProperty("androidPlatformName"));
        capabilities.setCapability("automationName", ConfigReader.getProperty("androidAutomationName"));
        capabilities.setCapability("udid", ConfigReader.getProperty("androidUDID"));
        // Optionally set deviceName; if not provided, we reuse the UDID
        String deviceName = ConfigReader.getProperty("androidDeviceName");
        if (deviceName.isEmpty()) {
            deviceName = ConfigReader.getProperty("androidUDID");
        }
        capabilities.setCapability("deviceName", deviceName);

        // App Configuration
        capabilities.setCapability("app",
                System.getProperty("user.dir") + "/" + ConfigReader.getProperty("androidAppLocation"));
        capabilities.setCapability("appPackage", ConfigReader.getProperty("androidAppPackage"));
        capabilities.setCapability("appActivity", ConfigReader.getProperty("androidAppActivity"));

        return capabilities;
    }
}
