#Author: talaatharb
Feature: Ebay Home page scenarios

  @Naviagation
  Scenario: Advanced search link
    Given I am on Ebay Home page
    When I click on Advanced Link
    Then I naviagate to the Advanced Search page
