# User Story 2
Feature: Items can be added to the front
  An item can be inserted into the front of the deque

  Scenario: Add to front
    Given that I have a deque with size 3
    When I add an item, 0, to the "front" of the deque
    Then the value of the item at the "front" should be 0
