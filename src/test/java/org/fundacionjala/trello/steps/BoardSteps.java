package org.fundacionjala.trello.steps;


import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.pages.BoardPage;
import org.fundacionjala.trello.pages.DashboardPage;
import org.fundacionjala.trello.pages.board.BoardCreationPage;
import org.fundacionjala.trello.pages.board.BoardFields;
import org.testng.Assert;

import java.util.Map;

public class BoardSteps {
    private DashboardPage dashboardPage;
    private BoardPage boardPage;
    private BoardCreationPage boardCreationPage;

    public BoardSteps(final CommonSteps commonSteps) {
        this.dashboardPage = commonSteps.getDashboardPage();

    }
    @When("I create new board from {string} with a:")
    public void iCreateABoardWithA(final String wayToCreateBoard, final Map<BoardFields, String> dataTable) {
        boardCreationPage = dashboardPage.clickAddBoard(wayToCreateBoard);
        boardPage = boardCreationPage.createNewBoard(dataTable);
    }

    @Then("^I should see the board$")
    public void iShouldSeeTheBoard() {
        Assert.assertEquals(boardCreationPage.getTitleString(), "Fernando");
    }
}
