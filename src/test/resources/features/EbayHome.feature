#Author: talaatharb
Feature: Ebay Home page scenarios

  @Navigation
  Scenario: Advanced search link
    Given I am on Ebay 'Home' page
    When I click on Advanced Link
    Then I naviagate to the 'Advanced search' page

  @Search
  Scenario: Search items count
    Given I am on Ebay 'Home' page
    When I search for "IPhone 14"
    Then I confirm at least 1000 results
    
  @Search
  Scenario: Search an item in category
    Given I am on Ebay 'Home' page
    When I search for 'Dell' in category 'Computers/Tablets & Networking'
    Then I confirm at least 10000 results