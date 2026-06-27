# User Story 5
Feature: Remove from back
  An item can be removed from back of the deque

  Scenario: Remove from back
    Given that I have a deque with size 4
    And the second to last item has a value of 3
    When remove the last item
    Then the value of the "last" item is now 3
