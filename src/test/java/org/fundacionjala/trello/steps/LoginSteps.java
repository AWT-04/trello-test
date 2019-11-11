package org.fundacionjala.trello.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.fundacionjala.trello.ui.pages.BoardPage;
import org.fundacionjala.trello.ui.pages.DashboardPage;
import org.fundacionjala.trello.ui.pages.LoginPage;
import java.util.Map;

public class LoginSteps {
    DashboardPage dashboardPage;
    BoardPage boardPage;
    private static final int IMPLICIT_TIME = 15;

    @Given("I login as user:")
    public void iLoginAsUser(final Map<String, String> user) {
        LoginPage loginPage = new LoginPage();
        dashboardPage = loginPage.login(user.get("name"), user.get("password"));
    }

    @Then("I should see {string} in the list of cards")
    public void iShouldSeeInTheListOfCards(String cardName) {
        String XPath = String.format("//*[@class='list-card-title js-card-name' and contains(text(),'%s')]", cardName);
//        (new WebDriverWait(base.driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".tc_menu_header.tc_menu_header_projects")));
//        Assert.assertEquals(webDriver.findElement(By.xpath(XPath)).getText(), cardName);
    }

    @When("I add a list with the name {string}")
    public void iAddAListWithTheName(String listName) {
        boardPage = dashboardPage.createBoard("my board");
        boardPage.createList(listName);
    }

    @And("I create the following cards:")
    public void iCreateTheFollowingCards(final DataTable cards) {
        for (int i = 0; i < cards.height(); i++) {
            boardPage.createCard(cards.cell(i, 1).toString());
        }
    }
}