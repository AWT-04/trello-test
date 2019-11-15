Feature: Card feature
  As owner, I want add, delete and update a card, so that I can verify the UI board

  Background:
    Given I log in with the user "owner"
    And  I create new board from "boards page" with a:
      | Title | My board |
    And I add a list with the name:
      | Name | To Do |

  Scenario: Verify the cards creation in list
    When I create the following cards:
      | name Card | Selenium tasks |