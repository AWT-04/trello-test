Feature: Team feature
  As a owner, I want add, delete and update a team, so that I can verify the UI board

  Background:
    Given I log in with the user "owner"

  @cleanTeams
  Scenario: Create new team from sidebar
    When I create a new "Team from sidebar" with :
      | name        | Test2              |
      | description | description test 2 |
    Then Team "Test2" is listed in the team page with "description test 2" as description
    And Team "Test2" is listed on url and page title
#    And Team "Test2" is listed in sidebar on dashboard page
#    And Team "Test2" is listed in content on dashboard page
#    And Team "Test2" listed on search button on header

  @cleanTeams
  Scenario: Create new team from header
    When I create a new "Team from header" with :
      | name        | Test1              |
      | description | description test 1 |
    Then Team "Test1" is listed in the team page with "description test 1" as description
    And Team "Test1" is listed on url and page title
#    And Team "Test1" is listed in sidebar on dashboard page
#    And Team "Test1" is listed in content on dashboard page
#    And Team "Test1" listed on search button on header


