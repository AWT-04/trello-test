package org.fundacionjala.trello.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.pages.board.DashboardPage;
import org.fundacionjala.trello.pages.board.BoardCreationPage;
import org.fundacionjala.trello.pages.board.BoardFields;
import org.testng.Assert;

import java.util.Map;

public class BoardSteps {
    private DashboardPage dashboardPage;
    private BoardCreationPage boardCreationPage;

    public BoardSteps(final CommonSteps commonSteps) {
        this.dashboardPage = commonSteps.getDashboardPage();
    }

    @When("I create new board from {string} with a:")
    public void iCreateABoardWithA(final String wayToCreateBoard, final Map<BoardFields, String> dataTable) {
        boardCreationPage = dashboardPage.clickAddBoard(wayToCreateBoard);
        boardCreationPage.createNewBoard(dataTable);
    }

    @Then("^I should see the board$")
    public void iShouldSeeTheBoard() {
        Assert.assertEquals(boardCreationPage.getTitleString(), dashboardPage.getTitleStringHeader());
        Assert.assertEquals(boardCreationPage.getPrivacyString(), dashboardPage.getPermissionHeader());
        Assert.assertEquals(boardCreationPage.getBackgroundString(), dashboardPage.getBackgroundColor());
    }
}
