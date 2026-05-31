# User Story 1
Feature: New Deques are Empty
  Brand new data structures should not have items

  Scenario: Brand new deque
    Given that I have a brand new deque
    When I ask the size of the deque
    Then it should tell me size is 0
