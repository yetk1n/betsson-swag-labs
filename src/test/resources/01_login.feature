@smoke @login
Feature: Login functionality

  # Scenario Outline is used because there is only one generic error message for failed login attempts.
  # In larger and more complex projects, if failure messages vary, separate scenarios can be used for better management.
  Scenario Outline: Login attempts with various credentials
    Given User is on the login page
    When User enters username "<username>" and password "<password>"
    And User clicks login button
    Then the login should be "<status>"

    Examples:
      | username       | password         | status   |
      # 1. Wrong user     + Wrong password   = Failure
      | wrong_user     | wrong_password   | failure  |
      # 2. Correct user   + Wrong password   = Failure
      | problem_user   | wrong_password   | failure  |
      # 3. Correct user   + Correct password = Success
      | problem_user   | secret_sauce     | success  |
