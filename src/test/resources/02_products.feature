@smoke @products
Feature: Products page functionality

  Background:
    Given User is on the login page
    When User enters username "problem_user" and password "secret_sauce"
    And User clicks login button
    Then the login should be "success"

  # Scenario verifying that product filters (by name and price sort order)
  # correctly apply when selected by the user.
  Scenario Outline: Filter products
    Given User is opened the filters section
    When User clicks "<filter>"
    Then "<filter>" should be applied

    Examples:
      | filter               |
      | Name (A to Z)        |
      | Name (Z to A)        |
      | Price (low to high)  |
      | Price (high to low)  |

  # Scenario validating that when the user adds a product, the cart icon updates,
  # the cart page opens successfully, and the added product is visible within the cart.
  Scenario: Adding a product to cart
    When User adds product to cart
    Then the product should be added to cart

  # Scenario verifying that clicking on the given numbered product navigates to the
  # respective product detail page and correctly displays the product description.
  Scenario: Go to product detail page
    When User clicks on the the number 1 product box
    Then the product detail page should be displayed
