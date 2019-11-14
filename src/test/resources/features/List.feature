Feature: List feature
  As owner, I want add, delete and update a list, so that I can verify the UI board

  Background:
    Given I log in with the user "owner"
    And a board created with the name:
      | Title | My board |

  Scenario: Verify the list creation in a board
    When I add a list with the name:
      | Name | To Do |
    And I create the following cards:
      | name Card | Selenium tasks |
    Then I should see the list "To Do" in the board
    And I select the card "Selenium tasks"
    And I should see "To Do" in list after selecting card

  Scenario: Verify archive a list in a board
    When I add a list with the name:
      | Name | To Do |
    And I archive the list:
      | Name | To Do |
    Then I don't should see the list:
      | Name | To Do |