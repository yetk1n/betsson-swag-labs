package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import driver.DriverManager;

public class Hooks {

    @Before
    public void setUp() {
        // This will initialize the Appium driver before each scenario
        DriverManager.getDriver();
    }

    @After
    public void tearDown() {
        // Quit the driver after each scenario
        DriverManager.quitDriver();
    }
}
