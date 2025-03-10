package pages;

import driver.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.List;

public class ProductsPage extends BasePage {

    @AndroidFindBy(xpath = "(//android.view.ViewGroup[@content-desc=\"test-ADD TO CART\"])[1]")
    public WebElement firstItemAddToCart;

    @AndroidFindBy(xpath = "(//android.widget.TextView[@text=\"1\"])")
    public WebElement oneItemAddedToCartIcon;

    @AndroidFindBy(accessibility = "test-Modal Selector Button")
    public WebElement filterButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Price\"]")
    private List<WebElement> priceElements;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"test-Item title\"]")
    private List<WebElement> productTitleElements;

    private static String addedProductTitle;

    @AndroidFindBy(accessibility = "test-Cart")
    public WebElement myCartButton;

    @AndroidFindBy(xpath = "//android.view.ViewGroup[@content-desc='test-Item']")
    public List<WebElement> productBoxes;


    public ProductsPage() {
        super();
    }

    public void addFirstItemToCart() {
        // Get the title of the first product before adding it to cart
        WebElement firstItemTitle = findElementByXpath("(//android.widget.TextView[@content-desc='test-Item title'])[1]");
        addedProductTitle = firstItemTitle.getText();

        // Add the item to cart
        firstItemAddToCart.click();
        logger.info("First item ({}) added to cart.", addedProductTitle);
    }

    // Getter method to access the stored title from other classes
    public static String getAddedProductTitle() {
        return addedProductTitle;
    }

    public void goToMyCartPage() {
        myCartButton.click();
        logger.info("Navigated to the Cart page.");
    }

    public void isOneItemAddedToCartIconVisible() {
        isVisible(oneItemAddedToCartIcon);
    }

    // Method to check if prices are sorted
    public void arePricesSortedAscending() {
        arePricesInAscendingOrder(priceElements);
    }

    // Method to check if prices are sorted in descending order
    public void arePricesSortedDescending() {
        arePricesInDescendingOrder(priceElements);
    }

    public void openFilterSection() {
        filterButton.click();
        logger.info("Opened the filter section.");

    }

    // Method to check if titles are sorted alphabetically
    public void areTitlesSortedAlphabetically() {
        areTitlesInAlphabeticalOrder(productTitleElements);
    }

    // Method to check if titles are sorted reverse way alphabetically
    public void areTitlesSortedAlphabeticallyAsReverse() {
        areTitlesInReverseAlphabeticalOrder(productTitleElements);
    }


    // Selects a sorting option based on the provided text.
    public void selectSortingOption(String optionText) {
        logger.info("Filter value: {}", optionText);
        String dynamicXPath = String.format("//android.widget.TextView[@text='%s']", optionText);
        WebElement sortingOption = DriverManager.getDriver().findElement(By.xpath(dynamicXPath));
        sortingOption.click();
    }


    // Method to click on a product based on the given number
    public void clickOnProductByNumber(int number) {
        if (number > 2) {
            // Scroll once if the number is more than 2
            scrollPage();
        }
        if (number > 4) {
            // Scroll twice if the number is more than 4
            scrollPage();
        }

        String dynamicXPath = String.format("(//android.view.ViewGroup[@content-desc=\"test-Item\"])[%d]", number);
        WebElement productElement = DriverManager.getDriver().findElement(By.xpath(dynamicXPath));
        productElement.click();
        logger.info("Clicked on product number: {}", number);
    }


    private void scrollPage() {
        // Define scrolling action
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence scroll = new Sequence(finger, 1);
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(0),
                PointerInput.Origin.viewport(), 500, 1500)); // Start point of scroll
        scroll.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        scroll.addAction(finger.createPointerMove(Duration.ofMillis(1000),
                PointerInput.Origin.viewport(), 500, 500)); // End point of scroll
        scroll.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        DriverManager.getDriver().perform(List.of(scroll));
    }
}
