package runners;

import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
        features = "src/test/resources",
        glue = {"steps"},
        plugin = {"pretty", "html:target/cucumber-reports.html"},
        tags = "@smoke"
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

