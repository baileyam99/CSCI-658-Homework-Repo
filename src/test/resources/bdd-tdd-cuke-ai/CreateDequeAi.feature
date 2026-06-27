# User Story 1
Feature: Create a deque
  As a developer using a deque
  I want a new deque to start empty
  So that I can begin collecting elements without special setup

  Scenario: A new deque starts empty
    Given a new deque
    Then the deque is empty
    And the deque size is 0
