package org.fundacionjala.trello.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.pages.board.BoardCreationPage;
import org.fundacionjala.trello.pages.board.BoardFields;
import org.fundacionjala.trello.pages.board.Dashboard;
import org.testng.Assert;

import java.util.Map;

public class BoardSteps {
    private Dashboard dashboard;
    private BoardCreationPage boardCreationPage;

    public BoardSteps(final Dashboard dashboardPage) {
        this.dashboard = dashboardPage;
    }

    @When("I create new board from {string} with a:")
    public void iCreateABoardWithA(final String wayToCreateBoard, final Map<BoardFields, String> dataTable) {
        boardCreationPage = dashboard.clickAddBoard(wayToCreateBoard);
        boardCreationPage.createNewBoard(dataTable);
    }

    @Then("^I should see the board$")
    public void iShouldSeeTheBoard() {
        Assert.assertEquals(boardCreationPage.getTitleString(), dashboard.getTitleStringHeader());
        Assert.assertEquals(boardCreationPage.getPrivacyString(), dashboard.getPermissionHeader());
        Assert.assertEquals(boardCreationPage.getBackgroundString(), dashboard.getBackgroundColor());
    }
}
