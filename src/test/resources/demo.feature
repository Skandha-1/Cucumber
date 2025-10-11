Feature: Saucedemo Login Page

  Background:
    Given user on login page

  @Completed
  Scenario Outline: Successfully Login Functionality
    When entering valid username "<Username>" and password "<Password>"
    Then dashboard page is displayed
    And user logs out

    Examples:
| Username      | Password     |
| standard_user | secret_sauce |

  Scenario Outline: Invalid Login Functionality
    When enter invaild credentials "<Username>" and "<Password>"
    Then still in the login page

    Examples:
| Username  | Password     |
| demouser  | secresauce   |

 