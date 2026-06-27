# User Story 4
Feature: Inspect deque state
  As a developer using a deque
  I want to inspect its size and whether it is empty
  So that I can safely decide whether to process another element

  Scenario: Size and emptiness reflect deque changes
    Given a new deque
    When I add "first" to the back
    And I add "second" to the back
    And I remove an item from the front
    Then the deque is not empty
    And the deque size is 1
