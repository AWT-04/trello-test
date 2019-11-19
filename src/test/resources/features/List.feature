Feature: List feature
  As owner, I want add, delete and update a list, so that I can verify the UI board

  Background:
    Given I log in with the user "owner"
    And I navigate to created board

  @createBoard @deleteBoard
  Scenario: Verify the list creation in a board
    When I add a list with the name:
      | Name | To Do |
    And I create the following card:
      | Name | Selenium tasks |
    Then I should see the list "To Do" in the board
    And I select the card "Selenium tasks"
    And I should see "To Do" in list after selecting card

  @createBoard @deleteBoard
  Scenario: Verify archive a list in a board
    When I add a list with the name:
      | Name | Task |
    And I archive the list:
      | Name | Task |
    Then I don't should see the list:
      | Name | Task |
    And I delete the board created