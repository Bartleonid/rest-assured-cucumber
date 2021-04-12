Feature: Add Phone

  Scenario: Add new valid phone number
    Given I am authorized
    When I add Phone
    Then Status code is 200
