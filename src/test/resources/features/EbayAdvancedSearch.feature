#Author: talaatharb
Feature: Advanced search page features

  @Navigation
  Scenario: Ebay logo
    Given I am on Ebay 'Advanced search' page
    When I click on Ebay logo
    Then I naviagate to the 'Home' page

  @Search
  Scenario: Advanced search
    Given I am on Ebay 'Advanced search' page
    When I do advanced search
      | keyword   | exclude     | minPrice | maxPrice |
      | IPhone 14 | refurbished |      300 |      900 |
    Then I confirm at least 1000 results