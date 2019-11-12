package org.fundacionjala.trello.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.pages.common.LoginPage;
import org.fundacionjala.trello.ui.pages.BoardPage;
import org.fundacionjala.trello.ui.pages.DashboardPage;
import org.testng.Assert;
import java.util.Map;

public class TrelloSteps {
    private DashboardPage dashboardPage;
    private BoardPage boardPage;

    @Given("I login as user:")
    public void iLoginAsUser(final Map<String, String> user) {
        LoginPage loginPage = new LoginPage();
        dashboardPage = loginPage.login(user.get("name"), user.get("password"));
    }

    @Then("I should see {string} in the list of cards")
    public void iShouldSeeInTheListOfCards(final String cardName) {
        Assert.assertEquals(boardPage.extractTextToTheCard(cardName), cardName);
    }

    @When("I add a list with the name {string}")
    public void iAddAListWithTheName(final String listName) {
        boardPage.createList(listName);
    }

    @And("I create the following cards:")
    public void iCreateTheFollowingCards(final DataTable cards) {
        for (int i = 0; i < cards.height(); i++) {
            boardPage.createCard(cards.cell(i, 1));
        }
    }

    @And("a board created with the name {string}")
    public void aBoardCreatedWithTheName(final String boardName) {
        boardPage = dashboardPage.createBoard(boardName);
    }

    @When("I delete {string} card")
    public void iDeleteCard(final String cardName) {
        boardPage.deleteCard(cardName);
    }

    @Then("I should NOT see {string} in the list of cards")
    public void iShouldNOTSeeInTheListOfCards(final String cardName) {
        Assert.assertTrue(boardPage.listOfCards(cardName).isEmpty());
    }

    @Given("I log in as {string}")
    public void iLogInAs(final String account) {
        LoginPage loginPage = new LoginPage();
        dashboardPage = loginPage.loginWithAccount(account);
    }
}
