# User Story 4
Feature: Items can be added to the back
  An item can be inserted into the back of the deque

  Scenario: Add to back
    Given that I have a deque with size 3
    When I add an item, 5, to the "back" of the deque
    Then the value of the item at the "back" should be 5
