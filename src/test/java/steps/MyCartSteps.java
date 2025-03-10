package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MyCartPage;
import pages.ProductsPage;

public class MyCartSteps {
    private final MyCartPage myCartPage;
    private final ProductsPage productsPage;

    public MyCartSteps() {
        this.myCartPage = new MyCartPage();
        this.productsPage = new ProductsPage();

    }

    @Given("User is on the My Cart page and added a product to cart")
    public void userIsOnTheMyCartPageAndAddedAProductToCart() {
        productsPage.addFirstItemToCart();
        productsPage.goToMyCartPage();
        myCartPage.isMyCartPageOpened();
        myCartPage.isCartHasProduct();
    }

    @When("User removes the products from the cart")
    public void userRemovesTheProductsFromTheCart() {
        myCartPage.removeAllProductsFromCart();
    }

    @Then("no product should be left on the cart page")
    public void noProductShouldBeLeftOnTheCartPage() {
        myCartPage.isCartEmpty();
    }
}
