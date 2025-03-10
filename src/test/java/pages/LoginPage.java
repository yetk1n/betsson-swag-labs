package pages;

import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    @AndroidFindBy(accessibility = "test-Login")
    public WebElement loginPage;

    @AndroidFindBy(accessibility = "test-Username")
    public WebElement usernameInput;

    @AndroidFindBy(accessibility = "test-Password")
    public WebElement passwordInput;

    @AndroidFindBy(accessibility = "test-LOGIN")
    public WebElement loginButton;

    @AndroidFindBy(accessibility = "test-Error message")
    public WebElement errorMessage;

    @AndroidFindBy(accessibility = "test-PRODUCTS")
    public WebElement products;

    public LoginPage() {
        super();
    }

    // Clear and enter username
    public void enterUsername(String username) {
        clearAndSendKeys(usernameInput, username);
    }

    // Clear and enter password
    public void enterPassword(String password) {
        clearAndSendKeys(passwordInput, password);
    }

    // Click the Login button
    public void clickLoginButton() {
        click(loginButton);
    }

    // Get error message text
    public String getErrorMessage() {
        return getText(errorMessage);
    }

    // Perform login (combines actions)
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

    // Verify login failed by checking the visibility of the error message
    public boolean isLoginFailed() {
        return isVisible(errorMessage);
    }

    // Check if login page is visible or not
    public void isLoginPageOpened(){
        isVisible(loginPage);
    }

    // Returns "failure" if error message is visible; otherwise returns "success"
    public String getLoginStatus() {
        try {
            if (errorMessage.isDisplayed()) {
                return "failure";
            }
        } catch (Exception e) {
            // Error message element not found or not accessible, continue to next check
        }

        // If we get here, either the error message isn't displayed or we caught an exception
        if (isVisible(products)) {
            logger.info("Successfully logged in!");
            return "success";
        } else {
            return "failure";
        }
    }


}