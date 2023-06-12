Feature: Test Facebook smoke scenario

  Scenario: Test log in with valid credentials
    Given Open google chrome and launch the application
    When I enter a valid username and valid password
    Then The user should be able to log in successfully