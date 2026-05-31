# User Story 5
Feature: Remove the second item from the front
  As a developer using a deque
  I want to remove the second item from the front
  So that I can process a queued item out of order while preserving the front item

  Scenario: Remove the second item from a deque with several items
    Given a new deque
    When I add "first" to the back
    And I add "second" to the back
    And I add "third" to the back
    And I remove the second item from the front
    Then the removed item is "second"
    And the deque contains "first, third" from front to back
    And the deque size is 2

  Scenario: Reject removing the second item from a single-item deque
    Given a new deque
    When I add "only" to the back
    And I attempt to remove the second item from the front
    Then removing the second item fails because fewer than two items exist
    And the deque contains "only" from front to back
    And the deque size is 1
