# User Story 3
Feature: Remove elements from either end
  As a developer using a deque
  I want to remove elements from the front or back
  So that I can retrieve the next element required by my algorithm

  Scenario: Remove an element from the front
    Given a new deque
    When I add "first" to the front
    And I add "last" to the back
    And I remove an item from the front
    Then the removed item is "first"
    And the deque contains "last" from front to back

  Scenario: Remove an element from the back
    Given a new deque
    When I add "first" to the front
    And I add "last" to the back
    And I remove an item from the back
    Then the removed item is "last"
    And the deque contains "first" from front to back
