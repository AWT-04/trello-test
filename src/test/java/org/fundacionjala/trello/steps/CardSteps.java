package org.fundacionjala.trello.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.pages.board.Dashboard;
import org.fundacionjala.trello.pages.card.BoardPage;
import org.testng.Assert;

import java.util.Map;

public class CardSteps {

    private Dashboard dashboardPage;
    private BoardPage boardPage;

    public CardSteps(final BoardPage boardPage) {
        this.boardPage = boardPage;
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

    @And("I modify the name of card {string} to {string}")
    public void iModifyTheNameOfCardTo(final String nameCard, final String newNameCard) {
        boardPage.editCreatedCard(nameCard, newNameCard);
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
    public void iShoudSeeInThePageTitle(final String nameCard) {
        Assert.assertTrue(boardPage.verifyPageTtile(nameCard));
    }

    @And("I should see {string} in the menu of activity")
    public void iShouldSeeInTheMenuOfActivity(final String pageName) {
        Assert.assertTrue(boardPage.verifyCardNameInTheMenuActivity(pageName));
    }

    @And("I should NOT see {string} in the menu of activity")
    public void iShouldNOTSeeInTheMenuOfActivity(final String pageName) {
        Assert.assertFalse(boardPage.verifyCardNameInTheMenuActivity(pageName));
    }

    @Then("I should see the list {string} in the board")
    public void iShouldSeeTheListInTheBoard(final String nameList) {
        Assert.assertEquals(boardPage.getTitleList(nameList), nameList);
    }

    @And("I archive the list:")
    public void iArchiveTheList(final Map<String, String> data) {
        boardPage.openMenuList(data.get("Name"));
    }

    @Then("I don't should see the list:")
    public void iDonTShouldSeeTheList(final Map<String, String> table) {
        Assert.assertTrue(boardPage.listOfCards(table.get("Name")).isEmpty());
    }
}
