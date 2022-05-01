@ui
Feature: User reset password
  Background:
    Given user is on the reset password page

  Scenario: provide an invalid email to reset password
    When user enters "bob@roomex.com" for email input box
    And clicks Reset Password button
    Then an error message is displayed

