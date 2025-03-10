package pages;

import driver.DriverManager;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {
    protected RemoteWebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(this.driver, Duration.ofSeconds(10));
        PageFactory.initElements(new AppiumFieldDecorator(this.driver, Duration.ofSeconds(10)), this);
    }

    // Create a logger instance for this class
    public static final Logger logger = LogManager.getLogger(BasePage.class);

    // Click on an element when it is clickable
    public void click(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    // Clear the existing text and type new text
    public void clearAndSendKeys(WebElement element, String text) {
        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(text);
    }

    // Get text from an element
    public String getText(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    // Check if an element is visible
    public boolean isVisible(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).isDisplayed();
    }

    // Check if an element is displayed without blocking or throwing exceptions
    public boolean isDisplayedWithoutError(WebElement element) {
        try {
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement findElementByXpath(String xpath) {
        return DriverManager.getDriver().findElement(By.xpath(xpath));
    }


    // Verifies if prices displayed on the page are in ascending order
    public void arePricesInAscendingOrder(List<WebElement> priceElements) {
        // If fewer than 2 elements, we can consider it "in order" by default
        if (priceElements.size() < 2) {
            return;
        }

        // Extract the price values
        List<Double> prices = new ArrayList<>();
        for (WebElement element : priceElements) {
            // Extract text and remove dollar sign
            String priceText = element.getText().replace("$", "");
            try {
                double price = Double.parseDouble(priceText);
                prices.add(price);
            } catch (NumberFormatException e) {
                logger.info("Warning: Could not parse price: {}", element.getText());
            }
        }

        // Check if the prices are in ascending order
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) > prices.get(i + 1)) {
                return; // Not in ascending order
            }
        }

    }

    public void arePricesInDescendingOrder(List<WebElement> priceElements) {
        // If fewer than 2 elements, we can consider it "in order" by default
        if (priceElements.size() < 2) {
            return;
        }

        // Extract the price values
        List<Double> prices = new ArrayList<>();
        for (WebElement element : priceElements) {
            // Extract text and remove dollar sign
            String priceText = element.getText().replace("$", "");
            try {
                double price = Double.parseDouble(priceText);
                prices.add(price);
            } catch (NumberFormatException e) {
                logger.info("Warning: Could not parse price: {}", element.getText());
            }
        }

        // Check if the prices are in descending order
        for (int i = 0; i < prices.size() - 1; i++) {
            if (prices.get(i) < prices.get(i + 1)) {
                return; // Not in descending order
            }
        }

    }


    public void areTitlesInAlphabeticalOrder(List<WebElement> titleElements) {
        // If fewer than 2 elements, we can consider it "in order" by default
        if (titleElements.size() < 2) {
            return;
        }

        // Extract the title texts
        List<String> titles = new ArrayList<>();
        for (WebElement element : titleElements) {
            String titleText = element.getText().trim();
            titles.add(titleText);
        }

        // Check if the titles are in alphabetical order
        for (int i = 0; i < titles.size() - 1; i++) {
            if (titles.get(i).compareToIgnoreCase(titles.get(i + 1)) > 0) {
                return; // Not in alphabetical order
            }
        }

    }

    public void areTitlesInReverseAlphabeticalOrder(List<WebElement> titleElements) {
        // If fewer than 2 elements, we can consider it "in order" by default
        if (titleElements.size() < 2) {
            return;
        }

        // Extract the title texts
        List<String> titles = new ArrayList<>();
        for (WebElement element : titleElements) {
            String titleText = element.getText().trim();
            titles.add(titleText);
        }

        // Check if the titles are in reverse alphabetical order
        for (int i = 0; i < titles.size() - 1; i++) {
            if (titles.get(i).compareToIgnoreCase(titles.get(i + 1)) < 0) {
                return; // Not in reverse alphabetical order
            }
        }

    }


    public void scrollPage(int times) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        for (int i = 0; i < times; i++) {
            Sequence scroll = new Sequence(finger, 1);
            scroll.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), 500, 1500)); // Start point
            scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
            scroll.addAction(finger.createPointerMove(Duration.ofMillis(500), PointerInput.Origin.viewport(), 500, 500)); // End point
            scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
            driver.perform(List.of(scroll));

            // Optional: Add a short pause to ensure the page has finished scrolling/loading
            try {
                Thread.sleep(500); // Adjust the wait time as necessary for your application
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }


    // Scroll to an element
    public void scrollTo(WebElement element) {
        driver.executeScript("arguments[0].scrollIntoView(true);", element);
    }
}