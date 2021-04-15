Feature: Track covid Infected people around the world

  Scenario Outline: Successful login with valid credentials
    """
    As a user, I would like to reach landing screen after login successfully with a valid credential.
    """
    Given I am on the login page for <Platform>
    When I enter the valid credentials
    Then I shall see successful login to landing screen
    Examples:
      | Platform |
      | web      |
      | ios      |
      | android  |


  Scenario Outline: UnSuccessful login with password and username length greater than 8 and invalid credential
    """
    As a user, I would like to be prompt with error message if I enter password and username length greater than 8 and invalid credential entere.
    """
    Given I am on the login page for <Platform>
    When I enter the invalid credentials
    Then I shall see error message
    Examples:
      | Platform |
      | web      |
      | ios      |
      | android  |

  Scenario Outline: I would like to see submit button disable if either one of the fields(username/password) is empty.
    """
    As a user, I would like to see submit button disable if either one of the fields(username/password) is empty.
    """
    Given I am on the login page for <Platform>
    When I enter either username or password only
    Then I shall not see submit button
    Examples:
      | Platform |
      | web      |
      | ios      |
      | android  |