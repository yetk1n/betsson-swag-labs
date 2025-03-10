@smoke @mycart
Feature: Login functionality

  Background:
    Given User is on the login page
    When User enters username "problem_user" and password "secret_sauce"
    And User clicks login button
    Then the login should be "success"

  # Scenario validating that when a user removes all products from the cart, the cart becomes empty.
  Scenario: Remove the products from the cart
    Given User is on the My Cart page and added a product to cart
    When User removes the products from the cart
    Then no product should be left on the cart page


