package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import pages.LoginPage;

public class LoginSteps {

    private final LoginPage loginPage;

    public LoginSteps() {
        this.loginPage = new LoginPage();
    }


    @Given("User is on the login page")
    public void userIsOnTheLoginPage() {
        loginPage.isLoginPageOpened();
    }

    @When("User enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
    }

    @Then("the login should be {string}")
    public void theLoginShouldBe(String expectedStatus) {
        String actualStatus = loginPage.getLoginStatus();
        if (!actualStatus.equalsIgnoreCase(expectedStatus)) {
            throw new AssertionError("Expected login status: " + expectedStatus + ", but got: " + actualStatus);
        }
    }

    @And("User clicks login button")
    public void userClicksLoginButton() {
        loginPage.clickLoginButton();
    }
}

