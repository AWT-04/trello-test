Feature: Create new board in Trello
  As a owner, I want create a new board, so that I can verify in the UI board.

  Background:
    Given I log in with the user "owner"

  Scenario: Create new board with boards page
    When I create new board from "boards page" with a:
      | Title      | Fernando |
      | Background | green    |
      | Privacy    | private  |
    Then I should see the board

  Scenario: Create new board with boards page
    When I create new board from "boards page" with a:
      | Title      | Fernando05 |
      | Background | green      |
      | Privacy    | private    |
    Then I should see the board

  @cleanBoardsAfter
  Scenario: Create new board with boards page
    When I create new board from "boards page" with a:
      | Title      | Fernando01 |
      | Background | green      |
      | Privacy    | private    |
    Then I should see the board