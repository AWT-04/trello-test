Feature: Card feature

  Scenario: Create cards in boards
    Given I login as user:
      | name     | osalamar@gmail.com |
      | password | r4514812L*         |
    When I add a list with the name "To do"
    And I create the following cards:
      | name Card | Selenium tasks |
      | name Card | Java     tasks |
      | name Card | Python tasks   |
    Then I should see "Selenium tasks" in the list of cards