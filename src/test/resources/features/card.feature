Feature: Card feature
  As a owner, I want add, delete and update a card, so that I can verify the UI board

  Scenario: Create cards in boards
    Given I login as user:
      | name     | osalamar@gmail.com |
      | password | r4514812L*         |
    And a board created with the name "My board"
    When I add a list with the name "To do"
    And I create the following cards:
      | name Card | Selenium tasks |
      | name Card | Java     tasks |
      | name Card | Python tasks   |
    Then I should see "Selenium tasks" in the list of cards


  Scenario: Delete a card in boards
    Given I login as user:
      | name     | osalamar@gmail.com |
      | password | r4514812L*         |
    And a board created with the name "My board"
    And I add a list with the name "To do"
    And I create the following cards:
      | name Card | Selenium tasks |
      | name Card | Java     tasks |
      | name Card | Python tasks   |
    When I delete "Selenium tasks" card
    Then I should NOT see "Selenium tasks" in the list of cards

