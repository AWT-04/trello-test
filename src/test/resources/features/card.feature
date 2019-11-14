Feature: Card feature
  As owner, I want add, delete and update a card, so that I can verify the UI board

  Background:
    Given I log in with the user "owner"
    And a board created with the name:
      | Title | My board |
    And I add a list with the name:
      | Name | To Do |

  Scenario: Verify the cards creation in list
    When I create the following cards:
      | name Card | Selenium tasks |
      | name Card | Java     tasks |
      | name Card | Python tasks   |
    Then I should see "Selenium tasks" in the list of cards
    And I select the card "Selenium tasks"
    And I should see "Selenium tasks" in the title after selecting card
    And I shoud see "Selenium tasks" in the page title
    And I should see "Selenium tasks" in the menu of activity
    And I should see "To Do" in list after selecting card

  Scenario: Delete a card in boards
    When I create the following cards:
      | name Card | Selenium tasks |
      | name Card | Java     tasks |
      | name Card | Python tasks   |
      | name Card | C# tasks       |
    When I delete "Selenium tasks" card
    Then I should NOT see "Selenium tasks" in the list of cards

  Scenario: Update card name in board
    When I create the following cards:
      | name Card | Selenium tasks |
      | name Card | Java     tasks |
      | name Card | Python tasks   |
    And I modify the name of card "Selenium tasks" to "New Selenium 3.0"
    Then I should see "New Selenium 3.0" in the list of cards