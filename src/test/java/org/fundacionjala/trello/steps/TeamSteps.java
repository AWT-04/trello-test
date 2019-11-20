package org.fundacionjala.trello.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.pages.board.Dashboard;
import org.fundacionjala.trello.pages.team.TeamCreationPage;
import org.fundacionjala.trello.pages.team.TeamFields;
import org.fundacionjala.trello.pages.team.TeamPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Map;

public class TeamSteps {
    private Dashboard dashboard;
    private WebDriver webDriver;
    private TeamCreationPage teamCreationPage;
    private TeamPage teamPage;

    public TeamSteps(final Dashboard dashboardPage) {
        this.dashboard = dashboardPage;
    }

    @When("I create a new {string} with :")
    public void iCreateANewTeamFromHeaderWith(final String wayToCreateTeam,
                                              final Map<TeamFields, String> dataTable) {
        teamCreationPage = dashboard.teamClickAddHeader(wayToCreateTeam);
        teamCreationPage.createNewTeam(dataTable);
    }

    @Then("Team {string} is listed in the team page with {string} as description")
    public void teamIsListedInTheLeftSidebar(final String teamName, final String teamDesc) {
        teamPage = dashboard.getTeamPage();
        Assert.assertEquals(teamPage.getNameTeam(), teamName);
        Assert.assertEquals(teamPage.getDescriptionTeam(), teamDesc);
        Assert.assertTrue(teamPage.teamNameTitle().contains(teamName));
    }

    @And("Team {string} is listed in sidebar on dashboard page")
    public void teamIsListedInBoardsPage(final String teamName) {
        Assert.assertNotNull(dashboard.getTeamNameSidebar(teamName));
    }

    @And("Team {string} is listed in content on dashboard page")
    public void teamIsListedInContentOnDashboardPage(final String teamName) {
        Assert.assertNotNull(dashboard.getTeamNameDashboard(teamName));
    }

    @And("Team {string} is listed on url and page title")
    public void teamIsListedOnUrlAndPageTitle(final String teamName) {
        teamPage = dashboard.getTeamPage();
        Assert.assertTrue(teamPage.teamNameTitle().contains(teamName));
        Assert.assertTrue(teamPage.teamNameUrl().contains(teamName.toLowerCase()));
        teamPage.dashboardHeaderButton();
    }

    @And("Team {string} listed on search button on header")
    public void teamListedOnSearchButtonOnHeader(final String teamName) {
        dashboard.searchTeamButtonHeader(teamName);
    }
}
