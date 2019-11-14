Feature: Create new board in Trello
  As a owner, I want create a new board, so that I can verify in the UI board.

  Background:
    Given I log in with the user "owner"

  Scenario: Create new board with boards page
    When I create new board from "boards page" with a:
      | Title      | Fernando |
      | Background | green    |
      | Privacy    | public   |

    Then I should see the board

  Scenario: Create new board with add button
    When I create new board from "add button" with a:
      | Title      | Fernando |
      | Background | blue     |
      | Privacy    | private  |
    Then I should see the board

  Scenario: Create new board with board button
    When I create new board from "board button" with a:
      | Title      | Fernando |
      | Background | red      |
      | Privacy    | private  |
    Then I should see the board