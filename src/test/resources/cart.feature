Feature: Cart Page Functionality
 
  Scenario: View cart page
    Given user is logged in
    And user is on the cart page
    Then cart page should be displayed
 
  Scenario: Continue shopping from cart
    Given user is logged in
    And user has added items to the cart
    And user is on the cart page
    When user clicks on "Continue Shopping"
    Then user should be redirected to the products page
 
  Scenario: Proceed to checkout from cart
    Given user is logged in
    And user has added items to the cart
    And user is on the cart page
    When user clicks on "Checkout"
    Then user should be redirected to the checkout page