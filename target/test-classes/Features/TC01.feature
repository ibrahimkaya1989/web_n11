Feature: feature to test n11.com wishList functionality

  Scenario: wishList functionality on n11

    Given user is on n11
    When search the product and validate search result
    And go to second page and validate page
    And add into watch list
    And go to watch list
    And validate the product in watch list
    And remove the product from watch list
    Then validate the watch list