@ui
Feature: User can login
  Background:
    Given the user is on the login page

  Scenario: User clicks Login leaving email/password empty
    When user clicks Login button
    Then email error message displayed
    And password error message displayed