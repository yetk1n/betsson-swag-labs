@smoke @products
Feature: Products page functionality

  Background:
    Given User is on the login page
    When User enters username "problem_user" and password "secret_sauce"
    And User clicks login button
    Then the login should be "success"

#  Scenario Outline: Filter products
#    Given User is opened the filters section
#    When User clicks "<filter>"
#    Then "<filter>" should be applied
#
#    Examples:
#      | filter               |
#      | Name (A to Z)        |
#      | Name (Z to A)        |
#      | Price (low to high)  |
#      | Price (high to low)  |
#
#
#  Scenario: Adding a product to cart
#    When User adds product to cart
#    Then the product should be added to cart

  Scenario: Go to product detail page
    When User clicks on the the number 1 product box
    Then the product detail page should be displayed
