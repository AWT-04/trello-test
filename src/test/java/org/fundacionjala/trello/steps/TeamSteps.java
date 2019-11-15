package org.fundacionjala.trello.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.pages.team.TeamCreationPage;
import org.fundacionjala.trello.pages.team.TeamFields;
import org.fundacionjala.trello.pages.board.DashboardPage;
import org.fundacionjala.trello.pages.team.TeamPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

    public class TeamSteps {
        private DashboardPage dashboardPage;
        private WebDriver webDriver;
        private TeamCreationPage teamCreationPage;
        private TeamPage teamPage;

        public TeamSteps(final CommonSteps commonSteps) {
            this.dashboardPage = commonSteps.getDashboardPage();
        }

        @When("I create a new {string} with :")
        public void iCreateANewTeamFromHeaderWith(final String wayToCreateTeam,
                                                  final Map<TeamFields, String> dataTable) {
            teamCreationPage = dashboardPage.teamClickAddHeader(wayToCreateTeam);
            teamCreationPage.createNewTeam(dataTable);
        }

        @Then("Team {string} is listed in the team page with {string} as description")
        public void teamIsListedInTheLeftSidebar(final String teamName, final String teamDesc) {
            teamPage = dashboardPage.getTeamPage();
            Assert.assertEquals(teamPage.getNameTeam(), teamName);
            Assert.assertEquals(teamPage.getDescriptionTeam(), teamDesc);
            teamPage.dashboardHeaderButton();
        }

        @And("Team {string} is listed in sidebar on dashboard page")
        public void teamIsListedInBoardsPage(final String teamNameEx) {
            teamPage = dashboardPage.getTeamPage();
        }
    }
