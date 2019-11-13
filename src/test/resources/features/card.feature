Feature: Card feature
  As a owner, I want add, delete and update a card, so that I can verify the UI board

Background:
  Given I log in with the user "owner"
  And a board created with the name:
    | Title | My board |
  And I add a list with the name:
    | Name | To Do |

  Scenario: Create cards in boards
    When I create the following cards:
      | name Card | Selenium tasks |
      | name Card | Java     tasks |
      | name Card | Python tasks   |
    Then I should see "Selenium tasks" in the list of cards

  Scenario: Delete a card in boards
    When I create the following cards:
      | name Card | Selenium tasks |
      | name Card | Java     tasks |
      | name Card | Python tasks   |
    When I delete "Selenium tasks" card
    Then I should NOT see "Selenium tasks" in the list of cards

  Scenario: Update card name in board
    When I create the following cards:
      | name Card | Selenium tasks |
      | name Card | Java     tasks |
      | name Card | Python tasks   |
    And I modify the name of card "Selenium tasks" to "New Selenium 3.0"
    Then I should see "New Selenium 3.0" in the list of cards