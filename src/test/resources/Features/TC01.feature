Feature: feature to test n11.com cart functionality

  Scenario: cart functionality on n11

    Given user is on n11
    When search the product and click Enter key
    And select the product that want to buy
    And click to button to add into cart
    And User click the button to go to cart
    And User check the product
    And User search the product again
    And Select same product by another merchant
    And click to button to add into cart again
    And go to the cart again
    Then User Check the Cart