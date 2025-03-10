package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.MyCartPage;
import pages.ProductDetailPage;
import pages.ProductsPage;

public class ProductsSteps {
    private final ProductsPage productsPage;
    private final MyCartPage myCartPage;
    private final ProductDetailPage productDetailPage;


    public ProductsSteps() {
        this.productsPage = new ProductsPage();
        this.myCartPage = new MyCartPage();
        this.productDetailPage = new ProductDetailPage();
    }

    @When("User adds product to cart")
    public void userAddsProductToCart() {
        productsPage.addFirstItemToCart();
    }

    @Then("the product should be added to cart")
    public void theProductShouldBeAddedToCart() {
        productsPage.isOneItemAddedToCartIconVisible();
        productsPage.goToMyCartPage();
        myCartPage.isMyCartPageOpened();
        myCartPage.isAddedProductInCart();
    }

    @Given("User is opened the filters section")
    public void userIsOpenedTheFiltersSection() {
        productsPage.openFilterSection();
    }

    @When("User clicks {string}")
    public void userClick(String filter) {
        productsPage.selectSortingOption(filter);
    }

    @Then("{string} should be applied")
    public void shouldBeApplied(String filter) {
        if (filter.equalsIgnoreCase("Name (A to Z)")) {
            productsPage.areTitlesSortedAlphabetically();
        } else if (filter.equalsIgnoreCase("Name (Z to A)")) {
            productsPage.areTitlesSortedAlphabeticallyAsReverse();
        } else if (filter.equalsIgnoreCase("Price (low to high)")) {
            productsPage.arePricesSortedAscending();
        } else if (filter.equalsIgnoreCase("Price (high to low)")) {
            productsPage.arePricesSortedDescending();
        } else {
            throw new IllegalArgumentException("Unknown filter: " + filter);
        }
    }


    @When("User clicks on the the number {int} product box")
    public void userClicksOnTheTheNumberProductBox(int number) {
        productsPage.clickOnProductByNumber(number);
    }

    @Then("the product detail page should be displayed")
    public void theProductDetailPageShouldBeDisplayed() {
        productsPage.isVisible(productDetailPage.productDescription);
    }
}
