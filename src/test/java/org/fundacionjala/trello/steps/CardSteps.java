package org.fundacionjala.trello.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.pages.common.LoginPage;
import org.fundacionjala.trello.pages.card.BoardPage;
import org.fundacionjala.trello.pages.board.DashboardPage;
import org.testng.Assert;
import java.util.Map;

public class CardSteps {

    private DashboardPage dashboardPage;
    private BoardPage boardPage;

    public CardSteps(final CommonSteps commonSteps) {
        this.dashboardPage = commonSteps.getDashboardPage();
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

    @And("I modify the name of card {string} to {string}")
    public void iModifyTheNameOfCardTo(final String nameCard, final String newNameCard) {
        boardPage.editCreatedCard(nameCard, newNameCard);
    }

    @And("a board created with the name:")
    public void aBoardCreatedWithTheName(final Map<String, String> board) {
        boardPage = dashboardPage.createBoard(board.get("Title"));
    }

    @When("I add a list with the name:")
    public void iAddAListWithTheName(final Map<String, String> list) {
        boardPage.createList(list.get("Name"));
    }

    @And("I should see {string} in the title after selecting card")
    public void iShouldSeeInTheTitleAfterSelectingCard(final String title) {
        Assert.assertTrue(boardPage.verifySelectedCardNameInTheTitle(title));
    }

    @And("I should see {string} in list after selecting card")
    public void iShouldSeeInListAfterSelectingCard(final String listName) {
        Assert.assertTrue(boardPage.verifyListSelectedCardNameInTheTitle(listName));
    }

    @And("I select the card {string}")
    public void iSelectTheCard(final String title) {
        boardPage.selectCard(title);
    }

    @And("I shoud see {string} in the page title")
    public void iShoudSeeInThePageTitle(String nameCard) {
        Assert.assertTrue(boardPage.verifyPageTtile(nameCard));
    }

    @And("I should see {string} in the menu of activity")
    public void iShouldSeeInTheMenuOfActivity(String pageName) {
        Assert.assertTrue(boardPage.verifyCardNameInTheMenuActivity(pageName));
    }
}
