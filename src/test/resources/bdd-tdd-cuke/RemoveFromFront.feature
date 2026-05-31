# User Story 3
Feature: Items can be removed from the front
  An item can be removed from front of the deque

  Scenario: Remove from front
    Given that I have a deque with size 4
    And the second item has a value of 2
    When I remove the first item
    Then the value of the "front" item is now 2
