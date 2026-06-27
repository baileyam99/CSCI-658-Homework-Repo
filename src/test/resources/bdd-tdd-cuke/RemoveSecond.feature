# User Story 6
Feature: The second item, specifically, can be removed
  The item second fromt the front can be targeted for removal

  Scenario: Remove second item
    Given that I have a deque with size 3
    And the second item has a value of 2
    When I remove the second item
    Then the second item has a value of 3

  Scenario: Remove second item
    Given that I have a deque with size 1
    Then a NoSuchElementException is thrown