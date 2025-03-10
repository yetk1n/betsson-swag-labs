package pages;

import driver.DriverManager;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MyCartPage extends BasePage{

    @AndroidFindBy(xpath = "//android.widget.TextView[@text=\"YOUR CART\"]")
    public WebElement yourCartTitle;

    @AndroidFindBy(accessibility = "test-REMOVE")
    public WebElement removeButton;




    public void isMyCartPageOpened(){
        isVisible(yourCartTitle);
    }

    public void isCartHasProduct() {
        isVisible(removeButton);
    }

    public void removeAllProductsFromCart() {
        while (isDisplayedWithoutError(removeButton)) {
            removeButton.click();
        }
        logger.info("All products are removed from the cart.");
    }

    public void isCartEmpty() {
        if (!isDisplayedWithoutError(removeButton)) {
            logger.info("Cart is empty: Remove button is not visible");
        } else {
            throw new AssertionError("Cart contains products as the remove button is visible.");
        }
    }


    // Verifies if the product previously added to cart is displayed in the cart
    public void isAddedProductInCart() {
        String productTitle = ProductsPage.getAddedProductTitle();
        try {
            WebElement productInCart = DriverManager.getDriver().findElement(
                    By.xpath("//android.widget.TextView[@text=\"" + productTitle + "\"]"));
            productInCart.isDisplayed();
            logger.info("Found product in the cart: {}", productInCart.getText());
        } catch (Exception e) {
            // Re-throw the exception instead of silently ignoring it
            throw new RuntimeException("Product not found in cart: " + productTitle, e);
        }
    }

}
