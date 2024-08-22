#Author: talaatharb
Feature: Ebay Home page scenarios

  @Navigation
  Scenario: Advanced search link
    Given I am on Ebay 'Home' page
    When I click on 'Advanced' Link
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

  @Navigation
  Scenario Outline: Tab links
    Given I am on Ebay 'Home' page
    When I click on '<tabName>' Link
    Then I naviagate to the '<pageName>' page
    And I confirm page title contains '<title>'

    Examples: 
      | tabName     | pageName    | title       |
      | Motors      | Auto Parts  | Auto Parts  |
      | Electronics | Electronics | Electronics |
