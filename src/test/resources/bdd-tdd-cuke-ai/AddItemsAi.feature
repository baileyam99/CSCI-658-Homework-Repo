# User Story 2
Feature: Add elements to either end
  As a developer using a deque
  I want to add elements at the front or back
  So that I can control their processing order

  Scenario: Add elements at the front and back
    Given a new deque
    When I add "middle" to the front
    And I add "first" to the front
    And I add "last" to the back
    Then the deque contains "first, middle, last" from front to back
    And the deque size is 3
