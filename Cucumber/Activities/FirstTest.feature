Feature: Basic Syntax

  @Scenario1
  Scenario: Testing TS homepage
    Given the user on homepage
    When the user click on About us link
    Then the user will redirected to the about homepage
    Then close the browser